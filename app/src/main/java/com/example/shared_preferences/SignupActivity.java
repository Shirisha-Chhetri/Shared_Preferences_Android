package com.example.shared_preferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    Button b;
    EditText user, pass;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        user = findViewById(R.id.text1);
        pass = findViewById(R.id.text2);

        b = findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = user.getText().toString();
                String password = pass.getText().toString();
                SharedPreferences sp = getSharedPreferences("abc", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.putString("email",username);
                ed.putString("password",password);
                ed.apply();
                Intent i = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}
