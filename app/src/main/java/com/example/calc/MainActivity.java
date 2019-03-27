package com.example.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView textViewExpression;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewExpression = findViewById(R.id.textViewExpression);
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("StringKey", textViewExpression.getText().toString());
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        String restore = savedInstanceState.getString("StringKey");
        textViewExpression.setText(restore);
    }

    public void buttonACClick(View view) {
        textViewExpression.setText("");
    }

    public void buttonPMClick(View view) {
        textViewExpression.setText( Calculator.negation(textViewExpression.getText().toString()));
    }

    public void buttonPercentageClick(View view) {
        textViewExpression.setText( Calculator.percent(textViewExpression.getText().toString()));
    }

    public void buttonDivClick(View view) {
        if(Calculator.validate(textViewExpression.getText().toString()+"/")){
            textViewExpression.setText(textViewExpression.getText().toString()+"/");
        }
    }

    public void buttonMutiplyClick(View view) {
        if(Calculator.validate(textViewExpression.getText().toString()+"*")){
            textViewExpression.setText(textViewExpression.getText().toString()+"*");
        }
    }

    public void buttonAddClick(View view) {
        if(Calculator.validate(textViewExpression.getText().toString()+"+")){
            textViewExpression.setText(textViewExpression.getText().toString()+"+");
        }
    }

    public void buttonMinusClick(View view) {
        if(Calculator.validate(textViewExpression.getText().toString()+"-")){
            textViewExpression.setText(textViewExpression.getText().toString()+"-");
        }
    }

    public void buttonDotClick(View view) {
        if(Calculator.validate(textViewExpression.getText().toString()+",")){
            textViewExpression.setText(textViewExpression.getText().toString()+".");
        }
    }

    public void buttonEqualClick(View view) {
        textViewExpression.setText(Calculator.count(textViewExpression.getText().toString()));
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

    public void buttonLogClick(View view) {
        textViewExpression.setText( Calculator.log(textViewExpression.getText().toString()));
    }

    public void buttonSilniaClick(View view) {
        textViewExpression.setText( Calculator.silnia(textViewExpression.getText().toString()));
    }

    public void buttonSqrtClick(View view) {
        textViewExpression.setText( Calculator.sqrt(textViewExpression.getText().toString()));
    }

    public void buttonx3click(View view) {
        textViewExpression.setText( Calculator.x3(textViewExpression.getText().toString()));
    }

    public void buttonx2Click(View view) {
        textViewExpression.setText( Calculator.x2(textViewExpression.getText().toString()));
    }
}
