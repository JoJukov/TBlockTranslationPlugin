package text.translation.impl;

import exceptions.TranslationException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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

    // TODO: 5/5/21 make urlPath final
    private final String urlPath;
    private String destLang = "Ru";

    public GoogleTranslator(String urlPath) throws IOException {
        this.urlPath = urlPath;
    }

    @Override
    public String translate(String text) throws TranslationException {

        Map<String, String> mapJsonObjects = new HashMap<>();
        mapJsonObjects.put("dest", destLang);
        mapJsonObjects.put("text", text);

        JSONObject jsonObject = new JSONObject(mapJsonObjects);

        final HttpURLConnection con;
        try {
            con = getConnection();

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

    public String getUrlPath() {
        return urlPath;
    }

    public void setDestLang(String destLang) {
        this.destLang = destLang;
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

    private HttpURLConnection getConnection() throws IOException {
        URL url = new URL(urlPath);
        return (HttpURLConnection) url.openConnection();
    }
}
