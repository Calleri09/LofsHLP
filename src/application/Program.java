package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.enums.OrderStatus;
import entitiess.Client;
import entitiess.Order;
import entitiess.OrderItem;
import entitiess.Product;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data:");
		
		System.out.println("Name: ");
		String NameClient = sc.nextLine();
		System.out.println("Email: ");
		String EmailClient = sc.nextLine();
		System.out.println("Birth date (DD/MM/YYYY): ");
		Date BirthDate = sdf.parse(sc.next());
		
		System.out.println("Enter order data:");
		
		System.out.print("Status: ");
		String StatusOrder = sc.next();
		System.out.print("");
		
		Order order = new Order (new Date(), OrderStatus.valueOf(StatusOrder), new Client (NameClient, EmailClient, BirthDate));
		
		System.out.println("How many items to this order? ");
		int items = sc.nextInt();
		
		for (int i = 1; i <= items; i++) {
			System.out.println("Enter #" + i + " " + "Item data");
			System.out.println("Product name: ");
			String ProductName = sc.next();
			System.out.println("Product price: ");
			Double ProductPrice = sc.nextDouble();
			System.out.println("Quantity: ");
			Integer Quantity = sc.nextInt();
			OrderItem orderItem = new OrderItem (Quantity, ProductPrice, new Product(ProductName, ProductPrice));
			order.addItem(orderItem);
		}
		
		System.out.println("ORDER SUMMARY: ");
		System.out.println("Order moment: " + order.getMomento());
		System.out.println("Order status: " + order.getStatus());
		System.out.println("Client: " + NameClient + "(" + BirthDate + ")" + "-" + EmailClient);
		System.out.println("Order Items: ");
		for (OrderItem c : order.getItem()) {
			System.out.println(c);
		}
		System.out.println("Total Price: " + "$" + order.total());
		
	}

}
