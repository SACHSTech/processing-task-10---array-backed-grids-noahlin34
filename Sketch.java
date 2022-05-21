import processing.core.PApplet;



/**
 * 
 * @author noah lin
 * 
 * This program allows you to change cells to green and print various information about the current state of the grid 
 */
public class Sketch extends PApplet {
	


  //declaring variables
  int[][] intGrid;
  int intRowContinuousCount = 0;
  int intSelectedColumnCount = 0;
  int intSelectedRowCount = 0;
  int intSelectedCount = 0;
  int CELL_WIDTH = 20;
  int CELL_HEIGHT = 20;
  int MARGIN = 5;
  int ROW_COUNT = 10;
  int COLUMN_COUNT = 10;
  int SCREEN_HEIGHT = (ROW_COUNT * CELL_HEIGHT) + ((ROW_COUNT + 1) * MARGIN);
  int SCREEN_WIDTH = (CELL_WIDTH * COLUMN_COUNT) + ((COLUMN_COUNT + 1) * MARGIN);



  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(500, 600);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0,0,0);

    //delcaring the intGrid so that its values can be undefined
    intGrid = new int[ROW_COUNT][COLUMN_COUNT];
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
 



    //nested for loop to draw the grid
    for(int column = 0; column < COLUMN_COUNT; column++) {
      for(int row = 0; row < ROW_COUNT; row++) {

        //if the value of that array position is 1, make it green 
        if(intGrid[row][column] == 1) {
          fill(0, 255, 0);
          rect(MARGIN*(column + 1) + (column * CELL_WIDTH), MARGIN * (row + 1) + (row * CELL_HEIGHT), CELL_HEIGHT, CELL_WIDTH);
        } else {
          fill(255, 255, 255);
          rect(MARGIN*(column + 1) + (column * CELL_WIDTH), MARGIN * (row + 1) + (row * CELL_HEIGHT), CELL_HEIGHT, CELL_WIDTH);
        }
        
       
      }
    }

    
	  
  }

  public void mousePressed(){

    //nested for loop to check every space in the grid 
    for(int row = 0; row < ROW_COUNT; row++ ) {
      for(int column = 0; column < COLUMN_COUNT; column++) {
      
        //if the distance from the center of the cell is less than 10
        if(dist(MARGIN*(column + 1) + (column * CELL_WIDTH) + 10, MARGIN * (row + 1) + (row * CELL_HEIGHT) + 10, mouseX, mouseY) < 10 ) {
          
          //prints mouse position
          System.out.println("mouse coordinates: " + mouseX + ", " + mouseY + " Grid coordinates: row: " + (row + 1) + " column: " + (column + 1));
          

          //code to change the squares to green and update counters 
            intGrid[row][column] ^= 1;
            if (intGrid[row][column] == 1) {
              intSelectedCount++;
            } else {
              intSelectedCount--;
            }
            if(row < 9) {
              intGrid[row+1][column] ^= 1;
              if (intGrid[row + 1][column] == 1) {
                intSelectedCount++;
              } else {
                intSelectedCount--;
              }
            }
            if(column < 9) {
              intGrid[row][column+1] ^= 1;
              if (intGrid[row][column+1] == 1) {
                intSelectedCount++;
              } else {
                intSelectedCount--;
              }
            }

            if(row > 0) {
              intGrid[row-1][column] ^= 1;
              if (intGrid[row - 1][column] == 1) {
                intSelectedCount++;
              } else {
                intSelectedCount--;
              }
            }
            
            if(column > 0) {
              intGrid[row][column-1] ^= 1;
              if (intGrid[row][column - 1] == 1) {
                intSelectedCount++;
              } else {
                intSelectedCount--;
              }
            }
            
            
          
  
        }
      }
    }

    System.out.println("Total of " + intSelectedCount + " selected");
   
    //the following for loops and if statements are to count how many consecutive cells are selected in x row 
    for(int row = 0; row <ROW_COUNT; row++) {
      for(int column = 0; column < COLUMN_COUNT; column++) {
        if(intGrid[row][column] == 1) {
          intSelectedRowCount++;
        }
        
        if(column < COLUMN_COUNT-1 && column >0) {
          if(intGrid[row][column] == 1 && intGrid[row][column-1] == 1) {
            intRowContinuousCount++;
          } else if (column < COLUMN_COUNT-1 && column > 0) {
            if (intGrid[row][column] == 1 && intGrid[row][column+1] == 1) {
              intRowContinuousCount++;
            }
          }
          
        }
      }

    //if there are more than two continuous, print the information
    if(intRowContinuousCount > 2) {
      System.out.println("There are " + intRowContinuousCount + " continuous blocks selected on row " + (row+1));
    }
      System.out.println("Row " + (row+1) + " has " + intSelectedRowCount + " cells selected");
      intSelectedRowCount = 0;
      intRowContinuousCount = 0;
    }

    //for loop to display amount of selected cells in a column 
    for(int column = 0; column < COLUMN_COUNT; column++) {
      for(int row = 0; row < ROW_COUNT; row++) {
        if(intGrid[row][column] == 1) {
          intSelectedColumnCount++;
        }
      }
    
      System.out.println("Column " + (column+1) + " has " + intSelectedColumnCount + " cells selected");
      intSelectedColumnCount = 0;
    }
  }
}
