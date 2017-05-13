package ch.makery.lagertha.models;

import java.util.ArrayList;

public class Gramatica {

    private ArrayList<String> variaveis;
    private ArrayList<String> terminais;
    private ArrayList<String> regrasDeProducao;
    private String variavelIncial;

    public Gramatica(ArrayList<String> variaveis, ArrayList<String> terminais, ArrayList<String> regrasDeProducao, String variavelIncial) {
        this.variaveis = variaveis;
        this.terminais = terminais;
        this.regrasDeProducao = separacao(regrasDeProducao);
        this.variavelIncial = variavelIncial;
        
        first("R");
    }

    public ArrayList<String> first(String variavel) {
        System.out.println("FIRST");
        ArrayList<String> first = new ArrayList<>();

        if (contemVazio(variavel)) {
//                first.add("£");
            System.out.println("Entrou = " + variavel);
            return first;
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
        System.out.println("VARIAVEL = "+variavel);
        String palavraVazia = "£";
        for (String regra : this.regrasDeProducao){
            String[] resto = regra.split("->");
            System.out.println(resto[0] + " == "+ variavel );
            if(resto[0].equals(variavel)){
                System.out.println(resto[1]);
                if(resto[1].equals(palavraVazia)){
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<String> separacao(ArrayList<String> regrasDeProducao) {

        ArrayList<String> separadas = new ArrayList<>();
        char ou = '|';

        for (String regra : regrasDeProducao) {
            regra = regra.replaceAll(" ",""); 
            String[] resto = regra.split("->");
//            System.out.println(resto[0]);
            char[] letras = resto[1].toCharArray();
            String newRegra = "";
            for (char d : letras) {
                newRegra += d;
                if (d == ou) {
                    newRegra = newRegra.substring(0, newRegra.length() - 1);
                    separadas.add(resto[0] + "->" + newRegra);
                    newRegra = "";
                }
            }
            separadas.add(resto[0]+ "->"+newRegra);
        }
        
        for(String r : separadas){
            System.out.println(r);
        }
        return separadas;
    }

}
