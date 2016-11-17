package com.sds.study.recordapp.record;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sds.study.recordapp.R;

import java.util.List;

/*
 파일을 재생하는 화면을 관리할 프레그먼트
*/
public class DetailFragment extends Fragment implements View.OnClickListener{
    ListFragment listFragment;
    String filename;
    TextView txt_filename;
    Button bt_play;
    ImageView disc;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_detail,null);

        txt_filename=(TextView)view.findViewById(R.id.txt_filename);
        bt_play=(Button)view.findViewById(R.id.bt_play);
        disc=(ImageView)view.findViewById(R.id.disc);

        /* 페이지를 구성하는 나 아닌 다른 페이지 프레그먼트를
        * 접근해보자 !!*/
        FragmentManager manager =this.getFragmentManager();
        List<Fragment> list=manager.getFragments();
        listFragment =(ListFragment) list.get(0);

        bt_play.setOnClickListener(this);

        return view;
    }

    public void play(){
        Animation animation=AnimationUtils.loadAnimation(getContext(), R.anim.disc);
        /*안드로이에서 에니메이션의 대상이 되는 주체는
        *  모든 뷰이다!!
        * */
        disc.startAnimation(animation);
    }

    public void onClick(View view) {
        if(view.getId() == R.id.bt_play){
            play();
        }
    }
}







