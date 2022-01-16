package com.company.view;

import com.company.controllers.Produto;

import java.util.ArrayList;

public class Mostrar {
    public static void mostrarProdutos (ArrayList<Produto> p){
        if(p.size() == 0) System.out.println("Nenhum produto cadastrado.");

        for (int i = 0; i < p.size(); i++){
            System.out.println('\n');
            System.out.println(p.get(i).toString());
            System.out.println('\n');
        }
    }
}
