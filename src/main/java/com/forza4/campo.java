package com.forza4;

public class campo {

    private String[][] griglia = new String[6][6];


    //costruttore
    campo(String[][] grig) {
        grig = griglia;
    }

    //metodi
    void riempi(int y, String player) {
        
        int i;
        
        for(i=5;i<0;i--)
        {
            if(!griglia[i][y].equals("vuoto"))
            {
                griglia[i][y]=player;
                i=0;
            }
        }
    }

    void controllaquattro()
        {
            int y,i;
            int flagvittoria=0;

            //controllo verticali
            for(y=0;y<6;y++)
            {
                for(i=0;i<3;i++)
                {
                    if(griglia[i+1][y]==griglia[i][y])
                    {
                        if(griglia[i+2][y]==griglia[i][y])
                        {
                            if(griglia[i+3][y]==griglia[i][y])
                            {
                                flagvittoria=1;
                            }
                        }
                    }
                }
            }

            //controllo orizzontali

            if(flagvittoria==0)
            {


                for(i=0;i<6;i++)
                {
                    for(y=0;y<3;y++)
                    {
                        if(griglia[i][y+1]==griglia[i][y])
                        {
                            if(griglia[i][y+2]==griglia[i][y])
                            {
                                if(griglia[i][y+3]==griglia[i][y])
                                {
                                    flagvittoria=1;
                                }
                            }
                        }
                    }
                }
            }


                //diagonali da sinistra a destra

            if(flagvittoria==0)
            {
               for(i=3;i<6;i++)
               {
                   for(y=0;y<3;y++)
                   {
                       if (griglia[i - 1][y + 1] == griglia[i][y]) {
                           if (griglia[i - 2][y + 2] == griglia[i][y]) {
                               if (griglia[i - 3][y + 3] == griglia[i][y]) {
                                   flagvittoria = 1;
                               }
                           }
                       }
                   }
               }
            }



                //diagonali da destra a sinistra

            if(flagvittoria==0)
            {
                for(y=3;y<6;y++)
                {
                    for(i=0;i<3;i++)
                    {
                        if (griglia[i + 1][y - 1] == griglia[i][y]) {
                            if (griglia[i + 2][y - 2] == griglia[i][y]) {
                                if (griglia[i + 3][y - 3] == griglia[i][y]) {
                                    flagvittoria = 1;
                                }
                            }
                        }
                    }
                }
            }






        }

    void controllapari(){
        int flag=0,i,y;

        do
        {
            for(y=0;y<6;y++)
            {
                for (i = 0; i < 6; i++)
                {
                    if(griglia[y][i]=="vuoto")
                    {
                        flag=1;
                    }
                }
            }
        }while (flag==0);

    }


    void inizializza(){
        int i,y;
        for(y=0;y<6;y++) {
            for (i = 0; i < 6; i++) {
                griglia[y][i] = "vuoto";

            }
        }    
    }
}