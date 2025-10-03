package estudantes.entidades;

import professor.entidades.CodigoCurso;

public class Edital extends Norma{
    private String[] responsaveis;

    public Edital(
        String criador, 
        CodigoCurso codigo, 
        int paginas,
        int numero,
        boolean valido,
        String texto,
        String[] responsaveis
    ){
        super(criador, codigo, paginas, numero, valido, texto);
        this.responsaveis = responsaveis;
    }

    public String[] getResponsaveis(){
        return responsaveis;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Edital p = (Edital) o;
        if (this.criador.equals(p.criador) && 
            this.codigo.equals(p.codigo) && 
            this.paginas == p.paginas &&
            this.numero == p.numero &&
            this.valido == p.valido &&
            this.texto.equals(p.texto) &&
            this.responsaveis.equals(p.responsaveis) // está certo ??????
            ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return 10; 
    }
}