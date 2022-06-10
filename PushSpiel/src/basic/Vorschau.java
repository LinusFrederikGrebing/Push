package basic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import jserver.Board;
import jserver.BoardClickEvent;
import jserver.BoardClickListener;
import jserver.XSendAdapter;
import jserver.XSendAdapterEN;
import plotter.Graphic;

public class Vorschau {
	private static XSendAdapterEN xsend = new XSendAdapterEN();
	private int size = 30;
	
	Spieler x = new Spieler(name1);
	Spieler x2 = new Spieler(name2);
	static String name1 = "Linus";
	static String name2 = "Grebing";
	JLabel labelvn = new JLabel("Spieler1: ");
	JLabel labelnn = new JLabel("Spieler2: ");
	static JTextField vn = new JTextField();
	static JTextField nn = new JTextField();
	static JButton ok = new JButton("ok");
	static JButton einzelspieler = new JButton("Einzelspieler");
	static JButton versus = new JButton("1vs1");
	
	
	public static void main(String[] args) {
		Vorschau simu = new Vorschau();
		simu.start();
		ok.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        name1 = vn.getText();
                name2 = nn.getText();
		    }

	});
		
		einzelspieler.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Spiel spiel = new Spiel();
		    	spiel.start();
		    }
		});
		
		versus.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Spiel spiel = new Spiel();
		    	spiel.startVersus();
		    }
		});
	}
	
	
	private void start() {
		System.out.println("Quiz-Simulator V0.2 April 2021");
		setUpBoard();
		
	}
		private void setUpBoard() {
			Board board = xsend.getBoard();
			Graphic g = board.getGraphic();
		//S	board.addClickListener((BoardClickListener) this);
			board.setSize(800, 400);
			xsend.size(1, 2);
			xsend.forms("none");
			xsend.getBoard().receiveMessage(">>fontsize 80");
			xsend.getBoard().receiveMessage(">>fonttype Dialog");
			xsend.text2(0, 1, "Willkommen zu");
			xsend.text2(0, 0, "Push!");
			g.addBottomComponent(labelvn);
			g.addBottomComponent(vn);
			g.addBottomComponent(labelnn);
			g.addBottomComponent(nn);
			g.addBottomComponent(ok);
			g.addWestComponent(einzelspieler);
			g.addWestComponent(versus);
			g.addBottomComponent(ok);
		}
	
}
