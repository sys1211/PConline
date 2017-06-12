package com.example.tf.pconline.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.tf.pconline.Activity.SearchActivity;
import com.example.tf.pconline.Adapters.SearchLeftAdapter;
import com.example.tf.pconline.Datas.SearchLeftData;
import com.example.tf.pconline.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;

/**
 * Created by TF on 2017/6/6.
 */

public class FragmentProduct extends Fragment{
    private SlidingMenu slidingMenu;
    private View v;
    private Button bt;
    private ListView leftlv,rightlv;
    private ArrayList<SearchLeftData> list;

    private int[] imgs = {R.drawable.product_category_logo_mobile_default,R.drawable.product_category_logo_dc_default,
    R.drawable.product_category_logo_notebook_default,R.drawable.product_category_logo_diy_default,
    R.drawable.product_category_logo_ultrabook_default,R.drawable.product_category_logo_tabletpc_default,
    R.drawable.product_category_logo_electronics_default,R.drawable.product_category_logo_hardware_default,
    R.drawable.product_category_logo_digital_appliances_default,R.drawable.product_category_logo_dv_default,
    R.drawable.product_category_logo_network_equipment_default,R.drawable.product_category_logo_business_office_default};

    private String[] ups = {"手机","相机","笔记本","DIY硬件","超极本","平板电脑","数码产品","硬件外设","数字家电","摄像机","网络设备","企业办公"};
    private String[] belows = {"三星 HTC vivo","佳能 尼康 索尼","联想 惠普 华硕","CPU 显卡 固态硬盘","联想 华硕 索尼",
            "苹果 三星 ThinkPad","耳机 移动硬盘 游戏机","键盘 鼠标 音箱","电视 音响 家庭影院","索尼 松下 佳能",
            "无线路由 上网卡","投影仪 打印机 扫描仪"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_product,null);
        initview();
        initSliding();
        return v;
    }
private SlidingMenu.CanvasTransformer t;
    private void initSliding() {
        slidingMenu = (SlidingMenu) v.findViewById(R.id.slidingmenu);
        slidingMenu.setMode(SlidingMenu.RIGHT);
        slidingMenu.setMenu(R.layout.right_menu);
        slidingMenu.setBehindWidth(780);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
//        slidingMenu.setSlidingEnabled(false);
        slidingMenu.setTouchModeBehind(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setBehindScrollScale(1);
        slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
//        if(!slidingMenu.isMenuShowing()){
//            slidingMenu.setAboveOffsetRes(R.dimen.sliding_abovemove0);
//        }
//        if(slidingMenu.isMenuShowing()){

//        }
//        if(slidingMenu.isMenuShowing()){
//            slidingMenu.setSlidingEnabled(true);
//        }else {
//            slidingMenu.setSlidingEnabled(false);
//
//        }

        leftlv = (ListView) v.findViewById(R.id.left_listview);
        list = new ArrayList<>();
        for(int i=0;i<imgs.length;i++){
            SearchLeftData data = new SearchLeftData(imgs[i],ups[i],belows[i]);
            list.add(data);
        }

        final SearchLeftAdapter adapter = new SearchLeftAdapter(list,getContext());
        leftlv.setAdapter(adapter);


        leftlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                slidingMenu.showMenu();
                slidingMenu.setAboveOffsetRes(R.dimen.sliding_abovemove0);

//                    slidingMenu.setAboveOffsetRes(R.dimen.sliding_abovemove0);
                if(slidingMenu.isMenuShowing()){

                    slidingMenu.setAboveOffsetRes(R.dimen.sliding_abovemove);
                    slidingMenu.setTouchModeAbove(SlidingMenu.SLIDING_WINDOW);
                }

                adapter.setSelectItem(position);
                adapter.notifyDataSetInvalidated();





            }
        });
    }

    private void initview() {
        bt= (Button) v.findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), SearchActivity.class);
                startActivity(i);
            }
        });
    }

}
