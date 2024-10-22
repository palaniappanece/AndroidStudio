package com.palaniappan.thillainathan.a36surfaceviewimageviewcanvas;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    ImageView imageView;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        surfaceView= findViewById(R.id.surfaceView2);
        surfaceHolder=surfaceView.getHolder();
        imageView = findViewById(R.id.imageView);
        btn1 = findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap= Bitmap.createBitmap(surfaceView.getWidth(),surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
                Paint paint = new Paint();
                paint.setColor(Color.RED);
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(5);
                Canvas canvas = new Canvas(bitmap);

                canvas.drawCircle(bitmap.getWidth()/2,bitmap.getHeight()/2,bitmap.getWidth()/5,paint);
                imageView.setImageBitmap(bitmap);
                canvas=surfaceHolder.lockCanvas();
                canvas.drawCircle(bitmap.getWidth()/2,bitmap.getHeight()/2,bitmap.getWidth()/5,paint);
                surfaceHolder.unlockCanvasAndPost(canvas);

            }
   });

}
}