package com.vitale.evo.evoapp.View.NavigationPager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class FragmentNavigationPager extends ViewPager implements FragmentNavigationListener{
    private boolean isPagingEnabled = false;

    public FragmentNavigationPager(Context context) {
        super(context);
    }

    public FragmentNavigationPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onFragmentChangeRequested(String fragment_class_name, Bundle data) {
        if(getNavigationAdapter() != null){
            int page = 0;
            try {
                page = getNavigationAdapter().getItemPositionByName(fragment_class_name);
                if(data != null && data instanceof Bundle)
                    ((NavigationPagerFragment)getNavigationAdapter().getItem(page)).onDataReceived(data);
                setCurrentItem(page, false);
            }catch (FragmentNavigationPagerException e) {
                e.printStackTrace();
            }
        }
    }

    public NavigationPagerAdapter getNavigationAdapter(){
        return (NavigationPagerAdapter) this.getAdapter();
    }

    public void setItems(FragmentManager fm) {
        setAdapter(new NavigationPagerAdapter(fm, this));
    }

    public String getCurrentItemName(){
        return this.getNavigationAdapter().getItemName(this.getCurrentItem());
    }

    public void goBack(){
        if(getNavigationAdapter() != null){
            int page = getCurrentItem();
            if(page != -1){
                NavigationPagerFragment fragment = (NavigationPagerFragment) getNavigationAdapter().getItem(page);
                fragment.onBackPressed();
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onInterceptTouchEvent(event);
    }

    public void setPagingEnabled(boolean b) {
        this.isPagingEnabled = b;
    }
}
