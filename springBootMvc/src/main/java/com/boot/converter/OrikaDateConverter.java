package main.java.com.boot.converter;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by hao huang on 18/07/2016.
 */
public class OrikaDateConverter extends BidirectionalConverter<Date,String> {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    private static final String TIME_FORMAT_REGEX = "(^\\d{2}[:]\\d{2}$)";

    protected static final Pattern TIME_FORMAT_PATTERN = Pattern.compile(TIME_FORMAT_REGEX);

    @Override
    public String convertTo(Date source, Type<String> destinationType) {
        if(source.getClass().getName().equals("java.sql.Time")){
            return timeFormat.format(source);
        }
        return dateFormat.format(source);
    }

    @Override
    public Date convertFrom(String source, Type<Date> destinationType) {
        try {
            if(TIME_FORMAT_PATTERN.matcher(source).matches()){
                String[] strArr = source.split(":");
                return new Time(Integer.valueOf(strArr[0]),Integer.valueOf(strArr[1]),0);
            }
            return dateFormat.parse(source);
        } catch (ParseException e) {
            return null;
        }
    }
}
