package eu.caraus.dynamo.application.domain.udacity;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Transcodings implements Serializable {

	@SerializedName("480p_1000kbps_mp4")
	private JsonMember480p1000kbpsMp4 jsonMember480p1000kbpsMp4;

	@SerializedName("720p_mp4")
	private JsonMember720pMp4 jsonMember720pMp4;

	@SerializedName("480p_ogg")
	private JsonMember480pOgg jsonMember480pOgg;

	@SerializedName("480p_mp4")
	private JsonMember480pMp4 jsonMember480pMp4;

	public void setJsonMember480p1000kbpsMp4(JsonMember480p1000kbpsMp4 jsonMember480p1000kbpsMp4){
		this.jsonMember480p1000kbpsMp4 = jsonMember480p1000kbpsMp4;
	}

	public JsonMember480p1000kbpsMp4 getJsonMember480p1000kbpsMp4(){
		return jsonMember480p1000kbpsMp4;
	}

	public void setJsonMember720pMp4(JsonMember720pMp4 jsonMember720pMp4){
		this.jsonMember720pMp4 = jsonMember720pMp4;
	}

	public JsonMember720pMp4 getJsonMember720pMp4(){
		return jsonMember720pMp4;
	}

	public void setJsonMember480pOgg(JsonMember480pOgg jsonMember480pOgg){
		this.jsonMember480pOgg = jsonMember480pOgg;
	}

	public JsonMember480pOgg getJsonMember480pOgg(){
		return jsonMember480pOgg;
	}

	public void setJsonMember480pMp4(JsonMember480pMp4 jsonMember480pMp4){
		this.jsonMember480pMp4 = jsonMember480pMp4;
	}

	public JsonMember480pMp4 getJsonMember480pMp4(){
		return jsonMember480pMp4;
	}

	@Override
 	public String toString(){
		return 
			"Transcodings{" + 
			"480p_1000kbps_mp4 = '" + jsonMember480p1000kbpsMp4 + '\'' + 
			",720p_mp4 = '" + jsonMember720pMp4 + '\'' + 
			",480p_ogg = '" + jsonMember480pOgg + '\'' + 
			",480p_mp4 = '" + jsonMember480pMp4 + '\'' + 
			"}";
		}
}