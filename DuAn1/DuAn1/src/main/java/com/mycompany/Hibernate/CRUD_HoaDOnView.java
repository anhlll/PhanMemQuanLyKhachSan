
package com.mycompany.Hibernate;

import com.mycompany.Domainmodels.ThongTinHoaDon;
import com.mycompany.Utilities.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;


public class CRUD_HoaDOnView {
    public List<ThongTinHoaDon> getAll() {
        Session session = HibernateUtil.getFACTORY().openSession();
        List<ThongTinHoaDon> list = (List<ThongTinHoaDon>) session.createCriteria(ThongTinHoaDon.class).list();
        return list;
    }

    public Boolean add(ThongTinHoaDon hoaDon) {
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
    
    public Boolean updateTT(String ma, ThongTinHoaDon hoaDon) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String hql = "Update ThongTinHoaDon set  tinhTrang = :TT where ma = :Hello";
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
    public List<ThongTinHoaDon> getListByMa(String CCCD) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Criteria criteria = session.createCriteria(ThongTinHoaDon.class);
        List<ThongTinHoaDon> listp = criteria.add(Restrictions.eq("ma", CCCD)).list();
        return listp;
    }
}
