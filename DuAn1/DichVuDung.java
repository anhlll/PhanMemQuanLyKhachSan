/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Domainmodel;

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

    @ManyToOne
    @JoinColumn(name = "IdDV")
    private DichVu dichVu;

    @OneToMany(mappedBy = "dichVuDung")
    private List<HoaDonChiTiet> listhdct;

    public DichVuDung() {
    }

    public DichVuDung(String id, Date ngayThue, DichVu dichVu, List<HoaDonChiTiet> listhdct) {
        this.id = id;
        this.ngayThue = ngayThue;
        this.dichVu = dichVu;
        this.listhdct = listhdct;
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

    public DichVu getDichVu() {
        return dichVu;
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
    }

    public List<HoaDonChiTiet> getListhdct() {
        return listhdct;
    }

    public void setListhdct(List<HoaDonChiTiet> listhdct) {
        this.listhdct = listhdct;
    }

}
