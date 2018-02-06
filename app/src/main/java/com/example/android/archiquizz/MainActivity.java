package com.example.android.archiquizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.android.archiquizz.R;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    String nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkForRightAnswers(View view) {

        EditText nameEditText = (EditText) findViewById(R.id.name);
        nameText = nameEditText.getText().toString();
        RadioGroup question1 = (RadioGroup) findViewById(R.id.q1_answers);
        RadioGroup question2 = (RadioGroup) findViewById(R.id.q2_answers);
        RadioGroup question3 = (RadioGroup) findViewById(R.id.q3_answers);
        RadioGroup question4 = (RadioGroup) findViewById(R.id.q4_answers);
        RadioGroup question5 = (RadioGroup) findViewById(R.id.q5_answers);
        RadioGroup question7 = (RadioGroup) findViewById(R.id.q7_answers);
        RadioGroup question8 = (RadioGroup) findViewById(R.id.q8_answers);
        RadioGroup question9 = (RadioGroup) findViewById(R.id.q9_answers);
        RadioGroup question10 = (RadioGroup) findViewById(R.id.q10_answers);
        CheckBox question6Option1 = (CheckBox) findViewById(R.id.q6_op1);
        CheckBox question6Option2 = (CheckBox) findViewById(R.id.q6_op2);
        CheckBox question6Option3 = (CheckBox) findViewById(R.id.q6_op3);

        if (question1.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), R.string.complete_quiz_toast, Toast.LENGTH_SHORT).show();
        } else if (question2.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), R.string.complete_quiz_toast, Toast.LENGTH_SHORT).show();
        } else if (question3.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), R.string.complete_quiz_toast, Toast.LENGTH_SHORT).show();
        } else if (question4.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), R.string.complete_quiz_toast, Toast.LENGTH_SHORT).show();
        } else if (question5.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), R.string.complete_quiz_toast, Toast.LENGTH_SHORT).show();
        } else if (!question6Option1.isChecked() && !question6Option2.isChecked() && !question6Option3.isChecked()) {
            Toast.makeText(getApplicationContext(), R.string.complete_quiz_toast, Toast.LENGTH_SHORT).show();
        } else if (question7.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), R.string.complete_quiz_toast, Toast.LENGTH_SHORT).show();
        } else if (question8.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), R.string.complete_quiz_toast, Toast.LENGTH_SHORT).show();
        } else if (question9.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), R.string.complete_quiz_toast, Toast.LENGTH_SHORT).show();
        } else if (question10.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), R.string.complete_quiz_toast, Toast.LENGTH_SHORT).show();
        } else if (nameText.matches("")) {
            Toast.makeText(getApplicationContext(), R.string.enter_your_name_toast, Toast.LENGTH_SHORT).show();
        } else {
            int selectedIdQ1 = question1.getCheckedRadioButtonId();
            RadioButton selectedRadioButtonQ1 = (RadioButton) findViewById(selectedIdQ1);
            String answerForQ1 = selectedRadioButtonQ1.getText().toString();
            if (answerForQ1.equals("Pyramid")) {
                score = score + 1;
            }

            int selectedIdQ2 = question2.getCheckedRadioButtonId();
            RadioButton selectedRadioButtonQ2 = (RadioButton) findViewById(selectedIdQ2);
            String answerForQ2 = selectedRadioButtonQ2.getText().toString();
            if (answerForQ2.equals("S. Sophia Constantinople")) {
                score = score + 1;
            }

            int selectedIdQ3 = question3.getCheckedRadioButtonId();
            RadioButton selectedRadioButtonQ3 = (RadioButton) findViewById(selectedIdQ3);
            String answerForQ3 = selectedRadioButtonQ3.getText().toString();
            if (answerForQ3.equals("Ellipse")) {
                score = score + 1;
            }

            int selectedIdQ4 = question4.getCheckedRadioButtonId();
            RadioButton selectedRadioButtonQ4 = (RadioButton) findViewById(selectedIdQ4);
            String answerForQ4 = selectedRadioButtonQ4.getText().toString();
            if (answerForQ4.equals("Coffer")) {
                score = score + 1;
            }

            int selectedIdQ5 = question5.getCheckedRadioButtonId();
            RadioButton selectedRadioButtonQ5 = (RadioButton) findViewById(selectedIdQ5);
            String answerForQ5 = selectedRadioButtonQ5.getText().toString();
            if (answerForQ5.equals("Terrace")) {
                score = score + 1;
            }

            if (question6Option1.isChecked() && question6Option2.isChecked() && question6Option3.isChecked()) {
                score = score + 1;
            }

            int selectedIdQ7 = question7.getCheckedRadioButtonId();
            RadioButton selectedRadioButtonQ7 = (RadioButton) findViewById(selectedIdQ7);
            String answerForQ7 = selectedRadioButtonQ7.getText().toString();
            if (answerForQ7.equals("Art nouveau")) {
                score = score + 1;
            }

            int selectedIdQ8 = question8.getCheckedRadioButtonId();
            RadioButton selectedRadioButtonQ8 = (RadioButton) findViewById(selectedIdQ8);
            String answerForQ8 = selectedRadioButtonQ8.getText().toString();
            if (answerForQ8.equals("Marble")) {
                score = score + 1;
            }

            int selectedIdQ9 = question9.getCheckedRadioButtonId();
            RadioButton selectedRadioButtonQ9 = (RadioButton) findViewById(selectedIdQ9);
            String answerForQ9 = selectedRadioButtonQ9.getText().toString();
            if (answerForQ9.equals("Cornice")) {
                score = score + 1;
            }

            int selectedIdQ10 = question10.getCheckedRadioButtonId();
            RadioButton selectedRadioButtonQ10 = (RadioButton) findViewById(selectedIdQ10);
            String answerForQ10 = selectedRadioButtonQ10.getText().toString();
            if (answerForQ10.equals("Casa batllo")) {
                score = score + 1;
            }

            Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
            intent.putExtra("score_value", score);
            intent.putExtra("name_value", nameText);
            MainActivity.this.startActivity(intent);
        }
    }
}
