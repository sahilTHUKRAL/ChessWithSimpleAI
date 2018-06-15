import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


	// when a button is clicked, it generates an ActionEvent. Thus, each button needs an ActionListener. When it is clicked, it goes to this listener class that I have created and goes to the actionPerformed method. There (and in this class), we decide what we want to do.
   public class buttonListner implements ActionListener
    {       
	   static boolean ispieceSelected = false;
	   static PieceSet.Piece pieceSelected;
	   public void actionPerformed(ActionEvent e) 
        {
        	Board.Square buttonClicked = (Board.Square)e.getSource();
        	//if a Green Move is Selected after selecting a player
        	if(buttonClicked.getBackground()==Color.GREEN  ) {
        		pieceSelected.getPlayer().guiMove(pieceSelected,buttonClicked);
        		if(!pieceSelected.getPlayer().opponent.IsAI)
        			pieceSelected.getPlayer().isOpponentUnderCheck();
        		pieceSelected.getPlayer().inmove=false;
        		if(pieceSelected.getPlayer().opponent.IsAI){
        			pieceSelected.getPlayer().chessBoard.clearAllGreenSquare();
        			pieceSelected.getPlayer().opponent.takeAMove();
        		}
        		else{
        			pieceSelected.getPlayer().opponent.inmove=true;
        		}
        		pieceSelected.getPlayer().chessBoard.Resetboard(pieceSelected.getPlayer().game);
        		return;
        	}
        	/*if a non green move is selected after selecting a player 
        	if(buttonClicked.piece==null && buttonClicked.getBackground()!=Color.GREEN){
        		ispieceSelected=false;
        		pieceSelected=null;
        		return;
        	}
        	*/
        	// if a player is selected from right pieceSet
        	if(buttonClicked.piece!=null && checkForCorrectPiece(buttonClicked.piece)) {
        		buttonClicked.piece.getPlayer().chessBoard.clearAllGreenSquare();
        		ArrayList<Board.Square> colorSquares =  buttonClicked.legalMoves();
                ispieceSelected=true;
                pieceSelected= buttonClicked.piece;
                Game.GreenPossibleMoves(colorSquares);
        		ispieceSelected=false;
        	}        	
        }
   public  boolean checkForCorrectPiece(PieceSet.Piece piece) {	   
	   return piece.getPlayer().inmove;
   }
    }
   
