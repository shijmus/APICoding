package WalmartOpenAPI.Utils;

import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import WalmartOpenAPI.Model.ProductModel;
import WalmartOpenAPI.Model.CustomerProductModel;

/**
 * A utility class to generate a TreeSet of CustomerProductModel objects and
 * handles the print function
 * 
 * @author JS
 *
 */
public class CustomerRankingUtils {
	public static TreeSet<CustomerProductModel> customerResults;
	public static ProductModel[] pmarr;
	public static int size;
	
	public static void initialize(ProductModel[] pmarr, int size) {
		CustomerRankingUtils.pmarr = pmarr;
		CustomerRankingUtils.size = size;
	}

	public static void generateUnsortedResults() {
		double[] averageReviews = new double[size];
		customerResults = new TreeSet<CustomerProductModel>(
				new TreeSetComparatorUtils());
		URLGeneratorUtils ug = URLGeneratorUtils.getInstance();
		Document document = null;
		for (int i = 0; i < size; i++) {
			try {
				SAXReader reader = new SAXReader();
				document = reader.read(ug.getReviewURL(pmarr[i].getItemId()));
			} catch (DocumentException e) {
				System.out.println("Error In Reading Product Reviews");
				e.printStackTrace();
			}

			@SuppressWarnings("unchecked")
			List<Node> list_reviews = document
					.selectNodes("//itemReview/reviewStatistics/averageOverallRating");
			averageReviews[i] = Double.parseDouble(list_reviews.get(0)
					.getStringValue());

			customerResults.add(new CustomerProductModel(pmarr[i],
					averageReviews[i]));
			System.out.println("Item ID = " + pmarr[i].getItemId() + "\t"
					+ "Average Review Rating = " + averageReviews[i]);
		}
	}

	public static TreeSet<CustomerProductModel> customerRank() {
		return customerResults;
	}

	public static void printSortedResults(
			TreeSet<CustomerProductModel> customerResults) {
		System.out
				.println("\nRecommended Products Based On Customer Overall Ratings:");
		System.out.println("Rating\tProduct ID\tProduct Name");
		Iterator<CustomerProductModel> it = customerResults.iterator();
		while (it.hasNext()) {
			CustomerProductModel pwr = (CustomerProductModel) it.next();
			System.out.println(pwr.getAverageOverallRating() + "\t"
					+ pwr.getProductModel().getItemId() + "\t"
					+ pwr.getProductModel().getName());
		}
	}
}
