/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.Service;

import com.mycompany.Domainmodels.KhachHang;
import com.mycompany.Domainmodels.NguoiDung;
import com.mycompany.Domainmodels.NguoiDung;
import java.util.List;

/**
 *
 * @author HP
 */
public interface NhanVienInterface {

    public List<NguoiDung> getAll();

    public boolean Them(NguoiDung nv);

    public boolean Sua(String Ma, NguoiDung nv);

    public boolean Xoa(String Ma);

    public String find(String ma);

    public boolean checkAcc(String email, String pass);

    public List<NguoiDung> getAcc(String email, String password);

    public List<NguoiDung> getListNVByMa(String CCCD);

    public List<NguoiDung> getListNVBySDT(String CCCD);

    public List<NguoiDung> getListNVBycccd(String CCCD);

    public List<NguoiDung> getListNVByEmail(String CCCD);
}
