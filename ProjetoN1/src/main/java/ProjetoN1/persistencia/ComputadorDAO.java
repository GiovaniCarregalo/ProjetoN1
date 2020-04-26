package ProjetoN1.persistencia;

import java.util.List;
import ProjetoN1.entidade.Computador;

public interface ComputadorDAO
{
    boolean create (Computador computador);
    List<Computador> read ();
    boolean update(Computador computador);
    boolean delete(Computador computador);
}