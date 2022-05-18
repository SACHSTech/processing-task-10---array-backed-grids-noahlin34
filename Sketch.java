import processing.core.PApplet;

public class Sketch extends PApplet {
	

  int[][] intGrid = new int[ROW_COUNT][COLUMN_COUNT];
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

    intGrid[1][5] = 1;
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {



    for(int column = 0; column <= ROW_COUNT; column++) {
      for(int row = 0; row <= ROW_COUNT; row++) {
        
        rect(MARGIN*(column + 1) + (column * CELL_WIDTH), MARGIN * (row + 1) + (row * CELL_HEIGHT), CELL_HEIGHT, CELL_WIDTH);
        if(intGrid[row][column] == 1) {
          fill(0, 255, 0);
        }
      }
    }
	  
  }

  public void mousePressed(){
    
  }
}
