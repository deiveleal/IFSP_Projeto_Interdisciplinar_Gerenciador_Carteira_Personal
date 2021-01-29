package src;

public class Produto {
    private Double valor;
    private String cidade
    
}


public class CalculadoraDePrecos_Refatorado {

    public double calcula(Compra produto) {
        TabelaDePrecoPadrao tabela = new TabelaDePrecoPadrao();
        Frete correios = new Frete();

        double desconto = tabela.descontoPara(produto.getValor());
        double frete = correios.para(produto.getCidade());

        return produto.getValor() * (1 - desconto) + frete;
    }
}



public class TabelaDePrecoPadrao {

    public double descontoPara(double valor) {
        if (valor > 5000) {
            return 0.03;
        }
        if (valor > 1000) {
            return 0.05;
        }
        return 0;
    }
}

public class Frete {

    public double para(String cidade) {
        if ("SAO PAULO".equals(cidade.toUpperCase())) {
            return 15;
        }
        return 30;
    }
}

 //   BEGIN

public interface DescontoStrategy {
    Double calcula(Produto produto);
}

//public class 
        
public interface FreteCidadeStrategy {
    Double calcula(Produto produto);
}

public class FreteSaoPauloConcreteStrategy implements FreteCidadeStrategy{

}
    
public class CalculadoraDePreco(){

    public double calcula(DescontoStrategy desconto, Compra produto){
        return desconto.calcula(produto.getValor());
    }

}