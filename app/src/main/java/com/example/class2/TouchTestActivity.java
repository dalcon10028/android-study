package com.example.class2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Scanner;

public class TouchTestActivity extends AppCompatActivity {

    class MyTouchView extends View{
        public Integer nWidth;
        public Integer nHeight;
        boolean rectIn = true;
        String msg="";
        int Xpos, Ypos;

        public MyTouchView(Context context){
            super(context);
            setBackgroundColor(Color.GREEN);
        }

        @Override
        protected void onDraw(android.graphics.Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.BLUE);
            paint.setTextSize(100);


            Rect rect = new Rect(nWidth/2-200, nHeight/2-250, nWidth/2+200, nHeight/2+250);
            canvas.drawRect(rect, paint);

            paint.setColor(Color.RED);
            canvas.drawText(msg, 50, 100, paint);
            canvas.drawText(rectIn ? "x: "+Xpos+", y: "+Ypos : "터치 x: "+Xpos+", y: "+Ypos, Xpos, Ypos, paint);

        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            Xpos = (int) event.getX();
            Ypos = (int) event.getY();
            if( !((Xpos>=(nWidth/2-200) && Xpos<=(nWidth/2+200)) && (Ypos>=(nHeight/2-250) && Ypos<=(nHeight/2+250)))) rectIn = true;
            else rectIn = false;

            if(event.getAction() == MotionEvent.ACTION_DOWN)
                msg = "Action_down";
            if(event.getAction() == MotionEvent.ACTION_MOVE)
                msg = "Action_move";
            if(event.getAction() == MotionEvent.ACTION_UP)
                msg = "Action_up";

            invalidate();
            return true;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyTouchView MyTouchTest = new MyTouchView(this);
        setContentView(MyTouchTest);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        MyTouchTest.nWidth = displayMetrics.widthPixels;
        MyTouchTest.nHeight = displayMetrics.heightPixels;

    }

}