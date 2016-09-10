package uk.co.ohpollux.space.program;

import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class SpaceProgram {
    private static TextManipulator manipulator = new TextManipulator();

    public static void main(String[] args) {
	System.out.println("Space Program: Starting");
	HelpFormatter formatter = new HelpFormatter();
	Options options = constructOptions();

	if (args.length == 0) {
	    formatter.printHelp("", options);
	    System.exit(-1);
	}

	try {
	    CommandLineParser parser = new DefaultParser();
	    CommandLine cmd = parser.parse(options, args);

	    if (cmd.hasOption("h") || !cmd.hasOption("if") || !cmd.hasOption("of")) {
		formatter.printHelp("", options);
	    } else {
		String inFile = cmd.getOptionValue("if");
		String outFile = cmd.getOptionValue("of");

		if (cmd.hasOption("d")) {
		    replaceWithDefaults(inFile, outFile);
		} else {
		    replaceWithRandomSpaces(inFile, outFile);
		}

		System.out.println("Space Program: Done");
	    }
	} catch (ParseException e) {
	    System.out.println("Space Program: Having trouble parsing arguments in the command line");
	} catch (IOException e) {
	    System.out.println("Space Program: Having trouble parsing the original file into string");
	}
    }

    private static Options constructOptions() {
	Options options = new Options();

	Option defaultReplace = new Option("d", "default", false,
		"replace all types of spaces with default ones if true, with non-default if false");
	Option help = new Option("h", "help", false, "displays help information");
	Option inFilePath = new Option("if", "inFile", true, "full path to the file that will be processed");
	inFilePath.isRequired();
	Option outFilePath = new Option("of", "outFile", true, "full path where the processed file will be stored");
	outFilePath.isRequired();

	options.addOption(defaultReplace);
	options.addOption(inFilePath);
	options.addOption(outFilePath);
	options.addOption(help);

	return options;
    }

    private static void replaceWithDefaults(String inFile, String outFile) throws IOException {
	String data = IO.getFileAsString(inFile);
	String modifiedData = manipulator.replaceNonDefaultSpaces(data);
	IO.saveStringAsFile(modifiedData, outFile);
    }

    private static void replaceWithRandomSpaces(String inFile, String outFile) throws IOException {
	String data = IO.getFileAsString(inFile);
	String modifiedData = manipulator.replaceDefaultSpaces(data);
	IO.saveStringAsFile(modifiedData, outFile);
    }
}
