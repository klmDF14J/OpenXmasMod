package OpenXmasMod.common.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

public class XmasLog {
	private static Logger log = Logger.getLogger("OpenXmasMod");

	public static void info(String msg) {
		log.log(Level.INFO, msg);
	}

	public static void warning(String msg) {
		log.log(Level.WARNING, msg);
	}

	public static void severe(String msg) {
		log.log(Level.SEVERE, msg);
	}

	public static Logger getLogger() {
		return log;
	}

	static {
		log.setParent(FMLLog.getLogger());
	}
}
