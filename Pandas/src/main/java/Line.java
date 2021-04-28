import java.util.ArrayList;
import java.util.List;

public class Line {
	private int index;
	private ArrayList<Element> elements = new ArrayList<>();


	/////////////////////////////////////////////////
	//                  Constructors               //
	/////////////////////////////////////////////////
	public Line() {
		new Line(0);
	}

	public Line(int index) {
		new Line(index, new ArrayList<Element>());
	}

	public Line(int index, ArrayList<Element> c) {
		this.index = index;
		this.elements = c;
	}

	/**
	 * Getter of Elements
	 *
	 * @return ArrayList<Element> of the line
	 */
	public ArrayList<Element> getElements(){
		return elements;
	}

	/**
	 * Get the element of the line at the index i
	 * @param i integer - the position to get the element from
	 * @return Element at the position i
	 */
	public Element getElementByIndex(int i) throws ExceptionWrongIndex{
		if (i < 0 || i >= this.elements.size()) {
			throw new ExceptionWrongIndex();
		}
		return elements.get(i);
	}

	/**
	 * Get the index of a given string element
	 *
	 * @param dataName Name of the element we want to find
	 * @return The index of the first element (-1 if not present)
	 */
	public int getIndexFromDataName(String dataName) {
		int toReturn = -1;
		for (Element e: elements) {
			if (e.toString().equals(dataName)) {
				return elements.indexOf(e);
			}
		}
		return toReturn;
	}

	/**
	 * Get the length of the line
	 * @return int - length of the line
	 */
	public int getSize() {
		return this.elements.size();
	}

	/**
	 * Add element to the line
	 *
	 * @param element Element to add
	 */
	public void add(Element element) {
		this.elements.add(element);
	}

	/**
	 * Get the sub line with given a sequence of index of column we want to keep.
	 * The column are added in the order of the sequence of index.
	 *
	 * @param numbersOfColumns The sequence of column we want to keep
	 * @return The sub line
	 */
	public Line getSubLineFromColumnNumber(List<Integer> numbersOfColumns) {
		ArrayList<Element> tmp = new ArrayList<>();
		int currentI = 0;
		int currentColumns = numbersOfColumns.get(currentI);
		for (int i = 0; i < this.elements.size(); i++) {
			if (i == currentColumns) {
				tmp.add(this.elements.get(i));
				currentI++;
				//Vraie condition de sortie, car numbersOfColumns peuvent ne pas être dans l'ordre
				if (currentI >= numbersOfColumns.size()) {
					break;
				} else if (numbersOfColumns.get(currentI) <= numbersOfColumns.get(currentI - 1)){
					i = 0;
				}
				currentColumns = numbersOfColumns.get(currentI);
			}
		}
		return new Line(this.index, tmp);
	}

	/**
	 * Get the sub line with given a sequence of index of column we want to keep.
	 * The column are added in the order of the sequence of index.
	 * Return null if the line don't contain the right value
	 *
	 * @param numbersOfColumns The sequence of column we want to keep
	 * @param valuesOfColumns The values of each column
	 * @return The sub line
	 */
	public Line selectLineWhere(List<Integer> numbersOfColumns, List<String> valuesOfColumns) throws ExceptionUnknownColumn {
		ArrayList<Element> tmp = new ArrayList<>();
		int currentI = 0;
		if( numbersOfColumns.get(currentI) < 0 || numbersOfColumns.get(currentI) >= this.elements.size()){
			throw new ExceptionUnknownColumn("One of the given index of column is not in the array");
		}
		int currentColumns = numbersOfColumns.get(currentI);
		for (int i = 0; i < this.elements.size(); i++) {

			if (i == currentColumns ) {
				if(this.elements.get(i).compareTo(valuesOfColumns.get(currentI)) != 0 ){
					return null;
				}
				tmp.add(this.elements.get(i));

				currentI++;
				if (currentI >= numbersOfColumns.size()) {
					i++;
					for(; i < this.elements.size(); i++){
						tmp.add(this.elements.get(i));
					}
					break;
				} else if (numbersOfColumns.get(currentI) <= numbersOfColumns.get(currentI - 1)){
					i = 0;
				}
				if( numbersOfColumns.get(currentI) < 0 || numbersOfColumns.get(currentI) >= this.elements.size()){
					throw new ExceptionUnknownColumn("One of the given index of column is not in the array");
				}
				currentColumns = numbersOfColumns.get(currentI);
			} else {
				tmp.add(this.elements.get(i));
			}
		}
		return new Line(this.index, tmp);
	}

	/**
	 * Get the sub line with given a sequence of label of column we want to keep.
	 *
	 * @param labelsOfColumns The sequence of label we want to keep
	 * @return The sub line
	 */
	public Line getSubColumnFromLabel(List<String> labelsOfColumns) {
		ArrayList<Element> tmp = new ArrayList<>();
		int currentI = 0;
		String currentColumns = labelsOfColumns.get(currentI);
		for (Element element : this.elements) {
			if (element.toString().equals(currentColumns)) {
				tmp.add(element);
				currentI++;
				if (currentI >= labelsOfColumns.size()) {
					break;
				}
				currentColumns = labelsOfColumns.get(currentI);
			}
		}
		return new Line(this.index, tmp);
	}

	/**
	 * Convert a line in string
	 *
	 * @return The line in string form
	 */
	@Override
	public String toString() {
		String tmp = elements.get(0).toString();
		for (int i = 1; i < elements.size(); i++) {
			tmp = tmp.concat(", " + elements.get(i).toString());
		}
		return tmp + "\n";
	}
}
