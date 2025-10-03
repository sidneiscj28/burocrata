package estudantes.entidades;

import java.util.Arrays;

import professor.entidades.CodigoCurso;
/**
 * Classe que representa um documento acadêmico do tipo registro.
 * <br><br>
 * 
 * 
 * @author Rafaela de Menezes e Sidnei Correia Junior
 */
public class Registro extends DocumentoAcademico{
    private String estudante;
    private long matricula;
    /**
     * Construtor de Registro
     * @param criador
     * @param codigo
     * @param paginas
     * @param autenticacao
     * @param estudante
     * @param matricula
     */
    public Registro(
        String criador, 
        CodigoCurso codigo, 
        int paginas,
        long autenticacao,
        String estudante,
        long matricula
    ){
        super(criador, codigo, paginas, autenticacao);
        this.estudante = estudante;
        this.matricula = matricula;
    }

    /**
     * Método getEstudante
     * @return
     */
    public String getEstudante(){
        return estudante;
    }
    /**
     * Método getMatricula
     * @return
     */
    public long getMatricula(){
        return matricula;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Registro p = (Registro) o;
        if (
            this.estudante.equals(p.estudante) &&
            this.matricula == p.matricula
            ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return 7; 
    }
}