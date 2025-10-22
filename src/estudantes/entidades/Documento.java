package estudantes.entidades;

import java.util.Objects;

import professor.entidades.CodigoCurso;

/**
 * Classe abstrata que representa um documento genérico dentro da universidade.
 * <p>
 * Todos os tipos específicos de documentos (como Ofício, Atestado, Diploma, etc.) devem
 * herdar desta classe. Ela define as propriedades básicas comuns a todos os documentos,
 * como criador, código do curso associado e número de páginas.
 *
 * @author Rafaela de Menezes e Sidnei Correia Junior
 */
public abstract class Documento {
    /**
     * O nome do criador ou responsável pela emissão do documento.
     */
    private String criador;
    /**
     * O código do curso ao qual este documento está associado.
     */
    private CodigoCurso codigo;
    /**
     * O número de páginas que o documento contém.
     */
    private int paginas;

    /**
     * Construtor de Documento.
     *
     * @param criador O nome do criador do documento.
     * @param codigo O código do curso ao qual o documento pertence.
     * @param paginas O número de páginas do documento.
     */
    public Documento(String criador, CodigoCurso codigo, int paginas){
        this.criador = criador;
        this.codigo = codigo;
        this.paginas = paginas;
    }
    /**
     * Retorna o nome do criador do documento.
     *
     * @return O nome do criador.
     */
    public String getCriador(){
        return criador;
    }
    /**
     * Retorna o código do curso associado ao documento.
     *
     * @return O {@link CodigoCurso} do documento.
     */
    public CodigoCurso getCodigoCurso(){
        return codigo;
    }
    /**
     * Retorna o número de páginas do documento.
     *
     * @return O número de páginas.
     */
    public int getPaginas(){
        return paginas;
    }

    /**
     * Compara este documento com outro objeto para verificar igualdade.
     * Dois documentos são considerados iguais se forem da mesma classe e
     * tiverem o mesmo criador, código de curso e número de páginas.
     *
     * @param o O objeto a ser comparado.
     * @return {@code true} se os objetos forem iguais, {@code false} caso contrário.
     */
    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass()) // Compara se são da mesma classe exata
            return false;
        Documento p = (Documento) o;
        if (Objects.equals(this.getCriador(), p.getCriador()) && 
            Objects.equals(this.getCodigoCurso(), p.getCodigoCurso()) && 
            this.getPaginas() == p.getPaginas()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gera um código hash para este documento.
     * O código hash é baseado no criador, código do curso e número de páginas.
     *
     * @return O valor do código hash.
     */
    @Override
    public int hashCode(){
        return Objects.hash(criador, codigo, paginas); 
    }

}
