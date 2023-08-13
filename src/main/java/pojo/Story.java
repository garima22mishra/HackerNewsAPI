package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * POJO for returning story details to user for top-stories and past-stories API
 * 
 * @author garima.m
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "title", "url", "score", "timeOfSubmission", "user" })

public class Story {
	@JsonProperty("title")
	private String title;
	@JsonProperty("url")
	private String url;
	@JsonProperty("score")
	private Integer score;
	@JsonProperty("timeOfSubmission")
	private Long timeOfSubmission;
	@JsonProperty("user")
	private String user;

	public Story(@JsonProperty("title") String title, @JsonProperty("url") String url,
			@JsonProperty("score") Integer score, @JsonProperty("timeOfSubmission") Long timeOfSubmission,
			@JsonProperty("user") String user) {
		this.title = title;
		this.url = url;
		this.score = score;
		this.timeOfSubmission = timeOfSubmission;
		this.user = user;
	}

	public Story() {
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("score")
	public Integer getScore() {
		return score;
	}

	@JsonProperty("score")
	public void setScore(Integer score) {
		this.score = score;
	}

	@JsonProperty("timeOfSubmission")
	public Long getTimeOfSubmission() {
		return timeOfSubmission;
	}

	@JsonProperty("timeOfSubmission")
	public void setTimeOfSubmission(Long timeOfSubmission) {
		this.timeOfSubmission = timeOfSubmission;
	}

	@JsonProperty("user")
	public String getUser() {
		return user;
	}

	@JsonProperty("user")
	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Story [title=" + title + ", url=" + url + ", score=" + score + ", timeOfSubmission=" + timeOfSubmission
				+ ", user=" + user + "]";
	}

}
