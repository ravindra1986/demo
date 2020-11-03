package com.genpact.demo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.genpact.demo.model.BookEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

	
	@Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }
	@Test
	public void contextLoads() {
	}
	
	
	@Test
    public void testGetAllBooks() {
    HttpHeaders headers = new HttpHeaders();
       HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/book",
       HttpMethod.GET, entity, String.class);  
       assertNotNull(response.getBody());
   }
	@Test
    public void testCreateBook() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookName("OS");
        bookEntity.setIsbnNo("ISBN0004");
        ResponseEntity<BookEntity> postResponse = restTemplate.postForEntity(getRootUrl() + "/book", bookEntity, BookEntity.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }
	
	@Test
    public void testUpdateBook() {
        int id = 1;
        BookEntity bookEntity = restTemplate.getForObject(getRootUrl() + "/book/" + id, BookEntity.class);
        bookEntity.setBookName("Compiler");
        bookEntity.setIsbnNo("ISBN0001");
        restTemplate.put(getRootUrl() + "/book/" + id, bookEntity);
        BookEntity updatedBook = restTemplate.getForObject(getRootUrl() + "/book/" + id, BookEntity.class);
        assertNotNull(updatedBook);
    }
}
