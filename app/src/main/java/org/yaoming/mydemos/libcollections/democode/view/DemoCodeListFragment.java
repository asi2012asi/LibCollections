package org.yaoming.mydemos.libcollections.democode.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import org.yaoming.mydemos.libcollections.R;
import org.yaoming.mydemos.libcollections.democode.model.DemoCodeListitemBean;
import org.yaoming.mydemos.libcollections.democode.presenter.DemoCodePresentImpl;
import org.yaoming.mydemos.libcollections.global.YFragment;

import java.util.List;

/**
 * Created by user on 2016/3/1.
 */
public class DemoCodeListFragment extends YFragment implements IDemoCodeView {

    private int mType;
    private DemoCodePresentImpl demoCodePresent;
    private DemoCodeListAdapter mAdapter;
    public DemoCodeListFragment() {
    }

    public static DemoCodeListFragment newInstance(int type) {
        Bundle args = new Bundle();
        DemoCodeListFragment fragment = new DemoCodeListFragment();
        args.putInt("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mType = getArguments().getInt("type");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_demo_code, null);
        EasyRecyclerView easyRecyclerView = (EasyRecyclerView) view.findViewById(R.id.democode_easyrecyclerview);
        easyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        mAdapter = new DemoCodeListAdapter(getActivity().getApplicationContext());
        easyRecyclerView.setAdapterWithProgress(mAdapter);
        demoCodePresent= new DemoCodePresentImpl(this);
        //根据类型 添加数据
        demoCodePresent.addDataByType(mType);
        mAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ActivityCompat.startActivity(getActivity(), new Intent(getActivity().getApplicationContext(),NewActivity.class),null);
                DemoCodeListitemBean item = mAdapter.getItem(position);
                Toast.makeText(getActivity().getApplicationContext(), mType + " " + item.getCategory() + " " + item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void addUIData(List<DemoCodeListitemBean> data) {
        mAdapter.addAll(data);
    }

    @Override
    public void addFuncitonData(List<DemoCodeListitemBean> data) {
        mAdapter.addAll(data);
    }

    @Override
    public void addWebSiteData(List<DemoCodeListitemBean> data) {
        mAdapter.addAll(data);
    }
}
