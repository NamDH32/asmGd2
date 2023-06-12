package com.example.asmgd1;

import java.io.Serializable;

public class nhan_vienModel implements Serializable {
    private String maNV;
    private String ten;
    private String phongBan;

    public nhan_vienModel(String maNV, String ten, String phongBan) {
        this.maNV = maNV;
        this.ten = ten;
        this.phongBan = phongBan;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }
}
