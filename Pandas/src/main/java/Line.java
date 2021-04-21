import java.util.ArrayList;
import java.util.List;

public class Line {
	private int index;
	private ArrayList<Element> elements = new ArrayList<>();

	public Line() {
		new Line(0);
	}

	public Line(int index) {
		new Line(index, new ArrayList<>());
	}

	public Line(int index, ArrayList<Element> c) {
		this.index = index;
		this.elements = c;
	}

	public void add(Element e) {
		this.elements.add(e);
	}

	public Line getSubLineFromNumber(List<Integer> numbersOfColumns) {
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

	public Line getSubLineFromLabel(List<String> labelsOfColumns) {
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

	public void printLine() {
		String tmp = elements.get(0).toString();
		for (int i = 1; i < elements.size(); i++) {
			tmp = tmp.concat(", " + elements.get(i).toString());
		}
		System.out.println(tmp);
	}

//	@Override
//	public Object clone() {
//		try {
//			return (Line) super.clone();
//		} catch (CloneNotSupportedException e) {
//			return new Line(this.index, this.elements);
//		}
//	}

	@Override
	public String toString() {
		return index + " : " + elements + "\n";
	}
}
