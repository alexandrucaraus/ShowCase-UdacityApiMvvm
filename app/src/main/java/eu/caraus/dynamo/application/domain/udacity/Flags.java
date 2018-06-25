package eu.caraus.dynamo.application.domain.udacity;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Flags implements Serializable {

	@SerializedName("enables_profiles")
	private boolean enablesProfiles;

	@SerializedName("featured")
	private boolean featured;

	@SerializedName("starter")
	private boolean starter;

	@SerializedName("capped")
	private boolean capped;

	@SerializedName("new_release")
	private boolean newRelease;

	@SerializedName("available")
	private boolean available;

	@SerializedName("open_for_enrollment")
	private boolean openForEnrollment;

	@SerializedName("public_listing")
	private boolean publicListing;

	@SerializedName("full_course_available")
	private boolean fullCourseAvailable;

	public void setEnablesProfiles(boolean enablesProfiles){
		this.enablesProfiles = enablesProfiles;
	}

	public boolean isEnablesProfiles(){
		return enablesProfiles;
	}

	public void setFeatured(boolean featured){
		this.featured = featured;
	}

	public boolean isFeatured(){
		return featured;
	}

	public void setStarter(boolean starter){
		this.starter = starter;
	}

	public boolean isStarter(){
		return starter;
	}

	public void setCapped(boolean capped){
		this.capped = capped;
	}

	public boolean isCapped(){
		return capped;
	}

	public void setNewRelease(boolean newRelease){
		this.newRelease = newRelease;
	}

	public boolean isNewRelease(){
		return newRelease;
	}

	public void setAvailable(boolean available){
		this.available = available;
	}

	public boolean isAvailable(){
		return available;
	}

	public void setOpenForEnrollment(boolean openForEnrollment){
		this.openForEnrollment = openForEnrollment;
	}

	public boolean isOpenForEnrollment(){
		return openForEnrollment;
	}

	public void setPublicListing(boolean publicListing){
		this.publicListing = publicListing;
	}

	public boolean isPublicListing(){
		return publicListing;
	}

	public void setFullCourseAvailable(boolean fullCourseAvailable){
		this.fullCourseAvailable = fullCourseAvailable;
	}

	public boolean isFullCourseAvailable(){
		return fullCourseAvailable;
	}

	@Override
 	public String toString(){
		return 
			"Flags{" + 
			"enables_profiles = '" + enablesProfiles + '\'' + 
			",featured = '" + featured + '\'' + 
			",starter = '" + starter + '\'' + 
			",capped = '" + capped + '\'' + 
			",new_release = '" + newRelease + '\'' + 
			",available = '" + available + '\'' + 
			",open_for_enrollment = '" + openForEnrollment + '\'' + 
			",public_listing = '" + publicListing + '\'' + 
			",full_course_available = '" + fullCourseAvailable + '\'' + 
			"}";
		}
}