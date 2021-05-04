package text.translation.impl;

import connection.impl.ProxyPropertyReader;
import exception.TranslationException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import text.translation.Destination;
import text.translation.Translator;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class GoogleTranslator implements Translator {

    private final ProxyPropertyReader proxyPropertyReader;

    public GoogleTranslator() throws IOException {
        this.proxyPropertyReader = new ProxyPropertyReader();
    }

    @Override
    public String translate(String text, Destination dest) throws TranslationException{

        Map<String, String> mapJsonObjects = new HashMap<>();
        mapJsonObjects.put("dest", destinationToString(dest));
        mapJsonObjects.put("text", text);

        JSONObject jsonObject = new JSONObject(mapJsonObjects);

        final HttpURLConnection con;
        try {
            String urlPath = proxyPropertyReader.getProperty("proxy_address");
            con = getConnection(urlPath);

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            final DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(jsonObject.toString());
            out.flush();
            out.close();

            String response = readResponse(con);

            Object obj = new JSONParser().parse(response);
            return ((JSONObject) obj).get("text").toString();
        } catch (IOException | ParseException e) {
            throw new TranslationException("Error while text translation");
        }
    }

    private String destinationToString(Destination destination) {
        return destination.name().toLowerCase();
    }

    private String readResponse(HttpURLConnection con) {
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            final StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } catch (IOException e) {
            return "";
        }
    }

    private HttpURLConnection getConnection(String urlPath) throws IOException {
        URL url = new URL(urlPath);
        return (HttpURLConnection) url.openConnection();
    }
}
