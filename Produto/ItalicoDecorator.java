package Produto;
public class ItalicoDecorator extends ProdutoDecorator {

    public ItalicoDecorator(Produto produto) {
        super(produto);
    }

    @Override
    public String formataParaImpressao() {
        return "<span style=\"font-style:italic\">\n" + super.formataParaImpressao() + "</span>";
    }
}
