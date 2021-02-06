import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class FileReaderService {

    private static void readData() throws IOException {
        //20210206_091452,
        BufferedReader br = new BufferedReader(new FileReader("20210206_091832"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            List<Long> empSalaryList = new ArrayList<>();
            for(Integer i = 0; i < 1000001; i ++) {
                String line2 = br.readLine();
                String[] splitters = line2.split(",");
                empSalaryList.add(Long.parseLong(splitters[1]));
            }

//            for(Long salary: empSalaryList){
//                System.out.println(salary);
//            }

            long startTime = System.nanoTime();

            Sorting sralgo = new Sorting();
            sralgo.bubblesort(empSalaryList);
//            empSalaryList = sralgo.mergesort(empSalaryList);

            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println("Total time taken: "+ totalTime/1000000.0);

//            for(Long salary: empSalaryList){
//                System.out.println(salary);
//            }



        } catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            br.close();
        }


}

    public static void main(String[] args) throws IOException {
        FileReaderService readerService = new FileReaderService();
        readerService.readData();
/*
*
*
*
*

* 1.187876

* different lang, differnet OS, etc.parallel processing..
* */
    }
}
