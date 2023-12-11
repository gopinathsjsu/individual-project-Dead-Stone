public class Main {
    public static void main(String[] args) {
        FileProcessor processor = new FileProcessor();
        try {
            processor.processFile("input_file.csv", "output_file.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            processor.processFile("input_file.xml", "output_file.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}