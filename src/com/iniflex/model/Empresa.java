package com.iniflex.model;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Empresa {
	private String nome;
	private List<Funcionario> funcionarios;
			
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public Map<String, List<Funcionario>> imprimirFuncionariosPorFuncao() {
		return this.funcionarios.stream()
								.collect(Collectors.groupingBy(Funcionario::getFuncao));
	}
	
	public void imprimirAniversariantes(int... meses) {
        List<Integer> listaMeses = Arrays.stream(meses).boxed().toList();
        this.funcionarios.stream()
                .filter(funcionario -> listaMeses.contains(funcionario.getDataNascimento().getMonthValue()))
                .forEach(System.out::println);
    }
	
	public void imprimirFuncionarioComMaiorIdade() {
        this.funcionarios.stream()
                .max(Comparator.comparingInt(Funcionario::getIdade))
                .ifPresent(funcionario -> System.out.println("Nome: " + funcionario.getNome() + ", Idade: " + funcionario.getIdade()));
    }
	
	public void imprimirFuncionariosOrdemAlfabetica() {
        this.funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(System.out::println);
    }
	
	public void imprimirTotalSalarios() {
		Locale LocaleBR = new Locale("pt", "BR");
		NumberFormat nf = NumberFormat.getNumberInstance(LocaleBR);
		
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		
        BigDecimal total = this.funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total dos salários: R$ " + nf.format(total));
    }
	
	public void imprimirSalariosMinimos(BigDecimal salarioMinimo) {
        this.funcionarios.forEach(funcionario -> {
            BigDecimal salariosMinimos = funcionario.getSalario().divide(salarioMinimo, RoundingMode.DOWN);
            System.out.println(funcionario.getNome() + " ganha " + salariosMinimos + " salários mínimos.");
        });
    }
	
	public void demitir(Funcionario funcionario) {
		this.funcionarios.remove(funcionario);
	}
	
	/**
	 * Aumenta o salário de todos os funcionários.
	 * @param porcentagem -> Recebe um inteiro para facilitar a interação do usuário.
	 */
	public void aumentoSalarialGeral(int porcentagem) {
		BigDecimal porcentagemAumento = new BigDecimal(porcentagem).divide(new BigDecimal(100));
		this.funcionarios.stream().forEach(funcionario -> {
			BigDecimal salario = funcionario.getSalario();
			BigDecimal aumento = salario.multiply(porcentagemAumento);
			BigDecimal novoSalario = salario.add(aumento);
			funcionario.setSalario(novoSalario);
		});
	}
}
