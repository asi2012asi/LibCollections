package org.yaoming.mydemos.libcollections.democode.view;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import org.yaoming.mydemos.libcollections.R;
import org.yaoming.mydemos.libcollections.democode.model.DemoCodeListitemBean;

/**
 * Created by user on 2016/3/2.
 */
public class DemoCodeListAdapter extends RecyclerArrayAdapter<DemoCodeListitemBean> {
    public DemoCodeListAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new DemoCodeListItemViewHolder(parent, R.layout.listitem_democode_list);
    }


    public static class DemoCodeListItemViewHolder extends BaseViewHolder<DemoCodeListitemBean>{

        private TextView tvCategory;
        private TextView tvTitle;

        private void assignViews() {
            tvCategory =  findView(R.id.tvCategory);
            tvTitle =  findView(R.id.tvTitle);
        }


        public DemoCodeListItemViewHolder(ViewGroup parent, @LayoutRes int res) {
            super(parent, res);
            assignViews();
        }

        @Override
        public void setData(DemoCodeListitemBean data) {
            super.setData(data);
            tvCategory.setText(data.getCategory());
            tvTitle.setText(data.getTitle());

        }
    }


}
