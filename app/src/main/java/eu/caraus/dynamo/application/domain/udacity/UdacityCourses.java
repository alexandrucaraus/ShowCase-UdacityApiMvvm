package eu.caraus.dynamo.application.domain.udacity;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;


public class UdacityCourses implements Serializable {

	@SerializedName("courses")
	private List<CoursesItem> courses;

	public void setCourses(List<CoursesItem> courses){
		this.courses = courses;
	}

	public List<CoursesItem> getCourses(){
		return courses;
	}

	@Override
 	public String toString(){
		return 
			"UdacityCourses{" +
			"courses = '" + courses + '\'' + 
			"}";
		}
}