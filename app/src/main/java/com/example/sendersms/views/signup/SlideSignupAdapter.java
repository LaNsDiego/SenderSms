package com.example.sendersms.views.signup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class SlideSignupAdapter extends FragmentStateAdapter {

    public static int NUM_PAGES = 4;

    public SlideSignupAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new S1PhoneNumberFragment();
            case 1:
                return new S2IdentificationFragment();
            case 2:
                return new S3UserDataFragment();
            case 3:
                return new S4ConfirmFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}
