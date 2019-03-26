package com.example.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView textViewScore;
    private TextView textViewExpression;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewScore = findViewById(R.id.textViewScore);
        textViewExpression = findViewById(R.id.textViewExpression);
    }

    public void buttonACClick(View view) {
        textViewExpression.setText("");
    }

    public void buttonPMClick(View view) {
        System.out.println("PM");
    }

    public void buttonPercentageClick(View view) {
        System.out.println("%");
    }

    public void buttonDivClick(View view) {
        textViewExpression.setText(textViewExpression.getText().toString()+"/");
    }

    public void buttonMutiplyClick(View view) {
        textViewExpression.setText(textViewExpression.getText().toString()+"*");
    }

    public void buttonAddClick(View view) {
         textViewExpression.setText(textViewExpression.getText().toString()+"+");
    }

    public void buttonMinusClick(View view) {
        textViewExpression.setText(textViewExpression.getText().toString()+"-");
    }

    public void buttonDotClick(View view) {
        textViewExpression.setText(textViewExpression.getText().toString()+",");
    }

    public void buttonEqualClick(View view) {
        textViewScore.setText(Count.test(textViewExpression.getText().toString()));
    }

    public void button0Click(View view) {
        textViewExpression.setText(textViewExpression.getText().toString()+"0");
    }

    public void button1Click(View view) {
        textViewExpression.setText(textViewExpression.getText().toString()+"1");
    }

    public void button2Click(View view) {
        textViewExpression.setText(textViewExpression.getText().toString()+"2");
    }

    public void button3Click(View view) {
        textViewExpression.setText(textViewExpression.getText().toString()+"3");
    }

    public void button4Click(View view) {
        textViewExpression.setText(textViewExpression.getText().toString()+"4");
    }

    public void button5Click(View view) {
        textViewExpression.setText(textViewExpression.getText().toString()+"5");
    }

    public void button6Click(View view) {
        textViewExpression.setText(textViewExpression.getText().toString()+"6");
    }

    public void button7Click(View view) {
        textViewExpression.setText(textViewExpression.getText().toString()+"7");
    }

    public void button8Click(View view) {
        textViewExpression.setText(textViewExpression.getText().toString()+"8");
    }

    public void button9Click(View view) {
        textViewExpression.setText(textViewExpression.getText().toString()+"9");
    }
}
