package estudantes.entidades;

import professor.entidades.CodigoCurso;

public class Certificado extends Registro{
    private String descricao;

    public Certificado(
        String criador, 
        CodigoCurso codigo, 
        int paginas,
        long autenticacao,
        String estudante,
        long matricula,
        String descricao
    ){
        super(criador, codigo, paginas, autenticacao, estudante, matricula);
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Certificado p = (Certificado) o;
        if (
            this.descricao.equals(p.descricao) 
            ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return 13; 
    }
}