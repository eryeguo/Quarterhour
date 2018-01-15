package pingan.com.quarter_hour.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pingan.com.quarter_hour.R;
import pingan.com.quarter_hour.bean.VideoBean;

/**
 * Created by 迷人的脚毛！！ on 2018/1/13.
 */

public class G_Video_RecuclerView extends RecyclerView.Adapter<G_Video_RecuclerView.ViewHolder> {

    //定义一个接口点击事件
    public interface OnRecyclerViewItemClickLintemet{
        void onItemClick(int position);
    }
    //定义接口对象         单击事件
    private OnRecyclerViewItemClickLintemet listener;
    //定义接口方法         单击事件
    public void setOnRecyclerViewItemClickLintemet(OnRecyclerViewItemClickLintemet listener){

        this.listener=listener;
    };

    private Context context;

    private List<VideoBean.DataBean> list;

    public G_Video_RecuclerView(Context context, List<VideoBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = View.inflate(context, R.layout.video_recyclerview, null);

        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //条目单击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(position);
            }
        });
        holder.aa.setText(list.get(position).getCreateTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView aa;
        public ViewHolder(View itemView) {
            super(itemView);
            aa= itemView.findViewById(R.id.tv_aa);
        }
    }
}
