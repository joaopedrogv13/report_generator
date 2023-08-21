package Filtro;
import java.util.ArrayList;
import java.util.List;

import Produto.Produto;

public class FiltroEstoque implements FiltroStrategy {
    @Override
    public List<Produto> filtrar(List<Produto> produtos, String argumento) {
        int estoqueMaximo = Integer.parseInt(argumento);
        List<Produto> produtosFiltrados = new ArrayList<>();

        for (Produto produto : produtos) {
            if (produto.getQtdEstoque() <= estoqueMaximo) {
                produtosFiltrados.add(produto);
            }
        }

        return produtosFiltrados;
    }
}
