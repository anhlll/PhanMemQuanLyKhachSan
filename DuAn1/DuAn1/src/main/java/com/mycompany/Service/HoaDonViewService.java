/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.Service;

import com.mycompany.Domainmodels.ThongTinHoaDon;
import java.util.List;

/**
 *
 * @author anhmt
 */
public interface HoaDonViewService {
    public List<ThongTinHoaDon> getAll() ;
    public Boolean add(ThongTinHoaDon hoaDon);
    public Boolean updateTT(String ma, ThongTinHoaDon hoaDon);
    public List<ThongTinHoaDon> getListHDVByMa(String CCCD);
}
