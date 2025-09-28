package estudantes.entidades;

import professor.entidades.CodigoCurso;

public class Atestado extends Registro{
    private String descricao;
    private String categoria;

    public Atestado(
        String criador, 
        CodigoCurso codigo, 
        int paginas,
        long autenticacao,
        String estudante,
        long matricula,
        String descricao,
        String categoria
    ){
        super(criador, codigo, paginas, autenticacao, estudante, matricula);
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public String getDescricao(){
        return descricao;
    }

    public String getCategoria(){
        return categoria;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Atestado p = (Atestado) o;
        if (
            this.descricao.equals(p.descricao) &&
            this.categoria.equals(p.categoria) 
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