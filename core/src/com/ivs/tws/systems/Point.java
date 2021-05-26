package com.ivs.tws.systems;

import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;

public class Point {

  public double x1;
  public double y1;
  public double x2;
  public double y2;
  public double vector;

  public static double distance(double x1, double y1, double x2, double y2){
    double d = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 * y1));
    return d;
  }

  public static double Deg2Rad(double x1, double y1, double x2, double y2){

    return
  }


  public Point ( int x , int y )
  {

    alpha = ( ( Math.atan (y/x) ) * 180 ) / Math.PI;
  }

  public static double vector1(){

  }
}
