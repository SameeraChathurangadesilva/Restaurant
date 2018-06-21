package com.ceyentra.restaurant;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
//        loadtale();

//        final TableView<String[]> tb = (TableView<String[]>) findViewById(R.id.tableview);
//        tb.setColumnCount(3);
//
//        data();
//
//        tb.setHeaderAdapter(new SimpleTableHeaderAdapter(this,placeorder));
//        tb.setDataAdapter(new SimpleTableDataAdapter(this,placorderdto));


//    private void data(){
//
//        SharedPreferences pref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
//
//        String test = pref.getString("Qty","");
//        String tets2 = pref.getString("Price","");
//
//        Object [] rowdata= {test,tets2};
//        PlaceOrderDTO placeOrderDTO = new PlaceOrderDTO();
//        List<PlaceOrderDTO> placeOrderDTOArrayList = new ArrayList<>();
//
//        for(PlaceOrderDTO placeOrderDTO1 :placeOrderDTOArrayList){
//            placeOrderDTO1.setItemname(test);
//            placeOrderDTO1.setQty(test);
//            placeOrderDTO1.setPrice(tets2);
//            placeOrderDTOArrayList.add(placeOrderDTO);
//        }
////        placeOrderDTO = new PlaceOrderDTO();
//
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

        ArrayList<String> listGet=new ArrayList<>();
        listGet=getListFromLocal("key");
        Log.e("getArrayList:","Get ArrayList size"+listGet.size());

        System.out.println(listGet.size()+"size");
        System.out.println(listGet.get(0)+" -0");
        System.out.println(listGet.get(1)+" -1");

//        List<PlaceOrderDTO> mcdList = new ArrayList<PlaceOrderDTO>();
//
//        ScrollView sv = new ScrollView(this);
//
//        // get a reference for the TableLayout
//        TableLayout ll = (TableLayout) findViewById(R.id.TableLayout01);
//
//        HorizontalScrollView hsv = new HorizontalScrollView(this);
//        // create a new TableRow
//        TableRow row = new TableRow(this);
//
//
//        SharedPreferences pref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
//
//        String test = pref.getString("Qty","");
//        String tets2 = pref.getString("Price","");
//
//        //This will be replaced by a Read Only Stored procedure that gets the List of Shelters
//        PlaceOrderDTO mcdonalds = new PlaceOrderDTO(test,tets2,tets2);
//        mcdList.add(mcdonalds);
//
//        for (PlaceOrderDTO mcD : mcdList){
//            // create a new TextView
//            TextView t = new TextView(this);
//            TextView t1 = new TextView(this);
//            TextView t2 = new TextView(this);
//            t2.setWidth(250);
//
//            String mcdAddress = mcD.getItemname();
//            String distance = mcD.getPrice();
//            String ETA = mcD.getQty();
//
//            t.setText(mcdAddress);
//            t1.setText(distance);
//            t2.setText(ETA);
//
//            row.addView(t);
//            row.addView(t1);
//            row.addView(t2);
//
//
//        }
//
//        ll.addView(row,new TableLayout.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

    }


    public ArrayList<String> getListFromLocal(String key)
    {
        SharedPreferences prefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        return gson.fromJson(json, type);

    }
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

//    public void loadtale(){
//
//        Intent intent = getIntent();
//        String itemname = intent.getStringExtra("Quantiy");
//        String toatlprice = intent.getStringExtra("Total");
//
//        SharedPreferences pref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
//
//        String test = pref.getString("Qty","");
//        String tets2 = pref.getString("Price","");
//
//        Object [] rowdata = {test,tets2};
//
//        TableLayout tableLayout =(TableLayout)findViewById(R.id.placeorderTableLayout);
//
//        for (int i=0;i<10;i++){
//            View tableRow = LayoutInflater.from(this).inflate(R.layout.activity_place_order,null,false);
////            TableRow tableRow = findViewById(R.id.placeorderTableRow);
//
//            TextView history_display_no  = (TextView) tableRow.findViewById(R.id.tvQty);
//            TextView history_display_date  = (TextView) tableRow.findViewById(R.id.tvPrice);
//
//            history_display_no.setText(test);
//            history_display_date.setText(tets2);
//
//        }
//    }
}
