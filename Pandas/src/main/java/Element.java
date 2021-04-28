
public class Element<E> implements Comparable<E>{
	private E data;
	
	public Element(E data) {
		this.data = data;
	}

	/**
	 * Return the current value of the element
	 *
	 * @return The data of the element
	 */
	public E getElem() {
		return data;
	}

	/**
	 * Change the current value of the element
	 *
	 * @param newData  the newData of the element
	 */
	public void setElem(E newData) {
		this.data = newData;
	}

	/**
	 * Return the string value of the element
	 *
	 * @return The string version of the element
	 */
	@Override
	public String toString() {
		return data.toString();
	}

	@Override
	public int compareTo(E e) {
		String tmp1 = e.toString();
		String tmp2 = this.data.toString();
		return tmp2.compareTo(tmp1);
	}
}
