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
