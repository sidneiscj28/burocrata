package estudantes.entidades;

import professor.entidades.CodigoCurso;

/**
 * Classe que representa um registro do tipo atestado.
 * <br><br>
 * 
 * 
 * @author Rafaela de Menezes e Sidnei Correia Junior
 */
public class Atestado extends Registro{
    private String descricao;
    private String categoria;

    /**
     * Construtor de Atestado
     * @param criador
     * @param codigo
     * @param paginas
     * @param autenticacao
     * @param estudante
     * @param matricula
     * @param descricao
     * @param categoria
     */

    public Atestado(
        String criador, 
        CodigoCurso codigo, 
        int paginas,
        long autenticacao,
        String estudante,
        long matricula,
        String descricao,
        String categoria
    ){
        super(criador, codigo, paginas, autenticacao, estudante, matricula);
        this.descricao = descricao;
        this.categoria = categoria;
    }
    /**
     * Método getDescricao
     * @return
     */
    public String getDescricao(){
        return descricao;
    }
    /**
     * Método getCategoria
     * @return
     */
    public String getCategoria(){
        return categoria;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Atestado p = (Atestado) o;
        if (
            this.descricao.equals(p.descricao) &&
            this.categoria.equals(p.categoria) 
            ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return 15; 
    }

}