package com.example.shared_preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.logout){
            SharedPreferences sp = getSharedPreferences("state",MODE_PRIVATE);
            SharedPreferences.Editor et = sp.edit();
            et.putBoolean("loginstate",false);
            et.apply();
            Intent i = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(i);
        }
        return true;
    }
}
