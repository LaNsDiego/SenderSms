package com.example.sendersms.contact;

import androidx.annotation.NonNull;

public class ContactModel {
    private String id;
    private String numberPhone;//Buscar libreria para verficar codigo post. de pais(Solo Perú)
    private Boolean isSended = false;

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

    public Boolean getSended() {
        return isSended;
    }

    public void setSended(Boolean sended) {
        isSended = sended;
    }

    @NonNull
    @Override
    public String toString() {
        return this.getNumberPhone();
    }


}
