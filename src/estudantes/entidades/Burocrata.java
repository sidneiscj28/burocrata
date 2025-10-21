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
    private int estresse = 0;
    private Mesa mesa;
    private Universidade universidade;

    /**
     * Construtor de Burocrata.
     * 
     * @param m mesa com os processos
     * @param u universidade com os montes dos cursos e a secretaria
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
        // Itera sobre todos os códigos de curso existentes na enumeração CodigoCurso
        for (CodigoCurso codigo : CodigoCurso.values()) {
            // Pega os documentos do monte do curso atual
            Documento[] documentos = universidade.pegarCopiaDoMonteDoCurso(codigo);
            // Se não houver documentos neste monte, passa para o próximo curso
            if (documentos.length == 0) {
                continue;
            }
            // Pega o primeiro documento da lista (o mais recente)
            Documento doc = documentos[0];
            // Tenta encontrar um processo vago na mesa para adicionar o documento
            loopProcesso: for (int i = 0; i < mesa.getProcessos().length; i++) {
                Processo proc = mesa.getProcesso(i);

                /*
                 * String para verificar se o primeiro documento do processo é adm
                 * caso for não incluirá Academicos
                 * Serve para situação oposta
                 */
                String temDocAdm = "";
                
                if (proc != null) { // Verifica se o processo existe (não foi despachado)

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
                    

                    int contador = 0;
                    for(Documento docs: documentos){
                        if (getDocumentoCategoria(docs).equals("Ata")){
                            contador++;
                        }
                    }

                    if (contador == documentos.length){
                        break;
                    }

                    // REGRA 06
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
                    
                    for (Documento docs: documentos){
                        if (!podeDespachar){
                            if (getDocumentoCategoria(docs).equals("Diploma")){
                               universidade.removerDocumentoDoMonteDoCurso(docs, codigo);
                            }
                        }
                    }

                    // FIM DA REGRA 06



                    // verifica se a String temDocAdm já foi inicializada (primeira verificação)
                    if (temDocAdm.equals("")){
                        // caso a String não tenha nada ainda, a primeira verificação ficará salva nela
                        if (getDocumentoCategoria(doc).equals("DocumentoAdministrativo")){
                            temDocAdm = "Sim";
                        }else if(getDocumentoCategoria(doc).equals("DocumentoAcademico")){
                            temDocAdm = "Nao";
                        }
                    }
                    
                    // loop para filtrar documentos
                    // separando removendo docAdm ou Academico do mesmo processo
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

                        
                        //começo regra 5
                    //     Set<String> destinatario= new HashSet<>();
                    // if (doc.getClass().getSimpleName().equals("Circular")){
                    //     Circular circular = (Circular) doc;

                    //     for (String dest : circular.getDestinatarios()){
                    //         destinatario.add(dest);
                    //     }
                    // }

                    // if (doc.getClass().getSimpleName().equals("Oficio")){
                    //     Oficio oficio = (Oficio) doc;
                    //         System.out.println(oficio.getDestinatario());
                    //     if(destinatario.contains(oficio.getDestinatario())){
                    //         System.out.println("mesmos destinatarios");
                    //     }else{
                    //         System.out.println("destinatarios diferentes");
                    //     }
                        
                    }
                    //final regra 5
                                     
                    

                    // ia - REMOVER ESTE BLOCO QUANDO NÃO FOR MAIS NECESSÁRIO
                    // ESTE BLOCO É PARA EXIBIR OS DOCUMENTOS DE CADA PROCESSO
                    // TUDO QUE FICA PRINTADO DENTRO DESSES "=====" É UM PROCESSO DIFERENTE
                
                    // System.out.println("===============================");
                    
                    // for (Documento docs : universidade.pegarCopiaDoMonteDoCurso(codigo)){
                    //     System.out.print("Curso: " + codigo + " => ");
                    //     System.out.println(docs.getClass().getSimpleName());
                    //     System.out.println("Páginas: " + doc.getPaginas()); 

                    // }
                    // System.out.println("===============================");
                  
                  
                    // ==============================================================

                    // REGRA 07 
                    String primeiraCategoria = "";

                    for (Documento docs : universidade.pegarCopiaDoMonteDoCurso(codigo)){
                        if (docs instanceof Atestado) {
                            Atestado atestado = (Atestado) docs;
                            primeiraCategoria = atestado.getCategoria();
                        }
                    }

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

                    // FIM DA REGRA 07

                  
                    proc.adicionarDocumento(doc);
                    universidade.despachar(proc);
                    universidade.removerDocumentoDoMonteDoCurso(doc, codigo);

                 break;
                }
                // Pega os documentos do monte do curso atual
                /*
                 * Documento[] documentos = universidade.pegarCopiaDoMonteDoCurso(codigo);
                 * 
                 * // Se não houver documentos neste monte, passa para o próximo curso
                 * if (documentos.length == 0) {
                 * return;
                 * }
                 * 
                 * // Pega o primeiro documento da lista (o mais recente)
                 * Documento doc = documentos[0];
                 * 
                 * // Tenta encontrar um processo vago na mesa para adicionar o documento
                 * for (int i = 0; i < mesa.getProcessos().length; i++) {
                 * Processo proc = mesa.getProcesso(i);
                 * if (proc != null) { // Verifica se o processo existe (não foi despachado)
                 * universidade.removerDocumentoDoMonteDoCurso(doc, codigo);
                 * proc.adicionarDocumento(doc);
                 * universidade.despachar(proc);
                 * break; // Sai do loop dos processos, pois já usou o documento
                 * }
                 * }
                 */
            }
            universidade.contarDocumentosCriados();
            universidade.contarDocumentosDespachados();
            universidade.contarProcessosDespachados();
            universidade.contarDocumentosPerdidos();
        }
    }

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
     * Método getEstresse
     * 
     * @return
     */
    public int getEstresse() {
        return estresse;
    }

    /**
     * Método estressar
     * 
     * @return
     */
    public void estressar() {
        estresse++;
    }

    /**
     * Método estressarMuito
     * 
     * @return
     */
    public void estressarMuito() {
        estresse += 10;
    }

}