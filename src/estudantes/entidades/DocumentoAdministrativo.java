package estudantes.entidades;

import professor.entidades.CodigoCurso;

public class DocumentoAdministrativo extends Documento{

    public DocumentoAdministrativo(String criador, CodigoCurso codigo, int paginas){
        super(criador, codigo, paginas);
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        DocumentoAdministrativo p = (DocumentoAdministrativo) o;
        if (this.criador.equals(p.criador) && this.codigo.equals(p.codigo) && this.paginas == p.paginas) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return 3; 
    }
}