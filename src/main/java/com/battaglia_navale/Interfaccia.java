package com.battaglia_navale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Interfaccia extends JFrame implements ActionListener {
    JLabel title = new JLabel("BATTAGLIA NAVALE");
    JPanel cg = new JPanel(); //Campo da gioco
    JPanel b = new JPanel();

    Interfaccia()
    {
        super("Battaglia navale");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(title, BorderLayout.NORTH);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(cg, BorderLayout.CENTER);
        add(b, BorderLayout.SOUTH);

        //------------------- Campo da gioco ---------------//
        cg.setLayout(new GridLayout(11,11));

        JLabel v = new JLabel("");

        //Riga lettere
        JLabel lA = new JLabel("A");
        lA.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel lB = new JLabel("B");
        lB.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel lC = new JLabel("C");
        lC.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel lD = new JLabel("D");
        lD.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel lE = new JLabel("E");
        lE.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel lF = new JLabel("F");
        lF.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel lG = new JLabel("G");
        lG.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel lH = new JLabel("H");
        lH.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel lI = new JLabel("I");
        lI.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel lJ = new JLabel("J");
        lJ.setHorizontalAlignment(SwingConstants.CENTER);

        //Colonna numeri
        JLabel l1 = new JLabel("1");
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel l2 = new JLabel("2");
        l2.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel l3 = new JLabel("3");
        l3.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel l4 = new JLabel("4");
        l4.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel l5 = new JLabel("5");
        l5.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel l6 = new JLabel("6");
        l6.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel l7 = new JLabel("7");
        l7.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel l8 = new JLabel("8");
        l8.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel l9 = new JLabel("9");
        l9.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel l10 = new JLabel("10");
        l10.setHorizontalAlignment(SwingConstants.CENTER);

        //Bottoni gioco
        //Colonna A
        JButton A1 = new JButton();
        A1.addActionListener(this);
        JButton A2 = new JButton();
        A2.addActionListener(this);
        JButton A3 = new JButton();
        A3.addActionListener(this);
        JButton A4 = new JButton();
        A4.addActionListener(this);
        JButton A5 = new JButton();
        A5.addActionListener(this);
        JButton A6 = new JButton();
        A6.addActionListener(this);
        JButton A7 = new JButton();
        A7.addActionListener(this);
        JButton A8 = new JButton();
        A8.addActionListener(this);
        JButton A9 = new JButton();
        A9.addActionListener(this);
        JButton A10 = new JButton();
        A10.addActionListener(this);

        //Colonna B
        JButton B1 = new JButton();
        JButton B2 = new JButton();
        JButton B3 = new JButton();
        JButton B4 = new JButton();
        JButton B5 = new JButton();
        JButton B6 = new JButton();
        JButton B7 = new JButton();
        JButton B8 = new JButton();
        JButton B9 = new JButton();
        JButton B10 = new JButton();

        //Colonna C
        JButton C1 = new JButton();
        JButton C2 = new JButton();
        JButton C3 = new JButton();
        JButton C4 = new JButton();
        JButton C5 = new JButton();
        JButton C6 = new JButton();
        JButton C7 = new JButton();
        JButton C8 = new JButton();
        JButton C9 = new JButton();
        JButton C10 = new JButton();

        //Colonna D
        JButton D1 = new JButton();
        JButton D2 = new JButton();
        JButton D3 = new JButton();
        JButton D4 = new JButton();
        JButton D5 = new JButton();
        JButton D6 = new JButton();
        JButton D7 = new JButton();
        JButton D8 = new JButton();
        JButton D9 = new JButton();
        JButton D10 = new JButton();

        //Colonna E
        JButton E1 = new JButton();
        JButton E2 = new JButton();
        JButton E3 = new JButton();
        JButton E4 = new JButton();
        JButton E5 = new JButton();
        JButton E6 = new JButton();
        JButton E7 = new JButton();
        JButton E8 = new JButton();
        JButton E9 = new JButton();
        JButton E10 = new JButton();

        //Colonna F
        JButton F1 = new JButton();
        JButton F2 = new JButton();
        JButton F3 = new JButton();
        JButton F4 = new JButton();
        JButton F5 = new JButton();
        JButton F6 = new JButton();
        JButton F7 = new JButton();
        JButton F8 = new JButton();
        JButton F9 = new JButton();
        JButton F10 = new JButton();

        //Colonna G
        JButton G1 = new JButton();
        JButton G2 = new JButton();
        JButton G3 = new JButton();
        JButton G4 = new JButton();
        JButton G5 = new JButton();
        JButton G6 = new JButton();
        JButton G7 = new JButton();
        JButton G8 = new JButton();
        JButton G9 = new JButton();
        JButton G10 = new JButton();

        //Colonna H
        JButton H1 = new JButton();
        JButton H2 = new JButton();
        JButton H3 = new JButton();
        JButton H4 = new JButton();
        JButton H5 = new JButton();
        JButton H6 = new JButton();
        JButton H7 = new JButton();
        JButton H8 = new JButton();
        JButton H9 = new JButton();
        JButton H10 = new JButton();

        //Colonna I
        JButton I1 = new JButton();
        JButton I2 = new JButton();
        JButton I3 = new JButton();
        JButton I4 = new JButton();
        JButton I5 = new JButton();
        JButton I6 = new JButton();
        JButton I7 = new JButton();
        JButton I8 = new JButton();
        JButton I9 = new JButton();
        JButton I10 = new JButton();

        //Colonna J
        JButton J1 = new JButton();
        JButton J2 = new JButton();
        JButton J3 = new JButton();
        JButton J4 = new JButton();
        JButton J5 = new JButton();
        JButton J6 = new JButton();
        JButton J7 = new JButton();
        JButton J8 = new JButton();
        JButton J9 = new JButton();
        JButton J10 = new JButton();

        //Riga lettere
        cg.add(v);
        cg.add(lA);
        cg.add(lB);
        cg.add(lC);
        cg.add(lD);
        cg.add(lE);
        cg.add(lF);
        cg.add(lG);
        cg.add(lH);
        cg.add(lI);
        cg.add(lJ);

        //Riga 1
        cg.add(l1);
        cg.add(A1);
        cg.add(B1);
        cg.add(C1);
        cg.add(D1);
        cg.add(E1);
        cg.add(F1);
        cg.add(G1);
        cg.add(H1);
        cg.add(I1);
        cg.add(J1);

        //Riga 2
        cg.add(l2);
        cg.add(A2);
        cg.add(B2);
        cg.add(C2);
        cg.add(D2);
        cg.add(E2);
        cg.add(F2);
        cg.add(G2);
        cg.add(H2);
        cg.add(I2);
        cg.add(J2);

        //Riga 3
        cg.add(l3);
        cg.add(A3);
        cg.add(B3);
        cg.add(C3);
        cg.add(D3);
        cg.add(E3);
        cg.add(F3);
        cg.add(G3);
        cg.add(H3);
        cg.add(I3);
        cg.add(J3);

        //Riga 4
        cg.add(l4);
        cg.add(A4);
        cg.add(B4);
        cg.add(C4);
        cg.add(D4);
        cg.add(E4);
        cg.add(F4);
        cg.add(G4);
        cg.add(H4);
        cg.add(I4);
        cg.add(J4);

        //Riga 5
        cg.add(l5);
        cg.add(A5);
        cg.add(B5);
        cg.add(C5);
        cg.add(D5);
        cg.add(E5);
        cg.add(F5);
        cg.add(G5);
        cg.add(H5);
        cg.add(I5);
        cg.add(J5);

        //Riga 6
        cg.add(l6);
        cg.add(A6);
        cg.add(B6);
        cg.add(C6);
        cg.add(D6);
        cg.add(E6);
        cg.add(F6);
        cg.add(G6);
        cg.add(H6);
        cg.add(I6);
        cg.add(J6);

        //Riga 7
        cg.add(l7);
        cg.add(A7);
        cg.add(B7);
        cg.add(C7);
        cg.add(D7);
        cg.add(E7);
        cg.add(F7);
        cg.add(G7);
        cg.add(H7);
        cg.add(I7);
        cg.add(J7);

        //Riga 8
        cg.add(l8);
        cg.add(A8);
        cg.add(B8);
        cg.add(C8);
        cg.add(D8);
        cg.add(E8);
        cg.add(F8);
        cg.add(G8);
        cg.add(H8);
        cg.add(I8);
        cg.add(J8);

        //Riga 9
        cg.add(l9);
        cg.add(A9);
        cg.add(B9);
        cg.add(C9);
        cg.add(D9);
        cg.add(E9);
        cg.add(F9);
        cg.add(G9);
        cg.add(H9);
        cg.add(I9);
        cg.add(J9);

        //Riga 10
        cg.add(l10);
        cg.add(A10);
        cg.add(B10);
        cg.add(C10);
        cg.add(D10);
        cg.add(E10);
        cg.add(F10);
        cg.add(G10);
        cg.add(H10);
        cg.add(I10);
        cg.add(J10);


    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
