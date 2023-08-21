package Produto;
public class CorDecorator extends ProdutoDecorator {
    private String cor;

    public CorDecorator(Produto produto, String cor) {
        super(produto);
        this.cor = cor.toLowerCase();
    }

    @Override
    public String formataParaImpressao() {
        return "<span style=\"color: " + cor + "\">\n" + super.formataParaImpressao() + "</span>";
    }
}
