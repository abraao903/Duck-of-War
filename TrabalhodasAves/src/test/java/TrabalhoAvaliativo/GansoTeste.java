package TrabalhoAvaliativo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GansoTeste {

    @Test
    public void testAtributosIniciaisGanso() {
        Ganso ganso = new Ganso();
        assertEquals(550, ganso.vida);
        assertEquals(30, ganso.ataque);
        assertEquals(25, ganso.defesa);
    }

    @Test
    public void testAfinidadeGanso() {
        Ganso ganso = new Ganso();
        assertEquals(Afinidade.VANTAGEM, ganso.checarAfinidade(Terrenos.TERRESTRE));
        assertEquals(Afinidade.DESVANTAGEM, ganso.checarAfinidade(Terrenos.AEREO));
        assertEquals(Afinidade.NEUTRO, ganso.checarAfinidade(Terrenos.AQUATICO));
    }

    @Test
    public void testReceberDanoGanso() {
        Ganso ganso = new Ganso(); // Defesa = 25, Vida = 550
        ganso.receberDano(100); // 100 - 25 = 75 de dano real
        assertEquals(475, ganso.vida);
    }
}