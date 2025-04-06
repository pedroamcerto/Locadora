import com.locadora.domain.Veiculo;
import org.junit.Test;
import static org.junit.Assert.*;

public class VeiculoTest {

    @Test
    public void testCalcularCustoSemDesconto() throws Exception {
        Veiculo veiculo = new Veiculo("Fiat Uno", 100.0);
        double custo = veiculo.calcularCusto(5);
        assertEquals(500.0, custo, 0.001);
    }

    @Test
    public void testCalcularCustoComDesconto() throws Exception {
        Veiculo veiculo = new Veiculo("Fiat Palio", 100.0);

        double custo = veiculo.calcularCusto(7);
        double valorTotal = 100.0 * 7;
        double desconto = valorTotal * 0.1;
        double esperado = valorTotal - desconto;
        assertEquals(esperado, custo, 0.001);
    }

    @Test(expected = Exception.class)
    public void testValorDiariaNegativo() throws Exception {
        new Veiculo("Chevrolet", -50.0);
    }

    @Test
    public void testCalcularCustoZeroDias() throws Exception {
        Veiculo veiculo = new Veiculo("Ford Ka", 80.0);
        double custo = veiculo.calcularCusto(0);
        assertEquals(0.0, custo, 0.001);
    }

    @Test
    public void testCalcularMultas() throws Exception {
        Veiculo veiculo = new Veiculo("Honda Civic", 200.0);
        // Para 3 dias de atraso: multa = 200 * 3 * 0.2 = 120.0
        double multas = veiculo.calcularMultas(3);
        assertEquals(120.0, multas, 0.001);
    }

    @Test(expected = Exception.class)
    public void testCalcularCustoDiasNegativos() throws Exception {
        Veiculo veiculo = new Veiculo("Toyota Corolla", 150.0);
        veiculo.calcularCusto(-5);
    }

    @Test(expected = Exception.class)
    public void testCalcularMultasDiasNegativos() throws Exception {
        Veiculo veiculo = new Veiculo("Volkswagen Golf", 180.0);
        veiculo.calcularMultas(-2);
    }

    @Test
    public void testDescontoProgressivo() throws Exception {
        Veiculo veiculo = new Veiculo("Renault Logan", 100.0);
        // Para 10 dias com 2% extra por dia além dos 7: desconto total = 10% + (3 * 2%) = 16%
        double descontoProgressivo = veiculo.calcularDescontoProgressivo(10, 0.02);
        double valorTotal = 100.0 * 10;
        double esperado = valorTotal * 0.16;
        assertEquals(esperado, descontoProgressivo, 0.001);
    }
}
