/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Hibernate;

import com.mycompany.Domainmodels.NguoiDung;
import com.mycompany.Utilities.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author HP
 */
public class CRUD_NhanVien {

    public List<NguoiDung> getAll() {
        Session session = HibernateUtil.getFACTORY().openSession();
        List<NguoiDung> list = (List<NguoiDung>) session.createCriteria(NguoiDung.class).list();
        return list;
    }

    public boolean add(NguoiDung nv) {
        Transaction transac = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transac = session.beginTransaction();
            session.save(nv);
            transac.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(String id) {
        Transaction transac = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transac = session.beginTransaction();
            String hql = "DELETE NguoiDung WHERE ma = :hid";
            org.hibernate.query.Query query = session.createQuery(hql);
            query.setParameter("hid", id);
            if (query.executeUpdate() > 0) {
                transac.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(String ma, NguoiDung nv) {
        nv.setId(ma);
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(ma, nv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

//      public String getByIDKH = ("SELECT gh.id FROM GioHang gh WHERE gh.khachHang.id =: id");
//    public String getByIDNV = ("SELECT gh.id FROM GioHang gh WHERE gh.idNV =: id");
    public String getByID(String ma) {
        String uuid;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            TypedQuery<String> query = session.createQuery("SELECT id FROM NguoiDung WHERE ma =:ma", String.class);
            query.setParameter("ma", ma);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public boolean checkAcc(String email, String password) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("From NguoiDung Where Email =: email and Password =: password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        List<NguoiDung> list = query.getResultList();
        if (list.isEmpty()) {
            return false;
        }
        return true;
    }

    public List<NguoiDung> getAccND(String email, String password) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("From NguoiDung Where Email =: email and Password =: password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        List<NguoiDung> list = query.getResultList();
        return list;
    }

    public List<NguoiDung> getListNvByMa(String CCCD) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Criteria criteria = session.createCriteria(NguoiDung.class);
        List<NguoiDung> listp = criteria.add(Restrictions.eq("ma", CCCD)).list();
        return listp;
    }

    public List<NguoiDung> getListNvBysdt(String CCCD) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Criteria criteria = session.createCriteria(NguoiDung.class);
        List<NguoiDung> listp = criteria.add(Restrictions.eq("sdt", CCCD)).list();
        return listp;
    }

    public List<NguoiDung> getListNvBycccd(String CCCD) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Criteria criteria = session.createCriteria(NguoiDung.class);
        List<NguoiDung> listp = criteria.add(Restrictions.eq("cCCD", CCCD)).list();
        return listp;
    }

    public List<NguoiDung> getListNvByemail(String CCCD) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Criteria criteria = session.createCriteria(NguoiDung.class);
        List<NguoiDung> listp = criteria.add(Restrictions.eq("email", CCCD)).list();
        return listp;
    }
}
