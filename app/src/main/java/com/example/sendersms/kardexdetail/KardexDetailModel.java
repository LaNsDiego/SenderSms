package com.example.sendersms.kardexdetail;

import com.example.sendersms.product.ProductModel;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class KardexDetailModel implements Serializable {
    private String id;
    private String kardexDetailId;
    private String tipoMovimiento;
    private String serie;
    private String numero;
    private Date fechaRegistro;
    private List<ProductModel> products;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKardexDetailId() {
        return kardexDetailId;
    }

    public void setKardexDetailId(String kardexDetailId) {
        this.kardexDetailId = kardexDetailId;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }
}
