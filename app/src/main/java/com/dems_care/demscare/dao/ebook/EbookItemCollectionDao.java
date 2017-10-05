
package com.dems_care.demscare.dao.ebook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EbookItemCollectionDao {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("ebooks")
    @Expose
    private List<Ebook> ebooks = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Ebook> getEbooks() {
        return ebooks;
    }

    public void setEbooks(List<Ebook> ebooks) {
        this.ebooks = ebooks;
    }

}
