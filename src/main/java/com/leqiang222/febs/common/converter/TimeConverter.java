package com.leqiang222.febs.common.converter;

import com.leqiang222.febs.common.utils.DateUtil;
import com.wuwenze.poi.convert.WriteConverter;
import com.wuwenze.poi.exception.ExcelKitWriteConverterException;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author LeQiang Li
 * @Date Created in 11:02 2019/7/8
 * @Description:  Execl导出时间类型字段格式化
 * @Modified By:
 */
@Slf4j
public class TimeConverter implements WriteConverter {
    @Override
    public String convert(Object o) throws ExcelKitWriteConverterException {
        try {
            if (o == null) {
                return "";
            }

            return DateUtil.formatCSTTime(o.toString(), DateUtil.FULL_TIME_SPLIT_PATTERN);

        } catch (Exception e) {
            log.error("时间转换异常", e);
            return "";
        }
    }
}
