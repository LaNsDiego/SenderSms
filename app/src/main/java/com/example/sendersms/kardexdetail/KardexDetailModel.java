package com.example.sendersms.kardexdetail;

import com.example.sendersms.product.ProductModel;
import com.google.firebase.firestore.ServerTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class KardexDetailModel implements Serializable {
    private String id;
    private String typeOperation;
    private String typeProof;
    private String serie;
    private String numberProof;
    private @ServerTimestamp Date createdAt;
    private List<ProductModel> products;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumberProof() {
        return numberProof;
    }

    public void setNumberProof(String numberProof) {
        this.numberProof = numberProof;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }

    public String getTypeProof() {
        return typeProof;
    }

    public void setTypeProof(String typeProof) {
        this.typeProof = typeProof;
    }
}
