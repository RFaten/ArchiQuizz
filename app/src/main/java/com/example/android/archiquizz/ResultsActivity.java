package com.example.android.archiquizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ActionBar;
import android.view.MenuItem;

import com.example.android.archiquizz.R;

import static com.example.android.archiquizz.R.id.score;

public class ResultsActivity extends AppCompatActivity {

    String nameText;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // Create BackButton on the ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Get the value entered in edit text from MainActivity
        nameText = getIntent().getStringExtra("name_value");
        //Get the value of calculated score from MainActivity
        score = getIntent().getExtras().getInt("score_value");

        // Get the welcome message string
        String welcomeMessage = getString(R.string.finish_quiz_welcome_message, nameText);
        // Find the view to display welcome message on
        TextView welcomeMessageTextView = (TextView) findViewById(R.id.welcome_message);
        // Set the welcome message text on that view
        welcomeMessageTextView.setText(welcomeMessage);

        // Find the view to display score on
        TextView scoreTextView = (TextView) findViewById(R.id.score);
        // Set the score value on that view
        scoreTextView.setText(String.valueOf(score));

        // Find the view to display score message on
        TextView scoreMessageTextView = (TextView) findViewById(R.id.score_message);
        // Define the score message based on score value
        if (score >= 8) {
            scoreMessageTextView.setText(R.string.score_message_1);
        } else if (score < 5) {
            scoreMessageTextView.setText(R.string.score_message_3);
        } else {
            scoreMessageTextView.setText(R.string.score_message_2);
        }

    }


    // Make the BackButton goes to MainActivity and resets the quiz
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home){
            this.finish();
        }
        super.onBackPressed();
        Intent intent = new Intent(ResultsActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        return super.onOptionsItemSelected(item);
    }

    // Override onBackPressed method to reset the quiz when the user go back to MainActivity
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ResultsActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    // The share button method
    public void shareScore(View view) {
        // Make the user choose an app to share their score
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        // Define the subject to share
        String subject = getString(R.string.subject);
        // Define the message to share
        String shareBody = getString(R.string.share_body, nameText, score);
        // Send the message and subject to the selected app
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        // Display the share message and subject on the selected app
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}
