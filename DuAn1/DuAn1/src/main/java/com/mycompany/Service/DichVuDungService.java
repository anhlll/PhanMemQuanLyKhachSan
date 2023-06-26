/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.Service;

import com.mycompany.Domainmodels.DichVuDung;
import java.util.List;

public interface DichVuDungService {
    public List<DichVuDung> getAll();
    public Boolean add(DichVuDung dvd);
    public Boolean delete(String id);
}
