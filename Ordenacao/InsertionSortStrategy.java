package Ordenacao;
import java.util.*;

import Produto.Produto;

public class InsertionSortStrategy implements OrdenacaoStrategy {
    private String criterio;

    public static final String CRIT_DESC_CRESC = "descricao_c";
	public static final String CRIT_PRECO_CRESC = "preco_c";
	public static final String CRIT_ESTOQUE_CRESC = "estoque_c";

    public InsertionSortStrategy(String criterio) {
        this.criterio = criterio;
    }

    @Override
    public void ordenar(List<Produto> produtos) {
        for (int i = 1; i < produtos.size(); i++) {
            Produto key = produtos.get(i);
            int j = i - 1;

            while (j >= 0 && compare(produtos.get(j), key) > 0) {
                produtos.set(j + 1, produtos.get(j));
                j--;
            }

            produtos.set(j + 1, key);
        }
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