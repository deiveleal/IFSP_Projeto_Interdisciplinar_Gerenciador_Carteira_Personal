/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author carolina
 */
public class ProvaASW_Refatorada {
    
}

//ex01
package src;


public class Funcionario {

    private int id;
    private String nome;
    private Cargo cargo;
    private Calendar dataDeAdmissao;
    private double salarioBase;

    public Funcionario(int id, String nome, Cargo cargo, 
        Calendar dataDeAdmissao, double salarioBase) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.dataDeAdmissao = dataDeAdmissao;
        this.salarioBase = salarioBase;
    }
       
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Calendar getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setDataDeAdmissao(Calendar dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

}

public interface RegraDeCalculoStrategy {
    double calcula(Funcionario funcionario);
}

public class DezOuVintePorCentoConcreteStrategy implements RegraDeCalculoStrategy {

    public double calcula(Funcionario funcionario) {
        if (funcionario.getSalarioBase() > 3000.0) {
            return funcionario.getSalarioBase() * 0.8;
        } else {
            return funcionario.getSalarioBase() * 0.9;
        }
    }
}

public class QuinzeOuVinteCincoPorCentoConcreteStrategy implements
        RegraDeCalculoStrategy {

    public double calcula(Funcionario funcionario) {
        if (funcionario.getSalarioBase() > 2000.0) {
            return funcionario.getSalarioBase() * 0.75;
        } else {
            return funcionario.getSalarioBase() * 0.85;
        }
    }
}

public enum Cargo {
    DESENVOLVEDOR(new DezOuVintePorCentoConcreteStrategy()),
    DBA(new QuinzeOuVinteCincoPorCentoConcreteStrategy()),
    TESTER(new QuinzeOuVinteCincoPorCentoConcreteStrategy());
    
    private RegraDeCalculo regra;

    Cargo(RegraDeCalculo regra) {
        this.regra = regra;
    }

    public RegraDeCalculo getRegra() {
        return regra;
    }
}

//ex02

public class CalculadoraDePrecos {

    private TabelaDePreco tabela;
    private Frete frete;

    public CalculadoraDePrecos(TabelaDePreco tabela, Frete frete) {
        this.tabela = tabela;
        this.frete = frete;
    }

    public double calcula(Compra produto) {
        double desconto = tabela.fatorDesconto(produto.getValor());
        double frete = frete.para(produto.getCidade());
        return produto.getValor() * (1 - desconto) + frete;
    }
}

public interface TabelaDePreco {
    double fatorDesconto(double valor);
}

public class TabelaDePrecoREGRA1 implements TabelaDePreco  {
    public double fatorDesconto(double valor) {
        if (valor > 5000) {
            return 0.03;
        }
        if (valor > 1000) {
            return 0.05;
        }
        return 0;
    }
}


public interface Frete {
    double para(String cidade);
}

public class FreteRegra1 implements Frete {
    double para(String cidade){
        if ("SAO PAULO".equals(cidade.toUpperCase())) {
            return 15;
        }
        return 30;
    }
}


//ex03
public class ProcessadorDeBoletos_Refatorado {

    public void processa(List<Boleto> boletos, Fatura fatura) {
        for (Boleto boleto : boletos) {
            Pagamento pagamento = new Pagamento(boleto.getValor(), 
            MeioDePagamento.BOLETO);
            fatura.adicionaPagamento(pagamento);
        }
    }
}

public class Boleto {

    private double valor;

    public Boleto(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

}

public class Fatura {

    private String cliente;
    private double valor;
    private List<Pagamento> pagamentos;
    private boolean pago;

    public void adicionaPagamento(Pagamento pagamento) {
        this.pagamentos.add(pagamento);
        if (valorTotalDosPagamentos() > this.valor) {
            this.pago = true;
        }
    }

    private double valorTotalDosPagamentos() {
        double total = 0;
        for (Pagamento p : pagamentos) {
            total += p.getValor();
        }
        return total;
    }
}

public enum MeioDePagamento {
    BOLETO,
    CARTAO
}

public class Pagamento {

    private double valor;
    private MeioDePagamento forma;

    public Pagamento(double valor, MeioDePagamento forma) {
        this.valor = valor;
        this.forma = forma;
    }
}

//ex04

public class ProcessadorDeInvestimentos {

    public static void main(String[] args) {
        for (ContaComum conta : listaContaComum()) {
            conta.rende();

            System.out.println("Novo Saldo:");
            System.out.println(conta.getSaldo());
        }
    }

    private static List<ContaComum> listaContaComum() {
        return Arrays.asList(contaComumCom(100), contaComumCom(150));
    }

    private static List<ContaComum> listaContaEstudante() {
        return Arrays.asList(contaDeEstudanteCom(200));
    }

    private static ContaDeEstudante contaDeEstudanteCom(double amount) {
        ContaDeEstudante c = new ContaDeEstudante();
        c.deposita(amount);
        return c;
    }

    private static ContaComum contaComumCom(double valor) {
        ContaComum c = new ContaComum();
        c.deposita(valor);
        return c;
    }
}

public class OperacoesDeConta {

    private double saldo;

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double getSaldo() {
        return saldo;
    }
}

public class ContaComum {

    private OperacoesDeConta operacoesDeConta;

    public ContaComum() {
        this.operacoesDeConta = new OperacoesDeConta();
    }

    public void saca(double valor) {
        operacoesDeConta.depositar(valor);
    }

    public void rende() {
        operacoesDeConta.saldo += this.saldo * 0.01;
    }
}

public class ContaDeEstudante {

    private OperacoesDeConta operacoesDeConta;
    private int milhas;

    public ContaDeEstudante() {
        this.operacoesDeConta = new OperacoesDeConta();
    }

    public int getMilhas() {
        return milhas;
    }

}
