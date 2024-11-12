package com.example.potholedectection.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import com.example.potholedectection.R;
import com.example.potholedectection.Activity.Setting_Activity;

import java.io.IOException;

public class User_Fragment extends Fragment {
    private View view;
    private ImageView avatar;
    private TextView change_avatar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.layout_fragment_user, container, false);

        avatar = view.findViewById(R.id.avatar);
        change_avatar = view.findViewById(R.id.change_avatar);

        /*change_avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //intent ẩn gọi đến ACTION_PICK
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                intent.setType("image/*"); // Chọn tất cả loại ảnh
                //yêu cầu quyền truy cập và thư viện ảnh
                if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){

                    ActivityCompat.requestPermissions(getActivity(),new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                    return;
                }
                //khởi động intent và chờ kq trả về
                startActivityForResult(intent,99);
            }
        });*/




        return view;

    }
}
