package apptsolutionz.minecad.core;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

import apptsolutionz.minecad.lib.Reference;

public class LogHelper {

    private static Logger mcadLogger = Logger.getLogger(Reference.MOD_ID);

    public static void init() {

        mcadLogger.setParent(FMLLog.getLogger());
    }

    public static void log(Level logLevel, String message) {

        mcadLogger.log(logLevel, message);
    }

}
