import java.util.List;

public interface IColaborador {
    List<String> obterDadosPessoais();
    List<Float> obterSalario(Proprietario proprietario);

}
