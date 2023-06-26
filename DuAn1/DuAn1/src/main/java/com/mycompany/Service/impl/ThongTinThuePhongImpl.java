
package com.mycompany.Service.impl;

import com.mycompany.Domainmodels.ThongTinThuePhong;
import com.mycompany.Hibernate.CRUD_ThongTinThuePhong;
import com.mycompany.Service.ThongTinThuePhongInterface;
import java.sql.Date;
import java.util.List;


public class ThongTinThuePhongImpl implements ThongTinThuePhongInterface {

    private final CRUD_ThongTinThuePhong ct = new CRUD_ThongTinThuePhong();
    @Override
    public List<ThongTinThuePhong> getAll() {
        return ct.getAll();
    }

    @Override
    public Boolean add(ThongTinThuePhong tttp) {
        return ct.add(tttp);
    }

    @Override
    public Boolean delete(String id) {
        return ct.xoa(id);
    }

    @Override
    public Boolean update(String id, ThongTinThuePhong tttp) {

        return ct.update(id, tttp);
    }

    @Override
    public boolean xoaByIdKH(String id) {
        return ct.xoaByIdKH(id);
    }


}
