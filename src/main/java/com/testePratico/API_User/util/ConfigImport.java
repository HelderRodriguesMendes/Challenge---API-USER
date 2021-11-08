package com.testePratico.API_User.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConfigImport {
    public LocalDateTime getLocalDateTimeCurrent(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String dataHoraFormat = localDateTime.format(formatter);
        return LocalDateTime.parse(dataHoraFormat, formatter);
    }
}
