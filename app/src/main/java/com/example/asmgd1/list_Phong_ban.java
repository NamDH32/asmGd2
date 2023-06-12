package com.example.asmgd1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
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

import java.util.ArrayList;

public class list_Phong_ban extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listphong_ban);

        getSupportActionBar().setTitle("Phòng ban");
        //Nút quay lại
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00BCD4")));

        ListView lv_phongBan = findViewById(R.id.lv_pb);

        ArrayList<phong_banModel> arrayList = new ArrayList<>();
        arrayList.add(new phong_banModel("Nhân Sự", R.drawable.anh4));
        arrayList.add(new phong_banModel("Hành Chính", R.drawable.anh4));
        arrayList.add(new phong_banModel("Đào Tạo", R.drawable.anh4));
        AdapterPhongBan adapterPhongBan = new AdapterPhongBan(this, arrayList);
        lv_phongBan.setAdapter(adapterPhongBan);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private class AdapterPhongBan extends BaseAdapter {

        private Context ctx;
        ArrayList<phong_banModel> list;

        public AdapterPhongBan(Context ctx, ArrayList<phong_banModel> list) {
            this.ctx = ctx;
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
            LayoutInflater inflater = ((Activity) ctx).getLayoutInflater();
            view = inflater.inflate(R.layout.item_phong_ban, viewGroup, false);
            phong_banModel phongBanModel = list.get(i);

            ImageView anh = view.findViewById(R.id.iv_icon);
            TextView name = view.findViewById(R.id.txtName);

            anh.setImageResource(phongBanModel.getIcon());
            name.setText(phongBanModel.getName());
            return view;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tolbar,menu);
        MenuItem searchItem = menu.findItem(R.id.item_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }
}