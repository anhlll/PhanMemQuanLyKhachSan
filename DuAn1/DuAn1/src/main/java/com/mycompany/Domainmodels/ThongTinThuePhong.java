
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
@Table(name = "ThongTinThuePhong")
public class ThongTinThuePhong {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

    @Column(name = "thoiGianThue")
    private Date thoiGianThue;

    @Column(name = "thoiGianTra")
    private Date thoiGianTra;

    @Column(name = "hinhThucThue")
    private String hinhThucThue;

    @Column(name = "soNguoi")
    private Integer soNguoi;

    @OneToMany(mappedBy = "thongTinThuePhong")
    private List<HoaDon> ListHD;
    
    @ManyToOne
    @JoinColumn(name = "IdPhong")
    private Phong phong;

    @OneToMany(mappedBy = "phong")
    private List<ThongTinThuePhong> listTTTP;
    
    @ManyToOne
    @JoinColumn(name = "IdKH")
    private KhachHang khachHang;
    
    public ThongTinThuePhong() {
    }

    public ThongTinThuePhong(String id, Date thoiGianThue, Date thoiGianTra, String hinhThucThue, Integer soNguoi, List<HoaDon> ListHD, Phong phong, List<ThongTinThuePhong> listTTTP, KhachHang khachHang) {
        this.id = id;
        this.thoiGianThue = thoiGianThue;
        this.thoiGianTra = thoiGianTra;
        this.hinhThucThue = hinhThucThue;
        this.soNguoi = soNguoi;
        this.ListHD = ListHD;
        this.phong = phong;
        this.listTTTP = listTTTP;
        this.khachHang = khachHang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getThoiGianThue() {
        return thoiGianThue;
    }

    public void setThoiGianThue(Date thoiGianThue) {
        this.thoiGianThue = thoiGianThue;
    }

    public Date getThoiGianTra() {
        return thoiGianTra;
    }

    public void setThoiGianTra(Date thoiGianTra) {
        this.thoiGianTra = thoiGianTra;
    }

    public String getHinhThucThue() {
        return hinhThucThue;
    }

    public void setHinhThucThue(String hinhThucThue) {
        this.hinhThucThue = hinhThucThue;
    }

    public Integer getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(Integer soNguoi) {
        this.soNguoi = soNguoi;
    }

    public List<HoaDon> getListHD() {
        return ListHD;
    }

    public void setListHD(List<HoaDon> ListHD) {
        this.ListHD = ListHD;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public List<ThongTinThuePhong> getListTTTP() {
        return listTTTP;
    }

    public void setListTTTP(List<ThongTinThuePhong> listTTTP) {
        this.listTTTP = listTTTP;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    


    

}
