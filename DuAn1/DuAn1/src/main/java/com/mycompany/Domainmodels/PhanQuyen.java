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

/**
 *
 * @author HP
 */
@Entity 
@Table(name = "PhanQuyen")
public class PhanQuyen {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;
    
    @Column(name = "MaQuyen")
    private String maQuyen;
    
    @Column(name = "Quyen")
    private String quyen;
    
    @OneToMany(mappedBy = "phanQuyen")
    private List<NguoiDung> listND;

    public PhanQuyen() {
    }

    public PhanQuyen(String id, String maQuyen, String quyen, List<NguoiDung> listND) {
        this.id = id;
        this.maQuyen = maQuyen;
        this.quyen = quyen;
        this.listND = listND;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(String maQuyen) {
        this.maQuyen = maQuyen;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    public List<NguoiDung> getListND() {
        return listND;
    }

    public void setListND(List<NguoiDung> listND) {
        this.listND = listND;
    }

    @Override
    public String toString() {
        return quyen;
    }
    
}
