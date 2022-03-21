package MySpringBoot.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;



import MySpringBoot.Model.Book;

@Service
public class BookService {
	
	public List<Book> bookList = new ArrayList<>(Arrays.asList(
			new Book("Xu so tan bao dieu ki va chon tan cung the gioi", 200 ),
			new Book("Toi noi gi ve chay bo", 100),
			new Book("Rung Nauy", 210),
			new Book("b", 210)
			));
	
	public List<Book> getAllBooks() {
		bookList.forEach(n -> System.out.println(n.getBookName() + " " + n.getPagesNumber()));
		return bookList;
	}		
	
	public List<Book> findBook(String book){
		bookList.stream().forEach(f -> {
			if(f.getBookName().equals(book)) {
				System.out.println(f.getBookName() + " " +f.getPagesNumber());
			}
			else {			
			}
		});	
		return bookList;
	}
	
	public List<Book> getInfo(String book){
		bookList.stream().forEach(f -> {
			if(f.getBookName().equals(book)) {
				System.out.println(f.getBookName() + " " +f.getPagesNumber());
			}
			else {			
			}
		});	
		return bookList;	
	}
	
	public List<Book> deleteBook(String book){	 	
		bookList.removeIf(b -> book.equals(b.getBookName()));
		return bookList;
	}
	
	public List<Book> addBook(Book b){
		
		bookList.add(b);
		
		return bookList;
	}
}
