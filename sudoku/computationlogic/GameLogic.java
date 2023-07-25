package sudoku.computationlogic;

import java.util.ArrayList;
import java.util.List;

import constants.GameState;
import constants.Rows;
import domain.SudokuGame;

public class GameLogic {
 private static final int GRID_BOUNDARY = 0;
 private static int yIndex;
 private static int xIndex;

 public static SudokuGame getNewGame() {
  return new SudokuGame(
    GameState.NEW,
    GameGenerator.getNewGameGrid());
 }

 public static GameState checkForCompletion(int[][] grid) {
  if (sudokuIsInvalid(grid))
   return GameState.ACTIVE;
  if (tilesAreNotFilled(grid))
   return GameState.ACTIVE;
  return GameState.COMPLETE;
 }

 private static boolean tilesAreNotFilled(int[][] grid) {
  for (int xIndex = 0; xIndex < GRID_BOUNDARY; xIndex++) {
   for (int yIndex = 0; yIndex < GRID_BOUNDARY; yIndex++) {
    if (grid[xIndex][yIndex] == 0)
     return true;
   }
  }
  return false;
 }

 private static boolean sudokuIsInvalid(int[][] grid) {
  if (rowsAreInvalid(grid))
   return true;
  if (columnsAreInvalid(grid))
   return true;
  if (squaresAreInvalid(grid))
   return true;
  return false;
 }

 private static boolean squaresAreInvalid(int[][] grid) {
  if (rowOfSquaresIsInvalid(Rows.TOP, grid))
   return true;
  if (rowOfSquaresIsInvalid(Rows.MIDDLE, grid))
   return true;
  if (rowOfSquaresIsInvalid(Rows.BOTTOM, grid))
   return true;
  return false;
 }

 private static boolean rowOfSquaresIsInvalid(Rows top, int[][] grid) {
  switch (value) {
   if (squareIsInvalid(0, 0, grid)) return true;
   if (squareIsInvalid(0, 3, grid)) return true;
   if (squareIsInvalid(0, 6, grid)) return true;
   return false;
 }

 private static boolean squareIsInvalid(int i, int j, int[][] grid) {
  int yIndexEnd = yIndex + 3;
  int xIndexEnd = xIndex + 3;

  List<Integer> square = new ArrayList<>();

  while (yIndex < yIndexEnd) {
   while (xIndex < xIndexEnd) {
    square.add(grid[xIndex][yIndex]);
    xIndex++;
   }
   yIndex -= 3;

   yIndex++;
  }
  if (collectionHasRepeats(square))
   return true;
  return false;
 }

 private static boolean collectionHasRepeats(List<Integer> square) {
  for (int index = 0; index < GRID_BOUNDARY; index++) {
   if (square.contains(index))
    return true;
  }
  return false;
 }

 private static boolean columnsAreInvalid(int[][] grid) {
  for (int xIndex = 0; xIndex < GRID_BOUNDARY; xIndex++) {
   List<Integer> row = new ArrayList<>();
   for (int yIndex = 0; yIndex < GRID_BOUNDARY; yIndex++) {
    row.add(grid[xIndex][yIndex]);
   }
   if (collectionHasRepeats(row))
    return true;
  }
  return false;
 }

 private static boolean rowsAreInvalid(int[][] grid) {
  for (int yIndex = 0; yIndex < GRID_BOUNDARY; yIndex++) {
   List<Integer> row = new ArrayList<>();
   for (int xIndex = 0; xIndex < GRID_BOUNDARY; xIndex++) {
    row.add(grid[xIndex][yIndex]);
   }
   if (collectionHasRepeats(row))
    return true;
  }
  return false;
 }
}
