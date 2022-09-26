package com.example.inputcontrol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private TextView tvFeedback;
    RatingBar rbStars;
    EditText etFeedback;
    private String feedback = "0";
    private Button btnFeedback;
    private ToggleButton tbBtn;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        tvFeedback = findViewById(R.id.tvFeedback);
        rbStars = findViewById(R.id.rbStars);
        etFeedback = findViewById(R.id.et_feedback);
        btnFeedback = findViewById(R.id.btnFeedback);
        builder = new AlertDialog.Builder(this);
        tbBtn = findViewById(R.id.toggleButton);

        rbStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (rating == 0) {
                    feedback = ("Very Dissatisfied");

                } else if (rating == 1) {
                    feedback = ("Dissatisfied");

                } else if (rating == 2) {
                    feedback = ("OK");

                } else if (rating == 3) {
                    feedback = ("Satisfied");

                } else if (rating == 4) {
                    feedback = ("Very Satisfied");

                } else if (rating == 5) {
                    feedback = ("Excellent");

                }
                tvFeedback.setText(feedback);

            }

        });
        tbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Thanks for your feedback!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        btnFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verify();
                Intent i = new Intent(getApplicationContext(), first.class);
                startActivity(i);
            }
        });
    }
    private void verify() {
        String feedback = etFeedback.getText().toString();
        if (feedback.equals("")) {
            etFeedback.setError("Please enter your feedback");
            etFeedback.requestFocus();
            return;
        }
        Toast.makeText(this, "Thanks for your valuable feedback!", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(getApplicationContext(), next.class);
//        startActivity(intent);
    }

    @Override
    public void onBackPressed()
    {
        builder.setTitle("Quit");
        builder.setMessage("Do you really want to quit?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
//                finish();
                System.exit(0);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

}