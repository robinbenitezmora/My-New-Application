package sudoku.computationlogic;

import domain.SudokuGame;

public class SudokuUtilities {
 public static void copySudokuArrayValues(Object object, int[][] newArray) {
  for (int xIndex = 0; xIndex < SudokuGame.GRID_BOUNDARY; xIndex++) {
   for (int yIndex = 0; yIndex < SudokuGame.GRID_BOUNDARY; yIndex++) {
    newArray[xIndex][yIndex] = ((int[][]) object)[xIndex][yIndex];
   }
  }
 }

 public static int[][] copyToNewArray(int[][] oldArray) {
  int[][] newArray = new int[SudokuGame.GRID_BOUNDARY][SudokuGame.GRID_BOUNDARY];

  for (int xIndex = 0; xIndex < SudokuGame.GRID_BOUNDARY; xIndex++) {
   for (int yIndex = 0; yIndex < SudokuGame.GRID_BOUNDARY; yIndex++) {
    newArray[xIndex][yIndex] = oldArray[xIndex][yIndex];
   }
  }

  return newArray;
 }
}
