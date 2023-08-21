package Filtro;
import java.util.ArrayList;
import java.util.List;

import Produto.Produto;

public class FiltroCategoria implements FiltroStrategy {
    @Override
    public List<Produto> filtrar(List<Produto> produtos, String argumento) {
        String categoriaFiltro = argumento.toLowerCase();
        List<Produto> produtosFiltrados = new ArrayList<>();

        for (Produto produto : produtos) {
            if (produto.getCategoria().equalsIgnoreCase(categoriaFiltro)) {
                produtosFiltrados.add(produto);
            }
        }

        return produtosFiltrados;
    }    
}
