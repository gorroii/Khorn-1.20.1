package com.dot.khorn.Client;

import com.dot.khorn.Sounds.ModSounds;

public class ModQuotes {
    public static final Quote RANKATAN_QUOTE = new Quote(
            ModSounds.RAKATAN_SOUND_TEST.get(),
            new Subtitles(4.5)
                    .add(0.0, "Oh..")
                    .add(1.0, "A new soul trying to use me")
    );
}