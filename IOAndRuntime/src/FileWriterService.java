import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileWriterService {

    private static void writeData(long startTime){
        BufferedWriter writer = null;
        try {
            //create a temporary file
            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            File logFile = new File(timeLog);   // path to file

            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile));
            writer.write("EmployeeId,EmployeeSalary");
            writer.write("\n");
            for(Integer i=0; i< 1000001; i++){
                StringBuilder sb = new StringBuilder();
                sb.append(i.toString());
                sb.append(",");
                sb.append((int) (Math.random() * 100000));
                writer.write(sb.toString());  // 10,55000
                writer.write("\n");
            }
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            writer.write("Total time taken: "+ totalTime/1000000.0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        FileWriterService writeservice = new FileWriterService();
        writeservice.writeData(startTime);
    }
}
