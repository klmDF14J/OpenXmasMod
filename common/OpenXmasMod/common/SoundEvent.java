package OpenXmasMod.common;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class SoundEvent
{
	@ForgeSubscribe
	public void onSoundLoad(SoundLoadEvent e)
	{
		e.manager.soundPoolStreaming.addSound("openxmas:AllIWant.ogg");
	}
}
