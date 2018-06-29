package com.safes.mling.safesapp.bean;

import java.util.List;

/**
 * Created by MLing on 2018/6/14 0014.
 */

public class HomeBean {

    /**
     * errcode : 0
     * data : {"indexCatePro":[{"id":"2","cate_name":"意外险","cate_sname":"意外险","cate_pic":"http://admin.23so.cn/upload/201805/03/006eb87b335e8b0497ac2c8b5b5cc01c1f196ecc1525319699.png","cate_icon":"http://admin.23so.cn/upload/201806/25/a65b9679a4783b2aaa98bb9cdf421cb3f35d56b01529920203.jpeg","cate_desc":"意外险即人身意外保险，又称意外伤害保险，是指在保险期限内，当被保险人遭受意外伤害，并以此为直接原因造成身故或残疾时，保险公司按照保险合同的约定向被保险人或受益人支付一定数量保险金的保险。保障项目包括意外伤害身故保险金、意外伤害残疾保险金等","pro":[{"id":"1","title":"健康定期重大疾病保险","title_desc":"可以多次赔付终身疾病保障","price":"1200.00","pic_id":"1","brand_id":"1","brand":{"id":"1","bname":"太平洋","sname":"太平洋","pic":"http://admin.23so.cn/upload/201806/26/35d7a61e4896c1f648ca43e3891926206121b6431529985048.png"},"title_pic":"http://admin.23so.cnhttp://www.newchinalife.com/Channel/CMS5_G20306002Resource?info=2610827;res=15041721044121143623824"},{"id":"2","title":"汽车产品保险","title_desc":"80种高发疾病+28钟常见轻症 多赔付","price":"360.00","pic_id":"2","brand_id":"1","brand":{"id":"1","bname":"太平洋","sname":"太平洋","pic":"http://admin.23so.cn/upload/201806/26/35d7a61e4896c1f648ca43e3891926206121b6431529985048.png"},"title_pic":"http://admin.23so.cn/upload/201806/07/b74d72f22cf77b1b5a0e7b728f64418f6f7895be1528365863.jpeg"}]},{"id":"3","cate_name":"旅游险","cate_sname":"旅游险","cate_pic":"http://admin.23so.cn/upload/201806/26/0b485b47e1086cff91ed0eae3d49af2d54a569f31529979523.jpg","cate_icon":"http://admin.23so.cn/upload/201806/26/7d1c81fff8b9d6b0ab1625db24c6ea7eef4796ff1529979523.jpg","cate_desc":"旅游险","pro":[]}],"indexJifenPro":[{"id":"1","title":"健康定期重大疾病保险","title_desc":"可以多次赔付终身疾病保障","price":"1200.00","pic_id":"1","brand_id":"1","brand":{"id":"1","bname":"太平洋","sname":"太平洋","pic":"http://admin.23so.cn/upload/201806/26/35d7a61e4896c1f648ca43e3891926206121b6431529985048.png"},"title_pic":"http://admin.23so.cnhttp://www.newchinalife.com/Channel/CMS5_G20306002Resource?info=2610827;res=15041721044121143623824"},{"id":"2","title":"汽车产品保险","title_desc":"80种高发疾病+28钟常见轻症 多赔付","price":"360.00","pic_id":"2","brand_id":"1","brand":{"id":"1","bname":"太平洋","sname":"太平洋","pic":"http://admin.23so.cn/upload/201806/26/35d7a61e4896c1f648ca43e3891926206121b6431529985048.png"},"title_pic":"http://admin.23so.cn/upload/201806/07/b74d72f22cf77b1b5a0e7b728f64418f6f7895be1528365863.jpeg"}],"banner":[{"id":"1","title":"11","links":"https://www.huyahaha.com/","pic":"https://wx2.sinaimg.cn/mw690/e3cf140dly1fsoor6jg6yj20im0a4di5.jpg"},{"id":"2","title":"22","links":"https://www.huyahaha.com/","pic":"https://wx4.sinaimg.cn/mw690/e3cf140dly1fs182u5a25j21980u01kx.jpg"}]}
     */

    private int errcode;
    private DataBean data;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<IndexCateProBean> indexCatePro;
        private List<IndexJifenProBean> indexJifenPro;
        private List<BannerBean> banner;

