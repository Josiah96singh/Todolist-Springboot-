package Myspringbootapp.fi.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository <Todo, Long> {
 
	List<Todo> findByDay(String day);
}
