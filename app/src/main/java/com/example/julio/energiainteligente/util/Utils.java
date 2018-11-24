package com.example.julio.energiainteligente.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class Utils {

    public static SimpleDateFormat dataHoraBrasil() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return simpleDateFormat;
    }

    public static DecimalFormat decimalFormat() {
        DecimalFormat df = new DecimalFormat("0.00");
        return df;
    }

}
