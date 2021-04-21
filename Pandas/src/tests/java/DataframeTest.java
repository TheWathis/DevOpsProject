import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.util.ArrayList;

public class DataframeTest {

	/**
	 * Test on get sub of data frame with sequence of line
	 * */
	@Test
	public void testGetSubDataFrameFromLines() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element(1));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element(1995));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element(10));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element(1870));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element(5));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element(2010));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Integer> indexOfColumn = new ArrayList<>();
		indexOfColumn.add(0);
		indexOfColumn.add(1);
		indexOfColumn.add(2);

		Dataframe dtSub = dt.getSubDataFrameFromLines(indexOfColumn);
		assertEquals(dt.toString(), dtSub.toString());
	}

	@Test
	public void testGetSubDataFrameFromFirstLine() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element(1));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element(10));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element(5));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Integer> indexOfColumn = new ArrayList<>();
		indexOfColumn.add(0);

		Dataframe dtSub = dt.getSubDataFrameFromLines(indexOfColumn);

		boolean resultAssert = true;
		ArrayList<Line> listOfLine = dt.getLines();
		ArrayList<Line> listOfSubLine = dtSub.getLines();
		if(listOfLine.get(0).getElements().get(0).getElem() != listOfSubLine.get(0).getElements().get(0).getElem() ){
			resultAssert = false;
		}
		assertTrue(resultAssert);
	}

	@Test
	public void testGetSubDataFrameFromLastLine() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element(1));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element(10));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element(5));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Integer> indexOfColumn = new ArrayList<>();
		indexOfColumn.add(2);

		Dataframe dtSub = dt.getSubDataFrameFromLines(indexOfColumn);

		boolean resultAssert = true;
		ArrayList<Line> listOfLine = dt.getLines();
		ArrayList<Line> listOfSubLine = dtSub.getLines();
		if(listOfLine.get(2).getElements().get(0).getElem() != listOfSubLine.get(0).getElements().get(0).getElem() ){
			resultAssert = false;
		}
		assertTrue(resultAssert);
	}

	@Test
	public void testGetSubDataFrameFromSameLine() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element(1));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element(10));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element(5));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Integer> indexOfColumn = new ArrayList<>();
		indexOfColumn.add(2);
		indexOfColumn.add(2);

		Dataframe dtSub = dt.getSubDataFrameFromLines(indexOfColumn);

		boolean resultAssert = true;
		ArrayList<Line> listOfLine = dt.getLines();
		ArrayList<Line> listOfSubLine = dtSub.getLines();
		if(listOfLine.get(2).getElements().get(0).getElem() != listOfSubLine.get(0).getElements().get(0).getElem()
			|| listOfLine.get(2).getElements().get(0).getElem() != listOfSubLine.get(1).getElements().get(0).getElem()){
			resultAssert = false;
		}
		assertTrue(resultAssert);
	}

	/**
	 * Test on get sub of data frame with sequence of column number
	 * */
	@Test
	public void testGetSubDataFrameFromColumnsNumber() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element(1));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element(1995));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element(10));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element(1870));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element(5));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element(2010));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Integer> indexOfColumn = new ArrayList<>();
		indexOfColumn.add(0);
		indexOfColumn.add(1);
		indexOfColumn.add(2);

		Dataframe dtSub = dt.getSubDataFrameFromColumnsNumber(indexOfColumn);
		assertEquals(dt.toString(), dtSub.toString());
	}

	@Test
	public void testGetSubDataFrameFromFirstColumnsNumber() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element(1));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element(1995));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element(10));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element(1870));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element(5));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element(2010));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Integer> indexOfColumn = new ArrayList<>();
		indexOfColumn.add(0);

		Dataframe dtSub = dt.getSubDataFrameFromColumnsNumber(indexOfColumn);

		boolean resultAssert = true;
		ArrayList<Line> listOfLine = dt.getLines();
		ArrayList<Line> listOfSubLine = dtSub.getLines();
		if(listOfLine.get(0).getElements().get(0).getElem() != listOfSubLine.get(0).getElements().get(0).getElem() ){
			resultAssert = false;
		}
		assertTrue(resultAssert);
	}

	@Test
	public void testGetSubDataFrameFromLastColumnsNumber() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element(1));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element(1995));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element(10));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element(1870));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element(5));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element(2010));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Integer> indexOfColumn = new ArrayList<>();
		indexOfColumn.add(2);

		Dataframe dtSub = dt.getSubDataFrameFromColumnsNumber(indexOfColumn);

		boolean resultAssert = true;
		ArrayList<Line> listOfLine = dt.getLines();
		ArrayList<Line> listOfSubLine = dtSub.getLines();
		if(listOfLine.get(0).getElements().get(2).getElem()
				!= listOfSubLine.get(0).getElements().get(0).getElem()
			|| listOfLine.get(1).getElements().get(2).getElem()
				!= listOfSubLine.get(1).getElements().get(0).getElem()
			|| listOfLine.get(2).getElements().get(2).getElem()
				!= listOfSubLine.get(2).getElements().get(0).getElem()
			|| listOfSubLine.size() != 3){
			resultAssert = false;
		}
		assertTrue(resultAssert);
	}

	@Test
	public void testGetSubDataFrameFromSameColumnsNumber() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element(1));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element(1995));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element(10));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element(1870));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element(5));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element(2010));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Integer> indexOfColumn = new ArrayList<>();
		indexOfColumn.add(2);
		indexOfColumn.add(2);

		Dataframe dtSub = dt.getSubDataFrameFromColumnsNumber(indexOfColumn);

		boolean resultAssert = true;
		ArrayList<Line> listOfLine = dt.getLines();
		ArrayList<Line> listOfSubLine = dtSub.getLines();
		if(listOfLine.get(0).getElements().get(2).getElem()
				!= listOfSubLine.get(0).getElements().get(0).getElem()
				|| listOfLine.get(1).getElements().get(2).getElem()
				!= listOfSubLine.get(1).getElements().get(0).getElem()
				|| listOfLine.get(2).getElements().get(2).getElem()
				!= listOfSubLine.get(2).getElements().get(0).getElem()

				|| listOfLine.get(0).getElements().get(2).getElem()
				!= listOfSubLine.get(0).getElements().get(1).getElem()
				|| listOfLine.get(1).getElements().get(2).getElem()
				!= listOfSubLine.get(1).getElements().get(1).getElem()
				|| listOfLine.get(2).getElements().get(2).getElem()
				!= listOfSubLine.get(2).getElements().get(1).getElem()
				|| listOfSubLine.size() != 3){
			resultAssert = false;
		}
		assertTrue(resultAssert);
	}

