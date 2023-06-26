/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.impl;

import com.mycompany.Domainmodels.HoaDon;
import com.mycompany.Hibernate.CRUD_HoaDon;
import java.util.List;
import com.mycompany.Service.HoaDonService;

/**
 *
 * @author HP
 */
public class HoaDonimpl implements HoaDonService{

    private CRUD_HoaDon cRUD_HoaDon = new CRUD_HoaDon();
    @Override
    public List<HoaDon> getAll() {
        return cRUD_HoaDon.getAll();
    }

    @Override
    public Boolean add(HoaDon hoaDon) {
        return cRUD_HoaDon.add(hoaDon);
    }

    @Override
    public Boolean delete(String id) {
        return cRUD_HoaDon.delete(id);
    }

    @Override
    public Boolean update(String id, HoaDon hoaDon) {
        return cRUD_HoaDon.update(id, hoaDon);
    }

    @Override
    public Boolean updateTT(String id, HoaDon hoaDon) {
        return cRUD_HoaDon.updateTT(id, hoaDon);
    }
    
}
