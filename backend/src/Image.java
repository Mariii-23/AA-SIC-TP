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
public class Image {
	public Image() {
	}
	
	private int ID;
	
	private String path;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setPath(String value) {
		this.path = value;
	}
	
	public String getPath() {
		return path;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
