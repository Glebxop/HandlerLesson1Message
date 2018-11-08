package com.example.master.handlerlesson1message;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mTextView;
    Handler handler;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.buttonStart);
        mTextView=(TextView)findViewById(R.id.textViewMain);
         handler=new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {

               mTextView.setText(String.valueOf( msg.what));
               if (msg.what==10)button.setEnabled(true);
                return true;
            }
        });
    }

    public void start(View view) {

        button.setEnabled(false);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=10 ; i++) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(i);
                }}});
        thread.start();
    }
}
