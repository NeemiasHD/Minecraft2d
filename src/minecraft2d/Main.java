
package minecraft2d;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {
      Janela janela = new Janela();
      ImageIcon icon = new ImageIcon("./src/img/icone.png");
        UIManager.put("OptionPane.okButtonText", "COMEÇAR");

        int menu = JOptionPane.showConfirmDialog(null, "BEM VINDO AO MINECRAFT!\nuse setinhas pra se movimentar.\n\nCOMANDOS:\n\n( 1 ) - FLOR\n( 2 ) - FOLHA\n( 3 ) - TERRA\n( 4 ) - MADEIRA\n( 5 ) - COBBLESTONE\n\n( ESPAÇO ) - DESTRUIR\n\n\n", // primeira tela
                "Minecraft", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, icon);

    }
}