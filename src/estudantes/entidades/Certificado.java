package estudantes.entidades;

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

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Certificado p = (Certificado) o;
        if (
            this.descricao.equals(p.descricao) 
            ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return 13; 
    }
}