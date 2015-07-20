package com.example.awang94.gesturedsl.Transitions;

import android.view.MotionEvent;

import com.example.awang94.gesturedsl.Direction;
import com.example.awang94.gesturedsl.State;

/**
 * Created by awang94 on 7/6/2015.
 */
public class Transition {
    State s1 = null, s2 = null;
    int symbol;
    boolean directional = false, positional = false, timed = false; //flags for additional qualities/requirements of the gesture
    Direction direction;
    public Transition(State s1, State s2)  {
        this.s1 = s1;
        this.s2 = s2;
    }
    public Transition()  {}


    public static double angle(float dx, float dy) {
        double slope, angle;
        if (dx == 0) { //in case the slope is undefined.
            if (dy < 0)

                return 270;
            else
                return 90;
        }
        slope = -dy / dx;
        angle = (180 / Math.PI) * (Math.atan(slope));
        //System.out.println(angle);
        if (angle >= 0 && dx > 0)
            angle += 180;
        if (angle < 0 && dx < 0) {
            angle += 360;
        }
        if (angle < 0 && dx > 0)  {
            angle += 180;
        }
        return angle;
    }
    public boolean withinRange(float value, float center, float range)  { //checks if value is within range of center.
        float upper, lower;
        upper = (center + range) % 360;
        lower = (center - range) % 360;
        if (value < upper && value > lower)  {
            System.out.println(value +  " is within " + lower + " and " + upper);
            return true;
        }
        else
            return false;
    }

    public State getDestination()  {
        return s2;
    }
    public State getStart()  {
        return s1;
    }

    public void setDirection(Direction d)  { //called by DSL when gesture needs to move a specific direction
        this.direction = d;
        this.directional = true;
    }

    public boolean transitionOnTouchEvent(MotionEvent event){
        return false;
    }

    public boolean transitionOnUp(MotionEvent event)  { return false; }

    public boolean transitionOnDown(MotionEvent event) {
        return false;
    }

    public boolean transitionOnFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        return false;
    }

    public boolean transitionOnLongPress(MotionEvent event) {
        return false;
    }

    public boolean transitionOnScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        return false;
    }

    public boolean transitionOnShowPress(MotionEvent event) {
        return false;
    }

    public boolean transitionOnSingleTapUp(MotionEvent event) {
        return false;
    }

    public boolean transitionOnDoubleTap(MotionEvent event) {
        return false;
    }

    public boolean transitionOnDoubleTapEvent(MotionEvent event) {
        return false;
    }

    public boolean transitionOnSingleTapConfirmed(MotionEvent event) {
        return false;
    }
}
