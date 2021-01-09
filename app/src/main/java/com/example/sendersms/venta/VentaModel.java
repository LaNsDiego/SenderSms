package com.example.sendersms.venta;

import com.example.sendersms.ventadetail.VentaDetailModel;

import java.sql.Date;
import java.util.List;

public class VentaModel {
    private String id;
    private String serie;
    private String numero;
    private Date fechaRegistro;
    private String userId;
    private double total;
    private List<VentaDetailModel> listDetail;
}
