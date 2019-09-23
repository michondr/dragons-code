package cz.vse.java.mico00.logika;


import java.util.Map;
import java.util.HashMap;

public class Batoh {
    public static final int KAPACITA = 3;
    private Map<String, Vec> seznamVeci;   // seznam věcí v batohu

    public Batoh() {
        seznamVeci = new HashMap<String, Vec>();
    }

    public void vlozVec(Vec vec) {
        seznamVeci.put(vec.getJmeno(), vec);
    }

    public String nazvyVeci() {
        String nazvy = "věci v batohu: ";
        for (String jmenoVeci : seznamVeci.keySet()) {
            nazvy += jmenoVeci + " ";
        }
        return nazvy;
    }

    public Vec vyberVec(String jmeno) {
        Vec nalezenaVec = null;
        if (seznamVeci.containsKey(jmeno)) {
            nalezenaVec = seznamVeci.get(jmeno);
            seznamVeci.remove(jmeno);
        }
        return nalezenaVec;
    }

}



