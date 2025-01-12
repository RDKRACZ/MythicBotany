package mythicbotany.data;

import io.github.noeppi_noeppi.libx.annotation.data.Datagen;
import io.github.noeppi_noeppi.libx.data.provider.BlockLootProviderBase;
import io.github.noeppi_noeppi.libx.mod.ModX;
import mythicbotany.ModBlocks;
import mythicbotany.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;

@Datagen
public class BlockLootProvider extends BlockLootProviderBase {

	public BlockLootProvider(ModX mod, DataGenerator generator) {
		super(mod, generator);
	}

	@Override
	protected void setup() {
        this.drops(ModBlocks.elementiumOre, true, this.stack(ModItems.rawElementium).with(this.fortuneOres()));
        this.drops(ModBlocks.goldOre, true, this.stack(Items.RAW_GOLD).with(this.fortuneOres()));
        this.drops(ModBlocks.dragonstoneOre, true, this.stack(vazkii.botania.common.item.ModItems.dragonstone).with(this.fortuneOres()));
		this.drops(ModBlocks.dreamwoodLeaves, this.first(
                this.item().with(this.or(this.silkCondition(), this.matchTool(Tags.Items.SHEARS))),
                this.combine(
                        this.stack(vazkii.botania.common.item.ModItems.dreamwoodTwig).with(this.randomFortune(0.06f)).with(this.count(1, 2)),
                        this.stack(ModItems.dreamCherry).with(this.randomFortune(0.015f))
				)
		));
	}
}
