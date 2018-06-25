package eu.caraus.dynamo.application.domain.udacity;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;


public class CoursesItem implements Serializable {

	@SerializedName("syllabus")
	private String syllabus;

	@SerializedName("featured")
	private boolean featured;

	@SerializedName("expected_duration_low")
	private String expectedDurationLow;

	@SerializedName("projects")
	private List<Object> projects;

	@SerializedName("capped")
	private boolean capped;

	@SerializedName("student_groups")
	private List<String> studentGroups;

	@SerializedName("available")
	private boolean available;

	@SerializedName("flags")
	private Flags flags;

	@SerializedName("public_listing")
	private boolean publicListing;

	@SerializedName("title")
	private String title;

	@SerializedName("project_name")
	private String projectName;

	@SerializedName("instructors")
	private List<InstructorsItem> instructors;

	@SerializedName("faq")
	private String faq;

	@SerializedName("expected_duration")
	private String expectedDuration;

	@SerializedName("expected_duration_unit")
	private String expectedDurationUnit;

	@SerializedName("required_knowledge")
	private String requiredKnowledge;

	@SerializedName("banner_image")
	private String bannerImage;

	@SerializedName("key")
	private String key;

	@SerializedName("short_summary")
	private String shortSummary;

	@SerializedName("slug")
	private String slug;

	@SerializedName("summary")
	private String summary;

	@SerializedName("enables_profiles")
	private boolean enablesProfiles;

	@SerializedName("image")
	private String image;

	@SerializedName("assistants")
	private List<String> assistants;

	@SerializedName("starter")
	private boolean starter;

	@SerializedName("level")
	private String level;

	@SerializedName("open_for_enrollment")
	private boolean openForEnrollment;

	@SerializedName("expected_duration_high")
	private String expectedDurationHigh;

	@SerializedName("tracks")
	private List<String> tracks;

	@SerializedName("related_degree_keys")
	private List<Object> relatedDegreeKeys;

	@SerializedName("tags")
	private List<Object> tags;

	@SerializedName("project_description")
	private String projectDescription;

	@SerializedName("new_release")
	private boolean newRelease;

	@SerializedName("expected_learning")
	private String expectedLearning;

	@SerializedName("subtitle")
	private String subtitle;

	@SerializedName("teaser_video")
	private TeaserVideo teaserVideo;

	@SerializedName("affiliates")
	private List<AffiliatesItem> affiliates;

	@SerializedName("graduate_groups")
	private List<String> graduateGroups;

	@SerializedName("full_course_available")
	private boolean fullCourseAvailable;

	public void setSyllabus(String syllabus){
		this.syllabus = syllabus;
	}

	public String getSyllabus(){
		return syllabus;
	}

	public void setFeatured(boolean featured){
		this.featured = featured;
	}

	public boolean isFeatured(){
		return featured;
	}

	public void setExpectedDurationLow(String expectedDurationLow){
		this.expectedDurationLow = expectedDurationLow;
	}

	public String getExpectedDurationLow(){
		return expectedDurationLow;
	}

	public void setProjects(List<Object> projects){
		this.projects = projects;
	}

	public List<Object> getProjects(){
		return projects;
	}

	public void setCapped(boolean capped){
		this.capped = capped;
	}

	public boolean isCapped(){
		return capped;
	}

	public void setStudentGroups(List<String> studentGroups){
		this.studentGroups = studentGroups;
	}

	public List<String> getStudentGroups(){
		return studentGroups;
	}

	public void setAvailable(boolean available){
		this.available = available;
	}

	public boolean isAvailable(){
		return available;
	}

	public void setFlags(Flags flags){
		this.flags = flags;
	}

	public Flags getFlags(){
		return flags;
	}

	public void setPublicListing(boolean publicListing){
		this.publicListing = publicListing;
	}

