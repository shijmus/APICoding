package WalmartOpenAPI.Utils;

import java.util.Comparator;

import WalmartOpenAPI.Model.CustomerProductModel;

/**
 * A utility class that implements Comparator class, that will sort
 * CustomerProductModel objects based on average overall ratings
 * 
 * @author JS
 *
 */
public class TreeSetComparatorUtils implements Comparator<CustomerProductModel> {

	public int compare(CustomerProductModel pwr1, CustomerProductModel pwr2) {
		if (pwr1.averageOverallRating > pwr2.averageOverallRating)
			return -1;
		else if (pwr1.averageOverallRating < pwr2.averageOverallRating)
			return 1;
		else
			return Integer.parseInt(pwr1.getProductModel().getItemId())
					- Integer.parseInt(pwr2.getProductModel().getItemId());
	}
}
