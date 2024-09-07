<<<<<<< HEAD
package SpringBootWebApp.ToDoApp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer>{

	List<Todo> findByUsername(String username);
}
=======
package SpringBootWebApp.ToDoApp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer>{

	List<Todo> findByUsername(String username);
}
>>>>>>> f36b17aa6fafaa2f907bb8ca009d81eaa3f6b2dd
