package com.company.view;

import com.company.Produtos.Lista;
import com.company.controllers.Produto;
import com.company.controllers.ProdutoNaoPerecivel;
import com.company.controllers.ProdutoPerecivel;

import java.io.IOException;
import java.util.Scanner;

public class Cadastrar extends MenuPrincipal{
    private static Scanner input = new Scanner(System.in);
    public void cadastrarProduto() throws IOException, InterruptedException {
        System.out.println("1 - Produto Perecivel");
        System.out.println("2 - Produto Não Perecivel");
        System.out.println("3 - Voltar");

        int valor = input.nextInt();
        switch (valor){
            case 1:
                Produto p = new ProdutoPerecivel();
                super.lista.cadastrar(p);
                cadastrarProduto();
                break;
                case 2:
                    Produto p1 = new ProdutoNaoPerecivel();
                    super.lista.cadastrar(p1);
                    cadastrarProduto();
                    break;
                    case 3:
                    super.mostrarMenuPrincipal();
                    break;
                default:
                    System.out.println(":)");

        }
    }
}