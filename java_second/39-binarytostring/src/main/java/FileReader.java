import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileReader {

    public String readFile(String filePath) throws IOException{
        File fr = new File(filePath);
        BufferedInputStream in = new BufferedInputStream(Files.newInputStream(Paths.get(filePath)));
        ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
        byte[] result = new byte[1024];
        int size = 0;
        while ((size = in.read(result)) != -1){
            out.write(result,0,size);
        }
        in.close();

        return out.toString();
    }

}
