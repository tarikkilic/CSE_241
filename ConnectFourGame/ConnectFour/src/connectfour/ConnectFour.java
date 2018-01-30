/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.*;
import javax.swing.*;

/**
 * Tum oyun kodlarini icinde barindirir
 * @author Tarık
 */
public final class ConnectFour{
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private final JFrame frame; 
    private JLabel[][] grid;
    private int size;
    private int cSize; //sutunun genisligi
    private int playerTurn = 1;//siranin kimde oldugunu tutar.
    GameBoard board;// Arka planda verileri tutuyor.
    private char GameType;//pvp mi pvc mi oldugunu tutuyor. action performed kullandim.
    boolean sizeFlag = true; // size kontroly icin
    
        
    /**
    * Oyunu baslatmak icin mainde cagirilmasi yeterli
    **/
    public ConnectFour(){
        
        //Boyut icin girdi ve kontrol
        while(sizeFlag){
            String temp = JOptionPane.showInputDialog("Boyut Giriniz");
            if(temp == null)
                System.exit(1);
            size = Integer.parseInt(temp);
            if(size > 2)
                sizeFlag = false;
        }
        
        
        JFrame menu = new JFrame();
        menu.setLayout(new FlowLayout());
        
        //Dialogda yes ve no yerine kendi stringimi koydum
        String[] options = new String[2];
        options[0] = "Player";
        options[1] = "Computer";
        //yes no butonlarindan oyun tipini girdi aliyor
        int selected = JOptionPane.showOptionDialog(menu.getContentPane(),"Oyun türünü seciniz","Menu", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
        if(selected == JOptionPane.YES_OPTION){
           GameType = 'P';
        }
        else if(selected == JOptionPane.NO_OPTION){
           GameType = 'C';
        }
        else{
            System.exit(1); //ciktiginda zibilyon tane exception firlatmamasi icin.
        }
        
       cSize = WIDTH/size; // her bir hücrenin genisligi
       frame = new JFrame("ConnectFour");
       JPanel panel = (JPanel) frame.getContentPane();
       panel.setLayout(new GridLayout(size,size));
       board = new GameBoard(size);
       //Label İnitilaze
       grid = new JLabel[size][size];
       for(int i = 0; i < size;i++)
       {
           for(int j = 0; j < size;j++){
               grid[i][j] = new JLabel();
                grid[i][j].setHorizontalAlignment(SwingConstants.CENTER); 
                grid[i][j].setBackground(Color.WHITE);
                grid[i][j].setOpaque(true);
                grid[i][j].setBorder(new LineBorder(Color.black)); 
                panel.add(grid[i][j]);
           }
       }
       //Simge olarak Mavi ve Sari resimlerim var.
        ImageIcon mavi = new ImageIcon(this.getClass().getResource("Mavi.png"));
        ImageIcon sari = new ImageIcon(this.getClass().getResource("Sari.png"));
        frame.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                int x = e.getX();
                boolean status = true;
                for(int i = 0; i < size;i++){
                    if( x < cSize*(i+1) && x > cSize*i){  //kullanicinin hangi hücreye tikladigini algilar.
                        for(int j = 0; j < size ; j++){
                            if(board.get(size-j-1, i) == 0){
                                if(status){
                                    //Kullanici PvP yi secmis ise
                                    if(GameType == 'P'){
                                        if(playerTurn == 1){
                                            board.setMavi(size-j-1, i);
                                            grid[size-j-1][i].setIcon(mavi);
                                            status = false;
                                            playerTurn = 2;
                                        }
                                        else if(playerTurn == 2){
                                            board.setSari(size-j-1, i);
                                            grid[size-j-1][i].setIcon(sari);
                                            status = false;
                                            playerTurn = 1;
                                        }
                                    }
                                    //Kullanici Computer secmis ise
                                    if(GameType == 'C'){
                                        if(playerTurn == 1){
                                            board.setMavi(size-j-1, i);
                                            grid[size-j-1][i].setIcon(mavi);
                                            board.computerAI(grid);
                                            status = false;
                                            
                                        }
                                    }
                                    
                                }                             
                            }
                        }
                    }  
                }
                
                
                //Oyun bitis icin gerekli kontroller
                if(board.isFinishedMavi() == 1 || board.crossFinishedMavi() == 1){
                    JOptionPane.showMessageDialog(null,"Mavi Kazandi");
                    frame.setVisible(false);
                     new ConnectFour();
                }             
                else if(board.isFinishedSari() == 2 || board.crossFinishedSari() == 2){
                    JOptionPane.showMessageDialog(null,"Sari Kazandi");
                    frame.setVisible(false);
                    new ConnectFour();                  
                }
                else if(board.isFilled() == 1){
                    JOptionPane.showMessageDialog(null,"Berabere");
                    frame.setVisible(false);
                    new ConnectFour();
                }
            } 
        });
       //Frame Code
       frame.setContentPane(panel);
       frame.setSize(WIDTH,HEIGHT);
       frame.setResizable(false);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
       
    }
    
    public static void main(String args[]){
            new ConnectFour();      
    }   
}
