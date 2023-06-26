/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.Service;

import com.mycompany.Domainmodels.HoaDon;
import java.util.List;

/**
 *
 * @author HP
 */
public interface HoaDonService {
    public List<HoaDon> getAll();
    public Boolean add(HoaDon hoaDon);
    public Boolean delete(String id);
    public Boolean update(String id, HoaDon hoaDon);
    public Boolean updateTT(String id, HoaDon hoaDon);
}
