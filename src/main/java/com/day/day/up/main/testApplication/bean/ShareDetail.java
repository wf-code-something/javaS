package com.day.day.up.main.testApplication.bean;

import java.math.BigDecimal;

public class ShareDetail {
    private String subMerchant;
    private BigDecimal subAmount;

    public String getSubMerchant() {
        return subMerchant;
    }

    public void setSubMerchant(String subMerchant) {
        this.subMerchant = subMerchant;
    }

    public BigDecimal getSubAmount() {
        return subAmount;
    }

    public void setSubAmount(BigDecimal subAmount) {
        this.subAmount = subAmount;
    }


    public static final class ShareDetailBuilder {
        private String subMerchant;
        private BigDecimal subAmount;

        private ShareDetailBuilder() {
        }

        public static ShareDetailBuilder aShareDetail() {
            return new ShareDetailBuilder();
        }

        public ShareDetailBuilder withSubMerchant(String subMerchant) {
            this.subMerchant = subMerchant;
            return this;
        }

        public ShareDetailBuilder withSubAmount(BigDecimal subAmount) {
            this.subAmount = subAmount;
            return this;
        }

        public ShareDetail build() {
            ShareDetail shareDetail = new ShareDetail();
            shareDetail.setSubMerchant(subMerchant);
            shareDetail.setSubAmount(subAmount);
            return shareDetail;
        }
    }
}
