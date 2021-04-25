package com.ivs.tws.screens.ScreenUtil;



import com.badlogic.gdx.Screen;

import java.awt.Point;

public class ScreenPoint extends Point {

    public int ScreenX = x;
    public int ScreenY = y;

    @Override
    public Point getLocation() {
        return super.getLocation();
    }

    @Override
    public double getX() {
        return super.getX();
    }

    @Override
    public double getY() {
        return super.getY();
    }


    public ScreenPoint(int x, int y) {
        x = x;
        y = y;
    }

    public void set(int currentX, int currentY){
        x = currentX;
        y = currentY;
    }

    public static ScreenPoint isoToOrtho (ScreenPoint point) {

        ScreenPoint newPoint = new ScreenPoint(0, 0);
        newPoint.x=(2*point.y+point.x)/2;
        newPoint.y=(2*point.y-point.x)/2;
        return(newPoint);
    }

    public static ScreenPoint OrthoToIso (ScreenPoint point) {

        ScreenPoint newPoint = new ScreenPoint(0, 0);
        newPoint.x=point.x-point.y;
        newPoint.y=(point.x+point.y)/2;
        return(newPoint);
    }


    public static ScreenPoint getTileCoordinates(ScreenPoint point, int tileHeight) {
        ScreenPoint newPoint = new ScreenPoint(0, 0);
        newPoint.x=(int)Math.floor(point.x/tileHeight);
        newPoint.y=(int)Math.floor(point.y/tileHeight);
        return newPoint;
    }


    public static ScreenPoint getOrthoFromTileCoordinates(ScreenPoint point, int tileHeight) {
        ScreenPoint newPoint = new ScreenPoint(0, 0);
        newPoint.x=point.x*tileHeight;
        newPoint.y=point.y*tileHeight;
        return(newPoint);
    }
}
