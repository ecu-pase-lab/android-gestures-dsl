package com.example.awang94.gesturedsl;

import android.view.MotionEvent;

import java.util.ArrayList;

/**
 * Created by awang94 on 7/6/2015.
 */
public class State {
    private static int idcount = 0;
    ArrayList<Transition> transList = new ArrayList<Transition>();
    int id;
    public State()  {
        id = ++idcount;
    }
    public void addTransition(Transition trans) {
        transList.add(trans);
    }
    public void pushState(MotionEvent event)  {

    }
    public State pushState(int action)  {
        for (int i = 0; i < transList.size(); i++)  {
            Transition trans = transList.get(i);
            if (action == trans.getSymbol()) return trans.getDestination();
        }
        return null;
    }


}
