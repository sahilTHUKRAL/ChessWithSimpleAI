import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collector.Characteristics;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintWriter;

import javax.swing.*;
public class Game extends Panel{
	static Player a = new Player();
	 static Player b = new Player();
	 Board chessBoard = new Board(a,b);

public Game() {
	b.game= this;
	a.game = this;
    setLayout(new GridLayout(8,8));
	      chessBoard.Resetboard(this);
	      a.inmove=true;
}
	private static void PrepairGUI() {
		  //printing the window for chess
	    JFrame window = new JFrame("CHESS");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new Game());
       window.setBounds(600,600,600,600);
        window.setVisible(true);
        window.setLocationRelativeTo(null);	
  		

	     
}
	public static void main(String a[])throws Exception{
       PrepairGUI();
/////////////////////----------------Game Logic -------------------////////////////////////////////
        String[] values = {"Human", "AI"};
		String pieceCode ="AI";
		Object selected = JOptionPane.showInputDialog(null, "Choose The opposition Player:\n 1: Human \n 2: AI ", "Selection", JOptionPane.DEFAULT_OPTION, null, values, "AI");
		if ( selected != null ){//null if the user cancels.
			if(selected.toString()=="AI")
					b.IsAI=true;
			String[] natureValues = {"Random", "Offensive","Preventive","meta-Preventive",};
			Object natureSelected = JOptionPane.showInputDialog(null, "Choose the AI Player nature :\n 1: Random \n 2: Offensive \n 3: Preventive \n 4: meta-Preventive \n ", " Nature Selection", JOptionPane.DEFAULT_OPTION, null, natureValues, "Random");
			if ( natureSelected != null ){//null if the user cancels.
				if(natureSelected.toString()=="Random") {
						b.nature="Random";
				}
				else if(natureSelected.toString()=="Offensive") {
						b.nature="Offensive";
				}
				else if(natureSelected.toString()=="meta-Preventive") {
					b.nature="meta-Preventive";
				}
				/*else if(natureSelected.toString()=="L1Moves") {
					b.nature="L1Moves";
				}*/
				else {
					b.nature="Preventive";
				}
			}
			else{
			    System.exit(0);
			}
		}else{
		    System.exit(0);
		}
		
        /* chessBoard.print();
	 //game loop
	 while(a.checkForMoveLeft() && b.checkForMoveLeft()) {
		// System.out.println(a.pieceSet.colour+"'s move");
		 move(a);
	 //chessBoard.turnTheBoard();
		// chessBoard.print();
		 chessBoard.Resetboard(this); 
		 //System.out.println(b.pieceSet.colour+"'s move");
		move(b);
	chessBoard.Resetboard(this); 
}
	 if(!a.moveLeft)
	 {
		 if(a.underCheck) {
		 System.out.println(" Player B wins");
		 }
		 else {
			 System.out.println("Match Draw By staleMate");
		 }
	 }
	 
	 if(!b.moveLeft)
	 {
		 if(b.underCheck) {
		 System.out.println(" Player A wins");
		 }
		 else {
			 System.out.println("Match Draw By staleMate");
		 }
	 }*/
        
        //move(a);
}

/*public static boolean GameAlive(Player a, Player b) {
	if(a.checkForMoveLeft() && b.checkForMoveLeft()) {return true;}
	return false;
}
*/
public static void GreenPossibleMoves(ArrayList<Board.Square> colorSquares) {
	for(Board.Square colorSquare : colorSquares) {
		colorSquare.setBackground(Color.GREEN);
	}
}
	
}
