package Logica;

import java.util.*;
import javax.swing.Action;

public enum Categoria {
    SC("SC",0),
    A("A",18),
    B("B",14),
    C("C",10);

    public static Categoria valueOf(Action action) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String key;
    private int value;
    private static final List<Categoria> list = new ArrayList<>();
    private static final Map<String, Categoria> lookup = new HashMap<>();

    static {

        for (Categoria s : EnumSet.allOf(Categoria.class)) {
            list.add(s);
            lookup.put(s.getKey(), s);
        }
    }

    private Categoria(String key, int value) {
        this.key = key;
        this.value = value;
    }
    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
    public static Categoria get(String key){
        return lookup.get(key);
    }
    public static boolean isValidKey(String key){
        return lookup.get(key)!=null?true:false;
    }


}
