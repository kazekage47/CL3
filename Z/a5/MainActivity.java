package com.example.root.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Button add,sin,store,load,file;
    EditText num1,num2,res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add=findViewById(R.id.button_add);
        sin=findViewById(R.id.button_sin);
        store=findViewById(R.id.button_store);
        load=findViewById(R.id.button_load);
        file=findViewById(R.id.button_file);

        num1=findViewById(R.id.editText_num1);
        num2=findViewById(R.id.editText2_num2);
        res=findViewById(R.id.editText_num3);

    }

    public void addition(View view)
    {
        Double n1,n2;
        n1=Double.parseDouble(num1.getText().toString());
        n2=Double.parseDouble(num2.getText().toString());

        res.setText("" +(n1+n2));

    }

    public void sin(View view)
    {
        Double n1,n2;
        n1=Double.parseDouble(num1.getText().toString());
        n2=Double.parseDouble(num2.getText().toString());

        res.setText("" + Math.sin(n1*Math.PI/180));

    }

    public void file(View view)
    {
        try {


            InputStream inputStream = getResources().openRawResource(R.raw.abc);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader= new BufferedReader(inputStreamReader);

            String n1=bufferedReader.readLine();
            String n2=bufferedReader.readLine();

            num1.setText(n1);
            num2.setText(n2);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void store(View view) throws IOException {
        try {
            FileOutputStream fileOutputStream = openFileOutput("try.txt", Context.MODE_PRIVATE);
            String temp = res.getText().toString();
            fileOutputStream.write(temp.getBytes());
            fileOutputStream.close();
        }
        catch (Exception e)
        {e.printStackTrace();}

    }


    public void load(View view) throws IOException {
        try {
            FileInputStream fileInputStream = openFileInput("try.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String temp = bufferedReader.readLine();
            res.setText(temp);
        }
        catch (Exception e)
        {e.printStackTrace();}
    }





}


