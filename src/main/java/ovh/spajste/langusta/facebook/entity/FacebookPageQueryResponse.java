package ovh.spajste.langusta.facebook.entity;

public class FacebookPageQueryResponse {
    class FacebookAccounts {
        class FacebookAccountsData {
            private FacebookBasicPageInfo[] pageInfos;

            public FacebookAccountsData() {
                this(null);
            }

            public FacebookAccountsData(FacebookBasicPageInfo[] pageInfos) {
                this.pageInfos = pageInfos;
            }

            public FacebookBasicPageInfo[] getPageInfos() {
                return pageInfos;
            }

            public void setPageInfos(FacebookBasicPageInfo[] pageInfos) {
                this.pageInfos = pageInfos;
            }
        }
        private FacebookAccountsData data;

        public FacebookAccounts() {
            this(null);
        }

        public FacebookAccounts(FacebookAccountsData facebookAccountsData) {
            this.data = facebookAccountsData;
        }

        public FacebookAccountsData getData() {
            return data;
        }

        public void setData(FacebookAccountsData data) {
            this.data = data;
        }
    }
    private FacebookAccounts accounts;

    class FacebookPaging {
        class FacebookCursors {
            String before;
            String after;

            public FacebookCursors() {
                this(null, null);
            }

            public FacebookCursors(String before, String after) {
                this.before = before;
                this.after = after;
            }

            public String getBefore() {
                return before;
            }

            public String getAfter() {
                return after;
            }

            public void setBefore(String before) {
                this.before = before;
            }

            public void setAfter(String after) {
                this.after = after;
            }
        }
        private FacebookCursors cursors;

        public FacebookPaging() {
            this(null);
        }

        public FacebookPaging(FacebookCursors facebookCursors) {
            this.cursors = facebookCursors;
        }

        public FacebookCursors getCursors() {
            return cursors;
        }

        public void setCursors(FacebookCursors cursors) {
            this.cursors = cursors;
        }
    }
    private FacebookPaging paging;
    private String id;

    public FacebookPageQueryResponse() {

    }

    public FacebookPageQueryResponse(FacebookAccounts facebookAccounts, FacebookPaging facebookPaging, String id) {
        this.accounts = facebookAccounts;
        this.paging = facebookPaging;
        this.id = id;
    }

    public FacebookAccounts getAccounts() {
        return accounts;
    }

    public FacebookPaging getPaging() {
        return paging;
    }

    public String getId() {
        return id;
    }

    public void setAccounts(FacebookAccounts accounts) {
        this.accounts = accounts;
    }

    public void setPaging(FacebookPaging paging) {
        this.paging = paging;
    }

    public void setId(String id) {
        this.id = id;
    }
}
