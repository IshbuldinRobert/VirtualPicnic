import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileRepository {
    private final File file;

    public FileRepository(File file) {
        this.file = file;
    }

    public List<String> getStringList() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
            String line = br.readLine();
            while(line != null) {
                sb.append(line);
                sb.append(" ");
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Arrays.stream(sb.toString().split(" ")).toList();
    }
}