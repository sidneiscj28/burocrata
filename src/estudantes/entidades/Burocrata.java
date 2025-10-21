package estudantes.entidades;

import java.util.*;

import professor.entidades.*;

/**
 * Classe que traz a lógica do algoritmo de organização e despacho de processos.
 * <br>
 * <br>
 * Você pode incluir novos atributos e métodos nessa classe para criar
 * lógicas mais complexas para o gerenciamento da organização e despacho de
 * processos, mas esses <strong>atributos e métodos devem ser todos
 * privados</strong> e eles não serão invocados diretamente pelo simulador.
 * <br>
 * <br>
 * Os únicos métodos públicos devem ser: getEstresse, trabalhar, estressar e
 * estressarMuito.
 * 
 * @author Rafaela de Menezes e Sidnei Correia Junior
 */
public class Burocrata {
    /** Nível de estresse do burocrata, que aumenta com certas ações. */
    private int estresse = 0;
    /** A mesa de trabalho do burocrata, onde os processos são organizados. */
    private Mesa mesa;
    /** A instância da universidade, que dá acesso aos montes de documentos e à secretaria. */
    private Universidade universidade;

    /**
     * Construtor de Burocrata.
     * 
     * @param m A mesa com os processos a serem trabalhados.
     * @param u A universidade com os montes de documentos e a secretaria.
     */
    public Burocrata(Mesa m, Universidade u) {
        this.mesa = m;
        this.universidade = u;
    }

    /**
     * Executa a lógica de criação e despacho dos processos.
     * <br>
     * <br>
     * Esse método é o único método de controle invocado durante a simulação
     * da universidade.
     * <br>
     * <br>
     * Aqui podem ser feitas todas as verificações sobre os documentos nos
     * montes dos cursos e dos processos abertos na mesa do Burocrata. A partir
     * dessas informações, você pode colocar documentos nos processos abertos
     * e despachar os processos para a secretaria acadêmica.
     * <br>
     * <br>
     * Cuidado com a complexidade do seu algoritmo, porque se ele demorar muito
     * serão criados menos documentos na sua execução e sua produtividade geral
     * vai cair.
     * <br>
     * <br>
     * Esse método será chamado a cada 100 milissegundos pelo simulador da
     * universidade.
     * <br>
     * <br>
     * <strong>O burocrata não pode manter documentos com ele</strong> depois
     * que o método trabalhar terminar de executar, ou seja, você deve devolver
     * para os montes dos cursos todos os documentos que você removeu dos montes
     * dos cursos.
     * 
     * @see professor.entidades.Universidade#despachar(Processo)
     * @see professor.entidades.Universidade#removerDocumentoDoMonteDoCurso(estudantes.entidades.Documento,
     *      professor.entidades.CodigoCurso)
     * @see professor.entidades.Universidade#devolverDocumentoParaMonteDoCurso(estudantes.entidades.Documento,
     *      professor.entidades.CodigoCurso)
     */
    public void trabalhar() {
        // Itera sobre todos os cursos para encontrar documentos para processar
        for (CodigoCurso codigo : CodigoCurso.values()) {
            // Pega uma cópia dos documentos do monte do curso atual
            Documento[] documentos = universidade.pegarCopiaDoMonteDoCurso(codigo);
            // Se não houver documentos, pula para o próximo curso
            if (documentos.length == 0) {
                continue;
            }
            // Pega o primeiro documento da lista (o mais recente)
            Documento doc = documentos[0];
            // Tenta encontrar um processo vago na mesa para adicionar o documento
            loopProcesso: for (int i = 0; i < mesa.getProcessos().length; i++) {
                Processo proc = mesa.getProcesso(i);
                
                // Variável para tentar garantir que um processo tenha apenas documentos do mesmo tipo (Adm. ou Acad.)
                String temDocAdm = "";

                if (proc != null) { // Verifica se o processo existe (não foi despachado)
                    // REGRA: Despacho imediato para Portarias ou Editais com 100+ páginas.
                    for (Documento docs: documentos){
                        if (doc.getClass().getSimpleName().equals("Portaria") || 
                            doc.getClass().getSimpleName().equals("Edital") &&
                            doc.getPaginas() >= 100                            
                            ){
                                proc.adicionarDocumento(docs);
                                universidade.despachar(proc);

                                break loopProcesso;
                            }
                    }
                    
                    // REGRA: Se todos os documentos no monte forem Atas, o processo não é montado com eles
                    int contador = 0;
                    for(Documento docs: documentos){
                        if (getDocumentoCategoria(docs).equals("Ata")){
                            contador++;
                        }
                    }

                    if (contador == documentos.length){
                        break; // Sai do loop do processo, não monta com apenas Atas
                    }

                    // REGRA 06: Verifica se o monte contém documentos que permitem o despacho de um Diploma
                    // Verifica se o monte contém documentos que permitem o despacho de um Diploma.
                    boolean podeDespachar = false;
                    for (Documento docs: documentos){
                        int temDiploma = 0;
                        boolean temCertificado = false;
                        boolean temAta = false;
                        if (getDocumentoCategoria(docs).equals("Diploma")){
                            temDiploma++;
                        }
                        if (getDocumentoCategoria(docs).equals("Certificado")){
                            temCertificado = true;
                        }
                        if (getDocumentoCategoria(docs).equals("Ata")){
                            temAta = true;
                        }
                        if (temDiploma >= 2 || temCertificado || temAta){
                            podeDespachar = true;
                        }
                    }
                    
                    // Se as condições não forem atendidas, remove os Diplomas do monte para evitar que sejam processados
                    for (Documento docs: documentos){
                        if (!podeDespachar){
                            if (getDocumentoCategoria(docs).equals("Diploma")){
                               universidade.removerDocumentoDoMonteDoCurso(docs, codigo);
                            }
                        }
                    }

                    // REGRA: Não misturar documentos Administrativos e Acadêmicos
                    // Define o tipo do processo com base no primeiro documento
                    if (temDocAdm.equals("")){
                        // caso a String não tenha nada ainda, a primeira verificação ficará salva nela
                        if (getDocumentoCategoria(doc).equals("DocumentoAdministrativo")){
                            temDocAdm = "Sim";
                        }else if(getDocumentoCategoria(doc).equals("DocumentoAcademico")){
                            temDocAdm = "Nao";
                        }
                    }
                    
                    // Remove do monte os documentos que não correspondem ao tipo definido para o processo
                    for (Documento docs : universidade.pegarCopiaDoMonteDoCurso(codigo)){
                        if (temDocAdm.equals("Sim")){
                            if (getDocumentoCategoria(docs).equals("DocumentoAcademico")){
                               universidade.removerDocumentoDoMonteDoCurso(docs, codigo);
                            }
                        }else if (temDocAdm.equals("Nao")){
                             if (getDocumentoCategoria(docs).equals("DocumentoAdministrativo")){
                               universidade.removerDocumentoDoMonteDoCurso(docs, codigo);
                            }
                        }
                    }

                    // REGRA 07: Garante que todos os Atestados em um processo sejam da mesma categoria
                    // Garante que todos os Atestados em um processo sejam da mesma categoria.
                    String primeiraCategoria = "";

                    for (Documento docs : universidade.pegarCopiaDoMonteDoCurso(codigo)){
                        if (docs instanceof Atestado) {
                            Atestado atestado = (Atestado) docs;
                            primeiraCategoria = atestado.getCategoria();
                        }
                    }

                    // Remove do monte os Atestados de categorias diferentes da primeira encontrada
                    for (Documento docs : universidade.pegarCopiaDoMonteDoCurso(codigo)){
                        if (!primeiraCategoria.equals("")){
                           if (docs instanceof Atestado) {
                                Atestado atestado = (Atestado) docs;
                                if (!atestado.getCategoria().equals(primeiraCategoria)){
                                   universidade.removerDocumentoDoMonteDoCurso(docs, codigo);
                                }
                           }
                        }
                    }

                    // Adiciona o documento principal ao processo, despacha e o remove do monte original
                    proc.adicionarDocumento(doc);
                    universidade.despachar(proc);
                    universidade.removerDocumentoDoMonteDoCurso(doc, codigo);
                    
                 break; // Sai do loop de processos, pois um documento já foi usado
                }
            }
            // Atualiza as estatísticas da universidade após o trabalho.
            universidade.contarDocumentosCriados();
            universidade.contarDocumentosDespachados();
            universidade.contarProcessosDespachados();
            universidade.contarDocumentosPerdidos();
        }
    }
    
