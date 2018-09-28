package com.example.a503_01.view0928;

import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

public class TabLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);


        TabHost host = (TabHost) findViewById(R.id.host);
        host.setup();

        TabHost.TabSpec spec = host.newTabSpec("tab1");
        spec.setIndicator(null,
                ResourcesCompat.getDrawable(getResources(), R.drawable.arrowright, null));
        spec.setContent(R.id.tab_content1);
        host.addTab(spec);

        spec = host.newTabSpec("tab2");
        spec.setIndicator(null,
                ResourcesCompat.getDrawable(getResources(), R.drawable.shoppingcart, null));
        spec.setContent(R.id.tab_content2);
        host.addTab(spec);

        spec = host.newTabSpec("tab2");
        spec.setIndicator(null,
                ResourcesCompat.getDrawable(getResources(), R.drawable.arrowleft, null));

        spec.setContent(R.id.tab_content2);
        host.addTab(spec);



    }
}