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

public class MainActivity2 extends AppCompatActivity {
    TextView firstnumber;
    TextView secondnumber;
    View layout;
    Button end;
    Random num=new Random();
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        firstnumber=findViewById(R.id.firstnumber);
        secondnumber=findViewById(R.id.secondnumber);
        end=findViewById(R.id.end);
        layout=findViewById(R.id.layout);
        firstnumber.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                checkanswer(1);
            }
        });
        secondnumber.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                checkanswer(0);
            }
        });
        end.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                System.out.println("count="+count);
                intent.putExtra("count",count);
                startActivity(intent);
                count=0;
            }
        });
    }
    public void checkanswer(int flag)
    {
        int first=Integer.parseInt(firstnumber.getText().toString());
        int second=Integer.parseInt(secondnumber.getText().toString());
        System.out.println(first);
        System.out.println(second);

        try {
            if (flag == 1 && Integer.parseInt(firstnumber.getText().toString()) > Integer.parseInt(secondnumber.getText().toString())) {
                Toast.makeText(this, "Well done", Toast.LENGTH_SHORT).show();
                layout.setBackgroundColor(Color.parseColor("#00FF00"));
                assignnumber();
                ++count;
            }
            else if (flag == 0 && Integer.parseInt(firstnumber.getText().toString()) < Integer.parseInt(secondnumber.getText().toString())) {
                Toast.makeText(this, "Well done", Toast.LENGTH_SHORT).show();
                layout.setBackgroundColor(Color.parseColor("#00FF00"));
                assignnumber();
                ++count;
            } else {
                end.callOnClick();
            }
        }
        catch(Exception e)
        {
            System.out.println("error");
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }
    }
    public void assignnumber()
    {
        firstnumber.setText(Integer.toString(num.nextInt(10)));
        secondnumber.setText(firstnumber.getText());
        while(secondnumber.getText()==firstnumber.getText())
        {
            secondnumber.setText(Integer.toString(num.nextInt(10)));
        }
    }
}
