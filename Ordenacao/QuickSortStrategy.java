package Ordenacao;
import java.util.*;

import Produto.Produto;

public class QuickSortStrategy implements OrdenacaoStrategy {
    private String criterio;

    public static final String CRIT_DESC_CRESC = "descricao_c";
	public static final String CRIT_PRECO_CRESC = "preco_c";
	public static final String CRIT_ESTOQUE_CRESC = "estoque_c";

    public QuickSortStrategy(String criterio) {
        this.criterio = criterio;
    }

    @Override
    public void ordenar(List<Produto> produtos) {
        ordena(produtos, 0, produtos.size() - 1);
    }

    private void ordena(List<Produto> produtos, int ini, int fim) {
        // Implementação do QuickSort de acordo com o critério de ordenação
        // (criterio) que pode ser "descricao_c", "preco_c" ou "estoque_c".
        if (ini < fim) {
            int pivotIndex = partition(produtos, ini, fim);
            ordena(produtos, ini, pivotIndex - 1);
            ordena(produtos, pivotIndex + 1, fim);
        }
    }


    private int partition(List<Produto> produtos, int ini, int fim) {
        Produto pivot = produtos.get(fim);
        int i = ini - 1;

        for (int j = ini; j < fim; j++) {
            if (compare(produtos.get(j), pivot) < 0) {
                i++;
                swap(produtos, i, j);
            }
        }

        swap(produtos, i + 1, fim);
        return i + 1;
    }

    // Método auxiliar para trocar elementos no produtosay
    private void swap(List<Produto> produtos, int i, int j) {
        Produto temp = produtos.get(i);
        produtos.set(i, produtos.get(j));
        produtos.set(j, temp);
    }

    private int compare(Produto p1, Produto p2) {
        if (criterio.equals(CRIT_DESC_CRESC)) {
            return p1.getDescricao().compareToIgnoreCase(p2.getDescricao());
        } else if (criterio.equals(CRIT_PRECO_CRESC)) {
            if (p1.getPreco() < p2.getPreco()) {
                return -1; 
            } else if (p1.getPreco() > p2.getPreco()) {
                return 1; 
            } else {
                return 0; 
            }
        } else if (criterio.equals(CRIT_ESTOQUE_CRESC)) {
            if (p1.getQtdEstoque() < p2.getQtdEstoque()) {
                return -1; 
            } else if (p1.getQtdEstoque() > p2.getQtdEstoque()) {
                return 1; 
            } else {
                return 0; 
            }
        } else {
            throw new IllegalArgumentException("Invalid sorting criterion: " + criterio);
        }
    }
}


