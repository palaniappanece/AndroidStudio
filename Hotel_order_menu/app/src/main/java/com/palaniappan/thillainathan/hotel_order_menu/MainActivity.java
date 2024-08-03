package com.palaniappan.thillainathan.hotel_order_menu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2;
    CheckBox P,B,F,T;
    Button btn;

    @SuppressLint("MissingInflatedId")
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
        tv1=(TextView) findViewById(R.id.T1);
        tv2=(TextView) findViewById(R.id.T2);
        P=(CheckBox) findViewById(R.id.C1);
        B=(CheckBox) findViewById(R.id.C2);
        F=(CheckBox) findViewById(R.id.C3);
        T=(CheckBox) findViewById(R.id.C4);
        btn=(Button) findViewById(R.id.B1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder s= new StringBuilder();
                int sum=0;
                s.append("selected items are :\n");
                if(P.isChecked())
                {
                    sum=sum+100;
                    s.append("PIZZA: Rs 100\n");
                }
                if (B.isChecked()){
                    sum=sum+150;
                    s.append("Burger : Rs 150\n");
                }
                if(F.isChecked()){
                    sum=sum+50;
                    s.append("FRIES : Rs 50\n");
                }
                if(T.isChecked()){
                    sum=sum+ 20;
                    s.append("TEA : Rs20\n");
                }
                s.append("TOTAL IS :"+"Rs"+sum);
                tv2.setText(s);
            }
        });
    }
}