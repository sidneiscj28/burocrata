package estudantes.entidades;
import java.util.Arrays;

import professor.entidades.CodigoCurso;

public class Plano extends DocumentoAcademico{
    private String responsavel;
    private String[] planejamento;

    public Plano(
        String criador, 
        CodigoCurso codigo, 
        int paginas,
        long autenticacao,
        String responsavel,
        String[] planejamento
    ){
        super(criador, codigo, paginas, autenticacao);
        this.responsavel = responsavel;
        this.planejamento = planejamento;
    }

    public String getResponsavel(){
        return responsavel;
    }

    public String[] getPlanejamento(){
        return planejamento;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Plano p = (Plano) o;
        if (
            this.responsavel.equals(p.responsavel) &&
            Arrays.equals(this.planejamento, p.planejamento)   
        ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return 8; 
    }

}