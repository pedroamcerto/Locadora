package com.locadora;

import com.locadora.domain.Veiculo;

public class Main {
    public static void main(String[] args) {
        try {
            Veiculo veiculo = new Veiculo("Fiat Siena", 120.0);
            int diasAluguel = 8;
            double custo = veiculo.calcularCusto(diasAluguel);
            double multa = veiculo.calcularMultas(2);
            System.out.println("Modelo: " + veiculo.getModelo());
            System.out.println("Valor Diária: " + veiculo.getValorDiaria());
            System.out.println("Custo do aluguel por " + diasAluguel + " dias: " + custo);
            System.out.println("Multa por 2 dias de atraso: " + multa);

            int diasProgressivo = 10;
            double descontoProgressivo = veiculo.calcularDescontoProgressivo(diasProgressivo, 0.02);
            System.out.println("Desconto progressivo para " + diasProgressivo + " dias: " + descontoProgressivo);

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
