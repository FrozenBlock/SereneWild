/*
 * Copyright 2025 FrozenBlock
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

package net.frozenblock.serenewild.datagen.tag;

import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.frozenblock.wilderwild.registry.WWBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

public final class SereneWildItemTagProvider extends FabricTagProvider.ItemTagProvider {

	public SereneWildItemTagProvider(@NotNull FabricDataOutput output, @NotNull CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries);
	}

	@Override
	protected void addTags(@NotNull HolderLookup.Provider arg) {
		this.getOrCreateTagBuilder(getTag("sereneseasons:year_round_crops"))
			.add(WWBlocks.BROWN_SHELF_FUNGI.asItem())
			.add(WWBlocks.RED_SHELF_FUNGI.asItem())
			.add(WWBlocks.TUMBLEWEED_PLANT.asItem());

		this.getOrCreateTagBuilder(getTag("sereneseasons:year_round_crops"))
			.add(WWBlocks.BROWN_SHELF_FUNGI.asItem())
			.add(WWBlocks.RED_SHELF_FUNGI.asItem())
			.add(WWBlocks.TUMBLEWEED_PLANT.asItem());

		this.getOrCreateTagBuilder(getTag("sereneseasons:spring_crops"))
			.add(WWBlocks.BUSH.asItem())
			.add(WWBlocks.WILLOW_SAPLING.asItem())
			.add(WWBlocks.CYPRESS_SAPLING.asItem())
			.add(WWBlocks.BROWN_SHELF_FUNGI.asItem())
			.add(WWBlocks.RED_SHELF_FUNGI.asItem())
			.add(WWBlocks.TUMBLEWEED_PLANT.asItem());

		this.getOrCreateTagBuilder(getTag("sereneseasons:summer_crops"))
			.add(WWBlocks.BUSH.asItem())
			.add(WWBlocks.WILLOW_SAPLING.asItem())
			.add(WWBlocks.CYPRESS_SAPLING.asItem())
			.add(WWBlocks.BAOBAB_NUT.asItem())
			.add(WWBlocks.COCONUT.asItem())
			.add(WWBlocks.BROWN_SHELF_FUNGI.asItem())
			.add(WWBlocks.RED_SHELF_FUNGI.asItem())
			.add(WWBlocks.TUMBLEWEED_PLANT.asItem());

		this.getOrCreateTagBuilder(getTag("sereneseasons:autumn_crops"))
			.add(WWBlocks.MAPLE_SAPLING.asItem())
			.add(WWBlocks.BROWN_SHELF_FUNGI.asItem())
			.add(WWBlocks.RED_SHELF_FUNGI.asItem())
			.add(WWBlocks.TUMBLEWEED_PLANT.asItem());

		this.getOrCreateTagBuilder(getTag("sereneseasons:winter_crops"))
			.add(WWBlocks.BROWN_SHELF_FUNGI.asItem())
			.add(WWBlocks.RED_SHELF_FUNGI.asItem())
			.add(WWBlocks.TUMBLEWEED_PLANT.asItem());

		this.getOrCreateTagBuilder(getTag("sereneseasons:unbreakable_infertile_crops"))
			.add(WWBlocks.MILKWEED.asItem())
			.add(WWBlocks.DATURA.asItem())
			.add(WWBlocks.SEEDING_DANDELION.asItem())
			.add(WWBlocks.WILLOW_SAPLING.asItem())
			.add(WWBlocks.CYPRESS_SAPLING.asItem())
			.add(WWBlocks.BAOBAB_NUT.asItem())
			.add(WWBlocks.COCONUT.asItem())
			.add(WWBlocks.MAPLE_SAPLING.asItem())
			.add(WWBlocks.CLOVERS.asItem())
			.add(WWBlocks.BROWN_SHELF_FUNGI.asItem())
			.add(WWBlocks.RED_SHELF_FUNGI.asItem())
			.add(WWBlocks.TUMBLEWEED.asItem())
			.add(WWBlocks.TUMBLEWEED_PLANT.asItem());
	}

	@NotNull
	private TagKey<Item> getTag(String id) {
		return TagKey.create(this.registryKey, ResourceLocation.parse(id));
	}

}
