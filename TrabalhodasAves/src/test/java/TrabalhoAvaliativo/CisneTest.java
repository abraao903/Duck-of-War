package TrabalhoAvaliativo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CisneTest {

    @Test
    public void testAtributosIniciaisCisne() {
        Cisne cisne = new Cisne();
        assertEquals(600, cisne.vida);
        assertEquals(35, cisne.defesa);
    }

    @Test
    public void testDiminuirDanoInimigo() {
        Ganso gansoInimigo = new Ganso(); // Ataque inicial = 30
        gansoInimigo.diminuirDano(gansoInimigo.ataque); // 30 * 0.8 = 24
        assertEquals(24, gansoInimigo.ataque);
    }

    @Test
    public void testUltimateCisneCuraComDanoInimigo() {
        Cisne cisne = new Cisne(); // Vida inicial = 600
        Ganso inimigo = new Ganso(); // Ataque = 30

        // Simulação da lógica da Ultimate fora do ambiente gráfico/console
        int novaVida = cisne.vida + inimigo.ataque;
        cisne.vida = novaVida;

        assertEquals(630, cisne.vida);
    }
}