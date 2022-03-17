package com.example.android.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;

    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                Intent ProjectIntent=new Intent(ProfileActivity.this,CreateProjectActivity.class);
                startActivity(ProjectIntent);
                return true;
            case R.id.item2:
                Intent homeIntent=new Intent(ProfileActivity.this,MainActivity.class);
                startActivity(homeIntent);
                return true;
            case R.id.item3:
                Intent contactIntent=new Intent(ProfileActivity.this,ContactActivity.class);
                startActivity(contactIntent);
                return true;
            case R.id.item4:
                Intent LogoutIntent=new Intent(ProfileActivity.this,LoginActivity.class);
                startActivity(LogoutIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
