package com.example.asmgd1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class add_nhanVien extends AppCompatActivity {
    EditText edt_maNV;
    EditText edt_ten;
    EditText edt_phongBan;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_nv);
        TextView txtTitle = findViewById(R.id.txt_title);
        edt_maNV = findViewById(R.id.edt_maNV);
        edt_ten = findViewById(R.id.edt_ten);
        edt_phongBan = findViewById(R.id.edt_phongBan);
        btn_submit = findViewById(R.id.btn_sumbit);

        boolean isaddNv = getIntent().getBooleanExtra(list_Nhan_vien.Key_Add, false);
        if(isaddNv){
            txtTitle.setText("Thêm Nhân Viên");
        }else{
            txtTitle.setText("Sửa Nhân Viên");
        }

        nhan_vienModel nhanVienModel = (nhan_vienModel) getIntent().getSerializableExtra("data");

        if(nhanVienModel !=null){
            edt_maNV.setText(nhanVienModel.getMaNV());
            edt_ten.setText(nhanVienModel.getTen());
            edt_phongBan.setText(nhanVienModel.getPhongBan());
        }
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String maNv = edt_maNV.getText().toString();
                String ten = edt_ten.getText().toString();
                String pb = edt_phongBan.getText().toString();
                nhan_vienModel nhanVienModel = new nhan_vienModel(maNv,ten,pb);
                intent.putExtra("data",nhanVienModel);
                setResult(1, intent);
                finish();
            }
        });

    }
}