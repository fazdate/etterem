package org.fazdate.etterem;

import java.util.ArrayList;

public class Asztal {

    private String nev;
    private ArrayList<Etel> rendeles;
    private boolean isFoglalt = false;

    public Asztal(String nev, ArrayList<Etel> rendeles) {
        this.nev = nev;
        this.rendeles = rendeles;
    }

    public void setRendeles(Etel etel) {
        rendeles.add(etel);
    }

    public ArrayList<Etel> getRendeles() {
        return rendeles;
    }

    public String getNev() {
        return nev;
    }

    public boolean isFoglalt() {
        return isFoglalt;
    }

    public void setFoglalt(boolean foglalt) {
        isFoglalt = foglalt;
    }

    public void torles() { rendeles.clear(); }

    public int osszErtek() {
        int ertek = 0;
        for (int i = 0; i < rendeles.size(); i++)
            ertek += rendeles.get(i).getAr();
        return ertek;
    }

}