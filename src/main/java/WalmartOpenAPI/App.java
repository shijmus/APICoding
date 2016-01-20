package WalmartOpenAPI;

import java.util.Scanner;
import java.util.TreeSet;

import WalmartOpenAPI.Controller.RecommendationAPIResponse;
import WalmartOpenAPI.Controller.SearchAPIResponse;
import WalmartOpenAPI.Model.ProductModel;
import WalmartOpenAPI.Model.CustomerProductModel;
import WalmartOpenAPI.Model.SearchModel;
import WalmartOpenAPI.Resources.APIParameters;
import WalmartOpenAPI.Utils.CustomerRankingUtils;
import WalmartOpenAPI.Utils.GetFirstSearchResultUtils;

/**
 * The program should invoke the Walmart Labs Open API to implement the
 * following workflow: 1. Search for products based upon a user-provided search
 * 2. string Use the first item in the search response as input for a product
 * recommendation search 3. Retrieve reviews of the first 10 product
 * recommendations 4. Rank order the recommended products based upon the review
 * sentiments
 * 
 * @author JS
 * 
 */

public class App {
	public static void main(String args[]) {

		/**
		 * Customer input handling
		 * 
		 * @param query
		 *            User input search sting
		 */
		String query = null;
		System.out.println("Please Input The Item You Want To Search:");
		try (Scanner sc = new Scanner(System.in);) {
			query = sc.next();
		}

		/**
		 * Perform customer search and get the first element in search result
		 * 
		 * @param searchResponse
		 *            Get an Instance of the SearchAPIResponse class
		 * @param searchResult
		 *            A SearchModel object containing search result *
		 */
		SearchAPIResponse searchResponse = SearchAPIResponse.getInstance();
		SearchModel searchResult = searchResponse.search(query);
		GetFirstSearchResultUtils.getFirst(searchResult);
		System.out
				.println("\nUsing The First Search Result as as input for a product recommendation search:");
		System.out.println("First Product In Search Result, Item Id = "
				+ APIParameters.firstItemInSearch);

		/**
		 * User the first element in search result to get an array of
		 * recommended products
		 * 
		 * @param recommendResponse
		 *            Get an Instance of the RecommendationAPIResponse class
		 * @param pmarr
		 *            An array that contains recommended products
		 * @param size
		 *            Number of items in the recommended products array
		 */
		RecommendationAPIResponse recommendResponse = RecommendationAPIResponse
				.getInstance();
		ProductModel[] pmarr = recommendResponse.search();
		int size = pmarr.length > 10 ? 10 : pmarr.length;
		System.out.println("\nFirst 10 Product Recommendations are:");
		CustomerRankingUtils.initialize(pmarr, size);
		CustomerRankingUtils.generateUnsortedResults();
	
		/**
		 * Perform customer ranking of the recommended products based on average
		 * overall ratings
		 * 
		 * @param customerResults
		 *            Sorted products set based on average ratings. The results
		 *            were constructed into ProductWithRating Model type,
		 *            highest rated product ranks first
		 */
		TreeSet<CustomerProductModel> customerResults = CustomerRankingUtils
				.customerRank();

		/**
		 * Output customer ranking results, with average overall ratings,
		 * product item ID, product name being the categories
		 * 
		 * @param it
		 *            Iterator to traverse customerResults TreeSet
		 * 
		 */
		System.out
				.println("\nRecommended Products Based On Customer Overall Ratings:\n");
		System.out.println("Rating\tProduct ID\tProduct Name");
		CustomerRankingUtils.printSortedResults(customerResults);
	}
}