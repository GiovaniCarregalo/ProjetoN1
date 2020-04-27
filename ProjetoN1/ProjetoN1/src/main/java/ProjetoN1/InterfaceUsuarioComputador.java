package ProjetoN1;

import ProjetoN1.entidade.Computador;
import ProjetoN1.persistencia.ComputadorDAO;

import java.util.List;
import java.util.Scanner;

public class InterfaceUsuarioComputador {
    ComputadorDAO dao;
    Scanner in;

    public InterfaceUsuarioComputador(ComputadorDAO dao) {
        this.dao = dao;
        this.in = new Scanner(System.in);
    }
    public void iniciar() {
        imprimirMenu();
    }

    private void imprimirMenu() {
        int opc = 0;
        do {
            System.out.println("\n==============");
            System.out.println("==== Menu ====");
            System.out.println("==============");
            System.out.println("\t1. Create");
            System.out.println("\t2. Read");
            System.out.println("\t3. Update");
            System.out.println("\t4. Delete");
            System.out.println("\t5. sair");
            System.out.print("Escolha uma opção: ");
            opc = in.nextInt();
            in.nextLine();
            switch (opc) {
                case 1:
                    this.create();
                    break;
                case 2:
                    this.read();
                    break;
                case 3:
                    this.update();
                    break;
                case 4:
                    this.delete();
                    break;
                case 5:
                    System.out.println("tchau :)");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }
        while (opc != 5);
    }
    private void create() {
        Computador computador = new Computador();
        System.out.println("\n******************");
        System.out.println("*** Novo computador ***");
        System.out.println("******************");
        System.out.print("Informe o Marca do computador: ");
        computador.setMarca(in.nextLine());
        System.out.print("Informe o Processador do computador: ");
        computador.setProcessador(in.nextLine());
        System.out.print("Informe o Quantidade de RAM do computador: ");
        computador.setQuantidade_de_ram(in.nextInt());
        in.nextLine();
        System.out.print("Informe o Tamanho do Disco do computador: ");
        computador.setTamanho_do_disco(in.nextInt());
        if (dao.create(computador)) {
            System.out.println("Computador adicionado ao banco de Dados");
        }
        else {
            System.out.println("Ops: problema ao adicionar o computador");
        }
    }
    private void read() {
        List<Computador> computadores = dao.read();
        System.out.println("\n***********************************");
        System.out.println("*** Lista de Computadores Cadastrados ***");
        System.out.println("***********************************");
        for(Computador computador : computadores) {
            System.out.println(computador);
        }
    }
    private void update(){
        Computador computador = new Computador();

        System.out.println(" Atualizar um Computador ");
        System.out.println("Insira o ID do computador que deseja modificar: ");
        computador.setId(in.nextLong());
        in.nextLine();

        System.out.println("Altere o nome da marca: ");
        computador.setMarca(in.nextLine());

        System.out.println("Altere do nome do processador: ");
        computador.setProcessador(in.nextLine());

        System.out.println("Altere a quantidade de ram: ");
        computador.setQuantidade_de_ram(in.nextInt());
        System.out.println("Altere o tamanho do disco: ");
        computador.setTamanho_do_disco(in.nextInt());

        if(dao.update(computador)){
            System.out.println("Computador atualizado no Banco de Dados");
        } else{
            System.out.println("Ops: problema ao adicionar aplicativo");
        }
    }
    private void delete() {
        List<Computador> computadores = dao.read();
        while (true) {
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Computadores Cadastrados ***");
            System.out.println("***********************************");
            int i = 0;
            for (Computador computador : computadores) {
                System.out.println(i + " - " + computador);
                i++;
            }
            System.out.println(i + " - Cancelar operação");
            System.out.print("Qual carro deseja remover? ");
            int opc = in.nextInt();
            in.nextLine();
            if (opc==i) {
                break;
            }
            if (opc >= computadores.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            }
            else {
                if (dao.delete(computadores.get(opc))) {
                    System.out.println("Computador " + computadores.get(opc).getMarca() +
                            " removido com sucesso");
                }
                else {
                    System.out.println("OPS: falar ao tentar remover");
                }
                break;
            }
        }
    }
}