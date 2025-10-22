package estudantes.entidades;

import java.util.Objects;

import professor.entidades.CodigoCurso;
/**
 * Classe que representa um registro do tipo certificado.
 * <br><br>
 * 
 * 
 * @author Rafaela de Menezes e Sidnei Correia Junior
 */
public class Certificado extends Registro{
    private String descricao;
    /**
     * Construtor de Certificado
     * @param criador
     * @param codigo
     * @param paginas
     * @param autenticacao
     * @param estudante
     * @param matricula
     * @param descricao
     */
    public Certificado(
        String criador, 
        CodigoCurso codigo, 
        int paginas,
        long autenticacao,
        String estudante,
        long matricula,
        String descricao
    ){
        super(criador, codigo, paginas, autenticacao, estudante, matricula);
        this.descricao = descricao;
    }
    /**
     * Método getDescricao
     * @return
     */
    public String getDescricao(){
        return descricao;
    }

    /** 
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Certificado p = (Certificado) o;
        if (Objects.equals(this.getCriador(), p.getCriador()) && 
            Objects.equals(this.getCodigoCurso(), p.getCodigoCurso()) && 
            this.getPaginas() == p.getPaginas() &&
            this.getAutenticacao() == p.getAutenticacao() &&
            Objects.equals(this.getEstudante(), p.getEstudante()) &&
            this.getMatricula() == p.getMatricula() &&
            Objects.equals(this.getDescricao(), p.getDescricao())
            ) {
            return true;
        } else {
            return false;
        }
    }

    /** 
     * @return int
     */
    @Override
    public int hashCode(){
        return Objects.hash(descricao) + super.hashCode(); 
    }
}