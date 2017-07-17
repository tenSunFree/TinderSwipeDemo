package com.tensun.tinderswipedemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.swipeView)
    SwipePlaceHolderView swipeView;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mContext = getApplicationContext();

        swipeView.getBuilder()                                                                                           // 修改默認視圖配置
                .setDisplayViewCount(3)                                                                                  // 最多同時顯示幾張
                .setSwipeDecor(new SwipeDecor()

                        /** 放置在堆棧中的卡的感知 */
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)

                        /** 添加所述卡的消息 */
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));

        for (Profile profile : Utils.loadProfiles(this.getApplicationContext())) {                                         // 把每一個profile 放到每一個TinderCard, 再把每一個TinderCard 加到swipeView
            swipeView.addView(new TinderCard(mContext, profile, swipeView));
        }

        findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeView.doSwipe(false);
            }
        });

        findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeView.doSwipe(true);
            }
        });
    }
}
