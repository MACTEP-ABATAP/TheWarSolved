package com.ivs.tws.systems;



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

}
