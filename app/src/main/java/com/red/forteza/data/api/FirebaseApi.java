package com.red.forteza.data.api;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import static com.google.android.gms.internal.zzt.TAG;

public class FirebaseApi {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    String value = "";

    public void writeValue(String locationName, String value) {
        DatabaseReference ref = database.getReference(locationName);
        ref.setValue(value);
    }

    public String readImageValue(String locationName, final Context context, final ImageView img){
        DatabaseReference ref = database.getReference(locationName);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String data = dataSnapshot.getValue(String.class);
                value = data;
                Picasso.with(context).load(value).into(img);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        return value;
    }
}
