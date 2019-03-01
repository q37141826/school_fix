package com.qixiu.schoolfix.model.check_mechine;

import com.qixiu.qixiu.request.bean.BaseBean;

public class CheckStepMoudleBean extends BaseBean<CheckStepMoudleBean.ResultBean> {

    public static class ResultBean {
        /**
         * id : 92d0fdcd-c519-44bd-37e6-08d69c598bf5
         * checkPointGUID : 8d82f10e-5f05-4cd9-6859-08d69af30dd4
         * checkReportDate : 2019-02-27 00:00:00
         * checkReportType : 1
         * checkReportValue : [{"groupName":"学校交换机当前与教育连接的端口","reportTemplateOptionDtos":[{"key":"端口号","value":null,"valueType":"字符串"},{"key":"电信纤芯号","value":null,"valueType":"字符串"}]},{"groupName":"学校交换机与教育网连接类型","reportTemplateOptionDtos":[{"key":"光模块型号","value":null,"valueType":"字符串"},{"key":"网线","value":null,"valueType":"字符串"}]},{"groupName":"连接教育网的光纤模块光纤跳迁信息","reportTemplateOptionDtos":[{"key":"跳纤接口","value":null,"valueType":"字符串"},{"key":"跳纤长度","value":null,"valueType":"字符串"}]},{"groupName":"交换机外观及端口使用情况","reportTemplateOptionDtos":[{"key":"机框式","value":null,"valueType":"字符串"},{"key":"光口数量","value":null,"valueType":"字符串"},{"key":"光口使用数量","value":null,"valueType":"字符串"},{"key":"电口数量","value":null,"valueType":"字符串"},{"key":"电口使用数量","value":null,"valueType":"字符串"}]},{"groupName":"交换机电源信息","reportTemplateOptionDtos":[{"key":"安装电源数量","value":null,"valueType":"字符串"},{"key":"电源线是否固定安全","value":null,"valueType":"字符串"},{"key":"处理措施","value":null,"valueType":"字符串"}]},{"groupName":"交换机线路连接情况","reportTemplateOptionDtos":[{"key":"是否整齐","value":"1","valueType":"真值"},{"key":"处理措施","value":null,"valueType":"字符串"}]},{"groupName":"交换机上有新增线路","reportTemplateOptionDtos":[{"key":"是否有新增","value":"1","valueType":"真值"},{"key":"处理措施","value":null,"valueType":"字符串"}]},{"groupName":"交换机散热风扇情况","reportTemplateOptionDtos":[{"key":"是否报警","value":"1","valueType":"真值"},{"key":"处理措施","value":null,"valueType":"字符串"}]},{"groupName":"交换机周边灰尘清理","reportTemplateOptionDtos":[{"key":"是否清理","value":"1","valueType":"真值"},{"key":"处理措施","value":null,"valueType":"字符串"}]}]
         * checkSignUrl : null
         * teacherSignUrl : null
         */

        private String id;
        private String checkPointGUID;
        private String checkReportDate;
        private int checkReportType;
        private String checkReportValue;
        private String checkSignUrl;
        private String teacherSignUrl;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCheckPointGUID() {
            return checkPointGUID;
        }

        public void setCheckPointGUID(String checkPointGUID) {
            this.checkPointGUID = checkPointGUID;
        }

        public String getCheckReportDate() {
            return checkReportDate;
        }

        public void setCheckReportDate(String checkReportDate) {
            this.checkReportDate = checkReportDate;
        }

        public int getCheckReportType() {
            return checkReportType;
        }

        public void setCheckReportType(int checkReportType) {
            this.checkReportType = checkReportType;
        }

        public String getCheckReportValue() {
            return checkReportValue;
        }

        public void setCheckReportValue(String checkReportValue) {
            this.checkReportValue = checkReportValue;
        }

        public Object getCheckSignUrl() {
            return checkSignUrl;
        }

        public void setCheckSignUrl(String checkSignUrl) {
            this.checkSignUrl = checkSignUrl;
        }

        public String getTeacherSignUrl() {
            return teacherSignUrl;
        }

        public void setTeacherSignUrl(String teacherSignUrl) {
            this.teacherSignUrl = teacherSignUrl;
        }
    }
}
