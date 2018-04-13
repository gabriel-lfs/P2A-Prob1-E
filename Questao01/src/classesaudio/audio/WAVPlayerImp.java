/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesaudio.audio;

import classesaudio.FormatoAudio;
import problema1.WAVPlayer;

/**
 *
 * @author gabriel
 */
public class WAVPlayerImp implements FormatoAudio {

    private WAVPlayer player;
    private int posicao = 0;
    @Override
    public void abrir(String nomeArquivo) {
        player = new WAVPlayer(nomeArquivo);
    }

    @Override
    public void reproduzir() {
        player.forward(posicao);
        player.play();
    }

    @Override
    public void pausar() {
        posicao = player.forward(0);
        player.stop();
    }

    @Override
    public void parar() {
        player.stop();
    }

    @Override
    public void avancar(int ponteiro) {
        player.forward(ponteiro);
    }

    @Override
    public void retomar(int ponteiro) {
        player.reward(ponteiro);
    }

    @Override
    public void liberar() {
        player.stop();
    }
     
}
