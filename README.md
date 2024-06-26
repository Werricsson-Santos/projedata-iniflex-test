# Teste Prático - Iniflex

Considerando que uma indústria possui as pessoas/funcionários abaixo:

Diante disso, você deve desenvolver um projeto java, com os seguintes requisitos:

##### 1– Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).

##### 2 – Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String).

#### 3 – Deve conter uma classe Principal para executar as seguintes ações:
- ##### 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
- ##### 3.2 – Remover o funcionário “João” da lista.
- ##### 3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
   -  informação de data deve ser exibido no formato dd/mm/aaaa;
   -  informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
- ##### 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
- ##### 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
- ##### 3.6 – Imprimir os funcionários, agrupados por função.
- ##### 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
- ##### 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
- ##### 3.10 – Imprimir a lista de funcionários por ordem alfabética.
- ##### 3.11 – Imprimir o total dos salários dos funcionários.
- ##### 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.

## Tabela fornecida:
![Tabela de usuários](./assets/tabela-funcionarios.png)

## Diagrama de classes

```mermaid
classDiagram
    class Pessoa {
        - String nome
        - LocalDate dataNascimento
        + Pessoa(String nome, LocalDate dataNascimento)
        + String getNome()
        + void setNome(String nome)
        + LocalDate getDataNascimento()
        + void setDataNascimento(LocalDate dataNascimento)
    }

    class Funcionario {
        - BigDecimal salario
        - String funcao
        + Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao)
        + BigDecimal getSalario()
        + void setSalario(BigDecimal salario)
        + String getFuncao()
        + void setFuncao(String funcao)
        + String imprimirDataNascimento()
        + String imprimirSalario()
        + int getIdade()
        + String toString()
    }

    class Empresa {
        - String nome
        - List<Funcionario> funcionarios
        + String getNome()
        + void setNome(String nome)
        + List<Funcionario> getFuncionarios()
        + void setFuncionarios(List<Funcionario> funcionarios)
        + Map<String, List<Funcionario>> imprimirFuncionariosPorFuncao()
        + void imprimirAniversariantes(int... meses)
        + void imprimirFuncionarioComMaiorIdade()
        + void imprimirFuncionariosOrdemAlfabetica()
        + void imprimirTotalSalarios()
        + void imprimirSalariosMinimos(BigDecimal salarioMinimo)
        + void demitir(Funcionario funcionario)
        + void aumentoSalarialGeral(int porcentagem)
    }

    Pessoa <|-- Funcionario
    Empresa --> Funcionario : contains
```
