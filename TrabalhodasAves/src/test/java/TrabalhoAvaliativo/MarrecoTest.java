package TrabalhoAvaliativo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MarrecoTest {

    @Test
    public void testAtributosIniciaisMarreco() {
        Marreco marreco = new Marreco();
        assertEquals(400, marreco.vida);
        assertEquals(55, marreco.ataque);
    }

    @Test
    public void testAfinidadeMarreco() {
        Marreco marreco = new Marreco();
        assertEquals(Afinidade.VANTAGEM, marreco.checarAfinidade(Terrenos.AEREO));
        assertEquals(Afinidade.DESVANTAGEM, marreco.checarAfinidade(Terrenos.AQUATICO));
    }

    @Test
    public void testAtaqueModificadoComVantagem() {
        Marreco marreco = new Marreco(); // Ataque 55 * 1.5 (Vantagem no Aéreo) = 82
        int ataqueModificado = marreco.getAtaqueModificado(Terrenos.AEREO);
        assertEquals(82, ataqueModificado);
    }
}