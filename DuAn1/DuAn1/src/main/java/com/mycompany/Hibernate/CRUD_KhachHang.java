/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Hibernate;

import com.mycompany.Domainmodels.KhachHang;
import com.mycompany.Domainmodels.Phong;
import com.mycompany.Utilities.HibernateUtil;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ASUS
 */
public class CRUD_KhachHang {

    public List<KhachHang> getAll() {
        Session session = HibernateUtil.getFACTORY().openSession();
        List<KhachHang> list = (List<KhachHang>) session.createCriteria(KhachHang.class).list();
        return list;
    }

    public boolean add(KhachHang kh) {
        Transaction transac = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transac = session.beginTransaction();
            session.save(kh);
            transac.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xoa(String id) {
        Transaction transaction = null;

        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE khachhang WHERE id = :hid";
            Query query = session.createQuery(hql);
            query.setParameter("hid", id);
            if (query.executeUpdate() > 0) {
                transaction.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(String ma, KhachHang kh) {
        kh.setId(ma);
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(ma, kh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public String getByID(String sccc) {
        String uuid;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            TypedQuery<String> query = session.createQuery("SELECT ma FROM KhachHang WHERE sCCCD =:sccc", String.class);
            query.setParameter("sccc", sccc);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
     public String getByMa(String ma) {
        String uuid;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            TypedQuery<String> query = session.createQuery("SELECT id FROM KhachHang WHERE ma =:ma", String.class);
            query.setParameter("ma", ma);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public List<KhachHang> getListKHByMa(String ma) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Criteria criteria = session.createCriteria(KhachHang.class);
        List<KhachHang> listp = criteria.add(Restrictions.eq("ma", ma)).list();
        return listp;
    }

    public List<KhachHang> getListNvBysdt(String CCCD) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Criteria criteria = session.createCriteria(KhachHang.class);
        List<KhachHang> listp = criteria.add(Restrictions.eq("sDT", CCCD)).list();
        return listp;
    }

    public List<KhachHang> getListNvBycccd(String CCCD) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Criteria criteria = session.createCriteria(KhachHang.class);
        List<KhachHang> listp = criteria.add(Restrictions.eq("sCCCD", CCCD)).list();
        return listp;
    }
}
