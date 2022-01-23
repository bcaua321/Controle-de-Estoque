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
            System.out.println();
            System.out.println(p.get(i).toString());
            System.out.println();
        }
    }
    public void manipularProdutos () throws IOException, InterruptedException {
        Opcoes.menuProdutos();

        int valor = 0;
        try {
            valor = input.nextInt();
        } catch (InputMismatchException ex){
            input.next();
        }

        switch(valor){
            case 1:
                break;
            case 2:
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

    public void excluirProduto() throws IOException, InterruptedException {
        System.out.println("Digite o ID do produto:");
        int valor = input.nextInt();
        if(valor < menu.lista.getListaDeProdutos().size() && valor>= 0){
            menu.lista.removeElemento(valor);
            return;
        } else {
            while(true){
                System.out.println(ANSI_RED + "Não exite produto com esse ID\n" + ANSI_RESET +  "Deseja continuar?\n 1 - SIM   2- NAO");
                try {
                    valor = input.nextInt();
                } catch (InputMismatchException ex){
                    input.next();
                }

                switch(valor){
                    case 1:
                        excluirProduto();
                        break;
                    case 2:
                        menu.mostrarMenuPrincipal();
                        break;
                    default:
                        System.out.println(ANSI_RED + "Opção inválida" + ANSI_RESET);
                }
            }
        }
    }
}
