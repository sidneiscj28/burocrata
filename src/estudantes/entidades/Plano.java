package estudantes.entidades;
import java.util.Arrays;

import professor.entidades.CodigoCurso;
/**
 * Classe que representa um documento acadêmico do tipo plano.
 * <br><br>
 * 
 * 
 * @author Rafaela de Menezes e Sidnei Correia Junior
 */
public class Plano extends DocumentoAcademico{
    private String responsavel;
    private String[] planejamento;
    /**
     * Construtor de Documento
     * @param criador
     * @param codigo
     * @param paginas
     * @param autenticacao
     * @param responsavel
     * @param planejamento
     */
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
    /**
     * Método getResponsavel
     * @return
     */
    public String getResponsavel(){
        return responsavel;
    }
    /**
     * Método getPlanejamento
     * @return
     */
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