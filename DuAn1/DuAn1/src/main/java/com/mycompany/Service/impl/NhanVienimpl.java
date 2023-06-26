/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.impl;

import com.mycompany.Domainmodels.KhachHang;
import com.mycompany.Domainmodels.NguoiDung;
import com.mycompany.Hibernate.CRUD_NhanVien;
import com.mycompany.Service.NhanVienInterface;
import java.util.List;

/**
 *
 * @author HP
 */
public class NhanVienimpl implements NhanVienInterface {

    private CRUD_NhanVien cRUD_NhanVien = new CRUD_NhanVien();

    @Override
    public List<NguoiDung> getAll() {
        return cRUD_NhanVien.getAll();
    }

    @Override
    public boolean Them(NguoiDung nv) {
        return cRUD_NhanVien.add(nv);
    }

    @Override
    public boolean Sua(String Ma, NguoiDung nv) {
        return cRUD_NhanVien.update(Ma, nv);
    }

    @Override
    public boolean Xoa(String Ma) {
        return cRUD_NhanVien.delete(Ma);
    }

    @Override
    public String find(String ma) {
        return cRUD_NhanVien.getByID(ma);
    }

    @Override
    public boolean checkAcc(String email, String pass) {
        return cRUD_NhanVien.checkAcc(email, pass);
    }

    @Override
    public List<NguoiDung> getAcc(String email, String password) {
        return cRUD_NhanVien.getAccND(email, password);
    }
    @Override
    public List<NguoiDung> getListNVByMa(String CCCD) {
        return cRUD_NhanVien.getListNvByMa(CCCD);
    }

    @Override
    public List<NguoiDung> getListNVBySDT(String CCCD) {
        return cRUD_NhanVien.getListNvBysdt(CCCD);
    }

    @Override
    public List<NguoiDung> getListNVBycccd(String CCCD) {
        return cRUD_NhanVien.getListNvBycccd(CCCD);
    }

    @Override
    public List<NguoiDung> getListNVByEmail(String CCCD) {
        return cRUD_NhanVien.getListNvByemail(CCCD);
    }
}
