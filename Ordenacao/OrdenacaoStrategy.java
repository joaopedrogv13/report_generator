package Ordenacao;
import java.util.*;

import Produto.Produto;

public interface OrdenacaoStrategy {
    void ordenar(List<Produto> produtos);
}