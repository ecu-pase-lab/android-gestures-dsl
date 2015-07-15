package com.example.awang94.gesturedsl;

import com.example.awang94.gesturedsl.Transitions.Transition;

import java.util.ArrayList;

/**
 * Created by awang94 on 7/6/2015.
 */
public class State {
    private static int idCount = 0;
    boolean acceptingState;
    State parentState;
    ArrayList<Transition> transList;
    Transition transition;
    int id;
    public State()  {
        id = ++idCount;
        transList = new ArrayList<Transition>();
        acceptingState = false;
    }
    public void addTransition(Transition trans) {
        transList.add(trans);
    }
    public ArrayList<Transition> getTransitions()  {  return transList;  }
    public boolean isAcceptingState() {
        return acceptingState;
    }
    public void setAcceptingState(boolean b)  {
        acceptingState = b;
    }
    public void setParentState(State s) {
        parentState = s;
    }
    public State getParentState()  {
        return parentState;
    }
    public State getRootState(State s)  {
        State rootState = s;
        while(rootState.getParentState() != null)  {
            rootState = rootState.getParentState();
        }
        return rootState;
    }

}
