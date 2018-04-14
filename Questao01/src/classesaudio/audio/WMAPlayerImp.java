/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesaudio.audio;

import classesaudio.FormatoAudio;
import problema1.wmaPlay;

/**
 *
 * @author gabriel
 */
public class WMAPlayerImp implements FormatoAudio {
    
    private final wmaPlay player = new wmaPlay();
    private int posicao = 0;
    @Override
    public void abrir(String nomeArquivo) {
        player.setFile(nomeArquivo);
        player.open();
    }

    @Override
    public void reproduzir() {
        player.setLocation(posicao);
        player.play();
    }

    @Override
    public void pausar() {
        posicao = player.getLocation();
        player.stop();
    }

    @Override
    public void parar() {
        player.stop();
    }

    @Override
    public void avancar(int ponteiro) {
        player.setLocation(player.getLocation() + ponteiro);
    }

    @Override
    public void retomar(int ponteiro) {
        player.setLocation(player.getLocation() - ponteiro);
    }

    @Override
    public void liberar() {
        player.stop();
    }
    
}
