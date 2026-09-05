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
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.ui.settings.Globals;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: MoviezwapProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MoviezwapProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u0004\u0018\u00010'*\u00020(H\u0002J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u001c2\u0006\u0010*\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+J\u0018\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+JF\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u000e2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205032\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020503H\u0096@¢\u0006\u0002\u00108J\b\u00109\u001a\u000205H\u0002J\b\u0010:\u001a\u000205H\u0002J\u0010\u0010;\u001a\u0002052\u0006\u0010.\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006="}, d2 = {"Lcom/cncverse/MoviezwapProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showSubscriptionPopupIfNeeded", "showTelegramPopup", "openInExternalBrowser", "Companion", "MoviezwapProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMoviezwapProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MoviezwapProvider.kt\ncom/cncverse/MoviezwapProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,568:1\n1642#2,10:569\n1915#2:579\n1916#2:581\n1652#2:582\n1696#2,8:583\n1642#2,10:591\n1915#2:601\n1916#2:603\n1652#2:604\n1696#2,8:605\n1642#2,10:614\n1915#2:624\n1916#2:626\n1652#2:627\n1586#2:628\n1661#2,3:629\n1915#2,2:632\n1#3:580\n1#3:602\n1#3:613\n1#3:625\n1#3:634\n*S KotlinDebug\n*F\n+ 1 MoviezwapProvider.kt\ncom/cncverse/MoviezwapProvider\n*L\n97#1:569,10\n97#1:579\n97#1:581\n97#1:582\n99#1:583,8\n170#1:591,10\n170#1:601\n170#1:603\n170#1:604\n172#1:605,8\n210#1:614,10\n210#1:624\n210#1:626\n210#1:627\n275#1:628\n275#1:629,3\n283#1:632,2\n97#1:580\n170#1:602\n210#1:625\n*E\n"})
public final class MoviezwapProvider extends MainAPI {
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

    @NotNull
    private String mainUrl = "https://www.moviezwap.land";

