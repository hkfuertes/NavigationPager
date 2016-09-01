# NavigationPager
FragmentStatePager modified for Navigation Purposes.

##Usage
1. Let your fragment extend NavigationPagerFragment.
2. Register your Fragment in the NavigationPagerAdapter.
3. Access the method:
code NavigationPagerFragment.requestChange(String fragment.class.getName(),[Bundle data]);
4. Access the method:
code NavigationPagerFragment.onBackPressed();
