package com.cncverse;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.plugins.Plugin;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LivXowPlugin.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/LivXowProvider/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/cncverse/LivXowPlugin;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "sharedPref", "Landroid/content/SharedPreferences;", "load", "", "context", "Landroid/content/Context;", "LivXowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLivXowPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LivXowPlugin.kt\ncom/cncverse/LivXowPlugin\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,60:1\n777#2:61\n873#2,2:62\n1915#2,2:64\n1642#2,10:66\n1915#2:76\n1916#2:78\n1652#2:79\n1#3:77\n*S KotlinDebug\n*F\n+ 1 LivXowPlugin.kt\ncom/cncverse/LivXowPlugin\n*L\n30#1:61\n30#1:62,2\n35#1:64,2\n53#1:66,10\n53#1:76\n53#1:78\n53#1:79\n53#1:77\n*E\n"})
public final class LivXowPlugin extends Plugin {

    @Nullable
    private final SharedPreferences sharedPref;

    public LivXowPlugin() {
        Activity activity = CommonActivity.INSTANCE.getActivity();
        this.sharedPref = activity != null ? activity.getSharedPreferences("LivXow", 0) : null;
    }

    public void load(@NotNull Context context) {
        LivXowProvider.INSTANCE.setContext(context);
        LivXowLiveEventsProvider.INSTANCE.setContext(context);
        String displayTitle = null;
        registerMainAPI(new LivXowLiveEventsProvider(null, null, 3, null));
        registerMainAPI(new LivXowLiveEventsProvider("🎬LivXow Highlights", "highlights.txt"));
        final List categoryProviders = (List) BuildersKt.runBlocking$default((CoroutineContext) null, new LivXowPlugin$load$categoryProviders$1(null), 1, (Object) null);
        List $this$filter$iv = categoryProviders;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            Object obj = ((Map) element$iv$iv).get("title");
            String title = obj instanceof String ? (String) obj : null;
            boolean z = false;
            if (title != null) {
                SharedPreferences sharedPreferences = this.sharedPref;
                if (sharedPreferences != null ? sharedPreferences.getBoolean(title, false) : false) {
                    z = true;
                }
            }
            if (z) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable selectedProviders = (List) destination$iv$iv;
        Iterable $this$forEach$iv = selectedProviders;
        for (Object element$iv : $this$forEach$iv) {
            Map provider = (Map) element$iv;
            Object obj2 = provider.get("title");
            String title2 = obj2 instanceof String ? (String) obj2 : displayTitle;
            if (title2 != null) {
                Object obj3 = provider.get("type");
                String type = obj3 instanceof String ? (String) obj3 : displayTitle;
                if (type == null) {
                    type = "m3u";
                }
                Object obj4 = provider.get("catLink");
                String catLink = obj4 instanceof String ? (String) obj4 : displayTitle;
                if (catLink != null) {
                    String displayTitle2 = "📺 " + title2;
                    if (Intrinsics.areEqual(type, "custom")) {
                        registerMainAPI(new LivXowLiveEventsProvider(displayTitle2, catLink));
                    } else {
                        registerMainAPI(new LivXowProvider(displayTitle2, catLink));
                    }
                }
            }
            displayTitle = null;
        }
        final AppCompatActivity act = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (act != null) {
            setOpenSettings(new Function1() { // from class: com.cncverse.LivXowPlugin$$ExternalSyntheticLambda0
                public final Object invoke(Object obj5) {
                    return LivXowPlugin.load$lambda$2(categoryProviders, this, act, (Context) obj5);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$2(List $categoryProviders, LivXowPlugin this$0, AppCompatActivity $act, Context it) {
        List $this$mapNotNull$iv = $categoryProviders;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Map it2 = (Map) element$iv$iv$iv;
            Object obj = it2.get("title");
            String str = obj instanceof String ? (String) obj : null;
            if (str != null) {
                destination$iv$iv.add(str);
            }
        }
        List categoryNames = (List) destination$iv$iv;
        LivXowSettings frag = new LivXowSettings(this$0, this$0.sharedPref, categoryNames);
        frag.show($act.getSupportFragmentManager(), "LivXowSettings");
        return Unit.INSTANCE;
    }
}
