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
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
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
import com.lagradost.cloudstream3.ui.settings.Globals;
import com.lagradost.cloudstream3.utils.AppUtils;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
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

/* JADX INFO: compiled from: LivXowLiveEventsProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/LivXowProvider/classes.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 X2\u00020\u0001:\u0005XYZ[\\B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u001f\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0002J\u0010\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0003H\u0002J\u001e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0096@¢\u0006\u0002\u00103J\u001c\u00104\u001a\b\u0012\u0004\u0012\u000206052\u0006\u00107\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u00108J\u0016\u00109\u001a\u00020:2\u0006\u0010,\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u00108JF\u0010;\u001a\u00020\u00132\u0006\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u00132\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020)0?2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020)0?H\u0096@¢\u0006\u0002\u0010CJ\u0018\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u00108J\u0018\u0010G\u001a\u0004\u0018\u00010\u00032\u0006\u0010H\u001a\u00020IH\u0082@¢\u0006\u0002\u0010JJ\u0018\u0010K\u001a\u0004\u0018\u00010\u00032\u0006\u0010H\u001a\u00020IH\u0082@¢\u0006\u0002\u0010JJ \u0010L\u001a\u0004\u0018\u00010\u00032\u0006\u0010M\u001a\u00020\u00032\u0006\u0010H\u001a\u00020IH\u0082@¢\u0006\u0002\u0010NJ\u0018\u0010O\u001a\u0004\u0018\u00010\u00032\u0006\u0010H\u001a\u00020IH\u0082@¢\u0006\u0002\u0010JJ\u0018\u0010P\u001a\u0004\u0018\u00010\u00032\u0006\u0010H\u001a\u00020IH\u0082@¢\u0006\u0002\u0010JJ\u0018\u0010Q\u001a\u0004\u0018\u00010\u00032\u0006\u0010H\u001a\u00020IH\u0082@¢\u0006\u0002\u0010JJ\u0018\u0010R\u001a\u0004\u0018\u00010\u00032\u0006\u0010H\u001a\u00020IH\u0082@¢\u0006\u0002\u0010JJ\u0018\u0010S\u001a\u0004\u0018\u00010\u00032\u0006\u0010H\u001a\u00020IH\u0082@¢\u0006\u0002\u0010JJ(\u0010T\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030V0U2\u0006\u0010W\u001a\u00020\u0003H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u001a\u0010\u000f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/cncverse/LivXowLiveEventsProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "name", "", "customCatLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getCustomCatLink", "mainUrl", "getMainUrl", "setMainUrl", "lang", "getLang", "setLang", "hasMainPage", "", "getHasMainPage", "()Z", "hasChromecastSupport", "getHasChromecastSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "client", "Lokhttp3/OkHttpClient;", "getWebUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDisplayTitle", "event", "Lcom/cncverse/LiveEventData;", "getEventStatus", "isEventLive", "isEventEnded", "generateMatchCardUrl", "showSubscriptionPopupIfNeeded", "", "showTelegramPopup", "openInExternalBrowser", "url", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchChannelStreams", "Lcom/cncverse/LivXowLiveEventsProvider$ChannelStreamResponse;", "slug", "fetchStreamFromTokenApi", "config", "Lcom/cncverse/LivXowLiveEventsProvider$TokenApiConfig;", "(Lcom/cncverse/LivXowLiveEventsProvider$TokenApiConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleEmbedExtraction", "loadEmbedInWebView", "embedUrl", "(Ljava/lang/String;Lcom/cncverse/LivXowLiveEventsProvider$TokenApiConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleJsonExtraction", "handleHtmlExtraction", "handleYoutubeExtraction", "handleLocationServiceExtraction", "handleDirectApiCall", "parseStreamLink", "Lkotlin/Pair;", "", "link", "Companion", "ChannelStreamResponse", "StreamUrl", "TokenApiConfig", "LiveEventLoadData", "LivXowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLivXowLiveEventsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LivXowLiveEventsProvider.kt\ncom/cncverse/LivXowLiveEventsProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 7 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,1387:1\n1#2:1388\n1#2:1420\n1#2:1439\n1#2:1459\n1512#3:1389\n1538#3,3:1390\n1541#3,3:1400\n1586#3:1406\n1661#3,3:1407\n1068#3:1411\n777#3:1412\n873#3,2:1413\n1586#3:1415\n1661#3,3:1416\n1915#3:1457\n1586#3:1477\n1661#3,3:1478\n1586#3:1481\n1661#3,3:1482\n1916#3:1485\n1915#3,2:1486\n383#4,7:1393\n129#5:1403\n158#5,2:1404\n160#5:1410\n63#6:1419\n64#6,15:1421\n63#6:1438\n64#6,15:1440\n63#6:1458\n64#6,15:1460\n50#7:1436\n43#7:1437\n50#7:1455\n43#7:1456\n50#7:1475\n43#7:1476\n*S KotlinDebug\n*F\n+ 1 LivXowLiveEventsProvider.kt\ncom/cncverse/LivXowLiveEventsProvider\n*L\n671#1:1420\n720#1:1439\n736#1:1459\n537#1:1389\n537#1:1390,3\n537#1:1400,3\n574#1:1406\n574#1:1407,3\n611#1:1411\n629#1:1412\n629#1:1413,2\n642#1:1415\n642#1:1416,3\n729#1:1457\n766#1:1477\n766#1:1478,3\n777#1:1481\n777#1:1482,3\n729#1:1485\n1365#1:1486,2\n537#1:1393,7\n541#1:1403\n541#1:1404,2\n541#1:1410\n671#1:1419\n671#1:1421,15\n720#1:1438\n720#1:1440,15\n736#1:1458\n736#1:1460,15\n671#1:1436\n671#1:1437\n720#1:1455\n720#1:1456\n736#1:1475\n736#1:1476\n*E\n"})
public final class LivXowLiveEventsProvider extends MainAPI {
    private static final long BROWSER_DEBOUNCE_MS = 10000;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String DEFAULT_WEB_URL = "https://welalagaa.site";

    @NotNull
    private static final String OMG10 = "aHR0cHM6Ly9vbWcxMC5jb20vNC8xMTEwNDQ4OQ==";

    @Nullable
    private static String cachedWebUrl;

    @Nullable
    private static Context context;
    private static volatile boolean csGuardWasEverActive;
    private static volatile long lastBrowserOpenMs;
    private static volatile boolean subscriptionPopupShown;
    private static volatile boolean telegramPopupShown;

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

    /* JADX INFO: renamed from: com.cncverse.LivXowLiveEventsProvider$getMainPage$1 */
    /* JADX INFO: compiled from: LivXowLiveEventsProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowLiveEventsProvider", f = "LivXowLiveEventsProvider.kt", i = {0, 0, 1, 1}, l = {531, 533}, m = "getMainPage", n = {"request", "page", "request", "page"}, nl = {533, 530}, s = {"L$0", "I$0", "L$0", "I$0"}, v = 2)
    static final class C00121 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00121(Continuation<? super C00121> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LivXowLiveEventsProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowLiveEventsProvider$getWebUrl$1 */
    /* JADX INFO: compiled from: LivXowLiveEventsProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowLiveEventsProvider", f = "LivXowLiveEventsProvider.kt", i = {}, l = {95}, m = "getWebUrl", n = {}, nl = {96}, s = {}, v = 2)
    static final class C00141 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00141(Continuation<? super C00141> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LivXowLiveEventsProvider.this.getWebUrl((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowLiveEventsProvider$loadLinks$1 */
    /* JADX INFO: compiled from: LivXowLiveEventsProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowLiveEventsProvider", f = "LivXowLiveEventsProvider.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {723, 737, 784, 802, 823, 843}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "loadData", "isCasting", "data", "subtitleCallback", "callback", "loadData", "streamResponse", "$this$forEach$iv", "element$iv", "stream", "serverName", "tokenConfig", "isCasting", "$i$f$forEach", "$i$a$-forEach-LivXowLiveEventsProvider$loadLinks$3", "data", "subtitleCallback", "callback", "loadData", "streamResponse", "$this$forEach$iv", "element$iv", "stream", "streamLink", "serverName", "url", "parsedHeaders", "headers", "drmInfo", "drmKidBytes", "drmKidBase64", "drmKeyBytes", "drmKeyBase64", "isCasting", "$i$f$forEach", "$i$a$-forEach-LivXowLiveEventsProvider$loadLinks$3", "data", "subtitleCallback", "callback", "loadData", "streamResponse", "$this$forEach$iv", "element$iv", "stream", "streamLink", "serverName", "url", "parsedHeaders", "headers", "drmInfo", "isCasting", "$i$f$forEach", "$i$a$-forEach-LivXowLiveEventsProvider$loadLinks$3", "data", "subtitleCallback", "callback", "loadData", "streamResponse", "$this$forEach$iv", "element$iv", "stream", "streamLink", "serverName", "url", "parsedHeaders", "headers", "finalHeaders", "isCasting", "$i$f$forEach", "$i$a$-forEach-LivXowLiveEventsProvider$loadLinks$3", "data", "subtitleCallback", "callback", "loadData", "streamResponse", "$this$forEach$iv", "element$iv", "stream", "streamLink", "serverName", "url", "parsedHeaders", "headers", "finalHeaders", "isCasting", "$i$f$forEach", "$i$a$-forEach-LivXowLiveEventsProvider$loadLinks$3"}, nl = {724, 738, 783, 801, 822, 842}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "Z$0", "I$0", "I$1"}, v = 2)
    static final class C00301 extends ContinuationImpl {
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
        Object L$19;
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

        C00301(Continuation<? super C00301> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LivXowLiveEventsProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowLiveEventsProvider$search$1 */
    /* JADX INFO: compiled from: LivXowLiveEventsProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowLiveEventsProvider", f = "LivXowLiveEventsProvider.kt", i = {0}, l = {626}, m = "search", n = {"query"}, nl = {628}, s = {"L$0"}, v = 2)
    static final class C00311 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00311(Continuation<? super C00311> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LivXowLiveEventsProvider.this.search(null, (Continuation) this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LivXowLiveEventsProvider() {
        String str = null;
        this(str, str, 3, str);
    }

    /* JADX INFO: compiled from: LivXowLiveEventsProvider.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/cncverse/LivXowLiveEventsProvider$Companion;", "", "<init>", "()V", "isCsGuardActive", "", "csGuardWasEverActive", "isCsGuardBlocked", "showCsGuardToast", "", "ctx", "Landroid/content/Context;", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "cachedWebUrl", "", "DEFAULT_WEB_URL", "OMG10", "lastBrowserOpenMs", "", "telegramPopupShown", "subscriptionPopupShown", "BROWSER_DEBOUNCE_MS", "LivXowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nLivXowLiveEventsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LivXowLiveEventsProvider.kt\ncom/cncverse/LivXowLiveEventsProvider$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1387:1\n1#2:1388\n*E\n"})
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
                LivXowLiveEventsProvider.csGuardWasEverActive = true;
            }
            return LivXowLiveEventsProvider.csGuardWasEverActive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCsGuardToast(final Context ctx) {
            if (ctx == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.LivXowLiveEventsProvider$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LivXowLiveEventsProvider.Companion.showCsGuardToast$lambda$0(ctx);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showCsGuardToast$lambda$0(Context $c) {
            Toast.makeText($c, "🚫 CSGuard detected — Restart CloudStream after removing CSGuard to use CNCRepo", 1).show();
        }

        @Nullable
        public final Context getContext() {
            return LivXowLiveEventsProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            LivXowLiveEventsProvider.context = context;
        }
    }

    public LivXowLiveEventsProvider(@NotNull String name, @Nullable String customCatLink) {
        this.name = name;
        this.customCatLink = customCatLink;
        this.mainUrl = DEFAULT_WEB_URL;
        this.lang = "ta";
        this.hasMainPage = true;
        this.hasChromecastSupport = true;
        this.supportedTypes = SetsKt.setOf(TvType.Live);
        this.client = new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).build();
    }

    public /* synthetic */ LivXowLiveEventsProvider(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "⚡LivXow Live Events" : str, (i & 2) != 0 ? null : str2);
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
        C00141 c00141;
        Object baseApiUrl;
        if (continuation instanceof C00141) {
            c00141 = (C00141) continuation;
            if ((c00141.label & Integer.MIN_VALUE) != 0) {
                c00141.label -= Integer.MIN_VALUE;
            } else {
                c00141 = new C00141(continuation);
            }
        } else {
            c00141 = new C00141(continuation);
        }
        Object $result = c00141.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (c00141.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String it = cachedWebUrl;
                if (it != null) {
                    return it;
                }
                LivXowFirebaseFetcher livXowFirebaseFetcher = LivXowFirebaseFetcher.INSTANCE;
                c00141.label = 1;
                baseApiUrl = livXowFirebaseFetcher.getBaseApiUrl(c00141);
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

    /* JADX INFO: compiled from: LivXowLiveEventsProvider.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\bHÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/cncverse/LivXowLiveEventsProvider$ChannelStreamResponse;", "", "streamUrls", "", "Lcom/cncverse/LivXowLiveEventsProvider$StreamUrl;", "related", "Lcom/cncverse/LiveEventData;", "prevChannel", "", "nextChannel", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getStreamUrls", "()Ljava/util/List;", "getRelated", "getPrevChannel", "()Ljava/lang/String;", "getNextChannel", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "LivXowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LivXowLiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0003J\u009e\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010/J\u0014\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00103\u001a\u00020\bHÖ\u0081\u0004J\n\u00104\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010!\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0013¨\u00065"}, d2 = {"Lcom/cncverse/LivXowLiveEventsProvider$StreamUrl;", "", "name", "", "link", "url", "stream_url", "scheme", "", "api", "drm", "tokenApi", "linkTag", "colorHex", "headers", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getName", "()Ljava/lang/String;", "getLink", "getUrl", "getStream_url", "getScheme", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getApi", "getDrm", "getTokenApi", "getLinkTag", "getColorHex", "getHeaders", "()Ljava/util/Map;", "streamUrl", "getStreamUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/cncverse/LivXowLiveEventsProvider$StreamUrl;", "equals", "", "other", "hashCode", "toString", "LivXowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class StreamUrl {

        @Nullable
        private final String api;

        @Nullable
        private final String colorHex;

        @Nullable
        private final String drm;

        @Nullable
        private final Map<String, String> headers;

        @Nullable
        private final String link;

        @Nullable
        private final String linkTag;

        @Nullable
        private final String name;

        @Nullable
        private final Integer scheme;

        @Nullable
        private final String stream_url;

        @Nullable
        private final String tokenApi;

        @Nullable
        private final String url;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StreamUrl copy$default(StreamUrl streamUrl, String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = streamUrl.name;
            }
            if ((i & 2) != 0) {
                str2 = streamUrl.link;
            }
            if ((i & 4) != 0) {
                str3 = streamUrl.url;
            }
            if ((i & 8) != 0) {
                str4 = streamUrl.stream_url;
            }
            if ((i & 16) != 0) {
                num = streamUrl.scheme;
            }
            if ((i & 32) != 0) {
                str5 = streamUrl.api;
            }
            if ((i & 64) != 0) {
                str6 = streamUrl.drm;
            }
            if ((i & 128) != 0) {
                str7 = streamUrl.tokenApi;
            }
            if ((i & 256) != 0) {
                str8 = streamUrl.linkTag;
            }
            if ((i & 512) != 0) {
                str9 = streamUrl.colorHex;
            }
            if ((i & 1024) != 0) {
                map = streamUrl.headers;
            }
            String str10 = str9;
            Map map2 = map;
            String str11 = str7;
            String str12 = str8;
            String str13 = str5;
            String str14 = str6;
            Integer num2 = num;
            String str15 = str3;
            return streamUrl.copy(str, str2, str15, str4, num2, str13, str14, str11, str12, str10, map2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getColorHex() {
            return this.colorHex;
        }

        @Nullable
        public final Map<String, String> component11() {
            return this.headers;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLink() {
            return this.link;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getStream_url() {
            return this.stream_url;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getScheme() {
            return this.scheme;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getApi() {
            return this.api;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getDrm() {
            return this.drm;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getTokenApi() {
            return this.tokenApi;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getLinkTag() {
            return this.linkTag;
        }

        @NotNull
        public final StreamUrl copy(@Nullable String name, @Nullable String link, @Nullable String url, @Nullable String stream_url, @Nullable Integer scheme, @Nullable String api, @Nullable String drm, @Nullable String tokenApi, @Nullable String linkTag, @Nullable String colorHex, @Nullable Map<String, String> headers) {
            return new StreamUrl(name, link, url, stream_url, scheme, api, drm, tokenApi, linkTag, colorHex, headers);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StreamUrl)) {
                return false;
            }
            StreamUrl streamUrl = (StreamUrl) other;
            return Intrinsics.areEqual(this.name, streamUrl.name) && Intrinsics.areEqual(this.link, streamUrl.link) && Intrinsics.areEqual(this.url, streamUrl.url) && Intrinsics.areEqual(this.stream_url, streamUrl.stream_url) && Intrinsics.areEqual(this.scheme, streamUrl.scheme) && Intrinsics.areEqual(this.api, streamUrl.api) && Intrinsics.areEqual(this.drm, streamUrl.drm) && Intrinsics.areEqual(this.tokenApi, streamUrl.tokenApi) && Intrinsics.areEqual(this.linkTag, streamUrl.linkTag) && Intrinsics.areEqual(this.colorHex, streamUrl.colorHex) && Intrinsics.areEqual(this.headers, streamUrl.headers);
        }

        public int hashCode() {
            return ((((((((((((((((((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.link == null ? 0 : this.link.hashCode())) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.stream_url == null ? 0 : this.stream_url.hashCode())) * 31) + (this.scheme == null ? 0 : this.scheme.hashCode())) * 31) + (this.api == null ? 0 : this.api.hashCode())) * 31) + (this.drm == null ? 0 : this.drm.hashCode())) * 31) + (this.tokenApi == null ? 0 : this.tokenApi.hashCode())) * 31) + (this.linkTag == null ? 0 : this.linkTag.hashCode())) * 31) + (this.colorHex == null ? 0 : this.colorHex.hashCode())) * 31) + (this.headers != null ? this.headers.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("StreamUrl(name=").append(this.name).append(", link=").append(this.link).append(", url=").append(this.url).append(", stream_url=").append(this.stream_url).append(", scheme=").append(this.scheme).append(", api=").append(this.api).append(", drm=").append(this.drm).append(", tokenApi=").append(this.tokenApi).append(", linkTag=").append(this.linkTag).append(", colorHex=").append(this.colorHex).append(", headers=").append(this.headers).append(')');
            return sb.toString();
        }

        public StreamUrl(@Nullable String name, @Nullable String link, @Nullable String url, @Nullable String stream_url, @Nullable Integer scheme, @Nullable String api, @Nullable String drm, @Nullable String tokenApi, @Nullable String linkTag, @Nullable String colorHex, @Nullable Map<String, String> map) {
            this.name = name;
            this.link = link;
            this.url = url;
            this.stream_url = stream_url;
            this.scheme = scheme;
            this.api = api;
            this.drm = drm;
            this.tokenApi = tokenApi;
            this.linkTag = linkTag;
            this.colorHex = colorHex;
            this.headers = map;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ StreamUrl(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            Map map2;
            if ((i & 1024) == 0) {
                map2 = map;
            } else {
                map2 = null;
            }
            this(str, str2, str3, str4, num, str5, str6, str7, str8, str9, map2);
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
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final String getStream_url() {
            return this.stream_url;
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
        public final String getDrm() {
            return this.drm;
        }

        @Nullable
        public final String getTokenApi() {
            return this.tokenApi;
        }

        @Nullable
        public final String getLinkTag() {
            return this.linkTag;
        }

        @Nullable
        public final String getColorHex() {
            return this.colorHex;
        }

        @Nullable
        public final Map<String, String> getHeaders() {
            return this.headers;
        }

        @Nullable
        public final String getStreamUrl() {
            String str = this.url;
            if (str != null) {
                return str;
            }
            String str2 = this.stream_url;
            return str2 == null ? this.link : str2;
        }
    }

    /* JADX INFO: compiled from: LivXowLiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ji\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006%"}, d2 = {"Lcom/cncverse/LivXowLiveEventsProvider$TokenApiConfig;", "", "url", "", "api", "type", "link_key", "default_string", "request_type", "request_body_type", "ip_api", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getApi", "getType", "getLink_key", "getDefault_string", "getRequest_type", "getRequest_body_type", "getIp_api", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "LivXowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LivXowLiveEventsProvider.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003JM\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/cncverse/LivXowLiveEventsProvider$LiveEventLoadData;", "", "eventId", "", "title", "", "poster", "slug", "formats", "", "Lcom/cncverse/LiveEventFormat;", "eventInfo", "Lcom/cncverse/LiveEventInfo;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/cncverse/LiveEventInfo;)V", "getEventId", "()I", "getTitle", "()Ljava/lang/String;", "getPoster", "getSlug", "getFormats", "()Ljava/util/List;", "getEventInfo", "()Lcom/cncverse/LiveEventInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "LivXowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
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
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.LivXowLiveEventsProvider$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    LivXowLiveEventsProvider.showSubscriptionPopupIfNeeded$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.LivXowLiveEventsProvider$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LivXowLiveEventsProvider.showSubscriptionPopupIfNeeded$lambda$0$11($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249, $ctx, dialog, view);
                }
            });
            subscribeTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.LivXowLiveEventsProvider$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LivXowLiveEventsProvider.showSubscriptionPopupIfNeeded$lambda$0$12(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.LivXowLiveEventsProvider$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                LivXowLiveEventsProvider.showTelegramPopup$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.LivXowLiveEventsProvider$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            joinTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.LivXowLiveEventsProvider$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LivXowLiveEventsProvider.showTelegramPopup$lambda$0$9(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.LivXowLiveEventsProvider$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                LivXowLiveEventsProvider.openInExternalBrowser$lambda$0(ctx, url);
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:101:0x0270  */
    /* JADX WARN: Code duplicated, block: B:112:0x0274 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:43:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:48:0x012b  */
    /* JADX WARN: Code duplicated, block: B:51:0x0157  */
    /* JADX WARN: Code duplicated, block: B:54:0x0160  */
    /* JADX WARN: Code duplicated, block: B:55:0x0163  */
    /* JADX WARN: Code duplicated, block: B:58:0x016c  */
    /* JADX WARN: Code duplicated, block: B:59:0x016f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0178  */
    /* JADX WARN: Code duplicated, block: B:63:0x017b  */
    /* JADX WARN: Code duplicated, block: B:66:0x0184  */
    /* JADX WARN: Code duplicated, block: B:67:0x0187  */
    /* JADX WARN: Code duplicated, block: B:70:0x0190  */
    /* JADX WARN: Code duplicated, block: B:71:0x0193  */
    /* JADX WARN: Code duplicated, block: B:74:0x019c  */
    /* JADX WARN: Code duplicated, block: B:75:0x019f  */
    /* JADX WARN: Code duplicated, block: B:78:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:79:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:83:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:85:0x020c  */
    /* JADX WARN: Code duplicated, block: B:86:0x0228  */
    /* JADX WARN: Code duplicated, block: B:89:0x023c  */
    /* JADX WARN: Code duplicated, block: B:91:0x0244  */
    /* JADX WARN: Code duplicated, block: B:95:0x024d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0250  */
    /* JADX WARN: Code duplicated, block: B:98:0x0257  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws UnsupportedEncodingException {
        C00121 c00121;
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
        if (continuation instanceof C00121) {
            c00121 = (C00121) continuation;
            if ((c00121.label & Integer.MIN_VALUE) != 0) {
                c00121.label -= Integer.MIN_VALUE;
            } else {
                c00121 = new C00121(continuation);
            }
        } else {
            c00121 = new C00121(continuation);
        }
        Object $result = c00121.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00121.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                }
                showTelegramPopup();
                showSubscriptionPopupIfNeeded();
                if (this.customCatLink == null) {
                    LivXowProviderManager livXowProviderManager = LivXowProviderManager.INSTANCE;
                    c00121.L$0 = SpillingKt.nullOutSpilledVariable(request);
                    c00121.I$0 = page2;
                    c00121.label = 2;
                    objFetchLiveEvents = livXowProviderManager.fetchLiveEvents(c00121);
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
                        C00121 c00122 = c00121;
                        final Comparator comparator = new Comparator() { // from class: com.cncverse.LivXowLiveEventsProvider$getMainPage$lambda$1$$inlined$compareBy$1
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
                        $this$map$iv2 = CollectionsKt.sortedWith(categoryEvents, new Comparator() { // from class: com.cncverse.LivXowLiveEventsProvider$getMainPage$lambda$1$$inlined$thenBy$1
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
                                destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle, AppUtils.INSTANCE.toJson(loadData), TvType.Live, false, new Function1() { // from class: com.cncverse.LivXowLiveEventsProvider$$ExternalSyntheticLambda4
                                    public final Object invoke(Object obj) {
                                        return LivXowLiveEventsProvider.getMainPage$lambda$1$2$0(posterUrl2, (LiveSearchResponse) obj);
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
                        c00121 = c00122;
                        $result = $result2;
                        request2 = request2;
                    }
                    Iterable $this$sortedBy$iv = (List) destination$iv$iv;
                    List homePageLists = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: com.cncverse.LivXowLiveEventsProvider$getMainPage$$inlined$sortedBy$1
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
                LivXowProviderManager livXowProviderManager2 = LivXowProviderManager.INSTANCE;
                String str2 = this.customCatLink;
                c00121.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00121.I$0 = page2;
                c00121.label = 1;
                objFetchCustomEvents = livXowProviderManager2.fetchCustomEvents(str2, c00121);
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
                    C00121 c00123 = c00121;
                    final Comparator comparator2 = new Comparator() { // from class: com.cncverse.LivXowLiveEventsProvider$getMainPage$lambda$1$$inlined$compareBy$1
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
                    $this$map$iv2 = CollectionsKt.sortedWith(categoryEvents2, new Comparator() { // from class: com.cncverse.LivXowLiveEventsProvider$getMainPage$lambda$1$$inlined$thenBy$1
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
                            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle2, AppUtils.INSTANCE.toJson(loadData2), TvType.Live, false, new Function1() { // from class: com.cncverse.LivXowLiveEventsProvider$$ExternalSyntheticLambda4
                                public final Object invoke(Object obj) {
                                    return LivXowLiveEventsProvider.getMainPage$lambda$1$2$0(posterUrl3, (LiveSearchResponse) obj);
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
                    c00121 = c00123;
                    $result = $result3;
                    request2 = request2;
                }
                Iterable $this$sortedBy$iv2 = (List) destination$iv$iv;
                List homePageLists2 = CollectionsKt.sortedWith($this$sortedBy$iv2, new Comparator() { // from class: com.cncverse.LivXowLiveEventsProvider$getMainPage$$inlined$sortedBy$1
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
                page2 = c00121.I$0;
                request2 = (MainPageRequest) c00121.L$0;
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
                    C00121 c00124 = c00121;
                    final Comparator comparator3 = new Comparator() { // from class: com.cncverse.LivXowLiveEventsProvider$getMainPage$lambda$1$$inlined$compareBy$1
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
                    $this$map$iv2 = CollectionsKt.sortedWith(categoryEvents3, new Comparator() { // from class: com.cncverse.LivXowLiveEventsProvider$getMainPage$lambda$1$$inlined$thenBy$1
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
                            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle3, AppUtils.INSTANCE.toJson(loadData3), TvType.Live, false, new Function1() { // from class: com.cncverse.LivXowLiveEventsProvider$$ExternalSyntheticLambda4
                                public final Object invoke(Object obj) {
                                    return LivXowLiveEventsProvider.getMainPage$lambda$1$2$0(posterUrl4, (LiveSearchResponse) obj);
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
                    c00121 = c00124;
                    $result = $result4;
                    request2 = request2;
                }
                Iterable $this$sortedBy$iv3 = (List) destination$iv$iv;
                List homePageLists3 = CollectionsKt.sortedWith($this$sortedBy$iv3, new Comparator() { // from class: com.cncverse.LivXowLiveEventsProvider$getMainPage$$inlined$sortedBy$1
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
                page2 = c00121.I$0;
                request2 = (MainPageRequest) c00121.L$0;
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
                    C00121 c00125 = c00121;
                    final Comparator comparator4 = new Comparator() { // from class: com.cncverse.LivXowLiveEventsProvider$getMainPage$lambda$1$$inlined$compareBy$1
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
                    $this$map$iv2 = CollectionsKt.sortedWith(categoryEvents4, new Comparator() { // from class: com.cncverse.LivXowLiveEventsProvider$getMainPage$lambda$1$$inlined$thenBy$1
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
                            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle4, AppUtils.INSTANCE.toJson(loadData4), TvType.Live, false, new Function1() { // from class: com.cncverse.LivXowLiveEventsProvider$$ExternalSyntheticLambda4
                                public final Object invoke(Object obj) {
                                    return LivXowLiveEventsProvider.getMainPage$lambda$1$2$0(posterUrl5, (LiveSearchResponse) obj);
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
                    c00121 = c00125;
                    $result = $result5;
                    request2 = request2;
                }
                Iterable $this$sortedBy$iv4 = (List) destination$iv$iv;
                List homePageLists4 = CollectionsKt.sortedWith($this$sortedBy$iv4, new Comparator() { // from class: com.cncverse.LivXowLiveEventsProvider$getMainPage$$inlined$sortedBy$1
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
        C00311 c00311;
        Object objFetchLiveEvents;
        String query2;
        LivXowLiveEventsProvider livXowLiveEventsProvider = this;
        if (continuation instanceof C00311) {
            c00311 = (C00311) continuation;
            if ((c00311.label & Integer.MIN_VALUE) != 0) {
                c00311.label -= Integer.MIN_VALUE;
            } else {
                c00311 = livXowLiveEventsProvider.new C00311(continuation);
            }
        } else {
            c00311 = livXowLiveEventsProvider.new C00311(continuation);
        }
        Object $result = c00311.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00311.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return CollectionsKt.emptyList();
                }
                LivXowProviderManager livXowProviderManager = LivXowProviderManager.INSTANCE;
                c00311.L$0 = query;
                c00311.label = 1;
                objFetchLiveEvents = livXowProviderManager.fetchLiveEvents(c00311);
                if (objFetchLiveEvents == coroutine_suspended) {
                    return coroutine_suspended;
                }
                query2 = query;
                break;
                break;
            case 1:
                query2 = (String) c00311.L$0;
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
            c00311 = c00311;
            $result = $result;
        }
        Iterable $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            LiveEventData event2 = (LiveEventData) item$iv$iv;
            String displayTitle = livXowLiveEventsProvider.createDisplayTitle(event2);
            String status = livXowLiveEventsProvider.getEventStatus(event2);
            String fullTitle = !StringsKt.isBlank(status) ? status + ' ' + displayTitle : displayTitle;
            final String posterUrl = livXowLiveEventsProvider.generateMatchCardUrl(event2);
            int id = event2.getId();
            String slug = event2.getSlug();
            List<LiveEventFormat> formats = event2.getFormats();
            if (formats == null) {
                formats = CollectionsKt.emptyList();
            }
            LiveEventLoadData loadData = new LiveEventLoadData(id, displayTitle, posterUrl, slug, formats, event2.getEventInfo());
            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(livXowLiveEventsProvider, fullTitle, AppUtils.INSTANCE.toJson(loadData), TvType.Live, false, new Function1() { // from class: com.cncverse.LivXowLiveEventsProvider$$ExternalSyntheticLambda7
                public final Object invoke(Object obj) {
                    return LivXowLiveEventsProvider.search$lambda$1$0(posterUrl, (LiveSearchResponse) obj);
                }
            }, 8, (Object) null));
            livXowLiveEventsProvider = this;
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
                objDecodeFromString = $this$readValue$iv$iv.readValue(url, new TypeReference<LiveEventLoadData>() { // from class: com.cncverse.LivXowLiveEventsProvider$load$$inlined$parseJson$1
                });
            } catch (Throwable th3) {
                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv2.readValue(url, new TypeReference<LiveEventLoadData>() { // from class: com.cncverse.LivXowLiveEventsProvider$load$$inlined$parseJson$1
                });
            }
        } else {
            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
            objDecodeFromString = $this$readValue$iv$iv3.readValue(url, new TypeReference<LiveEventLoadData>() { // from class: com.cncverse.LivXowLiveEventsProvider$load$$inlined$parseJson$1
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
        return MainAPIKt.newLiveStreamLoadResponse(this, data.getTitle(), url, url, new C00242(data, plot, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowLiveEventsProvider$load$2 */
    /* JADX INFO: compiled from: LivXowLiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/LiveStreamLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowLiveEventsProvider$load$2", f = "LivXowLiveEventsProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00242 extends SuspendLambda implements Function2<LiveStreamLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ LiveEventLoadData $data;
        final /* synthetic */ String $plot;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00242(LiveEventLoadData liveEventLoadData, String str, Continuation<? super C00242> continuation) {
            super(2, continuation);
            this.$data = liveEventLoadData;
            this.$plot = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00242 = new C00242(this.$data, this.$plot, continuation);
            c00242.L$0 = obj;
            return c00242;
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

    /* JADX WARN: Code duplicated, block: B:111:0x048b  */
    /* JADX WARN: Code duplicated, block: B:113:0x049b  */
    /* JADX WARN: Code duplicated, block: B:116:0x04a7  */
    /* JADX WARN: Code duplicated, block: B:120:0x04b0  */
    /* JADX WARN: Code duplicated, block: B:122:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:124:0x04bb  */
    /* JADX WARN: Code duplicated, block: B:128:0x04c4  */
    /* JADX WARN: Code duplicated, block: B:138:0x04fd  */
    /* JADX WARN: Code duplicated, block: B:154:0x0547  */
    /* JADX WARN: Code duplicated, block: B:174:0x057b  */
    /* JADX WARN: Code duplicated, block: B:180:0x05f0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:181:0x05f1  */
    /* JADX WARN: Code duplicated, block: B:184:0x0600  */
    /* JADX WARN: Code duplicated, block: B:185:0x060a  */
    /* JADX WARN: Code duplicated, block: B:201:0x06c2  */
    /* JADX WARN: Code duplicated, block: B:203:0x06c8  */
    /* JADX WARN: Code duplicated, block: B:218:0x0720 A[Catch: Exception -> 0x0703, TRY_LEAVE, TryCatch #39 {Exception -> 0x0703, blocks: (B:214:0x06fe, B:218:0x0720, B:229:0x0782, B:235:0x07fd), top: B:399:0x06fe }] */
    /* JADX WARN: Code duplicated, block: B:220:0x0737  */
    /* JADX WARN: Code duplicated, block: B:225:0x0742 A[Catch: Exception -> 0x0951, TryCatch #29 {Exception -> 0x0951, blocks: (B:223:0x073b, B:225:0x0742, B:226:0x077a, B:232:0x07a9, B:233:0x07f7, B:238:0x0828), top: B:385:0x073b }] */
    /* JADX WARN: Code duplicated, block: B:229:0x0782 A[Catch: Exception -> 0x0703, TRY_ENTER, TRY_LEAVE, TryCatch #39 {Exception -> 0x0703, blocks: (B:214:0x06fe, B:218:0x0720, B:229:0x0782, B:235:0x07fd), top: B:399:0x06fe }] */
    /* JADX WARN: Code duplicated, block: B:235:0x07fd A[Catch: Exception -> 0x0703, TRY_ENTER, TRY_LEAVE, TryCatch #39 {Exception -> 0x0703, blocks: (B:214:0x06fe, B:218:0x0720, B:229:0x0782, B:235:0x07fd), top: B:399:0x06fe }] */
    /* JADX WARN: Code duplicated, block: B:243:0x08d3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:244:0x08d4  */
    /* JADX WARN: Code duplicated, block: B:260:0x09f7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:261:0x09f8  */
    /* JADX WARN: Code duplicated, block: B:274:0x0ac0  */
    /* JADX WARN: Code duplicated, block: B:280:0x0ade A[Catch: Exception -> 0x0cfc, TRY_ENTER, TRY_LEAVE, TryCatch #34 {Exception -> 0x0cfc, blocks: (B:277:0x0ad4, B:280:0x0ade), top: B:393:0x0ad4 }] */
    /* JADX WARN: Code duplicated, block: B:284:0x0af2  */
    /* JADX WARN: Code duplicated, block: B:285:0x0af8 A[Catch: Exception -> 0x0be9, TRY_LEAVE, TryCatch #3 {Exception -> 0x0be9, blocks: (B:282:0x0aec, B:285:0x0af8, B:292:0x0b23), top: B:338:0x0aec }] */
    /* JADX WARN: Code duplicated, block: B:296:0x0ba6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:297:0x0ba7  */
    /* JADX WARN: Code duplicated, block: B:304:0x0c07  */
    /* JADX WARN: Code duplicated, block: B:307:0x0c16 A[Catch: Exception -> 0x0ce0, TryCatch #13 {Exception -> 0x0ce0, blocks: (B:305:0x0c0c, B:307:0x0c16, B:308:0x0c19, B:294:0x0ba0), top: B:357:0x0c0c }] */
    /* JADX WARN: Code duplicated, block: B:310:0x0c97 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:311:0x0c98  */
    /* JADX WARN: Code duplicated, block: B:330:0x0ddc  */
    /* JADX WARN: Code duplicated, block: B:355:0x0504 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:361:0x06f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:377:0x06de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:385:0x073b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:389:0x04c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:397:0x0b02 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:399:0x06fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:401:0x054e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x01aa: MOVE (r26 I:??[OBJECT, ARRAY] A[D('data' java.lang.String)]) = (r10 I:??[OBJECT, ARRAY] A[D('serverName' java.lang.String)]), block:B:24:0x01a1 */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x01ac: MOVE (r14 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('element$iv' java.lang.Object)]) = (r12 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$f$forEach' int)]), block:B:24:0x01a1 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x01a1: MOVE (r2 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY] A[D('element$iv' java.lang.Object)]), block:B:24:0x01a1 */
    /* JADX WARN: Not initialized variable reg: 24, insn: 0x01a2: MOVE (r28 I:??[OBJECT, ARRAY]) = (r24 I:??[OBJECT, ARRAY] A[D('callback' kotlin.jvm.functions.Function1)]), block:B:24:0x01a1 */
    /* JADX WARN: Not initialized variable reg: 26, insn: 0x01a4: MOVE (r32 I:??[OBJECT, ARRAY]) = (r26 I:??[OBJECT, ARRAY] A[D('data' java.lang.String)]), block:B:24:0x01a1 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:184:0x0600 -> B:331:0x0e00). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:194:0x0652 -> B:331:0x0e00). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:197:0x0686 -> B:331:0x0e00). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:246:0x08fa -> B:329:0x0dd0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:263:0x0a13 -> B:329:0x0dd0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:297:0x0ba7 -> B:365:0x0bbe). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:313:0x0cb5 -> B:329:0x0dd0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:328:0x0db7 -> B:329:0x0dd0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:330:0x0ddc -> B:331:0x0e00). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r41, boolean r42, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r43, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r44, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r45) {
        /*
            Method dump skipped, instruction units count: 3618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.LivXowLiveEventsProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadLinks$lambda$0$0(Context $_ctx) {
        Toast.makeText($_ctx, "⚠️(Opening ads) Subscription expired. If you have renewed your subscription, please re-verify it in Subscription Manager.", 1).show();
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowLiveEventsProvider$fetchChannelStreams$2 */
    /* JADX INFO: compiled from: LivXowLiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/cncverse/LivXowLiveEventsProvider$ChannelStreamResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowLiveEventsProvider$fetchChannelStreams$2", f = "LivXowLiveEventsProvider.kt", i = {}, l = {870}, m = "invokeSuspend", n = {}, nl = {871}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nLivXowLiveEventsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LivXowLiveEventsProvider.kt\ncom/cncverse/LivXowLiveEventsProvider$fetchChannelStreams$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,1387:1\n63#2:1388\n64#2,15:1390\n63#2:1407\n64#2,15:1409\n63#2:1426\n64#2,15:1428\n63#2:1445\n64#2,15:1447\n1#3:1389\n1#3:1408\n1#3:1427\n1#3:1446\n50#4:1405\n43#4:1406\n50#4:1424\n43#4:1425\n50#4:1443\n43#4:1444\n50#4:1462\n43#4:1463\n*S KotlinDebug\n*F\n+ 1 LivXowLiveEventsProvider.kt\ncom/cncverse/LivXowLiveEventsProvider$fetchChannelStreams$2\n*L\n899#1:1388\n899#1:1390,15\n904#1:1407\n904#1:1409,15\n909#1:1426\n909#1:1428,15\n914#1:1445\n914#1:1447,15\n899#1:1389\n904#1:1408\n909#1:1427\n914#1:1446\n899#1:1405\n899#1:1406\n904#1:1424\n904#1:1425\n909#1:1443\n909#1:1444\n914#1:1462\n914#1:1463\n*E\n"})
    static final class C00062 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ChannelStreamResponse>, Object> {
        final /* synthetic */ String $slug;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00062(String str, Continuation<? super C00062> continuation) {
            super(2, continuation);
            this.$slug = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LivXowLiveEventsProvider.this.new C00062(this.$slug, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ChannelStreamResponse> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:107:0x0282  */
        /* JADX WARN: Code duplicated, block: B:117:0x029e A[Catch: Exception -> 0x0420, TryCatch #12 {Exception -> 0x0420, blocks: (B:56:0x0185, B:64:0x01b4, B:67:0x01bb, B:77:0x01ed, B:78:0x01f4, B:80:0x01fa, B:82:0x0207, B:88:0x0236, B:105:0x027c, B:108:0x0283, B:118:0x02b7, B:117:0x029e, B:116:0x0298, B:104:0x0272, B:87:0x022c, B:119:0x02be, B:121:0x02ca, B:127:0x02f9, B:139:0x032f, B:142:0x0336, B:152:0x0366, B:151:0x0351, B:150:0x034b, B:138:0x0325, B:126:0x02ef, B:153:0x036b, B:159:0x039a, B:171:0x03cc, B:174:0x03d3, B:184:0x0405, B:183:0x03ee, B:182:0x03e8, B:170:0x03c2, B:158:0x0390, B:186:0x0412, B:76:0x01d6, B:75:0x01d0, B:63:0x01a9, B:55:0x017b, B:60:0x018d, B:84:0x0215, B:123:0x02d8, B:70:0x01c1, B:145:0x033c, B:111:0x0289, B:155:0x0379, B:177:0x03d9), top: B:223:0x017b, inners: #6, #10, #11, #15, #16, #21, #23, #26, #25, #24, #23 }] */
        /* JADX WARN: Code duplicated, block: B:242:0x0289 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Object invokeSuspend(Object $result) {
            Object webUrl;
            Object obj;
            Object obj2;
            Object objDecodeFromString;
            String str;
            List rawList;
            Iterator it;
            String str2;
            Object obj3;
            Object objDecodeFromString2;
            Object obj4;
            Object objDecodeFromString3;
            Object obj5;
            DeserializationStrategy deserializationStrategy;
            Object objDecodeFromString4;
            String str3 = "stream";
            String str4 = "channel";
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            boolean z = true;
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        webUrl = LivXowLiveEventsProvider.this.getWebUrl((Continuation) this);
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
                Response response = LivXowLiveEventsProvider.this.client.newCall(request).execute();
                if (response.isSuccessful()) {
                    String encryptedData = response.body().string();
                    String str5 = encryptedData;
                    if (!(str5 == null || StringsKt.isBlank(str5))) {
                        System.out.println((Object) ("SKTech: Fetched encrypted channel data for " + this.$slug + ": " + encryptedData.length() + " chars"));
                        String decryptedData = LivXowCryptoUtils.INSTANCE.decrypt(StringsKt.trim(encryptedData).toString());
                        String str6 = decryptedData;
                        if (str6 != null && !StringsKt.isBlank(str6)) {
                            z = false;
                        }
                        if (!z) {
                            System.out.println((Object) "SKTech: Decrypted channel data successfully");
                            System.out.println((Object) ("SKTech: Decrypted data: " + StringsKt.take(decryptedData, 200)));
                            try {
                                List streamUrls = new ArrayList();
                                AppUtils appUtils = AppUtils.INSTANCE;
                                try {
                                    Result.Companion companion = Result.Companion;
                                    obj = "kotlinx.serialization.serializer.simple";
                                    try {
                                        try {
                                            try {
                                                KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Object.class)))));
                                                MagicApiIntrinsics.voidMagicApiCall(obj);
                                                obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                            } catch (Throwable th) {
                                                th = th;
                                                try {
                                                    Result.Companion companion2 = Result.Companion;
                                                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                                } catch (Exception e) {
                                                    e = e;
                                                    System.out.println((Object) ("SKTech: Failed to parse stream URLs: " + e.getMessage()));
                                                    return null;
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    obj = "kotlinx.serialization.serializer.simple";
                                }
                                if (Result.exceptionOrNull-impl(obj2) != null) {
                                    try {
                                        Result.Companion companion3 = Result.Companion;
                                        obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                                    } catch (Throwable th5) {
                                        Result.Companion companion4 = Result.Companion;
                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th5));
                                    }
                                }
                                if (Result.isFailure-impl(obj2)) {
                                    obj2 = null;
                                }
                                DeserializationStrategy deserializationStrategy2 = (KSerializer) obj2;
                                if (deserializationStrategy2 != null) {
                                    try {
                                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, decryptedData);
                                    } catch (SerializationException e2) {
                                        ArchComponentExtKt.logError(e2);
                                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv.readValue(decryptedData, new TypeReference<List<? extends Map<String, ? extends Object>>>() { // from class: com.cncverse.LivXowLiveEventsProvider$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$1
                                        });
                                    } catch (Throwable th6) {
                                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv2.readValue(decryptedData, new TypeReference<List<? extends Map<String, ? extends Object>>>() { // from class: com.cncverse.LivXowLiveEventsProvider$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$1
                                        });
                                    }
                                } else {
                                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv3.readValue(decryptedData, new TypeReference<List<? extends Map<String, ? extends Object>>>() { // from class: com.cncverse.LivXowLiveEventsProvider$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$1
                                    });
                                }
                                List rawList2 = (List) objDecodeFromString;
                                for (Iterator it2 = rawList2.iterator(); it2.hasNext(); it2 = it) {
                                    Map item = (Map) it2.next();
                                    if (item.containsKey(str4)) {
                                        String innerStr = String.valueOf(item.get(str4));
                                        AppUtils appUtils2 = AppUtils.INSTANCE;
                                        try {
                                            Result.Companion companion5 = Result.Companion;
                                            KType kTypeTypeOf2 = Reflection.typeOf(StreamUrl.class);
                                            MagicApiIntrinsics.voidMagicApiCall(obj);
                                            obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                        } catch (Throwable th7) {
                                            Result.Companion companion6 = Result.Companion;
                                            obj5 = Result.constructor-impl(ResultKt.createFailure(th7));
                                        }
                                        if (Result.exceptionOrNull-impl(obj5) == null) {
                                            str = str4;
                                            rawList = rawList2;
                                            it = it2;
                                        } else {
                                            try {
                                                Result.Companion companion7 = Result.Companion;
                                                str = str4;
                                                try {
                                                    rawList = rawList2;
                                                    it = it2;
                                                    try {
                                                        obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(StreamUrl.class), (List) null, 2, (Object) null));
                                                    } catch (Throwable th8) {
                                                        th = th8;
                                                        Result.Companion companion8 = Result.Companion;
                                                        obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                                    }
                                                } catch (Throwable th9) {
                                                    th = th9;
                                                    rawList = rawList2;
                                                    it = it2;
                                                    Result.Companion companion9 = Result.Companion;
                                                    obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                                    if (Result.isFailure-impl(obj5)) {
                                                        obj5 = null;
                                                    }
                                                    deserializationStrategy = (KSerializer) obj5;
                                                    if (deserializationStrategy != null) {
                                                        try {
                                                            objDecodeFromString4 = MainAPIKt.getJson().decodeFromString(deserializationStrategy, innerStr);
                                                        } catch (SerializationException e3) {
                                                            ArchComponentExtKt.logError(e3);
                                                            ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                                                            objDecodeFromString4 = $this$readValue$iv$iv4.readValue(innerStr, new TypeReference<StreamUrl>() { // from class: com.cncverse.LivXowLiveEventsProvider$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$2
                                                            });
                                                        } catch (Throwable th10) {
                                                            ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                                                            objDecodeFromString4 = $this$readValue$iv$iv5.readValue(innerStr, new TypeReference<StreamUrl>() { // from class: com.cncverse.LivXowLiveEventsProvider$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$2
                                                            });
                                                        }
                                                    } else {
                                                        ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                                                        objDecodeFromString4 = $this$readValue$iv$iv6.readValue(innerStr, new TypeReference<StreamUrl>() { // from class: com.cncverse.LivXowLiveEventsProvider$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$2
                                                        });
                                                    }
                                                    streamUrls.add(objDecodeFromString4);
                                                    str2 = str3;
                                                    rawList2 = rawList;
                                                    str3 = str2;
                                                    str4 = str;
                                                }
                                            } catch (Throwable th11) {
                                                th = th11;
                                                str = str4;
                                            }
                                        }
                                        if (Result.isFailure-impl(obj5)) {
                                            obj5 = null;
                                        }
                                        deserializationStrategy = (KSerializer) obj5;
                                        if (deserializationStrategy != null) {
                                            objDecodeFromString4 = MainAPIKt.getJson().decodeFromString(deserializationStrategy, innerStr);
                                        } else {
                                            ObjectMapper $this$readValue$iv$iv7 = MainAPIKt.getMapper();
                                            objDecodeFromString4 = $this$readValue$iv$iv7.readValue(innerStr, new TypeReference<StreamUrl>() { // from class: com.cncverse.LivXowLiveEventsProvider$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$2
                                            });
                                        }
                                        streamUrls.add(objDecodeFromString4);
                                        str2 = str3;
                                    } else {
                                        str = str4;
                                        rawList = rawList2;
                                        it = it2;
                                        if (item.containsKey(str3)) {
                                            String innerStr2 = String.valueOf(item.get(str3));
                                            AppUtils appUtils3 = AppUtils.INSTANCE;
                                            try {
                                                Result.Companion companion10 = Result.Companion;
                                                KType kTypeTypeOf3 = Reflection.typeOf(StreamUrl.class);
                                                MagicApiIntrinsics.voidMagicApiCall(obj);
                                                obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                                            } catch (Throwable th12) {
                                                Result.Companion companion11 = Result.Companion;
                                                obj4 = Result.constructor-impl(ResultKt.createFailure(th12));
                                            }
                                            if (Result.exceptionOrNull-impl(obj4) == null) {
                                                str2 = str3;
                                            } else {
                                                try {
                                                    Result.Companion companion12 = Result.Companion;
                                                    str2 = str3;
                                                    try {
                                                        obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(StreamUrl.class), (List) null, 2, (Object) null));
                                                    } catch (Throwable th13) {
                                                        th = th13;
                                                        Result.Companion companion13 = Result.Companion;
                                                        obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                                    }
                                                } catch (Throwable th14) {
                                                    th = th14;
                                                    str2 = str3;
                                                }
                                            }
                                            if (Result.isFailure-impl(obj4)) {
                                                obj4 = null;
                                            }
                                            DeserializationStrategy deserializationStrategy3 = (KSerializer) obj4;
                                            if (deserializationStrategy3 != null) {
                                                try {
                                                    objDecodeFromString3 = MainAPIKt.getJson().decodeFromString(deserializationStrategy3, innerStr2);
                                                } catch (SerializationException e4) {
                                                    ArchComponentExtKt.logError(e4);
                                                    ObjectMapper $this$readValue$iv$iv8 = MainAPIKt.getMapper();
                                                    objDecodeFromString3 = $this$readValue$iv$iv8.readValue(innerStr2, new TypeReference<StreamUrl>() { // from class: com.cncverse.LivXowLiveEventsProvider$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$3
                                                    });
                                                } catch (Throwable th15) {
                                                    ObjectMapper $this$readValue$iv$iv9 = MainAPIKt.getMapper();
                                                    objDecodeFromString3 = $this$readValue$iv$iv9.readValue(innerStr2, new TypeReference<StreamUrl>() { // from class: com.cncverse.LivXowLiveEventsProvider$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$3
                                                    });
                                                }
                                            } else {
                                                ObjectMapper $this$readValue$iv$iv10 = MainAPIKt.getMapper();
                                                objDecodeFromString3 = $this$readValue$iv$iv10.readValue(innerStr2, new TypeReference<StreamUrl>() { // from class: com.cncverse.LivXowLiveEventsProvider$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$3
                                                });
                                            }
                                            streamUrls.add(objDecodeFromString3);
                                        } else {
                                            str2 = str3;
                                            String flatJson = AppUtils.INSTANCE.toJson(item);
                                            AppUtils appUtils4 = AppUtils.INSTANCE;
                                            try {
                                                Result.Companion companion14 = Result.Companion;
                                                KType kTypeTypeOf4 = Reflection.typeOf(StreamUrl.class);
                                                MagicApiIntrinsics.voidMagicApiCall(obj);
                                                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                                            } catch (Throwable th16) {
                                                Result.Companion companion15 = Result.Companion;
                                                obj3 = Result.constructor-impl(ResultKt.createFailure(th16));
                                            }
                                            if (Result.exceptionOrNull-impl(obj3) != null) {
                                                try {
                                                    Result.Companion companion16 = Result.Companion;
                                                    try {
                                                        obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(StreamUrl.class), (List) null, 2, (Object) null));
                                                    } catch (Throwable th17) {
                                                        th = th17;
                                                        Result.Companion companion17 = Result.Companion;
                                                        obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                                    }
                                                } catch (Throwable th18) {
                                                    th = th18;
                                                }
                                            }
                                            if (Result.isFailure-impl(obj3)) {
                                                obj3 = null;
                                            }
                                            DeserializationStrategy deserializationStrategy4 = (KSerializer) obj3;
                                            if (deserializationStrategy4 != null) {
                                                try {
                                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy4, flatJson);
                                                } catch (SerializationException e5) {
                                                    ArchComponentExtKt.logError(e5);
                                                    ObjectMapper $this$readValue$iv$iv11 = MainAPIKt.getMapper();
                                                    objDecodeFromString2 = $this$readValue$iv$iv11.readValue(flatJson, new TypeReference<StreamUrl>() { // from class: com.cncverse.LivXowLiveEventsProvider$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$4
                                                    });
                                                } catch (Throwable th19) {
                                                    ObjectMapper $this$readValue$iv$iv12 = MainAPIKt.getMapper();
                                                    objDecodeFromString2 = $this$readValue$iv$iv12.readValue(flatJson, new TypeReference<StreamUrl>() { // from class: com.cncverse.LivXowLiveEventsProvider$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$4
                                                    });
                                                }
                                            } else {
                                                ObjectMapper $this$readValue$iv$iv13 = MainAPIKt.getMapper();
                                                objDecodeFromString2 = $this$readValue$iv$iv13.readValue(flatJson, new TypeReference<StreamUrl>() { // from class: com.cncverse.LivXowLiveEventsProvider$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$4
                                                });
                                            }
                                            streamUrls.add(objDecodeFromString2);
                                        }
                                    }
                                    rawList2 = rawList;
                                    str3 = str2;
                                    str4 = str;
                                }
                                return new ChannelStreamResponse(streamUrls, null, null, null);
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } else {
                            System.out.println((Object) ("SKTech: Failed to decrypt channel data for " + this.$slug));
                            return null;
                        }
                    } else {
                        return null;
                    }
                } else {
                    System.out.println((Object) ("SKTech: HTTP error " + response.code() + " fetching channel " + this.$slug));
                    return null;
                }
            } catch (Exception e7) {
                System.out.println((Object) ("SKTech: Exception fetching channel streams: " + e7.getMessage()));
                e7.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchChannelStreams(String slug, Continuation<? super ChannelStreamResponse> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00062(slug, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowLiveEventsProvider$fetchStreamFromTokenApi$2 */
    /* JADX INFO: compiled from: LivXowLiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowLiveEventsProvider$fetchStreamFromTokenApi$2", f = "LivXowLiveEventsProvider.kt", i = {}, l = {953, 954, 955, 956, 957, 958}, m = "invokeSuspend", n = {}, nl = {954, 955, 956, 957, 958, 952}, s = {}, v = 2)
    static final class C00112 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ TokenApiConfig $config;
        int label;
        final /* synthetic */ LivXowLiveEventsProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00112(TokenApiConfig tokenApiConfig, LivXowLiveEventsProvider livXowLiveEventsProvider, Continuation<? super C00112> continuation) {
            super(2, continuation);
            this.$config = tokenApiConfig;
            this.this$0 = livXowLiveEventsProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00112(this.$config, this.this$0, continuation);
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
        return BuildersKt.withContext(Dispatchers.getIO(), new C00112(config, this, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowLiveEventsProvider$handleEmbedExtraction$2 */
    /* JADX INFO: compiled from: LivXowLiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowLiveEventsProvider$handleEmbedExtraction$2", f = "LivXowLiveEventsProvider.kt", i = {0}, l = {992}, m = "invokeSuspend", n = {"embedUrl"}, nl = {993}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nLivXowLiveEventsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LivXowLiveEventsProvider.kt\ncom/cncverse/LivXowLiveEventsProvider$handleEmbedExtraction$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1387:1\n1#2:1388\n*E\n"})
    static final class C00172 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ TokenApiConfig $config;
        Object L$0;
        int label;
        final /* synthetic */ LivXowLiveEventsProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00172(TokenApiConfig tokenApiConfig, LivXowLiveEventsProvider livXowLiveEventsProvider, Continuation<? super C00172> continuation) {
            super(2, continuation);
            this.$config = tokenApiConfig;
            this.this$0 = livXowLiveEventsProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00172(this.$config, this.this$0, continuation);
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
        return BuildersKt.withContext(Dispatchers.getIO(), new C00172(config, this, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowLiveEventsProvider$loadEmbedInWebView$2 */
    /* JADX INFO: compiled from: LivXowLiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowLiveEventsProvider$loadEmbedInWebView$2", f = "LivXowLiveEventsProvider.kt", i = {}, l = {1006}, m = "invokeSuspend", n = {}, nl = {1147}, s = {}, v = 2)
    static final class C00252 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $embedUrl;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00252(String str, Continuation<? super C00252> continuation) {
            super(2, continuation);
            this.$embedUrl = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00252(this.$embedUrl, continuation);
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
                        Context context = LivXowLiveEventsProvider.INSTANCE.getContext();
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
                            webView.addJavascriptInterface(new Object() { // from class: com.cncverse.LivXowLiveEventsProvider$loadEmbedInWebView$2$1$bridge$1
                                @JavascriptInterface
                                public final void onStreamUrlFound(final String url) {
                                    System.out.println((Object) ("SKTech: JavaScript bridge received stream URL: " + url));
                                    if (!urlCaptured.element && !StringsKt.isBlank(url)) {
                                        urlCaptured.element = true;
                                        capturedUrl.element = url;
                                        Handler handler = new Handler(Looper.getMainLooper());
                                        final WebView webView2 = webView;
                                        final Continuation<String> continuation2 = continuation;
                                        handler.post(new Runnable() { // from class: com.cncverse.LivXowLiveEventsProvider$loadEmbedInWebView$2$1$bridge$1$onStreamUrlFound$1
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
                            webView.setWebViewClient(new WebViewClient() { // from class: com.cncverse.LivXowLiveEventsProvider$loadEmbedInWebView$2$1$1
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
                                            handler.post(new Runnable() { // from class: com.cncverse.LivXowLiveEventsProvider$loadEmbedInWebView$2$1$1$shouldInterceptRequest$1
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
                                        handler.postDelayed(new Runnable() { // from class: com.cncverse.LivXowLiveEventsProvider$loadEmbedInWebView$2$1$1$onPageFinished$1
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
                                        handler2.postDelayed(new Runnable() { // from class: com.cncverse.LivXowLiveEventsProvider$loadEmbedInWebView$2$1$1$onPageFinished$2
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
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.cncverse.LivXowLiveEventsProvider$loadEmbedInWebView$2$1$2
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
        return BuildersKt.withContext(Dispatchers.getMain(), new C00252(embedUrl, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowLiveEventsProvider$handleJsonExtraction$2 */
    /* JADX INFO: compiled from: LivXowLiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowLiveEventsProvider$handleJsonExtraction$2", f = "LivXowLiveEventsProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nLivXowLiveEventsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LivXowLiveEventsProvider.kt\ncom/cncverse/LivXowLiveEventsProvider$handleJsonExtraction$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,1387:1\n63#2:1388\n64#2,15:1390\n1#3:1389\n50#4:1405\n43#4:1406\n*S KotlinDebug\n*F\n+ 1 LivXowLiveEventsProvider.kt\ncom/cncverse/LivXowLiveEventsProvider$handleJsonExtraction$2\n*L\n1173#1:1388\n1173#1:1390,15\n1173#1:1389\n1173#1:1405\n1173#1:1406\n*E\n"})
    static final class C00192 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ TokenApiConfig $config;
        int label;
        final /* synthetic */ LivXowLiveEventsProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00192(TokenApiConfig tokenApiConfig, LivXowLiveEventsProvider livXowLiveEventsProvider, Continuation<? super C00192> continuation) {
            super(2, continuation);
            this.$config = tokenApiConfig;
            this.this$0 = livXowLiveEventsProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00192(this.$config, this.this$0, continuation);
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
                                            objDecodeFromString = $this$readValue$iv$iv.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.LivXowLiveEventsProvider$handleJsonExtraction$2$invokeSuspend$$inlined$parseJson$1
                                            });
                                        } catch (Throwable th3) {
                                            ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                            objDecodeFromString = $this$readValue$iv$iv2.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.LivXowLiveEventsProvider$handleJsonExtraction$2$invokeSuspend$$inlined$parseJson$1
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
                                        objDecodeFromString = $this$readValue$iv$iv3.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.LivXowLiveEventsProvider$handleJsonExtraction$2$invokeSuspend$$inlined$parseJson$1
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
        return BuildersKt.withContext(Dispatchers.getIO(), new C00192(config, this, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowLiveEventsProvider$handleHtmlExtraction$2 */
    /* JADX INFO: compiled from: LivXowLiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowLiveEventsProvider$handleHtmlExtraction$2", f = "LivXowLiveEventsProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00182 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ TokenApiConfig $config;
        int label;
        final /* synthetic */ LivXowLiveEventsProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00182(TokenApiConfig tokenApiConfig, LivXowLiveEventsProvider livXowLiveEventsProvider, Continuation<? super C00182> continuation) {
            super(2, continuation);
            this.$config = tokenApiConfig;
            this.this$0 = livXowLiveEventsProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00182(this.$config, this.this$0, continuation);
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
        return BuildersKt.withContext(Dispatchers.getIO(), new C00182(config, this, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowLiveEventsProvider$handleYoutubeExtraction$2 */
    /* JADX INFO: compiled from: LivXowLiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowLiveEventsProvider$handleYoutubeExtraction$2", f = "LivXowLiveEventsProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00232 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ TokenApiConfig $config;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00232(TokenApiConfig tokenApiConfig, Continuation<? super C00232> continuation) {
            super(2, continuation);
            this.$config = tokenApiConfig;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00232(this.$config, continuation);
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
        return BuildersKt.withContext(Dispatchers.getIO(), new C00232(config, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowLiveEventsProvider$handleLocationServiceExtraction$2 */
    /* JADX INFO: compiled from: LivXowLiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowLiveEventsProvider$handleLocationServiceExtraction$2", f = "LivXowLiveEventsProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nLivXowLiveEventsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LivXowLiveEventsProvider.kt\ncom/cncverse/LivXowLiveEventsProvider$handleLocationServiceExtraction$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,1387:1\n63#2:1388\n64#2,15:1390\n1#3:1389\n50#4:1405\n43#4:1406\n*S KotlinDebug\n*F\n+ 1 LivXowLiveEventsProvider.kt\ncom/cncverse/LivXowLiveEventsProvider$handleLocationServiceExtraction$2\n*L\n1286#1:1388\n1286#1:1390,15\n1286#1:1389\n1286#1:1405\n1286#1:1406\n*E\n"})
    static final class C00212 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ TokenApiConfig $config;
        int label;
        final /* synthetic */ LivXowLiveEventsProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00212(TokenApiConfig tokenApiConfig, LivXowLiveEventsProvider livXowLiveEventsProvider, Continuation<? super C00212> continuation) {
            super(2, continuation);
            this.$config = tokenApiConfig;
            this.this$0 = livXowLiveEventsProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00212(this.$config, this.this$0, continuation);
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
                                            objDecodeFromString = $this$readValue$iv$iv.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.LivXowLiveEventsProvider$handleLocationServiceExtraction$2$invokeSuspend$$inlined$parseJson$1
                                            });
                                        } catch (Throwable th3) {
                                            ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                            objDecodeFromString = $this$readValue$iv$iv2.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.LivXowLiveEventsProvider$handleLocationServiceExtraction$2$invokeSuspend$$inlined$parseJson$1
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
                                        objDecodeFromString = $this$readValue$iv$iv3.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.LivXowLiveEventsProvider$handleLocationServiceExtraction$2$invokeSuspend$$inlined$parseJson$1
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
        return BuildersKt.withContext(Dispatchers.getIO(), new C00212(config, this, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowLiveEventsProvider$handleDirectApiCall$2 */
    /* JADX INFO: compiled from: LivXowLiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowLiveEventsProvider$handleDirectApiCall$2", f = "LivXowLiveEventsProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nLivXowLiveEventsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LivXowLiveEventsProvider.kt\ncom/cncverse/LivXowLiveEventsProvider$handleDirectApiCall$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,1387:1\n63#2:1388\n64#2,15:1390\n1#3:1389\n50#4:1405\n43#4:1406\n*S KotlinDebug\n*F\n+ 1 LivXowLiveEventsProvider.kt\ncom/cncverse/LivXowLiveEventsProvider$handleDirectApiCall$2\n*L\n1328#1:1388\n1328#1:1390,15\n1328#1:1389\n1328#1:1405\n1328#1:1406\n*E\n"})
    static final class C00152 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ TokenApiConfig $config;
        int label;
        final /* synthetic */ LivXowLiveEventsProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00152(TokenApiConfig tokenApiConfig, LivXowLiveEventsProvider livXowLiveEventsProvider, Continuation<? super C00152> continuation) {
            super(2, continuation);
            this.$config = tokenApiConfig;
            this.this$0 = livXowLiveEventsProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00152(this.$config, this.this$0, continuation);
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
                                            objDecodeFromString = $this$readValue$iv$iv.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.LivXowLiveEventsProvider$handleDirectApiCall$2$invokeSuspend$$inlined$parseJson$1
                                            });
                                        } catch (Throwable th3) {
                                            ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                            objDecodeFromString = $this$readValue$iv$iv2.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.LivXowLiveEventsProvider$handleDirectApiCall$2$invokeSuspend$$inlined$parseJson$1
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
                                        objDecodeFromString = $this$readValue$iv$iv3.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.LivXowLiveEventsProvider$handleDirectApiCall$2$invokeSuspend$$inlined$parseJson$1
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
        return BuildersKt.withContext(Dispatchers.getIO(), new C00152(config, this, null), continuation);
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
