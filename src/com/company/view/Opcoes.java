package com.company.view;

public class Opcoes {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_RED = "\u001B[31m";

    public static void printMenu(String[] opcoes){
        for(String opcao: opcoes){
            System.out.println(opcao);
        }
    }

    public static void menuPrincipal(){
        String[] opcoes = {
                ANSI_CYAN + "=====================================" + ANSI_RESET,
                ANSI_PURPLE + "1 " + ANSI_RESET + "- Cadastrar um novo Produto" + "\t\t|",
                ANSI_PURPLE + "2 " + ANSI_RESET  + "- Mostrar Produtos já Cadastrados" + "\t|",
                ANSI_PURPLE + "3 " + ANSI_RESET  + "- Organizar produtos" + "\t\t\t\t|",
                ANSI_PURPLE + "4 " + ANSI_RESET  + "- Imprimir Arquivos" + "\t\t\t\t|",
                ANSI_CYAN + "=====================================" + ANSI_RESET
        };

        Opcoes.printMenu(opcoes);
    }

    public static void menuCadastro(){
        String[] opcoes = {
                ANSI_CYAN + "=================================" + ANSI_RESET,
                ANSI_PURPLE + "1 " + ANSI_RESET + "- Produto Perecivel" + "\t\t\t|",
                ANSI_PURPLE + "2 " + ANSI_RESET  + "- Produto Não Perecivel" + "\t\t|",
                ANSI_PURPLE + "3 " + ANSI_RESET + "- Voltar" + "\t\t\t\t\t\t|",
                ANSI_CYAN + "=================================" + ANSI_RESET
        };

        Opcoes.printMenu(opcoes);
    }

}
