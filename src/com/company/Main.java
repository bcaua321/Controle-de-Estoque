package com.company;
import com.company.dados.Arquivo;
import com.company.menus.MenuPrincipal;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Arquivo arq = new Arquivo();
        arq.lerArquivo();
        MenuPrincipal menu = new MenuPrincipal();
        menu.mostrarMenuPrincipal();
    }
}
