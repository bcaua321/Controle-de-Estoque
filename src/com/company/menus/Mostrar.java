package com.company.menus;

import com.company.dados.Lista;
import com.company.produto.Produto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Mostrar  {
    MenuPrincipal menu = new MenuPrincipal();
    Lista lista = new Lista();
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static Scanner input = new Scanner(System.in);

    public static void mostrarProdutos (ArrayList<Produto> p) {
        for (int i = 0; i < p.size(); i++){
            System.out.println(p.get(i).toString());
            System.out.println();
        }
    }

    public void manipularProdutos () {
        Editar editar = new Editar();

        if(lista.getListaDeProdutos().size() == 0) {
            System.out.println("=== Nenhum produto cadastrado ===");
            menu.mostrarMenuPrincipal();
        }

        Opcoes.menuProdutos();
        int valor = 0;
        try {
            valor = input.nextInt();
        } catch (InputMismatchException ex){
            input.next();
        }

        clearScreen();
        switch(valor){
            case 1:
                editar.continuarEditar();
                break;
            case 2:
                this.continuarExcluir();
                break;
            case 3:
                Mostrar.mostrarProdutos(lista.getListaDeProdutos());
                break;
            case 4:
                menu.mostrarMenuPrincipal();
                break;
            default:
                System.out.println(ANSI_RED + "Opção inválida" + ANSI_RESET);
        }

        manipularProdutos();
    }

    public void excluirProduto(){
        Mostrar.mostrarProdutos(lista.getListaDeProdutos());
        System.out.println("Digite o ID do produto:");

        int valor = input.nextInt();
        if(valor < lista.getListaDeProdutos().size() && valor>= 0){
            lista.removeElemento(valor);
            System.out.println(ANSI_CYAN  + "Item excluido!" + ANSI_RED);
            this.manipularProdutos();
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


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
