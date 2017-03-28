package CustommerBill;

import java.util.Scanner;

public class CustomerBill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int desktop, laptop, mobile, tablet, phablet, Swatch;
		System.out.print("Quantity of Desktop = ");
		desktop = scanner.nextInt();
		System.out.print("Quantity of Laptop = ");
		laptop = scanner.nextInt();
		System.out.print("Quantity of Mooblie Phone = ");
		mobile = scanner.nextInt();
		System.out.print("Quantity of Tablet = ");
		tablet = scanner.nextInt();
		System.out.print("Quantity of Phablet = ");
		phablet = scanner.nextInt();
		System.out.print("Quantity of Smart Watch = ");
		Swatch = scanner.nextInt();
		double PriceDesktop = 400.00;
		double PriceLaptop = 550.50;
		double PriceMobile = 150.50;
		double PriceTablet = 250.00;
		double PricePhablet = 350.50;
		double PriceSwatch = 100.00;
		double TotalPrice = ((desktop * PriceDesktop) + (laptop * PriceLaptop) + (mobile * PriceMobile)
				+ (tablet * PriceTablet) + (phablet * PricePhablet) + (Swatch * PriceSwatch));
		double Tax = TotalPrice * (8.5 / 100);
		System.out.print("Enter the amount of money = ");
		double money = scanner.nextDouble();
		double Change = money - (TotalPrice + Tax);
		System.out.println("-------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("List\t\tQuantity\tUnit Price\tPrice\tTotal Ptice");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Desktop\t\t" + desktop + "\t\t" + PriceDesktop + "\t\t" + (desktop * PriceDesktop) + "\t"
				+ (desktop * PriceDesktop));
		System.out.println("Laptop\t\t" + laptop + "\t\t" + PriceLaptop + "\t\t" + (laptop * PriceLaptop) + "\t"
				+ ((desktop * PriceDesktop) + (laptop * PriceLaptop)));
		System.out.println("Moblie Phone\t" + mobile + "\t\t" + PriceMobile + "\t\t" + (mobile * PriceMobile) + "\t"
				+ ((desktop * PriceDesktop) + (laptop * PriceLaptop) + (mobile * PriceMobile)));
		System.out.println("Tablet\t\t" + tablet + "\t\t" + PriceTablet + "\t\t" + (tablet * PriceTablet) + "\t"
				+ ((desktop * PriceDesktop) + (laptop * PriceLaptop) + (mobile * PriceMobile)
						+ (tablet * PriceTablet)));
		System.out.println("Phablet\t\t" + phablet + "\t\t" + PricePhablet + "\t\t" + (phablet * PricePhablet) + "\t"
				+ ((desktop * PriceDesktop) + (laptop * PriceLaptop) + (mobile * PriceMobile) + (tablet * PriceTablet)
						+ (phablet * PricePhablet)));
		System.out.println("Smart Watch\t" + Swatch + "\t\t" + PriceSwatch + "\t\t" + (Swatch * PriceSwatch) + "\t"
				+ ((desktop * PriceDesktop) + (laptop * PriceLaptop) + (mobile * PriceMobile) + (tablet * PriceTablet)
						+ (phablet * PricePhablet) + (Swatch * PriceSwatch)));
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Total Price\t\t\t" + TotalPrice);
		System.out.println("Tax\t\t\t\t" + Tax);
		System.out.println("Change\t\t\t\t" + Change);
		System.out.println("-------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------");
	}

}