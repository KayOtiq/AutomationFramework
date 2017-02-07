package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestResults {
	
	int passed;
	int failed;
	int skipped;
	
	public int getPassed() {
		return this.passed;
	}
	
	public int getFailed() {
		return this.failed;
	}
	
	public int getSkipped() {
		return this.skipped;
	}

	
	public int getTotalTests() {
		return this.passed + this.failed + this.skipped;
	}
	
	public int incrementPassed() {
		return this.passed++;
	}
	
	public int incrementFailed() {
		return this.failed++;
	}
	
	public int incrementSkipped() {
		return this.skipped++;
	}
	
	public void write() throws IOException {
		
		File file = new File("C:\\Users\\lyndam\\workspace3\\MyStore\\test-output\\myTestResults.txt");
		
		//this will auto-close on completion
		try (FileWriter fw = new FileWriter(file); 
			BufferedWriter bWriter = new BufferedWriter(fw)) {		
			fw.write("PASSED="+this.passed+"\n");
			fw.write("FAILED="+this.failed+"\n");
			fw.write("SKIPPED="+this.skipped+"\n");
			fw.write("TOTAL="+this.getTotalTests()+"\n");
		}
	}
	
	public void writeToCSV() throws IOException {
		
		File file = new File("C:\\Users\\lyndam\\workspace3\\MyStore\\test-output\\myTestResults.csv");
		
		//this will auto-close on completion
		try (FileWriter fw = new FileWriter(file); 
			BufferedWriter bWriter = new BufferedWriter(fw)) {		
			fw.write("PASSED="+this.passed+"\n");
			fw.write("FAILED="+this.failed+"\n");
			fw.write("SKIPPED="+this.skipped+"\n");
			fw.write("TOTAL="+this.getTotalTests()+"\n");
		}
	}
}