    /**
     * Método auxiliar para obter a categoria principal de um documento (ex: DocumentoAcademico).
     * <p>
     * Ele navega na hierarquia de classes do documento até encontrar a classe que herda
     * diretamente de {@link Documento}, retornando seu nome.
     * 
     * @param doc O documento a ser analisado.
     * @return O nome da categoria principal do documento ou "Category Not Found" se não for encontrada.
     */
    // ia
    public static String getDocumentoCategoria(Documento doc) {
        // Start at the runtime class of the object (e.g., Portaria.class)
        Class<?> currentClass = doc.getClass();
        
        // Loop up the hierarchy until the superclass is Documento
        while (currentClass != null && currentClass.getSuperclass() != null && !currentClass.getSuperclass().equals(Documento.class)) {
            // Move up to the next superclass
            currentClass = currentClass.getSuperclass();
        }

        // If we found the class whose superclass is Documento, return its name.
        if (currentClass != null && currentClass.getSuperclass().equals(Documento.class)) {
            return currentClass.getSimpleName();
        }

        // Handle the case where the object itself is a Documento or the structure is different
        return "Category Not Found"; 
    }

    /**
     * Retorna o nível de estresse atual do burocrata.
     * 
     * @return O valor inteiro do estresse.
     */
    public int getEstresse() {
        return estresse;
    }

    /**
     * Aumenta o nível de estresse do burocrata em 1.
     */
    public void estressar() {
        estresse++;
    }

    /**
     * Aumenta o nível de estresse do burocrata em 10.
     * Usado para situações de maior impacto.
     */
    public void estressarMuito() {
        estresse += 10;
    }

}