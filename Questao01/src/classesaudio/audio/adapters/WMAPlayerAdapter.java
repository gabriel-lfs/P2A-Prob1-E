/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesaudio.audio.adapters;

import problema1.wmaPlay;

/**
 *
 * @author gabriel
 */
public class WMAPlayerAdapter extends FormatoAudioAdapter {

    private final wmaPlay player = new wmaPlay();

    @Override
    public void abrir(String nomeArquivo) {
        player.setFile(nomeArquivo);
        player.setLocation(0);
        player.open();
    }

    @Override
    public void reproduzir() {
        player.play();
    }

    @Override
    public void pausar() {
        /*
         * ## wmaPlay.stop()
         * ## Caso a próxima mensagem seja play(), reinicia a execução do ponto onde parou.
         * ## Caso a próxima mensagem seja stop(), reinicia a execução do ponto onde parou.
         * 
         * *** Salva a posição e seta novamente caso seja chamado o "pausar" duas vezes seguidas.
         * *** pois o comportamento de "pausar" não pode divergir entre chamadas
         * *** diferentemente do stop
         */
        int posicao = player.getLocation();
        player.stop();
        player.setLocation(posicao);
    }

    @Override
    public void parar() {
        player.stop();
        player.setLocation(0);
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
        player.stop();
        player.setFile(null);
    }

}
