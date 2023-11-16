package com.bot.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textViewCanBuy, textViewBalance;
    private int account = 200;
    private int spongeCakes=10, discountSpongeCakes=26;
    private int cream=10, discountСream=26;
    private int fruits=10, discountFruits=26;
    private int nuts=10, discountNuts=26;
    private int berries=7, discountBerries=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCanBuy = findViewById(R.id.possiblityOut);
        textViewBalance = findViewById(R.id.balanceOut);

        if(possibility()){
            textViewCanBuy.setText("Достаточно денег для покупки приготовления торта");
            textViewBalance.setText("Остаток от покупки " + balance() + " монет");
        }else {
            textViewCanBuy.setText("Не достаточно денег для покупки");
            textViewBalance.setText(" - ");
        }
    }

    private float calculation(){
        float count = ((spongeCakes * (100 - discountSpongeCakes) + cream * (100 - discountСream)
            + fruits * (100 - discountFruits) + nuts * (100 - discountNuts) + berries * (100 - discountBerries))/100);
        return count;
    }

    private boolean possibility(){
        if(calculation()<=account){
            return true;
        }else {
            return false;
        }
    }

    private float balance(){
        if(possibility()){
            return account - calculation();
        }else {
            return -1;
        }
    }
}