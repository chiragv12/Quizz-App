package com.chig.quizapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int score;
    TextView scoreDisp;
    Button next;
    Button previous;
    int questionNum = 1;

    FragmentTransaction ft;
    FragmentManager fragmentManager;
    ArrayList<Bundle> questions = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle q1 = new Bundle();
        q1.putString("QUESTION", "Who is the current number 1 tennis player?");
        q1.putString("CHOICE_A", "Novak Djokovic");
        q1.putString("CHOICE_B", "Roger Federer");
        q1.putString("CHOICE_C", "Rafa Nadal");
        q1.putString("CHOICE_D", "Andy Murray");
        q1.putString("CORRECT_CHOICE", "Andy Murray");
        questions.add(q1);

        Bundle q2 = new Bundle();
        q2.putString("QUESTION", "Who has won the most Grand Slams?");
        q2.putString("CHOICE_A", "Roger Federer");
        q2.putString("CHOICE_B", "Alexander Zverev");
        q2.putString("CHOICE_C", "Nick Krygios");
        q2.putString("CHOICE_D", "Pete Sampras");
        q2.putString("CORRECT_CHOICE", "Roger Federer");
        questions.add(q2);

        Bundle q3 = new Bundle();
        q3.putString("QUESTION", "How many Grand Slams does Roger Federer have?");
        q3.putString("CHOICE_A", "17");
        q3.putString("CHOICE_B", "19");
        q3.putString("CHOICE_C", "15");
        q3.putString("CHOICE_D", "18");
        q3.putString("CORRECT_CHOICE", "18");
        questions.add(q3);

        Bundle q4 = new Bundle();
        q4.putString("QUESTION", "In what year did Rafa Nadal win his last Grand Slam?");
        q4.putString("CHOICE_A", "2011");
        q4.putString("CHOICE_B", "2016");
        q4.putString("CHOICE_C", "2014");
        q4.putString("CHOICE_D", "2015");
        q4.putString("CORRECT_CHOICE", "2014");
        questions.add(q4);

        Bundle q5 = new Bundle();
        q5.putString("QUESTION", "Who is the best American player");
        q5.putString("CHOICE_A", "Jack Sock");
        q5.putString("CHOICE_B", "Steve Johnson");
        q5.putString("CHOICE_C", "Taylor Fritz");
        q5.putString("CHOICE_D", "John Isner");
        q5.putString("CORRECT_CHOICE", "Jack Sock");
        questions.add(q5);

        Bundle q6 = new Bundle();
        q6.putString("QUESTION", "Who won the 2016 French Open?");
        q6.putString("CORRECT_CHOICE", "Novak Djokovic");
        questions.add(q6);

        Bundle q7 = new Bundle();
        q7.putString("QUESTION", "How many Grand Slams does Novak Djokovic have?");
        q7.putString("CORRECT_CHOICE", "12");
        questions.add(q7);

        Bundle q8 = new Bundle();
        q8.putString("QUESTION", "Who was the only person to win the Calender Slam in the open era?");
        q8.putString("CORRECT_CHOICE", "Rod Laver");
        questions.add(q8);

        Bundle q9 = new Bundle();
        q9.putString("QUESTION", "Who is the youngest player currently in the top 20?");
        q9.putString("CORRECT_CHOICE", "Alexander Zverev");
        questions.add(q9);

        Bundle q10 = new Bundle();
        q10.putString("QUESTION", "Who won the most French Open titles?");
        q10.putString("CORRECT_CHOICE", "Rafa Nadal");
        questions.add(q10);




        scoreDisp = (TextView)findViewById(R.id.textView_score);
        next = (Button)findViewById(R.id.button_next);
        previous = (Button)findViewById(R.id.button_previous);



        fragmentManager = getSupportFragmentManager();
        ft = fragmentManager.beginTransaction();


        MCFrag initialQuestion = new MCFrag();
        initialQuestion.setArguments(q1);
        ft.add(R.id.relLayout, initialQuestion);

        ft.commit();

        scoreDisp.setText(score + "");

        Log.d("TAG", score + "");

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionNum++;

                if(questionNum >= 1 && questionNum<= 5){
                    MCFrag mc = new MCFrag();
                    mc.setArguments(questions.get(questionNum-1));
                    ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.relLayout, mc);
                    ft.commit();
                }
                else if(questionNum >=6 && questionNum <= 10){
                    FreeResFrag frq = new FreeResFrag();
                    frq.setArguments(questions.get(questionNum-1));
                    ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.relLayout, frq);
                    ft.commit();
                }
                else if(questionNum > 10){
                    questionNum = 10;
                }

            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionNum--;
                if(questionNum >= 1 && questionNum<= 5){
                    MCFrag mc = new MCFrag();
                    mc.setArguments(questions.get(questionNum-1));
                    ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.relLayout, mc);
                    ft.commit();
                }
                else if(questionNum >=6 && questionNum <= 10){
                    FreeResFrag frq = new FreeResFrag();
                    frq.setArguments(questions.get(questionNum-1));
                    frq.setArguments(questions.get(questionNum-1));
                    ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.relLayout, frq);
                    ft.commit();
                }
                else if(questionNum < 1){
                    questionNum = 1;
                }


            }
        });
    }

    public void incrementScoreAndUpdate(){
        score++;
        scoreDisp.setText(score + "");
    }

}
