package ProjetoN1.persistencia;

import java.util.List;
import ProjetoN1.entidade.Carro;

public interface CarroDAO
{
    boolean create (Carro carro);
    List<Carro> read ();
    boolean update(Carro carro);
    boolean delete(Carro carro);
}
