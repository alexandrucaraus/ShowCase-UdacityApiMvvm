package eu.caraus.dynamo.application.domain.udacity;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class AffiliatesItem implements Serializable {

	@SerializedName("image")
	private String image;

	@SerializedName("name")
	private String name;

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

	public void setKey(String key){
		this.key = key;
	}

	public String getKey(){
		return key;
	}

	@Override
 	public String toString(){
		return 
			"AffiliatesItem{" + 
			"image = '" + image + '\'' + 
			",name = '" + name + '\'' + 
			",key = '" + key + '\'' + 
			"}";
		}
}