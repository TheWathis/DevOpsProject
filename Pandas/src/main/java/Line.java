import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Line {
	private int index;
	private ArrayList<Element> elements = new ArrayList<>();

	public ArrayList<Element> getElements(){
		return elements;
	}

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
	 * Add element to the line
	 *
	 * @param element Element to add
	 */
	public void add(Element element) {
		this.elements.add(element);
	}

	/**
	 * Get the sub line with given a sequence of index of column we want to keep.
	 *
	 * @param numbersOfColumns The sequence of column we want to keep
	 * @return The sub line
	 */
	public Line getSubColumnFromNumber(List<Integer> numbersOfColumns) {
		ArrayList<Element> tmp = new ArrayList<>();
		int currentI = 0;
		int currentColumns = numbersOfColumns.get(currentI);
		for (int i = 0; i < this.elements.size(); i++) {
			if (i == currentColumns) {
				tmp.add(this.elements.get(i));
				currentI++;
				if (currentI >= numbersOfColumns.size()) {
					break;
				}
				currentColumns = numbersOfColumns.get(currentI);
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
	 * Get the index of a given string element
	 *
	 * @param dataName Name of the element we want to find
	 * @return The index of the element
	 */
	public int getIndex(String dataName) {
		int toReturn = -1;
		for (Element e: elements) {
			if (e.toString().equals(dataName)) {
				toReturn = elements.indexOf(e);
				break;
			}
		}
		return toReturn;
	}

	/**
	 * Print the line
	 *
	 */
	public void printLine() {
		String tmp = elements.get(0).toString();
		for (int i = 1; i < elements.size(); i++) {
			tmp = tmp.concat(", " + elements.get(i).toString());
		}
		System.out.println(tmp);
	}

	/**
	 * Convert a line in string
	 *
	 */
	@Override
	public String toString() {
		return index + " : " + elements + "\n";
	}
}
