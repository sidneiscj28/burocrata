package estudantes.entidades;
import java.util.Arrays;

import professor.entidades.CodigoCurso;

public class Circular extends Deliberacao{
    private String[] destinatarios;

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
        return 0; // mudar isso
    }
}