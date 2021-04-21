import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DataframeTest {

	@Test
	public void test() {

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
