/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesaudio.audio.exceptions;

/**
 *
 * @author guilh
 */
public class EmptyAudioException extends AudioException {

    public EmptyAudioException(String message) {
        super(message);
    }

    public EmptyAudioException(String message, Throwable cause) {
        super(message, cause);
    }
}
