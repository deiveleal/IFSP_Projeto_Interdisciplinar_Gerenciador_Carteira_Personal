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
