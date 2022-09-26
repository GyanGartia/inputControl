package com.example.inputcontrol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.UiModeManager;
import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class first extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    FloatingActionButton fab;
    Button btnClick,btnContacts;
    Switch modeSwitch;
    //SwitchMaterial modeSwitch;
    private UiModeManager umm;
    private TextView tvClick;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    //Option Menu
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.item1:
//                Toast.makeText(this, "Item 1", Toast.LENGTH_SHORT).show();
//                return true;
//
//            case R.id.item2:
//                Toast.makeText(this,"Item 2", Toast.LENGTH_SHORT).show();
//                return true;
//
//            case R.id.item3:
//                Toast.makeText(this, "Item 3", Toast.LENGTH_SHORT).show();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        fab = findViewById(R.id.btn_fab);
        umm = (UiModeManager) getSystemService(UI_MODE_SERVICE);
        modeSwitch = findViewById(R.id.switch1);
        tvClick = findViewById(R.id.tvClick);
        btnClick = findViewById(R.id.btnClick);
        btnContacts = findViewById(R.id.btnContacts);

        btnContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),contact.class);
                startActivity(intent);
            }
        });
        tvClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPop(view);
            }
        });

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),second.class);
                startActivity(intent);
            }
        });

        modeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    umm.setNightMode(UiModeManager.MODE_NIGHT_YES);
                } else
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    umm.setNightMode(UiModeManager.MODE_NIGHT_NO);
                }
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Signup.class);
                startActivity(i);
            }
        });
    }

    public void showPop(View view) {
        PopupMenu popupMenu = new PopupMenu(getApplicationContext(), view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
    }



    public void NightModeON(View view) {
        umm.setNightMode(UiModeManager.MODE_NIGHT_YES);
    }

    public void NightModeOFF(View view) {
        umm.setNightMode(UiModeManager.MODE_NIGHT_NO);
    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.item_1:
                Toast.makeText(this, "Item 1 is selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item_2:
                Toast.makeText(this, "Item 2 is selected", Toast.LENGTH_SHORT).show();
                return true;


            case R.id.item_3:
                Toast.makeText(this , "Item 3 is selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item_4:
                Toast.makeText(this , "Item 4 is selected", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return false;
        }
    }
}

