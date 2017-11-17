package com.example.shans_000.vehicleguru1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Main2Activity extends AppCompatActivity {

    private EditText lpurchase_price , lscrapvalue , lmonthsleft ;
    private TextView lmonthlydepre , lyearlydepre ;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case  (R.id.navigation_home):
                    Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                    startActivity(intent);
                    return true;
                case (R.id.navigation_Depre):
                    intent = new Intent(Main2Activity.this, Main2Activity.class);
                    startActivity(intent);
                    return true;

                case (R.id.navigation_Loan):
                    intent = new Intent(Main2Activity.this, Main3Activity.class);
                    startActivity(intent);
                    break;

            }
            return false;

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lpurchase_price = findViewById(R.id.purchase_price);
        lscrapvalue = findViewById(R.id.scrapvalue);
        lmonthsleft = findViewById(R.id.monthsleft);
        lmonthlydepre = findViewById(R.id.monthlydepre);
        lyearlydepre = findViewById(R.id.yearlydepre);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    public void Calculate (View ClickedButton) {
        double purchase_price = Integer.parseInt(lpurchase_price.getText().toString());
        double scrapevalue = Integer.parseInt(lscrapvalue.getText().toString());
        double monthsleft = Integer.parseInt(lmonthsleft.getText().toString());

        double monthlydepre = (purchase_price-scrapevalue)/monthsleft;
        double yearlydepre = (monthlydepre*12);

        lmonthlydepre.setText(new DecimalFormat("##.##").format(monthlydepre));
        lyearlydepre.setText(new DecimalFormat("##.##").format(yearlydepre));



    }




}
