package com.example.sendersms.sell;

import com.example.sendersms.ventadetail.VentaDetailModel;

import java.sql.Date;
import java.util.List;

public class SellModel {
    private String id;
    private String serie;
    private String numero;
    private Date fechaRegistro;
    private String userId;
    private double total;
    private List<VentaDetailModel> listDetail;
}