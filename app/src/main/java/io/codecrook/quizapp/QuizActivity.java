package io.codecrook.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    RadioGroup q1Ans, q4Ans;
    CheckBox q2Opt1, q2Opt2, q2Opt3, q2Opt4, q5Opt1, q5Opt2, q5Opt3, q5Opt4;
    EditText q3AnsEditText;
    String q3Ans;
    Button submitButton;
    int q1AnsSelectedOptID, q4AnsSelectedOptID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        q1Ans = findViewById(R.id.q1_ans);

        q4Ans = findViewById(R.id.q4_ans);

        q2Opt1 = findViewById(R.id.q2_ans_opt1);
        q2Opt2 = findViewById(R.id.q2_ans_opt2);
        q2Opt3 = findViewById(R.id.q2_ans_opt3);
        q2Opt4 = findViewById(R.id.q2_ans_opt4);

        q5Opt1 = findViewById(R.id.q5_ans_opt1);
        q5Opt2 = findViewById(R.id.q5_ans_opt2);
        q5Opt3 = findViewById(R.id.q5_ans_opt3);
        q5Opt4 = findViewById(R.id.q5_ans_opt4);

        q3AnsEditText = findViewById(R.id.q3_ans);

        submitButton = findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int playerScore = 0;
                q1AnsSelectedOptID = q1Ans.getCheckedRadioButtonId();
                q4AnsSelectedOptID = q4Ans.getCheckedRadioButtonId();
                q3Ans = q3AnsEditText.getText().toString().trim();

                if (q1AnsSelectedOptID == -1 || q4AnsSelectedOptID == -1 || q3Ans.equals("")
                        || (!q2Opt1.isChecked() && !q2Opt2.isChecked() && !q2Opt3.isChecked() && !q2Opt4.isChecked())
                        || (!q5Opt1.isChecked() && !q5Opt2.isChecked() && !q5Opt3.isChecked() && !q5Opt4.isChecked())) {

                    Toast toast = Toast.makeText(QuizActivity.this, "Attempt all questions!!", Toast.LENGTH_SHORT);
                    toast.show();
                } else {

                    if (q1AnsSelectedOptID == R.id.q1_ans_opt3) {
                        playerScore++;
                    }
                    if (q2Opt1.isChecked() && q2Opt4.isChecked() && !q2Opt2.isChecked() && !q2Opt3.isChecked()) {
                        playerScore++;
                    }

                    if (q3Ans.equalsIgnoreCase("creeper")) {
                        playerScore++;
                    }

                    if (q4AnsSelectedOptID == R.id.q4_ans_opt2) {
                        playerScore++;
                    }

                    if (q5Opt2.isChecked() && q5Opt3.isChecked() && !q5Opt1.isChecked() && !q5Opt4.isChecked()) {
                        playerScore++;
                    }


                    Intent showResult = new Intent(QuizActivity.this, ResultActivity.class);
                    showResult.putExtra("result", playerScore);
                    startActivity(showResult);
                    finish();

                }
            }
        });

    }
}
