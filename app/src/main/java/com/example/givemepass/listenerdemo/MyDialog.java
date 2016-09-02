package com.example.givemepass.listenerdemo;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by rick.wu on 2016/9/2.
 */
public class MyDialog extends Dialog{
    public interface OnEventCompletedListener{
        void onCompleted(String result);
    }

    public void setOnEventCompletedListener(OnEventCompletedListener listener){
        mOnEventCompletedListener = listener;
    }
    private OnEventCompletedListener mOnEventCompletedListener;
    private EditText input;
    private Button submit;
    public MyDialog(Context context) {
        super(context, R.style.AppTheme);
        setContentView(R.layout.my_dialog);
        input = (EditText) findViewById(R.id.input);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = input.getText().toString();
                if(inputText != null && !inputText.equals("")){
                    if(mOnEventCompletedListener != null){
                        mOnEventCompletedListener.onCompleted(inputText);
                    }
                }
                dismiss();
            }
        });
    }
}
