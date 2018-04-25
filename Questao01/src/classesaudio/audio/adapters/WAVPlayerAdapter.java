/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesaudio.audio.adapters;

import problema1.WAVPlayer;

/**
 *
 * @author gabriel
 */
public class WAVPlayerAdapter extends FormatoAudioAdapter {

    private WAVPlayer player;

    @Override
    public void abrir(String nomeArquivo) {
        player = new WAVPlayer(nomeArquivo);
    }

    @Override
    public void reproduzir() {
        player.play();
    }

    @Override
    public void pausar() {
        player.stop();
    }

    @Override
    public void parar() {
        // Para a execução
        player.stop();
            
        // Volta para o inicio
        player.reward(player.forward(0));
    }

    @Override
    public void avancar(int ponteiro) {
        player.forward(ponteiro * 1000);
    }

    @Override
    public void retornar(int ponteiro) {
        player.reward(ponteiro * 1000);
    }

    @Override
    public void liberar() {
        player.stop();
    }

}
