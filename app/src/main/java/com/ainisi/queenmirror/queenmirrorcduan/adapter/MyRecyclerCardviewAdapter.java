package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.Bean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.fragment.HomeFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.EstheticsActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.HomeFightaloneActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.MessageActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SearchActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollListview;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;

import static com.lzy.okgo.OkGo.getContext;

/**
 * 用于首页多item布局
 */
public class MyRecyclerCardviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements HttpCallBack{

    private final Context context;
    List<Bean.BodyBean.ApiRefundListBean> apiRefundList = new ArrayList<>();

    public static enum ITEM_TYPE {
        ITEM_TYPE_Theme,
        ITEM_TYPE_Video,
        ITEM_TYPE_Image
    }
    //数据集
    public List<Integer> mdatas;
    private TextView themeTitle;

    public MyRecyclerCardviewAdapter(Context context){
        super();
        this.context=context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == ITEM_TYPE.ITEM_TYPE_Theme.ordinal()){

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home_shop,parent,false);

            return new ThemeVideoHolder(view);

        }else if(viewType == ITEM_TYPE.ITEM_TYPE_Video.ordinal()){

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_appbarlayout,parent,false);
            return new VideoViewHolder(view);

        }else if(viewType == ITEM_TYPE.ITEM_TYPE_Image.ordinal()){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shortrecycler,parent,false);
            return new VideoViewHolder(view);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof ThemeVideoHolder){

            ((ThemeVideoHolder)holder).li_home_meijia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CeshiData();
                }
            });



        }else if (holder instanceof VideoViewHolder){
           /* ((VideoViewHolder)holder).videologo.setImageResource(R.drawable.lianzai_02);
            ((VideoViewHolder)holder).videocomment.setText("209条");*/

        }

    }

    /**
     * 测试列表数据
     */
    private void CeshiData() {
        //传参数
        HashMap<String,String> params = new HashMap<>();
        params.put("userId", "111");

        //doPost();  第一个参数：调用的方法       第二个：传递的参数   第三个：是否成功返回的样式    第四个：对话框     第五个：传入当前的activity
        HttpUtils.doPost(ACTION.LIST,params, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }


    public int getItemViewType(int position){
        if(position == 0){
            return ITEM_TYPE.ITEM_TYPE_Theme.ordinal();
        }else if(position == 1){
            return ITEM_TYPE.ITEM_TYPE_Video.ordinal();
        }else{
            return ITEM_TYPE.ITEM_TYPE_Image.ordinal();
        }

    }
    @Override
    public int getItemCount() {
        return 12;
    }


    public class ThemeVideoHolder extends RecyclerView.ViewHolder {

//        private final LinearLayout home_esthetics;
//        private final LinearLayout linear_home_freetrial;
        LinearLayout li_home_meijia;

        public ThemeVideoHolder(View itemView) {
            super(itemView);
            li_home_meijia = (LinearLayout) itemView.findViewById(R.id.li_home_meijia);
         //   home_esthetics = (LinearLayout) itemView.findViewById(R.id.home_esthetics);
//            linear_home_freetrial = (LinearLayout) itemView.findViewById(R.id.linear_home_freetrial);
//            home_esthetics.setOnClickListener(this);
//            linear_home_freetrial.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View view) {
//            switch (view.getId()){
//                //美学汇
//                case R.id.home_esthetics:
//                    context.startActivity(new Intent(context, EstheticsActivity.class));
//                    break;
//                //免费试用（拼单）
//                case R.id.linear_home_freetrial:
//                    context.startActivity(new Intent(context,HomeFightaloneActivity.class));
//                    break;
//            }
//        }
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {


        private final ImageView surFace;
        private boolean isClick;
        ListViewAdapter listadapter;
        NoScrollGridView gridView;
        NoScrollListview listView;
        private GridViewAdapter gridViewAdapter;

        public VideoViewHolder(View itemView) {
            super(itemView);
            surFace = itemView.findViewById(R.id.iv_surface);
          //  surFace.setOnClickLister(this);

        }

//        @Override
//        public void onClick(View view) {
//            switch (view.getId()){
//                case R.id.iv_surface:
//                    if (isClick) {
//                        isClick = false;
//                        listadapter = new ListViewAdapter(getContext());
//                        listView.setAdapter(listadapter);
//                        gridView.setVisibility(View.GONE);
//                        listView.setVisibility(View.VISIBLE);
//                        surFace.setImageResource(R.drawable.icon_home_list);
//                    } else {
//                        surFace.setImageResource(R.drawable.icon_home_recycler);
//                        gridView.setVisibility(View.VISIBLE);
//                        listView.setVisibility(View.GONE);
//                        gridViewAdapter = new GridViewAdapter(getContext());
//                        gridView.setAdapter(gridViewAdapter);
//                        isClick = true;
//                    }
//                    break;
//            }
//        }
    }

    @Override
    public void onSuccess(int action, String res) {
     switch (action){
           case ACTION.LIST:
               Bean bean = GsonUtil.toObj(res, Bean.class);
               T.show(bean.getMsg());
                Bean.BodyBean body = bean.getBody();
               apiRefundList = body.getApiRefundList();

               L.e("获取列表中为什么退款的原因   "+apiRefundList.get(0).getRefundReasonLabel());
               T.show(apiRefundList.get(0).getRefundReasonLabel());

               Bean.BodyBean.ApiRefundListBean.AnsCustRefundBean ansCustRefundBean = apiRefundList.get(0).getAnsCustRefund();

               L.e("???????????????????????   获取列表中对象中的ID信息  "+ansCustRefundBean.getId());
               break;
}
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }

}
