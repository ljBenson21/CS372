package com.example.lbenson18.yahtzee;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;

public class GameStart extends AppCompatActivity implements View.OnClickListener, Runnable {
    //public static Boolean startStop; // START STOP BUTTON DEPRECATED
    int[] images = {R.drawable.five, R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.six};
    int[] values = {0,0,0,0,0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);
       // GameStart game = new GameStart();

        final Button button1 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(this);
        Intent intent = getIntent();

    }




    public void run() {



        int[] imageviews = {R.id.imageView2,R.id.imageView3, R.id.imageView4, R.id.imageView5,R.id.imageView6 };
        Random rnd = new Random();

            for (int i = 0; i < 5; i++) {
                ImageView view = (ImageView) findViewById(imageviews[i]);
                int s = rnd.nextInt(6);
                view.setImageResource(images[s]);
                values[i] = s+1;

            }
        //   TextView v = (TextView) findViewById(R.id.textView);
        //    v.setText(addDie());

        }
    public void onClick(View v) {
        run();
    }
    public int addDie(){
        int sum = 0;
        int id[] = {R.drawable.one};
        for (int i = 0; i < images.length +1; i++){
            sum += values[i];
        }

        return sum;
    }
    }






