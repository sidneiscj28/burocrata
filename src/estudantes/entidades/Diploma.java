package estudantes.entidades;

import professor.entidades.CodigoCurso;

public class Diploma extends Certificado{
    private String habilitacao;

    public Diploma(
        String criador, 
        CodigoCurso codigo, 
        int paginas,
        long autenticacao,
        String estudante,
        long matricula,
        String descricao,
        String habilitacao
    ){
        super(criador, codigo, paginas, autenticacao, estudante, matricula, descricao);
        this.habilitacao = habilitacao;
    }

    public String getHabilitacao(){
        return habilitacao;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Diploma p = (Diploma) o;
        if (
            this.habilitacao.equals(p.habilitacao) 
            ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return 16; 
    }
}