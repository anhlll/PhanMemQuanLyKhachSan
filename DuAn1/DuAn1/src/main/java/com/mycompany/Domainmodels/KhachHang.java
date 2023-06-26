/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Domainmodels;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "KhachHang")
public class KhachHang implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "HoVaTen")
    private String hoVaTen;

    @Column(name = "gioiTinh")
    private String gioiTinh;

    @Column(name = "ngaySinh")
    private Date ngaySinh;

    @Column(name = "Sdt")
    private String sDT;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "sCCCD")
    private String sCCCD;
    
    @OneToMany(mappedBy = "khachHang")
    private List<HoaDon> listHD;

    public KhachHang() {
    }

    public KhachHang(String id, String ma, String hoVaTen, String gioiTinh, Date ngaySinh, String sDT, String diaChi, String sCCCD, List<HoaDon> listHD) {
        this.id = id;
        this.ma = ma;
        this.hoVaTen = hoVaTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sDT = sDT;
        this.diaChi = diaChi;
        this.sCCCD = sCCCD;
        this.listHD = listHD;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getsCCCD() {
        return sCCCD;
    }

    public void setsCCCD(String sCCCD) {
        this.sCCCD = sCCCD;
    }

    public List<HoaDon> getListHD() {
        return listHD;
    }

    public void setListHD(List<HoaDon> listHD) {
        this.listHD = listHD;
    }

   

    @Override
    public String toString() {
        return ma;
    }

}
