package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;

import java.util.List;

/**
 * 用于首页多item布局
 */
public class MyRecyclerCardviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public static enum ITEM_TYPE {
        ITEM_TYPE_Theme,
        ITEM_TYPE_Video,
        ITEM_TYPE_Image
    }
    //数据集
    public List<Integer> mdatas;
    private TextView themeTitle;

    public MyRecyclerCardviewAdapter(){
        super();
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

            //themeTitle.setText("
            // ");



        }else if (holder instanceof VideoViewHolder){
           /* ((VideoViewHolder)holder).videologo.setImageResource(R.drawable.lianzai_02);
            ((VideoViewHolder)holder).videocomment.setText("209条");*/

        }

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


    public class ThemeVideoHolder extends RecyclerView.ViewHolder{

        public ThemeVideoHolder(View itemView) {
            super(itemView);
        }
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {



        public VideoViewHolder(View itemView) {
            super(itemView);
           // videologo = (ImageView) itemView.findViewById(R.id.videologo);
        }
    }
}
