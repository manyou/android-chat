package cn.wildfire.chat.contact.viewholder;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.wildfirechat.chat.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.wildfire.chat.GlideApp;
import cn.wildfire.chat.contact.ContactAdapter;
import cn.wildfire.chat.contact.model.UIUserInfo;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    protected Fragment fragment;
    protected ContactAdapter adapter;
    @Bind(R.id.portraitImageView)
    ImageView portraitImageView;
    @Bind(R.id.nameTextView)
    TextView nameTextView;
    @Bind(R.id.categoryTextView)
    TextView categoryTextView;

    protected UIUserInfo userInfo;

    public ContactViewHolder(Fragment fragment, ContactAdapter adapter, View itemView) {
        super(itemView);
        this.fragment = fragment;
        this.adapter = adapter;
        ButterKnife.bind(this, itemView);
    }

    public void onBind(UIUserInfo userInfo) {
        this.userInfo = userInfo;
        if (userInfo.isShowCategory()) {
            categoryTextView.setVisibility(View.VISIBLE);
            categoryTextView.setText(userInfo.getCategory());
        } else {
            categoryTextView.setVisibility(View.GONE);
        }
        if (userInfo.getUserInfo().displayName != null) {
            nameTextView.setText(userInfo.getUserInfo().displayName);
        } else {
            nameTextView.setText("<" + userInfo.getUserInfo().uid + ">");
        }
        GlideApp.with(fragment).load(userInfo.getUserInfo().portrait).error(R.mipmap.default_header).into(portraitImageView);
    }

    public UIUserInfo getBindContact() {
        return userInfo;
    }
}
