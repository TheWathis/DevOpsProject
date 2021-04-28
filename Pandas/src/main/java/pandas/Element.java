package pandas;

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
	public E getData() {
		return data;
	}

	/**
	 * Change the current value of the element
	 *
	 * @param newData  the newData of the element
	 */
	public void setData(E newData) {
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

	/**
	 * -1 si e est plus grand
	 * 0 si e et this sont égaux
	 * 1 si this est plus grand
	 * @param e
	 * @return
	 */
	@Override
	public int compareTo(E e) {
		int result = Integer.min(Integer.max(this.data.toString().length() - e.toString().length(), -1), 1);
		if (result == 0) {
			int i = 0;
			while (i < e.toString().length()) {

				char c = this.data.toString().charAt(i);
				char c_bis = e.toString().charAt(i);

				if ((c - c_bis) < 0) {
					return -1;
				} else if ((c - c_bis) > 0) {
					return 1;
				}
				//c et c_bis sont égaux jusque là, je vais voir plus loin
				i++;
			}
			//Si je suis ici ce sont les mêmes
			return 0;
		}
		return result;
	}
}
