/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Hibernate;

import com.mycompany.Utilities.HibernateUtil;
import com.mycompany.ViewModels.ThongKeView;
import java.util.Collections;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.mapping.Collection;
import org.hibernate.transform.Transformers;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

/**
 *
 * @author DELL
 */
public class CRUD_ThongKe {
    public List<ThongKeView> queryByDay(String date) {
        String sql = "SELECT CAST(ngayTao as DATE) as ngay, COUNT(id) AS soHoaDon, SUM(tongTien) AS tongTien"
                + " FROM ThongTinHoaDon WHERE tinhTrang = 'Da thanh toan' AND CAST(ngayTao As Date) = '" + date + "'"
                + " group by CAST(ngayTao as DATE)";
        Session session = HibernateUtil.getFACTORY().openSession();
        List<ThongKeView> results = session.createSQLQuery(sql)
                                    .addScalar("ngay", new StringType())
                                    .addScalar("soHoaDon", new IntegerType())
                                    .addScalar("tongTien", new FloatType())
                                    .setResultTransformer(Transformers.aliasToBean(ThongKeView.class))
                                    .list();
        return results;
    }
    
    public List<ThongKeView> queryByMonth(String month, String year) {
        String startDate = year + "-" + month + "-01 00:00:00.000";
        String endDate = year + "-" + month + "-" + maxDateOfMonth(month) + " 23:59:59.000";
        String sql = "SELECT CAST(ngayTao as DATE) as ngay, COUNT(id) AS soHoaDon, SUM(tongTien) AS tongTien"
                + " FROM ThongTinHoaDon WHERE tinhTrang = 'Da thanh toan' AND ngayTao BETWEEN '" + startDate + "' AND '" + endDate + "'"
                + " group by CAST(ngayTao as DATE)";
        Session session = HibernateUtil.getFACTORY().openSession();
        List<ThongKeView> results = session.createSQLQuery(sql)
                                    .addScalar("ngay", new StringType())
                                    .addScalar("soHoaDon", new IntegerType())
                                    .addScalar("tongTien", new FloatType())
                                    .setResultTransformer(Transformers.aliasToBean(ThongKeView.class))
                                    .list();
        return results;
    }
    
    public List<ThongKeView> queryByYear(String year) {
        String startDate = year + "-01-01 00:00:00.000";
        String endDate = year + "-12-31 23:59:59.000";
        String sql = "SELECT CAST(ngayTao as DATE) as ngay, COUNT(id) AS soHoaDon, SUM(tongTien) AS tongTien"
                + " FROM ThongTinHoaDon WHERE tinhTrang = 'Da thanh toan' AND ngayTao BETWEEN '" + startDate + "' AND '" + endDate + "'"
                + " group by CAST(ngayTao as DATE)";
        Session session = HibernateUtil.getFACTORY().openSession();
        List<ThongKeView> results = session.createSQLQuery(sql)
                                    .addScalar("ngay", new StringType())
                                    .addScalar("soHoaDon", new IntegerType())
                                    .addScalar("tongTien", new FloatType())
                                    .setResultTransformer(Transformers.aliasToBean(ThongKeView.class))
                                    .list();
        return results;
    }
    public static void main(String[] args) {
        List<ThongKeView> listTKView = new CRUD_ThongKe().queryByYear("2021");
        for(ThongKeView tk:listTKView) {
            System.out.println(listTKView.toString());
        }
    }
    
    private String maxDateOfMonth(String month) {
        switch (month) {
            case "1":
                return "31";
            case "2":
                return "28";
            case "3":
                return "31";
            case "4":
                return "30";
            case "5":
                return "31";
            case "6":
                return "30";
            case "7":
                return "31";
            case "8":
                return "31";
            case "9":
                return "30";
            case "10":
                return "31";
            case "11":
                return "30";
            case "12":
                return "31";
        }
        return "30";
    }
}
