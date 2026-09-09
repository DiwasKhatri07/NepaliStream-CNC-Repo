package com.cncverse;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.cncverse.donation.DonationManager;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LiveSearchResponse;
import com.lagradost.cloudstream3.LiveStreamLoadResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LiveEventsProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/SKTechProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 U2\u00020\u0001:\u0005UVWXYB\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u001f\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H\u0002J\u001e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0096@¢\u0006\u0002\u0010.J\u001c\u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00102\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u00103J\u0016\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u00103JF\u00107\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u00132\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020=0;2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020=0;H\u0096@¢\u0006\u0002\u0010@J\u0018\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u00103J\u0018\u0010D\u001a\u0004\u0018\u00010\u00032\u0006\u0010E\u001a\u00020FH\u0082@¢\u0006\u0002\u0010GJ\u0018\u0010H\u001a\u0004\u0018\u00010\u00032\u0006\u0010E\u001a\u00020FH\u0082@¢\u0006\u0002\u0010GJ \u0010I\u001a\u0004\u0018\u00010\u00032\u0006\u0010J\u001a\u00020\u00032\u0006\u0010E\u001a\u00020FH\u0082@¢\u0006\u0002\u0010KJ\u0018\u0010L\u001a\u0004\u0018\u00010\u00032\u0006\u0010E\u001a\u00020FH\u0082@¢\u0006\u0002\u0010GJ\u0018\u0010M\u001a\u0004\u0018\u00010\u00032\u0006\u0010E\u001a\u00020FH\u0082@¢\u0006\u0002\u0010GJ\u0018\u0010N\u001a\u0004\u0018\u00010\u00032\u0006\u0010E\u001a\u00020FH\u0082@¢\u0006\u0002\u0010GJ\u0018\u0010O\u001a\u0004\u0018\u00010\u00032\u0006\u0010E\u001a\u00020FH\u0082@¢\u0006\u0002\u0010GJ\u0018\u0010P\u001a\u0004\u0018\u00010\u00032\u0006\u0010E\u001a\u00020FH\u0082@¢\u0006\u0002\u0010GJ(\u0010Q\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030S0R2\u0006\u0010T\u001a\u00020\u0003H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u001a\u0010\u000f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/cncverse/LiveEventsProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "name", "", "customCatLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getCustomCatLink", "mainUrl", "getMainUrl", "setMainUrl", "lang", "getLang", "setLang", "hasMainPage", "", "getHasMainPage", "()Z", "hasChromecastSupport", "getHasChromecastSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "client", "Lokhttp3/OkHttpClient;", "getWebUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDisplayTitle", "event", "Lcom/cncverse/LiveEventData;", "getEventStatus", "isEventLive", "isEventEnded", "generateMatchCardUrl", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchChannelStreams", "Lcom/cncverse/LiveEventsProvider$ChannelStreamResponse;", "slug", "fetchStreamFromTokenApi", "config", "Lcom/cncverse/LiveEventsProvider$TokenApiConfig;", "(Lcom/cncverse/LiveEventsProvider$TokenApiConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleEmbedExtraction", "loadEmbedInWebView", "embedUrl", "(Ljava/lang/String;Lcom/cncverse/LiveEventsProvider$TokenApiConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleJsonExtraction", "handleHtmlExtraction", "handleYoutubeExtraction", "handleLocationServiceExtraction", "handleDirectApiCall", "parseStreamLink", "Lkotlin/Pair;", "", "link", "Companion", "ChannelStreamResponse", "StreamUrl", "TokenApiConfig", "LiveEventLoadData", "SKTechProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLiveEventsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveEventsProvider.kt\ncom/cncverse/LiveEventsProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 7 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,1065:1\n1#2:1066\n1#2:1098\n1#2:1117\n1#2:1137\n1512#3:1067\n1538#3,3:1068\n1541#3,3:1078\n1586#3:1084\n1661#3,3:1085\n1068#3:1089\n777#3:1090\n873#3,2:1091\n1586#3:1093\n1661#3,3:1094\n1915#3:1135\n1586#3:1155\n1661#3,3:1156\n1586#3:1159\n1661#3,3:1160\n1916#3:1163\n1915#3,2:1164\n383#4,7:1071\n129#5:1081\n158#5,2:1082\n160#5:1088\n63#6:1097\n64#6,15:1099\n63#6:1116\n64#6,15:1118\n63#6:1136\n64#6,15:1138\n50#7:1114\n43#7:1115\n50#7:1133\n43#7:1134\n50#7:1153\n43#7:1154\n*S KotlinDebug\n*F\n+ 1 LiveEventsProvider.kt\ncom/cncverse/LiveEventsProvider\n*L\n389#1:1098\n422#1:1117\n438#1:1137\n255#1:1067\n255#1:1068,3\n255#1:1078,3\n292#1:1084\n292#1:1085,3\n329#1:1089\n347#1:1090\n347#1:1091,2\n360#1:1093\n360#1:1094,3\n431#1:1135\n465#1:1155\n465#1:1156,3\n476#1:1159\n476#1:1160,3\n431#1:1163\n1043#1:1164,2\n255#1:1071,7\n259#1:1081\n259#1:1082,2\n259#1:1088\n389#1:1097\n389#1:1099,15\n422#1:1116\n422#1:1118,15\n438#1:1136\n438#1:1138,15\n389#1:1114\n389#1:1115\n422#1:1133\n422#1:1134\n438#1:1153\n438#1:1154\n*E\n"})
public final class LiveEventsProvider extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String DEFAULT_WEB_URL = "https://welalagaa.site";

    @Nullable
    private static String cachedWebUrl;

    @Nullable
    private static Context context;

    @NotNull
    private final OkHttpClient client;

    @Nullable
    private final String customCatLink;
    private final boolean hasChromecastSupport;
    private final boolean hasMainPage;

    @NotNull
    private String lang;

    @NotNull
    private String mainUrl;

    @NotNull
    private String name;

    @NotNull
    private final Set<TvType> supportedTypes;

    /* JADX INFO: renamed from: com.cncverse.LiveEventsProvider$getMainPage$1 */
    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LiveEventsProvider", f = "LiveEventsProvider.kt", i = {0, 0, 1, 1}, l = {249, 251}, m = "getMainPage", n = {"request", "page", "request", "page"}, nl = {251, 248}, s = {"L$0", "I$0", "L$0", "I$0"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveEventsProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.LiveEventsProvider$getWebUrl$1 */
    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LiveEventsProvider", f = "LiveEventsProvider.kt", i = {}, l = {64}, m = "getWebUrl", n = {}, nl = {65}, s = {}, v = 2)
    static final class C00091 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00091(Continuation<? super C00091> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveEventsProvider.this.getWebUrl((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.LiveEventsProvider$loadLinks$1 */
    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LiveEventsProvider", f = "LiveEventsProvider.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {425, 439, 483, 501, 522, 542}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "loadData", "isCasting", "data", "subtitleCallback", "callback", "loadData", "streamResponse", "$this$forEach$iv", "element$iv", "stream", "serverName", "tokenConfig", "isCasting", "$i$f$forEach", "$i$a$-forEach-LiveEventsProvider$loadLinks$2", "data", "subtitleCallback", "callback", "loadData", "streamResponse", "$this$forEach$iv", "element$iv", "stream", "streamLink", "serverName", "url", "headers", "drmInfo", "drmKidBytes", "drmKidBase64", "drmKeyBytes", "drmKeyBase64", "isCasting", "$i$f$forEach", "$i$a$-forEach-LiveEventsProvider$loadLinks$2", "data", "subtitleCallback", "callback", "loadData", "streamResponse", "$this$forEach$iv", "element$iv", "stream", "streamLink", "serverName", "url", "headers", "drmInfo", "isCasting", "$i$f$forEach", "$i$a$-forEach-LiveEventsProvider$loadLinks$2", "data", "subtitleCallback", "callback", "loadData", "streamResponse", "$this$forEach$iv", "element$iv", "stream", "streamLink", "serverName", "url", "headers", "finalHeaders", "isCasting", "$i$f$forEach", "$i$a$-forEach-LiveEventsProvider$loadLinks$2", "data", "subtitleCallback", "callback", "loadData", "streamResponse", "$this$forEach$iv", "element$iv", "stream", "streamLink", "serverName", "url", "headers", "finalHeaders", "isCasting", "$i$f$forEach", "$i$a$-forEach-LiveEventsProvider$loadLinks$2"}, nl = {426, 440, 482, 500, 521, 541}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "Z$0", "I$0", "I$1"}, v = 2)
    static final class C00231 extends ContinuationImpl {
        int I$0;
        int I$1;
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

        C00231(Continuation<? super C00231> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveEventsProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.LiveEventsProvider$search$1 */
    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LiveEventsProvider", f = "LiveEventsProvider.kt", i = {0}, l = {344}, m = "search", n = {"query"}, nl = {346}, s = {"L$0"}, v = 2)
    static final class C00241 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00241(Continuation<? super C00241> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveEventsProvider.this.search(null, (Continuation) this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LiveEventsProvider() {
        String str = null;
        this(str, str, 3, str);
    }

    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/cncverse/LiveEventsProvider$Companion;", "", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "cachedWebUrl", "", "DEFAULT_WEB_URL", "SKTechProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Context getContext() {
            return LiveEventsProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            LiveEventsProvider.context = context;
        }
    }

    public LiveEventsProvider(@NotNull String name, @Nullable String customCatLink) {
        this.name = name;
        this.customCatLink = customCatLink;
        this.mainUrl = DEFAULT_WEB_URL;
        this.lang = "ta";
        this.hasMainPage = true;
        this.hasChromecastSupport = true;
        this.supportedTypes = SetsKt.setOf(TvType.Live);
        this.client = new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).build();
    }

    public /* synthetic */ LiveEventsProvider(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "⚡SKTech Live Events" : str, (i & 2) != 0 ? null : str2);
    }

    @Nullable
    public final String getCustomCatLink() {
        return this.customCatLink;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    public boolean getHasChromecastSupport() {
        return this.hasChromecastSupport;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getWebUrl(Continuation<? super String> continuation) {
        C00091 c00091;
        Object baseApiUrl;
        if (continuation instanceof C00091) {
            c00091 = (C00091) continuation;
            if ((c00091.label & Integer.MIN_VALUE) != 0) {
                c00091.label -= Integer.MIN_VALUE;
            } else {
                c00091 = new C00091(continuation);
            }
        } else {
            c00091 = new C00091(continuation);
        }
        Object $result = c00091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (c00091.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String it = cachedWebUrl;
                if (it != null) {
                    return it;
                }
                FirebaseRemoteConfigFetcher firebaseRemoteConfigFetcher = FirebaseRemoteConfigFetcher.INSTANCE;
                c00091.label = 1;
                baseApiUrl = firebaseRemoteConfigFetcher.getBaseApiUrl(c00091);
                if (baseApiUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                baseApiUrl = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String firebaseUrl = (String) baseApiUrl;
        String str = firebaseUrl;
        if (str != null && !StringsKt.isBlank(str)) {
            z = false;
        }
        if (!z) {
            cachedWebUrl = firebaseUrl;
            String str2 = cachedWebUrl;
            Intrinsics.checkNotNull(str2);
            setMainUrl(str2);
            String str3 = cachedWebUrl;
            Intrinsics.checkNotNull(str3);
            return str3;
        }
        cachedWebUrl = DEFAULT_WEB_URL;
        setMainUrl(DEFAULT_WEB_URL);
        return DEFAULT_WEB_URL;
    }

    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\bHÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/cncverse/LiveEventsProvider$ChannelStreamResponse;", "", "streamUrls", "", "Lcom/cncverse/LiveEventsProvider$StreamUrl;", "related", "Lcom/cncverse/LiveEventData;", "prevChannel", "", "nextChannel", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getStreamUrls", "()Ljava/util/List;", "getRelated", "getPrevChannel", "()Ljava/lang/String;", "getNextChannel", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "SKTechProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ChannelStreamResponse {

        @Nullable
        private final String nextChannel;

        @Nullable
        private final String prevChannel;

        @Nullable
        private final List<LiveEventData> related;

        @Nullable
        private final List<StreamUrl> streamUrls;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ChannelStreamResponse copy$default(ChannelStreamResponse channelStreamResponse, List list, List list2, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = channelStreamResponse.streamUrls;
            }
            if ((i & 2) != 0) {
                list2 = channelStreamResponse.related;
            }
            if ((i & 4) != 0) {
                str = channelStreamResponse.prevChannel;
            }
            if ((i & 8) != 0) {
                str2 = channelStreamResponse.nextChannel;
            }
            return channelStreamResponse.copy(list, list2, str, str2);
        }

        @Nullable
        public final List<StreamUrl> component1() {
            return this.streamUrls;
        }

        @Nullable
        public final List<LiveEventData> component2() {
            return this.related;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPrevChannel() {
            return this.prevChannel;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getNextChannel() {
            return this.nextChannel;
        }

        @NotNull
        public final ChannelStreamResponse copy(@Nullable List<StreamUrl> streamUrls, @Nullable List<LiveEventData> related, @Nullable String prevChannel, @Nullable String nextChannel) {
            return new ChannelStreamResponse(streamUrls, related, prevChannel, nextChannel);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelStreamResponse)) {
                return false;
            }
            ChannelStreamResponse channelStreamResponse = (ChannelStreamResponse) other;
            return Intrinsics.areEqual(this.streamUrls, channelStreamResponse.streamUrls) && Intrinsics.areEqual(this.related, channelStreamResponse.related) && Intrinsics.areEqual(this.prevChannel, channelStreamResponse.prevChannel) && Intrinsics.areEqual(this.nextChannel, channelStreamResponse.nextChannel);
        }

        public int hashCode() {
            return ((((((this.streamUrls == null ? 0 : this.streamUrls.hashCode()) * 31) + (this.related == null ? 0 : this.related.hashCode())) * 31) + (this.prevChannel == null ? 0 : this.prevChannel.hashCode())) * 31) + (this.nextChannel != null ? this.nextChannel.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "ChannelStreamResponse(streamUrls=" + this.streamUrls + ", related=" + this.related + ", prevChannel=" + this.prevChannel + ", nextChannel=" + this.nextChannel + ')';
        }

        public ChannelStreamResponse(@Nullable List<StreamUrl> list, @Nullable List<LiveEventData> list2, @Nullable String prevChannel, @Nullable String nextChannel) {
            this.streamUrls = list;
            this.related = list2;
            this.prevChannel = prevChannel;
            this.nextChannel = nextChannel;
        }

        @Nullable
        public final List<StreamUrl> getStreamUrls() {
            return this.streamUrls;
        }

        @Nullable
        public final List<LiveEventData> getRelated() {
            return this.related;
        }

        @Nullable
        public final String getPrevChannel() {
            return this.prevChannel;
        }

        @Nullable
        public final String getNextChannel() {
            return this.nextChannel;
        }
    }

    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/cncverse/LiveEventsProvider$StreamUrl;", "", "name", "", "link", "scheme", "", "api", "tokenApi", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getLink", "getScheme", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getApi", "getTokenApi", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/cncverse/LiveEventsProvider$StreamUrl;", "equals", "", "other", "hashCode", "toString", "SKTechProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class StreamUrl {

        @Nullable
        private final String api;

        @Nullable
        private final String link;

        @Nullable
        private final String name;

        @Nullable
        private final Integer scheme;

        @Nullable
        private final String tokenApi;

        public static /* synthetic */ StreamUrl copy$default(StreamUrl streamUrl, String str, String str2, Integer num, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = streamUrl.name;
            }
            if ((i & 2) != 0) {
                str2 = streamUrl.link;
            }
            if ((i & 4) != 0) {
                num = streamUrl.scheme;
            }
            if ((i & 8) != 0) {
                str3 = streamUrl.api;
            }
            if ((i & 16) != 0) {
                str4 = streamUrl.tokenApi;
            }
            String str5 = str4;
            Integer num2 = num;
            return streamUrl.copy(str, str2, num2, str3, str5);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLink() {
            return this.link;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getScheme() {
            return this.scheme;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getApi() {
            return this.api;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getTokenApi() {
            return this.tokenApi;
        }

        @NotNull
        public final StreamUrl copy(@Nullable String name, @Nullable String link, @Nullable Integer scheme, @Nullable String api, @Nullable String tokenApi) {
            return new StreamUrl(name, link, scheme, api, tokenApi);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StreamUrl)) {
                return false;
            }
            StreamUrl streamUrl = (StreamUrl) other;
            return Intrinsics.areEqual(this.name, streamUrl.name) && Intrinsics.areEqual(this.link, streamUrl.link) && Intrinsics.areEqual(this.scheme, streamUrl.scheme) && Intrinsics.areEqual(this.api, streamUrl.api) && Intrinsics.areEqual(this.tokenApi, streamUrl.tokenApi);
        }

        public int hashCode() {
            return ((((((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.link == null ? 0 : this.link.hashCode())) * 31) + (this.scheme == null ? 0 : this.scheme.hashCode())) * 31) + (this.api == null ? 0 : this.api.hashCode())) * 31) + (this.tokenApi != null ? this.tokenApi.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "StreamUrl(name=" + this.name + ", link=" + this.link + ", scheme=" + this.scheme + ", api=" + this.api + ", tokenApi=" + this.tokenApi + ')';
        }

        public StreamUrl(@Nullable String name, @Nullable String link, @Nullable Integer scheme, @Nullable String api, @Nullable String tokenApi) {
            this.name = name;
            this.link = link;
            this.scheme = scheme;
            this.api = api;
            this.tokenApi = tokenApi;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getLink() {
            return this.link;
        }

        @Nullable
        public final Integer getScheme() {
            return this.scheme;
        }

        @Nullable
        public final String getApi() {
            return this.api;
        }

        @Nullable
        public final String getTokenApi() {
            return this.tokenApi;
        }
    }

    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ji\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006%"}, d2 = {"Lcom/cncverse/LiveEventsProvider$TokenApiConfig;", "", "url", "", "api", "type", "link_key", "default_string", "request_type", "request_body_type", "ip_api", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getApi", "getType", "getLink_key", "getDefault_string", "getRequest_type", "getRequest_body_type", "getIp_api", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "SKTechProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class TokenApiConfig {

        @Nullable
        private final String api;

        @Nullable
        private final String default_string;

        @Nullable
        private final String ip_api;

        @Nullable
        private final String link_key;

        @Nullable
        private final String request_body_type;

        @Nullable
        private final String request_type;

        @Nullable
        private final String type;

        @Nullable
        private final String url;

        public static /* synthetic */ TokenApiConfig copy$default(TokenApiConfig tokenApiConfig, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tokenApiConfig.url;
            }
            if ((i & 2) != 0) {
                str2 = tokenApiConfig.api;
            }
            if ((i & 4) != 0) {
                str3 = tokenApiConfig.type;
            }
            if ((i & 8) != 0) {
                str4 = tokenApiConfig.link_key;
            }
            if ((i & 16) != 0) {
                str5 = tokenApiConfig.default_string;
            }
            if ((i & 32) != 0) {
                str6 = tokenApiConfig.request_type;
            }
            if ((i & 64) != 0) {
                str7 = tokenApiConfig.request_body_type;
            }
            if ((i & 128) != 0) {
                str8 = tokenApiConfig.ip_api;
            }
            String str9 = str7;
            String str10 = str8;
            String str11 = str5;
            String str12 = str6;
            return tokenApiConfig.copy(str, str2, str3, str4, str11, str12, str9, str10);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getApi() {
            return this.api;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getLink_key() {
            return this.link_key;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getDefault_string() {
            return this.default_string;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getRequest_type() {
            return this.request_type;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getRequest_body_type() {
            return this.request_body_type;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getIp_api() {
            return this.ip_api;
        }

        @NotNull
        public final TokenApiConfig copy(@Nullable String url, @Nullable String api, @Nullable String type, @Nullable String link_key, @Nullable String default_string, @Nullable String request_type, @Nullable String request_body_type, @Nullable String ip_api) {
            return new TokenApiConfig(url, api, type, link_key, default_string, request_type, request_body_type, ip_api);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TokenApiConfig)) {
                return false;
            }
            TokenApiConfig tokenApiConfig = (TokenApiConfig) other;
            return Intrinsics.areEqual(this.url, tokenApiConfig.url) && Intrinsics.areEqual(this.api, tokenApiConfig.api) && Intrinsics.areEqual(this.type, tokenApiConfig.type) && Intrinsics.areEqual(this.link_key, tokenApiConfig.link_key) && Intrinsics.areEqual(this.default_string, tokenApiConfig.default_string) && Intrinsics.areEqual(this.request_type, tokenApiConfig.request_type) && Intrinsics.areEqual(this.request_body_type, tokenApiConfig.request_body_type) && Intrinsics.areEqual(this.ip_api, tokenApiConfig.ip_api);
        }

        public int hashCode() {
            return ((((((((((((((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.api == null ? 0 : this.api.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.link_key == null ? 0 : this.link_key.hashCode())) * 31) + (this.default_string == null ? 0 : this.default_string.hashCode())) * 31) + (this.request_type == null ? 0 : this.request_type.hashCode())) * 31) + (this.request_body_type == null ? 0 : this.request_body_type.hashCode())) * 31) + (this.ip_api != null ? this.ip_api.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "TokenApiConfig(url=" + this.url + ", api=" + this.api + ", type=" + this.type + ", link_key=" + this.link_key + ", default_string=" + this.default_string + ", request_type=" + this.request_type + ", request_body_type=" + this.request_body_type + ", ip_api=" + this.ip_api + ')';
        }

        public TokenApiConfig(@Nullable String url, @Nullable String api, @Nullable String type, @Nullable String link_key, @Nullable String default_string, @Nullable String request_type, @Nullable String request_body_type, @Nullable String ip_api) {
            this.url = url;
            this.api = api;
            this.type = type;
            this.link_key = link_key;
            this.default_string = default_string;
            this.request_type = request_type;
            this.request_body_type = request_body_type;
            this.ip_api = ip_api;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final String getApi() {
            return this.api;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getLink_key() {
            return this.link_key;
        }

        @Nullable
        public final String getDefault_string() {
            return this.default_string;
        }

        @Nullable
        public final String getRequest_type() {
            return this.request_type;
        }

        @Nullable
        public final String getRequest_body_type() {
            return this.request_body_type;
        }

        @Nullable
        public final String getIp_api() {
            return this.ip_api;
        }
    }

    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003JM\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/cncverse/LiveEventsProvider$LiveEventLoadData;", "", "eventId", "", "title", "", "poster", "slug", "formats", "", "Lcom/cncverse/LiveEventFormat;", "eventInfo", "Lcom/cncverse/LiveEventInfo;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/cncverse/LiveEventInfo;)V", "getEventId", "()I", "getTitle", "()Ljava/lang/String;", "getPoster", "getSlug", "getFormats", "()Ljava/util/List;", "getEventInfo", "()Lcom/cncverse/LiveEventInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "SKTechProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class LiveEventLoadData {
        private final int eventId;

        @Nullable
        private final LiveEventInfo eventInfo;

        @NotNull
        private final List<LiveEventFormat> formats;

        @NotNull
        private final String poster;

        @NotNull
        private final String slug;

        @NotNull
        private final String title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LiveEventLoadData copy$default(LiveEventLoadData liveEventLoadData, int i, String str, String str2, String str3, List list, LiveEventInfo liveEventInfo, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = liveEventLoadData.eventId;
            }
            if ((i2 & 2) != 0) {
                str = liveEventLoadData.title;
            }
            if ((i2 & 4) != 0) {
                str2 = liveEventLoadData.poster;
            }
            if ((i2 & 8) != 0) {
                str3 = liveEventLoadData.slug;
            }
            if ((i2 & 16) != 0) {
                list = liveEventLoadData.formats;
            }
            if ((i2 & 32) != 0) {
                liveEventInfo = liveEventLoadData.eventInfo;
            }
            List list2 = list;
            LiveEventInfo liveEventInfo2 = liveEventInfo;
            return liveEventLoadData.copy(i, str, str2, str3, list2, liveEventInfo2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getEventId() {
            return this.eventId;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSlug() {
            return this.slug;
        }

        @NotNull
        public final List<LiveEventFormat> component5() {
            return this.formats;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final LiveEventInfo getEventInfo() {
            return this.eventInfo;
        }

        @NotNull
        public final LiveEventLoadData copy(int eventId, @NotNull String title, @NotNull String poster, @NotNull String slug, @NotNull List<LiveEventFormat> formats, @Nullable LiveEventInfo eventInfo) {
            return new LiveEventLoadData(eventId, title, poster, slug, formats, eventInfo);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LiveEventLoadData)) {
                return false;
            }
            LiveEventLoadData liveEventLoadData = (LiveEventLoadData) other;
            return this.eventId == liveEventLoadData.eventId && Intrinsics.areEqual(this.title, liveEventLoadData.title) && Intrinsics.areEqual(this.poster, liveEventLoadData.poster) && Intrinsics.areEqual(this.slug, liveEventLoadData.slug) && Intrinsics.areEqual(this.formats, liveEventLoadData.formats) && Intrinsics.areEqual(this.eventInfo, liveEventLoadData.eventInfo);
        }

        public int hashCode() {
            return (((((((((this.eventId * 31) + this.title.hashCode()) * 31) + this.poster.hashCode()) * 31) + this.slug.hashCode()) * 31) + this.formats.hashCode()) * 31) + (this.eventInfo == null ? 0 : this.eventInfo.hashCode());
        }

        @NotNull
        public String toString() {
            return "LiveEventLoadData(eventId=" + this.eventId + ", title=" + this.title + ", poster=" + this.poster + ", slug=" + this.slug + ", formats=" + this.formats + ", eventInfo=" + this.eventInfo + ')';
        }

        public LiveEventLoadData(int eventId, @NotNull String title, @NotNull String poster, @NotNull String slug, @NotNull List<LiveEventFormat> list, @Nullable LiveEventInfo eventInfo) {
            this.eventId = eventId;
            this.title = title;
            this.poster = poster;
            this.slug = slug;
            this.formats = list;
            this.eventInfo = eventInfo;
        }

        public final int getEventId() {
            return this.eventId;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getPoster() {
            return this.poster;
        }

        @NotNull
        public final String getSlug() {
            return this.slug;
        }

        @NotNull
        public final List<LiveEventFormat> getFormats() {
            return this.formats;
        }

        @Nullable
        public final LiveEventInfo getEventInfo() {
            return this.eventInfo;
        }
    }

    private final String createDisplayTitle(LiveEventData event) {
        LiveEventInfo eventInfo = event.getEventInfo();
        if (eventInfo != null) {
            String teamA = eventInfo.getTeamA();
            if (!(teamA == null || StringsKt.isBlank(teamA))) {
                String teamB = eventInfo.getTeamB();
                if (!(teamB == null || StringsKt.isBlank(teamB))) {
                    if (Intrinsics.areEqual(eventInfo.getTeamA(), eventInfo.getTeamB())) {
                        return eventInfo.getTeamA();
                    }
                    return eventInfo.getTeamA() + " vs " + eventInfo.getTeamB();
                }
            }
        }
        return event.getTitle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getEventStatus(LiveEventData event) {
        Date date;
        Date date2;
        LiveEventInfo eventInfo = event.getEventInfo();
        if (eventInfo == null) {
            return "";
        }
        long now = System.currentTimeMillis();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
            String it = eventInfo.getStartTime();
            Long endTime = null;
            Long startTime = (it == null || (date2 = dateFormat.parse(it)) == null) ? null : Long.valueOf(date2.getTime());
            String it2 = eventInfo.getEndTime();
            if (it2 != null && (date = dateFormat.parse(it2)) != null) {
                endTime = Long.valueOf(date.getTime());
            }
            if (endTime != null && now >= endTime.longValue()) {
                return "✅";
            }
            if (startTime == null || now < startTime.longValue()) {
                return (startTime == null || now >= startTime.longValue()) ? "" : "🔜";
            }
            return "🔴";
        } catch (Exception e) {
            return "";
        }
    }

    private final boolean isEventLive(LiveEventData event) {
        Date date;
        Date date2;
        LiveEventInfo eventInfo = event.getEventInfo();
        if (eventInfo == null) {
            return false;
        }
        long now = System.currentTimeMillis();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
            String it = eventInfo.getStartTime();
            Long endTime = null;
            Long startTime = (it == null || (date2 = dateFormat.parse(it)) == null) ? null : Long.valueOf(date2.getTime());
            String it2 = eventInfo.getEndTime();
            if (it2 != null && (date = dateFormat.parse(it2)) != null) {
                endTime = Long.valueOf(date.getTime());
            }
            return (endTime == null || now < endTime.longValue()) && startTime != null && now >= startTime.longValue();
        } catch (Exception e) {
            return false;
        }
    }

    private final boolean isEventEnded(LiveEventData event) {
        Date date;
        LiveEventInfo eventInfo = event.getEventInfo();
        if (eventInfo == null) {
            return false;
        }
        long now = System.currentTimeMillis();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
            String it = eventInfo.getEndTime();
            Long endTime = null;
            if (it != null && (date = dateFormat.parse(it)) != null) {
                endTime = Long.valueOf(date.getTime());
            }
            return endTime != null && now >= endTime.longValue();
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x009c  */
    private final String generateMatchCardUrl(LiveEventData event) throws UnsupportedEncodingException {
        String title;
        String teamA;
        String teamB;
        String teamAFlag;
        String teamBFlag;
        String eventLogo;
        String it;
        LiveEventInfo eventInfo = event.getEventInfo();
        if (eventInfo == null || (title = eventInfo.getEventName()) == null) {
            title = event.getTitle();
        }
        String title2 = URLEncoder.encode(title, "UTF-8");
        if (eventInfo == null || (teamA = eventInfo.getTeamA()) == null) {
            teamA = "Team A";
        }
        String teamA2 = URLEncoder.encode(teamA, "UTF-8");
        if (eventInfo == null || (teamB = eventInfo.getTeamB()) == null) {
            teamB = "Team B";
        }
        String teamB2 = URLEncoder.encode(teamB, "UTF-8");
        String time = "";
        if (eventInfo == null || (teamAFlag = eventInfo.getTeamAFlag()) == null) {
            teamAFlag = "";
        }
        String teamAImg = teamAFlag;
        if (eventInfo == null || (teamBFlag = eventInfo.getTeamBFlag()) == null) {
            teamBFlag = "";
        }
        String teamBImg = teamBFlag;
        if (eventInfo == null || (eventLogo = eventInfo.getEventLogo()) == null) {
            eventLogo = "";
        }
        String eventLogo2 = eventLogo;
        boolean isLive = isEventLive(event);
        boolean isEnded = isEventEnded(event);
        if (eventInfo != null) {
            try {
                String it2 = eventInfo.getStartTime();
                if (it2 != null) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                    try {
                        SimpleDateFormat displayFormat = new SimpleDateFormat("MMM dd, yyyy hh:mm a", Locale.US);
                        Date date = dateFormat.parse(it2);
                        if (date == null || (it = URLEncoder.encode(displayFormat.format(date), "UTF-8")) == null) {
                            it = "";
                        }
                        if (it != null) {
                            time = it;
                        }
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
            }
        }
        StringBuilder $this$generateMatchCardUrl_u24lambda_u241 = new StringBuilder();
        $this$generateMatchCardUrl_u24lambda_u241.append("https://live-card-png.cricify.workers.dev/?");
        $this$generateMatchCardUrl_u24lambda_u241.append("title=" + title2);
        $this$generateMatchCardUrl_u24lambda_u241.append("&teamA=" + teamA2);
        $this$generateMatchCardUrl_u24lambda_u241.append("&teamB=" + teamB2);
        if (!StringsKt.isBlank(teamAImg)) {
            $this$generateMatchCardUrl_u24lambda_u241.append("&teamAImg=" + teamAImg);
        }
        if (!StringsKt.isBlank(teamBImg)) {
            $this$generateMatchCardUrl_u24lambda_u241.append("&teamBImg=" + teamBImg);
        }
        if (!StringsKt.isBlank(eventLogo2)) {
            $this$generateMatchCardUrl_u24lambda_u241.append("&eventLogo=" + eventLogo2);
        }
        if (!StringsKt.isBlank(time)) {
            $this$generateMatchCardUrl_u24lambda_u241.append("&time=" + time);
        }
        $this$generateMatchCardUrl_u24lambda_u241.append("&isLive=" + isLive);
        $this$generateMatchCardUrl_u24lambda_u241.append("&isEnded=" + isEnded);
        return $this$generateMatchCardUrl_u24lambda_u241.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:108:0x025e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:44:0x0115  */
    /* JADX WARN: Code duplicated, block: B:47:0x0141  */
    /* JADX WARN: Code duplicated, block: B:50:0x014a  */
    /* JADX WARN: Code duplicated, block: B:51:0x014d  */
    /* JADX WARN: Code duplicated, block: B:54:0x0156  */
    /* JADX WARN: Code duplicated, block: B:55:0x0159  */
    /* JADX WARN: Code duplicated, block: B:58:0x0162  */
    /* JADX WARN: Code duplicated, block: B:59:0x0165  */
    /* JADX WARN: Code duplicated, block: B:62:0x016e  */
    /* JADX WARN: Code duplicated, block: B:63:0x0171  */
    /* JADX WARN: Code duplicated, block: B:66:0x017a  */
    /* JADX WARN: Code duplicated, block: B:67:0x017d  */
    /* JADX WARN: Code duplicated, block: B:70:0x0186  */
    /* JADX WARN: Code duplicated, block: B:71:0x0189  */
    /* JADX WARN: Code duplicated, block: B:74:0x0192  */
    /* JADX WARN: Code duplicated, block: B:75:0x0195  */
    /* JADX WARN: Code duplicated, block: B:79:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:81:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:82:0x0212  */
    /* JADX WARN: Code duplicated, block: B:85:0x0226  */
    /* JADX WARN: Code duplicated, block: B:87:0x022e  */
    /* JADX WARN: Code duplicated, block: B:91:0x0237  */
    /* JADX WARN: Code duplicated, block: B:93:0x023a  */
    /* JADX WARN: Code duplicated, block: B:94:0x0241  */
    /* JADX WARN: Code duplicated, block: B:97:0x025a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws UnsupportedEncodingException {
        C00081 c00081;
        Object objFetchLiveEvents;
        MainPageRequest request2;
        Object objFetchCustomEvents;
        List events;
        Map groupedEvents;
        Map $this$map$iv;
        Collection destination$iv$iv;
        String lowerCase;
        String icon;
        Iterable $this$map$iv2;
        Collection destination$iv$iv2;
        Iterable $this$mapTo$iv$iv;
        Iterator it;
        Iterable $this$map$iv3;
        LiveEventData event;
        String displayTitle;
        String status;
        String status2;
        String posterUrl;
        List<LiveEventFormat> formats;
        String image;
        boolean z;
        LiveEventInfo eventInfo;
        String str;
        Object value$iv$iv$iv;
        Object answer$iv$iv$iv;
        int page2 = page;
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
                DonationManager.INSTANCE.checkAndShow(getName());
                if (this.customCatLink == null) {
                    ProviderManager providerManager = ProviderManager.INSTANCE;
                    c00081.L$0 = SpillingKt.nullOutSpilledVariable(request);
                    c00081.I$0 = page2;
                    c00081.label = 2;
                    objFetchLiveEvents = providerManager.fetchLiveEvents(c00081);
                    if (objFetchLiveEvents == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    request2 = request;
                    events = (List) objFetchLiveEvents;
                    List $this$groupBy$iv = events;
                    groupedEvents = new LinkedHashMap();
                    for (Object element$iv$iv : $this$groupBy$iv) {
                        LiveEventData it2 = (LiveEventData) element$iv$iv;
                        eventInfo = it2.getEventInfo();
                        String cat = eventInfo != null ? "Other" : "Other";
                        str = cat;
                        value$iv$iv$iv = groupedEvents.get(str);
                        if (value$iv$iv$iv == null) {
                            Object answer$iv$iv$iv2 = (List) new ArrayList();
                            answer$iv$iv$iv = answer$iv$iv$iv2;
                            groupedEvents.put(str, answer$iv$iv$iv);
                        } else {
                            answer$iv$iv$iv = value$iv$iv$iv;
                        }
                        List list$iv$iv = (List) answer$iv$iv$iv;
                        list$iv$iv.add(element$iv$iv);
                        page2 = page2;
                    }
                    $this$map$iv = groupedEvents;
                    destination$iv$iv = new ArrayList($this$map$iv.size());
                    for (Map.Entry item$iv$iv : $this$map$iv.entrySet()) {
                        String category = (String) item$iv$iv.getKey();
                        List categoryEvents = (List) item$iv$iv.getValue();
                        Map $this$map$iv4 = $this$map$iv;
                        lowerCase = category.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        switch (lowerCase) {
                            case "boxing":
                                icon = "🥊";
                                break;
                            case "tennis":
                                icon = "🎾";
                                break;
                            case "ice hockey":
                                icon = "🏒";
                                break;
                            case "football":
                                icon = "⚽";
                                break;
                            case "motorsport":
                                icon = "🏎️";
                                break;
                            case "basketball":
                                icon = "🏀";
                                break;
                            case "cricket":
                                icon = "🏏";
                                break;
                            default:
                                icon = "📺";
                                break;
                        }
                        C00081 c00082 = c00081;
                        final Comparator comparator = new Comparator() { // from class: com.cncverse.LiveEventsProvider$getMainPage$lambda$1$$inlined$compareBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                Integer num;
                                Integer num2;
                                LiveEventData event2 = (LiveEventData) t;
                                String status3 = this.this$0.getEventStatus(event2);
                                if (StringsKt.contains$default(status3, "🔴", false, 2, (Object) null)) {
                                    num = (Comparable) 0;
                                } else if (StringsKt.contains$default(status3, "🔜", false, 2, (Object) null)) {
                                    num = (Comparable) 1;
                                } else {
                                    num = StringsKt.contains$default(status3, "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                                }
                                LiveEventData event3 = (LiveEventData) t2;
                                String status4 = this.this$0.getEventStatus(event3);
                                if (StringsKt.contains$default(status4, "🔴", false, 2, (Object) null)) {
                                    num2 = (Comparable) 0;
                                } else if (StringsKt.contains$default(status4, "🔜", false, 2, (Object) null)) {
                                    num2 = (Comparable) 1;
                                } else {
                                    num2 = StringsKt.contains$default(status4, "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                                }
                                return ComparisonsKt.compareValues(num, num2);
                            }
                        };
                        Object $result2 = $result;
                        $this$map$iv2 = CollectionsKt.sortedWith(categoryEvents, new Comparator() { // from class: com.cncverse.LiveEventsProvider$getMainPage$lambda$1$$inlined$thenBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                Long lValueOf;
                                Long lValueOf2;
                                String startTime;
                                String startTime2;
                                int previousCompare = comparator.compare(t, t2);
                                if (previousCompare != 0) {
                                    return previousCompare;
                                }
                                LiveEventData event2 = (LiveEventData) t;
                                try {
                                    LiveEventInfo info = event2.getEventInfo();
                                    if (info == null || (startTime2 = info.getStartTime()) == null) {
                                        lValueOf = (Comparable) Long.MAX_VALUE;
                                    } else {
                                        SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                        Date date = fmt.parse(startTime2);
                                        lValueOf = Long.valueOf(date != null ? date.getTime() : Long.MAX_VALUE);
                                    }
                                } catch (Exception e) {
                                    lValueOf = (Comparable) Long.MAX_VALUE;
                                }
                                LiveEventData event3 = (LiveEventData) t2;
                                try {
                                    LiveEventInfo info2 = event3.getEventInfo();
                                    if (info2 == null || (startTime = info2.getStartTime()) == null) {
                                        lValueOf2 = (Comparable) Long.MAX_VALUE;
                                    } else {
                                        SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                        Date date2 = fmt2.parse(startTime);
                                        lValueOf2 = Long.valueOf(date2 != null ? date2.getTime() : Long.MAX_VALUE);
                                    }
                                } catch (Exception e2) {
                                    lValueOf2 = (Comparable) Long.MAX_VALUE;
                                }
                                return ComparisonsKt.compareValues(lValueOf, lValueOf2);
                            }
                        });
                        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                        $this$mapTo$iv$iv = $this$map$iv2;
                        it = $this$mapTo$iv$iv.iterator();
                        while (true) {
                            $this$map$iv3 = $this$map$iv2;
                            if (it.hasNext()) {
                                event = (LiveEventData) it.next();
                                Iterable $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                                displayTitle = createDisplayTitle(event);
                                MainPageRequest request3 = request2;
                                status = getEventStatus(event);
                                if (StringsKt.isBlank(status)) {
                                    status2 = displayTitle;
                                } else {
                                    status2 = status + ' ' + displayTitle;
                                }
                                String fullTitle = status2;
                                if (Intrinsics.areEqual(event.getCat(), "Custom")) {
                                    image = event.getImage();
                                    if (image != null) {
                                        z = true;
                                    } else {
                                        z = true;
                                    }
                                    if (z) {
                                        posterUrl = generateMatchCardUrl(event);
                                    } else {
                                        posterUrl = event.getImage();
                                    }
                                } else {
                                    posterUrl = generateMatchCardUrl(event);
                                }
                                int id = event.getId();
                                String slug = event.getSlug();
                                formats = event.getFormats();
                                if (formats == null) {
                                    formats = CollectionsKt.emptyList();
                                }
                                LiveEventLoadData loadData = new LiveEventLoadData(id, displayTitle, posterUrl, slug, formats, event.getEventInfo());
                                final String posterUrl2 = posterUrl;
                                destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle, AppUtils.INSTANCE.toJson(loadData), TvType.Live, false, new Function1() { // from class: com.cncverse.LiveEventsProvider$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj) {
                                        return LiveEventsProvider.getMainPage$lambda$1$2$0(posterUrl2, (LiveSearchResponse) obj);
                                    }
                                }, 8, (Object) null));
                                $this$map$iv2 = $this$map$iv3;
                                $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                                request2 = request3;
                                events = events;
                            }
                        }
                        List searchResponses = (List) destination$iv$iv2;
                        destination$iv$iv.add(new HomePageList(icon + ' ' + category, searchResponses, true));
                        $this$map$iv = $this$map$iv4;
                        c00081 = c00082;
                        $result = $result2;
                        request2 = request2;
                    }
                    Iterable $this$sortedBy$iv = (List) destination$iv$iv;
                    List homePageLists = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: com.cncverse.LiveEventsProvider$getMainPage$$inlined$sortedBy$1
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            int i;
                            HomePageList list = (HomePageList) t;
                            int i2 = 1;
                            if (StringsKt.contains(list.getName(), "Cricket", true)) {
                                i = 0;
                            } else if (StringsKt.contains(list.getName(), "Football", true)) {
                                i = 1;
                            } else {
                                i = StringsKt.contains(list.getName(), "Basketball", true) ? 2 : 10;
                            }
                            Integer numValueOf = Integer.valueOf(i);
                            HomePageList list2 = (HomePageList) t2;
                            if (StringsKt.contains(list2.getName(), "Cricket", true)) {
                                i2 = 0;
                            } else if (!StringsKt.contains(list2.getName(), "Football", true)) {
                                i2 = StringsKt.contains(list2.getName(), "Basketball", true) ? 2 : 10;
                            }
                            return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(i2));
                        }
                    });
                    return MainAPIKt.newHomePageResponse(homePageLists, Boxing.boxBoolean(false));
                }
                ProviderManager providerManager2 = ProviderManager.INSTANCE;
                String str2 = this.customCatLink;
                c00081.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00081.I$0 = page2;
                c00081.label = 1;
                objFetchCustomEvents = providerManager2.fetchCustomEvents(str2, c00081);
                if (objFetchCustomEvents == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                events = (List) objFetchCustomEvents;
                List $this$groupBy$iv2 = events;
                groupedEvents = new LinkedHashMap();
                while (r13.hasNext()) {
                    LiveEventData it3 = (LiveEventData) element$iv$iv;
                    eventInfo = it3.getEventInfo();
                    if ((eventInfo != null || (cat = eventInfo.getEventCat()) == null) && (cat = it3.getCat()) == null) {
                    }
                    str = cat;
                    value$iv$iv$iv = groupedEvents.get(str);
                    if (value$iv$iv$iv == null) {
                        Object answer$iv$iv$iv3 = (List) new ArrayList();
                        answer$iv$iv$iv = answer$iv$iv$iv3;
                        groupedEvents.put(str, answer$iv$iv$iv);
                    } else {
                        answer$iv$iv$iv = value$iv$iv$iv;
                    }
                    List list$iv$iv2 = (List) answer$iv$iv$iv;
                    list$iv$iv2.add(element$iv$iv);
                    page2 = page2;
                }
                $this$map$iv = groupedEvents;
                destination$iv$iv = new ArrayList($this$map$iv.size());
                while (r12.hasNext()) {
                    String category2 = (String) item$iv$iv.getKey();
                    List categoryEvents2 = (List) item$iv$iv.getValue();
                    Map $this$map$iv5 = $this$map$iv;
                    lowerCase = category2.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    switch (lowerCase) {
                        case -1383120329:
                            if (!lowerCase.equals("boxing")) {
                                icon = "📺";
                            } else {
                                icon = "🥊";
                            }
                            break;
                        case -877324069:
                            if (!lowerCase.equals("tennis")) {
                                icon = "📺";
                            } else {
                                icon = "🎾";
                            }
                            break;
                        case -654884904:
                            if (!lowerCase.equals("ice hockey")) {
                                icon = "📺";
                            } else {
                                icon = "🏒";
                            }
                            break;
                        case 394668909:
                            if (!lowerCase.equals("football")) {
                                icon = "📺";
                            } else {
                                icon = "⚽";
                            }
                            break;
                        case 400486431:
                            if (!lowerCase.equals("motorsport")) {
                                icon = "📺";
                            } else {
                                icon = "🏎️";
                            }
                            break;
                        case 727149765:
                            if (!lowerCase.equals("basketball")) {
                                icon = "📺";
                            } else {
                                icon = "🏀";
                            }
                            break;
                        case 1032299505:
                            if (!lowerCase.equals("cricket")) {
                                icon = "📺";
                            } else {
                                icon = "🏏";
                            }
                            break;
                        default:
                            icon = "📺";
                            break;
                    }
                    C00081 c00083 = c00081;
                    final Comparator comparator2 = new Comparator() { // from class: com.cncverse.LiveEventsProvider$getMainPage$lambda$1$$inlined$compareBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Integer num;
                            Integer num2;
                            LiveEventData event2 = (LiveEventData) t;
                            String status3 = this.this$0.getEventStatus(event2);
                            if (StringsKt.contains$default(status3, "🔴", false, 2, (Object) null)) {
                                num = (Comparable) 0;
                            } else if (StringsKt.contains$default(status3, "🔜", false, 2, (Object) null)) {
                                num = (Comparable) 1;
                            } else {
                                num = StringsKt.contains$default(status3, "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                            }
                            LiveEventData event3 = (LiveEventData) t2;
                            String status4 = this.this$0.getEventStatus(event3);
                            if (StringsKt.contains$default(status4, "🔴", false, 2, (Object) null)) {
                                num2 = (Comparable) 0;
                            } else if (StringsKt.contains$default(status4, "🔜", false, 2, (Object) null)) {
                                num2 = (Comparable) 1;
                            } else {
                                num2 = StringsKt.contains$default(status4, "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                            }
                            return ComparisonsKt.compareValues(num, num2);
                        }
                    };
                    Object $result3 = $result;
                    $this$map$iv2 = CollectionsKt.sortedWith(categoryEvents2, new Comparator() { // from class: com.cncverse.LiveEventsProvider$getMainPage$lambda$1$$inlined$thenBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Long lValueOf;
                            Long lValueOf2;
                            String startTime;
                            String startTime2;
                            int previousCompare = comparator2.compare(t, t2);
                            if (previousCompare != 0) {
                                return previousCompare;
                            }
                            LiveEventData event2 = (LiveEventData) t;
                            try {
                                LiveEventInfo info = event2.getEventInfo();
                                if (info == null || (startTime2 = info.getStartTime()) == null) {
                                    lValueOf = (Comparable) Long.MAX_VALUE;
                                } else {
                                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                    Date date = fmt.parse(startTime2);
                                    lValueOf = Long.valueOf(date != null ? date.getTime() : Long.MAX_VALUE);
                                }
                            } catch (Exception e) {
                                lValueOf = (Comparable) Long.MAX_VALUE;
                            }
                            LiveEventData event3 = (LiveEventData) t2;
                            try {
                                LiveEventInfo info2 = event3.getEventInfo();
                                if (info2 == null || (startTime = info2.getStartTime()) == null) {
                                    lValueOf2 = (Comparable) Long.MAX_VALUE;
                                } else {
                                    SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                    Date date2 = fmt2.parse(startTime);
                                    lValueOf2 = Long.valueOf(date2 != null ? date2.getTime() : Long.MAX_VALUE);
                                }
                            } catch (Exception e2) {
                                lValueOf2 = (Comparable) Long.MAX_VALUE;
                            }
                            return ComparisonsKt.compareValues(lValueOf, lValueOf2);
                        }
                    });
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    $this$mapTo$iv$iv = $this$map$iv2;
                    it = $this$mapTo$iv$iv.iterator();
                    while (true) {
                        $this$map$iv3 = $this$map$iv2;
                        if (it.hasNext()) {
                            event = (LiveEventData) it.next();
                            Iterable $this$mapTo$iv$iv3 = $this$mapTo$iv$iv;
                            displayTitle = createDisplayTitle(event);
                            MainPageRequest request4 = request2;
                            status = getEventStatus(event);
                            if (StringsKt.isBlank(status)) {
                                status2 = status + ' ' + displayTitle;
                            } else {
                                status2 = displayTitle;
                            }
                            String fullTitle2 = status2;
                            if (Intrinsics.areEqual(event.getCat(), "Custom")) {
                                posterUrl = generateMatchCardUrl(event);
                            } else {
                                image = event.getImage();
                                if (image != null || StringsKt.isBlank(image)) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    posterUrl = event.getImage();
                                } else {
                                    posterUrl = generateMatchCardUrl(event);
                                }
                            }
                            int id2 = event.getId();
                            String slug2 = event.getSlug();
                            formats = event.getFormats();
                            if (formats == null) {
                                formats = CollectionsKt.emptyList();
                            }
                            LiveEventLoadData loadData2 = new LiveEventLoadData(id2, displayTitle, posterUrl, slug2, formats, event.getEventInfo());
                            final String posterUrl3 = posterUrl;
                            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle2, AppUtils.INSTANCE.toJson(loadData2), TvType.Live, false, new Function1() { // from class: com.cncverse.LiveEventsProvider$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    return LiveEventsProvider.getMainPage$lambda$1$2$0(posterUrl3, (LiveSearchResponse) obj);
                                }
                            }, 8, (Object) null));
                            $this$map$iv2 = $this$map$iv3;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv3;
                            request2 = request4;
                            events = events;
                        }
                    }
                    List searchResponses2 = (List) destination$iv$iv2;
                    destination$iv$iv.add(new HomePageList(icon + ' ' + category2, searchResponses2, true));
                    $this$map$iv = $this$map$iv5;
                    c00081 = c00083;
                    $result = $result3;
                    request2 = request2;
                }
                Iterable $this$sortedBy$iv2 = (List) destination$iv$iv;
                List homePageLists2 = CollectionsKt.sortedWith($this$sortedBy$iv2, new Comparator() { // from class: com.cncverse.LiveEventsProvider$getMainPage$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int i;
                        HomePageList list = (HomePageList) t;
                        int i2 = 1;
                        if (StringsKt.contains(list.getName(), "Cricket", true)) {
                            i = 0;
                        } else if (StringsKt.contains(list.getName(), "Football", true)) {
                            i = 1;
                        } else {
                            i = StringsKt.contains(list.getName(), "Basketball", true) ? 2 : 10;
                        }
                        Integer numValueOf = Integer.valueOf(i);
                        HomePageList list2 = (HomePageList) t2;
                        if (StringsKt.contains(list2.getName(), "Cricket", true)) {
                            i2 = 0;
                        } else if (!StringsKt.contains(list2.getName(), "Football", true)) {
                            i2 = StringsKt.contains(list2.getName(), "Basketball", true) ? 2 : 10;
                        }
                        return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(i2));
                    }
                });
                return MainAPIKt.newHomePageResponse(homePageLists2, Boxing.boxBoolean(false));
            case 1:
                page2 = c00081.I$0;
                request2 = (MainPageRequest) c00081.L$0;
                ResultKt.throwOnFailure($result);
                objFetchCustomEvents = $result;
                events = (List) objFetchCustomEvents;
                List $this$groupBy$iv3 = events;
                groupedEvents = new LinkedHashMap();
                while (r13.hasNext()) {
                    LiveEventData it4 = (LiveEventData) element$iv$iv;
                    eventInfo = it4.getEventInfo();
                    if (eventInfo != null) {
                    }
                    str = cat;
                    value$iv$iv$iv = groupedEvents.get(str);
                    if (value$iv$iv$iv == null) {
                        Object answer$iv$iv$iv4 = (List) new ArrayList();
                        answer$iv$iv$iv = answer$iv$iv$iv4;
                        groupedEvents.put(str, answer$iv$iv$iv);
                    } else {
                        answer$iv$iv$iv = value$iv$iv$iv;
                    }
                    List list$iv$iv3 = (List) answer$iv$iv$iv;
                    list$iv$iv3.add(element$iv$iv);
                    page2 = page2;
                }
                $this$map$iv = groupedEvents;
                destination$iv$iv = new ArrayList($this$map$iv.size());
                while (r12.hasNext()) {
                    String category3 = (String) item$iv$iv.getKey();
                    List categoryEvents3 = (List) item$iv$iv.getValue();
                    Map $this$map$iv6 = $this$map$iv;
                    lowerCase = category3.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    switch (lowerCase) {
                        case -1383120329:
                            if (!lowerCase.equals("boxing")) {
                                icon = "📺";
                            } else {
                                icon = "🥊";
                            }
                            break;
                        case -877324069:
                            if (!lowerCase.equals("tennis")) {
                                icon = "📺";
                            } else {
                                icon = "🎾";
                            }
                            break;
                        case -654884904:
                            if (!lowerCase.equals("ice hockey")) {
                                icon = "📺";
                            } else {
                                icon = "🏒";
                            }
                            break;
                        case 394668909:
                            if (!lowerCase.equals("football")) {
                                icon = "📺";
                            } else {
                                icon = "⚽";
                            }
                            break;
                        case 400486431:
                            if (!lowerCase.equals("motorsport")) {
                                icon = "📺";
                            } else {
                                icon = "🏎️";
                            }
                            break;
                        case 727149765:
                            if (!lowerCase.equals("basketball")) {
                                icon = "📺";
                            } else {
                                icon = "🏀";
                            }
                            break;
                        case 1032299505:
                            if (!lowerCase.equals("cricket")) {
                                icon = "📺";
                            } else {
                                icon = "🏏";
                            }
                            break;
                        default:
                            icon = "📺";
                            break;
                    }
                    C00081 c00084 = c00081;
                    final Comparator comparator3 = new Comparator() { // from class: com.cncverse.LiveEventsProvider$getMainPage$lambda$1$$inlined$compareBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Integer num;
                            Integer num2;
                            LiveEventData event2 = (LiveEventData) t;
                            String status3 = this.this$0.getEventStatus(event2);
                            if (StringsKt.contains$default(status3, "🔴", false, 2, (Object) null)) {
                                num = (Comparable) 0;
                            } else if (StringsKt.contains$default(status3, "🔜", false, 2, (Object) null)) {
                                num = (Comparable) 1;
                            } else {
                                num = StringsKt.contains$default(status3, "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                            }
                            LiveEventData event3 = (LiveEventData) t2;
                            String status4 = this.this$0.getEventStatus(event3);
                            if (StringsKt.contains$default(status4, "🔴", false, 2, (Object) null)) {
                                num2 = (Comparable) 0;
                            } else if (StringsKt.contains$default(status4, "🔜", false, 2, (Object) null)) {
                                num2 = (Comparable) 1;
                            } else {
                                num2 = StringsKt.contains$default(status4, "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                            }
                            return ComparisonsKt.compareValues(num, num2);
                        }
                    };
                    Object $result4 = $result;
                    $this$map$iv2 = CollectionsKt.sortedWith(categoryEvents3, new Comparator() { // from class: com.cncverse.LiveEventsProvider$getMainPage$lambda$1$$inlined$thenBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Long lValueOf;
                            Long lValueOf2;
                            String startTime;
                            String startTime2;
                            int previousCompare = comparator3.compare(t, t2);
                            if (previousCompare != 0) {
                                return previousCompare;
                            }
                            LiveEventData event2 = (LiveEventData) t;
                            try {
                                LiveEventInfo info = event2.getEventInfo();
                                if (info == null || (startTime2 = info.getStartTime()) == null) {
                                    lValueOf = (Comparable) Long.MAX_VALUE;
                                } else {
                                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                    Date date = fmt.parse(startTime2);
                                    lValueOf = Long.valueOf(date != null ? date.getTime() : Long.MAX_VALUE);
                                }
                            } catch (Exception e) {
                                lValueOf = (Comparable) Long.MAX_VALUE;
                            }
                            LiveEventData event3 = (LiveEventData) t2;
                            try {
                                LiveEventInfo info2 = event3.getEventInfo();
                                if (info2 == null || (startTime = info2.getStartTime()) == null) {
                                    lValueOf2 = (Comparable) Long.MAX_VALUE;
                                } else {
                                    SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                    Date date2 = fmt2.parse(startTime);
                                    lValueOf2 = Long.valueOf(date2 != null ? date2.getTime() : Long.MAX_VALUE);
                                }
                            } catch (Exception e2) {
                                lValueOf2 = (Comparable) Long.MAX_VALUE;
                            }
                            return ComparisonsKt.compareValues(lValueOf, lValueOf2);
                        }
                    });
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    $this$mapTo$iv$iv = $this$map$iv2;
                    it = $this$mapTo$iv$iv.iterator();
                    while (true) {
                        $this$map$iv3 = $this$map$iv2;
                        if (it.hasNext()) {
                            event = (LiveEventData) it.next();
                            Iterable $this$mapTo$iv$iv4 = $this$mapTo$iv$iv;
                            displayTitle = createDisplayTitle(event);
                            MainPageRequest request5 = request2;
                            status = getEventStatus(event);
                            if (StringsKt.isBlank(status)) {
                                status2 = status + ' ' + displayTitle;
                            } else {
                                status2 = displayTitle;
                            }
                            String fullTitle3 = status2;
                            if (Intrinsics.areEqual(event.getCat(), "Custom")) {
                                posterUrl = generateMatchCardUrl(event);
                            } else {
                                image = event.getImage();
                                if (image != null) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    posterUrl = event.getImage();
                                } else {
                                    posterUrl = generateMatchCardUrl(event);
                                }
                            }
                            int id3 = event.getId();
                            String slug3 = event.getSlug();
                            formats = event.getFormats();
                            if (formats == null) {
                                formats = CollectionsKt.emptyList();
                            }
                            LiveEventLoadData loadData3 = new LiveEventLoadData(id3, displayTitle, posterUrl, slug3, formats, event.getEventInfo());
                            final String posterUrl4 = posterUrl;
                            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle3, AppUtils.INSTANCE.toJson(loadData3), TvType.Live, false, new Function1() { // from class: com.cncverse.LiveEventsProvider$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    return LiveEventsProvider.getMainPage$lambda$1$2$0(posterUrl4, (LiveSearchResponse) obj);
                                }
                            }, 8, (Object) null));
                            $this$map$iv2 = $this$map$iv3;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv4;
                            request2 = request5;
                            events = events;
                        }
                    }
                    List searchResponses3 = (List) destination$iv$iv2;
                    destination$iv$iv.add(new HomePageList(icon + ' ' + category3, searchResponses3, true));
                    $this$map$iv = $this$map$iv6;
                    c00081 = c00084;
                    $result = $result4;
                    request2 = request2;
                }
                Iterable $this$sortedBy$iv3 = (List) destination$iv$iv;
                List homePageLists3 = CollectionsKt.sortedWith($this$sortedBy$iv3, new Comparator() { // from class: com.cncverse.LiveEventsProvider$getMainPage$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int i;
                        HomePageList list = (HomePageList) t;
                        int i2 = 1;
                        if (StringsKt.contains(list.getName(), "Cricket", true)) {
                            i = 0;
                        } else if (StringsKt.contains(list.getName(), "Football", true)) {
                            i = 1;
                        } else {
                            i = StringsKt.contains(list.getName(), "Basketball", true) ? 2 : 10;
                        }
                        Integer numValueOf = Integer.valueOf(i);
                        HomePageList list2 = (HomePageList) t2;
                        if (StringsKt.contains(list2.getName(), "Cricket", true)) {
                            i2 = 0;
                        } else if (!StringsKt.contains(list2.getName(), "Football", true)) {
                            i2 = StringsKt.contains(list2.getName(), "Basketball", true) ? 2 : 10;
                        }
                        return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(i2));
                    }
                });
                return MainAPIKt.newHomePageResponse(homePageLists3, Boxing.boxBoolean(false));
            case 2:
                page2 = c00081.I$0;
                request2 = (MainPageRequest) c00081.L$0;
                ResultKt.throwOnFailure($result);
                objFetchLiveEvents = $result;
                events = (List) objFetchLiveEvents;
                List $this$groupBy$iv4 = events;
                groupedEvents = new LinkedHashMap();
                while (r13.hasNext()) {
                    LiveEventData it5 = (LiveEventData) element$iv$iv;
                    eventInfo = it5.getEventInfo();
                    if (eventInfo != null) {
                    }
                    str = cat;
                    value$iv$iv$iv = groupedEvents.get(str);
                    if (value$iv$iv$iv == null) {
                        Object answer$iv$iv$iv5 = (List) new ArrayList();
                        answer$iv$iv$iv = answer$iv$iv$iv5;
                        groupedEvents.put(str, answer$iv$iv$iv);
                    } else {
                        answer$iv$iv$iv = value$iv$iv$iv;
                    }
                    List list$iv$iv4 = (List) answer$iv$iv$iv;
                    list$iv$iv4.add(element$iv$iv);
                    page2 = page2;
                }
                $this$map$iv = groupedEvents;
                destination$iv$iv = new ArrayList($this$map$iv.size());
                while (r12.hasNext()) {
                    String category4 = (String) item$iv$iv.getKey();
                    List categoryEvents4 = (List) item$iv$iv.getValue();
                    Map $this$map$iv7 = $this$map$iv;
                    lowerCase = category4.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    switch (lowerCase) {
                        case -1383120329:
                            if (!lowerCase.equals("boxing")) {
                                icon = "📺";
                            } else {
                                icon = "🥊";
                            }
                            break;
                        case -877324069:
                            if (!lowerCase.equals("tennis")) {
                                icon = "📺";
                            } else {
                                icon = "🎾";
                            }
                            break;
                        case -654884904:
                            if (!lowerCase.equals("ice hockey")) {
                                icon = "📺";
                            } else {
                                icon = "🏒";
                            }
                            break;
                        case 394668909:
                            if (!lowerCase.equals("football")) {
                                icon = "📺";
                            } else {
                                icon = "⚽";
                            }
                            break;
                        case 400486431:
                            if (!lowerCase.equals("motorsport")) {
                                icon = "📺";
                            } else {
                                icon = "🏎️";
                            }
                            break;
                        case 727149765:
                            if (!lowerCase.equals("basketball")) {
                                icon = "📺";
                            } else {
                                icon = "🏀";
                            }
                            break;
                        case 1032299505:
                            if (!lowerCase.equals("cricket")) {
                                icon = "📺";
                            } else {
                                icon = "🏏";
                            }
                            break;
                        default:
                            icon = "📺";
                            break;
                    }
                    C00081 c00085 = c00081;
                    final Comparator comparator4 = new Comparator() { // from class: com.cncverse.LiveEventsProvider$getMainPage$lambda$1$$inlined$compareBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Integer num;
                            Integer num2;
                            LiveEventData event2 = (LiveEventData) t;
                            String status3 = this.this$0.getEventStatus(event2);
                            if (StringsKt.contains$default(status3, "🔴", false, 2, (Object) null)) {
                                num = (Comparable) 0;
                            } else if (StringsKt.contains$default(status3, "🔜", false, 2, (Object) null)) {
                                num = (Comparable) 1;
                            } else {
                                num = StringsKt.contains$default(status3, "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                            }
                            LiveEventData event3 = (LiveEventData) t2;
                            String status4 = this.this$0.getEventStatus(event3);
                            if (StringsKt.contains$default(status4, "🔴", false, 2, (Object) null)) {
                                num2 = (Comparable) 0;
                            } else if (StringsKt.contains$default(status4, "🔜", false, 2, (Object) null)) {
                                num2 = (Comparable) 1;
                            } else {
                                num2 = StringsKt.contains$default(status4, "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                            }
                            return ComparisonsKt.compareValues(num, num2);
                        }
                    };
                    Object $result5 = $result;
                    $this$map$iv2 = CollectionsKt.sortedWith(categoryEvents4, new Comparator() { // from class: com.cncverse.LiveEventsProvider$getMainPage$lambda$1$$inlined$thenBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Long lValueOf;
                            Long lValueOf2;
                            String startTime;
                            String startTime2;
                            int previousCompare = comparator4.compare(t, t2);
                            if (previousCompare != 0) {
                                return previousCompare;
                            }
                            LiveEventData event2 = (LiveEventData) t;
                            try {
                                LiveEventInfo info = event2.getEventInfo();
                                if (info == null || (startTime2 = info.getStartTime()) == null) {
                                    lValueOf = (Comparable) Long.MAX_VALUE;
                                } else {
                                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                    Date date = fmt.parse(startTime2);
                                    lValueOf = Long.valueOf(date != null ? date.getTime() : Long.MAX_VALUE);
                                }
                            } catch (Exception e) {
                                lValueOf = (Comparable) Long.MAX_VALUE;
                            }
                            LiveEventData event3 = (LiveEventData) t2;
                            try {
                                LiveEventInfo info2 = event3.getEventInfo();
                                if (info2 == null || (startTime = info2.getStartTime()) == null) {
                                    lValueOf2 = (Comparable) Long.MAX_VALUE;
                                } else {
                                    SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                    Date date2 = fmt2.parse(startTime);
                                    lValueOf2 = Long.valueOf(date2 != null ? date2.getTime() : Long.MAX_VALUE);
                                }
                            } catch (Exception e2) {
                                lValueOf2 = (Comparable) Long.MAX_VALUE;
                            }
                            return ComparisonsKt.compareValues(lValueOf, lValueOf2);
                        }
                    });
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    $this$mapTo$iv$iv = $this$map$iv2;
                    it = $this$mapTo$iv$iv.iterator();
                    while (true) {
                        $this$map$iv3 = $this$map$iv2;
                        if (it.hasNext()) {
                            event = (LiveEventData) it.next();
                            Iterable $this$mapTo$iv$iv5 = $this$mapTo$iv$iv;
                            displayTitle = createDisplayTitle(event);
                            MainPageRequest request6 = request2;
                            status = getEventStatus(event);
                            if (StringsKt.isBlank(status)) {
                                status2 = status + ' ' + displayTitle;
                            } else {
                                status2 = displayTitle;
                            }
                            String fullTitle4 = status2;
                            if (Intrinsics.areEqual(event.getCat(), "Custom")) {
                                posterUrl = generateMatchCardUrl(event);
                            } else {
                                image = event.getImage();
                                if (image != null) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    posterUrl = event.getImage();
                                } else {
                                    posterUrl = generateMatchCardUrl(event);
                                }
                            }
                            int id4 = event.getId();
                            String slug4 = event.getSlug();
                            formats = event.getFormats();
                            if (formats == null) {
                                formats = CollectionsKt.emptyList();
                            }
                            LiveEventLoadData loadData4 = new LiveEventLoadData(id4, displayTitle, posterUrl, slug4, formats, event.getEventInfo());
                            final String posterUrl5 = posterUrl;
                            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle4, AppUtils.INSTANCE.toJson(loadData4), TvType.Live, false, new Function1() { // from class: com.cncverse.LiveEventsProvider$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    return LiveEventsProvider.getMainPage$lambda$1$2$0(posterUrl5, (LiveSearchResponse) obj);
                                }
                            }, 8, (Object) null));
                            $this$map$iv2 = $this$map$iv3;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv5;
                            request2 = request6;
                            events = events;
                        }
                    }
                    List searchResponses4 = (List) destination$iv$iv2;
                    destination$iv$iv.add(new HomePageList(icon + ' ' + category4, searchResponses4, true));
                    $this$map$iv = $this$map$iv7;
                    c00081 = c00085;
                    $result = $result5;
                    request2 = request2;
                }
                Iterable $this$sortedBy$iv4 = (List) destination$iv$iv;
                List homePageLists4 = CollectionsKt.sortedWith($this$sortedBy$iv4, new Comparator() { // from class: com.cncverse.LiveEventsProvider$getMainPage$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int i;
                        HomePageList list = (HomePageList) t;
                        int i2 = 1;
                        if (StringsKt.contains(list.getName(), "Cricket", true)) {
                            i = 0;
                        } else if (StringsKt.contains(list.getName(), "Football", true)) {
                            i = 1;
                        } else {
                            i = StringsKt.contains(list.getName(), "Basketball", true) ? 2 : 10;
                        }
                        Integer numValueOf = Integer.valueOf(i);
                        HomePageList list2 = (HomePageList) t2;
                        if (StringsKt.contains(list2.getName(), "Cricket", true)) {
                            i2 = 0;
                        } else if (!StringsKt.contains(list2.getName(), "Football", true)) {
                            i2 = StringsKt.contains(list2.getName(), "Basketball", true) ? 2 : 10;
                        }
                        return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(i2));
                    }
                });
                return MainAPIKt.newHomePageResponse(homePageLists4, Boxing.boxBoolean(false));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$1$2$0(String $posterUrl, LiveSearchResponse $this$newLiveSearchResponse) {
        $this$newLiveSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws UnsupportedEncodingException {
        C00241 c00241;
        Object objFetchLiveEvents;
        String query2;
        LiveEventsProvider liveEventsProvider = this;
        if (continuation instanceof C00241) {
            c00241 = (C00241) continuation;
            if ((c00241.label & Integer.MIN_VALUE) != 0) {
                c00241.label -= Integer.MIN_VALUE;
            } else {
                c00241 = liveEventsProvider.new C00241(continuation);
            }
        } else {
            c00241 = liveEventsProvider.new C00241(continuation);
        }
        Object $result = c00241.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00241.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ProviderManager providerManager = ProviderManager.INSTANCE;
                c00241.L$0 = query;
                c00241.label = 1;
                objFetchLiveEvents = providerManager.fetchLiveEvents(c00241);
                if (objFetchLiveEvents == coroutine_suspended) {
                    return coroutine_suspended;
                }
                query2 = query;
                break;
                break;
            case 1:
                query2 = (String) c00241.L$0;
                ResultKt.throwOnFailure($result);
                objFetchLiveEvents = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable events = (List) objFetchLiveEvents;
        Iterable $this$filter$iv = events;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            LiveEventData event = (LiveEventData) element$iv$iv;
            String title = event.getTitle();
            LiveEventInfo eventInfo = event.getEventInfo();
            String teamA = eventInfo != null ? eventInfo.getTeamA() : null;
            LiveEventInfo eventInfo2 = event.getEventInfo();
            String teamB = eventInfo2 != null ? eventInfo2.getTeamB() : null;
            LiveEventInfo eventInfo3 = event.getEventInfo();
            String eventName = eventInfo3 != null ? eventInfo3.getEventName() : null;
            LiveEventInfo eventInfo4 = event.getEventInfo();
            String query3 = query2;
            String searchText = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{title, teamA, teamB, eventName, eventInfo4 != null ? eventInfo4.getEventType() : null}), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            if (StringsKt.contains(searchText, query3, true)) {
                destination$iv$iv.add(element$iv$iv);
            }
            query2 = query3;
            c00241 = c00241;
            $result = $result;
        }
        Iterable $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            LiveEventData event2 = (LiveEventData) item$iv$iv;
            String displayTitle = liveEventsProvider.createDisplayTitle(event2);
            String status = liveEventsProvider.getEventStatus(event2);
            String fullTitle = !StringsKt.isBlank(status) ? status + ' ' + displayTitle : displayTitle;
            final String posterUrl = liveEventsProvider.generateMatchCardUrl(event2);
            int id = event2.getId();
            String slug = event2.getSlug();
            List<LiveEventFormat> formats = event2.getFormats();
            if (formats == null) {
                formats = CollectionsKt.emptyList();
            }
            LiveEventLoadData loadData = new LiveEventLoadData(id, displayTitle, posterUrl, slug, formats, event2.getEventInfo());
            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(liveEventsProvider, fullTitle, AppUtils.INSTANCE.toJson(loadData), TvType.Live, false, new Function1() { // from class: com.cncverse.LiveEventsProvider$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return LiveEventsProvider.search$lambda$1$0(posterUrl, (LiveSearchResponse) obj);
                }
            }, 8, (Object) null));
            liveEventsProvider = this;
        }
        return (List) destination$iv$iv2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$1$0(String $posterUrl, LiveSearchResponse $this$newLiveSearchResponse) {
        $this$newLiveSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        Object obj;
        Object objDecodeFromString;
        AppUtils appUtils = AppUtils.INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            KType kTypeTypeOf = Reflection.typeOf(LiveEventLoadData.class);
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            try {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LiveEventLoadData.class), (List) null, 2, (Object) null));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th2));
            }
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        DeserializationStrategy deserializationStrategy = (KSerializer) obj;
        if (deserializationStrategy != null) {
            try {
                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, url);
            } catch (SerializationException e) {
                ArchComponentExtKt.logError(e);
                ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv.readValue(url, new TypeReference<LiveEventLoadData>() { // from class: com.cncverse.LiveEventsProvider$load$$inlined$parseJson$1
                });
            } catch (Throwable th3) {
                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv2.readValue(url, new TypeReference<LiveEventLoadData>() { // from class: com.cncverse.LiveEventsProvider$load$$inlined$parseJson$1
                });
            }
        } else {
            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
            objDecodeFromString = $this$readValue$iv$iv3.readValue(url, new TypeReference<LiveEventLoadData>() { // from class: com.cncverse.LiveEventsProvider$load$$inlined$parseJson$1
            });
        }
        LiveEventLoadData data = (LiveEventLoadData) objDecodeFromString;
        LiveEventInfo eventInfo = data.getEventInfo();
        StringBuilder $this$load_u24lambda_u240 = new StringBuilder();
        if (eventInfo != null) {
            String it = eventInfo.getEventType();
            if (it != null) {
                $this$load_u24lambda_u240.append("📌 " + it + '\n');
            }
            String it2 = eventInfo.getEventName();
            if (it2 != null) {
                $this$load_u24lambda_u240.append("🏆 " + it2 + '\n');
            }
            String it3 = eventInfo.getStartTime();
            if (it3 != null) {
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                    SimpleDateFormat displayFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.US);
                    Date date = dateFormat.parse(it3);
                    if (date != null) {
                        $this$load_u24lambda_u240.append("🕐 " + displayFormat.format(date) + '\n');
                    }
                } catch (Exception e2) {
                    $this$load_u24lambda_u240.append("🕐 " + it3 + '\n');
                }
            }
        }
        $this$load_u24lambda_u240.append("\n📡 Available Servers: " + data.getFormats().size());
        String plot = $this$load_u24lambda_u240.toString();
        return MainAPIKt.newLiveStreamLoadResponse(this, data.getTitle(), url, url, new C00192(data, plot, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LiveEventsProvider$load$2 */
    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/LiveStreamLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LiveEventsProvider$load$2", f = "LiveEventsProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00192 extends SuspendLambda implements Function2<LiveStreamLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ LiveEventLoadData $data;
        final /* synthetic */ String $plot;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00192(LiveEventLoadData liveEventLoadData, String str, Continuation<? super C00192> continuation) {
            super(2, continuation);
            this.$data = liveEventLoadData;
            this.$plot = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00192 = new C00192(this.$data, this.$plot, continuation);
            c00192.L$0 = obj;
            return c00192;
        }

        public final Object invoke(LiveStreamLoadResponse liveStreamLoadResponse, Continuation<? super Unit> continuation) {
            return create(liveStreamLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LiveStreamLoadResponse $this$newLiveStreamLoadResponse = (LiveStreamLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newLiveStreamLoadResponse.setPosterUrl(this.$data.getPoster());
                    $this$newLiveStreamLoadResponse.setPlot(this.$plot);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:108:0x049d  */
    /* JADX WARN: Code duplicated, block: B:124:0x04e7  */
    /* JADX WARN: Code duplicated, block: B:144:0x051b  */
    /* JADX WARN: Code duplicated, block: B:150:0x058e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:151:0x058f  */
    /* JADX WARN: Code duplicated, block: B:154:0x059e  */
    /* JADX WARN: Code duplicated, block: B:155:0x05a8  */
    /* JADX WARN: Code duplicated, block: B:180:0x06c9  */
    /* JADX WARN: Code duplicated, block: B:183:0x06cd A[Catch: Exception -> 0x06a2, TryCatch #18 {Exception -> 0x06a2, blocks: (B:177:0x068b, B:183:0x06cd, B:185:0x06d4, B:186:0x070c, B:188:0x0714, B:189:0x0739, B:190:0x0789, B:192:0x078f, B:193:0x07b6), top: B:329:0x068b }] */
    /* JADX WARN: Code duplicated, block: B:210:0x0966 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:211:0x0967  */
    /* JADX WARN: Code duplicated, block: B:220:0x09fd  */
    /* JADX WARN: Code duplicated, block: B:230:0x0a2f  */
    /* JADX WARN: Code duplicated, block: B:231:0x0a35 A[Catch: Exception -> 0x0b3d, TRY_LEAVE, TryCatch #34 {Exception -> 0x0b3d, blocks: (B:228:0x0a29, B:231:0x0a35, B:238:0x0a6b), top: B:359:0x0a29 }] */
    /* JADX WARN: Code duplicated, block: B:242:0x0aea A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:243:0x0aeb  */
    /* JADX WARN: Code duplicated, block: B:254:0x0b79  */
    /* JADX WARN: Code duplicated, block: B:273:0x0c2c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:274:0x0c2d  */
    /* JADX WARN: Code duplicated, block: B:299:0x0dd1  */
    /* JADX WARN: Code duplicated, block: B:325:0x0a1b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:329:0x068b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:331:0x0468 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:335:0x0685 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:339:0x0b88 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:357:0x04a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:368:0x0a3f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:370:0x066e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:378:0x04ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x042b  */
    /* JADX WARN: Code duplicated, block: B:83:0x043b  */
    /* JADX WARN: Code duplicated, block: B:86:0x0447  */
    /* JADX WARN: Code duplicated, block: B:90:0x0450  */
    /* JADX WARN: Code duplicated, block: B:92:0x0453  */
    /* JADX WARN: Code duplicated, block: B:94:0x045b  */
    /* JADX WARN: Code duplicated, block: B:98:0x0464  */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x01c7: MOVE (r13 I:??[OBJECT, ARRAY] A[D('isCasting' boolean)]) = (r10 I:??[OBJECT, ARRAY] A[D('stream' com.cncverse.LiveEventsProvider$StreamUrl)]), block:B:24:0x01bb */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x01d3: MOVE (r15 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('headers' java.util.Map)]) = (r12 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$f$forEach' int)]), block:B:24:0x01bb */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x01c4: MOVE (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r13 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('isCasting' boolean)]), block:B:24:0x01bb */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x01bb: MOVE (r2 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY] A[D('element$iv' java.lang.Object)]), block:B:24:0x01bb */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x01d1: MOVE (r20 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY] A[D('headers' java.util.Map)]), block:B:24:0x01bb */
    /* JADX WARN: Not initialized variable reg: 20, insn: 0x01cf: MOVE (r21 I:??[OBJECT, ARRAY] A[D('$this$forEach$iv' java.lang.Iterable)]) = (r20 I:??[OBJECT, ARRAY]), block:B:24:0x01bb */
    /* JADX WARN: Not initialized variable reg: 21, insn: 0x01cd: MOVE (r22 I:??[OBJECT, ARRAY] A[D('streamResponse' com.cncverse.LiveEventsProvider$ChannelStreamResponse)]) = (r21 I:??[OBJECT, ARRAY] A[D('$this$forEach$iv' java.lang.Iterable)]), block:B:24:0x01bb */
    /* JADX WARN: Not initialized variable reg: 22, insn: 0x01cb: MOVE (r23 I:??[OBJECT, ARRAY] A[D('loadData' com.cncverse.LiveEventsProvider$LiveEventLoadData)]) = (r22 I:??[OBJECT, ARRAY] A[D('streamResponse' com.cncverse.LiveEventsProvider$ChannelStreamResponse)]), block:B:24:0x01bb */
    /* JADX WARN: Not initialized variable reg: 23, insn: 0x01c8: MOVE (r24 I:??[OBJECT, ARRAY] A[D('callback' kotlin.jvm.functions.Function1)]) = (r23 I:??[OBJECT, ARRAY] A[D('loadData' com.cncverse.LiveEventsProvider$LiveEventLoadData)]), block:B:24:0x01bb */
    /* JADX WARN: Not initialized variable reg: 24, insn: 0x01c5: MOVE (r26 I:??[OBJECT, ARRAY] A[D('data' java.lang.String)]) = (r24 I:??[OBJECT, ARRAY] A[D('callback' kotlin.jvm.functions.Function1)]), block:B:24:0x01bb */
    /* JADX WARN: Not initialized variable reg: 25, insn: 0x01bc: MOVE (r27 I:??[OBJECT, ARRAY]) = (r25 I:??[OBJECT, ARRAY] A[D('subtitleCallback' kotlin.jvm.functions.Function1)]), block:B:24:0x01bb */
    /* JADX WARN: Not initialized variable reg: 26, insn: 0x01be: MOVE (r28 I:??[OBJECT, ARRAY]) = (r26 I:??[OBJECT, ARRAY] A[D('data' java.lang.String)]), block:B:24:0x01bb */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:154:0x059e -> B:300:0x0df6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:164:0x05f4 -> B:300:0x0df6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:167:0x0628 -> B:300:0x0df6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:200:0x087e -> B:298:0x0dc5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:213:0x098b -> B:298:0x0dc5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:243:0x0aeb -> B:327:0x0b0c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:276:0x0c53 -> B:298:0x0dc5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:297:0x0db4 -> B:298:0x0dc5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:299:0x0dd1 -> B:300:0x0df6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r41, boolean r42, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r43, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r44, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r45) {
        /*
            Method dump skipped, instruction units count: 3608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.LiveEventsProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.cncverse.LiveEventsProvider$fetchChannelStreams$2 */
    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/cncverse/LiveEventsProvider$ChannelStreamResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LiveEventsProvider$fetchChannelStreams$2", f = "LiveEventsProvider.kt", i = {}, l = {569}, m = "invokeSuspend", n = {}, nl = {570}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nLiveEventsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveEventsProvider.kt\ncom/cncverse/LiveEventsProvider$fetchChannelStreams$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,1065:1\n63#2:1066\n64#2,15:1068\n1#3:1067\n50#4:1083\n43#4:1084\n*S KotlinDebug\n*F\n+ 1 LiveEventsProvider.kt\ncom/cncverse/LiveEventsProvider$fetchChannelStreams$2\n*L\n595#1:1066\n595#1:1068,15\n595#1:1067\n595#1:1083\n595#1:1084\n*E\n"})
    static final class C00052 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ChannelStreamResponse>, Object> {
        final /* synthetic */ String $slug;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00052(String str, Continuation<? super C00052> continuation) {
            super(2, continuation);
            this.$slug = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LiveEventsProvider.this.new C00052(this.$slug, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ChannelStreamResponse> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object webUrl;
            Object obj;
            Object objDecodeFromString;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            boolean z = true;
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        webUrl = LiveEventsProvider.this.getWebUrl((Continuation) this);
                        if (webUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        webUrl = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String webUrl2 = (String) webUrl;
                String url = webUrl2 + '/' + this.$slug + ".txt";
                Request request = new Request.Builder().url(url).header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36").build();
                Response response = LiveEventsProvider.this.client.newCall(request).execute();
                if (response.isSuccessful()) {
                    String encryptedData = response.body().string();
                    String str = encryptedData;
                    if (!(str == null || StringsKt.isBlank(str))) {
                        System.out.println((Object) ("SKTech: Fetched encrypted channel data for " + this.$slug + ": " + encryptedData.length() + " chars"));
                        String decryptedData = SKLiveCryptoUtils.INSTANCE.decryptSKLive(StringsKt.trim(encryptedData).toString());
                        String str2 = decryptedData;
                        if (str2 != null && !StringsKt.isBlank(str2)) {
                            z = false;
                        }
                        if (!z) {
                            System.out.println((Object) "SKTech: Decrypted channel data successfully");
                            System.out.println((Object) ("SKTech: Decrypted data: " + StringsKt.take(decryptedData, 200)));
                            try {
                                AppUtils appUtils = AppUtils.INSTANCE;
                                try {
                                    Result.Companion companion = Result.Companion;
                                    KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(StreamUrl.class)));
                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                } catch (Throwable th) {
                                    Result.Companion companion2 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                                }
                                if (Result.exceptionOrNull-impl(obj) != null) {
                                    try {
                                        Result.Companion companion3 = Result.Companion;
                                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                                    } catch (Throwable th2) {
                                        Result.Companion companion4 = Result.Companion;
                                        obj = Result.constructor-impl(ResultKt.createFailure(th2));
                                    }
                                }
                                if (Result.isFailure-impl(obj)) {
                                    obj = null;
                                }
                                DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                                if (deserializationStrategy != null) {
                                    try {
                                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decryptedData);
                                    } catch (SerializationException e) {
                                        ArchComponentExtKt.logError(e);
                                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv.readValue(decryptedData, new TypeReference<List<? extends StreamUrl>>() { // from class: com.cncverse.LiveEventsProvider$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$1
                                        });
                                    } catch (Throwable th3) {
                                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv2.readValue(decryptedData, new TypeReference<List<? extends StreamUrl>>() { // from class: com.cncverse.LiveEventsProvider$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$1
                                        });
                                    }
                                } else {
                                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv3.readValue(decryptedData, new TypeReference<List<? extends StreamUrl>>() { // from class: com.cncverse.LiveEventsProvider$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$1
                                    });
                                }
                                List streamUrls = (List) objDecodeFromString;
                                return new ChannelStreamResponse(streamUrls, null, null, null);
                            } catch (Exception e2) {
                                System.out.println((Object) ("SKTech: Failed to parse stream URLs: " + e2.getMessage()));
                                return null;
                            }
                        }
                        System.out.println((Object) ("SKTech: Failed to decrypt channel data for " + this.$slug));
                        return null;
                    }
                    return null;
                }
                System.out.println((Object) ("SKTech: HTTP error " + response.code() + " fetching channel " + this.$slug));
                return null;
            } catch (Exception e3) {
                System.out.println((Object) ("SKTech: Exception fetching channel streams: " + e3.getMessage()));
                e3.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchChannelStreams(String slug, Continuation<? super ChannelStreamResponse> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00052(slug, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LiveEventsProvider$fetchStreamFromTokenApi$2 */
    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LiveEventsProvider$fetchStreamFromTokenApi$2", f = "LiveEventsProvider.kt", i = {}, l = {631, 632, 633, 634, 635, 636}, m = "invokeSuspend", n = {}, nl = {632, 633, 634, 635, 636, 630}, s = {}, v = 2)
    static final class C00072 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ TokenApiConfig $config;
        int label;
        final /* synthetic */ LiveEventsProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00072(TokenApiConfig tokenApiConfig, LiveEventsProvider liveEventsProvider, Continuation<? super C00072> continuation) {
            super(2, continuation);
            this.$config = tokenApiConfig;
            this.this$0 = liveEventsProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00072(this.$config, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:53:0x00f8 A[RETURN] */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final Object invokeSuspend(Object $result) {
            String lowerCase;
            Object objHandleDirectApiCall;
            Object objHandleLocationServiceExtraction;
            Object objHandleYoutubeExtraction;
            Object objHandleHtmlExtraction;
            Object objHandleJsonExtraction;
            Object objHandleEmbedExtraction;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        System.out.println((Object) ("SKTech: Fetching stream from tokenApi type=" + this.$config.getType()));
                        String type = this.$config.getType();
                        if (type != null) {
                            lowerCase = type.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        } else {
                            lowerCase = null;
                        }
                        if (lowerCase != null) {
                            switch (lowerCase.hashCode()) {
                                case 3463:
                                    if (lowerCase.equals("ls")) {
                                        this.label = 5;
                                        objHandleLocationServiceExtraction = this.this$0.handleLocationServiceExtraction(this.$config, (Continuation) this);
                                        if (objHandleLocationServiceExtraction == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        return (String) objHandleLocationServiceExtraction;
                                    }
                                    break;
                                case 3677:
                                    if (!lowerCase.equals("sp")) {
                                        break;
                                    }
                                    this.label = 2;
                                    objHandleJsonExtraction = this.this$0.handleJsonExtraction(this.$config, (Continuation) this);
                                    if (objHandleJsonExtraction == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return (String) objHandleJsonExtraction;
                                case 3867:
                                    if (lowerCase.equals("yt")) {
                                        this.label = 4;
                                        objHandleYoutubeExtraction = this.this$0.handleYoutubeExtraction(this.$config, (Continuation) this);
                                        if (objHandleYoutubeExtraction == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        return (String) objHandleYoutubeExtraction;
                                    }
                                    break;
                                case 3213227:
                                    if (lowerCase.equals("html")) {
                                        this.label = 3;
                                        objHandleHtmlExtraction = this.this$0.handleHtmlExtraction(this.$config, (Continuation) this);
                                        if (objHandleHtmlExtraction == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        return (String) objHandleHtmlExtraction;
                                    }
                                    break;
                                case 3271912:
                                    if (!lowerCase.equals("json")) {
                                        break;
                                    }
                                    this.label = 2;
                                    objHandleJsonExtraction = this.this$0.handleJsonExtraction(this.$config, (Continuation) this);
                                    if (objHandleJsonExtraction == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return (String) objHandleJsonExtraction;
                                case 96620249:
                                    if (lowerCase.equals("embed")) {
                                        this.label = 1;
                                        objHandleEmbedExtraction = this.this$0.handleEmbedExtraction(this.$config, (Continuation) this);
                                        if (objHandleEmbedExtraction == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        return (String) objHandleEmbedExtraction;
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                        this.label = 6;
                        objHandleDirectApiCall = this.this$0.handleDirectApiCall(this.$config, (Continuation) this);
                        if (objHandleDirectApiCall == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return (String) objHandleDirectApiCall;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        objHandleEmbedExtraction = $result;
                        return (String) objHandleEmbedExtraction;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        objHandleJsonExtraction = $result;
                        return (String) objHandleJsonExtraction;
                    case 3:
                        ResultKt.throwOnFailure($result);
                        objHandleHtmlExtraction = $result;
                        return (String) objHandleHtmlExtraction;
                    case 4:
                        ResultKt.throwOnFailure($result);
                        objHandleYoutubeExtraction = $result;
                        return (String) objHandleYoutubeExtraction;
                    case 5:
                        ResultKt.throwOnFailure($result);
                        objHandleLocationServiceExtraction = $result;
                        return (String) objHandleLocationServiceExtraction;
                    case 6:
                        ResultKt.throwOnFailure($result);
                        objHandleDirectApiCall = $result;
                        return (String) objHandleDirectApiCall;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e) {
                System.out.println((Object) ("SKTech: Exception in fetchStreamFromTokenApi: " + e.getMessage()));
                e.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchStreamFromTokenApi(TokenApiConfig config, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00072(config, this, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LiveEventsProvider$handleEmbedExtraction$2 */
    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LiveEventsProvider$handleEmbedExtraction$2", f = "LiveEventsProvider.kt", i = {0}, l = {670}, m = "invokeSuspend", n = {"embedUrl"}, nl = {671}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nLiveEventsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveEventsProvider.kt\ncom/cncverse/LiveEventsProvider$handleEmbedExtraction$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1065:1\n1#2:1066\n*E\n"})
    static final class C00122 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ TokenApiConfig $config;
        Object L$0;
        int label;
        final /* synthetic */ LiveEventsProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00122(TokenApiConfig tokenApiConfig, LiveEventsProvider liveEventsProvider, Continuation<? super C00122> continuation) {
            super(2, continuation);
            this.$config = tokenApiConfig;
            this.this$0 = liveEventsProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00122(this.$config, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0037 A[Catch: Exception -> 0x010f, TryCatch #0 {Exception -> 0x010f, blocks: (B:7:0x0016, B:10:0x0020, B:12:0x0028, B:23:0x004c, B:25:0x0053, B:32:0x0060, B:34:0x006a, B:40:0x0076, B:41:0x008e, B:43:0x009c, B:45:0x00a9, B:47:0x00b6, B:49:0x00c3, B:51:0x00d0, B:54:0x00de, B:59:0x00f6, B:17:0x0037, B:19:0x003f), top: B:64:0x0007 }] */
        /* JADX WARN: Code duplicated, block: B:22:0x004b  */
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String embedUrl = this.$config.getUrl();
                        if (embedUrl == null) {
                            embedUrl = this.$config.getApi();
                            if (embedUrl != null || StringsKt.isBlank(embedUrl)) {
                                embedUrl = null;
                            }
                        } else {
                            if (StringsKt.isBlank(embedUrl)) {
                                embedUrl = null;
                            }
                            if (embedUrl == null) {
                                embedUrl = this.$config.getApi();
                                if (embedUrl != null) {
                                    embedUrl = null;
                                } else {
                                    embedUrl = null;
                                }
                            }
                        }
                        String str = embedUrl;
                        if (str == null || StringsKt.isBlank(str)) {
                            return null;
                        }
                        String url = this.$config.getUrl();
                        if (url == null || StringsKt.isBlank(url)) {
                            System.out.println((Object) ("SKTech: Embed URL empty, using API URL as embed URL: " + embedUrl));
                        }
                        if (!StringsKt.contains$default(embedUrl, ".m3u8", false, 2, (Object) null) && !StringsKt.contains$default(embedUrl, ".mpd", false, 2, (Object) null) && !StringsKt.contains$default(embedUrl, ".mp4", false, 2, (Object) null) && !StringsKt.contains$default(embedUrl, ".ts", false, 2, (Object) null) && !StringsKt.contains$default(embedUrl, ".mkv", false, 2, (Object) null) && !StringsKt.contains$default(embedUrl, ".webm", false, 2, (Object) null)) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(embedUrl);
                            this.label = 1;
                            Object objLoadEmbedInWebView = this.this$0.loadEmbedInWebView(embedUrl, this.$config, (Continuation) this);
                            if (objLoadEmbedInWebView == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return objLoadEmbedInWebView;
                        }
                        System.out.println((Object) ("SKTech: Embed URL is already a stream: " + embedUrl));
                        return embedUrl;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e) {
                System.out.println((Object) ("SKTech: Exception in handleEmbedExtraction: " + e.getMessage()));
                e.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleEmbedExtraction(TokenApiConfig config, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00122(config, this, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LiveEventsProvider$loadEmbedInWebView$2 */
    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LiveEventsProvider$loadEmbedInWebView$2", f = "LiveEventsProvider.kt", i = {}, l = {684}, m = "invokeSuspend", n = {}, nl = {825}, s = {}, v = 2)
    static final class C00202 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $embedUrl;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00202(String str, Continuation<? super C00202> continuation) {
            super(2, continuation);
            this.$embedUrl = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00202(this.$embedUrl, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String str = this.$embedUrl;
                    this.L$0 = str;
                    this.label = 1;
                    Continuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted((Continuation) this));
                    final Continuation continuation = safeContinuation;
                    try {
                        Context context = LiveEventsProvider.INSTANCE.getContext();
                        if (context == null) {
                            System.out.println((Object) "SKTech: No context available for WebView");
                            Result.Companion companion = Result.Companion;
                            continuation.resumeWith(Result.constructor-impl((Object) null));
                        } else {
                            final WebView webView = new WebView(context);
                            WebSettings settings = webView.getSettings();
                            settings.setJavaScriptEnabled(true);
                            settings.setLoadsImagesAutomatically(true);
                            settings.setDomStorageEnabled(true);
                            settings.setAllowContentAccess(true);
                            settings.setAllowFileAccess(true);
                            settings.setMixedContentMode(0);
                            settings.setMediaPlaybackRequiresUserGesture(false);
                            final Ref.BooleanRef urlCaptured = new Ref.BooleanRef();
                            final Ref.ObjectRef capturedUrl = new Ref.ObjectRef();
                            webView.addJavascriptInterface(new Object() { // from class: com.cncverse.LiveEventsProvider$loadEmbedInWebView$2$1$bridge$1
                                @JavascriptInterface
                                public final void onStreamUrlFound(final String url) {
                                    System.out.println((Object) ("SKTech: JavaScript bridge received stream URL: " + url));
                                    if (!urlCaptured.element && !StringsKt.isBlank(url)) {
                                        urlCaptured.element = true;
                                        capturedUrl.element = url;
                                        Handler handler = new Handler(Looper.getMainLooper());
                                        final WebView webView2 = webView;
                                        final Continuation<String> continuation2 = continuation;
                                        handler.post(new Runnable() { // from class: com.cncverse.LiveEventsProvider$loadEmbedInWebView$2$1$bridge$1$onStreamUrlFound$1
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                try {
                                                    webView2.destroy();
                                                } catch (Exception e) {
                                                }
                                                Continuation<String> continuation3 = continuation2;
                                                Result.Companion companion2 = Result.Companion;
                                                continuation3.resumeWith(Result.constructor-impl(url));
                                            }
                                        });
                                    }
                                }
                            }, "StreamBridge");
                            webView.setWebViewClient(new WebViewClient() { // from class: com.cncverse.LiveEventsProvider$loadEmbedInWebView$2$1$1
                                @Override // android.webkit.WebViewClient
                                public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                                    final String url = request.getUrl().toString();
                                    if (StringsKt.contains$default(url, ".m3u8", false, 2, (Object) null) || StringsKt.contains$default(url, ".mpd", false, 2, (Object) null) || StringsKt.contains$default(url, ".mp4", false, 2, (Object) null) || StringsKt.contains$default(url, ".ts", false, 2, (Object) null) || StringsKt.contains$default(url, ".mkv", false, 2, (Object) null) || StringsKt.contains$default(url, ".webm", false, 2, (Object) null)) {
                                        System.out.println((Object) ("SKTech: Intercepted streaming URL from WebView: " + url));
                                        if (!urlCaptured.element) {
                                            urlCaptured.element = true;
                                            capturedUrl.element = url;
                                            Handler handler = new Handler(Looper.getMainLooper());
                                            final WebView webView2 = webView;
                                            final Continuation<String> continuation2 = continuation;
                                            handler.post(new Runnable() { // from class: com.cncverse.LiveEventsProvider$loadEmbedInWebView$2$1$1$shouldInterceptRequest$1
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    try {
                                                        webView2.destroy();
                                                    } catch (Exception e) {
                                                    }
                                                    Continuation<String> continuation3 = continuation2;
                                                    Result.Companion companion2 = Result.Companion;
                                                    continuation3.resumeWith(Result.constructor-impl(url));
                                                }
                                            });
                                        }
                                    }
                                    return super.shouldInterceptRequest(view, request);
                                }

                                @Override // android.webkit.WebViewClient
                                public void onPageFinished(WebView view, String pageUrl) {
                                    super.onPageFinished(view, pageUrl);
                                    System.out.println((Object) ("SKTech: WebView page finished loading: " + pageUrl));
                                    if (!urlCaptured.element) {
                                        Handler handler = new Handler(Looper.getMainLooper());
                                        final WebView webView2 = webView;
                                        handler.postDelayed(new Runnable() { // from class: com.cncverse.LiveEventsProvider$loadEmbedInWebView$2$1$1$onPageFinished$1
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                System.out.println((Object) "SKTech: Injecting JavaScript to extract stream URL");
                                                try {
                                                    webView2.evaluateJavascript("(function() {\n    if (typeof playbackURL !== 'undefined' && playbackURL) {\n        window.StreamBridge.onStreamUrlFound(playbackURL);\n    }\n})();", null);
                                                } catch (Exception e) {
                                                    System.out.println((Object) ("SKTech: Error injecting JavaScript: " + e.getMessage()));
                                                }
                                            }
                                        }, 500L);
                                    }
                                    if (!urlCaptured.element) {
                                        Handler handler2 = new Handler(Looper.getMainLooper());
                                        final Ref.BooleanRef booleanRef = urlCaptured;
                                        final WebView webView3 = webView;
                                        final Continuation<String> continuation2 = continuation;
                                        handler2.postDelayed(new Runnable() { // from class: com.cncverse.LiveEventsProvider$loadEmbedInWebView$2$1$1$onPageFinished$2
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                if (!booleanRef.element) {
                                                    System.out.println((Object) "SKTech: No streaming URL found after page load timeout");
                                                    try {
                                                        webView3.destroy();
                                                    } catch (Exception e) {
                                                    }
                                                    Continuation<String> continuation3 = continuation2;
                                                    Result.Companion companion2 = Result.Companion;
                                                    continuation3.resumeWith(Result.constructor-impl((Object) null));
                                                }
                                            }
                                        }, 3000L);
                                    }
                                }
                            });
                            webView.setWebChromeClient(new WebChromeClient());
                            System.out.println((Object) "SKTech: Loading embed in WebView");
                            System.out.println((Object) ("SKTech: Loading URL: " + str));
                            webView.loadUrl(str);
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.cncverse.LiveEventsProvider$loadEmbedInWebView$2$1$2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    if (!urlCaptured.element && capturedUrl.element == null) {
                                        System.out.println((Object) "SKTech: Embed WebView extraction timeout after 30s");
                                        try {
                                            webView.destroy();
                                        } catch (Exception e) {
                                        }
                                        try {
                                            Continuation<String> continuation2 = continuation;
                                            Result.Companion companion2 = Result.Companion;
                                            continuation2.resumeWith(Result.constructor-impl((Object) null));
                                        } catch (Exception e2) {
                                        }
                                    }
                                }
                            }, 30000L);
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println((Object) ("SKTech: Exception in loadEmbedInWebView: " + e.getMessage()));
                        e.printStackTrace();
                        Result.Companion companion2 = Result.Companion;
                        continuation.resumeWith(Result.constructor-impl((Object) null));
                    }
                    Object orThrow = safeContinuation.getOrThrow();
                    if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended((Continuation) this);
                    }
                    if (orThrow == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return orThrow;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadEmbedInWebView(String embedUrl, TokenApiConfig config, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new C00202(embedUrl, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LiveEventsProvider$handleJsonExtraction$2 */
    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LiveEventsProvider$handleJsonExtraction$2", f = "LiveEventsProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nLiveEventsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveEventsProvider.kt\ncom/cncverse/LiveEventsProvider$handleJsonExtraction$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,1065:1\n63#2:1066\n64#2,15:1068\n1#3:1067\n50#4:1083\n43#4:1084\n*S KotlinDebug\n*F\n+ 1 LiveEventsProvider.kt\ncom/cncverse/LiveEventsProvider$handleJsonExtraction$2\n*L\n851#1:1066\n851#1:1068,15\n851#1:1067\n851#1:1083\n851#1:1084\n*E\n"})
    static final class C00142 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ TokenApiConfig $config;
        int label;
        final /* synthetic */ LiveEventsProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00142(TokenApiConfig tokenApiConfig, LiveEventsProvider liveEventsProvider, Continuation<? super C00142> continuation) {
            super(2, continuation);
            this.$config = tokenApiConfig;
            this.this$0 = liveEventsProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00142(this.$config, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:48:0x0158 A[Catch: Exception -> 0x0188, TryCatch #3 {Exception -> 0x0188, blocks: (B:20:0x00a3, B:26:0x00e3, B:33:0x0111, B:36:0x0118, B:46:0x0148, B:48:0x0158, B:50:0x015c, B:52:0x0161, B:58:0x016f, B:45:0x0133, B:44:0x012d, B:32:0x0106, B:25:0x00d9, B:29:0x00ea, B:22:0x00a8, B:39:0x011e), top: B:71:0x00a3, outer: #5, inners: #1, #2, #6 }] */
        /* JADX WARN: Code duplicated, block: B:49:0x015b  */
        /* JADX WARN: Code duplicated, block: B:56:0x016b  */
        /* JADX WARN: Code duplicated, block: B:58:0x016f A[Catch: Exception -> 0x0188, TRY_LEAVE, TryCatch #3 {Exception -> 0x0188, blocks: (B:20:0x00a3, B:26:0x00e3, B:33:0x0111, B:36:0x0118, B:46:0x0148, B:48:0x0158, B:50:0x015c, B:52:0x0161, B:58:0x016f, B:45:0x0133, B:44:0x012d, B:32:0x0106, B:25:0x00d9, B:29:0x00ea, B:22:0x00a8, B:39:0x011e), top: B:71:0x00a3, outer: #5, inners: #1, #2, #6 }] */
        public final Object invokeSuspend(Object $result) {
            Object obj;
            Object objDecodeFromString;
            Object obj2;
            String streamUrl;
            String str;
            boolean z;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        String apiUrl = this.$config.getApi();
                        if (apiUrl == null) {
                            return null;
                        }
                        System.out.println((Object) ("SKTech: Fetching JSON stream from: " + apiUrl));
                        Request request = new Request.Builder().url(apiUrl).header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36").build();
                        Response response = this.this$0.client.newCall(request).execute();
                        if (response.isSuccessful()) {
                            String responseBody = response.body().string();
                            System.out.println((Object) ("SKTech: JSON response: " + StringsKt.take(responseBody, 200)));
                            String link_key = this.$config.getLink_key();
                            if (!(link_key == null || StringsKt.isBlank(link_key))) {
                                try {
                                    AppUtils appUtils = AppUtils.INSTANCE;
                                    try {
                                        Result.Companion companion = Result.Companion;
                                        KType kTypeTypeOf = Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Object.class)));
                                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                    } catch (Throwable th) {
                                        Result.Companion companion2 = Result.Companion;
                                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                                    }
                                    if (Result.exceptionOrNull-impl(obj) != null) {
                                        try {
                                            Result.Companion companion3 = Result.Companion;
                                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Map.class), (List) null, 2, (Object) null));
                                        } catch (Throwable th2) {
                                            Result.Companion companion4 = Result.Companion;
                                            obj = Result.constructor-impl(ResultKt.createFailure(th2));
                                        }
                                    }
                                    if (Result.isFailure-impl(obj)) {
                                        obj = null;
                                    }
                                    DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                                    if (deserializationStrategy != null) {
                                        try {
                                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, responseBody);
                                        } catch (SerializationException e) {
                                            ArchComponentExtKt.logError(e);
                                            ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                            objDecodeFromString = $this$readValue$iv$iv.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.LiveEventsProvider$handleJsonExtraction$2$invokeSuspend$$inlined$parseJson$1
                                            });
                                        } catch (Throwable th3) {
                                            ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                            objDecodeFromString = $this$readValue$iv$iv2.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.LiveEventsProvider$handleJsonExtraction$2$invokeSuspend$$inlined$parseJson$1
                                            });
                                        }
                                        Map json = (Map) objDecodeFromString;
                                        obj2 = json.get(this.$config.getLink_key());
                                        if (obj2 instanceof String) {
                                            streamUrl = (String) obj2;
                                        } else {
                                            streamUrl = null;
                                        }
                                        str = streamUrl;
                                        if (str != null || StringsKt.isBlank(str)) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (!z) {
                                            System.out.println((Object) ("SKTech: Extracted JSON stream URL: " + streamUrl));
                                            return streamUrl;
                                        }
                                        System.out.println((Object) ("SKTech: Exception in handleJsonExtraction: " + e.getMessage()));
                                    } else {
                                        ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv3.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.LiveEventsProvider$handleJsonExtraction$2$invokeSuspend$$inlined$parseJson$1
                                        });
                                        Map json2 = (Map) objDecodeFromString;
                                        obj2 = json2.get(this.$config.getLink_key());
                                        if (obj2 instanceof String) {
                                            streamUrl = (String) obj2;
                                        } else {
                                            streamUrl = null;
                                        }
                                        str = streamUrl;
                                        if (str != null) {
                                            z = true;
                                        } else {
                                            z = true;
                                        }
                                        if (!z) {
                                            System.out.println((Object) ("SKTech: Extracted JSON stream URL: " + streamUrl));
                                            return streamUrl;
                                        }
                                        System.out.println((Object) ("SKTech: Exception in handleJsonExtraction: " + e.getMessage()));
                                    }
                                } catch (Exception e2) {
                                    System.out.println((Object) ("SKTech: Failed to parse JSON response: " + e2.getMessage()));
                                }
                                break;
                            }
                            return StringsKt.trim(responseBody).toString();
                        }
                        return null;
                    } catch (Exception e3) {
                        System.out.println((Object) ("SKTech: Exception in handleJsonExtraction: " + e3.getMessage()));
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleJsonExtraction(TokenApiConfig config, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00142(config, this, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LiveEventsProvider$handleHtmlExtraction$2 */
    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LiveEventsProvider$handleHtmlExtraction$2", f = "LiveEventsProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00132 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ TokenApiConfig $config;
        int label;
        final /* synthetic */ LiveEventsProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00132(TokenApiConfig tokenApiConfig, LiveEventsProvider liveEventsProvider, Continuation<? super C00132> continuation) {
            super(2, continuation);
            this.$config = tokenApiConfig;
            this.this$0 = liveEventsProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00132(this.$config, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        String apiUrl = this.$config.getApi();
                        if (apiUrl == null) {
                            return null;
                        }
                        System.out.println((Object) ("SKTech: Fetching HTML stream from: " + apiUrl));
                        Request request = new Request.Builder().url(apiUrl).header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36").build();
                        Response response = this.this$0.client.newCall(request).execute();
                        if (response.isSuccessful()) {
                            String responseBody = response.body().string();
                            List<String> patterns = CollectionsKt.listOf(new String[]{"player\\.load\\(\\{[^}]*source:\\s*\"([^\"]+)\"", "src\\s*=\\s*['\"]([^'\"]*\\.m3u8[^'\"]*)['\"]", "url\\s*:\\s*['\"]([^'\"]*\\.mpd[^'\"]*)['\"]"});
                            for (String pattern : patterns) {
                                Regex regex = new Regex(pattern);
                                MatchResult match = Regex.find$default(regex, responseBody, 0, 2, (Object) null);
                                if (match != null) {
                                    String url = (String) match.getGroupValues().get(1);
                                    System.out.println((Object) ("SKTech: Extracted HTML stream URL: " + url));
                                    return url;
                                }
                            }
                            System.out.println((Object) "SKTech: No streaming URL found in HTML response");
                        }
                        return null;
                    } catch (Exception e) {
                        System.out.println((Object) ("SKTech: Exception in handleHtmlExtraction: " + e.getMessage()));
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleHtmlExtraction(TokenApiConfig config, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00132(config, this, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LiveEventsProvider$handleYoutubeExtraction$2 */
    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LiveEventsProvider$handleYoutubeExtraction$2", f = "LiveEventsProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00182 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ TokenApiConfig $config;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00182(TokenApiConfig tokenApiConfig, Continuation<? super C00182> continuation) {
            super(2, continuation);
            this.$config = tokenApiConfig;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00182(this.$config, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        String apiUrl = this.$config.getUrl();
                        if (apiUrl == null && (apiUrl = this.$config.getApi()) == null) {
                            return null;
                        }
                        System.out.println((Object) ("SKTech: YouTube URL for extraction: " + apiUrl));
                        return apiUrl;
                    } catch (Exception e) {
                        System.out.println((Object) ("SKTech: Exception in handleYoutubeExtraction: " + e.getMessage()));
                        return null;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleYoutubeExtraction(TokenApiConfig config, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00182(config, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LiveEventsProvider$handleLocationServiceExtraction$2 */
    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LiveEventsProvider$handleLocationServiceExtraction$2", f = "LiveEventsProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nLiveEventsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveEventsProvider.kt\ncom/cncverse/LiveEventsProvider$handleLocationServiceExtraction$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,1065:1\n63#2:1066\n64#2,15:1068\n1#3:1067\n50#4:1083\n43#4:1084\n*S KotlinDebug\n*F\n+ 1 LiveEventsProvider.kt\ncom/cncverse/LiveEventsProvider$handleLocationServiceExtraction$2\n*L\n964#1:1066\n964#1:1068,15\n964#1:1067\n964#1:1083\n964#1:1084\n*E\n"})
    static final class C00162 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ TokenApiConfig $config;
        int label;
        final /* synthetic */ LiveEventsProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00162(TokenApiConfig tokenApiConfig, LiveEventsProvider liveEventsProvider, Continuation<? super C00162> continuation) {
            super(2, continuation);
            this.$config = tokenApiConfig;
            this.this$0 = liveEventsProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00162(this.$config, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:53:0x016b A[Catch: Exception -> 0x0199, TryCatch #1 {Exception -> 0x0199, blocks: (B:25:0x00b7, B:31:0x00f7, B:38:0x0124, B:41:0x012b, B:51:0x015b, B:53:0x016b, B:55:0x016f, B:57:0x0174, B:63:0x0180, B:50:0x0146, B:49:0x0140, B:37:0x0119, B:30:0x00ed, B:34:0x00fe, B:27:0x00bc, B:44:0x0131), top: B:71:0x00b7, inners: #2, #4, #6 }] */
        /* JADX WARN: Code duplicated, block: B:54:0x016e  */
        /* JADX WARN: Code duplicated, block: B:61:0x017d  */
        /* JADX WARN: Code duplicated, block: B:63:0x0180 A[Catch: Exception -> 0x0199, TRY_LEAVE, TryCatch #1 {Exception -> 0x0199, blocks: (B:25:0x00b7, B:31:0x00f7, B:38:0x0124, B:41:0x012b, B:51:0x015b, B:53:0x016b, B:55:0x016f, B:57:0x0174, B:63:0x0180, B:50:0x0146, B:49:0x0140, B:37:0x0119, B:30:0x00ed, B:34:0x00fe, B:27:0x00bc, B:44:0x0131), top: B:71:0x00b7, inners: #2, #4, #6 }] */
        public final Object invokeSuspend(Object $result) {
            String ipApiUrl;
            Object obj;
            Object objDecodeFromString;
            Object obj2;
            String streamUrl;
            String str;
            boolean z;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        String it = this.$config.getIp_api();
                        if (it != null) {
                            if (StringsKt.startsWith$default(it, "aHR0", false, 2, (Object) null)) {
                                ipApiUrl = new String(Base64.decode(it, 0), Charsets.UTF_8);
                            } else {
                                ipApiUrl = it;
                            }
                        } else {
                            ipApiUrl = "https://ip-api.streamingucms.com/";
                        }
                        System.out.println((Object) ("SKTech: Resolving location service from: " + ipApiUrl));
                        Request request = new Request.Builder().url(ipApiUrl).header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36").build();
                        Response response = this.this$0.client.newCall(request).execute();
                        if (response.isSuccessful()) {
                            String responseBody = response.body().string();
                            System.out.println((Object) ("SKTech: Location service response: " + responseBody));
                            String link_key = this.$config.getLink_key();
                            if (!(link_key == null || StringsKt.isBlank(link_key))) {
                                try {
                                    AppUtils appUtils = AppUtils.INSTANCE;
                                    try {
                                        Result.Companion companion = Result.Companion;
                                        KType kTypeTypeOf = Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Object.class)));
                                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                    } catch (Throwable th) {
                                        Result.Companion companion2 = Result.Companion;
                                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                                    }
                                    if (Result.exceptionOrNull-impl(obj) != null) {
                                        try {
                                            Result.Companion companion3 = Result.Companion;
                                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Map.class), (List) null, 2, (Object) null));
                                        } catch (Throwable th2) {
                                            Result.Companion companion4 = Result.Companion;
                                            obj = Result.constructor-impl(ResultKt.createFailure(th2));
                                        }
                                    }
                                    if (Result.isFailure-impl(obj)) {
                                        obj = null;
                                    }
                                    DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                                    if (deserializationStrategy != null) {
                                        try {
                                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, responseBody);
                                        } catch (SerializationException e) {
                                            ArchComponentExtKt.logError(e);
                                            ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                            objDecodeFromString = $this$readValue$iv$iv.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.LiveEventsProvider$handleLocationServiceExtraction$2$invokeSuspend$$inlined$parseJson$1
                                            });
                                        } catch (Throwable th3) {
                                            ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                            objDecodeFromString = $this$readValue$iv$iv2.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.LiveEventsProvider$handleLocationServiceExtraction$2$invokeSuspend$$inlined$parseJson$1
                                            });
                                        }
                                        Map json = (Map) objDecodeFromString;
                                        obj2 = json.get(this.$config.getLink_key());
                                        if (obj2 instanceof String) {
                                            streamUrl = (String) obj2;
                                        } else {
                                            streamUrl = null;
                                        }
                                        str = streamUrl;
                                        if (str != null || StringsKt.isBlank(str)) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (!z) {
                                            System.out.println((Object) ("SKTech: Extracted location-based stream URL: " + streamUrl));
                                            return streamUrl;
                                        }
                                    } else {
                                        ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv3.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.LiveEventsProvider$handleLocationServiceExtraction$2$invokeSuspend$$inlined$parseJson$1
                                        });
                                        Map json2 = (Map) objDecodeFromString;
                                        obj2 = json2.get(this.$config.getLink_key());
                                        if (obj2 instanceof String) {
                                            streamUrl = (String) obj2;
                                        } else {
                                            streamUrl = null;
                                        }
                                        str = streamUrl;
                                        if (str != null) {
                                            z = true;
                                        } else {
                                            z = true;
                                        }
                                        if (!z) {
                                            System.out.println((Object) ("SKTech: Extracted location-based stream URL: " + streamUrl));
                                            return streamUrl;
                                        }
                                    }
                                    break;
                                } catch (Exception e2) {
                                }
                            }
                            return StringsKt.trim(responseBody).toString();
                        }
                    } catch (Exception e3) {
                        System.out.println((Object) ("SKTech: Exception in handleLocationServiceExtraction: " + e3.getMessage()));
                    }
                    return null;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleLocationServiceExtraction(TokenApiConfig config, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00162(config, this, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LiveEventsProvider$handleDirectApiCall$2 */
    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LiveEventsProvider$handleDirectApiCall$2", f = "LiveEventsProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nLiveEventsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveEventsProvider.kt\ncom/cncverse/LiveEventsProvider$handleDirectApiCall$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,1065:1\n63#2:1066\n64#2,15:1068\n1#3:1067\n50#4:1083\n43#4:1084\n*S KotlinDebug\n*F\n+ 1 LiveEventsProvider.kt\ncom/cncverse/LiveEventsProvider$handleDirectApiCall$2\n*L\n1006#1:1066\n1006#1:1068,15\n1006#1:1067\n1006#1:1083\n1006#1:1084\n*E\n"})
    static final class C00102 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ TokenApiConfig $config;
        int label;
        final /* synthetic */ LiveEventsProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00102(TokenApiConfig tokenApiConfig, LiveEventsProvider liveEventsProvider, Continuation<? super C00102> continuation) {
            super(2, continuation);
            this.$config = tokenApiConfig;
            this.this$0 = liveEventsProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00102(this.$config, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:48:0x0158 A[Catch: Exception -> 0x0188, TryCatch #3 {Exception -> 0x0188, blocks: (B:20:0x00a3, B:26:0x00e3, B:33:0x0111, B:36:0x0118, B:46:0x0148, B:48:0x0158, B:50:0x015c, B:52:0x0161, B:58:0x016f, B:45:0x0133, B:44:0x012d, B:32:0x0106, B:25:0x00d9, B:29:0x00ea, B:22:0x00a8, B:39:0x011e), top: B:70:0x00a3, inners: #1, #2, #6 }] */
        /* JADX WARN: Code duplicated, block: B:49:0x015b  */
        /* JADX WARN: Code duplicated, block: B:56:0x016b  */
        /* JADX WARN: Code duplicated, block: B:58:0x016f A[Catch: Exception -> 0x0188, TRY_LEAVE, TryCatch #3 {Exception -> 0x0188, blocks: (B:20:0x00a3, B:26:0x00e3, B:33:0x0111, B:36:0x0118, B:46:0x0148, B:48:0x0158, B:50:0x015c, B:52:0x0161, B:58:0x016f, B:45:0x0133, B:44:0x012d, B:32:0x0106, B:25:0x00d9, B:29:0x00ea, B:22:0x00a8, B:39:0x011e), top: B:70:0x00a3, inners: #1, #2, #6 }] */
        public final Object invokeSuspend(Object $result) {
            Object obj;
            Object objDecodeFromString;
            Object obj2;
            String streamUrl;
            String str;
            boolean z;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        String apiUrl = this.$config.getApi();
                        if (apiUrl == null) {
                            return null;
                        }
                        System.out.println((Object) ("SKTech: Direct API call to: " + apiUrl));
                        Request request = new Request.Builder().url(apiUrl).header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36").build();
                        Response response = this.this$0.client.newCall(request).execute();
                        if (response.isSuccessful()) {
                            String responseBody = response.body().string();
                            System.out.println((Object) ("SKTech: Direct API response: " + StringsKt.take(responseBody, 200)));
                            String link_key = this.$config.getLink_key();
                            if (!(link_key == null || StringsKt.isBlank(link_key))) {
                                try {
                                    AppUtils appUtils = AppUtils.INSTANCE;
                                    try {
                                        Result.Companion companion = Result.Companion;
                                        KType kTypeTypeOf = Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Object.class)));
                                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                    } catch (Throwable th) {
                                        Result.Companion companion2 = Result.Companion;
                                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                                    }
                                    if (Result.exceptionOrNull-impl(obj) != null) {
                                        try {
                                            Result.Companion companion3 = Result.Companion;
                                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Map.class), (List) null, 2, (Object) null));
                                        } catch (Throwable th2) {
                                            Result.Companion companion4 = Result.Companion;
                                            obj = Result.constructor-impl(ResultKt.createFailure(th2));
                                        }
                                    }
                                    if (Result.isFailure-impl(obj)) {
                                        obj = null;
                                    }
                                    DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                                    if (deserializationStrategy != null) {
                                        try {
                                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, responseBody);
                                        } catch (SerializationException e) {
                                            ArchComponentExtKt.logError(e);
                                            ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                            objDecodeFromString = $this$readValue$iv$iv.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.LiveEventsProvider$handleDirectApiCall$2$invokeSuspend$$inlined$parseJson$1
                                            });
                                        } catch (Throwable th3) {
                                            ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                            objDecodeFromString = $this$readValue$iv$iv2.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.LiveEventsProvider$handleDirectApiCall$2$invokeSuspend$$inlined$parseJson$1
                                            });
                                        }
                                        Map json = (Map) objDecodeFromString;
                                        obj2 = json.get(this.$config.getLink_key());
                                        if (obj2 instanceof String) {
                                            streamUrl = (String) obj2;
                                        } else {
                                            streamUrl = null;
                                        }
                                        str = streamUrl;
                                        if (str != null || StringsKt.isBlank(str)) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (!z) {
                                            System.out.println((Object) ("SKTech: Extracted stream URL from API: " + streamUrl));
                                            return streamUrl;
                                        }
                                    } else {
                                        ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv3.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.LiveEventsProvider$handleDirectApiCall$2$invokeSuspend$$inlined$parseJson$1
                                        });
                                        Map json2 = (Map) objDecodeFromString;
                                        obj2 = json2.get(this.$config.getLink_key());
                                        if (obj2 instanceof String) {
                                            streamUrl = (String) obj2;
                                        } else {
                                            streamUrl = null;
                                        }
                                        str = streamUrl;
                                        if (str != null) {
                                            z = true;
                                        } else {
                                            z = true;
                                        }
                                        if (!z) {
                                            System.out.println((Object) ("SKTech: Extracted stream URL from API: " + streamUrl));
                                            return streamUrl;
                                        }
                                    }
                                    break;
                                } catch (Exception e2) {
                                }
                            }
                            return StringsKt.trim(responseBody).toString();
                        }
                    } catch (Exception e3) {
                        System.out.println((Object) ("SKTech: Exception in handleDirectApiCall: " + e3.getMessage()));
                    }
                    return null;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleDirectApiCall(TokenApiConfig config, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00102(config, this, null), continuation);
    }

    private final Pair<String, Map<String, String>> parseStreamLink(String link) {
        String headerName;
        Map headers = new LinkedHashMap();
        int i = 0;
        int i2 = 2;
        if (!StringsKt.contains$default(link, "|", false, 2, (Object) null)) {
            return new Pair<>(link, headers);
        }
        List parts = StringsKt.split$default(link, new String[]{"|"}, false, 2, 2, (Object) null);
        String url = (String) parts.get(0);
        int i3 = 1;
        if (parts.size() > 1) {
            String headerPart = (String) parts.get(1);
            Iterable $this$forEach$iv = StringsKt.split$default(headerPart, new String[]{"&"}, false, 0, 6, (Object) null);
            for (Object element$iv : $this$forEach$iv) {
                String headerPair = (String) element$iv;
                List keyValue = StringsKt.split$default(headerPair, new String[]{"="}, false, 2, 2, (Object) null);
                if (keyValue.size() == i2) {
                    String key = StringsKt.trim((String) keyValue.get(i)).toString();
                    String value = StringsKt.trim((String) keyValue.get(i3)).toString();
                    String lowerCase = key.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    switch (lowerCase) {
                        case "cookie":
                            headerName = "Cookie";
                            break;
                        case "origin":
                            headerName = "Origin";
                            break;
                        case "user-agent":
                            headerName = "User-Agent";
                            break;
                        case "referer":
                            headerName = "Referer";
                            break;
                        default:
                            headerName = key;
                            break;
                    }
                    headers.put(headerName, value);
                }
                i3 = 1;
                i = 0;
                i2 = 2;
            }
        }
        return new Pair<>(url, headers);
    }
}
