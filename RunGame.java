

//import javax.swing.JOptionPane;

import java.util.Scanner;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class RunGame {
    public static void main(Bank bank) {
		Scanner scan = new Scanner(System.in);

		String[] frontFileNames = { "can.jpg", "flopsy_mopsy_cottontail.jpg", "friends.jpg", "mother_ladybird.jpg",
		"mr_mcgregor.jpg", "mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };

		MatrixBoard mb = new MatrixBoard(4, "back.jpg", frontFileNames);
		GameManager gm = new GameManager(mb);
	

		System.out.println("Ange ditt kontonummer");
		int accountNumber = scan.nextInt();
		BankAccount player = bank.findByNumber(accountNumber);
		System.out.println(player);

		

		int tries = 0;
		while(!mb.hasWon()){

			gm.drawBoard();
			int r1;
			int c1;
			int r2;
			int c2;

			gm.waitForMouseClick();
			r1 = gm.getMouseRow();
			c1 = gm.getMouseCol();

			while(mb.isRevealed(r1, c1)){
				gm.waitForMouseClick();
				r1 = gm.getMouseRow();
				c1 = gm.getMouseCol();
			}
			mb.turnCard(r1, c1);
			gm.drawBoard();

			gm.waitForMouseClick();
			r2 = gm.getMouseRow();
			c2 = gm.getMouseCol();

			while(mb.isRevealed(r2, c2) == true){
				gm.waitForMouseClick();
				r2 = gm.getMouseRow();
				c2 = gm.getMouseCol();
			}

			mb.turnCard(r2, c2);
			gm.drawBoard();
			gm.delay(500);

			if(mb.same(r1, c1, r2, c2) == false){
				mb.turnCard(r1, c1);
				mb.turnCard(r2, c2);
				gm.drawBoard();
				tries++;
			} else if(mb.same(r1, c1, r2, c2) == true && mb.hasWon()){
				tries++;
				JOptionPane.showMessageDialog(null, "Dina försök: " + tries, "BankSpel",
						JOptionPane.INFORMATION_MESSAGE);
			} else{
				tries++;
			}

		}
		double sum = 0;
		if (tries <= 20) {
			sum = 100;
		}
		player.deposit(sum);
	}

	
}
