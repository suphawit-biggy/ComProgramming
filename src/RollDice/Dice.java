package RollDice;
//Suphawit  Kasemsirisopha ,572115056

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		boolean error = false;
		int F = 0, B = 0, L = 0, R = 0, Bot = 0, T = 0;
		String rotate = null;
		System.out.println("Set the number of dices (1-6 and unique).");

		do {
			System.out.print("Top : ");
			try {
				T = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(" Invalid Arguments.");
				String er = scan.next();
			}
			if (T < 1 || T > 6)
				System.out.println("(1-6 and unique)");
		} while (T < 1 || T > 6);

		do {
			System.out.print("Bottom : ");
			try {
				Bot = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(" Invalid Arguments.");
				String er = scan.next();
			}
			if (Bot < 1 || Bot > 6 || Bot == T)
				System.out.println("(1-6 and unique)");
		} while (Bot < 1 || Bot > 6 || Bot == T);

		do {
			System.out.print("Left : ");
			try {
				L = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(" Invalid Arguments.");
				String er = scan.next();
			}
			if (L < 1 || L > 6 || L == T || L == Bot)
				System.out.println("(1-6 and unique)");
		} while (L < 1 || L > 6 || L == T || L == Bot);

		do {
			System.out.print("Right : ");
			try {
				R = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(" Invalid Arguments.");
				String er = scan.next();
			}
			if (R < 1 || R > 6 || R == T || R == Bot || R == L)
				System.out.println("(1-6 and unique)");
		} while (R < 1 || R > 6 || R == T || R == Bot || R == L);

		do {
			System.out.print("Front : ");
			try {
				F = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(" Invalid Arguments.");
				String er = scan.next();
			}
			if (F < 1 || F > 6 || F == T || F == Bot || F == L || F == R)
				System.out.println("(1-6 and unique)");
		} while (F < 1 || F > 6 || F == T || F == Bot || F == L || F == R);

		do {
			System.out.print("Back : ");
			try {
				B = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(" Invalid Arguments.");
				String er = scan.next();
			}
			if (B < 1 || B > 6 || B == T || B == Bot || B == L || B == R || B == F)
				System.out.println("(1-6 and unique)");
		} while (B < 1 || B > 6 || B == T || B == Bot || B == L || B == R || B == F);

		System.out.println("|Top\t|Bottom\t|Left\t|Right\t|Front\t|Back");
		System.out.println("|" + T + "\t|" + Bot + "\t|" + L + "\t|" + R + "\t|" + F + "\t|" + B);

		int temp = 0;

		do {
			System.out.println("Input sequence of the rotation.");
			System.out.println("(F)orward,(B)ackward,(L)eft,(R)ight,(C)lockwise and (D)Counter-Clockwise");
			do {
				System.out.print("ex. L , FBC : ");
				rotate = scan.next();
				for (int i = 0; i < rotate.length(); i++) {
					String str = String.valueOf(rotate.charAt(i));
					if (str.equals("F") || str.equals("B") || str.equals("L") || str.equals("R") || str.equals("C")
							|| str.equals("D"))
						error = true;
				}
			} while (error == false);

			for (int i = 0; i < rotate.length(); i++) {
				String str = String.valueOf(rotate.charAt(i));
				if (str.equals("F")) {
					temp = T;
					T = B;
					B = Bot;
					Bot = F;
					F = temp;
				} else if (str.equals("B")) {
					temp = T;
					T = F;
					F = Bot;
					Bot = B;
					B = temp;
				} else if (str.equals("L")) {
					temp = T;
					T = R;
					R = Bot;
					Bot = L;
					L = temp;
				} else if (str.equals("R")) {
					temp = T;
					T = L;
					L = Bot;
					Bot = R;
					R = temp;
				} else if (str.equals("C")) {
					temp = B;
					B = L;
					L = F;
					F = R;
					R = temp;
				} else if (str.equals("D")) {
					temp = B;
					B = R;
					R = F;
					F = L;
					L = temp;
				}
			}
			System.out.println("|Top\t|Bottom\t|Left\t|Right\t|Front\t|Back");
			System.out.println("|" + T + "\t|" + Bot + "\t|" + L + "\t|" + R + "\t|" + F + "\t|" + B);
			System.out.println();
			System.out.println();
		} while (true);
	}
}