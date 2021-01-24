package com.example.sendersms.kardex;

import com.example.sendersms.kardexdetail.KardexDetailModel;

import java.io.Serializable;
import java.util.List;

public class KardexModel implements Serializable {
    private String id;
    private String periodo;
    private String razonSocial;
    private String codigoUnidad;
    private String ruc;
    private String descripción;
    private String almacenId;
    private String latitude;
    private String longitude;
    private String address;
    private List<KardexDetailModel> detail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCodigoUnidad() {
        return codigoUnidad;
    }

    public void setCodigoUnidad(String codigoUnidad) {
        this.codigoUnidad = codigoUnidad;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public String getAlmacenId() {
        return almacenId;
    }

    public void setAlmacenId(String almacenId) {
        this.almacenId = almacenId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<KardexDetailModel> getDetail() {
        return detail;
    }

    public void setDetail(List<KardexDetailModel> detail) {
        this.detail = detail;
    }
}
