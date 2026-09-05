package com.cncverse;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.ui.settings.Globals;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: TamilUltraProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TamilUltraProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 B2\u00020\u0001:\u0002BCB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0096@¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u00020#*\u00020$2\u0006\u0010%\u001a\u00020\u0005H\u0002J\u000e\u0010&\u001a\u0004\u0018\u00010'*\u00020$H\u0002J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020'0)2\u0006\u0010*\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+J*\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0082@¢\u0006\u0002\u00101J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+JF\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u000e2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;092\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020;09H\u0096@¢\u0006\u0002\u0010>J\b\u0010?\u001a\u00020;H\u0002J\b\u0010@\u001a\u00020;H\u0002J\u0010\u0010A\u001a\u00020;2\u0006\u00104\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006D"}, d2 = {"Lcom/cncverse/TamilUltraProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toHomePageList", "Lcom/lagradost/cloudstream3/HomePageList;", "Lorg/jsoup/nodes/Element;", "sectionName", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "search", "", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEmbed", "Lcom/lagradost/nicehttp/NiceResponse;", "postid", "nume", "referUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showSubscriptionPopupIfNeeded", "showTelegramPopup", "openInExternalBrowser", "Companion", "EmbedUrl", "TamilUltraProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTamilUltraProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TamilUltraProvider.kt\ncom/cncverse/TamilUltraProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,458:1\n1642#2,10:459\n1915#2:469\n1916#2:471\n1652#2:472\n1642#2,10:473\n1915#2:483\n1916#2:485\n1652#2:486\n1642#2,10:487\n1915#2:497\n1916#2:499\n1652#2:500\n1#3:470\n1#3:484\n1#3:498\n1#3:502\n62#4:501\n*S KotlinDebug\n*F\n+ 1 TamilUltraProvider.kt\ncom/cncverse/TamilUltraProvider\n*L\n85#1:459,10\n85#1:469\n85#1:471\n85#1:472\n93#1:473,10\n93#1:483\n93#1:485\n93#1:486\n112#1:487,10\n112#1:497\n112#1:499\n112#1:500\n85#1:470\n93#1:484\n112#1:498\n165#1:501\n*E\n"})
public final class TamilUltraProvider extends MainAPI {
    private static final long BROWSER_DEBOUNCE_MS = 10000;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String OMG10 = "aHR0cHM6Ly9vbWcxMC5jb20vNC8xMTEwNDQ4OQ==";

    @Nullable
    private static Context context;
    private static volatile boolean csGuardWasEverActive;
    private static volatile long lastBrowserOpenMs;
    private static volatile boolean subscriptionPopupShown;
    private static volatile boolean telegramPopupShown;
    private final boolean hasDownloadSupport;

    @NotNull
    private String mainUrl = "https://tamilultra.co.uk";

