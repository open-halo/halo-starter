package org.example.common.utils;

import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Calendar;
import java.util.Date;

public class DateUtilTest {

    @Test
    public void testDate() {
        Date now1 = DateUtil.date();
        Date now2 = DateUtil.date(Calendar.getInstance());
        Date now3 = DateUtil.date(System.currentTimeMillis());
        assertNotNull(now1);
        assertNotNull(now2);
        assertNotNull(now3);

        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();

        //当前日期字符串，格式：yyyy-MM-dd
        String today= DateUtil.today();

        // 支持自动识别的格式
        //        yyyy-MM-dd HH:mm:ss
        //        yyyy/MM/dd HH:mm:ss
        //        yyyy.MM.dd HH:mm:ss
        //        yyyy年MM月dd日 HH时mm分ss秒
        //        yyyy-MM-dd
        //        yyyy/MM/dd
        //        yyyy.MM.dd
        //        HH:mm:ss
        //                HH时mm分ss秒
        //        yyyy-MM-dd HH:mm
        //        yyyy-MM-dd HH:mm:ss.SSS
        //                yyyyMMddHHmmss
        //        yyyyMMddHHmmssSSS
        //                yyyyMMdd
        //        EEE, dd MMM yyyy HH:mm:ss z
        //        EEE MMM dd HH:mm:ss zzz yyyy
        //        yyyy-MM-dd'T'HH:mm:ss'Z'
        //        yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
        //        yyyy-MM-dd'T'HH:mm:ssZ
        //        yyyy-MM-dd'T'HH:mm:ss.SSSZ
        String dateStr = "2017-03-01";
        Date date = DateUtil.parse(dateStr);
        assertEquals(date.getTime(), 1488297600000L);

        String dateStr2 = "2024-03-01 23:59:59.666";
        date = DateUtil.parse(dateStr2);
        assertEquals(date.getTime(), 1709308799666L);
    }
}
