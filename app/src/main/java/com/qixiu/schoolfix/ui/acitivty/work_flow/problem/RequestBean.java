package com.qixiu.schoolfix.ui.acitivty.work_flow.problem;

import com.qixiu.schoolfix.model.BaseRequestIntef;

import java.util.List;

public class RequestBean implements BaseRequestIntef {

        /**
         * pageIndex : 1
         * pageSize : 1000
         * order : ProductProblemRemark
         * filter : {"type":"and","conditions":[{"attribute":"ProductGUID","datatype":"uniqueidentifier","operatoer":"eq","value":"50BB2ACD-7694-436F-8BE7-08D64C5BA3EC"}]}
         */

        private int pageIndex;
        private int pageSize;
        private String order;
        /**
         * type : and
         * conditions : [{"attribute":"ProductGUID","datatype":"uniqueidentifier","operatoer":"eq","value":"50BB2ACD-7694-436F-8BE7-08D64C5BA3EC"}]
         */

        private FilterBean filter;

        public int getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(int pageIndex) {
            this.pageIndex = pageIndex;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public FilterBean getFilter() {
            return filter;
        }

        public void setFilter(FilterBean filter) {
            this.filter = filter;
        }

        public static class FilterBean {
            private String type;
            /**
             * attribute : ProductGUID
             * datatype : uniqueidentifier
             * operatoer : eq
             * value : 50BB2ACD-7694-436F-8BE7-08D64C5BA3EC
             */

            private List<ConditionsBean> conditions;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ConditionsBean> getConditions() {
                return conditions;
            }

            public void setConditions(List<ConditionsBean> conditions) {
                this.conditions = conditions;
            }

            public static class ConditionsBean {
                private String attribute;
                private String datatype;
                private String operatoer;
                private String value;

                public String getAttribute() {
                    return attribute;
                }

                public void setAttribute(String attribute) {
                    this.attribute = attribute;
                }

                public String getDatatype() {
                    return datatype;
                }

                public void setDatatype(String datatype) {
                    this.datatype = datatype;
                }

                public String getOperatoer() {
                    return operatoer;
                }

                public void setOperatoer(String operatoer) {
                    this.operatoer = operatoer;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }
        }
    }