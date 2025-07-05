package com.dot.khorn.Client;

import net.minecraft.sounds.SoundEvent;

public class Quote {
    private final SoundEvent sound;
    private final Subtitles subtitles;

    public Quote(SoundEvent sound, Subtitles subtitles) {
        this.sound = sound;
        this.subtitles = subtitles;
    }

    public SoundEvent getSound() {
        return sound;
    }

    public Subtitles getSubtitles() {
        return subtitles;
    }
}