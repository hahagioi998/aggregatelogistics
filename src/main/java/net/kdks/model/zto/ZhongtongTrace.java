package net.kdks.model.zto;

import lombok.ToString;
import net.kdks.constant.ZhongtongScanType;
import net.kdks.enums.ExpressStateEnum;
import net.kdks.model.ExpressData;
import net.kdks.utils.DateUtils;

/**
 * 路由信息.
 *
 * @author Ze.Wang
 * @since 0.0.1
 */
@ToString
public class ZhongtongTrace extends ExpressData {
    private static final long serialVersionUID = 1L;

    public void setScanCity(String scanCity) {
        super.setAreaName(scanCity);
    }

    public void setScanDate(String scanDate) {
        super.setTime(DateUtils.strToTimestamp(scanDate));
        super.setFtime(scanDate);
    }

    public void setDesc(String desc) {
        super.setContext(desc);
    }

    /**
     * 处理路由状态.
     *
     * @param scanType 路由状态
     */
    public void setScanType(String scanType) {
        // 收件
        if (scanType.equals(ZhongtongScanType.COLLECTED)) {
            super.setStatus(ExpressStateEnum.COLLECTED.getValue());
            return;
        }
        // 已签收
        if (scanType.equals(ZhongtongScanType.SIGNED)
            || scanType.equals(ZhongtongScanType.THIRD_PARTY_SIGNED)
            || scanType.equals(ZhongtongScanType.CLIENT_SIGNED)) {
            super.setStatus(ExpressStateEnum.SIGNED.getValue());
            return;
        }
        // 正在派送途中
        if (scanType.equals(ZhongtongScanType.DELIVERING)) {
            super.setStatus(ExpressStateEnum.DELIVERING.getValue());
            return;
        }
        // 代理收件
        if (scanType.equals(ZhongtongScanType.AGENT)) {
            super.setStatus(ExpressStateEnum.AGENT.getValue());
            return;
        }

        // 退回
        if (scanType.equals(ZhongtongScanType.BACK)
            || scanType.equals(ZhongtongScanType.BACK_SIGNED)) {
            super.setStatus(ExpressStateEnum.BACK.getValue());
            return;
        }

        // 疑难
        if (scanType.equals(ZhongtongScanType.PROBLEM)) {
            super.setStatus(ExpressStateEnum.EXCEPTION.getValue());
            return;
        }

        super.setStatus(ExpressStateEnum.TRANSITING.getValue());
    }

}
