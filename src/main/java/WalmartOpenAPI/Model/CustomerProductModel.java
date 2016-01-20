package WalmartOpenAPI.Model;

/**
 * A data model class constructed with ProductModel and average overall ratings
 * @author JS
 *
 */
public class CustomerProductModel {
	public ProductModel productModel;
	public Double averageOverallRating;	
	
	public CustomerProductModel(ProductModel pm, Double averageOverallRating){
		this.productModel = pm;
		this.averageOverallRating = averageOverallRating;		
	}

	public ProductModel getProductModel() {
		return productModel;
	}

	public Double getAverageOverallRating() {
		return averageOverallRating;
	}
	
}
