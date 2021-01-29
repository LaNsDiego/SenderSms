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
    private String storeId;
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

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }


    public List<KardexDetailModel> getDetail() {
        return detail;
    }

    public void setDetail(List<KardexDetailModel> detail) {
        this.detail = detail;
    }
}
