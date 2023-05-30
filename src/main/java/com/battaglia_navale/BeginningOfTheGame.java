package com.battaglia_navale;



public class BeginningOfTheGame implements GameState {
    private BattleShip battleShip;
    private PlayerScreen player1;
    private PlayerScreen player2;

    BeginningOfTheGame(BattleShip battleShip,PlayerScreen player1,PlayerScreen player2){
        this.player1 = player1;
        this.player2 = player2;
        this.battleShip = battleShip;
    }

    //turn ON SelfGrid for player 1
    public void player1Turn (){
        player1.getSelfGrid().setSelfGridListener(true);
    }

    //turn OFF SelfGrid for player 2
    public void player2turn (){
        player2.getSelfGrid().setSelfGridListener(true);
        battleShip.setState(battleShip.getMiddleOfTheGame());
    }

}