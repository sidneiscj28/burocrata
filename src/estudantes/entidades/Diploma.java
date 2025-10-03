package estudantes.entidades;

import professor.entidades.CodigoCurso;
/**
 * Classe que representa um certificado do tipo diploma.
 * <br><br>
 * 
 * 
 * @author Rafaela de Menezes e Sidnei Correia Junior
 */
public class Diploma extends Certificado{
    private String habilitacao;
    /**
     * Construtor de Diploma
     * @param criador
     * @param codigo
     * @param paginas
     * @param autenticacao
     * @param estudante
     * @param matricula
     * @param descricao
     * @param habilitacao
     */
    public Diploma(
        String criador, 
        CodigoCurso codigo, 
        int paginas,
        long autenticacao,
        String estudante,
        long matricula,
        String descricao,
        String habilitacao
    ){
        super(criador, codigo, paginas, autenticacao, estudante, matricula, descricao);
        this.habilitacao = habilitacao;
    }
    /**
     * Método getHabilitacao
     * @return
     */
    public String getHabilitacao(){
        return habilitacao;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Diploma p = (Diploma) o;
        if (
            this.habilitacao.equals(p.habilitacao) 
            ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return 16; 
    }
}