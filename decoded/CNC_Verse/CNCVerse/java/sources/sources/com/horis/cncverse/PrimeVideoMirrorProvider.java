package com.horis.cncverse;

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
import com.horis.cncverse.entities.PostData;
import com.horis.cncverse.entities.SearchData;
import com.horis.cncverse.entities.SearchResult;
import com.horis.cncverse.entities.Season;
import com.horis.cncverse.entities.Suggest;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.ActorRole;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.ui.settings.Globals;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/CNC_Verse/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 E2\u00020\u0001:\u0003EFGB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0096@¢\u0006\u0002\u0010\"J\f\u0010#\u001a\u00020$*\u00020%H\u0002J\u000e\u0010&\u001a\u0004\u0018\u00010'*\u00020%H\u0002J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020'0)2\u0006\u0010*\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010+J\u0018\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010+J4\u0010/\u001a\b\u0012\u0004\u0012\u0002000)2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u00104JF\u00105\u001a\u00020\u00162\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\u00162\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;092\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020;09H\u0096@¢\u0006\u0002\u0010>J\u0012\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020=H\u0016J\b\u0010B\u001a\u00020;H\u0002J\b\u0010C\u001a\u00020;H\u0002J\u0010\u0010D\u001a\u00020;2\u0006\u0010.\u001a\u00020\nH\u0002R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u0016X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/horis/cncverse/PrimeVideoMirrorProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "cookie_value", "headers", "", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toHomePageList", "Lcom/lagradost/cloudstream3/HomePageList;", "Lorg/jsoup/nodes/Element;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "search", "", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "getEpisodes", "Lcom/lagradost/cloudstream3/Episode;", "title", "eid", "sid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoInterceptor", "Lokhttp3/Interceptor;", "extractorLink", "showSubscriptionPopupIfNeeded", "showTelegramPopup", "openInExternalBrowser", "Companion", "Id", "LoadData", "CNC Verse_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPrimeVideoMirrorProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PrimeVideoMirrorProvider.kt\ncom/horis/cncverse/PrimeVideoMirrorProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 5 Utils.kt\ncom/horis/cncverse/UtilsKt\n*L\n1#1,580:1\n1586#2:581\n1661#2,3:582\n1642#2,10:585\n1915#2:595\n1916#2:597\n1652#2:598\n1586#2:600\n1661#2,3:601\n1586#2:606\n1661#2,3:607\n1586#2:610\n1661#2,3:611\n1586#2:614\n1661#2,3:615\n777#2:618\n873#2,2:619\n1586#2:621\n1661#2,3:622\n1661#2,3:625\n1661#2,3:629\n1#3:596\n1#3:635\n62#4:599\n62#4:605\n62#4:628\n62#4:633\n62#4:634\n231#5:604\n231#5:632\n*S KotlinDebug\n*F\n+ 1 PrimeVideoMirrorProvider.kt\ncom/horis/cncverse/PrimeVideoMirrorProvider\n*L\n104#1:581\n104#1:582,3\n112#1:585,10\n112#1:595\n112#1:597\n112#1:598\n140#1:600\n140#1:601,3\n167#1:606\n167#1:607,3\n168#1:610\n168#1:611,3\n174#1:614\n174#1:615,3\n175#1:618\n175#1:619,2\n180#1:621\n180#1:622,3\n192#1:625,3\n245#1:629,3\n112#1:596\n138#1:599\n162#1:605\n244#1:628\n292#1:633\n299#1:634\n151#1:604\n287#1:632\n*E\n"})
public final class PrimeVideoMirrorProvider extends MainAPI {
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
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Anime, TvType.AsianDrama});

    @NotNull
    private String lang = "ta";

    @NotNull
    private String mainUrl = "https://net52.cc";

    @NotNull
    private String name = "Prime Video";
    private final boolean hasMainPage = true;

    @NotNull
    private String cookie_value = "";

    @NotNull
    private final Map<String, String> headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"), TuplesKt.to("Accept-Language", "en-IN,en-US;q=0.9,en;q=0.8"), TuplesKt.to("Cache-Control", "max-age=0"), TuplesKt.to("Connection", "keep-alive"), TuplesKt.to("sec-ch-ua", "\"Not(A:Brand\";v=\"8\", \"Chromium\";v=\"144\", \"Android WebView\";v=\"144\""), TuplesKt.to("sec-ch-ua-mobile", "?0"), TuplesKt.to("sec-ch-ua-platform", "\"Android\""), TuplesKt.to("Sec-Fetch-Dest", "document"), TuplesKt.to("Sec-Fetch-Mode", "navigate"), TuplesKt.to("Sec-Fetch-Site", "same-origin"), TuplesKt.to("Sec-Fetch-User", "?1"), TuplesKt.to("Upgrade-Insecure-Requests", "1"), TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 13; Pixel 5 Build/TQ3A.230901.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/144.0.7559.132 Safari/537.36 /OS.Gatu v3.0"), TuplesKt.to("X-Requested-With", "XMLHttpRequest")});

    /* JADX INFO: renamed from: com.horis.cncverse.PrimeVideoMirrorProvider$getEpisodes$1 */
    /* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.PrimeVideoMirrorProvider", f = "PrimeVideoMirrorProvider.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {239}, m = "getEpisodes", n = {"title", "eid", "sid", "episodes", "cookies", "page", "pg"}, nl = {244}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 2)
    static final class C00291 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00291(Continuation<? super C00291> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PrimeVideoMirrorProvider.this.getEpisodes(null, null, null, 0, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cncverse.PrimeVideoMirrorProvider$getMainPage$1 */
    /* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.PrimeVideoMirrorProvider", f = "PrimeVideoMirrorProvider.kt", i = {0, 0, 1, 1, 1}, l = {92, 98}, m = "getMainPage", n = {"request", "page", "request", "cookies", "page"}, nl = {94, 103}, s = {"L$0", "I$0", "L$0", "L$1", "I$0"}, v = 2)
    static final class C00301 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00301(Continuation<? super C00301> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PrimeVideoMirrorProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cncverse.PrimeVideoMirrorProvider$load$1 */
    /* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.PrimeVideoMirrorProvider", f = "PrimeVideoMirrorProvider.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {150, 157, 203, 206, 213}, m = "load", n = {"url", "url", "id", "cookies", "url", "id", "cookies", "data", "episodes", "title", "castList", "cast", "genre", "rating", "suggest", "runTime", "url", "id", "cookies", "data", "episodes", "title", "castList", "cast", "genre", "rating", "suggest", "runTime", "url", "id", "cookies", "data", "episodes", "title", "castList", "cast", "genre", "rating", "suggest", "type", "runTime"}, nl = {151, 162, 206, 211, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0"}, v = 2)
    static final class C00321 extends ContinuationImpl {
        int I$0;
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

        C00321(Continuation<? super C00321> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PrimeVideoMirrorProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cncverse.PrimeVideoMirrorProvider$loadLinks$1 */
    /* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.PrimeVideoMirrorProvider", f = "PrimeVideoMirrorProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5}, l = {286, 288, 289, 295, 296, 305}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "apiBase", "id", "isCasting", "data", "subtitleCallback", "callback", "apiBase", "id", "userToken", "response", "isCasting", "data", "subtitleCallback", "callback", "apiBase", "id", "userToken", "response", "isCasting", "data", "subtitleCallback", "callback", "apiBase", "id", "userToken", "response", "isCasting", "data", "subtitleCallback", "callback", "apiBase", "id", "userToken", "response", "isCasting"}, nl = {287, 289, 292, 296, 299, 304}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0"}, v = 2)
    static final class C00351 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00351(Continuation<? super C00351> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PrimeVideoMirrorProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cncverse.PrimeVideoMirrorProvider$search$1 */
    /* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.PrimeVideoMirrorProvider", f = "PrimeVideoMirrorProvider.kt", i = {0, 1, 1, 1}, l = {131, 138}, m = "search", n = {"query", "query", "cookies", "url"}, nl = {133, 581}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 2)
    static final class C00371 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00371(Continuation<? super C00371> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PrimeVideoMirrorProvider.this.search(null, (Continuation) this);
        }
    }

    /* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/horis/cncverse/PrimeVideoMirrorProvider$Companion;", "", "<init>", "()V", "isCsGuardActive", "", "csGuardWasEverActive", "isCsGuardBlocked", "showCsGuardToast", "", "ctx", "Landroid/content/Context;", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "OMG10", "", "lastBrowserOpenMs", "", "telegramPopupShown", "subscriptionPopupShown", "BROWSER_DEBOUNCE_MS", "CNC Verse_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nPrimeVideoMirrorProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PrimeVideoMirrorProvider.kt\ncom/horis/cncverse/PrimeVideoMirrorProvider$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,580:1\n1#2:581\n*E\n"})
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
                PrimeVideoMirrorProvider.csGuardWasEverActive = true;
            }
            return PrimeVideoMirrorProvider.csGuardWasEverActive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCsGuardToast(final Context ctx) {
            if (ctx == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PrimeVideoMirrorProvider.Companion.showCsGuardToast$lambda$0(ctx);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showCsGuardToast$lambda$0(Context $c) {
            Toast.makeText($c, "🚫 CSGuard detected — Restart CloudStream after removing CSGuard to use CNCRepo", 1).show();
        }

        @Nullable
        public final Context getContext() {
            return PrimeVideoMirrorProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            PrimeVideoMirrorProvider.context = context;
        }
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
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

    /* JADX WARN: Code duplicated, block: B:31:0x015b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x015c  */
    /* JADX WARN: Code duplicated, block: B:36:0x018a A[LOOP:0: B:34:0x0184->B:36:0x018a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws Exception {
        C00301 c00301;
        String str;
        int page2;
        MainPageRequest request2;
        PrimeVideoMirrorProvider primeVideoMirrorProvider;
        Object obj;
        MainPageRequest request3;
        Collection destination$iv$iv;
        if (continuation instanceof C00301) {
            c00301 = (C00301) continuation;
            if ((c00301.label & Integer.MIN_VALUE) != 0) {
                c00301.label -= Integer.MIN_VALUE;
            } else {
                c00301 = new C00301(continuation);
            }
        } else {
            c00301 = new C00301(continuation);
        }
        Object $result = c00301.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00301.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                }
                showTelegramPopup();
                showSubscriptionPopupIfNeeded();
                if (this.cookie_value.length() == 0) {
                    String mainUrl = getMainUrl();
                    c00301.L$0 = SpillingKt.nullOutSpilledVariable(request);
                    c00301.L$1 = this;
                    c00301.I$0 = page;
                    c00301.label = 1;
                    Object objBypass = UtilsKt.bypass(mainUrl, c00301);
                    if (objBypass == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objBypass;
                    page2 = page;
                    request3 = request;
                    primeVideoMirrorProvider = this;
                    str = (String) obj;
                    request2 = request3;
                } else {
                    str = this.cookie_value;
                    page2 = page;
                    request2 = request;
                    primeVideoMirrorProvider = this;
                }
                primeVideoMirrorProvider.cookie_value = str;
                Map cookies = MapsKt.mapOf(new Pair[]{TuplesKt.to("t_hash_t", this.cookie_value), TuplesKt.to("ott", "pv"), TuplesKt.to("hd", "on")});
                Requests app = UtilsKt.getApp();
                String str2 = getMainUrl() + "/mobile/home?app=1";
                Map<String, String> map = this.headers;
                String str3 = getMainUrl() + "/mobile/home?app=1";
                c00301.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00301.L$1 = SpillingKt.nullOutSpilledVariable(cookies);
                c00301.I$0 = page2;
                c00301.label = 2;
                $result = Requests.get$default(app, str2, map, str3, (Map) null, cookies, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00301, 4072, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Document document = ((NiceResponse) $result).getDocument();
                Iterable $this$map$iv = document.select(".tray-container, #top10");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Element it = (Element) item$iv$iv;
                    destination$iv$iv.add(toHomePageList(it));
                }
                List items = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(items, Boxing.boxBoolean(false));
            case 1:
                page2 = c00301.I$0;
                PrimeVideoMirrorProvider primeVideoMirrorProvider2 = (PrimeVideoMirrorProvider) c00301.L$1;
                request3 = (MainPageRequest) c00301.L$0;
                ResultKt.throwOnFailure($result);
                primeVideoMirrorProvider = primeVideoMirrorProvider2;
                obj = $result;
                str = (String) obj;
                request2 = request3;
                primeVideoMirrorProvider.cookie_value = str;
                Map cookies2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("t_hash_t", this.cookie_value), TuplesKt.to("ott", "pv"), TuplesKt.to("hd", "on")});
                Requests app2 = UtilsKt.getApp();
                String str4 = getMainUrl() + "/mobile/home?app=1";
                Map<String, String> map2 = this.headers;
                String str5 = getMainUrl() + "/mobile/home?app=1";
                c00301.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00301.L$1 = SpillingKt.nullOutSpilledVariable(cookies2);
                c00301.I$0 = page2;
                c00301.label = 2;
                $result = Requests.get$default(app2, str4, map2, str5, (Map) null, cookies2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00301, 4072, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Document document2 = ((NiceResponse) $result).getDocument();
                Iterable $this$map$iv2 = document2.select(".tray-container, #top10");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                while (r11.hasNext()) {
                    Element it2 = (Element) item$iv$iv;
                    destination$iv$iv.add(toHomePageList(it2));
                }
                List items2 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(items2, Boxing.boxBoolean(false));
            case 2:
                int i = c00301.I$0;
                ResultKt.throwOnFailure($result);
                Document document3 = ((NiceResponse) $result).getDocument();
                Iterable $this$map$iv3 = document3.select(".tray-container, #top10");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                while (r11.hasNext()) {
                    Element it3 = (Element) item$iv$iv;
                    destination$iv$iv.add(toHomePageList(it3));
                }
                List items3 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(items3, Boxing.boxBoolean(false));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final HomePageList toHomePageList(Element $this$toHomePageList) {
        String name = $this$toHomePageList.select("h2, span").text();
        Iterable $this$mapNotNull$iv = $this$toHomePageList.select("article, .top10-post");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List items = (List) destination$iv$iv;
        return new HomePageList(name, items, false);
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        final String id;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("a");
        if (elementSelectFirst == null || (id = elementSelectFirst.attr("data-post")) == null) {
            id = $this$toSearchResult.attr("data-post");
        }
        return MainAPIKt.newAnimeSearchResponse$default(this, "", AppUtils.INSTANCE.toJson(new Id(id)), (TvType) null, false, new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return PrimeVideoMirrorProvider.toSearchResult$lambda$0(id, this, (AnimeSearchResponse) obj);
            }
        }, 12, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toSearchResult$lambda$0(String $id, PrimeVideoMirrorProvider this$0, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl("https://imgcdn.kim/pv/v/" + $id + ".jpg");
        $this$newAnimeSearchResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this$0.getMainUrl() + "/home")));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0155 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x0156  */
    /* JADX WARN: Code duplicated, block: B:36:0x0194 A[LOOP:0: B:34:0x018e->B:36:0x0194, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws Exception {
        C00371 c00371;
        String str;
        String query2;
        PrimeVideoMirrorProvider primeVideoMirrorProvider;
        String query3;
        Object obj;
        PrimeVideoMirrorProvider primeVideoMirrorProvider2;
        SearchData data;
        Collection destination$iv$iv;
        if (continuation instanceof C00371) {
            c00371 = (C00371) continuation;
            if ((c00371.label & Integer.MIN_VALUE) != 0) {
                c00371.label -= Integer.MIN_VALUE;
            } else {
                c00371 = new C00371(continuation);
            }
        } else {
            c00371 = new C00371(continuation);
        }
        Object $result = c00371.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00371.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return CollectionsKt.emptyList();
                }
                if (this.cookie_value.length() == 0) {
                    String mainUrl = getMainUrl();
                    query3 = query;
                    c00371.L$0 = query3;
                    c00371.L$1 = this;
                    c00371.label = 1;
                    Object objBypass = UtilsKt.bypass(mainUrl, c00371);
                    if (objBypass == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objBypass;
                    primeVideoMirrorProvider2 = this;
                    str = (String) obj;
                    String str2 = query3;
                    primeVideoMirrorProvider = primeVideoMirrorProvider2;
                    query2 = str2;
                } else {
                    str = this.cookie_value;
                    query2 = query;
                    primeVideoMirrorProvider = this;
                }
                primeVideoMirrorProvider.cookie_value = str;
                Map cookies = MapsKt.mapOf(new Pair[]{TuplesKt.to("t_hash_t", this.cookie_value), TuplesKt.to("hd", "on"), TuplesKt.to("ott", "pv")});
                String url = getMainUrl() + "/mobile/pv/search.php?s=" + query2 + "&t=" + APIHolder.INSTANCE.getUnixTime();
                Requests app = UtilsKt.getApp();
                String str3 = getMainUrl() + "/home";
                c00371.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00371.L$1 = SpillingKt.nullOutSpilledVariable(cookies);
                c00371.L$2 = SpillingKt.nullOutSpilledVariable(url);
                c00371.label = 2;
                $result = Requests.get$default(app, url, (Map) null, str3, (Map) null, cookies, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00371, 4074, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                NiceResponse this_$iv = (NiceResponse) $result;
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                data = (SearchData) parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(SearchData.class));
                Iterable $this$map$iv = data.getSearchResult();
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    final SearchResult it = (SearchResult) item$iv$iv;
                    destination$iv$iv.add(MainAPIKt.newAnimeSearchResponse$default(this, it.getT(), AppUtils.INSTANCE.toJson(new Id(it.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda13
                        public final Object invoke(Object obj2) {
                            return PrimeVideoMirrorProvider.search$lambda$0$0(it, this, (AnimeSearchResponse) obj2);
                        }
                    }, 12, (Object) null));
                    data = data;
                }
                return (List) destination$iv$iv;
            case 1:
                primeVideoMirrorProvider2 = (PrimeVideoMirrorProvider) c00371.L$1;
                query3 = (String) c00371.L$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                str = (String) obj;
                String str4 = query3;
                primeVideoMirrorProvider = primeVideoMirrorProvider2;
                query2 = str4;
                primeVideoMirrorProvider.cookie_value = str;
                Map cookies2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("t_hash_t", this.cookie_value), TuplesKt.to("hd", "on"), TuplesKt.to("ott", "pv")});
                String url2 = getMainUrl() + "/mobile/pv/search.php?s=" + query2 + "&t=" + APIHolder.INSTANCE.getUnixTime();
                Requests app2 = UtilsKt.getApp();
                String str5 = getMainUrl() + "/home";
                c00371.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00371.L$1 = SpillingKt.nullOutSpilledVariable(cookies2);
                c00371.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                c00371.label = 2;
                $result = Requests.get$default(app2, url2, (Map) null, str5, (Map) null, cookies2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00371, 4074, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                NiceResponse this_$iv2 = (NiceResponse) $result;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                data = (SearchData) parser2.parse(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(SearchData.class));
                Iterable $this$map$iv2 = data.getSearchResult();
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                while (r11.hasNext()) {
                    final SearchResult it2 = (SearchResult) item$iv$iv;
                    destination$iv$iv.add(MainAPIKt.newAnimeSearchResponse$default(this, it2.getT(), AppUtils.INSTANCE.toJson(new Id(it2.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda13
                        public final Object invoke(Object obj2) {
                            return PrimeVideoMirrorProvider.search$lambda$0$0(it2, this, (AnimeSearchResponse) obj2);
                        }
                    }, 12, (Object) null));
                    data = data;
                }
                return (List) destination$iv$iv;
            case 2:
                ResultKt.throwOnFailure($result);
                NiceResponse this_$iv3 = (NiceResponse) $result;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                data = (SearchData) parser3.parse(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(SearchData.class));
                Iterable $this$map$iv3 = data.getSearchResult();
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                while (r11.hasNext()) {
                    final SearchResult it3 = (SearchResult) item$iv$iv;
                    destination$iv$iv.add(MainAPIKt.newAnimeSearchResponse$default(this, it3.getT(), AppUtils.INSTANCE.toJson(new Id(it3.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda13
                        public final Object invoke(Object obj2) {
                            return PrimeVideoMirrorProvider.search$lambda$0$0(it3, this, (AnimeSearchResponse) obj2);
                        }
                    }, 12, (Object) null));
                    data = data;
                }
                return (List) destination$iv$iv;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$0(SearchResult $it, PrimeVideoMirrorProvider this$0, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl("https://imgcdn.kim/pv/v/" + $it.getId() + ".jpg");
        $this$newAnimeSearchResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this$0.getMainUrl() + "/home")));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x05af  */
    /* JADX WARN: Code duplicated, block: B:110:0x05b2  */
    /* JADX WARN: Code duplicated, block: B:113:0x062f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:114:0x0630  */
    /* JADX WARN: Code duplicated, block: B:30:0x01fe A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:34:0x0234  */
    /* JADX WARN: Code duplicated, block: B:41:0x0287  */
    /* JADX WARN: Code duplicated, block: B:45:0x02ab A[LOOP:1: B:43:0x02a5->B:45:0x02ab, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:48:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:65:0x038f  */
    /* JADX WARN: Code duplicated, block: B:68:0x0397  */
    /* JADX WARN: Code duplicated, block: B:69:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:72:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:75:0x03d9 A[LOOP:4: B:73:0x03d3->B:75:0x03d9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x042d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x043d  */
    /* JADX WARN: Code duplicated, block: B:81:0x0465  */
    /* JADX WARN: Code duplicated, block: B:84:0x047f A[LOOP:5: B:82:0x0479->B:84:0x047f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:87:0x04bc A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:88:0x04c4  */
    /* JADX WARN: Code duplicated, block: B:92:0x0508 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:93:0x0509  */
    /* JADX WARN: Code duplicated, block: B:99:0x053e  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) throws Exception {
        C00321 c00321;
        String url2;
        String str;
        PrimeVideoMirrorProvider primeVideoMirrorProvider;
        Object obj;
        String id;
        Map cookies;
        Object obj2;
        C00321 c00322;
        String url3;
        String url4;
        final PostData data;
        ArrayList episodes;
        String title;
        String cast;
        List destination$iv$iv;
        List castList;
        List $this$map$iv;
        Collection destination$iv$iv2;
        Iterable $this$mapTo$iv$iv;
        List cast2;
        String genre;
        ArrayList arrayList;
        List genre2;
        String match;
        String strReplace$default;
        String rating;
        int runTime;
        Iterable suggest;
        Object obj3;
        List castList2;
        ArrayList arrayList2;
        List suggest2;
        Iterable $this$mapTo$iv;
        ArrayList destination$iv;
        int $i$f$mapTo;
        Iterator it;
        Integer nextPageShow;
        String url5;
        Object episodes2;
        int runTime2;
        Map cookies2;
        String url6;
        String id2;
        PostData data2;
        List genre3;
        String rating2;
        String title2;
        ArrayList arrayList3;
        ArrayList episodes3;
        List cast3;
        List cast4;
        String id3;
        String title3;
        String url7;
        ArrayList episodes4;
        int runTime3;
        String id4;
        List cast5;
        PostData data3;
        List genre4;
        String title4;
        ArrayList genre5;
        String title5;
        List cast6;
        String id5;
        Iterable $this$map$iv2;
        Collection destination$iv$iv3;
        Iterable $this$mapTo$iv$iv2;
        Iterable iterableSplit$default;
        Iterable iterableSplit$default2;
        List<Season> season;
        List listDropLast;
        Object objAmap;
        ArrayList episodes5;
        List suggest3;
        PostData data4;
        Map cookies3;
        String title6;
        int runTime4;
        String title7;
        List castList3;
        String rating3;
        TvType tvType;
        if (continuation instanceof C00321) {
            c00321 = (C00321) continuation;
            if ((c00321.label & Integer.MIN_VALUE) != 0) {
                c00321.label -= Integer.MIN_VALUE;
            } else {
                c00321 = new C00321(continuation);
            }
        } else {
            c00321 = new C00321(continuation);
        }
        C00321 c00323 = c00321;
        Object $result = c00323.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00323.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.cookie_value.length() == 0) {
                    String mainUrl = getMainUrl();
                    url2 = url;
                    c00323.L$0 = url2;
                    c00323.L$1 = this;
                    c00323.label = 1;
                    Object objBypass = UtilsKt.bypass(mainUrl, c00323);
                    if (objBypass == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objBypass;
                    primeVideoMirrorProvider = this;
                    str = (String) obj;
                } else {
                    url2 = url;
                    str = this.cookie_value;
                    primeVideoMirrorProvider = this;
                }
                primeVideoMirrorProvider.cookie_value = str;
                String text$iv = url2;
                id = ((Id) UtilsKt.getJSONParser().parse(text$iv, Reflection.getOrCreateKotlinClass(Id.class))).getId();
                cookies = MapsKt.mapOf(new Pair[]{TuplesKt.to("t_hash_t", this.cookie_value), TuplesKt.to("hd", "on"), TuplesKt.to("ott", "pv")});
                Requests app = UtilsKt.getApp();
                String str2 = getMainUrl() + "/mobile/pv/post.php?id=" + id + "&t=" + APIHolder.INSTANCE.getUnixTime();
                Map<String, String> map = this.headers;
                String str3 = getMainUrl() + "/home";
                c00323.L$0 = url2;
                c00323.L$1 = id;
                c00323.L$2 = SpillingKt.nullOutSpilledVariable(cookies);
                c00323.label = 2;
                obj2 = Requests.get$default(app, str2, map, str3, (Map) null, cookies, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00323, 4072, (Object) null);
                c00322 = c00323;
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                String str4 = url2;
                url3 = id;
                url4 = str4;
                NiceResponse this_$iv = (NiceResponse) obj2;
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                data = (PostData) parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(PostData.class));
                episodes = new ArrayList();
                title = data.getTitle();
                cast = data.getCast();
                if (cast != null || (iterableSplit$default2 = StringsKt.split$default(cast, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                    destination$iv$iv = CollectionsKt.emptyList();
                } else {
                    Iterable $this$map$iv3 = iterableSplit$default2;
                    Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                    for (Object item$iv$iv : $this$map$iv3) {
                        destination$iv$iv4.add(StringsKt.trim((String) item$iv$iv).toString());
                    }
                    destination$iv$iv = (List) destination$iv$iv4;
                }
                castList = destination$iv$iv;
                $this$map$iv = castList;
                int $i$f$map = CollectionsKt.collectionSizeOrDefault($this$map$iv, 10);
                destination$iv$iv2 = new ArrayList($i$f$map);
                $this$mapTo$iv$iv = $this$map$iv;
                for (Object item$iv$iv2 : $this$mapTo$iv$iv) {
                    destination$iv$iv2.add(new ActorData(new Actor((String) item$iv$iv2, (String) null, 2, (DefaultConstructorMarker) null), (ActorRole) null, (String) null, (Actor) null, 14, (DefaultConstructorMarker) null));
                    $this$map$iv = $this$map$iv;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                    $result = $result;
                }
                cast2 = (List) destination$iv$iv2;
                genre = data.getGenre();
                if (genre != null || (iterableSplit$default = StringsKt.split$default(genre, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                    arrayList = null;
                } else {
                    Iterable $this$map$iv4 = iterableSplit$default;
                    Collection destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                    for (Object item$iv$iv3 : $this$map$iv4) {
                        destination$iv$iv5.add(StringsKt.trim((String) item$iv$iv3).toString());
                        $this$map$iv4 = $this$map$iv4;
                    }
                    Iterable $this$filter$iv = (List) destination$iv$iv5;
                    Collection destination$iv$iv6 = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        Iterable $this$filter$iv2 = $this$filter$iv;
                        if (((String) element$iv$iv).length() > 0) {
                            destination$iv$iv6.add(element$iv$iv);
                        }
                        $this$filter$iv = $this$filter$iv2;
                    }
                    arrayList = (List) destination$iv$iv6;
                }
                genre2 = arrayList;
                match = data.getMatch();
                if (match != null) {
                    strReplace$default = StringsKt.replace$default(match, "IMDb ", "", false, 4, (Object) null);
                } else {
                    strReplace$default = null;
                }
                rating = strReplace$default;
                runTime = UtilsKt.convertRuntimeToMinutes(String.valueOf(data.getRuntime()));
                suggest = data.getSuggest();
                if (suggest != null) {
                    $this$map$iv2 = suggest;
                    destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    $this$mapTo$iv$iv2 = $this$map$iv2;
                    for (Object item$iv$iv4 : $this$mapTo$iv$iv2) {
                        Iterable $this$map$iv5 = $this$map$iv2;
                        final Suggest it2 = (Suggest) item$iv$iv4;
                        destination$iv$iv3.add(MainAPIKt.newAnimeSearchResponse$default(this, "", AppUtils.INSTANCE.toJson(new Id(it2.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj4) {
                                return PrimeVideoMirrorProvider.load$lambda$4$0(it2, this, (AnimeSearchResponse) obj4);
                            }
                        }, 12, (Object) null));
                        $this$map$iv2 = $this$map$iv5;
                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv2;
                        castList = castList;
                        coroutine_suspended = coroutine_suspended;
                    }
                    obj3 = coroutine_suspended;
                    castList2 = castList;
                    arrayList2 = (List) destination$iv$iv3;
                } else {
                    obj3 = coroutine_suspended;
                    castList2 = castList;
                    arrayList2 = null;
                }
                suggest2 = arrayList2;
                if (CollectionsKt.first(data.getEpisodes()) == null) {
                    Boxing.boxBoolean(episodes.add(MainAPIKt.newEpisode(this, new LoadData(title, url3), new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj4) {
                            return PrimeVideoMirrorProvider.load$lambda$5(data, (Episode) obj4);
                        }
                    })));
                    runTime3 = runTime;
                    id4 = url3;
                    cast5 = suggest2;
                    c00322 = c00322;
                    data3 = data;
                    genre4 = genre2;
                    obj3 = obj3;
                    title4 = url4;
                    genre5 = episodes;
                    title5 = title;
                    cast6 = cast2;
                    id5 = rating;
                } else {
                    $this$mapTo$iv = CollectionsKt.filterNotNull(data.getEpisodes());
                    destination$iv = episodes;
                    $i$f$mapTo = 0;
                    for (it = $this$mapTo$iv.iterator(); it.hasNext(); it = it) {
                        Object item$iv = it.next();
                        final com.horis.cncverse.entities.Episode it3 = (com.horis.cncverse.entities.Episode) item$iv;
                        destination$iv.add(MainAPIKt.newEpisode(this, new LoadData(title, it3.getId()), new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda5
                            public final Object invoke(Object obj4) {
                                return PrimeVideoMirrorProvider.load$lambda$6$0(it3, (Episode) obj4);
                            }
                        }));
                        $this$mapTo$iv = $this$mapTo$iv;
                        $i$f$mapTo = $i$f$mapTo;
                    }
                    nextPageShow = data.getNextPageShow();
                    if (nextPageShow == null && nextPageShow.intValue() == 1) {
                        String nextPageSeason = data.getNextPageSeason();
                        Intrinsics.checkNotNull(nextPageSeason);
                        c00322.L$0 = url4;
                        c00322.L$1 = url3;
                        c00322.L$2 = SpillingKt.nullOutSpilledVariable(cookies);
                        c00322.L$3 = data;
                        c00322.L$4 = episodes;
                        c00322.L$5 = title;
                        c00322.L$6 = SpillingKt.nullOutSpilledVariable(castList2);
                        c00322.L$7 = cast2;
                        c00322.L$8 = genre2;
                        c00322.L$9 = rating;
                        c00322.L$10 = suggest2;
                        c00322.L$11 = episodes;
                        c00322.I$0 = runTime;
                        c00322.label = 3;
                        C00321 c00324 = c00322;
                        url5 = url4;
                        episodes2 = getEpisodes(title, url5, nextPageSeason, 2, c00324);
                        c00322 = c00324;
                        obj3 = obj3;
                        if (episodes2 == obj3) {
                            return obj3;
                        }
                        Map map2 = cookies;
                        runTime2 = runTime;
                        cookies2 = map2;
                        url6 = url5;
                        id2 = url3;
                        data2 = data;
                        genre3 = genre2;
                        rating2 = rating;
                        title2 = title;
                        arrayList3 = episodes;
                        episodes3 = arrayList3;
                        cast3 = cast2;
                        arrayList3.addAll((Collection) episodes2);
                        int i = runTime2;
                        cookies = cookies2;
                        runTime = i;
                        title3 = title2;
                        episodes4 = episodes3;
                        id3 = id2;
                        rating = rating2;
                        genre2 = genre3;
                        url7 = url6;
                        data = data2;
                        cast4 = cast3;
                        season = data.getSeason();
                        if (season != null || (listDropLast = CollectionsKt.dropLast(season, 1)) == null) {
                            title5 = title3;
                            cast6 = cast4;
                            data3 = data;
                            title4 = url7;
                            cast5 = suggest2;
                            runTime3 = runTime;
                            genre4 = genre2;
                            genre5 = episodes4;
                            id4 = id3;
                            id5 = rating;
                        } else {
                            C00334 c00334 = new C00334(episodes4, this, title3, url7, null);
                            c00322.L$0 = url7;
                            c00322.L$1 = id3;
                            c00322.L$2 = SpillingKt.nullOutSpilledVariable(cookies);
                            c00322.L$3 = data;
                            c00322.L$4 = episodes4;
                            c00322.L$5 = title3;
                            c00322.L$6 = SpillingKt.nullOutSpilledVariable(castList2);
                            c00322.L$7 = cast4;
                            c00322.L$8 = genre2;
                            c00322.L$9 = rating;
                            c00322.L$10 = suggest2;
                            c00322.L$11 = null;
                            c00322.I$0 = runTime;
                            c00322.label = 4;
                            objAmap = ParCollectionsKt.amap(listDropLast, c00334, c00322);
                            if (objAmap == obj3) {
                                return obj3;
                            }
                            episodes5 = episodes4;
                            suggest3 = suggest2;
                            data4 = data;
                            cookies3 = cookies;
                            title6 = title3;
                            runTime4 = runTime;
                            title7 = rating;
                            castList3 = castList2;
                            rating3 = id3;
                            String str5 = title6;
                            title4 = url7;
                            genre4 = genre2;
                            genre5 = episodes5;
                            title5 = str5;
                            id5 = title7;
                            castList2 = castList3;
                            runTime3 = runTime4;
                            data3 = data4;
                            cookies = cookies3;
                            cast6 = cast4;
                            cast5 = suggest3;
                            id4 = rating3;
                        }
                    } else {
                        String str6 = url3;
                        cast4 = cast2;
                        id3 = str6;
                        title3 = title;
                        url7 = url4;
                        episodes4 = episodes;
                        season = data.getSeason();
                        if (season != null) {
                        }
                        title5 = title3;
                        cast6 = cast4;
                        data3 = data;
                        title4 = url7;
                        cast5 = suggest2;
                        runTime3 = runTime;
                        genre4 = genre2;
                        genre5 = episodes4;
                        id4 = id3;
                        id5 = rating;
                    }
                }
                if (CollectionsKt.first(data3.getEpisodes()) == null) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                TvType type = tvType;
                String rating4 = id5;
                C00345 c00345 = new C00345(id4, this, data3, genre4, cast6, id5, runTime3, cast5, null);
                c00322.L$0 = SpillingKt.nullOutSpilledVariable(title4);
                c00322.L$1 = SpillingKt.nullOutSpilledVariable(id4);
                c00322.L$2 = SpillingKt.nullOutSpilledVariable(cookies);
                c00322.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                c00322.L$4 = SpillingKt.nullOutSpilledVariable(genre5);
                c00322.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                c00322.L$6 = SpillingKt.nullOutSpilledVariable(castList2);
                c00322.L$7 = SpillingKt.nullOutSpilledVariable(cast6);
                c00322.L$8 = SpillingKt.nullOutSpilledVariable(genre4);
                c00322.L$9 = SpillingKt.nullOutSpilledVariable(rating4);
                c00322.L$10 = SpillingKt.nullOutSpilledVariable(cast5);
                c00322.L$11 = SpillingKt.nullOutSpilledVariable(type);
                c00322.I$0 = runTime3;
                c00322.label = 5;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, title5, title4, type, genre5, c00345, c00322);
                if ($result == obj3) {
                    return obj3;
                }
                return $result;
            case 1:
                primeVideoMirrorProvider = (PrimeVideoMirrorProvider) c00323.L$1;
                url2 = (String) c00323.L$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                str = (String) obj;
                primeVideoMirrorProvider.cookie_value = str;
                String text$iv2 = url2;
                id = ((Id) UtilsKt.getJSONParser().parse(text$iv2, Reflection.getOrCreateKotlinClass(Id.class))).getId();
                cookies = MapsKt.mapOf(new Pair[]{TuplesKt.to("t_hash_t", this.cookie_value), TuplesKt.to("hd", "on"), TuplesKt.to("ott", "pv")});
                Requests app2 = UtilsKt.getApp();
                String str7 = getMainUrl() + "/mobile/pv/post.php?id=" + id + "&t=" + APIHolder.INSTANCE.getUnixTime();
                Map<String, String> map3 = this.headers;
                String str8 = getMainUrl() + "/home";
                c00323.L$0 = url2;
                c00323.L$1 = id;
                c00323.L$2 = SpillingKt.nullOutSpilledVariable(cookies);
                c00323.label = 2;
                obj2 = Requests.get$default(app2, str7, map3, str8, (Map) null, cookies, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00323, 4072, (Object) null);
                c00322 = c00323;
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                String str9 = url2;
                url3 = id;
                url4 = str9;
                NiceResponse this_$iv2 = (NiceResponse) obj2;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                data = (PostData) parser2.parse(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(PostData.class));
                episodes = new ArrayList();
                title = data.getTitle();
                cast = data.getCast();
                if (cast != null) {
                    destination$iv$iv = CollectionsKt.emptyList();
                } else {
                    destination$iv$iv = CollectionsKt.emptyList();
                }
                castList = destination$iv$iv;
                $this$map$iv = castList;
                int $i$f$map2 = CollectionsKt.collectionSizeOrDefault($this$map$iv, 10);
                destination$iv$iv2 = new ArrayList($i$f$map2);
                $this$mapTo$iv$iv = $this$map$iv;
                while (r20.hasNext()) {
                    destination$iv$iv2.add(new ActorData(new Actor((String) item$iv$iv2, (String) null, 2, (DefaultConstructorMarker) null), (ActorRole) null, (String) null, (Actor) null, 14, (DefaultConstructorMarker) null));
                    $this$map$iv = $this$map$iv;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                    $result = $result;
                }
                cast2 = (List) destination$iv$iv2;
                genre = data.getGenre();
                if (genre != null) {
                    arrayList = null;
                } else {
                    arrayList = null;
                }
                genre2 = arrayList;
                match = data.getMatch();
                if (match != null) {
                    strReplace$default = StringsKt.replace$default(match, "IMDb ", "", false, 4, (Object) null);
                } else {
                    strReplace$default = null;
                }
                rating = strReplace$default;
                runTime = UtilsKt.convertRuntimeToMinutes(String.valueOf(data.getRuntime()));
                suggest = data.getSuggest();
                if (suggest != null) {
                    $this$map$iv2 = suggest;
                    destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    $this$mapTo$iv$iv2 = $this$map$iv2;
                    while (r18.hasNext()) {
                        Iterable $this$map$iv6 = $this$map$iv2;
                        final Suggest it4 = (Suggest) item$iv$iv4;
                        destination$iv$iv3.add(MainAPIKt.newAnimeSearchResponse$default(this, "", AppUtils.INSTANCE.toJson(new Id(it4.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj4) {
                                return PrimeVideoMirrorProvider.load$lambda$4$0(it4, this, (AnimeSearchResponse) obj4);
                            }
                        }, 12, (Object) null));
                        $this$map$iv2 = $this$map$iv6;
                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv2;
                        castList = castList;
                        coroutine_suspended = coroutine_suspended;
                    }
                    obj3 = coroutine_suspended;
                    castList2 = castList;
                    arrayList2 = (List) destination$iv$iv3;
                } else {
                    obj3 = coroutine_suspended;
                    castList2 = castList;
                    arrayList2 = null;
                }
                suggest2 = arrayList2;
                if (CollectionsKt.first(data.getEpisodes()) == null) {
                    $this$mapTo$iv = CollectionsKt.filterNotNull(data.getEpisodes());
                    destination$iv = episodes;
                    $i$f$mapTo = 0;
                    while (it.hasNext()) {
                        Object item$iv2 = it.next();
                        final com.horis.cncverse.entities.Episode it5 = (com.horis.cncverse.entities.Episode) item$iv2;
                        destination$iv.add(MainAPIKt.newEpisode(this, new LoadData(title, it5.getId()), new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda5
                            public final Object invoke(Object obj4) {
                                return PrimeVideoMirrorProvider.load$lambda$6$0(it5, (Episode) obj4);
                            }
                        }));
                        $this$mapTo$iv = $this$mapTo$iv;
                        $i$f$mapTo = $i$f$mapTo;
                    }
                    nextPageShow = data.getNextPageShow();
                    if (nextPageShow == null) {
                        String nextPageSeason2 = data.getNextPageSeason();
                        Intrinsics.checkNotNull(nextPageSeason2);
                        c00322.L$0 = url4;
                        c00322.L$1 = url3;
                        c00322.L$2 = SpillingKt.nullOutSpilledVariable(cookies);
                        c00322.L$3 = data;
                        c00322.L$4 = episodes;
                        c00322.L$5 = title;
                        c00322.L$6 = SpillingKt.nullOutSpilledVariable(castList2);
                        c00322.L$7 = cast2;
                        c00322.L$8 = genre2;
                        c00322.L$9 = rating;
                        c00322.L$10 = suggest2;
                        c00322.L$11 = episodes;
                        c00322.I$0 = runTime;
                        c00322.label = 3;
                        C00321 c00325 = c00322;
                        url5 = url4;
                        episodes2 = getEpisodes(title, url5, nextPageSeason2, 2, c00325);
                        c00322 = c00325;
                        obj3 = obj3;
                        if (episodes2 == obj3) {
                            return obj3;
                        }
                        Map map4 = cookies;
                        runTime2 = runTime;
                        cookies2 = map4;
                        url6 = url5;
                        id2 = url3;
                        data2 = data;
                        genre3 = genre2;
                        rating2 = rating;
                        title2 = title;
                        arrayList3 = episodes;
                        episodes3 = arrayList3;
                        cast3 = cast2;
                        arrayList3.addAll((Collection) episodes2);
                        int i2 = runTime2;
                        cookies = cookies2;
                        runTime = i2;
                        title3 = title2;
                        episodes4 = episodes3;
                        id3 = id2;
                        rating = rating2;
                        genre2 = genre3;
                        url7 = url6;
                        data = data2;
                        cast4 = cast3;
                        season = data.getSeason();
                        if (season != null) {
                        }
                        title5 = title3;
                        cast6 = cast4;
                        data3 = data;
                        title4 = url7;
                        cast5 = suggest2;
                        runTime3 = runTime;
                        genre4 = genre2;
                        genre5 = episodes4;
                        id4 = id3;
                        id5 = rating;
                        break;
                    }
                    String str10 = url3;
                    cast4 = cast2;
                    id3 = str10;
                    title3 = title;
                    url7 = url4;
                    episodes4 = episodes;
                    season = data.getSeason();
                    if (season != null) {
                    }
                    title5 = title3;
                    cast6 = cast4;
                    data3 = data;
                    title4 = url7;
                    cast5 = suggest2;
                    runTime3 = runTime;
                    genre4 = genre2;
                    genre5 = episodes4;
                    id4 = id3;
                    id5 = rating;
                    break;
                } else {
                    Boxing.boxBoolean(episodes.add(MainAPIKt.newEpisode(this, new LoadData(title, url3), new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj4) {
                            return PrimeVideoMirrorProvider.load$lambda$5(data, (Episode) obj4);
                        }
                    })));
                    runTime3 = runTime;
                    id4 = url3;
                    cast5 = suggest2;
                    c00322 = c00322;
                    data3 = data;
                    genre4 = genre2;
                    obj3 = obj3;
                    title4 = url4;
                    genre5 = episodes;
                    title5 = title;
                    cast6 = cast2;
                    id5 = rating;
                }
                if (CollectionsKt.first(data3.getEpisodes()) == null) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                TvType type2 = tvType;
                String rating5 = id5;
                C00345 c00346 = new C00345(id4, this, data3, genre4, cast6, id5, runTime3, cast5, null);
                c00322.L$0 = SpillingKt.nullOutSpilledVariable(title4);
                c00322.L$1 = SpillingKt.nullOutSpilledVariable(id4);
                c00322.L$2 = SpillingKt.nullOutSpilledVariable(cookies);
                c00322.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                c00322.L$4 = SpillingKt.nullOutSpilledVariable(genre5);
                c00322.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                c00322.L$6 = SpillingKt.nullOutSpilledVariable(castList2);
                c00322.L$7 = SpillingKt.nullOutSpilledVariable(cast6);
                c00322.L$8 = SpillingKt.nullOutSpilledVariable(genre4);
                c00322.L$9 = SpillingKt.nullOutSpilledVariable(rating5);
                c00322.L$10 = SpillingKt.nullOutSpilledVariable(cast5);
                c00322.L$11 = SpillingKt.nullOutSpilledVariable(type2);
                c00322.I$0 = runTime3;
                c00322.label = 5;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, title5, title4, type2, genre5, c00346, c00322);
                if ($result == obj3) {
                    return obj3;
                }
                return $result;
            case 2:
                Map cookies4 = (Map) c00323.L$2;
                url3 = (String) c00323.L$1;
                String url8 = (String) c00323.L$0;
                ResultKt.throwOnFailure($result);
                cookies = cookies4;
                url4 = url8;
                c00322 = c00323;
                obj2 = $result;
                NiceResponse this_$iv3 = (NiceResponse) obj2;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                data = (PostData) parser3.parse(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(PostData.class));
                episodes = new ArrayList();
                title = data.getTitle();
                cast = data.getCast();
                if (cast != null) {
                    destination$iv$iv = CollectionsKt.emptyList();
                } else {
                    destination$iv$iv = CollectionsKt.emptyList();
                }
                castList = destination$iv$iv;
                $this$map$iv = castList;
                int $i$f$map3 = CollectionsKt.collectionSizeOrDefault($this$map$iv, 10);
                destination$iv$iv2 = new ArrayList($i$f$map3);
                $this$mapTo$iv$iv = $this$map$iv;
                while (r20.hasNext()) {
                    destination$iv$iv2.add(new ActorData(new Actor((String) item$iv$iv2, (String) null, 2, (DefaultConstructorMarker) null), (ActorRole) null, (String) null, (Actor) null, 14, (DefaultConstructorMarker) null));
                    $this$map$iv = $this$map$iv;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                    $result = $result;
                }
                cast2 = (List) destination$iv$iv2;
                genre = data.getGenre();
                if (genre != null) {
                    arrayList = null;
                } else {
                    arrayList = null;
                }
                genre2 = arrayList;
                match = data.getMatch();
                if (match != null) {
                    strReplace$default = StringsKt.replace$default(match, "IMDb ", "", false, 4, (Object) null);
                } else {
                    strReplace$default = null;
                }
                rating = strReplace$default;
                runTime = UtilsKt.convertRuntimeToMinutes(String.valueOf(data.getRuntime()));
                suggest = data.getSuggest();
                if (suggest != null) {
                    $this$map$iv2 = suggest;
                    destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    $this$mapTo$iv$iv2 = $this$map$iv2;
                    while (r18.hasNext()) {
                        Iterable $this$map$iv7 = $this$map$iv2;
                        final Suggest it6 = (Suggest) item$iv$iv4;
                        destination$iv$iv3.add(MainAPIKt.newAnimeSearchResponse$default(this, "", AppUtils.INSTANCE.toJson(new Id(it6.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj4) {
                                return PrimeVideoMirrorProvider.load$lambda$4$0(it6, this, (AnimeSearchResponse) obj4);
                            }
                        }, 12, (Object) null));
                        $this$map$iv2 = $this$map$iv7;
                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv2;
                        castList = castList;
                        coroutine_suspended = coroutine_suspended;
                    }
                    obj3 = coroutine_suspended;
                    castList2 = castList;
                    arrayList2 = (List) destination$iv$iv3;
                } else {
                    obj3 = coroutine_suspended;
                    castList2 = castList;
                    arrayList2 = null;
                }
                suggest2 = arrayList2;
                if (CollectionsKt.first(data.getEpisodes()) == null) {
                    $this$mapTo$iv = CollectionsKt.filterNotNull(data.getEpisodes());
                    destination$iv = episodes;
                    $i$f$mapTo = 0;
                    while (it.hasNext()) {
                        Object item$iv3 = it.next();
                        final com.horis.cncverse.entities.Episode it7 = (com.horis.cncverse.entities.Episode) item$iv3;
                        destination$iv.add(MainAPIKt.newEpisode(this, new LoadData(title, it7.getId()), new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda5
                            public final Object invoke(Object obj4) {
                                return PrimeVideoMirrorProvider.load$lambda$6$0(it7, (Episode) obj4);
                            }
                        }));
                        $this$mapTo$iv = $this$mapTo$iv;
                        $i$f$mapTo = $i$f$mapTo;
                    }
                    nextPageShow = data.getNextPageShow();
                    if (nextPageShow == null) {
                        String nextPageSeason3 = data.getNextPageSeason();
                        Intrinsics.checkNotNull(nextPageSeason3);
                        c00322.L$0 = url4;
                        c00322.L$1 = url3;
                        c00322.L$2 = SpillingKt.nullOutSpilledVariable(cookies);
                        c00322.L$3 = data;
                        c00322.L$4 = episodes;
                        c00322.L$5 = title;
                        c00322.L$6 = SpillingKt.nullOutSpilledVariable(castList2);
                        c00322.L$7 = cast2;
                        c00322.L$8 = genre2;
                        c00322.L$9 = rating;
                        c00322.L$10 = suggest2;
                        c00322.L$11 = episodes;
                        c00322.I$0 = runTime;
                        c00322.label = 3;
                        C00321 c00326 = c00322;
                        url5 = url4;
                        episodes2 = getEpisodes(title, url5, nextPageSeason3, 2, c00326);
                        c00322 = c00326;
                        obj3 = obj3;
                        if (episodes2 == obj3) {
                            return obj3;
                        }
                        Map map5 = cookies;
                        runTime2 = runTime;
                        cookies2 = map5;
                        url6 = url5;
                        id2 = url3;
                        data2 = data;
                        genre3 = genre2;
                        rating2 = rating;
                        title2 = title;
                        arrayList3 = episodes;
                        episodes3 = arrayList3;
                        cast3 = cast2;
                        arrayList3.addAll((Collection) episodes2);
                        int i3 = runTime2;
                        cookies = cookies2;
                        runTime = i3;
                        title3 = title2;
                        episodes4 = episodes3;
                        id3 = id2;
                        rating = rating2;
                        genre2 = genre3;
                        url7 = url6;
                        data = data2;
                        cast4 = cast3;
                        season = data.getSeason();
                        if (season != null) {
                        }
                        title5 = title3;
                        cast6 = cast4;
                        data3 = data;
                        title4 = url7;
                        cast5 = suggest2;
                        runTime3 = runTime;
                        genre4 = genre2;
                        genre5 = episodes4;
                        id4 = id3;
                        id5 = rating;
                        break;
                    }
                    String str11 = url3;
                    cast4 = cast2;
                    id3 = str11;
                    title3 = title;
                    url7 = url4;
                    episodes4 = episodes;
                    season = data.getSeason();
                    if (season != null) {
                    }
                    title5 = title3;
                    cast6 = cast4;
                    data3 = data;
                    title4 = url7;
                    cast5 = suggest2;
                    runTime3 = runTime;
                    genre4 = genre2;
                    genre5 = episodes4;
                    id4 = id3;
                    id5 = rating;
                    break;
                } else {
                    Boxing.boxBoolean(episodes.add(MainAPIKt.newEpisode(this, new LoadData(title, url3), new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj4) {
                            return PrimeVideoMirrorProvider.load$lambda$5(data, (Episode) obj4);
                        }
                    })));
                    runTime3 = runTime;
                    id4 = url3;
                    cast5 = suggest2;
                    c00322 = c00322;
                    data3 = data;
                    genre4 = genre2;
                    obj3 = obj3;
                    title4 = url4;
                    genre5 = episodes;
                    title5 = title;
                    cast6 = cast2;
                    id5 = rating;
                }
                if (CollectionsKt.first(data3.getEpisodes()) == null) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                TvType type3 = tvType;
                String rating6 = id5;
                C00345 c00347 = new C00345(id4, this, data3, genre4, cast6, id5, runTime3, cast5, null);
                c00322.L$0 = SpillingKt.nullOutSpilledVariable(title4);
                c00322.L$1 = SpillingKt.nullOutSpilledVariable(id4);
                c00322.L$2 = SpillingKt.nullOutSpilledVariable(cookies);
                c00322.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                c00322.L$4 = SpillingKt.nullOutSpilledVariable(genre5);
                c00322.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                c00322.L$6 = SpillingKt.nullOutSpilledVariable(castList2);
                c00322.L$7 = SpillingKt.nullOutSpilledVariable(cast6);
                c00322.L$8 = SpillingKt.nullOutSpilledVariable(genre4);
                c00322.L$9 = SpillingKt.nullOutSpilledVariable(rating6);
                c00322.L$10 = SpillingKt.nullOutSpilledVariable(cast5);
                c00322.L$11 = SpillingKt.nullOutSpilledVariable(type3);
                c00322.I$0 = runTime3;
                c00322.label = 5;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, title5, title4, type3, genre5, c00347, c00322);
                if ($result == obj3) {
                    return obj3;
                }
                return $result;
            case 3:
                int runTime5 = c00323.I$0;
                arrayList3 = (ArrayList) c00323.L$11;
                List suggest4 = (List) c00323.L$10;
                rating2 = (String) c00323.L$9;
                genre3 = (List) c00323.L$8;
                cast3 = (List) c00323.L$7;
                List castList4 = (List) c00323.L$6;
                title2 = (String) c00323.L$5;
                episodes3 = (ArrayList) c00323.L$4;
                data2 = (PostData) c00323.L$3;
                cookies2 = (Map) c00323.L$2;
                runTime2 = runTime5;
                id2 = (String) c00323.L$1;
                url6 = (String) c00323.L$0;
                ResultKt.throwOnFailure($result);
                c00322 = c00323;
                castList2 = castList4;
                obj3 = coroutine_suspended;
                suggest2 = suggest4;
                episodes2 = $result;
                arrayList3.addAll((Collection) episodes2);
                int i4 = runTime2;
                cookies = cookies2;
                runTime = i4;
                title3 = title2;
                episodes4 = episodes3;
                id3 = id2;
                rating = rating2;
                genre2 = genre3;
                url7 = url6;
                data = data2;
                cast4 = cast3;
                season = data.getSeason();
                if (season != null) {
                    break;
                }
                title5 = title3;
                cast6 = cast4;
                data3 = data;
                title4 = url7;
                cast5 = suggest2;
                runTime3 = runTime;
                genre4 = genre2;
                genre5 = episodes4;
                id4 = id3;
                id5 = rating;
                if (CollectionsKt.first(data3.getEpisodes()) == null) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                TvType type4 = tvType;
                String rating7 = id5;
                C00345 c00348 = new C00345(id4, this, data3, genre4, cast6, id5, runTime3, cast5, null);
                c00322.L$0 = SpillingKt.nullOutSpilledVariable(title4);
                c00322.L$1 = SpillingKt.nullOutSpilledVariable(id4);
                c00322.L$2 = SpillingKt.nullOutSpilledVariable(cookies);
                c00322.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                c00322.L$4 = SpillingKt.nullOutSpilledVariable(genre5);
                c00322.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                c00322.L$6 = SpillingKt.nullOutSpilledVariable(castList2);
                c00322.L$7 = SpillingKt.nullOutSpilledVariable(cast6);
                c00322.L$8 = SpillingKt.nullOutSpilledVariable(genre4);
                c00322.L$9 = SpillingKt.nullOutSpilledVariable(rating7);
                c00322.L$10 = SpillingKt.nullOutSpilledVariable(cast5);
                c00322.L$11 = SpillingKt.nullOutSpilledVariable(type4);
                c00322.I$0 = runTime3;
                c00322.label = 5;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, title5, title4, type4, genre5, c00348, c00322);
                if ($result == obj3) {
                    return obj3;
                }
                return $result;
            case 4:
                int runTime6 = c00323.I$0;
                suggest3 = (List) c00323.L$10;
                title7 = (String) c00323.L$9;
                List genre6 = (List) c00323.L$8;
                cast4 = (List) c00323.L$7;
                castList3 = (List) c00323.L$6;
                title6 = (String) c00323.L$5;
                episodes5 = (ArrayList) c00323.L$4;
                PostData data5 = (PostData) c00323.L$3;
                Map cookies5 = (Map) c00323.L$2;
                rating3 = (String) c00323.L$1;
                runTime4 = runTime6;
                String url9 = (String) c00323.L$0;
                ResultKt.throwOnFailure($result);
                c00322 = c00323;
                data4 = data5;
                cookies3 = cookies5;
                genre2 = genre6;
                obj3 = coroutine_suspended;
                url7 = url9;
                objAmap = $result;
                String str12 = title6;
                title4 = url7;
                genre4 = genre2;
                genre5 = episodes5;
                title5 = str12;
                id5 = title7;
                castList2 = castList3;
                runTime3 = runTime4;
                data3 = data4;
                cookies = cookies3;
                cast6 = cast4;
                cast5 = suggest3;
                id4 = rating3;
                if (CollectionsKt.first(data3.getEpisodes()) == null) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                TvType type5 = tvType;
                String rating8 = id5;
                C00345 c00349 = new C00345(id4, this, data3, genre4, cast6, id5, runTime3, cast5, null);
                c00322.L$0 = SpillingKt.nullOutSpilledVariable(title4);
                c00322.L$1 = SpillingKt.nullOutSpilledVariable(id4);
                c00322.L$2 = SpillingKt.nullOutSpilledVariable(cookies);
                c00322.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                c00322.L$4 = SpillingKt.nullOutSpilledVariable(genre5);
                c00322.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                c00322.L$6 = SpillingKt.nullOutSpilledVariable(castList2);
                c00322.L$7 = SpillingKt.nullOutSpilledVariable(cast6);
                c00322.L$8 = SpillingKt.nullOutSpilledVariable(genre4);
                c00322.L$9 = SpillingKt.nullOutSpilledVariable(rating8);
                c00322.L$10 = SpillingKt.nullOutSpilledVariable(cast5);
                c00322.L$11 = SpillingKt.nullOutSpilledVariable(type5);
                c00322.I$0 = runTime3;
                c00322.label = 5;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, title5, title4, type5, genre5, c00349, c00322);
                if ($result == obj3) {
                    return obj3;
                }
                return $result;
            case 5:
                int i5 = c00323.I$0;
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$4$0(Suggest $it, PrimeVideoMirrorProvider this$0, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl("https://imgcdn.kim/pv/v/" + $it.getId() + ".jpg");
        $this$newAnimeSearchResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this$0.getMainUrl() + "/home")));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$5(PostData $data, Episode $this$newEpisode) {
        $this$newEpisode.setName($data.getTitle());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$6$0(com.horis.cncverse.entities.Episode $it, Episode $this$newEpisode) {
        $this$newEpisode.setName($it.getT());
        $this$newEpisode.setEpisode(StringsKt.toIntOrNull(StringsKt.replace$default($it.getEp(), "E", "", false, 4, (Object) null)));
        $this$newEpisode.setSeason(StringsKt.toIntOrNull(StringsKt.replace$default($it.getS(), "S", "", false, 4, (Object) null)));
        $this$newEpisode.setPosterUrl("https://imgcdn.kim/pvepimg/" + $it.getId() + ".jpg");
        $this$newEpisode.setRunTime(StringsKt.toIntOrNull(StringsKt.replace$default($it.getTime(), "m", "", false, 4, (Object) null)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.horis.cncverse.PrimeVideoMirrorProvider$load$4 */
    /* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/horis/cncverse/entities/Season;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.PrimeVideoMirrorProvider$load$4", f = "PrimeVideoMirrorProvider.kt", i = {0}, l = {207}, m = "invokeSuspend", n = {"it"}, nl = {-1}, s = {"L$0"}, v = 2)
    static final class C00334 extends SuspendLambda implements Function2<Season, Continuation<? super Boolean>, Object> {
        final /* synthetic */ ArrayList<Episode> $episodes;
        final /* synthetic */ String $title;
        final /* synthetic */ String $url;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ PrimeVideoMirrorProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00334(ArrayList<Episode> arrayList, PrimeVideoMirrorProvider primeVideoMirrorProvider, String str, String str2, Continuation<? super C00334> continuation) {
            super(2, continuation);
            this.$episodes = arrayList;
            this.this$0 = primeVideoMirrorProvider;
            this.$title = str;
            this.$url = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00334 = new C00334(this.$episodes, this.this$0, this.$title, this.$url, continuation);
            c00334.L$0 = obj;
            return c00334;
        }

        public final Object invoke(Season season, Continuation<? super Boolean> continuation) {
            return create(season, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object episodes;
            ArrayList<Episode> arrayList;
            Season it = (Season) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    ArrayList<Episode> arrayList2 = this.$episodes;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = arrayList2;
                    this.label = 1;
                    episodes = this.this$0.getEpisodes(this.$title, this.$url, it.getId(), 1, (Continuation) this);
                    if (episodes == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    arrayList = arrayList2;
                    break;
                    break;
                case 1:
                    arrayList = (ArrayList) this.L$1;
                    ResultKt.throwOnFailure($result);
                    episodes = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Boxing.boxBoolean(arrayList.addAll((Collection) episodes));
        }
    }

    /* JADX INFO: renamed from: com.horis.cncverse.PrimeVideoMirrorProvider$load$5 */
    /* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.PrimeVideoMirrorProvider$load$5", f = "PrimeVideoMirrorProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00345 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $cast;
        final /* synthetic */ PostData $data;
        final /* synthetic */ List<String> $genre;
        final /* synthetic */ String $id;
        final /* synthetic */ String $rating;
        final /* synthetic */ int $runTime;
        final /* synthetic */ List<AnimeSearchResponse> $suggest;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PrimeVideoMirrorProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00345(String str, PrimeVideoMirrorProvider primeVideoMirrorProvider, PostData postData, List<String> list, List<ActorData> list2, String str2, int i, List<AnimeSearchResponse> list3, Continuation<? super C00345> continuation) {
            super(2, continuation);
            this.$id = str;
            this.this$0 = primeVideoMirrorProvider;
            this.$data = postData;
            this.$genre = list;
            this.$cast = list2;
            this.$rating = str2;
            this.$runTime = i;
            this.$suggest = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00345 = new C00345(this.$id, this.this$0, this.$data, this.$genre, this.$cast, this.$rating, this.$runTime, this.$suggest, continuation);
            c00345.L$0 = obj;
            return c00345;
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
                    $this$newTvSeriesLoadResponse.setPosterUrl("https://imgcdn.kim/pv/v/" + this.$id + ".jpg");
                    $this$newTvSeriesLoadResponse.setBackgroundPosterUrl("https://imgcdn.kim/pv/h/" + this.$id + ".jpg");
                    $this$newTvSeriesLoadResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this.this$0.getMainUrl() + "/home")));
                    $this$newTvSeriesLoadResponse.setPlot(this.$data.getDesc());
                    $this$newTvSeriesLoadResponse.setYear(StringsKt.toIntOrNull(this.$data.getYear()));
                    $this$newTvSeriesLoadResponse.setTags(this.$genre);
                    $this$newTvSeriesLoadResponse.setActors(this.$cast);
                    $this$newTvSeriesLoadResponse.setScore(Score.Companion.from10(this.$rating));
                    $this$newTvSeriesLoadResponse.setDuration(Boxing.boxInt(this.$runTime));
                    $this$newTvSeriesLoadResponse.setContentRating(this.$data.getUa());
                    $this$newTvSeriesLoadResponse.setRecommendations(this.$suggest);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x0149 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:17:0x014a  */
    /* JADX WARN: Code duplicated, block: B:20:0x0172  */
    /* JADX WARN: Code duplicated, block: B:23:0x0183 A[LOOP:0: B:21:0x017d->B:23:0x0183, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:25:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:28:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x014a -> B:18:0x0150). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.attributes.nodes.LoopInfo.getExitEdges(LoopInfo.java:64)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:265)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        */
    public final java.lang.Object getEpisodes(java.lang.String r29, java.lang.String r30, java.lang.String r31, int r32, kotlin.coroutines.Continuation<? super java.util.List<com.lagradost.cloudstream3.Episode>> r33) {
        /*
            Method dump skipped, instruction units count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horis.cncverse.PrimeVideoMirrorProvider.getEpisodes(java.lang.String, java.lang.String, java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getEpisodes$lambda$0$0(com.horis.cncverse.entities.Episode $it, Episode $this$newEpisode) {
        $this$newEpisode.setName($it.getT());
        $this$newEpisode.setEpisode(StringsKt.toIntOrNull(StringsKt.replace$default($it.getEp(), "E", "", false, 4, (Object) null)));
        $this$newEpisode.setSeason(StringsKt.toIntOrNull(StringsKt.replace$default($it.getS(), "S", "", false, 4, (Object) null)));
        $this$newEpisode.setPosterUrl("https://imgcdn.kim/pvepimg/" + $it.getId() + ".jpg");
        $this$newEpisode.setRunTime(StringsKt.toIntOrNull(StringsKt.replace$default($it.getTime(), "m", "", false, 4, (Object) null)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x0232 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x0233  */
    /* JADX WARN: Code duplicated, block: B:59:0x02d4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:60:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:63:0x0310  */
    /* JADX WARN: Code duplicated, block: B:65:0x0339 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x033a  */
    /* JADX WARN: Code duplicated, block: B:69:0x03c8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:70:0x03c9  */
    /* JADX WARN: Code duplicated, block: B:72:0x03fb  */
    /* JADX WARN: Code duplicated, block: B:75:0x040e  */
    /* JADX WARN: Code duplicated, block: B:79:0x0417  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x041a  */
    /* JADX WARN: Code duplicated, block: B:83:0x041f  */
    /* JADX WARN: Code duplicated, block: B:85:0x0479 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:86:0x047a  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) throws Exception {
        C00351 c00351;
        String data2;
        Function1<? super ExtractorLink, Unit> function3;
        Object objResolveApiUrl;
        Function1<? super SubtitleFile, Unit> function4;
        boolean isCasting2;
        String apiBase;
        String id;
        Function1<? super ExtractorLink, Unit> function5;
        Object newTvUserToken$default;
        String apiBase2;
        String id2;
        boolean isCasting3;
        Function1<? super SubtitleFile, Unit> function6;
        Function1<? super ExtractorLink, Unit> function7;
        Ref.ObjectRef response;
        String data3;
        String apiBase3;
        Function1<? super ExtractorLink, Unit> function8;
        boolean isCasting4;
        String userToken;
        boolean z;
        String str;
        String str2;
        Object obj;
        Object obj2;
        String id3;
        Object obj3;
        Object obj4;
        Function1<? super SubtitleFile, Unit> function9;
        String data4;
        String id4;
        Function1<? super ExtractorLink, Unit> function10;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef response2;
        boolean isCasting5;
        String data5;
        boolean z2;
        boolean isCasting6;
        String apiBase4;
        Function1<? super ExtractorLink, Unit> function11;
        Function1<? super SubtitleFile, Unit> function12;
        String data6;
        Ref.ObjectRef response3;
        Object newTvUserToken;
        String data7;
        boolean isCasting7;
        Ref.ObjectRef response4;
        String id5;
        String apiBase5;
        Function1<? super ExtractorLink, Unit> function13;
        Function1<? super SubtitleFile, Unit> function14;
        String userToken2;
        String id6;
        String apiBase6;
        Function1<? super ExtractorLink, Unit> function15;
        boolean isCasting8;
        Ref.ObjectRef response5;
        Object obj5;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef response6;
        String data8;
        String userToken3;
        String apiBase7;
        String id7;
        String video_link;
        boolean z3;
        Object objNewExtractorLink;
        Function1<? super ExtractorLink, Unit> function16;
        if (continuation instanceof C00351) {
            c00351 = (C00351) continuation;
            if ((c00351.label & Integer.MIN_VALUE) != 0) {
                c00351.label -= Integer.MIN_VALUE;
            } else {
                c00351 = new C00351(continuation);
            }
        } else {
            c00351 = new C00351(continuation);
        }
        C00351 c00352 = c00351;
        Object $result = c00352.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00352.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!SubscriptionHelper.INSTANCE.isSubscribed(context)) {
                    PrimeVideoMirrorProvider $this$loadLinks_u24lambda_u240 = this;
                    final Context _ctx = context;
                    SharedPreferences _prefs = _ctx != null ? _ctx.getSharedPreferences("CNCVerseSubscription", 0) : null;
                    String _mode = _prefs != null ? _prefs.getString("mode", "ads") : null;
                    long _expiresAt = _prefs != null ? _prefs.getLong("expires_at", 0L) : 0L;
                    long _nowSec = System.currentTimeMillis() / 1000;
                    boolean _isSubscribed = Intrinsics.areEqual(_mode, "subscription") && (_expiresAt == 0 || _expiresAt > _nowSec);
                    if (!_isSubscribed) {
                        if (Intrinsics.areEqual(_mode, "subscription") && _expiresAt > 0 && _expiresAt <= _nowSec) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda9
                                @Override // java.lang.Runnable
                                public final void run() {
                                    PrimeVideoMirrorProvider.loadLinks$lambda$0$0(_ctx);
                                }
                            });
                        }
                        $this$loadLinks_u24lambda_u240.openInExternalBrowser(new String(Base64.decode(OMG10, 0), Charsets.UTF_8));
                    }
                }
                data2 = data;
                c00352.L$0 = data2;
                c00352.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                function3 = function2;
                c00352.L$2 = function3;
                c00352.Z$0 = isCasting;
                c00352.label = 1;
                objResolveApiUrl = UtilsKt.resolveApiUrl(c00352);
                if (objResolveApiUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function4 = function1;
                isCasting2 = isCasting;
                apiBase = (String) objResolveApiUrl;
                String text$iv = data2;
                id = ((LoadData) UtilsKt.getJSONParser().parse(text$iv, Reflection.getOrCreateKotlinClass(LoadData.class))).getId();
                c00352.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00352.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                c00352.L$2 = function3;
                c00352.L$3 = apiBase;
                c00352.L$4 = id;
                c00352.Z$0 = isCasting2;
                c00352.label = 2;
                function5 = function3;
                newTvUserToken$default = UtilsKt.getNewTvUserToken$default(apiBase, "pv", false, c00352, 4, null);
                if (newTvUserToken$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiBase2 = apiBase;
                id2 = id;
                isCasting3 = isCasting2;
                function6 = function4;
                function7 = function5;
                String userToken4 = (String) newTvUserToken$default;
                response = new Ref.ObjectRef();
                data3 = data2;
                Map<String, String> mapBuildNewTvHeaders = UtilsKt.buildNewTvHeaders("pv", MapsKt.mapOf(TuplesKt.to("Usertoken", userToken4)));
                c00352.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                c00352.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                c00352.L$2 = function7;
                c00352.L$3 = apiBase2;
                c00352.L$4 = id2;
                c00352.L$5 = SpillingKt.nullOutSpilledVariable(userToken4);
                c00352.L$6 = response;
                c00352.L$7 = response;
                c00352.Z$0 = isCasting3;
                c00352.label = 3;
                apiBase3 = apiBase2;
                function8 = function7;
                isCasting4 = isCasting3;
                userToken = userToken4;
                z = false;
                str = "/newtv/player.php?id=";
                str2 = "pv";
                obj = "Usertoken";
                obj2 = coroutine_suspended;
                id3 = id2;
                obj3 = Requests.get$default(UtilsKt.getApp(), apiBase2 + "/newtv/player.php?id=" + id2, mapBuildNewTvHeaders, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00352, 4092, (Object) null);
                c00352 = c00352;
                if (obj3 == obj2) {
                    return obj2;
                }
                obj4 = obj3;
                function9 = function6;
                data4 = apiBase3;
                id4 = id3;
                function10 = function8;
                objectRef = response;
                response2 = objectRef;
                isCasting5 = isCasting4;
                data5 = data3;
                NiceResponse this_$iv = (NiceResponse) obj4;
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                objectRef.element = parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                if (Intrinsics.areEqual(((NewTvPlayerResponse) response2.element).getStatus(), "otp")) {
                    c00352.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                    c00352.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                    c00352.L$2 = function10;
                    c00352.L$3 = data4;
                    c00352.L$4 = id4;
                    c00352.L$5 = SpillingKt.nullOutSpilledVariable(userToken);
                    c00352.L$6 = response2;
                    c00352.L$7 = null;
                    c00352.Z$0 = isCasting5;
                    c00352.label = 4;
                    z2 = true;
                    newTvUserToken = UtilsKt.getNewTvUserToken(data4, str2, true, c00352);
                    if (newTvUserToken == obj2) {
                        return obj2;
                    }
                    data7 = data5;
                    isCasting7 = isCasting5;
                    response4 = response2;
                    id5 = id4;
                    apiBase5 = data4;
                    function13 = function10;
                    function14 = function9;
                    userToken2 = (String) newTvUserToken;
                    Map<String, String> mapBuildNewTvHeaders2 = UtilsKt.buildNewTvHeaders(str2, MapsKt.mapOf(TuplesKt.to(obj, userToken2)));
                    c00352.L$0 = SpillingKt.nullOutSpilledVariable(data7);
                    c00352.L$1 = SpillingKt.nullOutSpilledVariable(function14);
                    c00352.L$2 = function13;
                    c00352.L$3 = apiBase5;
                    c00352.L$4 = SpillingKt.nullOutSpilledVariable(id5);
                    c00352.L$5 = SpillingKt.nullOutSpilledVariable(userToken2);
                    c00352.L$6 = response4;
                    c00352.L$7 = response4;
                    c00352.Z$0 = isCasting7;
                    c00352.label = 5;
                    C00351 c00353 = c00352;
                    id6 = id5;
                    apiBase6 = apiBase5;
                    function15 = function13;
                    isCasting8 = isCasting7;
                    response5 = response4;
                    obj5 = Requests.get$default(UtilsKt.getApp(), apiBase5 + str + id5, mapBuildNewTvHeaders2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00353, 4092, (Object) null);
                    c00352 = c00353;
                    if (obj5 == obj2) {
                        return obj2;
                    }
                    objectRef2 = response5;
                    response6 = objectRef2;
                    function12 = function14;
                    data8 = data7;
                    function11 = function15;
                    userToken3 = userToken2;
                    apiBase7 = apiBase6;
                    id7 = id6;
                    NiceResponse this_$iv2 = (NiceResponse) obj5;
                    ResponseParser parser2 = this_$iv2.getParser();
                    Intrinsics.checkNotNull(parser2);
                    objectRef2.element = parser2.parse(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                    response3 = response6;
                    userToken = userToken3;
                    data6 = data8;
                    isCasting6 = isCasting8;
                    data4 = apiBase7;
                    apiBase4 = id7;
                } else {
                    z2 = true;
                    isCasting6 = isCasting5;
                    apiBase4 = id4;
                    function11 = function10;
                    function12 = function9;
                    data6 = data5;
                    response3 = response2;
                }
                video_link = ((NewTvPlayerResponse) response3.element).getVideo_link();
                if (video_link != null || StringsKt.isBlank(video_link)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    return Boxing.boxBoolean(z);
                }
                String name = getName();
                String name2 = getName();
                String video_link2 = ((NewTvPlayerResponse) response3.element).getVideo_link();
                ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                C00363 c00363 = new C00363(response3, data4, null);
                c00352.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                c00352.L$1 = SpillingKt.nullOutSpilledVariable(function12);
                c00352.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                c00352.L$3 = SpillingKt.nullOutSpilledVariable(data4);
                c00352.L$4 = SpillingKt.nullOutSpilledVariable(apiBase4);
                c00352.L$5 = SpillingKt.nullOutSpilledVariable(userToken);
                c00352.L$6 = SpillingKt.nullOutSpilledVariable(response3);
                c00352.L$7 = function11;
                c00352.Z$0 = isCasting6;
                c00352.label = 6;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, video_link2, extractorLinkType, c00363, c00352);
                if (objNewExtractorLink == obj2) {
                    return obj2;
                }
                function16 = function11;
                function16.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(z2);
            case 1:
                boolean isCasting9 = c00352.Z$0;
                function3 = (Function1) c00352.L$2;
                Function1<? super SubtitleFile, Unit> function17 = (Function1) c00352.L$1;
                String data9 = (String) c00352.L$0;
                ResultKt.throwOnFailure($result);
                isCasting2 = isCasting9;
                function4 = function17;
                data2 = data9;
                objResolveApiUrl = $result;
                apiBase = (String) objResolveApiUrl;
                String text$iv2 = data2;
                id = ((LoadData) UtilsKt.getJSONParser().parse(text$iv2, Reflection.getOrCreateKotlinClass(LoadData.class))).getId();
                c00352.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00352.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                c00352.L$2 = function3;
                c00352.L$3 = apiBase;
                c00352.L$4 = id;
                c00352.Z$0 = isCasting2;
                c00352.label = 2;
                function5 = function3;
                newTvUserToken$default = UtilsKt.getNewTvUserToken$default(apiBase, "pv", false, c00352, 4, null);
                if (newTvUserToken$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiBase2 = apiBase;
                id2 = id;
                isCasting3 = isCasting2;
                function6 = function4;
                function7 = function5;
                String userToken5 = (String) newTvUserToken$default;
                response = new Ref.ObjectRef();
                data3 = data2;
                Map<String, String> mapBuildNewTvHeaders3 = UtilsKt.buildNewTvHeaders("pv", MapsKt.mapOf(TuplesKt.to("Usertoken", userToken5)));
                c00352.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                c00352.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                c00352.L$2 = function7;
                c00352.L$3 = apiBase2;
                c00352.L$4 = id2;
                c00352.L$5 = SpillingKt.nullOutSpilledVariable(userToken5);
                c00352.L$6 = response;
                c00352.L$7 = response;
                c00352.Z$0 = isCasting3;
                c00352.label = 3;
                apiBase3 = apiBase2;
                function8 = function7;
                isCasting4 = isCasting3;
                userToken = userToken5;
                z = false;
                str = "/newtv/player.php?id=";
                str2 = "pv";
                obj = "Usertoken";
                obj2 = coroutine_suspended;
                id3 = id2;
                obj3 = Requests.get$default(UtilsKt.getApp(), apiBase2 + "/newtv/player.php?id=" + id2, mapBuildNewTvHeaders3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00352, 4092, (Object) null);
                c00352 = c00352;
                if (obj3 == obj2) {
                    return obj2;
                }
                obj4 = obj3;
                function9 = function6;
                data4 = apiBase3;
                id4 = id3;
                function10 = function8;
                objectRef = response;
                response2 = objectRef;
                isCasting5 = isCasting4;
                data5 = data3;
                NiceResponse this_$iv3 = (NiceResponse) obj4;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                objectRef.element = parser3.parse(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                if (Intrinsics.areEqual(((NewTvPlayerResponse) response2.element).getStatus(), "otp")) {
                    c00352.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                    c00352.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                    c00352.L$2 = function10;
                    c00352.L$3 = data4;
                    c00352.L$4 = id4;
                    c00352.L$5 = SpillingKt.nullOutSpilledVariable(userToken);
                    c00352.L$6 = response2;
                    c00352.L$7 = null;
                    c00352.Z$0 = isCasting5;
                    c00352.label = 4;
                    z2 = true;
                    newTvUserToken = UtilsKt.getNewTvUserToken(data4, str2, true, c00352);
                    if (newTvUserToken == obj2) {
                        return obj2;
                    }
                    data7 = data5;
                    isCasting7 = isCasting5;
                    response4 = response2;
                    id5 = id4;
                    apiBase5 = data4;
                    function13 = function10;
                    function14 = function9;
                    userToken2 = (String) newTvUserToken;
                    Map<String, String> mapBuildNewTvHeaders4 = UtilsKt.buildNewTvHeaders(str2, MapsKt.mapOf(TuplesKt.to(obj, userToken2)));
                    c00352.L$0 = SpillingKt.nullOutSpilledVariable(data7);
                    c00352.L$1 = SpillingKt.nullOutSpilledVariable(function14);
                    c00352.L$2 = function13;
                    c00352.L$3 = apiBase5;
                    c00352.L$4 = SpillingKt.nullOutSpilledVariable(id5);
                    c00352.L$5 = SpillingKt.nullOutSpilledVariable(userToken2);
                    c00352.L$6 = response4;
                    c00352.L$7 = response4;
                    c00352.Z$0 = isCasting7;
                    c00352.label = 5;
                    C00351 c00354 = c00352;
                    id6 = id5;
                    apiBase6 = apiBase5;
                    function15 = function13;
                    isCasting8 = isCasting7;
                    response5 = response4;
                    obj5 = Requests.get$default(UtilsKt.getApp(), apiBase5 + str + id5, mapBuildNewTvHeaders4, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00354, 4092, (Object) null);
                    c00352 = c00354;
                    if (obj5 == obj2) {
                        return obj2;
                    }
                    objectRef2 = response5;
                    response6 = objectRef2;
                    function12 = function14;
                    data8 = data7;
                    function11 = function15;
                    userToken3 = userToken2;
                    apiBase7 = apiBase6;
                    id7 = id6;
                    NiceResponse this_$iv4 = (NiceResponse) obj5;
                    ResponseParser parser4 = this_$iv4.getParser();
                    Intrinsics.checkNotNull(parser4);
                    objectRef2.element = parser4.parse(this_$iv4.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                    response3 = response6;
                    userToken = userToken3;
                    data6 = data8;
                    isCasting6 = isCasting8;
                    data4 = apiBase7;
                    apiBase4 = id7;
                } else {
                    z2 = true;
                    isCasting6 = isCasting5;
                    apiBase4 = id4;
                    function11 = function10;
                    function12 = function9;
                    data6 = data5;
                    response3 = response2;
                }
                video_link = ((NewTvPlayerResponse) response3.element).getVideo_link();
                if (video_link != null) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (z3) {
                    return Boxing.boxBoolean(z);
                }
                String name3 = getName();
                String name4 = getName();
                String video_link3 = ((NewTvPlayerResponse) response3.element).getVideo_link();
                ExtractorLinkType extractorLinkType2 = ExtractorLinkType.M3U8;
                C00363 c00364 = new C00363(response3, data4, null);
                c00352.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                c00352.L$1 = SpillingKt.nullOutSpilledVariable(function12);
                c00352.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                c00352.L$3 = SpillingKt.nullOutSpilledVariable(data4);
                c00352.L$4 = SpillingKt.nullOutSpilledVariable(apiBase4);
                c00352.L$5 = SpillingKt.nullOutSpilledVariable(userToken);
                c00352.L$6 = SpillingKt.nullOutSpilledVariable(response3);
                c00352.L$7 = function11;
                c00352.Z$0 = isCasting6;
                c00352.label = 6;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name3, name4, video_link3, extractorLinkType2, c00364, c00352);
                if (objNewExtractorLink == obj2) {
                    return obj2;
                }
                function16 = function11;
                function16.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(z2);
            case 2:
                boolean isCasting10 = c00352.Z$0;
                String id8 = (String) c00352.L$4;
                String apiBase8 = (String) c00352.L$3;
                Function1<? super ExtractorLink, Unit> function18 = (Function1) c00352.L$2;
                Function1<? super SubtitleFile, Unit> function19 = (Function1) c00352.L$1;
                String data10 = (String) c00352.L$0;
                ResultKt.throwOnFailure($result);
                isCasting3 = isCasting10;
                data2 = data10;
                function7 = function18;
                id2 = id8;
                function6 = function19;
                apiBase2 = apiBase8;
                newTvUserToken$default = $result;
                String userToken6 = (String) newTvUserToken$default;
                response = new Ref.ObjectRef();
                data3 = data2;
                Map<String, String> mapBuildNewTvHeaders5 = UtilsKt.buildNewTvHeaders("pv", MapsKt.mapOf(TuplesKt.to("Usertoken", userToken6)));
                c00352.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                c00352.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                c00352.L$2 = function7;
                c00352.L$3 = apiBase2;
                c00352.L$4 = id2;
                c00352.L$5 = SpillingKt.nullOutSpilledVariable(userToken6);
                c00352.L$6 = response;
                c00352.L$7 = response;
                c00352.Z$0 = isCasting3;
                c00352.label = 3;
                apiBase3 = apiBase2;
                function8 = function7;
                isCasting4 = isCasting3;
                userToken = userToken6;
                z = false;
                str = "/newtv/player.php?id=";
                str2 = "pv";
                obj = "Usertoken";
                obj2 = coroutine_suspended;
                id3 = id2;
                obj3 = Requests.get$default(UtilsKt.getApp(), apiBase2 + "/newtv/player.php?id=" + id2, mapBuildNewTvHeaders5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00352, 4092, (Object) null);
                c00352 = c00352;
                if (obj3 == obj2) {
                    return obj2;
                }
                obj4 = obj3;
                function9 = function6;
                data4 = apiBase3;
                id4 = id3;
                function10 = function8;
                objectRef = response;
                response2 = objectRef;
                isCasting5 = isCasting4;
                data5 = data3;
                NiceResponse this_$iv5 = (NiceResponse) obj4;
                ResponseParser parser5 = this_$iv5.getParser();
                Intrinsics.checkNotNull(parser5);
                objectRef.element = parser5.parse(this_$iv5.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                if (Intrinsics.areEqual(((NewTvPlayerResponse) response2.element).getStatus(), "otp")) {
                    c00352.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                    c00352.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                    c00352.L$2 = function10;
                    c00352.L$3 = data4;
                    c00352.L$4 = id4;
                    c00352.L$5 = SpillingKt.nullOutSpilledVariable(userToken);
                    c00352.L$6 = response2;
                    c00352.L$7 = null;
                    c00352.Z$0 = isCasting5;
                    c00352.label = 4;
                    z2 = true;
                    newTvUserToken = UtilsKt.getNewTvUserToken(data4, str2, true, c00352);
                    if (newTvUserToken == obj2) {
                        return obj2;
                    }
                    data7 = data5;
                    isCasting7 = isCasting5;
                    response4 = response2;
                    id5 = id4;
                    apiBase5 = data4;
                    function13 = function10;
                    function14 = function9;
                    userToken2 = (String) newTvUserToken;
                    Map<String, String> mapBuildNewTvHeaders6 = UtilsKt.buildNewTvHeaders(str2, MapsKt.mapOf(TuplesKt.to(obj, userToken2)));
                    c00352.L$0 = SpillingKt.nullOutSpilledVariable(data7);
                    c00352.L$1 = SpillingKt.nullOutSpilledVariable(function14);
                    c00352.L$2 = function13;
                    c00352.L$3 = apiBase5;
                    c00352.L$4 = SpillingKt.nullOutSpilledVariable(id5);
                    c00352.L$5 = SpillingKt.nullOutSpilledVariable(userToken2);
                    c00352.L$6 = response4;
                    c00352.L$7 = response4;
                    c00352.Z$0 = isCasting7;
                    c00352.label = 5;
                    C00351 c00355 = c00352;
                    id6 = id5;
                    apiBase6 = apiBase5;
                    function15 = function13;
                    isCasting8 = isCasting7;
                    response5 = response4;
                    obj5 = Requests.get$default(UtilsKt.getApp(), apiBase5 + str + id5, mapBuildNewTvHeaders6, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00355, 4092, (Object) null);
                    c00352 = c00355;
                    if (obj5 == obj2) {
                        return obj2;
                    }
                    objectRef2 = response5;
                    response6 = objectRef2;
                    function12 = function14;
                    data8 = data7;
                    function11 = function15;
                    userToken3 = userToken2;
                    apiBase7 = apiBase6;
                    id7 = id6;
                    NiceResponse this_$iv6 = (NiceResponse) obj5;
                    ResponseParser parser6 = this_$iv6.getParser();
                    Intrinsics.checkNotNull(parser6);
                    objectRef2.element = parser6.parse(this_$iv6.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                    response3 = response6;
                    userToken = userToken3;
                    data6 = data8;
                    isCasting6 = isCasting8;
                    data4 = apiBase7;
                    apiBase4 = id7;
                } else {
                    z2 = true;
                    isCasting6 = isCasting5;
                    apiBase4 = id4;
                    function11 = function10;
                    function12 = function9;
                    data6 = data5;
                    response3 = response2;
                }
                video_link = ((NewTvPlayerResponse) response3.element).getVideo_link();
                if (video_link != null) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (z3) {
                    return Boxing.boxBoolean(z);
                }
                String name5 = getName();
                String name6 = getName();
                String video_link4 = ((NewTvPlayerResponse) response3.element).getVideo_link();
                ExtractorLinkType extractorLinkType3 = ExtractorLinkType.M3U8;
                C00363 c00365 = new C00363(response3, data4, null);
                c00352.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                c00352.L$1 = SpillingKt.nullOutSpilledVariable(function12);
                c00352.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                c00352.L$3 = SpillingKt.nullOutSpilledVariable(data4);
                c00352.L$4 = SpillingKt.nullOutSpilledVariable(apiBase4);
                c00352.L$5 = SpillingKt.nullOutSpilledVariable(userToken);
                c00352.L$6 = SpillingKt.nullOutSpilledVariable(response3);
                c00352.L$7 = function11;
                c00352.Z$0 = isCasting6;
                c00352.label = 6;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name5, name6, video_link4, extractorLinkType3, c00365, c00352);
                if (objNewExtractorLink == obj2) {
                    return obj2;
                }
                function16 = function11;
                function16.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(z2);
            case 3:
                boolean isCasting11 = c00352.Z$0;
                Ref.ObjectRef objectRef3 = (Ref.ObjectRef) c00352.L$7;
                Ref.ObjectRef response7 = (Ref.ObjectRef) c00352.L$6;
                String userToken7 = (String) c00352.L$5;
                String id9 = (String) c00352.L$4;
                data4 = (String) c00352.L$3;
                function10 = (Function1) c00352.L$2;
                function9 = (Function1) c00352.L$1;
                String data11 = (String) c00352.L$0;
                ResultKt.throwOnFailure($result);
                data5 = data11;
                obj2 = coroutine_suspended;
                id4 = id9;
                response2 = response7;
                isCasting5 = isCasting11;
                userToken = userToken7;
                obj = "Usertoken";
                str = "/newtv/player.php?id=";
                str2 = "pv";
                z = false;
                objectRef = objectRef3;
                obj4 = $result;
                NiceResponse this_$iv7 = (NiceResponse) obj4;
                ResponseParser parser7 = this_$iv7.getParser();
                Intrinsics.checkNotNull(parser7);
                objectRef.element = parser7.parse(this_$iv7.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                if (Intrinsics.areEqual(((NewTvPlayerResponse) response2.element).getStatus(), "otp")) {
                    c00352.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                    c00352.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                    c00352.L$2 = function10;
                    c00352.L$3 = data4;
                    c00352.L$4 = id4;
                    c00352.L$5 = SpillingKt.nullOutSpilledVariable(userToken);
                    c00352.L$6 = response2;
                    c00352.L$7 = null;
                    c00352.Z$0 = isCasting5;
                    c00352.label = 4;
                    z2 = true;
                    newTvUserToken = UtilsKt.getNewTvUserToken(data4, str2, true, c00352);
                    if (newTvUserToken == obj2) {
                        return obj2;
                    }
                    data7 = data5;
                    isCasting7 = isCasting5;
                    response4 = response2;
                    id5 = id4;
                    apiBase5 = data4;
                    function13 = function10;
                    function14 = function9;
                    userToken2 = (String) newTvUserToken;
                    Map<String, String> mapBuildNewTvHeaders7 = UtilsKt.buildNewTvHeaders(str2, MapsKt.mapOf(TuplesKt.to(obj, userToken2)));
                    c00352.L$0 = SpillingKt.nullOutSpilledVariable(data7);
                    c00352.L$1 = SpillingKt.nullOutSpilledVariable(function14);
                    c00352.L$2 = function13;
                    c00352.L$3 = apiBase5;
                    c00352.L$4 = SpillingKt.nullOutSpilledVariable(id5);
                    c00352.L$5 = SpillingKt.nullOutSpilledVariable(userToken2);
                    c00352.L$6 = response4;
                    c00352.L$7 = response4;
                    c00352.Z$0 = isCasting7;
                    c00352.label = 5;
                    C00351 c00356 = c00352;
                    id6 = id5;
                    apiBase6 = apiBase5;
                    function15 = function13;
                    isCasting8 = isCasting7;
                    response5 = response4;
                    obj5 = Requests.get$default(UtilsKt.getApp(), apiBase5 + str + id5, mapBuildNewTvHeaders7, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00356, 4092, (Object) null);
                    c00352 = c00356;
                    if (obj5 == obj2) {
                        return obj2;
                    }
                    objectRef2 = response5;
                    response6 = objectRef2;
                    function12 = function14;
                    data8 = data7;
                    function11 = function15;
                    userToken3 = userToken2;
                    apiBase7 = apiBase6;
                    id7 = id6;
                    NiceResponse this_$iv8 = (NiceResponse) obj5;
                    ResponseParser parser8 = this_$iv8.getParser();
                    Intrinsics.checkNotNull(parser8);
                    objectRef2.element = parser8.parse(this_$iv8.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                    response3 = response6;
                    userToken = userToken3;
                    data6 = data8;
                    isCasting6 = isCasting8;
                    data4 = apiBase7;
                    apiBase4 = id7;
                } else {
                    z2 = true;
                    isCasting6 = isCasting5;
                    apiBase4 = id4;
                    function11 = function10;
                    function12 = function9;
                    data6 = data5;
                    response3 = response2;
                }
                video_link = ((NewTvPlayerResponse) response3.element).getVideo_link();
                if (video_link != null) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (z3) {
                    return Boxing.boxBoolean(z);
                }
                String name7 = getName();
                String name8 = getName();
                String video_link5 = ((NewTvPlayerResponse) response3.element).getVideo_link();
                ExtractorLinkType extractorLinkType4 = ExtractorLinkType.M3U8;
                C00363 c00366 = new C00363(response3, data4, null);
                c00352.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                c00352.L$1 = SpillingKt.nullOutSpilledVariable(function12);
                c00352.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                c00352.L$3 = SpillingKt.nullOutSpilledVariable(data4);
                c00352.L$4 = SpillingKt.nullOutSpilledVariable(apiBase4);
                c00352.L$5 = SpillingKt.nullOutSpilledVariable(userToken);
                c00352.L$6 = SpillingKt.nullOutSpilledVariable(response3);
                c00352.L$7 = function11;
                c00352.Z$0 = isCasting6;
                c00352.label = 6;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name7, name8, video_link5, extractorLinkType4, c00366, c00352);
                if (objNewExtractorLink == obj2) {
                    return obj2;
                }
                function16 = function11;
                function16.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(z2);
            case 4:
                isCasting7 = c00352.Z$0;
                Ref.ObjectRef response8 = (Ref.ObjectRef) c00352.L$6;
                id5 = (String) c00352.L$4;
                apiBase5 = (String) c00352.L$3;
                Function1<? super ExtractorLink, Unit> function20 = (Function1) c00352.L$2;
                Function1<? super SubtitleFile, Unit> function21 = (Function1) c00352.L$1;
                String data12 = (String) c00352.L$0;
                ResultKt.throwOnFailure($result);
                obj2 = coroutine_suspended;
                obj = "Usertoken";
                str = "/newtv/player.php?id=";
                str2 = "pv";
                function13 = function20;
                data7 = data12;
                z = false;
                response4 = response8;
                z2 = true;
                newTvUserToken = $result;
                function14 = function21;
                userToken2 = (String) newTvUserToken;
                Map<String, String> mapBuildNewTvHeaders8 = UtilsKt.buildNewTvHeaders(str2, MapsKt.mapOf(TuplesKt.to(obj, userToken2)));
                c00352.L$0 = SpillingKt.nullOutSpilledVariable(data7);
                c00352.L$1 = SpillingKt.nullOutSpilledVariable(function14);
                c00352.L$2 = function13;
                c00352.L$3 = apiBase5;
                c00352.L$4 = SpillingKt.nullOutSpilledVariable(id5);
                c00352.L$5 = SpillingKt.nullOutSpilledVariable(userToken2);
                c00352.L$6 = response4;
                c00352.L$7 = response4;
                c00352.Z$0 = isCasting7;
                c00352.label = 5;
                C00351 c00357 = c00352;
                id6 = id5;
                apiBase6 = apiBase5;
                function15 = function13;
                isCasting8 = isCasting7;
                response5 = response4;
                obj5 = Requests.get$default(UtilsKt.getApp(), apiBase5 + str + id5, mapBuildNewTvHeaders8, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00357, 4092, (Object) null);
                c00352 = c00357;
                if (obj5 == obj2) {
                    return obj2;
                }
                objectRef2 = response5;
                response6 = objectRef2;
                function12 = function14;
                data8 = data7;
                function11 = function15;
                userToken3 = userToken2;
                apiBase7 = apiBase6;
                id7 = id6;
                NiceResponse this_$iv9 = (NiceResponse) obj5;
                ResponseParser parser9 = this_$iv9.getParser();
                Intrinsics.checkNotNull(parser9);
                objectRef2.element = parser9.parse(this_$iv9.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                response3 = response6;
                userToken = userToken3;
                data6 = data8;
                isCasting6 = isCasting8;
                data4 = apiBase7;
                apiBase4 = id7;
                video_link = ((NewTvPlayerResponse) response3.element).getVideo_link();
                if (video_link != null) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (z3) {
                    return Boxing.boxBoolean(z);
                }
                String name9 = getName();
                String name10 = getName();
                String video_link6 = ((NewTvPlayerResponse) response3.element).getVideo_link();
                ExtractorLinkType extractorLinkType5 = ExtractorLinkType.M3U8;
                C00363 c00367 = new C00363(response3, data4, null);
                c00352.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                c00352.L$1 = SpillingKt.nullOutSpilledVariable(function12);
                c00352.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                c00352.L$3 = SpillingKt.nullOutSpilledVariable(data4);
                c00352.L$4 = SpillingKt.nullOutSpilledVariable(apiBase4);
                c00352.L$5 = SpillingKt.nullOutSpilledVariable(userToken);
                c00352.L$6 = SpillingKt.nullOutSpilledVariable(response3);
                c00352.L$7 = function11;
                c00352.Z$0 = isCasting6;
                c00352.label = 6;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name9, name10, video_link6, extractorLinkType5, c00367, c00352);
                if (objNewExtractorLink == obj2) {
                    return obj2;
                }
                function16 = function11;
                function16.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(z2);
            case 5:
                boolean isCasting12 = c00352.Z$0;
                objectRef2 = (Ref.ObjectRef) c00352.L$7;
                response6 = (Ref.ObjectRef) c00352.L$6;
                userToken3 = (String) c00352.L$5;
                id7 = (String) c00352.L$4;
                apiBase7 = (String) c00352.L$3;
                function11 = (Function1) c00352.L$2;
                function12 = (Function1) c00352.L$1;
                data8 = (String) c00352.L$0;
                ResultKt.throwOnFailure($result);
                isCasting8 = isCasting12;
                obj2 = coroutine_suspended;
                z = false;
                obj5 = $result;
                z2 = true;
                NiceResponse this_$iv10 = (NiceResponse) obj5;
                ResponseParser parser10 = this_$iv10.getParser();
                Intrinsics.checkNotNull(parser10);
                objectRef2.element = parser10.parse(this_$iv10.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                response3 = response6;
                userToken = userToken3;
                data6 = data8;
                isCasting6 = isCasting8;
                data4 = apiBase7;
                apiBase4 = id7;
                video_link = ((NewTvPlayerResponse) response3.element).getVideo_link();
                if (video_link != null) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (z3) {
                    return Boxing.boxBoolean(z);
                }
                String name11 = getName();
                String name12 = getName();
                String video_link7 = ((NewTvPlayerResponse) response3.element).getVideo_link();
                ExtractorLinkType extractorLinkType6 = ExtractorLinkType.M3U8;
                C00363 c00368 = new C00363(response3, data4, null);
                c00352.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                c00352.L$1 = SpillingKt.nullOutSpilledVariable(function12);
                c00352.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                c00352.L$3 = SpillingKt.nullOutSpilledVariable(data4);
                c00352.L$4 = SpillingKt.nullOutSpilledVariable(apiBase4);
                c00352.L$5 = SpillingKt.nullOutSpilledVariable(userToken);
                c00352.L$6 = SpillingKt.nullOutSpilledVariable(response3);
                c00352.L$7 = function11;
                c00352.Z$0 = isCasting6;
                c00352.label = 6;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name11, name12, video_link7, extractorLinkType6, c00368, c00352);
                if (objNewExtractorLink == obj2) {
                    return obj2;
                }
                function16 = function11;
                function16.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(z2);
            case 6:
                boolean z4 = c00352.Z$0;
                function16 = (Function1) c00352.L$7;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                z2 = true;
                function16.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(z2);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadLinks$lambda$0$0(Context $_ctx) {
        Toast.makeText($_ctx, "⚠️(Opening ads) Subscription expired. If you have renewed your subscription, please re-verify it in Subscription Manager.", 1).show();
    }

    /* JADX INFO: renamed from: com.horis.cncverse.PrimeVideoMirrorProvider$loadLinks$3 */
    /* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.PrimeVideoMirrorProvider$loadLinks$3", f = "PrimeVideoMirrorProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00363 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $apiBase;
        final /* synthetic */ Ref.ObjectRef<NewTvPlayerResponse> $response;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00363(Ref.ObjectRef<NewTvPlayerResponse> objectRef, String str, Continuation<? super C00363> continuation) {
            super(2, continuation);
            this.$response = objectRef;
            this.$apiBase = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00363 = new C00363(this.$response, this.$apiBase, continuation);
            c00363.L$0 = obj;
            return c00363;
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
                    String referer = ((NewTvPlayerResponse) this.$response.element).getReferer();
                    if (referer == null) {
                        referer = this.$apiBase;
                    }
                    $this$newExtractorLink.setReferer(referer);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Nullable
    public Interceptor getVideoInterceptor(@NotNull ExtractorLink extractorLink) {
        return new Interceptor() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider.getVideoInterceptor.1
            public Response intercept(Interceptor.Chain chain) {
                Request request = chain.request();
                if (StringsKt.contains$default(request.url().toString(), ".m3u8", false, 2, (Object) null)) {
                    Request newRequest = request.newBuilder().header("Cookie", "hd=on").build();
                    return chain.proceed(newRequest);
                }
                return chain.proceed(request);
            }
        };
    }

    /* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/horis/cncverse/PrimeVideoMirrorProvider$Id;", "", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "CNC Verse_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Id {

        @NotNull
        private final String id;

        public static /* synthetic */ Id copy$default(Id id, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = id.id;
            }
            return id.copy(str);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final Id copy(@NotNull String id) {
            return new Id(id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Id) && Intrinsics.areEqual(this.id, ((Id) other).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        @NotNull
        public String toString() {
            return "Id(id=" + this.id + ')';
        }

        public Id(@NotNull String id) {
            this.id = id;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }
    }

    /* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/horis/cncverse/PrimeVideoMirrorProvider$LoadData;", "", "title", "", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CNC Verse_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class LoadData {

        @NotNull
        private final String id;

        @NotNull
        private final String title;

        public static /* synthetic */ LoadData copy$default(LoadData loadData, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loadData.title;
            }
            if ((i & 2) != 0) {
                str2 = loadData.id;
            }
            return loadData.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final LoadData copy(@NotNull String title, @NotNull String id) {
            return new LoadData(title, id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadData)) {
                return false;
            }
            LoadData loadData = (LoadData) other;
            return Intrinsics.areEqual(this.title, loadData.title) && Intrinsics.areEqual(this.id, loadData.id);
        }

        public int hashCode() {
            return (this.title.hashCode() * 31) + this.id.hashCode();
        }

        @NotNull
        public String toString() {
            return "LoadData(title=" + this.title + ", id=" + this.id + ')';
        }

        public LoadData(@NotNull String title, @NotNull String id) {
            this.title = title;
            this.id = id;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
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
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    PrimeVideoMirrorProvider.showSubscriptionPopupIfNeeded$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PrimeVideoMirrorProvider.showSubscriptionPopupIfNeeded$lambda$0$11($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249, $ctx, dialog, view);
                }
            });
            subscribeTv.setOnClickListener(new View.OnClickListener() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PrimeVideoMirrorProvider.showSubscriptionPopupIfNeeded$lambda$0$12(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                PrimeVideoMirrorProvider.showTelegramPopup$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            joinTv.setOnClickListener(new View.OnClickListener() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PrimeVideoMirrorProvider.showTelegramPopup$lambda$0$9(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                PrimeVideoMirrorProvider.openInExternalBrowser$lambda$0(ctx, url);
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
