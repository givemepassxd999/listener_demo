package com.example.givemepass.listenerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button showDialog;
    private TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showDialog = (Button) findViewById(R.id.show_dialog);
        resultText = (TextView) findViewById(R.id.result);
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDialog mMyDialog = new MyDialog(MainActivity.this);
                mMyDialog.setOnEventCompletedListener(new MyDialog.OnEventCompletedListener() {
                    @Override
                    public void onCompleted(String result) {
                        resultText.setText(result);
                    }
                });
                mMyDialog.show();
            }
        });


    }
}
