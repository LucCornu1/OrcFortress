package com.ccicraft.gamedev;

import javafx.scene.image.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.IntBuffer;

public class SpriteManager {
    // Constructor
    public SpriteManager() {
        // pass
    }

    // Variables
    private static final int BASE_SPRITE_SIZE = 13;
    public static final int SCALE_IMAGE = 4;
    public static int SPRITE_SIZE_PX = BASE_SPRITE_SIZE * SCALE_IMAGE;
    private static final int IMAGE_WIDTH = 261;
    private static final int IMAGE_HEIGHT = 131;
    private static final int scaledWidthSize = IMAGE_WIDTH * SCALE_IMAGE;
    private static final int scaleHeightSize = IMAGE_HEIGHT * SCALE_IMAGE;
    private static final String IMAGE_PATH = "src/resources/colored.png";
    private static final Image IMAGE_RESOURCE;
    static {
        try {
            IMAGE_RESOURCE = new Image(new FileInputStream(IMAGE_PATH),
                    scaledWidthSize,
                    scaleHeightSize,
                    false,
                    false
            );
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Methods
    // #Static method that crops part out of the image and returns it
    public static Image cropSprite(int col, int row) {
        PixelReader pr = IMAGE_RESOURCE.getPixelReader();
        WritablePixelFormat<IntBuffer> pixelFormat = WritablePixelFormat.getIntArgbInstance();
        int[] pixels = new int[SPRITE_SIZE_PX * SPRITE_SIZE_PX];
        pr.getPixels(col * SPRITE_SIZE_PX,
                row * SPRITE_SIZE_PX,
                SPRITE_SIZE_PX,
                SPRITE_SIZE_PX,
                pixelFormat,
                pixels,
                0,
                SPRITE_SIZE_PX
        );
        WritableImage outImage = new WritableImage(SPRITE_SIZE_PX, SPRITE_SIZE_PX);
        PixelWriter pw = outImage.getPixelWriter();
        pw.setPixels(0, 0, SPRITE_SIZE_PX, SPRITE_SIZE_PX, pixelFormat, pixels, 0, SPRITE_SIZE_PX);

        return outImage;
    }
}
