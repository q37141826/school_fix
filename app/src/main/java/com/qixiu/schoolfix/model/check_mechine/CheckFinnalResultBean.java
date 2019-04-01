package com.qixiu.schoolfix.model.check_mechine;

import com.qixiu.qixiu.request.bean.BaseBean;

public class CheckFinnalResultBean extends BaseBean<CheckFinnalResultBean.ResultBean> {



    public static class ResultBean {
        /**
         * checkPointGUID : 8d82f10e-5f05-4cd9-6859-08d69af30dd4
         * checkReportDate : 2019-03-05 00:00:00
         * checkReportType : 2
         * checkReportValue : [{"groupName":"机房环境","reportTemplateOptionDtos":[{"id":"电力箱电闸是否正常","key":"电力箱电闸是否正常","value":"1","valueType":"真值"},{"id":"电力箱电闸是否正常处置情况","key":"处置情况","value":"","valueType":"字符串"},{"id":"静电地板下是否有杂物积水","key":"静电地板下是否有杂物积水","value":"1","valueType":"真值"},{"id":"静电地板下是否有杂物积水处置情况","key":"处置情况","value":"","valueType":"字符串"},{"id":"机房内灭火器是否在有效期内","key":"机房内灭火器是否在有效期内","value":"1","valueType":"真值"},{"id":"机房内灭火器是否在有效期内处置情况","key":"处置情况","value":"","valueType":"字符串"},{"id":"空调、烟感、警铃、防爆灯、UPS是否正常","key":"空调、烟感、警铃、防爆灯、UPS是否正常","value":"1","valueType":"真值"},{"id":"空调、烟感、警铃、防爆灯、UPS是否正常处置情况","key":"处置情况","value":"","valueType":"字符串"},{"id":"机房、机柜内温湿度及传感器数据是否正常","key":"机房、机柜内温湿度及传感器数据是否正常","value":"1","valueType":"真值"},{"id":"机房、机柜内温湿度及传感器数据是否正常处置情况","key":"处置情况","value":"","valueType":"字符串"},{"id":"机房内环控监测设备数据采集是否正常","key":"机房内环控监测设备数据采集是否正常","value":"1","valueType":"真值"},{"id":"机房内环控监测设备数据采集是否正常处置情况","key":"处置情况","value":"","valueType":"字符串"}]},{"groupName":"线路检查","reportTemplateOptionDtos":[{"id":"强弱电线路是否整齐","key":"强弱电线路是否整齐","value":"1","valueType":"真值"},{"id":"强弱电线路是否整齐处置情况","key":"处置情况","valueType":"字符串"},{"id":"机房内是否无新增线缆","key":"机房内是否无新增线缆","value":"1","valueType":"真值"},{"id":"机房内是否无新增线缆处置情况","key":"处置情况","value":"","valueType":"字符串"},{"id":"设备电源线是否整齐、合理，所有设备电源线是否连接到PDU上","key":"设备电源线是否整齐、合理，所有设备电源线是否连接到PDU上","value":"1","valueType":"真值"},{"id":"设备电源线是否整齐、合理，所有设备电源线是否连接到PDU上处置情况","key":"处置情况","value":"","valueType":"字符串"},{"id":"所有线路、设备以及电源线标签是否清楚","key":"所有线路、设备以及电源线标签是否清楚","value":"1","valueType":"真值"},{"id":"所有线路、设备以及电源线标签是否清楚处置情况","key":"处置情况","value":"","valueType":"字符串"}]},{"groupName":"机房卫生检查","reportTemplateOptionDtos":[{"id":"设备除尘","key":"设备除尘","value":"0","valueType":"真值"},{"id":"机房清扫","key":"机房清扫","value":"0","valueType":"真值"},{"id":"机房无杂物堆放","key":"机房无杂物堆放","value":"0","valueType":"真值"},{"id":"各机房拍照记录","key":"各机房拍照记录","value":"1","valueType":"真值"}]}]
         * checkSignUrl : /upload/SHWorkOrder/2019030518559_20190305918upload.jpg
         * teacherSignUrl : null
         * teacherSignTime : null
         * id : d701566e-3a83-4565-e693-08d6a10807b6
         */

        private String checkPointGUID;
        private String checkReportDate;
        private int checkReportType;
        private String checkReportValue;
        private String checkSignUrl;
        private Object teacherSignUrl;
        private Object teacherSignTime;
        private String id;

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

        public String getCheckSignUrl() {
            return checkSignUrl;
        }

        public void setCheckSignUrl(String checkSignUrl) {
            this.checkSignUrl = checkSignUrl;
        }

        public Object getTeacherSignUrl() {
            return teacherSignUrl;
        }

        public void setTeacherSignUrl(Object teacherSignUrl) {
            this.teacherSignUrl = teacherSignUrl;
        }

        public Object getTeacherSignTime() {
            return teacherSignTime;
        }

        public void setTeacherSignTime(Object teacherSignTime) {
            this.teacherSignTime = teacherSignTime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
