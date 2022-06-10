package basic;

public class Spielfeld {
	
	static int sf[][] = { { 1, 0, 1, 0, 1 }, 
						{ 0, 1, 0, 1, 0 },
						{ 1, 0, 1, 0, 1 }, 
						{ 0, 1, 0, 1, 0 },
						{ 1, 0, 1, 0, 1 } };

	
	public static void setUpOnlyBoard() {
		for (int x = 1; x < Spiel.size; x++) {
			for (int y = 1; y < Spiel.size; y++) {
				if (sf[x - 1][y - 1] == 1) {
					Spiel.xsend.color2(x, y, 1);
				}
				if (sf[x - 1][y - 1] == 0) {
					Spiel.xsend.color2(x, y, 0xFFFFFF);
				}
			}

		}
		if (Spiel.t == true) { Sieg.sieger(sf); }
	}


}
