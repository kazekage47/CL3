package com.example.root.calculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_plus = findViewById(R.id.button_plus);
        Button button_minus = findViewById(R.id.button_minus);
        Button button_multiply = findViewById(R.id.button_multiply);
        Button button_divide = findViewById(R.id.button_divide);
        Button button_sin = findViewById(R.id.button_sin);
        Button button_cos = findViewById(R.id.button_cos);
        Button button_tan = findViewById(R.id.button_tan);
        Button button_sec = findViewById(R.id.button_sec);
        Button button_cosec = findViewById(R.id.button_cosec);
        Button button_cot = findViewById(R.id.button_cot);
        Button button_sqrt = findViewById(R.id.button_sqrt);
        Button button_equals = findViewById(R.id.button_equals);
        Button button_clear = findViewById(R.id.button_clear);
        Button button_loadinput = findViewById(R.id.button_loadinput);
        Button button_loadoutput = findViewById(R.id.button_loadoutput);
        Button button_store = findViewById(R.id.button_store);

        final EditText editText_num1 = findViewById(R.id.editText_num1);
        final EditText editText_num2 = findViewById(R.id.editText_num2);
        final EditText editText_result = findViewById(R.id.editText_result);

        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float num1f = Float.parseFloat(editText_num1.getText().toString());
                Float num2f = Float.parseFloat(editText_num2.getText().toString());
                editText_result.setText(""+(num1f+num2f));
                Variables.operation=" + ";
            }
        });

        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float num1f = Float.parseFloat(editText_num1.getText().toString());
                Float num2f = Float.parseFloat(editText_num2.getText().toString());
                editText_result.setText(""+(num1f-num2f));
                Variables.operation=" - ";
            }
        });

        button_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float num1f = Float.parseFloat(editText_num1.getText().toString());
                Float num2f = Float.parseFloat(editText_num2.getText().toString());
                editText_result.setText(""+(num1f*num2f));
                Variables.operation=" * ";
            }
        });

        button_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float num1f = Float.parseFloat(editText_num1.getText().toString());
                Float num2f = Float.parseFloat(editText_num2.getText().toString());
                editText_result.setText(""+(num1f/num2f));
                Variables.operation=" / ";
            }
        });

        button_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_num1.setText("sin:");
                Variables.operation = "sin";
            }
        });

        button_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_num1.setText("cos:");
                Variables.operation = "cos";
            }
        });

        button_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_num1.setText("tan:");
                Variables.operation = "tan";
            }
        });

        button_sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_num1.setText("sec:");
                Variables.operation = "sec";
            }
        });

        button_cosec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_num1.setText("cosec:");
                Variables.operation = "cosec";
            }
        });

        button_cot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_num1.setText("cosec:");
                Variables.operation = "cosec";
            }
        });

        button_sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_num1.setText("sqrt:");
                Variables.operation = "sqrt";
            }
        });

        button_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Variables.operation.equals("sin")) {
                    String input = editText_num1.getText().toString();
                    String[] num1 = input.split(":");
                    Float num1f = Float.parseFloat(num1[1]);
                    editText_result.setText(""+Math.sin((num1f*Math.PI/180)));
                }
                else if(Variables.operation.equals("cos")) {
                    String input = editText_num1.getText().toString();
                    String[] num1 = input.split(":");
                    Float num1f = Float.parseFloat(num1[1]);
                    editText_result.setText(""+Math.cos((num1f*Math.PI/180)));
                }
                else if(Variables.operation.equals("tan")) {
                    String input = editText_num1.getText().toString();
                    String[] num1 = input.split(":");
                    Float num1f = Float.parseFloat(num1[1]);
                    editText_result.setText(""+Math.tan((num1f*Math.PI/180)));
                }
                else if(Variables.operation.equals("sec")) {
                    String input = editText_num1.getText().toString();
                    String[] num1 = input.split(":");
                    Float num1f = Float.parseFloat(num1[1]);
                    editText_result.setText(""+(1/Math.cos((num1f*Math.PI/180))));
                }
                else if(Variables.operation.equals("cosec")) {
                    String input = editText_num1.getText().toString();
                    String[] num1 = input.split(":");
                    Float num1f = Float.parseFloat(num1[1]);
                    editText_result.setText(""+(1/Math.sin((num1f*Math.PI/180))));
                }
                else if(Variables.operation.equals("cot")) {
                    String input = editText_num1.getText().toString();
                    String[] num1 = input.split(":");
                    Float num1f = Float.parseFloat(num1[1]);
                    editText_result.setText(""+(1/Math.tan((num1f*Math.PI/180))));
                }
                else if(Variables.operation.equals("sqrt")) {
                    String input = editText_num1.getText().toString();
                    String[] num1 = input.split(":");
                    Float num1f = Float.parseFloat(num1[1]);
                    editText_result.setText(""+Math.sqrt(num1f));
                }
            }
        });

        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Variables.operation = "";
                editText_num1.setText("");
                editText_num2.setText("");
                editText_result.setText("");
            }
        });

        button_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fileOutputStream;
                try {
                    fileOutputStream = openFileOutput("try.txt", Context.MODE_PRIVATE);
                    String filecontents = editText_num1.getText().toString()+Variables.operation+editText_num2.getText().toString()+" = "+editText_result.getText().toString();
                    fileOutputStream.write(filecontents.getBytes());
                    fileOutputStream.close();
                } catch (Exception e) {
                    editText_result.setText("Error in store");
                    e.printStackTrace();
                }
            }
        });

        button_loadoutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileInputStream fileInputStream;
                try {
                    fileInputStream = openFileInput("try.txt");
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String input = bufferedReader.readLine();
                    editText_result.setText(input);
                } catch (Exception e) {
                    editText_result.setText("Error in loading output");
                    e.printStackTrace();
                }
            }
        });

        button_loadinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream inputStream = getResources().openRawResource(R.raw.abc);
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String num1 = bufferedReader.readLine();
                    editText_num1.setText(num1);
                    String num2 = bufferedReader.readLine();
                    editText_num2.setText(num2);
                } catch (Exception e) {
                    editText_result.setText("Error in loading input");
                    e.printStackTrace();
                }
            }
        });

    }
}
