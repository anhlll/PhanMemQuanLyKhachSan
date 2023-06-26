/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ViewModels;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class ThongKeView {
    private String ngay;
    private int soHoaDon;
    private float tongTien;

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public int getSoHoaDon() {
        return soHoaDon;
    }

    public void setSoHoaDon(int soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "ThongKeView{" + "ngay=" + ngay + ", soHoaDon=" + soHoaDon + ", tongTien=" + tongTien + '}';
    }

   
    
}
