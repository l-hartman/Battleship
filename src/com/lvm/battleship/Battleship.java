package com.lvm.battleship;

import javax.swing.*;

import com.lvm.battleship.menus.Rules;
import com.lvm.battleship.menus.StartMenu;
import com.lvm.battleship.players.NamePrompt;
import com.lvm.battleship.players.Player;

import java.awt.*;
import java.io.*;

public class Battleship {
    //Global frame
    public static JFrame frame;
    //Global panels 
    public static JPanel startMenuPanel;
    public static JPanel rulesPanel;
    public static JPanel namePromptPanel;
    
    /**
	 * main is the entry point for the program
	 * 
	 * @param args
	 * @throws FileNotFoundException, IOException, FontFormatException
	 */
    public static void main(String[] args)
    throws FileNotFoundException, IOException, FontFormatException{   
        //Set up global frame
        frame = new JFrame();
        frame.setTitle("BattleShip");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        
        //Set up global panels
        startMenuPanel = new StartMenu();
        rulesPanel = new Rules();
        namePromptPanel = new NamePrompt();
        
        //Add start menu to the global frame
        frame.add(startMenuPanel);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void initGame(Game game) {
		frame.setResizable(false);
		frame.setTitle("Battleship");
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		// TODO test name functionality
		System.out.println(Player.player1.getName());
		System.out.println(Player.player2.getName());
		
		game.start();
    }
}
