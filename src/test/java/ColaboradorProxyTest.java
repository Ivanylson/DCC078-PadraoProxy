import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ColaboradorProxyTest {

    @BeforeEach
    void setUp() {
        BD.addColaborador(new Colaborador("1", "João", 950.0f));
        BD.addColaborador(new Colaborador("2", "Maria", 1000.0f));
    }

    @Test
    void deveRetornarDadosPessoaisDosColaboradores() {
        ColaboradorProxy colaborador = new ColaboradorProxy("1");
        assertEquals(Arrays.asList("João"), colaborador.obterDadosPessoais());
    }

    @Test
    void deveRetonarSalarioolaborador() {
        Proprietario proprietario = new Proprietario("Lara", true);
        ColaboradorProxy colaborador = new ColaboradorProxy("1");

        assertEquals(Arrays.asList(950.0f), colaborador.obterSalario(proprietario));
    }

    @Test
    void deveRetonarExcecaoUsuarioNaoAutorizadoConsultarSalarioColaborador() {
        try {
            Proprietario proprietario = new Proprietario("Ivanylson", false);
            ColaboradorProxy colaborador = new ColaboradorProxy("2");

            colaborador.obterSalario(proprietario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Socio nao autorizado", e.getMessage());
        }
    }

}