package com.example.administrator.ghichu;

public class CongViec {
    private int idcv;
    private String tencv;

    public CongViec(int idcv, String tencv) {
        this.idcv = idcv;
        this.tencv = tencv;
    }

    public int getIdcv() {
        return idcv;
    }

    public String getTencv() {
        return tencv;
    }

    public void setIdcv(int idcv) {
        this.idcv = idcv;
    }

    public void setTencv(String tencv) {
        this.tencv = tencv;
    }
}