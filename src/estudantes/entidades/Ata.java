package estudantes.entidades;

import professor.entidades.*;

public class Ata extends Documento{
    private int numero;
    private String texto;
    private String[] presentes;

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
}