import java.io.*;

/**
 * Created by nikitos on 13.10.16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        long time = System.nanoTime();
        int all = 0;
        File file = new File("/Users/nikitos/Downloads/file.txt");
        file = convert(file);
        FileReader fr = new FileReader(file);
        orderedLinkedList oList = new orderedLinkedList();
        int c;
        while ((c = fr.read()) != -1) {
            oList.add((char)c);
            ++all;
        }
        oList.showList();
        fr.close();
        oList.removeAll();
        file.delete();

        System.out.println("Всего символов " + all + "\nПрограмма выполнилась за " + (float) (System.nanoTime() - time) / 1000000 + " мc");
    }

    public static File convert(File file) throws IOException {
        FileReader fi = new FileReader(file);
        File out = new File(file.getAbsolutePath().substring(0, file.getAbsolutePath().indexOf('.')) + "1.txt");
        FileWriter fo = new FileWriter(out);
        int c;
        while ((c = fi.read()) != -1) {
            char r = (char) c;
            r = Character.toLowerCase(r);
            if (r >= 'a' && r <= 'z' || r >= 'а' && r <= 'я'||r==' '||r=='\n') {
                fo.write(r);
            }
        }
        fo.flush();
        fi.close();
        fo.close();
        return out;
    }
}
