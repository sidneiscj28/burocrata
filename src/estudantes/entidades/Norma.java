package estudantes.entidades;
import estudantes.entidades.DocumentoAdministrativo;
import professor.entidades.CodigoCurso;
/**
 * Classe que representa um documento administrativo do tipo norma.
 * <br><br>
 * 
 * 
 * @author Rafaela de Menezes e Sidnei Correia Junior
 */
public class Norma extends DocumentoAdministrativo{
    private int numero;
    private boolean valido;
    private String texto;
    /**
     * Construtor de Norma
     * @param criador
     * @param codigo
     * @param paginas
     * @param numero
     * @param valido
     * @param texto
     */
    public Norma(
        String criador, 
        CodigoCurso codigo, 
        int paginas,
        int numero,
        boolean valido,
        String texto
    )
    {
        super(criador, codigo, paginas);
        this.numero = numero;
        this.valido = valido;
        this.texto = texto;
    }
    /**
     * Método getNumero
     * @return
     */
    public int getNumero(){
        return numero;
    }
    /**
     * Método getValido
     * @return
     */
    public boolean getValido(){
        return valido;
    }
    /**
     * Método getTexto
     * @return
     */
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
        Norma p = (Norma) o;
        if (
            this.numero == p.numero &&
            this.valido == p.valido &&
            this.texto.equals(p.texto)
            ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return 5; 
    }
}


// VERIFICAR SE OS ATRIBUTOS DA CLASSE MÃE SERÃO INCLUSAS EM CADA EQUALS
//   @Override
//     public boolean equals(Object o){
//         if (this == o)
//             return true;
//         if (o == null)
//             return false;
//         if (this.getClass() != o.getClass())
//             return false;
//         Norma p = (Norma) o;
//         if (this.criador.equals(p.criador) && 
//             this.codigo.equals(p.codigo) && 
//             this.paginas == p.paginas &&
//             this.numero == p.numero &&
//             this.valido == p.valido &&
//             this.texto.equals(p.texto)
//             ) {
//             return true;
//         } else {
//             return false;
//         }
//     }