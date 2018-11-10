
package ovh.spajste.langusta.facebook.entity;

import java.util.List;
import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class FacebookComments {

    private List<FacebookDatum> data;
    private FacebookPaging paging;

    public List<FacebookDatum> getData() {
        return data;
    }

    public void setData(List<FacebookDatum> data) {
        this.data = data;
    }

    public FacebookPaging getPaging() {
        return paging;
    }

    public void setPaging(FacebookPaging paging) {
        this.paging = paging;
    }

}
