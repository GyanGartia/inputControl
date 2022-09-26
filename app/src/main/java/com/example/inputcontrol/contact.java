package com.example.inputcontrol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class contact extends AppCompatActivity {

    ListView listView;
    String contacts[]={"Gyan","Yash","Rohit","Akshay","Pankaj"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        listView=(ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);
        listView.setAdapter(adapter);
        // Register the ListView  for Context menu
        registerForContextMenu(listView);

    }

    //ContextMenu
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.call){
            Toast.makeText(getApplicationContext(),"calling code",Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId()==R.id.sms){
            Toast.makeText(getApplicationContext(),"sending sms code",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        menu.setHeaderTitle("Select The Action");
    }
}