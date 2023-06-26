/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.impl;

import com.mycompany.Domainmodels.DichVuDung;
import com.mycompany.Hibernate.CRUD_DichVuDung;
import com.mycompany.Service.DichVuDungService;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DichVuDungServiceImp implements DichVuDungService{

    private CRUD_DichVuDung cd = new CRUD_DichVuDung();
    
    @Override
    public List<DichVuDung> getAll() {
        return cd.getAll();
    }

    @Override
    public Boolean add(DichVuDung dvd) {
        return cd.add(dvd);
    }

    @Override
    public Boolean delete(String id) {
        return cd.delete(id);
    }
    
}
