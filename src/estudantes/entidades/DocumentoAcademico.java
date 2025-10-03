package estudantes.entidades;

import professor.entidades.CodigoCurso;

public class DocumentoAcademico extends Documento{
    private long autenticacao;

    public DocumentoAcademico(
        String criador, 
        CodigoCurso codigo, 
        int paginas,
        long autenticacao
    ){
        super(criador, codigo, paginas);
        this.autenticacao = autenticacao;
    }

    public long getAutenticacao(){
        return  autenticacao;
    }
    public void setAutenticacao(long auth){
        autenticacao = auth;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        DocumentoAcademico p = (DocumentoAcademico) o;
        if (
            this.autenticacao == p.autenticacao) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return 4; 
    }
}