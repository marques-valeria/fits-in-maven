package codegen.egcl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			String path = "/home/owolabi/projects/fits-in-maven/chapter06/";
			EGCLScript script = new EGCLScript(path + "src/main/resources/properties.egcl");
			try {
				File file_java = new File(path + "src/main/java/monitoredfits/rv/Verification.java");
				;

				BufferedWriter output = new BufferedWriter(new FileWriter(file_java));
				output.write(script.getVerificationCode());
				output.close();

				File file_aj = new File(path + "src/main/java/monitoredfits/rv/Properties.aj");
				output = new BufferedWriter(new FileWriter(file_aj));
				output.write(script.toAspectJ());
				output.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception msg) {
			System.out.println("Error: " + msg);
		}
	}

}
