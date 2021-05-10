package com.zhuvar.tblock.text.translation.impl;

import com.zhuvar.tblock.exceptions.TranslationException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.zhuvar.tblock.text.translation.Translator;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class GoogleTranslator implements Translator {

    private static final String urlPath = "https://vantus-software.ru/translate";
    private String destLang;

    public GoogleTranslator() {
        destLang = "Ru";
    }

    @Override
    public String translate(String text) throws TranslationException {

        Map<String, String> mapJsonObjects = new HashMap<>();
        mapJsonObjects.put("dest", destLang.toLowerCase());
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
        } catch (MalformedURLException e) {
            throw new TranslationException("Error in URL address");
        } catch (ParseException e) {
            throw new TranslationException("Error while parsing response in Json");
        } catch (IOException e) {
            throw new TranslationException(e.getMessage());
        }
    }

    public void setDestLang(String destLang) {
        this.destLang = destLang;
    }

    private String readResponse(HttpURLConnection con) throws IOException {
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            final StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        }
    }

    private HttpURLConnection getConnection() throws IOException {
        URL url = new URL(urlPath);
        return (HttpURLConnection) url.openConnection();
    }
}
