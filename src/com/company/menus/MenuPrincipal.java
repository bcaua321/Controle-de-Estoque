package com.company.menus;

import com.company.dados.Arquivo;
import com.company.dados.OrdenaLista;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static Scanner input = new Scanner(System.in);
    private Arquivo arquivo = new Arquivo();

    public void mostrarMenuPrincipal() {
        Cadastrar cadastrar = new Cadastrar();
        OrdenaLista listaOrdenada = new OrdenaLista();
        Mostrar mostrar = new Mostrar();
        Opcoes.menuPrincipal();

        int valor = 0;
        try {
            valor = input.nextInt();
        } catch (InputMismatchException ex){
            input.next();
        }

        switch (valor) {
            case 1:
                cadastrar.cadastrarProduto();
                break;
            case 2:
                mostrar.manipularProdutos();
                break;
            case 3:
                listaOrdenada.ordenarLista();
                break;
            case 4:
                System.exit(1);
                break;
            default:
                System.out.println(ANSI_RED + "Opção inválida" + ANSI_RESET);
        }
        mostrarMenuPrincipal();
    }

    public static void clearScreen() {
            System.out.print("\033[H\033[2J");
            System.out.flush();
    }
}