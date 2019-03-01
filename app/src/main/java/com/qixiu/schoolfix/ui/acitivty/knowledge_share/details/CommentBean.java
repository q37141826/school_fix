package com.qixiu.schoolfix.ui.acitivty.knowledge_share.details;

import android.os.Parcel;
import android.os.Parcelable;

public class CommentBean implements Parcelable {
        private String methoed;
        private String id;

    public String getMethoed() {
        return methoed;
    }

    public void setMethoed(String methoed) {
        this.methoed = methoed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.methoed);
        dest.writeString(this.id);
    }

    public CommentBean() {
    }

    protected CommentBean(Parcel in) {
        this.methoed = in.readString();
        this.id = in.readString();
    }

    public static final Parcelable.Creator<CommentBean> CREATOR = new Parcelable.Creator<CommentBean>() {
        @Override
        public CommentBean createFromParcel(Parcel source) {
            return new CommentBean(source);
        }

        @Override
        public CommentBean[] newArray(int size) {
            return new CommentBean[size];
        }
    };
}