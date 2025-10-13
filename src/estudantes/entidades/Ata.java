package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;

import professor.entidades.*;
/**
 * Classe que representa um documento do tipo ata.
 * <br><br>
 * 
 * 
 * @author Rafaela de Menezes e Sidnei Correia Junior
 */
public class Ata extends Documento{
    private int numero;
    private String texto;
    private String[] presentes;

    /**
     * Construtor de Ata
     * @param criador
     * @param codigo
     * @param paginas
     * @param numero
     * @param texto
     * @param presentes
     */
    public Ata(
        String criador, 
        CodigoCurso codigo, 
        int paginas, 
        int numero, 
        String texto, 
        String[] presentes
        ){
        
            super(criador,codigo, paginas);
            this.numero = numero;
            this.texto = texto;
            this.presentes = presentes;
    }
    /**
     * Método getNumero
     * @return
     */
    public int getNumero(){
        return numero;
    }
    /**
     * Método getTexto
     * @return
     */
    public String getTexto(){
        return texto;
    }
    /**
     * Método getPresentes
     * @return
     */
    public String[] getPresentes(){
        return presentes;
    }
    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Ata p = (Ata) o;
        if (Objects.equals(this.getCriador(), p.getCriador()) && 
            Objects.equals(this.getCodigo(), p.getCodigo()) && 
            this.getPaginas() == p.getPaginas() &&
            this.numero==p.numero &&
            this.texto.equals(p.texto) &&
            Arrays.equals(this.presentes, p.presentes)
            ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return 2;
    }
}