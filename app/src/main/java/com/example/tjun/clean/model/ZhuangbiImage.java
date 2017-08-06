// (c)2016 Flipboard Inc, All Rights Reserved.

package com.example.tjun.clean.model;

import java.util.List;

public class ZhuangbiImage {

    /**
     * resultData : {"lastPage":true,"pageSize":10,"pageNumber":1,"firstPage":true,"list":[{"price":10,"name":"Converse诞生于1908年。创办以来Converse坚","specId":1159,"image":"http://testpic.g1zg.com/uploads/b3bcef8ec439487d9b560603067862df.png","businessId":32,"productId":150}],"totalRow":1,"totalPage":1}
     * resultCode : 1
     * resultDes : success
     */

    private ResultDataBean resultData;
    private String resultCode;
    private String resultDes;

    public ResultDataBean getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataBean resultData) {
        this.resultData = resultData;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDes() {
        return resultDes;
    }

    public void setResultDes(String resultDes) {
        this.resultDes = resultDes;
    }

    @Override
    public String toString() {
        return "ZhuangbiImage{" +
                "resultData=" + resultData +
                ", resultCode='" + resultCode + '\'' +
                ", resultDes='" + resultDes + '\'' +
                '}';
    }

    public static class ResultDataBean {
        /**
         * lastPage : true
         * pageSize : 10
         * pageNumber : 1
         * firstPage : true
         * list : [{"price":10,"name":"Converse诞生于1908年。创办以来Converse坚","specId":1159,"image":"http://testpic.g1zg.com/uploads/b3bcef8ec439487d9b560603067862df.png","businessId":32,"productId":150}]
         * totalRow : 1
         * totalPage : 1
         */


        private boolean lastPage;
        private int pageSize;
        private int pageNumber;
        private boolean firstPage;
        private int totalRow;
        private int totalPage;
        private List<ListBean> list;

        public boolean isLastPage() {
            return lastPage;
        }

        public void setLastPage(boolean lastPage) {
            this.lastPage = lastPage;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public boolean isFirstPage() {
            return firstPage;
        }

        public void setFirstPage(boolean firstPage) {
            this.firstPage = firstPage;
        }

        public int getTotalRow() {
            return totalRow;
        }

        public void setTotalRow(int totalRow) {
            this.totalRow = totalRow;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        @Override
        public String toString() {
            return "ResultDataBean{" +
                    "lastPage=" + lastPage +
                    ", pageSize=" + pageSize +
                    ", pageNumber=" + pageNumber +
                    ", firstPage=" + firstPage +
                    ", totalRow=" + totalRow +
                    ", totalPage=" + totalPage +
                    ", list=" + list +
                    '}';
        }

        public static class ListBean {

            /**
             * price : 10.0
             * name : Converse诞生于1908年。创办以来Converse坚
             * specId : 1159
             * image : http://testpic.g1zg.com/uploads/b3bcef8ec439487d9b560603067862df.png
             * businessId : 32
             * productId : 150
             */


            private double price;
            private String name;
            private int specId;
            private String image;
            private int businessId;
            private int productId;

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getSpecId() {
                return specId;
            }

            public void setSpecId(int specId) {
                this.specId = specId;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getBusinessId() {
                return businessId;
            }

            public void setBusinessId(int businessId) {
                this.businessId = businessId;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "price=" + price +
                        ", name='" + name + '\'' +
                        ", specId=" + specId +
                        ", image='" + image + '\'' +
                        ", businessId=" + businessId +
                        ", productId=" + productId +
                        '}';
            }
        }
    }

}
