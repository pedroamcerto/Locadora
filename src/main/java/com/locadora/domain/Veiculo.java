package com.locadora.domain;

public class Veiculo {
    private String modelo;
    private Double valorDiaria;

    public String getModelo(){
        return modelo;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valor) throws Exception {
        if(valor <= 0){
            throw new Exception("Valor deve ser maior do que 0.");
        }

        valorDiaria = valor;
    }

    public double calcularValorDiaria(int dias) {
        Double valorDesconto = 0.0;
        Double valorTotal = valorDiaria * dias;

        if(dias >= 7) {
            valorDesconto = calcularDesconto(0.1, valorTotal);
        }

        return valorTotal - valorDesconto;
    }

    public Double calcularDesconto(Double desconto, Double valorTotal) {
        return valorTotal * desconto;
    }

    public Double calcularMultas(Double valorTotal, int diasAtrasado) {
        valorTotal
    }
}
