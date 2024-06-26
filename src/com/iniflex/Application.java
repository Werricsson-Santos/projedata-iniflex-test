package com.iniflex;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.iniflex.model.Empresa;
import com.iniflex.model.Funcionario;

public class Application {
	public static BigDecimal salarioMinimo = new BigDecimal(1212.00);

	public static void main(String[] args) {
		Empresa projeData = new Empresa();
		projeData.setNome("Projedata");
		List<Funcionario> funcionarios = new ArrayList<>();
		
		//3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
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
		
			//Descomentar linhas abaixo para ver que o João foi incluído na ordem correta.
				//System.out.println(projeData.getFuncionarios()); 
				//System.out.println("======================================================");
		//3.2 – Remover o funcionário “João” da lista.
			projeData.demitir(joao);
			
		/*
		3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
			• informação de data deve ser exibido no formato dd/mm/aaaa;
			• informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
		*/
			System.out.println("========== Imprimindo todos os funcionários ==========");
			System.out.println(projeData.getFuncionarios());
			System.out.println("======================================================\n");
		
		//3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
			projeData.aumentoSalarialGeral(10);
			//Descomentar a linha abaixo caso queira imprimir a lista de funcionários com o salário atualizado.
				//System.out.println(projeData.getFuncionarios());
				//System.out.println("======================================================");
		
		//3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
			//Favor verificar a resposta na classe Empresa.
			
		//3.6 – Imprimir os funcionários, agrupados por função.	
			System.out.println("============= Funcionários por função ================");
			System.out.println(projeData.imprimirFuncionariosPorFuncao());
			System.out.println("======================================================\n");
		
		//3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
			System.out.println("=========== Aniversariantes mês 10 e 12 ==============");
			projeData.imprimirAniversariantes(10, 12);
			System.out.println("======================================================\n");
			
			/*
			Não existe funcionário que faz aniversário no mês 12, então caso queira ver outras opção descomente as linhas abaixo e
			sintam-se à vontade para colocar outras datas como parâmetro.
			*/ 
				//System.out.println("=========== Aniversariantes mês 10 e 12 ==============");
				//projeData.imprimirAniversariantes(10, 11);
				//System.out.println("======================================================");
		
		//3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
			System.out.println("=========== Funcionário com maior idade ==============");
			projeData.imprimirFuncionarioComMaiorIdade();
			System.out.println("======================================================\n");
			
	    //3.10 – Imprimir a lista de funcionários por ordem alfabética.
			System.out.println("======== Funcionários por ordem alfabética ===========");
			projeData.imprimirFuncionariosOrdemAlfabetica();
			System.out.println("======================================================\n");
		
		//3.11 – Imprimir o total dos salários dos funcionários.
			System.out.println("======== Total dos salários dos funcionários =========");
			projeData.imprimirTotalSalarios();
			System.out.println("======================================================\n");
			
		//3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
			System.out.println("============ Comparativo salário mínimo ==============");
			projeData.imprimirSalariosMinimos(salarioMinimo);
			System.out.println("======================================================\n");
	}

}
