package com.mycompany.Hibernate;

import com.mycompany.Domainmodels.Phong;
import com.mycompany.Utilities.HibernateUtil;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class CRUD_Phong {

    public List<Phong> getAll() {
        Session session = HibernateUtil.getFACTORY().openSession();
        List<Phong> list = (List<Phong>) session.createCriteria(Phong.class).list();
        return list;
    }

    public Phong getPhongByMa(String id) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Phong p = (Phong) session.get(Phong.class, id);
        session.close();
        return p;
    }

    public List<Phong> loadcbb() {
        Session session = HibernateUtil.getFACTORY().openSession();
        List<Phong> list = (List<Phong>) session.createCriteria(Phong.class).list();
        return list;
    }

    public List<Phong> getListPhongByMa(String ma) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Criteria criteria = session.createCriteria(Phong.class);
        List<Phong> listp = criteria.add(Restrictions.eq("maPhong", ma)).list();
        return listp;
    }
    public List<Phong> getListPhongByTen(String ten) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Criteria criteria = session.createCriteria(Phong.class);
        List<Phong> listp = criteria.add(Restrictions.eq("tenPhong", ten)).list();
        return listp;
    }

    public Boolean updateTinhTrang(Phong p, String ma) {
        Transaction transac = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transac = session.beginTransaction();
            String update = "UPDATE Phong set TrangThai = :LK WHERE MaPhong = :Hello";
            Query query = session.createQuery(update);
            query.setParameter("LK", 1);
            query.setParameter("Hello", ma);
            if (query.executeUpdate() > 0) {
                transac.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean updateTinhTrangConTrong(Phong p, String ma) {
        Transaction transac = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transac = session.beginTransaction();
            String update = "UPDATE Phong set TrangThai = :LK WHERE TenPhong = :Hello";
            Query query = session.createQuery(update);
            query.setParameter("LK", 0);
            query.setParameter("Hello", ma);
            if (query.executeUpdate() > 0) {
                transac.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean add(Phong p) {
        Transaction transac = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transac = session.beginTransaction();
            session.save(p);
            transac.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xoa(String idphong) {
        Transaction transaction = null;

        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
//            String hql1 = "DELETE ThongTinThuePhong WHERE idp = :hid1";
//            Query query1 = session.createQuery(hql1);
//            query1.setParameter("hid1", idtttp);
            String hql = "DELETE Phong WHERE maPhong= :hid";
            Query query = session.createQuery(hql);
            query.setParameter("hid", idphong);
            if (query.executeUpdate() > 0) {
                transaction.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(String ma, Phong p) {
        p.setId(ma);
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(ma, p);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getByID(String ma) {
        String uuid;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            TypedQuery<String> query = session.createQuery("SELECT id FROM Phong WHERE maPhong =:ma", String.class);
            query.setParameter("ma", ma);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

}
