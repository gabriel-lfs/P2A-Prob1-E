/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesaudio.audio;

/**
 *
 * @author guilh
 */
public interface AudioFacade {

    // Lança exceção generia, a ser sobrescrita por implementações caso necessário
    void reproduzirSimples(String arquivo) throws Exception;

    void pararSimples();

}
