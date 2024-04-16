package com.example.ass1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class alphas extends AppCompatActivity {

    private RadioGroup nameRadioGroup;
    private RadioGroup nameRadioGroup1;
    private Button submitButton;
    private String correctName = "q";
    private String correctName1 = "a";
    private TextView messageTextView;
    private String testResult;
    private int selectedRadioId = -1;
    private int selectedRadioId1 = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alphas);

        // Initialize views
        nameRadioGroup = findViewById(R.id.nameRadioGroup);
        nameRadioGroup1 = findViewById(R.id.radioGroup);
        submitButton = findViewById(R.id.check);
        messageTextView = findViewById(R.id.finaltxt);

        // Restore selected radio button choices if available
        if (savedInstanceState != null) {
            selectedRadioId = savedInstanceState.getInt("selected_radio_id", -1);
            selectedRadioId1 = savedInstanceState.getInt("selected_radio_id1", -1);
            testResult = savedInstanceState.getString("test_result");
        }

        if (selectedRadioId != -1) {
            nameRadioGroup.check(selectedRadioId);
        }

        if (selectedRadioId1 != -1) {
            nameRadioGroup1.check(selectedRadioId1);
        }

        if (testResult != null) {
            messageTextView.setText(testResult);
        }
        // Add radio buttons dynamically for animal names
        String[] animalNames = {"e", "k", "p", "q"};
        for (String name : animalNames) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(name);
            nameRadioGroup.addView(radioButton);
        }

        String[] animalNames1 = {"a", "d", "b", "y"};
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
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save selected radio button choices and test result
        outState.putInt("selected_radio_id", nameRadioGroup.getCheckedRadioButtonId());
        outState.putInt("selected_radio_id1", nameRadioGroup1.getCheckedRadioButtonId());
        outState.putString("test_result", messageTextView.getText().toString());
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
