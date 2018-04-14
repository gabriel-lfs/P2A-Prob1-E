package classesaudio.audio;

import problema1.*;
import classesaudio.FormatoAudio;

/**
 * Identifica o formato de arquivo e retorna um FormatoAudio correto
 * @author gabriel
 */
public class AudioPlayerFactory {
    
    private String arquivo;
    
    public AudioPlayerFactory(String arquivo) {
        this.arquivo = arquivo;
    }
    
    public FormatoAudio build(){
        FormatoAudio fa = null;
        String extensao = this.arquivo.split("\\.")[this.arquivo.split("\\.").length-1];
        switch (extensao) {
            case "wma": fa = new WMAPlayerImp();
                        break;
            case "aiff": fa = new AIFFPlayerImp();
                         break;
            case "wav": fa = new WAVPlayerImp();
                        break;
        }
        if (fa != null) {
            fa.abrir(this.arquivo);
            return fa;
        } else {
            throw new IllegalArgumentException("ya dun goofed");
        }
    }
}
