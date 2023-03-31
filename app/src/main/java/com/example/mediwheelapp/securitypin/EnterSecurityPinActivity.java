package com.example.mediwheelapp.securitypin;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mediwheelapp.Activities.CreateAndSignInActivity;
import com.example.mediwheelapp.Activities.TextChangedListener;
import com.example.mediwheelapp.R;

public class EnterSecurityPinActivity extends AuthenticateFingerPrint {
    private static final String TAG = "EnterSecurityPinActivit";
    private EditText edtLoginPIN1, edtLoginPIN2, edtLoginPIN3, edtLoginPIN4;
    private String pin1 = "", pin2 = "", pin3 = "", pin4 = "", requiredPIN;
    private TextView resetPin;
    private Button enterPinBtn;

    private ProgressDialog progressDialog;
    private String token;
    private String mob;
    SharedPreferenceUtils sharedPreferenceUtils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_security_pin);
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage(this.getResources().getString(R.string.pleaseWait));
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        sharedPreferenceUtils = SharedPreferenceUtils.getInstance(this);

        init();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            authintecate(this);
        }

    }

    private void init() {
        edtLoginPIN1 = findViewById(R.id.edtLoginPIN1);
        edtLoginPIN1.requestFocus();
        edtLoginPIN2 = findViewById(R.id.edtLoginPIN2);
        edtLoginPIN3 = findViewById(R.id.edtLoginPIN3);
        edtLoginPIN4 = findViewById(R.id.edtLoginPIN4);
        resetPin = findViewById(R.id.reset_pin);


        edtLoginPIN1.addTextChangedListener(new TextChangedListener<EditText>(edtLoginPIN1) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                pin1 = s.toString();
                requiredPIN = pin1 + pin2 + pin3 + pin4;
                if (s.toString().length() > 0) {
                    edtLoginPIN2.requestFocus();
                }
            }
        });


        edtLoginPIN2.addTextChangedListener(new TextChangedListener<EditText>(edtLoginPIN2) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                pin2 = s.toString();
                requiredPIN = pin1 + pin2 + pin3 + pin4;
                if (s.toString().length() > 0) {
                    edtLoginPIN3.requestFocus();
                }
            }

        });


        edtLoginPIN3.addTextChangedListener(new TextChangedListener<EditText>(edtLoginPIN3) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                pin3 = s.toString();
                requiredPIN = pin1 + pin2 + pin3 + pin4;
                if (s.toString().length() > 0) {
                    edtLoginPIN4.requestFocus();
                }
            }
        });

        edtLoginPIN4.addTextChangedListener(new TextChangedListener<EditText>(edtLoginPIN4) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                pin4 = s.toString();
                requiredPIN = pin1 + pin2 + pin3 + pin4;
                createPassword();
                // checkUser();
            }
        });

        resetPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationAlertDialog();
            }
        });

    }

    private void showConfirmationAlertDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setMessage(getResources().getString(R.string.resetCodeMessage));
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, getResources().getString(R.string.btnCstAlertDigCancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, getResources().getString(R.string.btnMainActivityLogout), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
                sharedPreferenceUtils.clear();
                startActivity(new Intent(EnterSecurityPinActivity.this, CreateAndSignInActivity.class));
                finish();

            }
        });

        alertDialog.show();
    }

    private void createPassword() {
        if (requiredPIN.length() == 4) {
            if (sharedPreferenceUtils.getStringValue("SecurityPin", "").equals(requiredPIN)) {
                setResult(2000, new Intent().putExtra("enter_pin", true));
                finish();
            } else {
                Toast.makeText(this, getResources().getString(R.string.pinInvalid), Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }


}
