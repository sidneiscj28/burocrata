package estudantes.entidades;

import java.util.Arrays;

import professor.entidades.CodigoCurso;

public class Oficio extends Deliberacao{
    private String destinatario;

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
        if (
            this.destinatario.equals(p.destinatario)
        ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return 12; 
    }
}