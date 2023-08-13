package util;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import pojo.CommentDetails;
import pojo.Item;
import pojo.Story;

/**
 * Utility class for HackerNewsServlet.java
 * 
 * @author garima.m
 *
 */
public class HackerNewsUtil {
	private static final ObjectMapper MAPPER;
	/**
	 * cache set contains all the stories that are returned as top 10 stories to the
	 * user.
	 */
	public static Set<Story> cache;

	/**
	 * lastStorySent contains the most recent list of stories that is returned as
	 * top 10 stories.
	 */
	public static List<Story> lastStorySent;

	/**
	 * lastRequestTimestamp is the time when top-stories is requested by the user.
	 */
	public static String lastRequestTimestamp;

	static {
		MAPPER = new ObjectMapper();
		cache = new HashSet<>();
		lastStorySent = new ArrayList<>();
	}

	/**
	 * Method returns true if request to top-stories is made before 15 minutes.
	 * 
	 * @param currentRequestTimestamp
	 * @return
	 */
	public static Boolean getRequestTimestamp(String currentRequestTimestamp) {

		if (lastRequestTimestamp == null || lastRequestTimestamp.isEmpty()) {
			lastRequestTimestamp = currentRequestTimestamp;
			return true;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

		try {
			Date currentDate = sdf.parse(currentRequestTimestamp);
			Date lastDate = sdf.parse(lastRequestTimestamp);

			// Calculating the difference in minutes
			long difference = (Math.abs(lastDate.getTime() - currentDate.getTime()) / (60 * 1000)) % 60;

			// If the time difference in last request and most recent request to top-stories
			// api is more than 15 minutes then return false
			if (difference > 15) {
				lastRequestTimestamp = currentRequestTimestamp;
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return true;

	}

	/**
	 * Method returns the top 10 stories ranked by the score in the last 15 minutes.
	 * Each story contains details like title, URL, score, time of submission, and
	 * the user who submitted it.
	 * 
	 * @param requestTimestamp
	 * @return
	 */
	public static List<Story> getTopStories(String requestTimestamp) {

		Boolean requestedBefore15Minutes = HackerNewsUtil.getRequestTimestamp(requestTimestamp);

		// If top-stories is requested before 15 minutes than the last request then
		// return the last response of top-stories
		if ((lastStorySent != null && !lastStorySent.isEmpty()) && requestedBefore15Minutes) {
			return lastStorySent;
		}

		List<String> ids = HackerNewsUtil.getIds();
		List<Item> itemDetails = HackerNewsUtil.getItemDetailsForIds(ids);
		Collections.sort(itemDetails);

		List<Story> topTenStories = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			Item item = itemDetails.get(i);

			String title = item.getTitle();
			String url = item.getUrl();
			Integer score = item.getScore();
			Long time = item.getTime();
			String user = item.getBy();

			Story story = new Story(title, url, score, time, user);

			topTenStories.add(story);
		}
		// Update the cache with top 10 stories
		cache.addAll(topTenStories);

		// Clear the last story sent and update it with most recent stories
		lastStorySent.clear();
		lastStorySent.addAll(topTenStories);

		return topTenStories;
	}

	/**
	 * Method returns all the stories that were served previously from the 1st end
	 * point (/top-stories).
	 * 
	 * @return
	 */
	public static Set<Story> getPastStories() {
		return cache;
	}

	/**
	 * Method returns 10 comments (max) on a given story sorted by a total number of
	 * child comments. Each comment contains comment text, the user’s hacker news
	 * handle.
	 * 
	 * @param id
	 * @return
	 */
	public static List<CommentDetails> getComments(String id) {
		Item item = HackerNewsUtil.getItem(id);
		List<CommentDetails> commentDetailsList = new ArrayList<>(10);

		if (item != null) {
			// List of child comments
			List<Long> kids = item.getKids();

			if (kids != null && !kids.isEmpty()) {
				for (Long kidId : kids) {
					// Fetch details for each child comment
					Item child = HackerNewsUtil.getItem(kidId.toString());
					String comment = child.getText();
					String user = child.getBy();

					// If comment text or user is empty then skip this child comment
					if (comment == null && user == null)
						continue;

					// Get child comments for current comment
					List<Long> kidsKids = child.getKids();

					// If child comment list is null then the score is 0
					Integer score = (kidsKids != null && !kidsKids.isEmpty()) ? kidsKids.size() : 0;

					CommentDetails commentDetails = new CommentDetails(comment, user, score);
					commentDetailsList.add(commentDetails);
				}
			}
			// Sort the comment list on the basis of its child comment count
			Collections.sort(commentDetailsList);
		}

		return commentDetailsList.subList(0, 10);
	}

	/**
	 * Method returns up to 500 top stories
	 * 
	 * @return
	 */
	public static List<String> getIds() {
		URL u;
		List<String> ids = new ArrayList<>();

		try {
			u = new URL("https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty");
			JsonNode jsonNode = get(u);
			ObjectReader reader = MAPPER.readerFor(new TypeReference<List<String>>() {
			});
			ids = reader.readValue(jsonNode);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ids;
	}

	/**
	 * Method returns Item details such as by, descendants, id, kids, score, time,
	 * title, type, url, deleted, text, dead, parent, poll, parts for list of story
	 * ids.
	 * 
	 * @param ids
	 * @return
	 */
	public static List<Item> getItemDetailsForIds(List<String> ids) {
		List<Item> items = new ArrayList<>();

		try {
			for (String id : ids) {
				Item item = HackerNewsUtil.getItem(id);
				items.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	/**
	 * Method returns Item details such as by, descendants, id, kids, score, time,
	 * title, type, url, deleted, text, dead, parent, poll, parts for a single id.
	 * 
	 * @param id
	 * @return
	 */
	public static Item getItem(String id) {
		URL u;
		Item item = null;

		try {
			u = new URL("https://hacker-news.firebaseio.com/v0/item/" + id + ".json?print=pretty");
			JsonNode jsonNode = get(u);
			item = MAPPER.treeToValue(jsonNode, Item.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	/**
	 * Method to get the data for given URL
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static JsonNode get(URL url) throws IOException {
		return MAPPER.readTree(url);
	}

}
