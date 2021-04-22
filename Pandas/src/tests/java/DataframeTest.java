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
		listOfElement.add(new Element("1"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("10"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("5"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
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
		listOfElement.add(new Element("1"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("10"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("5"));
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
		listOfElement.add(new Element("1"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("10"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("5"));
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
		listOfElement.add(new Element("1"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("10"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("5"));
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
		listOfElement.add(new Element("1"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("10"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("5"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
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
		listOfElement.add(new Element("1"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("10"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("5"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
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
		if(listOfLine.get(0).getElements().get(0).getElem()
				!= listOfSubLine.get(0).getElements().get(0).getElem()
				|| listOfLine.get(1).getElements().get(0).getElem()
				!= listOfSubLine.get(1).getElements().get(0).getElem()
				|| listOfLine.get(2).getElements().get(0).getElem()
				!= listOfSubLine.get(2).getElements().get(0).getElem()
				|| listOfSubLine.size() != 3 ){
			resultAssert = false;
		}
		assertTrue(resultAssert);
	}

	@Test
	public void testGetSubDataFrameFromLastColumnsNumber() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element("1"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("10"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("5"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
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
		listOfElement.add(new Element("1"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("10"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("5"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
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

	/**
	 * Test on get sub of data frame with sequence of column label
	 * */

	@Test
	public void testGetSubDataFrameFromColumnsLabel() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element("1"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("10"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("5"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Element> listOfElementLabel = new ArrayList<>();
		listOfElementLabel.add(new Element("Number"));
		listOfElementLabel.add(new Element("Name"));
		listOfElementLabel.add(new Element("Date"));
		Line lLabel = new Line(0, listOfElementLabel);
		dt.changeLabelLine(lLabel);

		ArrayList<String> indexOfColumn = new ArrayList<>();
		indexOfColumn.add("Number");
		indexOfColumn.add("Name");
		indexOfColumn.add("Date");
		Dataframe dtSub = dt.getSubDataFrameFromColumnsLabel(indexOfColumn);
		dtSub.changeLabelLine(lLabel);

		assertEquals(dt.toString(), dtSub.toString());
	}

	@Test
	public void testGetSubDataFrameFromFirstColumnsLabel() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element("1"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("10"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("5"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Element> listOfElementLabel = new ArrayList<>();
		listOfElementLabel.add(new Element("Number"));
		listOfElementLabel.add(new Element("Name"));
		listOfElementLabel.add(new Element("Date"));
		Line lLabel = new Line(0, listOfElementLabel);
		dt.changeLabelLine(lLabel);

		ArrayList<String> indexOfColumn = new ArrayList<>();
		indexOfColumn.add("Number");
		Dataframe dtSub = dt.getSubDataFrameFromColumnsLabel(indexOfColumn);
		dtSub.changeLabelLine(lLabel);

		boolean resultAssert = true;
		ArrayList<Line> listOfLine = dt.getLines();
		ArrayList<Line> listOfSubLine = dtSub.getLines();
		if(listOfLine.get(0).getElements().get(0).getElem()
				!= listOfSubLine.get(0).getElements().get(0).getElem()
				|| listOfLine.get(1).getElements().get(0).getElem()
				!= listOfSubLine.get(1).getElements().get(0).getElem()
				|| listOfLine.get(2).getElements().get(0).getElem()
				!= listOfSubLine.get(2).getElements().get(0).getElem()
				|| listOfSubLine.size() != 3){
			resultAssert = false;
		}
		assertTrue(resultAssert);
	}

	@Test
	public void testGetSubDataFrameFromLastColumnsLabel() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element("1"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("10"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("5"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Element> listOfElementLabel = new ArrayList<>();
		listOfElementLabel.add(new Element("Number"));
		listOfElementLabel.add(new Element("Name"));
		listOfElementLabel.add(new Element("Date"));
		Line lLabel = new Line(0, listOfElementLabel);
		dt.changeLabelLine(lLabel);

		ArrayList<String> indexOfColumn = new ArrayList<>();
		indexOfColumn.add("Date");
		Dataframe dtSub = dt.getSubDataFrameFromColumnsLabel(indexOfColumn);
		dtSub.changeLabelLine(lLabel);

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
	public void testGetSubDataFrameFromSameColumnsLabel() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element("1"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("10"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("5"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Element> listOfElementLabel = new ArrayList<>();
		listOfElementLabel.add(new Element("Number"));
		listOfElementLabel.add(new Element("Name"));
		listOfElementLabel.add(new Element("Date"));
		Line lLabel = new Line(0, listOfElementLabel);
		dt.changeLabelLine(lLabel);

		ArrayList<String> indexOfColumn = new ArrayList<>();
		indexOfColumn.add("Date");
		indexOfColumn.add("Date");
		Dataframe dtSub = dt.getSubDataFrameFromColumnsLabel(indexOfColumn);
		dtSub.changeLabelLine(lLabel);

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

	/**
	 * Tests for maximum value function
	 * */
	@Test
	public void testMaxElementByColumnIndex() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element("M"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("L"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("X"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Element> listOfElementLabel = new ArrayList<>();
		listOfElementLabel.add(new Element("Sexe"));
		listOfElementLabel.add(new Element("Name"));
		listOfElementLabel.add(new Element("Date"));
		Line lLabel = new Line(0, listOfElementLabel);
		dt.changeLabelLine(lLabel);

		Element eSexe = dt.maxValueByColumnIndex(0);
		assertEquals("L", eSexe.getElem());
		Element eName = dt.maxValueByColumnIndex(1);
		assertEquals("Audrey", eName.getElem());
		Element eDate = dt.maxValueByColumnIndex(2);
		assertEquals("2010", eDate.getElem());

	}

	@Test
	public void testMaxElementByColumnIndexNonExistingColumn() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element("M"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("L"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("X"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Element> listOfElementLabel = new ArrayList<>();
		listOfElementLabel.add(new Element("Sexe"));
		listOfElementLabel.add(new Element("Name"));
		listOfElementLabel.add(new Element("Date"));
		Line lLabel = new Line(0, listOfElementLabel);
		dt.changeLabelLine(lLabel);

		Element eNullSup = dt.maxValueByColumnIndex(-1);
		assertEquals(null, eNullSup);
		Element eNullInf = dt.maxValueByColumnIndex(10);
		assertEquals(null, eNullInf);
		Element eNullSupDomain = dt.maxValueByColumnIndex(3);
		assertEquals(null, eNullSupDomain);

	}

	/**
	 * Tests for maximum value function by label
	 * */
	@Test
	public void testMaxElementByColumnLabel() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element("M"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("L"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("X"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Element> listOfElementLabel = new ArrayList<>();
		listOfElementLabel.add(new Element("Sexe"));
		listOfElementLabel.add(new Element("Name"));
		listOfElementLabel.add(new Element("Date"));
		Line lLabel = new Line(0, listOfElementLabel);
		dt.changeLabelLine(lLabel);

		Element eSexe = dt.maxValueByLabel("Sexe");
		assertEquals("L", eSexe.getElem());
		Element eName = dt.maxValueByLabel("Name");
		assertEquals("Audrey", eName.getElem());
		Element eDate = dt.maxValueByLabel("Date");
		assertEquals("2010", eDate.getElem());

	}

	@Test
	public void testMaxElementByColumnLabelNonExistingColumn() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element("M"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("L"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("X"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Element> listOfElementLabel = new ArrayList<>();
		listOfElementLabel.add(new Element("Sexe"));
		listOfElementLabel.add(new Element("Name"));
		listOfElementLabel.add(new Element("Date"));
		Line lLabel = new Line(0, listOfElementLabel);
		dt.changeLabelLine(lLabel);

		Element eNullSup = dt.maxValueByLabel("");
		assertEquals(null, eNullSup);
		Element eNullInf = dt.maxValueByLabel("tst");
		assertEquals(null, eNullInf);
		Element eNullSupDomain = dt.maxValueByLabel("Laa");
		assertEquals(null, eNullSupDomain);

	}

	/**
	 * Tests for minimum value function
	 * */
	@Test
	public void testMinElementByColumnIndex() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element("M"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("L"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("X"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Element> listOfElementLabel = new ArrayList<>();
		listOfElementLabel.add(new Element("Sexe"));
		listOfElementLabel.add(new Element("Name"));
		listOfElementLabel.add(new Element("Date"));
		Line lLabel = new Line(0, listOfElementLabel);
		dt.changeLabelLine(lLabel);

		Element eSexe = dt.minValueByColumnIndex(0);
		assertEquals("X", eSexe.getElem());
		Element eName = dt.minValueByColumnIndex(1);
		assertEquals("Marion", eName.getElem());
		Element eDate = dt.minValueByColumnIndex(2);
		assertEquals("1870", eDate.getElem());

	}

	@Test
	public void testMinElementByColumnIndexNonExistingColumn() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element("M"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("L"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("X"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Element> listOfElementLabel = new ArrayList<>();
		listOfElementLabel.add(new Element("Sexe"));
		listOfElementLabel.add(new Element("Name"));
		listOfElementLabel.add(new Element("Date"));
		Line lLabel = new Line(0, listOfElementLabel);
		dt.changeLabelLine(lLabel);

		Element eNullSup = dt.minValueByColumnIndex(-1);
		assertEquals(null, eNullSup);
		Element eNullInf = dt.minValueByColumnIndex(10);
		assertEquals(null, eNullInf);
		Element eNullSupDomain = dt.minValueByColumnIndex(3);
		assertEquals(null, eNullSupDomain);

	}

	/**
	 * Tests for maximum value function by label
	 * */
	@Test
	public void testMinElementByColumnLabel() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element("M"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("L"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("X"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Element> listOfElementLabel = new ArrayList<>();
		listOfElementLabel.add(new Element("Sexe"));
		listOfElementLabel.add(new Element("Name"));
		listOfElementLabel.add(new Element("Date"));
		Line lLabel = new Line(0, listOfElementLabel);
		dt.changeLabelLine(lLabel);

		Element eSexe = dt.minValueByLabel("Sexe");
		assertEquals("X", eSexe.getElem());
		Element eName = dt.minValueByLabel("Name");
		assertEquals("Marion", eName.getElem());
		Element eDate = dt.minValueByLabel("Date");
		assertEquals("1870", eDate.getElem());

	}

	@Test
	public void testMinElementByColumnLabelNonExistingColumn() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element("M"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("L"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("X"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Element> listOfElementLabel = new ArrayList<>();
		listOfElementLabel.add(new Element("Sexe"));
		listOfElementLabel.add(new Element("Name"));
		listOfElementLabel.add(new Element("Date"));
		Line lLabel = new Line(0, listOfElementLabel);
		dt.changeLabelLine(lLabel);

		Element eNullSup = dt.minValueByLabel("");
		assertEquals(null, eNullSup);
		Element eNullInf = dt.minValueByLabel("tst");
		assertEquals(null, eNullInf);
		Element eNullSupDomain = dt.minValueByLabel("Laa");
		assertEquals(null, eNullSupDomain);

	}

	/***
	 * Tests for mean function
	 * */
	@Test
	public void testMeanValueByIndex() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element("1"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("2"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("3"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Element> listOfElementLabel = new ArrayList<>();
		listOfElementLabel.add(new Element("Sexe"));
		listOfElementLabel.add(new Element("Name"));
		listOfElementLabel.add(new Element("Date"));
		Line lLabel = new Line(0, listOfElementLabel);
		dt.changeLabelLine(lLabel);


		Element mean = dt.meanValueByIndex(0);
		assertEquals(2.0, mean.getElem());

	}

	@Test
	public void testMeanValueByInvalidIndex() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element("1"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("2"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("3"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Element> listOfElementLabel = new ArrayList<>();
		listOfElementLabel.add(new Element("Sexe"));
		listOfElementLabel.add(new Element("Name"));
		listOfElementLabel.add(new Element("Date"));
		Line lLabel = new Line(0, listOfElementLabel);
		dt.changeLabelLine(lLabel);


		Element eNullSup = dt.meanValueByIndex(5);
		assertEquals(null, eNullSup);
		Element eInvalidColumn = dt.meanValueByIndex(1);
		assertEquals(null, eInvalidColumn);
		Element eNullInf = dt.meanValueByIndex(-1);
		assertEquals(null, eNullInf);
	}

	/***
	 * Tests for mean function with label
	 * */
	@Test
	public void testMeanValueByLabel() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element("1"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("2"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("3"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Element> listOfElementLabel = new ArrayList<>();
		listOfElementLabel.add(new Element("Sexe"));
		listOfElementLabel.add(new Element("Name"));
		listOfElementLabel.add(new Element("Date"));
		Line lLabel = new Line(0, listOfElementLabel);
		dt.changeLabelLine(lLabel);


		Element mean = dt.meanValueByLabel("Sexe");
		assertEquals(2.0, mean.getElem());

	}

	@Test
	public void testMeanValueByInvalidLabel() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element("1"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("2"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("3"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Element> listOfElementLabel = new ArrayList<>();
		listOfElementLabel.add(new Element("Sexe"));
		listOfElementLabel.add(new Element("Name"));
		listOfElementLabel.add(new Element("Date"));
		Line lLabel = new Line(0, listOfElementLabel);
		dt.changeLabelLine(lLabel);


		Element eNullSup = dt.meanValueByLabel("");
		assertEquals(null, eNullSup);
		Element eInvalidColumn = dt.meanValueByLabel("Name");
		assertEquals(null, eInvalidColumn);
		Element eInvalidColumn2 = dt.meanValueByLabel("null");
		assertEquals(null, eInvalidColumn2);
	}

	/***
	 * Tests for select line where
	 * */
	@Test
	public void testSelectLineWhere() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element("1"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("2"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("3"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Element> listOfElementLabel = new ArrayList<>();
		listOfElementLabel.add(new Element("Sexe"));
		listOfElementLabel.add(new Element("Name"));
		listOfElementLabel.add(new Element("Date"));
		Line lLabel = new Line(0, listOfElementLabel);
		dt.changeLabelLine(lLabel);

		ArrayList<Integer> column = new ArrayList<>();
		column.add(1);
		ArrayList<String> columnValue = new ArrayList<>();
		columnValue.add("Bruno");
		Dataframe selectDataframe = dt.selectLineWhere(column, columnValue);
		selectDataframe.printDataframe();
		boolean correctValue = true;
		if(selectDataframe.getLines().size() != 1
			|| selectDataframe.getLines().get(0).getElementByIndex(1).getElem() != "Bruno"){
			correctValue = false;
		}
		selectDataframe.printDataframe();
		assertTrue(correctValue);

	}

	/***
	 * Tests for select line where with label
	 * */
	@Test
	public void testSelectLineWhereWithLabel() {
		Dataframe dt = new Dataframe();
		ArrayList<Element> listOfElement = new ArrayList<>();
		listOfElement.add(new Element("1"));
		listOfElement.add(new Element("Marion"));
		listOfElement.add(new Element("1995"));
		Line l = new Line(0, listOfElement);
		ArrayList<Element> listOfElement2 = new ArrayList<>();
		listOfElement2.add(new Element("2"));
		listOfElement2.add(new Element("Bruno"));
		listOfElement2.add(new Element("1870"));
		Line l2 = new Line(1, listOfElement2);
		ArrayList<Element> listOfElement3 = new ArrayList<>();
		listOfElement3.add(new Element("3"));
		listOfElement3.add(new Element("Audrey"));
		listOfElement3.add(new Element("2010"));
		Line l3 = new Line(2, listOfElement3);
		dt.addLine(l);
		dt.addLine(l2);
		dt.addLine(l3);

		ArrayList<Element> listOfElementLabel = new ArrayList<>();
		listOfElementLabel.add(new Element("Sexe"));
		listOfElementLabel.add(new Element("Name"));
		listOfElementLabel.add(new Element("Date"));
		Line lLabel = new Line(0, listOfElementLabel);
		dt.changeLabelLine(lLabel);

		ArrayList<String> column = new ArrayList<>();
		column.add("Name");
		ArrayList<String> columnValue = new ArrayList<>();
		columnValue.add("Bruno");
		Dataframe selectDataframe = dt.selectLineWhereByLabel(column, columnValue);
		selectDataframe.printDataframe();
		boolean correctValue = true;
		if(selectDataframe.getLines().size() != 1
				|| selectDataframe.getLines().get(0).getElementByIndex(1).getElem() != "Bruno"){
			correctValue = false;
		}
		selectDataframe.printDataframe();
		assertTrue(correctValue);

	}
}
