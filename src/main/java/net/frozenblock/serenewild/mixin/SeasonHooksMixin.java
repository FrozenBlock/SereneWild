package net.frozenblock.serenewild.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.frozenblock.wilderwild.block.impl.SnowloggingUtils;
import net.frozenblock.wilderwild.config.WWBlockConfig;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import sereneseasons.season.SeasonHooks;

@Pseudo
@Mixin(SeasonHooks.class)
public class SeasonHooksMixin {

	@WrapOperation(
		method = "shouldSnowHook",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/level/block/state/BlockState;isAir()Z",
			ordinal = 0
		)
	)
	private static boolean sereneWild$fixSnowlogging(
		BlockState blockState, Operation<Boolean> original
	) {
		return original.call(blockState) || (SnowloggingUtils.canSnowlog(blockState) && WWBlockConfig.canSnowlogNaturally());
	}

}
