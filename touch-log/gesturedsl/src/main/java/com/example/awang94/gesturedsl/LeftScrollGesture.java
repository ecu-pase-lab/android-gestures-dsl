package com.example.awang94.gesturedsl;

/**
 * Created by awang94 on 7/20/2015.
 */
public class LeftScrollGesture extends Gesture{
    public LeftScrollGesture() {
        this.beginsWith().touchDown().then().scroll().inDirection(Direction.LEFT).touchUp().end();
    }
}
