package com.example.class2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DrawCtrlActivity extends AppCompatActivity {

    class Canvas extends View{
        public Canvas(Context context){
            super(context);
            setBackgroundColor(Color.BLUE);
        }

        @Override
        protected void onDraw(android.graphics.Canvas canvas) {
            super.onDraw(canvas);

            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.GREEN);
            paint.setStrokeWidth(5);
            paint.setTextSize(100);
            canvas.drawText("Text Test", 20, 500, paint);
            canvas.drawLine(100, 100, 300, 500, paint);

            paint.setColor(Color.RED);
            paint.setStrokeWidth(0);
            paint.setStyle(Paint.Style.FILL);
            Rect rect1 = new Rect(10, 50, 10+100, 50+100);
            canvas.drawRect(rect1, paint);

            paint.setStrokeWidth(5);
            Path path1 = new Path();
            path1.moveTo(10, 290);
            path1.lineTo(10+50, 290+50);
            path1.lineTo(10+100, 290);
            path1.lineTo(10+150, 290+50);
            path1.lineTo(10+200, 290);
            canvas.drawPath(path1, paint);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Canvas canvas = new Canvas(this);
        setContentView(canvas);
    }
}