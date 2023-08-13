package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import pojo.CommentDetails;
import pojo.Story;
import util.HackerNewsUtil;

/**
 * Servlet implementation class HackerNewServlet
 * 
 * @author garima.m
 *
 */
@WebServlet(name = "HackerNewsAPI", urlPatterns = { "/api" })
public class HackerNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final ObjectMapper MAPPER = new ObjectMapper();

	private static final ObjectNode NODE = MAPPER.createObjectNode();

	public HackerNewsServlet() {
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action == null) {
			NODE.put("Status", "Failed");
			NODE.put("Reason", "Action is empty. Please provide valid action.");
			HackerNewsServlet.sendJsonResponse(MAPPER.writeValueAsString(NODE), response);
		}

		switch (action) {
		case "top-stories":
			this.getTopStories(request, response);
			break;

		case "past-stories":
			this.getPastStories(request, response);
			break;

		case "comments":
			this.getComments(request, response);
			break;
		}
	}

	/**
	 * Method to get top 10 stories ranked by the score in the last 15 minutes.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getTopStories(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String requestTimestamp = new Date(session.getLastAccessedTime()).toString();
		List<Story> topStories = HackerNewsUtil.getTopStories(requestTimestamp);

		if (topStories != null && !topStories.isEmpty()) {
			NODE.put("Status", "Success");
			NODE.putPOJO("Data", topStories);
		} else {
			NODE.put("Status", "Failed");
		}

		HackerNewsServlet.sendJsonResponse(MAPPER.writeValueAsString(NODE), response);
	}

	/**
	 * Method to get all the stories that were served previously from the 1st end
	 * point.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getPastStories(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Set<Story> pastStories = HackerNewsUtil.getPastStories();

		if (pastStories != null && !pastStories.isEmpty()) {
			NODE.put("Status", "Success");
			NODE.putPOJO("Data", pastStories);
		} else {
			NODE.put("Status", "Failed");
		}

		HackerNewsServlet.sendJsonResponse(MAPPER.writeValueAsString(NODE), response);
	}

	/**
	 * Method to get 10 comments (max) on a given story sorted by a total number of
	 * child comments.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getComments(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		List<CommentDetails> comments = HackerNewsUtil.getComments(id);

		if (comments != null && !comments.isEmpty()) {
			NODE.put("Status", "Success");
			NODE.putPOJO("Data", comments);
		} else {
			NODE.put("Status", "Failed");
		}

		HackerNewsServlet.sendJsonResponse(MAPPER.writeValueAsString(NODE), response);
	}

	/**
	 * Method to return JSON response.
	 * 
	 * @param result
	 * @param response
	 */
	private static void sendJsonResponse(String result, HttpServletResponse response) {
		response.setContentType("application/json");
		MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
		PrintWriter writer = null;

		try {
			writer = response.getWriter();
			writer.write(result);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
