/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mine.sweeper;


import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author Rhea Alvares & Hiro Miko Reyes
 */

public class GameControl { 

//this class controls all game logic and generation within the game itself.
//factors that are not directly related to gui output are coded within here.
//gui output is coded within the gui itself.
    
    //creating all necessary objects
    
    Random ranGen = new Random();
    
    //declaring all arrays and necessary variables for the game
    
    
    
    boolean gameIsWon;    //boolean that determines if the game has been won or not.
    boolean flagToggled; //boolean that determines if the flag toggle button is on or not.
    boolean gameIsStarted; // detects whether the game has started or not
    boolean[] selectedArray = new boolean[100]; // this array is used to detect whether a tile has been selected or not.
    boolean[] bombArray = new boolean[100]; //this array holds the values of the locations of the bombs.
    ArrayList<Integer> bombLocation = new ArrayList<>(); //used in the generation of new bombs
    boolean[] flagArray = new boolean[100]; // this array holds the value of the locations of the user placed flags.
    int[] tileValue = new int[100]; //this array holds the value that the tile will display when close to a bomb.
    

    
    void generate(){ //generates the bombs and numbers necessary to play the game
        
        
        //generates a number that hasn't been generated yet.

        while(bombLocation.size() < 100){
            
            int random = ranGen.nextInt(100);
            if(!bombLocation.contains(random)){
                bombLocation.add(random);
            } 
        }
        

        //ten of these random values are assigned to the bombArray
        
        for(int i = 0; i < 10; i++){
            bombArray[bombLocation.get(i)] = true; 
            System.out.println(bombLocation.get(i));
        }

       
        
        //the tiles surrounding the bombs are assigned a value
        
        //to avoid errors the way, the program treats the corners, edge pieces and center pieces are different.
        for(int i = 0; i <100; i++){
            
            if(bombArray[i]){
            
            if(i== 0) { //top left corner piece
                
                tileValue[i+1] = tileValue[i+1] + 1;
                tileValue[i+10] = tileValue[i+10] + 1;
                tileValue[i+11] = tileValue[i+11] + 1;
                
           
                
            }
            if(i== 90) { //bottom left corner piece
                
                tileValue[i+1] = tileValue[i+1] + 1;
                tileValue[i-10] = tileValue[i-10] + 1;
                tileValue[i-9] = tileValue[i-9] + 1;
               
            }
            if(i== 99) { //bottom right corner piece
                
                tileValue[i-1] = tileValue[i-1] + 1;
                tileValue[i-10] = tileValue[i-10] + 1;
                tileValue[i-11] = tileValue[i-11] + 1;
                
            }
            if( i== 9) { //top right corner piece
                
                tileValue[i-1] = tileValue[i-1] + 1;
                tileValue[i+9] = tileValue[i+9] + 1;
                tileValue[i+10] = tileValue[i+10] + 1;
                
            }
             //center pieces
            if(i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18 || 
                    i == 21 || i == 22 || i == 23 || i == 24 || i == 25 || i == 26 || i == 27 || i == 28 ||
                    i == 31 || i == 32 || i == 33 || i == 34 || i == 35 || i == 36 || i == 37 || i == 38 ||
                    i == 41 || i == 42 || i == 43 || i == 44 || i == 45 || i == 46 || i == 47 || i == 48 ||
                    i == 51 || i == 52 || i == 53 || i == 54 || i == 55 || i == 56 || i == 57 || i == 58 ||
                    i == 61 || i == 62 || i == 63 || i == 64 || i == 65 || i == 66 || i == 67 || i == 68 ||
                    i == 71 || i == 72 || i == 73 || i == 74 || i == 75 || i == 76 || i == 77 || i == 78 ||
                    i == 81 || i == 82 || i == 83 || i == 84 || i == 85 || i == 86 || i == 87 || i == 88){
                
                
                tileValue[i+1] = tileValue[i+1]+ 1;
                tileValue[i-1] = tileValue[i-1]+ 1;
                tileValue[i+10] = tileValue[i+10]+ 1;
                tileValue[i-10] = tileValue[i-10]+ 1;
                tileValue[i+11] = tileValue[i+11]+ 1;
                tileValue[i-11] = tileValue[i-11]+ 1;
                tileValue[i+9] = tileValue[i+9]+ 1;
                tileValue[i-9] = tileValue[i-9]+ 1;
                
            }
               //top edge pieces
            if(i == 1 || i == 2|| i == 3 || i == 4 || i ==5 || i == 6 || i == 7 || i == 8){
               
                tileValue[i-1] = tileValue[i-1] + 1;
                tileValue[i+1] = tileValue[i+1] + 1;
                tileValue[i+9] = tileValue[i+9] + 1;
                tileValue[i+10] =tileValue[i+10] + 1;
                tileValue[i+11] = tileValue[i+11] + 1;
                       
             
                        
            } //left edge pieces
             if(i == 10 || i == 20 || i == 30 || i == 40 || i == 50 || i == 60|| i == 70 || i == 80) { 
               
                tileValue[i+1] = tileValue[i+1] + 1;
                tileValue[i-9] = tileValue[i-9] + 1;
                tileValue[i-10] = tileValue[i-10] + 1;
                tileValue[i+10] =tileValue[i+10] + 1;
                tileValue[i+11] = tileValue[i+11] + 1;
                
              
                        
                        
            } //bottom edge pieces
            if(i == 91 || i == 92 || i == 93 || i == 94 || i == 95 || i == 96|| i == 97 || i == 98) { 
               
                tileValue[i+1] = tileValue[i+1] + 1;
                tileValue[i-1] = tileValue[i-1] + 1;
                tileValue[i-9] = tileValue[i-9] + 1;
                tileValue[i-10] =tileValue[i-10] + 1;
                tileValue[i-11] = tileValue[i-11] + 1;
                        
                     
            } 
              //right edge pieces
               
            if(i == 19  || i == 29 || i == 39 || i == 49 || i == 59 || i == 69|| i == 79 || i == 89) { 
                tileValue[i-1] = tileValue[i-1] + 1;
                tileValue[i-10] = tileValue[i-10] + 1;
                tileValue[i-11] = tileValue[i-11] + 1;
                tileValue[i+10] =tileValue[i+10] + 1;
                tileValue[i+9] = tileValue[i+9] + 1;
                         
            } 
            } 

        }
        }
        
  
    
    void reset(){ //resets all arrays
      
        for(int i = 0; i < 100; i++){
            tileValue[i] = 0;
            bombArray[i] = false;
            flagArray[i] = false;
            selectedArray[i] = false;
            bombLocation.clear();
        }
        
 
        
    }
   

 void winCondition(){
   
        if (Arrays.equals(flagArray, bombArray)) 
//if all flags have been placed in the same position as each bomb, then it triggers a win.
        {
            gameIsWon = true;
            
        }
    }

 }
        
    

            
    
