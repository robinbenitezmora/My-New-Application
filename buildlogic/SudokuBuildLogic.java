package buildlogic;

import java.io.IOException;
import java.util.EventListener;

import javax.naming.ldap.Control;

import domain.IStorage;
import domain.SudokuGame;
import sudoku.computationlogic.GameGenerator;
import userInterface.IUserInterfaceContract;
import userInterface.IUserInterfaceContract.View;
import userInterface.logic.ControlLogic;

public class SudokuBuildLogic {
 private static final IStorage storage = null;
 private static final View userInterface = null;

 public static void build(IUserInterfaceContract.View userInterface) throws IOException {
  SudokuGame initialState;
  IStorage storage = (IStorage) new LocalStorageImpl();

  try {
   initialState = storage.getGameData();
  } catch (IOException e) {
   initialState = GameGenerator.getNewGame();
   storage.updateGameData(initialState);
  }
 }

 public static void register(IUserInterfaceContract.View userInterface) {
  ControlLogic controlLogic = new ControlLogic(storage, userInterface);
  userInterface.setListener((EventListener) controlLogic);
  try {
   userInterface.updateBoard(storage.getGameData());
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 }
}
