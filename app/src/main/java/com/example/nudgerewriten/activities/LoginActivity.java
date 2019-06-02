package com.example.nudgerewriten.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.nudgerewriten.R;
import com.example.nudgerewriten.utils.SharedPrefUtils;

public class LoginActivity extends AppCompatActivity {

    private EditText licencecode;
    public SharedPrefUtils sharedPrefUtils;

    private final TextWatcher mTextEditorWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //This sets a textview to the current length

        }

        public void afterTextChanged(Editable s) {
            if (s.length() == 8) {

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                sharedPrefUtils.writeLoginStatus(true);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPrefUtils = new SharedPrefUtils(getApplicationContext());

        if (sharedPrefUtils.readLoginStatus()) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);

            //Finishes activity after login
            finish();
        } else {
            licencecode = findViewById(R.id.edit_text_license_code);
            licencecode.addTextChangedListener(mTextEditorWatcher);
        }
    }
}