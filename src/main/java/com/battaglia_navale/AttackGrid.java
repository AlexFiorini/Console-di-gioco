package com.battaglia_navale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



/**
 Represents the player's own grid
 */
public class AttackGrid extends BattleGrid {
    private String name;
    private int enemyShipSunkPlayer1 = 0;
    private int enemyShipSunkPlayer2 = 0;
    private boolean isAttackGridListener ;
    private BattleShip battleShip;
    private PlayerScreen player;
    private JPanel thePanel = null;


    public AttackGrid(String name,BattleShip battleShip,PlayerScreen player) {
        super();
        this.name = name;
        this.player = player;
        this.battleShip = battleShip;

    }

    @Override
    protected JPanel getCell()
    {
        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        panel.setPreferredSize(new Dimension(20, 20)); // for demo purposes only

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(isAttackGridListener) {

                    Point i = panel.getLocation();
                    double xPos = (i.getX() / 20 + 1);
                    int x = (int) xPos;
                    double yPos = (i.getY() / 20 + 1);
                    int y = (int) yPos;

                    if (name.equals("Player1")) {
                        if(!battleShip.getTakeTurnAttack()) {
                            battleShip.setTakeTurnAttack(true);
                            Coordinate hit = new Coordinate(x, y);
                            battleShip.getPlayer2Data().attackShip(hit);

                            boolean Successo = battleShip.getPlayer2Data().isHit(hit);
                            if (Successo) {
                                battleShip.getPlayer1Data().setAttackData(x, y, "Successo");
                                draw();
                            } else {
                                battleShip.getPlayer1Data().setAttackData(x, y, "Fallimento");
                                draw();
                            }

                            boolean isSunk = battleShip.getPlayer2Data().isSunk(hit);
                            if (isSunk) {
                                enemyShipSunkPlayer1++;
                                battleShip.getPlayer1().enemyShipSunk.setText(Integer.toString(enemyShipSunkPlayer1));
                                JOptionPane.showMessageDialog(panel, "La nave del giocatore 2 è affondata! Congratulazioni!\nClicca OK per passare allo schermo del giocatore 2");
                                player.hideScreen();
                                battleShip.getPlayer2().showScreen();
                                String ownShipSunkPlayer2 = Integer.toString(battleShip.getPlayer2Data().getNumberOfOwnShipSunk());
                                battleShip.getPlayer2().ownShipSunk.setText(ownShipSunkPlayer2);
                            }
                        }
                        boolean lost = battleShip.getPlayer2Data().isPlayerLost();
                            if (lost) {
                                battleShip.setState(battleShip.getEndOfTheGame());
                                JOptionPane.showMessageDialog(panel, "Hai vinto Giocatore 1! Congratulazioni!\nClicca OK per uscire dal gioco");
                                battleShip.player1Turn();
                            }

                        }
                        if (name.equals("Player2")) {
                            if(battleShip.getTakeTurnAttack()) {
                                battleShip.setTakeTurnAttack(false);
                                Coordinate hit = new Coordinate(x, y);
                                battleShip.getPlayer1Data().attackShip(hit);

                                boolean Successo = battleShip.getPlayer1Data().isHit(hit);
                                if (Successo) {
                                    System.out.print("Attacco giocatore 2");
                                    battleShip.getPlayer2Data().setAttackData(x, y, "Successo");
                                    draw();
                                } else {
                                    battleShip.getPlayer2Data().setAttackData(x, y, "Fallimento");
                                    draw();
                                }

                                boolean isSunk = battleShip.getPlayer1Data().isSunk(hit);
                                if (isSunk) {
                                    enemyShipSunkPlayer2++;
                                    battleShip.getPlayer2().enemyShipSunk.setText(Integer.toString(enemyShipSunkPlayer2));
                                    JOptionPane.showMessageDialog(panel, "La nave del giocatore 1 è affondata! Congratulazioni!\nClicca OK per passare allo schermo del giocatore 1");
                                    player.hideScreen();
                                    battleShip.getPlayer1().showScreen();
                                    String ownShipSunkPlayer1 = Integer.toString(battleShip.getPlayer1Data().getNumberOfOwnShipSunk());
                                    battleShip.getPlayer1().ownShipSunk.setText(ownShipSunkPlayer1);
                                }
                            }
                                boolean lost = battleShip.getPlayer1Data().isPlayerLost();
                                if (lost) {
                                    battleShip.setState(battleShip.getEndOfTheGame());
                                    JOptionPane.showMessageDialog(panel, "Hai vinto Giocatore 2! Congratulazioni!\nClicca OK per uscire dal gioco");
                                    battleShip.player2turn();
                                }
                            }
                        }


            }
        });

        return panel;
    }
    public void setAttackGridListener (boolean attackGridListener){
        this.isAttackGridListener = attackGridListener;

    }
    public void getJpanel(Point newPoint){
        thePanel = this.getComponentAt(newPoint);
    }

    public void draw(){

        int[][] temp=null;
        if(name.equals("Player1")){
            temp = battleShip.getPlayer1Data().getAttackData();
        }
        else if(name.equals("Player2")){
            temp = battleShip.getPlayer2Data().getAttackData();
        }

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++)
            {
                if(temp[i][j]==1){
                    int x = numberToPanel(i);
                    int y = numberToPanel(j);

                    Point p = new Point(x,y);
                    getJpanel(p);
                    thePanel.setBackground(Color.GREEN);
                }
                if(temp[i][j]==2){
                    int x = numberToPanel(i);
                    int y = numberToPanel(j);

                    Point p = new Point(x,y);
                    getJpanel(p);
                    thePanel.setBackground(Color.BLUE);

                }
            }
        }
    }

    public int numberToPanel(int s){
        int temp = (s-1)*20;
        return temp;
    }

    public boolean getAttackGridListener() {
        return isAttackGridListener;
    }
}