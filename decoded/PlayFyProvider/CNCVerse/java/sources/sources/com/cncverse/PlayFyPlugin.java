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
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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

/* JADX INFO: compiled from: PlayFyPlugin.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/PlayFyProvider/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/cncverse/PlayFyPlugin;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "sharedPref", "Landroid/content/SharedPreferences;", "iptvProviders", "", "", "", "", "load", "", "context", "Landroid/content/Context;", "PlayFyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPlayFyPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayFyPlugin.kt\ncom/cncverse/PlayFyPlugin\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,53:1\n777#2:54\n873#2,2:55\n1915#2,2:57\n1642#2,10:59\n1915#2:69\n1916#2:71\n1652#2:72\n1#3:70\n*S KotlinDebug\n*F\n+ 1 PlayFyPlugin.kt\ncom/cncverse/PlayFyPlugin\n*L\n31#1:54\n31#1:55,2\n36#1:57,2\n47#1:59,10\n47#1:69\n47#1:71\n47#1:72\n47#1:70\n*E\n"})
public final class PlayFyPlugin extends Plugin {

    @NotNull
    private List<? extends Map<String, ? extends Object>> iptvProviders;

    @Nullable
    private final SharedPreferences sharedPref;

    public PlayFyPlugin() {
        Activity activity = CommonActivity.INSTANCE.getActivity();
        this.sharedPref = activity != null ? activity.getSharedPreferences("PlayFy", 0) : null;
        this.iptvProviders = CollectionsKt.emptyList();
    }

    public void load(@NotNull Context context) {
        PlayFy.INSTANCE.setContext(context);
        PlayFyLiveEvents.INSTANCE.setContext(context);
        registerMainAPI(new PlayFyLiveEvents("⚡ PlayFy Live Events", "live"));
        registerMainAPI(new PlayFyLiveEvents("🎬 PlayFy Highlights", "highlights"));
        this.iptvProviders = (List) BuildersKt.runBlocking$default((CoroutineContext) null, new C00271(null), 1, (Object) null);
        Iterable $this$filter$iv = this.iptvProviders;
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
        Iterable selected = (List) destination$iv$iv;
        Iterable $this$forEach$iv = selected;
        for (Object element$iv : $this$forEach$iv) {
            Map provider = (Map) element$iv;
            Object obj2 = provider.get("title");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = provider.get("catLink");
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
            String catLink = (String) obj3;
            registerMainAPI(new PlayFy("📺 " + ((String) obj2), catLink));
        }
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        final AppCompatActivity act = (AppCompatActivity) context;
        setOpenSettings(new Function1() { // from class: com.cncverse.PlayFyPlugin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj4) {
                return PlayFyPlugin.load$lambda$2(this.f$0, act, (Context) obj4);
            }
        });
    }

    /* JADX INFO: renamed from: com.cncverse.PlayFyPlugin$load$1 */
    /* JADX INFO: compiled from: PlayFyPlugin.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayFyPlugin$load$1", f = "PlayFyPlugin.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Map<String, ? extends Object>>>, Object> {
        int label;

        C00271(Continuation<? super C00271> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00271(continuation);
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
                    Object objFetchProviders = PlayFyProviderManager.INSTANCE.fetchProviders((Continuation) this);
                    if (objFetchProviders == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objFetchProviders;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$2(PlayFyPlugin this$0, AppCompatActivity $act, Context it) {
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
        PlayFySettings frag = new PlayFySettings(this$0, sharedPreferences, (List) destination$iv$iv);
        frag.show($act.getSupportFragmentManager(), "PlayFySettings");
        return Unit.INSTANCE;
    }
}
