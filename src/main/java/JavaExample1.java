import java.io.*;

public class JavaExample1 {

    public static void main(String[] args) {
    String file = "C:\\Kranthi\\Gen4\\protobuf_pieces\\2015_04_22_[15_18]_{e95dbd52-9a01-49cd-a41a-ab0af202c445}.jdl.sessionContext";
    //new JavaExample1().read(file);

        String sql = "SELECT count(*) " + "\"Count\"" + ",m.movie_id,m.moviename, r.rating  FROM users u ," +
                " movies m, rating r WHERE id=:userId AND u.id = m.user_id and m.movie_id = r.movie_id group by m.movie_id, r.rating";

        System.out.println("Sql is ::"+ sql);


    }

   public byte[] read(String aInputFileName) {
        File file = new File(aInputFileName);
        byte[] result = new byte[(int) file.length()];
        try {
            InputStream input = null;
            try {
                int totalBytesRead = 0;
                input = new BufferedInputStream(new FileInputStream(file));
                while (totalBytesRead < result.length) {
                    int bytesRemaining = result.length - totalBytesRead;
                    //input.read() returns -1, 0, or more :
                    int bytesRead = input.read(result, totalBytesRead, bytesRemaining);
                    if (bytesRead > 0) {
                        totalBytesRead = totalBytesRead + bytesRead;
                    }
                }
                System.out.println("totalBytesRead::" + totalBytesRead);
            } finally {
                input.close();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

       String string = new String(result);
       System.out.println("string::"+ string);

        return result;
    }

}
