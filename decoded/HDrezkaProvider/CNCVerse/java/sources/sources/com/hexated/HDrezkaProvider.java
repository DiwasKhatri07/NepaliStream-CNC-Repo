package com.hexated;

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
import android.view.View;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.Episode;
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
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.ui.settings.Globals;
import com.lagradost.cloudstream3.utils.AppUtils;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
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
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: HDrezkaProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/HDrezkaProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\t*\u0001M\u0018\u0000 O2\u00020\u0001:\u0006OPQRSTB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\f\u0010&\u001a\u00020'*\u00020(H\u0002J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u001c2\u0006\u0010*\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+J\u0010\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0002JB\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u000e2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020207H\u0082@¢\u0006\u0002\u00109J\u0010\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0005H\u0002J\u0010\u0010<\u001a\u00020\"2\u0006\u0010;\u001a\u00020\u0005H\u0002JN\u0010=\u001a\u0002022\u0006\u00103\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00052\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u000202072\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020207H\u0082@¢\u0006\u0002\u0010AJF\u0010B\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u000e2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u000202072\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020207H\u0096@¢\u0006\u0002\u0010FJ\b\u0010G\u001a\u000202H\u0002J\b\u0010H\u001a\u000202H\u0002J\u0010\u0010I\u001a\u0002022\u0006\u0010.\u001a\u00020\u0005H\u0002J\u0012\u0010K\u001a\u0004\u0018\u00010\u00052\u0006\u0010.\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010J\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0004\n\u0002\u0010N¨\u0006U"}, d2 = {"Lcom/hexated/HDrezkaProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "decryptStreamUrl", "data", "cleanCallback", "", "source", "quality", "isM3u8", "sourceCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLanguage", "str", "getQuality", "invokeSources", "subtitle", "subCallback", "Lcom/lagradost/cloudstream3/SubtitleFile;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "isCasting", "subtitleCallback", "callback", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showSubscriptionPopupIfNeeded", "showTelegramPopup", "openInExternalBrowser", "anubisCookie", "getAnubisCookie", "anubisKiller", "com/hexated/HDrezkaProvider$anubisKiller$1", "Lcom/hexated/HDrezkaProvider$anubisKiller$1;", "Companion", "LocalSources", "Sources", "Server", "Data", "Trailer", "HDrezkaProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHDrezkaProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HDrezkaProvider.kt\ncom/hexated/HDrezkaProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 7 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,854:1\n1586#2:855\n1661#2,3:856\n1586#2:859\n1661#2,3:860\n1586#2:863\n1661#2,3:864\n1642#2,10:873\n1915#2:883\n1916#2:885\n1652#2:886\n1586#2:887\n1661#2,3:888\n1586#2:891\n1661#2,3:892\n1586#2:895\n1661#2,3:896\n1586#2:899\n1661#2,3:900\n1586#2:903\n1661#2,3:904\n1915#2,2:907\n1586#2:909\n1661#2,2:910\n1586#2:912\n1661#2,3:913\n1663#2:916\n1586#2:917\n1661#2,3:918\n1586#2:944\n1661#2,2:945\n1663#2:970\n1586#2:971\n1661#2,2:972\n1266#2,4:983\n1663#2:992\n2829#2,5:993\n1915#2:998\n1915#2,2:999\n1916#2:1001\n2835#2:1002\n67#3,5:867\n67#3,5:987\n1#4:872\n1#4:884\n1#4:924\n1#4:950\n93#5,2:921\n63#5:923\n64#5,15:925\n95#5,2:942\n93#5,2:947\n63#5:949\n64#5,15:951\n95#5,2:968\n50#6:940\n43#6:941\n50#6:966\n43#6:967\n507#7,7:974\n466#7:981\n415#7:982\n*S KotlinDebug\n*F\n+ 1 HDrezkaProvider.kt\ncom/hexated/HDrezkaProvider\n*L\n93#1:855\n93#1:856,3\n131#1:859\n131#1:860,3\n146#1:863\n146#1:864,3\n164#1:873,10\n164#1:883\n164#1:885\n164#1:886\n171#1:887\n171#1:888,3\n185#1:891\n185#1:892,3\n195#1:895\n195#1:896,3\n209#1:899\n209#1:900,3\n242#1:903\n242#1:904,3\n295#1:907,2\n353#1:909\n353#1:910,2\n358#1:912\n358#1:913,3\n353#1:916\n371#1:917\n371#1:918,3\n410#1:944\n410#1:945,2\n410#1:970\n426#1:971\n426#1:972,2\n440#1:983,4\n426#1:992\n280#1:993,5\n282#1:998\n283#1:999,2\n282#1:1001\n280#1:1002\n157#1:867,5\n442#1:987,5\n164#1:884\n407#1:924\n414#1:950\n407#1:921,2\n407#1:923\n407#1:925,15\n407#1:942,2\n414#1:947,2\n414#1:949\n414#1:951,15\n414#1:968,2\n407#1:940\n407#1:941\n414#1:966\n414#1:967\n440#1:974,7\n440#1:981\n440#1:982\n*E\n"})
public final class HDrezkaProvider extends MainAPI {
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

    @Nullable
    private String anubisCookie;

    @NotNull
    private String mainUrl = "https://rezka.ag";

