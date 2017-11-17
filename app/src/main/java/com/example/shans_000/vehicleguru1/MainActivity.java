package com.example.shans_000.vehicleguru1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case (R.id.navigation_home):
                    Intent intent = new Intent(MainActivity.this,MainActivity.class);
                    startActivity(intent);
                    return true;
                case (R.id.navigation_Depre):
                    intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                    return true;
                case (R.id.navigation_Loan):
                    intent =new  Intent(MainActivity.this, Main3Activity.class);
                     startActivity(intent);
                     break ;
            }
            return false;
        }
    };



}
