package com.ycce.mptruck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener{
    private Button sendotp;
    private EditText textotp,textnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        addlisteners();
    }

    private void addlisteners() {
        sendotp.setOnClickListener(this);
    }

    private void init(){
        sendotp= (Button) findViewById(R.id.sendotp);
        textotp = (EditText) findViewById(R.id.textotp);
        textnum = (EditText) findViewById(R.id.textnum);
    }
    private boolean validatePhoneNumber() {
        String phoneNumber = textnum.getText().toString();
        if (TextUtils.isEmpty(phoneNumber)) {
            textnum.setError("Invalid phone number.");
            return false;
        }

        return true;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sendotp:
                if (!validatePhoneNumber()) {
                    return;
                }

                startPhoneNumberVerification(mPhoneNumberField.getText().toString());
                break;
    }
}
