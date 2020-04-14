package com.example.projet_android.model;

public class Programme {

    private String Maladie;
    private String Date_debut;
    private String Duree;

    public Programme(String maladie, String date_debut, String duree) {
        Maladie = maladie;
        Date_debut = date_debut;
        Duree = duree;
    }

    public String getMaladie() {
        return Maladie;
    }

    public void setMaladie(String maladie) {
        Maladie = maladie;
    }

    public String getDate_debut() {
        return Date_debut;
    }

    public void setDate_debut(String date_debut) {
        Date_debut = date_debut;
    }

    public String getDuree() {
        return Duree;
    }

    public void setDuree(String duree) {
        Duree = duree;
    }
}

