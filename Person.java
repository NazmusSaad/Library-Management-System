import java.util.*;

class Person{
	private String role;
	private String name;
	private int id;
	private String pass;
	private ArrayList<Book> booksTakenOut = new ArrayList<Book>();  

	private static int pplCount = 0;   // this is the num of ppl


	public Person(String role, String name, String pass){
		this.role = role;
		this.name = name;
		this.pass = pass;
		pplCount++;
		this.id = pplCount;
	}

	// getters

	public ArrayList<Book> getBooksTakenOut(){
		return this.booksTakenOut;
	}


	// helpers

	public void returnBook(ArrayList<Book> books, int bookId){
		for (int i = 0; i < books.size(); i++){
			if (books.get(i).getId() == bookId){
				books.get(i).setOnloan(false);
				books.get(i).setUser("n/a");

			}
		}
	}

	
	public void takeOutBook(ArrayList<Book> books, String bookName){
		boolean success = false;
		for (int i = 0; i < books.size(); i++){
			
			// check if book exists and if its available
			if (books.get(i).getName().equals(bookName) && books.get(i).getStatus() == false){

				// set the book to onloan
				books.get(i).setOnloan(true);

				// set who has the book
				books.get(i).setUser(this.name);

				// increase popularity
				books.get(i).setPop();

				// add the book to users list
				booksTakenOut.add(books.get(i));
				
				success = true;
				break;  //need to break so we dont take out all of the other books with the same name
			}
		}
		// error check
		if (success == false){
			System.out.println("Sorry, the book does not exist or is already taken out.");
		}
	}

	public void addNewBook(ArrayList<Book> books, String bookName, String authorName, String genre, boolean onloan){
		if (this.role.equals("User")){
			System.out.print("Only For Librarians");
		}
		books.add(new Book(bookName, authorName, genre, onloan));
	}

	public String toString(){
		return this.name + ": " + booksTakenOut;
	}
}