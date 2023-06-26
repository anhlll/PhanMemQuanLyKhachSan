package com.mycompany.Service;

import com.mycompany.Domainmodels.Phong;
import java.util.List;

public interface PhongService {

    public List<Phong> getAll();

    public List<Phong> getListPhongByMa(String roomNumber);

    public Phong getPhongByMa(String roomNumber);

    public String find(String ma);

    public Boolean UpdateTinhTrang(Phong p, String ma);

    public boolean Them(Phong p);

    public boolean Sua(String Ma, Phong p);

    public boolean Xoa(String id1);

    public List<Phong> loadcbb();

    public Boolean UpdateTinhTrangcontrong(Phong p, String ma);

    public List<Phong> getListPhongByTen(String ten);
}
