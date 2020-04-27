package ProjetoN1;

import ProjetoN1.entidade.Carro;
import ProjetoN1.persistencia.CarroDAO;

import java.util.List;
import java.util.Scanner;

public class InterfaceUsuarioCarro {
    CarroDAO dao;
    Scanner in;

    public InterfaceUsuarioCarro(CarroDAO dao) {
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
        Carro carro = new Carro();
        System.out.println("\n******************");
        System.out.println("*** Novo carro ***");
        System.out.println("******************");
        System.out.print("Informe o MODELO do carro: ");
        carro.setModelo(in.nextLine());
        System.out.print("Informe o MARCA do carro: ");
        carro.setMarca(in.nextLine());
        System.out.print("Informe o ANO do carro: ");
        carro.setAno(in.nextInt());
        in.nextLine();
        System.out.print("Informe o CATEGORIA do carro: ");
        carro.setCategoria(in.nextLine());
        if (dao.create(carro)) {
            System.out.println("Carro adicionado ao banco de Dados");
        }
        else {
            System.out.println("Ops: problema ao adicionar o carro");
        }
    }
    private void read() {
        List<Carro> carros = dao.read();
        System.out.println("\n***********************************");
        System.out.println("*** Lista de Carros Cadastrados ***");
        System.out.println("***********************************");
        for(Carro carro : carros) {
            System.out.println(carro);
        }
    }
    private void update(){
        Carro carro = new Carro();

        System.out.println(" Atualizar um Carro ");
        System.out.println("Insira o ID do carro que deseja modificar: ");
        carro.setId(in.nextLong());
        in.nextLine();

        System.out.println("Altere o nome da marca: ");
        carro.setMarca(in.nextLine());

        System.out.println("Altere do nome do modelo: ");
        carro.setModelo(in.nextLine());

        System.out.println("Altere o ano: ");
        carro.setAno(in.nextInt());
        System.out.println("Altere a categoria: ");
        carro.setCategoria(in.nextLine());

        if(dao.update(carro)){
            System.out.println("Carro atualizado no Banco de Dados");
        } else{
            System.out.println("Ops: problema ao adicionar aplicativo");
        }
    }
    private void delete() {
        List<Carro> carros = dao.read();
        while (true) {
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Carros Cadastrados ***");
            System.out.println("***********************************");
            int i = 0;
            for (Carro carro : carros) {
                System.out.println(i + " - " + carro);
                i++;
            }
            System.out.println(i + " - Cancelar operação");
            System.out.print("Qual carro deseja remover? ");
            int opc = in.nextInt();
            in.nextLine();
            if (opc==i) {
                break;
            }
            if (opc >= carros.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            }
            else {
                if (dao.delete(carros.get(opc))) {
                    System.out.println("Carro " + carros.get(opc).getMarca() +
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