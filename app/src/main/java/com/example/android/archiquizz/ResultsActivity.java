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
        //ActionBar ab = getActionBar();
        //ab.setDisplayHomeAsUpEnabled(true);

        nameText = getIntent().getStringExtra("name_value");
        score = getIntent().getExtras().getInt("score_value");

        String welcomeMessage = getString(R.string.finish_quiz_welcome_message, nameText);
        TextView welcomeMessageTextView = (TextView) findViewById(R.id.welcome_message);
        welcomeMessageTextView.setText(welcomeMessage);

        TextView scoreTextView = (TextView) findViewById(R.id.score);
        scoreTextView.setText(String.valueOf(score));

        TextView scoreMessageTextView = (TextView) findViewById(R.id.score_message);
        if (score >= 8) {
            scoreMessageTextView.setText(R.string.score_message_1);
        } else if (score < 5) {
            scoreMessageTextView.setText(R.string.score_message_3);
        } else {
            scoreMessageTextView.setText(R.string.score_message_2);
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ResultsActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void shareScore(View view) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String subject = getString(R.string.subject);
        String shareBody = getString(R.string.share_body, nameText, score);
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}
