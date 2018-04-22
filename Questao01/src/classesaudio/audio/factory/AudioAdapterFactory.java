/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesaudio.audio.factory;

import classesaudio.FormatoAudio;
import classesaudio.audio.exceptions.AudioNotSupportedException;
import classesaudio.audio.adapters.AACPlayerAdapter;
import classesaudio.audio.adapters.AIFFPlayerAdapter;
import classesaudio.audio.adapters.FormatoAudioAdapter;
import classesaudio.audio.adapters.MP3DJAdapter;
import classesaudio.audio.adapters.WAVPlayerAdapter;
import classesaudio.audio.adapters.WMAPlayerAdapter;
import java.util.HashMap;

/**
 *
 * @author guilh
 */
public class AudioAdapterFactory {

    public static final HashMap<String, Class<? extends FormatoAudioAdapter>> EXTENSION_CLASS_MAP = new HashMap<>();

    static {
        // Registra extensões suportadas e seus respectivos adapters
        registerType(".aiff", AIFFPlayerAdapter.class);
        registerType(".wav", WAVPlayerAdapter.class);
        registerType(".wma", WMAPlayerAdapter.class);

        // Registrar classes esquecidas
        registerType(".mp3", MP3DJAdapter.class);
        registerType(".aac", AACPlayerAdapter.class);
    }

    static void registerType(String ext, Class<? extends FormatoAudioAdapter> c) {
        EXTENSION_CLASS_MAP.put(ext, c);
    }

    /**
     * Implementação usando instanciamento generico. <br>
     * Possui a limitação de não suportar arquivos adapters que não tenham o
     * construtor vazio. Implementado somente como prova de conceito.
     *
     * @deprecated Metodo criado somente a tópico de curiosidade utilizando
     * reflection. A forma preferivel é o metodo
     * <code>openFileManual(...)</code>
     *
     * @param file
     * @return
     * @throws AudioNotSupportedException
     */
    @Deprecated
    public static FormatoAudio openFileGenerico(String file) throws AudioNotSupportedException {

        String ext = "Sem extensão";

        // Arquivo com extensão
        if (file.contains(".")) {

            // Pega a extensão do arquivo
            ext = file.substring(file.lastIndexOf("."));

            // Verifica se é um formato registrado
            if (EXTENSION_CLASS_MAP.containsKey(ext)) {
                try {
                    FormatoAudio item = EXTENSION_CLASS_MAP.get(ext).newInstance();
                    item.abrir(ext);
                    return item;

                } catch (InstantiationException | IllegalAccessException e) {
                    throw new AudioNotSupportedException("O formato deseja não possui construtor vazio (" + ext + ")");
                }
            }
        }

        throw new AudioNotSupportedException("Formato de arquivo não suportado : " + ext);
    }

    /**
     *
     * @param file
     * @return
     * @throws AudioNotSupportedException
     */
    public static FormatoAudio openFileManual(String file) throws AudioNotSupportedException {

        String ext = null;

        // Arquivo com extensão
        if (file.contains(".")) {

            FormatoAudio item = null;

            // Pega a extensão do arquivo
            ext = file.substring(file.lastIndexOf(".")).toLowerCase();

            // Mapeamento manual dos construtores
            switch (ext) {
                case ".aiff":
                    item = new AIFFPlayerAdapter();
                    break;

                case ".wav":
                    item = new WAVPlayerAdapter();
                    break;

                case ".wma":
                    item = new WMAPlayerAdapter();
                    break;

                // Adicionado tratamento para formato MP3 ("esquecido" inicialmente)
                case ".mp3":
                    item = new MP3DJAdapter();
                    break;

                // Adicionado tratamento para formato AAC ("esquecido" inicialmente)
                case ".aac":
                    item = new AACPlayerAdapter();
                    break;
            }

            if (item != null) {
                item.abrir(file);
                return item;
            }

        }

        throw new AudioNotSupportedException("Formato de arquivo não suportado : "
                + (isNullOrEmpty(ext) ? "Arquivo sem extensão" : ext));
    }

    private static boolean isNullOrEmpty(String str) {
        return !(str != null && !str.isEmpty());
    }
}
