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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PlayZTVPlugin.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/PlayZTVProvider/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/cncverse/PlayZTVPlugin;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "sharedPref", "Landroid/content/SharedPreferences;", "iptvProviders", "", "", "", "", "load", "", "context", "Landroid/content/Context;", "PlayZTVProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPlayZTVPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayZTVPlugin.kt\ncom/cncverse/PlayZTVPlugin\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,70:1\n1642#2,10:71\n1915#2:81\n1916#2:83\n1652#2:84\n777#2:85\n873#2,2:86\n1915#2,2:88\n1642#2,10:90\n1915#2:100\n1916#2:102\n1652#2:103\n1#3:82\n1#3:101\n*S KotlinDebug\n*F\n+ 1 PlayZTVPlugin.kt\ncom/cncverse/PlayZTVPlugin\n*L\n36#1:71,10\n36#1:81\n36#1:83\n36#1:84\n42#1:85\n42#1:86,2\n46#1:88,2\n65#1:90,10\n65#1:100\n65#1:102\n65#1:103\n36#1:82\n65#1:101\n*E\n"})
public final class PlayZTVPlugin extends Plugin {

    @NotNull
    private List<? extends Map<String, ? extends Object>> iptvProviders;

    @Nullable
    private final SharedPreferences sharedPref;

    public PlayZTVPlugin() {
        Activity activity = CommonActivity.INSTANCE.getActivity();
        this.sharedPref = activity != null ? activity.getSharedPreferences("PlayZTV", 0) : null;
        this.iptvProviders = CollectionsKt.emptyList();
    }

    public void load(@NotNull Context context) {
        Pair pair;
        PlayZTV.INSTANCE.setContext(context);
        PlayZTVLiveEventsProvider.INSTANCE.setContext(context);
        String str = null;
        registerMainAPI(new PlayZTVLiveEventsProvider(str, str, 3, str));
        this.iptvProviders = (List) BuildersKt.runBlocking$default((CoroutineContext) null, new C00201(null), 1, (Object) null);
        Iterable $this$mapNotNull$iv = this.iptvProviders;
        Collection destination$iv$iv = new ArrayList();
        Iterator it = $this$mapNotNull$iv.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object element$iv$iv$iv = it.next();
            Object obj = ((Map) element$iv$iv$iv).get("title");
            String title = obj instanceof String ? (String) obj : null;
            if (title == null) {
                pair = null;
            } else {
                SharedPreferences sharedPreferences = this.sharedPref;
                pair = TuplesKt.to(title, Boolean.valueOf(sharedPreferences != null ? sharedPreferences.getBoolean(title, false) : false));
            }
            if (pair != null) {
                destination$iv$iv.add(pair);
            }
        }
        Map providerSettings = MapsKt.toMap((List) destination$iv$iv);
        Iterable $this$filter$iv = this.iptvProviders;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            Object obj2 = ((Map) element$iv$iv).get("title");
            String title2 = obj2 instanceof String ? (String) obj2 : null;
            if (title2 != null && Intrinsics.areEqual(providerSettings.get(title2), true)) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        Iterable $this$forEach$iv = (List) destination$iv$iv2;
        for (Object element$iv : $this$forEach$iv) {
            Map p = (Map) element$iv;
            Object obj3 = p.get("title");
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
            String title3 = (String) obj3;
            Object obj4 = p.get("catLink");
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
            String catLink = (String) obj4;
            Object obj5 = p.get("type");
            String type = obj5 instanceof String ? (String) obj5 : null;
            if (type == null) {
                type = "m3u";
            }
            String displayTitle = "📺 " + title3;
            if (Intrinsics.areEqual(type, "custom")) {
                registerMainAPI(new PlayZTVLiveEventsProvider(displayTitle, catLink));
            } else {
                registerMainAPI(new PlayZTV(displayTitle, catLink));
            }
        }
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        final AppCompatActivity act = (AppCompatActivity) context;
        setOpenSettings(new Function1() { // from class: com.cncverse.PlayZTVPlugin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj6) {
                return PlayZTVPlugin.load$lambda$3(this.f$0, act, (Context) obj6);
            }
        });
    }

    /* JADX INFO: renamed from: com.cncverse.PlayZTVPlugin$load$1 */
    /* JADX INFO: compiled from: PlayZTVPlugin.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayZTVPlugin$load$1", f = "PlayZTVPlugin.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Map<String, ? extends Object>>>, Object> {
        int label;

        C00201(Continuation<? super C00201> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00201(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Map<String, ? extends Object>>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    Object objFetchProviders = PlayZTVProviderManager.INSTANCE.fetchProviders((Continuation) this);
                    return objFetchProviders == coroutine_suspended ? coroutine_suspended : objFetchProviders;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$3(PlayZTVPlugin this$0, AppCompatActivity $act, Context it) {
        SharedPreferences sharedPreferences = this$0.sharedPref;
        Iterable $this$mapNotNull$iv = this$0.iptvProviders;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Map it2 = (Map) element$iv$iv$iv;
            Object obj = it2.get("title");
            Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
            String str = obj instanceof String ? (String) obj : null;
            if (str != null) {
                destination$iv$iv.add(str);
            }
            $this$mapNotNull$iv = $this$mapNotNull$iv2;
        }
        new PlayZTVSettings(this$0, sharedPreferences, (List) destination$iv$iv).show($act.getSupportFragmentManager(), "PlayZTVSettings");
        return Unit.INSTANCE;
    }
}
