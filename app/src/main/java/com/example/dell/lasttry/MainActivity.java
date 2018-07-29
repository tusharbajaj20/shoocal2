package com.example.dell.lasttry;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button b;
    ListView l;
    EditText e;
    EditText ee;
    EditText eee;
    SQLiteDatabase sql=null;
    ArrayList n=new ArrayList();
    ArrayList p=new ArrayList();
    ArrayList s=new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.button);
        l=(ListView)findViewById(R.id.listview);
        e=(EditText)findViewById(R.id.editText);
        ee=(EditText)findViewById(R.id.editText2);
        eee=(EditText)findViewById(R.id.editText3);
        sql=openOrCreateDatabase("m",MODE_PRIVATE,null);
        sql.execSQL("create table if not exists android (name varchar,number varchar,state varchar)");
    }
    public void click(View v){
        n.clear();
        p.clear();
        s.clear();
        String name=e.getText().toString();
        String number=ee.getText().toString();
        String state=eee.getText().toString();
        sql.execSQL("insert into android values ('"+name+"','"+number+"','"+state+"')");
        Snackbar.make(v,"inserted",Snackbar.LENGTH_SHORT).show();
        Cursor c=sql.rawQuery("select * from android",null);
        c.moveToFirst();
        do{
            n.add(c.getString(c.getColumnIndex("name")));
            p.add(c.getString(c.getColumnIndex("number")));
            s.add(c.getString(c.getColumnIndex("state")));
        }
        while(c.moveToNext());
        custom ar=new custom(MainActivity.this);
        l.setAdapter(ar);
    }
}
