package org.fazdate.etterem;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Etel {

    private String nev;
    private long ar;
    private String leiras;

    private ArrayList<Etel> eloetelek = new ArrayList<>();
    private ArrayList<Etel> levesek = new ArrayList<>();
    private ArrayList<Etel> foFogasok = new ArrayList<>();
    private ArrayList<Etel> gyerekekKedvere = new ArrayList<>();
    private ArrayList<Etel> husmentes = new ArrayList<>();
    private ArrayList<Etel> salatak = new ArrayList<>();
    private ArrayList<Etel> ketSzemelyes = new ArrayList<>();
    private ArrayList<Etel> desszertek = new ArrayList<>();
    private ArrayList<Etel> alkoholmentesek = new ArrayList<>();
    private ArrayList<Etel> sorok = new ArrayList<>();
    private ArrayList<Etel> rovidek = new ArrayList<>();
    private ArrayList<Etel> borok = new ArrayList<>();
    private ArrayList<Etel> pezsgok = new ArrayList<>();
    private ArrayList<Etel> melengetok = new ArrayList<>();
    private ArrayList<ArrayList<Etel>> etelek = new ArrayList<ArrayList<Etel>>();

    private  JSONParser jsonParser = new JSONParser();
    private  JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src/main/java/Etlap.json"));

    public Etel(String kategoria, int etel) throws IOException, ParseException {
        JSONArray tempKat = (JSONArray) jsonObject.get(kategoria);
        JSONObject tempEtel = (JSONObject) tempKat.get((etel));
        this.nev = (String) tempEtel.get("nev");
        this.ar = (long) tempEtel.get("ar");
        this.leiras = (String) tempEtel.get("leiras");
    }

    public long getAr() {
        return ar;
    }

    public String getNev() { return nev; }

    public ArrayList<Etel> getEloetelek() throws IOException, ParseException {
        JSONArray tempKat = (JSONArray) jsonObject.get("ELŐÉTELEK");
        for (int i = 0; i < tempKat.size(); i++)
            eloetelek.add(new Etel("ELŐÉTELEK", i));
        return eloetelek;
    }

    public ArrayList<Etel> getLevesek() throws IOException, ParseException {
        JSONArray tempKat = (JSONArray) jsonObject.get("LEVESEK");
        for (int i = 0; i < tempKat.size(); i++)
            levesek.add(new Etel("LEVESEK", i));
        return levesek;
    }

    public ArrayList<Etel> getFoFogasok() throws IOException, ParseException {
        JSONArray tempKat = (JSONArray) jsonObject.get("FŐ FOGÁSOK");
        for (int i = 0; i < tempKat.size(); i++)
            foFogasok.add(new Etel("FŐ FOGÁSOK", i));
        return foFogasok;
    }

    public ArrayList<Etel> getGyerekekKedvere() throws IOException, ParseException {
        JSONArray tempKat = (JSONArray) jsonObject.get("GYEREKEK");
        for (int i = 0; i < tempKat.size(); i++)
            gyerekekKedvere.add(new Etel("GYEREKEK", i));
        return gyerekekKedvere;
    }

    public ArrayList<Etel> getHusmentes() throws IOException, ParseException {
        JSONArray tempKat = (JSONArray) jsonObject.get("HÚSMENTES");
        for (int i = 0; i < tempKat.size(); i++)
            husmentes.add(new Etel("HÚSMENTES", i));
        return husmentes;
    }

    public ArrayList<Etel> getSalatak() throws IOException, ParseException {
        JSONArray tempKat = (JSONArray) jsonObject.get("SALÁTÁK");
        for (int i = 0; i < tempKat.size(); i++)
            salatak.add(new Etel("SALÁTÁK", i));
        return salatak;
    }

    public ArrayList<Etel> getKetSzemelyes() throws IOException, ParseException {
        JSONArray tempKat = (JSONArray) jsonObject.get("2 SZEMÉLYES");
        for (int i = 0; i < tempKat.size(); i++)
            ketSzemelyes.add(new Etel("2 SZEMÉLYES", i));
        return ketSzemelyes;
    }

    public ArrayList<Etel> getDesszertek() throws IOException, ParseException {
        JSONArray tempKat = (JSONArray) jsonObject.get("DESSZERTEK");
        for (int i = 0; i < tempKat.size(); i++)
            desszertek.add(new Etel("DESSZERTEK", i));
        return desszertek;
    }

    public ArrayList<Etel> getAlkoholmentesek() throws IOException, ParseException {
        JSONArray tempKat = (JSONArray) jsonObject.get("ALKOHOLMENTES");
        for (int i = 0; i < tempKat.size(); i++)
            alkoholmentesek.add(new Etel("ALKOHOLMENTES", i));
        return alkoholmentesek;
    }

    public ArrayList<Etel> getSorok() throws IOException, ParseException {
        JSONArray tempKat = (JSONArray) jsonObject.get("SÖR");
        for (int i = 0; i < tempKat.size(); i++)
            sorok.add(new Etel("SÖR", i));
        return sorok;
    }

    public ArrayList<Etel> getRovidek() throws IOException, ParseException {
        JSONArray tempKat = (JSONArray) jsonObject.get("RÖVID");
        for (int i = 0; i < tempKat.size(); i++)
            rovidek.add(new Etel("RÖVID", i));
        return rovidek;
    }

    public ArrayList<Etel> getBorok() throws IOException, ParseException {
        JSONArray tempKat = (JSONArray) jsonObject.get("BOR");
        for (int i = 0; i < tempKat.size(); i++)
            borok.add(new Etel("BOR", i));
        return borok;
    }

    public ArrayList<Etel> getPezsgok() throws IOException, ParseException {
        JSONArray tempKat = (JSONArray) jsonObject.get("PEZSGŐ");
        for (int i = 0; i < tempKat.size(); i++)
            pezsgok.add(new Etel("PEZSGŐ", i));
        return pezsgok;
    }

    public ArrayList<Etel> getMelengetok() throws IOException, ParseException {
        JSONArray tempKat = (JSONArray) jsonObject.get("MELENGETŐK");
        for (int i = 0; i < tempKat.size(); i++)
            melengetok.add(new Etel("MELENGETŐK", i));
        return melengetok;
    }

    public ArrayList<ArrayList<Etel>> getEtelek() throws IOException, ParseException {
        etelek.add(getEloetelek());
        etelek.add(getLevesek());
        etelek.add(getFoFogasok());
        etelek.add(getGyerekekKedvere());
        etelek.add(getHusmentes());
        etelek.add(getSalatak());
        etelek.add(getKetSzemelyes());
        etelek.add(getDesszertek());
        etelek.add(getAlkoholmentesek());
        etelek.add(getSorok());
        etelek.add(getRovidek());
        etelek.add(getBorok());
        etelek.add(getPezsgok());
        etelek.add(getMelengetok());
        return etelek;
    }
}
