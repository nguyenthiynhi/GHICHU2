package com.example.administrator.ghichu;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Database database;
    ListView lvcongviec;
    ArrayList<CongViec> ArralCongViec;
    CongViecAdrapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvcongviec = (ListView) findViewById(R.id.lvcongviec);
        ArralCongViec = new ArrayList<>();


        adapter  = new CongViecAdrapter(this,R.layout.dong_cong_viec,ArralCongViec);
        lvcongviec.setAdapter(adapter);

        //tao database Ghichu
        database = new Database(this, "ghichu.sqlite", null, 1);
        //tao bang Congviec
        database.QueryData("CREATE TABLE if not exists Congviec  (ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, TenCV TEXT NOT NULL)");
        database.QueryData("insert into Congviec values (null, ' ngày 22/4/2018 ')");

        Cursor dataCongviec = database.GetData("select * from Congviec");
        while (dataCongviec.moveToNext()) {
            String ten = dataCongviec.getString(1);
            //Toast.makeText(this,ten,Toast.LENGTH_LONG).show();
            //Toast.makeText(this, "dung xem nua", Toast.LENGTH_SHORT).show();
            int id = dataCongviec.getInt(0);
            ArralCongViec.add(new CongViec(id,ten));
        }
        adapter.notifyDataSetChanged();
    }
}
