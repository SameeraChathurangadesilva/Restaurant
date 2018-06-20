package com.ceyentra.restaurant;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DialogTest extends AppCompatActivity {

    public Toolbar toolbar;
    private TextView txtSetItemSizePrice,totalPrice;
    private Button btnAddToOrder;
    private RadioGroup radioGroupSizes;
    private RadioButton ppprice,mprice,lprice;
    private EditText qty;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_test);
        this.context=this;

        btnAddToOrder = findViewById(R.id.btnAddToOrder);
        ppprice = findViewById(R.id.PPprice);
        mprice = findViewById(R.id.Mprice);
        lprice = findViewById(R.id.Lprice);
        qty = findViewById(R.id.txtQty);
        totalPrice = findViewById(R.id.txtTotal);

        setToolBar();
        setItemPriceValues();
        setTestValue();
        setTotalPrice();
    }

    public void setToolBar() {

        Intent intent = getIntent();
        String itemname = intent.getStringExtra("ItemName");
        toolbar = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(itemname);
        toolbar.setTitleTextColor(Color.parseColor("#EEEEEE"));
        toolbar.setNavigationIcon(R.drawable.left_24px);
    }

    public void setItemPriceValues() {

        radioGroupSizes = findViewById(R.id.RadioItemSize);

        radioGroupSizes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.PPprice:
                        // do operations specific to this selection
                        Intent pppriceIntent = getIntent();
                        String pppricevalue = pppriceIntent.getStringExtra("PPprice");
                        txtSetItemSizePrice = findViewById(R.id.txtSetItemSizePrice);
                        txtSetItemSizePrice.setText(pppricevalue);
                        break;

                    case R.id.Mprice:
                        // do operations specific to this selection
                        Intent mpriceIntent = getIntent();
                        String mprice = mpriceIntent.getStringExtra("Mprice");
                        txtSetItemSizePrice = findViewById(R.id.txtSetItemSizePrice);
                        txtSetItemSizePrice.setText(mprice);
                        break;

                    case R.id.Lprice:
                        // do operations specific to this selection
                        Intent lpriceIntent = getIntent();
                        String lprice = lpriceIntent.getStringExtra("Lprice");
                        txtSetItemSizePrice = findViewById(R.id.txtSetItemSizePrice);
                        txtSetItemSizePrice.setText(lprice);
                        break;

                }
            }
        });
    }

    public void setTotalPrice(){

        qty =findViewById(R.id.txtQty);

        qty.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //here is your code
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                try {
                    txtSetItemSizePrice = findViewById(R.id.txtSetItemSizePrice);
                    totalPrice = findViewById(R.id.txtTotal);
                    String quantiy = qty.getText().toString();
                    Double quantiyDouble= Double.valueOf(quantiy).doubleValue();
                    String itemprice = txtSetItemSizePrice.getText().toString();
                    Double itempriceDouble = Double.valueOf(itemprice).doubleValue();
                    Double total = quantiyDouble*itempriceDouble;
                    totalPrice.setText(String.valueOf(total));
                }catch (NumberFormatException ex){

                }
            }
        });
    }


    public void setTestValue() {

        btnAddToOrder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    Intent intent = new Intent(context,PlaceOrder.class);
                    String pp = ppprice.getText().toString();
                    String m = mprice.getText().toString();
                    String l = lprice.getText().toString();
                    String quantiy = qty.getText().toString();
                    String total = totalPrice.getText().toString();

                    intent.putExtra("PPprice",pp);
                    intent.putExtra("Mprice",m);
                    intent.putExtra("Lprice",l);
                    intent.putExtra("Quantiy",quantiy);
                    intent.putExtra("Total",total);
                    startActivity(intent);

                    SharedPreferences pref = getSharedPreferences("MyPref", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();

                    editor.putString("Qty",qty.getText().toString());
                    editor.putString("Price",totalPrice.getText().toString());
                    editor.apply();

                }catch (NumberFormatException ex){

                }

            }
        });
    }
}
