package com.example.awang94.touch_log;

import android.app.Activity;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;
import com.example.awang94.gesturedsl.*;


public class MainActivity extends DSL {
    private TextView mTextView;
    private TextView gTextView;
    private GestureDetectorCompat mDetector;
    private GestureMap coordArr;
    private boolean drawing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addGesture(new PressGesture());
        mTextView = (TextView) findViewById(R.id.touch_view);
        mTextView.setMovementMethod(new ScrollingMovementMethod());
        gTextView = (TextView) findViewById(R.id.gest_view);
        gTextView.setMovementMethod(new ScrollingMovementMethod());
        mDetector = new GestureDetectorCompat(this, this);
        mDetector.setOnDoubleTapListener(this);
        coordArr = new GestureMap();
        drawing = false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        int action = MotionEventCompat.getActionMasked(event);
        this.mDetector.onTouchEvent(event);
        if (action == MotionEvent.ACTION_UP && drawing)  {
            drawing = false;
            Point p1 = coordArr.get(0);
            Point p2 = coordArr.get(coordArr.size() - 1);
            double angle = coordArr.angle(p1, p2);
            gTextView.append("\n(" + p1.x + ", " + p1.y + ")" + "(" + p2.x + ", " + p2.y + ") " + angle + " degrees");
            coordArr.clear();
        }
        /*switch(action) {
            case (MotionEvent.ACTION_DOWN) :
                actString = "Action was DOWN\n";
                mTextView.append(actString);
                return true;
            case (MotionEvent.ACTION_MOVE) :
                actString = "Action was MOVE\n";
                mTextView.append(actString);
                return true;
            case (MotionEvent.ACTION_UP) :
                actString = "Action was UP\n";
                mTextView.append(actString);
                return true;
            case (MotionEvent.ACTION_CANCEL) :
                actString = "Action was CANCEL\n";
                mTextView.append(actString);
                return true;
            case (MotionEvent.ACTION_OUTSIDE) :
                actString = "Action was OUTSIDE\n";
                mTextView.append(actString);
                return true;
            default :
                return super.onTouchEvent(event);
        }*/
        return super.onTouchEvent(event);
    }
    @Override
    public boolean onDown(MotionEvent event) {
       mTextView.append("onDown\n");
       //gTextView.append("\nonDown: " + event.toString());
        coordArr.add(new Point((int)event.getX(), (int)event.getY()));
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        mTextView.append("onFling\n");
        //gTextView.append("\nonFling: " + event1.toString()+event2.toString());
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        mTextView.append("onLongPress\n");
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        mTextView.append("onScroll\n");
        coordArr.add(new Point((int) e2.getX(), (int) e2.getY()));
        gTextView.append("\n(" + e1.getX() + ", " + e1.getY() + ")" + "(" + e2.getX() + ", " + e2.getY() + ")");
        drawing = true;
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        mTextView.append("showPress\n");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        mTextView.append("onSingleTapUp\n");
        //gTextView.append("\nonSingleTapUp: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        mTextView.append("onDoubleTap\n");
        //gTextView.append("\nonDoubleTap: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        mTextView.append("onDoubleTapEvent\n");
        //gTextView.append("\nonDoubleTapEvent: " + event.toString());
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        mTextView.append("onSingleTapConfirmed\n");
        //gTextView.append("\nonSingleTapConfirmed: " + event.toString());
        return true;
    }
    public void clearText(View view)  {
        gTextView.setText(""); mTextView.setText("");
    }
}
