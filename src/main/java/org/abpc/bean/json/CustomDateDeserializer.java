package org.abpc.bean.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateDeserializer extends JsonDeserializer<Date> {

    private static final Logger EXCEPTIONS_LOGGER = LoggerFactory.getLogger("exceptions");

    @Override
    public Date deserialize(JsonParser jsonparser,
                            DeserializationContext deserializationcontext) throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String date = jsonparser.getText();
        try {
            return format.parse(date);
        } catch (ParseException e) {
            EXCEPTIONS_LOGGER.error("Error to parse date - jsonparser: {}", jsonparser, e);
            throw new RuntimeException(e);
        }
    }
}
