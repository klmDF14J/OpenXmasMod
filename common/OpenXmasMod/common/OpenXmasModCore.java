package OpenXmasMod.common;

import java.util.logging.Logger;

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

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		MinecraftForge.EVENT_BUS.register(new SoundEvent());
		Logger log = Logger.getLogger("OpenXmasMod");
		log.setParent(FMLLog.getLogger());

	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		allIWantForXmasMusicDisk = new ItemXmasRecord(800, "openxmas:AllIWant");
	}


	@ForgeSubscribe
	@EventHandler
	public void onServerStarting(FMLServerStartingEvent event , EntityPlayer player) {
		
		
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
	
		
	}
}
