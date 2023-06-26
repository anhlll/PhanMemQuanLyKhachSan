/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.impl;

import com.mycompany.Domainmodels.ThongTinHoaDon;
import com.mycompany.Hibernate.CRUD_HoaDOnView;
import com.mycompany.Service.HoaDonViewService;

import java.util.List;

/**
 *
 * @author anhmt
 */
public class HoaDonViewServiceImpl implements HoaDonViewService {

    private CRUD_HoaDOnView hoaDOnCRUD = new CRUD_HoaDOnView();

    @Override
    public List<ThongTinHoaDon> getAll() {
        return hoaDOnCRUD.getAll();
    }

    @Override
    public Boolean add(ThongTinHoaDon hoaDon) {
        return hoaDOnCRUD.add(hoaDon);
    }

    @Override
    public Boolean updateTT(String ma, ThongTinHoaDon hoaDon) {
        return hoaDOnCRUD.updateTT(ma, hoaDon);
    }

    @Override
    public List<ThongTinHoaDon> getListHDVByMa(String CCCD) {
        return hoaDOnCRUD.getListByMa(CCCD);
    }

}
