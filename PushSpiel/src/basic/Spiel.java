package basic;

import jserver.Board;
import jserver.BoardClickEvent;
import jserver.BoardClickListener;
import jserver.XSendAdapterEN;

public class Spiel implements BoardClickListener {
	public static boolean t = false;
	static XSendAdapterEN xsend = new XSendAdapterEN();
	static int size = 6;
	private static int spieler = 1;
	Spieler schwarz = new Spieler("Linus Grebing");
	Spieler weiﬂ = new Spieler("Nils Paul");

	public void startVersus() {
		System.out.println("Quiz-Simulator V0.2 April 2021");
		setUpBoard();
		Spielfeld.setUpOnlyBoard();
		 t = true;
		
	}
	
	public void start() {
		System.out.println("Quiz-Simulator V0.2 April 2021");
		setUpBoard();
		Spielfeld.setUpOnlyBoard();

	}

	private void setUpBoard() {
		Board board = xsend.getBoard();
		board.addClickListener(this);
		board.setSize(800, 800);
		xsend.size(size, size);
		xsend.colors(0xb9b9b9);
		xsend.form2(0, 0, "none");
	}

	@Override
	public void boardClick(BoardClickEvent info) {
		new Thread() {
			@Override
			public void run() {

				int xPos = info.getX();
				int yPos = info.getY();

				for (int i = 1; i < size; i++) {
					if (yPos == i && xPos == 0) {

						Schieber.sleep(yPos, xPos, spieler);

						Schieber.schieberX(spieler, yPos, Spielfeld.sf);
					if(Spiel.t == true) {
						if (spieler == 1) {
							xsend.statusText("Weiﬂ, du bist an der Reihe! " + " Spieler: " + weiﬂ.getName());
						} else {
							xsend.statusText("Schwarz, du bist an der Reihe! " + " Spieler: " + schwarz.getName());
						}
					} if (spieler == 1){ spieler = 0; } else if(spieler == 0){ spieler = 1;}
					}

					if (xPos == i && yPos == 0) {
						Schieber.sleep(yPos, xPos, spieler);
						Schieber.schieberY(spieler, xPos, Spielfeld.sf);
						
						if(Spiel.t == true) {
						if (spieler == 1) {
							xsend.statusText("Weiﬂ, du bist an der Reihe! " + " Spieler: " + weiﬂ.getName());
						
						} else {
							xsend.statusText("Schwarz, du bist an der Reihe! " + " Spieler: " + schwarz.getName());
		
						}
						}
						if (spieler == 1){ spieler = 0; } else if(spieler == 0){ spieler = 1;}
					}
			 }
				}
			

		}.start();

	}
}
