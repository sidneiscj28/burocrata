package estudantes.entidades;

import professor.entidades.CodigoCurso;
/**
 * Classe que representa um documento do tipo acadêmico.
 * <br><br>
 * 
 * 
 * @author Rafaela de Menezes e Sidnei Correia Junior
 */
public class DocumentoAcademico extends Documento{
    private long autenticacao;
    /**
     * Construtor de DocumentoAcademico
     * @param criador
     * @param codigo
     * @param paginas
     * @param autenticacao
     */
    public DocumentoAcademico(
        String criador, 
        CodigoCurso codigo, 
        int paginas,
        long autenticacao
    ){
        super(criador, codigo, paginas);
        this.autenticacao = autenticacao;
    }
    /**
     * Método getAutenticacao
     * @return
     */
    public long getAutenticacao(){
        return  autenticacao;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        DocumentoAcademico p = (DocumentoAcademico) o;
        if (
            this.autenticacao == p.autenticacao) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return 4; 
    }
}