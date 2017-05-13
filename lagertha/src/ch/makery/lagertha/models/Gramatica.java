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

        first("L");
    }

    public ArrayList<String> first(String variavel) {
        System.out.println("FIRST de "+ variavel);
        String palavraVazia = "£";
        ArrayList<String> first = new ArrayList<>();

        if (contemVazio(variavel)) {
            first.add(palavraVazia);
//            return first;
        }
        System.out.println("Não tem Final");
        for(String regra : this.regrasDeProducao){
            String[] resto = regra.split("->");
            if(resto[0].equals(variavel)){
                char[] restante = resto[1].toCharArray();
                for(char letra : restante){
                    if(ehTerminal(letra+"")){
                        first = uniaoArrayETerminal(first, letra+"");
                    }else{
                        
                    }
                }
            }
        }
        System.out.println("First Calculado");
        for(String f : first){
            System.out.print(f+ " ");
        }
        System.out.println("");
        return null;
    }

    public ArrayList<String> uniaoArrayETerminal( ArrayList<String> array, String terminal){
        
        boolean teste = false;
        for(String variavel : array){
            if(variavel.equals(terminal)){
                teste = true;
            }
        }
        
        if(teste){
            return array;
        }else{
            array.add(terminal);
            return array;
        }
        
    }
    
    public ArrayList<String> follow(String variavel) {

        return null;
    }
    
    public boolean ehTerminal(String variavel){
        for(String terminal : this.terminais){
            if(terminal.equals(variavel)){
                return true;
            }
        }
        return false;
    }

    public boolean contemVazio(String variavel) {
//        System.out.println("VARIAVEL = " + variavel);
        String palavraVazia = "£";
        for (String regra : this.regrasDeProducao) {
            String[] resto = regra.split("->");
//            System.out.println(resto[0] + " == " + variavel);
            if (resto[0].equals(variavel)) {
                if (resto[1].equals(palavraVazia)) {
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
            regra = regra.replaceAll(" ", "");
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
            separadas.add(resto[0] + "->" + newRegra);
        }

        for (String r : separadas) {
            System.out.println(r);
        }
        return separadas;
    }

}
