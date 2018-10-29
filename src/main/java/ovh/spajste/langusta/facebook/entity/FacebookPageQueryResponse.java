package ovh.spajste.langusta.facebook.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FacebookPageQueryResponse {
    class FacebookAccounts {
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

        private FacebookBasicPageInfo[] data;

        public FacebookAccounts() {
            this(null);
        }

        public FacebookAccounts(FacebookBasicPageInfo[] facebookAccountsData) {
            this.data = facebookAccountsData;
        }

        public FacebookBasicPageInfo[] getData() {
            return data;
        }

        public void setData(FacebookBasicPageInfo[] data) {
            this.data = data;
        }

        public FacebookPaging getPaging() {
            return paging;
        }

        public void setPaging(FacebookPaging paging) {
            this.paging = paging;
        }
    }
    private FacebookAccounts accounts;

    private String id;

    public FacebookPageQueryResponse() {

    }

    public FacebookPageQueryResponse(FacebookAccounts facebookAccounts, String id) {
        this.accounts = facebookAccounts;
        this.id = id;
    }

    public FacebookAccounts getAccounts() {
        return accounts;
    }

    public String getId() {
        return id;
    }

    public void setAccounts(FacebookAccounts accounts) {
        this.accounts = accounts;
    }

    public void setId(String id) {
        this.id = id;
    }
}
