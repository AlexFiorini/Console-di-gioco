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
    JButton[][] bottoni = new JButton[][];

    //Colonna A
    JButton A1;
    JButton A2;
    JButton A3;
    JButton A4;
    JButton A5;
    JButton A6;
    JButton A7;
    JButton A8;
    JButton A9;
    JButton A10;

    //Colonna B
    JButton B1;
    JButton B2;
    JButton B3;
    JButton B4;
    JButton B5;
    JButton B6;
    JButton B7;
    JButton B8;
    JButton B9;
    JButton B10;

    //Colonna C
    JButton C1;
    JButton C2;
    JButton C3;
    JButton C4;
    JButton C5;
    JButton C6;
    JButton C7;
    JButton C8;
    JButton C9;
    JButton C10;

    //Colonna D
    JButton D1;
    JButton D2;
    JButton D3;
    JButton D4;
    JButton D5;
    JButton D6;
    JButton D7;
    JButton D8;
    JButton D9;
    JButton D10;

    //Colonna E
    JButton E1;
    JButton E2;
    JButton E3;
    JButton E4;
    JButton E5;
    JButton E6;
    JButton E7;
    JButton E8;
    JButton E9;
    JButton E10;

    //Colonna F
    JButton F1;
    JButton F2;
    JButton F3;
    JButton F4;
    JButton F5;
    JButton F6;
    JButton F7;
    JButton F8;
    JButton F9;
    JButton F10;

    //Colonna G
    JButton G1;
    JButton G2;
    JButton G3;
    JButton G4;
    JButton G5;
    JButton G6;
    JButton G7;
    JButton G8;
    JButton G9;
    JButton G10;

    //Colonna H
    JButton H1;
    JButton H2;
    JButton H3;
    JButton H4;
    JButton H5;
    JButton H6;
    JButton H7;
    JButton H8;
    JButton H9;
    JButton H10;

    //Colonna I
    JButton I1;
    JButton I2;
    JButton I3;
    JButton I4;
    JButton I5;
    JButton I6;
    JButton I7;
    JButton I8;
    JButton I9;
    JButton I10;

    //Colonna J
    JButton J1;
    JButton J2;
    JButton J3;
    JButton J4;
    JButton J5;
    JButton J6;
    JButton J7;
    JButton J8;
    JButton J9;
    JButton J10;
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

        //Aggiunta ascoltatori bottoni
        A1.addActionListener(this);
        A2.addActionListener(this);
        A3.addActionListener(this);
        A4.addActionListener(this);
        A5.addActionListener(this);
        A6.addActionListener(this);
        A7.addActionListener(this);
        A8.addActionListener(this);
        A9.addActionListener(this);
        A10.addActionListener(this);

        B1.addActionListener(this);
        B2.addActionListener(this);
        B3.addActionListener(this);
        B4.addActionListener(this);
        B5.addActionListener(this);
        B6.addActionListener(this);
        B7.addActionListener(this);
        B8.addActionListener(this);
        B9.addActionListener(this);
        B10.addActionListener(this);

        C1.addActionListener(this);
        C2.addActionListener(this);
        C3.addActionListener(this);
        C4.addActionListener(this);
        C5.addActionListener(this);
        C6.addActionListener(this);
        C7.addActionListener(this);
        C8.addActionListener(this);
        C9.addActionListener(this);
        C10.addActionListener(this);

        D1.addActionListener(this);
        D2.addActionListener(this);
        D3.addActionListener(this);
        D4.addActionListener(this);
        D5.addActionListener(this);
        D6.addActionListener(this);
        D7.addActionListener(this);
        D8.addActionListener(this);
        D9.addActionListener(this);
        D10.addActionListener(this);

        E1.addActionListener(this);
        E2.addActionListener(this);
        E3.addActionListener(this);
        E4.addActionListener(this);
        E5.addActionListener(this);
        E6.addActionListener(this);
        E7.addActionListener(this);
        E8.addActionListener(this);
        E9.addActionListener(this);
        E10.addActionListener(this);

        F1.addActionListener(this);
        F2.addActionListener(this);
        F3.addActionListener(this);
        F4.addActionListener(this);
        F5.addActionListener(this);
        F6.addActionListener(this);
        F7.addActionListener(this);
        F8.addActionListener(this);
        F9.addActionListener(this);
        F10.addActionListener(this);

        G1.addActionListener(this);
        G2.addActionListener(this);
        G3.addActionListener(this);
        G4.addActionListener(this);
        G5.addActionListener(this);
        G6.addActionListener(this);
        G7.addActionListener(this);
        G8.addActionListener(this);
        G9.addActionListener(this);
        G10.addActionListener(this);

        H1.addActionListener(this);
        H2.addActionListener(this);
        H3.addActionListener(this);
        H4.addActionListener(this);
        H5.addActionListener(this);
        H6.addActionListener(this);
        H7.addActionListener(this);
        H8.addActionListener(this);
        H9.addActionListener(this);
        H10.addActionListener(this);

        I1.addActionListener(this);
        I2.addActionListener(this);
        I3.addActionListener(this);
        I4.addActionListener(this);
        I5.addActionListener(this);
        I6.addActionListener(this);
        I7.addActionListener(this);
        I8.addActionListener(this);
        I9.addActionListener(this);
        I10.addActionListener(this);

        J1.addActionListener(this);
        J2.addActionListener(this);
        J3.addActionListener(this);
        J4.addActionListener(this);
        J5.addActionListener(this);
        J6.addActionListener(this);
        J7.addActionListener(this);
        J8.addActionListener(this);
        J9.addActionListener(this);
        J10.addActionListener(this);

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
