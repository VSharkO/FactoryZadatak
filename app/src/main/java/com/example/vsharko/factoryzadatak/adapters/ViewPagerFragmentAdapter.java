package com.example.vsharko.factoryzadatak.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.vsharko.factoryzadatak.model.Article;
import com.example.vsharko.factoryzadatak.pager.view.ArticleFragment;
import java.util.ArrayList;
import java.util.List;


public class ViewPagerFragmentAdapter extends FragmentPagerAdapter {

    private final List<Article> articleList = new ArrayList<>();

    public ViewPagerFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ArticleFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return articleList.size();
    }

    public void setAdapterData(List<Article> dataSource) {
        this.articleList.clear();
        this.articleList.addAll(dataSource);
        notifyDataSetChanged();
    }
}
