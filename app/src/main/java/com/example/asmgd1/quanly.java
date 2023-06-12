package com.example.asmgd1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class quanly extends AppCompatActivity {
    LinearLayout lin_phongBan, lin_nhanVien, lin_thoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qlynhansu);
        lin_phongBan = findViewById(R.id.lin_phongBan);
        lin_nhanVien = findViewById(R.id.lin_nhanvien);
        lin_thoat = findViewById(R.id.lin_thoat);

        lin_phongBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(quanly.this, list_Phong_ban.class);
                startActivity(intent);
            }
        });

        lin_nhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(quanly.this, list_Nhan_vien.class);
                startActivity(intent);
            }
        });
        lin_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(quanly.this, dangnhap.class);
                startActivity(intent);
            }
        });

    }
}
