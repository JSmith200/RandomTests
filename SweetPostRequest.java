import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class SweetPostRequest {

    private static int CONNECT_TIMEOUT = 10 * 1000;
    private static int READ_TIMEOUT = 1 * 60 * 1000;
    private static String EMPTY = "";

    public static void main (String[] args) throws IOException{
        System.out.println(sendPOST("http://api.sweet.tv/BillingService/GetSlides.json",

                "{ " +
                        "\"device\":" +
                        "{ " +
                        "\"type\":\"DT_SmartTV\",\"sub_type\":\"DST_SAMSUNG\",\"application\":" +
                        "{ " +
                        "\"type\":\"AT_SWEET_TV_Player\"" +
                        "}" +
                        ",\"supported_drm\":" +
                        "{ " +
                        "\"widevineModular\":true},\"screen_info\":" +
                        "{ " +
                        "\"aspectRatio\":\"AR_16_9\",\"width\":1280,\"height\":720},\"firmware\":" +
                        "{ " +
                        "\"versionCode\":1,\"versionString\":\"2.4.2\"" +
                        "}" +
                        ",\"mac\":\"34:FC:EF:D9:C4:B2\"" +
                        "}" +
                        ",\"locale\":\"uk\"" +
                        "}"
        ));

    }


    public static String sendPOST(String url, String data) throws IOException{

        HttpURLConnection conn = null;
        InputStream stream = null;
        URL urlLink = new URL(url);
        OutputStreamWriter writer = null;

        conn = (HttpURLConnection)urlLink.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setUseCaches(false);
        conn.setConnectTimeout(CONNECT_TIMEOUT);
        conn.setReadTimeout(READ_TIMEOUT);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestMethod("POST");

        writer = new OutputStreamWriter(conn.getOutputStream());
        writer.write(data);
        writer.flush();
        writer.close();



        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            System.out.println("Content Length is " + conn.getContentLength());
            stream = conn.getInputStream();
        }
        else {
            stream = conn.getErrorStream();
        }
        if (stream == null){
            System.out.println("Response code is " + conn.getResponseCode());
            System.out.println("Request code is " + conn.getInputStream());
            return EMPTY;
        }


        return stream2String(stream);
    }

    private static String stream2String(InputStream is) throws IOException{
        StringBuilder sb = new StringBuilder(8192);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        while ((line = br.readLine())!= null){
            sb.append(line);
        }
        return sb.toString();
    }
}