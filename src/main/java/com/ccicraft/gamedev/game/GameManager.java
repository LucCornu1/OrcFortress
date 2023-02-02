package com.ccicraft.gamedev.game;

public class GameManager {
    public static int SCREEN_WIDTH = 1600;
    public static int SCREEN_HEIGHT = 900;
    public static final String DWARF = "Dwarf";
    public static final String ORC = "Orc";
    public static final int MAP_SIZE = 450;

    public static ScreenMap root = new ScreenMap();
    public static boolean GAME_ON = true;

    public enum GAME_SPEED {
        PAUSE,
        SLOW,
        NORMAL,
        FAST
    }

    public static GAME_SPEED CURRENT_SPEED = GAME_SPEED.NORMAL;
}
