package apptsolutionz.minecad.core;

public class Utilities {
    public static String getShortName(String longname) {
        return (longname.replaceAll(" ", "")).toLowerCase();
    }
}
