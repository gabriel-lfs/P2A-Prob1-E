/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesaudio.audio;

import classesaudio.FormatoAudio;
import problema1.AIFFSuperPlayer;

/**
 *
 * @author gabriel
 */
public class AIFFPlayerImp implements FormatoAudio {
    
    private AIFFSuperPlayer player;
    private int posicao = 0;

    @Override
    public void abrir(String nomeArquivo) {
        player = new AIFFSuperPlayer(nomeArquivo);
    }

    @Override
    public void reproduzir() {
        player.setCursor(posicao);
        player.play();
    }

    @Override
    public void pausar() {
        posicao = player.pause();
    }

    @Override
    public void parar() {
        player.stop();
    }

    @Override
    public void avancar(int ponteiro) {
        this.pausar();
        this.reproduzir();
        player.setCursor(posicao + ponteiro);
    }

    @Override
    public void retomar(int ponteiro) {
        this.pausar();
        this.reproduzir();
        player.setCursor(posicao - ponteiro);
    }

    @Override
    public void liberar() {
        player.release();
    }

    @Override
    public void reproduzirSimples(String nomeArquivo) {
        this.abrir(nomeArquivo);
        this.reproduzir();
    }

    @Override
    public void pararSimples() {
        this.parar();
        this.liberar();
    }
}