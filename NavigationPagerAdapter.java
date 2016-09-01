package com.vitale.evo.evoapp.View.NavigationPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.vitale.evo.evoapp.Fragments.BookrateContactFragment;
import com.vitale.evo.evoapp.Fragments.BookRateFragment;
import com.vitale.evo.evoapp.Fragments.BookrateProfileFragment;
import com.vitale.evo.evoapp.Fragments.ChallengesFragment;
import com.vitale.evo.evoapp.Fragments.ChallengesListFragment;
import com.vitale.evo.evoapp.Fragments.EvoAcademyFragment;
import com.vitale.evo.evoapp.Fragments.FavoritesFragment;
import com.vitale.evo.evoapp.Fragments.InboxFragment;
import com.vitale.evo.evoapp.Fragments.LibraryFragment;
import com.vitale.evo.evoapp.Fragments.LocatorFragment;
import com.vitale.evo.evoapp.Fragments.MoreFragment;
import com.vitale.evo.evoapp.Fragments.MyEvoFragment;
import com.vitale.evo.evoapp.Fragments.NewsEventFragment;
import com.vitale.evo.evoapp.Fragments.NewsEventsFragment;
import com.vitale.evo.evoapp.Fragments.PtFragment;
import com.vitale.evo.evoapp.Fragments.RankingFragment;
import com.vitale.evo.evoapp.Fragments.SugestedFragment;
import com.vitale.evo.evoapp.Fragments.TrainingFragment;
import com.vitale.evo.evoapp.Fragments.TrainingSelectionExFragment;
import com.vitale.evo.evoapp.Fragments.TrainingSelectionFragment;
import com.vitale.evo.evoapp.Fragments.VirtualPTFragment;

public class NavigationPagerAdapter extends FragmentStatePagerAdapter {
    private FragmentNavigationListener fil;

    private Fragment[] fragments;
    private String[] index;

    public NavigationPagerAdapter(FragmentManager fm, FragmentNavigationListener fil) {
        super(fm);
        this.fil = fil;

        init();
    }

    private void init(){
        fragments = new Fragment[]{
                TrainingFragment.newInstance(fil),
                PtFragment.newInstance(fil),
                ChallengesFragment.newInstance(fil),
                MyEvoFragment.newInstance(fil),
                MoreFragment.newInstance(fil),
                TrainingSelectionFragment.newInstance(fil),
                TrainingSelectionExFragment.newInstance(fil),
                BookRateFragment.newInstance(fil),
                BookrateProfileFragment.newInstance(fil),
                BookrateContactFragment.newInstance(fil),
                SugestedFragment.newInstance(fil),
                FavoritesFragment.newInstance(fil),
                VirtualPTFragment.newInstance(fil),
                ChallengesListFragment.newInstance(fil),
                RankingFragment.newInstance(fil),
                LocatorFragment.newInstance(fil),
                InboxFragment.newInstance(fil),
                NewsEventsFragment.newInstance(fil),
                NewsEventFragment.newInstance(fil),
                EvoAcademyFragment.newInstance(fil),
                LibraryFragment.newInstance(fil)
        };

        index = new String[]{
                TrainingFragment.class.getName(),
                PtFragment.class.getName(),
                ChallengesFragment.class.getName(),
                MyEvoFragment.class.getName(),
                MoreFragment.class.getName(),
                TrainingSelectionFragment.class.getName(),
                TrainingSelectionExFragment.class.getName(),
                BookRateFragment.class.getName(),
                BookrateProfileFragment.class.getName(),
                BookrateContactFragment.class.getName(),
                SugestedFragment.class.getName(),
                FavoritesFragment.class.getName(),
                VirtualPTFragment.class.getName(),
                ChallengesListFragment.class.getName(),
                RankingFragment.class.getName(),
                LocatorFragment.class.getName(),
                InboxFragment.class.getName(),
                NewsEventsFragment.class.getName(),
                NewsEventFragment.class.getName(),
                EvoAcademyFragment.class.getName(),
                LibraryFragment.class.getName()
        };
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    public int getItemPositionByName(String name) throws FragmentNavigationPagerException {
        try {
            int i;
            for (i = 0; i < index.length; i++) {
                if (index[i].equals(name)) {
                    break;
                }
            }
            if (index[i].equals(name)) return i;
            else return -1;
        }catch (ArrayIndexOutOfBoundsException ex){
            throw new FragmentNavigationPagerException("Fragment not present in Pager: Please add this fragment to the PagerAdapter");
        }
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    public String getItemName(int currentItem) {
        return index[currentItem];
    }
}