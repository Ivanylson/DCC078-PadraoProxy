import java.util.List;
public class ColaboradorProxy implements IColaborador {
    private Colaborador colaborador;
    private String matricula;

    public ColaboradorProxy(String matricula){
        this.matricula = matricula;
    }


    @Override
    public List<String> obterDadosPessoais() {
        if(this.colaborador == null){
            this.colaborador = new Colaborador(this.matricula);
        }
        return this.colaborador.obterDadosPessoais();
    }

    @Override
    public List<Float> obterSalario(Proprietario proprietario) {
        if(!proprietario.isAdministrador()){
            throw new IllegalArgumentException("Socio nao autorizado");
        }
        if(this.colaborador == null){
            this.colaborador = new Colaborador(this.matricula);
        }

        return this.colaborador.obterSalario(proprietario);
    }
}
