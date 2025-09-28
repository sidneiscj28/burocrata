package estudantes.entidades;

import estudantes.entidades.DocumentoAdministrativo;
import professor.entidades.CodigoCurso;

public class Deliberacao extends  DocumentoAdministrativo{
    private String texto;

    public Deliberacao(
        String criador, 
        CodigoCurso codigo, 
        int paginas,
        String texto
    ){
        super(criador, codigo, paginas);
        this.texto = texto;
    }

    public String getTexto(){
        return texto;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Deliberacao p = (Deliberacao) o;
        if (
            this.texto.equals(p.texto)
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