package com.company.menus;

import com.company.dados.Lista;
import com.company.produto.Produto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Classe para operações de ver a lista de produtos, editar e excluir.
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
        Excluir excluir = new Excluir();

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
                excluir.continuarExcluir();
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


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
