
public class Element<E>{
	private E data;
	
	public Element(E l) {
		this.data = l;
	}

	public E getElem() {
		return data;
	}
	public void setElem(E e) {
		data = e;
	}

//	@Override
//	public Object clone() {
//		try {
//			return (Element) super.clone();
//		} catch (CloneNotSupportedException e) {
//			return new Element(data);
//		}
//	}

	@Override
	public String toString() {
		return data.toString();
	}
}
