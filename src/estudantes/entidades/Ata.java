package estudantes.entidades;

import java.util.Arrays;

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

    public int getNumero(){
        return numero;
    }
    public String getTexto(){
        return texto;
    }
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
        if (
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