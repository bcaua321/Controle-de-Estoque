package com.company.Produtos;

import com.company.controllers.Produto;
import com.company.Produtos.Lista;
import com.company.controllers.ProdutoPerecivel;

import java.io.*;
import java.util.ArrayList;

public class Arquivo {
    public Lista lista = new Lista();
    public String listaProdutos(ArrayList<Produto> produtos){
        String lista = "";

        for (Produto produto: produtos) {
            lista += produto.getProdutoEh() + "," +
                    produto.getCodigo() + "," +
                    produto.getProduto() + "," +
                    produto.getFornecedor() + "," +
                    produto.getCategoria() +  "," +
                    produto.getDataDeCompra() + "\n";
        }

        return lista;
    }

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

    public void lerArquivo(){
        try {
            FileReader arq = new FileReader("src/com/company/Produtos/dados.txt");
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {
                String[] arrayLinha = this.trataString(linha);
                ProdutoPerecivel produtoPerecivel = new ProdutoPerecivel(Integer.parseInt(arrayLinha[1]), arrayLinha[2], arrayLinha[3], arrayLinha[4], arrayLinha[5]);
                this.lista.addElemento(produtoPerecivel);
                linha = lerArq.readLine();
            }

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na conexão com base dados\n");
        }
    }

    private String[] trataString (String linha){
        return linha.split(",");
    }
}
