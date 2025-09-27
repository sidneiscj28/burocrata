package estudantes.entidades;

import professor.entidades.CodigoCurso;

/**
 * Classe que representa um documento genérico.
 * <br><br>
 * <strong>Seu trabalho começa aqui...</strong>
 * 
 * @author Rafaela de Menezes e Sidnei Correia Junior
 */
public abstract class Documento {
    String criador;
    CodigoCurso codigo;
    int paginas;

    public Documento(String criador, CodigoCurso codigo, int paginas){
        this.criador = criador;
        this.codigo = codigo;
        this.paginas = paginas;
    }

    public String getCriador(){
        return criador;
    }
    public CodigoCurso getCodigo(){
        return codigo;
    }
    public int getPagina(){
        return paginas;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Documento p = (Documento) o;
        if (this.criador.equals(p.criador) && this.codigo.equals(p.codigo) && this.paginas == p.paginas) {
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
