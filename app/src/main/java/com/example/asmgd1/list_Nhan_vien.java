package com.example.asmgd1;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class list_Nhan_vien extends AppCompatActivity {
    public static final String Key_Add = "add_NV";
    TextView txt_add;
    ArrayList<nhan_vienModel> arrayList = new ArrayList<>();
    AdapterNhanVien adapterNhanVien;
    int index = -1;
    ActivityResultLauncher<Intent> addData = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    nhan_vienModel nhanVienModel = (nhan_vienModel) result.getData().getSerializableExtra("data");
                    arrayList.add(nhanVienModel);
                    adapterNhanVien.notifyDataSetChanged();
                }
            }
    );
    ActivityResultLauncher<Intent> updateData = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    nhan_vienModel nhanVienModel = (nhan_vienModel) result.getData().getSerializableExtra("data");
                    arrayList.set(index, nhanVienModel);
                    adapterNhanVien.notifyDataSetChanged();
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_nhan_vien);


        getSupportActionBar().setTitle("Nhân Viên");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00BCD4")));

        ListView lv_NV = findViewById(R.id.lv_nv);

        arrayList.add(new nhan_vienModel("NV001", "Phạm Tiến Minh", "Nhân Sự"));
        arrayList.add(new nhan_vienModel("NV002", "Đinh Hoài Nam", "Hành Chính"));
        arrayList.add(new nhan_vienModel("NV003", "Tống Doanh Chính", "Đào Tạo"));
        arrayList.add(new nhan_vienModel("NV004", "Lê Mạnh Quỳnh", "Nhân Sự"));
        arrayList.add(new nhan_vienModel("NV002", "Phùng Quang Dũng", "Đào Tạo"));
        txt_add = findViewById(R.id.txt_themNv);
        adapterNhanVien = new AdapterNhanVien(this, arrayList);
        lv_NV.setAdapter(adapterNhanVien);
        txt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(list_Nhan_vien.this, add_nhanVien.class);
                intent.putExtra(Key_Add,true);
                addData.launch(intent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class AdapterNhanVien extends BaseAdapter {

        private Context ctc;
        ArrayList<nhan_vienModel> list;

        public AdapterNhanVien(Context ctc, ArrayList<nhan_vienModel> list) {
            this.ctc = ctc;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = ((Activity) ctc).getLayoutInflater();
            view = inflater.inflate(R.layout.item_nhan_vien, viewGroup, false);


            nhan_vienModel nhanVienModel = list.get(i);

            TextView maNV = view.findViewById(R.id.txt_maNv);
            TextView ten = view.findViewById(R.id.txt_ten);
            TextView phongBan = view.findViewById(R.id.txt_phong_ban);

            maNV.setText(nhanVienModel.getMaNV());
            ten.setText(nhanVienModel.getTen());
            phongBan.setText(nhanVienModel.getPhongBan());


            ImageView imgUpdate = view.findViewById(R.id.img_sua);
            ImageView imgDelete = view.findViewById(R.id.img_xoaNV);
            imgUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    index = i;
                    getIntent().putExtra(Key_Add,false);
                    Intent intent = new Intent(getApplicationContext(), add_nhanVien.class);
                    intent.putExtra("data", arrayList.get(i));
                    updateData.launch(intent);
                }
            });
            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(i);
                    notifyDataSetChanged();
                }
            });
            return view;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tolbar, menu);
        MenuItem searchItem = menu.findItem(R.id.item_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        //xử lý sự kiện khi người dùng tìm kiếm
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //xử lí khi người dùng ấn nút tìm kiếm trên bàn phím
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                //xử lý khi người dùng thay đổi tìm kiếm
                //có thể lọc danh sách nhân viên
                return true;
            }
        });
        return true;
    }
}
