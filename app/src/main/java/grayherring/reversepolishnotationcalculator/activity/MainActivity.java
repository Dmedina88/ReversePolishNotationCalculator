package grayherring.reversepolishnotationcalculator.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import grayherring.reversepolishnotationcalculator.R;
import grayherring.reversepolishnotationcalculator.util.Calculator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mInput;
    private TextView mOutPut;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInput = (EditText) findViewById(R.id.input);
        mOutPut = (TextView) findViewById(R.id.output);
        mButton = (Button) findViewById(R.id.enter_btn);

        mButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.enter_btn:
                try {
                    mOutPut.setText(Calculator.calculate(mInput.getText().toString()));
                } catch (Exception e) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.CustomDialog);
                    builder.setTitle("There is an issue with your Input");
                    builder.setMessage(e.getMessage());
                    builder.setNegativeButton("OK", null);
                    builder.show();
                }
                break;
        }
    }
}
