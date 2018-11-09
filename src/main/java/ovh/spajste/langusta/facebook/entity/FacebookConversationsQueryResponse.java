package ovh.spajste.langusta.facebook.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FacebookConversationsQueryResponse {
    public class FacebookConversations {
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

        private FacebookConversationId[] data;

        public FacebookConversations() {
            this(null);
        }

        public FacebookConversations(FacebookConversationId[] facebookConversationsData) {
            this.data = facebookConversationsData;
        }

        public FacebookConversationId[] getData() {
            return data;
        }

        public void setData(FacebookConversationId[] data) {
            this.data = data;
        }

        public FacebookPaging getPaging() {
            return paging;
        }

        public void setPaging(FacebookPaging paging) {
            this.paging = paging;
        }
    }
    private FacebookConversations conversations;

    private String id;

    public FacebookConversationsQueryResponse() {

    }

    public FacebookConversationsQueryResponse(FacebookConversations facebookAccounts, String id) {
        this.conversations = facebookAccounts;
        this.id = id;
    }

    public FacebookConversations getConversations() {
        return conversations;
    }

    public String getId() {
        return id;
    }

    public void setConversations(FacebookConversations accounts) {
        this.conversations = accounts;
    }

    public void setId(String id) {
        this.id = id;
    }
}
