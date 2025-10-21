package estudantes.entidades;

import java.util.Objects;

import professor.entidades.CodigoCurso;
/**
 * Classe que representa um documento do tipo administrativo.
 * <br><br>
 * 
 * 
 * @author Rafaela de Menezes e Sidnei Correia Junior
 */
public class DocumentoAdministrativo extends Documento{
    /**
     * Construtor de Documento
     * @param criador
     * @param codigo
     * @param paginas
     */
    public DocumentoAdministrativo(String criador, CodigoCurso codigo, int paginas){
        super(criador, codigo, paginas);
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
        DocumentoAdministrativo p = (DocumentoAdministrativo) o;
        if (Objects.equals(this.getCriador(), p.getCriador()) && 
            Objects.equals(this.getCodigo(), p.getCodigo()) && 
            this.getPaginas() == p.getPaginas()) {
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
        return super.hashCode(); 
    }
}