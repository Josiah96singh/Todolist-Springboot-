package Myspringbootapp.fi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Todo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String description;
	private String day;
	private int year;
	
	
	@ManyToOne
	@JoinColumn(name = "labelid")
	private Label label;
	
	public Todo(){}
	
	public Todo(String description, String day, int year, Label label) {
		super();
		this.description = description;
		this.day= day;
		this.year = year;
		this.label=label;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", description=" + description + ", day=" + day + ", year=" + year + ", label=" + label + "]";
	}


	

	
	
}
