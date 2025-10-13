package estudantes.entidades;

import java.util.Objects;
/**
 * Classe que representa uma deliberação do tipo ofício.
 * <br><br>
 * 
 * 
 * @author Rafaela de Menezes e Sidnei Correia Junior
 */
import professor.entidades.CodigoCurso;

public class Oficio extends Deliberacao{
    private String destinatario;
    /**
     * Construtor de Oficio
     * @param criador
     * @param codigo
     * @param paginas
     * @param texto
     * @param destinatario
     */
    public Oficio(
        String criador, 
        CodigoCurso codigo, 
        int paginas,
        String texto,
        String destinatario
    ){
        super(criador, codigo, paginas, texto);
        this.destinatario = destinatario;
    }
    /**
     * Método getDestinatario
     * @return
     */
    public String getDestinatario(){
        return destinatario;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Oficio p = (Oficio) o;
        if (Objects.equals(this.getCriador(), p.getCriador()) && 
            Objects.equals(this.getCodigo(), p.getCodigo()) && 
            this.getPaginas() == p.getPaginas() &&
            Objects.equals(this.getTexto(), p.getTexto()) &&
            Objects.equals(this.getDestinatario(), p.getDestinatario())
        ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(destinatario) + super.hashCode(); 
    }
}