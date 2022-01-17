package com.company.Produtos;

import com.company.controllers.Produto;
import com.company.controllers.ProdutoNaoPerecivel;
import com.company.controllers.ProdutoPerecivel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lista {
    private static ArrayList<Produto> listaDeProdutos = new ArrayList<Produto>();
    public void addElemento(Produto produto){
        Lista.listaDeProdutos.add(produto);
    }
    public void removeElemento(int index){
        Lista.listaDeProdutos.remove(index);
    }

    public ArrayList<Produto> getListaDeProdutos() {
        return Lista.listaDeProdutos;
    }

    public ArrayList<Produto> cadastrar(Produto p){
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
        if(p instanceof ProdutoPerecivel){
            System.out.println("Data de Validade: ");
            data = input.nextLine();
            p = new ProdutoPerecivel(code,
                    produto,
                    fornecedor,
                    categoria,
                    data);
        } else {
            System.out.println("Data de Compra: ");
            data = input.nextLine();
            p = new ProdutoNaoPerecivel(code, produto, fornecedor, categoria, data);
        }

        this.addElemento(p);
        return this.getListaDeProdutos();
    }
}
