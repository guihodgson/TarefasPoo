package ProjetoPoo.Eventos;

import ProjetoPoo.InputHandler;

public abstract class Evento {

    public abstract boolean iniciar(InputHandler inputHandler, ContextoHeroi ctx);

}
