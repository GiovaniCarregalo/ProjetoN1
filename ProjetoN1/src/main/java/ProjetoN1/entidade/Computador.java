package ProjetoN1.entidade;

public class Computador {
    private long id;
    private String marca;
    private String processador;
    private int quantidade_de_ram;
    private int tamanho_do_disco;

    public Computador() {}

    public Computador(long id, String marca, String processador, int quantidade_de_ram, int
            tamanho_do_disco) {
        this.id = id;
        this.marca = marca;
        this.processador = processador;
        this.quantidade_de_ram = quantidade_de_ram;
        this.tamanho_do_disco = tamanho_do_disco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    @Override
    public String toString() {
        return "Computador{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", processador='" + processador + '\'' +
                ", quantidade de ram=" + quantidade_de_ram +
                ", tamanho do disco='" + tamanho_do_disco + '\'' +
                '}';
    }

    public int getQuantidade_de_ram() {
        return quantidade_de_ram;
    }

    public void setQuantidade_de_ram(int quantidade_de_ram) {
        this.quantidade_de_ram = quantidade_de_ram;
    }

    public int getTamanho_do_disco() {
        return tamanho_do_disco;
    }

    public void setTamanho_do_disco(int tamanho_do_disco) {
        this.tamanho_do_disco = tamanho_do_disco;
    }
}