package com.battaglia_navale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Interfaccia extends JFrame implements ActionListener {
    JLabel title = new JLabel("BATTAGLIA NAVALE");
    JPanel cg = new JPanel(); //Campo da gioco
    JPanel b = new JPanel();

    //------ Bottoni ------//
    JButton[][] bottoni = new JButton[10][10];
    JButton np = new JButton();
    JButton c = new JButton();

    //------ Label ------//
    JLabel[] lettere = new JLabel[11];
    JLabel[] numeri = new JLabel[10];

    Interfaccia()
    {
        super("Battaglia navale");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(title, BorderLayout.NORTH);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        //------------------- Campo da gioco ---------------//
        cg.setLayout(new GridLayout(11,11));
        add(cg, BorderLayout.CENTER);

        for(int i=0; i<11; i++)
        {
            //------------------- Lettere ---------------//
            if(i==0) {
                cg.add(new JLabel(""));
            }
            else {
                int lettera = i + 64;
                lettere[i] = new JLabel(Character.toString((char)lettera));
                lettere[i].setHorizontalAlignment(SwingConstants.CENTER);
                cg.add(lettere[i]);
            }
        }

        for(int i=0; i<10; i++)
        {
            //------------------- Numeri ---------------//
            numeri[i] = new JLabel(String.valueOf(i));
            numeri[i].setHorizontalAlignment(SwingConstants.CENTER);
            cg.add(numeri[i]);

            //------------------- Bottoni ---------------//
            for(int j=0; j<10; j++)
            {
                bottoni[i][j] = new JButton();
                bottoni[i][j].addActionListener(this);
                cg.add(bottoni[i][j]);
            }
        }

        //Pannello bottoni
        add(b, BorderLayout.SOUTH);
        b.setLayout(new FlowLayout());
        b.add(np);
        b.add(c);
        np.setText("Nuova partita");
        np.addActionListener(this);
        c.setText("Classifica");
        c.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }


}
