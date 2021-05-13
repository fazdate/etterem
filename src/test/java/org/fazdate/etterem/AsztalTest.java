package org.fazdate.etterem;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AsztalTest {

    private Asztal asztal;
    private ArrayList<Etel> etelek = new ArrayList<>();
    private ArrayList<Etel> etelekKontroll = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        asztal = new Asztal("Asztal1", etelek);
        etelekKontroll.add(new Etel("ELŐÉTELEK", 0));
    }

    @Test
    public void setRendeles() throws IOException, ParseException {
        asztal.setRendeles(new Etel("ELŐÉTELEK", 0));
        assertEquals(etelek, etelekKontroll);
    }

    @Test
    public void osszErtek() throws IOException, ParseException {
        asztal.torles();
        asztal.setRendeles(new Etel("ELŐÉTELEK", 0));
        asztal.setRendeles(new Etel("ELŐÉTELEK", 1));
        int osszertek = asztal.osszErtek();
        assertEquals(osszertek, 6240);
    }
}