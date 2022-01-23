package com.company.view;

import com.company.Produtos.Arquivo;
import com.company.Produtos.Lista;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static Scanner input = new Scanner(System.in);
    protected Lista lista = new Lista();
    private Arquivo arquivo = new Arquivo();

    public void mostrarMenuPrincipal() throws IOException, InterruptedException {
        Cadastrar cadastrar = new Cadastrar();
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
                mostrarMenuPrincipal();
                break;
            case 2:
                mostrar.manipularProdutos();
                break;
            case 4:
                break;
            default:
                System.out.println(ANSI_RED + "Opção inválida" + ANSI_RESET);
                mostrarMenuPrincipal();
        }

    }

    public void limpaTela() throws IOException, InterruptedException {
        //Limpa a tela no windows, no linux e no MacOS
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    }
}