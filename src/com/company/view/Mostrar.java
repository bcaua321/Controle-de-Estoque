package com.company.view;

import com.company.Produtos.Lista;
import com.company.controllers.Produto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Mostrar  {
    MenuPrincipal menu = new MenuPrincipal();
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static Scanner input = new Scanner(System.in);

    public static void mostrarProdutos (ArrayList<Produto> p) {
        if(p.size() == 0) System.out.println("Nenhum produto cadastrado.");
        for (int i = 0; i < p.size(); i++){
            System.out.println(p.get(i).toString());
            System.out.println();
        }
    }
    public void manipularProdutos () {
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
                this.continuarEditar();
                break;
            case 2:
                this.continuarExcluir();
                this.excluirProduto();
                break;
            case 3:
                Mostrar.mostrarProdutos(menu.lista.getListaDeProdutos());
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
        Mostrar.mostrarProdutos(menu.lista.getListaDeProdutos());
        System.out.println("Digite o ID do produto:");

        int valor = input.nextInt();
        if(valor < menu.lista.getListaDeProdutos().size() && valor>= 0){
            menu.lista.removeElemento(valor);
            this.manipularProdutos();
            return;
        } else {
            while(true){
                System.out.println(ANSI_RED + "Não exite produto com esse ID\n" + ANSI_RESET);
                this.continuarExcluir();
            }
        }

    }

    public void editarProduto(){
        System.out.println("Digite o ID do produto que deseja EDITAR:");
        int valor = input.nextInt();
        if(valor < menu.lista.getListaDeProdutos().size() && valor>= 0){
            menu.lista.removeElemento(valor);
            return;
        } else {
            while(true){
                System.out.println(ANSI_RED + "Não exite produto com esse ID\n" + ANSI_RESET);
                this.continuarEditar();
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
                this.menu.mostrarMenuPrincipal();
                break;
            default:
                System.out.println(ANSI_RED + "Opção inválida" + ANSI_RESET);
        }
        continuarEditar();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