	public boolean isPublicListing(){
		return publicListing;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setProjectName(String projectName){
		this.projectName = projectName;
	}

	public String getProjectName(){
		return projectName;
	}

	public void setInstructors(List<InstructorsItem> instructors){
		this.instructors = instructors;
	}

	public List<InstructorsItem> getInstructors(){
		return instructors;
	}

	public void setFaq(String faq){
		this.faq = faq;
	}

	public String getFaq(){
		return faq;
	}

	public void setExpectedDuration(String expectedDuration){
		this.expectedDuration = expectedDuration;
	}

	public String getExpectedDuration(){
		return expectedDuration;
	}

	public void setExpectedDurationUnit(String expectedDurationUnit){
		this.expectedDurationUnit = expectedDurationUnit;
	}

	public String getExpectedDurationUnit(){
		return expectedDurationUnit;
	}

	public void setRequiredKnowledge(String requiredKnowledge){
		this.requiredKnowledge = requiredKnowledge;
	}

	public String getRequiredKnowledge(){
		return requiredKnowledge;
	}

	public void setBannerImage(String bannerImage){
		this.bannerImage = bannerImage;
	}

	public String getBannerImage(){
		return bannerImage;
	}

	public void setKey(String key){
		this.key = key;
	}

	public String getKey(){
		return key;
	}

	public void setShortSummary(String shortSummary){
		this.shortSummary = shortSummary;
	}

	public String getShortSummary(){
		return shortSummary;
	}

	public void setSlug(String slug){
		this.slug = slug;
	}

	public String getSlug(){
		return slug;
	}

	public void setSummary(String summary){
		this.summary = summary;
	}

	public String getSummary(){
		return summary;
	}

	public void setEnablesProfiles(boolean enablesProfiles){
		this.enablesProfiles = enablesProfiles;
	}

	public boolean isEnablesProfiles(){
		return enablesProfiles;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setAssistants(List<String> assistants){
		this.assistants = assistants;
	}

	public List<String> getAssistants(){
		return assistants;
	}

	public void setStarter(boolean starter){
		this.starter = starter;
	}

	public boolean isStarter(){
		return starter;
	}

	public void setLevel(String level){
		this.level = level;
	}

	public String getLevel(){
		return level;
	}

	public void setOpenForEnrollment(boolean openForEnrollment){
		this.openForEnrollment = openForEnrollment;
	}

	public boolean isOpenForEnrollment(){
		return openForEnrollment;
	}

	public void setExpectedDurationHigh(String expectedDurationHigh){
		this.expectedDurationHigh = expectedDurationHigh;
	}

	public String getExpectedDurationHigh(){
		return expectedDurationHigh;
	}

	public void setTracks(List<String> tracks){
		this.tracks = tracks;
	}

	public List<String> getTracks(){
		return tracks;
	}

	public void setRelatedDegreeKeys(List<Object> relatedDegreeKeys){
		this.relatedDegreeKeys = relatedDegreeKeys;
	}

	public List<Object> getRelatedDegreeKeys(){
		return relatedDegreeKeys;
	}

	public void setTags(List<Object> tags){
		this.tags = tags;
	}

	public List<Object> getTags(){
		return tags;
	}

	public void setProjectDescription(String projectDescription){
		this.projectDescription = projectDescription;
	}

	public String getProjectDescription(){
		return projectDescription;
	}

	public void setNewRelease(boolean newRelease){
		this.newRelease = newRelease;
	}

	public boolean isNewRelease(){
		return newRelease;
	}

	public void setExpectedLearning(String expectedLearning){
		this.expectedLearning = expectedLearning;
	}

	public String getExpectedLearning(){
		return expectedLearning;
	}

	public void setSubtitle(String subtitle){
		this.subtitle = subtitle;
	}

	public String getSubtitle(){
		return subtitle;
	}

	public void setTeaserVideo(TeaserVideo teaserVideo){
		this.teaserVideo = teaserVideo;
	}

	public TeaserVideo getTeaserVideo(){
		return teaserVideo;
	}

	public void setAffiliates(List<AffiliatesItem> affiliates){
		this.affiliates = affiliates;
	}

	public List<AffiliatesItem> getAffiliates(){
		return affiliates;
	}

	public void setGraduateGroups(List<String> graduateGroups){
		this.graduateGroups = graduateGroups;
	}

	public List<String> getGraduateGroups(){
		return graduateGroups;
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
			"CoursesItem{" + 
			"syllabus = '" + syllabus + '\'' + 
			",featured = '" + featured + '\'' + 
			",expected_duration_low = '" + expectedDurationLow + '\'' + 
			",projects = '" + projects + '\'' + 
			",capped = '" + capped + '\'' + 
			",student_groups = '" + studentGroups + '\'' + 
			",available = '" + available + '\'' + 
			",flags = '" + flags + '\'' + 
			",public_listing = '" + publicListing + '\'' + 
			",title = '" + title + '\'' + 
			",project_name = '" + projectName + '\'' + 
			",instructors = '" + instructors + '\'' + 
			",faq = '" + faq + '\'' + 
			",expected_duration = '" + expectedDuration + '\'' + 
			",expected_duration_unit = '" + expectedDurationUnit + '\'' + 
			",required_knowledge = '" + requiredKnowledge + '\'' + 
			",banner_image = '" + bannerImage + '\'' + 
			",key = '" + key + '\'' + 
			",short_summary = '" + shortSummary + '\'' + 
			",slug = '" + slug + '\'' + 
			",summary = '" + summary + '\'' + 
			",enables_profiles = '" + enablesProfiles + '\'' + 
			",image = '" + image + '\'' + 
			",assistants = '" + assistants + '\'' + 
			",starter = '" + starter + '\'' + 
			",level = '" + level + '\'' + 
			",open_for_enrollment = '" + openForEnrollment + '\'' + 
			",expected_duration_high = '" + expectedDurationHigh + '\'' + 
			",tracks = '" + tracks + '\'' + 
			",related_degree_keys = '" + relatedDegreeKeys + '\'' + 
			",tags = '" + tags + '\'' + 
			",project_description = '" + projectDescription + '\'' + 
			",new_release = '" + newRelease + '\'' + 
			",expected_learning = '" + expectedLearning + '\'' + 
			",subtitle = '" + subtitle + '\'' + 
			",teaser_video = '" + teaserVideo + '\'' + 
			",affiliates = '" + affiliates + '\'' + 
			",graduate_groups = '" + graduateGroups + '\'' + 
			",full_course_available = '" + fullCourseAvailable + '\'' + 
			"}";
		}
}