package com.example.android.paginationusingretrofit.model;


import java.util.List;

public class HomeModel {

    /**
     * status : 0
     * msg : show Successfully
     * image_url : http://192.168.1.200/quotesmanagement/public/uploads/
     * data : [{"id":31,"quotes_image":"1529672129-images (12).jpg","quotes":"Hold fast to dreams, for if dreams die, life is a broken-winged bird that cannot fly."},{"id":30,"quotes_image":"1529672092-images (11).jpg","quotes":"Opportunities don't happen. You create them."},{"id":29,"quotes_image":"1529672057-images (8).jpg","quotes":"Success usually comes to those who are too busy to be looking for it."},{"id":28,"quotes_image":"1529672022-images (19).jpg","quotes":"Don't be afraid to give up the good to go for the great."},{"id":27,"quotes_image":"1529671987-images (12).jpg","quotes":"All our dreams can come true, if we have the courage to pursue them."},{"id":26,"quotes_image":"1529671957-images (15).jpg","quotes":"Hold fast to dreams, for if dreams die, life is a broken-winged bird that cannot fly."},{"id":25,"quotes_image":"1529671924-images (17).jpg","quotes":"It does not do to dwell on dreams and forget to live."},{"id":24,"quotes_image":"1529671902-navigation_cover.jpg","quotes":"Success is not final; failure is not fatal: It is the courage to continue that counts."},{"id":23,"quotes_image":"1529671534-images (15).jpg","quotes":"If only we could pull out our brain and use only our eyes."},{"id":22,"quotes_image":"1529671512-images (7).jpg","quotes":"Falsity in intellectual action is intellectual immorality."}]
     */

    private int status;
    private String msg;
    private String image_url;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 31
         * quotes_image : 1529672129-images (12).jpg
         * quotes : Hold fast to dreams, for if dreams die, life is a broken-winged bird that cannot fly.
         */

        private String id;
        private String quotes_image;
        private String quotes;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getQuotes_image() {
            return quotes_image;
        }

        public void setQuotes_image(String quotes_image) {
            this.quotes_image = quotes_image;
        }

        public String getQuotes() {
            return quotes;
        }

        public void setQuotes(String quotes) {
            this.quotes = quotes;
        }
    }
}
