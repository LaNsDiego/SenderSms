package com.example.sendersms.kardex;

import com.example.sendersms.kardexdetail.KardexDetailModel;

import java.io.Serializable;
import java.util.List;

public class KardexModel implements Serializable {
    private String id;
    private String period;
    private String entity;
    private String codeUnit;
    private String ruc;
    private String description;
    private String warehouseId;
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

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getCodeUnit() {
        return codeUnit;
    }

    public void setCodeUnit(String codeUnit) {
        this.codeUnit = codeUnit;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
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
