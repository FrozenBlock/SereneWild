package net.frozenblock.serenewild.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.frozenblock.wilderwild.block.impl.SnowloggingUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import sereneseasons.season.RandomUpdateHandler;

@Pseudo
@Mixin(RandomUpdateHandler.class)
public class RandomUpdateHandlerMixin {

	@WrapOperation(
		method = "meltInChunk",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/level/block/state/BlockState;getBlock()Lnet/minecraft/world/level/block/Block;",
			ordinal = 0
		)
	)
	private static Block sereneWild$fixSnowloggedMelting(
		BlockState blockState, Operation<Block> original,
		@Local ServerLevel serverLevel,
		@Local(ordinal = 0) BlockPos topAirPos
	) {
		if (SnowloggingUtils.isSnowlogged(blockState)) {
			serverLevel.setBlockAndUpdate(topAirPos, SnowloggingUtils.getStateWithoutSnow(blockState));
		}
		return original.call(blockState);
	}

}
