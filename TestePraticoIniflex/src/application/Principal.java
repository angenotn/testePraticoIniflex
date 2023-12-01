package application;



import entities.Funcionario;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.lang.System.out;

public class Principal {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Funcionario> funcionarios = new ArrayList<>();

        int opcao = 0;

        do { //ok
            out.println("=== MENU ===");
            out.println("1- Cadastrar Funcionário");
            out.println("2- Remover o 'João' da lista");
            out.println("3- Tabela de funcionários");
            out.println("4- Aumento de salário em 10% para todos os funcionários");
            out.println("5- Funcionários por função");
            out.println("6- Aniversariantes dos meses 10 e 12");
            out.println("7- Funcionário com maior idade");
            out.println("8- Lista de funcionários por ordem alfabética");
            out.println("9- Total de salários dos funcionários");
            out.println("10- Salários mínimos por funcionário");
            out.println("0- Sair");
            out.println();
            out.print("Opção escolhida: ");
            opcao = sc.nextInt();
            out.println();

            switch (opcao) {
                case 1: //100% funcionando
                    char escolha = ' ';
                    do {
                        out.println("=== CADASTRO DE FUNCIONÁRIO ===");
                        Funcionario funcionario = new Funcionario();
                        sc.nextLine();
                        out.print("Nome: ");
                        funcionario.nome = sc.nextLine();
                        out.print("Data de Nascimento: ");
                        funcionario.dataNascimento = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        out.print("Salário: ");
                        funcionario.salario = sc.nextBigDecimal();
                        sc.nextLine();
                        out.print("Função: ");
                        funcionario.funcao = sc.nextLine();
                        funcionarios.add(funcionario);

                        out.print("Deseja cadastrar outro funcionário? (s/n): ");
                        escolha = sc.next().charAt(0);
                    } while (escolha == 'S' || escolha == 's');
                    break;
                case 2: //100% funcionando
                    out.println("=== EXCLUSÃO DE JOÃO===");
                    funcionarios.removeIf(func -> Objects.equals(func.getNome(), "João"));
                    out.println("O João foi excluido com sucesso");
                    out.println("Confira a tabela atualizada escolhendo a opção 3");
                    out.println("-----------------------------------------------");
                    out.println();
                    break;
                case 3: //100% funcionando
                    out.println("\t\t\t\t\t\t\t=== FUNCIONÁRIOS CADASTRADOS ===");
                    out.println("-------------------------------------------------------------------------------------------------");
                    out.println("|Nome\t\t\t\t|Data de Nascimento\t\t\t\t|Salário\t\t\t\t|Função\t\t\t\t|");
                    out.println("-------------------------------------------------------------------------------------------------");

                    for (Funcionario funcionario : funcionarios) {
                        out.print(funcionario);
                    }
                    break;
                case 4: //100% funcionando
                    out.println("=== AUMENTO DE SALÁRIO EM 10% P/ TODOS OS FUNCIONÁRIOS ===");
                    out.println();
                    for (int i = 0; i < funcionarios.size(); i++) {
                        Funcionario funcionario = funcionarios.get(i);
                        BigDecimal aumento = BigDecimal.valueOf(0.10);
                        BigDecimal salarioFinal = funcionario.salario;
                        salarioFinal = salarioFinal.add(funcionario.salario.multiply(aumento));
                        funcionario.setSalario(salarioFinal);
                    }
                    out.println("Todos os funcionários ganharam um aumento de 10%");
                    out.println("Confira a tabela atualizada escolhendo a opção 3");
                    out.println("-------------------------------------------------------");
                    out.println();
                    break;
                case 5://100% funcionando
                    out.println("=== FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO ===");
                    out.println("-----------------------------------------------");
                    Map<String, String> funcionarioPorFuncao = new HashMap<>();
                    for (int i = 0; i < funcionarios.size(); i++) {
                        Funcionario funcionario = funcionarios.get(i);

                        if (funcionarioPorFuncao.get(funcionario.funcao) == null) {
                            funcionarioPorFuncao.put(funcionario.funcao, funcionario.nome);
                        } else {
                            funcionarioPorFuncao.put(funcionario.funcao, funcionario.nome + "\n" + funcionarioPorFuncao.get(funcionario.funcao));
                        }
                    }

                    for (String key : funcionarioPorFuncao.keySet()) {
                        out.println(key);
                        out.println();
                        out.println(funcionarioPorFuncao.get(key));
                        out.println("-----------------------------------------------");
                    }
                    out.println();
                    break;
                case 6: //100% funcionando
                    System.out.println("=== ANIVERSARIANTES DOS MESES 10 E 12 ===");
                    System.out.println("-----------------------------------------------");
                    for (int i = 0; i < funcionarios.size(); i++) {
                        Funcionario funcionario = funcionarios.get(i);
                        LocalDate data = funcionario.dataNascimento;

                        if (data.getMonthValue() == 10 || data.getMonthValue() == 12) {
                            System.out.println(funcionario.nome);
                        }
                    }
                    System.out.println("-----------------------------------------------");
                    System.out.println();
                    break;
                case 7: //100% funcionando
                    out.println("=== FUNCIONÁRIO COM MAIOR IDADE ===");
                    out.println("-----------------------------------------------");
                    List <Integer> ano = new ArrayList<>();

                    for (int i = 0; i < funcionarios.size(); i++) {
                        Funcionario funcionario = funcionarios.get(i);
                        ano.add(funcionario.dataNascimento.getYear());
                    }

                    Integer maisVelho = Collections.min(ano);

                    for (int i = 0; i < funcionarios.size(); i++) {
                        Funcionario funcionario = funcionarios.get(i);
                        if (funcionario.dataNascimento.getYear() == maisVelho) {
                            out.println("Funcionário: " + funcionario.nome);
                            int idade = LocalDate.now().compareTo(funcionario.dataNascimento);
                            out.println("Idade: " + idade + " anos");
                            out.println("-----------------------------------------------");
                            out.println();
                        }
                    }
                    break;
                case 8: //100% funcionando
                    out.println("\t\t\t\t\t=== LISTA DE FUNCIONÁRIOS EM ORDEM ALFABÉTICA ===");
                    out.println("-------------------------------------------------------------------------------------------------");
                    out.println("|Nome\t\t\t\t|Data de Nascimento\t\t\t\t|Salário\t\t\t\t|Função\t\t\t\t|");
                    out.println("-------------------------------------------------------------------------------------------------");
                    Collections.sort(funcionarios);
                    for (int i = 0; i < funcionarios.size(); i++) {
                        Funcionario funcionario = funcionarios.get(i);
                        out.print(funcionario);
                    }
                    break;
                case 9: //100% funcionando
                    out.println("=== TOTAL DOS SALÁRIOS ===");
                    out.println("-----------------------------------------------");
                    BigDecimal totalSalario = BigDecimal.ZERO;
                    for (int i = 0; i < funcionarios.size(); i++) {
                        Funcionario funcionario = funcionarios.get(i);
                        totalSalario = totalSalario.add(funcionario.salario.setScale(2, RoundingMode.HALF_EVEN));
                    }
                    out.printf("Total dos salários: R$%.2f\n", totalSalario);
                    out.println("-----------------------------------------------");
                    out.println();
                    break;
                case 10: //100% funcionando
                    out.println("=== SALÁRIOS MÍNIMOS POR FUNCIONÁRIO ===");
                    //Funcionario funcionario = null;
                    BigDecimal salarioMinimo = BigDecimal.valueOf(1212);
                    BigDecimal divisao;
                    int cont = 0;
                    for (int i = 0; i < funcionarios.size(); i++) {
                        Funcionario funcionario = funcionarios.get(i);
                        divisao = funcionario.salario.divide(salarioMinimo, MathContext.DECIMAL32);
                        out.println("-----------------------------------------------");
                        System.out.println("Nome:" + funcionario.nome);
                        System.out.printf("Salários minimos: %d\n", divisao.intValue());

                    }
                    out.println("-----------------------------------------------");
                    break;
                case 0: //100% funcionando
                    out.println("Saindo...");
                    break;
                default:
                    out.println("Opção Inválida!");
                    out.println();
            }
        } while (opcao != 0);
        }
    }
