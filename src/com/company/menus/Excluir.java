package com.company.menus;

import com.company.dados.Lista;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excluir {
    MenuPrincipal menu = new MenuPrincipal();
    Mostrar mostrar = new Mostrar();
    Lista lista = new Lista();

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static Scanner input = new Scanner(System.in);

    public void excluirProduto(){
        Mostrar.mostrarProdutos(lista.getListaDeProdutos());
        System.out.println("Digite o ID do produto:");

        int valor = input.nextInt();
        if(valor < lista.getListaDeProdutos().size() && valor>= 0){
            lista.removeElemento(valor);
            System.out.println(ANSI_CYAN  + "Item excluido!" + ANSI_RED);
            mostrar.manipularProdutos();
            return;
        } else {
            while(true){
                System.out.println(ANSI_RED + "Não exite produto com esse ID\n" + ANSI_RESET);
                this.continuarExcluir();
            }
        }

    }

    public void continuarExcluir() {
        System.out.println("Deseja continuar?\n1 - SIM\t\t2 - NAO\n");
        int valor = 0;
        try {
            valor = input.nextInt();
        } catch (InputMismatchException ex){
            input.next();
        }

        switch(valor){
            case 1:
                this.excluirProduto();
                break;
            case 2:
                this.menu.mostrarMenuPrincipal();
                break;
            default:
                System.out.println(ANSI_RED + "Opção inválida" + ANSI_RESET);
        }
        continuarExcluir();
    }
}
