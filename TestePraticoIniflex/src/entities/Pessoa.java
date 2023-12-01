package entities;

import java.time.LocalDate;

public class Pessoa implements  Comparable<Pessoa>{
    public String nome;
    public LocalDate dataNascimento;

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public int compareTo(Pessoa o) {
        return nome.compareTo(o.getNome());
    }
}
