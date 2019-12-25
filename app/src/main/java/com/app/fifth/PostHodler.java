package com.app.fifth;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PostHodler extends RecyclerView.ViewHolder {

    ImageView ProfImg;
    TextView Name;
    TextView TimeD;
    TextView PostDes;

    public PostHodler(@NonNull View itemView) {
        super(itemView);

        ProfImg = itemView.findViewById(R.id.ProfImg);
        Name = itemView.findViewById(R.id.Name);
        TimeD = itemView.findViewById(R.id.TimeD);
        PostDes = itemView.findViewById(R.id.PostDes);
    }

}
