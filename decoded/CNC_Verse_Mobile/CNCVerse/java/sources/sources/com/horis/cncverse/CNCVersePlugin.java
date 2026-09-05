package com.horis.cncverse;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.plugins.Plugin;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CNCVersePlugin.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/CNC_Verse_Mobile/CNCVerse/java/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/horis/cncverse/CNCVersePlugin;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "load", "", "context", "Landroid/content/Context;", "CNC Verse Mobile_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCNCVersePlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CNCVersePlugin.kt\ncom/horis/cncverse/CNCVersePlugin\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,48:1\n777#2:49\n873#2,2:50\n1915#2,2:52\n*S KotlinDebug\n*F\n+ 1 CNCVersePlugin.kt\ncom/horis/cncverse/CNCVersePlugin\n*L\n36#1:49\n36#1:50,2\n36#1:52,2\n*E\n"})
public class CNCVersePlugin extends Plugin {
    public void load(@NotNull Context context) {
        NetflixMirrorStorage.INSTANCE.init(context.getApplicationContext());
        DisneyStudioProvider.INSTANCE.setContext(context);
        NetflixMirrorProvider.INSTANCE.setContext(context);
        PrimeVideoMirrorProvider.INSTANCE.setContext(context);
        HotStarMirrorProvider.INSTANCE.setContext(context);
        registerMainAPI(new NetflixMirrorProvider());
        registerMainAPI(new PrimeVideoMirrorProvider());
        registerMainAPI(new HotStarMirrorProvider());
        final SharedPreferences sharedPref = context.getSharedPreferences("CNCVerseStudiosM", 0);
        final List studioOptions = CollectionsKt.listOf(new StudioOption[]{new StudioOption("studio_disney", "DisneyM", "disney"), new StudioOption("studio_marvel", "MarvelM", "marvel"), new StudioOption("studio_starwars", "Star WarsM", "starwars"), new StudioOption("studio_pixar", "PixarM", "pixar")});
        List $this$filter$iv = studioOptions;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            StudioOption it = (StudioOption) element$iv$iv;
            if (load$isStudioEnabled(sharedPref, it)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$forEach$iv = (List) destination$iv$iv;
        for (Object element$iv : $this$forEach$iv) {
            StudioOption option = (StudioOption) element$iv;
            registerMainAPI(new DisneyStudioProvider(option.getCookieValue(), option.getLabel()));
        }
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        final AppCompatActivity activity = (AppCompatActivity) context;
        setOpenSettings(new Function1() { // from class: com.horis.cncverse.CNCVersePlugin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return CNCVersePlugin.load$lambda$2(this.f$0, sharedPref, studioOptions, activity, (Context) obj);
            }
        });
    }

    private static final boolean load$isStudioEnabled(SharedPreferences sharedPref, StudioOption option) {
        if (sharedPref.contains(option.getKey())) {
            return sharedPref.getBoolean(option.getKey(), false);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$2(CNCVersePlugin this$0, SharedPreferences $sharedPref, List $studioOptions, AppCompatActivity $activity, Context it) {
        CNCVerseSettings frag = new CNCVerseSettings(this$0, $sharedPref, $studioOptions);
        frag.show($activity.getSupportFragmentManager(), "CNCVerseSettings");
        return Unit.INSTANCE;
    }
}
