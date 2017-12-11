package Myspringbootapp.fi.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LabelRepository extends CrudRepository <Label, Long> {

	List<Label> findByName(String name);
}
