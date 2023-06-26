/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Hibernate;

import com.mycompany.Domainmodels.DichVuDung;
import com.mycompany.Utilities.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author ASUS
 */
public class CRUD_DichVuDung {

    public List<DichVuDung> getAll() {
        Session session = HibernateUtil.getFACTORY().openSession();
        List<DichVuDung> list = (List<DichVuDung>) session.createCriteria(DichVuDung.class).list();
        return list;
    }

    public boolean add(DichVuDung dvd) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(dvd);
            transaction.commit();
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
            String hql = "DELETE DichVuDung WHERE IdPhong = :hid";
            Query query = session.createQuery(hql);
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
}
