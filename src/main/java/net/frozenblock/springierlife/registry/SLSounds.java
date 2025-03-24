/*
 * Copyright 2023-2025 FrozenBlock
 * This file is part of Springier Life.
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

package net.frozenblock.springierlife.registry;

import net.frozenblock.springierlife.SLConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

public final class SLSounds {

	//AMBIENT BLOCK
	public static final SoundEvent AMBIENT_OVERWORLD_CREAK = register("ambient.overworld.creak");
	public static final SoundEvent AMBIENT_OVERWORLD_WIND_LEAVES = register("ambient.overworld.wind_leaves");
	public static final SoundEvent AMBIENT_OVERWORLD_WIND_LEAVES_FAST = register("ambient.overworld.wind_leaves_fast");
	public static final SoundEvent AMBIENT_OVERWORLD_WIND_FALLING_LEAVES = register("ambient.overworld.wind_falling_leaves");
	public static final SoundEvent AMBIENT_OVERWORLD_WIND_FALLING_LEAVES_FAST = register("ambient.overworld.wind_falling_leaves_fast");
	public static final SoundEvent AMBIENT_OVERWORLD_WIND_CATTAIL = register("ambient.overworld.wind_cattail");
	public static final SoundEvent AMBIENT_OVERWORLD_GRASSHOPPER = register("ambient.overworld.grasshopper");

	private SLSounds() {
		throw new UnsupportedOperationException("SLSounds contains only static declarations.");
	}

	@NotNull
	private static Holder.Reference<SoundEvent> registerForHolder(@NotNull String string) {
		return registerForHolder(SLConstants.id(string));
	}

	@NotNull
	private static Holder.Reference<SoundEvent> registerForHolder(@NotNull ResourceLocation resourceLocation) {
		return registerForHolder(resourceLocation, resourceLocation);
	}

	@NotNull
	public static SoundEvent register(@NotNull String path) {
		var id = SLConstants.id(path);
		return Registry.register(BuiltInRegistries.SOUND_EVENT, id, new SoundEvent(id, 16F, false));
	}

	@NotNull
	private static Holder.Reference<SoundEvent> registerForHolder(@NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2) {
		return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, resourceLocation, SoundEvent.createVariableRangeEvent(resourceLocation2));
	}

	public static void init() {
		SLConstants.logWithModId("Registering SoundEvents for", SLConstants.UNSTABLE_LOGGING);
	}

}
