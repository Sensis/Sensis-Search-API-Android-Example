package au.com.louth.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class APIResponse {

	@JsonProperty(value="results")
	private List<Business> businesses;

	public List<Business> getBusinesses() {
		return businesses;
	}

	public void setBusinesses(List<Business> businesses) {
		this.businesses = businesses;
	}

}
