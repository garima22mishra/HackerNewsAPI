package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.Item;

public class Temp {

	public static void main(String[] args) {
		String line  = "{\r\n"
				+ "  \"by\" : \"kpetermeni\",\r\n"
				+ "  \"descendants\" : 341,\r\n"
				+ "  \"id\" : 37036277,\r\n"
				+ "  \"kids\" : [ 37036744, 37037088, 37048815, 37037225, 37036911, 37037266, 37037000, 37037043, 37036585, 37047426, 37045267, 37036584, 37040500, 37038375, 37038204, 37037079, 37036768, 37037551, 37038360, 37038078, 37040698, 37038513, 37037174, 37038044, 37037104, 37037055, 37036733, 37036602, 37037207, 37041969, 37037269, 37037380, 37037111, 37036537, 37037986, 37038229 ],\r\n"
				+ "  \"score\" : 352,\r\n"
				+ "  \"time\" : 1691424324,\r\n"
				+ "  \"title\" : \"Police raid Worldcoin warehouse in Nairobi\",\r\n"
				+ "  \"type\" : \"story\",\r\n"
				+ "  \"url\" : \"https://www.capitalfm.co.ke/news/2023/08/police-raid-worldcoin-cryptocurrency-warehouse-in-nairobi/\"\r\n"
				+ "}";
		ObjectMapper json = new ObjectMapper();
		Item item;
		try {
			item = json.readValue(line, Item.class);
			System.out.println(item);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
