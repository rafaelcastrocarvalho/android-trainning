package br.com.locaweb.treinamento.brasileirao.domain.shared;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater {

    public static String format(Date date) {
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yy HH:mm");
        return  sf.format(date);
    }
}
