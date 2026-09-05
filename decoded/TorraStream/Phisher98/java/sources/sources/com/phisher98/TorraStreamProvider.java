package com.phisher98;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.plugins.Plugin;
import com.phisher98.settings.SettingsFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TorraStreamProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/TorraStream/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016Ê\u0001\u0002\b\t¨\u0006\b"}, d2 = {"Lcom/phisher98/TorraStreamProvider;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "load", "", "context", "Landroid/content/Context;", "TorraStream", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class TorraStreamProvider extends Plugin {
    public void load(@NotNull Context context) {
        List savedMainApis;
        final SharedPreferences sharedPref = context.getSharedPreferences("TorraStream", 0);
        String savedMainApisString = sharedPref.getString("main_apis", "TMDB,Anime");
        if (savedMainApisString == null || (savedMainApis = StringsKt.split$default(savedMainApisString, new String[]{","}, false, 0, 6, (Object) null)) == null) {
            savedMainApis = CollectionsKt.listOf(new String[]{"TMDB", "Anime"});
        }
        if (savedMainApis.contains("TMDB")) {
            registerMainAPI((MainAPI) new TorraStream(sharedPref));
        }
        if (savedMainApis.contains("Anime")) {
            registerMainAPI(new TorraStreamAnime(sharedPref));
        }
        if (savedMainApis.contains("Trakt")) {
            registerMainAPI((MainAPI) new TorraStreamTrakt(sharedPref));
        }
        setOpenSettings(new Function1() { // from class: com.phisher98.TorraStreamProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return TorraStreamProvider.load$lambda$0(this.f$0, sharedPref, (Context) obj);
            }
        });
    }

    static final Unit load$lambda$0(TorraStreamProvider this$0, SharedPreferences $sharedPref, Context ctx) {
        Intrinsics.checkNotNull(ctx, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AppCompatActivity activity = (AppCompatActivity) ctx;
        SettingsFragment frag = new SettingsFragment(this$0, $sharedPref);
        frag.show(activity.getSupportFragmentManager(), "Frag");
        return Unit.INSTANCE;
    }
}
