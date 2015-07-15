package com.example.awang94.gesturedsl.Transitions;

import android.view.MotionEvent;

import com.example.awang94.gesturedsl.State;
import com.example.awang94.gesturedsl.Transitions.Transition;

/**
 * Created by awang94 on 7/10/2015.
 */
public class DownTransition extends Transition {
    public DownTransition(State s1, State s2)  {
        super(s1, s2);
    }
    @Override
    public boolean transitionOnDown(MotionEvent event)  { return true; }
}
