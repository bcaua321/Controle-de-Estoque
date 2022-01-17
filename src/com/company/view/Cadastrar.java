package com.company.view;

import com.company.controllers.Produto;
import com.company.controllers.ProdutoNaoPerecivel;
import com.company.controllers.ProdutoPerecivel;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Cadastrar extends MenuPrincipal{
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    private static Scanner input = new Scanner(System.in);
    public void cadastrarProduto() throws IOException, InterruptedException {
        Opcoes.menuCadastro();

        int valor = 0;
        try {
            valor = input.nextInt();
        } catch (InputMismatchException ex){
            input.next();
        }

        switch (valor){
            case 1:
                Produto p = new ProdutoPerecivel();
                try{
                    super.lista.cadastrar(p);
                } catch (NoSuchElementException e){
                    System.out.println(ANSI_RED + "Valor inválido" + ANSI_RESET);
                }
                cadastrarProduto();
                break;
            case 2:
                Produto p1 = new ProdutoNaoPerecivel();
                try {
                    super.lista.cadastrar(p1);
                } catch (NoSuchElementException e){
                    System.out.println(ANSI_RED + "Valor inválido" + ANSI_RESET);
                }
                cadastrarProduto();
                break;
            case 3:
                super.mostrarMenuPrincipal();
                break;
            default:
                System.out.println(ANSI_RED + "Opção inválida" + ANSI_RESET);
        }
        cadastrarProduto();
    }
}