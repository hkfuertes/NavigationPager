package com.vitale.evo.evoapp.View.NavigationPager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class NavigationPagerFragment extends Fragment {

    private FragmentNavigationListener fil = null;


    public void setFragmentNavigationListener(FragmentNavigationListener fil){
        this.fil = fil;
    }
    public void removeFragmentNavigationListener(){
        this.fil = null;
    }
    public boolean isRegistered(){
        return fil != null;
    }


    public void requestChange(String fragment_name, Bundle data){
        if(isRegistered())
            fil.onFragmentChangeRequested(fragment_name, data);
    }

    public void requestChange(String fragment_name){
        if(isRegistered())
            fil.onFragmentChangeRequested(fragment_name,null);
    }



    /*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof FragmentNavigationListener) {
            fil = (FragmentNavigationListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentNavigationListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        fil = null;
    }
*/
    //Implementar/Sobreescribir que hacer en caso de ir para atras.
    public void onBackPressed(){};

    //Implementar/Sobreescribir que hacer al recibir datos.
    public void onDataReceived(Bundle data){}

    //Para actualizar las vistas
    public void updateViews(){}

}