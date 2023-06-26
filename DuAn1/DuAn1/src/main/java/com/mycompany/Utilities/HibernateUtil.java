
package com.mycompany.Utilities;

import com.mycompany.Domainmodels.DichVu;
import com.mycompany.Domainmodels.DichVuDung;
import com.mycompany.Domainmodels.HoaDon;
import com.mycompany.Domainmodels.ThongTinHoaDon;
import com.mycompany.Domainmodels.KhachHang;
import com.mycompany.Domainmodels.Phong;
import com.mycompany.Domainmodels.NguoiDung;
import com.mycompany.Domainmodels.PhanQuyen;
import com.mycompany.Domainmodels.Phong;
import com.mycompany.Domainmodels.ThongTinThuePhong;
import org.hibernate.cfg.Configuration;
import java.util.Properties;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

/**
 *
 * @author HP
 */
public class HibernateUtil {

    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=DuAn1");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "son2012003");
        properties.put(Environment.SHOW_SQL, "true");
//        gen DB tự động
//        properties.put(Environment.HBM2DDL_AUTO, "create");

        conf.setProperties(properties);
        conf.addAnnotatedClass(NguoiDung.class);
        conf.addAnnotatedClass(Phong.class);
        conf.addAnnotatedClass(ThongTinThuePhong.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(DichVu.class);
        conf.addAnnotatedClass(DichVuDung.class);
        conf.addAnnotatedClass(ThongTinHoaDon.class);
        conf.addAnnotatedClass(PhanQuyen.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        getFACTORY();
    }
}
