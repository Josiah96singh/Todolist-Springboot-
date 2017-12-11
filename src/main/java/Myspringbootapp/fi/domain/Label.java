package Myspringbootapp.fi.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Label {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private long labelid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "label")
	private List<Todo> todos;
	
	public Label(){}
	
	public Label(String name) {
		super();
		this.name = name;
	}

	public long getLabelid() {
		return labelid;
	}
	public void setLabelid(long labelid) {
		this.labelid = labelid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	@Override
	public String toString() {
		return "Label [labelid=" + labelid + ", name=" + name + "]";
	}
	
	
}
