import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static Scanner scan = new Scanner (System.in);
	public static Random rand = new Random();
	public static ArrayList<Route> route = new ArrayList<>();
	
	public static void insert () {
		
		String Destination = null, ID = null;
		int Distance = 0;
		
		do {
			System.out.println("Input route destination [Jakarta | Bogor | Depok | Tangerang | Bekasi] (case sensitive): ");
			try {
				Destination = scan.nextLine();
			} catch (Exception e) {
				System.out.println("Error");
			}
		} while (!Destination.equals("Jakarta") && !Destination.equals("Bogor") && !Destination.equals("Depok") 
				&& !Destination.equals("Tangerang") && !Destination.equals("Bekasi"));	
		
		do {
			System.out.println("Input route distance [1...1000]: ");
			try {
				Distance = scan.nextInt(); scan.nextLine();
			} catch (Exception e) {
				System.out.println("Error");
				scan.nextLine();
			} 
		} while (!(Distance >= 1) || !(Distance <= 1000));
			
		ID = "BJ" + rand.nextInt(1000);
	
		Route rt = new Route();
		rt.Destination = Destination;
		rt.Distance = Distance;
		rt.ID = ID;
		route.add(rt);
		
		System.out.println("Succesfully added new route!");
		System.out.println("Press Enter to continue...");
		scan.nextLine(); // biar enter baru continue
	}
	
	public static void view() {
		if (route.isEmpty()) {
			System.out.println("There are no routes available.");
			System.out.println("Press Enter to continue...");
			scan.nextLine();
		} else {
			System.out.println("==========================================================");
			System.out.println("|  ID  |        To        |  Distance  |      Price      |");
			
			for(int i = 0; i < route.size(); i++) {
				int Price = ((route.get(i).Distance / 2 * 100) + 10000);
				System.out.println("| " + route.get(i).ID + "|      " + route.get(i).Destination + "     |    " 
				+ route.get(i).Distance + "      | Rp. " + Price + "       |");
			}
			System.out.println("==========================================================");
			System.out.println("Press Enter to continue...");
			scan.nextLine();
		}
	}
	
	public static void update() {
		if (route.isEmpty()) {
			System.out.println("There are no routes available.");
			System.out.println("Press Enter to continue...");
			scan.nextLine();
		} else {
			System.out.println("==========================================================");
			System.out.println("|  ID  |        To        |  Distance  |      Price      |");
			
			for(int i = 0; i < route.size(); i++) {
				int Price = ((route.get(i).Distance / 2 * 100) + 10000);
				System.out.println("| " + route.get(i).ID + "|      " + route.get(i).Destination + "     |    " 
				+ route.get(i).Distance + "      | Rp. " + Price + "       |");
			}
			System.out.println("==========================================================");
			System.out.println(" ");
			
			String tempID = null;
			
			System.out.println("Input Route ID to update: ");
			tempID = scan.nextLine();
				
			for (Route r : route) {
				if(r.ID.equals(tempID)) {
					
					String tempDestination = null;
					
					do {
						System.out.println("Input new destination [Jakarta | Bogor | Depok | Tangerang | Bekasi] (case sensitive): ");
						try {
							tempDestination = scan.nextLine();
						} catch (Exception e) {
							System.out.println("Error");
						}
					} while (!tempDestination.equals("Jakarta") && !tempDestination.equals("Bogor") && !tempDestination.equals("Depok") 
							&& !tempDestination.equals("Tangerang") && !tempDestination.equals("Bekasi"));	
					
					r.Destination = tempDestination;
					
					int tempDistance = 0;
					
					do {
						System.out.println("Input new distance [1...1000]: ");
						try {
							tempDistance = scan.nextInt(); scan.nextLine();
						} catch (Exception e) {
							System.out.println("Error");
						} 
					} while (!(tempDistance >= 1) || !(tempDistance <= 1000));
					
					r.Distance = tempDistance;
					
					System.out.println("Succesfully updated Route " + tempID +"!");
					System.out.println("Press Enter to continue...");
					scan.nextLine();
					
				} else {
					System.out.println("Route ID is invalid!");
					System.out.println("Press Enter to continue...");
					scan.nextLine();
				}
			}
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 0;
		
		do {
			System.out.println("BlueJack Station");
			System.out.println("================");
			System.out.println("1. Insert route");
			System.out.println("2. View routes");
			System.out.println("3. Update route");
			System.out.println("4. Exit");
			System.out.print(">> ");
			
			input = scan.nextInt(); scan.nextLine();
			
			switch(input) {
			case 1:
				insert();
				break;
			case 2 :
				view();
				break;
			case 3 :
				update();
				break;
			}
		}while (input != 4);
	}
}


