package com.chig.quizapp;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MCFrag extends Fragment {
    String question, a, b, c, d, answer;

    public MCFrag(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_mc, null);

        TextView question = (TextView)fragmentView.findViewById(R.id.textView_question);
        final RadioGroup group = (RadioGroup)fragmentView.findViewById(R.id.radioGroup);
        Button selectAnswer = (Button)fragmentView.findViewById(R.id.button_answer);
        RadioButton buttonA = (RadioButton)fragmentView.findViewById(R.id.radioButtonA);
        RadioButton buttonB = (RadioButton)fragmentView.findViewById(R.id.radioButtonB);
        RadioButton buttonC = (RadioButton)fragmentView.findViewById(R.id.radioButtonC);
        RadioButton buttonD = (RadioButton)fragmentView.findViewById(R.id.radioButtonD);

        Bundle bundle = this.getArguments();
        this.question = bundle.getString("QUESTION");
        this.a = bundle.getString("CHOICE_A");
        this.b = bundle.getString("CHOICE_B");
        this.c = bundle.getString("CHOICE_C");
        this.d = bundle.getString("CHOICE_D");
        this.answer = bundle.getString("CORRECT_CHOICE");

        question.setText(this.question);
        buttonA.setText(this.a);
        buttonB.setText(this.b);
        buttonC.setText(this.c);
        buttonD.setText(this.d);



        selectAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton buttonSelected = (RadioButton)fragmentView.findViewById(group.getCheckedRadioButtonId());
                if(buttonSelected.getText().equals(answer)){
                    Log.d("TAG", "TRUE");
                    ((MainActivity)getActivity()).incrementScoreAndUpdate();
                }
            }
        });


        return fragmentView;
    }

}
