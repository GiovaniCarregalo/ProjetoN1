package ProjetoN1;

import ProjetoN1.persistencia.CarroDAOMySQL;
import ProjetoN1.persistencia.ComputadorDAOMySQL;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        int BD;
        System.out.println("Bem Vindo ao projeto da N1 de programaçâo de sistemas!");
        System.out.println("Escolha o tema do banco de dados para usar o CRUD do mesmo!");
        System.out.println("Para usar o Banco de dados 'Carro' digite o numero 1");
        System.out.println("Para usar o Banco de dados 'Computador'' digite o numero 2");
        BD = print.nextInt();
        if (BD == 1) {
            CarroDAOMySQL carroDAO = new CarroDAOMySQL();
            InterfaceUsuarioCarro carro = new InterfaceUsuarioCarro(carroDAO);
            carro.iniciar();
        }
        else if (BD == 2) {
            ComputadorDAOMySQL computadorDAO = new ComputadorDAOMySQL();
            InterfaceUsuarioComputador computador = new InterfaceUsuarioComputador(computadorDAO);
            computador.iniciar();
        }
        else {
            System.out.println("Opção escolhida não existente");
        }
    }
}