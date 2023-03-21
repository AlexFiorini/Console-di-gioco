package com.tris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Finestra {

    JFrame Finestra= new JFrame("Tris");
    JButton Bottone1= new JButton();
    JButton Bottone2= new JButton();
    JButton Bottone3= new JButton();
    JButton Bottone4= new JButton();
    JButton Bottone5= new JButton();
    JButton Bottone6= new JButton();
    JButton Bottone7= new JButton();
    JButton Bottone8= new JButton();
    JButton Bottone9= new JButton();
    int cont = 0;
    Ascoltatore listener= new Ascoltatore();
    int mat[][]= new int [3][3];

    Finestra()
    {

        Finestra.setLayout(new GridLayout(3,3));


        Bottone1.addActionListener(listener);
        Finestra.add(Bottone1);
        Bottone2.addActionListener(listener);
        Finestra.add(Bottone2);
        Bottone3.addActionListener(listener);
        Finestra.add(Bottone3);
        Bottone4.addActionListener(listener);
        Finestra.add(Bottone4);
        Bottone5.addActionListener(listener);
        Finestra.add(Bottone5);
        Bottone6.addActionListener(listener);
        Finestra.add(Bottone6);
        Bottone7.addActionListener(listener);
        Finestra.add(Bottone7);
        Bottone8.addActionListener(listener);
        Finestra.add(Bottone8);
        Bottone9.addActionListener(listener);
        Finestra.add(Bottone9);


        Finestra.setSize(300,300);
        Finestra.setVisible(true);
        Finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public class Ascoltatore implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            event.getSource();
            Bottone1.setText("x");

        }
    }
}