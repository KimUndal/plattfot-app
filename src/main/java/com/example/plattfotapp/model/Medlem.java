package com.example.plattfotapp.model;

import java.util.Objects;

public class Medlem {
    private String id;
    private String fornavn;
    private String etternavn;
    private String adresse;
    private String telefon;
    private String epost;

    public Medlem(String fornavn, String etternavn, String adresse, String telefon, String epost) {
        id = java.util.UUID.randomUUID().toString();
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.adresse = adresse;
        this.telefon = telefon;
        this.epost = epost;
    }

    public Medlem(String id, String fornavn, String etternavn, String adresse, String telefon, String epost) {
        this.id = id;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.adresse = adresse;
        this.telefon = telefon;
        this.epost = epost;
    }

    public String getId() {
        return id;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEpost() {
        return epost;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medlem medlem = (Medlem) o;
        return Objects.equals(
                getId(), medlem.getId())
                && Objects.equals(getFornavn(), medlem.getFornavn())
                && Objects.equals(getEtternavn(), medlem.getEtternavn())
                && Objects.equals(getAdresse(), medlem.getAdresse())
                && Objects.equals(getTelefon(), medlem.getTelefon())
                && Objects.equals(getEpost(), medlem.getEpost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFornavn(), getEtternavn(), getAdresse(), getTelefon(), getEpost());
    }

    @Override
    public String toString() {
        return "Medlem{" +
                "id='" + id + '\'' +
                ", fornavn='" + fornavn + '\'' +
                ", etternavn='" + etternavn + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telefon='" + telefon + '\'' +
                ", epost='" + epost + '\'' +
                '}';
    }


}
