package com.mycompany.Domainmodels;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "HoaDon")
public class HoaDon {

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

    @Column(name = "tongTien")
    private float tongTien;

    @ManyToOne
    @JoinColumn(name = "IdTTTP")
    private ThongTinThuePhong thongTinThuePhong;
    
    @ManyToOne
    @JoinColumn(name = "IdKH")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "IdNguoiDung")
    private NguoiDung nhanVien;

    public HoaDon() {
    }

    public HoaDon(String id, String ma, Date ngayTao, Date ngayTraPhong, String tinhTrang, float tongTien, ThongTinThuePhong thongTinThuePhong, KhachHang khachHang, NguoiDung nhanVien) {
        this.id = id;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayTraPhong = ngayTraPhong;
        this.tinhTrang = tinhTrang;
        this.tongTien = tongTien;
        this.thongTinThuePhong = thongTinThuePhong;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
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

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public ThongTinThuePhong getThongTinThuePhong() {
        return thongTinThuePhong;
    }

    public void setThongTinThuePhong(ThongTinThuePhong thongTinThuePhong) {
        this.thongTinThuePhong = thongTinThuePhong;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NguoiDung getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NguoiDung nhanVien) {
        this.nhanVien = nhanVien;
    }

    

    

    public HoaDon(String ma) {
        this.ma = ma;
    }

}
