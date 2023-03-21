package com.forza4;

public class campo {

    private int[][] griglia = new int[6][6];


    //costruttore
    campo(int[][] grig) {
        grig = griglia;
    }

    //metodi
    void riempi(int y, int player) {

        int i;

        for(i=6;i==0;i--)
        {
            if(griglia[i][y]!=0);
        }

    }
    void inizializza(){
        int i;

        for(i=0;i<6;i++)
        {
            griglia[i][i]=0;
        }
    }
}