package estudantes.entidades;

import java.util.Arrays;

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

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Historico p = (Historico) o;
        if (
            this.coeficiente == p.coeficiente &&
            Arrays.equals(this.componentes, p.componentes)
            ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return 14; 
    }
}