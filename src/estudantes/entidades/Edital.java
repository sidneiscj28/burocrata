package estudantes.entidades;

import java.util.Objects;

import professor.entidades.CodigoCurso;
/**
 * Classe que representa uma norma do tipo edital.
 * <br><br>
 * 
 * 
 * @author Rafaela de Menezes e Sidnei Correia Junior
 */
public class Edital extends Norma{
    private String[] responsaveis;
    /**
     * Construtor de Edital
     * @param criador
     * @param codigo
     * @param paginas
     * @param numero
     * @param valido
     * @param texto
     * @param responsaveis
     */
    public Edital(
        String criador, 
        CodigoCurso codigo, 
        int paginas,
        int numero,
        boolean valido,
        String texto,
        String[] responsaveis
    ){
        super(criador, codigo, paginas, numero, valido, texto);
        this.responsaveis = responsaveis;
    }
    /**
     * Método getResponsaveis
     * @return
     */
    public String[] getResponsaveis(){
        return responsaveis;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Edital p = (Edital) o;
        if (Objects.equals(this.getCriador(), p.getCriador()) && 
            Objects.equals(this.getCodigo(), p.getCodigo()) && 
            this.getPaginas() == p.getPaginas() &&
            this.getNumero() == p.getNumero() &&
            this.getValido() == p.getValido() &&
            Objects.equals(this.getTexto(), p.getTexto()) &&
            Objects.equals(this.getResponsaveis(), p.getResponsaveis())){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(responsaveis) + super.hashCode(); //problema array
    }
}