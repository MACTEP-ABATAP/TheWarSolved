package com.ivs.tws.Map.Model.Map;

import com.artemis.Entity;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.ivs.tws.Map.Model.Map.Iso.help.MyMath;

public class Map {

    public final Terrain[][] map;

    private final Entity[][] entityByCoord;

    private final MapPosition[][] posByCoord;


    public final int width, height;


    public final Texture texture;



    public Map(Terrain[][] map) {
        this.map = map;
        width = map.length;
        height = map[0].length;

        entityByCoord = new Entity[width][height];

        posByCoord = new MapPosition[width][height];

        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                MapPosition pos = posByCoord[x][y] = new MapPosition(x, y);

                pixmap.setColor(map[x][y].getColor());
                pixmap.drawPixel(x, y);
            }
        }

        texture = new Texture(pixmap);
        pixmap.dispose();
    }

    public Entity getEntityAt(int x, int y) {
        if (isOnMap(x, y))
            return entityByCoord[x][y];
        else
            return null;
    }

    public Entity getEntityAt(MapPosition pos) {
        return getEntityAt(pos.x, pos.y);
    }

    public boolean hasEntity(MapPosition pos) {
        return getEntityAt(pos) != null;
    }

    public Terrain getTerrainAt(MapPosition pos) {
        return getTerrainAt(pos.x, pos.y);
    }

    public Terrain getTerrainAt(int x, int y) {
        if (isOnMap(x, y))
            return map[x][y];
        else
            throw new IllegalStateException("(" + x + ", " + y + ") is outside map boundaries.");
    }



    public boolean isOnMap(MapPosition p) {
        return isOnMap(p.x, p.y);
    }

    public boolean isOnMap(int x, int y) {
        return x >= 0 && x < posByCoord.length && y >= 0 && y < posByCoord[0].length;
    }

    public MapPosition getPositionAt(int x, int y) {
        if (isOnMap(x, y))
            return posByCoord[x][y];
        else
            throw new IllegalStateException("(" + x + ", " + y + ") is outside map boundaries.");
    }

    public void setEntity(Entity e, int x, int y) {
        entityByCoord[x][y] = e;
    }

    public void setEntity(Entity e, MapPosition p) {
        setEntity(e, p.x, p.y);
    }

    public void moveEntity(Entity e, MapPosition from, MapPosition to) {
        entityByCoord[from.x][from.y] = null;
        entityByCoord[to.x][to.y] = e;
    }

    public Array<MapPosition> getNeighbors(int x, int y, int n) {
        Array<MapPosition> coordinates = new Array<MapPosition>();
        int min;
        int myrow;
        for (int row = y - n; row < y + n + 1; row++) {
            min = MyMath.min(2 * (row - y + n), n, -2 * (row - y - n) + 1);
            for (int col = x - min; col < x + min + 1; col++) {
                if ((col < 0) || (col >= width))
                    continue;
                if (x == col && y == row)
                    continue;
                else if (x % 2 == 0)
                    myrow = 2 * y - row;
                else
                    myrow = row;
                if ((myrow < 0) || (myrow >= height))
                    continue;
                coordinates.add(new MapPosition(col, myrow));
            }
        }
        return coordinates;
    }

    public Array<MapPosition> getNeighbors(MapPosition pos) {
        return getNeighbors(pos.x, pos.y, 1);
    }

}
