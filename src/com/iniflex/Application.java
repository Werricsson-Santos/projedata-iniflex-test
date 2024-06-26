package com.iniflex;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.iniflex.model.Empresa;
import com.iniflex.model.Funcionario;

public class Application {

	public static void main(String[] args) {
		Empresa projeData = new Empresa();
		projeData.setNome("Projedata");
		List<Funcionario> funcionarios = new ArrayList<>();
		
		Funcionario maria = new Funcionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2009.44), "Operador");
		funcionarios.add(maria);
		Funcionario joao = new Funcionario("João", LocalDate.of(1990, 05, 12), BigDecimal.valueOf(2284.38), "Operador");
		funcionarios.add(joao);
		Funcionario caio = new Funcionario("Caio", LocalDate.of(1961, 05, 02), BigDecimal.valueOf(9836.14), "Coordenador");
		funcionarios.add(caio);
		Funcionario miguel = new Funcionario("Miguel", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(19119.88), "Diretor");
		funcionarios.add(miguel);
		Funcionario alice = new Funcionario("Alice", LocalDate.of(1995, 01, 05), BigDecimal.valueOf(2234.68), "Recepcionista");
		funcionarios.add(alice);
		Funcionario heitor = new Funcionario("Heitor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72), "Operador");
		funcionarios.add(heitor);
		Funcionario arthur = new Funcionario("Arthur", LocalDate.of(1993, 03, 31), BigDecimal.valueOf(4071.84), "Contador");
		funcionarios.add(arthur);
		Funcionario laura = new Funcionario("Laura", LocalDate.of(1994, 07, 8), BigDecimal.valueOf(3017.45), "Gerente");
		funcionarios.add(laura);
		Funcionario heloisa = new Funcionario("Heloísa", LocalDate.of(2003, 05, 24), BigDecimal.valueOf(1606.85), "Eletrecista");
		funcionarios.add(heloisa);
		Funcionario helena = new Funcionario("Helena", LocalDate.of(1996, 9, 02), BigDecimal.valueOf(2799.93), "Gerente");
		funcionarios.add(helena);
		
		
		projeData.setFuncionarios(funcionarios);
		
		//System.out.println(projeData.getFuncionarios());
		
		projeData.demitir(joao);
		
		//System.out.println(projeData.getFuncionarios());
		System.out.println("======================================================");
		
		projeData.aumentoSalarialGeral(10);
		
		//System.out.println(projeData.getFuncionarios());
		
		//System.out.println(projeData.imprimirFuncionariosPorFuncao());
		
		//3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
			//projeData.imprimirAniversariantes(10, 12);
		
		
		//3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
			projeData.imprimirFuncionarioComMaiorIdade();
			
	    //3.10 – Imprimir a lista de funcionários por ordem alfabética.
	}

}
