package com.locadora.domain;

public class Veiculo {
    private String modelo;
    private Double valorDiaria;

    public Veiculo(String modelo, Double valorDiaria) throws Exception {
        this.modelo = modelo;
        setValorDiaria(valorDiaria);
    }

    public String getModelo(){
        return modelo;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    // Valida que o valor da diária seja maior que zero
    public void setValorDiaria(Double valor) throws Exception {
        if(valor == null || valor <= 0){
            throw new Exception("Valor deve ser maior do que 0.");
        }
        this.valorDiaria = valor;
    }

    /**
     * Calcula o custo total do aluguel para uma dada quantidade de dias.
     * Se o número de dias for negativo, lança exceção.
     * Se for 0, retorna 0.
     */
    public double calcularCusto(int dias) throws Exception {
        if(dias < 0) {
            throw new Exception("Quantidade de dias não pode ser negativa.");
        }
        if(dias == 0) {
            return 0.0;
        }
        double valorTotal = valorDiaria * dias;
        double valorDesconto = aplicarDesconto(dias, valorTotal);
        return valorTotal - valorDesconto;
    }

    /**
     * Aplica desconto de 10% se o aluguel for de 7 dias ou mais.
     */
    private double aplicarDesconto(int dias, double valorTotal) {
        if(dias >= 7) {
            return calcularDesconto(0.1, valorTotal);
        }
        return 0.0;
    }

    /**
     * Calcula o valor do desconto dado um percentual.
     */
    public double calcularDesconto(double percentual, double valorTotal) {
        return valorTotal * percentual;
    }

    /**
     * Calcula a multa por atraso na devolução.
     * A lógica utilizada é: 20% do valor da diária para cada dia de atraso.
     * Lança exceção se diasAtrasado for negativo.
     */
    public double calcularMultas(int diasAtrasado) throws Exception {
        if(diasAtrasado < 0) {
            throw new Exception("Dias atrasado não pode ser negativo.");
        }
        return valorDiaria * diasAtrasado * 0.2;
    }

    /**
     * Método extra: Calcula um desconto progressivo.
     * Se o aluguel tiver 7 dias ou mais, além do desconto base de 10%,
     * adiciona um percentual extra (por exemplo, 2% para cada dia extra) até um máximo de 30%.
     */
    public double calcularDescontoProgressivo(int dias, double percentualExtra) throws Exception {
        if(dias < 0) {
            throw new Exception("Quantidade de dias não pode ser negativa.");
        }
        double valorTotal = valorDiaria * dias;
        if(dias < 7) {
            return 0.0;
        }
        int diasExtra = dias - 7;
        double percentualProgressivo = Math.min(0.1 + (diasExtra * percentualExtra), 0.3);
        return calcularDesconto(percentualProgressivo, valorTotal);
    }
}
