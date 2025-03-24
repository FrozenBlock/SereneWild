package net.frozenblock.serenewild.mixin.immersivesnow;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalBooleanRef;
import net.frozenblock.wilderwild.block.impl.SnowloggingUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import straywave.minecraft.immersivesnow.Logic;

@Pseudo
@Mixin(Logic.class)
public class LogicMixin {

	@WrapOperation(
		method = "checkAndUpdateBlock",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z",
			ordinal = 0
		)
	)
	private static boolean sereneWild$fixSnowloggingA(BlockState blockState, Block block, Operation<Boolean> original) {
		return original.call(blockState, block) || SnowloggingUtils.isSnowlogged(blockState);
	}

	@WrapOperation(
		method = "checkAndUpdateBlock",
		at = @At(
			value = "INVOKE",
			target = "Lstraywave/minecraft/immersivesnow/Utils;setBlock(Lnet/minecraft/world/level/LevelWriter;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V",
			ordinal = 0
		)
	)
	private static void sereneWild$fixSnowloggingB(
		LevelWriter level, BlockPos pos, BlockState state, Operation<Void> original,
		@Local(ordinal = 0) BlockState topState
	) {
		if (SnowloggingUtils.canSnowlog(topState)) {
			original.call(level, pos, SnowloggingUtils.getSnowloggedState(topState, state));
		}
	}

	@WrapOperation(
		method = "checkAndUpdateBlock",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z",
			ordinal = 3
		)
	)
	private static boolean sereneWild$fixMeltingA(
		BlockState blockState, Block block, Operation<Boolean> original,
		@Share("sereneWild$isSnowlogged") LocalBooleanRef isSnowlogged
	) {
		if (SnowloggingUtils.isSnowlogged(blockState)) {
			isSnowlogged.set(true);
			return true;
		}
		isSnowlogged.set(false);
		return original.call(blockState, block);
	}

	@WrapOperation(
		method = "checkAndUpdateBlock",
		at = @At(
			value = "INVOKE",
			target = "Lstraywave/minecraft/immersivesnow/Utils;setBlock(Lnet/minecraft/world/level/LevelWriter;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V",
			ordinal = 3
		)
	)
	private static void sereneWild$fixMeltingB(
		LevelWriter level, BlockPos pos, BlockState state, Operation<Void> original,
		@Local(ordinal = 0) BlockState topState,
		@Share("sereneWild$isSnowlogged") LocalBooleanRef isSnowlogged
	) {
		if (isSnowlogged.get()) {
			original.call(level, pos, SnowloggingUtils.getStateWithoutSnow(topState));
			return;
		}
		original.call(level, pos, state);
	}

}
