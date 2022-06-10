package basic;

public class Sieg {
	
	public static void sieger(int[][] sf) {
		for(int i = 1; i < sf.length-1; i++) {
			for(int j = 1; j < sf.length-1; j++) {
				if(sf[i][j]==1 && sf[i-1][j]==1 && sf[i+1][j]==1 && sf[i][j-1]==1 && sf[i-1][j-1]==1 && sf[i+1][j-1]==1 && sf[i][j+1]==1 && sf[i-1][j+1]==1 && sf[i+1][j+1]==1) {
					Spiel.xsend.forms("none");
					Spiel.xsend.size(1, 2);
					Spiel.xsend.getBoard().receiveMessage(">>fontsize 80");
					Spiel.xsend.getBoard().receiveMessage(">>fonttype Dialog");
					Spiel.xsend.text2(0, 1, "Schwarz hat");
					Spiel.xsend.text2(0, 0, "gewonnen!");
				}
				if(sf[i][j]==0 && sf[i-1][j]==0 && sf[i+1][j]==0 && sf[i][j-1]==0 && sf[i-1][j-1]==0 && sf[i+1][j-1]==0 && sf[i][j+1]==0 && sf[i-1][j+1]==0 && sf[i+1][j+1]==0) {
					Spiel.xsend.forms("none");
					Spiel.xsend.size(1, 2);
					Spiel.xsend.getBoard().receiveMessage(">>fontsize 80");
					Spiel.xsend.getBoard().receiveMessage(">>fonttype Dialog");
					Spiel.xsend.text2(0, 1, "Weiﬂ hat");
					Spiel.xsend.text2(0, 0, "gewonnen!");
				}
			}
			
		}
		
		
	}
}
