package com.example.inputcontrol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Signup extends AppCompatActivity {

    EditText etName, etPhn, etEmail, etPsswd,etCnfPsswd;
    Button btnSignup;
    String[] state = { "State","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Gujarat","Haryana",
            "Himachal Pradesh","Jharkhand","Karnataka","Kerala","Madhya pradesh","Maharashtra","Mizoram","Nagaland","Odisha",
            "Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Spinner spin = findViewById(R.id.city_spn);
        //spin.setOnClickListener(this);

        etName = findViewById(R.id.name_et);
        etPhn = findViewById(R.id.phone_et);
        etEmail = findViewById(R.id.email_et);
        etPsswd = findViewById(R.id.password_signup_et);
        etCnfPsswd = findViewById(R.id.cnf_password_signup_et);
        btnSignup = findViewById(R.id.signup_btn);

        btnSignup.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view)
            {
                String name = etName.getText().toString();
                String phn = etPhn.getText().toString();
                String email = etEmail.getText().toString();
                String psswd = etPsswd.getText().toString();
                String cnfpsswd = etCnfPsswd.getText().toString();

                if(chkName(name) && chkPhn(phn) && chkEmail(email) && chkPsswd(psswd) && chkCnfPsswd(psswd,cnfpsswd))
                {
                    Toast.makeText(Signup.this, "Successfully Signed Up", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(Signup.this, Login.class);
//                    intent.putExtra("Name", name);
//                    intent.putExtra("Password", psswd);
//                    startActivity(intent);
                }
            }
        });

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, state);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spin.setAdapter(dataAdapter);
    }
    //Performing action onItemSelected and onNothing selected
    public String onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        return parent.getItemAtPosition(position).toString();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    boolean chkName(String name) {
        if (name.trim().length() <= 0)
        {
            etName.setError("Enter Name");
            return false;
        } else
            return true;
    }

    boolean chkPhn(String phn) {
        if (phn.trim().length() <= 0)
        {
            etPhn.setError("Enter Mobile Number");
            return false;
        }
        else if (phn.trim().length() != 10)
        {
            etPhn.setError("Invalid Phone Number");
            return false;
        } else
            return true;
    }

    boolean chkEmail(String email)
    {
        if (email.trim().length() <= 0)
        {
            etEmail.setError("Enter Email");
            return false;
        }
        else if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return true;
        }
        else
        {
            etEmail.setError("Invalid Email Address");
            return false;
        }
    }

    public boolean chkPsswd (String psswd)
    {
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a z])(?=.*[A Z])(?=.*[@#$%^&+=]).{5,}$";
        if (psswd.trim().length() <= 0)
        {
            etPsswd.setError("Enter Password");
            return false;
        }
        else if ( Pattern.compile (PASSWORD_PATTERN).matcher(psswd.trim()).matches()) {
            return true;
        }
        else
        {
            etPsswd.setError("Enter at least one digit,one lower case letter,one upper case letter," +
                    "one special character and length must be 5");
            return true;
        }

    }
    public boolean chkCnfPsswd(String psswd,String cnfpsswd)
    {
        if(psswd.equals(cnfpsswd))
            return true;
        else
        {
            etCnfPsswd.setError("Password didn't match");
            return false;
        }
    }

    private void alert(String message)
    {

        AlertDialog dlg = new AlertDialog.Builder(Signup.this)
                .setTitle("Message")
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                    }
                })
                .create();
        dlg.show();
    }

}