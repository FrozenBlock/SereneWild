/*
 * Copyright 2025 FrozenBlock
 * This file is part of Serene Wild.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, see <https://www.gnu.org/licenses/>.
 */

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
