import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Test {
	
	public static void main(String[] args) {
		ComparatorByCode c = new ComparatorByCode();
		OrderedArrayList<Country> countries = new OrderedArrayList<Country>(250, c);
		readCountriesFromFile(countries, "countries.txt");
		
		Scanner scan = new Scanner(System.in);
		int operation = 0;
		do {
			printMenu();
			operation = scan.nextInt();
			switch(operation) {
			case 1:
				//View list of countries
				System.out.println("Code: \t\t\t\t\t   Name\t\t\t   Capital\t     Area");
				System.out.println();
				System.out.println(countries.toString());
				break;
			case 2:
				//Search for a country
				System.out.println("Enter the name of your country.");
				scan.nextLine();
				String n = scan.nextLine();
				Country cc = countries.find(new Country("",n,"",0.0));
				if(cc == null) {
					System.out.println("Country not found");
				} else {
					System.out.println(cc.toString());
				}
				
				break;
			case 3:
				//Remove a country
				System.out.println("Enter the name of your country.");
				scan.nextLine();
				String n2 = scan.nextLine();
				if(countries.remove(new Country("",n2,"",0.0))) {
					System.out.println("Country removed.");
				} else {
					System.out.println("Country not found");
				}
				break;
			case 4:
				//Sort countries by area
				ComparatorByArea cArea = new ComparatorByArea();
				countries.setComparator(cArea);
				System.out.println("The list has been sorted by area");
				break;
			case 5:
				//Sort countries by code
				ComparatorByCode cCode = new ComparatorByCode();
				countries.setComparator(cCode);
				System.out.println("The list has been sorted by code");
				break;
			case 6:
				//Sort countries by name
				ComparatorByName cName = new ComparatorByName();
				countries.setComparator(cName);
				System.out.println("This list has been sorted by name");
				break;
			case 7:
				//Exit
				System.out.println("Thank you for using my program");
				System.exit(0);
				break;
			}
		} while(operation != 7);
		
	}
	
	public static void printMenu() {
		System.out.println("1) View list of countries");
		System.out.println("2) Search for a country");
		System.out.println("3) Remove a country");
		System.out.println("4) Sort the countries by area");
		System.out.println("5) Sort the countries by code");
		System.out.println("6) Sort the countries by name");
		System.out.println("7) Exit");
	}
	
	public static void readCountriesFromFile(OrderedArrayList<Country> list, String filename) {
		File file = new File(filename);
		try {
			Scanner readFile = new Scanner(file);
			while(readFile.hasNextLine()) {
				String line = readFile.nextLine();
				String[] tokens = line.split("\\|");
				String code = tokens[0];
				String name = tokens[1];
				String capital = tokens[2];
				double area = Double.parseDouble(tokens[3]);
				
				Country c = new Country(code, name, capital, area);
				list.insert(c);
			}
		} catch(FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
	}
}