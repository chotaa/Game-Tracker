package com.example.android.courtcounter;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * Global variables are created
     */
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int freeKickA = 0;
    int cornerKickA = 0;
    int foulsA = 0;
    int freeKickB = 0;
    int cornerKickB = 0;
    int foulsB = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Updates & displays minor stats
     */
    public void displayResult(int x, String y) {
        String buttonID = y;
        int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
        TextView theField = (TextView) findViewById(resID);
        if (x > 9) {
            theField.setTextSize(26);
        } else {
            theField.setTextSize(32);
        }
        theField.setText(String.valueOf(x));
    }

    /**
     * Updates & displays the score. I used two methods instead of one, because when number go above
     * 9 (two digits) I get them to lower in textSize. But since the main score had different sizes,
     * I had to clone the method
     */
    public void displayScore(int x, String y) {
        String buttonID = y;
        int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
        TextView theField = (TextView) findViewById(resID);
        if (x > 9) {
            theField.setTextSize(48);
        } else {
            theField.setTextSize(56);
        }
        theField.setText(String.valueOf(x));
    }

    /**
     * All the onClick methods that add-up the stats and send it to display methods.
     * <p>
     * A Team Methods
     */
    public void aGoal(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayScore(scoreTeamA, "team_a_score");
    }

    public void aFreeK(View view) {
        freeKickA = freeKickA + 1;
        displayResult(freeKickA, "freeK_fieldA");
    }

    public void aCornerK(View view) {
        cornerKickA = cornerKickA + 1;
        displayResult(cornerKickA, "cornerK_fieldA");
    }

    public void aFouls(View view) {
        foulsA = foulsA + 1;
        displayResult(foulsA, "fouls_fieldA");
    }

    /**
     * B Team Methods
     */
    public void bGoal(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayScore(scoreTeamB, "team_b_score");
    }

    public void bFreeK(View view) {
        freeKickB = freeKickB + 1;
        displayResult(freeKickB, "freeK_fieldB");
    }

    public void bCornerK(View view) {
        cornerKickB = cornerKickB + 1;
        displayResult(cornerKickB, "cornerK_fieldB");
    }

    public void bFouls(View view) {
        foulsB = foulsB + 1;
        displayResult(foulsB, "fouls_fieldB");
    }

    /**
     * Reset button method
     */
    public void resetPoints(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        freeKickA = 0;
        cornerKickA = 0;
        foulsA = 0;
        freeKickB = 0;
        cornerKickB = 0;
        foulsB = 0;

        displayResult(foulsB, "fouls_fieldB");
        displayResult(cornerKickB, "cornerK_fieldB");
        displayResult(freeKickB, "freeK_fieldB");
        displayScore(scoreTeamB, "team_b_score");

        displayResult(foulsA, "fouls_fieldA");
        displayResult(cornerKickA, "cornerK_fieldA");
        displayResult(freeKickA, "freeK_fieldA");
        displayScore(scoreTeamA, "team_a_score");

        TextView theFieldA = (EditText) findViewById(R.id.teamA);
        theFieldA.setText("");

        TextView theFieldB = (EditText) findViewById(R.id.teamB);
        theFieldB.setText("");

    }
}
