package com.cncverse.desiserials;

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
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.ui.settings.Globals;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
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
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: DesiSerialsProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/DesiSerialsProvider/classes.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 B2\u00020\u0001:\u0001BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u0004\u0018\u00010'*\u00020(H\u0002J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u001c2\u0006\u0010*\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+J\u0018\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+J>\u0010/\u001a\b\u0012\u0004\u0012\u0002H00\u001c\"\u0004\b\u0000\u00101\"\b\b\u0001\u00100*\u000202*\b\u0012\u0004\u0012\u0002H1032\u0014\u00104\u001a\u0010\u0012\u0004\u0012\u0002H1\u0012\u0006\u0012\u0004\u0018\u0001H005H\u0002JF\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u000e2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;052\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020;05H\u0096@¢\u0006\u0002\u0010>J\b\u0010?\u001a\u00020;H\u0002J\b\u0010@\u001a\u00020;H\u0002J\u0010\u0010A\u001a\u00020;2\u0006\u0010.\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006C"}, d2 = {"Lcom/cncverse/desiserials/DesiSerialsProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "mapNotBlank", "R", "T", "", "", "transform", "Lkotlin/Function1;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showSubscriptionPopupIfNeeded", "showTelegramPopup", "openInExternalBrowser", "Companion", "DesiSerialsProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDesiSerialsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DesiSerialsProvider.kt\ncom/cncverse/desiserials/DesiSerialsProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,718:1\n1642#2,10:719\n1915#2:729\n1916#2:731\n1652#2:732\n1586#2:734\n1661#2,3:735\n1642#2,10:738\n1915#2:748\n1916#2:750\n1652#2:751\n1915#2,2:752\n1642#2,10:754\n1915#2:764\n1916#2:766\n1652#2:767\n1586#2:768\n1661#2,3:769\n1642#2,10:773\n1915#2:783\n1916#2:785\n1652#2:786\n777#2:787\n873#2,2:788\n1586#2:790\n1661#2,3:791\n1586#2:794\n1661#2,3:795\n777#2:798\n873#2,2:799\n1915#2,2:801\n1586#2:822\n1661#2,3:823\n1915#2:826\n1915#2,2:827\n1915#2,2:829\n1915#2,2:831\n1915#2,2:833\n1916#2:835\n1915#2,2:836\n1#3:730\n1#3:733\n1#3:749\n1#3:765\n1#3:772\n1#3:784\n1#3:804\n1#3:838\n63#4:803\n64#4,15:805\n50#5:820\n43#5:821\n*S KotlinDebug\n*F\n+ 1 DesiSerialsProvider.kt\ncom/cncverse/desiserials/DesiSerialsProvider\n*L\n96#1:719,10\n96#1:729\n96#1:731\n96#1:732\n136#1:734\n136#1:735,3\n164#1:738,10\n164#1:748\n164#1:750\n164#1:751\n164#1:752,2\n195#1:754,10\n195#1:764\n195#1:766\n195#1:767\n197#1:768\n197#1:769,3\n244#1:773,10\n244#1:783\n244#1:785\n244#1:786\n244#1:787\n244#1:788,2\n448#1:790\n448#1:791,3\n449#1:794\n449#1:795,3\n449#1:798\n449#1:799,2\n455#1:801,2\n289#1:822\n289#1:823,3\n292#1:826\n317#1:827,2\n336#1:829,2\n365#1:831,2\n394#1:833,2\n292#1:835\n424#1:836,2\n96#1:730\n164#1:749\n195#1:765\n244#1:784\n463#1:804\n463#1:803\n463#1:805,15\n463#1:820\n463#1:821\n*E\n"})
public final class DesiSerialsProvider extends MainAPI {
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
    private String mainUrl = "https://www.desi-serials.to";

