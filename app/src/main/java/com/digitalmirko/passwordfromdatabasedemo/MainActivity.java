package com.digitalmirko.passwordfromdatabasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = editText.getText().toString();
                if(!code.equals("")){
                    for(int i = 0; i < Database.codes.length; i++){
                        if(code.equals(Database.codes[i])){
                            // enter the app
                            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
//                            Toast.makeText(MainActivity.this, "Wrong Password!", Toast.LENGTH_SHORT).show();
                            textView.setText("Wrong Password");
                        }
                    }
                }
            }
        });
    }
}
