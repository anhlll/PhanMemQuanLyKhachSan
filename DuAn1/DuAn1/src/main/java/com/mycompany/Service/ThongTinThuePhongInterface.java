/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.Service;

import com.mycompany.Domainmodels.Phong;
import com.mycompany.Domainmodels.ThongTinThuePhong;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ThongTinThuePhongInterface {
    public List<ThongTinThuePhong> getAll();
    public Boolean add(ThongTinThuePhong tttp);
    public Boolean delete(String id);
    public Boolean update(String id, ThongTinThuePhong tttp);
    public boolean xoaByIdKH(String id);
}