    @NotNull
    private String name = "Moviezwap";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "te";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to(getMainUrl() + "/category/Telugu-(2026)-Movies.html", "Telugu (2026) Movies"), TuplesKt.to(getMainUrl() + "/category/Telugu-(2025)-Movies.html", "Telugu (2025) Movies"), TuplesKt.to(getMainUrl() + "/category/Tamil-(2026)-Movies.html", "Tamil (2026) Movies"), TuplesKt.to(getMainUrl() + "/category/Tamil-(2025)-Movies.html", "Tamil (2025) Movies"), TuplesKt.to(getMainUrl() + "/category/Telugu-Dubbed-Movies-[Hollywood].html", "Telugu Dubbed Hollywood"), TuplesKt.to(getMainUrl() + "/category/HOT-Web-Series.html", "HOT Web Series")});

    /* JADX INFO: renamed from: com.cncverse.MoviezwapProvider$getMainPage$1 */
    /* JADX INFO: compiled from: MoviezwapProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MoviezwapProvider", f = "MoviezwapProvider.kt", i = {0, 0, 0}, l = {90}, m = "getMainPage", n = {"request", "url", "page"}, nl = {91}, s = {"L$0", "L$1", "I$0"}, v = 2)
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
            return MoviezwapProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MoviezwapProvider$load$1 */
    /* JADX INFO: compiled from: MoviezwapProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MoviezwapProvider", f = "MoviezwapProvider.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {178, 230, 237}, m = "load", n = {"url", "url", "document", "title", "poster", "description", "yearText", "year", "seasonLinks", "episodes", "isSeries", "url", "document", "title", "poster", "description", "yearText", "year", "seasonLinks", "isSeries"}, nl = {179, 237, 208}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MoviezwapProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MoviezwapProvider$loadLinks$1 */
    /* JADX INFO: compiled from: MoviezwapProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MoviezwapProvider", f = "MoviezwapProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {268, 299, 309}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "document", "downloadLinks", "foundLinks", "$this$forEach$iv", "element$iv", "linkElement", "downloadPageUrl", "linkText", "isCasting", "$i$f$forEach", "$i$a$-forEach-MoviezwapProvider$loadLinks$3", "quality", "data", "subtitleCallback", "callback", "document", "downloadLinks", "foundLinks", "$this$forEach$iv", "element$iv", "linkElement", "downloadPageUrl", "linkText", "actualDownloadUrl", "isCasting", "$i$f$forEach", "$i$a$-forEach-MoviezwapProvider$loadLinks$3", "quality"}, nl = {269, 301, 308}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "Z$0", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "Z$0", "I$0", "I$1", "I$2"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MoviezwapProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MoviezwapProvider$search$1 */
    /* JADX INFO: compiled from: MoviezwapProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MoviezwapProvider", f = "MoviezwapProvider.kt", i = {0, 0, 0}, l = {164}, m = "search", n = {"query", "fixedQuery", "searchUrl"}, nl = {165}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MoviezwapProvider.this.search(null, (Continuation) this);
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

    /* JADX INFO: compiled from: MoviezwapProvider.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/cncverse/MoviezwapProvider$Companion;", "", "<init>", "()V", "isCsGuardActive", "", "csGuardWasEverActive", "isCsGuardBlocked", "showCsGuardToast", "", "ctx", "Landroid/content/Context;", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "OMG10", "", "lastBrowserOpenMs", "", "telegramPopupShown", "subscriptionPopupShown", "BROWSER_DEBOUNCE_MS", "MoviezwapProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nMoviezwapProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MoviezwapProvider.kt\ncom/cncverse/MoviezwapProvider$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,568:1\n1#2:569\n*E\n"})
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
                MoviezwapProvider.csGuardWasEverActive = true;
            }
            return MoviezwapProvider.csGuardWasEverActive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCsGuardToast(final Context ctx) {
            if (ctx == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.MoviezwapProvider$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MoviezwapProvider.Companion.showCsGuardToast$lambda$0(ctx);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showCsGuardToast$lambda$0(Context $c) {
            Toast.makeText($c, "🚫 CSGuard detected — Restart CloudStream after removing CSGuard to use CNCRepo", 1).show();
        }

        @Nullable
        public final Context getContext() {
            return MoviezwapProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            MoviezwapProvider.context = context;
        }
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00f7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:39:0x0120  */
    /* JADX WARN: Code duplicated, block: B:41:0x0132  */
    /* JADX WARN: Code duplicated, block: B:46:0x0157  */
    /* JADX WARN: Code duplicated, block: B:75:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x016a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x0151 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        MainPageRequest request2;
        String url;
        Collection destination$iv$iv;
        HashSet set$iv;
        ArrayList list$iv;
        SearchResponse it;
        SearchResponse searchResult;
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
                if (page == 1) {
                    try {
                        url = request.getData();
                        try {
                            Requests app = MainActivityKt.getApp();
                            c00001.L$0 = request;
                            c00001.L$1 = SpillingKt.nullOutSpilledVariable(url);
                            c00001.I$0 = page;
                            c00001.label = 1;
                            try {
                                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4094, (Object) null);
                                if ($result == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                request2 = request;
                                try {
                                    Document document = ((NiceResponse) $result).getDocument();
                                    Iterable $this$mapNotNull$iv = document.select("a[href*='/movie/']");
                                    destination$iv$iv = new ArrayList();
                                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                        Element it2 = (Element) element$iv$iv$iv;
                                        searchResult = toSearchResult(it2);
                                        if (searchResult != null) {
                                            destination$iv$iv.add(searchResult);
                                        }
                                    }
                                    Iterable $this$distinctBy$iv = (List) destination$iv$iv;
                                    set$iv = new HashSet();
                                    list$iv = new ArrayList();
                                    for (Object e$iv : $this$distinctBy$iv) {
                                        it = (SearchResponse) e$iv;
                                        if (set$iv.add(it.getUrl())) {
                                            list$iv.add(e$iv);
                                        }
                                    }
                                    ArrayList home = list$iv;
                                    return MainAPIKt.newHomePageResponse(CollectionsKt.arrayListOf(new HomePageList[]{new HomePageList(request2.getName(), home, false, 4, (DefaultConstructorMarker) null)}), Boxing.boxBoolean(!home.isEmpty()));
                                } catch (Exception e) {
                                    e = e;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                request2 = request;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            request2 = request;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        request2 = request;
                    }
                } else {
                    try {
                        url = StringsKt.removeSuffix(request.getData(), ".html") + '/' + page + ".html";
                        Requests app2 = MainActivityKt.getApp();
                        c00001.L$0 = request;
                        c00001.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        c00001.I$0 = page;
                        c00001.label = 1;
                        $result = Requests.get$default(app2, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4094, (Object) null);
                        if ($result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        request2 = request;
                        Document document2 = ((NiceResponse) $result).getDocument();
                        Iterable $this$mapNotNull$iv2 = document2.select("a[href*='/movie/']");
                        destination$iv$iv = new ArrayList();
                        while (r13.hasNext()) {
                            Element it3 = (Element) element$iv$iv$iv;
                            searchResult = toSearchResult(it3);
                            if (searchResult != null) {
                                destination$iv$iv.add(searchResult);
                            }
                        }
                        Iterable $this$distinctBy$iv2 = (List) destination$iv$iv;
                        set$iv = new HashSet();
                        list$iv = new ArrayList();
                        while (r9.hasNext()) {
                            it = (SearchResponse) e$iv;
                            if (set$iv.add(it.getUrl())) {
                                list$iv.add(e$iv);
                            }
                        }
                        ArrayList home2 = list$iv;
                        return MainAPIKt.newHomePageResponse(CollectionsKt.arrayListOf(new HomePageList[]{new HomePageList(request2.getName(), home2, false, 4, (DefaultConstructorMarker) null)}), Boxing.boxBoolean(!home2.isEmpty()));
                    } catch (Exception e5) {
                        e = e5;
                        request2 = request;
                    }
                }
                Log.e("MoviezwapProvider", "Error fetching main page: " + e.getMessage());
                return MainAPIKt.newHomePageResponse(CollectionsKt.arrayListOf(new HomePageList[]{new HomePageList(request2.getName(), CollectionsKt.emptyList(), false, 4, (DefaultConstructorMarker) null)}), Boxing.boxBoolean(false));
            case 1:
                int i = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    Document document3 = ((NiceResponse) $result).getDocument();
                    Iterable $this$mapNotNull$iv3 = document3.select("a[href*='/movie/']");
                    destination$iv$iv = new ArrayList();
                    while (r13.hasNext()) {
                        Element it4 = (Element) element$iv$iv$iv;
                        searchResult = toSearchResult(it4);
                        if (searchResult != null) {
                            destination$iv$iv.add(searchResult);
                        }
                    }
                    Iterable $this$distinctBy$iv3 = (List) destination$iv$iv;
                    set$iv = new HashSet();
                    list$iv = new ArrayList();
                    while (r9.hasNext()) {
                        it = (SearchResponse) e$iv;
                        if (set$iv.add(it.getUrl())) {
                            list$iv.add(e$iv);
                        }
                    }
                    ArrayList home3 = list$iv;
                    return MainAPIKt.newHomePageResponse(CollectionsKt.arrayListOf(new HomePageList[]{new HomePageList(request2.getName(), home3, false, 4, (DefaultConstructorMarker) null)}), Boxing.boxBoolean(!home3.isEmpty()));
                } catch (Exception e6) {
                    e = e6;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String href = $this$toSearchResult.attr("href");
        if (!StringsKt.contains$default(href, "/movie/", false, 2, (Object) null)) {
            return null;
        }
        String string = StringsKt.trim($this$toSearchResult.text()).toString();
        if (string.length() == 0) {
            string = StringsKt.replace$default(StringsKt.replace$default(StringsKt.removeSuffix(StringsKt.substringAfterLast$default(href, "/", (String) null, 2, (Object) null), ".html"), "-", " ", false, 4, (Object) null), "(", " (", false, 4, (Object) null);
        }
        String title = string;
        if (StringsKt.isBlank(title)) {
            return null;
        }
        boolean isSeries = new Regex("(?i)(season|episodes?|eps|all episodes|web series)").containsMatchIn(title);
        String slug = StringsKt.substringBefore$default(StringsKt.substringAfter$default(href, "/movie/", (String) null, 2, (Object) null), ".html", (String) null, 2, (Object) null).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(slug, "toLowerCase(...)");
        String slug2 = StringsKt.replace$default(StringsKt.replace$default(slug, "(", "", false, 4, (Object) null), ")", "", false, 4, (Object) null);
        if (isSeries) {
            int seasonIndex = StringsKt.lastIndexOf$default(slug2, "-season-", 0, false, 6, (Object) null);
            if (seasonIndex != -1) {
                int end = seasonIndex + 8;
                while (end < slug2.length() && Character.isDigit(slug2.charAt(end))) {
                    end++;
                }
                String strSubstring = slug2.substring(0, end);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                slug2 = strSubstring;
            }
        } else {
            int movieIndex = StringsKt.lastIndexOf$default(slug2, "-movie", 0, false, 6, (Object) null);
            if (movieIndex != -1) {
                String strSubstring2 = slug2.substring(0, movieIndex + 6);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                slug2 = strSubstring2;
            } else if (StringsKt.endsWith$default(slug2, "-org", false, 2, (Object) null)) {
                slug2 = StringsKt.removeSuffix(slug2, "-org") + "-movie";
            } else if (StringsKt.endsWith$default(slug2, "-orginal", false, 2, (Object) null)) {
                slug2 = StringsKt.removeSuffix(slug2, "-orginal") + "-movie";
            }
        }
        final String posterUrl = "/poster/" + slug2 + ".jpg";
        return isSeries ? MainAPIKt.newTvSeriesSearchResponse$default(this, title, MainAPIKt.fixUrl(this, href), TvType.TvSeries, false, new Function1() { // from class: com.cncverse.MoviezwapProvider$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                return MoviezwapProvider.toSearchResult$lambda$1(this.f$0, posterUrl, (TvSeriesSearchResponse) obj);
            }
        }, 8, (Object) null) : MainAPIKt.newMovieSearchResponse$default(this, title, MainAPIKt.fixUrl(this, href), TvType.Movie, false, new Function1() { // from class: com.cncverse.MoviezwapProvider$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                return MoviezwapProvider.toSearchResult$lambda$2(this.f$0, posterUrl, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toSearchResult$lambda$1(MoviezwapProvider this$0, String $posterUrl, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl(MainAPIKt.fixUrl(this$0, $posterUrl));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toSearchResult$lambda$2(MoviezwapProvider this$0, String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl(MainAPIKt.fixUrl(this$0, $posterUrl));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0104  */
    /* JADX WARN: Code duplicated, block: B:34:0x0118  */
    /* JADX WARN: Code duplicated, block: B:39:0x013f  */
    /* JADX WARN: Code duplicated, block: B:62:0x011d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x0152 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x0139 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00051 c00051;
        Document document;
        Collection destination$iv$iv;
        HashSet set$iv;
        ArrayList list$iv;
        SearchResponse it;
        SearchResponse searchResult;
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
        C00051 c00052 = c00051;
        Object $result = c00052.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00052.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return CollectionsKt.emptyList();
                }
                String fixedQuery = StringsKt.replace$default(query, " ", "+", false, 4, (Object) null);
                String searchUrl = getMainUrl() + "/search.php?q=" + fixedQuery;
                try {
                    Requests app = MainActivityKt.getApp();
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(query);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(fixedQuery);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(searchUrl);
                    c00052.label = 1;
                    try {
                        Object obj = Requests.get$default(app, searchUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00052, 4094, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = obj;
                        try {
                            document = ((NiceResponse) $result).getDocument();
                            Iterable $this$mapNotNull$iv = document.select("a[href*='/movie/']");
                            destination$iv$iv = new ArrayList();
                            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                Document document2 = document;
                                Element it2 = (Element) element$iv$iv$iv;
                                searchResult = toSearchResult(it2);
                                if (searchResult != null) {
                                    destination$iv$iv.add(searchResult);
                                }
                                document = document2;
                            }
                            Iterable $this$distinctBy$iv = (List) destination$iv$iv;
                            set$iv = new HashSet();
                            list$iv = new ArrayList();
                            for (Object e$iv : $this$distinctBy$iv) {
                                it = (SearchResponse) e$iv;
                                if (set$iv.add(it.getUrl())) {
                                    list$iv.add(e$iv);
                                }
                            }
                            ArrayList $this$distinctBy$iv2 = list$iv;
                            return $this$distinctBy$iv2;
                        } catch (Exception e) {
                            e = e;
                            Log.e("MoviezwapProvider", "Error during search: " + e.getMessage());
                            return CollectionsKt.emptyList();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        Log.e("MoviezwapProvider", "Error during search: " + e.getMessage());
                        return CollectionsKt.emptyList();
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                break;
            case 1:
                try {
                    ResultKt.throwOnFailure($result);
                    document = ((NiceResponse) $result).getDocument();
                    Iterable $this$mapNotNull$iv2 = document.select("a[href*='/movie/']");
                    destination$iv$iv = new ArrayList();
                    while (r13.hasNext()) {
                        Document document3 = document;
                        Element it3 = (Element) element$iv$iv$iv;
                        searchResult = toSearchResult(it3);
                        if (searchResult != null) {
                            destination$iv$iv.add(searchResult);
                        }
                        document = document3;
                    }
                    Iterable $this$distinctBy$iv3 = (List) destination$iv$iv;
                    set$iv = new HashSet();
                    list$iv = new ArrayList();
                    while (r9.hasNext()) {
                        it = (SearchResponse) e$iv;
                        if (set$iv.add(it.getUrl())) {
                            list$iv.add(e$iv);
                        }
                    }
                    ArrayList $this$distinctBy$iv4 = list$iv;
                    return $this$distinctBy$iv4;
                } catch (Exception e4) {
                    e = e4;
                    Log.e("MoviezwapProvider", "Error during search: " + e.getMessage());
                    return CollectionsKt.emptyList();
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x036f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:107:0x0370  */
    /* JADX WARN: Code duplicated, block: B:110:0x0384 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:130:0x02a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0101  */
    /* JADX WARN: Code duplicated, block: B:36:0x0109  */
    /* JADX WARN: Code duplicated, block: B:43:0x012e  */
    /* JADX WARN: Code duplicated, block: B:44:0x0135  */
    /* JADX WARN: Code duplicated, block: B:47:0x0157  */
    /* JADX WARN: Code duplicated, block: B:48:0x0159  */
    /* JADX WARN: Code duplicated, block: B:50:0x015c  */
    /* JADX WARN: Code duplicated, block: B:55:0x0177  */
    /* JADX WARN: Code duplicated, block: B:58:0x018d  */
    /* JADX WARN: Code duplicated, block: B:59:0x018f  */
    /* JADX WARN: Code duplicated, block: B:61:0x0192  */
    /* JADX WARN: Code duplicated, block: B:67:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:97:0x02a3  */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public Object load(@NotNull String str, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        String str2;
        String str3;
        Document document;
        Element elementSelectFirst;
        Element elementSelectFirst2;
        String strText;
        String strSubstringBefore$default;
        String string;
        Element elementSelectFirst3;
        String strAttr;
        String strFixUrlNull;
        String string2;
        boolean z;
        String str4;
        String strText2;
        boolean z2;
        String str5;
        MatchResult matchResultFind$default;
        Object intOrNull;
        Integer num;
        boolean zContainsMatchIn;
        Elements elementsSelect;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        Object obj;
        Elements elements;
        final int iIntValue;
        Episode episodeNewEpisode;
        List groupValues;
        Integer intOrNull2;
        List groupValues2;
        String str12;
        Integer intOrNull3;
        String value;
        Element elementSelectFirst4;
        String strText3;
        String strText4;
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
        Object objNewMovieLoadResponse = c00012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00012.label) {
            case 0:
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                try {
                    Requests app = MainActivityKt.getApp();
                    c00012.L$0 = str;
                    c00012.label = 1;
                    str2 = null;
                    try {
                        objNewMovieLoadResponse = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                        c00012 = c00012;
                        if (objNewMovieLoadResponse == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str3 = str;
                        try {
                            document = ((NiceResponse) objNewMovieLoadResponse).getDocument();
                            elementSelectFirst = document.selectFirst("h2");
                            if (elementSelectFirst != null || (strText4 = elementSelectFirst.text()) == null || (string = StringsKt.trim(strText4).toString()) == null) {
                                elementSelectFirst2 = document.selectFirst("title");
                                if (elementSelectFirst2 != null || (strText = elementSelectFirst2.text()) == null || (strSubstringBefore$default = StringsKt.substringBefore$default(strText, "-", str2, 2, str2)) == null) {
                                    return null;
                                }
                                string = StringsKt.trim(strSubstringBefore$default).toString();
                            }
                            MoviezwapProvider moviezwapProvider = this;
                            elementSelectFirst3 = document.selectFirst("img[src*='/poster/']");
                            if (elementSelectFirst3 != null) {
                                strAttr = elementSelectFirst3.attr("src");
                            } else {
                                strAttr = str2;
                            }
                            strFixUrlNull = MainAPIKt.fixUrlNull(moviezwapProvider, strAttr);
                            string2 = StringsKt.trim(document.select("td:contains(Desc/Plot) + td").text()).toString();
                            if (string2.length() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                elementSelectFirst4 = document.selectFirst("p");
                                if (elementSelectFirst4 != null || (strText3 = elementSelectFirst4.text()) == null) {
                                    string2 = str2;
                                } else {
                                    string2 = StringsKt.trim(strText3).toString();
                                }
                            }
                            str4 = string2;
                            strText2 = document.select("td:contains(Release Date) + td").text();
                            if (strText2.length() == 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                strText2 = document.select("td:contains(Category) + td").text();
                            }
                            str5 = strText2;
                            matchResultFind$default = Regex.find$default(new Regex("(\\d{4})"), str5, 0, 2, str2);
                            if (matchResultFind$default != null || (value = matchResultFind$default.getValue()) == null) {
                                intOrNull = str2;
                            } else {
                                intOrNull = StringsKt.toIntOrNull(value);
                            }
                            num = intOrNull;
                            zContainsMatchIn = new Regex("(?i)(season|episodes?|eps|all episodes|web series)").containsMatchIn(string);
                            elementsSelect = document.select("div.catList a[href*='/movie/']");
                            if (zContainsMatchIn || ((Collection) elementsSelect).isEmpty()) {
                                str6 = string;
                                TvType tvType = TvType.Movie;
                                C00033 c00033 = new C00033(strFixUrlNull, num, str4, null);
                                c00012.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                                c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
                                c00012.L$2 = SpillingKt.nullOutSpilledVariable(str6);
                                c00012.L$3 = SpillingKt.nullOutSpilledVariable(strFixUrlNull);
                                c00012.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                                c00012.L$5 = SpillingKt.nullOutSpilledVariable(str5);
                                c00012.L$6 = SpillingKt.nullOutSpilledVariable(num);
                                c00012.L$7 = SpillingKt.nullOutSpilledVariable(elementsSelect);
                                c00012.Z$0 = zContainsMatchIn;
                                c00012.label = 3;
                                objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str6, str3, tvType, str3, c00033, c00012);
                                if (objNewMovieLoadResponse == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                str7 = strFixUrlNull;
                                str8 = str4;
                                str9 = str5;
                                str10 = str6;
                                str11 = str3;
                                obj = num;
                                elements = elementsSelect;
                                return (LoadResponse) objNewMovieLoadResponse;
                            }
                            Collection<Element> collection = (Iterable) elementsSelect;
                            int i = 0;
                            ArrayList arrayList = new ArrayList();
                            for (Element element : collection) {
                                final String string3 = StringsKt.trim(element.text()).toString();
                                String str13 = string;
                                String strFixUrl = MainAPIKt.fixUrl(this, element.attr("href"));
                                String str14 = str3;
                                Collection collection2 = collection;
                                int i2 = i;
                                MatchResult matchResultFind$default2 = Regex.find$default(new Regex("Season\\s*(\\d+)", RegexOption.IGNORE_CASE), string3, 0, 2, (Object) null);
                                MatchResult matchResultFind$default3 = Regex.find$default(new Regex("Eps?\\s*\\(?(\\d+)(?:\\s*to\\s*(\\d+))?\\)?", RegexOption.IGNORE_CASE), string3, 0, 2, (Object) null);
                                final int iIntValue2 = (matchResultFind$default2 == null || (groupValues2 = matchResultFind$default2.getGroupValues()) == null || (str12 = (String) groupValues2.get(1)) == null || (intOrNull3 = StringsKt.toIntOrNull(str12)) == null) ? 1 : intOrNull3.intValue();
                                if (matchResultFind$default3 != null && (groupValues = matchResultFind$default3.getGroupValues()) != null) {
                                    String str15 = (String) groupValues.get(1);
                                    if (str15 != null && (intOrNull2 = StringsKt.toIntOrNull(str15)) != null) {
                                        iIntValue = intOrNull2.intValue();
                                    }
                                    episodeNewEpisode = MainAPIKt.newEpisode(this, strFixUrl, new Function1() { // from class: com.cncverse.MoviezwapProvider$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj2) {
                                            return MoviezwapProvider.load$lambda$2$0(string3, iIntValue2, iIntValue, (Episode) obj2);
                                        }
                                    });
                                    if (episodeNewEpisode != null) {
                                        arrayList.add(episodeNewEpisode);
                                    }
                                    string = str13;
                                    collection = collection2;
                                    str3 = str14;
                                    i = i2;
                                }
                                iIntValue = 1;
                                episodeNewEpisode = MainAPIKt.newEpisode(this, strFixUrl, new Function1() { // from class: com.cncverse.MoviezwapProvider$$ExternalSyntheticLambda1
                                    public final Object invoke(Object obj2) {
                                        return MoviezwapProvider.load$lambda$2$0(string3, iIntValue2, iIntValue, (Episode) obj2);
                                    }
                                });
                                if (episodeNewEpisode != null) {
                                    arrayList.add(episodeNewEpisode);
                                }
                                string = str13;
                                collection = collection2;
                                str3 = str14;
                                i = i2;
                            }
                            String str16 = string;
                            ArrayList arrayList2 = arrayList;
                            TvType tvType2 = TvType.TvSeries;
                            C00022 c00022 = new C00022(strFixUrlNull, num, str4, null);
                            c00012.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                            c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
                            c00012.L$2 = SpillingKt.nullOutSpilledVariable(str16);
                            c00012.L$3 = SpillingKt.nullOutSpilledVariable(strFixUrlNull);
                            c00012.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                            c00012.L$5 = SpillingKt.nullOutSpilledVariable(str5);
                            c00012.L$6 = SpillingKt.nullOutSpilledVariable(num);
                            c00012.L$7 = SpillingKt.nullOutSpilledVariable(elementsSelect);
                            c00012.L$8 = SpillingKt.nullOutSpilledVariable(arrayList2);
                            c00012.Z$0 = zContainsMatchIn;
                            c00012.label = 2;
                            objNewMovieLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, str16, str3, tvType2, arrayList2, c00022, c00012);
                            return objNewMovieLoadResponse == coroutine_suspended ? coroutine_suspended : (LoadResponse) objNewMovieLoadResponse;
                        } catch (Exception e) {
                            e = e;
                            Log.e("MoviezwapProvider", "Error loading movie: " + e.getMessage());
                            return null;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        Log.e("MoviezwapProvider", "Error loading movie: " + e.getMessage());
                        return null;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                break;
            case 1:
                String str17 = (String) c00012.L$0;
                try {
                    ResultKt.throwOnFailure(objNewMovieLoadResponse);
                    str3 = str17;
                    str2 = null;
                    document = ((NiceResponse) objNewMovieLoadResponse).getDocument();
                    elementSelectFirst = document.selectFirst("h2");
                    if (elementSelectFirst != null) {
                        elementSelectFirst2 = document.selectFirst("title");
                        if (elementSelectFirst2 != null) {
                            return null;
                        }
                        return null;
                    }
                    elementSelectFirst2 = document.selectFirst("title");
                    if (elementSelectFirst2 != null) {
                        return null;
                    }
                    return null;
                    MoviezwapProvider moviezwapProvider2 = this;
                    elementSelectFirst3 = document.selectFirst("img[src*='/poster/']");
                    if (elementSelectFirst3 != null) {
                        strAttr = elementSelectFirst3.attr("src");
                    } else {
                        strAttr = str2;
                    }
                    strFixUrlNull = MainAPIKt.fixUrlNull(moviezwapProvider2, strAttr);
                    string2 = StringsKt.trim(document.select("td:contains(Desc/Plot) + td").text()).toString();
                    if (string2.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        elementSelectFirst4 = document.selectFirst("p");
                        if (elementSelectFirst4 != null) {
                            string2 = str2;
                        } else {
                            string2 = str2;
                        }
                    }
                    str4 = string2;
                    strText2 = document.select("td:contains(Release Date) + td").text();
                    if (strText2.length() == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        strText2 = document.select("td:contains(Category) + td").text();
                    }
                    str5 = strText2;
                    matchResultFind$default = Regex.find$default(new Regex("(\\d{4})"), str5, 0, 2, str2);
                    if (matchResultFind$default != null) {
                        intOrNull = str2;
                    } else {
                        intOrNull = str2;
                    }
                    num = intOrNull;
                    zContainsMatchIn = new Regex("(?i)(season|episodes?|eps|all episodes|web series)").containsMatchIn(string);
                    elementsSelect = document.select("div.catList a[href*='/movie/']");
                    if (zContainsMatchIn) {
                        break;
                    }
                    str6 = string;
                    TvType tvType3 = TvType.Movie;
                    C00033 c00034 = new C00033(strFixUrlNull, num, str4, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(str6);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(strFixUrlNull);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(str5);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(num);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(elementsSelect);
                    c00012.Z$0 = zContainsMatchIn;
                    c00012.label = 3;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str6, str3, tvType3, str3, c00034, c00012);
                    if (objNewMovieLoadResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str7 = strFixUrlNull;
                    str8 = str4;
                    str9 = str5;
                    str10 = str6;
                    str11 = str3;
                    obj = num;
                    elements = elementsSelect;
                    return (LoadResponse) objNewMovieLoadResponse;
                } catch (Exception e4) {
                    e = e4;
                    Log.e("MoviezwapProvider", "Error loading movie: " + e.getMessage());
                    return null;
                }
            case 2:
                boolean z3 = c00012.Z$0;
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
            case 3:
                boolean z4 = c00012.Z$0;
                elements = (Elements) c00012.L$7;
                Object obj2 = (Integer) c00012.L$6;
                str9 = (String) c00012.L$5;
                str8 = (String) c00012.L$4;
                str7 = (String) c00012.L$3;
                str10 = (String) c00012.L$2;
                document = (Document) c00012.L$1;
                str11 = (String) c00012.L$0;
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                obj = obj2;
                return (LoadResponse) objNewMovieLoadResponse;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$2$0(String $episodeTitle, int $season, int $epStart, Episode $this$newEpisode) {
        $this$newEpisode.setName($episodeTitle);
        $this$newEpisode.setSeason(Integer.valueOf($season));
        $this$newEpisode.setEpisode(Integer.valueOf($epStart));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.cncverse.MoviezwapProvider$load$2 */
    /* JADX INFO: compiled from: MoviezwapProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MoviezwapProvider$load$2", f = "MoviezwapProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00022 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00022(String str, Integer num, String str2, Continuation<? super C00022> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$year = num;
            this.$description = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00022 = new C00022(this.$poster, this.$year, this.$description, continuation);
            c00022.L$0 = obj;
            return c00022;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            TvSeriesLoadResponse $this$newTvSeriesLoadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newTvSeriesLoadResponse.setPosterUrl(this.$poster);
                    $this$newTvSeriesLoadResponse.setYear(this.$year);
                    $this$newTvSeriesLoadResponse.setPlot(this.$description);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MoviezwapProvider$load$3 */
    /* JADX INFO: compiled from: MoviezwapProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MoviezwapProvider$load$3", f = "MoviezwapProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00033 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00033(String str, Integer num, String str2, Continuation<? super C00033> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$year = num;
            this.$description = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00033 = new C00033(this.$poster, this.$year, this.$description, continuation);
            c00033.L$0 = obj;
            return c00033;
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
                    $this$newMovieLoadResponse.setYear(this.$year);
                    $this$newMovieLoadResponse.setPlot(this.$description);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x051a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:105:0x051b  */
    /* JADX WARN: Code duplicated, block: B:66:0x0293  */
    /* JADX WARN: Code duplicated, block: B:68:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:69:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:71:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:72:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:74:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:75:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:77:0x0301  */
    /* JADX WARN: Code duplicated, block: B:78:0x0308  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x0315  */
    /* JADX WARN: Code duplicated, block: B:81:0x0318  */
    /* JADX WARN: Code duplicated, block: B:87:0x03a2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:88:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:91:0x03d0 A[Catch: Exception -> 0x03ec, TRY_LEAVE, TryCatch #1 {Exception -> 0x03ec, blocks: (B:89:0x03c2, B:91:0x03d0), top: B:119:0x03c2 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x03d6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x051b -> B:106:0x0538). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r41, boolean r42, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r43, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r44, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r45) {
        /*
            Method dump skipped, instruction units count: 1446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.MoviezwapProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadLinks$lambda$0$0(Context $_ctx) {
        Toast.makeText($_ctx, "⚠️(Opening ads) Subscription expired. If you have renewed your subscription, please re-verify it in Subscription Manager.", 1).show();
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
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.MoviezwapProvider$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MoviezwapProvider.showSubscriptionPopupIfNeeded$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.MoviezwapProvider$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MoviezwapProvider.showSubscriptionPopupIfNeeded$lambda$0$11($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249, $ctx, dialog, view);
                }
            });
            subscribeTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.MoviezwapProvider$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MoviezwapProvider.showSubscriptionPopupIfNeeded$lambda$0$12(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.MoviezwapProvider$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                MoviezwapProvider.showTelegramPopup$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.MoviezwapProvider$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            joinTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.MoviezwapProvider$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MoviezwapProvider.showTelegramPopup$lambda$0$9(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.MoviezwapProvider$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                MoviezwapProvider.openInExternalBrowser$lambda$0(ctx, url);
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
