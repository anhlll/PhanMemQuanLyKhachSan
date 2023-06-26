
package com.mycompany.Service.impl;

import com.mycompany.Domainmodels.Phong;
import com.mycompany.Hibernate.CRUD_Phong;
import java.util.List;
import com.mycompany.Service.PhongService;

public class PhongServiceimpl implements PhongService{
    private CRUD_Phong PhongRepository = new CRUD_Phong();

    @Override
    public List<Phong> getAll() {
        return PhongRepository.getAll();
    }

    @Override
    public List<Phong> getListPhongByMa(String roomNumber) {
        return PhongRepository.getListPhongByMa(roomNumber);
    }

    @Override
    public Phong getPhongByMa(String roomNumber) {
        return PhongRepository.getPhongByMa(roomNumber);
    }

    @Override
    public Boolean UpdateTinhTrang(Phong p, String ma) {
        return PhongRepository.updateTinhTrang(p, ma);
    }

    @Override
    public boolean Them(Phong p) {
        return PhongRepository.add(p);
    }

    @Override
    public boolean Sua(String Ma, Phong p) {
        return PhongRepository.update(Ma, p);
    }

    @Override
    public boolean Xoa(String id1) {
        return PhongRepository.xoa(id1);
    }

    @Override
    public List<Phong> loadcbb() {
        return PhongRepository.loadcbb();
    }

    @Override
    public String find(String ma) {
        return PhongRepository.getByID(ma);
    }

    @Override
    public Boolean UpdateTinhTrangcontrong(Phong p, String ma) {
        return PhongRepository.updateTinhTrangConTrong(p, ma);
    }

    @Override
    public List<Phong> getListPhongByTen(String ten) {
        return PhongRepository.getListPhongByTen(ten);
    }

   
}
