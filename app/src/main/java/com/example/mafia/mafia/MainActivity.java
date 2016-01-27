package com.example.mafia.mafia;
//Hello World
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button create=(Button)findViewById(R.id.start);

        final EditText players=(EditText)findViewById(R.id.players);
        final EditText doctors=(EditText)findViewById(R.id.doctors);
        final EditText mafia=(EditText)findViewById(R.id.mafia);

        create.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int noPlayers,noMafia,noDoctors,noVillagers;
                ArrayList<String> all=new ArrayList<String>();
                long seed = System.nanoTime();
                noPlayers=Integer.parseInt(players.getText().toString());
                noMafia=Integer.parseInt(mafia.getText().toString());
                noDoctors=Integer.parseInt(doctors.getText().toString());
                noVillagers=noPlayers-noMafia-noDoctors;
                String test=new String();

                if(noDoctors>noPlayers||noMafia>noPlayers){
                    Context context = getApplicationContext();
                    CharSequence text = "No of mafia or doctors canot be grater than number of player!!!!!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                else {
                    for (int i = 0; i < noVillagers; i++) {
                        all.add("Villager");
                    }

                    for (int i = 0; i < noMafia; i++) {
                        all.add("Mafia");
                    }

                    for (int i = 0; i < noDoctors; i++) {
                        all.add("Doctor");
                    }

                    Collections.shuffle(all, new Random(seed));

                    for(int i=0;i<all.size();i++)
                    {
                        test+=" "+all.get(i);
                    }

                    Context context = getApplicationContext();
                    CharSequence text = test;
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    Intent intent = new Intent(context, assignActivity.class);
                    intent.putStringArrayListExtra("content",all);
                    startActivity(intent);
                }
            }
        });
    }
}
