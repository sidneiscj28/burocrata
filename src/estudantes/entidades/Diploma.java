package estudantes.entidades;

import java.util.Objects;

import professor.entidades.CodigoCurso;

/**
 * Classe que representa um certificado do tipo diploma.
 * <p>
 * Um Diploma é um tipo específico de {@link Certificado}, que inclui
 * a informação da habilitação obtida pelo estudante.
 *
 * @author Rafaela de Menezes e Sidnei Correia Junior
 */
public class Diploma extends Certificado{
    /**
     * A habilitação (ex: "Bacharelado em Ciência da Computação") conferida pelo diploma.
     * <p>
     * Este campo é final, garantindo que a habilitação não possa ser alterada após a criação do diploma.
     */
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
     */ // Corrigido para incluir o Javadoc completo
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
     * Retorna a habilitação conferida pelo diploma.
     *
     * @return A string da habilitação.
     */
    public String getHabilitacao(){
        return habilitacao;
    }

    /**
     * Compara este diploma com outro objeto para verificar igualdade.
     * Dois diplomas são considerados iguais se forem da mesma classe e
     * tiverem as mesmas propriedades de {@link Certificado} e a mesma
     * habilitação.
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
        Diploma p = (Diploma) o;
        if (Objects.equals(this.getCriador(), p.getCriador()) && 
            Objects.equals(this.getCodigoCurso(), p.getCodigoCurso()) && 
            this.getPaginas() == p.getPaginas() &&
            this.getAutenticacao() == p.getAutenticacao() &&
            Objects.equals(this.getEstudante(), p.getEstudante()) &&
            this.getMatricula() == p.getMatricula() &&
            Objects.equals(this.getDescricao(), p.getDescricao()) &&
            Objects.equals(this.getHabilitacao(), p.getHabilitacao())
            ) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gera um código hash para este diploma.
     * O código hash é baseado na habilitação, além do hash da superclasse.
     *
     * @return O valor do código hash.
     */
    @Override
    public int hashCode(){
        return Objects.hash(habilitacao) + super.hashCode(); 
    }
}