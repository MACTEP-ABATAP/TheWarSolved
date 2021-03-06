package com.ivs.tws.systems;

public class TrigLut {


    public static final float sin(float rad) {
        return sin[(int) (rad * radToIndex) & SIN_MASK];
    }

    public static final float cos(float rad) {
        return cos[(int) (rad * radToIndex) & SIN_MASK];
    }

    public static final float sinDeg(float deg) {
        return sin[(int) (deg * degToIndex) & SIN_MASK];
    }

    public static final float cosDeg(float deg) {
        return cos[(int) (deg * degToIndex) & SIN_MASK];
    }

    private static final float RAD, DEG;
    private static final int SIN_BITS, SIN_MASK, SIN_COUNT;
    private static final float radFull, radToIndex;
    private static final float degFull, degToIndex;
    private static final float[] sin, cos;

    static {
        RAD = (float) Math.PI / 180.0f;
        DEG = 180.0f / (float) Math.PI;

        SIN_BITS = 12;
        SIN_MASK = ~(-1 << SIN_BITS);
        SIN_COUNT = SIN_MASK + 1;

        radFull = (float) (Math.PI * 2.0);
        degFull = (float) (360.0);
        radToIndex = SIN_COUNT / radFull;
        degToIndex = SIN_COUNT / degFull;

        sin = new float[SIN_COUNT];
        cos = new float[SIN_COUNT];

        for (int i = 0; i < SIN_COUNT; i++) {
            sin[i] = (float) Math.sin((i + 0.5f) / SIN_COUNT * radFull);
            cos[i] = (float) Math.cos((i + 0.5f) / SIN_COUNT * radFull);
        }
    }
}