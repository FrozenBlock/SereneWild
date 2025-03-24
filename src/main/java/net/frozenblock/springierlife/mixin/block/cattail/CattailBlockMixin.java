/*
 * Copyright 2023-2025 FrozenBlock
 * This file is part of Springier life.
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

package net.frozenblock.springierlife.mixin.block.cattail;

import net.frozenblock.springierlife.block.impl.BlockAmbienceUtil;
import net.frozenblock.springierlife.registry.SLSounds;
import net.frozenblock.wilderwild.block.CattailBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CattailBlock.class)
public abstract class CattailBlockMixin extends Block {

	public CattailBlockMixin(Properties settings) {
		super(settings);
	}

	@Override
	public void animateTick(BlockState blockState, Level level, BlockPos blockPos, @NotNull RandomSource randomSource) {
		if (randomSource.nextFloat() < BlockAmbienceUtil.horizontalWindStrength(level, blockPos) * 0.045F) {
			if (blockState.getValue(CattailBlock.WATERLOGGED)) {
				BlockState aboveState = level.getBlockState(blockPos.above());
				if (aboveState.is(CattailBlock.class.cast(this)) && !aboveState.getValue(CattailBlock.WATERLOGGED)) {
					if (BlockAmbienceUtil.isBrightEnoughForWind(level, blockPos)) {
						level.playLocalSound(
							blockPos.getX() + 0.5D,
							blockPos.getY() + 0.5D,
							blockPos.getZ() + 0.5D,
							SLSounds.AMBIENT_OVERWORLD_WIND_CATTAIL,
							SoundSource.AMBIENT,
							0.05F,
							0.85F + (randomSource.nextFloat() * 0.25F),
							false
						);
					}
				}
			}
		}
	}

}
