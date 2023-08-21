package Filtro;
import java.util.*;

import Produto.Produto;

public interface FiltroStrategy {
    List<Produto> filtrar(List<Produto> produtos, String argumento);
}
