package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputStream {
	private static InputStream instance = new InputStream();
	
	private InputStream() {
		//empty constructor
	}
	
	public Division setData(File file) throws FileNotFoundException {
		Division dataSet = new Division();
		
		String temp;
		Scanner scan = new Scanner(file);
		StringTokenizer token;
		int numofData=0;
		
		ArrayList<Double[]> att = new ArrayList<Double[]>();
		ArrayList<Boolean[]> label = new ArrayList<Boolean[]>();
		
		while(scan.hasNextLine()) {
			temp = scan.nextLine();
			token = new StringTokenizer(temp,",");
			
			Double attribute[] = new Double[294];
			Boolean labelArr[] = new Boolean[5];
			
			for(int i=0;i<294;i++) {
				attribute[i] = Double.parseDouble(token.nextToken());
			}
			for(int i=0;i<5;i++) {
				if(Integer.parseInt(token.nextToken())==1) {
					labelArr[i] = true;
				} else {
					labelArr[i] = false;
				}
			}
			att.add(attribute);
			label.add(labelArr);
			numofData++;
		}
		scan.close();
		
		dataSet.setAtt(att);
		dataSet.setLabel(label);
		dataSet.setNum(numofData);
		
		return dataSet;
	}
	
	public static InputStream getInstance() {
		return instance;
	}
}
