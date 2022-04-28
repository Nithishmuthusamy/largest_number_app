package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView score;
    View layout;
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score=findViewById(R.id.score);
        layout=findViewById(R.id.layout);
        start=findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });
        try {
            Intent intent1 = getIntent();
            score.setText("Your score= "+Integer.toString(intent1.getIntExtra("count", 0)));
        }
        catch(Exception e)
        {
            System.out.println("one");
        }
    }
}
