# 21/11/2025 - G
    Hola amigos, hice este documento por si necesitamos dejar por escrito los cambios que fuimos haciendo.

    HelpDebug.java
        Esta clase sirve para rastrear los sysos dentro del proyecto, una vez crece se vuelven imposibles de encontrar y terminamos con una consola llena mensajes imposibles de debugear.

    Recursos.java
        Puse esta clase para especificar la ruta de las texturas, sonidos y algunas cosas de traduccion.

    EstadosJuego.java - ENUM
        nos sirve como variable de control, el jugador puede estar "jugando" y pasa tal cosa, si esta en "pausa" queremos que no corra el tiempo por ejemplo. Este enum es importante para poder hacer cosas dependiendo de su valor, ademas, cuanto mas detalle tenga mejor. si queremos que en el menu suene una musica y en le menu de configuracion otra, entonces tendriamos que crear un valor MENU, CONFIGURACION y en un manager o clase pertinente agregar todas las distinciones

    