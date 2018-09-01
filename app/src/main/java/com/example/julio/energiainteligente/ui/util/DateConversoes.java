package com.example.julio.energiainteligente.ui.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConversoes extends Date {

    public static Integer diferencaMinutos(Date posterior, Date anterior) {
        Long milisegundos = posterior.getTime() - anterior.getTime();
        Long diferencaMinutos = ((milisegundos / 1000) / 60);
        return diferencaMinutos.intValue();
    }

    public static String dataBR(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        //vai te retorna uma String
        return sdf.format(date);
    }
}
