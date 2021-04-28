package com.giftech.simplecanvas;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private Canvas mCanvas;
    private Paint mPaint = new Paint();
    private Paint mPaintText = new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.my_imageview);
        mPaint.setColor(Color.YELLOW);
        mPaintText.setColor(Color.WHITE);
        mPaintText.setTextSize(27);
    }

    public void drawSomething(View view) {
        // Background
        int vWidth = view.getWidth();
        int vHeight = view.getHeight();
        mBitmap = Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.ARGB_8888);
        mImageView.setImageBitmap(mBitmap);
        mCanvas = new Canvas(mBitmap);
        mCanvas.drawColor(Color.LTGRAY);

        mPaint.setColor(ContextCompat.getColor(this, R.color.purple_700));
        Path path = new Path();
        path.moveTo(250, 100);
        path.lineTo(50, 300);
        path.lineTo(900, 300);
        path.lineTo(700, 100);
        path.close();
        mCanvas.drawPath(path, mPaint);


        mPaint.setColor(ContextCompat.getColor(this, R.color.teal_200));
        Rect mRect = new Rect();
        mRect.set(50, 300, 900, 900);
        mCanvas.drawRect(mRect, mPaint);

        mPaint.setColor(ContextCompat.getColor(this, R.color.teal_700));
        mRect.set(150, 500, 700, 900);
        mCanvas.drawRect(mRect, mPaint);

        mPaint.setColor(ContextCompat.getColor(this, R.color.teal_200));
        mRect.set(200, 550, 650, 900);
        mCanvas.drawRect(mRect, mPaint);

        mCanvas.drawText("Galih Indra Firmansyah", 400, 400, mPaintText);
        view.invalidate();
    }
}