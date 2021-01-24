package com.example.sendersms.contact;

public class ContactModel {
    private String id;
    private String numberPhone;//Buscar libreria para verficar codigo post. de pais(Solo Perú)

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
}
