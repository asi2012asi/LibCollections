package org.yaoming.mydemos.libcollections.democode.view;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import org.sufficientlysecure.htmltextview.HtmlTextView;
import org.yaoming.mydemos.libcollections.R;
import org.yaoming.mydemos.libcollections.global.AbUtil.AbAppUtil;
import org.yaoming.mydemos.libcollections.global.YBaseActivity;

import me.imid.swipebacklayout.lib.SwipeBackLayout;

/**
 * Created by user on 2016/3/3.
 */
public class NewActivity extends YBaseActivity {

    private String imgUrl = "http://c.hiphotos.baidu.com/zhidao/wh%3D600%2C800/sign=13d273e99922720e7b9beafc4bfb267e/b219ebc4b74543a998032c471f178a82b9011424.jpg";
    private ProgressBar mProgressBar;
    private SwipeBackLayout mSwipeBackLayout;
    private HtmlTextView mTVNewsContent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mProgressBar = (ProgressBar) findViewById(R.id.progress);
        mTVNewsContent = (HtmlTextView) findViewById(R.id.htNewsContent);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeSize(AbAppUtil.getDisplayMetrics(this).widthPixels);
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("ces 测试哒哒哒");
//      SimpleDraweeView imgeView = (SimpleDraweeView) findViewById(R.id.ivImage);
//        imgeView.setImageURI(Uri.parse(imgUrl));
        mProgressBar.setVisibility(View.GONE);
//        ImageLoaderUtils.display(getApplicationContext(), (ImageView) findViewById(R.id.ivImage), mNews.getImgsrc());
//
//        mNewsDetailPresenter = new NewsDetailPresenterImpl(getApplication(), this);
//        mNewsDetailPresenter.loadNewsDetail(mNews.getDocid());

    }
}
