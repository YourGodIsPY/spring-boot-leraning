package com.ypan.sprinbootweb1.config;

/**
 * 常量
 */
public class Constants {

    public enum INTEGER_NUM {
        INTEGER_OK(200), INTEGER_ERROR(300), INTEGER_900(900);
        private Integer val;

        INTEGER_NUM(Integer val) {
            this.val = val;
        }

        public Integer getVal() {
            return val;
        }
    }

    public enum STRING_MSG {
        STRING_OK("OK"), STRING_ERROR("ERROR");
        private String val;

        STRING_MSG(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }
}
