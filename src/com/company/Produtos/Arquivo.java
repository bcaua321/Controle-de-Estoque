package com.company.Produtos;

import com.company.controllers.Produto;
import com.company.Produtos.Lista;
import com.company.controllers.ProdutoNaoPerecivel;
import com.company.controllers.ProdutoPerecivel;

import java.io.*;
import java.util.ArrayList;

public class Arquivo {
    public Lista lista = new Lista();

    // Para formatar o ArrayList no arquivo
    public String listaProdutos(ArrayList<Produto> produtos){
        String lista = "";

        for (Produto produto: produtos) {
            lista += produto.getProdutoEh() + "," +
                    produto.getId() + "," +
                    produto.getCodigo() + "," +
                    produto.getProduto() + "," +
                    produto.getFornecedor() + "," +
                    produto.getCategoria() +  ",";
                    if(produto instanceof ProdutoPerecivel){
                      String data = ((ProdutoPerecivel) produto).getDataDeValidade();
                        lista += data +"\n";
                    } else {
                        String data = ((ProdutoNaoPerecivel) produto).getDataDeCompra();
                        lista += data +"\n";
                    }

        }

        return lista;
    }

    // FUnção para criar um arquivo com o ArrayList, sempre será chamado quando for criar, atualizar e deletar um produto.
    public void criaArquivo(){
        FileWriter arquivo;
        String lista = listaProdutos(this.lista.getListaDeProdutos());

        try {
            arquivo = new FileWriter(new File("src/com/company/Produtos/dados.txt"));
            arquivo.write(lista);
            arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Será chamado somente no início do programa
    public void lerArquivo(){
        try {
            FileReader arq = new FileReader("src/com/company/Produtos/dados.txt");
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {
                String[] arrayLinha = linha.split(",");
                if(arrayLinha[0] == "perecivel"){
                    ProdutoPerecivel produtoPerecivel = new ProdutoPerecivel(Integer.parseInt(arrayLinha[1]), Integer.parseInt(arrayLinha[2]), arrayLinha[3], arrayLinha[4], arrayLinha[5], arrayLinha[6]);
                    this.lista.addElemento(produtoPerecivel);
                } else  {
                    ProdutoNaoPerecivel produtoNPerecivel = new ProdutoNaoPerecivel(Integer.parseInt(arrayLinha[1]), Integer.parseInt(arrayLinha[2]), arrayLinha[3], arrayLinha[4], arrayLinha[5], arrayLinha[6]);
                    this.lista.addElemento(produtoNPerecivel);
                }

                linha = lerArq.readLine();
            }

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na conexão com base dados\n");
        }
    }
}
