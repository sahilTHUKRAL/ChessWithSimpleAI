import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class PieceSet{
	class Piece {
		protected  String name;
		protected int value;
		protected char icon;
		protected Icon iconImage;
		java.net.URL imageUrl;
		protected int x,y;
		protected String pathToImage;
		//Copy Constructor 
		public Piece(Piece p) {
			this.name = p.name;
			this.pathToImage= p.pathToImage;
			this.icon = p.icon;
			this.value= p.value;
			this.iconImage = p.iconImage;
			this.imageUrl = p.imageUrl;
			this.x= p.x;
			this.y=p.y;
		}
		
		public int getColour() {
			return colour;
		}
		public void setFirstMove(Boolean b) {
		}
		public boolean getFirstMove() {
			return false;
		}
		public Player getPlayer() {
			return player;
		}
		
		protected boolean underlimits(int i, int j) {
			return (i<8 && j<8 && i>=0 && j>=0);
		}
		// Simple Constructor 
		public Piece() {}
		// Paramertic Constructor
		public Piece(int x , int y){	
			this.x=x;
			this.y=y;
		}
		public ArrayList<Board.Square> getMoves(Board.Square[][] board) {
			System.out.println(x+","+y);
			return null;
		}
		public ArrayList<Board.Square> getMovesWithOutCheck(Board.Square[][] board) {
			return null;
		}
	}
	class Rook extends Piece{
		Rook(int x, int y){
			this.name= "Rook";
			this.value=5;
			if(this.getColour()==1) {
				this.icon='\u265c';
				this.pathToImage="images/blackRook.png";
				this.iconImage = new ImageIcon(getClass().getResource(pathToImage));
			}
			else {
				this.icon= '\u2656';
				this.pathToImage="images/whiteRook.png";
				this.iconImage = new ImageIcon(getClass().getResource(pathToImage));
			}
			this.x=x;
			this.y=y;
		}
		@Override
		public ArrayList<Board.Square> getMovesWithOutCheck(Board.Square[][] board) {
			ArrayList<Board.Square> moves= new ArrayList<Board.Square>();
			int i=x;
			int j=y;
			for(i=x+1;underlimits(i, j);i++) {
			if(board[i][j].piece==null) {
					moves.add(board[i][j]);
				}
				else if(board[i][j].piece!=null){
					moves.add(board[i][j]);
					break;
				}
			}
			i=x;
			j=y;
			for(i=x-1;underlimits(i, j);i--) {
				if(board[i][j].piece==null) {
					moves.add(board[i][j]);
				}
				else if(board[i][j].piece!=null){
						moves.add(board[i][j]);
					break;
				}
			}
			i=x;
			j=y;
			for(j=y+1;underlimits(i, j);j++) {
				if(board[i][j].piece==null) {
						moves.add(board[i][j]);}
					else if(board[i][j].piece!=null){
							moves.add(board[i][j]);
						break;
					}
				}
			
			i=x;
			j=y;
			for(j=y-1;underlimits(i, j);j--) {
					if(board[i][j].piece==null) {
							moves.add(board[i][j]);
					}
					else if(board[i][j].piece!=null){
						moves.add(board[i][j]);
						break;
					}
				}
			return moves;
		}
		@Override
		public ArrayList<Board.Square> getMoves(Board.Square[][] board) {			
			ArrayList<Board.Square> moves= new ArrayList<Board.Square>();
			int i=x;
			int j=y;
			for(i=x+1;underlimits(i, j);i++) {
			if(board[i][j].piece==null) {
				if(!checkForCheck(board[x][y],board[i][j]))
					moves.add(board[i][j]);
				}
				else if(board[i][j].piece!=null){
					if(!checkForCheck(board[x][y],board[i][j]))
					moves.add(board[i][j]);
					break;
				}
			}
			i=x;
			j=y;
			for(i=x-1;underlimits(i, j);i--) {
				if(board[i][j].piece==null) {
				if(!checkForCheck(board[x][y],board[i][j]))
					moves.add(board[i][j]);
				}
				else if(board[i][j].piece!=null){
					if(!checkForCheck(board[x][y],board[i][j]))
						moves.add(board[i][j]);
					break;
				}
			}
			i=x;
			j=y;
			for(j=y+1;underlimits(i, j);j++) {
				if(board[i][j].piece==null) {
					if(!checkForCheck(board[x][y],board[i][j]))
						moves.add(board[i][j]);}
					else if(board[i][j].piece!=null){
						if(!checkForCheck(board[x][y],board[i][j]))
							moves.add(board[i][j]);
						break;
					}
				}
			
			i=x;
			j=y;
			for(j=y-1;underlimits(i, j);j--) {
					if(board[i][j].piece==null) {
						if(!checkForCheck(board[x][y],board[i][j]))
							moves.add(board[i][j]);
					}
					else if(board[i][j].piece!=null){
						if(!checkForCheck(board[x][y],board[i][j]))
						moves.add(board[i][j]);
						break;
					}
				}
			return moves;
		}
	}
	
	class Knight extends Piece{
		Knight(int x, int y){
			this.name= "Knight";
			this.value = 3;
			if(this.getColour()==1) {
				this.icon='\u265e';
				this.pathToImage="images/blackKnight.png";
				iconImage = new ImageIcon(getClass().getResource(pathToImage));
			}
			else {
				this.icon= '\u2658';
				this.pathToImage="images/whiteKnight.png";
				iconImage = new ImageIcon(getClass().getResource(pathToImage));
			}
			this.x=x;
			this.y=y;
		}
		@Override
		public ArrayList<Board.Square> getMovesWithOutCheck(Board.Square[][] board) {
			ArrayList<Board.Square> moves= new ArrayList<Board.Square>();
			int i=x;
			int j=y;
			if(underlimits(i+2, j+1)) {
				{
				moves.add(board[i+2][j+1]);
				}
			}
			if(underlimits(i-2, j+1)) {
				moves.add(board[i-2][j+1]);
			}
			if(underlimits(i+2, j-1)) {
				moves.add(board[i+2][j-1]);
			}
			if(underlimits(i-2, j-1)) {
				moves.add(board[i-2][j-1]);
			}
			if(underlimits(i+1, j+2)) {
				moves.add(board[i+1][j+2]);
			}
			if(underlimits(i-1, j+2)) {
				moves.add(board[i-1][j+2]);
			}
			if(underlimits(i+1, j-2)) {
				moves.add(board[i+1][j-2]);
			}
			if(underlimits(i-1, j-2)) {
				moves.add(board[i-1][j-2]);
			}	return moves;
		}
	
		@Override
		public ArrayList<Board.Square> getMoves(Board.Square[][] board) {
			ArrayList<Board.Square> moves= new ArrayList<Board.Square>();
			int i=x;
			int j=y;
			if(underlimits(i+2, j+1)) {
				if(!checkForCheck(board[x][y],board[i+2][j+1]))
					{
					
					moves.add(board[i+2][j+1]);}
			}
			if(underlimits(i-2, j+1)) {
				
				if(!checkForCheck(board[x][y],board[i-2][j+1])) {
					moves.add(board[i-2][j+1]);
					
				}
			}
			if(underlimits(i+2, j-1)) {
				
				if(!checkForCheck(board[x][y],board[i+2][j-1])) {
					moves.add(board[i+2][j-1]);
				}
			}
			if(underlimits(i-2, j-1)) {
				if(!checkForCheck(board[x][y],board[i-2][j-1])) {
					moves.add(board[i-2][j-1]);
				}
			}
			if(underlimits(i+1, j+2)) {
				if(!checkForCheck(board[x][y],board[i+1][j+2]))
					moves.add(board[i+1][j+2]);
			}
			if(underlimits(i-1, j+2)) {
				if(!checkForCheck(board[x][y],board[i-1][j+2]))
					moves.add(board[i-1][j+2]);
			}
			if(underlimits(i+1, j-2)) {
				if(!checkForCheck(board[x][y],board[i+1][j-2]))
					moves.add(board[i+1][j-2]);
			}
			if(underlimits(i-1, j-2)) {
				if(!checkForCheck(board[x][y],board[i-1][j-2]))
					moves.add(board[i-1][j-2]);
			}
			return moves;
			
		}
	}
	
	class Bishop extends Piece{
		Bishop(int x, int y){
			this.name= "Bishop";
			this.value = 3;
			if(this.getColour()==1) {
				this.icon='\u265d';
				this.pathToImage="images/blackBishop.png";
				iconImage = new ImageIcon(getClass().getResource(pathToImage));
			}
			else {
				this.icon= '\u2657';
				this.pathToImage="images/whiteBishop.png";
				iconImage = new ImageIcon(getClass().getResource(pathToImage));
			}
			this.x=x;
			this.y=y;
		}
		@Override
		public ArrayList<Board.Square> getMovesWithOutCheck(Board.Square[][] board) {
			ArrayList<Board.Square> moves= new ArrayList<Board.Square>();
			int i=x;
			int j=y;
			j++;
			for(i=x+1;underlimits(i, j);i++) {
			if(board[i][j].piece==null) {
					moves.add(board[i][j]);
				}
				else if(board[i][j].piece!=null){
					moves.add(board[i][j]);
					break;
				}
			j++;
			}
			i=x;
			j=y;
			j--;
			for(i=x-1;underlimits(i, j);i--) {
				if(board[i][j].piece==null) {
					moves.add(board[i][j]);
				}
				else if(board[i][j].piece!=null){
					moves.add(board[i][j]);
					break;
				}
				j--;
			}
			i=x;
			j=y;
			i--;
			for(j=y+1;underlimits(i, j);j++) {
				if(board[i][j].piece==null) {
						moves.add(board[i][j]);
					}
					else if(board[i][j].piece!=null){
						moves.add(board[i][j]);
						break;
					}
				i--;
				}
			i=x;
			j=y;
			i++;
				for(j=y-1;underlimits(i, j);j--) {
					if(board[i][j].piece==null) {
						moves.add(board[i][j]);
					}
					else if(board[i][j].piece!=null){
						moves.add(board[i][j]);
						break;
					}
				i++;
				}
				
			return moves;
		}
		@Override
		public ArrayList<Board.Square> getMoves(Board.Square[][] board) {			
			ArrayList<Board.Square> moves= new ArrayList<Board.Square>();
			int i=x;
			int j=y;
			j++;
			for(i=x+1;underlimits(i, j);i++) {
			if(board[i][j].piece==null) {
				if(!checkForCheck(board[x][y],board[i][j]))
					moves.add(board[i][j]);
				}
				else if(board[i][j].piece!=null){
					if(!checkForCheck(board[x][y],board[i][j]))
					moves.add(board[i][j]);
					break;
				}
			j++;
			}
			i=x;
			j=y;
			j--;
			for(i=x-1;underlimits(i, j);i--) {
				if(board[i][j].piece==null) {
					if(!checkForCheck(board[x][y],board[i][j]))
					moves.add(board[i][j]);
				}
				else if(board[i][j].piece!=null){
					if(!checkForCheck(board[x][y],board[i][j]))
					moves.add(board[i][j]);
					break;
				}
				j--;
			}
			i=x;
			j=y;
			i--;
			for(j=y+1;underlimits(i, j);j++) {
				if(board[i][j].piece==null) {
					if(!checkForCheck(board[x][y],board[i][j]))
						moves.add(board[i][j]);
					}
					else if(board[i][j].piece!=null){
						if(!checkForCheck(board[x][y],board[i][j]))
						moves.add(board[i][j]);
						break;
					}
				i--;
				}
			i=x;
			j=y;
			i++;
				for(j=y-1;underlimits(i, j);j--) {
					if(board[i][j].piece==null) {
						if(!checkForCheck(board[x][y],board[i][j]))
						moves.add(board[i][j]);
					}
					else if(board[i][j].piece!=null){
						if(!checkForCheck(board[x][y],board[i][j]))
						moves.add(board[i][j]);
						break;
					}
				i++;
				}
				
			return moves;
		}
	}
	
	class Queen extends Piece{
		Queen(int x, int y){
			this.name= "Queen";
			this.value= 9;
			if(this.getColour()==1) {
				this.icon='\u265b';
				this.pathToImage="images/blackQueen.png";
				iconImage = new ImageIcon(getClass().getResource(pathToImage));
				}
			else {
				this.icon= '\u2655';
				this.pathToImage="images/whiteQueen.png";
				iconImage = new ImageIcon(getClass().getResource(pathToImage));
				}
			this.x=x;
			this.y=y;
		}
		@Override
		public ArrayList<Board.Square> getMovesWithOutCheck(Board.Square[][] board) {
			ArrayList<Board.Square> moves= new ArrayList<Board.Square>();
			int i=x;
			int j=y;
			j++;
			for(i=x+1;underlimits(i, j);i++) {
			if(board[i][j].piece==null) {
					moves.add(board[i][j]);
				}
				else if(board[i][j].piece!=null){
					moves.add(board[i][j]);
					break;
				}
			j++;
			}
			i=x;
			j=y;
			j--;
			for(i=x-1;underlimits(i, j);i--) {
				if(board[i][j].piece==null) {
					moves.add(board[i][j]);
				}
				else if(board[i][j].piece!=null){
					moves.add(board[i][j]);
					break;
				}
				j--;
			}
			i=x;
			j=y;
			i--;
			for(j=y+1;underlimits(i, j);j++) {
				if(board[i][j].piece==null) {
						moves.add(board[i][j]);
					}
					else if(board[i][j].piece!=null){
						moves.add(board[i][j]);
						break;
					}
				i--;
				}
			i=x;
			j=y;
			i++;
				for(j=y-1;underlimits(i, j);j--) {
					if(board[i][j].piece==null) {
						moves.add(board[i][j]);
					}
					else if(board[i][j].piece!=null){
						moves.add(board[i][j]);
						break;
					}
				i++;
				}
				
				 i=x;
				 j=y;
				for(i=x+1;i<8;i++) {
				if(board[i][j].piece==null) {
						moves.add(board[i][j]);
					}
					else if(board[i][j].piece!=null){
						moves.add(board[i][j]);
						break;
					}
				}
				for(i=x-1;i>=0;i--) {
					if(board[i][j].piece==null) {
						moves.add(board[i][j]);
					}
					else if(board[i][j].piece!=null){
						moves.add(board[i][j]);
						break;
					}
				}
				i=x;
				for(j=y+1;j<8;j++) {
					if(board[i][j].piece==null) {
							moves.add(board[i][j]);
						}
						else if(board[i][j].piece!=null){
							moves.add(board[i][j]);
							break;
						}
					}
					for(j=y-1;j>=0;j--) {
						if(board[i][j].piece==null) {
							moves.add(board[i][j]);
						}
						else if(board[i][j].piece!=null){
							moves.add(board[i][j]);
							break;
						}
					}
			return moves;
		}
		@Override
		public ArrayList<Board.Square> getMoves(Board.Square[][] board) {	
			ArrayList<Board.Square> moves= new ArrayList<Board.Square>();
//bishop moves
			int i=x;
			int j=y;
			j++;
			for(i=x+1;underlimits(i, j);i++) {
			if(board[i][j].piece==null) {
				if(!checkForCheck(board[x][y],board[i][j]))
					moves.add(board[i][j]);
				}
				else if(board[i][j].piece!=null){
					if(!checkForCheck(board[x][y],board[i][j]))
					moves.add(board[i][j]);
					break;
				}
			j++;
			}
			i=x;
			j=y;
			j--;
			for(i=x-1;underlimits(i, j);i--) {
				if(board[i][j].piece==null) {
					if(!checkForCheck(board[x][y],board[i][j]))
					moves.add(board[i][j]);
				}
				else if(board[i][j].piece!=null){
					if(!checkForCheck(board[x][y],board[i][j]))
					moves.add(board[i][j]);
					break;
				}
				j--;
			}
			i=x;
			j=y;
			i--;
			for(j=y+1;underlimits(i, j);j++) {
				if(board[i][j].piece==null) {
					if(!checkForCheck(board[x][y],board[i][j]))
						moves.add(board[i][j]);
					}
					else if(board[i][j].piece!=null){
						if(!checkForCheck(board[x][y],board[i][j]))
						moves.add(board[i][j]);
						break;
					}
				i--;
				}
			i=x;
			j=y;
			i++;
				for(j=y-1;underlimits(i, j);j--) {
					if(board[i][j].piece==null) {
						if(!checkForCheck(board[x][y],board[i][j]))
						moves.add(board[i][j]);
					}
					else if(board[i][j].piece!=null){
						if(!checkForCheck(board[x][y],board[i][j]))
						moves.add(board[i][j]);
						break;
					}
				i++;
				}
// rooks moves
				i=x;
				j=y;
				for(i=x+1;underlimits(i, j);i++) {

				if(board[i][j].piece==null) {
					if(!checkForCheck(board[x][y],board[i][j]))
						moves.add(board[i][j]);
					}
					else if(board[i][j].piece!=null){
						if(!checkForCheck(board[x][y],board[i][j]))
						moves.add(board[i][j]);
						break;
					}
				}
				i=x;
				j=y;
				for(i=x-1;underlimits(i, j);i--) {
					if(board[i][j].piece==null) {
					if(!checkForCheck(board[x][y],board[i][j]))
						moves.add(board[i][j]);
					}
					else if(board[i][j].piece!=null){
						if(!checkForCheck(board[x][y],board[i][j]))
							moves.add(board[i][j]);
						break;
					}
				}
				i=x;
				j=y;
				for(j=y+1;underlimits(i, j);j++) {
					if(board[i][j].piece==null) {
						if(!checkForCheck(board[x][y],board[i][j]))
							moves.add(board[i][j]);}
						else if(board[i][j].piece!=null){
							if(!checkForCheck(board[x][y],board[i][j]))
								moves.add(board[i][j]);
							break;
						}
					}
				
				i=x;
				j=y;
				for(j=y-1;underlimits(i, j);j--) {
						if(board[i][j].piece==null) {
							if(!checkForCheck(board[x][y],board[i][j]))
								moves.add(board[i][j]);
						}
						else if(board[i][j].piece!=null){
							if(!checkForCheck(board[x][y],board[i][j]))
							moves.add(board[i][j]);
							break;
						}
					}
			return moves;
		}
		
	}
	
	class King extends Piece{
		public boolean casling=true;
		King(int x, int y){
			this.name= "King";
			this.value=Integer.MAX_VALUE;
			if(this.getColour()==1) {
				this.icon='\u265a';
				this.pathToImage="images/blackKing.png";
				iconImage = new ImageIcon(getClass().getResource(pathToImage));
				}
			else {
				this.icon= '\u2654';
				this.pathToImage="images/whiteKing.png";
				iconImage = new ImageIcon(getClass().getResource(pathToImage));

				}
			this.x=x;
			this.y=y;
		}	
		@Override
		public ArrayList<Board.Square> getMovesWithOutCheck(Board.Square[][] board) {
			
			ArrayList<Board.Square> moves= new ArrayList<Board.Square>();
			//staright moves
			int i=x;
			int j=y+1;
			if(underlimits(i, j)) {
				moves.add(board[i][j]);
			}
			i=x;
			j=y-1;
			if(underlimits(i, j)) {
				moves.add(board[i][j]);
			}
			i=x-1;
			j=y;
			if(underlimits(i, j)) {
				moves.add(board[i][j]);
			}
			i=x+1;
			j=y;
			if(underlimits(i, j)) {
				moves.add(board[i][j]);
			}
			//diagonal moves
			 i=x+1;
			 j=y+1;
			if(underlimits(i, j)) {
				moves.add(board[i][j]);
			}
			i=x+1;
			j=y-1;
			if(underlimits(i, j)) {
				moves.add(board[i][j]);
			}
			i=x-1;
			j=y+1;
			if(underlimits(i, j)) {
				moves.add(board[i][j]);
			}
			i=x-1;
			j=y-1;
			if(underlimits(i, j)) {
				moves.add(board[i][j]);
			}
		return moves;
		}
		@Override
		public ArrayList<Board.Square> getMoves(Board.Square[][] board) {
			
			ArrayList<Board.Square> moves= new ArrayList<Board.Square>();
			int X=x;
			int Y=y;
			//diagonal moves
			int i=X+1;
			 int j=Y+1;
			if(underlimits(i, j)) {
			if(!checkForCheck(board[x][y],board[i][j])) {
				moves.add(board[i][j]);
			}
			}
			i=X+1;
			j=Y-1;
			if(underlimits(i, j)) {
			if(!checkForCheck(board[x][y],board[i][j])) {
				moves.add(board[i][j]);
			}
			}
			i=X-1;
			j=Y-1;
			
			if(underlimits(i, j)) {
			if(!checkForCheck(board[x][y],board[i][j])) {
				moves.add(board[i][j]);
			}
			}
			i=X-1;
			j=Y+1;
			if(underlimits(i, j)) {
			if(!checkForCheck(board[x][y],board[i][j])) {
				moves.add(board[i][j]);
			}
			}
			
			//staright moves
			i=X;
			 j=Y+1;
			if(underlimits(i, j)) {
			if(!checkForCheck(board[x][y],board[i][j])) {
				moves.add(board[i][j]);
			}
			}
			i=X;
			j=Y-1;
			if(underlimits(i, j)) {
			if(!checkForCheck(board[x][y],board[i][j])) {
				moves.add(board[i][j]);
			}
			}
			i=X-1;
			j=Y;
			
			if(underlimits(i, j)) {
			if(!checkForCheck(board[x][y],board[i][j])) {
				moves.add(board[i][j]);
			}
			}
			i=X+1;
			j=Y;
			if(underlimits(i, j)) {
			if(!checkForCheck(board[x][y],board[i][j])) {
				moves.add(board[i][j]);
			}
			}
			
		return moves;
		}
	}

	class Pawn extends Piece{
		public boolean fistMove=true;
		@Override
		
		public void setFirstMove(Boolean b) {
			this.fistMove=b;
		}
		@Override
		public boolean getFirstMove() {
			return fistMove;
		}
		Pawn(int x, int y){
			this.name= "Pawn";
			this.value = 1;
			if(this.getColour()==1) {
				this.icon='\u265f'; 
				this.pathToImage="images/blackPawn.png";
				iconImage = new ImageIcon(getClass().getResource(pathToImage));
			}
			else {
				this.icon= '\u2659';
				this.pathToImage="images/whitePawn.png";
				iconImage = new ImageIcon(getClass().getResource(pathToImage));
				}
			this.x=x;
			this.y=y;
		}
		@Override
		public ArrayList<Board.Square> getMovesWithOutCheck(Board.Square[][] board) {
			ArrayList<Board.Square> moves= new ArrayList<Board.Square>();
			if(this.getColour()==1) {
				int i=x;
				int j=y;
			if(fistMove && underlimits(i+2, j) && board[i+1][j].piece==null && board[i+2][j].piece==null) {
			moves.add(board[i+2][j]);
			}
			i=x;
			j=y;
			if(underlimits(i+1, j)&& board[i+1][j].piece==null) {
					moves.add(board[i+1][j]);
			}
			i=x;
			j=y;
			if(underlimits(i+1, j+1)&& board[i+1][j+1].piece!=null) {
				moves.add(board[i+1][j+1]);
			}
			i=x;
			j=y;
			if(underlimits(i+1, j-1)&& board[i+1][j-1].piece!=null) {
				moves.add(board[i+1][j-1]);
			}
			}
			else {
				int X=x;
				int Y=y;
				int i=x-2;
				int j=y;
				if(fistMove && underlimits(i, j) && board[i][j].piece==null && board[i+1][j].piece==null) {
					moves.add(board[i][j]);
					}
				i=X-1;
				j=Y;
					if(underlimits(i, j)&& board[i][j].piece==null) {
							moves.add(board[i][j]);
					}
					i=X-1;
					j=Y-1;

					if(underlimits(i, j)&& board[i][j].piece!=null) {
						moves.add(board[i][j]);
					}
					i=X-1;
					j=Y+1;

					if(underlimits(i, j)&& board[i][j].piece!=null) {
						moves.add(board[i][j]);
					}
					}				
			return moves;
		}
		@Override
		public ArrayList<Board.Square> getMoves(Board.Square[][] board) {
			ArrayList<Board.Square> moves= new ArrayList<Board.Square>();
			if(this.getColour()==1) {
				int i=x;
				int j=y;
			if(fistMove && underlimits(i+2, j) && board[i+2][j].piece==null && board[i+1][j].piece==null) {
			if(!checkForCheck(board[x][y],board[i+2][j])) {
			moves.add(board[i+2][j]);
			}
			}
			i=x;
			j=y;
			if(underlimits(i+1, j)&& board[i+1][j].piece==null) {
				if(!checkForCheck(board[x][y],board[i+1][j])) {
					moves.add(board[i+1][j]);
			}
			}
			i=x;
			j=y;
			if(underlimits(i+1, j+1)&& board[i+1][j+1].piece!=null) {
				if(!checkForCheck(board[x][y],board[i+1][j+1])) {
				moves.add(board[i+1][j+1]);
			}
			}
			i=x;
			j=y;
			if(underlimits(i+1, j-1)&& board[i+1][j-1].piece!=null) {
				if(!checkForCheck(board[x][y],board[i+1][j-1])) {
				moves.add(board[i+1][j-1]);
			}
			}
			}
			else {
				int X=x;
				int Y=y;
				int i=x-2;
				int j=y;
				if(fistMove && underlimits(i, j) && board[i][j].piece==null && board[i+1][j].piece==null) {
					if(!checkForCheck(board[x][y],board[i][j])) {
					moves.add(board[i][j]);
					}
					}
				i=X-1;
				j=Y;
					if(underlimits(i, j)&& board[i][j].piece==null) {
						if(!checkForCheck(board[x][y],board[i][j])) {
							moves.add(board[i][j]);
					}
					}
					i=X-1;
					j=Y-1;

					if(underlimits(i, j)&& board[i][j].piece!=null) {
						if(!checkForCheck(board[x][y],board[i][j])) {
						moves.add(board[i][j]);
					}
					}
					i=X-1;
					j=Y+1;

					if(underlimits(i, j)&& board[i][j].piece!=null) {
						if(!checkForCheck(board[x][y],board[i][j])) {
						moves.add(board[i][j]);
					}
					}
					}				
			return moves;
		}
}
	Player player;
	int colour;
	Piece rook1;
	Piece bishop1;
	Piece knight1;
	Piece rook2;
	Piece bishop2;
	Piece knight2;
	Piece queen;
	Piece pawn1;
	Piece pawn2;
	Piece pawn3;
	Piece pawn4;
	Piece pawn5;
	Piece pawn6;
	Piece pawn7;
	Piece pawn8;
	Piece king;
	Board board;
	PieceSet(int colour,Board board, Player player){
	this.colour = colour;
	this.board=board;
	this.player=player;
	if(colour==0) {
	this.rook1 = new Rook(0,0);
	this.knight1 = new Knight(0,1);
	this.bishop1 = new Bishop(0,2);
	this.king = new King(0,3);
	this.queen = new Queen(0,4);
	this.bishop2 = new Bishop(0,5);
	this.knight2 = new Knight(0,6);
	this.rook2 = new Rook(0,7);
	this.pawn1 = new Pawn(1,0);
	this.pawn2 = new Pawn(1,1);
	this.pawn3 = new Pawn(1,2);
	this.pawn4 = new Pawn(1,3);
	this.pawn5 = new Pawn(1,4);
	this.pawn6 = new Pawn(1,5);
	this.pawn7 = new Pawn(1,6);
	this.pawn8 = new Pawn(1,7);
	}
	else {
		this.rook1 = new Rook(7,0);
		this.knight1 = new Knight(7,1);
		this.bishop1 = new Bishop(7,2);
		this.king = new King(7,3);
		this.queen = new Queen(7,4);
		this.bishop2 = new Bishop(7,5);
		this.knight2 = new Knight(7,6);
		this.rook2 = new Rook(7,7);
		this.pawn1 = new Pawn(6,0);
		this.pawn2 = new Pawn(6,1);
		this.pawn3 = new Pawn(6,2);
		this.pawn4 = new Pawn(6,3);
		this.pawn5 = new Pawn(6,4);
		this.pawn6 = new Pawn(6,5);
		this.pawn7 = new Pawn(6,6);
		this.pawn8 = new Pawn(6,7);
		}
	this.player.addToPiceseAlive(this.rook1);
	this.player.addToPiceseAlive(this.knight1);
	this.player.addToPiceseAlive(this.bishop1);
	this.player.addToPiceseAlive(this.king);
	this.player.addToPiceseAlive(this.queen);
	this.player.addToPiceseAlive(this.bishop2);
	this.player.addToPiceseAlive(this.knight2);
	this.player.addToPiceseAlive(this.rook2);
	this.player.addToPiceseAlive(this.pawn1);
	this.player.addToPiceseAlive(this.pawn2);
	this.player.addToPiceseAlive(this.pawn3);
	this.player.addToPiceseAlive(this.pawn4);
	this.player.addToPiceseAlive(this.pawn5);
	this.player.addToPiceseAlive(this.pawn6);
	this.player.addToPiceseAlive(this.pawn7);
	this.player.addToPiceseAlive(this.pawn8);
	}
	public Piece CreatePiece(Piece p) {
		Piece piece = new Piece(p);
		return piece;
	}
	public boolean checkForCheck(Board.Square s1,Board.Square s2) {
		boolean IsUnderCheck = board.tempmoveForCheck(s1,s2,this.king);
		
		return IsUnderCheck;
	}
}
