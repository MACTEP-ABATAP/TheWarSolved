package com.ivs.tws.model.Maps.Maputil;

public class IsometricUtil {

    public static TilePoint isoTo2D (TilePoint point) {
        //gx=(2*isoy+isox)/2;
        //gy=(2*isoy-isox)/2
        TilePoint newPoint = new TilePoint(0, 0);
        newPoint.x = (2 * point.y + point.x) / 2;
        newPoint.y = (2 * point.y - point.x) / 2;
        return (newPoint);
    }

    public static TilePoint twoDToIso (TilePoint point) {
        //gx=(isox-isoxy;
        //gy=(isoy+isox)/2
        Point newPoint = new TilePoint(0, 0);
        newPoint.x=point.x-point.y;
        newPoint.y=(point.x+point.y)/2;
        return(newPoint);
    }

    public static TilePoint getTileCoordinates(TilePoint point, int tileHeight) {
        TilePoint newPoint = new TilePoint(0, 0);
        newPoint.x=(int)Math.floor(point.x/tileHeight);
        newPoint.y=(int)Math.floor(point.y/tileHeight);
        return newPoint;
    }

    public static TilePoint get2dFromTileCoordinates(TilePoint point, int tileHeight) {
        TilePoint newPoint = new TilePoint(0, 0);
        newPoint.x=point.x*tileHeight;
        newPoint.y=point.y*tileHeight;
        return(newPoint);
    }
}
