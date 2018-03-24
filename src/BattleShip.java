import javax.swing.*;
import java.awt.*;
import java.io.*;

public class BattleShip {
    public static void main(String[] args){
        JFrame f = new JFrame("Battleship");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setUndecorated(true);
        
        f.pack();
        f.setVisible(true);
    }
}
