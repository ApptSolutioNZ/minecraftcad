package apptsolutionz.minecad.client.audio;

import java.util.logging.Level;

import apptsolutionz.minecad.core.LogHelper;
import apptsolutionz.minecad.lib.Sounds;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class SoundHandler {

    @ForgeSubscribe
    public void onSoundLoad(SoundLoadEvent event) {

        // For each custom sound file we have defined in Sounds
        for (String soundFile : Sounds.soundFiles) {
            // Try to add the custom sound file to the pool of sounds
            try {
                event.manager.soundPoolSounds.addSound(soundFile, this
                        .getClass().getResource("/" + soundFile));
            }
            // If we cannot add the custom sound file to the pool, log the
            // exception
            catch (Exception e) {
                LogHelper.log(Level.WARNING, "Failed loading sound file: "
                        + soundFile);
            }
        }
    }
}
