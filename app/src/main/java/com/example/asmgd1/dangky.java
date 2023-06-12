package com.example.asmgd1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class dangky extends AppCompatActivity {
    public static String Nam = "user_name";
    public static String Nhap = "passwork";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createaccount);
        Button btnLogin = findViewById(R.id.btn_login);
        Button btntv = findViewById(R.id.btntrove);

        EditText edtUsername = findViewById(R.id.edt_username);
        EditText edtPassword = findViewById(R.id.edt_password);
        EditText edtRetypePassword = findViewById(R.id.edtnhaplai);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtUsername.getText().toString();
                String pass = edtPassword.getText().toString();
                String confirm = edtRetypePassword.getText().toString();

                if (name.isEmpty() || pass.isEmpty() || confirm.isEmpty() || !pass.equals(confirm)) {
                    Toast.makeText(dangky.this, "Vui lòng điền đầy đủ thông tin và xác nhận mật khẩu", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences sharedPreferences = getSharedPreferences("abc", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Username", name);
                    editor.putString("password", pass);
                    editor.apply();

                    Intent intent = new Intent();
                    intent.putExtra(Nam, name);
                    intent.putExtra(Nhap, pass);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
        btntv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
