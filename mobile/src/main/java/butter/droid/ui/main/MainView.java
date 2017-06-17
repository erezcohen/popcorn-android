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

package butter.droid.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import butter.droid.base.providers.media.MediaProvider.NavInfo;
import butter.droid.base.torrent.StreamInfo;
import butter.droid.provider.base.Movie;
import java.util.List;

public interface MainView {
    void showTermsScreen();

    void showYoutubeVideo(Movie movie, String url);

    void showPlayerTestDialog(String[] fileTypes);

    void showPlayerTestUrlDialog();

    void showVideoPlayer(@NonNull StreamInfo info);

    void showBeamPlayer(@NonNull StreamInfo info);

    void requestStoragePermissions();

    void closeScreen();

    void checkIntentAction();

    void initProviders(int providerId);

    void closeDrawer();

    void openPreferenceScreen();

    void displayProvider(@StringRes int title, List<NavInfo> navigation);

    void onGenreChanged(String genre);

    void showFirsContentScreen();

    void writeStateData(@NonNull Bundle outState, int selectedProviderId);

    void setScreenTitle(@StringRes int title);

    void openSearchScreen(int providerId);
}
