import java.io.*;
import java.util.Scanner;
public class FileCopy{
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		System.out.print("Input file: ");
		String inputFile = sc.nextLine();

		System.out.print("Output path: ");
		String outputFile = sc.nextLine();

        // FileInputStream in = null;
        // FileOutputStream out = null;

        // long start = System.currentTimeMillis();
        // try {
        //     in = new FileInputStream(inputFile);
        //     out = new FileOutputStream(outputFile);
        //     int c;

        //     while ((c = in.read()) != -1) {
        //         out.write(c);
        //     }
        // } finally {
        //     if (in != null) {
        //         in.close();
        //     }
        //     if (out != null) {
        //         out.close();
        //     }
        // }
        // long end = System.currentTimeMillis();
		// System.out.println("no buffer time: " + (end - start));
		
        long start = System.currentTimeMillis();
        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;

        try {
            inputStream = new BufferedInputStream(new FileInputStream(inputFile));
			outputStream = new BufferedOutputStream(new FileOutputStream(outputFile));
            int c;

            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("buffer time: " + (end - start));
    }
}