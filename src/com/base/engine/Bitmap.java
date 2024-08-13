package com.base.engine;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Bitmap {
    private int width;
    private int height;
    private int[] pixels;

    public Bitmap(String filename) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("./res/levels/" + filename));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        if (image != null) {
            width = image.getWidth();
            height = image.getHeight();

            pixels = new int[width * height];
            image.getRGB(0, 0, width, height, pixels, 0, width);
        }
    }

    public Bitmap(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[] getPixels() {
        return pixels;
    }

    public int getPixel(int x, int y) {
        return pixels[x + y * width];
    }

    public void setPixel(int x, int y, int value) {
        pixels[x + y * width] = value;
    }
}
