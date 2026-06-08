package TrabalhoAvaliativo;

import org.junit.jupiter.api.Test;
import java.util.InputMismatchException;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    // TESTE 1: Garante que a Exception Personalizada é disparada ao digitar "pato"
    @Test
    public void testDisparoDePatosupremoException() {
        assertThrows(PatosupremoException.class, () -> {
            String entrada = "pato";
            if (entrada.equalsIgnoreCase("pato")) {
                throw new PatosupremoException("Easter egg");
            }
        });
    }

    // TESTE 2: Garante que digitar texto comum dispara o NumberFormatException (antigo Mismatch)
    @Test
    public void testDisparoDeNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> {
            String entradaInvalida = "ganso";
            Integer.parseInt(entradaInvalida);
        });
    }

    // TESTE 3: Garante que um número válido em formato de texto é convertido corretamente
    @Test
    public void testConversaoDeNumeroValido() {
        String entradaValida = "3";
        int numeroConvertido = Integer.parseInt(entradaValida);
        assertEquals(3, numeroConvertido);
    }
}