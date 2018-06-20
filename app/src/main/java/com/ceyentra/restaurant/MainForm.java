package com.ceyentra.restaurant;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TextView;

public class MainForm extends AppCompatActivity {

    public Toolbar toolbar;
    private Context context;
    private Button button;
    private TabHost host;
    private TextView itemname,PPpice,Mprice,Lprice;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_form);
        this.context=this;
        toolBarDetails();

        loadTabHost();
        Test();
//        colorChange();

    }

    public void toolBarDetails() {
        toolbar = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Restaurant");
        toolbar.setTitleTextColor(Color.parseColor("#EEEEEE"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void loadTabHost(){

        host = findViewById(R.id.tabHost);
        host.setup();


//        this.setNewTab(this, host, "tab3", R.string.app_name3, R.drawable.beer_24px, R.id.layout01);
//        this.setNewTab(this, host, "tab3", R.string.app_name3, R.drawable.bread_24px, R.id.layout02);
//        this.setNewTab(this, host, "tab3", R.string.app_name3, R.drawable.dim_sum_24px, R.id.layout03);
//        this.setNewTab(this, host, "tab4", R.string.app_name3, R.drawable.cinnamonroll_24px, R.id.layout04);
//        this.setNewTab(this, host, "tab5", R.string.app_name3, R.drawable.cinnamonroll_24px, R.id.layout05);

        TabHost.TabSpec spec1 = host.newTabSpec("");
        spec1.setIndicator("", getResources().getDrawable(R.drawable.bread_24px));
        spec1.setContent(R.id.layout01);
        host.addTab(spec1);

        TabHost.TabSpec spec2 = host.newTabSpec("Tab 02");
        spec2.setIndicator("", getResources().getDrawable(R.drawable.cinnamonroll_24px));
        spec2.setContent(R.id.layout02);
        host.addTab(spec2);

        TabHost.TabSpec spec3 = host.newTabSpec("Tab 03");
        spec3.setIndicator("", getResources().getDrawable(R.drawable.dim_sum_24px));
        spec3.setContent(R.id.layout03);
        host.addTab(spec3);

        TabHost.TabSpec spec4 = host.newTabSpec("Tab 04");
        spec4.setIndicator("", getResources().getDrawable(R.drawable.beer_24px));
        spec4.setContent(R.id.layout04);
        host.addTab(spec4);

        TabHost.TabSpec spec5 = host.newTabSpec("Tab 05");
        spec5.setIndicator("", getResources().getDrawable(R.drawable.beer_24px));
        spec5.setContent(R.id.layout05);
        host.addTab(spec5);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.shoppingcard:
                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        startActivity(new Intent(getApplicationContext(),PlaceOrder.class));
                        return true;
                    }
                });
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setNewTab(Context context, TabHost tabHost, String tag, int title, int icon, int contentID ){
        TabHost.TabSpec tabSpec = tabHost.newTabSpec(tag);
        tabSpec.setIndicator(getTabIndicator(tabHost.getContext(), title, icon)); // new function to inject our own tab layout
        tabSpec.setContent(contentID);
        tabHost.addTab(tabSpec);
    }

    private View getTabIndicator(Context context, int title, int icon) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_layout, null);
        ImageView iv = (ImageView) view.findViewById(R.id.imageView);
        iv.setImageResource(icon);
        TextView tv = (TextView) view.findViewById(R.id.textView);
        tv.setText(title);
        return view;
    }


    public void Test(){

        itemname = findViewById(R.id.item_name);
        PPpice = findViewById(R.id.PPprice);
        Mprice = findViewById(R.id.Mprice);
        Lprice = findViewById(R.id.Lprice);
        button = findViewById(R.id.btnAdd);
        imageView = findViewById(R.id.item_icon);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,DialogTest.class);
                String setItemName = itemname.getText().toString();
                String setPPprice = PPpice.getText().toString();
                String setMprice = Mprice.getText().toString();
                String setLprice = Lprice.getText().toString();

                intent.putExtra("ItemName",setItemName);
                intent.putExtra("PPprice",setPPprice);
                intent.putExtra("Mprice",setMprice);
                intent.putExtra("Lprice",setLprice);
                startActivity(intent);

//
//                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainForm.this);
//                View  view = getLayoutInflater().inflate(R.layout.activity_dialog_form,null);
//                mBuilder.setView(view);
//                AlertDialog alertDialog = mBuilder.create();
//                alertDialog.show();
////

            }
        });
    }
}