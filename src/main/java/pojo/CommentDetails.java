package pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * POJO for comment details such as comment text and user.
 * 
 * @author garima.m
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "comment", "user" })

public class CommentDetails implements Comparable<CommentDetails> {

	@JsonProperty("comment")
	private String comment;

	@JsonProperty("user")
	private String user;

	@JsonIgnore
	private Integer score;

	public CommentDetails() {
		super();
	}

	public CommentDetails(@JsonProperty("comment") String comment, @JsonProperty("user") String user, Integer score) {
		super();
		this.comment = comment;
		this.user = user;
		this.score = score;
	}

	@JsonProperty("comment")
	public String getComment() {
		return comment;
	}

	@JsonProperty("comment")
	public void setComment(String comment) {
		this.comment = comment;
	}

	@JsonProperty("user")
	public String getUser() {
		return user;
	}

	@JsonProperty("user")
	public void setUser(String user) {
		this.user = user;
	}

	@JsonIgnore
	public Integer getScore() {
		return score;
	}

	@JsonIgnore
	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "CommentDetails [comment=" + comment + ", user=" + user + "]";
	}

	@Override
	public int compareTo(CommentDetails o) {
		return o.score - this.score;
	}

}
