
package com.mycompany.Hibernate;

import com.mycompany.Domainmodels.Phong;
import com.mycompany.Domainmodels.ThongTinThuePhong;
import com.mycompany.Utilities.HibernateUtil;
import java.sql.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class CRUD_ThongTinThuePhong {

    public List<ThongTinThuePhong> getAll() {
        Session session = HibernateUtil.getFACTORY().openSession();
        List<ThongTinThuePhong> list = session.createCriteria(ThongTinThuePhong.class).list();
        return list;
    }

    public boolean xoa(String id) {
        Transaction transaction = null;
        
         try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE ThongTinThuePhong WHERE IdPhong = :hid";
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

    public boolean add(ThongTinThuePhong tttp) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(tttp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(String id, ThongTinThuePhong tttp) {
        tttp.setId(id);
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(id, tttp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean xoaByIdKH(String id) {
        Transaction transaction = null;
        
         try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE ThongTinThuePhong WHERE IdKH = :hid";
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
}
