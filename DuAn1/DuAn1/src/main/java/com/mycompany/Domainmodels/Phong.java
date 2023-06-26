/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Domainmodels;

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
import org.hibernate.annotations.ManyToAny;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "Phong")
public class Phong {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

    @Column(name = "MaPhong")
    private String maPhong;

    @Column(name = "TenPhong")
    private String tenPhong;

    @Column(name = "Tang")
    private int tang;

    @Column(name = "SoGiuong")
    private int soGiuong;

    @Column(name = "LoaiPhong")
    private String loaiPhong;

    @Column(name = "TrangThai")
    private Boolean trangThai;

    @Column(name = "GiaTheoNgay")
    private float giaTheoNgay;

    @Column(name = "GiaTheoGio")
    private float giaTheoGio;

    @Column(name = "SoNguoiToiDa")
    private int soNguoiToiDa;

    @OneToMany(mappedBy = "phong")
    private List<ThongTinThuePhong> listTTTP;

    @OneToMany(mappedBy = "phong")
    private List<DichVuDung> listdvd;

    public Phong() {
    }

    public Phong(String id, String maPhong, String tenPhong, int tang, int soGiuong, String loaiPhong, Boolean trangThai, float giaTheoNgay, float giaTheoGio, int soNguoiToiDa, List<ThongTinThuePhong> listTTTP, List<DichVuDung> listdvd) {
        this.id = id;
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.tang = tang;
        this.soGiuong = soGiuong;
        this.loaiPhong = loaiPhong;
        this.trangThai = trangThai;
        this.giaTheoNgay = giaTheoNgay;
        this.giaTheoGio = giaTheoGio;
        this.soNguoiToiDa = soNguoiToiDa;
        this.listTTTP = listTTTP;
        this.listdvd = listdvd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public int getSoGiuong() {
        return soGiuong;
    }

     public void setSoGiuong(int soGiuong) {
        this.soGiuong = soGiuong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public float getGiaTheoNgay() {
        return giaTheoNgay;
    }

    public void setGiaTheoNgay(float giaTheoNgay) {
        this.giaTheoNgay = giaTheoNgay;
    }

    public float getGiaTheoGio() {
        return giaTheoGio;
    }

    public void setGiaTheoGio(float giaTheoGio) {
        this.giaTheoGio = giaTheoGio;
    }

    public int getSoNguoiToiDa() {
        return soNguoiToiDa;
    }

    public void setSoNguoiToiDa(int soNguoiToiDa) {
        this.soNguoiToiDa = soNguoiToiDa;
    }

    public List<ThongTinThuePhong> getListTTTP() {
        return listTTTP;
    }

    public void setListTTTP(List<ThongTinThuePhong> listTTTP) {
        this.listTTTP = listTTTP;
    }

    public List<DichVuDung> getListdvd() {
        return listdvd;
    }

    public void setListdvd(List<DichVuDung> listdvd) {
        this.listdvd = listdvd;
    }

    public String TrangThaiPhong(){
        if(trangThai == false){
            return "Con Trong";
        }
        return "Da thue";
    }

    @Override
    public String toString() {
        return tenPhong;
    }
    
}