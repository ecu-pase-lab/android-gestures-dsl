package com.example.awang94.gesturedsl;

import android.app.Activity;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.example.awang94.gesturedsl.Transitions.Transition;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * Created by awang94 on 7/6/2015.
 */
public class DSL extends Activity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {
    private ArrayList<State> currentStates;
    private static final String DEBUG_TAG = "Gestures";
    private GestureDetectorCompat mDetector;
    public void addGesture(Gesture gest)  {
        currentStates.add(gest);
    }

    private void transition(Set<State> targets) {
        if (targets.size() == 1) {
            currentStates.add(targets.iterator().next());
        } else {
            // PANIC!
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int action = MotionEventCompat.getActionMasked(event);
        this.mDetector.onTouchEvent(event);
        if (action == MotionEvent.ACTION_UP) {
            for (State currentState: currentStates) {
                Set<State> nextStates = new HashSet<State>();
                for (Transition t : currentState.getTransitions()) {
                    if (t.transitionOnUp(event)) {
                        nextStates.add(t.getDestination());
                    }
                }
                currentStates.remove(currentState);
                transition(nextStates);
                nextStates.clear();
            }
        }
        return super.onTouchEvent(event);
    }
    @Override
    public boolean onDown(MotionEvent event) {
        Log.d(DEBUG_TAG, "onDown: " + event.toString());
        Set<State> nextStates = new HashSet<State>();
        for (State currentState: currentStates) {
            for (Transition t : currentState.getTransitions()) {
                if (t.transitionOnDown(event)) {
                    nextStates.add(t.getDestination());
                }
            }
            currentStates.remove(currentState);
            transition(nextStates);
            nextStates.clear();
        }
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        Log.d(DEBUG_TAG, "onFling: " + event1.toString()+event2.toString());
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "onLongPress: " + event.toString());
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        Log.d(DEBUG_TAG, "onScroll: " + e1.toString()+e2.toString());
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "onShowPress: " + event.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        Log.d(DEBUG_TAG, "onSingleTapUp: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        Log.d(DEBUG_TAG, "onDoubleTap: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        Log.d(DEBUG_TAG, "onDoubleTapEvent: " + event.toString());
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        Log.d(DEBUG_TAG, "onSingleTapConfirmed: " + event.toString());
        return true;
    }
}
