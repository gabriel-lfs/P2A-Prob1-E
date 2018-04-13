package classesaudio;

/**
 * Ver "template" design pattern
 * "Bridge"
 * 
 * @author gabriel
 */
public interface FormatoAudio {
    void abrir(String nomeArquivo);
    void reproduzir();
    void pausar();
    void parar();
    void avancar(int ponteiro);
    void retomar(int ponteiro);
    void liberar();
}
