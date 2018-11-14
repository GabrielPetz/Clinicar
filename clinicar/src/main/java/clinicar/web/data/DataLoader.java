package clinicar.web.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.apache.http.NameValuePair;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * @author Petz
 * @since 26/10/18
 */
public class DataLoader {

    private static HttpURLConnection httpURLConnection;
    private static URLConnection urlConnection;

    public static JsonArray getData(String url) {
        try {
            urlConnection = new URL(url).openConnection();
            urlConnection.connect();
            JsonArray rootobj = new JsonParser().parse(new InputStreamReader((InputStream) urlConnection.getContent())).getAsJsonArray();
            return rootobj;

        } catch (IOException ex) {
            System.out.println("erro" + ex.getMessage());
        }
        return null;
    }

    public static String setData(String url, String parameters) {
        try {

            httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);

            try (DataOutputStream dos = new DataOutputStream(httpURLConnection.getOutputStream())) {
                dos.writeBytes(parameters);
                dos.flush();
            }

            Integer responseCode = httpURLConnection.getResponseCode();
            StringBuilder response;
            try (BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
                response = new StringBuilder();
                while (in.ready()) {
                    response.append(in.readLine());
                }
            }

            if (responseCode == 200) {
                return response.toString();
            }

        } catch (IOException ex) {
            System.out.println("erro" + ex.getMessage());
        }
        return null;
    }


}
