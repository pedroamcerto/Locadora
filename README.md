# Projeto Locadora de Veículos

Este projeto tem como objetivo representar um sistema simples de locadora de veículos. Ele oferece funcionalidades para calcular o custo do aluguel de um veículo com base na quantidade de dias, aplicar descontos (inclusive progressivos) e calcular multas por devolução atrasada.

## Funcionalidades

- **Calcular Custo do Aluguel:**  
  - Calcula o custo total com base no valor da diária e no número de dias. Aplica um desconto de 10% para aluguéis de 7 dias ou mais.

- **Calcular Desconto Progressivo:**  
  - Além do desconto base de 10%, possibilita aplicar um percentual extra por dia a partir do sétimo dia, limitado a um máximo de 30%.

- **Calcular Multas:**  
  - Calcula multas por atraso na devolução do veículo, considerando 20% do valor da diária para cada dia de atraso.

- **Tratamento de Erros:**  
  - O projeto trata situações inválidas, como valores negativos ou zero para a diária e dias negativos para o aluguel ou atraso.


## Requisitos

- **Java JDK 1.8 ou superior:**  
  - Certifique-se de ter o Java instalado.

- **Maven:**  
  - Para gerenciamento de dependências e build do projeto.

- **JUnit 4:**  
  - Utilizado para a execução dos testes unitários.

## Compilação e Execução
### Compilar o Projeto

Navegue até a raiz do projeto onde se encontra o arquivo pom.xml e execute:

```bash
mvn compile
```

### Executar os Testes

Para executar os testes unitários com o JUnit, utilize:

```bash
mvn test
```

### Executar a Aplicação

Para executar a aplicação e visualizar o funcionamento da classe Veiculo, execute a classe Main. Você pode rodar pelo seu IDE ou utilizar o comando abaixo (certificando-se de que o classpath está configurado corretamente):

```bash
mvn exec:java -Dexec.mainClass="com.locadora.Main"
```

# Exemplos de Uso
Na classe Main, um exemplo de utilização é demonstrado. Ela cria um objeto do tipo Veiculo, calcula o custo do aluguel com desconto, calcula multas por atraso e aplica um desconto progressivo. O console exibirá as seguintes informações:

- Modelo do veículo.
- Valor da diária.
- Custo total do aluguel (considerando desconto se aplicável).
- Valor da multa para os dias de atraso.
- Valor do desconto progressivo aplicado.

# Considerações Finais
Este projeto foi desenvolvido com foco na simplicidade e clareza do código, utilizando tratamento de erros para garantir a robustez dos métodos. Sinta-se à vontade para expandir as funcionalidades, por exemplo, adicionando novos tipos de descontos ou regras de multa conforme a necessidade do negócio.