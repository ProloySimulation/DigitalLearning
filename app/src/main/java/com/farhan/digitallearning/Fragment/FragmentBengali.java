package com.farhan.digitallearning.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.farhan.digitallearning.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class FragmentBengali extends Fragment {

    TextView tvBenagli,tvScore ;
    Button btnA , btnB , btnC , btnD ;
    public Firebase qstn , optiona1,option2,option3,option4 , answer;
    private int questionNumber = 0 ;
    private int score = 0 ;
    private String manswer ; 


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_fragment_bengali, container, false);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        tvBenagli = rootView.findViewById(R.id.tvQstn);
        tvScore = rootView.findViewById(R.id.tvScore);
        btnA = rootView.findViewById(R.id.btnA);
        btnB = rootView.findViewById(R.id.btnB);
        btnC = rootView.findViewById(R.id.btnC);
        btnD = rootView.findViewById(R.id.btnD);

        updateQuestion();

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnA.getText().equals(manswer))
                {

                    score = score + 1;
                    updateScore(score);
                    updateQuestion();
                }
                else {
                    updateQuestion();
                }
            }
        });


        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnB.getText().equals(manswer))
                {

                    score = score + 1;
                    updateScore(score);
                    updateQuestion();
                }
                else {
                    updateQuestion();
                }
            }
        });


        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnC.getText().equals(manswer))
                {

                    score = score + 1;
                    updateScore(score);
                    updateQuestion();
                }
                else {
                    updateQuestion();
                }
            }
        });


        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnD.getText().equals(manswer))
                {

                    score = score + 1;
                    updateScore(score);
                    updateQuestion();
                }
                else {
                    updateQuestion();
                }
            }
        });
        return rootView ;
    }

    public void updateScore(int score)
    {
        tvScore.setText("" +score);
    }

    public void updateQuestion()
    {
        qstn = new Firebase("https://digitallearning-a581a.firebaseio.com/"+questionNumber + "/question");

        qstn.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String question = dataSnapshot.getValue(String.class);
                tvBenagli.setText(question);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        optiona1 = new Firebase("https://digitallearning-a581a.firebaseio.com/"+questionNumber +"/choice1");
        optiona1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                btnA.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        option2 = new Firebase("https://digitallearning-a581a.firebaseio.com/"+questionNumber + "/choice2");
        option2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                btnB.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        option3 = new Firebase("https://digitallearning-a581a.firebaseio.com/"+questionNumber + "/choice3");
        option3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                btnC.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        option4 = new Firebase("https://digitallearning-a581a.firebaseio.com/"+questionNumber + "/choice4");
        option4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                btnD.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        answer = new Firebase("https://digitallearning-a581a.firebaseio.com/"+questionNumber + "/answer");
        answer.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                 manswer = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        questionNumber++ ;

    }


}
