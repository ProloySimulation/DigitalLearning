package com.farhan.digitallearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.farhan.digitallearning.Fragment.FragmentBengali;
import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    CardView btnBengali,card1,card2,card3,card4 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBengali = findViewById(R.id.btnBengali);
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);

        Firebase.setAndroidContext(this);

        btnBengali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnBengali.setVisibility(View.GONE);
                card1.setVisibility(View.GONE);
                card2.setVisibility(View.GONE);
                card3.setVisibility(View.GONE);
                card4.setVisibility(View.GONE);

                FragmentBengali fragmentBengali = new FragmentBengali();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container,fragmentBengali);
                transaction.commit();
            }
        });

    }

}
