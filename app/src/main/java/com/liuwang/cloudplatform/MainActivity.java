package com.liuwang.cloudplatform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private DrawCircle drawCircle;
    private cicle ciCle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawCircle=findViewById(R.id.draw_circle);
        ciCle=findViewById(R.id.cicle);
    }

}
