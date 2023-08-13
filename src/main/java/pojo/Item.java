package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * POJO for holding Item details received from Hacker news database with respect
 * to story id
 * 
 * @author garima.m
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "by", "descendants", "id", "kids", "score", "time", "title", "type", "url", "deleted", "text",
		"dead", "parent", "poll", "parts" })

public class Item implements Comparable<Item> {
	@JsonProperty("by")
	private String by;
	@JsonProperty("descendants")
	private Integer descendants;
	@JsonProperty("id")
	private String id;
	@JsonProperty("kids")
	private List<Long> kids;
	@JsonProperty("score")
	private Integer score;
	@JsonProperty("time")
	private Long time;
	@JsonProperty("title")
	private String title;
	@JsonProperty("type")
	private String type;
	@JsonProperty("url")
	private String url;
	@JsonProperty("deleted")
	private Boolean deleted;
	@JsonProperty("text")
	private String text;
	@JsonProperty("dead")
	private Boolean dead;
	@JsonProperty("parent")
	private String parent;
	@JsonProperty("poll")
	private String poll;
	@JsonProperty("parts")
	private List<String> parts;

	public Item() {
		super();
	}

	public Item(@JsonProperty("by") String by, @JsonProperty("descendants") Integer descendants,
			@JsonProperty("id") String id, @JsonProperty("kids") List<Long> kids, @JsonProperty("score") Integer score,
			@JsonProperty("time") Long time, @JsonProperty("title") String title, @JsonProperty("type") String type,
			@JsonProperty("url") String url, @JsonProperty("deleted") Boolean deleted,
			@JsonProperty("text") String text, @JsonProperty("dead") Boolean dead,
			@JsonProperty("parent") String parent, @JsonProperty("poll") String poll,
			@JsonProperty("parts") List<String> parts) {
		super();
		this.by = by;
		this.descendants = descendants;
		this.id = id;
		this.kids = kids;
		this.score = score;
		this.time = time;
		this.title = title;
		this.type = type;
		this.url = url;
		this.deleted = deleted;
		this.text = text;
		this.dead = dead;
		this.parent = parent;
		this.poll = poll;
		this.parts = parts;
	}

	@JsonProperty("by")
	public String getBy() {
		return by;
	}

	@JsonProperty("by")
	public void setBy(String by) {
		this.by = by;
	}

	@JsonProperty("descendants")
	public Integer getDescendants() {
		return descendants;
	}

	@JsonProperty("descendants")
	public void setDescendants(Integer descendants) {
		this.descendants = descendants;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("kids")
	public List<Long> getKids() {
		return kids;
	}

	@JsonProperty("kids")
	public void setKids(List<Long> kids) {
		this.kids = kids;
	}

	@JsonProperty("score")
	public Integer getScore() {
		return score;
	}

	@JsonProperty("score")
	public void setScore(Integer score) {
		this.score = score;
	}

	@JsonProperty("time")
	public Long getTime() {
		return time;
	}

	@JsonProperty("time")
	public void setTime(Long time) {
		this.time = time;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("deleted")
	public Boolean isDeleted() {
		return deleted;
	}

	@JsonProperty("deleted")
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@JsonProperty("text")
	public String getText() {
		return text;
	}

	@JsonProperty("text")
	public void setText(String text) {
		this.text = text;
	}

	@JsonProperty("dead")
	public Boolean isDead() {
		return dead;
	}

	@JsonProperty("dead")
	public void setDead(Boolean dead) {
		this.dead = dead;
	}

	@JsonProperty("parent")
	public String getParent() {
		return parent;
	}

	@JsonProperty("parent")
	public void setParent(String parent) {
		this.parent = parent;
	}

	@JsonProperty("poll")
	public String getPoll() {
		return poll;
	}

	@JsonProperty("poll")
	public void setPoll(String poll) {
		this.poll = poll;
	}

	@JsonProperty("parts")
	public List<String> getParts() {
		return parts;
	}

	@JsonProperty("parts")
	public void setParts(List<String> parts) {
		this.parts = parts;
	}

	@Override
	public String toString() {
		return "Item [by=" + by + ", descendants=" + descendants + ", id=" + id + ", kids=" + kids + ", score=" + score
				+ ", time=" + time + ", title=" + title + ", type=" + type + ", url=" + url + ", deleted=" + deleted
				+ ", text=" + text + ", dead=" + dead + ", parent=" + parent + ", poll=" + poll + ", parts=" + parts
				+ "]";
	}

	@Override
	public int compareTo(Item o) {
		return o.score - this.score;
	}

}
