import java.io.*;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Чтение текстовых файлов
        FileReader fr = new FileReader("Test.txt");
        BufferedReader br = new BufferedReader(fr);
        while(true) {
            String s = br.readLine();
            if(s == null){
                break;
            }
            System.out.println(s);
        }
        br.close();
        fr.close();
        // Запись текстовых файлов
        FileWriter fw = new FileWriter("1.txt");
        fw.write("Test\n");
        fw.write("Writer ");
        fw.write("Text");
        fw.flush();// производит запись информации в файл
        fw.close();

        FileWriter fw2 = new FileWriter("2.txt", false);// append - дописывает информацию в конец файла
        BufferedWriter bw = new BufferedWriter(fw2);
        bw.write((new Date()).toString());
        bw.write(" Vasili logged in");
        bw.newLine();
        bw.flush();
        bw.close();
        fw.close();
        // Серилизация (запись бинарного файла)
        /*FileOutputStream fos = new FileOutputStream("data.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeFloat(3.14f);
        oos.writeBoolean(true);
        oos.writeChar('!');
        Player p = new Player();
        p.name = "Ivan";
        p.setHealth(23.12f);
        oos.writeObject(p);
        oos.flush();
        oos.close();
        fos.close();*/
        //Де-серилизация (чтение бинарного файла)
        //Вызывать методы read в том же порядке, что и записывали
        FileInputStream fis = new FileInputStream("data.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        float f = ois.readFloat();
        System.out.println(f);
        ois.readBoolean();
        ois.readChar();
        Player p2 = null;
        try{
            p2 = (Player) ois.readObject();
        } catch (ClassNotFoundException e){
            System.out.println(e.getCause());
        }
        System.out.println(p2.name);
        System.out.println(p2.getHealth());
    }
}