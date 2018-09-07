package funbook;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.funbook.beans.Book;
import com.funbook.controller.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class BookLibraryTest {
	 private static final String URLREST = "http://localhost:8080/api/books";
	 
	 
	 
	   @Test 
	    public void checkGetAllBook() {
	        final Response response = RestAssured.get(URLREST);
	        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	    }
	   
	   
	   
	    @Test
	    public void checkSaveNewBook() {
	         Book book = new Book();
	         book.setAuthor("APJ");
	         book.setId(222);
	         book.setTitle("WingsofFire");
	         book.setPrice(343.3);
	        final Response response = RestAssured.given()
	            .contentType(MediaType.APPLICATION_JSON_VALUE)
	            .body(book)
	            .post(URLREST);
	        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
	    }
	    
	    
	    
}