//	public static void main(String args[]) {
//		Dataframe df = new Dataframe();
//		if(args.length > 0) {
//			BufferedReader br = null;
//			try {
//				br = new BufferedReader(new FileReader(args[0]));
//
//				String ligne = br.readLine();
//				if (ligne != null) {
//					String[] data = ligne.split(",");
//					for (String val : data) {
//						df.label.add(new Element(val));
//					}
//				}
//
//				while ((ligne = br.readLine()) != null) {
//					ArrayList<Element> tmp = new ArrayList<>();
//					String[] data = ligne.split(",");
//					for (String val : data) {
//						tmp.add(new Element(val));
//					}
//					df.table.add(new Line(df.table.size(), tmp));
//				}
//				df.printDataframe();
//				System.out.println("----------------");
//				df.printFirstLines(2);
//				System.out.println("----------------");
//				df.printFirstLines(15);
//				System.out.println("----------------");
//				df.printLastLines(2);
//				System.out.println("----------------");
//				df.printLastLines(15);
//				System.out.println("################");
//				Dataframe dfL = df.getSubDataFrameFromLines(new ArrayList<Integer>(Arrays.asList(0, 2)));
//				System.out.println("################");
//				dfL.printFirstLines(2);
//				System.out.println("----------------");
//				dfL.printFirstLines(15);
//				System.out.println("----------------");
//				dfL.printLastLines(2);
//				System.out.println("----------------");
//				dfL.printLastLines(15);
//				System.out.println("################");
//				Dataframe dfC = df.getSubDataFrameFromColumnsNumber(new ArrayList<Integer>(Arrays.asList(0, 2)));
//				dfC.printDataframe();
//				System.out.println("################");
//				dfC.printFirstLines(2);
//				System.out.println("----------------");
//				dfC.printFirstLines(15);
//				System.out.println("----------------");
//				dfC.printLastLines(2);
//				System.out.println("----------------");
//				dfC.printLastLines(15);
//				System.out.println("################");
//				Dataframe dfCl = df.getSubDataFrameFromColumnsLabel(new ArrayList<String>(Arrays.asList("Sexe", "Année de naissance")));
//				System.out.println("################");
//				dfCl.printFirstLines(2);
//				System.out.println("----------------");
//				dfCl.printFirstLines(15);
//				System.out.println("----------------");
//				dfCl.printLastLines(2);
//				System.out.println("----------------");
//				dfCl.printLastLines(15);
//
//				br.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
}
