package ac.mz.hendrickpaculet2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterPager extends FragmentPagerAdapter {
    private final List<Fragment> fragmentList = new ArrayList();
    private final List<String> fragmentTitleList = new ArrayList<>();



    public MyAdapterPager(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        // Adicione os fragments e os títulos correspondentes à lista

        fragmentList.add(new New1());
        fragmentTitleList.add("Registo ");

        fragmentList.add(new New2());
        fragmentTitleList.add("Listar");
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }
}

