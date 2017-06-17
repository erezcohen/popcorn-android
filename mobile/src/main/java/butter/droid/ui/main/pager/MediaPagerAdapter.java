/*
 * This file is part of Butter.
 *
 * Butter is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Butter is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Butter. If not, see <http://www.gnu.org/licenses/>.
 */

package butter.droid.ui.main.pager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import butter.droid.R;
import butter.droid.base.providers.media.MediaProvider;
import butter.droid.base.providers.media.MediaProvider.NavInfo;
import butter.droid.base.utils.LocaleUtils;
import butter.droid.ui.main.genre.GenreSelectionFragment;
import butter.droid.ui.media.list.MediaListFragment;

public class MediaPagerAdapter extends FragmentPagerAdapter {

    private final Context context;

    private List<MediaProvider.NavInfo> items;
    private String genre;

    public MediaPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        int cnt = 0;

        if (items != null) {
            cnt += items.size();
        }

        return cnt;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return context.getString(items.get(position).getLabel()).toUpperCase(LocaleUtils.getCurrent());
    }

    @Override
    public Fragment getItem(int position) {
        NavInfo navInfo = items.get(position);
        switch (navInfo.getId()) {
            case R.id.nav_item_filter:
                return MediaListFragment.newInstance(navInfo.getProviderId(), navInfo.getFilter());
            case R.id.nav_item_genre:
                return GenreSelectionFragment.newInstance(navInfo.getProviderId());
            default:
                throw new IllegalStateException("Unknown item type");
        }
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setData(List<NavInfo> items) {
        this.items = items;
        notifyDataSetChanged();
    }

}
