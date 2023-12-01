package entities;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;

public class Funcionario extends Pessoa {
    public BigDecimal salario;
    public String funcao;

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
    public String getFuncao() {
        return funcao;
    }

    public void setFuncao() {
        this.funcao = funcao;
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String toString() {
        return  "|" + String.format("%-19s",nome)
                + "|" + dataNascimento.format(formatter) + "\t\t\t\t\t\t"
                + "|" + String.format("%.2f", salario) +"\t\t\t\t"
                + "|" + String.format("%-19s|\n",funcao)
                + "-------------------------------------------------------------------------------------------------" + "\n";
    }

}
