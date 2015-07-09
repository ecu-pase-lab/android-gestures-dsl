package com.example.awang94.gesturedsl;

import android.view.MotionEvent;

/**
 * Created by mhills on 7/9/15.
 */
public class Example {
    public void example() {
        State s1 = new State();
        State s2 = new State();

        s1.addTransition(new LongPressTransition().startsWith(s1).endsAt(s2));

        s1.goesTo(s2).onDown();

        s1.addTransition(new Transition() {
            public boolean transitionOnLongPress (MotionEvent event) {
                return true;
            }
        }.startsWith(s1).endsAt(s2));
    }
}
