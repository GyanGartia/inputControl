package com.example.inputcontrol;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class second extends AppCompatActivity {

//    CardView cdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().hide();

        CardView cardView1 = findViewById(R.id.cd1);
        registerForContextMenu(cardView1);
    }

    //Context Menu
    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.example_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option1:
                Toast.makeText(getApplicationContext(), "Option 1 is selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.option2:
                Toast.makeText(getApplicationContext(), "Option 2 is selected", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
//        return super.onContextItemSelected(item);
    }

}