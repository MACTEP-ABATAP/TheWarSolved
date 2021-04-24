package com.ivs.tws.Maps;

public class Map extends AbstractMap {
    private int TileType;

    public int [][] mapData = {{1, 1, 1, 1, 1, 1, 1, 2, 1},
                                {2, 0, 0, 2, 0, 0, 1, 0, 1},
                                {1, 0, 2, 2, 2, 0, 1, 10,1},
                                {1, 0, 0, 7, 7, 0, 1, 0, 1},
                                {1, 1, 9, 7, 7, 7, 1, 0, 1},
                                {1, 1,11, 0, 1, 1, 1, 0, 1},
                                {1, 8, 5, 3, 1, 6, 6, 0, 1},
                                {1, 1, 4, 2, 1, 6, 6, 0, 1},
                                {1, 1, 1, 2, 1, 1, 1, 0, 1}
    };
}
