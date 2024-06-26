package com.iniflex.model;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
