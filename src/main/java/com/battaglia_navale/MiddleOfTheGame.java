package com.battaglia_navale;



public class MiddleOfTheGame implements GameState{
    private BattleShip battleShip;
    private PlayerScreen player1;
    private PlayerScreen player2;

    MiddleOfTheGame(BattleShip battleShip,PlayerScreen player1,PlayerScreen player2){
        this.battleShip = battleShip;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void player1Turn (){
        player1.getSelfGrid().setSelfGridListener(false);
        player1.getAttackGrid().setAttackGridListener(true);
    }
    public void player2turn (){
        player2.getSelfGrid().setSelfGridListener(false);
        player2.getAttackGrid().setAttackGridListener(true);
    }



}