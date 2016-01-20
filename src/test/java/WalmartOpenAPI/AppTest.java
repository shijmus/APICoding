package WalmartOpenAPI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.TreeSet;

import org.junit.BeforeClass;
import org.junit.Test;

import WalmartOpenAPI.Controller.RecommendationAPIResponse;
import WalmartOpenAPI.Controller.SearchAPIResponse;
import WalmartOpenAPI.Model.CustomerProductModel;
import WalmartOpenAPI.Model.ProductModel;
import WalmartOpenAPI.Model.SearchModel;
import WalmartOpenAPI.Resources.APIParameters;
import WalmartOpenAPI.Resources.TestParameters;
import WalmartOpenAPI.Utils.CustomerRankingUtils;
import WalmartOpenAPI.Utils.GetFirstSearchResultUtils;

/**
 * Unit test class
 */

public class AppTest {
	/**
	 * Test the Search API
	 */
	@Test
	public void searchAPITest() {
		SearchAPIResponse searchResponse = SearchAPIResponse.getInstance();
		SearchModel searchResult = searchResponse.search("tv");
		assertNotNull("The search with keyword \"tv\" returns empty results",
				searchResult.getItems());
		GetFirstSearchResultUtils.getFirst(searchResult);
		assertEquals("Search returns wrong results", "27608624",
				APIParameters.firstItemInSearch);
	}

	/**
     * 
     */
	private static ProductModel[] pmarr;
	private static int size;

	@BeforeClass
	public static void recommendationAPIPrepare() {
		APIParameters.firstItemInSearch = "27608624";
		RecommendationAPIResponse recommendResponse = RecommendationAPIResponse
				.getInstance();
		pmarr = recommendResponse.search();
		size = pmarr.length > 10 ? 10 : pmarr.length;
	}

	@Test
	public void recommendationAPITest() {

		assertNotNull("The Product Recommendation Returns Empty Result", pmarr);
		for (int i = 0; i < size; i++) {
			assertEquals("Product Recommendation returns wrong list",
					TestParameters.recommItemIdArray[i], pmarr[i].getItemId()
							.toString());
		}
	}
	
	@BeforeClass
	public static void initialize(){
		CustomerRankingUtils.initialize(pmarr, size);
		CustomerRankingUtils.generateUnsortedResults();
		System.setOut(null);
	}
	@Test
	public void reviewsAPITest() {
		TreeSet<CustomerProductModel> customerResults = CustomerRankingUtils
				.customerRank();
		assertNotNull("Reviews API returns null list", customerResults);
		int i = 0;
		for (CustomerProductModel cpm : customerResults) {
			assertEquals("Sorted product set does not give right order", TestParameters.averageRating[i],
					cpm.getAverageOverallRating());
			i++;
		}
	}
}
