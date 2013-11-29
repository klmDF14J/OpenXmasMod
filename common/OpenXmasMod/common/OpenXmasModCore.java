package OpenXmasMod.common;

import java.util.logging.Logger;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import OpenXmasMod.common.block.BlockPresent;
import OpenXmasMod.common.config.Config;
import OpenXmasMod.common.item.ItemXmasRecord;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "OpenXmasMod ", name = "OpenXmasMod", version = OpenXmasModCore .VERSION + OpenXmasModCore .STATE)
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = "OpenXmasMod", packetHandler = PacketHandler.class)

public class OpenXmasModCore {
	public static final String VERSION = "1.6.4_V0.0.1_";
	public static final String STATE = "DEV";
	
	@Instance("OpenXmasMod")
	public static OpenXmasModCore instance;

	@SidedProxy(clientSide = "OpenXmasMod.common.CommonProxy", serverSide = "OpenXmasMod.client.ClientProxy")
	public static CommonProxy CommonProxy;
	public static OpenXmasMod.client.ClientProxy ClientProxy;

	//public static Item allIWantForXmasMusicDisk, jingleBells;
	
	public static Block present;
	
	public static CreativeTabs musicTab;
	public static CreativeTabs blocksTab;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {


		MinecraftForge.EVENT_BUS.register(new SoundEvent());
		Logger log = Logger.getLogger("OpenXmasMod");
		log.setParent(FMLLog.getLogger());
		
		for(BiomeGenBase biome : BiomeGenBase.biomeList) {
			if(biome != null) {
				biome.setDisableRain().setEnableSnow().setTemperatureRainfall(-1.0F, -0.5F);
			}
		}
		
		Config.init(event.getSuggestedConfigurationFile());
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		/*allIWantForXmasMusicDisk = new ItemXmasRecord(Config.allIWant, "openxmas:AllIWant", "Mariah Carey", "All I Want For Christmas Is You").setUnlocalizedName("openxmas.allIWantDisk");
		LanguageRegistry.addName(allIWantForXmasMusicDisk, "OpenXMas Disk");

		jingleBells = new ItemXmasRecord(Config.jingleBells, "openxmas:JingleBells", "Basshunter", "Jingle Bells").setUnlocalizedName("openxmas.jingleBellsDisk");
		LanguageRegistry.addName(jingleBells, "OpenXMas Disk");*/
		
		musicTab = new ChristmasMusicTab(CreativeTabs.getNextID(), "openXmasMusic", Item.snowball.itemID);
		blocksTab = new ChristmasMusicTab(CreativeTabs.getNextID(), "openXmasBlocks", Config.present);
		
		present = new BlockPresent(Config.present);
		GameRegistry.registerBlock(present, ItemBlockPresent.class, "present");
		
		for(int i = 0; i < BlockPresent.types.length; i++) {
			LanguageRegistry.addName(new ItemStack(present, 1, i), BlockPresent.types[i] + " Christmas Present");
		}
		
		LanguageRegistry.instance().addStringLocalization("itemGroup.openXmasMusic", "Open Xmas Music");
		LanguageRegistry.instance().addStringLocalization("itemGroup.openXmasBlocks", "Open Xmas Blocks");
	}


	@ForgeSubscribe
	@EventHandler
	public void onServerStarting(FMLServerStartingEvent event , EntityPlayer player) {
		
		
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
	
		
	}
}
