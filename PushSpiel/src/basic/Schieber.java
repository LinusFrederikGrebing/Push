package basic;

import plotter.Sleep;

public class Schieber {
	
	public static void schieberX(int spieler, int ypos, int[][] sf) {
		int[] wert = new int[sf.length];
		wert[0] = spieler;
		
		for (int i = 0; i < sf.length - 1; i++) {
			
			wert[i + 1] = sf[i][ypos - 1];
			System.out.println(sf[i][ypos - 1]);
		}
		for (int j = 0; j < sf.length; j++) {
			
			sf[j][ypos - 1] = wert[j];
		}
		
		Spielfeld.setUpOnlyBoard(); 
	}

	public static void schieberY(int test, int xpos, int[][] sf) {
		int[] wert = new int[sf.length];
		wert[0] = test;

		for (int i = 0; i < sf.length - 1; i++) {
			wert[i + 1] = sf[xpos - 1][i];
		}
		for (int i = 0; i < sf.length; i++) {
			sf[xpos - 1][i] = wert[i];
		}
		
		 Spielfeld.setUpOnlyBoard(); 
	}
	
	public static void sleep(int y, int x, int spieler) {					// Farbwechsel schwarz

		if(spieler == 1) {
			Spiel.xsend.color2(x, y, 0x000000);
			Sleep.sleep(300);
			Spiel.xsend.color2(x, y, 0xb9b9b9);
		} else {
			Spiel.xsend.color2(x, y, 0xFFFFFF);
			Sleep.sleep(300);
			Spiel.xsend.color2(x, y, 0xb9b9b9);
		}
		
	}
	
}
