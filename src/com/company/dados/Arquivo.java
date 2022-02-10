package com.company.dados;

import com.company.produto.Produto;

import java.io.*;
import java.util.ArrayList;

public class Arquivo {
    public Lista lista = new Lista();
    private String path = "src/com/company/dados/dados.txt";

    // Função para criar um arquivo com o ArrayList, sempre será chamado quando for criar, atualizar e deletar um produto.
    public void criaArquivo(){
        FileWriter arquivo;
        String lista = listaProdutos(this.lista.getListaDeProdutos());

        try {
            arquivo = new FileWriter(new File(path));
            arquivo.write(lista);
            arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Para formatar o ArrayList no arquivo
    public String listaProdutos(ArrayList<Produto> produtos){
        String lista = "";

        for (Produto produto: produtos) {
            lista += produto.getId() + "," +
                    produto.getCodigo() + "," +
                    produto.getProdutoNome() + "," +
                    produto.getPreco() + "," +
                    produto.getFornecedor() + "," +
                    produto.getCategoria() +  "," +
                    produto.getDataDeCompra() + "\n";
        }

        return lista;
    }

    // Será chamado somente no início do programa, para ler o que tem no arquivo .txt e passar ao arraylist
    public void lerArquivo(){
        try {
            FileReader arq = new FileReader(path);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {
                String[] arrayLinha = linha.split(",");
                Produto produto = new Produto(Integer.parseInt(arrayLinha[0]), Integer.parseInt(arrayLinha[1]), arrayLinha[2], Double.parseDouble(arrayLinha[3]), arrayLinha[4], arrayLinha[5], arrayLinha[6]);
                this.lista.addElemento(produto);

                linha = lerArq.readLine();
            }

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na conexão com base dados\n");
        }
    }
}
