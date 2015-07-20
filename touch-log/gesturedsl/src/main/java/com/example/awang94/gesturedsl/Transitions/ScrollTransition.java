package com.example.awang94.gesturedsl.Transitions;

import android.view.MotionEvent;

import com.example.awang94.gesturedsl.State;

/**
 * Created by awang94 on 7/13/2015.
 */
public class ScrollTransition extends Transition {
    public ScrollTransition(State s1, State s2)  {
        super(s1, s2);
    }
    @Override
    public boolean transitionOnScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                                      float distanceY) {
        if (directional)  {
           //System.out.println("dx:" + distanceX + "dy:" + distanceY);
            System.out.println(angle(distanceX, distanceY));
            switch (direction) {
                case LEFT:
                    if (withinRange((float) angle(distanceX, distanceY), 180, 30)) {
                        System.out.println("check left");
                        return true;
                    }
                    else
                        return false;
                case RIGHT:
                    if (withinRange((float) angle(distanceX, distanceY), 0, 30))
                        return true;
                    else
                        return false;
                case UP:
                    if (withinRange((float) angle(distanceX, distanceY), 90, 30))
                        return true;
                    else
                        return false;
                case DOWN:
                    if (withinRange((float) angle(distanceX, distanceY), 270, 30))
                        return true;
                    else
                        return false;
            }
        }
        return true;
    }

}
