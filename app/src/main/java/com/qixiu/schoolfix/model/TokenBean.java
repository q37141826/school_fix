package com.qixiu.schoolfix.model;

import com.qixiu.qixiu.request.bean.BaseBean;

/**
 * Created by my on 2018/11/23.
 */

public class TokenBean extends BaseBean<TokenBean.ResultBean> {

    public static final String TOKEN_TAG="Bearer ";
    /**
     * accessToken : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMDAyIiwianRpIjoiNzQxM2I3NzUtNTUzNi00OWJiLWEyMzItNzljOWNlMjdhN2U0IiwiaWF0IjoxNTQyOTQzMzcyLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJhZG1pbiIsIm5iZiI6MTU0Mjk0MzM3MiwiZXhwIjoxNTQyOTUwNTcyLCJpc3MiOiJNeUFCUFZ1ZUNvcmUiLCJhdWQiOiJNeUFCUFZ1ZUNvcmUifQ.rzrCJQDkDn4cKUMwnsAmAzVE9xm6Bi_bU1_lzbS_DRE
     * encryptedAccessToken : wNYmO41/48SHNstaLVXxHCCre29BZQl1NhC6NM3R3rwZiL572M4gBaHf6sHsTGZfduWg8KXCE0hKju27oGz4iuxz25JgR+1zwtL1lHECJWYCSBuaxW3V3LBJXziWVETe5gM2UmBRnG5LfYFw8hV7tHoI+WhnV26Ih4cRk/i1D2mG08E8HJTt8qaz+/WA6z44Z06ZnPVnL3llaRSD9YZt9LpYHjiFYtSMDpODDp4D+FKlrKu/6o5zT+ei852I7j3TGbJMmrzb0opFadP1RovLyyKtlR9U/l/x/5/fg38ZriKwQke6XrWIZTH/NI+GvWRUtU9QothofcbJeccS/qr0AXb5ygBYlJqjqDq7KHQ0Csp76npqJUbhRVSnuhzcIheJDvWiwdRd3n5+Txz3g+bkGcjpAIzMgFg0W1qptXHnX56aiRIllyvmkB0EbqS8y2s5bTdOJb4IyrpL3NJnYxL0Yn8+IfGCmHTha7eYJx5vC+YqREdehbw+cZSFioFPpNA5
     * expireInSeconds : 6900
     * userId : 0
     */


    public static class ResultBean {
        private String accessToken;
        private String encryptedAccessToken;
        private int expireInSeconds;
        private int userId;

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getEncryptedAccessToken() {
            return encryptedAccessToken;
        }

        public void setEncryptedAccessToken(String encryptedAccessToken) {
            this.encryptedAccessToken = encryptedAccessToken;
        }

        public int getExpireInSeconds() {
            return expireInSeconds;
        }

        public void setExpireInSeconds(int expireInSeconds) {
            this.expireInSeconds = expireInSeconds;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
