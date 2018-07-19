package com.example.vsharko.factoryzadatak.pager.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.vsharko.factoryzadatak.R;
import com.example.vsharko.factoryzadatak.pager.presenter.ArticleFragmentPresenter;
import com.example.vsharko.factoryzadatak.pager.presenter.ArticleFragmentPresenterImpl;
import com.example.vsharko.factoryzadatak.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleFragment extends Fragment implements ArticleFragmentView{
    @BindView(R.id.single_article_image)
    ImageView image;
    @BindView(R.id.single_article_title)
    TextView title;
    @BindView(R.id.single_article_description)
    TextView description;
    @BindView(R.id.single_article_link)
    TextView link;

    private ArticleFragmentPresenter presenter;

    public static Fragment newInstance(int index) {
        Bundle data = new Bundle();
        data.putInt(Constants.FRAGMENT_PUT_DATA_CONSTANT, index);
        ArticleFragment f = new ArticleFragment();
        f.setArguments(data);
        return f;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initPresenter();
    }

    private void initPresenter() {
        presenter = new ArticleFragmentPresenterImpl(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        int index = getArguments().getInt(Constants.FRAGMENT_PUT_DATA_CONSTANT);
        presenter.setData(index);
    }
    @Override
    public void setImage(String urlToImage) {
        Glide.with(getActivity().getApplicationContext()).load(urlToImage).into(image);
    }

    @Override
    public void setDescription(String description) {
        this.description.setText(description);
    }

    @Override
    public void setTitle(String title) {
        this.title.setText(title);
    }

    @Override
    public void setLink(String url) {
        this.link.setText(url);
    }
}
