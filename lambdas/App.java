package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {
		
		ArrayList<Car> stock = create15CarStock();
		
		// 1. Coche amb +100 potencia
		
		System.out.println("--1.1 Coches amb +100 potencia \n");
		
		List<Car> powerCars;
		powerCars = stock.stream().filter(c -> c.getPotencia() > 100).collect(Collectors.toList()); 	

		 for (Car car: powerCars) {
			System.out.println(car.toString()); 
		}
		
		System.out.println("\n--1.2 Coches amb +100 potencia\n"); 
		 
		stock.stream().filter(c -> c.getPotencia() > 100).forEach(System.out::println);
		
		// 2.
		System.out.println("\n--2 Coches de una marca y modelo\n");
		String brand = typeString("In which brand are you interested?");
		
		String model = typeString("And which model?");
		
		List<Car> desiredCars = stock.stream().filter
				(c -> c.getMarca().equalsIgnoreCase(brand) 
			  && c.getModelo().equalsIgnoreCase(model)).collect(Collectors.toList());
		
		for (Car car: desiredCars) {
			System.out.println(car.toString()); 
		} 
		
		// 3. Media caballos de todos los coches
		System.out.println("\n--3 Media caballos de todos los coches\n"); 
		double averagePower = stock.stream()
                .mapToInt(Car::getPotencia)		// same as c -> c.getPotencia()
                .average()  					// Returns OptionalDouble
                .orElse(0);

		System.out.println("The average power of all cars is: " + averagePower);
		
		// 4. Cantidad de coches de una marca en concreto
		System.out.println("\n--4 Cantidad de coches de una marca en concreto\n"); 
		String brand1 = typeString("In which brand are you interested?");
		
		long count = stock.stream().filter(c -> c.getMarca().equalsIgnoreCase(brand1)).count();				

		System.out.println("The number of " + brand + " cars is: " + count);
		
		// 5. Todos los coches diferentes de una marca:
		System.out.println("\n--5 Todos los coches diferentes de una marca\n"); 
		 
		stock.stream()
		 	.filter(c -> c.getMarca().equals(brand1))			
	        .collect(Collectors.groupingBy(Car::getModelo))	 //Groups the cars with the same model name into a single entry in a Map key -> model name, value -> list of cars
	        .forEach((modelo, cars) -> { 					// Iterates over the map
	        	if (cars.size() > 1) {						// Condition to check duplicates
	        		System.out.println(cars.get(0));
	        	} else {
	        	System.out.println(cars); 
	        	}
	        });
		
		
		// 6. Primer Coche de una Marca
		System.out.println("\n--6 Primer Coche de una Marca\n"); 
		stock.stream()
	    .collect(Collectors.groupingBy(Car::getMarca))
	    .forEach((marca, cars) -> System.out.println(cars.get(0)));
		
		
		// 7. Último coche de una Marca
		System.out.println("\n--7 Último Coche de una Marca\n");    
		stock.stream()
	    .collect(Collectors.groupingBy(Car::getMarca))
	    .forEach((marca, cars) -> System.out.println(cars.get(cars.size()-1)));
	        	
	        

		
			
	}
	
	
	
	public static ArrayList<Car> create15CarStock() {
		ArrayList<Car> stock = new ArrayList<>();
		Car car1 = new Car("Pegueot", "206", 4, 110);
		Car car2 = new Car("Pegueot", "106", 4, 80);
		Car car3 = new Car("Audi", "A1", 4, 150);
		Car car4 = new Car("Audi", "A4", 4, 160);
		Car car5 = new Car("Audi", "A7", 6, 180);
		Car car6 = new Car("Audi", "A8", 6, 190);
		Car car7 = new Car("Renault", "Megane", 4, 115);
		Car car8 = new Car("Renault", "Clio", 4, 90);
		Car car9 = new Car("Renault", "Captur", 4, 80);
		Car car10 = new Car("Seat", "Leon", 6, 110);
		Car car11 = new Car("Seat", "Ibiza", 6, 96);
		Car car12 = new Car("Seat", "Leon", 6, 110);
		Car car13 = new Car("Porsche", "Cayenne", 8, 600);
		Car car14 = new Car("Ford", "Focus", 4, 85);
		Car car15 = new Car("Ford", "Fiesta", 6, 140);
		
		stock.addAll(Arrays.asList(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, car11, car12, car13, car14, car15));
		
		return stock;
	}
	
	static String typeString(String mensaje) {
	    Scanner input = new Scanner(System.in);
		System.out.println(mensaje);
		String sentence = input.nextLine();
		return sentence;
	}
	
	
	
	/* ---------------Explicacions per mi: -------------
	 * 
	 * Method Reference:
	 * The toString method is being called because the forEach method requires an 
	 * argument of type Consumer, which is a functional interface that defines a 
	 * single abstract method called accept that takes an object of a specified 
	 * type and returns no result. The implementation of the accept method determines
	 * the action that will be performed for each element in the stream. 
	 * In this case, the implementation is the System.out.println method reference, 
	 * which will print the result of the toString method of each car in the stream.
	 * The toString method is being called because it is the default implementation 
	 * in the Object class, which is the parent class of all classes in Java, and it 
	 * provides a string representation of an object, which is what is being printed 
	 * by the println method in this case.*/ 

}
