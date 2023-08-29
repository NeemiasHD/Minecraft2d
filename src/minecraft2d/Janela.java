package minecraft2d;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Janela extends JFrame implements KeyListener {

    private final int size = 400;
    private final int cols = 20;
    private final int rows = 20;

    private final String steve = "./src/img/steve.png";
    private final String madeira = "./src/img/madeira.png";
    private final String terra = "./src/img/terra.jpg";
    private final String ceu = "./src/img/ceu.png";
    private final String flor = "./src/img/flor.png";
    private final String folha = "./src/img/folha.png";
    private final String cobblestone = "./src/img/cobblestone.png";
    private final String nuvem = "./src/img/nuvem.png";

    private MyPanel myPanel[];

    private int[] tipoblocos;

    private ImageIcon STEVE;
    private ImageIcon FLOR;
    private ImageIcon CEU;
    private ImageIcon TERRA;
    private ImageIcon MADEIRA;
    private ImageIcon FOLHA;
    private ImageIcon COBBLESTONE;
    private ImageIcon NUVEM;

    private int posicaoSTEVE;

    public Janela() {

        this.setLayout(new GridLayout(rows, cols));

        STEVE = new ImageIcon(steve);
        CEU = new ImageIcon(ceu);
        FLOR = new ImageIcon(flor);
        TERRA = new ImageIcon(terra);
        MADEIRA = new ImageIcon(madeira);
        FOLHA = new ImageIcon(folha);
        COBBLESTONE = new ImageIcon(cobblestone);
        NUVEM = new ImageIcon(nuvem);

        tipoblocos = new int[size];

        myPanel = new MyPanel[size];

        for (int i = 0; i < size; i++) {
            if (i == 103 || i == 104 || i == 105 || i == 106 || i == 107 || i == 84 || i == 85 || i == 91 || i == 92
                    || i == 93 || i == 94 || i == 95 || i == 96 || i == 48 || i == 54 || i == 73 || i == 74 || i == 75
                    || i == 117 || i == 118) {
                myPanel[i] = new MyPanel(NUVEM);
                this.add(myPanel[i]);
            } else {
                myPanel[i] = new MyPanel(CEU);
                this.add(myPanel[i]);
            }

        }

        posicaoSTEVE = 210;
        myPanel[210].setIcon(STEVE);

        this.addKeyListener(this);

        this.setTitle("Minecraft 2D");
        this.setSize(800, 800);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

    }

    private ImageIcon getIcon(int tipo) {
        switch (tipoblocos[tipo]) {
            case 1:
                return FLOR;
            case 2:
                return FOLHA;
            case 3:
                return TERRA;
            case 4:
                return MADEIRA;

            case 5:
                return COBBLESTONE;
            case 6:
                return NUVEM;

            default:
                return CEU;
        }
    }

    @Override
    public void keyPressed(KeyEvent key) {

        // movimentações
        if (key.getKeyCode() == KeyEvent.VK_RIGHT) {
            myPanel[posicaoSTEVE].setIcon(getIcon(posicaoSTEVE));
            posicaoSTEVE++;
            if (posicaoSTEVE > size - 1)
                posicaoSTEVE = 0;
            myPanel[posicaoSTEVE].setIcon(STEVE);
        }

        if (key.getKeyCode() == KeyEvent.VK_LEFT) {
            myPanel[posicaoSTEVE].setIcon(getIcon(posicaoSTEVE));
            posicaoSTEVE--;
            if (posicaoSTEVE < 0)
                posicaoSTEVE = size - 1;
            myPanel[posicaoSTEVE].setIcon(STEVE);
        }

        if (key.getKeyCode() == KeyEvent.VK_DOWN) {
            myPanel[posicaoSTEVE].setIcon(getIcon(posicaoSTEVE));
            posicaoSTEVE += 20;
            if (posicaoSTEVE > 399)
                posicaoSTEVE = posicaoSTEVE - 399;
            myPanel[posicaoSTEVE].setIcon(STEVE);
        }

        if (key.getKeyCode() == KeyEvent.VK_UP) {
            myPanel[posicaoSTEVE].setIcon(getIcon(posicaoSTEVE));
            posicaoSTEVE -= 20;
            if (posicaoSTEVE < 0)
                posicaoSTEVE = 399 - (Math.abs(posicaoSTEVE));
            myPanel[posicaoSTEVE].setIcon(STEVE);
        }

        // construções
        if (key.getKeyCode() == KeyEvent.VK_1) {
            myPanel[posicaoSTEVE].setIcon(FLOR);
            tipoblocos[posicaoSTEVE] = 1;
            key.setKeyCode(KeyEvent.VK_RIGHT);
            keyPressed(key);
        }

        if (key.getKeyCode() == KeyEvent.VK_2) {
            myPanel[posicaoSTEVE].setIcon(FOLHA);
            tipoblocos[posicaoSTEVE] = 2;
            key.setKeyCode(KeyEvent.VK_UP);
            keyPressed(key);
        }

        if (key.getKeyCode() == KeyEvent.VK_3) {
            myPanel[posicaoSTEVE].setIcon(TERRA);
            tipoblocos[posicaoSTEVE] = 3;
            key.setKeyCode(KeyEvent.VK_RIGHT);
            keyPressed(key);
        }

        if (key.getKeyCode() == KeyEvent.VK_4) {
            myPanel[posicaoSTEVE].setIcon(MADEIRA);
            tipoblocos[posicaoSTEVE] = 4;
            key.setKeyCode(KeyEvent.VK_UP);
            keyPressed(key);
        }
        if (key.getKeyCode() == KeyEvent.VK_5) {
            myPanel[posicaoSTEVE].setIcon(COBBLESTONE);
            tipoblocos[posicaoSTEVE] = 5;
            key.setKeyCode(KeyEvent.VK_UP);
            keyPressed(key);
        }
        if (key.getKeyCode() == KeyEvent.VK_6) {
            JOptionPane.showMessageDialog(null, posicaoSTEVE);
            myPanel[posicaoSTEVE].setIcon(NUVEM);
            tipoblocos[posicaoSTEVE] = 6;
            key.setKeyCode(KeyEvent.VK_UP);
            keyPressed(key);
        }

        if (key.getKeyCode() == KeyEvent.VK_SPACE) {
            myPanel[posicaoSTEVE].setIcon(CEU);
            tipoblocos[posicaoSTEVE] = 0;
            key.setKeyCode(KeyEvent.VK_UP);
            keyPressed(key);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}