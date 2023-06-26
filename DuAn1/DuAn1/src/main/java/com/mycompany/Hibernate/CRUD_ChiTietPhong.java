
package com.mycompany.Hibernate;

import com.mycompany.Domainmodels.Phong;
import com.mycompany.Utilities.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ASUS
 */
public class CRUD_ChiTietPhong {
    public List<Phong> getAll(){
       Session session = HibernateUtil.getFACTORY().openSession();
        List<Phong> list = (List<Phong>) session.createCriteria(Phong.class).list();
        return list;
   }
}
