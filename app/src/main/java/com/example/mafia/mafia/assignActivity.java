package com.example.mafia.mafia;

/**
 * Created by Pavan on 1/26/2016.
 */

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.*;

public class assignActivity extends AppCompatActivity{

    int count;
    ArrayList all=new ArrayList();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assign);
        TextView result;
        int count;
        Bundle bundle = getIntent().getExtras();
        all=bundle.getStringArrayList("content");
        result=(TextView)findViewById(R.id.result);
        result.setText("Please Pass On The Device To First Player");
        count=0;
    }

    public void start(View view){
        final TextView result = (TextView) findViewById(R.id.result);
        if(count<all.size()) {
            Context context = getApplicationContext();
            CharSequence text = "Hello toast!" + all.size();
            int duration = Toast.LENGTH_SHORT;

            result.setText(all.get(count).toString());
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            AlertDialog alertDialog=new AlertDialog.Builder(this).create();

            alertDialog.setTitle("Press Ok And Pass To Next Player");
            alertDialog.setMessage("You are " +all.get(count).toString());
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    result.setText("Pass the device to next player");
                }
            });
            alertDialog.show();
            count++;
        }
        else{
            result.setText("All the players are assigned with roles!! Time to start the game");
        }
    }

}
