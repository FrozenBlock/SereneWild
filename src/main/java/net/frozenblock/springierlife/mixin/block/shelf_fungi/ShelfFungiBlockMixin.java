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

package net.frozenblock.springierlife.mixin.block.shelf_fungi;

import net.frozenblock.springierlife.registry.SLSounds;
import net.frozenblock.wilderwild.block.ShelfFungiBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ShelfFungiBlock.class)
public abstract class ShelfFungiBlockMixin extends FaceAttachedHorizontalDirectionalBlock {

	protected ShelfFungiBlockMixin(Properties properties) {
		super(properties);
	}

	@Override
	public void animateTick(BlockState blockState, Level level, BlockPos blockPos, @NotNull RandomSource randomSource) {
		if (randomSource.nextFloat() <= 0.004F) {
			Direction oppositeDirection = getConnectedDirection(blockState).getOpposite();
			BlockPos connectedPos = blockPos.relative(oppositeDirection);
			if (level.getBlockState(connectedPos).is(BlockTags.OVERWORLD_NATURAL_LOGS)) {
				level.playLocalSound(
					connectedPos.getX() + 0.5D,
					connectedPos.getY() + 0.5D,
					connectedPos.getZ() + 0.5D,
					SLSounds.AMBIENT_OVERWORLD_CREAK,
					SoundSource.AMBIENT,
					0.1F + (randomSource.nextFloat() * 0.2F),
					0.85F + (randomSource.nextFloat() * 0.25F),
					false
				);
			}
		}
	}

}
