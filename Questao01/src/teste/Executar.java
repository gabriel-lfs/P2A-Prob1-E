/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import classesaudio.audio.PlaylistAudioPlayer;
import classesaudio.audio.SimpleAudioPlayer;
import classesaudio.audio.exceptions.AudioException;

/**
 *
 * @author gbrisida
 */
public class Executar {

    private static final String[] ARQUIVOS = new String[]{
        "Ok.aac",
        "Ok.aiff",
        "Ok.wav",
        "Ok.wma",
        "Ok.mp3"
    };

    public static void main(String[] args) throws AudioException {
        // Execução da versão simples
        System.out.println("Execução da versão simples");
        simple();

        System.out.println("\n");

        // Execução da versão complexa
        System.out.println("Execução da versão complexa");
        complex();
    }

    public static void simple() throws AudioException {
        SimpleAudioPlayer simplePlayer = new SimpleAudioPlayer();

        for (String it : ARQUIVOS) {
            simplePlayer.reproduzirSimples(it);
        }
    }

    public static void complex() throws AudioException {
        PlaylistAudioPlayer player = new PlaylistAudioPlayer(ARQUIVOS);
        player.start();
        player.reproduzirSimples("nova_musica.aiff");
    }
}
