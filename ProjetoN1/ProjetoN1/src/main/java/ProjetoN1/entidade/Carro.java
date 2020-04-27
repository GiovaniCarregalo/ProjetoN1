package ProjetoN1.entidade;

public class Carro {
    private long id;
    private String modelo;
    private String marca;
    private int ano;
    private String categoria;

    public Carro() {}

    public Carro(long id, String modelo, String marca,int ano,String categoria) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.ano=ano;
        this.categoria=categoria;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", ano=" + ano +
                ", categoria='" + categoria + '\'' +
                '}';
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}