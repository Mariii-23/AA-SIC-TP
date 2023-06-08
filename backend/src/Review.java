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
public class Review {
	public Review() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_REVIEW_AUTHOR) {
			this.author = (_Costumer) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private _Costumer author;
	
	private int classification;
	
	private String comment;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setClassification(int value) {
		this.classification = value;
	}
	
	public int getClassification() {
		return classification;
	}
	
	public void setComment(String value) {
		this.comment = value;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setAuthor(_Costumer value) {
		this.author = value;
	}
	
	public _Costumer getAuthor() {
		return author;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
