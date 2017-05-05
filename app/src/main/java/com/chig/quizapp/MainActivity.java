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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MCFrag mc1 = new MCFrag();
        mc1.setParams("Who is the current number 1 tennis player?", "Novak Djokovic", "Roger Federer", "Rafa Nadal", "Andy Murray", "Andy Murray");

        final MCFrag mc2 = new MCFrag();
        mc2.setParams("Who has won the most Grand Slams?", "Roger Federer", "Alexander Zverev", "Nick Krygios", "Pete Sampras", "Roger Federer");

        final MCFrag mc3 = new MCFrag();
        mc3.setParams("How many Grand Slams does Roger Federer have?", "17", "19", "15", "18", "18");

        final MCFrag mc4 = new MCFrag();
        mc4.setParams("In what year did Rafa Nadal win his last Grand Slam?", "2011", "2016", "2014", "2015", "2014");

        final MCFrag mc5 = new MCFrag();
        mc5.setParams("Who is the best American player", "Jack Sock", "Steve Johnson", "Taylor Fritz", "John Isner", "Jack Sock");

        final FreeResFrag fr1 = new FreeResFrag();
        fr1.setParams("Who won the 2016 French Open?", "Novak Djokovic");

        final FreeResFrag fr2 = new FreeResFrag();
        fr2.setParams("How many Grand Slams does Novak Djokovic have?", "12");

        final FreeResFrag fr3 = new FreeResFrag();
        fr3.setParams("Who was the only person to win the Calender Slam in the open era?", "Rod Laver");

        final FreeResFrag fr4 = new FreeResFrag();
        fr4.setParams("Who is the youngest player currently in the top 20?", "Alexander Zverev");

        final FreeResFrag fr5 = new FreeResFrag();
        fr5.setParams("Who won the most French Open titles?", "Rafa Nadal");




        scoreDisp = (TextView)findViewById(R.id.textView_score);
        next = (Button)findViewById(R.id.button_next);
        previous = (Button)findViewById(R.id.button_previous);



        fragmentManager = getSupportFragmentManager();
        ft = fragmentManager.beginTransaction();


        ft.add(R.id.relLayout, mc1);

        ft.commit();

        scoreDisp.setText(score + "");

        Log.d("TAG", score + "");

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionNum++;

                switch(questionNum){
                    case 1:
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.relLayout, mc1);
                        ft.commit();
                        break;
                    case 2:
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.relLayout, mc2);
                        ft.commit();
                        break;
                    case 3:
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.relLayout, mc3);
                        ft.commit();
                        break;
                    case 4:
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.relLayout, mc4);
                        ft.commit();
                        break;
                    case 5:
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.relLayout, mc5);
                        ft.commit();
                        break;
                    case 6:
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.relLayout, fr1);
                        ft.commit();
                        break;
                    case 7:
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.relLayout, fr2);
                        ft.commit();
                        break;
                    case 8:
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.relLayout, fr3);
                        ft.commit();
                        break;
                    case 9:
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.relLayout, fr4);
                        ft.commit();
                        break;
                    case 10:
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.relLayout, fr5);
                        ft.commit();
                        break;
                    default:
                        questionNum--;
                        break;
                }

            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionNum--;

                switch(questionNum){
                    case 1:
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.relLayout, mc1);
                        ft.commit();
                        break;
                    case 2:
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.relLayout, mc2);
                        ft.commit();
                        break;
                    case 3:
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.relLayout, mc3);
                        ft.commit();
                        break;
                    case 4:
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.relLayout, mc4);
                        ft.commit();
                        break;
                    case 5:
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.relLayout, mc5);
                        ft.commit();
                        break;
                    case 6:
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.relLayout, fr1);
                        ft.commit();
                        break;
                    case 7:
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.relLayout, fr2);
                        ft.commit();
                        break;
                    case 8:
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.relLayout, fr3);
                        ft.commit();
                        break;
                    case 9:
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.relLayout, fr4);
                        ft.commit();
                        break;
                    case 10:
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.relLayout, fr5);
                        ft.commit();
                        break;
                    default:
                        questionNum++;
                        break;
                }

            }
        });
    }

    public void incrementScoreAndUpdate(){
        score++;
        scoreDisp.setText(score + "");
    }

}
