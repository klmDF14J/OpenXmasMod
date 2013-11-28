package OpenXmasMod.common.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class Config {
	
	public static Configuration config;
	
	public static void init(File location) {
		config = new Configuration(location);
		
		config.load();
		
		config.save();
	}
	
	
	public static int getValue(String key, int defaultID, boolean isItem) {
		if(isItem) {
			return config.getItem(key, defaultID).getInt() - 256;
		}
		else {
			return config.getBlock(key, defaultID).getInt();
		}
	}
}
