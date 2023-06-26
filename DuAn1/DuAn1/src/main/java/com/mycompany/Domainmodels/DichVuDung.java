/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Domainmodels;

import java.util.Date;
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
@Table(name = "DichVuDung")
public class DichVuDung {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

    @Column(name = "NgayThue")
    private Date ngayThue;
    
    @Column(name = "soLuongDung")
    private Integer soLuongSuDung;
    
    @ManyToOne
    @JoinColumn(name = "IdDV")
    private DichVu dichVu;
    
    @ManyToOne
    @JoinColumn(name = "IdPhong")
    private Phong phong;

    public DichVuDung() {
    }

    public DichVuDung(String id, Date ngayThue, Integer soLuongSuDung, DichVu dichVu, Phong phong) {
        this.id = id;
        this.ngayThue = ngayThue;
        this.soLuongSuDung = soLuongSuDung;
        this.dichVu = dichVu;
        this.phong = phong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(Date ngayThue) {
        this.ngayThue = ngayThue;
    }

    public Integer getSoLuongSuDung() {
        return soLuongSuDung;
    }

    public void setSoLuongSuDung(Integer soLuongSuDung) {
        this.soLuongSuDung = soLuongSuDung;
    }

    public DichVu getDichVu() {
        return dichVu;
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }


}
