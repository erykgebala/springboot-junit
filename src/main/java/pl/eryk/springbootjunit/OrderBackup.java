package pl.eryk.springbootjunit;

import java.io.*;

public class OrderBackup {

    private Writer writer;

    public void createFile() throws FileNotFoundException {
        File file = new File("orderBackup.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        writer = new BufferedWriter(outputStreamWriter);
    }

    public void backupOrder(Order order) throws IOException {
        this.writer.append(order.toString()).append(System.lineSeparator());
    }

    public void closeFile() throws IOException {
        this.writer.close();
    }

    public void appendText(String text) throws IOException {
        this.writer.append(text).append(System.lineSeparator());
    }
}
