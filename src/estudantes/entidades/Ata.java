package estudantes.entidades;

import professor.entidades.*;

public class Ata extends Documento{
    int numero;
    String texto;
    String[] presentes;

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