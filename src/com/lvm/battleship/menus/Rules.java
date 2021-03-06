package com.lvm.battleship.menus;

import javax.swing.*;

import com.lvm.battleship.Battleship;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class Rules extends JPanel implements ActionListener{
    //Containers and components
    private JPanel buttonPanel;
    private JButton returnButton = new JButton("RETURN");
    private JButton exitButton = new JButton("EXIT");
    Font font;
    
    public Rules(){       
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        
        //Set up bottom button panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.setBackground(Color.BLACK);
        
         //Read from font file
        try{
            //File path may need changing
            InputStream is = new BufferedInputStream(new FileInputStream("res/RobotoMono-Medium.ttf"));
            font = Font.createFont(Font.TRUETYPE_FONT, is);
            
            addComponents();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }catch(IOException e){
            System.out.println("Input/Output error");
        }catch(FontFormatException e){
            System.out.println("Font format exception");
        }
    }
    
    private void addComponents(){
        addTitle();        
        addRulesText();  
        font = font.deriveFont(30f);
        addReturnButton();
        addExitButton();        
        add(buttonPanel,BorderLayout.SOUTH); 
    }
    
    private void addTitle(){
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBackground(Color.BLACK);
        font = font.deriveFont(40f);        
        
        JLabel titleLabel = new JLabel("RULES");
        titleLabel.setFont(font);
        titleLabel.setForeground(Color.RED);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        titlePanel.add(titleLabel,BorderLayout.CENTER);
        add(titlePanel,BorderLayout.NORTH);
    }
    
    private void addRulesText(){
        Box list = Box.createVerticalBox(); 
        String strLine;
        BufferedReader in;
        
        try{
            //File path may need changing
            in = new BufferedReader(new FileReader("res/Rules.txt"));            
            font = font.deriveFont(35f);        
            JLabel[] rulesLabel = new JLabel[19];
            int lineCount = 0;
            
            while((strLine = in.readLine()) != null){
                rulesLabel[lineCount] = new JLabel();
                rulesLabel[lineCount].setFont(font);
                rulesLabel[lineCount].setForeground(Color.RED);
                rulesLabel[lineCount].setText(strLine);
                list.add(rulesLabel[lineCount]);
                
                lineCount++;
            }
            in.close();
        }catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }catch(IOException e){
            System.out.println("error");
        }          
        
        add(list,BorderLayout.LINE_START);
    }
    
    private void addReturnButton(){
        returnButton.addActionListener(this);
        returnButton.setPreferredSize(new Dimension(200,75));
        returnButton.setFont(font);
        returnButton.setBackground(Color.BLACK);
        returnButton.setBorder(BorderFactory.createLineBorder(Color.RED));
        returnButton.setForeground(Color.RED);
        
        buttonPanel.add(returnButton,BorderLayout.LINE_END);
    }
    
    private void addExitButton(){
        exitButton.addActionListener(this);
        exitButton.setPreferredSize(new Dimension(200,75));
        exitButton.setFont(font);
        exitButton.setBackground(Color.BLACK);
        exitButton.setBorder(BorderFactory.createLineBorder(Color.RED));
        exitButton.setForeground(Color.RED);
        exitButton.setFocusPainted(false);
        
        buttonPanel.add(exitButton,BorderLayout.LINE_START);
    }
    
    /**
     *
     * @param e
     * @throws FileNotFoundException
     * @throws IOException
     * @throws FontFormatException
     */
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == returnButton){
            //Set current panel to not visible
            //Set start menu panel to visible
            
            setVisible(false);
            Battleship.startMenuPanel.setVisible(true);
        }else if(e.getSource() == exitButton){
            System.exit(0);
        }
    }
}
