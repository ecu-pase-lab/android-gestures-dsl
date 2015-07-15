package com.example.awang94.gesturedsl.Transitions;

import android.view.MotionEvent;

import com.example.awang94.gesturedsl.State;

/**
 * Created by awang94 on 7/13/2015.
 */
public class SingleTapTransition extends Transition {
    public SingleTapTransition(State s1, State s2)  {
        super(s1, s2);
    }
    @Override
    public boolean transitionOnSingleTapUp(MotionEvent event) {
        return true;
    }
}
