package ovh.spajste.langusta.facebook.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

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
    private FacebookDataHeader dataHeader;

    private String id;

    public FacebookResponse() {
        this(null, null);
    }

    public FacebookResponse(FacebookDataHeader facebookDataHeader, String id) {
        this.dataHeader = facebookDataHeader;
        this.id = id;
    }

    @JsonProperty("p")
    @JsonSerialize(using = FacebookResponseSerializer.class)
    public FacebookDataHeader getDataHeaders() {
        return dataHeader;
    }

    public String getId() {
        return id;
    }

    public void setDataHeaders(FacebookDataHeader accounts) {
        this.dataHeader = accounts;
    }

    public void setId(String id) {
        this.id = id;
    }

    private class FacebookResponseSerializer extends JsonSerializer<Object> {
        public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
            jgen.writeStartObject();
            jgen.writeObjectField("accounts", value);
            jgen.writeEndObject();
        }
    }
}
