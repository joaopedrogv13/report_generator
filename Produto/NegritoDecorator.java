package Produto;
public class NegritoDecorator extends ProdutoDecorator {

    public NegritoDecorator(Produto product) {
        super(product);
    }
    
    @Override
    public String formataParaImpressao() {
        return "<span style=\"font-weight:bold\">\n" + super.formataParaImpressao() + "</span>";
    }
}
