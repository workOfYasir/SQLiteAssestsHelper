package com.hybird.sqliteassestshelper;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hybird.sqliteassestshelper.RecylcerPackage.DBAdapter;
import com.hybird.sqliteassestshelper.RecylcerPackage.DBModelClass;
import com.hybird.sqliteassestshelper.SQLitePackage.MyDbClass;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyDbClass objMyDbClass;
    ArrayList<DBModelClass> objDbModelClassArrayList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        objMyDbClass=new MyDbClass(this);
        objDbModelClassArrayList=new ArrayList();
        recyclerView=findViewById(R.id.dataRV);
    }
    public void showData(View view)
    {
        try {
            objDbModelClassArrayList=objMyDbClass.getAllData();
            DBAdapter objDbAdapter = new DBAdapter(objDbModelClassArrayList);
            recyclerView.hasFixedSize();
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(objDbAdapter);
        }
        catch(Exception e){
            Toast.makeText(this, "showData", Toast.LENGTH_SHORT).show();
        }
    }
}
