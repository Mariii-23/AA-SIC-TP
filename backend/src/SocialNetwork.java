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
public class SocialNetwork {
	public SocialNetwork() {
	}
	
	private int ID;
	
	private String name;
	
	private String link;
	
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
	
	public void setLink(String value) {
		this.link = value;
	}
	
	public String getLink() {
		return link;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
