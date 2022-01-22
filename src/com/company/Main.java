package com.company;
import com.company.Produtos.Arquivo;
import com.company.view.MenuPrincipal;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Arquivo arq = new Arquivo();
        arq.lerArquivo();
        MenuPrincipal menu = new MenuPrincipal();
        menu.mostrarMenuPrincipal();

    }
}
