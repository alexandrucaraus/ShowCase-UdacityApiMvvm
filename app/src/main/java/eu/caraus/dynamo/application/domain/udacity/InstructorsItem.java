package eu.caraus.dynamo.application.domain.udacity;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class InstructorsItem implements Serializable {

	@SerializedName("image")
	private String image;

	@SerializedName("name")
	private String name;

	@SerializedName("bio")
	private String bio;

	@SerializedName("title")
	private String title;

	@SerializedName("key")
	private String key;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setBio(String bio){
		this.bio = bio;
	}

	public String getBio(){
		return bio;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setKey(String key){
		this.key = key;
	}

	public String getKey(){
		return key;
	}

	@Override
 	public String toString(){
		return 
			"InstructorsItem{" + 
			"image = '" + image + '\'' + 
			",name = '" + name + '\'' + 
			",bio = '" + bio + '\'' + 
			",title = '" + title + '\'' + 
			",key = '" + key + '\'' + 
			"}";
		}
}