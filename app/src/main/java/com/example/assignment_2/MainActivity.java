package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton tb;
    EditText textname,textid;
    Button vote;
    int votes1;
    int votes2;
    int votes3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textname = (EditText) findViewById(R.id.text_view1);
        textid = (EditText) findViewById(R.id.text_view2);
        vote = findViewById(R.id.button4);
        tb = findViewById(R.id.toggle);
        String[] candidates = {"choose candidate", "candidate1", "candidate2", "candidate3"};


        //Dropdown
        Spinner mySpinner = findViewById(R.id.Candiate);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, candidates);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //String s1 = String.valueOf(candidates[position]);
             switch(position){
                 case 0:
                     return;
                 case 1:
                     votes1 +=1;
                 case 2:
                     votes2 +=1;
                 case 3:
                     votes3 +=1;

             }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkdata();
                Intent i = new Intent(MainActivity.this, vote_candidates.class);
                Bundle bundle = new Bundle();
                bundle.putInt("votes1", votes1);
                bundle.putInt("votes2", votes2);
                bundle.putInt("votes3", votes3);
                i.putExtras(bundle);
                startActivity(i);

            }

            boolean isName(EditText text) {
                CharSequence textname = text.getText().toString();
                return (!TextUtils.isEmpty(textname));
            }

            boolean isEmpty(EditText text) {
                CharSequence str = text.getText().toString();
                return TextUtils.isEmpty(str);
            }

            private void checkdata() {
                if (isEmpty(textname)) {
                    textname.setError("Please enter name");
                }

                if (isEmpty(textid)) {
                    textid.setError("Please enter ID ");
                }
            }


        });

    }

}