/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Hibernate;

import com.mycompany.Domainmodels.PhanQuyen;
import com.mycompany.Utilities.HibernateUtil;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author anhmt
 */
public class CRUD_PhanQuyen {
    public List<PhanQuyen> getAll() {
        Session session = HibernateUtil.getFACTORY().openSession();
        List<PhanQuyen> list = (List<PhanQuyen>) session.createCriteria(PhanQuyen.class).list();
        return list;
    }

    public boolean add(PhanQuyen kh) {
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
            String hql = "DELETE PhanQuyen WHERE MaQuyen = :hid";
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

    public boolean update(String ma, PhanQuyen kh) {
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
}
