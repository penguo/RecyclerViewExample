package com.afordev.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * RecyclerView Example
 *
 * Created by penguo on 2018-01-17.
 */

public class MainActivity extends AppCompatActivity {

    RecyclerView rcv;
    RcvAdapter rcvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv = (RecyclerView) findViewById(R.id.main_rcv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv.addItemDecoration(new DividerItemDecoration(this, linearLayoutManager.getOrientation()));
        rcv.setLayoutManager(linearLayoutManager);

        ArrayList<DataForm> list = new ArrayList<>();
        list.add(new DataForm("Jung Jihun", 1));
        list.add(new DataForm("Lee Minho", 2));
        list.add(new DataForm("Alex", 2));
        list.add(new DataForm("Daniel", 4));
        list.add(new DataForm("Kim Bora", 3));
        list.add(new DataForm("Joa Sigong", 1));
        list.add(new DataForm("Park Somi", 1));
        list.add(new DataForm("Kim Minji", 3));
        list.add(new DataForm("Andrew", 3));

        rcvAdapter = new RcvAdapter(this, list);
        rcv.setAdapter(rcvAdapter);
    }
}
