/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesaudio.audio.adapters;

import problema1.AIFFSuperPlayer;

/**
 *
 * @author gabriel
 */
public class AIFFPlayerAdapter extends FormatoAudioAdapter {

    private AIFFSuperPlayer player;

    @Override
    public void abrir(String nomeArquivo) {
        player = new AIFFSuperPlayer(nomeArquivo);
    }

    @Override
    public void reproduzir() {
        player.play();
    }

    @Override
    public void pausar() {
        player.pause();
    }

    @Override
    public void parar() {
        player.stop();
        player.setCursor(0);
    }

    @Override
    public void avancar(int ponteiro) {
        player.setCursor(player.pause() + ponteiro);
        player.play();
    }

    @Override
    public void retornar(int ponteiro) {
        player.setCursor(player.pause() - ponteiro);
        player.play();
    }

    @Override
    public void liberar() {
        player.release();
    }

}
