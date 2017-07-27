package com.red.forteza.ui.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.red.forteza.R;
import com.red.forteza.data.model.Photo;
import com.red.forteza.ui.activity.ImageActivity;
import com.red.forteza.util.Res;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GuardPhotoPagerAdapter extends PagerAdapter {

    ArrayList<Photo> mPhotos;

    public GuardPhotoPagerAdapter(ArrayList<Photo> photos) {
        mPhotos = photos;
    }

    @Override
    public Object instantiateItem(ViewGroup parent, int position) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_guard_photo, parent, false);
        Photo photo = mPhotos.get(position);
        GuardPhotoViewHolder holder = new GuardPhotoViewHolder(v);
        holder.bind(photo);

        v.setTag(position);
        parent.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup parent, int position, Object view) {
        parent.removeView((View) view);
    }

    @Override
    public int getCount() {
        return mPhotos.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.getTag().equals(((View) object).getTag());
    }

    public class GuardPhotoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.photo_guard)
        ImageView guardPhoto;
        @BindView(R.id.photo_detail)
        TextView photoDetail;

        Photo mPhoto;

        public GuardPhotoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Photo photo) {
            mPhoto = photo;

            Glide.with(itemView.getContext()).load(Res.drawableId(itemView.getContext(), mPhoto.photo)).into(guardPhoto);
            photoDetail.setText(mPhoto.photoDetail);
        }

        @OnClick(R.id.item_photo)
        protected void onClick() {
            Bundle extras = new Bundle();
            extras.putString("REF", mPhoto.photo);
            Intent intent = new Intent(itemView.getContext(), ImageActivity.class);
            intent.putExtras(extras);
            itemView.getContext().startActivity(intent, extras);
        }
    }
}
