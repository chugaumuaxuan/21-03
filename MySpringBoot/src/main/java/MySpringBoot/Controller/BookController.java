package MySpringBoot.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import MySpringBoot.Model.Book;
import MySpringBoot.Service.BookService;

@RestController
public class BookController {
	
	@Autowired
	public BookService bookService;
	
	@RequestMapping("/book")
	public List<Book> all_books(){
		return bookService.getAllBooks();
	}
	
	@RequestMapping(value = "/FindBook")
	public List<Book> find_book(@RequestParam String book ){
		return bookService.findBook(book);
		
	}
	
	@RequestMapping(value = {"/GetInfo", "/GetInfo/{name}"})
	public List<Book> getInfo(@PathVariable("name") String book){	
		return bookService.getInfo(book);
	}
	
	@RequestMapping(value = {"/DeleteBook", "/DeleteBook/{name}"})
	public List<Book> DeleteBook(@PathVariable("name") String book){	
		return bookService.deleteBook(book);
	}
	

	@PostMapping(value = "/user/register", produces = "application/json;charset=UTF-8")
	public @ResponseBody Book addBook(@RequestBody Book b){
		b = (Book) bookService.addBook(b);
		return b;
	}
	
}
