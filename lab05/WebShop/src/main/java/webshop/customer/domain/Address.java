package webshop.customer.domain;

/**
 * Address (Value Object)
 * 
 * @author mbeshir
 *
 */
public final class Address {

	private String street;

	private String city;

	private Integer zip;

	private String country;


	public Address(String street, String city, Integer zip, String country) {
		super();
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public Integer getZip() {
		return zip;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", zip=" + zip + ", country=" + country + "]";
	}
	
	

}
