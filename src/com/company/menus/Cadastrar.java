package com.company.menus;

import com.company.dados.Arquivo;
import com.company.dados.Lista;
import com.company.produto.Produto;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Cadastrar {
    Lista listaProdutos = new Lista();
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    private static Scanner input = new Scanner(System.in);
    public void cadastrarProduto(){
        Produto p = new Produto();
        try{
            this.cadastrar(p);
        } catch (NoSuchElementException e){
            System.out.println(ANSI_RED + "Valor inválido" + ANSI_RESET);
            return;
        }
    }

    public void cadastrar(Produto p){
        Arquivo arq = new Arquivo();
        Scanner input = new Scanner(System.in);
        System.out.println("--- Cadastro de Produto ---");
        System.out.println("Código: ");
        int code = input.nextInt();
        System.out.println("Produto: ");
        input.nextLine();
        String produto = input.nextLine();
        System.out.println("Preco: ");
        Double preco = input.nextDouble();
        System.out.println("Fornecedor: ");
        input.nextLine();
        String fornecedor = input.nextLine();
        System.out.println("Categoria: ");
        String categoria = input.nextLine();
        String data;
        System.out.println("Data de Compra (DD/MM/AAAA): ");
        data = input.nextLine();
        p = new Produto(listaProdutos.getListaDeProdutos().size(),
                code,
                produto,
                preco,
                fornecedor,
                categoria,
                data);
        listaProdutos.addElemento(p);
        arq.criaArquivo();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}