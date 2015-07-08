package com.example.awang94.touch_log;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by awang94 on 6/29/2015.
 */
public class GestureMap extends ArrayList<Point> {
    int numVertices;
    ArrayList<Point> vertexList = new ArrayList<Point>();
    ArrayList<Double> angleList = new ArrayList<Double>();
    public static double angle(Point p1, Point p2) {
        double x1, x2, y1, y2;
        double slope, angle;
        x1 = (double) p1.x;
        x2 = (double) p2.x;
        y1 = (double) p1.y;
        y2 = (double) p2.y;
        if (p2.x - p1.x == 0) { //in case the slope is undefined.
            if (p2.y > p1.y)

                return 270;
            else
                return 90;
        }
        slope = (y1 - y2) / (x2 - x1);
        Log.d("Slope", Double.toString(slope));
        angle = (180 / Math.PI) * (Math.atan(slope));
        if (angle > 0 && (p2.x - p1.x) < 0)
            angle += 180;
        if (angle < 0 && (p2.x - p1.x > 0)) {
            angle = angle + 360;
        }
        if (angle < 0 && (p2.x - p1.x < 0))  {
            angle = angle + 180;
        }
        return angle;
    }
    public void populateAngles()  {
        for (int i = 0; i < this.size() - 1; i++)  {
            angleList.add(angle(this.get(i), this.get(i + 1)));
        }
    }
    public int getNumVertices()  {
        return numVertices;
    }
}