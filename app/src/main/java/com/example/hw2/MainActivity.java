package com.example.hw2;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int grade1;
    int grade2;
    int grade3;
    int grade4;
    int grade5;

    EditText grade1Input;
    EditText grade2Input;
    EditText grade3Input;
    EditText grade4Input;
    EditText grade5Input;

    TextView computeGpaOutput;

    Button gpaButton;

    int gpaCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grade1Input = (EditText) findViewById(R.id.grade1Input);
        grade2Input = (EditText) findViewById(R.id.grade2Input);
        grade3Input = (EditText) findViewById(R.id.grade3Input);
        grade4Input = (EditText) findViewById(R.id.grade4Input);
        grade5Input = (EditText) findViewById(R.id.grade5Input);

        computeGpaOutput = (TextView) findViewById(R.id.computeGpaOutput);


        gpaButton = (Button) findViewById(R.id.button);


        pressButton(gpaButton);

    }
    public void pressButton(final Button button)
    {
        final LinearLayout bgElement = (LinearLayout) findViewById(R.id.container);

        gpaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(grade1Input.length() == 0)
                {
                    grade1Input.setError("Enter Grade");
                }else if(grade2Input.length() == 0)
                {
                    grade2Input.setError("Enter Grade");
                }else if(grade3Input.length() == 0)
                {
                    grade3Input.setError("Enter Grade");
                }else if(grade4Input.length() == 0)
                {
                    grade4Input.setError("Enter Grade");
                }else if(grade5Input.length() == 0)
                {
                    grade5Input.setError("Enter Grade");
                }else
                {
                    grade1 = Integer.valueOf(grade1Input.getText().toString());
                    grade2 = Integer.valueOf(grade2Input.getText().toString());
                    grade3 = Integer.valueOf(grade3Input.getText().toString());
                    grade4 = Integer.valueOf(grade4Input.getText().toString());
                    grade5 = Integer.valueOf(grade5Input.getText().toString());



                    gpaCalc = (grade1 + grade2 + grade3 + grade4 + grade5) / 5;

                    computeGpaOutput.setText(String.valueOf(gpaCalc));

                    if (gpaCalc <= 60) {
                        bgElement.setBackgroundColor(Color.RED);
                    } else if (gpaCalc >= 61 && gpaCalc <= 79) {
                        bgElement.setBackgroundColor(Color.YELLOW);
                    } else
                        bgElement.setBackgroundColor(Color.GREEN);

                    gpaButton.setText("Clear Form");

                    if(gpaButton.getText() == "Clear Form")
                    {
                        gpaButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                grade1Input.setText("");
                                grade2Input.setText("");
                                grade3Input.setText("");
                                grade4Input.setText("");
                                grade5Input.setText("");
                                computeGpaOutput.setText("");

                                bgElement.setBackgroundColor(Color.WHITE);
                                gpaButton.setText("Compute GPA");

                                if(gpaButton.getText() == "Compute GPA")
                                {
                                    pressButton(button);
                                }
                            }
                        });
                    }
                }
            }
        });
    }
}