    @NotNull
    private String name = "TamilUltra";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "ta";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Live);

    /* JADX INFO: renamed from: com.cncverse.TamilUltraProvider$getMainPage$1 */
    /* JADX INFO: compiled from: TamilUltraProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.TamilUltraProvider", f = "TamilUltraProvider.kt", i = {0, 0, 0}, l = {83}, m = "getMainPage", n = {"request", "genreClasses", "page"}, nl = {85}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TamilUltraProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.TamilUltraProvider$load$1 */
    /* JADX INFO: compiled from: TamilUltraProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.TamilUltraProvider", f = "TamilUltraProvider.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {156, 161, 168}, m = "load", n = {"url", "url", "doc", "title", "poster", "id", "url", "doc", "title", "poster", "id", "m3u8", "link"}, nl = {157, 165, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TamilUltraProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.TamilUltraProvider$loadLinks$1 */
    /* JADX INFO: compiled from: TamilUltraProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.TamilUltraProvider", f = "TamilUltraProvider.kt", i = {0, 0, 0, 0, 0}, l = {199}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "link", "isCasting"}, nl = {198}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TamilUltraProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.TamilUltraProvider$search$1 */
    /* JADX INFO: compiled from: TamilUltraProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.TamilUltraProvider", f = "TamilUltraProvider.kt", i = {0}, l = {110}, m = "search", n = {"query"}, nl = {112}, s = {"L$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TamilUltraProvider.this.search(null, (Continuation) this);
        }
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    public boolean getHasDownloadSupport() {
        return this.hasDownloadSupport;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX INFO: compiled from: TamilUltraProvider.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/cncverse/TamilUltraProvider$Companion;", "", "<init>", "()V", "isCsGuardActive", "", "csGuardWasEverActive", "isCsGuardBlocked", "showCsGuardToast", "", "ctx", "Landroid/content/Context;", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "OMG10", "", "lastBrowserOpenMs", "", "telegramPopupShown", "subscriptionPopupShown", "BROWSER_DEBOUNCE_MS", "TamilUltraProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nTamilUltraProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TamilUltraProvider.kt\ncom/cncverse/TamilUltraProvider$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,458:1\n1#2:459\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0042  */
        public final boolean isCsGuardActive() {
            String name;
            Class<?> cls;
            String name2;
            try {
                Class<?> cls2 = Class.forName("android.app.ActivityThread");
                Object thread = cls2.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                Field field = cls2.getDeclaredField("mInstrumentation");
                field.setAccessible(true);
                Object obj = field.get(thread);
                if (obj == null || (cls = obj.getClass()) == null || (name2 = cls.getName()) == null) {
                    name = "";
                } else {
                    name = name2.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(name, "toLowerCase(...)");
                    if (name == null) {
                        name = "";
                    }
                }
                return StringsKt.contains$default(name, "guard", false, 2, (Object) null) || StringsKt.contains$default(name, "csguard", false, 2, (Object) null);
            } catch (Throwable th) {
                return false;
            }
        }

        public final boolean isCsGuardBlocked() {
            if (isCsGuardActive()) {
                TamilUltraProvider.csGuardWasEverActive = true;
            }
            return TamilUltraProvider.csGuardWasEverActive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCsGuardToast(final Context ctx) {
            if (ctx == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.TamilUltraProvider$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    TamilUltraProvider.Companion.showCsGuardToast$lambda$0(ctx);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showCsGuardToast$lambda$0(Context $c) {
            Toast.makeText($c, "🚫 CSGuard detected — Restart CloudStream after removing CSGuard to use CNCRepo", 1).show();
        }

        @Nullable
        public final Context getContext() {
            return TamilUltraProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            TamilUltraProvider.context = context;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        int page2;
        List genreClasses;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = new C00001(continuation);
            }
        } else {
            c00001 = new C00001(continuation);
        }
        Object $result = c00001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00001.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                }
                showTelegramPopup();
                showSubscriptionPopupIfNeeded();
                List genreClasses2 = CollectionsKt.listOf(new Pair[]{TuplesKt.to("genre_tamil-news", "Tamil News"), TuplesKt.to("genre_tamil-movies", "Tamil Movies"), TuplesKt.to("genre_tamil-kids", "Tamil Kids"), TuplesKt.to("genre_tamil-infotainment", "Tamil Infotainment"), TuplesKt.to("genre_tamil-music", "Tamil Music"), TuplesKt.to("genre_tamil-entertainment", "Tamil Entertainment"), TuplesKt.to("genre_sports", "Sports")});
                Requests app = MainActivityKt.getApp();
                String mainUrl = getMainUrl();
                c00001.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00001.L$1 = genreClasses2;
                c00001.I$0 = page;
                c00001.label = 1;
                $result = Requests.get$default(app, mainUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                page2 = page;
                genreClasses = genreClasses2;
                break;
                break;
            case 1:
                page2 = c00001.I$0;
                genreClasses = (List) c00001.L$1;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        List $this$mapNotNull$iv = genreClasses;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Pair pair = (Pair) element$iv$iv$iv;
            String className = (String) pair.component1();
            Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
            String displayName = (String) pair.component2();
            int page3 = page2;
            List genreClasses3 = genreClasses;
            Element element = (Element) CollectionsKt.firstOrNull(document.select("div#" + className));
            HomePageList homePageList = element != null ? toHomePageList(element, displayName) : null;
            if (homePageList != null) {
                destination$iv$iv.add(homePageList);
            }
            $this$mapNotNull$iv = $this$mapNotNull$iv2;
            page2 = page3;
            genreClasses = genreClasses3;
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse$default(home, (Boolean) null, 2, (Object) null);
    }

    private final HomePageList toHomePageList(Element $this$toHomePageList, String sectionName) {
        Iterable $this$mapNotNull$iv = $this$toHomePageList.select("article.item");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List items = (List) destination$iv$iv;
        return new HomePageList(sectionName, items, false, 4, (DefaultConstructorMarker) null);
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String strText;
        String title;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("div.data > h3 > a");
        if (elementSelectFirst == null || (strText = elementSelectFirst.text()) == null || (title = StringsKt.trim(strText).toString()) == null) {
            return null;
        }
        StringBuilder sbAppend = new StringBuilder().append("");
        TamilUltraProvider tamilUltraProvider = this;
        Element elementSelectFirst2 = $this$toSearchResult.selectFirst("div.data > h3 > a");
        String href = sbAppend.append(MainAPIKt.fixUrl(tamilUltraProvider, String.valueOf(elementSelectFirst2 != null ? elementSelectFirst2.attr("href") : null))).toString();
        TamilUltraProvider tamilUltraProvider2 = this;
        Element elementSelectFirst3 = $this$toSearchResult.selectFirst("div.poster > img");
        final String posterUrl = MainAPIKt.fixUrlNull(tamilUltraProvider2, elementSelectFirst3 != null ? elementSelectFirst3.attr("src") : null);
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Live, false, new Function1() { // from class: com.cncverse.TamilUltraProvider$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return TamilUltraProvider.toSearchResult$lambda$0(posterUrl, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toSearchResult$lambda$0(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00051 c00051;
        String query2;
        if (continuation instanceof C00051) {
            c00051 = (C00051) continuation;
            if ((c00051.label & Integer.MIN_VALUE) != 0) {
                c00051.label -= Integer.MIN_VALUE;
            } else {
                c00051 = new C00051(continuation);
            }
        } else {
            c00051 = new C00051(continuation);
        }
        Object $result = c00051.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00051.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return CollectionsKt.emptyList();
                }
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/?s=" + query;
                c00051.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00051.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00051, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                query2 = query;
                break;
                break;
            case 1:
                query2 = (String) c00051.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.result-item");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            Element elementSelectFirst = it.selectFirst("article > div.details > div.title > a");
            String title = StringsKt.trim(String.valueOf(elementSelectFirst != null ? elementSelectFirst.text() : null)).toString();
            TamilUltraProvider tamilUltraProvider = this;
            Element elementSelectFirst2 = it.selectFirst("article > div.details > div.title > a");
            String href = MainAPIKt.fixUrl(tamilUltraProvider, String.valueOf(elementSelectFirst2 != null ? elementSelectFirst2.attr("href") : null));
            Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
            String query3 = query2;
            String finalUrl = StringsKt.startsWith$default(href, "/", false, 2, (Object) null) ? getMainUrl() + href : "" + href;
            TamilUltraProvider tamilUltraProvider2 = this;
            Element elementSelectFirst3 = it.selectFirst("article > div.image > div.thumbnail > a > img");
            final String posterUrl = MainAPIKt.fixUrlNull(tamilUltraProvider2, elementSelectFirst3 != null ? elementSelectFirst3.attr("src") : null);
            MovieSearchResponse movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(this, title, finalUrl, TvType.Live, false, new Function1() { // from class: com.cncverse.TamilUltraProvider$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    return TamilUltraProvider.search$lambda$0$0(posterUrl, (MovieSearchResponse) obj);
                }
            }, 8, (Object) null);
            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                destination$iv$iv.add(movieSearchResponseNewMovieSearchResponse$default);
            }
            document = document;
            $this$mapNotNull$iv = $this$mapNotNull$iv2;
            query2 = query3;
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$0(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getEmbed(String postid, String nume, String referUrl, Continuation<? super NiceResponse> continuation) {
        return Requests.post$default(MainActivityKt.getApp(), getMainUrl() + "/wp-admin/admin-ajax.php", (Map) null, referUrl, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, new FormBody.Builder((Charset) null, 1, (DefaultConstructorMarker) null).addEncoded("action", "doo_player_ajax").addEncoded("post", String.valueOf(postid)).addEncoded("nume", nume).addEncoded("type", "movie").build(), false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, continuation, 65274, (Object) null);
    }

    /* JADX INFO: compiled from: TamilUltraProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/cncverse/TamilUltraProvider$EmbedUrl;", "", "embedUrl", "", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getEmbedUrl", "()Ljava/lang/String;", "setEmbedUrl", "(Ljava/lang/String;)V", "getType", "setType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "TamilUltraProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class EmbedUrl {

        @JsonProperty("embed_url")
        @NotNull
        private String embedUrl;

        @JsonProperty("type")
        @Nullable
        private String type;

        public static /* synthetic */ EmbedUrl copy$default(EmbedUrl embedUrl, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = embedUrl.embedUrl;
            }
            if ((i & 2) != 0) {
                str2 = embedUrl.type;
            }
            return embedUrl.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEmbedUrl() {
            return this.embedUrl;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final EmbedUrl copy(@JsonProperty("embed_url") @NotNull String embedUrl, @JsonProperty("type") @Nullable String type) {
            return new EmbedUrl(embedUrl, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EmbedUrl)) {
                return false;
            }
            EmbedUrl embedUrl = (EmbedUrl) other;
            return Intrinsics.areEqual(this.embedUrl, embedUrl.embedUrl) && Intrinsics.areEqual(this.type, embedUrl.type);
        }

        public int hashCode() {
            return (this.embedUrl.hashCode() * 31) + (this.type == null ? 0 : this.type.hashCode());
        }

        @NotNull
        public String toString() {
            return "EmbedUrl(embedUrl=" + this.embedUrl + ", type=" + this.type + ')';
        }

        public EmbedUrl(@JsonProperty("embed_url") @NotNull String embedUrl, @JsonProperty("type") @Nullable String type) {
            this.embedUrl = embedUrl;
            this.type = type;
        }

        @NotNull
        public final String getEmbedUrl() {
            return this.embedUrl;
        }

        public final void setEmbedUrl(@NotNull String str) {
            this.embedUrl = str;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        public final void setType(@Nullable String str) {
            this.type = str;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:22:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:25:0x012c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x012d  */
    /* JADX WARN: Code duplicated, block: B:29:0x01e2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        Object obj;
        int i;
        Object obj2;
        String url2;
        Document doc;
        String title;
        Element elementSelectFirst;
        String strAttr;
        String poster;
        String id;
        TamilUltraProvider tamilUltraProvider;
        Object embed;
        Document doc2;
        String url3;
        String title2;
        MainAPI mainAPI;
        Object obj3;
        String title3;
        String title4;
        Object objNewMovieLoadResponse;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
            } else {
                c00011 = new C00011(continuation);
            }
        } else {
            c00011 = new C00011(continuation);
        }
        C00011 c00012 = c00011;
        Object $result = c00012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00012.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00012.L$0 = url;
                c00012.label = 1;
                obj = coroutine_suspended;
                i = 2;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                c00012 = c00012;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                doc = ((NiceResponse) obj2).getDocument();
                title = doc.select("div.sheader > div.data > h1").text();
                TamilUltraProvider tamilUltraProvider2 = this;
                elementSelectFirst = doc.selectFirst("div.poster > img");
                if (elementSelectFirst != null) {
                    strAttr = elementSelectFirst.attr("src");
                } else {
                    strAttr = null;
                }
                poster = MainAPIKt.fixUrlNull(tamilUltraProvider2, strAttr);
                id = doc.select("#player-option-1").attr("data-post");
                tamilUltraProvider = this;
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc);
                c00012.L$2 = title;
                c00012.L$3 = poster;
                c00012.L$4 = id;
                c00012.L$5 = tamilUltraProvider;
                c00012.label = i;
                embed = getEmbed(id, "1", url2, c00012);
                if (embed == obj) {
                    return obj;
                }
                doc2 = doc;
                url3 = url2;
                title2 = title;
                mainAPI = tamilUltraProvider;
                obj3 = embed;
                title3 = poster;
                title4 = id;
                NiceResponse this_$iv = (NiceResponse) obj3;
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                String m3u8 = String.valueOf(MainAPIKt.fixUrlNull(mainAPI, ((EmbedUrl) parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(EmbedUrl.class))).getEmbedUrl()));
                String link = "https://tamilultra.co.uk/" + StringsKt.substringAfter$default(m3u8, ".php?", (String) null, i, (Object) null);
                C00022 c00022 = new C00022(title3, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc2);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(title3);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(title4);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(m3u8);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(link);
                c00012.label = 3;
                objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title2 + " (Use Vpn if content didn't play)", title4, TvType.Live, m3u8 + ',' + link, c00022, c00012);
                if (objNewMovieLoadResponse == obj) {
                    return obj;
                }
                return objNewMovieLoadResponse;
            case 1:
                url2 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                obj2 = $result;
                i = 2;
                doc = ((NiceResponse) obj2).getDocument();
                title = doc.select("div.sheader > div.data > h1").text();
                TamilUltraProvider tamilUltraProvider3 = this;
                elementSelectFirst = doc.selectFirst("div.poster > img");
                if (elementSelectFirst != null) {
                    strAttr = elementSelectFirst.attr("src");
                } else {
                    strAttr = null;
                }
                poster = MainAPIKt.fixUrlNull(tamilUltraProvider3, strAttr);
                id = doc.select("#player-option-1").attr("data-post");
                tamilUltraProvider = this;
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc);
                c00012.L$2 = title;
                c00012.L$3 = poster;
                c00012.L$4 = id;
                c00012.L$5 = tamilUltraProvider;
                c00012.label = i;
                embed = getEmbed(id, "1", url2, c00012);
                if (embed == obj) {
                    return obj;
                }
                doc2 = doc;
                url3 = url2;
                title2 = title;
                mainAPI = tamilUltraProvider;
                obj3 = embed;
                title3 = poster;
                title4 = id;
                NiceResponse this_$iv2 = (NiceResponse) obj3;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                String m3u9 = String.valueOf(MainAPIKt.fixUrlNull(mainAPI, ((EmbedUrl) parser2.parse(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(EmbedUrl.class))).getEmbedUrl()));
                String link2 = "https://tamilultra.co.uk/" + StringsKt.substringAfter$default(m3u9, ".php?", (String) null, i, (Object) null);
                C00022 c00023 = new C00022(title3, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc2);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(title3);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(title4);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(m3u9);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(link2);
                c00012.label = 3;
                objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title2 + " (Use Vpn if content didn't play)", title4, TvType.Live, m3u9 + ',' + link2, c00023, c00012);
                if (objNewMovieLoadResponse == obj) {
                    return obj;
                }
                return objNewMovieLoadResponse;
            case 2:
                mainAPI = (MainAPI) c00012.L$5;
                String id2 = (String) c00012.L$4;
                String poster2 = (String) c00012.L$3;
                String title5 = (String) c00012.L$2;
                Document doc3 = (Document) c00012.L$1;
                String url4 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                url3 = url4;
                obj3 = $result;
                doc2 = doc3;
                i = 2;
                title2 = title5;
                title3 = poster2;
                title4 = id2;
                NiceResponse this_$iv3 = (NiceResponse) obj3;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                String m3u10 = String.valueOf(MainAPIKt.fixUrlNull(mainAPI, ((EmbedUrl) parser3.parse(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(EmbedUrl.class))).getEmbedUrl()));
                String link3 = "https://tamilultra.co.uk/" + StringsKt.substringAfter$default(m3u10, ".php?", (String) null, i, (Object) null);
                C00022 c00024 = new C00022(title3, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc2);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(title3);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(title4);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(m3u10);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(link3);
                c00012.label = 3;
                objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title2 + " (Use Vpn if content didn't play)", title4, TvType.Live, m3u10 + ',' + link3, c00024, c00012);
                if (objNewMovieLoadResponse == obj) {
                    return obj;
                }
                return objNewMovieLoadResponse;
            case 3:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.cncverse.TamilUltraProvider$load$2 */
    /* JADX INFO: compiled from: TamilUltraProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.TamilUltraProvider$load$2", f = "TamilUltraProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00022 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00022(String str, Continuation<? super C00022> continuation) {
            super(2, continuation);
            this.$poster = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00022 = new C00022(this.$poster, continuation);
            c00022.L$0 = obj;
            return c00022;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            MovieLoadResponse $this$newMovieLoadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newMovieLoadResponse.setPosterUrl(this.$poster);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00031 c00031;
        Function1<? super ExtractorLink, Unit> function3;
        boolean z;
        Object objNewExtractorLink;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
            } else {
                c00031 = new C00031(continuation);
            }
        } else {
            c00031 = new C00031(continuation);
        }
        C00031 c00032 = c00031;
        Object $result = c00032.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00032.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                TamilUltraProvider $this$loadLinks_u24lambda_u240 = this;
                final Context _ctx = context;
                SharedPreferences _prefs = _ctx != null ? _ctx.getSharedPreferences("CNCVerseSubscription", 0) : null;
                String _mode = _prefs != null ? _prefs.getString("mode", "ads") : null;
                long _expiresAt = _prefs != null ? _prefs.getLong("expires_at", 0L) : 0L;
                long _nowSec = System.currentTimeMillis() / 1000;
                boolean _isSubscribed = Intrinsics.areEqual(_mode, "subscription") && (_expiresAt == 0 || _expiresAt > _nowSec);
                if (!_isSubscribed) {
                    if (Intrinsics.areEqual(_mode, "subscription") && _expiresAt > 0 && _expiresAt <= _nowSec) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.TamilUltraProvider$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                TamilUltraProvider.loadLinks$lambda$0$0(_ctx);
                            }
                        });
                    }
                    $this$loadLinks_u24lambda_u240.openInExternalBrowser(new String(Base64.decode(OMG10, 0), Charsets.UTF_8));
                }
                String link = StringsKt.substringAfter$default(data, ",", (String) null, 2, (Object) null);
                String name = getName();
                String name2 = getName();
                ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                C00043 c00043 = new C00043(null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(link);
                function3 = function2;
                c00032.L$4 = function3;
                c00032.Z$0 = isCasting;
                z = true;
                c00032.label = 1;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, link, extractorLinkType, c00043, c00032);
                if (objNewExtractorLink == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                boolean z2 = c00032.Z$0;
                Function1<? super ExtractorLink, Unit> function4 = (Function1) c00032.L$4;
                ResultKt.throwOnFailure($result);
                function3 = function4;
                z = true;
                objNewExtractorLink = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        function3.invoke(objNewExtractorLink);
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadLinks$lambda$0$0(Context $_ctx) {
        Toast.makeText($_ctx, "⚠️(Opening ads) Subscription expired. If you have renewed your subscription, please re-verify it in Subscription Manager.", 1).show();
    }

    /* JADX INFO: renamed from: com.cncverse.TamilUltraProvider$loadLinks$3 */
    /* JADX INFO: compiled from: TamilUltraProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.TamilUltraProvider$loadLinks$3", f = "TamilUltraProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00043 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00043(Continuation<? super C00043> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00043 = new C00043(continuation);
            c00043.L$0 = obj;
            return c00043;
        }

        public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
            return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newExtractorLink.setQuality(Qualities.Unknown.getValue());
                    $this$newExtractorLink.setReferer("https://tamilultra.co.uk/");
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final void showSubscriptionPopupIfNeeded() {
        final Context ctx = context;
        if (ctx == null || subscriptionPopupShown) {
            return;
        }
        try {
            boolean isTV = Globals.INSTANCE.isLayout(2);
            if (isTV) {
                return;
            }
        } catch (Exception e) {
        }
        SharedPreferences sharedPreferences = ctx.getSharedPreferences("CNCVerseSubscription", 0);
        boolean isSubscribed = Intrinsics.areEqual(sharedPreferences != null ? sharedPreferences.getString("mode", "ads") : null, "subscription");
        if (isSubscribed) {
            return;
        }
        SharedPreferences _dontShowPrefs = ctx.getSharedPreferences("CNCVerseSubscription", 0);
        if (_dontShowPrefs.getBoolean("dont_show_ads_popup", false)) {
            subscriptionPopupShown = true;
        } else {
            subscriptionPopupShown = true;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.TamilUltraProvider$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    TamilUltraProvider.showSubscriptionPopupIfNeeded$lambda$0(ctx);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSubscriptionPopupIfNeeded$lambda$0(final Context $ctx) {
        try {
            float dp = $ctx.getResources().getDisplayMetrics().density;
            GradientDrawable $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u240 = new GradientDrawable();
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u240.setColor(Color.parseColor("#1A1A2E"));
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u240.setCornerRadius(16.0f * dp);
            LinearLayout root = new LinearLayout($ctx);
            root.setOrientation(1);
            float f = 24;
            root.setPadding((int) (f * dp), (int) (20 * dp), (int) (f * dp), (int) (16 * dp));
            root.setBackground($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u240);
            TextView $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242 = new TextView($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setText("📺 You're in Ads Mode");
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setTextColor(-1);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setTextSize(17.0f);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setTypeface(Typeface.DEFAULT_BOLD);
            LinearLayout.LayoutParams it = new LinearLayout.LayoutParams(-1, -2);
            it.bottomMargin = (int) (8 * dp);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setLayoutParams(it);
            View divider = new View($ctx);
            divider.setBackgroundColor(Color.parseColor("#2D2D4A"));
            LinearLayout.LayoutParams it2 = new LinearLayout.LayoutParams(-1, 1);
            it2.bottomMargin = (int) (12 * dp);
            divider.setLayoutParams(it2);
            TextView $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244 = new TextView($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setText("All CNCVerse extensions currently run with ads.\n\nSubscribe to remove ads from just ₹20/month.\n\nManage via Settings > Extensions > CNCVerse Cloudstream Repo > Subscription Manager.");
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setTextColor(Color.parseColor("#A0A0A8"));
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setTextSize(14.0f);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setLineSpacing(0.0f, 1.4f);
            LinearLayout.LayoutParams it3 = new LinearLayout.LayoutParams(-1, -2);
            it3.bottomMargin = (int) (18 * dp);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setLayoutParams(it3);
            LinearLayout btnRow = new LinearLayout($ctx);
            btnRow.setOrientation(0);
            btnRow.setGravity(8388613);
            TextView laterTv = new TextView($ctx);
            laterTv.setText("Maybe Later");
            laterTv.setTextColor(Color.parseColor("#808090"));
            laterTv.setTextSize(14.0f);
            float f2 = 10;
            int p = (int) (f2 * dp);
            laterTv.setPadding(p, p, p, p);
            laterTv.setClickable(true);
            laterTv.setFocusable(true);
            TextView subscribeTv = new TextView($ctx);
            subscribeTv.setText("Subscribe Now");
            subscribeTv.setTextColor(Color.parseColor("#A78BFA"));
            subscribeTv.setTextSize(14.0f);
            subscribeTv.setTypeface(Typeface.DEFAULT_BOLD);
            int p2 = (int) (f2 * dp);
            subscribeTv.setPadding(p2, p2, 0, p2);
            subscribeTv.setClickable(true);
            subscribeTv.setFocusable(true);
            LinearLayout $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248 = new LinearLayout($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.setOrientation(0);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.setGravity(8388627);
            LinearLayout.LayoutParams it4 = new LinearLayout.LayoutParams(-1, -2);
            it4.bottomMargin = (int) (f2 * dp);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.setLayoutParams(it4);
            final CheckBox $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249 = new CheckBox($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249.setChecked(false);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#A78BFA")));
            TextView $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410 = new TextView($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410.setText("Don't show me again");
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410.setTextColor(Color.parseColor("#A0A0A8"));
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410.setTextSize(13.0f);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410.setPadding((int) (6 * dp), 0, 0, 0);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410);
            btnRow.addView(laterTv);
            btnRow.addView(subscribeTv);
            root.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242);
            root.addView(divider);
            root.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244);
            root.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248);
            root.addView(btnRow);
            final AlertDialog dialog = new AlertDialog.Builder($ctx).setView(root).setCancelable(true).create();
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.TamilUltraProvider$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TamilUltraProvider.showSubscriptionPopupIfNeeded$lambda$0$11($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249, $ctx, dialog, view);
                }
            });
            subscribeTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.TamilUltraProvider$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TamilUltraProvider.showSubscriptionPopupIfNeeded$lambda$0$12(dialog, $ctx, view);
                }
            });
            dialog.show();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSubscriptionPopupIfNeeded$lambda$0$11(CheckBox $dontShowCb, Context $ctx, AlertDialog $dialog, View it) {
        if ($dontShowCb.isChecked()) {
            $ctx.getSharedPreferences("CNCVerseSubscription", 0).edit().putBoolean("dont_show_ads_popup", true).apply();
        }
        $dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSubscriptionPopupIfNeeded$lambda$0$12(AlertDialog $dialog, Context $ctx, View it) {
        $dialog.dismiss();
        try {
            Intent i = new Intent("android.intent.action.VIEW", Uri.parse("https://cncverse-sub.pages.dev"));
            i.addFlags(268435456);
            $ctx.startActivity(i);
        } catch (Exception e) {
        }
    }

    private final void showTelegramPopup() {
        final Context ctx;
        if (Globals.INSTANCE.isLayout(2) || (ctx = context) == null || telegramPopupShown) {
            return;
        }
        SharedPreferences prefs = ctx.getSharedPreferences("cncverse_prefs", 0);
        if (prefs.getBoolean("telegram_popup_shown", false)) {
            telegramPopupShown = true;
            return;
        }
        telegramPopupShown = true;
        prefs.edit().putBoolean("telegram_popup_shown", true).apply();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.TamilUltraProvider$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                TamilUltraProvider.showTelegramPopup$lambda$0(ctx);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTelegramPopup$lambda$0(final Context $ctx) {
        try {
            float dp = $ctx.getResources().getDisplayMetrics().density;
            GradientDrawable $this$showTelegramPopup_u24lambda_u240_u240 = new GradientDrawable();
            $this$showTelegramPopup_u24lambda_u240_u240.setColor(Color.parseColor("#1A1A2E"));
            $this$showTelegramPopup_u24lambda_u240_u240.setCornerRadius(16.0f * dp);
            LinearLayout root = new LinearLayout($ctx);
            root.setOrientation(1);
            float f = 24;
            root.setPadding((int) (f * dp), (int) (20 * dp), (int) (f * dp), (int) (16 * dp));
            root.setBackground($this$showTelegramPopup_u24lambda_u240_u240);
            TextView $this$showTelegramPopup_u24lambda_u240_u242 = new TextView($ctx);
            $this$showTelegramPopup_u24lambda_u240_u242.setText("💬 Join CNCVerse Community");
            $this$showTelegramPopup_u24lambda_u240_u242.setTextColor(-1);
            $this$showTelegramPopup_u24lambda_u240_u242.setTextSize(17.0f);
            $this$showTelegramPopup_u24lambda_u240_u242.setTypeface(Typeface.DEFAULT_BOLD);
            LinearLayout.LayoutParams it = new LinearLayout.LayoutParams(-1, -2);
            float f2 = 10;
            it.bottomMargin = (int) (f2 * dp);
            $this$showTelegramPopup_u24lambda_u240_u242.setLayoutParams(it);
            View dividerV = new View($ctx);
            dividerV.setBackgroundColor(Color.parseColor("#2D2D4A"));
            LinearLayout.LayoutParams it2 = new LinearLayout.LayoutParams(-1, 1);
            it2.bottomMargin = (int) (14 * dp);
            dividerV.setLayoutParams(it2);
            TextView $this$showTelegramPopup_u24lambda_u240_u244 = new TextView($ctx);
            $this$showTelegramPopup_u24lambda_u240_u244.setText("Join our Telegram group to discuss and share your opinion!");
            $this$showTelegramPopup_u24lambda_u240_u244.setTextColor(Color.parseColor("#A0A0A8"));
            $this$showTelegramPopup_u24lambda_u240_u244.setTextSize(14.0f);
            $this$showTelegramPopup_u24lambda_u240_u244.setLineSpacing(0.0f, 1.4f);
            LinearLayout.LayoutParams it3 = new LinearLayout.LayoutParams(-1, -2);
            it3.bottomMargin = (int) (18 * dp);
            $this$showTelegramPopup_u24lambda_u240_u244.setLayoutParams(it3);
            LinearLayout btnRow = new LinearLayout($ctx);
            btnRow.setOrientation(0);
            btnRow.setGravity(8388613);
            TextView laterTv = new TextView($ctx);
            laterTv.setText("Later");
            laterTv.setTextColor(Color.parseColor("#808090"));
            laterTv.setTextSize(14.0f);
            int p = (int) (f2 * dp);
            laterTv.setPadding(p, p, p, p);
            laterTv.setClickable(true);
            laterTv.setFocusable(true);
            TextView joinTv = new TextView($ctx);
            joinTv.setText("Join Telegram");
            joinTv.setTextColor(Color.parseColor("#5B9BF5"));
            joinTv.setTextSize(14.0f);
            joinTv.setTypeface(Typeface.DEFAULT_BOLD);
            int p2 = (int) (f2 * dp);
            joinTv.setPadding(p2, p2, 0, p2);
            joinTv.setClickable(true);
            joinTv.setFocusable(true);
            btnRow.addView(laterTv);
            btnRow.addView(joinTv);
            root.addView($this$showTelegramPopup_u24lambda_u240_u242);
            root.addView(dividerV);
            root.addView($this$showTelegramPopup_u24lambda_u240_u244);
            root.addView(btnRow);
            final AlertDialog dialog = new AlertDialog.Builder($ctx).setView(root).setCancelable(true).create();
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.TamilUltraProvider$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            joinTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.TamilUltraProvider$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TamilUltraProvider.showTelegramPopup$lambda$0$9(dialog, $ctx, view);
                }
            });
            dialog.show();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTelegramPopup$lambda$0$9(AlertDialog $dialog, Context $ctx, View it) {
        $dialog.dismiss();
        try {
            Intent i = new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/cncverse"));
            i.addFlags(268435456);
            $ctx.startActivity(i);
        } catch (Exception e) {
        }
    }

    private final void openInExternalBrowser(final String url) {
        final Context ctx;
        if (Globals.INSTANCE.isLayout(2) || (ctx = context) == null) {
            return;
        }
        long now = System.currentTimeMillis();
        if (now - lastBrowserOpenMs < BROWSER_DEBOUNCE_MS) {
            return;
        }
        lastBrowserOpenMs = now;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.TamilUltraProvider$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                TamilUltraProvider.openInExternalBrowser$lambda$0(ctx, url);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openInExternalBrowser$lambda$0(Context $ctx, String $url) {
        try {
            Intent $this$openInExternalBrowser_u24lambda_u240_u240 = new Intent("android.intent.action.VIEW", Uri.parse($url));
            $this$openInExternalBrowser_u24lambda_u240_u240.addFlags(268435456);
            $ctx.startActivity($this$openInExternalBrowser_u24lambda_u240_u240);
        } catch (Exception e) {
        }
    }
}
