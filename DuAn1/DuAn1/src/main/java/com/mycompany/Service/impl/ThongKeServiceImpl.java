/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.impl;

import com.mycompany.Hibernate.CRUD_ThongKe;
import com.mycompany.Service.ThongKeService;
import com.mycompany.ViewModels.ThongKeView;
import java.util.List;

/**
 *
 * @author anhmt
 */
public class ThongKeServiceImpl implements ThongKeService{
    private CRUD_ThongKe ct = new CRUD_ThongKe();

    @Override
    public List<ThongKeView> queryByDay(String date) {
        return ct.queryByDay(date);
    }

    @Override
    public List<ThongKeView> queryByMonth(String month, String year) {
        return ct.queryByMonth(month, year);
    }

    @Override
    public List<ThongKeView> queryByYear(String year) {
        return ct.queryByYear(year);
    }
}
