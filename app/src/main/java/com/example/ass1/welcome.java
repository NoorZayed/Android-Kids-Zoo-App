package com.example.ass1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class welcome extends AppCompatActivity {
private TextView namet;
private Button animb;
private Button numrb;
private Button alphab;
private Button testb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        namet = findViewById(R.id.nametxt);
        animb=findViewById(R.id.animalbtn);
        numrb=findViewById(R.id.numbtn);
        alphab=findViewById(R.id.alphabtn);
        testb=findViewById(R.id.testbtn);

        Intent intent =  getIntent();
        String msg = intent.getStringExtra("Data");
        namet.setText(msg);

        animb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the next Activity (replace NextActivity with your actual class name)
                Intent intent = new Intent(welcome.this , animal.class);

                // Start the next Activity
                startActivity(intent);
            }
        });

        numrb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the next Activity (replace NextActivity with your actual class name)
                Intent intent = new Intent(welcome.this , number.class);
                // Start the next Activity
                startActivity(intent);
            }
        });

        alphab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the next Activity (replace NextActivity with your actual class name)
                Intent intent = new Intent(welcome.this , alpha.class);
                // Start the next Activity
                startActivity(intent);
            }
        });

        testb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the next Activity (replace NextActivity with your actual class name)
                Intent intent = new Intent(welcome.this , test.class);
                // Start the next Activity
                startActivity(intent);
            }
        });
    }

}
