package com.example.shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user, pass;
    Button signup,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkLoginStatus();

        signup = findViewById(R.id.btn2);
        login = findViewById(R.id.btn1);

        user = findViewById(R.id.edit1);
        pass = findViewById(R.id.edit2);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SignupActivity.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //fetch from file
                SharedPreferences sp = getSharedPreferences("abc",MODE_PRIVATE);
                String fusername = sp.getString("email","siri");
                String fpassword = sp.getString("password","chhe");

                //fetch from user
                String uusernamea = user.getText().toString();
                String upassword = pass.getText().toString();
                if (fusername.equals(uusernamea) && fpassword.equals(upassword)){

                    //Length_Long is final class that means it is constant so capital
                    Toast.makeText(MainActivity.this, "Successfully Logged in",Toast.LENGTH_LONG).show();

                    SharedPreferences lp = getSharedPreferences("state",MODE_PRIVATE);
                    SharedPreferences.Editor et = lp.edit();
                    et.putBoolean("loginstate",true);
                    et.apply();

                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this, "Incorrect email or passsword",Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    private void checkLoginStatus() {
        SharedPreferences sp = getSharedPreferences("state",MODE_PRIVATE);
        boolean state = sp.getBoolean("loginstate",false);
        if(state){
            Intent i = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(i);
        }
    }
}