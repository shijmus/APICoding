package WalmartOpenAPI.Utils;

import WalmartOpenAPI.Model.SearchModel;
import WalmartOpenAPI.Resources.APIParameters;

/**
 * A utility class to choose the first element in Search API results
 * @author JS
 *
 */
public class GetFirstSearchResultUtils {

	public static void getFirst(SearchModel searchResult) {
		APIParameters.firstItemInSearch = searchResult.getItems().get(0)
				.getItemId();
	}
}
