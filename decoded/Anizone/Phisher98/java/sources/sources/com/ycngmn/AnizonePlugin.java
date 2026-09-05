package com.ycngmn;

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

/* JADX INFO: compiled from: AnizonePlugin.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Anizone/Phisher98/java/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016Ê\u0001\u0002\b\t¨\u0006\b"}, d2 = {"Lcom/ycngmn/AnizonePlugin;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "load", "", "context", "Landroid/content/Context;", "Anizone", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class AnizonePlugin extends Plugin {
    public void load(@NotNull Context context) {
        final SharedPreferences sharedPref = context.getSharedPreferences("AnizonePref", 0);
        registerMainAPI(new AnizoneProvider(sharedPref));
        setOpenSettings(new Function1() { // from class: com.ycngmn.AnizonePlugin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return AnizonePlugin.load$lambda$0(this.f$0, sharedPref, (Context) obj);
            }
        });
    }

    static final Unit load$lambda$0(AnizonePlugin this$0, SharedPreferences $sharedPref, Context ctx) {
        Intrinsics.checkNotNull(ctx, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AppCompatActivity act = (AppCompatActivity) ctx;
        SettingsFragment frag = new SettingsFragment(this$0, $sharedPref);
        frag.show(act.getSupportFragmentManager(), "AnizoneSettings");
        return Unit.INSTANCE;
    }
}
