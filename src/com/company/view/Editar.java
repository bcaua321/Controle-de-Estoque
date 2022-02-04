package com.company.view;

import com.company.controllers.Produto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Editar {
    MenuPrincipal menu = new MenuPrincipal();
    Mostrar mostrar = new Mostrar();
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static Scanner input = new Scanner(System.in);

    public void editarProduto(){
        Mostrar.mostrarProdutos(menu.lista.getListaDeProdutos());
        System.out.println("Digite o ID do produto que deseja EDITAR:");
        int valor = input.nextInt();
        if(valor < menu.lista.getListaDeProdutos().size() && valor>= 0){
            this.editarList(valor);
            return;
        } else {
            while(true){
                System.out.println(ANSI_RED + "Não exite produto com esse ID\n" + ANSI_RESET);
                this.continuarEditar();
            }
        }
    }

    public void continuarEditar() {
        System.out.println("Deseja continuar?\n1 - SIM\t\t2 - NAO\n");
        int valor = 0;
        try {
            valor = input.nextInt();
        } catch (InputMismatchException ex){
            input.next();
        }

        switch(valor){
            case 1:
                this.editarProduto();
                break;
            case 2:
                mostrar.manipularProdutos();
                break;
            default:
                System.out.println(ANSI_RED + "Opção inválida" + ANSI_RESET);
                continuarEditar();
        }

    }

    public void editarList(int n){
        Produto item = menu.lista.getListaDeProdutos().get(n);
        item.toString();

        Opcoes.menuEditar();
        System.out.println("\nQual atributo deseja editar?");
        int valor = 0;
        try {
            valor = input.nextInt();
        } catch (InputMismatchException ex){
            input.next();
        }
        /*
        ANSI_CYAN + "====================================" + ANSI_RESET,
                ANSI_PURPLE + "1 " + ANSI_RESET + "- Codigo" + "\t\t\t\t\t\t\t|",
                ANSI_PURPLE + "2 " + ANSI_RESET  + "- Produto" + "\t\t\t\t\t\t\t|",
                ANSI_PURPLE + "2 " + ANSI_RESET  + "- Preco" + "\t\t\t\t\t\t\t|",
                ANSI_PURPLE + "3 " + ANSI_RESET + "- Fornecedor" + "\t\t\t\t\t\t|",
                ANSI_PURPLE + "4 " + ANSI_RESET + "- Categoria" + "\t\t\t\t\t\t|",
                ANSI_PURPLE + "4 " + ANSI_RESET + "- Data de Compra" + "\t\t\t\t\t|",
                ANSI_CYAN + "====================================" + ANSI_RESET

         */
        switch(valor){
            case 1:
                break;
            case 2:
                mostrar.manipularProdutos();
                break;
            default:
                System.out.println(ANSI_RED + "Opção inválida" + ANSI_RESET);
                continuarEditar();
        }

        return;
    }
}
