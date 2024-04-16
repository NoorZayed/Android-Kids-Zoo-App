package com.example.ass1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class number2 extends AppCompatActivity {
    private Button back;
    private Button nextb;
    private Button prevbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number2);
        nextb=findViewById(R.id.nextbtn);
        nextb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the next Activity (replace NextActivity with your actual class name)
                Intent intent = new Intent(number2.this , number3.class);
                // Start the next Activity
                startActivity(intent);
            }
        });

        prevbt = findViewById(R.id.prevbtn);
        prevbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the next Activity (replace NextActivity with your actual class name)
                Intent intent = new Intent(number2.this , number1.class);
                // Start the next Activity
                startActivity(intent);
            }
        });

        back = findViewById(R.id.backbtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the next Activity (replace NextActivity with your actual class name)
                Intent intent = new Intent(number2.this , welcome.class);
                // Start the next Activity
                startActivity(intent);
            }
        });
    }
}
