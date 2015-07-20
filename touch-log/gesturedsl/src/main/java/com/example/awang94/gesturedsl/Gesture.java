package com.example.awang94.gesturedsl;

import com.example.awang94.gesturedsl.Transitions.*;

import java.util.ArrayList;

/**
 * Created by awang94 on 7/10/2015.
 */

public class Gesture extends State {
    Gesture rootState;
    Behavior behavior;
    public Gesture(Gesture g)  {
        super();
        this.rootState = g.rootState;
        this.behavior = g.behavior;
    }
    public Gesture()  {
        super();
    }
    public Gesture beginsWith()  {
        rootState = this;
        return this;
    }
    public void setBehavior(Behavior b)  {
        behavior = b;
    }
    public void executeBehavior()  {
        behavior.execute();
    }
    public Gesture then()  {
        return this;
    }
    public Gesture touchDown()  {
        Gesture nextState = new Gesture(this);
        this.addTransition(new DownTransition(this, nextState));
        nextState.setParentState(this);
        return nextState;
    }
    public Gesture touchUp()  {
        Gesture nextState = new Gesture(this);
        this.addTransition(new UpTransition(this, nextState));
        nextState.setParentState(this);
        return nextState;
    }
    public Gesture end()  {
        this.setAcceptingState(true);
        return rootState;
    }
    public Gesture scroll()  {
        Gesture nextState = new Gesture(this);
        this.addTransition(new ScrollTransition(this, nextState));
        nextState.setParentState(this);
        nextState.addTransition(new ScrollTransition(nextState, nextState));
        return nextState;
    }
    public Gesture inDirection(Direction direction)  {
        ArrayList<Transition> transitions = this.getParentState().getTransitions();
        transitions.addAll(this.getTransitions());
        for (Transition t: transitions)  {
            t.setDirection(direction);
            System.out.println("set direction:" + direction.toString());
        }
        return this;
    }
    public Gesture getRootState()  {
        return rootState;
    }
}
