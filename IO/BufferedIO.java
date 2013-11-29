import java.io.*;
public class BufferedIO{
	public static void main(String[] args) throws IOException {

        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;

        try {
            inputStream = new BufferedInputStream(new FileInputStream("lorem.txt"));
			outputStream = new BufferedOutputStream(new FileOutputStream("bufferedOutput.txt"));
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
    }
}