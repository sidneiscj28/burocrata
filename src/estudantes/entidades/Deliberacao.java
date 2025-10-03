package estudantes.entidades;

import estudantes.entidades.DocumentoAdministrativo;
import professor.entidades.CodigoCurso;
/**
 * Classe que representa um documento administrativo do tipo deliberação.
 * <br><br>
 * 
 * 
 * @author Rafaela de Menezes e Sidnei Correia Junior
 */
public class Deliberacao extends  DocumentoAdministrativo{
    private String texto;
    /**
     * Construtor de Deliberação
     * @param criador
     * @param codigo
     * @param paginas
     * @param texto

     */
    public Deliberacao(
        String criador, 
        CodigoCurso codigo, 
        int paginas,
        String texto
    ){
        super(criador, codigo, paginas);
        this.texto = texto;
    }
    /**
     * Método getTexto
     * @return
     */
    public String getTexto(){
        return texto;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Deliberacao p = (Deliberacao) o;
        if (
            this.texto.equals(p.texto)
            ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return 6; 
    }
}