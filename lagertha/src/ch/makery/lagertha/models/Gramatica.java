package ch.makery.lagertha.models;

import java.util.ArrayList;

public class Gramatica {

    private ArrayList<String> variaveis;
    private ArrayList<String> terminais;
    private ArrayList<String> regrasDeProdcao;
    private String variavelIncial;

    public Gramatica(ArrayList<String> variaveis, ArrayList<String> terminais, ArrayList<String> regrasDeProdcao, String variavelIncial) {
        this.variaveis = variaveis;
        this.terminais = terminais;
        this.regrasDeProdcao = separacao(regrasDeProdcao);
        this.variavelIncial = variavelIncial;
    }

    public ArrayList<String> first(String variavel) {

        ArrayList<String> first = new ArrayList<>();

        for (String regra : this.variaveis) {
            if (contemVazio(regra)) {
                first.add("£");
                return first;
            }
        }

        return null;
    }

    public boolean testarRegraProducao(String variavel) {

        return false;
    }

    public ArrayList<String> follow(String variavel) {

        return null;
    }

    public boolean contemVazio(String variavel) {

        return false;
    }

    public ArrayList<String> separacao(ArrayList<String> regrasDeProdcao) {

        ArrayList<String> separadas = new ArrayList<>();

        String ou = "|";
        String a = "R -> As  as";
        String[] s = a.split(ou);
        System.out.println(a + " - - " + s.length);
        for (String d : s) {
            System.out.println(d);
        }

        return separadas;
    }

}
