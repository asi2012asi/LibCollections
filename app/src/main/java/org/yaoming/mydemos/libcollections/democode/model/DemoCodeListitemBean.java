package org.yaoming.mydemos.libcollections.democode.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 2016/3/2.
 */
public class DemoCodeListitemBean implements Parcelable {
    /**
     * 分类
     */
    private String category;
    /**
     * 标题
     */
    private String title;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.category);
        dest.writeString(this.title);
    }

    public DemoCodeListitemBean(String category,String title) {
        this.category = category;
        this.title = title;

    }

    protected DemoCodeListitemBean(Parcel in) {
        this.category = in.readString();
        this.title = in.readString();
    }

    public static final Parcelable.Creator<DemoCodeListitemBean> CREATOR = new Parcelable.Creator<DemoCodeListitemBean>() {
        public DemoCodeListitemBean createFromParcel(Parcel source) {
            return new DemoCodeListitemBean(source);
        }

        public DemoCodeListitemBean[] newArray(int size) {
            return new DemoCodeListitemBean[size];
        }
    };
}
