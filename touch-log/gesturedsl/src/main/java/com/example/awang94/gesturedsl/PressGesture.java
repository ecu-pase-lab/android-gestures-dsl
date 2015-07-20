package com.example.awang94.gesturedsl;

/**
 * Created by awang94 on 7/10/2015.
 */
public class PressGesture extends Gesture {
    public PressGesture()  {
        this.beginsWith().touchDown().then().touchUp().end();
/*        behavior = new Behavior()  {
            public void execute()  {
                System.out.println("accepted state");
            }
        };*/
    }
}
