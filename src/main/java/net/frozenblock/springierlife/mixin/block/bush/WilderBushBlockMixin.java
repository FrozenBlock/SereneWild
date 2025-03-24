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

package net.frozenblock.springierlife.mixin.block.bush;

import net.frozenblock.springierlife.block.impl.BlockAmbienceUtil;
import net.frozenblock.springierlife.registry.SLSounds;
import net.frozenblock.wilderwild.block.WilderBushBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(WilderBushBlock.class)
public abstract class WilderBushBlockMixin extends Block {

	public WilderBushBlockMixin(Properties properties) {
		super(properties);
	}

	@Override
	public void animateTick(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull RandomSource random) {
		if (random.nextFloat() <= 0.03F && BlockAmbienceUtil.isNight(level) && BlockAmbienceUtil.isBrightEnoughForWind(level, pos)) {
			level.playLocalSound(
				pos.getX() + 0.5D,
				pos.getY() + 0.5D,
				pos.getZ() + 0.5D,
				SLSounds.AMBIENT_OVERWORLD_GRASSHOPPER,
				SoundSource.AMBIENT,
				0.15F + (random.nextFloat() * 0.15F),
				0.75F + (random.nextFloat() * 0.375F),
				false
			);
		}
	}

}
