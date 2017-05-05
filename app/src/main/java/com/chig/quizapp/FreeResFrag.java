package com.chig.quizapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FreeResFrag extends Fragment {

    String question;
    String answer;

    public FreeResFrag() {

    }

    public void setParams(String question, String answer){
        this.question = question;
        this.answer = answer;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_free_res, null);

        final TextView question = (TextView)fragmentView.findViewById(R.id.textView_freeQuestion);
        final EditText response = (EditText)fragmentView.findViewById(R.id.editText_freeResponce);
        Button submit = (Button)fragmentView.findViewById(R.id.button_submit);

        question.setText(this.question);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer.toUpperCase().equals(response.getText().toString().toUpperCase())){
                    Log.d("TAG", "TRUE 2");
                    ((MainActivity)getActivity()).incrementScoreAndUpdate();
                }
            }
        });




        return fragmentView;
    }

}