    @NotNull
    private String name = "HDrezka";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "ru";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Anime, TvType.AsianDrama});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to(getMainUrl() + "/films/?filter=watching", "фильмы"), TuplesKt.to(getMainUrl() + "/series/?filter=watching", "сериалы"), TuplesKt.to(getMainUrl() + "/cartoons/?filter=watching", "мультфильмы"), TuplesKt.to(getMainUrl() + "/animation/?filter=watching", "аниме")});

    @NotNull
    private final HDrezkaProvider$anubisKiller$1 anubisKiller = new Interceptor() { // from class: com.hexated.HDrezkaProvider$anubisKiller$1
        public Response intercept(Interceptor.Chain chain) throws InterruptedException {
            Request reqWithCookie;
            String cookie;
            Request request = chain.request();
            String url = request.url().toString();
            String str = this.this$0.anubisCookie;
            boolean z = true;
            if ((str == null || str.length() == 0) && (cookie = this.this$0.getAnubisCookie(url)) != null) {
                this.this$0.anubisCookie = cookie;
            }
            String str2 = this.this$0.anubisCookie;
            if (str2 != null && str2.length() != 0) {
                z = false;
            }
            if (!z) {
                Request.Builder builderNewBuilder = request.newBuilder();
                String str3 = this.this$0.anubisCookie;
                Intrinsics.checkNotNull(str3);
                reqWithCookie = builderNewBuilder.header("Cookie", str3).header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36").build();
            } else {
                reqWithCookie = request.newBuilder().header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36").build();
            }
            Response response = chain.proceed(reqWithCookie);
            String bodyString = response.peekBody(Long.MAX_VALUE).string();
            if (StringsKt.contains$default(bodyString, "id=\"anubis_challenge\"", false, 2, (Object) null) || response.code() == 503) {
                response.close();
                String newCookie = this.this$0.getAnubisCookie(url);
                if (newCookie != null) {
                    this.this$0.anubisCookie = newCookie;
                    Request.Builder builderNewBuilder2 = request.newBuilder();
                    String str4 = this.this$0.anubisCookie;
                    Intrinsics.checkNotNull(str4);
                    Request retryReq = builderNewBuilder2.header("Cookie", str4).header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36").build();
                    return chain.proceed(retryReq);
                }
                return chain.proceed(request);
            }
            return response;
        }
    };

    /* JADX INFO: renamed from: com.hexated.HDrezkaProvider$cleanCallback$1 */
    /* JADX INFO: compiled from: HDrezkaProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.hexated.HDrezkaProvider", f = "HDrezkaProvider.kt", i = {0, 0, 0, 0, 0}, l = {312}, m = "cleanCallback", n = {"source", "url", "quality", "sourceCallback", "isM3u8"}, nl = {311}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HDrezkaProvider.this.cleanCallback(null, null, null, false, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.hexated.HDrezkaProvider$getMainPage$1 */
    /* JADX INFO: compiled from: HDrezkaProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.hexated.HDrezkaProvider", f = "HDrezkaProvider.kt", i = {0, 0, 0}, l = {91}, m = "getMainPage", n = {"request", "url", "page"}, nl = {92}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HDrezkaProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.hexated.HDrezkaProvider$invokeSources$1 */
    /* JADX INFO: compiled from: HDrezkaProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.hexated.HDrezkaProvider", f = "HDrezkaProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {361, 376}, m = "invokeSources", n = {"source", "url", "subtitle", "subCallback", "sourceCallback", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "links", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "quality", "item$iv$iv", "it", "link", "type", "$i$f$map", "$i$f$mapTo", "$i$a$-map-HDrezkaProvider$invokeSources$2", "$i$f$map", "$i$f$mapTo", "$i$a$-map-HDrezkaProvider$invokeSources$2$1", "source", "url", "subtitle", "subCallback", "sourceCallback", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "sub", "link", "language", "$i$f$map", "$i$f$mapTo", "$i$a$-map-HDrezkaProvider$invokeSources$3"}, nl = {368, 375}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$19", "L$20", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "L$11", "L$12", "I$0", "I$1", "I$2"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$21;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HDrezkaProvider.this.invokeSources(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.hexated.HDrezkaProvider$load$1 */
    /* JADX INFO: compiled from: HDrezkaProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.hexated.HDrezkaProvider", f = "HDrezkaProvider.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {138, 152, 231, 257}, m = "load", n = {"url", "url", "document", "id", "title", "poster", "tags", "year", "tvType", "description", "url", "document", "id", "title", "poster", "tags", "year", "tvType", "description", "trailer", "ratingText", "score", "actors", "recommendations", "data", "server", "translators", "episodes", "url", "document", "id", "title", "poster", "tags", "year", "tvType", "description", "trailer", "ratingText", "score", "actors", "recommendations", "data", "server"}, nl = {140, 157, 242, 182}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
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

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HDrezkaProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.hexated.HDrezkaProvider$loadLinks$1 */
    /* JADX INFO: compiled from: HDrezkaProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.hexated.HDrezkaProvider", f = "HDrezkaProvider.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {409, 415, 427, 443}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "res", "isCasting", "$i$a$-let-HDrezkaProvider$loadLinks$3", "data", "subtitleCallback", "callback", "res", "document", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "script", "dataJson", "source", "isCasting", "$i$a$-let-HDrezkaProvider$loadLinks$3", "$i$f$map", "$i$f$mapTo", "$i$a$-map-HDrezkaProvider$loadLinks$3$1", "$i$a$-let-HDrezkaProvider$loadLinks$3$1$1", "data", "subtitleCallback", "callback", "res", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "server", "isCasting", "$i$a$-let-HDrezkaProvider$loadLinks$3", "$i$f$map", "$i$f$mapTo", "$i$a$-map-HDrezkaProvider$loadLinks$3$2", "data", "subtitleCallback", "callback", "res", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "server", "source", "isCasting", "$i$a$-let-HDrezkaProvider$loadLinks$3", "$i$f$map", "$i$f$mapTo", "$i$a$-map-HDrezkaProvider$loadLinks$3$2", "$i$a$-let-HDrezkaProvider$loadLinks$3$2$3"}, nl = {410, 422, 442, 450}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "L$12", "L$13", "Z$0", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "Z$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "Z$0", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
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

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HDrezkaProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.hexated.HDrezkaProvider$search$1 */
    /* JADX INFO: compiled from: HDrezkaProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.hexated.HDrezkaProvider", f = "HDrezkaProvider.kt", i = {0, 0}, l = {129}, m = "search", n = {"query", "link"}, nl = {131}, s = {"L$0", "L$1"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HDrezkaProvider.this.search(null, (Continuation) this);
        }
    }

    /* JADX INFO: compiled from: HDrezkaProvider.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/hexated/HDrezkaProvider$Companion;", "", "<init>", "()V", "isCsGuardActive", "", "csGuardWasEverActive", "isCsGuardBlocked", "showCsGuardToast", "", "ctx", "Landroid/content/Context;", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "OMG10", "", "lastBrowserOpenMs", "", "telegramPopupShown", "subscriptionPopupShown", "BROWSER_DEBOUNCE_MS", "HDrezkaProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nHDrezkaProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HDrezkaProvider.kt\ncom/hexated/HDrezkaProvider$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,854:1\n1#2:855\n*E\n"})
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
                HDrezkaProvider.csGuardWasEverActive = true;
            }
            return HDrezkaProvider.csGuardWasEverActive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCsGuardToast(final Context ctx) {
            if (ctx == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hexated.HDrezkaProvider$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    HDrezkaProvider.Companion.showCsGuardToast$lambda$0(ctx);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showCsGuardToast$lambda$0(Context $c) {
            Toast.makeText($c, "🚫 CSGuard detected — Restart CloudStream after removing CSGuard to use CNCRepo", 1).show();
        }

        @Nullable
        public final Context getContext() {
            return HDrezkaProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            HDrezkaProvider.context = context;
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
        C00021 c00021;
        Boolean bool;
        MainPageRequest request2;
        if (continuation instanceof C00021) {
            c00021 = (C00021) continuation;
            if ((c00021.label & Integer.MIN_VALUE) != 0) {
                c00021.label -= Integer.MIN_VALUE;
            } else {
                c00021 = new C00021(continuation);
            }
        } else {
            c00021 = new C00021(continuation);
        }
        Object $result = c00021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00021.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                }
                showTelegramPopup();
                showSubscriptionPopupIfNeeded();
                List url = StringsKt.split$default(request.getData(), new String[]{"?"}, false, 0, 6, (Object) null);
                Requests app = MainActivityKt.getApp();
                String str = ((String) CollectionsKt.first(url)) + "page/" + page + "/?" + ((String) CollectionsKt.last(url));
                HDrezkaProvider$anubisKiller$1 hDrezkaProvider$anubisKiller$1 = this.anubisKiller;
                c00021.L$0 = request;
                c00021.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00021.I$0 = page;
                c00021.label = 1;
                bool = null;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, hDrezkaProvider$anubisKiller$1, false, (ResponseParser) null, c00021, 3582, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                int i = c00021.I$0;
                request2 = (MainPageRequest) c00021.L$0;
                ResultKt.throwOnFailure($result);
                bool = null;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable $this$map$iv = ((NiceResponse) $result).getDocument().select("div.b-content__inline_items div.b-content__inline_item");
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Element it = (Element) item$iv$iv;
            destination$iv$iv.add(toSearchResult(it));
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse$default(request2.getName(), home, bool, 4, bool);
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String strText;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("div.b-content__inline_item-link > a");
        String title = String.valueOf((elementSelectFirst == null || (strText = elementSelectFirst.text()) == null) ? null : StringsKt.trim(strText).toString());
        Element elementSelectFirst2 = $this$toSearchResult.selectFirst("a");
        String href = String.valueOf(elementSelectFirst2 != null ? elementSelectFirst2.attr("href") : null);
        final String posterUrl = $this$toSearchResult.select("img").attr("src");
        TvType type = !$this$toSearchResult.select("span.info").isEmpty() ? TvType.TvSeries : TvType.Movie;
        if (type == TvType.Movie) {
            return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.hexated.HDrezkaProvider$$ExternalSyntheticLambda6
                public final Object invoke(Object obj) {
                    return HDrezkaProvider.toSearchResult$lambda$0(posterUrl, (MovieSearchResponse) obj);
                }
            }, 8, (Object) null);
        }
        final Integer episode = StringsKt.toIntOrNull(new Regex("[^0-9]").replace(StringsKt.substringAfter$default($this$toSearchResult.select("span.info").text(), ",", (String) null, 2, (Object) null), ""));
        return MainAPIKt.newAnimeSearchResponse$default(this, title, href, TvType.TvSeries, false, new Function1() { // from class: com.hexated.HDrezkaProvider$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                return HDrezkaProvider.toSearchResult$lambda$1(posterUrl, episode, (AnimeSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toSearchResult$lambda$0(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toSearchResult$lambda$1(String $posterUrl, Integer $episode, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($posterUrl);
        MainAPIKt.addDubStatus($this$newAnimeSearchResponse, true, true, $episode, $episode);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00081 c00081;
        if (continuation instanceof C00081) {
            c00081 = (C00081) continuation;
            if ((c00081.label & Integer.MIN_VALUE) != 0) {
                c00081.label -= Integer.MIN_VALUE;
            } else {
                c00081 = new C00081(continuation);
            }
        } else {
            c00081 = new C00081(continuation);
        }
        Object $result = c00081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00081.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return CollectionsKt.emptyList();
                }
                String link = getMainUrl() + "/search/?do=search&subaction=search&q=" + query;
                Requests app = MainActivityKt.getApp();
                HDrezkaProvider$anubisKiller$1 hDrezkaProvider$anubisKiller$1 = this.anubisKiller;
                c00081.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00081.L$1 = SpillingKt.nullOutSpilledVariable(link);
                c00081.label = 1;
                $result = Requests.get$default(app, link, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, hDrezkaProvider$anubisKiller$1, false, (ResponseParser) null, c00081, 3582, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$map$iv = document.select("div.b-content__inline_items div.b-content__inline_item");
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Element it = (Element) item$iv$iv;
            destination$iv$iv.add(toSearchResult(it));
        }
        return (List) destination$iv$iv;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0437 A[LOOP:1: B:98:0x0431->B:100:0x0437, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:103:0x0478  */
    /* JADX WARN: Code duplicated, block: B:104:0x047f  */
    /* JADX WARN: Code duplicated, block: B:107:0x04a5  */
    /* JADX WARN: Code duplicated, block: B:109:0x04b2  */
    /* JADX WARN: Code duplicated, block: B:112:0x04d6 A[LOOP:2: B:110:0x04d0->B:112:0x04d6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:114:0x0525  */
    /* JADX WARN: Code duplicated, block: B:117:0x054f  */
    /* JADX WARN: Code duplicated, block: B:119:0x057a  */
    /* JADX WARN: Code duplicated, block: B:125:0x05e1  */
    /* JADX WARN: Code duplicated, block: B:127:0x0613  */
    /* JADX WARN: Code duplicated, block: B:137:0x0641 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:142:0x073e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:143:0x073f  */
    /* JADX WARN: Code duplicated, block: B:145:0x0759  */
    /* JADX WARN: Code duplicated, block: B:148:0x0781 A[LOOP:5: B:146:0x0779->B:148:0x0781, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:151:0x0891 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:152:0x0892  */
    /* JADX WARN: Code duplicated, block: B:159:0x0400 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x059b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x07f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:28:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:31:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:34:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:35:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:39:0x0224 A[LOOP:6: B:37:0x021e->B:39:0x0224, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:46:0x025f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0262  */
    /* JADX WARN: Code duplicated, block: B:49:0x0265  */
    /* JADX WARN: Code duplicated, block: B:55:0x0281  */
    /* JADX WARN: Code duplicated, block: B:58:0x0316 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:59:0x0317  */
    /* JADX WARN: Code duplicated, block: B:67:0x034c  */
    /* JADX WARN: Code duplicated, block: B:68:0x0351  */
    /* JADX WARN: Code duplicated, block: B:71:0x036f  */
    /* JADX WARN: Code duplicated, block: B:72:0x0374  */
    /* JADX WARN: Code duplicated, block: B:75:0x0378  */
    /* JADX WARN: Code duplicated, block: B:78:0x0392  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:82:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:84:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:92:0x03f5 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:95:0x03fc  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00041 c00041;
        Object obj;
        Object obj2;
        String str;
        char c;
        String url2;
        Document document;
        String id;
        Element elementSelectFirst;
        Element elementSelectFirst2;
        String string;
        String strText;
        String title;
        Element elementSelectFirst3;
        String strAttr;
        String poster;
        Collection destination$iv$iv;
        List tags;
        Integer year;
        Collection collectionSelect;
        boolean z;
        TvType tvType;
        Element elementSelectFirst4;
        String string2;
        String description;
        TvType tvType2;
        Object obj3;
        Document document2;
        String url3;
        String id2;
        String poster2;
        TvType tvType3;
        List tags2;
        Integer year2;
        String description2;
        String title2;
        String strText2;
        String strText3;
        Object safe;
        Trailer trailer;
        String it;
        String trailer2;
        Element elementSelectFirst5;
        String ratingText;
        Score score;
        Iterable $this$mapNotNull$iv;
        int $i$f$mapNotNull;
        Collection destination$iv$iv2;
        String ratingText2;
        List actors;
        int $i$f$map;
        Collection destination$iv$iv3;
        List recommendations;
        HashMap data;
        ArrayList server;
        Element elementSelectFirst6;
        String strAttr2;
        String title3;
        String title4;
        String url4;
        String id3;
        TvType tvType4;
        Iterable $this$map$iv;
        int $i$f$map2;
        Collection destination$iv$iv4;
        Iterator it2;
        Iterable $this$map$iv2;
        String ratingText3;
        Integer year3;
        String description3;
        Score score2;
        List actors2;
        List recommendations2;
        ArrayList server2;
        Document document3;
        String poster3;
        List tags3;
        String trailer3;
        TvType tvType5;
        String title5;
        HashMap data2;
        String url5;
        Iterable server3;
        Iterable $this$map$iv3;
        int $i$f$map3;
        Collection destination$iv$iv5;
        Iterable $this$mapTo$iv$iv;
        int $i$f$mapTo;
        String poster4;
        MatchResult match;
        Iterable $this$map$iv4;
        int $i$f$map4;
        Collection destination$iv$iv6;
        Iterable $this$mapTo$iv$iv2;
        int $i$f$mapTo2;
        Iterator it3;
        Element elementSelectFirst7;
        String str2;
        String strText4;
        Iterable $this$map$iv5;
        Collection destination$iv$iv7;
        Iterable $this$mapTo$iv$iv3;
        int $i$f$mapTo3;
        Element elementSelectFirst8;
        Actor actor;
        String strText5;
        Double doubleOrNull;
        if (continuation instanceof C00041) {
            c00041 = (C00041) continuation;
            if ((c00041.label & Integer.MIN_VALUE) != 0) {
                c00041.label -= Integer.MIN_VALUE;
            } else {
                c00041 = new C00041(continuation);
            }
        } else {
            c00041 = new C00041(continuation);
        }
        C00041 c00042 = c00041;
        Object $result = c00042.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00042.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                HDrezkaProvider$anubisKiller$1 hDrezkaProvider$anubisKiller$1 = this.anubisKiller;
                c00042.L$0 = url;
                c00042.label = 1;
                obj = coroutine_suspended;
                obj2 = "id";
                str = "src";
                c = 0;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, hDrezkaProvider$anubisKiller$1, false, (ResponseParser) null, c00042, 3582, (Object) null);
                c00042 = c00042;
                if ($result == obj) {
                    return obj;
                }
                url2 = url;
                document = ((NiceResponse) $result).getDocument();
                id = (String) CollectionsKt.first(StringsKt.split$default((CharSequence) CollectionsKt.last(StringsKt.split$default(url2, new String[]{"/"}, false, 0, 6, (Object) null)), new String[]{"-"}, false, 0, 6, (Object) null));
                elementSelectFirst = document.selectFirst("div.b-post__title h1");
                if (elementSelectFirst != null || (strText3 = elementSelectFirst.text()) == null || (string = StringsKt.trim(strText3).toString()) == null) {
                    elementSelectFirst2 = document.selectFirst("div.b-post__origtitle");
                    if (elementSelectFirst2 != null || (strText = elementSelectFirst2.text()) == null) {
                        string = null;
                    } else {
                        string = StringsKt.trim(strText).toString();
                    }
                }
                title = String.valueOf(string);
                HDrezkaProvider hDrezkaProvider = this;
                elementSelectFirst3 = document.selectFirst("div.b-sidecover img");
                if (elementSelectFirst3 != null) {
                    strAttr = elementSelectFirst3.attr(str);
                } else {
                    strAttr = null;
                }
                poster = MainAPIKt.fixUrlNull(hDrezkaProvider, strAttr);
                Iterable $this$map$iv6 = document.select("table.b-post__info > tbody > tr:contains(Жанр) span[itemprop=genre]");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv6, 10));
                for (Object item$iv$iv : $this$map$iv6) {
                    Element it4 = (Element) item$iv$iv;
                    destination$iv$iv.add(it4.text());
                }
                tags = (List) destination$iv$iv;
                year = StringsKt.toIntOrNull(document.select("div.film-info > div:nth-child(2) a").text());
                collectionSelect = document.select("div#simple-episodes-tabs");
                if (collectionSelect != null || collectionSelect.isEmpty()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                elementSelectFirst4 = document.selectFirst("div.b-post__description_text");
                if (elementSelectFirst4 != null || (strText2 = elementSelectFirst4.text()) == null) {
                    string2 = null;
                } else {
                    string2 = StringsKt.trim(strText2).toString();
                }
                description = string2;
                Requests app2 = MainActivityKt.getApp();
                String str3 = getMainUrl() + "/engine/ajax/gettrailervideo.php";
                HDrezkaProvider$anubisKiller$1 hDrezkaProvider$anubisKiller$2 = this.anubisKiller;
                c00042.L$0 = url2;
                c00042.L$1 = document;
                c00042.L$2 = id;
                c00042.L$3 = title;
                c00042.L$4 = poster;
                c00042.L$5 = tags;
                c00042.L$6 = year;
                c00042.L$7 = tvType;
                c00042.L$8 = description;
                c00042.label = 2;
                tvType2 = tvType;
                C00041 c00043 = c00042;
                obj3 = obj2;
                $result = Requests.post$default(app2, str3, (Map) null, url2, (Map) null, (Map) null, MapsKt.mapOf(TuplesKt.to(obj2, id)), (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, hDrezkaProvider$anubisKiller$2, false, (ResponseParser) null, c00043, 57306, (Object) null);
                c00042 = c00043;
                if ($result == obj) {
                    return obj;
                }
                document2 = document;
                url3 = url2;
                id2 = id;
                poster2 = poster;
                tvType3 = tvType2;
                tags2 = tags;
                year2 = year;
                description2 = description;
                title2 = title;
                NiceResponse this_$iv = (NiceResponse) $result;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Trailer.class));
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                trailer = (Trailer) safe;
                if (trailer != null) {
                    it = trailer.getCode();
                } else {
                    it = null;
                }
                trailer2 = Jsoup.parse(String.valueOf(it)).select("iframe").attr(str);
                elementSelectFirst5 = document2.selectFirst("table.b-post__info > tbody > tr:nth-child(1) span.bold");
                if (elementSelectFirst5 != null) {
                    ratingText = elementSelectFirst5.text();
                } else {
                    ratingText = null;
                }
                if (ratingText != null || (doubleOrNull = StringsKt.toDoubleOrNull(ratingText)) == null) {
                    score = null;
                } else {
                    double it5 = doubleOrNull.doubleValue();
                    score = Score.Companion.from10(Boxing.boxDouble(it5));
                }
                $this$mapNotNull$iv = document2.select("table.b-post__info > tbody > tr:last-child span.item");
                $i$f$mapNotNull = 0;
                destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    String ratingText4 = ratingText;
                    Element it6 = (Element) element$iv$iv$iv;
                    Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                    elementSelectFirst8 = it6.selectFirst("span[itemprop=name]");
                    if (elementSelectFirst8 != null || (strText5 = elementSelectFirst8.text()) == null) {
                        actor = null;
                    } else {
                        $i$f$mapNotNull = $i$f$mapNotNull;
                        Element elementSelectFirst9 = it6.selectFirst("span[itemprop=actor]");
                        actor = new Actor(strText5, elementSelectFirst9 != null ? elementSelectFirst9.attr("data-photo") : null);
                    }
                    if (actor != null) {
                        destination$iv$iv2.add(actor);
                    }
                    ratingText = ratingText4;
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                    $i$f$mapNotNull = $i$f$mapNotNull;
                }
                ratingText2 = ratingText;
                actors = (List) destination$iv$iv2;
                Iterable $this$map$iv7 = document2.select("div.b-sidelist div.b-content__inline_item");
                $i$f$map = 0;
                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv7, 10));
                for (Object item$iv$iv2 : $this$map$iv7) {
                    Element it7 = (Element) item$iv$iv2;
                    destination$iv$iv3.add(toSearchResult(it7));
                    $i$f$map = $i$f$map;
                }
                recommendations = (List) destination$iv$iv3;
                data = new HashMap();
                server = new ArrayList();
                data.put(obj3, id2);
                HashMap map = data;
                elementSelectFirst6 = document2.selectFirst("input#ctrl_favs");
                if (elementSelectFirst6 != null) {
                    strAttr2 = elementSelectFirst6.attr("value");
                } else {
                    strAttr2 = null;
                }
                map.put("favs", String.valueOf(strAttr2));
                data.put("ref", url3);
                title3 = title2;
                title4 = "translator_id";
                url4 = url3;
                if (tvType3 == TvType.TvSeries) {
                    server3 = document2.select("ul#translators-list li");
                    if (((Collection) server3).isEmpty()) {
                        $this$map$iv3 = document2.select("script");
                        $i$f$map3 = 0;
                        destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                        $this$mapTo$iv$iv = $this$map$iv3;
                        $i$f$mapTo = 0;
                        for (Object item$iv$iv3 : $this$mapTo$iv$iv) {
                            Element script = (Element) item$iv$iv3;
                            Iterable $this$map$iv8 = $this$map$iv3;
                            int $i$f$map5 = $i$f$map3;
                            Iterable $this$mapTo$iv$iv4 = $this$mapTo$iv$iv;
                            int $i$f$mapTo4 = $i$f$mapTo;
                            String poster5 = poster2;
                            match = Regex.find$default(new Regex("initCDNSeriesEvents\\(\\d+, (\\d+)"), script.data(), 0, 2, (Object) null);
                            if (match != null) {
                                server.add(MapsKt.mapOf(new Pair[]{TuplesKt.to("translator_name", "HDrezka"), TuplesKt.to("translator_id", match.getGroupValues().get(1))}));
                            }
                            destination$iv$iv5.add(Unit.INSTANCE);
                            $i$f$mapTo = $i$f$mapTo4;
                            $this$map$iv3 = $this$map$iv8;
                            $i$f$map3 = $i$f$map5;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv4;
                            poster2 = poster5;
                        }
                        poster4 = poster2;
                    } else {
                        $this$map$iv5 = server3;
                        destination$iv$iv7 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                        $this$mapTo$iv$iv3 = $this$map$iv5;
                        $i$f$mapTo3 = 0;
                        for (Object item$iv$iv4 : $this$mapTo$iv$iv3) {
                            Iterable $this$map$iv9 = $this$map$iv5;
                            Element res = (Element) item$iv$iv4;
                            int $i$f$mapTo5 = $i$f$mapTo3;
                            Pair[] pairArr = new Pair[2];
                            pairArr[c] = TuplesKt.to("translator_name", res.text());
                            pairArr[1] = TuplesKt.to("translator_id", res.attr("data-translator_id"));
                            destination$iv$iv7.add(Boxing.boxBoolean(server.add(MapsKt.mapOf(pairArr))));
                            $this$map$iv5 = $this$map$iv9;
                            $this$mapTo$iv$iv3 = $this$mapTo$iv$iv3;
                            $i$f$mapTo3 = $i$f$mapTo5;
                        }
                        poster4 = poster2;
                    }
                    $this$map$iv4 = document2.select("#simple-episodes-tabs .b-simple_episode__item");
                    $i$f$map4 = 0;
                    destination$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                    $this$mapTo$iv$iv2 = $this$map$iv4;
                    $i$f$mapTo2 = 0;
                    it3 = $this$mapTo$iv$iv2.iterator();
                    while (it3.hasNext()) {
                        Object item$iv$iv5 = it3.next();
                        Element ep = (Element) item$iv$iv5;
                        Iterable $this$map$iv10 = $this$map$iv4;
                        final Integer season = StringsKt.toIntOrNull(ep.attr("data-season_id"));
                        int $i$f$map6 = $i$f$map4;
                        final Integer episode = StringsKt.toIntOrNull(ep.attr("data-episode_id"));
                        Iterable $this$mapTo$iv$iv5 = $this$mapTo$iv$iv2;
                        elementSelectFirst7 = ep.selectFirst(".b-simple_episode__title");
                        if (elementSelectFirst7 != null || (strText4 = elementSelectFirst7.text()) == null) {
                            $i$f$mapTo2 = $i$f$mapTo2;
                        } else {
                            String str4 = strText4;
                            if (StringsKt.isBlank(str4)) {
                                str4 = "Episode " + episode;
                            }
                            str2 = str4;
                            if (str2 != null) {
                            }
                            final String name = str2;
                            data.put("season", String.valueOf(season));
                            data.put("episode", String.valueOf(episode));
                            data.put("server", server);
                            data.put("action", "get_stream");
                            destination$iv$iv6.add(MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(data), new Function1() { // from class: com.hexated.HDrezkaProvider$$ExternalSyntheticLambda12
                                public final Object invoke(Object obj4) {
                                    return HDrezkaProvider.load$lambda$7$1(name, season, episode, (Episode) obj4);
                                }
                            }));
                            $this$map$iv4 = $this$map$iv10;
                            $i$f$map4 = $i$f$map6;
                            $this$mapTo$iv$iv2 = $this$mapTo$iv$iv5;
                            it3 = it3;
                            $i$f$mapTo2 = $i$f$mapTo2;
                        }
                        str2 = "Episode " + episode;
                        final String name2 = str2;
                        data.put("season", String.valueOf(season));
                        data.put("episode", String.valueOf(episode));
                        data.put("server", server);
                        data.put("action", "get_stream");
                        destination$iv$iv6.add(MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(data), new Function1() { // from class: com.hexated.HDrezkaProvider$$ExternalSyntheticLambda12
                            public final Object invoke(Object obj4) {
                                return HDrezkaProvider.load$lambda$7$1(name2, season, episode, (Episode) obj4);
                            }
                        }));
                        $this$map$iv4 = $this$map$iv10;
                        $i$f$map4 = $i$f$map6;
                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv5;
                        it3 = it3;
                        $i$f$mapTo2 = $i$f$mapTo2;
                    }
                    List episodes = (List) destination$iv$iv6;
                    TvType tvType6 = TvType.TvSeries;
                    String poster6 = poster4;
                    C00054 c00054 = new C00054(poster6, year2, description2, tags2, score, actors, recommendations, trailer2, null);
                    c00042.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c00042.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                    c00042.L$2 = SpillingKt.nullOutSpilledVariable(id2);
                    c00042.L$3 = SpillingKt.nullOutSpilledVariable(title3);
                    c00042.L$4 = SpillingKt.nullOutSpilledVariable(poster6);
                    c00042.L$5 = SpillingKt.nullOutSpilledVariable(tags2);
                    c00042.L$6 = SpillingKt.nullOutSpilledVariable(year2);
                    c00042.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                    c00042.L$8 = SpillingKt.nullOutSpilledVariable(description2);
                    c00042.L$9 = SpillingKt.nullOutSpilledVariable(trailer2);
                    c00042.L$10 = SpillingKt.nullOutSpilledVariable(ratingText2);
                    c00042.L$11 = SpillingKt.nullOutSpilledVariable(score);
                    c00042.L$12 = SpillingKt.nullOutSpilledVariable(actors);
                    c00042.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00042.L$14 = SpillingKt.nullOutSpilledVariable(data);
                    c00042.L$15 = SpillingKt.nullOutSpilledVariable(server);
                    c00042.L$16 = SpillingKt.nullOutSpilledVariable(server3);
                    c00042.L$17 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00042.label = 3;
                    $result = MainAPIKt.newTvSeriesLoadResponse(this, title3, url4, tvType6, episodes, c00054, c00042);
                    if ($result == obj) {
                        return obj;
                    }
                    return (LoadResponse) $result;
                }
                id3 = id2;
                tvType4 = tvType3;
                $this$map$iv = document2.select("ul#translators-list li");
                $i$f$map2 = 0;
                destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                it2 = $this$map$iv.iterator();
                while (true) {
                    $this$map$iv2 = $this$map$iv;
                    if (!it2.hasNext()) {
                        data.put("server", server);
                        data.put("action", "get_movie");
                        TvType tvType7 = TvType.Movie;
                        String json = AppUtils.INSTANCE.toJson(data);
                        C00066 c00066 = new C00066(poster2, year2, description2, tags2, score, actors, recommendations, trailer2, null);
                        c00042.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                        c00042.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                        c00042.L$2 = SpillingKt.nullOutSpilledVariable(id3);
                        c00042.L$3 = SpillingKt.nullOutSpilledVariable(title3);
                        c00042.L$4 = SpillingKt.nullOutSpilledVariable(poster2);
                        c00042.L$5 = SpillingKt.nullOutSpilledVariable(tags2);
                        c00042.L$6 = SpillingKt.nullOutSpilledVariable(year2);
                        c00042.L$7 = SpillingKt.nullOutSpilledVariable(tvType4);
                        c00042.L$8 = SpillingKt.nullOutSpilledVariable(description2);
                        c00042.L$9 = SpillingKt.nullOutSpilledVariable(trailer2);
                        c00042.L$10 = SpillingKt.nullOutSpilledVariable(ratingText2);
                        c00042.L$11 = SpillingKt.nullOutSpilledVariable(score);
                        c00042.L$12 = SpillingKt.nullOutSpilledVariable(actors);
                        c00042.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                        c00042.L$14 = SpillingKt.nullOutSpilledVariable(data);
                        c00042.L$15 = SpillingKt.nullOutSpilledVariable(server);
                        c00042.label = 4;
                        $result = MainAPIKt.newMovieLoadResponse(this, title3, url4, tvType7, json, c00066, c00042);
                        if ($result == obj) {
                            return obj;
                        }
                        ratingText3 = ratingText2;
                        year3 = year2;
                        description3 = description2;
                        score2 = score;
                        actors2 = actors;
                        recommendations2 = recommendations;
                        server2 = server;
                        document3 = document2;
                        poster3 = poster2;
                        tags3 = tags2;
                        trailer3 = trailer2;
                        tvType5 = tvType4;
                        title5 = title3;
                        data2 = data;
                        url5 = id3;
                        return (LoadResponse) $result;
                    }
                    Object item$iv$iv6 = it2.next();
                    Element res2 = (Element) item$iv$iv6;
                    destination$iv$iv4.add(Boxing.boxBoolean(server.add(MapsKt.mapOf(new Pair[]{TuplesKt.to("translator_name", res2.text()), TuplesKt.to(title4, res2.attr("data-translator_id")), TuplesKt.to("camrip", res2.attr("data-camrip")), TuplesKt.to("ads", res2.attr("data-ads")), TuplesKt.to("director", res2.attr("data-director"))}))));
                    $this$map$iv = $this$map$iv2;
                    $i$f$map2 = $i$f$map2;
                    title4 = title4;
                }
                break;
                break;
            case 1:
                String url6 = (String) c00042.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                obj2 = "id";
                str = "src";
                c = 0;
                url2 = url6;
                document = ((NiceResponse) $result).getDocument();
                id = (String) CollectionsKt.first(StringsKt.split$default((CharSequence) CollectionsKt.last(StringsKt.split$default(url2, new String[]{"/"}, false, 0, 6, (Object) null)), new String[]{"-"}, false, 0, 6, (Object) null));
                elementSelectFirst = document.selectFirst("div.b-post__title h1");
                if (elementSelectFirst != null) {
                    elementSelectFirst2 = document.selectFirst("div.b-post__origtitle");
                    if (elementSelectFirst2 != null) {
                        string = null;
                    } else {
                        string = null;
                    }
                } else {
                    elementSelectFirst2 = document.selectFirst("div.b-post__origtitle");
                    if (elementSelectFirst2 != null) {
                        string = null;
                    } else {
                        string = null;
                    }
                }
                title = String.valueOf(string);
                HDrezkaProvider hDrezkaProvider2 = this;
                elementSelectFirst3 = document.selectFirst("div.b-sidecover img");
                if (elementSelectFirst3 != null) {
                    strAttr = elementSelectFirst3.attr(str);
                } else {
                    strAttr = null;
                }
                poster = MainAPIKt.fixUrlNull(hDrezkaProvider2, strAttr);
                Iterable $this$map$iv11 = document.select("table.b-post__info > tbody > tr:contains(Жанр) span[itemprop=genre]");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv11, 10));
                while (r14.hasNext()) {
                    Element it8 = (Element) item$iv$iv;
                    destination$iv$iv.add(it8.text());
                }
                tags = (List) destination$iv$iv;
                year = StringsKt.toIntOrNull(document.select("div.film-info > div:nth-child(2) a").text());
                collectionSelect = document.select("div#simple-episodes-tabs");
                if (collectionSelect != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                elementSelectFirst4 = document.selectFirst("div.b-post__description_text");
                if (elementSelectFirst4 != null) {
                    string2 = null;
                } else {
                    string2 = null;
                }
                description = string2;
                Requests app3 = MainActivityKt.getApp();
                String str5 = getMainUrl() + "/engine/ajax/gettrailervideo.php";
                HDrezkaProvider$anubisKiller$1 hDrezkaProvider$anubisKiller$3 = this.anubisKiller;
                c00042.L$0 = url2;
                c00042.L$1 = document;
                c00042.L$2 = id;
                c00042.L$3 = title;
                c00042.L$4 = poster;
                c00042.L$5 = tags;
                c00042.L$6 = year;
                c00042.L$7 = tvType;
                c00042.L$8 = description;
                c00042.label = 2;
                tvType2 = tvType;
                C00041 c00044 = c00042;
                obj3 = obj2;
                $result = Requests.post$default(app3, str5, (Map) null, url2, (Map) null, (Map) null, MapsKt.mapOf(TuplesKt.to(obj2, id)), (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, hDrezkaProvider$anubisKiller$3, false, (ResponseParser) null, c00044, 57306, (Object) null);
                c00042 = c00044;
                if ($result == obj) {
                    return obj;
                }
                document2 = document;
                url3 = url2;
                id2 = id;
                poster2 = poster;
                tvType3 = tvType2;
                tags2 = tags;
                year2 = year;
                description2 = description;
                title2 = title;
                NiceResponse this_$iv2 = (NiceResponse) $result;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(Trailer.class));
                trailer = (Trailer) safe;
                if (trailer != null) {
                    it = trailer.getCode();
                } else {
                    it = null;
                }
                trailer2 = Jsoup.parse(String.valueOf(it)).select("iframe").attr(str);
                elementSelectFirst5 = document2.selectFirst("table.b-post__info > tbody > tr:nth-child(1) span.bold");
                if (elementSelectFirst5 != null) {
                    ratingText = elementSelectFirst5.text();
                } else {
                    ratingText = null;
                }
                if (ratingText != null) {
                    score = null;
                } else {
                    score = null;
                }
                $this$mapNotNull$iv = document2.select("table.b-post__info > tbody > tr:last-child span.item");
                $i$f$mapNotNull = 0;
                destination$iv$iv2 = new ArrayList();
                while (r20.hasNext()) {
                    String ratingText5 = ratingText;
                    Element it9 = (Element) element$iv$iv$iv;
                    Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                    elementSelectFirst8 = it9.selectFirst("span[itemprop=name]");
                    if (elementSelectFirst8 != null) {
                    }
                    actor = null;
                    if (actor != null) {
                        destination$iv$iv2.add(actor);
                    }
                    ratingText = ratingText5;
                    $this$mapNotNull$iv = $this$mapNotNull$iv3;
                    $i$f$mapNotNull = $i$f$mapNotNull;
                }
                ratingText2 = ratingText;
                actors = (List) destination$iv$iv2;
                Iterable $this$map$iv12 = document2.select("div.b-sidelist div.b-content__inline_item");
                $i$f$map = 0;
                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv12, 10));
                while (r13.hasNext()) {
                    Element it10 = (Element) item$iv$iv2;
                    destination$iv$iv3.add(toSearchResult(it10));
                    $i$f$map = $i$f$map;
                }
                recommendations = (List) destination$iv$iv3;
                data = new HashMap();
                server = new ArrayList();
                data.put(obj3, id2);
                HashMap map2 = data;
                elementSelectFirst6 = document2.selectFirst("input#ctrl_favs");
                if (elementSelectFirst6 != null) {
                    strAttr2 = elementSelectFirst6.attr("value");
                } else {
                    strAttr2 = null;
                }
                map2.put("favs", String.valueOf(strAttr2));
                data.put("ref", url3);
                title3 = title2;
                title4 = "translator_id";
                url4 = url3;
                if (tvType3 == TvType.TvSeries) {
                    server3 = document2.select("ul#translators-list li");
                    if (((Collection) server3).isEmpty()) {
                        $this$map$iv5 = server3;
                        destination$iv$iv7 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                        $this$mapTo$iv$iv3 = $this$map$iv5;
                        $i$f$mapTo3 = 0;
                        while (r28.hasNext()) {
                            Iterable $this$map$iv13 = $this$map$iv5;
                            Element res3 = (Element) item$iv$iv4;
                            int $i$f$mapTo6 = $i$f$mapTo3;
                            Pair[] pairArr2 = new Pair[2];
                            pairArr2[c] = TuplesKt.to("translator_name", res3.text());
                            pairArr2[1] = TuplesKt.to("translator_id", res3.attr("data-translator_id"));
                            destination$iv$iv7.add(Boxing.boxBoolean(server.add(MapsKt.mapOf(pairArr2))));
                            $this$map$iv5 = $this$map$iv13;
                            $this$mapTo$iv$iv3 = $this$mapTo$iv$iv3;
                            $i$f$mapTo3 = $i$f$mapTo6;
                        }
                        poster4 = poster2;
                    } else {
                        $this$map$iv3 = document2.select("script");
                        $i$f$map3 = 0;
                        destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                        $this$mapTo$iv$iv = $this$map$iv3;
                        $i$f$mapTo = 0;
                        while (r22.hasNext()) {
                            Element script2 = (Element) item$iv$iv3;
                            Iterable $this$map$iv14 = $this$map$iv3;
                            int $i$f$map7 = $i$f$map3;
                            Iterable $this$mapTo$iv$iv6 = $this$mapTo$iv$iv;
                            int $i$f$mapTo7 = $i$f$mapTo;
                            String poster7 = poster2;
                            match = Regex.find$default(new Regex("initCDNSeriesEvents\\(\\d+, (\\d+)"), script2.data(), 0, 2, (Object) null);
                            if (match != null) {
                                server.add(MapsKt.mapOf(new Pair[]{TuplesKt.to("translator_name", "HDrezka"), TuplesKt.to("translator_id", match.getGroupValues().get(1))}));
                            }
                            destination$iv$iv5.add(Unit.INSTANCE);
                            $i$f$mapTo = $i$f$mapTo7;
                            $this$map$iv3 = $this$map$iv14;
                            $i$f$map3 = $i$f$map7;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv6;
                            poster2 = poster7;
                        }
                        poster4 = poster2;
                    }
                    $this$map$iv4 = document2.select("#simple-episodes-tabs .b-simple_episode__item");
                    $i$f$map4 = 0;
                    destination$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                    $this$mapTo$iv$iv2 = $this$map$iv4;
                    $i$f$mapTo2 = 0;
                    it3 = $this$mapTo$iv$iv2.iterator();
                    while (it3.hasNext()) {
                        Object item$iv$iv7 = it3.next();
                        Element ep2 = (Element) item$iv$iv7;
                        Iterable $this$map$iv15 = $this$map$iv4;
                        final Integer season2 = StringsKt.toIntOrNull(ep2.attr("data-season_id"));
                        int $i$f$map8 = $i$f$map4;
                        final Integer episode2 = StringsKt.toIntOrNull(ep2.attr("data-episode_id"));
                        Iterable $this$mapTo$iv$iv7 = $this$mapTo$iv$iv2;
                        elementSelectFirst7 = ep2.selectFirst(".b-simple_episode__title");
                        if (elementSelectFirst7 != null) {
                            $i$f$mapTo2 = $i$f$mapTo2;
                        } else {
                            $i$f$mapTo2 = $i$f$mapTo2;
                        }
                        str2 = "Episode " + episode2;
                        final String name3 = str2;
                        data.put("season", String.valueOf(season2));
                        data.put("episode", String.valueOf(episode2));
                        data.put("server", server);
                        data.put("action", "get_stream");
                        destination$iv$iv6.add(MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(data), new Function1() { // from class: com.hexated.HDrezkaProvider$$ExternalSyntheticLambda12
                            public final Object invoke(Object obj4) {
                                return HDrezkaProvider.load$lambda$7$1(name3, season2, episode2, (Episode) obj4);
                            }
                        }));
                        $this$map$iv4 = $this$map$iv15;
                        $i$f$map4 = $i$f$map8;
                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv7;
                        it3 = it3;
                        $i$f$mapTo2 = $i$f$mapTo2;
                    }
                    List episodes2 = (List) destination$iv$iv6;
                    TvType tvType8 = TvType.TvSeries;
                    String poster8 = poster4;
                    C00054 c00055 = new C00054(poster8, year2, description2, tags2, score, actors, recommendations, trailer2, null);
                    c00042.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c00042.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                    c00042.L$2 = SpillingKt.nullOutSpilledVariable(id2);
                    c00042.L$3 = SpillingKt.nullOutSpilledVariable(title3);
                    c00042.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                    c00042.L$5 = SpillingKt.nullOutSpilledVariable(tags2);
                    c00042.L$6 = SpillingKt.nullOutSpilledVariable(year2);
                    c00042.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                    c00042.L$8 = SpillingKt.nullOutSpilledVariable(description2);
                    c00042.L$9 = SpillingKt.nullOutSpilledVariable(trailer2);
                    c00042.L$10 = SpillingKt.nullOutSpilledVariable(ratingText2);
                    c00042.L$11 = SpillingKt.nullOutSpilledVariable(score);
                    c00042.L$12 = SpillingKt.nullOutSpilledVariable(actors);
                    c00042.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00042.L$14 = SpillingKt.nullOutSpilledVariable(data);
                    c00042.L$15 = SpillingKt.nullOutSpilledVariable(server);
                    c00042.L$16 = SpillingKt.nullOutSpilledVariable(server3);
                    c00042.L$17 = SpillingKt.nullOutSpilledVariable(episodes2);
                    c00042.label = 3;
                    $result = MainAPIKt.newTvSeriesLoadResponse(this, title3, url4, tvType8, episodes2, c00055, c00042);
                    if ($result == obj) {
                        return obj;
                    }
                    return (LoadResponse) $result;
                }
                id3 = id2;
                tvType4 = tvType3;
                $this$map$iv = document2.select("ul#translators-list li");
                $i$f$map2 = 0;
                destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                it2 = $this$map$iv.iterator();
                while (true) {
                    $this$map$iv2 = $this$map$iv;
                    if (!it2.hasNext()) {
                        data.put("server", server);
                        data.put("action", "get_movie");
                        TvType tvType9 = TvType.Movie;
                        String json2 = AppUtils.INSTANCE.toJson(data);
                        C00066 c00067 = new C00066(poster2, year2, description2, tags2, score, actors, recommendations, trailer2, null);
                        c00042.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                        c00042.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                        c00042.L$2 = SpillingKt.nullOutSpilledVariable(id3);
                        c00042.L$3 = SpillingKt.nullOutSpilledVariable(title3);
                        c00042.L$4 = SpillingKt.nullOutSpilledVariable(poster2);
                        c00042.L$5 = SpillingKt.nullOutSpilledVariable(tags2);
                        c00042.L$6 = SpillingKt.nullOutSpilledVariable(year2);
                        c00042.L$7 = SpillingKt.nullOutSpilledVariable(tvType4);
                        c00042.L$8 = SpillingKt.nullOutSpilledVariable(description2);
                        c00042.L$9 = SpillingKt.nullOutSpilledVariable(trailer2);
                        c00042.L$10 = SpillingKt.nullOutSpilledVariable(ratingText2);
                        c00042.L$11 = SpillingKt.nullOutSpilledVariable(score);
                        c00042.L$12 = SpillingKt.nullOutSpilledVariable(actors);
                        c00042.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                        c00042.L$14 = SpillingKt.nullOutSpilledVariable(data);
                        c00042.L$15 = SpillingKt.nullOutSpilledVariable(server);
                        c00042.label = 4;
                        $result = MainAPIKt.newMovieLoadResponse(this, title3, url4, tvType9, json2, c00067, c00042);
                        if ($result == obj) {
                            return obj;
                        }
                        ratingText3 = ratingText2;
                        year3 = year2;
                        description3 = description2;
                        score2 = score;
                        actors2 = actors;
                        recommendations2 = recommendations;
                        server2 = server;
                        document3 = document2;
                        poster3 = poster2;
                        tags3 = tags2;
                        trailer3 = trailer2;
                        tvType5 = tvType4;
                        title5 = title3;
                        data2 = data;
                        url5 = id3;
                        return (LoadResponse) $result;
                    }
                    Object item$iv$iv8 = it2.next();
                    Element res4 = (Element) item$iv$iv8;
                    destination$iv$iv4.add(Boxing.boxBoolean(server.add(MapsKt.mapOf(new Pair[]{TuplesKt.to("translator_name", res4.text()), TuplesKt.to(title4, res4.attr("data-translator_id")), TuplesKt.to("camrip", res4.attr("data-camrip")), TuplesKt.to("ads", res4.attr("data-ads")), TuplesKt.to("director", res4.attr("data-director"))}))));
                    $this$map$iv = $this$map$iv2;
                    $i$f$map2 = $i$f$map2;
                    title4 = title4;
                }
                break;
            case 2:
                String description4 = (String) c00042.L$8;
                TvType tvType10 = (TvType) c00042.L$7;
                Integer year4 = (Integer) c00042.L$6;
                List tags4 = (List) c00042.L$5;
                String poster9 = (String) c00042.L$4;
                String title6 = (String) c00042.L$3;
                id2 = (String) c00042.L$2;
                document2 = (Document) c00042.L$1;
                String url7 = (String) c00042.L$0;
                ResultKt.throwOnFailure($result);
                description2 = description4;
                obj = coroutine_suspended;
                obj3 = "id";
                str = "src";
                title2 = title6;
                url3 = url7;
                tvType3 = tvType10;
                tags2 = tags4;
                c = 0;
                year2 = year4;
                poster2 = poster9;
                NiceResponse this_$iv3 = (NiceResponse) $result;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                safe = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(Trailer.class));
                trailer = (Trailer) safe;
                if (trailer != null) {
                    it = trailer.getCode();
                } else {
                    it = null;
                }
                trailer2 = Jsoup.parse(String.valueOf(it)).select("iframe").attr(str);
                elementSelectFirst5 = document2.selectFirst("table.b-post__info > tbody > tr:nth-child(1) span.bold");
                if (elementSelectFirst5 != null) {
                    ratingText = elementSelectFirst5.text();
                } else {
                    ratingText = null;
                }
                if (ratingText != null) {
                    score = null;
                } else {
                    score = null;
                }
                $this$mapNotNull$iv = document2.select("table.b-post__info > tbody > tr:last-child span.item");
                $i$f$mapNotNull = 0;
                destination$iv$iv2 = new ArrayList();
                while (r20.hasNext()) {
                    String ratingText6 = ratingText;
                    Element it11 = (Element) element$iv$iv$iv;
                    Iterable $this$mapNotNull$iv4 = $this$mapNotNull$iv;
                    elementSelectFirst8 = it11.selectFirst("span[itemprop=name]");
                    if (elementSelectFirst8 != null) {
                    }
                    actor = null;
                    if (actor != null) {
                        destination$iv$iv2.add(actor);
                    }
                    ratingText = ratingText6;
                    $this$mapNotNull$iv = $this$mapNotNull$iv4;
                    $i$f$mapNotNull = $i$f$mapNotNull;
                }
                ratingText2 = ratingText;
                actors = (List) destination$iv$iv2;
                Iterable $this$map$iv16 = document2.select("div.b-sidelist div.b-content__inline_item");
                $i$f$map = 0;
                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv16, 10));
                while (r13.hasNext()) {
                    Element it12 = (Element) item$iv$iv2;
                    destination$iv$iv3.add(toSearchResult(it12));
                    $i$f$map = $i$f$map;
                }
                recommendations = (List) destination$iv$iv3;
                data = new HashMap();
                server = new ArrayList();
                data.put(obj3, id2);
                HashMap map3 = data;
                elementSelectFirst6 = document2.selectFirst("input#ctrl_favs");
                if (elementSelectFirst6 != null) {
                    strAttr2 = elementSelectFirst6.attr("value");
                } else {
                    strAttr2 = null;
                }
                map3.put("favs", String.valueOf(strAttr2));
                data.put("ref", url3);
                title3 = title2;
                title4 = "translator_id";
                url4 = url3;
                if (tvType3 == TvType.TvSeries) {
                    server3 = document2.select("ul#translators-list li");
                    if (((Collection) server3).isEmpty()) {
                        $this$map$iv5 = server3;
                        destination$iv$iv7 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                        $this$mapTo$iv$iv3 = $this$map$iv5;
                        $i$f$mapTo3 = 0;
                        while (r28.hasNext()) {
                            Iterable $this$map$iv17 = $this$map$iv5;
                            Element res5 = (Element) item$iv$iv4;
                            int $i$f$mapTo8 = $i$f$mapTo3;
                            Pair[] pairArr3 = new Pair[2];
                            pairArr3[c] = TuplesKt.to("translator_name", res5.text());
                            pairArr3[1] = TuplesKt.to("translator_id", res5.attr("data-translator_id"));
                            destination$iv$iv7.add(Boxing.boxBoolean(server.add(MapsKt.mapOf(pairArr3))));
                            $this$map$iv5 = $this$map$iv17;
                            $this$mapTo$iv$iv3 = $this$mapTo$iv$iv3;
                            $i$f$mapTo3 = $i$f$mapTo8;
                        }
                        poster4 = poster2;
                    } else {
                        $this$map$iv3 = document2.select("script");
                        $i$f$map3 = 0;
                        destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                        $this$mapTo$iv$iv = $this$map$iv3;
                        $i$f$mapTo = 0;
                        while (r22.hasNext()) {
                            Element script3 = (Element) item$iv$iv3;
                            Iterable $this$map$iv18 = $this$map$iv3;
                            int $i$f$map9 = $i$f$map3;
                            Iterable $this$mapTo$iv$iv8 = $this$mapTo$iv$iv;
                            int $i$f$mapTo9 = $i$f$mapTo;
                            String poster10 = poster2;
                            match = Regex.find$default(new Regex("initCDNSeriesEvents\\(\\d+, (\\d+)"), script3.data(), 0, 2, (Object) null);
                            if (match != null) {
                                server.add(MapsKt.mapOf(new Pair[]{TuplesKt.to("translator_name", "HDrezka"), TuplesKt.to("translator_id", match.getGroupValues().get(1))}));
                            }
                            destination$iv$iv5.add(Unit.INSTANCE);
                            $i$f$mapTo = $i$f$mapTo9;
                            $this$map$iv3 = $this$map$iv18;
                            $i$f$map3 = $i$f$map9;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv8;
                            poster2 = poster10;
                        }
                        poster4 = poster2;
                    }
                    $this$map$iv4 = document2.select("#simple-episodes-tabs .b-simple_episode__item");
                    $i$f$map4 = 0;
                    destination$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                    $this$mapTo$iv$iv2 = $this$map$iv4;
                    $i$f$mapTo2 = 0;
                    it3 = $this$mapTo$iv$iv2.iterator();
                    while (it3.hasNext()) {
                        Object item$iv$iv9 = it3.next();
                        Element ep3 = (Element) item$iv$iv9;
                        Iterable $this$map$iv19 = $this$map$iv4;
                        final Integer season3 = StringsKt.toIntOrNull(ep3.attr("data-season_id"));
                        int $i$f$map10 = $i$f$map4;
                        final Integer episode3 = StringsKt.toIntOrNull(ep3.attr("data-episode_id"));
                        Iterable $this$mapTo$iv$iv9 = $this$mapTo$iv$iv2;
                        elementSelectFirst7 = ep3.selectFirst(".b-simple_episode__title");
                        if (elementSelectFirst7 != null) {
                            $i$f$mapTo2 = $i$f$mapTo2;
                        } else {
                            $i$f$mapTo2 = $i$f$mapTo2;
                        }
                        str2 = "Episode " + episode3;
                        final String name4 = str2;
                        data.put("season", String.valueOf(season3));
                        data.put("episode", String.valueOf(episode3));
                        data.put("server", server);
                        data.put("action", "get_stream");
                        destination$iv$iv6.add(MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(data), new Function1() { // from class: com.hexated.HDrezkaProvider$$ExternalSyntheticLambda12
                            public final Object invoke(Object obj4) {
                                return HDrezkaProvider.load$lambda$7$1(name4, season3, episode3, (Episode) obj4);
                            }
                        }));
                        $this$map$iv4 = $this$map$iv19;
                        $i$f$map4 = $i$f$map10;
                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv9;
                        it3 = it3;
                        $i$f$mapTo2 = $i$f$mapTo2;
                    }
                    List episodes3 = (List) destination$iv$iv6;
                    TvType tvType11 = TvType.TvSeries;
                    String poster11 = poster4;
                    C00054 c00056 = new C00054(poster11, year2, description2, tags2, score, actors, recommendations, trailer2, null);
                    c00042.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c00042.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                    c00042.L$2 = SpillingKt.nullOutSpilledVariable(id2);
                    c00042.L$3 = SpillingKt.nullOutSpilledVariable(title3);
                    c00042.L$4 = SpillingKt.nullOutSpilledVariable(poster11);
                    c00042.L$5 = SpillingKt.nullOutSpilledVariable(tags2);
                    c00042.L$6 = SpillingKt.nullOutSpilledVariable(year2);
                    c00042.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                    c00042.L$8 = SpillingKt.nullOutSpilledVariable(description2);
                    c00042.L$9 = SpillingKt.nullOutSpilledVariable(trailer2);
                    c00042.L$10 = SpillingKt.nullOutSpilledVariable(ratingText2);
                    c00042.L$11 = SpillingKt.nullOutSpilledVariable(score);
                    c00042.L$12 = SpillingKt.nullOutSpilledVariable(actors);
                    c00042.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00042.L$14 = SpillingKt.nullOutSpilledVariable(data);
                    c00042.L$15 = SpillingKt.nullOutSpilledVariable(server);
                    c00042.L$16 = SpillingKt.nullOutSpilledVariable(server3);
                    c00042.L$17 = SpillingKt.nullOutSpilledVariable(episodes3);
                    c00042.label = 3;
                    $result = MainAPIKt.newTvSeriesLoadResponse(this, title3, url4, tvType11, episodes3, c00056, c00042);
                    if ($result == obj) {
                        return obj;
                    }
                    return (LoadResponse) $result;
                }
                id3 = id2;
                tvType4 = tvType3;
                $this$map$iv = document2.select("ul#translators-list li");
                $i$f$map2 = 0;
                destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                it2 = $this$map$iv.iterator();
                while (true) {
                    $this$map$iv2 = $this$map$iv;
                    if (!it2.hasNext()) {
                        data.put("server", server);
                        data.put("action", "get_movie");
                        TvType tvType12 = TvType.Movie;
                        String json3 = AppUtils.INSTANCE.toJson(data);
                        C00066 c00068 = new C00066(poster2, year2, description2, tags2, score, actors, recommendations, trailer2, null);
                        c00042.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                        c00042.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                        c00042.L$2 = SpillingKt.nullOutSpilledVariable(id3);
                        c00042.L$3 = SpillingKt.nullOutSpilledVariable(title3);
                        c00042.L$4 = SpillingKt.nullOutSpilledVariable(poster2);
                        c00042.L$5 = SpillingKt.nullOutSpilledVariable(tags2);
                        c00042.L$6 = SpillingKt.nullOutSpilledVariable(year2);
                        c00042.L$7 = SpillingKt.nullOutSpilledVariable(tvType4);
                        c00042.L$8 = SpillingKt.nullOutSpilledVariable(description2);
                        c00042.L$9 = SpillingKt.nullOutSpilledVariable(trailer2);
                        c00042.L$10 = SpillingKt.nullOutSpilledVariable(ratingText2);
                        c00042.L$11 = SpillingKt.nullOutSpilledVariable(score);
                        c00042.L$12 = SpillingKt.nullOutSpilledVariable(actors);
                        c00042.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                        c00042.L$14 = SpillingKt.nullOutSpilledVariable(data);
                        c00042.L$15 = SpillingKt.nullOutSpilledVariable(server);
                        c00042.label = 4;
                        $result = MainAPIKt.newMovieLoadResponse(this, title3, url4, tvType12, json3, c00068, c00042);
                        if ($result == obj) {
                            return obj;
                        }
                        ratingText3 = ratingText2;
                        year3 = year2;
                        description3 = description2;
                        score2 = score;
                        actors2 = actors;
                        recommendations2 = recommendations;
                        server2 = server;
                        document3 = document2;
                        poster3 = poster2;
                        tags3 = tags2;
                        trailer3 = trailer2;
                        tvType5 = tvType4;
                        title5 = title3;
                        data2 = data;
                        url5 = id3;
                        return (LoadResponse) $result;
                    }
                    Object item$iv$iv10 = it2.next();
                    Element res6 = (Element) item$iv$iv10;
                    destination$iv$iv4.add(Boxing.boxBoolean(server.add(MapsKt.mapOf(new Pair[]{TuplesKt.to("translator_name", res6.text()), TuplesKt.to(title4, res6.attr("data-translator_id")), TuplesKt.to("camrip", res6.attr("data-camrip")), TuplesKt.to("ads", res6.attr("data-ads")), TuplesKt.to("director", res6.attr("data-director"))}))));
                    $this$map$iv = $this$map$iv2;
                    $i$f$map2 = $i$f$map2;
                    title4 = title4;
                }
                break;
            case 3:
                ResultKt.throwOnFailure($result);
                return (LoadResponse) $result;
            case 4:
                ArrayList server4 = (ArrayList) c00042.L$15;
                data2 = (HashMap) c00042.L$14;
                recommendations2 = (List) c00042.L$13;
                actors2 = (List) c00042.L$12;
                score2 = (Score) c00042.L$11;
                ratingText3 = (String) c00042.L$10;
                trailer3 = (String) c00042.L$9;
                description3 = (String) c00042.L$8;
                tvType5 = (TvType) c00042.L$7;
                year3 = (Integer) c00042.L$6;
                tags3 = (List) c00042.L$5;
                poster3 = (String) c00042.L$4;
                server2 = server4;
                title5 = (String) c00042.L$3;
                String id4 = (String) c00042.L$2;
                document3 = (Document) c00042.L$1;
                ResultKt.throwOnFailure($result);
                url5 = id4;
                return (LoadResponse) $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$7$1(String $name, Integer $season, Integer $episode, Episode $this$newEpisode) {
        $this$newEpisode.setName($name);
        $this$newEpisode.setSeason($season);
        $this$newEpisode.setEpisode($episode);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.hexated.HDrezkaProvider$load$4 */
    /* JADX INFO: compiled from: HDrezkaProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.hexated.HDrezkaProvider$load$4", f = "HDrezkaProvider.kt", i = {0}, l = {239}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {240}, s = {"L$0"}, v = 2)
    static final class C00054 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Actor> $actors;
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<SearchResponse> $recommendations;
        final /* synthetic */ Score $score;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00054(String str, Integer num, String str2, List<String> list, Score score, List<Actor> list2, List<? extends SearchResponse> list3, String str3, Continuation<? super C00054> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$year = num;
            this.$description = str2;
            this.$tags = list;
            this.$score = score;
            this.$actors = list2;
            this.$recommendations = list3;
            this.$trailer = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00054 = new C00054(this.$poster, this.$year, this.$description, this.$tags, this.$score, this.$actors, this.$recommendations, this.$trailer, continuation);
            c00054.L$0 = obj;
            return c00054;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (TvSeriesLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setScore(this.$score);
                    LoadResponse.Companion.addActorsOnly(loadResponse, this.$actors);
                    loadResponse.setRecommendations(this.$recommendations);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(loadResponse);
                    this.label = 1;
                    if (LoadResponse.Companion.addTrailer$default(LoadResponse.Companion, loadResponse, this.$trailer, (String) null, false, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.hexated.HDrezkaProvider$load$6 */
    /* JADX INFO: compiled from: HDrezkaProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.hexated.HDrezkaProvider$load$6", f = "HDrezkaProvider.kt", i = {0}, l = {265}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {266}, s = {"L$0"}, v = 2)
    static final class C00066 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Actor> $actors;
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<SearchResponse> $recommendations;
        final /* synthetic */ Score $score;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00066(String str, Integer num, String str2, List<String> list, Score score, List<Actor> list2, List<? extends SearchResponse> list3, String str3, Continuation<? super C00066> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$year = num;
            this.$description = str2;
            this.$tags = list;
            this.$score = score;
            this.$actors = list2;
            this.$recommendations = list3;
            this.$trailer = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00066 = new C00066(this.$poster, this.$year, this.$description, this.$tags, this.$score, this.$actors, this.$recommendations, this.$trailer, continuation);
            c00066.L$0 = obj;
            return c00066;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setScore(this.$score);
                    LoadResponse.Companion.addActorsOnly(loadResponse, this.$actors);
                    loadResponse.setRecommendations(this.$recommendations);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(loadResponse);
                    this.label = 1;
                    if (LoadResponse.Companion.addTrailer$default(LoadResponse.Companion, loadResponse, this.$trailer, (String) null, false, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
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

    private final String decryptStreamUrl(String data) {
        if (StringsKt.startsWith$default(data, "[", false, 2, (Object) null)) {
            return data;
        }
        List trashList = CollectionsKt.listOf(new String[]{"@", "#", "!", "^", "$"});
        Iterable trashSet = CollectionsKt.plus(decryptStreamUrl$getTrash(trashList, 2), decryptStreamUrl$getTrash(trashList, 3));
        String strJoinToString$default = CollectionsKt.joinToString$default(StringsKt.split$default(StringsKt.replace$default(data, "#h", "", false, 4, (Object) null), new String[]{"//_//"}, false, 0, 6, (Object) null), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        Iterable $this$forEach$iv = trashSet;
        String strReplace$default = strJoinToString$default;
        for (Object element$iv : $this$forEach$iv) {
            String it = (String) element$iv;
            byte[] bytes = it.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            String temp = MainAPIKt.base64Encode(bytes);
            strReplace$default = StringsKt.replace$default(strReplace$default, temp, "", false, 4, (Object) null);
        }
        return MainAPIKt.base64Decode(strReplace$default);
    }

    private static final List<String> decryptStreamUrl$getTrash(List<String> list, int item) {
        ArrayList trash = new ArrayList();
        int i = 1;
        if (1 <= item) {
            while (true) {
                trash.add(list);
                if (i == item) {
                    break;
                }
                i++;
            }
        }
        ArrayList $this$reduce$iv = trash;
        Iterator iterator$iv = $this$reduce$iv.iterator();
        if (!iterator$iv.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object accumulator$iv = iterator$iv.next();
        while (iterator$iv.hasNext()) {
            Iterable list2 = (List) iterator$iv.next();
            Iterable acc = (List) accumulator$iv;
            ArrayList temp = new ArrayList();
            Iterable $this$forEach$iv = acc;
            for (Object element$iv : $this$forEach$iv) {
                String ac = (String) element$iv;
                Iterable $this$forEach$iv2 = list2;
                for (Object element$iv2 : $this$forEach$iv2) {
                    String li = (String) element$iv2;
                    temp.add(ac + li);
                    trash = trash;
                }
            }
            accumulator$iv = temp;
        }
        return (List) accumulator$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object cleanCallback(String source, String url, String quality, boolean isM3u8, Function1<? super ExtractorLink, Unit> function1, Continuation<? super Unit> continuation) {
        C00001 c00001;
        Object objNewExtractorLink;
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
        C00001 c00002 = c00001;
        Object $result = c00002.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00002.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ExtractorLinkType extractorLinkType = isM3u8 ? ExtractorLinkType.M3U8 : ExtractorLinkType.VIDEO;
                C00012 c00012 = new C00012(quality, null);
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(source);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(quality);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c00002.L$4 = function1;
                c00002.Z$0 = isM3u8;
                c00002.label = 1;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(source, source, url, extractorLinkType, c00012, c00002);
                if (objNewExtractorLink == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                boolean isM3u9 = c00002.Z$0;
                Function1<? super ExtractorLink, Unit> function2 = (Function1) c00002.L$4;
                ResultKt.throwOnFailure($result);
                function1 = function2;
                objNewExtractorLink = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        function1.invoke(objNewExtractorLink);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.hexated.HDrezkaProvider$cleanCallback$2 */
    /* JADX INFO: compiled from: HDrezkaProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.hexated.HDrezkaProvider$cleanCallback$2", f = "HDrezkaProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00012 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $quality;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00012(String str, Continuation<? super C00012> continuation) {
            super(2, continuation);
            this.$quality = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00012 = HDrezkaProvider.this.new C00012(this.$quality, continuation);
            c00012.L$0 = obj;
            return c00012;
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
                    $this$newExtractorLink.setReferer(HDrezkaProvider.this.getMainUrl() + '/');
                    $this$newExtractorLink.setQuality(HDrezkaProvider.this.getQuality(this.$quality));
                    $this$newExtractorLink.setHeaders(MapsKt.mapOf(TuplesKt.to("Origin", HDrezkaProvider.this.getMainUrl())));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final String getLanguage(String str) {
        if (Intrinsics.areEqual(str, "Русский")) {
            return "Russian";
        }
        return Intrinsics.areEqual(str, "Українська") ? "Ukrainian" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int getQuality(String str) {
        switch (str.hashCode()) {
            case -1762539867:
                if (str.equals("1080p Ultra")) {
                    return Qualities.P1080.getValue();
                }
                break;
            case 1572835:
                if (str.equals("360p")) {
                    return Qualities.P240.getValue();
                }
                break;
            case 1604548:
                if (str.equals("480p")) {
                    return Qualities.P360.getValue();
                }
                break;
            case 1688155:
                if (str.equals("720p")) {
                    return Qualities.P480.getValue();
                }
                break;
            case 46737913:
                if (str.equals("1080p")) {
                    return Qualities.P720.getValue();
                }
                break;
        }
        return ExtractorApiKt.getQualityFromName(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x019b  */
    /* JADX WARN: Code duplicated, block: B:19:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x01e1 -> B:26:0x0279). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0372 -> B:36:0x039f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0564 -> B:56:0x0567). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.BlockNode.isDominator(BlockNode.java:178)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:746)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public final java.lang.Object invokeSources(java.lang.String r39, java.lang.String r40, java.lang.String r41, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r42, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r43, kotlin.coroutines.Continuation<? super kotlin.Unit> r44) {
        /*
            Method dump skipped, instruction units count: 1440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hexated.HDrezkaProvider.invokeSources(java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0396  */
    /* JADX WARN: Code duplicated, block: B:107:0x03be  */
    /* JADX WARN: Code duplicated, block: B:109:0x03f1  */
    /* JADX WARN: Code duplicated, block: B:110:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:117:0x0425  */
    /* JADX WARN: Code duplicated, block: B:129:0x0463  */
    /* JADX WARN: Code duplicated, block: B:146:0x048a  */
    /* JADX WARN: Code duplicated, block: B:158:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:160:0x0532 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:161:0x0533  */
    /* JADX WARN: Code duplicated, block: B:163:0x056d  */
    /* JADX WARN: Code duplicated, block: B:164:0x058e  */
    /* JADX WARN: Code duplicated, block: B:237:0x042a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:244:0x046a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v83, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v87, types: [java.lang.Throwable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:161:0x0533 -> B:162:0x0550). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:163:0x056d -> B:165:0x05b0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:164:0x058e -> B:165:0x05b0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:209:0x08ce -> B:210:0x08e6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:211:0x08f8 -> B:212:0x0918). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r54, boolean r55, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r56, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r57, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r58) {
        /*
            Method dump skipped, instruction units count: 2438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hexated.HDrezkaProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadLinks$lambda$0$0(Context $_ctx) {
        Toast.makeText($_ctx, "⚠️(Opening ads) Subscription expired. If you have renewed your subscription, please re-verify it in Subscription Manager.", 1).show();
    }

    /* JADX INFO: compiled from: HDrezkaProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/hexated/HDrezkaProvider$LocalSources;", "", "streams", "", "subtitle", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "getStreams", "()Ljava/lang/String;", "getSubtitle", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "HDrezkaProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class LocalSources {

        @JsonProperty("streams")
        @NotNull
        private final String streams;

        @JsonProperty("subtitle")
        @Nullable
        private final Object subtitle;

        public static /* synthetic */ LocalSources copy$default(LocalSources localSources, String str, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                str = localSources.streams;
            }
            if ((i & 2) != 0) {
                obj = localSources.subtitle;
            }
            return localSources.copy(str, obj);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getStreams() {
            return this.streams;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Object getSubtitle() {
            return this.subtitle;
        }

        @NotNull
        public final LocalSources copy(@JsonProperty("streams") @NotNull String streams, @JsonProperty("subtitle") @Nullable Object subtitle) {
            return new LocalSources(streams, subtitle);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LocalSources)) {
                return false;
            }
            LocalSources localSources = (LocalSources) other;
            return Intrinsics.areEqual(this.streams, localSources.streams) && Intrinsics.areEqual(this.subtitle, localSources.subtitle);
        }

        public int hashCode() {
            return (this.streams.hashCode() * 31) + (this.subtitle == null ? 0 : this.subtitle.hashCode());
        }

        @NotNull
        public String toString() {
            return "LocalSources(streams=" + this.streams + ", subtitle=" + this.subtitle + ')';
        }

        public LocalSources(@JsonProperty("streams") @NotNull String streams, @JsonProperty("subtitle") @Nullable Object subtitle) {
            this.streams = streams;
            this.subtitle = subtitle;
        }

        @NotNull
        public final String getStreams() {
            return this.streams;
        }

        @Nullable
        public final Object getSubtitle() {
            return this.subtitle;
        }
    }

    /* JADX INFO: compiled from: HDrezkaProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/hexated/HDrezkaProvider$Sources;", "", "url", "", "subtitle", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "getUrl", "()Ljava/lang/String;", "getSubtitle", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "HDrezkaProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Sources {

        @JsonProperty("subtitle")
        @Nullable
        private final Object subtitle;

        @JsonProperty("url")
        @NotNull
        private final String url;

        public static /* synthetic */ Sources copy$default(Sources sources, String str, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                str = sources.url;
            }
            if ((i & 2) != 0) {
                obj = sources.subtitle;
            }
            return sources.copy(str, obj);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Object getSubtitle() {
            return this.subtitle;
        }

        @NotNull
        public final Sources copy(@JsonProperty("url") @NotNull String url, @JsonProperty("subtitle") @Nullable Object subtitle) {
            return new Sources(url, subtitle);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Sources)) {
                return false;
            }
            Sources sources = (Sources) other;
            return Intrinsics.areEqual(this.url, sources.url) && Intrinsics.areEqual(this.subtitle, sources.subtitle);
        }

        public int hashCode() {
            return (this.url.hashCode() * 31) + (this.subtitle == null ? 0 : this.subtitle.hashCode());
        }

        @NotNull
        public String toString() {
            return "Sources(url=" + this.url + ", subtitle=" + this.subtitle + ')';
        }

        public Sources(@JsonProperty("url") @NotNull String url, @JsonProperty("subtitle") @Nullable Object subtitle) {
            this.url = url;
            this.subtitle = subtitle;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final Object getSubtitle() {
            return this.subtitle;
        }
    }

    /* JADX INFO: compiled from: HDrezkaProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/hexated/HDrezkaProvider$Server;", "", "translator_name", "", "translator_id", "camrip", "ads", "director", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTranslator_name", "()Ljava/lang/String;", "getTranslator_id", "getCamrip", "getAds", "getDirector", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "HDrezkaProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Server {

        @JsonProperty("ads")
        @Nullable
        private final String ads;

        @JsonProperty("camrip")
        @Nullable
        private final String camrip;

        @JsonProperty("director")
        @Nullable
        private final String director;

        @JsonProperty("translator_id")
        @Nullable
        private final String translator_id;

        @JsonProperty("translator_name")
        @Nullable
        private final String translator_name;

        public static /* synthetic */ Server copy$default(Server server, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = server.translator_name;
            }
            if ((i & 2) != 0) {
                str2 = server.translator_id;
            }
            if ((i & 4) != 0) {
                str3 = server.camrip;
            }
            if ((i & 8) != 0) {
                str4 = server.ads;
            }
            if ((i & 16) != 0) {
                str5 = server.director;
            }
            String str6 = str5;
            String str7 = str3;
            return server.copy(str, str2, str7, str4, str6);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTranslator_name() {
            return this.translator_name;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTranslator_id() {
            return this.translator_id;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getCamrip() {
            return this.camrip;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getAds() {
            return this.ads;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getDirector() {
            return this.director;
        }

        @NotNull
        public final Server copy(@JsonProperty("translator_name") @Nullable String translator_name, @JsonProperty("translator_id") @Nullable String translator_id, @JsonProperty("camrip") @Nullable String camrip, @JsonProperty("ads") @Nullable String ads, @JsonProperty("director") @Nullable String director) {
            return new Server(translator_name, translator_id, camrip, ads, director);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Server)) {
                return false;
            }
            Server server = (Server) other;
            return Intrinsics.areEqual(this.translator_name, server.translator_name) && Intrinsics.areEqual(this.translator_id, server.translator_id) && Intrinsics.areEqual(this.camrip, server.camrip) && Intrinsics.areEqual(this.ads, server.ads) && Intrinsics.areEqual(this.director, server.director);
        }

        public int hashCode() {
            return ((((((((this.translator_name == null ? 0 : this.translator_name.hashCode()) * 31) + (this.translator_id == null ? 0 : this.translator_id.hashCode())) * 31) + (this.camrip == null ? 0 : this.camrip.hashCode())) * 31) + (this.ads == null ? 0 : this.ads.hashCode())) * 31) + (this.director != null ? this.director.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Server(translator_name=" + this.translator_name + ", translator_id=" + this.translator_id + ", camrip=" + this.camrip + ", ads=" + this.ads + ", director=" + this.director + ')';
        }

        public Server(@JsonProperty("translator_name") @Nullable String translator_name, @JsonProperty("translator_id") @Nullable String translator_id, @JsonProperty("camrip") @Nullable String camrip, @JsonProperty("ads") @Nullable String ads, @JsonProperty("director") @Nullable String director) {
            this.translator_name = translator_name;
            this.translator_id = translator_id;
            this.camrip = camrip;
            this.ads = ads;
            this.director = director;
        }

        @Nullable
        public final String getTranslator_name() {
            return this.translator_name;
        }

        @Nullable
        public final String getTranslator_id() {
            return this.translator_id;
        }

        @Nullable
        public final String getCamrip() {
            return this.camrip;
        }

        @Nullable
        public final String getAds() {
            return this.ads;
        }

        @Nullable
        public final String getDirector() {
            return this.director;
        }
    }

    /* JADX INFO: compiled from: HDrezkaProvider.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0001\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jc\u0010\u001e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006%"}, d2 = {"Lcom/hexated/HDrezkaProvider$Data;", "", "id", "", "favs", "server", "", "Lcom/hexated/HDrezkaProvider$Server;", "season", "episode", "action", "ref", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getFavs", "getServer", "()Ljava/util/List;", "getSeason", "getEpisode", "getAction", "getRef", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "HDrezkaProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Data {

        @JsonProperty("action")
        @Nullable
        private final String action;

        @JsonProperty("episode")
        @Nullable
        private final String episode;

        @JsonProperty("favs")
        @Nullable
        private final String favs;

        @JsonProperty("id")
        @Nullable
        private final String id;

        @JsonProperty("ref")
        @Nullable
        private final String ref;

        @JsonProperty("season")
        @Nullable
        private final String season;

        @JsonProperty("server")
        @Nullable
        private final List<Server> server;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Data copy$default(Data data, String str, String str2, List list, String str3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = data.id;
            }
            if ((i & 2) != 0) {
                str2 = data.favs;
            }
            if ((i & 4) != 0) {
                list = data.server;
            }
            if ((i & 8) != 0) {
                str3 = data.season;
            }
            if ((i & 16) != 0) {
                str4 = data.episode;
            }
            if ((i & 32) != 0) {
                str5 = data.action;
            }
            if ((i & 64) != 0) {
                str6 = data.ref;
            }
            String str7 = str5;
            String str8 = str6;
            String str9 = str4;
            List list2 = list;
            return data.copy(str, str2, list2, str3, str9, str7, str8);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getFavs() {
            return this.favs;
        }

        @Nullable
        public final List<Server> component3() {
            return this.server;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getEpisode() {
            return this.episode;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getAction() {
            return this.action;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getRef() {
            return this.ref;
        }

        @NotNull
        public final Data copy(@JsonProperty("id") @Nullable String id, @JsonProperty("favs") @Nullable String favs, @JsonProperty("server") @Nullable List<Server> server, @JsonProperty("season") @Nullable String season, @JsonProperty("episode") @Nullable String episode, @JsonProperty("action") @Nullable String action, @JsonProperty("ref") @Nullable String ref) {
            return new Data(id, favs, server, season, episode, action, ref);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data = (Data) other;
            return Intrinsics.areEqual(this.id, data.id) && Intrinsics.areEqual(this.favs, data.favs) && Intrinsics.areEqual(this.server, data.server) && Intrinsics.areEqual(this.season, data.season) && Intrinsics.areEqual(this.episode, data.episode) && Intrinsics.areEqual(this.action, data.action) && Intrinsics.areEqual(this.ref, data.ref);
        }

        public int hashCode() {
            return ((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.favs == null ? 0 : this.favs.hashCode())) * 31) + (this.server == null ? 0 : this.server.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.action == null ? 0 : this.action.hashCode())) * 31) + (this.ref != null ? this.ref.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Data(id=" + this.id + ", favs=" + this.favs + ", server=" + this.server + ", season=" + this.season + ", episode=" + this.episode + ", action=" + this.action + ", ref=" + this.ref + ')';
        }

        public Data(@JsonProperty("id") @Nullable String id, @JsonProperty("favs") @Nullable String favs, @JsonProperty("server") @Nullable List<Server> list, @JsonProperty("season") @Nullable String season, @JsonProperty("episode") @Nullable String episode, @JsonProperty("action") @Nullable String action, @JsonProperty("ref") @Nullable String ref) {
            this.id = id;
            this.favs = favs;
            this.server = list;
            this.season = season;
            this.episode = episode;
            this.action = action;
            this.ref = ref;
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getFavs() {
            return this.favs;
        }

        @Nullable
        public final List<Server> getServer() {
            return this.server;
        }

        @Nullable
        public final String getSeason() {
            return this.season;
        }

        @Nullable
        public final String getEpisode() {
            return this.episode;
        }

        @Nullable
        public final String getAction() {
            return this.action;
        }

        @Nullable
        public final String getRef() {
            return this.ref;
        }
    }

    /* JADX INFO: compiled from: HDrezkaProvider.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/hexated/HDrezkaProvider$Trailer;", "", "success", "", "code", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCode", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;)Lcom/hexated/HDrezkaProvider$Trailer;", "equals", "other", "hashCode", "", "toString", "HDrezkaProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Trailer {

        @JsonProperty("code")
        @Nullable
        private final String code;

        @JsonProperty("success")
        @Nullable
        private final Boolean success;

        public static /* synthetic */ Trailer copy$default(Trailer trailer, Boolean bool, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = trailer.success;
            }
            if ((i & 2) != 0) {
                str = trailer.code;
            }
            return trailer.copy(bool, str);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getSuccess() {
            return this.success;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        @NotNull
        public final Trailer copy(@JsonProperty("success") @Nullable Boolean success, @JsonProperty("code") @Nullable String code) {
            return new Trailer(success, code);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Trailer)) {
                return false;
            }
            Trailer trailer = (Trailer) other;
            return Intrinsics.areEqual(this.success, trailer.success) && Intrinsics.areEqual(this.code, trailer.code);
        }

        public int hashCode() {
            return ((this.success == null ? 0 : this.success.hashCode()) * 31) + (this.code != null ? this.code.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Trailer(success=" + this.success + ", code=" + this.code + ')';
        }

        public Trailer(@JsonProperty("success") @Nullable Boolean success, @JsonProperty("code") @Nullable String code) {
            this.success = success;
            this.code = code;
        }

        @Nullable
        public final Boolean getSuccess() {
            return this.success;
        }

        @Nullable
        public final String getCode() {
            return this.code;
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
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hexated.HDrezkaProvider$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    HDrezkaProvider.showSubscriptionPopupIfNeeded$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.hexated.HDrezkaProvider$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HDrezkaProvider.showSubscriptionPopupIfNeeded$lambda$0$11($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249, $ctx, dialog, view);
                }
            });
            subscribeTv.setOnClickListener(new View.OnClickListener() { // from class: com.hexated.HDrezkaProvider$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HDrezkaProvider.showSubscriptionPopupIfNeeded$lambda$0$12(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hexated.HDrezkaProvider$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                HDrezkaProvider.showTelegramPopup$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.hexated.HDrezkaProvider$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            joinTv.setOnClickListener(new View.OnClickListener() { // from class: com.hexated.HDrezkaProvider$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HDrezkaProvider.showTelegramPopup$lambda$0$9(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hexated.HDrezkaProvider$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                HDrezkaProvider.openInExternalBrowser$lambda$0(ctx, url);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final String getAnubisCookie(final String url) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        final Ref.ObjectRef fetchedCookie = new Ref.ObjectRef();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hexated.HDrezkaProvider$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                HDrezkaProvider.getAnubisCookie$lambda$0(url, latch, fetchedCookie);
            }
        });
        latch.await(16L, TimeUnit.SECONDS);
        return (String) fetchedCookie.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAnubisCookie$lambda$0(final String $url, final CountDownLatch $latch, final Ref.ObjectRef $fetchedCookie) {
        try {
            Context ctx = context;
            try {
                if (ctx == null) {
                    throw new Exception("Context is null");
                }
                final WebView webView = new WebView(ctx);
                WebSettings settings = webView.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setDomStorageEnabled(true);
                settings.setLoadsImagesAutomatically(false);
                settings.setBlockNetworkImage(true);
                settings.setMixedContentMode(0);
                settings.setUserAgentString("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36");
                webView.setWebViewClient(new WebViewClient() { // from class: com.hexated.HDrezkaProvider$getAnubisCookie$1$1
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                        String reqHost;
                        String targetHost = Uri.parse($url).getHost();
                        if (targetHost == null || (reqHost = request.getUrl().getHost()) == null) {
                            return false;
                        }
                        if (StringsKt.contains$default(reqHost, targetHost, false, 2, (Object) null)) {
                            return super.shouldOverrideUrlLoading(view, request);
                        }
                        return true;
                    }
                });
                webView.loadUrl($url);
                final Ref.BooleanRef polling = new Ref.BooleanRef();
                polling.element = true;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.hexated.HDrezkaProvider$getAnubisCookie$1$checkRunnable$1
                    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z;
                        if (polling.element) {
                            String cookies = CookieManager.getInstance().getCookie($url);
                            Object obj = null;
                            if (cookies != null) {
                                z = StringsKt.contains$default(cookies, "-anubis-auth=", false, 2, (Object) null);
                            }
                            if (!z) {
                                new Handler(Looper.getMainLooper()).postDelayed(this, 250L);
                                return;
                            }
                            polling.element = false;
                            Ref.ObjectRef<String> objectRef = $fetchedCookie;
                            Iterable $this$map$iv = StringsKt.split$default(cookies, new String[]{";"}, false, 0, 6, (Object) null);
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                String it = (String) item$iv$iv;
                                destination$iv$iv.add(StringsKt.trim(it).toString());
                            }
                            Iterable $this$firstOrNull$iv = (List) destination$iv$iv;
                            for (Object element$iv : $this$firstOrNull$iv) {
                                String it2 = (String) element$iv;
                                if (StringsKt.contains$default(it2, "-anubis-auth=", false, 2, (Object) null)) {
                                    obj = element$iv;
                                    break;
                                }
                            }
                            objectRef.element = obj;
                            try {
                                webView.stopLoading();
                                webView.destroy();
                            } catch (Exception e) {
                            }
                            if ($latch.getCount() > 0) {
                                $latch.countDown();
                            }
                        }
                    }
                }, 250L);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.hexated.HDrezkaProvider$$ExternalSyntheticLambda11
                    @Override // java.lang.Runnable
                    public final void run() {
                        HDrezkaProvider.getAnubisCookie$lambda$0$0(polling, webView, $latch);
                    }
                }, 15000L);
                return;
            } catch (Exception e) {
            }
        } catch (Exception e2) {
        }
        if ($latch.getCount() > 0) {
            $latch.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAnubisCookie$lambda$0$0(Ref.BooleanRef $polling, WebView $webView, CountDownLatch $latch) {
        $polling.element = false;
        try {
            $webView.stopLoading();
            $webView.destroy();
        } catch (Exception e) {
        }
        if ($latch.getCount() > 0) {
            $latch.countDown();
        }
    }
}
