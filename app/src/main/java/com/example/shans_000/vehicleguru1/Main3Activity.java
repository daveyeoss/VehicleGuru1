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


   public class Main3Activity extends AppCompatActivity {
    private EditText Lpurchase_price, Ldown_payment , Linterest_rate , Lloan_period ;
    private TextView Lmonthly_payment_result , Ltotal_interest_result, Lloan_amount ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Lpurchase_price = findViewById(R.id.purchase_price);
        Ldown_payment = findViewById(R.id.Down_payment);
        Linterest_rate = findViewById(R.id.interest_rate);
        Lloan_period = findViewById(R.id.loan_period);
        Lloan_amount = findViewById(R.id.loan_amount_result);
        Lmonthly_payment_result = findViewById(R.id.monthly_payment_result);
        Ltotal_interest_result = findViewById(R.id.total_interest_result);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener);
    }


    public void showLoanPayments(View ClickedButton) {
        double purchase_price = Integer.parseInt(Lpurchase_price.getText().toString());
        double  down_payment = Integer.parseInt(Ldown_payment.getText().toString());
        double interest_rate = Integer.parseInt(Linterest_rate.getText().toString());
        double loan_period= Integer.parseInt(Lloan_period.getText().toString());


        double loan_amount = (purchase_price-down_payment);
        double total_interest = ((loan_amount * interest_rate)*loan_period)/12;
        double monthly_payment = loan_amount+total_interest/loan_period;

        Lmonthly_payment_result.setText(new DecimalFormat("##.##").format(monthly_payment));
        Lloan_amount.setText(new DecimalFormat("##.##").format(loan_amount));
        Ltotal_interest_result.setText(new DecimalFormat("##.##").format(total_interest));
    }
    private BottomNavigationView.OnNavigationItemSelectedListener OnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(Main3Activity.this,MainActivity.class);
                    startActivity(intent);
                    return true;
                case (R.id.navigation_Depre):
                    intent = new Intent(Main3Activity.this, Main2Activity.class);
                    startActivity(intent);
                    return true;
                case (R.id.navigation_Loan):
                    intent = new Intent(Main3Activity.this, Main3Activity.class);
                    startActivity(intent);
                     break;
            }return false;
    }

};

}
