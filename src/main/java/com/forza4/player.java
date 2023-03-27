package com.forza4;

public class player extends campo {


    private String nome;
    private String cognome;
    private String colore;

    private int numerogiocatore;


    player(String[][] grig, String n, String c, String color, int num) {
        super(grig);
        colore=color;
        nome=n;
        cognome=c;
        numerogiocatore=num;
    }

    void impostagiocatore(int numg)
    {
        numerogiocatore=numg;
    }
    void impostacolore(int numg)
    {
            if( numg == 0)
            {
                colore.equals("rosso");
            }
            if( numg == 1)
            {
                colore.equals("giallo");
            }
    }

}
