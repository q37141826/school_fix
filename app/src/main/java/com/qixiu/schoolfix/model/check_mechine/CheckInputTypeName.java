package com.qixiu.schoolfix.model.check_mechine;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class CheckInputTypeName implements Parcelable {

    private List<CheckReportValueBean> checkReportValue;

    public List<CheckReportValueBean> getCheckReportValue() {
        return checkReportValue;
    }

    public void setCheckReportValue(List<CheckReportValueBean> checkReportValue) {
        this.checkReportValue = checkReportValue;
    }

    public static class CheckReportValueBean implements Parcelable {


        /**
         * groupName : 学校交换机当前与教育连接的端口
         * reportTemplateOptionDtos : [{"key":"端口号","value":null,"valueType":"字符串"},{"key":"电信纤芯号","value":null,"valueType":"字符串"}]
         */

        private String groupName;
        private List<ReportTemplateOptionDtosBean> reportTemplateOptionDtos;

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public List<ReportTemplateOptionDtosBean> getReportTemplateOptionDtos() {
            return reportTemplateOptionDtos;
        }

        public void setReportTemplateOptionDtos(List<ReportTemplateOptionDtosBean> reportTemplateOptionDtos) {
            this.reportTemplateOptionDtos = reportTemplateOptionDtos;
        }

        public static class ReportTemplateOptionDtosBean implements Parcelable {
            /**
             * key : 端口号
             * value : null
             * valueType : 字符串
             */

            private String key;
            private String value;
            private String valueType;
            private String id;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getValueType() {
                return valueType;
            }

            public void setValueType(String valueType) {
                this.valueType = valueType;
            }

            public ReportTemplateOptionDtosBean() {
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.key);
                dest.writeString(this.value);
                dest.writeString(this.valueType);
                dest.writeString(this.id);
            }

            protected ReportTemplateOptionDtosBean(Parcel in) {
                this.key = in.readString();
                this.value = in.readString();
                this.valueType = in.readString();
                this.id = in.readString();
            }

            public static final Creator<ReportTemplateOptionDtosBean> CREATOR = new Creator<ReportTemplateOptionDtosBean>() {
                @Override
                public ReportTemplateOptionDtosBean createFromParcel(Parcel source) {
                    return new ReportTemplateOptionDtosBean(source);
                }

                @Override
                public ReportTemplateOptionDtosBean[] newArray(int size) {
                    return new ReportTemplateOptionDtosBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.groupName);
            dest.writeList(this.reportTemplateOptionDtos);
        }

        public CheckReportValueBean() {
        }

        protected CheckReportValueBean(Parcel in) {
            this.groupName = in.readString();
            this.reportTemplateOptionDtos = new ArrayList<ReportTemplateOptionDtosBean>();
            in.readList(this.reportTemplateOptionDtos, ReportTemplateOptionDtosBean.class.getClassLoader());
        }

        public static final Creator<CheckReportValueBean> CREATOR = new Creator<CheckReportValueBean>() {
            @Override
            public CheckReportValueBean createFromParcel(Parcel source) {
                return new CheckReportValueBean(source);
            }

            @Override
            public CheckReportValueBean[] newArray(int size) {
                return new CheckReportValueBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.checkReportValue);
    }

    public CheckInputTypeName() {
    }

    protected CheckInputTypeName(Parcel in) {
        this.checkReportValue = new ArrayList<CheckReportValueBean>();
        in.readList(this.checkReportValue, CheckReportValueBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<CheckInputTypeName> CREATOR = new Parcelable.Creator<CheckInputTypeName>() {
        @Override
        public CheckInputTypeName createFromParcel(Parcel source) {
            return new CheckInputTypeName(source);
        }

        @Override
        public CheckInputTypeName[] newArray(int size) {
            return new CheckInputTypeName[size];
        }
    };
}
