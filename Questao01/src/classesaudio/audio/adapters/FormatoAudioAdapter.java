/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesaudio.audio.adapters;

import classesaudio.FormatoAudio;

/**
 * Utilizado uma classe Abstrata para permitir a utilização de decorators caso
 * necessário alterar o comportamento das classes.
 *
 * @author guilh
 */
public abstract class FormatoAudioAdapter implements FormatoAudio {

    public FormatoAudioAdapter() {
        // Sem nenhum decorador por enquanto
    }

}
