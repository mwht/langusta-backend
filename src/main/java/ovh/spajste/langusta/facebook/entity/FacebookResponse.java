package ovh.spajste.langusta.facebook.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FacebookResponse<T> {
    public class FacebookDataHeader {
        public class FacebookPaging {
            public class FacebookCursors {
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

        private T[] data;

        public FacebookDataHeader() {
            this(null);
        }

        public FacebookDataHeader(T[] facebookAccountsData) {
            this.data = facebookAccountsData;
        }

        public T[] getData() {
            return data;
        }

        public void setData(T[] data) {
            this.data = data;
        }

        public FacebookPaging getPaging() {
            return paging;
        }

        public void setPaging(FacebookPaging paging) {
            this.paging = paging;
        }
    }
    private FacebookDataHeader accounts;

    private String id;

    public FacebookResponse() {
        this(null, null);
    }

    public FacebookResponse(FacebookDataHeader facebookDataHeader, String id) {
        this.accounts = facebookDataHeader;
        this.id = id;
    }

    public FacebookDataHeader getDataHeaders() {
        return accounts;
    }

    public String getId() {
        return id;
    }

    public void setDataHeaders(FacebookDataHeader accounts) {
        this.accounts = accounts;
    }

    public void setId(String id) {
        this.id = id;
    }
}
