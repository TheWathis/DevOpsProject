
public class Element<E>{
	private E data;
	
	public Element(E l) {
		data = l;
	}

	public E getElem() {
		return data;
	}
	public void setElem(E e) {
		data = e;
	}
}
