package io.codecrook.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button startQuizButton = (Button) findViewById(R.id.start_quiz_button);

        startQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startQuiz = new Intent(WelcomeActivity.this, QuizActivity.class);

                startActivity(startQuiz);
                finish();
            }
        });
    }

}
