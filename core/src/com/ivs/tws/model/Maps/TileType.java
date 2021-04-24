package com.ivs.tws.model.Maps;

public enum TileType {



    GRASS1(1, "GRASS1.png"),
    GRASS2(2, "GRASS2.png"),
    GRASS3(3, "GRASS3.png"),
    GRASS4(4, "GRASS4.png"),
    DIRT1(5, "DIRT1.png"),
    DIRT2(6, "DIRT2.png"),
    DIRT_ROAD1(7, "DIRT_ROAD1.png"),
    DIRT_ROAD2(8, "DIRT_ROAD2"),
    STONE_ROAD1(9, "STONE_ROAD1.png"),
    STONE_ROAD2(10, "STONE_ROAD2");

    private int id;
    private String fileName;


    private TileType(int id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public int id() {
        return this.id;
    }

    public String fileName() {
        return this.fileName;
    }
}
