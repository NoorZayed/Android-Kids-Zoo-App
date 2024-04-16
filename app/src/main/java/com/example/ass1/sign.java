package com.example.ass1;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class sign extends AppCompatActivity {
    private EditText usert;
    private  EditText passt;
    private Button passb;

    private static final String CORRECT_USERNAME1 = "noor";
    private static final String CORRECT_PASSWORD1 = "2003";
    private static final String PREF_NAME = "MyPrefs";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act2);

         usert = findViewById(R.id.user);
         passt = findViewById(R.id.pass);
        passb=findViewById(R.id.signbtn);

        // Retrieve saved credentials
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String savedUsername = sharedPreferences.getString(KEY_USERNAME, "");
        String savedPassword = sharedPreferences.getString(KEY_PASSWORD, "");

        // If credentials are saved, pre-fill the EditText fields
        if (!savedUsername.isEmpty() && !savedPassword.isEmpty()) {
            usert.setText(savedUsername);
            passt.setText(savedPassword);
        }
        passb.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String userin = usert.getText().toString();
                String pasin = passt.getText().toString();
                if(userin.equals(CORRECT_USERNAME1) && pasin.equals(CORRECT_PASSWORD1)){
                    String name =  " "+userin;

                    // Save credentials to SharedPreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_USERNAME, userin);
                    editor.putString(KEY_PASSWORD, pasin);
                    editor.apply();

                    String msg = "Welcome to your profile!"+ userin + "\nPassword: " + pasin;
                    Toast.makeText(sign.this,msg,Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(sign.this, welcome.class);
                    intent.putExtra("Data",name);
                    startActivity(intent);
                } else {
                    String msg = "wrong inputs try again";
                    Toast.makeText(sign.this,msg,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
