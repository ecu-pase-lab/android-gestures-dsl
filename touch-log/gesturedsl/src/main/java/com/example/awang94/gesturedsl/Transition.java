package com.example.awang94.gesturedsl;

/**
 * Created by awang94 on 7/6/2015.
 */
public class Transition {
    State s1, s2;
    int symbol;
    public Transition(State s1, State s2, int symbol)  {
        this.s1 = s1;
        this.s2 = s2;
        this.symbol = symbol;
    }
    public State getDestination()  {
        return s2;
    }
    public State getStart()  {
        return s1;
    }
    public int getSymbol()  {
        return symbol;
    }
}
