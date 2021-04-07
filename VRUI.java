import java.util.Scanner;

public class VRUI {
	private static Scanner scanner = new Scanner(System.in) ;
	private final VRControl VRControl = new VRControl();

	public static void main(String[] args) {
		VRUI ui = new VRUI() ;

		boolean quit = false ;
		while ( ! quit ) {
			int command = ui.showCommand() ;
			switch ( command ) {
				case 0: quit = true ; break ;
				case 1: ui.listCustomers() ; break ;
				case 2: ui.listVideos() ; break ;
				case 3: ui.registerCustomer() ; break ;
				case 4: ui.registerVideo(); break ;
				case 5: ui.rentVideo() ; break ;
				case 6: ui.returnVideo() ; break ;
				case 7: ui.getCustomerReport() ; break;
				case 8: ui.clearRentals() ; break ;
				case -1: ui.init() ; break ;
				default: break ;
			}
		}
		System.out.println("Bye");
	}

	public void clearRentals() {
		System.out.println("Enter customer name: ");
		String customerName = scanner.next();
		VRControl.clearRentals(customerName);
	}

	public void returnVideo() {
		System.out.println("Enter customer name: ");
		String customerName = scanner.next();
		System.out.println("Enter video title to return: ");
		String videoTitle = scanner.next();
		VRControl.returnVideo(customerName, videoTitle);
	}

	private void init() {
		VRControl.init();
	}

	public void listVideos() {
		VRControl.listVideos();
	}

	public void listCustomers() {
		VRControl.listCustomers();
	}

	public void getCustomerReport() {
		System.out.println("Enter customer name: ");
		String customerName = scanner.next();
		VRControl.getCustomerReport(customerName);
	}

	public void rentVideo() {
		System.out.println("Enter customer name: ");
		String customerName = scanner.next();
		System.out.println("Enter video title to rent: ");
		String videoTitle = scanner.next();
		VRControl.rentVideo(customerName, videoTitle);
	}

	public void registerCustomer() {
		System.out.println("Enter customer name: ");
		String name = scanner.next();
		VRControl.registerCustomer(name);
	}

	public void registerVideo() {

		System.out.println("Enter video title to register: ");
		String title = scanner.next();
		System.out.println("Enter video type( 1 for VHD, 2 for CD, 3 for DVD ):");
		int videoType = scanner.nextInt();
		System.out.println("Enter price code( 1 for Regular, 2 for New Release ):");
		int priceCode = scanner.nextInt();

		VRControl.registerVideo(title, videoType, priceCode);
	}

	public int showCommand() {
		System.out.println("\nSelect a command !");
		System.out.println("\t 0. Quit");
		System.out.println("\t 1. List customers");
		System.out.println("\t 2. List videos");
		System.out.println("\t 3. Register customer");
		System.out.println("\t 4. Register video");
		System.out.println("\t 5. Rent video");
		System.out.println("\t 6. Return video");
		System.out.println("\t 7. Show customer report");
		System.out.println("\t 8. Show customer and clear rentals");

		int command = scanner.nextInt() ;

		return command ;

	}
}
