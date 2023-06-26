/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.impl;

import com.mycompany.Domainmodels.KhachHang;
import com.mycompany.Hibernate.CRUD_KhachHang;
import com.mycompany.Service.KhachHangService;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class KhachHangImp implements KhachHangService {

    private CRUD_KhachHang ck = new CRUD_KhachHang();

    @Override
    public boolean Them(KhachHang kh) {
        return ck.add(kh);
    }

    @Override
    public boolean Sua(String Ma, KhachHang khachHang) {
        return ck.update(Ma, khachHang);
    }

    @Override
    public boolean Xoa(String Ma) {
        return ck.xoa(Ma);
    }

    @Override
    public List<KhachHang> Getlist() {
        return ck.getAll();
    }

    @Override
    public String find(String ma) {
        return ck.getByID(ma);
    }

    @Override
    public List<KhachHang> getListKHByMa(String CCCD) {
        return ck.getListKHByMa(CCCD);
    }

    @Override
    public String findid(String ma) {
        return ck.getByMa(ma);
    }

    @Override
    public List<KhachHang> getListNVBySDT(String CCCD) {
        return ck.getListNvBysdt(CCCD);
    }

    @Override
    public List<KhachHang> getListNVBycccd(String CCCD) {
        return ck.getListNvBycccd(CCCD);
    }

}
