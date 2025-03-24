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
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public final class SereneWildBlockTagProvider extends FabricTagProvider.BlockTagProvider {

	public SereneWildBlockTagProvider(@NotNull FabricDataOutput output, @NotNull CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries);
	}

	@Override
	protected void addTags(@NotNull HolderLookup.Provider arg) {
		this.getOrCreateTagBuilder(getTag("sereneseasons:year_round_crops"))
			.add(WWBlocks.BROWN_SHELF_FUNGI)
			.add(WWBlocks.RED_SHELF_FUNGI)
			.add(WWBlocks.TUMBLEWEED_PLANT);

		this.getOrCreateTagBuilder(getTag("sereneseasons:spring_crops"))
			.add(WWBlocks.RED_HIBISCUS)
			.add(WWBlocks.YELLOW_HIBISCUS)
			.add(WWBlocks.WHITE_HIBISCUS)
			.add(WWBlocks.PINK_HIBISCUS)
			.add(WWBlocks.PURPLE_HIBISCUS)
			.add(WWBlocks.BUSH)
			.add(WWBlocks.MILKWEED)
			.add(WWBlocks.DATURA)
			.add(WWBlocks.WILDFLOWERS)
			.add(WWBlocks.PHLOX)
			.add(WWBlocks.LANTANAS)
			.add(WWBlocks.CLOVERS)
			.add(WWBlocks.WILLOW_SAPLING)
			.add(WWBlocks.CYPRESS_SAPLING)
			.add(WWBlocks.BAOBAB_NUT)
			.add(WWBlocks.COCONUT)
			.add(WWBlocks.BROWN_SHELF_FUNGI)
			.add(WWBlocks.RED_SHELF_FUNGI)
			.add(WWBlocks.TUMBLEWEED_PLANT);

		this.getOrCreateTagBuilder(getTag("sereneseasons:summer_crops"))
			.add(WWBlocks.RED_HIBISCUS)
			.add(WWBlocks.YELLOW_HIBISCUS)
			.add(WWBlocks.WHITE_HIBISCUS)
			.add(WWBlocks.PINK_HIBISCUS)
			.add(WWBlocks.PURPLE_HIBISCUS)
			.add(WWBlocks.BUSH)
			.add(WWBlocks.MILKWEED)
			.add(WWBlocks.DATURA)
			.add(WWBlocks.WILDFLOWERS)
			.add(WWBlocks.PHLOX)
			.add(WWBlocks.LANTANAS)
			.add(WWBlocks.CLOVERS)
			.add(WWBlocks.WILLOW_SAPLING)
			.add(WWBlocks.CYPRESS_SAPLING)
			.add(WWBlocks.BAOBAB_NUT)
			.add(WWBlocks.COCONUT)
			.add(WWBlocks.BROWN_SHELF_FUNGI)
			.add(WWBlocks.RED_SHELF_FUNGI)
			.add(WWBlocks.TUMBLEWEED_PLANT);

		this.getOrCreateTagBuilder(getTag("sereneseasons:autumn_crops"))
			.add(WWBlocks.SEEDING_DANDELION)
			.add(WWBlocks.MAPLE_SAPLING)
			.add(WWBlocks.MARIGOLD)
			.add(WWBlocks.PASQUEFLOWER)
			.add(WWBlocks.PHLOX)
			.add(WWBlocks.LANTANAS)
			.add(WWBlocks.BROWN_SHELF_FUNGI)
			.add(WWBlocks.RED_SHELF_FUNGI)
			.add(WWBlocks.TUMBLEWEED_PLANT);

		this.getOrCreateTagBuilder(getTag("sereneseasons:winter_crops"))
			.add(WWBlocks.SEEDING_DANDELION)
			.add(WWBlocks.PASQUEFLOWER)
			.add(WWBlocks.MARIGOLD)
			.add(WWBlocks.PHLOX)
			.add(WWBlocks.BROWN_SHELF_FUNGI)
			.add(WWBlocks.RED_SHELF_FUNGI)
			.add(WWBlocks.TUMBLEWEED_PLANT);

		this.getOrCreateTagBuilder(getTag("sereneseasons:unbreakable_infertile_crops"))
			.add(WWBlocks.MILKWEED)
			.add(WWBlocks.DATURA)
			.add(WWBlocks.SEEDING_DANDELION)
			.add(WWBlocks.WILLOW_SAPLING)
			.add(WWBlocks.CYPRESS_SAPLING)
			.add(WWBlocks.BAOBAB_NUT)
			.add(WWBlocks.COCONUT)
			.add(WWBlocks.MAPLE_SAPLING)
			.add(WWBlocks.CLOVERS)
			.add(WWBlocks.BROWN_SHELF_FUNGI)
			.add(WWBlocks.RED_SHELF_FUNGI)
			.add(WWBlocks.TUMBLEWEED)
			.add(WWBlocks.TUMBLEWEED_PLANT);

		this.getOrCreateTagBuilder(getTag("sereneseasons:greenhouse_glass"))
			.add(WWBlocks.ECHO_GLASS);
	}

	@NotNull
	private TagKey<Block> getTag(String id) {
		return TagKey.create(this.registryKey, ResourceLocation.parse(id));
	}

}
