package estudantes.entidades;

import java.util.Objects;

import professor.entidades.CodigoCurso;
/**
 * Classe que representa uma norma do tipo portaria.
 * <br><br>
 * 
 * 
 * @author Rafaela de Menezes e Sidnei Correia Junior
 */
public class Portaria extends Norma{
    private int anoInicio;
    /**
     * Construtor de Portaria
     * @param criador
     * @param codigo
     * @param paginas
     * @param numero
     * @param valido
     * @param texto
     * @param anoInicio
     */
    public Portaria(
        String criador, 
        CodigoCurso codigo, 
        int paginas,
        int numero,
        boolean valido,
        String texto,
        int anoInicio
    ){
        super(criador, codigo, paginas, numero, valido, texto);
        this.anoInicio = anoInicio;
    }
    /**
     * Método getAnoInicio
     * @return
     */
    public int getAnoInicio(){
        return anoInicio;
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
        Portaria p = (Portaria) o;
        if (Objects.equals(this.getCriador(), p.getCriador()) && 
            Objects.equals(this.getCodigoCurso(), p.getCodigoCurso()) && 
            this.getPaginas() == p.getPaginas() &&
            this.getNumero() == p.getNumero() &&
            this.getValido() == p.getValido() &&
            Objects.equals(this.getTexto(), p.getTexto()) &&
            this.getAnoInicio() == p.getAnoInicio()
            ) {
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
        return Objects.hash(anoInicio) + super.hashCode(); 
    }


}