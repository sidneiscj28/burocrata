package estudantes.entidades;

import java.util.Objects;

import professor.entidades.CodigoCurso;

/**
 * Classe que representa um documento do tipo Atestado.
 * <p>
 * Um Atestado é um tipo específico de {@link Registro}, contendo informações
 * adicionais como descrição e categoria do atestado.
 *
 * @author Rafaela de Menezes e Sidnei Correia Junior
 */
public class Atestado extends Registro{
    /**
     * A descrição detalhada do atestado.
     */
    private String descricao;
    /**
     * A categoria à qual o atestado pertence (ex: "Saúde", "Comparecimento", etc.).
     */
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
     * @param categoria A categoria do atestado.
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
     * Retorna a descrição detalhada do atestado.
     *
     * @return A descrição do atestado.
     */
    public String getDescricao(){
        return descricao;
    }
    /**
     * Retorna a categoria do atestado.
     *
     * @return A categoria do atestado.
     */
    public String getCategoria(){
        return categoria;
    }

    /**
     * Compara este atestado com outro objeto para verificar igualdade.
     * Dois atestados são considerados iguais se forem da mesma classe e
     * tiverem as mesmas propriedades de {@link Registro} e as mesmas
     * descrição e categoria.
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
        if (this.getClass() != o.getClass())
            return false;
        Atestado p = (Atestado) o;
        if (Objects.equals(this.getCriador(), p.getCriador()) && 
            Objects.equals(this.getCodigoCurso(), p.getCodigoCurso()) && 
            this.getPaginas() == p.getPaginas() &&
            Objects.equals(this.getEstudante(), p.getEstudante()) &&
            this.getMatricula() == p.getMatricula() &&
            this.descricao.equals(p.descricao) &&
            this.categoria.equals(p.categoria) 
            ) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gera um código hash para este atestado.
     * O código hash é baseado na descrição e categoria, além do hash da superclasse.
     *
     * @return O valor do código hash.
     */
    @Override
    public int hashCode(){
        return Objects.hash(descricao, categoria) + super.hashCode(); 
    }

}