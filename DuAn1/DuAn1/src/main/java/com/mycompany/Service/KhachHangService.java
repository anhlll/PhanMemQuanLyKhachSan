package com.mycompany.Service;

import com.mycompany.Domainmodels.KhachHang;
import java.util.ArrayList;
import java.util.List;

public interface KhachHangService {

    public boolean Them(KhachHang kh);

    public boolean Sua(String Ma, KhachHang khachHang);

    public boolean Xoa(String Ma);

    public List<KhachHang> Getlist();

    public String find(String ma);

    public String findid(String ma);

    public List<KhachHang> getListKHByMa(String CCCD);

    public List<KhachHang> getListNVBySDT(String CCCD);

    public List<KhachHang> getListNVBycccd(String CCCD);
}
