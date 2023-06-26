/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Hibernate;

import com.mycompany.Domainmodels.HoaDon;
import com.mycompany.Utilities.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;

/**
 *
 * @author HP
 */
public class CRUD_HoaDon {

    public List<HoaDon> getAll() {
        Session session = HibernateUtil.getFACTORY().openSession();
        List<HoaDon> list = (List<HoaDon>) session.createCriteria(HoaDon.class).list();
        return list;
    }

    public Boolean add(HoaDon hoaDon) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(hoaDon);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(String id) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {

            transaction = session.beginTransaction();
            String hql = "Delete from HoaDon where id = :Hello";
            Query query = session.createQuery(hql);
            query.setParameter("Hello", id);
            if (query.executeUpdate() > 0) {
                transaction.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(String id, HoaDon hoaDon) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String hql = "Update HoaDon set  ngayTao = :NT,ngayTraPhong = :NTP, tinhTrang = :TT, khachHang = :TKH, tongTien = :ST where id = :Hello";
            Query query = session.createQuery(hql);
            query.setParameter("NT", hoaDon.getNgayTao());
            query.setParameter("NTP", hoaDon.getNgayTraPhong());
            query.setParameter("TT", hoaDon.getTinhTrang());
            query.setParameter("TKH", hoaDon.getKhachHang());
            query.setParameter("ST", hoaDon.getTongTien());
            query.setParameter("Hello", id);
            if (query.executeUpdate() > 0) {
                transaction.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean updateTT(String ma, HoaDon hoaDon) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String hql = "Update HoaDon set  tinhTrang = :TT where ma = :Hello";
            Query query = session.createQuery(hql);

            query.setParameter("TT", "Da thanh toan");

            query.setParameter("Hello", ma);
            if (query.executeUpdate() > 0) {
                transaction.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
