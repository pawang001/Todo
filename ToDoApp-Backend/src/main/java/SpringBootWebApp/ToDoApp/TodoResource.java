<<<<<<< HEAD
package SpringBootWebApp.ToDoApp;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class TodoResource {
	
	TodoService todoService;
	
	public TodoResource(TodoService todoService) {
		super();
		this.todoService= todoService;
	}
	
	@GetMapping(path = "/basicauth")
	public String basicAuthCheck() {
		return "Success";
	}
	
	@GetMapping("users/{username}/listTodos")
	public List<Todo> retreiveTodosByUsername(@PathVariable String username){
		return todoService.findByUsername(username);
	}
	
	@GetMapping("users/{username}/listTodos/{id}")
	public Todo retreiveTodo(@PathVariable String username, @PathVariable int id){
		return todoService.findById(id);
	}
	
	@DeleteMapping("users/{username}/listTodos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username,
			@PathVariable int id){
		todoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("users/{username}/listTodos/{id}")
	public Todo updateTodo(@PathVariable String username, @PathVariable int id,
			@RequestBody Todo todo) {
		todoService.updateTodo(todo);
		return todo;
	}
	
	@PostMapping("users/{username}/listTodos")
	public Todo createTodo(@PathVariable String username, 
			@RequestBody Todo todo) {
		Todo createdTodo = todoService.addTodo(username, 
				todo.getDescription(), todo.getTargetDate(), todo.isDone());
		return createdTodo;
	}
}
=======
package SpringBootWebApp.ToDoApp;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class TodoResource {
	
	TodoService todoService;
	
	public TodoResource(TodoService todoService) {
		super();
		this.todoService= todoService;
	}
	
	@GetMapping(path = "/basicauth")
	public String basicAuthCheck() {
		return "Success";
	}
	
	@GetMapping("users/{username}/listTodos")
	public List<Todo> retreiveTodosByUsername(@PathVariable String username){
		return todoService.findByUsername(username);
	}
	
	@GetMapping("users/{username}/listTodos/{id}")
	public Todo retreiveTodo(@PathVariable String username, @PathVariable int id){
		return todoService.findById(id);
	}
	
	@DeleteMapping("users/{username}/listTodos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username,
			@PathVariable int id){
		todoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("users/{username}/listTodos/{id}")
	public Todo updateTodo(@PathVariable String username, @PathVariable int id,
			@RequestBody Todo todo) {
		todoService.updateTodo(todo);
		return todo;
	}
	
	@PostMapping("users/{username}/listTodos")
	public Todo createTodo(@PathVariable String username, 
			@RequestBody Todo todo) {
		Todo createdTodo = todoService.addTodo(username, 
				todo.getDescription(), todo.getTargetDate(), todo.isDone());
		return createdTodo;
	}
}
>>>>>>> f36b17aa6fafaa2f907bb8ca009d81eaa3f6b2dd
