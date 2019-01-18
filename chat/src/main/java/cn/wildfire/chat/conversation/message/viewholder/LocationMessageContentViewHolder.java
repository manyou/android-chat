package cn.wildfire.chat.conversation.message.viewholder;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import cn.wildfirechat.chat.R;

import butterknife.Bind;
import cn.wildfire.chat.annotation.EnableContextMenu;
import cn.wildfire.chat.annotation.LayoutRes;
import cn.wildfire.chat.annotation.MessageContentType;
import cn.wildfire.chat.conversation.message.model.UiMessage;
import cn.wildfire.chat.third.utils.UIUtils;
import cn.wildfirechat.message.LocationMessageContent;

@MessageContentType(LocationMessageContent.class)
@LayoutRes(resId = R.layout.conversation_item_location_send)
@EnableContextMenu
public class LocationMessageContentViewHolder extends NormalMessageContentViewHolder {

    @Bind(R.id.locationTitleTextView)
    TextView locationTitleTextView;
    @Bind(R.id.locationImageView)
    ImageView locationImageView;

    public LocationMessageContentViewHolder(FragmentActivity context, RecyclerView.Adapter adapter, View itemView) {
        super(context, adapter, itemView);
    }

    @Override
    public void onBind(UiMessage message) {
        LocationMessageContent locationMessage = (LocationMessageContent) message.message.content;
        locationTitleTextView.setText(locationMessage.getTitle());

        if (locationMessage.getThumbnail() != null && locationMessage.getThumbnail().getWidth() > 0) {
            int width = locationMessage.getThumbnail().getWidth();
            int height = locationMessage.getThumbnail().getHeight();
            locationImageView.getLayoutParams().width = UIUtils.dip2Px(width > 200 ? 200 : width);
            locationImageView.getLayoutParams().height = UIUtils.dip2Px(height > 200 ? 200 : height);
            locationImageView.setImageBitmap(locationMessage.getThumbnail());
        } else {
            Glide.with(context).load(R.mipmap.default_location)
                    .apply(new RequestOptions().override(UIUtils.dip2Px(200), UIUtils.dip2Px(200)).centerCrop()).into(locationImageView);
        }
    }

    public void onClick(View view) {
        Toast.makeText(context, "TODO", Toast.LENGTH_SHORT).show();
    }
}
