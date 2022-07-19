package com.livix.lib_base.api;

import java.util.List;

/**
 * @author LIVIX
 * @date: 2022/7/6
 */
public class TokenBean {
    /**
     * accessToken : guest1474d0209be04b549645b818b951850b
     * strateges : [{"authStep":1,"isAdditional":false,"authMethod":"normal_login_password","strategyCode":"normal_user_login","businessCode":"user_login"},{"authStep":1,"isAdditional":false,"authMethod":"device_gesture_password","strategyCode":"device_gesture_login","businessCode":"user_login"},{"authStep":1,"isAdditional":false,"authMethod":"token_code","strategyCode":"token_code_login","businessCode":"user_login"},{"authStep":1,"isAdditional":false,"authMethod":"sms_code","strategyCode":"sms_code_login","businessCode":"user_login"},{"authStep":1,"isAdditional":false,"authMethod":"device_login_password","strategyCode":"device_user_login","businessCode":"user_login"},{"authStep":1,"isAdditional":false,"authMethod":"normal_login_password","strategyCode":"stock_user_login","businessCode":"user_login"}]
     */

    private String accessToken;
    private List<StrategesBean> strateges;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public List<StrategesBean> getStrateges() {
        return strateges;
    }

    public void setStrateges(List<StrategesBean> strateges) {
        this.strateges = strateges;
    }

    public static class StrategesBean {
        /**
         * authStep : 1
         * isAdditional : false
         * authMethod : normal_login_password
         * strategyCode : normal_user_login
         * businessCode : user_login
         */

        private int authStep;
        private boolean isAdditional;
        private String authMethod;
        private String strategyCode;
        private String businessCode;

        public int getAuthStep() {
            return authStep;
        }

        public void setAuthStep(int authStep) {
            this.authStep = authStep;
        }

        public boolean isIsAdditional() {
            return isAdditional;
        }

        public void setIsAdditional(boolean isAdditional) {
            this.isAdditional = isAdditional;
        }

        public String getAuthMethod() {
            return authMethod;
        }

        public void setAuthMethod(String authMethod) {
            this.authMethod = authMethod;
        }

        public String getStrategyCode() {
            return strategyCode;
        }

        public void setStrategyCode(String strategyCode) {
            this.strategyCode = strategyCode;
        }

        public String getBusinessCode() {
            return businessCode;
        }

        public void setBusinessCode(String businessCode) {
            this.businessCode = businessCode;
        }
    }
}

