package com.harreke.easyappframework.samples.holders;

import android.view.View;
import android.widget.TextView;

import com.harreke.easyappframework.holders.abslistview.ExListHolder;
import com.harreke.easyappframework.samples.R;
import com.harreke.easyappframework.samples.entities.beans.ExListGroupItem;

/**
 * 由 Harreke（harreke@live.cn） 创建于 2014/08/06
 */
public class ExListGroupHolder extends ExListHolder.Group<ExListGroupItem> {
    private TextView mGroupTag;

    public ExListGroupHolder(View convertView) {
        super(convertView);

        mGroupTag = (TextView) convertView.findViewById(R.id.group_tag);
    }

    @Override
    public void setItem(ExListGroupItem groupItem) {
        mGroupTag.setText(groupItem.getTag());
        if (groupItem.isChecked()) {
            mGroupTag.setBackgroundResource(R.drawable.shape_corner_theme);
        } else {
            mGroupTag.setBackgroundResource(R.drawable.shape_corner_gray);
        }
    }
}