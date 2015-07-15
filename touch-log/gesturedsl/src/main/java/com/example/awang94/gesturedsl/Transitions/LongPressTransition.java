package com.example.awang94.gesturedsl.Transitions;

import android.view.MotionEvent;

import com.example.awang94.gesturedsl.State;
import com.example.awang94.gesturedsl.Transitions.Transition;

/**
 * Created by mhills on 7/9/15.
 */
public class LongPressTransition extends Transition {
    public LongPressTransition(State s1, State s2)  {
        super(s1, s2);
    }
    @Override
    public boolean transitionOnLongPress(MotionEvent event) {
        return true;
    }
}
