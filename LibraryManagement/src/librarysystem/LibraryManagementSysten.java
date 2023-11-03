package librarysystem;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
class User{
	String name;
	String email; //in this application I am not considering email for validation of login
	String password;
	String role;
	int deposit;
	int fine;
	int fineLimit;
	Map<String,LocalDate> borrowedBooks;
	User(String name,String email,String password,String role){
		this.name=name;
		this.email=email;
		this.password=password;
		this.role=role;
		this.deposit=1500;
		this.borrowedBooks=new HashMap<>();
		this.fine=0;
	    this.fineLimit=100;
	}

	void addBook(String bookName){
		LocalDate currentDate = LocalDate.now();
		borrowedBooks.put(bookName,currentDate);
}
}
class Book{
	String bookName;
	String ISBN;
	int quantity;
	int price;
	Book(String bookName,String ISBN,int quantity,int price){
		this.bookName=bookName;
		this.ISBN=ISBN;
		this.quantity=quantity;
		this.price=price;
	}
}
public class LibraryManagementSysten {
   
	public static void main(String args[]) {
   List<User> users=new ArrayList<>();
   List<Book> books=new ArrayList<>();
   List<Book> currentCart=new ArrayList<>();
   users.add(new User("SANJAY","20CS148@kpriet.ac.in","12345678","ADMIN"));
   users.add(new User("KPR","20CS100@kpriet.ac.in","12345678","ADMIN"));
   users.add(new User("RAJ","20ME123@kpriet.ac.in","12345678","BORROWER"));
   books.add(new Book("english","ENG123",5,124));
   books.add(new Book("maths","MAT123",5,288));
   books.add(new Book("science","SCI123",5,299));
   books.add(new Book("tamil","TAM123",5,899));

   
   Scanner sc=new Scanner(System.in);
   System.out.println("============== WELCOME TO KPR LIBRARY ================");
   System.out.println();
   System.out.println("Enter your username  and  password :");
   String userName=sc.nextLine();
   String userPassword=sc.next();
   
   boolean isAdmin=false;
   
   User currentUser=null;
		   
   for(User user:users) {
	   if(user.name.equals(userName) && user.password.equals(userPassword)) {
		   currentUser=user;
	   }
   }
   if (currentUser != null) {
	    if (currentUser.role.equals("ADMIN")) {
	        isAdmin = true;
	    }
   }
   if(currentUser==null) {
	   System.out.println("INVALID USER-NAME OR PASSWORD !!!");
	   System.out.println("TRY AGAIN OR IF YOU ARE A NEW USER CONTACT THE ADMIN");
   }
   if(currentUser!=null) {
	   boolean actionComplete=true;
	   while(actionComplete) {
	   if(isAdmin) {
		   System.out.println("========= WELCOME ADMIN " + currentUser.name + "==========");
           System.out.println("1 - ADD A NEW ADMIN");
           System.out.println("2 - ADD A NEW BORROWER");
           System.out.println("3 - SEARCH FOR A BOOK");
           System.out.println("4 - ADD A BOOK");
           System.out.println("5 - MODIFY BOOK DETAILS");
           System.out.println("6 - DELETE A BOOK");
           System.out.println("7 - VIEW BOOKS SORTED BY NAME OR QUANTITY");
           System.out.println("8 - MANAGE BORROWERS' FINE LIMIT");
           System.out.println("9 - REPORT OF STUDENTS WITH FINE");
           System.out.println("10 - EXIT");
           System.out.println("PLEASE ENTER THE ACTION YOU WOULD LIKE TO PERFORM: ");
           int action = sc.nextInt();
		   switch(action) {
		   case 1:{
			   System.out.println("====== ENTER THE CREDENTIALS OF THE NEW ADMIN ==========");
			   System.out.print("ENTER THE NAME OF THE NEW ADMIN: ");
			   String adminName=sc.next();
			   System.out.print("ENTER THE EMAIL ID: ");
			   String adminEmail=sc.next();
			   System.out.println("ENTER THE PASSWORD: ");
			   String adminUserPassword=sc.next();
			   String role="ADMIN";
			   users.add(new User(adminName,adminEmail,adminUserPassword,role));
			  System.out.println("========= NEW ADMIN "+adminName+" HAS BEEN SUCCESSULLY ADDED ==========");
			  break;
		   }
		   case 2:{
			   System.out.println("====== ENTER THE CREDENTIALS OF THE NEW BORROWER ==========");
			   System.out.print("ENTER THE NAME OF THE NEW BORROWER: ");
			   String borrowerName=sc.next();
			   System.out.print("ENTER THE EMAIL ID: ");
			   String borrowerEmail=sc.next();
			   System.out.println("ENTER THE PASSWORD: ");
			   String borrowerUserPassword=sc.next();
			   String role="BORROWER";
			   users.add(new User(borrowerName,borrowerEmail,borrowerUserPassword,role));
			  System.out.println("========= NEW BORROWER "+borrowerName+" HAS BEEN SUCCESSULLY ADDED ==========");
			  break;
		   }
		   case 3:{
			   System.out.println("Enter the ISBN of the BOOK to Check :");
			   String ISBN=sc.next();
			   boolean bookPresent=false;
			   for(Book book:books) {
				   if(book.ISBN.equals(ISBN)) {
					   bookPresent=true;
					   System.out.println("BOOK NAME: "+book.bookName);
					   System.out.println("BOOK ISBN: "+book.ISBN);
					   System.out.println("BOOK QUANTITY: "+book.quantity);
				   }
			   }
			   if(!bookPresent) {
				   System.out.println("INCORRECT ISBN OR BOOK NOT AVAILABLE ");
			   }
			   break;
		   }
		   case 4:{
			   System.out.println("ENTER THE CREDENTIALS OF BOOK TO ADD");
			   String bookName=sc.nextLine();
			   String ISBN=sc.next();
			   int quantity=sc.nextInt();
			   int price=sc.nextInt();
			   books.add(new Book(bookName,ISBN,quantity,price));
			   break;
		   }
		   case 5:
		   {
			    System.out.println("Enter the ISBN of the book to modify: ");
			    String modifyISBN = sc.next();
			    boolean bookFound = false;
			    
			    for (Book book : books) {
			        if (book.ISBN.equals(modifyISBN)) {
			            bookFound = true;
			            System.out.println("Enter new quantity: ");
			            int newQuantity = sc.nextInt();
			            book.quantity = newQuantity;
			            System.out.println("Book quantity updated successfully.");
			        }
			    }
			    
			    if (!bookFound) {
			        System.out.println("Book not found with the provided ISBN.");
			    }
			    break;
		   }
		   case 6:{
			   System.out.println("ENTER THE ISBN OF THE BOOK YOU WANT TO DELETE : ");
			   String deleteISBN=sc.next();
			   for(Book book:books) {
				   if(book.ISBN.equals(deleteISBN)) {
					   books.remove(book);
					   System.out.println("BOOK SUCCESSFULLY REMOVED FROM INENTORY");
				   }
			   }
			   break;
		   }
		   case 7:{
			    System.out.println("1 - Sort by Name");
			    System.out.println("2 - Sort by Available Quantity");
			    int sortOption = sc.nextInt();
			    
			    if (sortOption == 1) {
			        Collections.sort(books, Comparator.comparing(book -> book.bookName));
			    } else if (sortOption == 2) {
			        Collections.sort(books, Comparator.comparingInt(book -> book.quantity));
			    } else {
			        System.out.println("Invalid sorting option.");
			    }
			    
			    for (Book book : books) {
			        System.out.println("Book Name: " + book.bookName);
			        System.out.println("Book ISBN: " + book.ISBN);
			        System.out.println("Book Quantity: " + book.quantity);
			    }
			    break;
		   }
		   case 8: {
			    System.out.println("PLEASE ENTER THE EMAIL OF THE BORROWER: ");
			    String emailCheck = sc.next();
			    for (User user : users) {
			        if (user.email.equals(emailCheck)) {
			            System.out.println("Current Fine Limit: " + user.fineLimit);
			            System.out.println("Enter the amount you would like to add or remove from the fine limit: ");
			            int modifyLimit = sc.nextInt();
			            user.fineLimit += modifyLimit;
			            System.out.println("Fine limit updated successfully.");
			        }
			    }
			    break;
			}
		   case 9:{
			   System.out.println("Students with outstanding fines:");
			   for (User user : users) {
			       if (user.fine > 0) {
			           System.out.println("Name: " + user.name);
			           System.out.println("Email: " + user.email);
			           System.out.println("Outstanding Fine: " + user.fine);
			           System.out.println();
			       }
			   }
			   break;
		   }
		   case 10:{
			   actionComplete=false;
			   System.out.println("THANK YOU VISIT AGAIN");
			   break;
		   }
		   default:
		        System.out.println("Invalid action. Please enter a valid option.");
		        break;
		   }
	   }
	   else {
		   System.out.println("========= WELCOME BORROWER " + currentUser.name + "==========");
		   System.out.println("1 - VIEW ALL AVAILABLE BOOKS");
           System.out.println("2 - SEARCH FOR A BOOK");
           System.out.println("3 - ADD A BOOK TO CART");
           System.out.println("4 - RETURN A BOOK");
           System.out.println("5 - CURRENT FINE AMOUNT");
           System.out.println("6 - BOOK IS LOST");
           System.out.println("7 - MEMBERSHIP CARD LOST");
           System.out.println("8 - EXIT");
           System.out.println("PLEASE ENTER THE ACTION YOU WOULD LIKE TO PERFORM : ");
           
           
           int action=sc.nextInt();
           
           while(actionComplete) {
        	   
           switch(action) {
           case 1:{			    
   			        Collections.sort(books, Comparator.comparing(book -> book.bookName));
   			    for (Book book : books) {
   			        System.out.println("Book Name: " + book.bookName);
   			        System.out.println("Book ISBN: " + book.ISBN);
   			        System.out.println("Book Quantity: " + book.quantity);
   			    }
   			    break;
           }
           case 2:{
        	   System.out.println("Enter the ISBN of the BOOK to Check :");
			   String ISBN=sc.next();
			   boolean bookPresent=false;
			   for(Book book:books) {
				   if(book.ISBN.equals(ISBN)) {
					   bookPresent=true;
					   System.out.println("BOOK NAME: "+book.bookName);
					   System.out.println("BOOK ISBN: "+book.ISBN);
					   System.out.println("BOOK QUANTITY: "+book.quantity);
				   }
			   }
			   if(!bookPresent) {
				   System.out.println("INCORRECT ISBN OR BOOK NOT AVAILABLE ");
			   }
			   break;
        	   }
           case 3:{
        	   if(currentCart.size()<3) {
        	   System.out.println("ENTER THE ISBN OF THE NUMBER YOU WOULD LIKE TO TAKE:");
        		  String bookISBN=sc.next();
        		  for(Book book:books) {
        			  if(book.ISBN.equals(bookISBN)) {
        				  if(currentCart.contains(book)) {
        					  System.out.println("SORRY YOU CANT TAKE SAME BOOK TWICE !");
        				  }
        				  int quantityAvailable=book.quantity;
        				  if(quantityAvailable>0) {
        				  currentCart.add(book);
        				  book.quantity=quantityAvailable-1;
        				  }
        				  else {
        					  System.out.println("SORRY THE BOOK IS OUT OF STOCK !");
        				  }
        			  }
        		  }
        	   
           }
        	   else {
        		   System.out.println("YOU CANT TAKE MORE THAN 3 BOOKS AT ONCE!");
        	   }
        	break;   
           }
           case 4:{
           System.out.println("Enter the ISBN of the book to return: ");
           String returnISBN = sc.next();
           boolean bookFound = false;
           
           for (Book book : currentCart) {
               if (book.ISBN.equals(returnISBN)) {
                   bookFound = true;
                   LocalDate currentDate = LocalDate.now();
                   LocalDate borrowedDate = currentUser.borrowedBooks.get(book.bookName);
                   long daysBorrowed = borrowedDate.until(currentDate).getDays();
                   
                   if (daysBorrowed > 15) {
                       double fineAmount = Math.min(2 * (daysBorrowed - 15), 0.8 * book.price);
                       System.out.println("Fine for returning the book late: " + fineAmount);
                       currentUser.fine += fineAmount;
                   }
                   
                   currentCart.remove(book);
                   book.quantity++;
                   currentUser.borrowedBooks.remove(book.bookName);
                   
                   System.out.println("Book returned successfully.");
               }
           }
           
           if (!bookFound) {
               System.out.println("Book not found in your cart with the provided ISBN.");
           }
           break;
           }
           case 5:{
        	   System.out.println("THE CURRENT FINE AMOUNT FOR USER "+currentUser.name+" is : "+currentUser.fine);
        	   break;
           }
           case 6:{
        	   System.out.println("ENTER THE ISBN OF THE BOOK LOST :");
        	   String lostBookISBN=sc.next();
        	   for(Book book:books) {
        		   if(book.ISBN.equals(lostBookISBN)) {
        			   int val=book.quantity-1;
        			   book.quantity=val;
        		   }
        	   }
        	   System.out.println("A FINE AMOUNT OF 50% OF THE BOOK WILL BE FINED! ");
        	   break;
           }
           case 7:{
        	   System.out.println("FINE AMOUNT OF Rs.10 WILL BE FINED AS A CONSEQUENCE OF LOSING MEMBERSHIP CARD !");
        	   break;
           }
           case 8:{
        	   actionComplete=false;
        	   System.out.println("THANK YOU VISIT AGAIN");
        	   break;
           }
           default:{
        	   System.out.println("PLEASE ENTER VALID OPTION FROM THE LIST");
           }
           }
	   }
	   }
   }
   }
   sc.close();
}
}