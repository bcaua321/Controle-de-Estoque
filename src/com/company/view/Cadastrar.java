package com.company.view;

import com.company.Produtos.Lista;
import com.company.controllers.Produto;
import com.company.controllers.ProdutoNaoPerecivel;
import com.company.controllers.ProdutoPerecivel;

import java.io.IOException;
import java.util.Scanner;

public class Cadastrar {
    private static Scanner input = new Scanner(System.in);
    Lista lista = new Lista();
    public void cadastrarProduto() throws IOException, InterruptedException {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        while(true){
            System.out.println("1 - Produto Perecivel");
            System.out.println("2 - Produto Não Perecivel");
            System.out.println("3 - Voltar");

        int valor = input.nextInt();
            switch (valor){
                case 1:
                    Produto p = new ProdutoPerecivel();
                    lista.cadastrar(p);
                    break;
                case 2:
                    Produto p1 = new ProdutoNaoPerecivel();
                    lista.cadastrar(p1);
                    break;
                case 3:
                    menuPrincipal.mostrarMenuPrincipal();
                    break;
            }
        }
    }
}
