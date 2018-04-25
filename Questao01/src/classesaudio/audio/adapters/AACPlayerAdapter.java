/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesaudio.audio.adapters;

import problema1.AACPlayer;

/**
 *
 * @author guilh
 */
public class AACPlayerAdapter extends FormatoAudioAdapter {

    private AACPlayer player;

    @Override
    public void abrir(String nomeArquivo) {
        player = new AACPlayer(nomeArquivo);
        player.open();
        player.setLocation(0);
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
        player.stop();
        player.stop();
    }

    @Override
    public void avancar(int ponteiro) {
        player.setLocation(player.getLocation() + ponteiro);
    }

    @Override
    public void retornar(int ponteiro) {
        player.setLocation(player.getLocation() - ponteiro);
    }

    @Override
    public void liberar() {
        this.parar();
    }

}
