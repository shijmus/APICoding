package WalmartOpenAPI.Model;

import java.net.URL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A data model class abstracted from
 * https://developer.walmartlabs.com/docs/read/Product_Recommendation_API
 * 
 * @author JS
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductModel {

	private String itemId;
	private String parentItemId;
	private String name;
	private float msrp;
	private float salePrice;
	private String upc;
	private String categoryPath;
	private String shortDescription;
	private String longDescription;
	private String brandName;
	private URL thumbnailImage;
	private URL mediumImage;
	private URL largeImage;
	private URL productTrackingUrl;
	private boolean ninetySevenCentShipping;
	private float standardShipRate;
	private float twoThreeDayShippingRate;
	private float overnightShippingRate;
	private boolean marketplace;
	private boolean shipToStore;
	private boolean freeShipToStore;
	private String modelNumber;
	private URL productUrl;
	private String customerRating;
	private int numReviews;
	private URL customerRatingImage;
	private String categoryNode;
	private boolean rollBack;
	private boolean bundle;
	private boolean clearance;
	private boolean preOrder;
	private String stock;
	private boolean availableOnline;
	public String getItemId() {
		return itemId;
	}
	public String getParentItemId() {
		return parentItemId;
	}
	public String getName() {
		return name;
	}
	public float getMsrp() {
		return msrp;
	}
	public float getSalePrice() {
		return salePrice;
	}
	public String getUpc() {
		return upc;
	}
	public String getCategoryPath() {
		return categoryPath;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public String getLongDescription() {
		return longDescription;
	}
	public String getBrandName() {
		return brandName;
	}
	public URL getThumbnailImage() {
		return thumbnailImage;
	}
	public URL getMediumImage() {
		return mediumImage;
	}
	public URL getLargeImage() {
		return largeImage;
	}
	public URL getProductTrackingUrl() {
		return productTrackingUrl;
	}
	public boolean isNinetySevenCentShipping() {
		return ninetySevenCentShipping;
	}
	public float getStandardShipRate() {
		return standardShipRate;
	}
	public float getTwoThreeDayShippingRate() {
		return twoThreeDayShippingRate;
	}
	public float getOvernightShippingRate() {
		return overnightShippingRate;
	}
	public boolean isMarketplace() {
		return marketplace;
	}
	public boolean isShipToStore() {
		return shipToStore;
	}
	public boolean isFreeShipToStore() {
		return freeShipToStore;
	}
	public String getModelNumber() {
		return modelNumber;
	}
	public URL getProductUrl() {
		return productUrl;
	}
	public String getCustomerRating() {
		return customerRating;
	}
	public int getNumReviews() {
		return numReviews;
	}
	public URL getCustomerRatingImage() {
		return customerRatingImage;
	}
	public String getCategoryNode() {
		return categoryNode;
	}
	public boolean isRollBack() {
		return rollBack;
	}
	public boolean isBundle() {
		return bundle;
	}
	public boolean isClearance() {
		return clearance;
	}
	public boolean isPreOrder() {
		return preOrder;
	}
	public String getStock() {
		return stock;
	}
	public boolean isAvailableOnline() {
		return availableOnline;
	}


}