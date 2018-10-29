package io.codecrook.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    int resultScore;
    TextView resultDisplay;
    Button replayButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultDisplay = findViewById(R.id.final_score_text_view);
        replayButton = findViewById(R.id.replay_button);
        resultScore = getIntent().getExtras().getInt("result");

        resultDisplay.setText(String.valueOf(resultScore));

        Toast resultToast = Toast.makeText(ResultActivity.this, "Score:" + resultScore, Toast.LENGTH_SHORT);
        resultToast.show();

        replayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replayQuiz = new Intent(ResultActivity.this, QuizActivity.class);
                startActivity(replayQuiz);
                finish();
            }
        });
    }
}