        public List<IndexCateProBean> getIndexCatePro() {
            return indexCatePro;
        }

        public void setIndexCatePro(List<IndexCateProBean> indexCatePro) {
            this.indexCatePro = indexCatePro;
        }

        public List<IndexJifenProBean> getIndexJifenPro() {
            return indexJifenPro;
        }

        public void setIndexJifenPro(List<IndexJifenProBean> indexJifenPro) {
            this.indexJifenPro = indexJifenPro;
        }

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public static class IndexCateProBean {
            /**
             * id : 2
             * cate_name : 意外险
             * cate_sname : 意外险
             * cate_pic : http://admin.23so.cn/upload/201805/03/006eb87b335e8b0497ac2c8b5b5cc01c1f196ecc1525319699.png
             * cate_icon : http://admin.23so.cn/upload/201806/25/a65b9679a4783b2aaa98bb9cdf421cb3f35d56b01529920203.jpeg
             * cate_desc : 意外险即人身意外保险，又称意外伤害保险，是指在保险期限内，当被保险人遭受意外伤害，并以此为直接原因造成身故或残疾时，保险公司按照保险合同的约定向被保险人或受益人支付一定数量保险金的保险。保障项目包括意外伤害身故保险金、意外伤害残疾保险金等
             * pro : [{"id":"1","title":"健康定期重大疾病保险","title_desc":"可以多次赔付终身疾病保障","price":"1200.00","pic_id":"1","brand_id":"1","brand":{"id":"1","bname":"太平洋","sname":"太平洋","pic":"http://admin.23so.cn/upload/201806/26/35d7a61e4896c1f648ca43e3891926206121b6431529985048.png"},"title_pic":"http://admin.23so.cnhttp://www.newchinalife.com/Channel/CMS5_G20306002Resource?info=2610827;res=15041721044121143623824"},{"id":"2","title":"汽车产品保险","title_desc":"80种高发疾病+28钟常见轻症 多赔付","price":"360.00","pic_id":"2","brand_id":"1","brand":{"id":"1","bname":"太平洋","sname":"太平洋","pic":"http://admin.23so.cn/upload/201806/26/35d7a61e4896c1f648ca43e3891926206121b6431529985048.png"},"title_pic":"http://admin.23so.cn/upload/201806/07/b74d72f22cf77b1b5a0e7b728f64418f6f7895be1528365863.jpeg"}]
             */

            private String id;
            private String cate_name;
            private String cate_sname;
            private String cate_pic;
            private String cate_icon;
            private String cate_desc;
            private List<ProBean> pro;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCate_name() {
                return cate_name;
            }

            public void setCate_name(String cate_name) {
                this.cate_name = cate_name;
            }

            public String getCate_sname() {
                return cate_sname;
            }

            public void setCate_sname(String cate_sname) {
                this.cate_sname = cate_sname;
            }

            public String getCate_pic() {
                return cate_pic;
            }

            public void setCate_pic(String cate_pic) {
                this.cate_pic = cate_pic;
            }

            public String getCate_icon() {
                return cate_icon;
            }

            public void setCate_icon(String cate_icon) {
                this.cate_icon = cate_icon;
            }

            public String getCate_desc() {
                return cate_desc;
            }

            public void setCate_desc(String cate_desc) {
                this.cate_desc = cate_desc;
            }

            public List<ProBean> getPro() {
                return pro;
            }

            public void setPro(List<ProBean> pro) {
                this.pro = pro;
            }

            public static class ProBean {
                /**
                 * id : 1
                 * title : 健康定期重大疾病保险
                 * title_desc : 可以多次赔付终身疾病保障
                 * price : 1200.00
                 * pic_id : 1
                 * brand_id : 1
                 * brand : {"id":"1","bname":"太平洋","sname":"太平洋","pic":"http://admin.23so.cn/upload/201806/26/35d7a61e4896c1f648ca43e3891926206121b6431529985048.png"}
                 * title_pic : http://admin.23so.cnhttp://www.newchinalife.com/Channel/CMS5_G20306002Resource?info=2610827;res=15041721044121143623824
                 */

                private String id;
                private String title;
                private String title_desc;
                private String price;
                private String pic_id;
                private String brand_id;
                private BrandBean brand;
                private String title_pic;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getTitle_desc() {
                    return title_desc;
                }

                public void setTitle_desc(String title_desc) {
                    this.title_desc = title_desc;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getPic_id() {
                    return pic_id;
                }

                public void setPic_id(String pic_id) {
                    this.pic_id = pic_id;
                }

                public String getBrand_id() {
                    return brand_id;
                }

                public void setBrand_id(String brand_id) {
                    this.brand_id = brand_id;
                }

                public BrandBean getBrand() {
                    return brand;
                }

                public void setBrand(BrandBean brand) {
                    this.brand = brand;
                }

                public String getTitle_pic() {
                    return title_pic;
                }

                public void setTitle_pic(String title_pic) {
                    this.title_pic = title_pic;
                }

                public static class BrandBean {
                    /**
                     * id : 1
                     * bname : 太平洋
                     * sname : 太平洋
                     * pic : http://admin.23so.cn/upload/201806/26/35d7a61e4896c1f648ca43e3891926206121b6431529985048.png
                     */

                    private String id;
                    private String bname;
                    private String sname;
                    private String pic;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getBname() {
                        return bname;
                    }

                    public void setBname(String bname) {
                        this.bname = bname;
                    }

                    public String getSname() {
                        return sname;
                    }

                    public void setSname(String sname) {
                        this.sname = sname;
                    }

                    public String getPic() {
                        return pic;
                    }

                    public void setPic(String pic) {
                        this.pic = pic;
                    }
                }
            }
        }

        public static class IndexJifenProBean {
            /**
             * id : 1
             * title : 健康定期重大疾病保险
             * title_desc : 可以多次赔付终身疾病保障
             * price : 1200.00
             * pic_id : 1
             * brand_id : 1
             * brand : {"id":"1","bname":"太平洋","sname":"太平洋","pic":"http://admin.23so.cn/upload/201806/26/35d7a61e4896c1f648ca43e3891926206121b6431529985048.png"}
             * title_pic : http://admin.23so.cnhttp://www.newchinalife.com/Channel/CMS5_G20306002Resource?info=2610827;res=15041721044121143623824
             */

            private String id;
            private String title;
            private String title_desc;
            private String price;
            private String pic_id;
            private String brand_id;
            private BrandBeanX brand;
            private String title_pic;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTitle_desc() {
                return title_desc;
            }

            public void setTitle_desc(String title_desc) {
                this.title_desc = title_desc;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getPic_id() {
                return pic_id;
            }

            public void setPic_id(String pic_id) {
                this.pic_id = pic_id;
            }

            public String getBrand_id() {
                return brand_id;
            }

            public void setBrand_id(String brand_id) {
                this.brand_id = brand_id;
            }

            public BrandBeanX getBrand() {
                return brand;
            }

            public void setBrand(BrandBeanX brand) {
                this.brand = brand;
            }

            public String getTitle_pic() {
                return title_pic;
            }

            public void setTitle_pic(String title_pic) {
                this.title_pic = title_pic;
            }

            public static class BrandBeanX {
                /**
                 * id : 1
                 * bname : 太平洋
                 * sname : 太平洋
                 * pic : http://admin.23so.cn/upload/201806/26/35d7a61e4896c1f648ca43e3891926206121b6431529985048.png
                 */

                private String id;
                private String bname;
                private String sname;
                private String pic;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getBname() {
                    return bname;
                }

                public void setBname(String bname) {
                    this.bname = bname;
                }

                public String getSname() {
                    return sname;
                }

                public void setSname(String sname) {
                    this.sname = sname;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }
            }
        }

        public static class BannerBean {
            /**
             * id : 1
             * title : 11
             * links : https://www.huyahaha.com/
             * pic : https://wx2.sinaimg.cn/mw690/e3cf140dly1fsoor6jg6yj20im0a4di5.jpg
             */

            private String id;
            private String title;
            private String links;
            private String pic;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLinks() {
                return links;
            }

            public void setLinks(String links) {
                this.links = links;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }
        }
    }
}
