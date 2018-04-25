/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesaudio.audio.adapters;

import problema1.MP3DJ;

/**
 *
 * @author guilh
 */
public class MP3DJAdapter extends FormatoAudioAdapter {

    private final MP3DJ player = new MP3DJ();
    @Override
    public void abrir(String nomeArquivo) {
        player.setFile(nomeArquivo);
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
        int qtdeRetornar = player.reward(0);
        player.reward(qtdeRetornar);
    }

    @Override
    public void avancar(int ponteiro) {
        player.forward(ponteiro);
    }

    @Override
    public void retornar(int ponteiro) {
        player.reward(ponteiro);
    }

    @Override
    public void liberar() {
        player.stop();
        player.setFile(null);
    }
}