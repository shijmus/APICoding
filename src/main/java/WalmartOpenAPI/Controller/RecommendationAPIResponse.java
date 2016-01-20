package WalmartOpenAPI.Controller;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import WalmartOpenAPI.Model.ProductModel;
import WalmartOpenAPI.Utils.URLGeneratorUtils;

/**
 * A singleton pattern class to handle Product Recommendation API calls
 * 
 * @author JS
 *
 */
public class RecommendationAPIResponse {
	private static RecommendationAPIResponse recommendResponse = new RecommendationAPIResponse();

	private RecommendationAPIResponse() {
	}

	public static RecommendationAPIResponse getInstance() {
		return recommendResponse;
	}

	/**
	 * A method to handle Product Recommendation API calls
	 * @param ug
	 *            An instance of URLGeneratorUtils class
	 * @param pmarr
	 *            An array of ProductModel objects
	 * @param mapper
	 *            An object of ObjectMapper class
	 * @return An array of ProductModel objects containing recommended products
	 */
	public ProductModel[] search() {
		URLGeneratorUtils ug = URLGeneratorUtils.getInstance();
		ProductModel[] pmarr = new ProductModel[10];
		ObjectMapper mapper = new ObjectMapper();

		try {
			pmarr = mapper.readValue(ug.getRecommendationURL(),
					ProductModel[].class);
		} catch (JsonParseException e) {
			System.out
					.println("Error In Parsing Product Recommendation Data In Json Format");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			System.out
					.println("Error In Mapping Product Recommendation Data In Json Format");
			e.printStackTrace();
		} catch (IOException e) {
			System.out
					.println("Error In Reading Product Recommendation Data in Json Format from Sever");
			e.printStackTrace();
		}

		if (pmarr.length == 0) {
			System.out
					.println("The Current Item Results In No Recommended Products, Please Check Your Keyword And Start Over Again");
			System.exit(0);
		}
		return pmarr;
	}

}
