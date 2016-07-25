package amazon;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

public class MergingTwoDataProviders {

	public Object[][] dp1() {
		
		Object[][] data1 = new Object[2][2];
		data1[0][0]="a1";
		data1[0][1]="a2";
		data1[1][0]="a3";
		data1[1][1]="a4";
		  return data1;
		  
		}

		public Object[][] dp2() {
			Object[][] data2 = new Object[2][2];
			data2[0][0]="b1";
			data2[0][1]="b2";
			data2[1][0]="b3";
			data2[1][1]="b4";
			  return data2;
			  
			}

		@DataProvider(name = "dp")
		public Object[][] dp() {
		  List<Object[]> result = Lists.newArrayList();
		  result.addAll(Arrays.asList(dp1()));
		  result.addAll(Arrays.asList(dp2()));
		  return result.toArray(new Object[result.size()][]);
		}

		@Test (dataProvider = "dp")
		public void mergeddata(String a, String b) {
		  System.out.println(a);
		  System.out.println(b);
		  
		}
}
