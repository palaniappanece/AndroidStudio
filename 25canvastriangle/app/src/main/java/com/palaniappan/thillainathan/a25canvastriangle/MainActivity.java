package com.palaniappan.thillainathan.a25canvastriangle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
       // setContentView(R.layout.activity_main);
        setContentView(new Myview(this));

    }

    private class Myview extends View {
        public Myview(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(@NonNull Canvas canvas) {
            super.onDraw(canvas);
            Paint paint=new Paint();
            Path path=new Path();

            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.rgb(255,51,153));
            canvas.drawPaint(paint);

            Point a=new Point(350,550);
            Point b= new Point(350,900);
            Point c=new Point(550,550);

            path.setFillType(Path.FillType.EVEN_ODD);

            path.lineTo(a.x,a.y);
            path.lineTo(b.x,b.y);
            path.lineTo(c.x,c.y);
            path.lineTo(a.x,a.y);
            path.close();
            paint.setColor(Color.YELLOW);
            canvas.drawPath(path,paint);


        }
    }
}