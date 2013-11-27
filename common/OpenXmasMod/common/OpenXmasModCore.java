package OpenXmasMod.common;

import java.util.logging.Logger;

<<<<<<< HEAD:common/OpenXmasMod/common/OpenXmasModCore.java
import net.minecraft.creativetab.CreativeTabs;
=======
import OpenXmasMod.common.util.XmasLog;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
>>>>>>> ceb2ea63dae8b841752914c0fd756387950cd425:src/OpenXmasMod/common/OpenXmasModCore.java
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
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

	public static Item allIWantForXmasMusicDisk;
	public static Item jingleBells;
	
	public static CreativeTabs musicTab = new ChristmasMusicTab(CreativeTabs.getNextID(), "openXmasMusic");

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
<<<<<<< HEAD:common/OpenXmasMod/common/OpenXmasModCore.java

		MinecraftForge.EVENT_BUS.register(new SoundEvent());
		Logger log = Logger.getLogger("OpenXmasMod");
		log.setParent(FMLLog.getLogger());

=======
		XmasLog.info("Starting OpenXmasMod verison " + OpenXmasModCore.VERSION);
>>>>>>> ceb2ea63dae8b841752914c0fd756387950cd425:src/OpenXmasMod/common/OpenXmasModCore.java
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		allIWantForXmasMusicDisk = new ItemXmasRecord(800, "openxmas:AllIWant", "Mariah Carey", "All I Want For Christmas Is You")
		.setUnlocalizedName("openxmas.allIWantDisk");
		LanguageRegistry.addName(allIWantForXmasMusicDisk, "OpenXMas Disk");

		jingleBells = new ItemXmasRecord(801, "openxmas:JingleBells", "Basshunter", "Jingle Bells")
		.setUnlocalizedName("openxmas.jingleBellsDisk");
		LanguageRegistry.addName(jingleBells, "OpenXMas Disk");
		
		LanguageRegistry.instance().addStringLocalization("itemGroup.openXmasMusic", "Open Xmas Music");
	}


	@ForgeSubscribe
	@EventHandler
	public void onServerStarting(FMLServerStartingEvent event , EntityPlayer player) {
		
		
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
	
		
	}
}
