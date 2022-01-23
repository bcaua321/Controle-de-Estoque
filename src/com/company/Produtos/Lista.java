package com.company.Produtos;

import com.company.controllers.Produto;
import com.company.controllers.ProdutoNaoPerecivel;
import com.company.controllers.ProdutoPerecivel;

import java.util.ArrayList;
import java.util.Scanner;


public class Lista {
    protected static ArrayList<Produto> listaDeProdutos = new ArrayList<Produto>();

    public void addElemento(Produto produto){
        Lista.listaDeProdutos.add(produto);
    }

    public void removeElemento(int index){
        Arquivo arq = new Arquivo();
        Lista.listaDeProdutos.remove(index);
        arq.criaArquivo();
    }

    public ArrayList<Produto> getListaDeProdutos() {
        return Lista.listaDeProdutos;
    }

    public void cadastrar(ProdutoNaoPerecivel p){
        Arquivo arq = new Arquivo();
        Scanner input = new Scanner(System.in);
        System.out.println("--- Cadastro de Produto ---");
        System.out.println("Código: ");
        int code = input.nextInt();
        System.out.println("Produto: ");
        input.nextLine();
        String produto = input.nextLine();
        System.out.println("Fornecedor: ");
        String fornecedor = input.nextLine();
        System.out.println("Categoria: ");
        String categoria = input.nextLine();
        String data;
        System.out.println("Data de Compra: ");
        data = input.nextLine();
        p = new ProdutoNaoPerecivel(listaDeProdutos.size(),
                code,
                produto,
                fornecedor,
                categoria,
                data);
        this.addElemento(p);
        arq.criaArquivo();
    }
    public void cadastrar(ProdutoPerecivel p) {
        Arquivo arq = new Arquivo();
        Scanner input = new Scanner(System.in);
        System.out.println("--- Cadastro de Produto ---");
        System.out.println("Código: ");
        int code = input.nextInt();
        System.out.println("Produto: ");
        input.nextLine();
        String produto = input.nextLine();
        System.out.println("Fornecedor: ");
        String fornecedor = input.nextLine();
        System.out.println("Categoria: ");
        String categoria = input.nextLine();
        System.out.println("Data de Validade: ");
        String data = input.nextLine();;
        p = new ProdutoPerecivel(listaDeProdutos.size(),
                code,
                produto,
                fornecedor,
                categoria,
                data);
        this.addElemento(p);
        arq.criaArquivo();
    }
}
