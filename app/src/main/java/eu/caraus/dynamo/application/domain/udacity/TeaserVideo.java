package eu.caraus.dynamo.application.domain.udacity;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class TeaserVideo implements Serializable {

	@SerializedName("vimeo_id")
	private String vimeoId;

	@SerializedName("youtube_url")
	private String youtubeUrl;

	@SerializedName("transcodings")
	private Transcodings transcodings;

	public void setVimeoId(String vimeoId){
		this.vimeoId = vimeoId;
	}

	public String getVimeoId(){
		return vimeoId;
	}

	public void setYoutubeUrl(String youtubeUrl){
		this.youtubeUrl = youtubeUrl;
	}

	public String getYoutubeUrl(){
		return youtubeUrl;
	}

	public void setTranscodings(Transcodings transcodings){
		this.transcodings = transcodings;
	}

	public Transcodings getTranscodings(){
		return transcodings;
	}

	@Override
 	public String toString(){
		return 
			"TeaserVideo{" + 
			"vimeo_id = '" + vimeoId + '\'' + 
			",youtube_url = '" + youtubeUrl + '\'' + 
			",transcodings = '" + transcodings + '\'' + 
			"}";
		}
}