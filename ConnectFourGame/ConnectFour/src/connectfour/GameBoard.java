/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *  hücrelerin icinde ne oldugunu tutar
 * @author Tarık
 */
public class GameBoard {
    private final int[][] arr;
    private final int size;
    
    /**
     * arrayi initiliaze eder.Icini sifirla doldurur
     * @param s boyutu belirlemek icin parametre olarak size alir
     */
    public GameBoard(int s){
        size = s;
        arr = new int[size][size];
        
        for(int i = 0;i < size;i++){
            for(int j = 0; j < size;j++){
                arr[i][j] = 0;
            }
        }
    }
    
    /**
     *
     * @param x Satir
     * @param y Sutun
     */
    void setMavi(int x,int y){
        arr[x][y] = 1;
    }
    
    /**
     *
     * @param x Satir
     * @param y Sutun
     */
    void setSari(int x,int y){
        arr[x][y] = 2;
    }
        
    /**
     *
     * @param x Satir
     * @param y Sutun
     * @return
     */
    public int get(int x,int y){
        return arr[x][y];
    }
    
    


    /**
    *     Oyun Bitis Fonksiyonlari
    *    Sag ve sol tarafi kontrol eder
    * @return Bitmis ise 1,yoksa 0
    */
    int isFinishedMavi(){
        int status = 0;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i + 1, j) == 1 && isLegal(i + 2, j) == 1 && isLegal(i + 3, j) == 1) {
                    if (arr[i][j] == 1 && arr[i + 1][j] == 1 && arr[i + 2][j] == 1 && arr[i + 3][j] == 1) {
                        status = 1;
                    }
                }
                if (isLegal(i, j + 1) == 1 && isLegal(i, j + 2) == 1 && isLegal(i, j + 3) == 1) {
                    if (arr[i][j] == 1 && arr[i][j + 1] == 1 && arr[i][j + 2] == 1 && arr[i][j + 3] == 1) {
                        status = 1;
                    }
                }
            }
        }
        return  status;
    }
    


    /**
     *     Oyun Bitis Fonksiyonlari
     * Sag ve sol tarafi kontrol eder
     * @return Bitmis ise 1,yoksa 0
     **/
    int isFinishedSari(){
        int status = 0;
        for (int k = 0; k < size; ++k) {
            for (int l = 0; l < size; ++l) {
                if(isLegal(k+1,l) == 1 && isLegal(k+2,l) == 1 && isLegal(k+3,l) == 1) {
                    if (arr[k][l] == 2 && arr[k + 1][l] == 2 && arr[k + 2][l] == 2 && arr[k + 3][l] == 2) {
                        status = 2;
                    }
                }
                if(isLegal(k,l+1) == 1 && isLegal(k,l+2) == 1 && isLegal(k,l+3) == 1) {
                    if (arr[k][l] == 2 && arr[k][l + 1] == 2 && arr[k][l + 2] == 2 && arr[k][l + 3] == 2) {
                        status = 2;
                    }
                }
            }
        }
        return status;
    }
    

    /**
     * secilen yerin size in icinde olup olmamasini kontrol eder.
     * @param x Satir
     * @param y Sutun
     * @return
     */
    private  int isLegal(int x,int y){
        int status = 0;
        if(x >= 0 && y >= 0 && x < size && y < size)
            status = 1;

        return status;
    }
    
    
    


    /**
     *   Oyun Bitis Fonksiyonlari
     *   Capraz tarafi kontrol eder
     * @return Bitmis ise 1,yoksa 0
     **/
   int crossFinishedSari(){
        int status = 0;
        for (int k = 0; k < size; ++k) {
            for (int l = 0; l < size; ++l) {
                if(isLegal(k+1,l+1) == 1 && isLegal(k+2,l+2) == 1 && isLegal(k+3,l+3) == 1){
                    if(arr[k][l] == 2 && arr[k+1][l+1] == 2 && arr[k+2][l+2] == 2 && arr[k+3][l+3] == 2) {
                        status = 2;
                    }
                }
                if(isLegal(k-1,l+1) == 1 && isLegal(k-2,l+2) == 1 && isLegal(k-3,l+3) == 1){
                    if(arr[k][l] == 2 && arr[k-1][l+1] == 2 && arr[k-2][l+2] == 2 && arr[k-3][l+3] == 2) {
                        status = 2;
                    }
                }
                if(isLegal(k+1,l-1) == 1 && isLegal(k+2,l-2) == 1 && isLegal(k+3,l-3) == 1){
                    if(arr[k][l] == 2 && arr[k+1][l-1] == 2 && arr[k+2][l-2] == 2 && arr[k+3][l-3] == 2) {
                        status = 2;
                    }
                }
                if(isLegal(k-1,l-1) == 1 && isLegal(k-2,l-2) == 1 && isLegal(k-3,l-3) == 1) {
                    if (arr[k][l] == 2 && arr[k - 1][l - 1] == 2 && arr[k - 2][l - 2] == 2 &&
                        arr[k - 3][l - 3] == 2) {
                        status = 2;
                    }
                }
            }
        }
        return status;
    }

    /**
     *   Oyun Bitis Fonksiyonlari
     *   Capraz tarafi kontrol eder
     * @return Bitmis ise 1,yoksa 0
     **/
    int crossFinishedMavi(){
        int status = 0;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if(isLegal(i+1,j+1) == 1 && isLegal(i+2,j+2) == 1 && isLegal(i+3,j+3) == 1){
                    if(arr[i][j] == 1 && arr[i+1][j+1] == 1 && arr[i+2][j+2] == 1 && arr[i+3][j+3] == 1) {
                        status = 1;
                    }
                }
                if(isLegal(i-1,j+1) == 1 && isLegal(i-2,j+2) == 1 && isLegal(i-3,j+3) == 1){
                     if(arr[i][j] == 1 && arr[i-1][j+1] == 1 && arr[i-2][j+2] == 1 && arr[i-3][j+3] == 1) {
                         status = 1;
                     }
                }
                if(isLegal(i+1,j-1) == 1 && isLegal(i+2,j-2) == 1 && isLegal(i+3,j-3) == 1){
                     if(arr[i][j] == 1 && arr[i+1][j-1] == 1 && arr[i+2][j-2] == 1 && arr[i+3][j-3] == 1) {
                         status = 1;
                     }
                }
                if(isLegal(i-1,j-1) == 1 && isLegal(i-2,j-2) == 1 && isLegal(i-3,j-3) == 1) {
                    if (arr[i][j] == 1 && arr[i - 1][j - 1] == 1 && arr[i - 2][j - 2] == 1 &&
                        arr[i - 3][j - 3] == 1) {
                        status = 1;
                    }
                }
            }
        }


        return status;
    }
    

 

    /**
     * Beraberligi kontrol eder
     * @return Bitmis ise 1,yoksa 0
     */
    int isFilled(){
    int status = 1;
    for (int i = 0; i < size; ++i) {
        for (int j = 0; j < size; ++j) {
            if(arr[i][j] == 0)
                status = 0;
        }
    }
    return status;
    }
    
        //Yapay Zeka Komutlari
        //Mantik olarak 3 mavi varsa maviyi kapatir,3 sari varsa tamamlar vs vs.

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
        private boolean computer3Right(JLabel[][] a){
            boolean status = false;
            for (int i = 0; i < size; ++i) {
                for (int j = 0; j < size; ++j) {
                    if (isLegal(i, j+1) == 1 && isLegal(i , j+2) == 1 && isLegal(i, j+3) == 1) {
                        if (arr[i][j] == 1 && arr[i][j + 1] == 1 && arr[i][j + 2] == 1 && arr[i][j+3] == 0) {
                            if((isLegal(i+1,j+3)) == 0 || arr[i+1][j + 3] != 0) {
                                if(!status) {
                                    arr[i][j + 3] = 2;
                                    a[i][j+3].setIcon(new ImageIcon(this.getClass().getResource("Sari.png")));
                                    status = true;
                                }
                            }
                        }
                    }
                }
            }
            return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer3RightO(JLabel[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j+1) == 1 && isLegal(i , j+2) == 1 && isLegal(i, j+3) == 1) {
                    if (arr[i][j] == 2 && arr[i][j + 1] == 2 && arr[i][j + 2] == 2 && arr[i][j+3] == 0) {
                        if(isLegal(i+1,j+3) == 0 || arr[i+1][j + 3] != 0) {
                            if(!status) {
                                arr[i][j + 3] = 2;
                                a[i][j+3].setIcon(new ImageIcon(this.getClass().getResource("Sari.png")));
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer3Left(JLabel[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j-1) == 1 && isLegal(i , j-2) == 1 && isLegal(i, j-3) == 1) {
                    if (arr[i][j] == 1 && arr[i][j - 1] == 1 && arr[i][j - 2] == 1 && arr[i][j-3] == 0) {
                        if(isLegal(i+1,j-3) == 0 || arr[i+1][j - 3] != 0) {
                            if(!status) {
                                arr[i][j - 3] = 2;
                                a[i][j-3].setIcon(new ImageIcon(this.getClass().getResource("Sari.png")));
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer3LeftO(JLabel[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j-1) == 1 && isLegal(i , j-2) == 1 && isLegal(i, j-3) == 1) {
                    if (arr[i][j] == 2 && arr[i][j - 1] == 2 && arr[i][j - 2] == 2 && arr[i][j-3] == 0) {
                        if(isLegal(i+1,j-3) == 0 || arr[i+1][j - 3] != 0) {
                            if(!status) {
                                arr[i][j - 3] = 2;
                                a[i][j-3].setIcon(new ImageIcon(this.getClass().getResource("Sari.png")));
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer2Left(JLabel[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j-1) == 1 && isLegal(i , j-2) == 1) {
                    if (arr[i][j] == 1 && arr[i][j - 1] == 1 && arr[i][j - 2] == 0) {
                        if(isLegal(i+1,j-2) == 0 || arr[i+1][j - 2] != 0) {
                            if(!status) {
                                arr[i][j - 2] = 2;
                                a[i][j-2].setIcon(new ImageIcon(this.getClass().getResource("Sari.png")));
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer2LeftO(JLabel[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j-1) == 1 && isLegal(i , j-2) == 1) {
                    if (arr[i][j] == 2 && arr[i][j - 1] == 2 && arr[i][j - 2] == 0) {
                        if(isLegal(i+1,j-2) == 0 || arr[i+1][j - 2] != 0) {
                            if(!status) {
                                arr[i][j - 2] = 2;
                                a[i][j-2].setIcon(new ImageIcon(this.getClass().getResource("Sari.png")));
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer2Right(JLabel[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j+1) == 1 && isLegal(i , j+2) == 1) {
                    if (arr[i][j] == 1 && arr[i][j + 1] == 1 && arr[i][j + 2] == 0) {
                        if(isLegal(i+1,j+2) == 0 || arr[i+1][j + 2] != 0) {
                            if(!status) {
                                arr[i][j + 2] = 2;
                                a[i][j+2].setIcon(new ImageIcon(this.getClass().getResource("Sari.png")));
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer2RightO(JLabel[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j+1) == 1 && isLegal(i , j+2) == 1) {
                    if (arr[i][j] == 2 && arr[i][j + 1] == 2 && arr[i][j + 2] == 0) {
                        if(isLegal(i+1,j+2) == 0 || arr[i+1][j + 2] != 0) {
                            if(!status) {
                                arr[i][j + 2] = 2;
                                a[i][j+2].setIcon(new ImageIcon(this.getClass().getResource("Sari.png")));
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer3Up(JLabel[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i - 1, j) == 1 && isLegal(i-2 , j) == 1 && isLegal(i-3, j) == 1) {
                    if (arr[i][j] == 1 && arr[i-1][j] == 1 && arr[i-2][j] == 1 && arr[i-3][j] == 0) {
                        if(arr[i-3][j] == 0) {
                            if(!status) {
                                arr[i - 3][j] = 2;
                                a[i-3][j].setIcon(new ImageIcon(this.getClass().getResource("Sari.png")));
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer3UpO(JLabel[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i - 1, j) == 1 && isLegal(i-2 , j) == 1 && isLegal(i-3, j) == 1) {
                    if (arr[i][j] == 2 && arr[i-1][j] == 2 && arr[i-2][j] == 2 && arr[i-3][j] == 0) {
                        if(arr[i-3][j] == 0) {
                            if(!status) {
                                arr[i - 3][j] = 2;
                                a[i-3][j].setIcon(new ImageIcon(this.getClass().getResource("Sari.png")));
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer2Up(JLabel[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i - 1, j) == 1 && isLegal(i-2 , j) == 1) {
                    if (arr[i][j] == 1 && arr[i-1][j] == 1 &&  arr[i-2][j] == 0) {
                        if(arr[i-2][j] == 0) {
                            if(!status) {
                                arr[i - 2][j] = 2;
                                a[i-2][j].setIcon(new ImageIcon(this.getClass().getResource("Sari.png")));
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer2UpO(JLabel[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i - 1, j) == 1 && isLegal(i-2 , j) == 1) {
                    if (arr[i][j] == 2 && arr[i-1][j] == 2 &&  arr[i-2][j] == 0) {
                        if(arr[i-2][j] == 0) {
                            if(!status) {
                                arr[i - 2][j] = 2;
                                a[i - 2][j].setIcon(new ImageIcon(this.getClass().getResource("Sari.png")));
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computerUp(JLabel[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i - 1, j) == 1 && isLegal(i-2 , j) == 1) {
                    if (arr[i][j] == 1 &&  arr[i-1][j] == 0) {
                        if(arr[i-1][j] == 0) {
                            if(!status) {
                                arr[i - 1][j] = 2;
                                a[i - 1][j].setIcon(new ImageIcon(this.getClass().getResource("Sari.png")));
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computerUpO(JLabel[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i - 1, j) == 1 && isLegal(i-2 , j) == 1) {
                    if (arr[i][j] == 2 &&  arr[i-1][j] == 0) {
                        if(arr[i-1][j] == 0) {
                            if(!status) {
                                arr[i - 1][j] = 2;
                                a[i-1][j].setIcon(new ImageIcon(this.getClass().getResource("Sari.png")));
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computerRight(JLabel[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j+1) == 1 && isLegal(i , j+2) == 1) {
                    if (arr[i][j] == 1 && arr[i][j + 1] == 0) {
                        if(isLegal(i+1,j+1) == 0 || arr[i+1][j + 1] != 0) {
                            if(!status) {
                                arr[i][j + 1] = 2;
                                a[i][j+1].setIcon(new ImageIcon(this.getClass().getResource("Sari.png")));
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computerRightO(JLabel[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j+1) == 1 && isLegal(i , j+2) == 1) {
                    if (arr[i][j] == 2 && arr[i][j + 1] == 0) {
                        if(isLegal(i+1,j+1) == 0 || arr[i+1][j + 1] != 0) {
                            if(!status) {
                                arr[i][j + 1] = 2;
                                a[i][j+1].setIcon(new ImageIcon(this.getClass().getResource("Sari.png")));
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computerLeft(JLabel[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j-1) == 1 && isLegal(i , j-2) == 1) {
                    if (arr[i][j] == 1 &&  arr[i][j - 1] == 0) {
                        if(isLegal(i+1,j-1) == 0 || arr[i+1][j - 1] != 0) {
                            if(!status) {
                                arr[i][j - 1] = 2;
                                a[i][j-1].setIcon(new ImageIcon(this.getClass().getResource("Sari.png")));
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computerLeftO(JLabel[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j-1) == 1 && isLegal(i , j-2) == 1) {
                    if (arr[i][j] == 2 &&  arr[i][j - 1] == 0) {
                        if(isLegal(i+1,j-1) == 0 || arr[i+1][j - 1] != 0) {
                            if(!status) {
                                arr[i][j - 1] = 2;
                                a[i][j-1].setIcon(new ImageIcon(this.getClass().getResource("Sari.png")));
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computerMid(JLabel[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j+1) == 1 && isLegal(i , j-1) == 1) {
                    if (arr[i][j-1] == 1  && arr[i][j + 1] == 1 && arr[i][j] == 0) {
                        if(isLegal(i+1,j) == 0 || arr[i+1][j] != 0) {
                            if(!status) {
                                arr[i][j] = 2;
                                a[i][j].setIcon(new ImageIcon(this.getClass().getResource("Sari.png")));
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    //Yapay zekanin hangi mantiga göre calisacagini belirler. 

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return 
     */
    int computerAI(JLabel[][] a){
        if(computer3RightO(a)){
            return 0;
        }
        else if(computer3LeftO(a)){
            return 0;
        }
        else if(computer3UpO(a)){
            return 0;
        }
        else if(computer3Up(a)){
            return 0;
        }
        else if(computer3Left(a)){
            return 0;
        }
        else if(computer3Right(a)){
            return 0;
        }
        else if(computerMid(a)){
            return 0;
        }
        else if(computer2RightO(a)){           
            return 0;
        }
        else if(computer2UpO(a)){
            return 0;
        }
        else if(computer2LeftO(a)){          
            return 0;
        }
        else if(computer2Up(a)){        
            return 0;
        }
        else if(computer2Left(a)){
            return 0;
        }
        else if(computer2Right(a)){
            return 0;
        }
        else if(computerUpO(a)){
            return 0;
        }
        else if(computerRightO(a)){          
            return 0;
        }
        else if(computerLeftO(a)){          
            return 0;
        }
        else if(computerUp(a)){           
            return 0;
        }
        else if(computerRight(a)){
            return 0;
        }
        else if(computerLeft(a)){
            return 0;
        }

        return 0;
    }

    
}
