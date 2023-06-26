
package com.mycompany.Domainmodels;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ThongTinHoaDon")
public class ThongTinHoaDon {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ngayTao")
    private Date ngayTao;

    @Column(name = "ngayTraPhong")
    private Date ngayTraPhong;

    @Column(name = "tinhTrang")
    private String tinhTrang;
    
    @Column(name = "TenKH")
    private String TenKhachHang;
    
    @Column(name = "Tang")
    private int tang;
    
    @Column(name = "TenPhong")
    private String tenPhong;

    @Column(name = "tongTien")
    private float tongTien;

    public ThongTinHoaDon() {
    }

    public ThongTinHoaDon(String ma, Date ngayTao, Date ngayTraPhong, String tinhTrang, String TenKhachHang, int tang, String tenPhong, float tongTien) {
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayTraPhong = ngayTraPhong;
        this.tinhTrang = tinhTrang;
        this.TenKhachHang = TenKhachHang;
        this.tang = tang;
        this.tenPhong = tenPhong;
        this.tongTien = tongTien;
    }

    public ThongTinHoaDon(String id, String ma, Date ngayTao, Date ngayTraPhong, String tinhTrang, String TenKhachHang, int tang, String tenPhong, float tongTien) {
        this.id = id;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayTraPhong = ngayTraPhong;
        this.tinhTrang = tinhTrang;
        this.TenKhachHang = TenKhachHang;
        this.tang = tang;
        this.tenPhong = tenPhong;
        this.tongTien = tongTien;
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

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayTraPhong() {
        return ngayTraPhong;
    }

    public void setNgayTraPhong(Date ngayTraPhong) {
        this.ngayTraPhong = ngayTraPhong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    
    
}
