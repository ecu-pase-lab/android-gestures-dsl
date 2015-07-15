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
    boolean directional = false, positional = false, timed = false;
    Direction direction;
    public Transition(State s1, State s2)  {
        this.s1 = s1;
        this.s2 = s2;
    }
    public Transition()  {}


    public Transition startsWith(State s1) {
        this.s1 = s1;
        return this;
    }

    public Transition endsAt(State s2) {
        this.s2 = s2;
        return this;
    }

    public State getDestination()  {
        return s2;
    }
    public State getStart()  {
        return s1;
    }

    public void setDirection(Direction d)  {
        direction = d;
        directional = true;
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
