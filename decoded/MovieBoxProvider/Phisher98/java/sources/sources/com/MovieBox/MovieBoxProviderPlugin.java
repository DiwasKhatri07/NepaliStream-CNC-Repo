package com.MovieBox;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.plugins.Plugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MovieBoxProviderPlugin.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/MovieBoxProvider/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016Ê\u0001\u0002\b\t¨\u0006\b"}, d2 = {"Lcom/MovieBox/MovieBoxProviderPlugin;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "load", "", "context", "Landroid/content/Context;", "MovieBoxProvider", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class MovieBoxProviderPlugin extends Plugin {
    public void load(@NotNull Context context) {
        final SharedPreferences sharedPref = context.getSharedPreferences("MovieBox", 0);
        registerMainAPI(new MovieBoxProvider(sharedPref));
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        final AppCompatActivity activity = (AppCompatActivity) context;
        setOpenSettings(new Function1() { // from class: com.MovieBox.MovieBoxProviderPlugin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return MovieBoxProviderPlugin.load$lambda$0(this.f$0, sharedPref, activity, (Context) obj);
            }
        });
    }

    static final Unit load$lambda$0(MovieBoxProviderPlugin this$0, SharedPreferences $sharedPref, AppCompatActivity $activity, Context it) {
        SettingsFragment frag = new SettingsFragment(this$0, $sharedPref);
        frag.show($activity.getSupportFragmentManager(), "MovieBoxSettings");
        return Unit.INSTANCE;
    }
}
