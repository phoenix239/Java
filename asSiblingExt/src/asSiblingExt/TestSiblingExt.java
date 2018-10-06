package asSiblingExt;

import javax.swing.JOptionPane;

import asSiblingExt.SiblingExt;

public class TestSiblingExt {

public static void main(String[] args) {
		
		int age, weight, height;
		String name, in, out;
		
		name = JOptionPane.showInputDialog(null, "Enter the first persons name");
		in = JOptionPane.showInputDialog(null, "Enter " + name + "'s age");
		age = Integer.parseInt(in);
		in = JOptionPane.showInputDialog(null, "Enter " + name + "'s weight");
		weight = Integer.parseInt(in);
		in = JOptionPane.showInputDialog(null, "Enter " + name + "'s height");
		height = Integer.parseInt(in);
		
		SiblingExt s1 = new SiblingExt(name, age, weight, height);
		
		name = JOptionPane.showInputDialog(null, "Enter the second persons name");
		in = JOptionPane.showInputDialog(null, "Enter " + name + "'s age");
		age = Integer.parseInt(in);
		in = JOptionPane.showInputDialog(null, "Enter " + name + "'s weight");
		weight = Integer.parseInt(in);
		in = JOptionPane.showInputDialog(null, "Enter " + name + "'s height");
		height = Integer.parseInt(in);
		
		SiblingExt s2 = new SiblingExt(name, age, weight, height);
		
		name = JOptionPane.showInputDialog(null, "Enter the third persons name");
		in = JOptionPane.showInputDialog(null, "Enter " + name + "'s age");
		age = Integer.parseInt(in);
		in = JOptionPane.showInputDialog(null, "Enter " + name + "'s weight");
		weight = Integer.parseInt(in);
		in = JOptionPane.showInputDialog(null, "Enter " + name + "'s height");
		height = Integer.parseInt(in);
		
		SiblingExt s3 = new SiblingExt(name, age, weight, height);
		
		out = "The Lightest sibling: " + getLightest(s1, s2, s3) 
		+ "\nThe youngest sibling: " + getYoungest(s1, s2, s3) 
		+ "\nThe Tallest Sibling: " + getTallest(s1, s2, s3);
		
		JOptionPane.showMessageDialog(null, out);
		System.exit(0);
		
	}
	
	public static String getYoungest(SiblingExt s1, SiblingExt s2, SiblingExt s3) {
		String name;
		int age;
		
		name = s1.getName();
		age = s1.getAge();
		
		if (s2.getAge() < age) {
			age = s2.getAge();
			name = s2.getName();
		}
		if (s3.getAge() < age) {
			age = s3.getAge();
			name = s3.getName();
		}
		
		String youngest = name + " at " + age + " years old";
		return youngest;
	}
	
	public static String getLightest(SiblingExt s1, SiblingExt s2, SiblingExt s3) {
		String name;
		int weight;
		
		name = s1.getName();
		weight = s1.getWeight();
		
		if (s2.getWeight() < weight) {
			weight = s2.getWeight();
			name = s2.getName();
		}
		if (s3.getWeight() < weight) {
			weight = s3.getWeight();
			name = s3.getName();
		}
		
		String lightest = name + " at " + weight + " lbs.";
		return lightest;
	}
	
	public static String getTallest(SiblingExt s1, SiblingExt s2, SiblingExt s3) {
		String name;
		int height;
		
		name = s1.getName();
		height = s1.getHeight();
		
		if (s2.getWeight() > height) {
			height = s2.getHeight();
			name = s2.getName();
		}
		if (s3.getWeight() > height) {
			height = s3.getHeight();
			name = s3.getName();
		}
		
		String tallest = name + " at " + height + " inches.";
		return tallest;
	}

}
