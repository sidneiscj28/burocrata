package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;

import professor.entidades.CodigoCurso;
/**
 * Classe que representa um registro do tipo histórico.
 * <br><br>
 * 
 * 
 * @author Rafaela de Menezes e Sidnei Correia Junior
 */
public class Historico extends Registro{
    private double coeficiente;
    private String[] componentes;
    /**
     * Construtor de Historico
     * @param criador
     * @param codigo
     * @param paginas
     * @param autenticacao
     * @param estudante
     * @param matricula
     * @param coeficiente
     * @param componentes
     */
    public Historico(
        String criador, 
        CodigoCurso codigo, 
        int paginas,
        long autenticacao,
        String estudante,
        long matricula,
        double coeficiente,
        String[] componentes
    ){
        super(criador, codigo, paginas, autenticacao, estudante, matricula);
        this.coeficiente = coeficiente;
        this.componentes = componentes;
    }
    /**
     * Método getCoeficiente
     * @return
     */
    public double getCoeficiente(){
        return coeficiente;
    }
    /**
     * Método getComponentes
     * @return
     */
    public String[] getComponentes(){
        return componentes;
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
        Historico p = (Historico) o;
        if (Objects.equals(this.getCriador(), p.getCriador()) && 
            Objects.equals(this.getCodigo(), p.getCodigo()) && 
            this.getPaginas() == p.getPaginas() &&
            this.getAutenticacao() == p.getAutenticacao() &&
            Objects.equals(this.getEstudante(), p.getEstudante()) &&
            this.getMatricula() == p.getMatricula() &&
            this.getCoeficiente() == p.getCoeficiente() &&
            Arrays.equals(this.getComponentes(), p.getComponentes())
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
        return Objects.hash(coeficiente,componentes) + super.hashCode(); 
    }
}