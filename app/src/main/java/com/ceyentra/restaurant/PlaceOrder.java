package com.ceyentra.restaurant;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class PlaceOrder extends AppCompatActivity {

    private Context context;
    public Toolbar toolbar;
    public TextView total,qty;

//    String [] placeorder = {"Item name","Qty","Price",};
//    String [][] placorderdto ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        this.context = context;
        settoolBar();
//        total = findViewById(R.id.Total);
//        set();
        loadtale();

//        final TableView<String[]> tb = (TableView<String[]>) findViewById(R.id.tableview);
//        tb.setColumnCount(3);
//
//        data();
//
//        tb.setHeaderAdapter(new SimpleTableHeaderAdapter(this,placeorder));
//        tb.setDataAdapter(new SimpleTableDataAdapter(this,placorderdto));
    }
//    private void data(){
//
//        SharedPreferences pref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
//
//        String test = pref.getString("Qty","");
//        String tets2 = pref.getString("Price","");
//
//        Object [] rowdata= {test,tets2};
//        PlaceOrderDTO placeOrderDTO = new PlaceOrderDTO();
//        ArrayList<PlaceOrderDTO> placeOrderDTOArrayList = new ArrayList<>();
//
//        placeOrderDTO = new PlaceOrderDTO();
//        placeOrderDTO.setItemname(test);
//        placeOrderDTO.setQty(test);
//        placeOrderDTO.setPrice(tets2);
//        placeOrderDTOArrayList.add(placeOrderDTO);
//
//        placorderdto = new String[placeOrderDTOArrayList.size()][3];
//
//
//        for(int i=0;i<placeOrderDTOArrayList.size();i++){
//
//            PlaceOrderDTO orderDTO = placeOrderDTOArrayList.get(i);
//
//            placorderdto[i][0]=orderDTO.getItemname();
//            placorderdto[i][1]=orderDTO.getQty();
//            placorderdto[i][2]=orderDTO.getPrice();
//        }
//    }


    public void settoolBar() {
        toolbar = findViewById(R.id.toolbarShoppingcard);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("PlaceOrder");
        toolbar.setTitleTextColor(Color.parseColor("#EEEEEE"));
        toolbar.setNavigationIcon(R.drawable.left_24px);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainForm.class));
                finish();
            }
        });
    }

//    public void set(){
//        SharedPreferences pref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
//
//        String test = pref.getString("Qty","");
//        total.setText(test);
//
//
//    }

    public void loadtale(){

        Intent intent = getIntent();
        String itemname = intent.getStringExtra("Quantiy");
        String toatlprice = intent.getStringExtra("Total");

        SharedPreferences pref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);

        String test = pref.getString("Qty","");
        String tets2 = pref.getString("Price","");

//        ArrayList<String> getAll = new ArrayList<>();
//        getAll.add(test);
//        getAll.add(tets2);

        Object [] rowdata = {test,tets2};

        TableLayout tableLayout =(TableLayout)findViewById(R.id.placeorderTableLayout);

        for (int i=0;i<rowdata.length;i++){
//            View tableRow = LayoutInflater.from(this).inflate(R.layout.activity_place_order,null,false);
            TableRow tableRow = findViewById(R.id.placeorderTableRow);
            TextView history_display_no  = (TextView) tableRow.findViewById(R.id.tvQty);
            TextView history_display_date  = (TextView) tableRow.findViewById(R.id.tvPrice);

            history_display_no.setText(test);
            history_display_date.setText(tets2);

        }
    }
}
