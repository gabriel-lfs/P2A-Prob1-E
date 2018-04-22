/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesaudio.audio;

import classesaudio.audio.exceptions.AudioNotSupportedException;
import classesaudio.FormatoAudio;
import classesaudio.audio.factory.AudioAdapterFactory;
import java.util.Optional;

/**
 *
 * @author gbrisida
 */
public class SimpleAudioPlayer implements AudioFacade {

    private Optional<FormatoAudio> formatoAudio = Optional.empty();

    @Override
    public void reproduzirSimples(String arquivo) throws AudioNotSupportedException {

        // Caso já estivesse executando outro arquivo, encerra o anterior
        // Obs.: O pararSimples já trata com segurança caso não esteja reproduzindo nada
        pararSimples();

        // Abre o arquivo
        formatoAudio = Optional.of(AudioAdapterFactory.openFileManual(arquivo));

        // Inicia a reprodução do arquivo
        formatoAudio.ifPresent(FormatoAudio::reproduzir);
    }

    @Override
    public void pararSimples() {
        formatoAudio.ifPresent(item -> {
            item.parar();
            item.liberar();
        });
        formatoAudio = Optional.empty();
    }
}
