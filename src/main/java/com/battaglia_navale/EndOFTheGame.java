package com.battaglia_navale;



public class EndOFTheGame implements GameState {
    private BattleShip battleShip;
    private PlayerScreen player1;
    private PlayerScreen player2;

    EndOFTheGame(BattleShip battleShip, PlayerScreen player1, PlayerScreen player2){
        this.battleShip = battleShip;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void player1Turn (){
        System.out.println("Fine del gioco giocatore 1 ");
        System.exit(0);
    }
    public void player2turn (){
        System.out.println("Fine del gioco giocatore 2 ");
        System.exit(0);
    }
}