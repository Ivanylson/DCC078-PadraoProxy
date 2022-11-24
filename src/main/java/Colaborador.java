import java.util.Arrays;
import java.util.List;

public class Colaborador implements IColaborador {
    private String matricula;
    private String nome;
    private Float salario;

    public Colaborador(String matricula){
        this.matricula = matricula;
        Colaborador objeto = BD.getColaborador(matricula);
        this.nome = objeto.nome;
        this.salario = objeto.salario;
    }

    public Colaborador(String matricula, String nome, Float salario){
        this.matricula = matricula;
        this.nome = nome;
        this.salario = salario;
    }

    public String getMatricula(){
        return this.matricula;
    }

    @Override
    public List<String> obterDadosPessoais() {
        return Arrays.asList(this.nome);
    }

    @Override
    public List<Float> obterSalario(Proprietario proprietario) {
        return Arrays.asList(this.salario);
    }
}
