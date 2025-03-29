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
import net.frozenblock.wilderwild.block.impl.SnowyBlockUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = ServerLevel.class, priority = 1050)
public class ServerLevelMixin {

	@WrapOperation(
		method = "tickPrecipitation",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/server/level/ServerLevel;setBlockAndUpdate(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)Z",
			ordinal = 2
		)
	)
	private boolean sereneWild$tickPrecipitation(
		ServerLevel instance, BlockPos pos, BlockState blockState, Operation<Boolean> original
	) {
		boolean setBlock = original.call(instance, pos, blockState);
		BlockState newState = instance.getBlockState(pos);
		if (SnowloggingUtils.isSnowlogged(newState)) {
			SnowyBlockUtils.replaceWithWorldgenSnowyEquivalent(instance, newState, pos);
		}
		return setBlock;
	}

}
