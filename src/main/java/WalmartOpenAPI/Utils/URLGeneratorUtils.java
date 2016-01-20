package WalmartOpenAPI.Utils;

import java.net.MalformedURLException;
import java.net.URL;

import WalmartOpenAPI.Resources.APIParameters;

/**
 * A utility class to generate URLs used in Search API, Product Recommendation
 * API and Reviews API
 * 
 * @author JS
 *
 */
public class URLGeneratorUtils {

	private static URLGeneratorUtils ug = new URLGeneratorUtils();

	private URLGeneratorUtils() {
	};

	public static URLGeneratorUtils getInstance() {
		return ug;
	}

	public URL getSearchURL(String query) {
		try {
			return new URL(APIParameters.SEARCH_URL + query);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public URL getRecommendationURL() {
		try {
			return new URL(APIParameters.PRODUCT_RECOMENDATION_URL
					+ APIParameters.firstItemInSearch);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public URL getReviewURL(String itemId) {
		try {
			return new URL(APIParameters.REVIEWS_URL + itemId
					+ APIParameters.KEY + "&format=xml");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
