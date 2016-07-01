package com.example.jpsejoe.snsadder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.button_Preview);
        final Button Tw_button = (Button) findViewById(R.id.twitter_Button);

        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (v == button) {
                        Msg_Check();
                    }
                }
            });
        }

        if (Tw_button != null) {
            Tw_button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (v == Tw_button) {
                        String Messege = getMsg();
                        Intent intent = new Intent();

                        intent.setAction(Intent.ACTION_SEND);
                        intent.setPackage("com.twitter.android");
                        intent.putExtra(Intent.EXTRA_TEXT,Messege);
                        startActivity(intent);
                    }
                }
            });
        }
    }

    private void Msg_Check() {
        Toast toast = Toast.makeText(MainActivity.this, "Textです", Toast.LENGTH_LONG);
        toast.show();

        String Msg = getMsg();
        TextView textView = (TextView) findViewById(R.id.text_view);
        textView.setText(Msg);
    }

    private String getMsg() {
        EditText editText = (EditText) findViewById(R.id.edit_text);
        String text = editText.getText().toString();
        return text;
    }
}