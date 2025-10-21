package estudantes.entidades;
import java.util.Arrays;
import java.util.Objects;

import professor.entidades.CodigoCurso;

/**
 * Classe que representa uma deliberação do tipo circular.
 * <p>
 * Uma Circular é um tipo específico de {@link Deliberacao}, caracterizada
 * por ter uma lista de destinatários.
 *
 * @author Rafaela de Menezes e Sidnei Correia Junior
 */
public class Circular extends Deliberacao{
    /**
     * Um array de strings contendo os nomes dos destinatários da circular.
     * <p>
     * Note: Arrays são mutáveis, o que pode impactar a imutabilidade e o comportamento de {@code equals}/{@code hashCode}.
     */
    private String[] destinatarios;
    /**
     * Construtor de Circular
     * @param criador
     * @param codigo
     * @param paginas
     * @param texto
     * @param destinatarios
     */ // Corrigido para incluir o Javadoc completo
    public Circular(
        String criador, 
        CodigoCurso codigo, 
        int paginas,
        String texto,
        String[] destinatarios
    ){
        super(criador, codigo, paginas, texto);
        this.destinatarios = destinatarios;
    }
    /**
     * Retorna o array de destinatários da circular.
     * <p>
     * **Atenção:** Retorna uma referência direta ao array interno. Modificações
     * neste array afetarão o estado interno do objeto. Para evitar isso,
     * considere retornar uma cópia do array ou uma {@code List} imutável.
     *
     * @return Um array de {@code String}s contendo os destinatários.
     */
    public String[] getDestinatarios(){
        return destinatarios;
    }

    /**
     * Compara esta circular com outro objeto para verificar igualdade.
     * Duas circulares são consideradas iguais se forem da mesma classe e
     * tiverem as mesmas propriedades de {@link Deliberacao} e os mesmos
     * destinatários (comparados por conteúdo do array).
     *
     * @param o O objeto a ser comparado.
     * @return {@code true} se os objetos forem iguais, {@code false} caso contrário.
     */
    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Circular p = (Circular) o;
        if (Objects.equals(this.getCriador(), p.getCriador()) && 
            Objects.equals(this.getCodigo(), p.getCodigo()) && 
            this.getPaginas() == p.getPaginas() &&
            Objects.equals(this.getTexto(), p.getTexto()) &&
            Arrays.equals(this.getDestinatarios(), p.getDestinatarios()) 
            ) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gera um código hash para esta circular.
     * O código hash é baseado nos destinatários (usando {@link Arrays#hashCode(Object[])}),
     * além do hash da superclasse.
     *
     * @return O valor do código hash.
     */
    @Override
    public int hashCode(){
        return Objects.hash(destinatarios) + super.hashCode(); 
    }
}