--> Prof. Marcel: implementação correta dos padrões.

# Mapeamentos
Adapter: 
Encapsula uma classe (target) e adapta a sua utilização para funcionar como um modelo de 
 outra classe (adaptee), inicialmente incompativel.
  - Target  -> (AIFFSuperPlayer, WAVPlayer, wmaPlay, AACPlayer, MP3DJ)
  - Adaptee -> FormatoAudio
--> Prof. Marcel: ao contrário: o Target é FormatoAudio; os Adaptees são as classes da empresa (.jar); os Adapters, as classes desenvolvidas pela equipe

Factory:
Abstrai a construção de objetos que assinem determinado contrato (interface)
  - AudioAdapterFactory
  --> Prof. Marcel: quem é Product? Quem é ConcreteProduct?

Façade: 
Simplifica o acesso a uma API complexa
 - Modelo: AudioFacade
 - Implementações: (SimpleAudioPlayer, PlaylistAudioPlayer)
 --> Prof. Marcel: a fachada, como prevista no problema, é a implementação SimpleAudioPlayer
