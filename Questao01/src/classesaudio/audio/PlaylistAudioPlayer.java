/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesaudio.audio;

import classesaudio.FormatoAudio;
import classesaudio.audio.exceptions.AudioException;
import classesaudio.audio.exceptions.EmptyAudioException;
import classesaudio.audio.factory.AudioAdapterFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

/**
 *
 * @author guilh
 */
public class PlaylistAudioPlayer implements AudioFacade {

    private Optional<FormatoAudio> formatoAudio = Optional.empty();
    private final ArrayList<String> playlist;
    private Optional<Integer> current;

    public PlaylistAudioPlayer() {
        this.playlist = new ArrayList<>();
        this.current = Optional.empty();
    }

    public PlaylistAudioPlayer(String... musics) {
        this.playlist = new ArrayList<>(Arrays.asList(musics));
        this.current = Optional.empty();
    }

    public void playPrevious() throws AudioException {
        if (current.isPresent()) {
            playForIndex(current.get() - 1);
        }
    }

    public void start() throws AudioException {
        for (int i = 0; i < playlist.size(); i++) {
            playForIndex(i);
        }
    }

    public void stop() {
        pararSimples();
    }

    public void playNext() throws AudioException {
        if (current.isPresent()) {
            playForIndex(current.get() + 1);
        }
    }

    @Override
    public void reproduzirSimples(String arquivo) throws AudioException {
        if (!playlist.contains(arquivo)) {
            playlist.add(arquivo);
        }
        playForIndex(playlist.indexOf(arquivo));
    }

    @Override
    public void pararSimples() {
        formatoAudio.ifPresent(audio -> {
            audio.parar();
            audio.liberar();

            // Remove arquivo que está em execução
            formatoAudio = Optional.empty();
            // Obs.: Apesar de interromper a execução, não é limpado o indicador
            // de faixa atual (current) para manter a noção de playlist 
            // interrompida que pode ser resumida posteriormente
        });
    }

    private void playForIndex(int index) throws AudioException {
        String music;

        // Lista de reprodução possui arquivos selecionados
        if (playlist.size() > 0) {

            if (index >= 0 && index < playlist.size()) {
                // Index valido
                music = playlist.get(index);
            } else {
                // Reproduzir index maior que o ultimo, volta para o começo
                // Reproduzir index menor que zero, vai para o ultimo

                if (index < 0) {
                    music = playlist.get(playlist.size() - 1);
                } else {
                    music = playlist.get(0);
                }
            }

            // Instancia o arquivo de audio
            formatoAudio.ifPresent(audio -> {
                pararSimples();
            });

            formatoAudio = Optional.of(AudioAdapterFactory.openFileManual(music));
            current = Optional.of(index);

            // Reproduz o arquivo de audio
            formatoAudio.get().reproduzir();

        } else {
            throw new EmptyAudioException("Nenhum arquivo carregado");
        }
    }
}
