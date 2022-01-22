package com.example.myapplication;


import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText email, password;
    private TextView welcome, enterReg;
    private Button btn_save;
    boolean notEmpty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        welcome = findViewById(R.id.welcome);
        enterReg = findViewById(R.id.enter_register);
        btn_save = findViewById(R.id.btn_save);


        email.addTextChangedListener(LoginTextWatcher);
        password.addTextChangedListener(LoginTextWatcher);


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals("1") && password.getText().toString().equals("1")) {
                    Toast.makeText(MainActivity.this, "Welcome to the Sample Login Tutorial", Toast.LENGTH_SHORT).show();
                    email.setVisibility(View.GONE);
                    password.setVisibility(View.GONE);
                    btn_save.setVisibility(View.GONE);
                    enterReg.setVisibility(View.GONE);
                } else {
                    Toast.makeText(MainActivity.this, "Username or Password is not correct", Toast.LENGTH_SHORT).show();
                }


            }
        });




        password.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        if (!email.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {
                            btn_save.setBackgroundColor(Color.parseColor("#FF6600"));
                        } else {
                            btn_save.setBackgroundColor(Color.parseColor("#D8575757"));
                        }
                    }
                });
        email.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        if (!email.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {
                            btn_save.setBackgroundColor(Color.parseColor("#FDDB16"));
                        } else {
                            btn_save.setBackgroundColor(Color.parseColor("##FFFFFF"));
                        }
                    }
                });
    }

    private final TextWatcher LoginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            btn_save.setEnabled(!email.getText().toString().isEmpty() && !password.getText().toString().isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

            if (!email.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {
                notEmpty = false;
            } else {
                notEmpty = true;
            }
        }
    };
}