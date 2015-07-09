package com.example.awang94.gesturedsl;

import android.view.MotionEvent;

/**
 * Created by mhills on 7/9/15.
 */
public class LongPressTransition extends Transition {
    @Override
    public boolean transitionOnLongPress(MotionEvent event) {
        return true;
    }
}
