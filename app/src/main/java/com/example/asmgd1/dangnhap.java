package com.example.asmgd1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class dangnhap extends AppCompatActivity {
    Button btnlogin, btnRegister;
    EditText edtUsername, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        btnlogin = findViewById(R.id.btn_dangnhap);
        btnRegister = findViewById(R.id.btn_register);

        edtUsername = findViewById(R.id.edt_name);
        edtPassword = findViewById(R.id.edt_pass);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(dangnhap.this, "Vui lòng nhập tên người dùng và mật khẩu", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences sharedPreferences = getSharedPreferences("abc", MODE_PRIVATE);
                    String storedUsername = sharedPreferences.getString("Username", "");
                    String storedPassword = sharedPreferences.getString("password", "");

                    if (username.equals(storedUsername) && password.equals(storedPassword)) {
                        Intent intent = new Intent(dangnhap.this, quanly.class);
                        startActivity(intent);
                        Toast.makeText(dangnhap.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(dangnhap.this, "Tên người dùng hoặc mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

// Xóa phần lấy dữ liệu từ Intent
// ...

// Đảm bảo requestCode của startActivityForResult là một giá trị duy nhất
        final int REQUEST_CODE_REGISTER = 1;

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangnhap.this, dangky.class);
                startActivityForResult(intent, REQUEST_CODE_REGISTER);
            }
        });
    }
}
