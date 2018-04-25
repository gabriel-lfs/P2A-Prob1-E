/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesaudio.audio.exceptions;

/**
 *
 * @author gbrisida
 */
public class AudioNotSupportedException extends AudioException {

    public AudioNotSupportedException(String message) {
        super(message);
    }

    public AudioNotSupportedException(String message, Throwable cause) {
        super(message, cause);
    }

}
