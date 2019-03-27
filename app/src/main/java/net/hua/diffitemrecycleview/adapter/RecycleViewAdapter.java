package net.hua.diffitemrecycleview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import net.hua.diffitemrecycleview.R;
import net.hua.diffitemrecycleview.bean.ChatWithFriendBean;

import java.util.IllegalFormatCodePointException;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<ChatWithFriendBean> mList;
    private Context mContext;
    private LayoutInflater mInflater;
    private AdapterView.OnItemClickListener mListener;
    private RequestOptions options;

    public interface OnItemClickListener{
        void onItemClick(ChatWithFriendBean bean);
    }

    public RecycleViewAdapter(Context context,List<ChatWithFriendBean> list) {
        mContext = context;
        mList = list;
        mInflater = LayoutInflater.from(mContext);
        options = new RequestOptions().centerCrop();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == ITEM_TYPE.TYPE_FRIEND_MSG.ordinal()) {
            return new FromMsgHolder(mInflater.inflate(R.layout.item_chat_friend,viewGroup,false));
        }else {
            return new ToMsgHolder(mInflater.inflate(R.layout.item_chat_me,viewGroup,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ChatWithFriendBean chatWithFriendBean = mList.get(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType == ITEM_TYPE.TYPE_FRIEND_MSG.ordinal()) {
            Glide.with(mContext).load(mContext.getResources().getDrawable(R.drawable.small_cat)).into(((FromMsgHolder)viewHolder).headImage);
            if (chatWithFriendBean.getMapUrl() != null && !"".equals(chatWithFriendBean.getMapUrl())) {
                ((FromMsgHolder)viewHolder).llAddressInfo.setVisibility(View.VISIBLE);
                ((FromMsgHolder)viewHolder).content.setVisibility(View.GONE);
                ((FromMsgHolder)viewHolder).addressContent.setText(chatWithFriendBean.getPoiname() + "\n" + chatWithFriendBean.getLabel());
                Glide.with(mContext).load(chatWithFriendBean.getMapUrl()).apply(options).into(((FromMsgHolder)viewHolder).address);
            }else {
                ((FromMsgHolder)viewHolder).llAddressInfo.setVisibility(View.GONE);
                ((FromMsgHolder)viewHolder).content.setVisibility(View.VISIBLE);
                ((FromMsgHolder)viewHolder).content.setText(chatWithFriendBean.getContent());
            }
        }else {
            Glide.with(mContext).load(mContext.getResources().getDrawable(R.drawable.small_dog)).into(((ToMsgHolder)viewHolder).headImage);
            if (chatWithFriendBean.getMapUrl() != null && !"".equals(chatWithFriendBean.getMapUrl())) {
                ((ToMsgHolder)viewHolder).llAddressInfo.setVisibility(View.VISIBLE);
                ((ToMsgHolder)viewHolder).content.setVisibility(View.GONE);
                Glide.with(mContext).load(chatWithFriendBean.getMapUrl()).apply(options).into(((ToMsgHolder)viewHolder).address);
                ((ToMsgHolder)viewHolder).addressContent.setText(chatWithFriendBean.getPoiname() + "\n" + chatWithFriendBean.getLabel());
            }else {
                ((ToMsgHolder)viewHolder).llAddressInfo.setVisibility(View.GONE);
                ((ToMsgHolder)viewHolder).content.setVisibility(View.VISIBLE);
                ((ToMsgHolder)viewHolder).content.setText(chatWithFriendBean.getContent());
            }
        }
    }

    public enum ITEM_TYPE {
        TYPE_FRIEND_MSG,
        TYPE_ME_MSG
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.get(position).isFriendMsg()) {
            return ITEM_TYPE.TYPE_FRIEND_MSG.ordinal();
        }else {
            return ITEM_TYPE.TYPE_ME_MSG.ordinal();
        }
    }

    public void update(List<ChatWithFriendBean> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        if (mList == null || mList.size() == 0) return 0;
        return mList.size();
    }

    public static class FromMsgHolder extends RecyclerView.ViewHolder {
        private ImageView headImage;
        private TextView content;
        private ImageView address;
        private LinearLayout llAddressInfo;
        private TextView addressContent;

        public FromMsgHolder(View itemView) {
            super(itemView);
            headImage = itemView.findViewById(R.id.friend_avatar);
            content = itemView.findViewById(R.id.friend_content);
            address = itemView.findViewById(R.id.friend_address);
            llAddressInfo = itemView.findViewById(R.id.ll_address_info);
            addressContent = itemView.findViewById(R.id.address_content);
        }
    }

    public static class ToMsgHolder extends RecyclerView.ViewHolder {
        private ImageView headImage;
        private TextView content;
        private ImageView address;
        private LinearLayout llAddressInfo;
        private TextView addressContent;

        public ToMsgHolder(View itemView) {
            super(itemView);
            headImage = itemView.findViewById(R.id.me_avatar);
            content = itemView.findViewById(R.id.me_content);
            address = itemView.findViewById(R.id.me_address);
            llAddressInfo = itemView.findViewById(R.id.ll_address_info);
            addressContent = itemView.findViewById(R.id.address_content);
        }
    }
}
