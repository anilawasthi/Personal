package com.jpm.jpql.client;

import com.jpm.jpql.entities.Book;
import com.jpm.jpql.service.BookServiceImpl;
import com.jpm.jpql.service.IBookService;

public class BookClient {

	public static void main(String[] args) {
		// prep work
		IBookService service = new BookServiceImpl();
		System.out.println("****************Listing book with id 101****************");
		System.out.println("Book with ID 101:" +service.getBookById(101));
		
		System.out.println("****************Listing All books****************");
		for(Book book:service.getAllBooks()){
			System.out.println(book);
		}
		
		System.out.println("****************Listing book with title Android****************");
		for(Book book:service.getBookByTitle("Android")){
			System.out.println(book);
		}
		
		System.out.println("****************Listing total number of books****************");
		System.out.println("Total books"+service.getBookCount());
		/*for(Book book:service.getBookCount("Java")){
			System.out.println(book);
		}*/
		
		System.out.println("****************Listing total number of books****************");
		for(Book book:service.getAuthorBooks("Danny Coward")){
			System.out.println(book);
		}
	}
}


