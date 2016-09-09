package com.csmarton.hackerrank.regexp;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlAttributesDetector {

	private int numOfLines;
	private Scanner in;
	private Map<String, Set<String>> tags = new TreeMap<>();

	private final static String RESOURCE_FOLDER_PATH = "regex/htmlattributesdetector/";

	public static void main(String[] args) throws FileNotFoundException
	{
		HtmlAttributesDetector htmlAttributesDetector = new HtmlAttributesDetector();
		htmlAttributesDetector.setInputs(RESOURCE_FOLDER_PATH + "input.txt");

		htmlAttributesDetector.startProcess();
	}

	private void startProcess()
	{
		in.nextLine();
		while (in.hasNextLine()){
			processLine(in.nextLine());
		}
	}

	private void processLine(String line)
	{
		//System.out.println(line);
		Pattern pattern = Pattern.compile("(?<=<)\\w+");

		Matcher m = pattern.matcher(line);
		while(m.find()){
			System.out.println(m.group());
		}
	}

	private void setInputs(String path) throws FileNotFoundException
	{
		URL resource = this.getClass().getClassLoader().getResource(path);

		in = new Scanner(new File(resource.getFile()));
		numOfLines = in.nextInt();
	}
}
