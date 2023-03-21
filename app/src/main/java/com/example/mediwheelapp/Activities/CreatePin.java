package com.example.mediwheelapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mediwheelapp.R;

public class CreatePin extends AppCompatActivity {
    private EditText etPin1, etPin2, etPin3, etPin4;
    private EditText etCPin1, etCPin2, etCPin3, etCPin4;
    private String pin1 = "", pin2 = "", pin3 = "", pin4 = "", requiredPIN, confirmPin;

    Button btnReset, btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pin);
        init();
    }

    private void init() {
        etPin1 = findViewById(R.id.etPin1);
        etPin1.requestFocus();
        etPin2 = findViewById(R.id.etPin2);
        etPin3 = findViewById(R.id.etPin3);
        etPin4 = findViewById(R.id.etPin4);

        etCPin1 = findViewById(R.id.etCPin1);
        etCPin2 = findViewById(R.id.etCPin2);
        etCPin3 = findViewById(R.id.etCPin3);
        etCPin4 = findViewById(R.id.etCPin4);


        btnSubmit = findViewById(R.id.btnSubmit);
        btnReset = findViewById(R.id.btnReset);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etPin1.getText().clear();
                etPin2.getText().clear();
                etPin3.getText().clear();
                etPin4.getText().clear();
                etCPin1.getText().clear();
                etCPin2.getText().clear();
                etCPin3.getText().clear();
                etCPin4.getText().clear();
                etPin1.requestFocus();

            }
        });

        etPin1.addTextChangedListener(new TextChangedListener<EditText>(etPin1) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                pin1 = s.toString();
                requiredPIN = pin1 + pin2 + pin3 + pin4;
                if (s.toString().length() > 0) {
                    etPin2.requestFocus();
                    etPin1.getBackground().setColorFilter(getColor(R.color.otpbgfilled), PorterDuff.Mode.MULTIPLY);
                } else {
                    etPin1.getBackground().setColorFilter(getColor(R.color.white), PorterDuff.Mode.MULTIPLY);
                }
            }
        });

        etPin2.addTextChangedListener(new TextChangedListener<EditText>(etPin2) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                pin2 = s.toString();
                requiredPIN = pin1 + pin2 + pin3 + pin4;
                if (s.toString().length() > 0) {
                    etPin3.requestFocus();
                    etPin2.getBackground().setColorFilter(getColor(R.color.otpbgfilled), PorterDuff.Mode.MULTIPLY);
                } else {
                    etPin1.requestFocus();
                    etPin2.getBackground().setColorFilter(getColor(R.color.white), PorterDuff.Mode.MULTIPLY);
                }
            }
        });

        etPin3.addTextChangedListener(new TextChangedListener<EditText>(etPin3) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                pin3 = s.toString();
                requiredPIN = pin1 + pin2 + pin3 + pin4;
                if (s.toString().length() > 0) {
                    etPin4.requestFocus();
                    etPin3.getBackground().setColorFilter(getColor(R.color.otpbgfilled), PorterDuff.Mode.MULTIPLY);
                } else {
                    etPin2.requestFocus();
                    etPin3.getBackground().setColorFilter(getColor(R.color.white), PorterDuff.Mode.MULTIPLY);
                }
            }
        });

        etPin4.addTextChangedListener(new TextChangedListener<EditText>(etPin4) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                pin4 = s.toString();
                requiredPIN = pin1 + pin2 + pin3 + pin4;
                if (s.toString().length() > 0) {
                    etCPin1.requestFocus();
                    etPin4.getBackground().setColorFilter(getColor(R.color.otpbgfilled), PorterDuff.Mode.MULTIPLY);
                } else {
                    etPin3.requestFocus();
                    etPin4.getBackground().setColorFilter(getColor(R.color.white), PorterDuff.Mode.MULTIPLY);
                }

            }
        });

        etCPin1.addTextChangedListener(new TextChangedListener<EditText>(etCPin1) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                pin1 = s.toString();
                confirmPin = pin1 + pin2 + pin3 + pin4;
                if (s.toString().length() > 0) {
                    etCPin2.requestFocus();
                    etCPin1.getBackground().setColorFilter(getColor(R.color.otpbgfilled), PorterDuff.Mode.MULTIPLY);
                } else {
                    etPin4.requestFocus();
                    etCPin1.getBackground().setColorFilter(getColor(R.color.white), PorterDuff.Mode.MULTIPLY);
                }
            }
        });

        etCPin2.addTextChangedListener(new TextChangedListener<EditText>(etCPin2) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                pin2 = s.toString();
                confirmPin = pin1 + pin2 + pin3 + pin4;
                if (s.toString().length() > 0) {
                    etCPin3.requestFocus();
                    etCPin2.getBackground().setColorFilter(getColor(R.color.otpbgfilled), PorterDuff.Mode.MULTIPLY);
                } else {
                    etCPin1.requestFocus();
                    etCPin2.getBackground().setColorFilter(getColor(R.color.white), PorterDuff.Mode.MULTIPLY);
                }
            }

        });

        etCPin3.addTextChangedListener(new TextChangedListener<EditText>(etCPin3) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                pin3 = s.toString();
                confirmPin = pin1 + pin2 + pin3 + pin4;
                if (s.toString().length() > 0) {
                    etCPin4.requestFocus();
                    etCPin3.getBackground().setColorFilter(getColor(R.color.otpbgfilled), PorterDuff.Mode.MULTIPLY);
                } else {
                    etCPin2.requestFocus();
                    etCPin3.getBackground().setColorFilter(getColor(R.color.white), PorterDuff.Mode.MULTIPLY);
                }
            }
        });

        etCPin4.addTextChangedListener(new TextChangedListener<EditText>(etCPin4) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                pin4 = s.toString();
                confirmPin = pin1 + pin2 + pin3 + pin4;
                if (s.toString().length() > 0) {
                    etCPin4.getBackground().setColorFilter(getColor(R.color.otpbgfilled), PorterDuff.Mode.MULTIPLY);
                } else {
                    etCPin3.requestFocus();
                    etCPin4.getBackground().setColorFilter(getColor(R.color.white), PorterDuff.Mode.MULTIPLY);
                }

            }


        });



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCondition();
            }
        });


    }

    private void checkCondition() {
        if (requiredPIN != null) {
            if (requiredPIN.length() == 4) {
                if (requiredPIN.matches(
                        "[0-9]+")) {
                    if (confirmPin.equals(requiredPIN)) {
                        Intent intent = new Intent(this,DashBoradActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(CreatePin.this, "In Valid PIN", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(CreatePin.this, "In Valid PIN", Toast.LENGTH_SHORT).show();

                }
            }
        }
    }
}