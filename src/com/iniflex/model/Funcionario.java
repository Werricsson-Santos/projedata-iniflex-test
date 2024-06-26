package com.iniflex.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Funcionario extends Pessoa {
	private BigDecimal salario;
	private String funcao;
	
	
	public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
		super(nome, dataNascimento);
		this.salario = salario;
		this.funcao = funcao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public String imprimirDataNascimento() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = this.getDataNascimento().format(formatter);
		
		return dataFormatada;
	}
	
	public String imprimirSalario() {
		Locale LocaleBR = new Locale("pt", "BR");
		NumberFormat nf = NumberFormat.getNumberInstance(LocaleBR);
		
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		
		String salarioFormatado = nf.format(this.salario);
		
		return salarioFormatado;
	}
	
	public int getIdade() {
        return LocalDate.now().getYear() - super.getDataNascimento().getYear();
    }

	@Override
	public String toString() {
		return "Funcionario [\nNome:" + getNome()+ "\nData de nascimento:" + imprimirDataNascimento() +
							"\nSalario: R$ " + imprimirSalario() + "\nFuncao:" + funcao + 
							"\n]\n";
	}
	
	
}
