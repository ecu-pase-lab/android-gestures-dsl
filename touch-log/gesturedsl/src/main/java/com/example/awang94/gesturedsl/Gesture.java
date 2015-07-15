package com.example.awang94.gesturedsl;

import com.example.awang94.gesturedsl.Transitions.*;

import java.util.ArrayList;

/**
 * Created by awang94 on 7/10/2015.
 */

public class Gesture extends State {
    Gesture rootState;
    public Gesture beginsWith()  {
        rootState = this;
        return this;
    }
    public Gesture then()  {
        return this;
    }
    public Gesture touchDown()  {
        Gesture nextState = new Gesture();
        this.addTransition(new DownTransition(this, nextState));
        nextState.setParentState(this);
        return nextState;
    }
    public Gesture touchUp()  {
        Gesture nextState = new Gesture();
        this.addTransition(new UpTransition(this, nextState));
        nextState.setParentState(this);
        return nextState;
    }
    public Gesture end()  {
        this.setAcceptingState(true);
        return rootState;
    }
    public Gesture scroll()  {
        Gesture nextState = new Gesture();
        this.addTransition(new ScrollTransition(this, nextState));
        nextState.setParentState(this);
        return nextState;
    }
    public Gesture inDirection(Direction direction)  {
        ArrayList<Transition> transitions = this.getTransitions();
        for (Transition t: transitions)  {
            t.setDirection(direction);
        }
        return this;
    }

}
