/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.Service;

import com.mycompany.ViewModels.ThongKeView;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface ThongKeService {
    public List<ThongKeView> queryByDay(String date);
    public List<ThongKeView> queryByMonth(String month, String year);
    public List<ThongKeView> queryByYear(String year);
}
