package com.dot.khorn.Client;

import java.util.Map;
import java.util.TreeMap;

public class Subtitles {
    private final double duration;
    private final TreeMap<Double, String> lines = new TreeMap<>();

    public Subtitles(double duration) {
        this.duration = duration;
    }

    public Subtitles add(double time, String line) {
        this.lines.put(time, line);
        return this;
    }

    public String getLine(double currentTime) {
        Map.Entry<Double, String> last = lines.floorEntry(currentTime);
        return last != null ? last.getValue() : "";
    }

    public double getDuration() {
        return this.duration;
    }
}
