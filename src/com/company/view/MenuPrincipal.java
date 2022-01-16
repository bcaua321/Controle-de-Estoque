package com.company.view;
import com.company.Produtos.Lista;

import java.io.IOException;
import java.util.Scanner;

public class MenuPrincipal {
    private static Scanner input = new Scanner(System.in);
    public Lista lista = new Lista();

    public void mostrarMenuPrincipal() throws IOException, InterruptedException {
        Cadastrar cadastrar = new Cadastrar();
        System.out.println("1 - Cadastrar um novo Produto");
        System.out.println("2 - Mostrar Produtos já Cadastrados");
        System.out.println("3 - Organizar produtos");
        System.out.println("4 - Imprimir Arquivos");
        int valor = input.nextInt();

        switch (valor) {
            case 1:
                cadastrar.cadastrarProduto();
                break;
            case 2:
                System.out.println(lista.getListaDeProdutos());
                mostrarMenuPrincipal();
                break;
            default:
                System.out.println(":)");
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
