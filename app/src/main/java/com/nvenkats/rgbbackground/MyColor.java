package com.nvenkats.rgbbackground;

import android.graphics.Color;

/**
 * Created by nvenk on 12-Jun-17.
 */

public class MyColor {
    private int red;
    private int green;
    private int blue;

    public void setColor(int r, int g, int b) {
        red = r;
        green = g;
        blue = b;
    }
    public void setColor(int rgb) {
        red = (rgb >> 16) & 0xff;
        green = (rgb >> 8) & 0xff;
        blue = rgb & 0xff;
    }
    public int getColor() {

        int c = red;
        c = (c << 8) | (byte)green;
        c = (c << 8) | (byte)blue;
        return c;
    }
    public int getr() {
        return red;
    }
    public int getg() {
        return green;
    }
    public int getb() {
        return blue;
    }
}
