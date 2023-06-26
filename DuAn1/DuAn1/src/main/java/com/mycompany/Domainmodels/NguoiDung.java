/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Domainmodels;

import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "NguoiDung")
public class NguoiDung {

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
    
    @Column(name = "sdt")
    private String sdt;
    
    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "CCCD")
    private String cCCD;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name = "Password")
    private String passWord;
    
    @OneToMany(mappedBy = "nhanVien")
    private List<HoaDon> listHD;
    
    @ManyToOne
    @JoinColumn(name = "IdPhanQuyen")
    private PhanQuyen phanQuyen;

    public NguoiDung() {
    }

    public NguoiDung(String id, String ma, String hoVaTen, String gioiTinh, Date ngaySinh, String sdt, String diaChi, String cCCD, String email, String passWord, List<HoaDon> listHD, PhanQuyen phanQuyen) {
        this.id = id;
        this.ma = ma;
        this.hoVaTen = hoVaTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.cCCD = cCCD;
        this.email = email;
        this.passWord = passWord;
        this.listHD = listHD;
        this.phanQuyen = phanQuyen;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getcCCD() {
        return cCCD;
    }

    public void setcCCD(String cCCD) {
        this.cCCD = cCCD;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List<HoaDon> getListHD() {
        return listHD;
    }

    public void setListHD(List<HoaDon> listHD) {
        this.listHD = listHD;
    }

    public PhanQuyen getPhanQuyen() {
        return phanQuyen;
    }

    public void setPhanQuyen(PhanQuyen phanQuyen) {
        this.phanQuyen = phanQuyen;
    }

  
    
}
