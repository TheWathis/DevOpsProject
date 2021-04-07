import java.util.ArrayList;
import java.util.List;

public class Colonnes <E>{
	String label;
	List<E> elems;
	
	public Colonnes(String l) {
		label = l;
		elems = new ArrayList<>();
	}
	
	public void addElem(int index,E e) {
		elems.add(index, e);
	}
	
	public E removeElem(int index) {
		return elems.remove(index);
	}
	
	public boolean sameLabel(String l) {
		return label.equals(l);
	}

	public E getElem(int index) {
		return elems.get(index);
	}
}
