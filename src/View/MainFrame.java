/*Elisabeth Nyström, ai8798, Medieproduktion och processdesign*/

package View;

import Controller.Controller;
import javax.swing.*;
import java.awt.*;

public class MainFrame {

    private JFrame frame;
    private MainPanel panel;

    private int width = 800;
    private int height = 400;

    public MainFrame(Controller controller){
        frame = new JFrame("P I Z Z E R I A");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocation(200, 200);
        panel = new MainPanel(controller, width, height);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    //Berättar vilket objekt som är valt
    public int getListIndex() {
        return panel.getListIndex();
    }

    public void addOrder(String orderItem, int amount) {
        panel.addOrder(orderItem, amount);
    }

    public int getTxtField(){
        return panel.getTxtField();
    }

    public void printReceipt(String[] receipt){
        JPanel textPanel = new JPanel(new GridLayout(15, 1));
        textPanel.setBackground(Color.pink);
        for (int i = 0; i < receipt.length; i++) {
            textPanel.add(new JLabel(receipt[i]));
        }
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(textPanel);
        JOptionPane.showMessageDialog(null, panel2, "R E C E I P T",JOptionPane.DEFAULT_OPTION);
    }

    public void updateView(){
        panel.updateView();
    }
}
