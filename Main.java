import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) {
    // System.out.println("Hello world!");

		Scanner in = new Scanner(System.in);

		// list of users
		ArrayList<Person> users = new ArrayList<Person>();
		
		// list of books
		ArrayList<Book> books = new ArrayList<Book>();

		// Read the files into the books and user arraylists
		// try {
    //   File myFile = new File("booksDB.txt");
		// 	Scanner myReader = new Scanner(myFile);

		// 	// ignore the header
		// 	myReader.nextLine();

		// 	// read the db of books
		// 	while (myReader.hasNextLine()){
		// 		String[] data = myReader.nextLine().split(", ");

		// 		// add book to books
		// 		books.add(new Book(data[0], data[1], data[2], Boolean.parseBoolean(data[5])));
		// 	}
      
    //   myReader.close();
    //   System.out.println("Successfully wrote to the file.");
    // } catch (IOException e) {
    //   System.out.println("An error occurred.");
    //   e.printStackTrace();
    // }

		// make some default books
		books.add(new Book("Harry Potter and the Sorceror's Stone", "J. K. Rowling", "Fantasy", false));
		books.add(new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", "Fantasy", false));
		books.add(new Book("Harry Potter and the Prisoner of Azkaban", "J. K. Rowling", "Fantasy", false));
		books.add(new Book("Harry Potter and the Prisoner of Azkaban", "J. K. Rowling", "Fantasy", false));
		books.add(new Book("Harry Potter and the Prisoner of Azkaban", "J. K. Rowling", "Fantasy", false));



		// Some users
		Person shap = new Person("User","Shapnil","1234");
		Person ek = new Person("Librarian","Eshan","1234");

		users.add(shap);
		users.add(ek);

		// Take out some books
		shap.takeOutBook(books, "Harry Potter and the Sorceror's Stone");
		shap.takeOutBook(books, "Harry Potter and the Chamber of Secrets");
		
		shap.takeOutBook(books, "Harry Potter and the Chamber of Secrets");
		shap.takeOutBook(books, "Harry Potter and the Prisoner of Azkaban");

		System.out.println(shap);


		// Return all books
		// for (int i = 0; i < shap.getBooksTakenOut().size(); i++){
		// 	shap.returnBook(books, shap.getBooksTakenOut().get(i).getId());
		// }


		// Return specific book
		shap.returnBook(books, shap.getBooksTakenOut().get(1).getId());

		
		// librarian adds new book
		ek.addNewBook(books, "Harry Potter and the Goblet of Fire", "J. K. Rowling", "Fantasy", false);
		ek.addNewBook(books, "Percy Jackson and The Lightning Thief", "R.R", "Fantasy", false);
		ek.addNewBook(books, "Percy Jackson and The Sea of Monsters", "R.R", "Fantasy", false);



		// SEARCHING

		// Searching for books
		System.out.println("\n\n");

		String s = "Harry Potter and the Prisoner of Azkaban";
		for (int i = 0; i < books.size(); i++){
			if (books.get(i).getName().equals(s)){
				System.out.println(books.get(i));
			}
		}
		System.out.println("\n\n");

		// Searching for Author
		System.out.println("\n\n");

		String s2 = "R.R";
		for (int i = 0; i < books.size(); i++){
			if (books.get(i).getAuthor().equals(s2)){
				System.out.println(books.get(i));
			}
		}
		System.out.println("\n\n");

		// Searching for Genre
		System.out.println("\n\n");

		String s3 = "Fantasy";
		for (int i = 0; i < books.size(); i++){
			if (books.get(i).getGenre().equals(s3)){
				System.out.println(books.get(i));
			}
		}
		System.out.println("\n\n");


		// SORTING
		
		// Things we can sort: bookNames, most popular, 

		// Sorting names of books using selection sort
		for (int i = 0; i < books.size(); i++){
			Book minBook = books.get(i);
			int ind = i;
			for (int j = i + 1; j < books.size(); j++){
				if (minBook.getName().compareToIgnoreCase(books.get(j).getName()) > 0){
					minBook = books.get(j);
					ind = j;
				}
			}
			if (books.get(i).getName().equals(minBook.getName())){
				continue;
			}
			else{
				Book temp = books.get(i);
				books.set(i, minBook);
				books.set(ind, temp);

			}
		}


		// Printing out all the books
		for (int i = 0; i < books.size(); i++){
			System.out.println(books.get(i));
		}


		// FILE STUFF

		// First, we read the files into the books and user arraylists
		// Then we do all the changes n editting with those arraylists n classes
		// Then we update the files with the new info

		// Update the file with the new info
		try {
      FileWriter myWriter = new FileWriter("booksDB.txt");
			myWriter.write("BookName - Author - Genre - User - ID - OnLoan - DueIn - Popularity\n");
			for (int i = 0; i < books.size(); i++){
				myWriter.write(books.get(i).toString() + "\n");
			}
      
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
		
  }
}