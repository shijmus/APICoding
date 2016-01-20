package WalmartOpenAPI.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A data model class abstracted from
 * https://developer.walmartlabs.com/docs/read/Search_API
 * 
 * @author JS
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchModel {
	private String query;
	private String sort;
	private String format;
	private String responseGroup;
	private String start;
	private String numItems;
	private List<ProductModel> items = new ArrayList<>();

	public String getQuery() {
		return query;
	}

	public String getSort() {
		return sort;
	}

	public String getFormat() {
		return format;
	}

	public String getResponseGroup() {
		return responseGroup;
	}

	public String getStart() {
		return start;
	}

	public String getNumItems() {
		return numItems;
	}

	public List<ProductModel> getItems() {
		return items;
	}

}
