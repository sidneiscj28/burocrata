package estudantes.entidades;

import java.util.Objects;

import professor.entidades.CodigoCurso;

/**
 * Classe que representa um documento genérico.
 * <br><br>
 * 
 * 
 * @author Rafaela de Menezes e Sidnei Correia Junior
 */
public abstract class Documento {
    private String criador;
    private CodigoCurso codigo;
    private int paginas;

    /**
     * Construtor de Documento
     * @param criador
     * @param codigo
     * @param paginas
     */
    public Documento(String criador, CodigoCurso codigo, int paginas){
        this.criador = criador;
        this.codigo = codigo;
        this.paginas = paginas;
    }
    /**
     * Método getCriador
     * @return
     */
    public String getCriador(){
        return criador;
    }
    /**
     * Método getCodigo
     * @return
     */
    public CodigoCurso getCodigo(){
        return codigo;
    }
    /**
     * Método getPagina
     * @return
     */
    public int getPaginas(){
        return paginas;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Documento p = (Documento) o;
        if (Objects.equals(this.criador, p.criador) && Objects.equals(this.codigo, p.codigo) && this.paginas == p.paginas) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(criador, codigo, paginas); 
    }

}
