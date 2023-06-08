/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: mariana(Universidade do Minho)
 * License Type: Academic
 */
public class Company {
	public Company() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_COMPANY_SOCIALNETWORKS) {
			return ORM_socialNetworks;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int ID;
	
	private String name;
	
	private String email;
	
	private int contact;
	
	private String address;
	
	private String logoImage;
	
	private String postCode;
	
	private String schedule;
	
	private java.util.Set ORM_socialNetworks = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setContact(int value) {
		this.contact = value;
	}
	
	public int getContact() {
		return contact;
	}
	
	public void setAddress(String value) {
		this.address = value;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setLogoImage(String value) {
		this.logoImage = value;
	}
	
	public String getLogoImage() {
		return logoImage;
	}
	
	public void setPostCode(String value) {
		this.postCode = value;
	}
	
	public String getPostCode() {
		return postCode;
	}
	
	public void setSchedule(String value) {
		this.schedule = value;
	}
	
	public String getSchedule() {
		return schedule;
	}
	
	private void setORM_SocialNetworks(java.util.Set value) {
		this.ORM_socialNetworks = value;
	}
	
	private java.util.Set getORM_SocialNetworks() {
		return ORM_socialNetworks;
	}
	
	public final SocialNetworkSetCollection socialNetworks = new SocialNetworkSetCollection(this, _ormAdapter, ORMConstants.KEY_COMPANY_SOCIALNETWORKS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
