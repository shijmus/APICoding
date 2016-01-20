package WalmartOpenAPI.Resources;

/**
 * A utility class containing API parameters
 * @author Owner
 *
 */
public class APIParameters {

	public static final String KEY = "?apiKey=sr8gntsqnbp64a97tavt8jsv";

	public static final String BASE_URL = "http://api.walmartlabs.com/v1/";

	public static final String SEARCH_URL = BASE_URL + "search" + KEY + "&query=";

	public static String firstItemInSearch = "";
	
	public static final String PRODUCT_RECOMENDATION_URL = BASE_URL + "nbp" + KEY + "&itemId=";	
	
	public static String reviewItemId = "";
	
	public static final String REVIEWS_URL = BASE_URL + "reviews/";

}
