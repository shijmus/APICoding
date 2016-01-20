package WalmartOpenAPI.Controller;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import WalmartOpenAPI.Model.SearchModel;
import WalmartOpenAPI.Utils.URLGeneratorUtils;

/**
 * A singleton pattern class to handle Search API calls
 * @author JS
 *
 */
public class SearchAPIResponse {
	private static SearchAPIResponse searchResponse = new SearchAPIResponse();

	private SearchAPIResponse() {
	}

	public static SearchAPIResponse getInstance() {
		return searchResponse;
	}
	
	/**
	 * A method to handle Search API calls 
	 * @param ug
	 *            An instance of URLGeneratorUtils class
	 * @param searchResult
	 *            An object of SearchModel objects
	 * @param searchMapper
	 *            An object of ObjectMapper class
	 * @return An SearchModel object containing search results
	 */
	public SearchModel search(String query) {
		URLGeneratorUtils ug = URLGeneratorUtils.getInstance();
		SearchModel searchResult = new SearchModel();
		ObjectMapper searchMapper = new ObjectMapper();

		try {
			searchResult = searchMapper.readValue(ug.getSearchURL(query),
					SearchModel.class);
		} catch (JsonParseException e) {
			System.out.println("Error In Parsing Search Results in Json Format");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			System.out.println("Error In Mapping Search Results in Json Format");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error In Reading Search Results in Json Format from Sever");
			e.printStackTrace();
		}

		if (searchResult.getItems().size() == 0) {
			System.out
					.println("The Search Returns 0 Results, Please Check Your Keyword And Start Over Again");
			System.exit(0);
		}
		return searchResult;
	}

}
