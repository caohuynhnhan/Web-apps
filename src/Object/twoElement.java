package Object;

public class twoElement {
	private String e1;
	private String e2;
	public twoElement() {
		this.setE1("");
		this.setE2("");
	}
	
	public twoElement(String Element1, String Element2) {
		this.setE1(Element1);
		this.setE2(Element2);
	}
	public String getE1() {
		return e1;
	}
	public void setE1(String e1) {
		this.e1 = e1;
	}
	public String getE2() {
		return e2;
	}
	public void setE2(String e2) {
		this.e2 = e2;
	}
}
