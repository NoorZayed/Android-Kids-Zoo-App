package com.example.ass1;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class animals extends AppCompatActivity {

    private RadioGroup nameRadioGroup;
    private RadioGroup nameRadioGroup1;
    private Button submitButton;
    private String correctName = "Dog";
    private String correctName1 = "Turtle";
    private TextView messageTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animals);

        // Initialize views
        nameRadioGroup = findViewById(R.id.nameRadioGroup);
        nameRadioGroup1 = findViewById(R.id.radioGroup);
        submitButton = findViewById(R.id.check);
        messageTextView = findViewById(R.id.finaltxt);
        // Add radio buttons dynamically for animal names
        String[] animalNames = {"Cat", "Fish", "Dog", "Giraffe"};
        for (String name : animalNames) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(name);
            nameRadioGroup.addView(radioButton);
        }

        String[] animalNames1 = {"Bird", "Fish", "Dog", "Turtle"};
        for (String name : animalNames1) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(name);
            nameRadioGroup1.addView(radioButton);
        }

        // Set onClickListener for the submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void checkAnswer() {
        int selectedId = nameRadioGroup.getCheckedRadioButtonId();
        int selectedId1 = nameRadioGroup1.getCheckedRadioButtonId();

        if (selectedId != -1 && selectedId1 != -1) {
            RadioButton selectedRadioButton = findViewById(selectedId);
            RadioButton selectedRadioButton1 = findViewById(selectedId1);
            String selectedName = selectedRadioButton.getText().toString();
            String selectedName1 = selectedRadioButton1.getText().toString();

            if (selectedName.equals(correctName) && selectedName1.equals(correctName1)) {
                // Correct answer
                Toast.makeText(this, "Both answers are correct!", Toast.LENGTH_SHORT).show();
                messageTextView.setText("Bravo!");
                messageTextView.setTextColor(Color.GREEN);
            } else {
                // Incorrect answer
                Toast.makeText(this, "One or both answers are incorrect. Try again!", Toast.LENGTH_SHORT).show();
                messageTextView.setText("Try Again!");
                messageTextView.setTextColor(Color.RED);
            }
        } else {
            // No option selected
            Toast.makeText(this, "Please select options for both questions", Toast.LENGTH_SHORT).show();
        }
    }
}
