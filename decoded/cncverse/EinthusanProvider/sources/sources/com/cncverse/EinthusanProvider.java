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
import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.ActorRole;
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
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchQuality;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
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
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
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
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: EinthusanProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/EinthusanProvider/classes.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 F2\u00020\u0001:\u0001FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010(\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0096@¢\u0006\u0002\u0010/J\u000e\u00100\u001a\u0004\u0018\u000101*\u000202H\u0002J\u001c\u00103\u001a\b\u0012\u0004\u0012\u0002010&2\u0006\u00104\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00105J\u0018\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00105JF\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u000e2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?0=2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020?0=H\u0096@¢\u0006\u0002\u0010BJ\b\u0010C\u001a\u00020?H\u0002J\b\u0010D\u001a\u00020?H\u0002J\u0010\u0010E\u001a\u00020?2\u0006\u00108\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006G"}, d2 = {"Lcom/cncverse/EinthusanProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "sequentialMainPage", "getSequentialMainPage", "setSequentialMainPage", "(Z)V", "sequentialMainPageDelay", "", "getSequentialMainPageDelay", "()J", "setSequentialMainPageDelay", "(J)V", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showSubscriptionPopupIfNeeded", "showTelegramPopup", "openInExternalBrowser", "Companion", "EinthusanProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nEinthusanProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EinthusanProvider.kt\ncom/cncverse/EinthusanProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,490:1\n1642#2,10:491\n1915#2:501\n1916#2:503\n1652#2:504\n1642#2,10:505\n1915#2:515\n1916#2:517\n1652#2:518\n1642#2,10:519\n1915#2:529\n1916#2:531\n1652#2:532\n1642#2,10:533\n1915#2:543\n1916#2:545\n1652#2:546\n1642#2,10:547\n1915#2:557\n1916#2:559\n1652#2:560\n1642#2,10:561\n1915#2:571\n1916#2:573\n1652#2:574\n1642#2,10:575\n1915#2:585\n1916#2:587\n1652#2:588\n1642#2,10:589\n1915#2:599\n1916#2:601\n1652#2:602\n1642#2,10:603\n1915#2:613\n1916#2:615\n1652#2:616\n1068#2:617\n1586#2:619\n1661#2,3:620\n1586#2:623\n1661#2,3:624\n1#3:502\n1#3:516\n1#3:530\n1#3:544\n1#3:558\n1#3:572\n1#3:586\n1#3:600\n1#3:614\n1#3:618\n*S KotlinDebug\n*F\n+ 1 EinthusanProvider.kt\ncom/cncverse/EinthusanProvider\n*L\n93#1:491,10\n93#1:501\n93#1:503\n93#1:504\n116#1:505,10\n116#1:515\n116#1:517\n116#1:518\n119#1:519,10\n119#1:529\n119#1:531\n119#1:532\n122#1:533,10\n122#1:543\n122#1:545\n122#1:546\n125#1:547,10\n125#1:557\n125#1:559\n125#1:560\n128#1:561,10\n128#1:571\n128#1:573\n128#1:574\n131#1:575,10\n131#1:585\n131#1:587\n131#1:588\n134#1:589,10\n134#1:599\n134#1:601\n134#1:602\n137#1:603,10\n137#1:613\n137#1:615\n137#1:616\n142#1:617\n163#1:619\n163#1:620,3\n171#1:623\n171#1:624,3\n93#1:502\n116#1:516\n119#1:530\n122#1:544\n125#1:558\n128#1:572\n131#1:586\n134#1:600\n137#1:614\n*E\n"})
public final class EinthusanProvider extends MainAPI {
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
    private String mainUrl = "https://einthusan.tv";

    @NotNull
    private String name = "Einthusan";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "ta";
    private final boolean hasDownloadSupport = true;
    private boolean sequentialMainPage = true;
    private long sequentialMainPageDelay = 100;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Movie);

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to(getMainUrl() + "/movie/results/?find=Recent&lang=tamil", "Tamil Movies"), TuplesKt.to(getMainUrl() + "/movie/results/?find=Recent&lang=hindi", "Hindi Movies"), TuplesKt.to(getMainUrl() + "/movie/results/?find=Recent&lang=telugu", "Telugu Movies"), TuplesKt.to(getMainUrl() + "/movie/results/?find=Recent&lang=malayalam", "Malayalam Movies"), TuplesKt.to(getMainUrl() + "/movie/results/?find=Recent&lang=kannada", "Kannada Movies"), TuplesKt.to(getMainUrl() + "/movie/results/?find=Recent&lang=bengali", "Bengali Movies"), TuplesKt.to(getMainUrl() + "/movie/results/?find=Recent&lang=marathi", "Marathi Movies"), TuplesKt.to(getMainUrl() + "/movie/results/?find=Recent&lang=punjabi", "Punjabi Movies")});

    /* JADX INFO: renamed from: com.cncverse.EinthusanProvider$getMainPage$1 */
    /* JADX INFO: compiled from: EinthusanProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.EinthusanProvider", f = "EinthusanProvider.kt", i = {0, 0, 1, 1}, l = {87, 89}, m = "getMainPage", n = {"request", "page", "request", "page"}, nl = {89, 86}, s = {"L$0", "I$0", "L$0", "I$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EinthusanProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.EinthusanProvider$load$1 */
    /* JADX INFO: compiled from: EinthusanProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.EinthusanProvider", f = "EinthusanProvider.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {155, 183}, m = "load", n = {"url", "url", "doc", "title", "href", "poster", "tags", "year", "description", "score", "actors", "mp4link", "m3u8link"}, nl = {157, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EinthusanProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.EinthusanProvider$loadLinks$1 */
    /* JADX INFO: compiled from: EinthusanProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.EinthusanProvider", f = "EinthusanProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {222, 233}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "mp4link", "m3u8link", "ipfind", "fixedmp4link", "fixedm3u8link", "isCasting", "data", "subtitleCallback", "callback", "mp4link", "m3u8link", "ipfind", "fixedmp4link", "fixedm3u8link", "isCasting"}, nl = {221, 232}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
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

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EinthusanProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.EinthusanProvider$search$1 */
    /* JADX INFO: compiled from: EinthusanProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.EinthusanProvider", f = "EinthusanProvider.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {116, 119, 122, 125, 128, 131, 134, 137}, m = "search", n = {"query", "fixedQuery", "query", "fixedQuery", "resultTamil", "query", "fixedQuery", "resultTamil", "resultHindi", "query", "fixedQuery", "resultTamil", "resultHindi", "resultMalayalam", "query", "fixedQuery", "resultTamil", "resultHindi", "resultMalayalam", "resultTelugu", "query", "fixedQuery", "resultTamil", "resultHindi", "resultMalayalam", "resultTelugu", "resultKannada", "query", "fixedQuery", "resultTamil", "resultHindi", "resultMalayalam", "resultTelugu", "resultKannada", "resultBengali", "query", "fixedQuery", "resultTamil", "resultHindi", "resultMalayalam", "resultTelugu", "resultKannada", "resultBengali", "resultMarathi"}, nl = {491, 505, 519, 533, 547, 561, 575, 589}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EinthusanProvider.this.search(null, (Continuation) this);
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

    public boolean getSequentialMainPage() {
        return this.sequentialMainPage;
    }

    public void setSequentialMainPage(boolean z) {
        this.sequentialMainPage = z;
    }

    public long getSequentialMainPageDelay() {
        return this.sequentialMainPageDelay;
    }

    public void setSequentialMainPageDelay(long j) {
        this.sequentialMainPageDelay = j;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX INFO: compiled from: EinthusanProvider.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/cncverse/EinthusanProvider$Companion;", "", "<init>", "()V", "isCsGuardActive", "", "csGuardWasEverActive", "isCsGuardBlocked", "showCsGuardToast", "", "ctx", "Landroid/content/Context;", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "OMG10", "", "lastBrowserOpenMs", "", "telegramPopupShown", "subscriptionPopupShown", "BROWSER_DEBOUNCE_MS", "EinthusanProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nEinthusanProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EinthusanProvider.kt\ncom/cncverse/EinthusanProvider$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,490:1\n1#2:491\n*E\n"})
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
                EinthusanProvider.csGuardWasEverActive = true;
            }
            return EinthusanProvider.csGuardWasEverActive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCsGuardToast(final Context ctx) {
            if (ctx == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.EinthusanProvider$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    EinthusanProvider.Companion.showCsGuardToast$lambda$0(ctx);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showCsGuardToast$lambda$0(Context $c) {
            Toast.makeText($c, "🚫 CSGuard detected — Restart CloudStream after removing CSGuard to use CNCRepo", 1).show();
        }

        @Nullable
        public final Context getContext() {
            return EinthusanProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            EinthusanProvider.context = context;
        }
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x013b  */
    /* JADX WARN: Code duplicated, block: B:33:0x014c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0151 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        C00001 c00002;
        Document document;
        Collection destination$iv$iv;
        SearchResponse searchResult;
        MainPageRequest request2 = request;
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
                if (page != 1) {
                    C00001 c00003 = c00001;
                    Requests app = MainActivityKt.getApp();
                    String str = request2.getData() + "&page=" + page;
                    c00003.L$0 = request2;
                    c00003.I$0 = page;
                    c00003.label = 2;
                    $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00003, 4094, (Object) null);
                    if ($result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    document = ((NiceResponse) $result).getDocument();
                    Iterable $this$mapNotNull$iv = document.select("#UIMovieSummary > ul > li");
                    destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                        Element it = (Element) element$iv$iv$iv;
                        searchResult = toSearchResult(it);
                        if (searchResult != null) {
                            destination$iv$iv.add(searchResult);
                        }
                    }
                    List home = (List) destination$iv$iv;
                    return MainAPIKt.newHomePageResponse(CollectionsKt.arrayListOf(new HomePageList[]{new HomePageList(request2.getName(), home, false, 4, (DefaultConstructorMarker) null)}), Boxing.boxBoolean(true));
                }
                Requests app2 = MainActivityKt.getApp();
                String data = request2.getData();
                c00001.L$0 = request2;
                c00001.I$0 = page;
                c00001.label = 1;
                C00001 c00004 = c00001;
                $result = Requests.get$default(app2, data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00004, 4094, (Object) null);
                c00002 = c00004;
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                document = ((NiceResponse) $result).getDocument();
                Iterable $this$mapNotNull$iv2 = document.select("#UIMovieSummary > ul > li");
                destination$iv$iv = new ArrayList();
                while (r12.hasNext()) {
                    Element it2 = (Element) element$iv$iv$iv;
                    searchResult = toSearchResult(it2);
                    if (searchResult != null) {
                        destination$iv$iv.add(searchResult);
                    }
                }
                List home2 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(CollectionsKt.arrayListOf(new HomePageList[]{new HomePageList(request2.getName(), home2, false, 4, (DefaultConstructorMarker) null)}), Boxing.boxBoolean(true));
            case 1:
                int page2 = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                c00002 = c00001;
                document = ((NiceResponse) $result).getDocument();
                Iterable $this$mapNotNull$iv3 = document.select("#UIMovieSummary > ul > li");
                destination$iv$iv = new ArrayList();
                while (r12.hasNext()) {
                    Element it3 = (Element) element$iv$iv$iv;
                    searchResult = toSearchResult(it3);
                    if (searchResult != null) {
                        destination$iv$iv.add(searchResult);
                    }
                }
                List home3 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(CollectionsKt.arrayListOf(new HomePageList[]{new HomePageList(request2.getName(), home3, false, 4, (DefaultConstructorMarker) null)}), Boxing.boxBoolean(true));
            case 2:
                int i = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                document = ((NiceResponse) $result).getDocument();
                Iterable $this$mapNotNull$iv4 = document.select("#UIMovieSummary > ul > li");
                destination$iv$iv = new ArrayList();
                while (r12.hasNext()) {
                    Element it4 = (Element) element$iv$iv$iv;
                    searchResult = toSearchResult(it4);
                    if (searchResult != null) {
                        destination$iv$iv.add(searchResult);
                    }
                }
                List home4 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(CollectionsKt.arrayListOf(new HomePageList[]{new HomePageList(request2.getName(), home4, false, 4, (DefaultConstructorMarker) null)}), Boxing.boxBoolean(true));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String strText;
        String title;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("div.block2 > a.title > h3");
        if (elementSelectFirst == null || (strText = elementSelectFirst.text()) == null || (title = StringsKt.trim(strText).toString()) == null) {
            return null;
        }
        EinthusanProvider einthusanProvider = this;
        StringBuilder sbAppend = new StringBuilder().append(getMainUrl());
        Element elementSelectFirst2 = $this$toSearchResult.selectFirst("div.block2 > a.title");
        String href = MainAPIKt.fixUrl(einthusanProvider, sbAppend.append(elementSelectFirst2 != null ? elementSelectFirst2.attr("href") : null).toString());
        EinthusanProvider einthusanProvider2 = this;
        StringBuilder sbAppend2 = new StringBuilder().append("https:");
        Element elementSelectFirst3 = $this$toSearchResult.selectFirst("div.block1 > a > img");
        final String posterUrl = MainAPIKt.fixUrlNull(einthusanProvider2, sbAppend2.append(elementSelectFirst3 != null ? elementSelectFirst3.attr("src") : null).toString());
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.cncverse.EinthusanProvider$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                return EinthusanProvider.toSearchResult$lambda$0(posterUrl, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toSearchResult$lambda$0(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setQuality(SearchQuality.HD);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x06cd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:104:0x06ce  */
    /* JADX WARN: Code duplicated, block: B:108:0x0703  */
    /* JADX WARN: Code duplicated, block: B:110:0x0719  */
    /* JADX WARN: Code duplicated, block: B:116:0x071e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x0655 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x0592 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:125:0x04d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:128:0x041f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:0x036f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:0x02c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x021d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0204  */
    /* JADX WARN: Code duplicated, block: B:33:0x0218  */
    /* JADX WARN: Code duplicated, block: B:37:0x0280 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x0281  */
    /* JADX WARN: Code duplicated, block: B:42:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:44:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:48:0x0329 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x032a  */
    /* JADX WARN: Code duplicated, block: B:53:0x0354  */
    /* JADX WARN: Code duplicated, block: B:55:0x036a  */
    /* JADX WARN: Code duplicated, block: B:59:0x03d7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:60:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:64:0x0404  */
    /* JADX WARN: Code duplicated, block: B:66:0x041a  */
    /* JADX WARN: Code duplicated, block: B:70:0x048a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:71:0x048b  */
    /* JADX WARN: Code duplicated, block: B:75:0x04ba  */
    /* JADX WARN: Code duplicated, block: B:77:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x0544 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:82:0x0545  */
    /* JADX WARN: Code duplicated, block: B:86:0x0577  */
    /* JADX WARN: Code duplicated, block: B:88:0x058d  */
    /* JADX WARN: Code duplicated, block: B:92:0x0604 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:93:0x0605  */
    /* JADX WARN: Code duplicated, block: B:97:0x063a  */
    /* JADX WARN: Code duplicated, block: B:99:0x0650  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00061 c00061;
        Object obj;
        String str;
        C00061 c00062;
        Object obj2;
        String fixedQuery;
        String query2;
        Iterable $this$mapNotNull$iv;
        Collection destination$iv$iv;
        List resultTamil;
        String fixedQuery2;
        String query3;
        C00061 c00063;
        String fixedQuery3;
        String fixedQuery4;
        List resultTamil2;
        SearchResponse searchResult;
        Iterable $this$mapNotNull$iv2;
        Collection destination$iv$iv2;
        List resultHindi;
        List resultTamil3;
        String fixedQuery5;
        String query4;
        C00061 c00064;
        String fixedQuery6;
        String fixedQuery7;
        List resultTamil4;
        List resultHindi2;
        SearchResponse searchResult2;
        Iterable $this$mapNotNull$iv3;
        Collection destination$iv$iv3;
        List resultMalayalam;
        List resultHindi3;
        List resultTamil5;
        String fixedQuery8;
        String query5;
        C00061 c00065;
        String fixedQuery9;
        String fixedQuery10;
        List resultHindi4;
        List resultHindi5;
        List resultMalayalam2;
        SearchResponse searchResult3;
        Iterable $this$mapNotNull$iv4;
        Collection destination$iv$iv4;
        List resultTelugu;
        List resultMalayalam3;
        List resultHindi6;
        List resultTamil6;
        String fixedQuery11;
        String query6;
        C00061 c00066;
        String fixedQuery12;
        String fixedQuery13;
        List resultHindi7;
        List resultMalayalam4;
        List resultMalayalam5;
        List resultTelugu2;
        SearchResponse searchResult4;
        Iterable $this$mapNotNull$iv5;
        Collection destination$iv$iv5;
        List resultKannada;
        List resultTelugu3;
        List resultMalayalam6;
        List resultHindi8;
        List resultTamil7;
        String fixedQuery14;
        String query7;
        C00061 c00067;
        String fixedQuery15;
        String fixedQuery16;
        List resultHindi9;
        List resultMalayalam7;
        List resultTelugu4;
        List resultTelugu5;
        List resultKannada2;
        SearchResponse searchResult5;
        Iterable $this$mapNotNull$iv6;
        Collection destination$iv$iv6;
        List resultBengali;
        List resultKannada3;
        List resultTelugu6;
        List resultMalayalam8;
        List resultHindi10;
        List resultTamil8;
        String fixedQuery17;
        String query8;
        C00061 c00068;
        String fixedQuery18;
        String fixedQuery19;
        List resultHindi11;
        List resultMalayalam9;
        List resultTelugu7;
        List resultKannada4;
        List resultKannada5;
        List resultBengali2;
        SearchResponse searchResult6;
        Iterable $this$mapNotNull$iv7;
        Collection destination$iv$iv7;
        List resultMarathi;
        List resultBengali3;
        List resultKannada6;
        List resultTelugu8;
        List resultMalayalam10;
        List resultHindi12;
        List resultTamil9;
        String query9;
        final String query10;
        List resultTamil10;
        List resultHindi13;
        List resultMalayalam11;
        List resultTelugu9;
        List resultKannada7;
        List resultBengali4;
        List resultMarathi2;
        SearchResponse searchResult7;
        Iterable $this$mapNotNull$iv8;
        Collection destination$iv$iv8;
        SearchResponse searchResult8;
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
        Object $result = c00061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00061.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return CollectionsKt.emptyList();
                }
                String fixedQuery20 = StringsKt.replace$default(query, " ", "+", false, 4, (Object) null);
                Requests app = MainActivityKt.getApp();
                String str2 = getMainUrl() + "/movie/results/?lang=tamil&query=" + fixedQuery20;
                c00061.L$0 = query;
                c00061.L$1 = fixedQuery20;
                c00061.label = 1;
                C00061 c00069 = c00061;
                obj = coroutine_suspended;
                str = "#UIMovieSummary > ul > li";
                Object obj3 = Requests.get$default(app, str2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00069, 4094, (Object) null);
                c00062 = c00069;
                if (obj3 == obj) {
                    return obj;
                }
                obj2 = obj3;
                fixedQuery = fixedQuery20;
                query2 = query;
                $this$mapNotNull$iv = ((NiceResponse) obj2).getDocument().select(str);
                destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    Iterable $this$mapNotNull$iv9 = $this$mapNotNull$iv;
                    Element it = (Element) element$iv$iv$iv;
                    searchResult = toSearchResult(it);
                    if (searchResult != null) {
                        destination$iv$iv.add(searchResult);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv9;
                }
                resultTamil = (List) destination$iv$iv;
                Requests app2 = MainActivityKt.getApp();
                String str3 = getMainUrl() + "/movie/results/?lang=hindi&query=" + fixedQuery;
                c00062.L$0 = query2;
                c00062.L$1 = fixedQuery;
                c00062.L$2 = resultTamil;
                c00062.label = 2;
                fixedQuery2 = fixedQuery;
                query3 = query2;
                C00061 c000610 = c00062;
                $result = Requests.get$default(app2, str3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000610, 4094, (Object) null);
                c00063 = c000610;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery3 = fixedQuery2;
                fixedQuery4 = query3;
                resultTamil2 = resultTamil;
                $this$mapNotNull$iv2 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv$iv2 : $this$mapNotNull$iv2) {
                    Iterable $this$mapNotNull$iv10 = $this$mapNotNull$iv2;
                    Element it2 = (Element) element$iv$iv$iv2;
                    searchResult2 = toSearchResult(it2);
                    if (searchResult2 != null) {
                        destination$iv$iv2.add(searchResult2);
                    }
                    $this$mapNotNull$iv2 = $this$mapNotNull$iv10;
                }
                resultHindi = (List) destination$iv$iv2;
                Requests app3 = MainActivityKt.getApp();
                String str4 = getMainUrl() + "/movie/results/?lang=malayalam&query=" + fixedQuery3;
                c00063.L$0 = fixedQuery4;
                c00063.L$1 = fixedQuery3;
                c00063.L$2 = resultTamil2;
                c00063.L$3 = resultHindi;
                c00063.label = 3;
                resultTamil3 = resultTamil2;
                fixedQuery5 = fixedQuery3;
                query4 = fixedQuery4;
                C00061 c000611 = c00063;
                $result = Requests.get$default(app3, str4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000611, 4094, (Object) null);
                c00064 = c000611;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery6 = fixedQuery5;
                fixedQuery7 = query4;
                resultTamil4 = resultTamil3;
                resultHindi2 = resultHindi;
                $this$mapNotNull$iv3 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv3 = new ArrayList();
                for (Object element$iv$iv$iv3 : $this$mapNotNull$iv3) {
                    Iterable $this$mapNotNull$iv11 = $this$mapNotNull$iv3;
                    Element it3 = (Element) element$iv$iv$iv3;
                    searchResult3 = toSearchResult(it3);
                    if (searchResult3 != null) {
                        destination$iv$iv3.add(searchResult3);
                    }
                    $this$mapNotNull$iv3 = $this$mapNotNull$iv11;
                }
                resultMalayalam = (List) destination$iv$iv3;
                Requests app4 = MainActivityKt.getApp();
                String str5 = getMainUrl() + "/movie/results/?lang=telugu&query=" + fixedQuery6;
                c00064.L$0 = fixedQuery7;
                c00064.L$1 = fixedQuery6;
                c00064.L$2 = resultTamil4;
                c00064.L$3 = resultHindi2;
                c00064.L$4 = resultMalayalam;
                c00064.label = 4;
                resultHindi3 = resultHindi2;
                resultTamil5 = resultTamil4;
                fixedQuery8 = fixedQuery6;
                query5 = fixedQuery7;
                C00061 c000612 = c00064;
                $result = Requests.get$default(app4, str5, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000612, 4094, (Object) null);
                c00065 = c000612;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery9 = fixedQuery8;
                fixedQuery10 = query5;
                resultHindi4 = resultTamil5;
                resultHindi5 = resultHindi3;
                resultMalayalam2 = resultMalayalam;
                $this$mapNotNull$iv4 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv4 = new ArrayList();
                for (Object element$iv$iv$iv4 : $this$mapNotNull$iv4) {
                    Iterable $this$mapNotNull$iv12 = $this$mapNotNull$iv4;
                    Element it4 = (Element) element$iv$iv$iv4;
                    searchResult4 = toSearchResult(it4);
                    if (searchResult4 != null) {
                        destination$iv$iv4.add(searchResult4);
                    }
                    $this$mapNotNull$iv4 = $this$mapNotNull$iv12;
                }
                resultTelugu = (List) destination$iv$iv4;
                Requests app5 = MainActivityKt.getApp();
                String str6 = getMainUrl() + "/movie/results/?lang=kannada&query=" + fixedQuery9;
                c00065.L$0 = fixedQuery10;
                c00065.L$1 = fixedQuery9;
                c00065.L$2 = resultHindi4;
                c00065.L$3 = resultHindi5;
                c00065.L$4 = resultMalayalam2;
                c00065.L$5 = resultTelugu;
                c00065.label = 5;
                resultMalayalam3 = resultMalayalam2;
                resultHindi6 = resultHindi5;
                resultTamil6 = resultHindi4;
                fixedQuery11 = fixedQuery9;
                query6 = fixedQuery10;
                C00061 c000613 = c00065;
                $result = Requests.get$default(app5, str6, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000613, 4094, (Object) null);
                c00066 = c000613;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery12 = fixedQuery11;
                fixedQuery13 = query6;
                resultHindi7 = resultTamil6;
                resultMalayalam4 = resultHindi6;
                resultMalayalam5 = resultMalayalam3;
                resultTelugu2 = resultTelugu;
                $this$mapNotNull$iv5 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv5 = new ArrayList();
                for (Object element$iv$iv$iv5 : $this$mapNotNull$iv5) {
                    Iterable $this$mapNotNull$iv13 = $this$mapNotNull$iv5;
                    Element it5 = (Element) element$iv$iv$iv5;
                    searchResult5 = toSearchResult(it5);
                    if (searchResult5 != null) {
                        destination$iv$iv5.add(searchResult5);
                    }
                    $this$mapNotNull$iv5 = $this$mapNotNull$iv13;
                }
                resultKannada = (List) destination$iv$iv5;
                Requests app6 = MainActivityKt.getApp();
                String str7 = getMainUrl() + "/movie/results/?lang=bengali&query=" + fixedQuery12;
                c00066.L$0 = fixedQuery13;
                c00066.L$1 = fixedQuery12;
                c00066.L$2 = resultHindi7;
                c00066.L$3 = resultMalayalam4;
                c00066.L$4 = resultMalayalam5;
                c00066.L$5 = resultTelugu2;
                c00066.L$6 = resultKannada;
                c00066.label = 6;
                resultTelugu3 = resultTelugu2;
                resultMalayalam6 = resultMalayalam5;
                resultHindi8 = resultMalayalam4;
                resultTamil7 = resultHindi7;
                fixedQuery14 = fixedQuery12;
                query7 = fixedQuery13;
                C00061 c000614 = c00066;
                $result = Requests.get$default(app6, str7, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000614, 4094, (Object) null);
                c00067 = c000614;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery15 = fixedQuery14;
                fixedQuery16 = query7;
                resultHindi9 = resultTamil7;
                resultMalayalam7 = resultHindi8;
                resultTelugu4 = resultMalayalam6;
                resultTelugu5 = resultTelugu3;
                resultKannada2 = resultKannada;
                $this$mapNotNull$iv6 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv6 = new ArrayList();
                for (Object element$iv$iv$iv6 : $this$mapNotNull$iv6) {
                    Iterable $this$mapNotNull$iv14 = $this$mapNotNull$iv6;
                    Element it6 = (Element) element$iv$iv$iv6;
                    searchResult6 = toSearchResult(it6);
                    if (searchResult6 != null) {
                        destination$iv$iv6.add(searchResult6);
                    }
                    $this$mapNotNull$iv6 = $this$mapNotNull$iv14;
                }
                resultBengali = (List) destination$iv$iv6;
                Requests app7 = MainActivityKt.getApp();
                String str8 = getMainUrl() + "/movie/results/?lang=marathi&query=" + fixedQuery15;
                c00067.L$0 = fixedQuery16;
                c00067.L$1 = fixedQuery15;
                c00067.L$2 = resultHindi9;
                c00067.L$3 = resultMalayalam7;
                c00067.L$4 = resultTelugu4;
                c00067.L$5 = resultTelugu5;
                c00067.L$6 = resultKannada2;
                c00067.L$7 = resultBengali;
                c00067.label = 7;
                resultKannada3 = resultKannada2;
                resultTelugu6 = resultTelugu5;
                resultMalayalam8 = resultTelugu4;
                resultHindi10 = resultMalayalam7;
                resultTamil8 = resultHindi9;
                fixedQuery17 = fixedQuery15;
                query8 = fixedQuery16;
                C00061 c000615 = c00067;
                $result = Requests.get$default(app7, str8, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000615, 4094, (Object) null);
                c00068 = c000615;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery18 = fixedQuery17;
                fixedQuery19 = query8;
                resultHindi11 = resultTamil8;
                resultMalayalam9 = resultHindi10;
                resultTelugu7 = resultMalayalam8;
                resultKannada4 = resultTelugu6;
                resultKannada5 = resultKannada3;
                resultBengali2 = resultBengali;
                $this$mapNotNull$iv7 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv7 = new ArrayList();
                for (Object element$iv$iv$iv7 : $this$mapNotNull$iv7) {
                    Iterable $this$mapNotNull$iv15 = $this$mapNotNull$iv7;
                    Element it7 = (Element) element$iv$iv$iv7;
                    searchResult7 = toSearchResult(it7);
                    if (searchResult7 != null) {
                        destination$iv$iv7.add(searchResult7);
                    }
                    $this$mapNotNull$iv7 = $this$mapNotNull$iv15;
                }
                resultMarathi = (List) destination$iv$iv7;
                Requests app8 = MainActivityKt.getApp();
                String str9 = getMainUrl() + "/movie/results/?lang=punjabi&query=" + fixedQuery18;
                c00068.L$0 = fixedQuery19;
                c00068.L$1 = SpillingKt.nullOutSpilledVariable(fixedQuery18);
                c00068.L$2 = resultHindi11;
                c00068.L$3 = resultMalayalam9;
                c00068.L$4 = resultTelugu7;
                c00068.L$5 = resultKannada4;
                c00068.L$6 = resultKannada5;
                c00068.L$7 = resultBengali2;
                c00068.L$8 = resultMarathi;
                c00068.label = 8;
                resultBengali3 = resultBengali2;
                resultKannada6 = resultKannada5;
                resultTelugu8 = resultKannada4;
                resultMalayalam10 = resultTelugu7;
                resultHindi12 = resultMalayalam9;
                resultTamil9 = resultHindi11;
                query9 = fixedQuery19;
                $result = Requests.get$default(app8, str9, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00068, 4094, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                query10 = query9;
                resultTamil10 = resultTamil9;
                resultHindi13 = resultHindi12;
                resultMalayalam11 = resultMalayalam10;
                resultTelugu9 = resultTelugu8;
                resultKannada7 = resultKannada6;
                resultBengali4 = resultBengali3;
                resultMarathi2 = resultMarathi;
                $this$mapNotNull$iv8 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv8 = new ArrayList();
                for (Object element$iv$iv$iv8 : $this$mapNotNull$iv8) {
                    Iterable $this$mapNotNull$iv16 = $this$mapNotNull$iv8;
                    Element it8 = (Element) element$iv$iv$iv8;
                    searchResult8 = toSearchResult(it8);
                    if (searchResult8 != null) {
                        destination$iv$iv8.add(searchResult8);
                    }
                    $this$mapNotNull$iv8 = $this$mapNotNull$iv16;
                }
                List resultPunjabi = (List) destination$iv$iv8;
                Iterable merge = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(resultTamil10, resultHindi13), resultMalayalam11), resultTelugu9), resultKannada7), resultBengali4), resultMarathi2), resultPunjabi);
                Iterable $this$sortedBy$iv = merge;
                return CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: com.cncverse.EinthusanProvider$search$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int i;
                        SearchResponse searchResponse = (SearchResponse) t;
                        String cleanName = new Regex("(\\()+(.*)+(\\))").replace(searchResponse.getName(), "").toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanName, "toLowerCase(...)");
                        String cleanQuery = query10.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanQuery, "toLowerCase(...)");
                        int i2 = 0;
                        if (StringsKt.contains$default(cleanName, cleanQuery, false, 2, (Object) null)) {
                            i = 0;
                        } else {
                            i = StringsKt.startsWith$default(cleanName, cleanQuery, false, 2, (Object) null) ? 1 : 2;
                        }
                        Integer numValueOf = Integer.valueOf(i);
                        SearchResponse searchResponse2 = (SearchResponse) t2;
                        String cleanName2 = new Regex("(\\()+(.*)+(\\))").replace(searchResponse2.getName(), "").toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanName2, "toLowerCase(...)");
                        String cleanQuery2 = query10.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanQuery2, "toLowerCase(...)");
                        if (!StringsKt.contains$default(cleanName2, cleanQuery2, false, 2, (Object) null)) {
                            i2 = StringsKt.startsWith$default(cleanName2, cleanQuery2, false, 2, (Object) null) ? 1 : 2;
                        }
                        return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(i2));
                    }
                });
            case 1:
                String fixedQuery21 = (String) c00061.L$1;
                String query11 = (String) c00061.L$0;
                ResultKt.throwOnFailure($result);
                c00062 = c00061;
                obj = coroutine_suspended;
                str = "#UIMovieSummary > ul > li";
                fixedQuery = fixedQuery21;
                query2 = query11;
                obj2 = $result;
                $this$mapNotNull$iv = ((NiceResponse) obj2).getDocument().select(str);
                destination$iv$iv = new ArrayList();
                while (r13.hasNext()) {
                    Iterable $this$mapNotNull$iv17 = $this$mapNotNull$iv;
                    Element it9 = (Element) element$iv$iv$iv;
                    searchResult = toSearchResult(it9);
                    if (searchResult != null) {
                        destination$iv$iv.add(searchResult);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv17;
                }
                resultTamil = (List) destination$iv$iv;
                Requests app9 = MainActivityKt.getApp();
                String str10 = getMainUrl() + "/movie/results/?lang=hindi&query=" + fixedQuery;
                c00062.L$0 = query2;
                c00062.L$1 = fixedQuery;
                c00062.L$2 = resultTamil;
                c00062.label = 2;
                fixedQuery2 = fixedQuery;
                query3 = query2;
                C00061 c000616 = c00062;
                $result = Requests.get$default(app9, str10, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000616, 4094, (Object) null);
                c00063 = c000616;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery3 = fixedQuery2;
                fixedQuery4 = query3;
                resultTamil2 = resultTamil;
                $this$mapNotNull$iv2 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv2 = new ArrayList();
                while (r14.hasNext()) {
                    Iterable $this$mapNotNull$iv18 = $this$mapNotNull$iv2;
                    Element it10 = (Element) element$iv$iv$iv2;
                    searchResult2 = toSearchResult(it10);
                    if (searchResult2 != null) {
                        destination$iv$iv2.add(searchResult2);
                    }
                    $this$mapNotNull$iv2 = $this$mapNotNull$iv18;
                }
                resultHindi = (List) destination$iv$iv2;
                Requests app10 = MainActivityKt.getApp();
                String str11 = getMainUrl() + "/movie/results/?lang=malayalam&query=" + fixedQuery3;
                c00063.L$0 = fixedQuery4;
                c00063.L$1 = fixedQuery3;
                c00063.L$2 = resultTamil2;
                c00063.L$3 = resultHindi;
                c00063.label = 3;
                resultTamil3 = resultTamil2;
                fixedQuery5 = fixedQuery3;
                query4 = fixedQuery4;
                C00061 c000617 = c00063;
                $result = Requests.get$default(app10, str11, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000617, 4094, (Object) null);
                c00064 = c000617;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery6 = fixedQuery5;
                fixedQuery7 = query4;
                resultTamil4 = resultTamil3;
                resultHindi2 = resultHindi;
                $this$mapNotNull$iv3 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv3 = new ArrayList();
                while (r15.hasNext()) {
                    Iterable $this$mapNotNull$iv19 = $this$mapNotNull$iv3;
                    Element it11 = (Element) element$iv$iv$iv3;
                    searchResult3 = toSearchResult(it11);
                    if (searchResult3 != null) {
                        destination$iv$iv3.add(searchResult3);
                    }
                    $this$mapNotNull$iv3 = $this$mapNotNull$iv19;
                }
                resultMalayalam = (List) destination$iv$iv3;
                Requests app11 = MainActivityKt.getApp();
                String str12 = getMainUrl() + "/movie/results/?lang=telugu&query=" + fixedQuery6;
                c00064.L$0 = fixedQuery7;
                c00064.L$1 = fixedQuery6;
                c00064.L$2 = resultTamil4;
                c00064.L$3 = resultHindi2;
                c00064.L$4 = resultMalayalam;
                c00064.label = 4;
                resultHindi3 = resultHindi2;
                resultTamil5 = resultTamil4;
                fixedQuery8 = fixedQuery6;
                query5 = fixedQuery7;
                C00061 c000618 = c00064;
                $result = Requests.get$default(app11, str12, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000618, 4094, (Object) null);
                c00065 = c000618;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery9 = fixedQuery8;
                fixedQuery10 = query5;
                resultHindi4 = resultTamil5;
                resultHindi5 = resultHindi3;
                resultMalayalam2 = resultMalayalam;
                $this$mapNotNull$iv4 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv4 = new ArrayList();
                while (r16.hasNext()) {
                    Iterable $this$mapNotNull$iv110 = $this$mapNotNull$iv4;
                    Element it12 = (Element) element$iv$iv$iv4;
                    searchResult4 = toSearchResult(it12);
                    if (searchResult4 != null) {
                        destination$iv$iv4.add(searchResult4);
                    }
                    $this$mapNotNull$iv4 = $this$mapNotNull$iv110;
                }
                resultTelugu = (List) destination$iv$iv4;
                Requests app12 = MainActivityKt.getApp();
                String str13 = getMainUrl() + "/movie/results/?lang=kannada&query=" + fixedQuery9;
                c00065.L$0 = fixedQuery10;
                c00065.L$1 = fixedQuery9;
                c00065.L$2 = resultHindi4;
                c00065.L$3 = resultHindi5;
                c00065.L$4 = resultMalayalam2;
                c00065.L$5 = resultTelugu;
                c00065.label = 5;
                resultMalayalam3 = resultMalayalam2;
                resultHindi6 = resultHindi5;
                resultTamil6 = resultHindi4;
                fixedQuery11 = fixedQuery9;
                query6 = fixedQuery10;
                C00061 c000619 = c00065;
                $result = Requests.get$default(app12, str13, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000619, 4094, (Object) null);
                c00066 = c000619;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery12 = fixedQuery11;
                fixedQuery13 = query6;
                resultHindi7 = resultTamil6;
                resultMalayalam4 = resultHindi6;
                resultMalayalam5 = resultMalayalam3;
                resultTelugu2 = resultTelugu;
                $this$mapNotNull$iv5 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv5 = new ArrayList();
                while (r17.hasNext()) {
                    Iterable $this$mapNotNull$iv111 = $this$mapNotNull$iv5;
                    Element it13 = (Element) element$iv$iv$iv5;
                    searchResult5 = toSearchResult(it13);
                    if (searchResult5 != null) {
                        destination$iv$iv5.add(searchResult5);
                    }
                    $this$mapNotNull$iv5 = $this$mapNotNull$iv111;
                }
                resultKannada = (List) destination$iv$iv5;
                Requests app13 = MainActivityKt.getApp();
                String str14 = getMainUrl() + "/movie/results/?lang=bengali&query=" + fixedQuery12;
                c00066.L$0 = fixedQuery13;
                c00066.L$1 = fixedQuery12;
                c00066.L$2 = resultHindi7;
                c00066.L$3 = resultMalayalam4;
                c00066.L$4 = resultMalayalam5;
                c00066.L$5 = resultTelugu2;
                c00066.L$6 = resultKannada;
                c00066.label = 6;
                resultTelugu3 = resultTelugu2;
                resultMalayalam6 = resultMalayalam5;
                resultHindi8 = resultMalayalam4;
                resultTamil7 = resultHindi7;
                fixedQuery14 = fixedQuery12;
                query7 = fixedQuery13;
                C00061 c0006110 = c00066;
                $result = Requests.get$default(app13, str14, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0006110, 4094, (Object) null);
                c00067 = c0006110;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery15 = fixedQuery14;
                fixedQuery16 = query7;
                resultHindi9 = resultTamil7;
                resultMalayalam7 = resultHindi8;
                resultTelugu4 = resultMalayalam6;
                resultTelugu5 = resultTelugu3;
                resultKannada2 = resultKannada;
                $this$mapNotNull$iv6 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv6 = new ArrayList();
                while (r18.hasNext()) {
                    Iterable $this$mapNotNull$iv112 = $this$mapNotNull$iv6;
                    Element it14 = (Element) element$iv$iv$iv6;
                    searchResult6 = toSearchResult(it14);
                    if (searchResult6 != null) {
                        destination$iv$iv6.add(searchResult6);
                    }
                    $this$mapNotNull$iv6 = $this$mapNotNull$iv112;
                }
                resultBengali = (List) destination$iv$iv6;
                Requests app14 = MainActivityKt.getApp();
                String str15 = getMainUrl() + "/movie/results/?lang=marathi&query=" + fixedQuery15;
                c00067.L$0 = fixedQuery16;
                c00067.L$1 = fixedQuery15;
                c00067.L$2 = resultHindi9;
                c00067.L$3 = resultMalayalam7;
                c00067.L$4 = resultTelugu4;
                c00067.L$5 = resultTelugu5;
                c00067.L$6 = resultKannada2;
                c00067.L$7 = resultBengali;
                c00067.label = 7;
                resultKannada3 = resultKannada2;
                resultTelugu6 = resultTelugu5;
                resultMalayalam8 = resultTelugu4;
                resultHindi10 = resultMalayalam7;
                resultTamil8 = resultHindi9;
                fixedQuery17 = fixedQuery15;
                query8 = fixedQuery16;
                C00061 c0006111 = c00067;
                $result = Requests.get$default(app14, str15, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0006111, 4094, (Object) null);
                c00068 = c0006111;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery18 = fixedQuery17;
                fixedQuery19 = query8;
                resultHindi11 = resultTamil8;
                resultMalayalam9 = resultHindi10;
                resultTelugu7 = resultMalayalam8;
                resultKannada4 = resultTelugu6;
                resultKannada5 = resultKannada3;
                resultBengali2 = resultBengali;
                $this$mapNotNull$iv7 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv7 = new ArrayList();
                while (r19.hasNext()) {
                    Iterable $this$mapNotNull$iv113 = $this$mapNotNull$iv7;
                    Element it15 = (Element) element$iv$iv$iv7;
                    searchResult7 = toSearchResult(it15);
                    if (searchResult7 != null) {
                        destination$iv$iv7.add(searchResult7);
                    }
                    $this$mapNotNull$iv7 = $this$mapNotNull$iv113;
                }
                resultMarathi = (List) destination$iv$iv7;
                Requests app15 = MainActivityKt.getApp();
                String str16 = getMainUrl() + "/movie/results/?lang=punjabi&query=" + fixedQuery18;
                c00068.L$0 = fixedQuery19;
                c00068.L$1 = SpillingKt.nullOutSpilledVariable(fixedQuery18);
                c00068.L$2 = resultHindi11;
                c00068.L$3 = resultMalayalam9;
                c00068.L$4 = resultTelugu7;
                c00068.L$5 = resultKannada4;
                c00068.L$6 = resultKannada5;
                c00068.L$7 = resultBengali2;
                c00068.L$8 = resultMarathi;
                c00068.label = 8;
                resultBengali3 = resultBengali2;
                resultKannada6 = resultKannada5;
                resultTelugu8 = resultKannada4;
                resultMalayalam10 = resultTelugu7;
                resultHindi12 = resultMalayalam9;
                resultTamil9 = resultHindi11;
                query9 = fixedQuery19;
                $result = Requests.get$default(app15, str16, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00068, 4094, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                query10 = query9;
                resultTamil10 = resultTamil9;
                resultHindi13 = resultHindi12;
                resultMalayalam11 = resultMalayalam10;
                resultTelugu9 = resultTelugu8;
                resultKannada7 = resultKannada6;
                resultBengali4 = resultBengali3;
                resultMarathi2 = resultMarathi;
                $this$mapNotNull$iv8 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv8 = new ArrayList();
                while (r18.hasNext()) {
                    Iterable $this$mapNotNull$iv114 = $this$mapNotNull$iv8;
                    Element it16 = (Element) element$iv$iv$iv8;
                    searchResult8 = toSearchResult(it16);
                    if (searchResult8 != null) {
                        destination$iv$iv8.add(searchResult8);
                    }
                    $this$mapNotNull$iv8 = $this$mapNotNull$iv114;
                }
                List resultPunjabi2 = (List) destination$iv$iv8;
                Iterable merge2 = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(resultTamil10, resultHindi13), resultMalayalam11), resultTelugu9), resultKannada7), resultBengali4), resultMarathi2), resultPunjabi2);
                Iterable $this$sortedBy$iv2 = merge2;
                return CollectionsKt.sortedWith($this$sortedBy$iv2, new Comparator() { // from class: com.cncverse.EinthusanProvider$search$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int i;
                        SearchResponse searchResponse = (SearchResponse) t;
                        String cleanName = new Regex("(\\()+(.*)+(\\))").replace(searchResponse.getName(), "").toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanName, "toLowerCase(...)");
                        String cleanQuery = query10.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanQuery, "toLowerCase(...)");
                        int i2 = 0;
                        if (StringsKt.contains$default(cleanName, cleanQuery, false, 2, (Object) null)) {
                            i = 0;
                        } else {
                            i = StringsKt.startsWith$default(cleanName, cleanQuery, false, 2, (Object) null) ? 1 : 2;
                        }
                        Integer numValueOf = Integer.valueOf(i);
                        SearchResponse searchResponse2 = (SearchResponse) t2;
                        String cleanName2 = new Regex("(\\()+(.*)+(\\))").replace(searchResponse2.getName(), "").toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanName2, "toLowerCase(...)");
                        String cleanQuery2 = query10.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanQuery2, "toLowerCase(...)");
                        if (!StringsKt.contains$default(cleanName2, cleanQuery2, false, 2, (Object) null)) {
                            i2 = StringsKt.startsWith$default(cleanName2, cleanQuery2, false, 2, (Object) null) ? 1 : 2;
                        }
                        return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(i2));
                    }
                });
            case 2:
                resultTamil2 = (List) c00061.L$2;
                String fixedQuery22 = (String) c00061.L$1;
                String query12 = (String) c00061.L$0;
                ResultKt.throwOnFailure($result);
                c00063 = c00061;
                obj = coroutine_suspended;
                str = "#UIMovieSummary > ul > li";
                fixedQuery3 = fixedQuery22;
                fixedQuery4 = query12;
                $this$mapNotNull$iv2 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv2 = new ArrayList();
                while (r14.hasNext()) {
                    Iterable $this$mapNotNull$iv115 = $this$mapNotNull$iv2;
                    Element it17 = (Element) element$iv$iv$iv2;
                    searchResult2 = toSearchResult(it17);
                    if (searchResult2 != null) {
                        destination$iv$iv2.add(searchResult2);
                    }
                    $this$mapNotNull$iv2 = $this$mapNotNull$iv115;
                }
                resultHindi = (List) destination$iv$iv2;
                Requests app16 = MainActivityKt.getApp();
                String str17 = getMainUrl() + "/movie/results/?lang=malayalam&query=" + fixedQuery3;
                c00063.L$0 = fixedQuery4;
                c00063.L$1 = fixedQuery3;
                c00063.L$2 = resultTamil2;
                c00063.L$3 = resultHindi;
                c00063.label = 3;
                resultTamil3 = resultTamil2;
                fixedQuery5 = fixedQuery3;
                query4 = fixedQuery4;
                C00061 c0006112 = c00063;
                $result = Requests.get$default(app16, str17, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0006112, 4094, (Object) null);
                c00064 = c0006112;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery6 = fixedQuery5;
                fixedQuery7 = query4;
                resultTamil4 = resultTamil3;
                resultHindi2 = resultHindi;
                $this$mapNotNull$iv3 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv3 = new ArrayList();
                while (r15.hasNext()) {
                    Iterable $this$mapNotNull$iv116 = $this$mapNotNull$iv3;
                    Element it18 = (Element) element$iv$iv$iv3;
                    searchResult3 = toSearchResult(it18);
                    if (searchResult3 != null) {
                        destination$iv$iv3.add(searchResult3);
                    }
                    $this$mapNotNull$iv3 = $this$mapNotNull$iv116;
                }
                resultMalayalam = (List) destination$iv$iv3;
                Requests app17 = MainActivityKt.getApp();
                String str18 = getMainUrl() + "/movie/results/?lang=telugu&query=" + fixedQuery6;
                c00064.L$0 = fixedQuery7;
                c00064.L$1 = fixedQuery6;
                c00064.L$2 = resultTamil4;
                c00064.L$3 = resultHindi2;
                c00064.L$4 = resultMalayalam;
                c00064.label = 4;
                resultHindi3 = resultHindi2;
                resultTamil5 = resultTamil4;
                fixedQuery8 = fixedQuery6;
                query5 = fixedQuery7;
                C00061 c0006113 = c00064;
                $result = Requests.get$default(app17, str18, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0006113, 4094, (Object) null);
                c00065 = c0006113;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery9 = fixedQuery8;
                fixedQuery10 = query5;
                resultHindi4 = resultTamil5;
                resultHindi5 = resultHindi3;
                resultMalayalam2 = resultMalayalam;
                $this$mapNotNull$iv4 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv4 = new ArrayList();
                while (r16.hasNext()) {
                    Iterable $this$mapNotNull$iv117 = $this$mapNotNull$iv4;
                    Element it19 = (Element) element$iv$iv$iv4;
                    searchResult4 = toSearchResult(it19);
                    if (searchResult4 != null) {
                        destination$iv$iv4.add(searchResult4);
                    }
                    $this$mapNotNull$iv4 = $this$mapNotNull$iv117;
                }
                resultTelugu = (List) destination$iv$iv4;
                Requests app18 = MainActivityKt.getApp();
                String str19 = getMainUrl() + "/movie/results/?lang=kannada&query=" + fixedQuery9;
                c00065.L$0 = fixedQuery10;
                c00065.L$1 = fixedQuery9;
                c00065.L$2 = resultHindi4;
                c00065.L$3 = resultHindi5;
                c00065.L$4 = resultMalayalam2;
                c00065.L$5 = resultTelugu;
                c00065.label = 5;
                resultMalayalam3 = resultMalayalam2;
                resultHindi6 = resultHindi5;
                resultTamil6 = resultHindi4;
                fixedQuery11 = fixedQuery9;
                query6 = fixedQuery10;
                C00061 c0006114 = c00065;
                $result = Requests.get$default(app18, str19, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0006114, 4094, (Object) null);
                c00066 = c0006114;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery12 = fixedQuery11;
                fixedQuery13 = query6;
                resultHindi7 = resultTamil6;
                resultMalayalam4 = resultHindi6;
                resultMalayalam5 = resultMalayalam3;
                resultTelugu2 = resultTelugu;
                $this$mapNotNull$iv5 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv5 = new ArrayList();
                while (r17.hasNext()) {
                    Iterable $this$mapNotNull$iv118 = $this$mapNotNull$iv5;
                    Element it110 = (Element) element$iv$iv$iv5;
                    searchResult5 = toSearchResult(it110);
                    if (searchResult5 != null) {
                        destination$iv$iv5.add(searchResult5);
                    }
                    $this$mapNotNull$iv5 = $this$mapNotNull$iv118;
                }
                resultKannada = (List) destination$iv$iv5;
                Requests app19 = MainActivityKt.getApp();
                String str110 = getMainUrl() + "/movie/results/?lang=bengali&query=" + fixedQuery12;
                c00066.L$0 = fixedQuery13;
                c00066.L$1 = fixedQuery12;
                c00066.L$2 = resultHindi7;
                c00066.L$3 = resultMalayalam4;
                c00066.L$4 = resultMalayalam5;
                c00066.L$5 = resultTelugu2;
                c00066.L$6 = resultKannada;
                c00066.label = 6;
                resultTelugu3 = resultTelugu2;
                resultMalayalam6 = resultMalayalam5;
                resultHindi8 = resultMalayalam4;
                resultTamil7 = resultHindi7;
                fixedQuery14 = fixedQuery12;
                query7 = fixedQuery13;
                C00061 c0006115 = c00066;
                $result = Requests.get$default(app19, str110, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0006115, 4094, (Object) null);
                c00067 = c0006115;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery15 = fixedQuery14;
                fixedQuery16 = query7;
                resultHindi9 = resultTamil7;
                resultMalayalam7 = resultHindi8;
                resultTelugu4 = resultMalayalam6;
                resultTelugu5 = resultTelugu3;
                resultKannada2 = resultKannada;
                $this$mapNotNull$iv6 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv6 = new ArrayList();
                while (r18.hasNext()) {
                    Iterable $this$mapNotNull$iv119 = $this$mapNotNull$iv6;
                    Element it111 = (Element) element$iv$iv$iv6;
                    searchResult6 = toSearchResult(it111);
                    if (searchResult6 != null) {
                        destination$iv$iv6.add(searchResult6);
                    }
                    $this$mapNotNull$iv6 = $this$mapNotNull$iv119;
                }
                resultBengali = (List) destination$iv$iv6;
                Requests app110 = MainActivityKt.getApp();
                String str111 = getMainUrl() + "/movie/results/?lang=marathi&query=" + fixedQuery15;
                c00067.L$0 = fixedQuery16;
                c00067.L$1 = fixedQuery15;
                c00067.L$2 = resultHindi9;
                c00067.L$3 = resultMalayalam7;
                c00067.L$4 = resultTelugu4;
                c00067.L$5 = resultTelugu5;
                c00067.L$6 = resultKannada2;
                c00067.L$7 = resultBengali;
                c00067.label = 7;
                resultKannada3 = resultKannada2;
                resultTelugu6 = resultTelugu5;
                resultMalayalam8 = resultTelugu4;
                resultHindi10 = resultMalayalam7;
                resultTamil8 = resultHindi9;
                fixedQuery17 = fixedQuery15;
                query8 = fixedQuery16;
                C00061 c0006116 = c00067;
                $result = Requests.get$default(app110, str111, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0006116, 4094, (Object) null);
                c00068 = c0006116;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery18 = fixedQuery17;
                fixedQuery19 = query8;
                resultHindi11 = resultTamil8;
                resultMalayalam9 = resultHindi10;
                resultTelugu7 = resultMalayalam8;
                resultKannada4 = resultTelugu6;
                resultKannada5 = resultKannada3;
                resultBengali2 = resultBengali;
                $this$mapNotNull$iv7 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv7 = new ArrayList();
                while (r19.hasNext()) {
                    Iterable $this$mapNotNull$iv1110 = $this$mapNotNull$iv7;
                    Element it112 = (Element) element$iv$iv$iv7;
                    searchResult7 = toSearchResult(it112);
                    if (searchResult7 != null) {
                        destination$iv$iv7.add(searchResult7);
                    }
                    $this$mapNotNull$iv7 = $this$mapNotNull$iv1110;
                }
                resultMarathi = (List) destination$iv$iv7;
                Requests app111 = MainActivityKt.getApp();
                String str112 = getMainUrl() + "/movie/results/?lang=punjabi&query=" + fixedQuery18;
                c00068.L$0 = fixedQuery19;
                c00068.L$1 = SpillingKt.nullOutSpilledVariable(fixedQuery18);
                c00068.L$2 = resultHindi11;
                c00068.L$3 = resultMalayalam9;
                c00068.L$4 = resultTelugu7;
                c00068.L$5 = resultKannada4;
                c00068.L$6 = resultKannada5;
                c00068.L$7 = resultBengali2;
                c00068.L$8 = resultMarathi;
                c00068.label = 8;
                resultBengali3 = resultBengali2;
                resultKannada6 = resultKannada5;
                resultTelugu8 = resultKannada4;
                resultMalayalam10 = resultTelugu7;
                resultHindi12 = resultMalayalam9;
                resultTamil9 = resultHindi11;
                query9 = fixedQuery19;
                $result = Requests.get$default(app111, str112, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00068, 4094, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                query10 = query9;
                resultTamil10 = resultTamil9;
                resultHindi13 = resultHindi12;
                resultMalayalam11 = resultMalayalam10;
                resultTelugu9 = resultTelugu8;
                resultKannada7 = resultKannada6;
                resultBengali4 = resultBengali3;
                resultMarathi2 = resultMarathi;
                $this$mapNotNull$iv8 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv8 = new ArrayList();
                while (r18.hasNext()) {
                    Iterable $this$mapNotNull$iv1111 = $this$mapNotNull$iv8;
                    Element it113 = (Element) element$iv$iv$iv8;
                    searchResult8 = toSearchResult(it113);
                    if (searchResult8 != null) {
                        destination$iv$iv8.add(searchResult8);
                    }
                    $this$mapNotNull$iv8 = $this$mapNotNull$iv1111;
                }
                List resultPunjabi3 = (List) destination$iv$iv8;
                Iterable merge3 = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(resultTamil10, resultHindi13), resultMalayalam11), resultTelugu9), resultKannada7), resultBengali4), resultMarathi2), resultPunjabi3);
                Iterable $this$sortedBy$iv3 = merge3;
                return CollectionsKt.sortedWith($this$sortedBy$iv3, new Comparator() { // from class: com.cncverse.EinthusanProvider$search$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int i;
                        SearchResponse searchResponse = (SearchResponse) t;
                        String cleanName = new Regex("(\\()+(.*)+(\\))").replace(searchResponse.getName(), "").toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanName, "toLowerCase(...)");
                        String cleanQuery = query10.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanQuery, "toLowerCase(...)");
                        int i2 = 0;
                        if (StringsKt.contains$default(cleanName, cleanQuery, false, 2, (Object) null)) {
                            i = 0;
                        } else {
                            i = StringsKt.startsWith$default(cleanName, cleanQuery, false, 2, (Object) null) ? 1 : 2;
                        }
                        Integer numValueOf = Integer.valueOf(i);
                        SearchResponse searchResponse2 = (SearchResponse) t2;
                        String cleanName2 = new Regex("(\\()+(.*)+(\\))").replace(searchResponse2.getName(), "").toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanName2, "toLowerCase(...)");
                        String cleanQuery2 = query10.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanQuery2, "toLowerCase(...)");
                        if (!StringsKt.contains$default(cleanName2, cleanQuery2, false, 2, (Object) null)) {
                            i2 = StringsKt.startsWith$default(cleanName2, cleanQuery2, false, 2, (Object) null) ? 1 : 2;
                        }
                        return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(i2));
                    }
                });
            case 3:
                resultHindi2 = (List) c00061.L$3;
                List resultTamil11 = (List) c00061.L$2;
                String fixedQuery23 = (String) c00061.L$1;
                String query13 = (String) c00061.L$0;
                ResultKt.throwOnFailure($result);
                c00064 = c00061;
                obj = coroutine_suspended;
                str = "#UIMovieSummary > ul > li";
                resultTamil4 = resultTamil11;
                fixedQuery6 = fixedQuery23;
                fixedQuery7 = query13;
                $this$mapNotNull$iv3 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv3 = new ArrayList();
                while (r15.hasNext()) {
                    Iterable $this$mapNotNull$iv1112 = $this$mapNotNull$iv3;
                    Element it114 = (Element) element$iv$iv$iv3;
                    searchResult3 = toSearchResult(it114);
                    if (searchResult3 != null) {
                        destination$iv$iv3.add(searchResult3);
                    }
                    $this$mapNotNull$iv3 = $this$mapNotNull$iv1112;
                }
                resultMalayalam = (List) destination$iv$iv3;
                Requests app112 = MainActivityKt.getApp();
                String str113 = getMainUrl() + "/movie/results/?lang=telugu&query=" + fixedQuery6;
                c00064.L$0 = fixedQuery7;
                c00064.L$1 = fixedQuery6;
                c00064.L$2 = resultTamil4;
                c00064.L$3 = resultHindi2;
                c00064.L$4 = resultMalayalam;
                c00064.label = 4;
                resultHindi3 = resultHindi2;
                resultTamil5 = resultTamil4;
                fixedQuery8 = fixedQuery6;
                query5 = fixedQuery7;
                C00061 c0006117 = c00064;
                $result = Requests.get$default(app112, str113, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0006117, 4094, (Object) null);
                c00065 = c0006117;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery9 = fixedQuery8;
                fixedQuery10 = query5;
                resultHindi4 = resultTamil5;
                resultHindi5 = resultHindi3;
                resultMalayalam2 = resultMalayalam;
                $this$mapNotNull$iv4 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv4 = new ArrayList();
                while (r16.hasNext()) {
                    Iterable $this$mapNotNull$iv1113 = $this$mapNotNull$iv4;
                    Element it115 = (Element) element$iv$iv$iv4;
                    searchResult4 = toSearchResult(it115);
                    if (searchResult4 != null) {
                        destination$iv$iv4.add(searchResult4);
                    }
                    $this$mapNotNull$iv4 = $this$mapNotNull$iv1113;
                }
                resultTelugu = (List) destination$iv$iv4;
                Requests app113 = MainActivityKt.getApp();
                String str114 = getMainUrl() + "/movie/results/?lang=kannada&query=" + fixedQuery9;
                c00065.L$0 = fixedQuery10;
                c00065.L$1 = fixedQuery9;
                c00065.L$2 = resultHindi4;
                c00065.L$3 = resultHindi5;
                c00065.L$4 = resultMalayalam2;
                c00065.L$5 = resultTelugu;
                c00065.label = 5;
                resultMalayalam3 = resultMalayalam2;
                resultHindi6 = resultHindi5;
                resultTamil6 = resultHindi4;
                fixedQuery11 = fixedQuery9;
                query6 = fixedQuery10;
                C00061 c0006118 = c00065;
                $result = Requests.get$default(app113, str114, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0006118, 4094, (Object) null);
                c00066 = c0006118;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery12 = fixedQuery11;
                fixedQuery13 = query6;
                resultHindi7 = resultTamil6;
                resultMalayalam4 = resultHindi6;
                resultMalayalam5 = resultMalayalam3;
                resultTelugu2 = resultTelugu;
                $this$mapNotNull$iv5 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv5 = new ArrayList();
                while (r17.hasNext()) {
                    Iterable $this$mapNotNull$iv1114 = $this$mapNotNull$iv5;
                    Element it116 = (Element) element$iv$iv$iv5;
                    searchResult5 = toSearchResult(it116);
                    if (searchResult5 != null) {
                        destination$iv$iv5.add(searchResult5);
                    }
                    $this$mapNotNull$iv5 = $this$mapNotNull$iv1114;
                }
                resultKannada = (List) destination$iv$iv5;
                Requests app114 = MainActivityKt.getApp();
                String str115 = getMainUrl() + "/movie/results/?lang=bengali&query=" + fixedQuery12;
                c00066.L$0 = fixedQuery13;
                c00066.L$1 = fixedQuery12;
                c00066.L$2 = resultHindi7;
                c00066.L$3 = resultMalayalam4;
                c00066.L$4 = resultMalayalam5;
                c00066.L$5 = resultTelugu2;
                c00066.L$6 = resultKannada;
                c00066.label = 6;
                resultTelugu3 = resultTelugu2;
                resultMalayalam6 = resultMalayalam5;
                resultHindi8 = resultMalayalam4;
                resultTamil7 = resultHindi7;
                fixedQuery14 = fixedQuery12;
                query7 = fixedQuery13;
                C00061 c0006119 = c00066;
                $result = Requests.get$default(app114, str115, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0006119, 4094, (Object) null);
                c00067 = c0006119;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery15 = fixedQuery14;
                fixedQuery16 = query7;
                resultHindi9 = resultTamil7;
                resultMalayalam7 = resultHindi8;
                resultTelugu4 = resultMalayalam6;
                resultTelugu5 = resultTelugu3;
                resultKannada2 = resultKannada;
                $this$mapNotNull$iv6 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv6 = new ArrayList();
                while (r18.hasNext()) {
                    Iterable $this$mapNotNull$iv1115 = $this$mapNotNull$iv6;
                    Element it117 = (Element) element$iv$iv$iv6;
                    searchResult6 = toSearchResult(it117);
                    if (searchResult6 != null) {
                        destination$iv$iv6.add(searchResult6);
                    }
                    $this$mapNotNull$iv6 = $this$mapNotNull$iv1115;
                }
                resultBengali = (List) destination$iv$iv6;
                Requests app115 = MainActivityKt.getApp();
                String str116 = getMainUrl() + "/movie/results/?lang=marathi&query=" + fixedQuery15;
                c00067.L$0 = fixedQuery16;
                c00067.L$1 = fixedQuery15;
                c00067.L$2 = resultHindi9;
                c00067.L$3 = resultMalayalam7;
                c00067.L$4 = resultTelugu4;
                c00067.L$5 = resultTelugu5;
                c00067.L$6 = resultKannada2;
                c00067.L$7 = resultBengali;
                c00067.label = 7;
                resultKannada3 = resultKannada2;
                resultTelugu6 = resultTelugu5;
                resultMalayalam8 = resultTelugu4;
                resultHindi10 = resultMalayalam7;
                resultTamil8 = resultHindi9;
                fixedQuery17 = fixedQuery15;
                query8 = fixedQuery16;
                C00061 c00061110 = c00067;
                $result = Requests.get$default(app115, str116, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00061110, 4094, (Object) null);
                c00068 = c00061110;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery18 = fixedQuery17;
                fixedQuery19 = query8;
                resultHindi11 = resultTamil8;
                resultMalayalam9 = resultHindi10;
                resultTelugu7 = resultMalayalam8;
                resultKannada4 = resultTelugu6;
                resultKannada5 = resultKannada3;
                resultBengali2 = resultBengali;
                $this$mapNotNull$iv7 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv7 = new ArrayList();
                while (r19.hasNext()) {
                    Iterable $this$mapNotNull$iv1116 = $this$mapNotNull$iv7;
                    Element it118 = (Element) element$iv$iv$iv7;
                    searchResult7 = toSearchResult(it118);
                    if (searchResult7 != null) {
                        destination$iv$iv7.add(searchResult7);
                    }
                    $this$mapNotNull$iv7 = $this$mapNotNull$iv1116;
                }
                resultMarathi = (List) destination$iv$iv7;
                Requests app116 = MainActivityKt.getApp();
                String str117 = getMainUrl() + "/movie/results/?lang=punjabi&query=" + fixedQuery18;
                c00068.L$0 = fixedQuery19;
                c00068.L$1 = SpillingKt.nullOutSpilledVariable(fixedQuery18);
                c00068.L$2 = resultHindi11;
                c00068.L$3 = resultMalayalam9;
                c00068.L$4 = resultTelugu7;
                c00068.L$5 = resultKannada4;
                c00068.L$6 = resultKannada5;
                c00068.L$7 = resultBengali2;
                c00068.L$8 = resultMarathi;
                c00068.label = 8;
                resultBengali3 = resultBengali2;
                resultKannada6 = resultKannada5;
                resultTelugu8 = resultKannada4;
                resultMalayalam10 = resultTelugu7;
                resultHindi12 = resultMalayalam9;
                resultTamil9 = resultHindi11;
                query9 = fixedQuery19;
                $result = Requests.get$default(app116, str117, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00068, 4094, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                query10 = query9;
                resultTamil10 = resultTamil9;
                resultHindi13 = resultHindi12;
                resultMalayalam11 = resultMalayalam10;
                resultTelugu9 = resultTelugu8;
                resultKannada7 = resultKannada6;
                resultBengali4 = resultBengali3;
                resultMarathi2 = resultMarathi;
                $this$mapNotNull$iv8 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv8 = new ArrayList();
                while (r18.hasNext()) {
                    Iterable $this$mapNotNull$iv1117 = $this$mapNotNull$iv8;
                    Element it119 = (Element) element$iv$iv$iv8;
                    searchResult8 = toSearchResult(it119);
                    if (searchResult8 != null) {
                        destination$iv$iv8.add(searchResult8);
                    }
                    $this$mapNotNull$iv8 = $this$mapNotNull$iv1117;
                }
                List resultPunjabi4 = (List) destination$iv$iv8;
                Iterable merge4 = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(resultTamil10, resultHindi13), resultMalayalam11), resultTelugu9), resultKannada7), resultBengali4), resultMarathi2), resultPunjabi4);
                Iterable $this$sortedBy$iv4 = merge4;
                return CollectionsKt.sortedWith($this$sortedBy$iv4, new Comparator() { // from class: com.cncverse.EinthusanProvider$search$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int i;
                        SearchResponse searchResponse = (SearchResponse) t;
                        String cleanName = new Regex("(\\()+(.*)+(\\))").replace(searchResponse.getName(), "").toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanName, "toLowerCase(...)");
                        String cleanQuery = query10.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanQuery, "toLowerCase(...)");
                        int i2 = 0;
                        if (StringsKt.contains$default(cleanName, cleanQuery, false, 2, (Object) null)) {
                            i = 0;
                        } else {
                            i = StringsKt.startsWith$default(cleanName, cleanQuery, false, 2, (Object) null) ? 1 : 2;
                        }
                        Integer numValueOf = Integer.valueOf(i);
                        SearchResponse searchResponse2 = (SearchResponse) t2;
                        String cleanName2 = new Regex("(\\()+(.*)+(\\))").replace(searchResponse2.getName(), "").toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanName2, "toLowerCase(...)");
                        String cleanQuery2 = query10.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanQuery2, "toLowerCase(...)");
                        if (!StringsKt.contains$default(cleanName2, cleanQuery2, false, 2, (Object) null)) {
                            i2 = StringsKt.startsWith$default(cleanName2, cleanQuery2, false, 2, (Object) null) ? 1 : 2;
                        }
                        return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(i2));
                    }
                });
            case 4:
                resultMalayalam2 = (List) c00061.L$4;
                List resultHindi14 = (List) c00061.L$3;
                List resultTamil12 = (List) c00061.L$2;
                String fixedQuery24 = (String) c00061.L$1;
                String query14 = (String) c00061.L$0;
                ResultKt.throwOnFailure($result);
                c00065 = c00061;
                obj = coroutine_suspended;
                str = "#UIMovieSummary > ul > li";
                resultHindi5 = resultHindi14;
                resultHindi4 = resultTamil12;
                fixedQuery9 = fixedQuery24;
                fixedQuery10 = query14;
                $this$mapNotNull$iv4 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv4 = new ArrayList();
                while (r16.hasNext()) {
                    Iterable $this$mapNotNull$iv1118 = $this$mapNotNull$iv4;
                    Element it1110 = (Element) element$iv$iv$iv4;
                    searchResult4 = toSearchResult(it1110);
                    if (searchResult4 != null) {
                        destination$iv$iv4.add(searchResult4);
                    }
                    $this$mapNotNull$iv4 = $this$mapNotNull$iv1118;
                }
                resultTelugu = (List) destination$iv$iv4;
                Requests app117 = MainActivityKt.getApp();
                String str118 = getMainUrl() + "/movie/results/?lang=kannada&query=" + fixedQuery9;
                c00065.L$0 = fixedQuery10;
                c00065.L$1 = fixedQuery9;
                c00065.L$2 = resultHindi4;
                c00065.L$3 = resultHindi5;
                c00065.L$4 = resultMalayalam2;
                c00065.L$5 = resultTelugu;
                c00065.label = 5;
                resultMalayalam3 = resultMalayalam2;
                resultHindi6 = resultHindi5;
                resultTamil6 = resultHindi4;
                fixedQuery11 = fixedQuery9;
                query6 = fixedQuery10;
                C00061 c00061111 = c00065;
                $result = Requests.get$default(app117, str118, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00061111, 4094, (Object) null);
                c00066 = c00061111;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery12 = fixedQuery11;
                fixedQuery13 = query6;
                resultHindi7 = resultTamil6;
                resultMalayalam4 = resultHindi6;
                resultMalayalam5 = resultMalayalam3;
                resultTelugu2 = resultTelugu;
                $this$mapNotNull$iv5 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv5 = new ArrayList();
                while (r17.hasNext()) {
                    Iterable $this$mapNotNull$iv1119 = $this$mapNotNull$iv5;
                    Element it1111 = (Element) element$iv$iv$iv5;
                    searchResult5 = toSearchResult(it1111);
                    if (searchResult5 != null) {
                        destination$iv$iv5.add(searchResult5);
                    }
                    $this$mapNotNull$iv5 = $this$mapNotNull$iv1119;
                }
                resultKannada = (List) destination$iv$iv5;
                Requests app118 = MainActivityKt.getApp();
                String str119 = getMainUrl() + "/movie/results/?lang=bengali&query=" + fixedQuery12;
                c00066.L$0 = fixedQuery13;
                c00066.L$1 = fixedQuery12;
                c00066.L$2 = resultHindi7;
                c00066.L$3 = resultMalayalam4;
                c00066.L$4 = resultMalayalam5;
                c00066.L$5 = resultTelugu2;
                c00066.L$6 = resultKannada;
                c00066.label = 6;
                resultTelugu3 = resultTelugu2;
                resultMalayalam6 = resultMalayalam5;
                resultHindi8 = resultMalayalam4;
                resultTamil7 = resultHindi7;
                fixedQuery14 = fixedQuery12;
                query7 = fixedQuery13;
                C00061 c00061112 = c00066;
                $result = Requests.get$default(app118, str119, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00061112, 4094, (Object) null);
                c00067 = c00061112;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery15 = fixedQuery14;
                fixedQuery16 = query7;
                resultHindi9 = resultTamil7;
                resultMalayalam7 = resultHindi8;
                resultTelugu4 = resultMalayalam6;
                resultTelugu5 = resultTelugu3;
                resultKannada2 = resultKannada;
                $this$mapNotNull$iv6 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv6 = new ArrayList();
                while (r18.hasNext()) {
                    Iterable $this$mapNotNull$iv11110 = $this$mapNotNull$iv6;
                    Element it1112 = (Element) element$iv$iv$iv6;
                    searchResult6 = toSearchResult(it1112);
                    if (searchResult6 != null) {
                        destination$iv$iv6.add(searchResult6);
                    }
                    $this$mapNotNull$iv6 = $this$mapNotNull$iv11110;
                }
                resultBengali = (List) destination$iv$iv6;
                Requests app119 = MainActivityKt.getApp();
                String str1110 = getMainUrl() + "/movie/results/?lang=marathi&query=" + fixedQuery15;
                c00067.L$0 = fixedQuery16;
                c00067.L$1 = fixedQuery15;
                c00067.L$2 = resultHindi9;
                c00067.L$3 = resultMalayalam7;
                c00067.L$4 = resultTelugu4;
                c00067.L$5 = resultTelugu5;
                c00067.L$6 = resultKannada2;
                c00067.L$7 = resultBengali;
                c00067.label = 7;
                resultKannada3 = resultKannada2;
                resultTelugu6 = resultTelugu5;
                resultMalayalam8 = resultTelugu4;
                resultHindi10 = resultMalayalam7;
                resultTamil8 = resultHindi9;
                fixedQuery17 = fixedQuery15;
                query8 = fixedQuery16;
                C00061 c00061113 = c00067;
                $result = Requests.get$default(app119, str1110, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00061113, 4094, (Object) null);
                c00068 = c00061113;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery18 = fixedQuery17;
                fixedQuery19 = query8;
                resultHindi11 = resultTamil8;
                resultMalayalam9 = resultHindi10;
                resultTelugu7 = resultMalayalam8;
                resultKannada4 = resultTelugu6;
                resultKannada5 = resultKannada3;
                resultBengali2 = resultBengali;
                $this$mapNotNull$iv7 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv7 = new ArrayList();
                while (r19.hasNext()) {
                    Iterable $this$mapNotNull$iv11111 = $this$mapNotNull$iv7;
                    Element it1113 = (Element) element$iv$iv$iv7;
                    searchResult7 = toSearchResult(it1113);
                    if (searchResult7 != null) {
                        destination$iv$iv7.add(searchResult7);
                    }
                    $this$mapNotNull$iv7 = $this$mapNotNull$iv11111;
                }
                resultMarathi = (List) destination$iv$iv7;
                Requests app1110 = MainActivityKt.getApp();
                String str1111 = getMainUrl() + "/movie/results/?lang=punjabi&query=" + fixedQuery18;
                c00068.L$0 = fixedQuery19;
                c00068.L$1 = SpillingKt.nullOutSpilledVariable(fixedQuery18);
                c00068.L$2 = resultHindi11;
                c00068.L$3 = resultMalayalam9;
                c00068.L$4 = resultTelugu7;
                c00068.L$5 = resultKannada4;
                c00068.L$6 = resultKannada5;
                c00068.L$7 = resultBengali2;
                c00068.L$8 = resultMarathi;
                c00068.label = 8;
                resultBengali3 = resultBengali2;
                resultKannada6 = resultKannada5;
                resultTelugu8 = resultKannada4;
                resultMalayalam10 = resultTelugu7;
                resultHindi12 = resultMalayalam9;
                resultTamil9 = resultHindi11;
                query9 = fixedQuery19;
                $result = Requests.get$default(app1110, str1111, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00068, 4094, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                query10 = query9;
                resultTamil10 = resultTamil9;
                resultHindi13 = resultHindi12;
                resultMalayalam11 = resultMalayalam10;
                resultTelugu9 = resultTelugu8;
                resultKannada7 = resultKannada6;
                resultBengali4 = resultBengali3;
                resultMarathi2 = resultMarathi;
                $this$mapNotNull$iv8 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv8 = new ArrayList();
                while (r18.hasNext()) {
                    Iterable $this$mapNotNull$iv11112 = $this$mapNotNull$iv8;
                    Element it1114 = (Element) element$iv$iv$iv8;
                    searchResult8 = toSearchResult(it1114);
                    if (searchResult8 != null) {
                        destination$iv$iv8.add(searchResult8);
                    }
                    $this$mapNotNull$iv8 = $this$mapNotNull$iv11112;
                }
                List resultPunjabi5 = (List) destination$iv$iv8;
                Iterable merge5 = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(resultTamil10, resultHindi13), resultMalayalam11), resultTelugu9), resultKannada7), resultBengali4), resultMarathi2), resultPunjabi5);
                Iterable $this$sortedBy$iv5 = merge5;
                return CollectionsKt.sortedWith($this$sortedBy$iv5, new Comparator() { // from class: com.cncverse.EinthusanProvider$search$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int i;
                        SearchResponse searchResponse = (SearchResponse) t;
                        String cleanName = new Regex("(\\()+(.*)+(\\))").replace(searchResponse.getName(), "").toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanName, "toLowerCase(...)");
                        String cleanQuery = query10.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanQuery, "toLowerCase(...)");
                        int i2 = 0;
                        if (StringsKt.contains$default(cleanName, cleanQuery, false, 2, (Object) null)) {
                            i = 0;
                        } else {
                            i = StringsKt.startsWith$default(cleanName, cleanQuery, false, 2, (Object) null) ? 1 : 2;
                        }
                        Integer numValueOf = Integer.valueOf(i);
                        SearchResponse searchResponse2 = (SearchResponse) t2;
                        String cleanName2 = new Regex("(\\()+(.*)+(\\))").replace(searchResponse2.getName(), "").toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanName2, "toLowerCase(...)");
                        String cleanQuery2 = query10.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanQuery2, "toLowerCase(...)");
                        if (!StringsKt.contains$default(cleanName2, cleanQuery2, false, 2, (Object) null)) {
                            i2 = StringsKt.startsWith$default(cleanName2, cleanQuery2, false, 2, (Object) null) ? 1 : 2;
                        }
                        return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(i2));
                    }
                });
            case 5:
                resultTelugu2 = (List) c00061.L$5;
                List resultMalayalam12 = (List) c00061.L$4;
                List resultHindi15 = (List) c00061.L$3;
                List resultTamil13 = (List) c00061.L$2;
                String fixedQuery25 = (String) c00061.L$1;
                String query15 = (String) c00061.L$0;
                ResultKt.throwOnFailure($result);
                c00066 = c00061;
                obj = coroutine_suspended;
                str = "#UIMovieSummary > ul > li";
                resultMalayalam5 = resultMalayalam12;
                resultMalayalam4 = resultHindi15;
                resultHindi7 = resultTamil13;
                fixedQuery12 = fixedQuery25;
                fixedQuery13 = query15;
                $this$mapNotNull$iv5 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv5 = new ArrayList();
                while (r17.hasNext()) {
                    Iterable $this$mapNotNull$iv11113 = $this$mapNotNull$iv5;
                    Element it1115 = (Element) element$iv$iv$iv5;
                    searchResult5 = toSearchResult(it1115);
                    if (searchResult5 != null) {
                        destination$iv$iv5.add(searchResult5);
                    }
                    $this$mapNotNull$iv5 = $this$mapNotNull$iv11113;
                }
                resultKannada = (List) destination$iv$iv5;
                Requests app1111 = MainActivityKt.getApp();
                String str1112 = getMainUrl() + "/movie/results/?lang=bengali&query=" + fixedQuery12;
                c00066.L$0 = fixedQuery13;
                c00066.L$1 = fixedQuery12;
                c00066.L$2 = resultHindi7;
                c00066.L$3 = resultMalayalam4;
                c00066.L$4 = resultMalayalam5;
                c00066.L$5 = resultTelugu2;
                c00066.L$6 = resultKannada;
                c00066.label = 6;
                resultTelugu3 = resultTelugu2;
                resultMalayalam6 = resultMalayalam5;
                resultHindi8 = resultMalayalam4;
                resultTamil7 = resultHindi7;
                fixedQuery14 = fixedQuery12;
                query7 = fixedQuery13;
                C00061 c00061114 = c00066;
                $result = Requests.get$default(app1111, str1112, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00061114, 4094, (Object) null);
                c00067 = c00061114;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery15 = fixedQuery14;
                fixedQuery16 = query7;
                resultHindi9 = resultTamil7;
                resultMalayalam7 = resultHindi8;
                resultTelugu4 = resultMalayalam6;
                resultTelugu5 = resultTelugu3;
                resultKannada2 = resultKannada;
                $this$mapNotNull$iv6 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv6 = new ArrayList();
                while (r18.hasNext()) {
                    Iterable $this$mapNotNull$iv11114 = $this$mapNotNull$iv6;
                    Element it1116 = (Element) element$iv$iv$iv6;
                    searchResult6 = toSearchResult(it1116);
                    if (searchResult6 != null) {
                        destination$iv$iv6.add(searchResult6);
                    }
                    $this$mapNotNull$iv6 = $this$mapNotNull$iv11114;
                }
                resultBengali = (List) destination$iv$iv6;
                Requests app1112 = MainActivityKt.getApp();
                String str1113 = getMainUrl() + "/movie/results/?lang=marathi&query=" + fixedQuery15;
                c00067.L$0 = fixedQuery16;
                c00067.L$1 = fixedQuery15;
                c00067.L$2 = resultHindi9;
                c00067.L$3 = resultMalayalam7;
                c00067.L$4 = resultTelugu4;
                c00067.L$5 = resultTelugu5;
                c00067.L$6 = resultKannada2;
                c00067.L$7 = resultBengali;
                c00067.label = 7;
                resultKannada3 = resultKannada2;
                resultTelugu6 = resultTelugu5;
                resultMalayalam8 = resultTelugu4;
                resultHindi10 = resultMalayalam7;
                resultTamil8 = resultHindi9;
                fixedQuery17 = fixedQuery15;
                query8 = fixedQuery16;
                C00061 c00061115 = c00067;
                $result = Requests.get$default(app1112, str1113, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00061115, 4094, (Object) null);
                c00068 = c00061115;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery18 = fixedQuery17;
                fixedQuery19 = query8;
                resultHindi11 = resultTamil8;
                resultMalayalam9 = resultHindi10;
                resultTelugu7 = resultMalayalam8;
                resultKannada4 = resultTelugu6;
                resultKannada5 = resultKannada3;
                resultBengali2 = resultBengali;
                $this$mapNotNull$iv7 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv7 = new ArrayList();
                while (r19.hasNext()) {
                    Iterable $this$mapNotNull$iv11115 = $this$mapNotNull$iv7;
                    Element it1117 = (Element) element$iv$iv$iv7;
                    searchResult7 = toSearchResult(it1117);
                    if (searchResult7 != null) {
                        destination$iv$iv7.add(searchResult7);
                    }
                    $this$mapNotNull$iv7 = $this$mapNotNull$iv11115;
                }
                resultMarathi = (List) destination$iv$iv7;
                Requests app1113 = MainActivityKt.getApp();
                String str1114 = getMainUrl() + "/movie/results/?lang=punjabi&query=" + fixedQuery18;
                c00068.L$0 = fixedQuery19;
                c00068.L$1 = SpillingKt.nullOutSpilledVariable(fixedQuery18);
                c00068.L$2 = resultHindi11;
                c00068.L$3 = resultMalayalam9;
                c00068.L$4 = resultTelugu7;
                c00068.L$5 = resultKannada4;
                c00068.L$6 = resultKannada5;
                c00068.L$7 = resultBengali2;
                c00068.L$8 = resultMarathi;
                c00068.label = 8;
                resultBengali3 = resultBengali2;
                resultKannada6 = resultKannada5;
                resultTelugu8 = resultKannada4;
                resultMalayalam10 = resultTelugu7;
                resultHindi12 = resultMalayalam9;
                resultTamil9 = resultHindi11;
                query9 = fixedQuery19;
                $result = Requests.get$default(app1113, str1114, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00068, 4094, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                query10 = query9;
                resultTamil10 = resultTamil9;
                resultHindi13 = resultHindi12;
                resultMalayalam11 = resultMalayalam10;
                resultTelugu9 = resultTelugu8;
                resultKannada7 = resultKannada6;
                resultBengali4 = resultBengali3;
                resultMarathi2 = resultMarathi;
                $this$mapNotNull$iv8 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv8 = new ArrayList();
                while (r18.hasNext()) {
                    Iterable $this$mapNotNull$iv11116 = $this$mapNotNull$iv8;
                    Element it1118 = (Element) element$iv$iv$iv8;
                    searchResult8 = toSearchResult(it1118);
                    if (searchResult8 != null) {
                        destination$iv$iv8.add(searchResult8);
                    }
                    $this$mapNotNull$iv8 = $this$mapNotNull$iv11116;
                }
                List resultPunjabi6 = (List) destination$iv$iv8;
                Iterable merge6 = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(resultTamil10, resultHindi13), resultMalayalam11), resultTelugu9), resultKannada7), resultBengali4), resultMarathi2), resultPunjabi6);
                Iterable $this$sortedBy$iv6 = merge6;
                return CollectionsKt.sortedWith($this$sortedBy$iv6, new Comparator() { // from class: com.cncverse.EinthusanProvider$search$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int i;
                        SearchResponse searchResponse = (SearchResponse) t;
                        String cleanName = new Regex("(\\()+(.*)+(\\))").replace(searchResponse.getName(), "").toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanName, "toLowerCase(...)");
                        String cleanQuery = query10.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanQuery, "toLowerCase(...)");
                        int i2 = 0;
                        if (StringsKt.contains$default(cleanName, cleanQuery, false, 2, (Object) null)) {
                            i = 0;
                        } else {
                            i = StringsKt.startsWith$default(cleanName, cleanQuery, false, 2, (Object) null) ? 1 : 2;
                        }
                        Integer numValueOf = Integer.valueOf(i);
                        SearchResponse searchResponse2 = (SearchResponse) t2;
                        String cleanName2 = new Regex("(\\()+(.*)+(\\))").replace(searchResponse2.getName(), "").toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanName2, "toLowerCase(...)");
                        String cleanQuery2 = query10.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanQuery2, "toLowerCase(...)");
                        if (!StringsKt.contains$default(cleanName2, cleanQuery2, false, 2, (Object) null)) {
                            i2 = StringsKt.startsWith$default(cleanName2, cleanQuery2, false, 2, (Object) null) ? 1 : 2;
                        }
                        return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(i2));
                    }
                });
            case 6:
                resultKannada2 = (List) c00061.L$6;
                List resultTelugu10 = (List) c00061.L$5;
                List resultMalayalam13 = (List) c00061.L$4;
                List resultHindi16 = (List) c00061.L$3;
                List resultTamil14 = (List) c00061.L$2;
                String fixedQuery26 = (String) c00061.L$1;
                String query16 = (String) c00061.L$0;
                ResultKt.throwOnFailure($result);
                c00067 = c00061;
                obj = coroutine_suspended;
                str = "#UIMovieSummary > ul > li";
                resultTelugu5 = resultTelugu10;
                resultTelugu4 = resultMalayalam13;
                resultMalayalam7 = resultHindi16;
                resultHindi9 = resultTamil14;
                fixedQuery15 = fixedQuery26;
                fixedQuery16 = query16;
                $this$mapNotNull$iv6 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv6 = new ArrayList();
                while (r18.hasNext()) {
                    Iterable $this$mapNotNull$iv11117 = $this$mapNotNull$iv6;
                    Element it1119 = (Element) element$iv$iv$iv6;
                    searchResult6 = toSearchResult(it1119);
                    if (searchResult6 != null) {
                        destination$iv$iv6.add(searchResult6);
                    }
                    $this$mapNotNull$iv6 = $this$mapNotNull$iv11117;
                }
                resultBengali = (List) destination$iv$iv6;
                Requests app1114 = MainActivityKt.getApp();
                String str1115 = getMainUrl() + "/movie/results/?lang=marathi&query=" + fixedQuery15;
                c00067.L$0 = fixedQuery16;
                c00067.L$1 = fixedQuery15;
                c00067.L$2 = resultHindi9;
                c00067.L$3 = resultMalayalam7;
                c00067.L$4 = resultTelugu4;
                c00067.L$5 = resultTelugu5;
                c00067.L$6 = resultKannada2;
                c00067.L$7 = resultBengali;
                c00067.label = 7;
                resultKannada3 = resultKannada2;
                resultTelugu6 = resultTelugu5;
                resultMalayalam8 = resultTelugu4;
                resultHindi10 = resultMalayalam7;
                resultTamil8 = resultHindi9;
                fixedQuery17 = fixedQuery15;
                query8 = fixedQuery16;
                C00061 c00061116 = c00067;
                $result = Requests.get$default(app1114, str1115, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00061116, 4094, (Object) null);
                c00068 = c00061116;
                if ($result == obj) {
                    return obj;
                }
                fixedQuery18 = fixedQuery17;
                fixedQuery19 = query8;
                resultHindi11 = resultTamil8;
                resultMalayalam9 = resultHindi10;
                resultTelugu7 = resultMalayalam8;
                resultKannada4 = resultTelugu6;
                resultKannada5 = resultKannada3;
                resultBengali2 = resultBengali;
                $this$mapNotNull$iv7 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv7 = new ArrayList();
                while (r19.hasNext()) {
                    Iterable $this$mapNotNull$iv11118 = $this$mapNotNull$iv7;
                    Element it11110 = (Element) element$iv$iv$iv7;
                    searchResult7 = toSearchResult(it11110);
                    if (searchResult7 != null) {
                        destination$iv$iv7.add(searchResult7);
                    }
                    $this$mapNotNull$iv7 = $this$mapNotNull$iv11118;
                }
                resultMarathi = (List) destination$iv$iv7;
                Requests app1115 = MainActivityKt.getApp();
                String str1116 = getMainUrl() + "/movie/results/?lang=punjabi&query=" + fixedQuery18;
                c00068.L$0 = fixedQuery19;
                c00068.L$1 = SpillingKt.nullOutSpilledVariable(fixedQuery18);
                c00068.L$2 = resultHindi11;
                c00068.L$3 = resultMalayalam9;
                c00068.L$4 = resultTelugu7;
                c00068.L$5 = resultKannada4;
                c00068.L$6 = resultKannada5;
                c00068.L$7 = resultBengali2;
                c00068.L$8 = resultMarathi;
                c00068.label = 8;
                resultBengali3 = resultBengali2;
                resultKannada6 = resultKannada5;
                resultTelugu8 = resultKannada4;
                resultMalayalam10 = resultTelugu7;
                resultHindi12 = resultMalayalam9;
                resultTamil9 = resultHindi11;
                query9 = fixedQuery19;
                $result = Requests.get$default(app1115, str1116, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00068, 4094, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                query10 = query9;
                resultTamil10 = resultTamil9;
                resultHindi13 = resultHindi12;
                resultMalayalam11 = resultMalayalam10;
                resultTelugu9 = resultTelugu8;
                resultKannada7 = resultKannada6;
                resultBengali4 = resultBengali3;
                resultMarathi2 = resultMarathi;
                $this$mapNotNull$iv8 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv8 = new ArrayList();
                while (r18.hasNext()) {
                    Iterable $this$mapNotNull$iv11119 = $this$mapNotNull$iv8;
                    Element it11111 = (Element) element$iv$iv$iv8;
                    searchResult8 = toSearchResult(it11111);
                    if (searchResult8 != null) {
                        destination$iv$iv8.add(searchResult8);
                    }
                    $this$mapNotNull$iv8 = $this$mapNotNull$iv11119;
                }
                List resultPunjabi7 = (List) destination$iv$iv8;
                Iterable merge7 = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(resultTamil10, resultHindi13), resultMalayalam11), resultTelugu9), resultKannada7), resultBengali4), resultMarathi2), resultPunjabi7);
                Iterable $this$sortedBy$iv7 = merge7;
                return CollectionsKt.sortedWith($this$sortedBy$iv7, new Comparator() { // from class: com.cncverse.EinthusanProvider$search$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int i;
                        SearchResponse searchResponse = (SearchResponse) t;
                        String cleanName = new Regex("(\\()+(.*)+(\\))").replace(searchResponse.getName(), "").toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanName, "toLowerCase(...)");
                        String cleanQuery = query10.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanQuery, "toLowerCase(...)");
                        int i2 = 0;
                        if (StringsKt.contains$default(cleanName, cleanQuery, false, 2, (Object) null)) {
                            i = 0;
                        } else {
                            i = StringsKt.startsWith$default(cleanName, cleanQuery, false, 2, (Object) null) ? 1 : 2;
                        }
                        Integer numValueOf = Integer.valueOf(i);
                        SearchResponse searchResponse2 = (SearchResponse) t2;
                        String cleanName2 = new Regex("(\\()+(.*)+(\\))").replace(searchResponse2.getName(), "").toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanName2, "toLowerCase(...)");
                        String cleanQuery2 = query10.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanQuery2, "toLowerCase(...)");
                        if (!StringsKt.contains$default(cleanName2, cleanQuery2, false, 2, (Object) null)) {
                            i2 = StringsKt.startsWith$default(cleanName2, cleanQuery2, false, 2, (Object) null) ? 1 : 2;
                        }
                        return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(i2));
                    }
                });
            case 7:
                resultBengali2 = (List) c00061.L$7;
                List resultKannada8 = (List) c00061.L$6;
                List resultTelugu11 = (List) c00061.L$5;
                List resultMalayalam14 = (List) c00061.L$4;
                List resultHindi17 = (List) c00061.L$3;
                List resultTamil15 = (List) c00061.L$2;
                String fixedQuery27 = (String) c00061.L$1;
                String query17 = (String) c00061.L$0;
                ResultKt.throwOnFailure($result);
                c00068 = c00061;
                obj = coroutine_suspended;
                str = "#UIMovieSummary > ul > li";
                resultKannada5 = resultKannada8;
                resultKannada4 = resultTelugu11;
                resultTelugu7 = resultMalayalam14;
                resultMalayalam9 = resultHindi17;
                resultHindi11 = resultTamil15;
                fixedQuery18 = fixedQuery27;
                fixedQuery19 = query17;
                $this$mapNotNull$iv7 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv7 = new ArrayList();
                while (r19.hasNext()) {
                    Iterable $this$mapNotNull$iv111110 = $this$mapNotNull$iv7;
                    Element it11112 = (Element) element$iv$iv$iv7;
                    searchResult7 = toSearchResult(it11112);
                    if (searchResult7 != null) {
                        destination$iv$iv7.add(searchResult7);
                    }
                    $this$mapNotNull$iv7 = $this$mapNotNull$iv111110;
                }
                resultMarathi = (List) destination$iv$iv7;
                Requests app1116 = MainActivityKt.getApp();
                String str1117 = getMainUrl() + "/movie/results/?lang=punjabi&query=" + fixedQuery18;
                c00068.L$0 = fixedQuery19;
                c00068.L$1 = SpillingKt.nullOutSpilledVariable(fixedQuery18);
                c00068.L$2 = resultHindi11;
                c00068.L$3 = resultMalayalam9;
                c00068.L$4 = resultTelugu7;
                c00068.L$5 = resultKannada4;
                c00068.L$6 = resultKannada5;
                c00068.L$7 = resultBengali2;
                c00068.L$8 = resultMarathi;
                c00068.label = 8;
                resultBengali3 = resultBengali2;
                resultKannada6 = resultKannada5;
                resultTelugu8 = resultKannada4;
                resultMalayalam10 = resultTelugu7;
                resultHindi12 = resultMalayalam9;
                resultTamil9 = resultHindi11;
                query9 = fixedQuery19;
                $result = Requests.get$default(app1116, str1117, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00068, 4094, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                query10 = query9;
                resultTamil10 = resultTamil9;
                resultHindi13 = resultHindi12;
                resultMalayalam11 = resultMalayalam10;
                resultTelugu9 = resultTelugu8;
                resultKannada7 = resultKannada6;
                resultBengali4 = resultBengali3;
                resultMarathi2 = resultMarathi;
                $this$mapNotNull$iv8 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv8 = new ArrayList();
                while (r18.hasNext()) {
                    Iterable $this$mapNotNull$iv111111 = $this$mapNotNull$iv8;
                    Element it11113 = (Element) element$iv$iv$iv8;
                    searchResult8 = toSearchResult(it11113);
                    if (searchResult8 != null) {
                        destination$iv$iv8.add(searchResult8);
                    }
                    $this$mapNotNull$iv8 = $this$mapNotNull$iv111111;
                }
                List resultPunjabi8 = (List) destination$iv$iv8;
                Iterable merge8 = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(resultTamil10, resultHindi13), resultMalayalam11), resultTelugu9), resultKannada7), resultBengali4), resultMarathi2), resultPunjabi8);
                Iterable $this$sortedBy$iv8 = merge8;
                return CollectionsKt.sortedWith($this$sortedBy$iv8, new Comparator() { // from class: com.cncverse.EinthusanProvider$search$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int i;
                        SearchResponse searchResponse = (SearchResponse) t;
                        String cleanName = new Regex("(\\()+(.*)+(\\))").replace(searchResponse.getName(), "").toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanName, "toLowerCase(...)");
                        String cleanQuery = query10.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanQuery, "toLowerCase(...)");
                        int i2 = 0;
                        if (StringsKt.contains$default(cleanName, cleanQuery, false, 2, (Object) null)) {
                            i = 0;
                        } else {
                            i = StringsKt.startsWith$default(cleanName, cleanQuery, false, 2, (Object) null) ? 1 : 2;
                        }
                        Integer numValueOf = Integer.valueOf(i);
                        SearchResponse searchResponse2 = (SearchResponse) t2;
                        String cleanName2 = new Regex("(\\()+(.*)+(\\))").replace(searchResponse2.getName(), "").toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanName2, "toLowerCase(...)");
                        String cleanQuery2 = query10.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanQuery2, "toLowerCase(...)");
                        if (!StringsKt.contains$default(cleanName2, cleanQuery2, false, 2, (Object) null)) {
                            i2 = StringsKt.startsWith$default(cleanName2, cleanQuery2, false, 2, (Object) null) ? 1 : 2;
                        }
                        return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(i2));
                    }
                });
            case 8:
                resultMarathi2 = (List) c00061.L$8;
                resultBengali4 = (List) c00061.L$7;
                resultKannada7 = (List) c00061.L$6;
                resultTelugu9 = (List) c00061.L$5;
                resultMalayalam11 = (List) c00061.L$4;
                resultHindi13 = (List) c00061.L$3;
                resultTamil10 = (List) c00061.L$2;
                query10 = (String) c00061.L$0;
                ResultKt.throwOnFailure($result);
                str = "#UIMovieSummary > ul > li";
                $this$mapNotNull$iv8 = ((NiceResponse) $result).getDocument().select(str);
                destination$iv$iv8 = new ArrayList();
                while (r18.hasNext()) {
                    Iterable $this$mapNotNull$iv111112 = $this$mapNotNull$iv8;
                    Element it11114 = (Element) element$iv$iv$iv8;
                    searchResult8 = toSearchResult(it11114);
                    if (searchResult8 != null) {
                        destination$iv$iv8.add(searchResult8);
                    }
                    $this$mapNotNull$iv8 = $this$mapNotNull$iv111112;
                }
                List resultPunjabi9 = (List) destination$iv$iv8;
                Iterable merge9 = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(resultTamil10, resultHindi13), resultMalayalam11), resultTelugu9), resultKannada7), resultBengali4), resultMarathi2), resultPunjabi9);
                Iterable $this$sortedBy$iv9 = merge9;
                return CollectionsKt.sortedWith($this$sortedBy$iv9, new Comparator() { // from class: com.cncverse.EinthusanProvider$search$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int i;
                        SearchResponse searchResponse = (SearchResponse) t;
                        String cleanName = new Regex("(\\()+(.*)+(\\))").replace(searchResponse.getName(), "").toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanName, "toLowerCase(...)");
                        String cleanQuery = query10.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanQuery, "toLowerCase(...)");
                        int i2 = 0;
                        if (StringsKt.contains$default(cleanName, cleanQuery, false, 2, (Object) null)) {
                            i = 0;
                        } else {
                            i = StringsKt.startsWith$default(cleanName, cleanQuery, false, 2, (Object) null) ? 1 : 2;
                        }
                        Integer numValueOf = Integer.valueOf(i);
                        SearchResponse searchResponse2 = (SearchResponse) t2;
                        String cleanName2 = new Regex("(\\()+(.*)+(\\))").replace(searchResponse2.getName(), "").toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanName2, "toLowerCase(...)");
                        String cleanQuery2 = query10.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(cleanQuery2, "toLowerCase(...)");
                        if (!StringsKt.contains$default(cleanName2, cleanQuery2, false, 2, (Object) null)) {
                            i2 = StringsKt.startsWith$default(cleanName2, cleanQuery2, false, 2, (Object) null) ? 1 : 2;
                        }
                        return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(i2));
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        Object obj;
        Object obj2;
        String url2;
        String strText;
        String strOwnText;
        String string;
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
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c00012.label = 1;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                c00012 = c00012;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                break;
                break;
            case 1:
                String url3 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                url2 = url3;
                obj2 = $result;
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document doc = ((NiceResponse) obj2).getDocument();
        String string2 = StringsKt.trim(doc.select("#UIMovieSummary > ul > li > div.block2 > a.title > h3").text()).toString();
        if (string2.length() == 0) {
            return null;
        }
        String title = string2;
        String href = MainAPIKt.fixUrl(this, getMainUrl() + doc.select("#UIMovieSummary > ul > li > div.block2 > a.title").attr("href"));
        String poster = MainAPIKt.fixUrlNull(this, "https:" + doc.select("#UIMovieSummary > ul > li > div.block1 > a > img").attr("src"));
        Iterable $this$map$iv = doc.select("ul.average-rating > li");
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(((Element) item$iv$iv).select("label").text());
        }
        List tags = (List) destination$iv$iv;
        Element elementSelectFirst = doc.selectFirst("div.block2 > div.info > p");
        Integer year = (elementSelectFirst == null || (strOwnText = elementSelectFirst.ownText()) == null || (string = StringsKt.trim(strOwnText).toString()) == null) ? null : Boxing.boxInt(Integer.parseInt(string));
        Element elementSelectFirst2 = doc.selectFirst("p.synopsis");
        String description = (elementSelectFirst2 == null || (strText = elementSelectFirst2.text()) == null) ? null : StringsKt.trim(strText).toString();
        Score score = Score.Companion.from10(doc.select("ul.average-rating > li > p[data-value]").toString());
        Iterable $this$map$iv2 = doc.select("div.professionals > div");
        int $i$f$map = 0;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            Element it = (Element) item$iv$iv2;
            destination$iv$iv2.add(new ActorData(new Actor(it.select("div.prof > p").text(), "https:" + it.select("div.imgwrap img").attr("src")), (ActorRole) null, it.select("div.prof > label").text(), (Actor) null, 10, (DefaultConstructorMarker) null));
            title = title;
            $result = $result;
            $this$map$iv2 = $this$map$iv2;
            $i$f$map = $i$f$map;
        }
        String title2 = title;
        List actors = (List) destination$iv$iv2;
        String mp4link = doc.select("#UIVideoPlayer").attr("data-mp4-link");
        String m3u8link = doc.select("#UIVideoPlayer").attr("data-hls-link");
        String title3 = mp4link + ',' + m3u8link;
        C00022 c00022 = new C00022(poster, year, description, tags, score, actors, null);
        c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
        c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc);
        c00012.L$2 = SpillingKt.nullOutSpilledVariable(title2);
        c00012.L$3 = SpillingKt.nullOutSpilledVariable(href);
        c00012.L$4 = SpillingKt.nullOutSpilledVariable(poster);
        c00012.L$5 = SpillingKt.nullOutSpilledVariable(tags);
        c00012.L$6 = SpillingKt.nullOutSpilledVariable(year);
        c00012.L$7 = SpillingKt.nullOutSpilledVariable(description);
        c00012.L$8 = SpillingKt.nullOutSpilledVariable(score);
        c00012.L$9 = SpillingKt.nullOutSpilledVariable(actors);
        c00012.L$10 = SpillingKt.nullOutSpilledVariable(mp4link);
        c00012.L$11 = SpillingKt.nullOutSpilledVariable(m3u8link);
        c00012.label = 2;
        Object objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title2, title3, TvType.Movie, mp4link + ',' + m3u8link, c00022, c00012);
        return objNewMovieLoadResponse == obj ? obj : objNewMovieLoadResponse;
    }

    /* JADX INFO: renamed from: com.cncverse.EinthusanProvider$load$2 */
    /* JADX INFO: compiled from: EinthusanProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.EinthusanProvider$load$2", f = "EinthusanProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00022 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ Score $score;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00022(String str, Integer num, String str2, List<String> list, Score score, List<ActorData> list2, Continuation<? super C00022> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$year = num;
            this.$description = str2;
            this.$tags = list;
            this.$score = score;
            this.$actors = list2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00022 = new C00022(this.$poster, this.$year, this.$description, this.$tags, this.$score, this.$actors, continuation);
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
                    String str = this.$poster;
                    $this$newMovieLoadResponse.setPosterUrl(str != null ? StringsKt.trim(str).toString() : null);
                    $this$newMovieLoadResponse.setYear(this.$year);
                    $this$newMovieLoadResponse.setPlot(this.$description);
                    $this$newMovieLoadResponse.setTags(this.$tags);
                    $this$newMovieLoadResponse.setScore(this.$score);
                    $this$newMovieLoadResponse.setActors(this.$actors);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0237 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x0238  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00031 c00031;
        String fixedmp4link;
        String fixedmp4link2;
        Regex ipfind;
        Object obj;
        Function1<? super ExtractorLink, Unit> function3;
        String mp4link;
        String m3u8link;
        String data2;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function4;
        Function1<? super ExtractorLink, Unit> function5;
        Object objNewExtractorLink;
        Function1<? super ExtractorLink, Unit> function6;
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
                EinthusanProvider $this$loadLinks_u24lambda_u240 = this;
                final Context _ctx = context;
                SharedPreferences _prefs = _ctx != null ? _ctx.getSharedPreferences("CNCVerseSubscription", 0) : null;
                String _mode = _prefs != null ? _prefs.getString("mode", "ads") : null;
                long _expiresAt = _prefs != null ? _prefs.getLong("expires_at", 0L) : 0L;
                long _nowSec = System.currentTimeMillis() / 1000;
                boolean _isSubscribed = Intrinsics.areEqual(_mode, "subscription") && (_expiresAt == 0 || _expiresAt > _nowSec);
                if (!_isSubscribed) {
                    if (Intrinsics.areEqual(_mode, "subscription") && _expiresAt > 0 && _expiresAt <= _nowSec) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.EinthusanProvider$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                EinthusanProvider.loadLinks$lambda$0$0(_ctx);
                            }
                        });
                    }
                    $this$loadLinks_u24lambda_u240.openInExternalBrowser(new String(Base64.decode(OMG10, 0), Charsets.UTF_8));
                }
                String mp4link2 = StringsKt.substringBefore$default(data, ",", (String) null, 2, (Object) null);
                String m3u8link2 = StringsKt.substringAfter$default(data, ",", (String) null, 2, (Object) null);
                Regex ipfind2 = new Regex("\\b\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\b");
                String fixedmp4link3 = ipfind2.replace(mp4link2, "cdn1.einthusan.io");
                String fixedm3u8link = ipfind2.replace(m3u8link2, "cdn1.einthusan.io");
                String str = getName() + "-MP4";
                String str2 = getName() + "-MP4";
                ExtractorLinkType extractorLinkType = ExtractorLinkType.VIDEO;
                C00043 c00043 = new C00043(null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00032.L$2 = function2;
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(mp4link2);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(m3u8link2);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(ipfind2);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(fixedmp4link3);
                c00032.L$7 = fixedm3u8link;
                c00032.L$8 = function2;
                c00032.Z$0 = isCasting;
                c00032.label = 1;
                Object objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(str, str2, fixedmp4link3, extractorLinkType, c00043, c00032);
                if (objNewExtractorLink2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                fixedmp4link = fixedmp4link3;
                fixedmp4link2 = fixedm3u8link;
                ipfind = ipfind2;
                obj = objNewExtractorLink2;
                function3 = function2;
                mp4link = mp4link2;
                m3u8link = m3u8link2;
                data2 = data;
                isCasting2 = isCasting;
                function4 = function1;
                function5 = function3;
                function3.invoke(obj);
                String str3 = getName() + "-M3U8";
                String str4 = getName() + "-M3U8";
                ExtractorLinkType extractorLinkType2 = ExtractorLinkType.M3U8;
                C00054 c00054 = new C00054(null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(mp4link);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(m3u8link);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(ipfind);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(fixedmp4link);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(fixedmp4link2);
                c00032.L$8 = function5;
                c00032.Z$0 = isCasting2;
                c00032.label = 2;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(str3, str4, fixedmp4link2, extractorLinkType2, c00054, c00032);
                if (objNewExtractorLink == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function6 = function5;
                function6.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            case 1:
                boolean isCasting3 = c00032.Z$0;
                function3 = (Function1) c00032.L$8;
                fixedmp4link2 = (String) c00032.L$7;
                String fixedmp4link4 = (String) c00032.L$6;
                Regex ipfind3 = (Regex) c00032.L$5;
                String m3u8link3 = (String) c00032.L$4;
                String mp4link3 = (String) c00032.L$3;
                Function1<? super ExtractorLink, Unit> function7 = (Function1) c00032.L$2;
                function4 = (Function1) c00032.L$1;
                data2 = (String) c00032.L$0;
                ResultKt.throwOnFailure($result);
                fixedmp4link = fixedmp4link4;
                mp4link = mp4link3;
                m3u8link = m3u8link3;
                function5 = function7;
                isCasting2 = isCasting3;
                ipfind = ipfind3;
                obj = $result;
                function3.invoke(obj);
                String str5 = getName() + "-M3U8";
                String str6 = getName() + "-M3U8";
                ExtractorLinkType extractorLinkType3 = ExtractorLinkType.M3U8;
                C00054 c00055 = new C00054(null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(mp4link);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(m3u8link);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(ipfind);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(fixedmp4link);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(fixedmp4link2);
                c00032.L$8 = function5;
                c00032.Z$0 = isCasting2;
                c00032.label = 2;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(str5, str6, fixedmp4link2, extractorLinkType3, c00055, c00032);
                if (objNewExtractorLink == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function6 = function5;
                function6.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            case 2:
                boolean z = c00032.Z$0;
                function6 = (Function1) c00032.L$8;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                function6.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadLinks$lambda$0$0(Context $_ctx) {
        Toast.makeText($_ctx, "⚠️(Opening ads) Subscription expired. If you have renewed your subscription, please re-verify it in Subscription Manager.", 1).show();
    }

    /* JADX INFO: renamed from: com.cncverse.EinthusanProvider$loadLinks$3 */
    /* JADX INFO: compiled from: EinthusanProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.EinthusanProvider$loadLinks$3", f = "EinthusanProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00043 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00043(Continuation<? super C00043> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00043 = EinthusanProvider.this.new C00043(continuation);
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
                    $this$newExtractorLink.setHeaders(MapsKt.mapOf(TuplesKt.to("Referer", EinthusanProvider.this.getMainUrl() + '/')));
                    $this$newExtractorLink.setQuality(Qualities.Unknown.getValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.cncverse.EinthusanProvider$loadLinks$4 */
    /* JADX INFO: compiled from: EinthusanProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.EinthusanProvider$loadLinks$4", f = "EinthusanProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00054 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00054(Continuation<? super C00054> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00054 = EinthusanProvider.this.new C00054(continuation);
            c00054.L$0 = obj;
            return c00054;
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
                    $this$newExtractorLink.setHeaders(MapsKt.mapOf(TuplesKt.to("Referer", EinthusanProvider.this.getMainUrl() + '/')));
                    $this$newExtractorLink.setQuality(Qualities.Unknown.getValue());
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
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.EinthusanProvider$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    EinthusanProvider.showSubscriptionPopupIfNeeded$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.EinthusanProvider$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EinthusanProvider.showSubscriptionPopupIfNeeded$lambda$0$11($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249, $ctx, dialog, view);
                }
            });
            subscribeTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.EinthusanProvider$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EinthusanProvider.showSubscriptionPopupIfNeeded$lambda$0$12(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.EinthusanProvider$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                EinthusanProvider.showTelegramPopup$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.EinthusanProvider$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            joinTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.EinthusanProvider$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EinthusanProvider.showTelegramPopup$lambda$0$9(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.EinthusanProvider$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                EinthusanProvider.openInExternalBrowser$lambda$0(ctx, url);
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
