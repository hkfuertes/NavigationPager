package com.vitale.evo.evoapp.View.NavigationPager;

import android.os.Bundle;

public interface FragmentNavigationListener {
    void onFragmentChangeRequested(String fragment_class_name, Bundle data);
}
