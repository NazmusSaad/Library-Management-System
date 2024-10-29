class Book{
	private String name;
	private String author;
	private String genre;
	private String user;
	private int id;
	private boolean onloan;
	private int dueIn;
	private int popularity;	
	private static int bookCount = 0;

	public Book(String name, String author, String genre, boolean onloan){
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.user = "n/a";
		this.onloan = onloan;
		bookCount++;
		this.id = bookCount;
		this.dueIn = 21;
		this.popularity = 0;
	}

	// getters

	public String getName(){
		return this.name;
	}

	public String getAuthor(){
		return this.author;
	}

	public String getGenre(){
		return this.genre;
	}

	public int getId(){
		return this.id;
	}

	public boolean getStatus(){
		return this.onloan;
	}


	// Setter

	public void setOnloan(boolean b){
		this.onloan = b;
	}

	public void setUser(String s){
		this.user = s;
	}

	public void setPop(){
		this.popularity++;
	}

	// toString
	public String toString(){
		return name + ", " + author + ", " + genre + ", " + user + ", " + onloan + ", " + id + ", " + dueIn + ", " + popularity;
	}

}