<<<<<<< HEAD
package SpringBootWebApp.ToDoApp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	
	private static int TodosCount = 0;
	
	static {
		todos.add(new Todo(++TodosCount, "Pawan",
				"Build a web app", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++TodosCount, "Pawan",
				"Learn HTML, CSS, JS", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++TodosCount, "Pawan",
				"Study Arrays, Trees", LocalDate.now().plusYears(3), false));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate=
		todo-> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public Todo addTodo(String username, String description,
			  LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++TodosCount, username, description, targetDate, done);
		todos.add(todo);
		return todo;
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate=todo-> todo.getId()==id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate=todo-> todo.getId()==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}
=======
package SpringBootWebApp.ToDoApp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	
	private static int TodosCount = 0;
	
	static {
		todos.add(new Todo(++TodosCount, "Pawan",
				"Build a web app", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++TodosCount, "Pawan",
				"Learn HTML, CSS, JS", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++TodosCount, "Pawan",
				"Study Arrays, Trees", LocalDate.now().plusYears(3), false));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate=
		todo-> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public Todo addTodo(String username, String description,
			  LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++TodosCount, username, description, targetDate, done);
		todos.add(todo);
		return todo;
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate=todo-> todo.getId()==id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate=todo-> todo.getId()==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}
>>>>>>> f36b17aa6fafaa2f907bb8ca009d81eaa3f6b2dd
