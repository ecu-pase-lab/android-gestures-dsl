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
    private ArrayList<State> currentStates = new ArrayList<State>();
    private ArrayList<State> rootStates = new ArrayList<State>();
    private static final String DEBUG_TAG = "Gestures";
    protected GestureDetectorCompat mDetector;
    public void init()  {
        currentStates = new ArrayList<State>();
        rootStates = new ArrayList<State>();
    }
    public void addGesture(Gesture gest)  {
        rootStates.add(gest);
        currentStates.add(gest);
    }


    private void checkAcceptingState(State state)  { //method checks if state is an accepting state, and if so, executes accepting behaviour
        if (state.isAcceptingState())  {
            Gesture gesture = (Gesture) state;
            gesture.getRootState().executeBehavior();
            currentStates = (ArrayList<State>) rootStates.clone(); //resets state machine for detection of another gesture
        }
    }

    private void transition(Set<State> targets) {
        if (targets.size() == 1) {
            State destination = targets.iterator().next();
           // System.out.println("transitioned");
            currentStates.add(destination);
            checkAcceptingState(destination);
        } else {
            currentStates = (ArrayList<State>) rootStates.clone();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int action = MotionEventCompat.getActionMasked(event);
        this.mDetector.onTouchEvent(event);
        if (action == MotionEvent.ACTION_UP) {
            Set<State> nextStates = new HashSet<State>();
            ArrayList<State> viableStates = (ArrayList<State>) currentStates.clone();
            currentStates.clear();
            for (State currentState: viableStates) {
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
        ArrayList<State> viableStates = (ArrayList<State>) currentStates.clone();
        currentStates.clear();
        for (State currentState: viableStates) {
            for (Transition t : currentState.getTransitions()) {
                if (t.transitionOnDown(event)) {
                    nextStates.add(t.getDestination());
                }
            }
            transition(nextStates);
            nextStates.clear();
        }
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        Log.d(DEBUG_TAG, "onFling: " + event1.toString()+event2.toString());
      /*  Set<State> nextStates = new HashSet<State>();
        for (State currentState: currentStates) {
            for (Transition t : currentState.getTransitions()) {
                if (t.transitionOnFling(event1, event2, velocityX, velocityY)) {
                    nextStates.add(t.getDestination());
                }
            }
            currentStates.remove(currentState);
            transition(nextStates);
            nextStates.clear();
        }*/
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "onLongPress: " + event.toString());
        Set<State> nextStates = new HashSet<State>();
        for (State currentState: currentStates) {
            for (Transition t : currentState.getTransitions()) {
                if (t.transitionOnLongPress(event)) {
                    nextStates.add(t.getDestination());
                }
            }
            currentStates.remove(currentState);
            transition(nextStates);
            nextStates.clear();
        }
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        Log.d(DEBUG_TAG, "onScroll: " + e1.toString()+e2.toString());
        Set<State> nextStates = new HashSet<State>();
        ArrayList<State> viableStates = (ArrayList<State>) currentStates.clone();
        currentStates.clear();
        for (State currentState: viableStates) {
            for (Transition t : currentState.getTransitions()) {
                if (t.transitionOnScroll(e1, e2, distanceX, distanceY)) {
                    nextStates.add(t.getDestination());
                }
            }
            transition(nextStates);
            nextStates.clear();
        }
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
