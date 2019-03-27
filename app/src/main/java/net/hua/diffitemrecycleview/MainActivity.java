package net.hua.diffitemrecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import net.hua.diffitemrecycleview.adapter.RecycleViewAdapter;
import net.hua.diffitemrecycleview.bean.ChatWithFriendBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView chatListView;
    private RecycleViewAdapter chatAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chatListView = findViewById(R.id.listView);
        chatAdapter = new RecycleViewAdapter(this,getData());
        chatListView.setLayoutManager(new LinearLayoutManager(this));
        chatListView.setAdapter(chatAdapter);
    }

    //模拟数据
    private List<ChatWithFriendBean> getData() {
        List<ChatWithFriendBean> mList = new ArrayList<>();
        ChatWithFriendBean friChatBeanOne = new ChatWithFriendBean();
        friChatBeanOne.setContent("你好,小汪");
        friChatBeanOne.setFriendMsg(true);
        mList.add(friChatBeanOne);
        ChatWithFriendBean meChatBeanOne = new ChatWithFriendBean();
        meChatBeanOne.setContent("在的，小喵，干啥");
        meChatBeanOne.setFriendMsg(false);
        mList.add(meChatBeanOne);
        ChatWithFriendBean friChatBeanTwo = new ChatWithFriendBean();
        friChatBeanTwo.setContent("在哪里呢");
        friChatBeanTwo.setFriendMsg(true);
        mList.add(friChatBeanTwo);
        ChatWithFriendBean meChatBeanTwo = new ChatWithFriendBean();
        meChatBeanTwo.setContent("在逛街");
        meChatBeanTwo.setFriendMsg(false);
        mList.add(meChatBeanTwo);
        ChatWithFriendBean friChatBeanThree = new ChatWithFriendBean();
        friChatBeanThree.setContent("在哪里逛街呢，地址给我发一下，去找你");
        friChatBeanThree.setFriendMsg(true);
        mList.add(friChatBeanThree);
        ChatWithFriendBean meChatBeanThree = new ChatWithFriendBean();
        meChatBeanThree.setMapUrl("http://restapi.amap.com/v3/staticmap?markers=mid,0xFF0000,A:116.37359,39.92437&key=352c8f38a730448b4b21d35f355a3bdb");
        meChatBeanThree.setPoiname("广济寺");
        meChatBeanThree.setLabel("北京城内西城区阜成门内大街25号");
        meChatBeanThree.setFriendMsg(false);
        mList.add(meChatBeanThree);
        ChatWithFriendBean friChatBeanFour = new ChatWithFriendBean();
        friChatBeanFour.setMapUrl("http://restapi.amap.com/v3/staticmap?markers=mid,0xFF0000,A:116.38359,39.62437&key=352c8f38a730448b4b21d35f355a3bdb");
        friChatBeanFour.setPoiname("南薰殿");
        friChatBeanFour.setLabel("南薰殿位于外朝西路，武英殿西南");
        friChatBeanFour.setFriendMsg(true);
        mList.add(friChatBeanFour);
        return mList;
    }
}
