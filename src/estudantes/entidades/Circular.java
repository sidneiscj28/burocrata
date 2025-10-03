package estudantes.entidades;
import java.util.Arrays;

import professor.entidades.CodigoCurso;
/**
 * Classe que representa uma deliberação do tipo circular.
 * <br><br>
 * 
 * 
 * @author Rafaela de Menezes e Sidnei Correia Junior
 */
public class Circular extends Deliberacao{
    private String[] destinatarios;
    /**
     * Construtor de Circular
     * @param criador
     * @param codigo
     * @param paginas
     * @param texto
     * @param destinatarios
     */
    public Circular(
        String criador, 
        CodigoCurso codigo, 
        int paginas,
        String texto,
        String[] destinatarios
    ){
        super(criador, codigo, paginas, texto);
        this.destinatarios = destinatarios;
    }
    /**
     * Método getDestinatarios
     * @return
     */
    public String[] getDestinatarios(){
        return destinatarios;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Circular p = (Circular) o;
        if (
            // this.destinatarios.equals(p.destinatarios)
            Arrays.equals(this.destinatarios, p.destinatarios) // está correto?
            ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return 11; 
    }
}