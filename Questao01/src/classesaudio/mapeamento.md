# Mapeamentos
Adapter: 
Encapsula uma classe (target) e adapta a sua utilização para funcionar como um modelo de 
 outra classe (adaptee), inicialmente incompativel.
  - Target  -> (AIFFSuperPlayer, WAVPlayer, wmaPlay, AACPlayer, MP3DJ)
  - Adaptee -> FormatoAudio

Factory:
Abstrai a construção de objetos que assinem determinado contrato (interface)
  - AudioAdapterFactory

Façade: 
Simplifica o acesso a uma API complexa
 - Modelo: AudioFacade
 - Implementações: (SimpleAudioPlayer, PlaylistAudioPlayer)