    @NotNull
    private String name = "DesiSerials";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "hi";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.TvSeries);

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("latest-episodes", "Latest Episodes"), TuplesKt.to("star-plus-hdepisodes", "Star Plus"), TuplesKt.to("color-tv-hd", "Colors TV"), TuplesKt.to("zee-tv", "Zee TV"), TuplesKt.to("sony-tv", "Sony TV"), TuplesKt.to("sab-tv-hd", "Sab TV"), TuplesKt.to("and-tv", "& TV"), TuplesKt.to("star-bharat", "Star Bharat")});

    /* JADX INFO: renamed from: com.cncverse.desiserials.DesiSerialsProvider$getMainPage$1 */
    /* JADX INFO: compiled from: DesiSerialsProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.desiserials.DesiSerialsProvider", f = "DesiSerialsProvider.kt", i = {0, 0, 0}, l = {85}, m = "getMainPage", n = {"request", "url", "page"}, nl = {88}, s = {"L$0", "L$1", "I$0"}, v = 2)
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
            return DesiSerialsProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.desiserials.DesiSerialsProvider$load$1 */
    /* JADX INFO: compiled from: DesiSerialsProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.desiserials.DesiSerialsProvider", f = "DesiSerialsProvider.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {178, 202, 237}, m = "load", n = {"url", "url", "doc", "title", "posterRegex", "posterRaw", "poster", "episodes", "pages", "maxPage", "url", "doc", "title", "posterRegex", "posterRaw", "poster", "episodes", "pages", "maxPage"}, nl = {181, 222, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DesiSerialsProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.desiserials.DesiSerialsProvider$loadLinks$1 */
    /* JADX INFO: compiled from: DesiSerialsProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.desiserials.DesiSerialsProvider", f = "DesiSerialsProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {445, 457, 464}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "doc", "iframes", "aLinks", "allLinks", "$this$forEach$iv", "element$iv", "it", "isCasting", "$i$f$forEach", "$i$a$-forEach-DesiSerialsProvider$loadLinks$3", "data", "subtitleCallback", "callback", "links", "isCasting"}, nl = {447, 458, 467}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$10;
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
            return DesiSerialsProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.desiserials.DesiSerialsProvider$search$1 */
    /* JADX INFO: compiled from: DesiSerialsProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.desiserials.DesiSerialsProvider", f = "DesiSerialsProvider.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {137, 159}, m = "search", n = {"query", "queryLower", "seenUrls", "results", "homePageSlugs", "query", "queryLower", "seenUrls", "results", "homePageSlugs", "encodedQuery", "searchUrl"}, nl = {156, 162}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DesiSerialsProvider.this.search(null, (Continuation) this);
        }
    }

    /* JADX INFO: compiled from: DesiSerialsProvider.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/cncverse/desiserials/DesiSerialsProvider$Companion;", "", "<init>", "()V", "isCsGuardActive", "", "csGuardWasEverActive", "isCsGuardBlocked", "showCsGuardToast", "", "ctx", "Landroid/content/Context;", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "OMG10", "", "lastBrowserOpenMs", "", "telegramPopupShown", "subscriptionPopupShown", "BROWSER_DEBOUNCE_MS", "DesiSerialsProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nDesiSerialsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DesiSerialsProvider.kt\ncom/cncverse/desiserials/DesiSerialsProvider$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,718:1\n1#2:719\n*E\n"})
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
                DesiSerialsProvider.csGuardWasEverActive = true;
            }
            return DesiSerialsProvider.csGuardWasEverActive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCsGuardToast(final Context ctx) {
            if (ctx == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.desiserials.DesiSerialsProvider$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DesiSerialsProvider.Companion.showCsGuardToast$lambda$0(ctx);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showCsGuardToast$lambda$0(Context $c) {
            Toast.makeText($c, "🚫 CSGuard detected — Restart CloudStream after removing CSGuard to use CNCRepo", 1).show();
        }

        @Nullable
        public final Context getContext() {
            return DesiSerialsProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            DesiSerialsProvider.context = context;
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

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        MainPageRequest request2;
        String url;
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
                String url2 = page == 1 ? getMainUrl() + '/' + request.getData() + '/' : getMainUrl() + '/' + request.getData() + "/page/" + page + '/';
                Requests app = MainActivityKt.getApp();
                Map mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"), TuplesKt.to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8")});
                c00001.L$0 = request;
                c00001.L$1 = url2;
                c00001.I$0 = page;
                c00001.label = 1;
                String url3 = url2;
                $result = Requests.get$default(app, url3, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4092, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                url = url3;
                break;
                break;
            case 1:
                int i = c00001.I$0;
                String url4 = (String) c00001.L$1;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                url = url4;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Log.d("DesiSerials", "getMainPage url=" + url + " title=" + document.title());
        Iterable iterableSelect = document.select("article.type-post, article.post-grid, .porto-sicon-wrapper, li.cat-item");
        Log.d("DesiSerials", "getMainPage posts=" + iterableSelect.size());
        Iterable $this$mapNotNull$iv = iterableSelect;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List home = CollectionsKt.toMutableList((List) destination$iv$iv);
        Log.d("DesiSerials", "getMainPage home=" + home.size());
        if (home.isEmpty()) {
            String strTitle = document.title();
            if (StringsKt.isBlank(strTitle)) {
                strTitle = "No Title";
            }
            String docTitle = strTitle;
            String firstText = StringsKt.take(document.text(), 50);
            home.add(MainAPIKt.newTvSeriesSearchResponse$default(this, "Debug: " + docTitle + " | " + firstText, url, TvType.TvSeries, false, new Function1() { // from class: com.cncverse.desiserials.DesiSerialsProvider$$ExternalSyntheticLambda12
                public final Object invoke(Object obj) {
                    return DesiSerialsProvider.getMainPage$lambda$2((TvSeriesSearchResponse) obj);
                }
            }, 8, (Object) null));
        }
        return MainAPIKt.newHomePageResponse(CollectionsKt.arrayListOf(new HomePageList[]{new HomePageList(request2.getName(), home, true)}), Boxing.boxBoolean(!home.isEmpty()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$2(TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SearchResponse toSearchResult(Element $this$toSearchResult) {
        Element titleElement = $this$toSearchResult.selectFirst("h3.thumb-info-inner a, h2.entry-title a, h5 a.porto-sicon-title-link, h3.porto-post-title a");
        if (titleElement == null && (titleElement = $this$toSearchResult.selectFirst("a")) == null) {
            return null;
        }
        String it = StringsKt.trim(titleElement.text()).toString();
        if (StringsKt.isBlank(it)) {
            it = null;
        }
        if (it == null) {
            it = StringsKt.trim(titleElement.attr("title")).toString();
            if (StringsKt.isBlank(it)) {
                it = null;
            }
            if (it == null) {
                it = "Unknown Series";
            }
        }
        String title = it;
        String href = MainAPIKt.fixUrl(this, titleElement.attr("href"));
        Element imgElement = $this$toSearchResult.selectFirst("div.post-image img, span.post-image img");
        if (imgElement == null) {
            imgElement = $this$toSearchResult.selectFirst("img");
        }
        final Ref.ObjectRef posterUrl = new Ref.ObjectRef();
        posterUrl.element = imgElement != null ? imgElement.attr("data-oi") : null;
        CharSequence charSequence = (CharSequence) posterUrl.element;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            posterUrl.element = imgElement != null ? imgElement.attr("src") : null;
        }
        posterUrl.element = MainAPIKt.fixUrlNull(this, (String) posterUrl.element);
        return MainAPIKt.newTvSeriesSearchResponse$default(this, title, href, TvType.TvSeries, false, new Function1() { // from class: com.cncverse.desiserials.DesiSerialsProvider$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return DesiSerialsProvider.toSearchResult$lambda$2(posterUrl, this, (TvSeriesSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toSearchResult$lambda$2(Ref.ObjectRef $posterUrl, DesiSerialsProvider this$0, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl((String) $posterUrl.element);
        $this$newTvSeriesSearchResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("referer", this$0.getMainUrl() + '/')));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x01d8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:40:0x0208 A[Catch: Exception -> 0x025f, TryCatch #0 {Exception -> 0x025f, blocks: (B:37:0x01e0, B:38:0x0202, B:40:0x0208, B:42:0x0222, B:44:0x022c, B:45:0x023b, B:47:0x0241, B:49:0x0255), top: B:60:0x01e0 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0222 A[Catch: Exception -> 0x025f, TryCatch #0 {Exception -> 0x025f, blocks: (B:37:0x01e0, B:38:0x0202, B:40:0x0208, B:42:0x0222, B:44:0x022c, B:45:0x023b, B:47:0x0241, B:49:0x0255), top: B:60:0x01e0 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0241 A[Catch: Exception -> 0x025f, TryCatch #0 {Exception -> 0x025f, blocks: (B:37:0x01e0, B:38:0x0202, B:40:0x0208, B:42:0x0222, B:44:0x022c, B:45:0x023b, B:47:0x0241, B:49:0x0255), top: B:60:0x01e0 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0255 A[Catch: Exception -> 0x025f, TRY_LEAVE, TryCatch #0 {Exception -> 0x025f, blocks: (B:37:0x01e0, B:38:0x0202, B:40:0x0208, B:42:0x0222, B:44:0x022c, B:45:0x023b, B:47:0x0241, B:49:0x0255), top: B:60:0x01e0 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0229 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0258 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00061 c00061;
        ArrayList results;
        String query2;
        String queryLower;
        Set seenUrls;
        List homePageSlugs;
        String searchUrl;
        Object obj;
        String searchUrl2;
        Set seenUrls2;
        Collection destination$iv$iv;
        Iterable $this$forEach$iv;
        SearchResponse item;
        SearchResponse searchResult;
        if (continuation instanceof C00061) {
            c00061 = (C00061) continuation;
            if ((c00061.label & Integer.MIN_VALUE) != 0) {
                c00061.label -= Integer.MIN_VALUE;
            } else {
                c00061 = new C00061(continuation);
            }
        } else {
            c00061 = new C00061(continuation);
        }
        C00061 c00062 = c00061;
        Object $result = c00062.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00062.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return CollectionsKt.emptyList();
                }
                String queryLower2 = StringsKt.trim(query).toString().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(queryLower2, "toLowerCase(...)");
                Set seenUrls3 = new LinkedHashSet();
                results = new ArrayList();
                Iterable $this$map$iv = getMainPage();
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    MainPageData it = (MainPageData) item$iv$iv;
                    destination$iv$iv2.add(it.getData());
                }
                List homePageSlugs2 = (List) destination$iv$iv2;
                C00072 c00072 = new C00072(queryLower2, seenUrls3, results, null);
                c00062.L$0 = query;
                c00062.L$1 = SpillingKt.nullOutSpilledVariable(queryLower2);
                c00062.L$2 = seenUrls3;
                c00062.L$3 = results;
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(homePageSlugs2);
                c00062.label = 1;
                if (ParCollectionsKt.amap(homePageSlugs2, c00072, c00062) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                query2 = query;
                queryLower = queryLower2;
                seenUrls = seenUrls3;
                homePageSlugs = homePageSlugs2;
                try {
                    String encodedQuery = StringsKt.replace$default(StringsKt.trim(query2).toString(), " ", "+", false, 4, (Object) null).toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(encodedQuery, "toLowerCase(...)");
                    searchUrl = getMainUrl() + "/?s=" + encodedQuery;
                    Requests app = MainActivityKt.getApp();
                    Map mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"), TuplesKt.to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8")});
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(queryLower);
                    c00062.L$2 = seenUrls;
                    c00062.L$3 = results;
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(homePageSlugs);
                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(encodedQuery);
                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(searchUrl);
                    c00062.label = 2;
                    try {
                        obj = Requests.get$default(app, searchUrl, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 4092, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        searchUrl2 = searchUrl;
                        $result = obj;
                        seenUrls2 = seenUrls;
                        try {
                            Document document = ((NiceResponse) $result).getDocument();
                            Iterable $this$mapNotNull$iv = document.select("div.post-item, article.type-post, article.post-grid, article.post");
                            destination$iv$iv = new ArrayList();
                            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                Element it2 = (Element) element$iv$iv$iv;
                                String searchUrl3 = searchUrl2;
                                searchResult = toSearchResult(it2);
                                if (searchResult != null) {
                                    destination$iv$iv.add(searchResult);
                                }
                                searchUrl2 = searchUrl3;
                            }
                            $this$forEach$iv = (List) destination$iv$iv;
                            for (Object element$iv : $this$forEach$iv) {
                                item = (SearchResponse) element$iv;
                                Iterable $this$forEach$iv2 = $this$forEach$iv;
                                if (seenUrls2.add(item.getUrl())) {
                                    results.add(item);
                                }
                                $this$forEach$iv = $this$forEach$iv2;
                                break;
                            }
                        } catch (Exception e) {
                            e = e;
                            Log.d("DesiSerials", "search endpoint error: " + e.getMessage());
                        }
                        return results;
                    } catch (Exception e2) {
                        e = e2;
                        Log.d("DesiSerials", "search endpoint error: " + e.getMessage());
                        return results;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                break;
            case 1:
                List homePageSlugs3 = (List) c00062.L$4;
                List results2 = (List) c00062.L$3;
                Set seenUrls4 = (Set) c00062.L$2;
                String queryLower3 = (String) c00062.L$1;
                query2 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                queryLower = queryLower3;
                results = results2;
                seenUrls = seenUrls4;
                homePageSlugs = homePageSlugs3;
                String encodedQuery2 = StringsKt.replace$default(StringsKt.trim(query2).toString(), " ", "+", false, 4, (Object) null).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(encodedQuery2, "toLowerCase(...)");
                searchUrl = getMainUrl() + "/?s=" + encodedQuery2;
                Requests app2 = MainActivityKt.getApp();
                Map mapMapOf2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"), TuplesKt.to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8")});
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00062.L$1 = SpillingKt.nullOutSpilledVariable(queryLower);
                c00062.L$2 = seenUrls;
                c00062.L$3 = results;
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(homePageSlugs);
                c00062.L$5 = SpillingKt.nullOutSpilledVariable(encodedQuery2);
                c00062.L$6 = SpillingKt.nullOutSpilledVariable(searchUrl);
                c00062.label = 2;
                obj = Requests.get$default(app2, searchUrl, mapMapOf2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 4092, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                searchUrl2 = searchUrl;
                $result = obj;
                seenUrls2 = seenUrls;
                Document document2 = ((NiceResponse) $result).getDocument();
                Iterable $this$mapNotNull$iv2 = document2.select("div.post-item, article.type-post, article.post-grid, article.post");
                destination$iv$iv = new ArrayList();
                while (r18.hasNext()) {
                    Element it3 = (Element) element$iv$iv$iv;
                    String searchUrl4 = searchUrl2;
                    searchResult = toSearchResult(it3);
                    if (searchResult != null) {
                        destination$iv$iv.add(searchResult);
                    }
                    searchUrl2 = searchUrl4;
                }
                $this$forEach$iv = (List) destination$iv$iv;
                while (r12.hasNext()) {
                    item = (SearchResponse) element$iv;
                    Iterable $this$forEach$iv3 = $this$forEach$iv;
                    if (seenUrls2.add(item.getUrl())) {
                        results.add(item);
                    }
                    $this$forEach$iv = $this$forEach$iv3;
                    break;
                }
                return results;
            case 2:
                searchUrl2 = (String) c00062.L$6;
                results = (List) c00062.L$3;
                seenUrls2 = (Set) c00062.L$2;
                try {
                    ResultKt.throwOnFailure($result);
                    Document document3 = ((NiceResponse) $result).getDocument();
                    Iterable $this$mapNotNull$iv3 = document3.select("div.post-item, article.type-post, article.post-grid, article.post");
                    destination$iv$iv = new ArrayList();
                    while (r18.hasNext()) {
                        Element it4 = (Element) element$iv$iv$iv;
                        String searchUrl5 = searchUrl2;
                        searchResult = toSearchResult(it4);
                        if (searchResult != null) {
                            destination$iv$iv.add(searchResult);
                        }
                        searchUrl2 = searchUrl5;
                    }
                    $this$forEach$iv = (List) destination$iv$iv;
                    while (r12.hasNext()) {
                        item = (SearchResponse) element$iv;
                        Iterable $this$forEach$iv4 = $this$forEach$iv;
                        if (seenUrls2.add(item.getUrl())) {
                            results.add(item);
                        }
                        $this$forEach$iv = $this$forEach$iv4;
                        break;
                    }
                } catch (Exception e4) {
                    e = e4;
                    Log.d("DesiSerials", "search endpoint error: " + e.getMessage());
                    return results;
                }
                return results;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.cncverse.desiserials.DesiSerialsProvider$search$2 */
    /* JADX INFO: compiled from: DesiSerialsProvider.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "slug", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.desiserials.DesiSerialsProvider$search$2", f = "DesiSerialsProvider.kt", i = {0, 0}, l = {140}, m = "invokeSuspend", n = {"slug", "url"}, nl = {143}, s = {"L$0", "L$1"}, v = 2)
    @SourceDebugExtension({"SMAP\nDesiSerialsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DesiSerialsProvider.kt\ncom/cncverse/desiserials/DesiSerialsProvider$search$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,718:1\n1642#2,10:719\n1915#2:729\n1916#2:731\n1652#2:732\n1915#2:733\n1916#2:735\n1#3:730\n1#3:734\n*S KotlinDebug\n*F\n+ 1 DesiSerialsProvider.kt\ncom/cncverse/desiserials/DesiSerialsProvider$search$2\n*L\n145#1:719,10\n145#1:729\n145#1:731\n145#1:732\n145#1:733\n145#1:735\n145#1:730\n*E\n"})
    static final class C00072 extends SuspendLambda implements Function2<String, Continuation<? super Object>, Object> {
        final /* synthetic */ String $queryLower;
        final /* synthetic */ List<SearchResponse> $results;
        final /* synthetic */ Set<String> $seenUrls;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00072(String str, Set<String> set, List<SearchResponse> list, Continuation<? super C00072> continuation) {
            super(2, continuation);
            this.$queryLower = str;
            this.$seenUrls = set;
            this.$results = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00072 = DesiSerialsProvider.this.new C00072(this.$queryLower, this.$seenUrls, this.$results, continuation);
            c00072.L$0 = obj;
            return c00072;
        }

        public final Object invoke(String str, Continuation<Object> continuation) {
            return create(str, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object obj;
            String slug = (String) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String url = DesiSerialsProvider.this.getMainUrl() + '/' + slug + '/';
                        Requests app = MainActivityKt.getApp();
                        Pair[] pairArr = {TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"), TuplesKt.to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8")};
                        this.L$0 = slug;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        this.label = 1;
                        obj = Requests.get$default(app, url, MapsKt.mapOf(pairArr), (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4092, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Document document = ((NiceResponse) obj).getDocument();
                Iterable $this$mapNotNull$iv = document.select("article.type-post, article.post-grid, .porto-sicon-wrapper, li.cat-item");
                DesiSerialsProvider desiSerialsProvider = DesiSerialsProvider.this;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    Element it = (Element) element$iv$iv$iv;
                    SearchResponse searchResult = desiSerialsProvider.toSearchResult(it);
                    if (searchResult != null) {
                        destination$iv$iv.add(searchResult);
                    }
                }
                Iterable $this$forEach$iv = (List) destination$iv$iv;
                String str = this.$queryLower;
                Set<String> set = this.$seenUrls;
                List<SearchResponse> list = this.$results;
                for (Object element$iv : $this$forEach$iv) {
                    SearchResponse item = (SearchResponse) element$iv;
                    String lowerCase = item.getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    String str2 = str;
                    Document document2 = document;
                    if (StringsKt.contains$default(lowerCase, str, false, 2, (Object) null) && set.add(item.getUrl())) {
                        synchronized (list) {
                            list.add(item);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                    document = document2;
                    str = str2;
                }
                return Unit.INSTANCE;
            } catch (Exception e) {
                return Boxing.boxInt(Log.d("DesiSerials", "search home page fetch error for slug=" + slug + ": " + e.getMessage()));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x010d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0115  */
    /* JADX WARN: Code duplicated, block: B:30:0x0126  */
    /* JADX WARN: Code duplicated, block: B:32:0x012f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0140  */
    /* JADX WARN: Code duplicated, block: B:37:0x0143 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x015c  */
    /* JADX WARN: Code duplicated, block: B:48:0x017a  */
    /* JADX WARN: Code duplicated, block: B:52:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:54:0x01be  */
    /* JADX WARN: Code duplicated, block: B:58:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:59:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:62:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:65:0x0207  */
    /* JADX WARN: Code duplicated, block: B:67:0x021c  */
    /* JADX WARN: Code duplicated, block: B:68:0x021e  */
    /* JADX WARN: Code duplicated, block: B:71:0x024d  */
    /* JADX WARN: Code duplicated, block: B:74:0x028f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:75:0x0290  */
    /* JADX WARN: Code duplicated, block: B:78:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x0311 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:82:0x0312  */
    /* JADX WARN: Code duplicated, block: B:86:0x01c7 A[SYNTHETIC] */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        String url2;
        Object obj;
        String url3;
        Document doc;
        Element elementSelectFirst;
        Element elementSelectFirst2;
        Element elementSelectFirst3;
        String string;
        String strText;
        String strText2;
        String title;
        Regex posterRegex;
        Element elementSelectFirst4;
        String posterRaw;
        MatchResult matchResultFind$default;
        String poster;
        List episodes;
        Collection destination$iv$iv;
        Integer num;
        int iIntValue;
        int maxPage;
        Object obj2;
        List listListOf;
        List pages;
        String url4;
        Object obj3;
        Document doc2;
        final String poster2;
        List pages2;
        List pages3;
        Regex posterRegex2;
        String posterRaw2;
        int maxPage2;
        String url5;
        final String poster3;
        Collection destination$iv$iv2;
        Iterable $this$mapTo$iv$iv;
        IntIterator it;
        int item$iv$iv;
        String str;
        Integer intOrNull;
        String value;
        String strText3;
        Object obj4;
        Object objNewTvSeriesLoadResponse;
        DesiSerialsProvider desiSerialsProvider = this;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
            } else {
                c00011 = desiSerialsProvider.new C00011(continuation);
            }
        } else {
            c00011 = desiSerialsProvider.new C00011(continuation);
        }
        C00011 c00012 = c00011;
        Object $result = c00012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00012.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                url2 = null;
                Requests app = MainActivityKt.getApp();
                Map mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"), TuplesKt.to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8")});
                c00012.L$0 = url;
                c00012.label = 1;
                Object obj5 = Requests.get$default(app, url, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4092, (Object) null);
                c00012 = c00012;
                if (obj5 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = obj5;
                url3 = url;
                doc = ((NiceResponse) obj).getDocument();
                elementSelectFirst = doc.selectFirst("h1.page-title");
                if (elementSelectFirst != null || (strText3 = elementSelectFirst.text()) == null || (string = StringsKt.trim(strText3).toString()) == null) {
                    elementSelectFirst2 = doc.selectFirst("h2.heading-primary");
                    if (elementSelectFirst2 != null || (strText2 = elementSelectFirst2.text()) == null) {
                        elementSelectFirst3 = doc.selectFirst("h1.entry-title");
                        if (elementSelectFirst3 != null || (strText = elementSelectFirst3.text()) == null) {
                            string = url2;
                        } else {
                            string = StringsKt.trim(strText).toString();
                        }
                        if (string == null) {
                            return url2;
                        }
                    } else {
                        string = StringsKt.trim(strText2).toString();
                    }
                }
                title = string;
                posterRegex = new Regex("(https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&\\/\\/=]*jpg))");
                elementSelectFirst4 = doc.selectFirst("div.page-image img");
                if (elementSelectFirst4 != null || (posterRaw = elementSelectFirst4.attr("src")) == null) {
                    posterRaw = doc.html();
                }
                matchResultFind$default = Regex.find$default(posterRegex, posterRaw, 0, 2, url2);
                if (matchResultFind$default != null || (value = matchResultFind$default.getValue()) == null) {
                    poster = url2;
                } else {
                    poster = StringsKt.trim(value).toString();
                }
                episodes = new ArrayList();
                Iterable $this$mapNotNull$iv = doc.select("a.page-numbers");
                destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    Element it2 = (Element) element$iv$iv$iv;
                    intOrNull = StringsKt.toIntOrNull(it2.text());
                    if (intOrNull != null) {
                        destination$iv$iv.add(intOrNull);
                    }
                }
                num = (Integer) CollectionsKt.maxOrNull((List) destination$iv$iv);
                if (num != null) {
                    iIntValue = num.intValue();
                } else {
                    iIntValue = 1;
                }
                maxPage = iIntValue;
                if (maxPage > 1) {
                    Iterable $this$map$iv = new IntRange(1, maxPage);
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    $this$mapTo$iv$iv = $this$map$iv;
                    it = $this$mapTo$iv$iv.iterator();
                    while (it.hasNext()) {
                        item$iv$iv = it.nextInt();
                        Object obj6 = coroutine_suspended;
                        Iterable $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                        if (item$iv$iv == 1) {
                            str = url3;
                        } else {
                            str = url3 + "/page/" + item$iv$iv + '/';
                        }
                        destination$iv$iv2.add(str);
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                        coroutine_suspended = obj6;
                    }
                    obj2 = coroutine_suspended;
                    listListOf = (List) destination$iv$iv2;
                } else {
                    obj2 = coroutine_suspended;
                    listListOf = CollectionsKt.listOf(url3);
                }
                pages = listListOf;
                desiSerialsProvider = this;
                url4 = url3;
                obj3 = obj2;
                C00022 c00022 = new C00022(url4, doc, desiSerialsProvider, poster, null);
                c00012.L$0 = url4;
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc);
                c00012.L$2 = title;
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(posterRegex);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(posterRaw);
                c00012.L$5 = poster;
                c00012.L$6 = episodes;
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(pages);
                c00012.I$0 = maxPage;
                c00012.label = 2;
                $result = ParCollectionsKt.amap(pages, c00022, c00012);
                if ($result == obj3) {
                    return obj3;
                }
                doc2 = doc;
                poster2 = poster;
                pages2 = episodes;
                pages3 = pages;
                posterRegex2 = posterRegex;
                posterRaw2 = url4;
                maxPage2 = maxPage;
                url5 = posterRaw;
                poster3 = title;
                List it3 = CollectionsKt.flatten((Iterable) $result);
                pages2.addAll(it3);
                if (pages2.isEmpty()) {
                    pages2.add(MainAPIKt.newEpisode(desiSerialsProvider, posterRaw2, new Function1() { // from class: com.cncverse.desiserials.DesiSerialsProvider$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj7) {
                            return DesiSerialsProvider.load$lambda$3(poster3, poster2, (Episode) obj7);
                        }
                    }));
                }
                obj4 = obj3;
                TvType tvType = TvType.TvSeries;
                List listReversed = CollectionsKt.reversed(pages2);
                C00035 c00035 = new C00035(poster2, desiSerialsProvider, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(posterRaw2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc2);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(poster3);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(posterRegex2);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(url5);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(poster2);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(pages2);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(pages3);
                c00012.I$0 = maxPage2;
                c00012.label = 3;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(desiSerialsProvider, poster3, posterRaw2, tvType, listReversed, c00035, c00012);
                if (objNewTvSeriesLoadResponse == obj4) {
                    return obj4;
                }
                return objNewTvSeriesLoadResponse;
            case 1:
                String url6 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                url3 = url6;
                url2 = null;
                obj = $result;
                doc = ((NiceResponse) obj).getDocument();
                elementSelectFirst = doc.selectFirst("h1.page-title");
                if (elementSelectFirst != null) {
                    elementSelectFirst2 = doc.selectFirst("h2.heading-primary");
                    if (elementSelectFirst2 != null) {
                        elementSelectFirst3 = doc.selectFirst("h1.entry-title");
                        if (elementSelectFirst3 != null) {
                            string = url2;
                        } else {
                            string = url2;
                        }
                        if (string == null) {
                            return url2;
                        }
                    } else {
                        elementSelectFirst3 = doc.selectFirst("h1.entry-title");
                        if (elementSelectFirst3 != null) {
                            string = url2;
                        } else {
                            string = url2;
                        }
                        if (string == null) {
                            return url2;
                        }
                    }
                } else {
                    elementSelectFirst2 = doc.selectFirst("h2.heading-primary");
                    if (elementSelectFirst2 != null) {
                        elementSelectFirst3 = doc.selectFirst("h1.entry-title");
                        if (elementSelectFirst3 != null) {
                            string = url2;
                        } else {
                            string = url2;
                        }
                        if (string == null) {
                            return url2;
                        }
                    } else {
                        elementSelectFirst3 = doc.selectFirst("h1.entry-title");
                        if (elementSelectFirst3 != null) {
                            string = url2;
                        } else {
                            string = url2;
                        }
                        if (string == null) {
                            return url2;
                        }
                    }
                }
                title = string;
                posterRegex = new Regex("(https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&\\/\\/=]*jpg))");
                elementSelectFirst4 = doc.selectFirst("div.page-image img");
                if (elementSelectFirst4 != null) {
                    posterRaw = doc.html();
                } else {
                    posterRaw = doc.html();
                }
                matchResultFind$default = Regex.find$default(posterRegex, posterRaw, 0, 2, url2);
                if (matchResultFind$default != null) {
                    poster = url2;
                } else {
                    poster = url2;
                }
                episodes = new ArrayList();
                Iterable $this$mapNotNull$iv2 = doc.select("a.page-numbers");
                destination$iv$iv = new ArrayList();
                while (r21.hasNext()) {
                    Element it4 = (Element) element$iv$iv$iv;
                    intOrNull = StringsKt.toIntOrNull(it4.text());
                    if (intOrNull != null) {
                        destination$iv$iv.add(intOrNull);
                    }
                }
                num = (Integer) CollectionsKt.maxOrNull((List) destination$iv$iv);
                if (num != null) {
                    iIntValue = num.intValue();
                } else {
                    iIntValue = 1;
                }
                maxPage = iIntValue;
                if (maxPage > 1) {
                    Iterable $this$map$iv2 = new IntRange(1, maxPage);
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    $this$mapTo$iv$iv = $this$map$iv2;
                    it = $this$mapTo$iv$iv.iterator();
                    while (it.hasNext()) {
                        item$iv$iv = it.nextInt();
                        Object obj7 = coroutine_suspended;
                        Iterable $this$mapTo$iv$iv3 = $this$mapTo$iv$iv;
                        if (item$iv$iv == 1) {
                            str = url3;
                        } else {
                            str = url3 + "/page/" + item$iv$iv + '/';
                        }
                        destination$iv$iv2.add(str);
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv3;
                        coroutine_suspended = obj7;
                    }
                    obj2 = coroutine_suspended;
                    listListOf = (List) destination$iv$iv2;
                } else {
                    obj2 = coroutine_suspended;
                    listListOf = CollectionsKt.listOf(url3);
                }
                pages = listListOf;
                desiSerialsProvider = this;
                url4 = url3;
                obj3 = obj2;
                C00022 c00023 = new C00022(url4, doc, desiSerialsProvider, poster, null);
                c00012.L$0 = url4;
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc);
                c00012.L$2 = title;
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(posterRegex);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(posterRaw);
                c00012.L$5 = poster;
                c00012.L$6 = episodes;
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(pages);
                c00012.I$0 = maxPage;
                c00012.label = 2;
                $result = ParCollectionsKt.amap(pages, c00023, c00012);
                if ($result == obj3) {
                    return obj3;
                }
                doc2 = doc;
                poster2 = poster;
                pages2 = episodes;
                pages3 = pages;
                posterRegex2 = posterRegex;
                posterRaw2 = url4;
                maxPage2 = maxPage;
                url5 = posterRaw;
                poster3 = title;
                List it5 = CollectionsKt.flatten((Iterable) $result);
                pages2.addAll(it5);
                if (pages2.isEmpty()) {
                    pages2.add(MainAPIKt.newEpisode(desiSerialsProvider, posterRaw2, new Function1() { // from class: com.cncverse.desiserials.DesiSerialsProvider$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj8) {
                            return DesiSerialsProvider.load$lambda$3(poster3, poster2, (Episode) obj8);
                        }
                    }));
                }
                obj4 = obj3;
                TvType tvType2 = TvType.TvSeries;
                List listReversed2 = CollectionsKt.reversed(pages2);
                C00035 c00036 = new C00035(poster2, desiSerialsProvider, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(posterRaw2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc2);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(poster3);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(posterRegex2);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(url5);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(poster2);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(pages2);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(pages3);
                c00012.I$0 = maxPage2;
                c00012.label = 3;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(desiSerialsProvider, poster3, posterRaw2, tvType2, listReversed2, c00036, c00012);
                if (objNewTvSeriesLoadResponse == obj4) {
                    return obj4;
                }
                return objNewTvSeriesLoadResponse;
            case 2:
                int maxPage3 = c00012.I$0;
                List pages4 = (List) c00012.L$7;
                List episodes2 = (List) c00012.L$6;
                String poster4 = (String) c00012.L$5;
                String posterRaw3 = (String) c00012.L$4;
                Regex posterRegex3 = (Regex) c00012.L$3;
                String title2 = (String) c00012.L$2;
                Document doc3 = (Document) c00012.L$1;
                String url7 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                url5 = posterRaw3;
                posterRaw2 = url7;
                obj3 = coroutine_suspended;
                maxPage2 = maxPage3;
                pages3 = pages4;
                pages2 = episodes2;
                poster2 = poster4;
                posterRegex2 = posterRegex3;
                doc2 = doc3;
                poster3 = title2;
                List it6 = CollectionsKt.flatten((Iterable) $result);
                pages2.addAll(it6);
                if (pages2.isEmpty()) {
                    pages2.add(MainAPIKt.newEpisode(desiSerialsProvider, posterRaw2, new Function1() { // from class: com.cncverse.desiserials.DesiSerialsProvider$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj8) {
                            return DesiSerialsProvider.load$lambda$3(poster3, poster2, (Episode) obj8);
                        }
                    }));
                }
                obj4 = obj3;
                TvType tvType3 = TvType.TvSeries;
                List listReversed3 = CollectionsKt.reversed(pages2);
                C00035 c00037 = new C00035(poster2, desiSerialsProvider, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(posterRaw2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc2);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(poster3);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(posterRegex2);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(url5);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(poster2);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(pages2);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(pages3);
                c00012.I$0 = maxPage2;
                c00012.label = 3;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(desiSerialsProvider, poster3, posterRaw2, tvType3, listReversed3, c00037, c00012);
                if (objNewTvSeriesLoadResponse == obj4) {
                    return obj4;
                }
                return objNewTvSeriesLoadResponse;
            case 3:
                int i = c00012.I$0;
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.cncverse.desiserials.DesiSerialsProvider$load$2 */
    /* JADX INFO: compiled from: DesiSerialsProvider.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/Episode;", "pUrl", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.desiserials.DesiSerialsProvider$load$2", f = "DesiSerialsProvider.kt", i = {0}, l = {203}, m = "invokeSuspend", n = {"pUrl"}, nl = {206}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nDesiSerialsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DesiSerialsProvider.kt\ncom/cncverse/desiserials/DesiSerialsProvider$load$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,718:1\n1642#2,10:719\n1915#2:729\n1916#2:731\n1652#2:732\n1#3:730\n*S KotlinDebug\n*F\n+ 1 DesiSerialsProvider.kt\ncom/cncverse/desiserials/DesiSerialsProvider$load$2\n*L\n209#1:719,10\n209#1:729\n209#1:731\n209#1:732\n209#1:730\n*E\n"})
    static final class C00022 extends SuspendLambda implements Function2<String, Continuation<? super List<? extends Episode>>, Object> {
        final /* synthetic */ Document $doc;
        final /* synthetic */ String $poster;
        final /* synthetic */ String $url;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DesiSerialsProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00022(String str, Document document, DesiSerialsProvider desiSerialsProvider, String str2, Continuation<? super C00022> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$doc = document;
            this.this$0 = desiSerialsProvider;
            this.$poster = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00022 = new C00022(this.$url, this.$doc, this.this$0, this.$poster, continuation);
            c00022.L$0 = obj;
            return c00022;
        }

        public final Object invoke(String str, Continuation<? super List<Episode>> continuation) {
            return create(str, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x009c  */
        /* JADX WARN: Code duplicated, block: B:19:0x00b6  */
        /* JADX WARN: Code duplicated, block: B:21:0x00dd  */
        /* JADX WARN: Code duplicated, block: B:22:0x00e9  */
        /* JADX WARN: Code duplicated, block: B:23:0x00ec  */
        /* JADX WARN: Code duplicated, block: B:25:0x00f6  */
        /* JADX WARN: Code duplicated, block: B:31:0x00fc A[SYNTHETIC] */
        public final Object invokeSuspend(Object $result) {
            Object obj;
            Document pDoc;
            Elements posts;
            DesiSerialsProvider desiSerialsProvider;
            String str;
            final String str2;
            Collection destination$iv$iv;
            Element a;
            Episode episodeNewEpisode;
            Elements posts2;
            DesiSerialsProvider desiSerialsProvider2;
            String epHref;
            final String epTitle;
            String pUrl = (String) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (Intrinsics.areEqual(pUrl, this.$url)) {
                        pDoc = this.$doc;
                    } else {
                        Requests app = MainActivityKt.getApp();
                        Pair[] pairArr = {TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"), TuplesKt.to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8")};
                        this.L$0 = SpillingKt.nullOutSpilledVariable(pUrl);
                        this.label = 1;
                        obj = Requests.get$default(app, pUrl, MapsKt.mapOf(pairArr), (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4092, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pDoc = ((NiceResponse) obj).getDocument();
                    }
                    posts = pDoc.select("article.type-post");
                    Iterable $this$mapNotNull$iv = (Iterable) posts;
                    desiSerialsProvider = this.this$0;
                    str = this.$url;
                    str2 = this.$poster;
                    destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                        Element element = (Element) element$iv$iv$iv;
                        Document pDoc2 = pDoc;
                        a = element.selectFirst("h3.thumb-info-inner a, h2.entry-title a");
                        episodeNewEpisode = null;
                        if (a != null) {
                            desiSerialsProvider2 = desiSerialsProvider;
                            posts2 = posts;
                            epHref = MainAPIKt.fixUrl(desiSerialsProvider2, a.attr("href"));
                            epTitle = StringsKt.trim(a.text()).toString();
                            if (!Intrinsics.areEqual(epHref, str)) {
                                episodeNewEpisode = MainAPIKt.newEpisode(desiSerialsProvider2, epHref, new Function1() { // from class: com.cncverse.desiserials.DesiSerialsProvider$load$2$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj2) {
                                        return DesiSerialsProvider.C00022.invokeSuspend$lambda$0$0(epTitle, str2, (Episode) obj2);
                                    }
                                });
                            }
                        } else {
                            posts2 = posts;
                        }
                        if (episodeNewEpisode != null) {
                            destination$iv$iv.add(episodeNewEpisode);
                        }
                        pDoc = pDoc2;
                        posts = posts2;
                        pUrl = pUrl;
                    }
                    return (List) destination$iv$iv;
                case 1:
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    pDoc = ((NiceResponse) obj).getDocument();
                    posts = pDoc.select("article.type-post");
                    Iterable $this$mapNotNull$iv2 = (Iterable) posts;
                    desiSerialsProvider = this.this$0;
                    str = this.$url;
                    str2 = this.$poster;
                    destination$iv$iv = new ArrayList();
                    while (r14.hasNext()) {
                        Element element2 = (Element) element$iv$iv$iv;
                        Document pDoc3 = pDoc;
                        a = element2.selectFirst("h3.thumb-info-inner a, h2.entry-title a");
                        episodeNewEpisode = null;
                        if (a != null) {
                            desiSerialsProvider2 = desiSerialsProvider;
                            posts2 = posts;
                            epHref = MainAPIKt.fixUrl(desiSerialsProvider2, a.attr("href"));
                            epTitle = StringsKt.trim(a.text()).toString();
                            if (!Intrinsics.areEqual(epHref, str)) {
                                episodeNewEpisode = MainAPIKt.newEpisode(desiSerialsProvider2, epHref, new Function1() { // from class: com.cncverse.desiserials.DesiSerialsProvider$load$2$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj2) {
                                        return DesiSerialsProvider.C00022.invokeSuspend$lambda$0$0(epTitle, str2, (Episode) obj2);
                                    }
                                });
                            }
                        } else {
                            posts2 = posts;
                        }
                        if (episodeNewEpisode != null) {
                            destination$iv$iv.add(episodeNewEpisode);
                        }
                        pDoc = pDoc3;
                        posts = posts2;
                        pUrl = pUrl;
                    }
                    return (List) destination$iv$iv;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0$0(String $epTitle, String $poster, Episode $this$newEpisode) {
            $this$newEpisode.setName($epTitle);
            $this$newEpisode.setPosterUrl($poster);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$3(String $title, String $poster, Episode $this$newEpisode) {
        $this$newEpisode.setName($title);
        $this$newEpisode.setSeason(1);
        $this$newEpisode.setEpisode(1);
        $this$newEpisode.setPosterUrl($poster);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.cncverse.desiserials.DesiSerialsProvider$load$5 */
    /* JADX INFO: compiled from: DesiSerialsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.desiserials.DesiSerialsProvider$load$5", f = "DesiSerialsProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00035 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DesiSerialsProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00035(String str, DesiSerialsProvider desiSerialsProvider, Continuation<? super C00035> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.this$0 = desiSerialsProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00035 = new C00035(this.$poster, this.this$0, continuation);
            c00035.L$0 = obj;
            return c00035;
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
                    String str = this.$poster;
                    $this$newTvSeriesLoadResponse.setPosterUrl(str != null ? StringsKt.trim(str).toString() : null);
                    $this$newTvSeriesLoadResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("referer", this.this$0.getMainUrl() + '/')));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final <T, R> List<R> mapNotBlank(Iterable<? extends T> iterable, Function1<? super T, ? extends R> function1) {
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : iterable) {
            Object it$iv$iv = function1.invoke(element$iv$iv$iv);
            if (it$iv$iv != null) {
                destination$iv$iv.add(it$iv$iv);
            }
        }
        Iterable $this$filter$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (T t : $this$filter$iv) {
            String s = t.toString();
            if ((StringsKt.isBlank(s) || Intrinsics.areEqual(s, "null")) ? false : true) {
                destination$iv$iv2.add(t);
            }
        }
        return (List) destination$iv$iv2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0020  */
    /* JADX WARN: Code duplicated, block: B:89:0x0359  */
    /* JADX WARN: Code duplicated, block: B:91:0x03c4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:92:0x03c5  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:92:0x03c5 -> B:93:0x03d3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r29, boolean r30, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r31, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r32, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r33) {
        /*
            Method dump skipped, instruction units count: 1332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.desiserials.DesiSerialsProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadLinks$lambda$0$0(Context $_ctx) {
        Toast.makeText($_ctx, "⚠️(Opening ads) Subscription expired. If you have renewed your subscription, please re-verify it in Subscription Manager.", 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:138:0x1052 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:139:0x1053  */
    /* JADX WARN: Code duplicated, block: B:524:0x0f86 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Failed to apply debug info
    jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 84901. Try increasing type updates limit count.
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.requestUpdate(TypeUpdateInfo.java:61)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:298)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyDebugInfo(TypeUpdate.java:77)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchDebugInfoByOffset(DebugInfoApplyVisitor.java:107)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:83)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:141:0x107c -> B:518:0x0f80). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:174:0x126d -> B:446:0x1183). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:268:0x17d6 -> B:454:0x16e1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:323:0x1ad7 -> B:419:0x1f88). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:370:0x1d22 -> B:542:0x1c01). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:430:0x20ba -> B:431:0x20d9). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public static final java.lang.Object loadLinks$handleIframe(kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r71, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r72, com.cncverse.desiserials.DesiSerialsProvider r73, java.lang.String r74, java.lang.String r75, kotlin.coroutines.Continuation<? super kotlin.Unit> r76) {
        /*
            Method dump skipped, instruction units count: 8490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.desiserials.DesiSerialsProvider.loadLinks$handleIframe(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, com.cncverse.desiserials.DesiSerialsProvider, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadLinks$handleIframe$lambda$2$0(MatchResult it) {
        return (String) it.getGroupValues().get(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadLinks$handleIframe$lambda$2$2(MatchResult it) {
        return (String) it.getGroupValues().get(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadLinks$handleIframe$lambda$2$4(MatchResult it) {
        return (String) it.getGroupValues().get(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadLinks$handleIframe$lambda$2$6(MatchResult it) {
        return (String) it.getGroupValues().get(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadLinks$handleIframe$lambda$3(MatchResult it) {
        return (String) it.getGroupValues().get(1);
    }

    /* JADX INFO: renamed from: com.cncverse.desiserials.DesiSerialsProvider$loadLinks$4 */
    /* JADX INFO: compiled from: DesiSerialsProvider.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "link", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.desiserials.DesiSerialsProvider$loadLinks$4", f = "DesiSerialsProvider.kt", i = {0}, l = {465}, m = "invokeSuspend", n = {"link"}, nl = {466}, s = {"L$0"}, v = 2)
    static final class C00054 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00054(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00054> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00054 = DesiSerialsProvider.this.new C00054(this.$subtitleCallback, this.$callback, continuation);
            c00054.L$0 = obj;
            return c00054;
        }

        public final Object invoke(String str, Continuation<? super Unit> continuation) {
            return create(str, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String link = (String) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(link);
                    this.label = 1;
                    if (DesiSerialsProvider.loadLinks$handleIframe(this.$subtitleCallback, this.$callback, DesiSerialsProvider.this, link, DesiSerialsProvider.this.getMainUrl() + '/', (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
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
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.desiserials.DesiSerialsProvider$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    DesiSerialsProvider.showSubscriptionPopupIfNeeded$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.desiserials.DesiSerialsProvider$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DesiSerialsProvider.showSubscriptionPopupIfNeeded$lambda$0$11($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249, $ctx, dialog, view);
                }
            });
            subscribeTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.desiserials.DesiSerialsProvider$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DesiSerialsProvider.showSubscriptionPopupIfNeeded$lambda$0$12(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.desiserials.DesiSerialsProvider$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                DesiSerialsProvider.showTelegramPopup$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.desiserials.DesiSerialsProvider$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            joinTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.desiserials.DesiSerialsProvider$$ExternalSyntheticLambda14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DesiSerialsProvider.showTelegramPopup$lambda$0$9(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.desiserials.DesiSerialsProvider$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                DesiSerialsProvider.openInExternalBrowser$lambda$0(ctx, url);
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
