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
import com.lagradost.cloudstream3.utils.DrmExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
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
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
import kotlin.text.CharsKt;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PlayFyLiveEvents.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/PlayFyProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 L2\u00020\u0001:\u0002LMB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H\u0002J\u001e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0096@¢\u0006\u0002\u0010,J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u00101J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u00101JF\u00105\u001a\u00020\u00132\u0006\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00132\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;092\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020;09H\u0096@¢\u0006\u0002\u0010>JP\u0010?\u001a\u00020;2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020;092\u0006\u0010@\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030B2\b\u0010C\u001a\u0004\u0018\u00010\u0003H\u0082@¢\u0006\u0002\u0010DJ\u0012\u0010E\u001a\u0004\u0018\u00010\u00032\u0006\u0010F\u001a\u00020\u0003H\u0002J(\u0010G\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030B0H2\u0006\u0010I\u001a\u00020\u0003H\u0002J\u0018\u0010J\u001a\u0004\u0018\u00010\u00032\u0006\u0010K\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u00101R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u001a\u0010\u000f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/cncverse/PlayFyLiveEvents;", "Lcom/lagradost/cloudstream3/MainAPI;", "name", "", "mode", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getMode", "mainUrl", "getMainUrl", "setMainUrl", "lang", "getLang", "setLang", "hasMainPage", "", "getHasMainPage", "()Z", "hasChromecastSupport", "getHasChromecastSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "client", "Lokhttp3/OkHttpClient;", "createDisplayTitle", "ch", "Lcom/cncverse/PlayFyChannel;", "getEventStatus", "isEventLive", "isEventEnded", "generateMatchCardUrl", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitLink", "serverName", "headers", "", "api", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hexToBase64", "hex", "parseStreamLink", "Lkotlin/Pair;", "link", "loadEmbedInWebView", "embedUrl", "Companion", "PlayFyLoadData", "PlayFyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPlayFyLiveEvents.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayFyLiveEvents.kt\ncom/cncverse/PlayFyLiveEvents\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 7 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,476:1\n1#2:477\n1#2:509\n1#2:528\n1512#3:478\n1538#3,3:479\n1541#3,3:489\n1586#3:495\n1661#3,3:496\n1068#3:500\n777#3:501\n873#3,2:502\n1586#3:504\n1661#3,3:505\n1915#3,2:546\n1586#3:548\n1661#3,3:549\n1915#3,2:552\n383#4,7:482\n129#5:492\n158#5,2:493\n160#5:499\n63#6:508\n64#6,15:510\n63#6:527\n64#6,15:529\n50#7:525\n43#7:526\n50#7:544\n43#7:545\n*S KotlinDebug\n*F\n+ 1 PlayFyLiveEvents.kt\ncom/cncverse/PlayFyLiveEvents\n*L\n261#1:509\n293#1:528\n174#1:478\n174#1:479,3\n174#1:489,3\n201#1:495\n201#1:496,3\n226#1:500\n242#1:501\n242#1:502,2\n245#1:504\n245#1:505,3\n297#1:546,2\n378#1:548\n378#1:549,3\n391#1:552,2\n174#1:482,7\n176#1:492\n176#1:493,2\n176#1:499\n261#1:508\n261#1:510,15\n293#1:527\n293#1:529,15\n261#1:525\n261#1:526\n293#1:544\n293#1:545\n*E\n"})
public final class PlayFyLiveEvents extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static Context context;

    @NotNull
    private final OkHttpClient client;
    private final boolean hasChromecastSupport;
    private final boolean hasMainPage;

    @NotNull
    private String lang;

    @NotNull
    private String mainUrl;

    @NotNull
    private final String mode;

    @NotNull
    private String name;

    @NotNull
    private final Set<TvType> supportedTypes;

    /* JADX INFO: renamed from: com.cncverse.PlayFyLiveEvents$emitLink$1 */
    /* JADX INFO: compiled from: PlayFyLiveEvents.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayFyLiveEvents", f = "PlayFyLiveEvents.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {342, 350, 358, 366}, m = "emitLink", n = {"callback", "serverName", "url", "headers", "api", "drmInfo", "kidB64", "keyB64", "callback", "serverName", "url", "headers", "api", "drmInfo", "callback", "serverName", "url", "headers", "api", "h", "callback", "serverName", "url", "headers", "api", "h"}, nl = {347, 355, 364, 372}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00151 extends ContinuationImpl {
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

        C00151(Continuation<? super C00151> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayFyLiveEvents.this.emitLink(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PlayFyLiveEvents$getMainPage$1 */
    /* JADX INFO: compiled from: PlayFyLiveEvents.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayFyLiveEvents", f = "PlayFyLiveEvents.kt", i = {0, 0, 1, 1}, l = {168, 170}, m = "getMainPage", n = {"request", "page", "request", "page"}, nl = {170, 167}, s = {"L$0", "I$0", "L$0", "I$0"}, v = 2)
    static final class C00201 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00201(Continuation<? super C00201> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayFyLiveEvents.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PlayFyLiveEvents$loadLinks$1 */
    /* JADX INFO: compiled from: PlayFyLiveEvents.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayFyLiveEvents", f = "PlayFyLiveEvents.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {294, 306, 309, 316}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "loadData", "isCasting", "data", "subtitleCallback", "callback", "loadData", "streams", "$this$forEach$iv", "element$iv", "stream", "serverName", "embedUrl", "isCasting", "$i$f$forEach", "$i$a$-forEach-PlayFyLiveEvents$loadLinks$2", "data", "subtitleCallback", "callback", "loadData", "streams", "$this$forEach$iv", "element$iv", "stream", "serverName", "extracted", "url", "headers", "embedUrl", "isCasting", "$i$f$forEach", "$i$a$-forEach-PlayFyLiveEvents$loadLinks$2", "data", "subtitleCallback", "callback", "loadData", "streams", "$this$forEach$iv", "element$iv", "stream", "serverName", "headers", "url", "rawLink", "isCasting", "$i$f$forEach", "$i$a$-forEach-PlayFyLiveEvents$loadLinks$2"}, nl = {295, 307, 313, 319}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "Z$0", "I$0", "I$1"}, v = 2)
    static final class C00251 extends ContinuationImpl {
        int I$0;
        int I$1;
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

        C00251(Continuation<? super C00251> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayFyLiveEvents.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PlayFyLiveEvents$search$1 */
    /* JADX INFO: compiled from: PlayFyLiveEvents.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayFyLiveEvents", f = "PlayFyLiveEvents.kt", i = {0}, l = {241}, m = "search", n = {"query"}, nl = {242}, s = {"L$0"}, v = 2)
    static final class C00261 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00261(Continuation<? super C00261> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayFyLiveEvents.this.search(null, (Continuation) this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PlayFyLiveEvents() {
        String str = null;
        this(str, str, 3, str);
    }

    public PlayFyLiveEvents(@NotNull String name, @NotNull String mode) {
        this.name = name;
        this.mode = mode;
        this.mainUrl = "https://reliablewebcenter.online";
        this.lang = "ta";
        this.hasMainPage = true;
        this.hasChromecastSupport = true;
        this.supportedTypes = SetsKt.setOf(TvType.Live);
        this.client = new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).build();
    }

    public /* synthetic */ PlayFyLiveEvents(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "⚡PlayFy Live Events" : str, (i & 2) != 0 ? "live" : str2);
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    @NotNull
    public final String getMode() {
        return this.mode;
    }

    /* JADX INFO: compiled from: PlayFyLiveEvents.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/cncverse/PlayFyLiveEvents$Companion;", "", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "PlayFyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Context getContext() {
            return PlayFyLiveEvents.context;
        }

        public final void setContext(@Nullable Context context) {
            PlayFyLiveEvents.context = context;
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

    /* JADX INFO: compiled from: PlayFyLiveEvents.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003JM\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0001J\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/cncverse/PlayFyLiveEvents$PlayFyLoadData;", "", "channelId", "", "title", "poster", "category", "eventInfo", "Lcom/cncverse/PlayFyEventInfo;", "formats", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/cncverse/PlayFyEventInfo;Ljava/util/List;)V", "getChannelId", "()Ljava/lang/String;", "getTitle", "getPoster", "getCategory", "getEventInfo", "()Lcom/cncverse/PlayFyEventInfo;", "getFormats", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "PlayFyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class PlayFyLoadData {

        @NotNull
        private final String category;

        @NotNull
        private final String channelId;

        @Nullable
        private final PlayFyEventInfo eventInfo;

        @NotNull
        private final List<String> formats;

        @NotNull
        private final String poster;

        @NotNull
        private final String title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PlayFyLoadData copy$default(PlayFyLoadData playFyLoadData, String str, String str2, String str3, String str4, PlayFyEventInfo playFyEventInfo, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = playFyLoadData.channelId;
            }
            if ((i & 2) != 0) {
                str2 = playFyLoadData.title;
            }
            if ((i & 4) != 0) {
                str3 = playFyLoadData.poster;
            }
            if ((i & 8) != 0) {
                str4 = playFyLoadData.category;
            }
            if ((i & 16) != 0) {
                playFyEventInfo = playFyLoadData.eventInfo;
            }
            if ((i & 32) != 0) {
                list = playFyLoadData.formats;
            }
            PlayFyEventInfo playFyEventInfo2 = playFyEventInfo;
            List list2 = list;
            return playFyLoadData.copy(str, str2, str3, str4, playFyEventInfo2, list2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
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
        public final String getCategory() {
            return this.category;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final PlayFyEventInfo getEventInfo() {
            return this.eventInfo;
        }

        @NotNull
        public final List<String> component6() {
            return this.formats;
        }

        @NotNull
        public final PlayFyLoadData copy(@NotNull String channelId, @NotNull String title, @NotNull String poster, @NotNull String category, @Nullable PlayFyEventInfo eventInfo, @NotNull List<String> formats) {
            return new PlayFyLoadData(channelId, title, poster, category, eventInfo, formats);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PlayFyLoadData)) {
                return false;
            }
            PlayFyLoadData playFyLoadData = (PlayFyLoadData) other;
            return Intrinsics.areEqual(this.channelId, playFyLoadData.channelId) && Intrinsics.areEqual(this.title, playFyLoadData.title) && Intrinsics.areEqual(this.poster, playFyLoadData.poster) && Intrinsics.areEqual(this.category, playFyLoadData.category) && Intrinsics.areEqual(this.eventInfo, playFyLoadData.eventInfo) && Intrinsics.areEqual(this.formats, playFyLoadData.formats);
        }

        public int hashCode() {
            return (((((((((this.channelId.hashCode() * 31) + this.title.hashCode()) * 31) + this.poster.hashCode()) * 31) + this.category.hashCode()) * 31) + (this.eventInfo == null ? 0 : this.eventInfo.hashCode())) * 31) + this.formats.hashCode();
        }

        @NotNull
        public String toString() {
            return "PlayFyLoadData(channelId=" + this.channelId + ", title=" + this.title + ", poster=" + this.poster + ", category=" + this.category + ", eventInfo=" + this.eventInfo + ", formats=" + this.formats + ')';
        }

        public PlayFyLoadData(@NotNull String channelId, @NotNull String title, @NotNull String poster, @NotNull String category, @Nullable PlayFyEventInfo eventInfo, @NotNull List<String> list) {
            this.channelId = channelId;
            this.title = title;
            this.poster = poster;
            this.category = category;
            this.eventInfo = eventInfo;
            this.formats = list;
        }

        @NotNull
        public final String getChannelId() {
            return this.channelId;
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
        public final String getCategory() {
            return this.category;
        }

        @Nullable
        public final PlayFyEventInfo getEventInfo() {
            return this.eventInfo;
        }

        @NotNull
        public final List<String> getFormats() {
            return this.formats;
        }
    }

    private final String createDisplayTitle(PlayFyChannel ch) {
        PlayFyEventInfo info = ch.getEventInfo();
        if (info != null) {
            String teamA = info.getTeamA();
            if (!(teamA == null || StringsKt.isBlank(teamA))) {
                String teamB = info.getTeamB();
                if (!(teamB == null || StringsKt.isBlank(teamB))) {
                    if (!Intrinsics.areEqual(info.getTeamA(), info.getTeamB())) {
                        return info.getTeamA() + " vs " + info.getTeamB();
                    }
                    String teamA2 = info.getTeamA();
                    Intrinsics.checkNotNull(teamA2);
                    return teamA2;
                }
            }
        }
        String title = ch.getTitle();
        return title == null ? "Unknown" : title;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getEventStatus(PlayFyChannel ch) {
        Date date;
        Date date2;
        PlayFyEventInfo info = ch.getEventInfo();
        if (info == null) {
            return "";
        }
        long now = System.currentTimeMillis();
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
            String it = info.getStartTime();
            Long end = null;
            Long start = (it == null || (date2 = fmt.parse(it)) == null) ? null : Long.valueOf(date2.getTime());
            String it2 = info.getEndTime();
            if (it2 != null && (date = fmt.parse(it2)) != null) {
                end = Long.valueOf(date.getTime());
            }
            if (end != null && now >= end.longValue()) {
                return "✅";
            }
            if (start == null || now < start.longValue()) {
                return (start == null || now >= start.longValue()) ? "" : "🔜";
            }
            return "🔴";
        } catch (Exception e) {
            return "";
        }
    }

    private final boolean isEventLive(PlayFyChannel ch) {
        Date date;
        Date date2;
        PlayFyEventInfo info = ch.getEventInfo();
        if (info == null) {
            return false;
        }
        long now = System.currentTimeMillis();
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
            String it = info.getStartTime();
            Long end = null;
            Long start = (it == null || (date2 = fmt.parse(it)) == null) ? null : Long.valueOf(date2.getTime());
            String it2 = info.getEndTime();
            if (it2 != null && (date = fmt.parse(it2)) != null) {
                end = Long.valueOf(date.getTime());
            }
            return (end == null || now < end.longValue()) && start != null && now >= start.longValue();
        } catch (Exception e) {
            return false;
        }
    }

    private final boolean isEventEnded(PlayFyChannel ch) {
        Date date;
        PlayFyEventInfo info = ch.getEventInfo();
        if (info == null) {
            return false;
        }
        long now = System.currentTimeMillis();
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
            String it = info.getEndTime();
            Long end = null;
            if (it != null && (date = fmt.parse(it)) != null) {
                end = Long.valueOf(date.getTime());
            }
            return end != null && now >= end.longValue();
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x009f  */
    private final String generateMatchCardUrl(PlayFyChannel ch) throws UnsupportedEncodingException {
        String title;
        String teamA;
        String teamB;
        String teamAFlag;
        String teamBFlag;
        String eventBanner;
        String it;
        PlayFyEventInfo info = ch.getEventInfo();
        String time = "";
        if ((info == null || (title = info.getEventName()) == null) && (title = ch.getTitle()) == null) {
            title = "";
        }
        String title2 = URLEncoder.encode(title, "UTF-8");
        if (info == null || (teamA = info.getTeamA()) == null) {
            teamA = "Team A";
        }
        String teamA2 = URLEncoder.encode(teamA, "UTF-8");
        if (info == null || (teamB = info.getTeamB()) == null) {
            teamB = "Team B";
        }
        String teamB2 = URLEncoder.encode(teamB, "UTF-8");
        if (info == null || (teamAFlag = info.getTeamAFlag()) == null) {
            teamAFlag = "";
        }
        String teamAImg = teamAFlag;
        if (info == null || (teamBFlag = info.getTeamBFlag()) == null) {
            teamBFlag = "";
        }
        String teamBImg = teamBFlag;
        if (info == null || (eventBanner = info.getEventBanner()) == null) {
            eventBanner = "";
        }
        String eventLogo = eventBanner;
        boolean isLive = isEventLive(ch);
        boolean isEnded = isEventEnded(ch);
        if (info != null) {
            try {
                String it2 = info.getStartTime();
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
        if (!StringsKt.isBlank(eventLogo)) {
            $this$generateMatchCardUrl_u24lambda_u241.append("&eventLogo=" + eventLogo);
        }
        if (!StringsKt.isBlank(time)) {
            $this$generateMatchCardUrl_u24lambda_u241.append("&time=" + time);
        }
        $this$generateMatchCardUrl_u24lambda_u241.append("&isLive=" + isLive);
        $this$generateMatchCardUrl_u24lambda_u241.append("&isEnded=" + isEnded);
        return $this$generateMatchCardUrl_u24lambda_u241.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:102:0x0263 A[PHI: r5
      0x0263: PHI (r5v20 java.lang.String) = (r5v19 java.lang.String), (r5v26 java.lang.String) binds: [B:98:0x0258, B:100:0x025e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:105:0x026f  */
    /* JADX WARN: Code duplicated, block: B:116:0x0273 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:36:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:37:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:42:0x0112  */
    /* JADX WARN: Code duplicated, block: B:45:0x013e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0147  */
    /* JADX WARN: Code duplicated, block: B:49:0x014a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0153  */
    /* JADX WARN: Code duplicated, block: B:53:0x0156  */
    /* JADX WARN: Code duplicated, block: B:56:0x015f  */
    /* JADX WARN: Code duplicated, block: B:57:0x0162  */
    /* JADX WARN: Code duplicated, block: B:60:0x016b  */
    /* JADX WARN: Code duplicated, block: B:61:0x016e  */
    /* JADX WARN: Code duplicated, block: B:64:0x0177  */
    /* JADX WARN: Code duplicated, block: B:65:0x017a  */
    /* JADX WARN: Code duplicated, block: B:68:0x0183  */
    /* JADX WARN: Code duplicated, block: B:69:0x0186  */
    /* JADX WARN: Code duplicated, block: B:72:0x018f  */
    /* JADX WARN: Code duplicated, block: B:73:0x0192  */
    /* JADX WARN: Code duplicated, block: B:77:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:79:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:80:0x020e  */
    /* JADX WARN: Code duplicated, block: B:83:0x0221  */
    /* JADX WARN: Code duplicated, block: B:85:0x0229  */
    /* JADX WARN: Code duplicated, block: B:89:0x0232  */
    /* JADX WARN: Code duplicated, block: B:91:0x0235  */
    /* JADX WARN: Code duplicated, block: B:92:0x023c  */
    /* JADX WARN: Code duplicated, block: B:95:0x024d  */
    /* JADX WARN: Code duplicated, block: B:96:0x0250  */
    /* JADX WARN: Code duplicated, block: B:99:0x025a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws UnsupportedEncodingException {
        C00201 c00201;
        Object objFetchLiveEvents;
        MainPageRequest request2;
        Object objFetchHighlights;
        List channels;
        Map grouped;
        Map $this$map$iv;
        Collection destination$iv$iv;
        String lowerCase;
        String icon;
        Iterable $this$map$iv2;
        Collection destination$iv$iv2;
        Iterable $this$mapTo$iv$iv;
        Iterator it;
        Iterable $this$map$iv3;
        PlayFyChannel ch;
        String displayTitle;
        String status;
        String status2;
        String posterUrl;
        String id;
        String str;
        String category;
        String str2;
        List<String> formats;
        String image;
        boolean z;
        String category2;
        String str3;
        Object value$iv$iv$iv;
        Object answer$iv$iv$iv;
        int page2 = page;
        if (continuation instanceof C00201) {
            c00201 = (C00201) continuation;
            if ((c00201.label & Integer.MIN_VALUE) != 0) {
                c00201.label -= Integer.MIN_VALUE;
            } else {
                c00201 = new C00201(continuation);
            }
        } else {
            c00201 = new C00201(continuation);
        }
        Object $result = c00201.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00201.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DonationManager.INSTANCE.checkAndShow(getName());
                if (!Intrinsics.areEqual(this.mode, "highlights")) {
                    PlayFyProviderManager playFyProviderManager = PlayFyProviderManager.INSTANCE;
                    c00201.L$0 = SpillingKt.nullOutSpilledVariable(request);
                    c00201.I$0 = page2;
                    c00201.label = 2;
                    objFetchLiveEvents = playFyProviderManager.fetchLiveEvents(c00201);
                    if (objFetchLiveEvents == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    request2 = request;
                    channels = (List) objFetchLiveEvents;
                    List $this$groupBy$iv = channels;
                    grouped = new LinkedHashMap();
                    for (Object element$iv$iv : $this$groupBy$iv) {
                        PlayFyChannel it2 = (PlayFyChannel) element$iv$iv;
                        category2 = it2.getCategory();
                        if (category2 == null) {
                            category2 = "Other";
                        }
                        str3 = category2;
                        value$iv$iv$iv = grouped.get(str3);
                        if (value$iv$iv$iv == null) {
                            Object answer$iv$iv$iv2 = (List) new ArrayList();
                            answer$iv$iv$iv = answer$iv$iv$iv2;
                            grouped.put(str3, answer$iv$iv$iv);
                        } else {
                            answer$iv$iv$iv = value$iv$iv$iv;
                        }
                        List list$iv$iv = (List) answer$iv$iv$iv;
                        list$iv$iv.add(element$iv$iv);
                        page2 = page2;
                    }
                    $this$map$iv = grouped;
                    destination$iv$iv = new ArrayList($this$map$iv.size());
                    for (Map.Entry item$iv$iv : $this$map$iv.entrySet()) {
                        String category3 = (String) item$iv$iv.getKey();
                        List items = (List) item$iv$iv.getValue();
                        Map $this$map$iv4 = $this$map$iv;
                        lowerCase = category3.toLowerCase(Locale.ROOT);
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
                        C00201 c00202 = c00201;
                        final Comparator comparator = new Comparator() { // from class: com.cncverse.PlayFyLiveEvents$getMainPage$lambda$1$$inlined$compareBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                Integer num;
                                Integer num2;
                                PlayFyChannel ch2 = (PlayFyChannel) t;
                                if (StringsKt.contains$default(this.this$0.getEventStatus(ch2), "🔴", false, 2, (Object) null)) {
                                    num = (Comparable) 0;
                                } else if (StringsKt.contains$default(this.this$0.getEventStatus(ch2), "🔜", false, 2, (Object) null)) {
                                    num = (Comparable) 1;
                                } else {
                                    num = StringsKt.contains$default(this.this$0.getEventStatus(ch2), "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                                }
                                PlayFyChannel ch3 = (PlayFyChannel) t2;
                                if (StringsKt.contains$default(this.this$0.getEventStatus(ch3), "🔴", false, 2, (Object) null)) {
                                    num2 = (Comparable) 0;
                                } else if (StringsKt.contains$default(this.this$0.getEventStatus(ch3), "🔜", false, 2, (Object) null)) {
                                    num2 = (Comparable) 1;
                                } else {
                                    num2 = StringsKt.contains$default(this.this$0.getEventStatus(ch3), "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                                }
                                return ComparisonsKt.compareValues(num, num2);
                            }
                        };
                        Object $result2 = $result;
                        $this$map$iv2 = CollectionsKt.sortedWith(items, new Comparator() { // from class: com.cncverse.PlayFyLiveEvents$getMainPage$lambda$1$$inlined$thenBy$1
                            /* JADX WARN: Code duplicated, block: B:16:0x0043  */
                            /* JADX WARN: Code duplicated, block: B:31:0x0082  */
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                Long lValueOf;
                                Long lValueOf2;
                                long jLongValue;
                                String it3;
                                long jLongValue2;
                                String it4;
                                int previousCompare = comparator.compare(t, t2);
                                if (previousCompare != 0) {
                                    return previousCompare;
                                }
                                PlayFyChannel ch2 = (PlayFyChannel) t;
                                try {
                                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                    PlayFyEventInfo eventInfo = ch2.getEventInfo();
                                    if (eventInfo == null || (it4 = eventInfo.getStartTime()) == null) {
                                        jLongValue2 = Long.MAX_VALUE;
                                    } else {
                                        Date date = fmt.parse(it4);
                                        Long lValueOf3 = date != null ? Long.valueOf(date.getTime()) : null;
                                        if (lValueOf3 != null) {
                                            jLongValue2 = lValueOf3.longValue();
                                        } else {
                                            jLongValue2 = Long.MAX_VALUE;
                                        }
                                    }
                                    lValueOf = Long.valueOf(jLongValue2);
                                } catch (Exception e) {
                                    lValueOf = (Comparable) Long.MAX_VALUE;
                                }
                                PlayFyChannel ch3 = (PlayFyChannel) t2;
                                try {
                                    SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                    PlayFyEventInfo eventInfo2 = ch3.getEventInfo();
                                    if (eventInfo2 == null || (it3 = eventInfo2.getStartTime()) == null) {
                                        jLongValue = Long.MAX_VALUE;
                                    } else {
                                        Date date2 = fmt2.parse(it3);
                                        Long lValueOf4 = date2 != null ? Long.valueOf(date2.getTime()) : null;
                                        if (lValueOf4 != null) {
                                            jLongValue = lValueOf4.longValue();
                                        } else {
                                            jLongValue = Long.MAX_VALUE;
                                        }
                                    }
                                    lValueOf2 = Long.valueOf(jLongValue);
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
                                ch = (PlayFyChannel) it.next();
                                Iterable $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                                displayTitle = createDisplayTitle(ch);
                                MainPageRequest request3 = request2;
                                status = getEventStatus(ch);
                                if (StringsKt.isBlank(status)) {
                                    status2 = displayTitle;
                                } else {
                                    status2 = status + ' ' + displayTitle;
                                }
                                String fullTitle = status2;
                                if (Intrinsics.areEqual(ch.getCat(), "Custom")) {
                                    image = ch.getImage();
                                    if (image != null) {
                                        z = true;
                                    } else {
                                        z = true;
                                    }
                                    if (z) {
                                        posterUrl = generateMatchCardUrl(ch);
                                    } else {
                                        posterUrl = ch.getImage();
                                    }
                                } else {
                                    posterUrl = generateMatchCardUrl(ch);
                                }
                                id = ch.getId();
                                if (id == null) {
                                    str = "";
                                } else {
                                    str = id;
                                }
                                category = ch.getCategory();
                                if (category == null) {
                                    str2 = category;
                                } else {
                                    str2 = category;
                                }
                                PlayFyEventInfo eventInfo = ch.getEventInfo();
                                formats = ch.getFormats();
                                if (formats == null) {
                                    formats = CollectionsKt.emptyList();
                                }
                                PlayFyLoadData loadData = new PlayFyLoadData(str, displayTitle, posterUrl, str2, eventInfo, formats);
                                final String posterUrl2 = posterUrl;
                                destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle, AppUtils.INSTANCE.toJson(loadData), TvType.Live, false, new Function1() { // from class: com.cncverse.PlayFyLiveEvents$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj) {
                                        return PlayFyLiveEvents.getMainPage$lambda$1$2$0(posterUrl2, (LiveSearchResponse) obj);
                                    }
                                }, 8, (Object) null));
                                $this$map$iv2 = $this$map$iv3;
                                $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                                request2 = request3;
                                channels = channels;
                            }
                        }
                        List sorted = (List) destination$iv$iv2;
                        destination$iv$iv.add(new HomePageList(icon + ' ' + category3, sorted, true));
                        $this$map$iv = $this$map$iv4;
                        c00201 = c00202;
                        $result = $result2;
                        request2 = request2;
                    }
                    Iterable $this$sortedBy$iv = (List) destination$iv$iv;
                    List lists = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: com.cncverse.PlayFyLiveEvents$getMainPage$$inlined$sortedBy$1
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
                    return MainAPIKt.newHomePageResponse(lists, Boxing.boxBoolean(false));
                }
                PlayFyProviderManager playFyProviderManager2 = PlayFyProviderManager.INSTANCE;
                c00201.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00201.I$0 = page2;
                c00201.label = 1;
                objFetchHighlights = playFyProviderManager2.fetchHighlights(c00201);
                if (objFetchHighlights == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                channels = (List) objFetchHighlights;
                List $this$groupBy$iv2 = channels;
                grouped = new LinkedHashMap();
                while (r13.hasNext()) {
                    PlayFyChannel it3 = (PlayFyChannel) element$iv$iv;
                    category2 = it3.getCategory();
                    if (category2 == null && (category2 = it3.getCat()) == null) {
                        category2 = "Other";
                    }
                    str3 = category2;
                    value$iv$iv$iv = grouped.get(str3);
                    if (value$iv$iv$iv == null) {
                        Object answer$iv$iv$iv3 = (List) new ArrayList();
                        answer$iv$iv$iv = answer$iv$iv$iv3;
                        grouped.put(str3, answer$iv$iv$iv);
                    } else {
                        answer$iv$iv$iv = value$iv$iv$iv;
                    }
                    List list$iv$iv2 = (List) answer$iv$iv$iv;
                    list$iv$iv2.add(element$iv$iv);
                    page2 = page2;
                }
                $this$map$iv = grouped;
                destination$iv$iv = new ArrayList($this$map$iv.size());
                while (r12.hasNext()) {
                    String category4 = (String) item$iv$iv.getKey();
                    List items2 = (List) item$iv$iv.getValue();
                    Map $this$map$iv5 = $this$map$iv;
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
                    C00201 c00203 = c00201;
                    final Comparator comparator2 = new Comparator() { // from class: com.cncverse.PlayFyLiveEvents$getMainPage$lambda$1$$inlined$compareBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Integer num;
                            Integer num2;
                            PlayFyChannel ch2 = (PlayFyChannel) t;
                            if (StringsKt.contains$default(this.this$0.getEventStatus(ch2), "🔴", false, 2, (Object) null)) {
                                num = (Comparable) 0;
                            } else if (StringsKt.contains$default(this.this$0.getEventStatus(ch2), "🔜", false, 2, (Object) null)) {
                                num = (Comparable) 1;
                            } else {
                                num = StringsKt.contains$default(this.this$0.getEventStatus(ch2), "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                            }
                            PlayFyChannel ch3 = (PlayFyChannel) t2;
                            if (StringsKt.contains$default(this.this$0.getEventStatus(ch3), "🔴", false, 2, (Object) null)) {
                                num2 = (Comparable) 0;
                            } else if (StringsKt.contains$default(this.this$0.getEventStatus(ch3), "🔜", false, 2, (Object) null)) {
                                num2 = (Comparable) 1;
                            } else {
                                num2 = StringsKt.contains$default(this.this$0.getEventStatus(ch3), "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                            }
                            return ComparisonsKt.compareValues(num, num2);
                        }
                    };
                    Object $result3 = $result;
                    $this$map$iv2 = CollectionsKt.sortedWith(items2, new Comparator() { // from class: com.cncverse.PlayFyLiveEvents$getMainPage$lambda$1$$inlined$thenBy$1
                        /* JADX WARN: Code duplicated, block: B:16:0x0043  */
                        /* JADX WARN: Code duplicated, block: B:31:0x0082  */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Long lValueOf;
                            Long lValueOf2;
                            long jLongValue;
                            String it4;
                            long jLongValue2;
                            String it5;
                            int previousCompare = comparator2.compare(t, t2);
                            if (previousCompare != 0) {
                                return previousCompare;
                            }
                            PlayFyChannel ch2 = (PlayFyChannel) t;
                            try {
                                SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                PlayFyEventInfo eventInfo2 = ch2.getEventInfo();
                                if (eventInfo2 == null || (it5 = eventInfo2.getStartTime()) == null) {
                                    jLongValue2 = Long.MAX_VALUE;
                                } else {
                                    Date date = fmt.parse(it5);
                                    Long lValueOf3 = date != null ? Long.valueOf(date.getTime()) : null;
                                    if (lValueOf3 != null) {
                                        jLongValue2 = lValueOf3.longValue();
                                    } else {
                                        jLongValue2 = Long.MAX_VALUE;
                                    }
                                }
                                lValueOf = Long.valueOf(jLongValue2);
                            } catch (Exception e) {
                                lValueOf = (Comparable) Long.MAX_VALUE;
                            }
                            PlayFyChannel ch3 = (PlayFyChannel) t2;
                            try {
                                SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                PlayFyEventInfo eventInfo3 = ch3.getEventInfo();
                                if (eventInfo3 == null || (it4 = eventInfo3.getStartTime()) == null) {
                                    jLongValue = Long.MAX_VALUE;
                                } else {
                                    Date date2 = fmt2.parse(it4);
                                    Long lValueOf4 = date2 != null ? Long.valueOf(date2.getTime()) : null;
                                    if (lValueOf4 != null) {
                                        jLongValue = lValueOf4.longValue();
                                    } else {
                                        jLongValue = Long.MAX_VALUE;
                                    }
                                }
                                lValueOf2 = Long.valueOf(jLongValue);
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
                            ch = (PlayFyChannel) it.next();
                            Iterable $this$mapTo$iv$iv3 = $this$mapTo$iv$iv;
                            displayTitle = createDisplayTitle(ch);
                            MainPageRequest request4 = request2;
                            status = getEventStatus(ch);
                            if (StringsKt.isBlank(status)) {
                                status2 = status + ' ' + displayTitle;
                            } else {
                                status2 = displayTitle;
                            }
                            String fullTitle2 = status2;
                            if (Intrinsics.areEqual(ch.getCat(), "Custom")) {
                                posterUrl = generateMatchCardUrl(ch);
                            } else {
                                image = ch.getImage();
                                if (image != null || StringsKt.isBlank(image)) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    posterUrl = ch.getImage();
                                } else {
                                    posterUrl = generateMatchCardUrl(ch);
                                }
                            }
                            id = ch.getId();
                            if (id == null) {
                                str = "";
                            } else {
                                str = id;
                            }
                            category = ch.getCategory();
                            if (category == null || (category = ch.getCat()) != null) {
                                str2 = category;
                            } else {
                                str2 = "";
                            }
                            PlayFyEventInfo eventInfo2 = ch.getEventInfo();
                            formats = ch.getFormats();
                            if (formats == null) {
                                formats = CollectionsKt.emptyList();
                            }
                            PlayFyLoadData loadData2 = new PlayFyLoadData(str, displayTitle, posterUrl, str2, eventInfo2, formats);
                            final String posterUrl3 = posterUrl;
                            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle2, AppUtils.INSTANCE.toJson(loadData2), TvType.Live, false, new Function1() { // from class: com.cncverse.PlayFyLiveEvents$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    return PlayFyLiveEvents.getMainPage$lambda$1$2$0(posterUrl3, (LiveSearchResponse) obj);
                                }
                            }, 8, (Object) null));
                            $this$map$iv2 = $this$map$iv3;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv3;
                            request2 = request4;
                            channels = channels;
                        }
                    }
                    List sorted2 = (List) destination$iv$iv2;
                    destination$iv$iv.add(new HomePageList(icon + ' ' + category4, sorted2, true));
                    $this$map$iv = $this$map$iv5;
                    c00201 = c00203;
                    $result = $result3;
                    request2 = request2;
                }
                Iterable $this$sortedBy$iv2 = (List) destination$iv$iv;
                List lists2 = CollectionsKt.sortedWith($this$sortedBy$iv2, new Comparator() { // from class: com.cncverse.PlayFyLiveEvents$getMainPage$$inlined$sortedBy$1
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
                return MainAPIKt.newHomePageResponse(lists2, Boxing.boxBoolean(false));
            case 1:
                page2 = c00201.I$0;
                request2 = (MainPageRequest) c00201.L$0;
                ResultKt.throwOnFailure($result);
                objFetchHighlights = $result;
                channels = (List) objFetchHighlights;
                List $this$groupBy$iv3 = channels;
                grouped = new LinkedHashMap();
                while (r13.hasNext()) {
                    PlayFyChannel it4 = (PlayFyChannel) element$iv$iv;
                    category2 = it4.getCategory();
                    if (category2 == null) {
                        category2 = "Other";
                    }
                    str3 = category2;
                    value$iv$iv$iv = grouped.get(str3);
                    if (value$iv$iv$iv == null) {
                        Object answer$iv$iv$iv4 = (List) new ArrayList();
                        answer$iv$iv$iv = answer$iv$iv$iv4;
                        grouped.put(str3, answer$iv$iv$iv);
                    } else {
                        answer$iv$iv$iv = value$iv$iv$iv;
                    }
                    List list$iv$iv3 = (List) answer$iv$iv$iv;
                    list$iv$iv3.add(element$iv$iv);
                    page2 = page2;
                }
                $this$map$iv = grouped;
                destination$iv$iv = new ArrayList($this$map$iv.size());
                while (r12.hasNext()) {
                    String category5 = (String) item$iv$iv.getKey();
                    List items3 = (List) item$iv$iv.getValue();
                    Map $this$map$iv6 = $this$map$iv;
                    lowerCase = category5.toLowerCase(Locale.ROOT);
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
                    C00201 c00204 = c00201;
                    final Comparator comparator3 = new Comparator() { // from class: com.cncverse.PlayFyLiveEvents$getMainPage$lambda$1$$inlined$compareBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Integer num;
                            Integer num2;
                            PlayFyChannel ch2 = (PlayFyChannel) t;
                            if (StringsKt.contains$default(this.this$0.getEventStatus(ch2), "🔴", false, 2, (Object) null)) {
                                num = (Comparable) 0;
                            } else if (StringsKt.contains$default(this.this$0.getEventStatus(ch2), "🔜", false, 2, (Object) null)) {
                                num = (Comparable) 1;
                            } else {
                                num = StringsKt.contains$default(this.this$0.getEventStatus(ch2), "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                            }
                            PlayFyChannel ch3 = (PlayFyChannel) t2;
                            if (StringsKt.contains$default(this.this$0.getEventStatus(ch3), "🔴", false, 2, (Object) null)) {
                                num2 = (Comparable) 0;
                            } else if (StringsKt.contains$default(this.this$0.getEventStatus(ch3), "🔜", false, 2, (Object) null)) {
                                num2 = (Comparable) 1;
                            } else {
                                num2 = StringsKt.contains$default(this.this$0.getEventStatus(ch3), "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                            }
                            return ComparisonsKt.compareValues(num, num2);
                        }
                    };
                    Object $result4 = $result;
                    $this$map$iv2 = CollectionsKt.sortedWith(items3, new Comparator() { // from class: com.cncverse.PlayFyLiveEvents$getMainPage$lambda$1$$inlined$thenBy$1
                        /* JADX WARN: Code duplicated, block: B:16:0x0043  */
                        /* JADX WARN: Code duplicated, block: B:31:0x0082  */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Long lValueOf;
                            Long lValueOf2;
                            long jLongValue;
                            String it5;
                            long jLongValue2;
                            String it6;
                            int previousCompare = comparator3.compare(t, t2);
                            if (previousCompare != 0) {
                                return previousCompare;
                            }
                            PlayFyChannel ch2 = (PlayFyChannel) t;
                            try {
                                SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                PlayFyEventInfo eventInfo3 = ch2.getEventInfo();
                                if (eventInfo3 == null || (it6 = eventInfo3.getStartTime()) == null) {
                                    jLongValue2 = Long.MAX_VALUE;
                                } else {
                                    Date date = fmt.parse(it6);
                                    Long lValueOf3 = date != null ? Long.valueOf(date.getTime()) : null;
                                    if (lValueOf3 != null) {
                                        jLongValue2 = lValueOf3.longValue();
                                    } else {
                                        jLongValue2 = Long.MAX_VALUE;
                                    }
                                }
                                lValueOf = Long.valueOf(jLongValue2);
                            } catch (Exception e) {
                                lValueOf = (Comparable) Long.MAX_VALUE;
                            }
                            PlayFyChannel ch3 = (PlayFyChannel) t2;
                            try {
                                SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                PlayFyEventInfo eventInfo4 = ch3.getEventInfo();
                                if (eventInfo4 == null || (it5 = eventInfo4.getStartTime()) == null) {
                                    jLongValue = Long.MAX_VALUE;
                                } else {
                                    Date date2 = fmt2.parse(it5);
                                    Long lValueOf4 = date2 != null ? Long.valueOf(date2.getTime()) : null;
                                    if (lValueOf4 != null) {
                                        jLongValue = lValueOf4.longValue();
                                    } else {
                                        jLongValue = Long.MAX_VALUE;
                                    }
                                }
                                lValueOf2 = Long.valueOf(jLongValue);
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
                            ch = (PlayFyChannel) it.next();
                            Iterable $this$mapTo$iv$iv4 = $this$mapTo$iv$iv;
                            displayTitle = createDisplayTitle(ch);
                            MainPageRequest request5 = request2;
                            status = getEventStatus(ch);
                            if (StringsKt.isBlank(status)) {
                                status2 = status + ' ' + displayTitle;
                            } else {
                                status2 = displayTitle;
                            }
                            String fullTitle3 = status2;
                            if (Intrinsics.areEqual(ch.getCat(), "Custom")) {
                                posterUrl = generateMatchCardUrl(ch);
                            } else {
                                image = ch.getImage();
                                if (image != null) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    posterUrl = ch.getImage();
                                } else {
                                    posterUrl = generateMatchCardUrl(ch);
                                }
                            }
                            id = ch.getId();
                            if (id == null) {
                                str = "";
                            } else {
                                str = id;
                            }
                            category = ch.getCategory();
                            if (category == null) {
                                str2 = category;
                            } else {
                                str2 = category;
                            }
                            PlayFyEventInfo eventInfo3 = ch.getEventInfo();
                            formats = ch.getFormats();
                            if (formats == null) {
                                formats = CollectionsKt.emptyList();
                            }
                            PlayFyLoadData loadData3 = new PlayFyLoadData(str, displayTitle, posterUrl, str2, eventInfo3, formats);
                            final String posterUrl4 = posterUrl;
                            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle3, AppUtils.INSTANCE.toJson(loadData3), TvType.Live, false, new Function1() { // from class: com.cncverse.PlayFyLiveEvents$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    return PlayFyLiveEvents.getMainPage$lambda$1$2$0(posterUrl4, (LiveSearchResponse) obj);
                                }
                            }, 8, (Object) null));
                            $this$map$iv2 = $this$map$iv3;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv4;
                            request2 = request5;
                            channels = channels;
                        }
                    }
                    List sorted3 = (List) destination$iv$iv2;
                    destination$iv$iv.add(new HomePageList(icon + ' ' + category5, sorted3, true));
                    $this$map$iv = $this$map$iv6;
                    c00201 = c00204;
                    $result = $result4;
                    request2 = request2;
                }
                Iterable $this$sortedBy$iv3 = (List) destination$iv$iv;
                List lists3 = CollectionsKt.sortedWith($this$sortedBy$iv3, new Comparator() { // from class: com.cncverse.PlayFyLiveEvents$getMainPage$$inlined$sortedBy$1
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
                return MainAPIKt.newHomePageResponse(lists3, Boxing.boxBoolean(false));
            case 2:
                page2 = c00201.I$0;
                request2 = (MainPageRequest) c00201.L$0;
                ResultKt.throwOnFailure($result);
                objFetchLiveEvents = $result;
                channels = (List) objFetchLiveEvents;
                List $this$groupBy$iv4 = channels;
                grouped = new LinkedHashMap();
                while (r13.hasNext()) {
                    PlayFyChannel it5 = (PlayFyChannel) element$iv$iv;
                    category2 = it5.getCategory();
                    if (category2 == null) {
                        category2 = "Other";
                    }
                    str3 = category2;
                    value$iv$iv$iv = grouped.get(str3);
                    if (value$iv$iv$iv == null) {
                        Object answer$iv$iv$iv5 = (List) new ArrayList();
                        answer$iv$iv$iv = answer$iv$iv$iv5;
                        grouped.put(str3, answer$iv$iv$iv);
                    } else {
                        answer$iv$iv$iv = value$iv$iv$iv;
                    }
                    List list$iv$iv4 = (List) answer$iv$iv$iv;
                    list$iv$iv4.add(element$iv$iv);
                    page2 = page2;
                }
                $this$map$iv = grouped;
                destination$iv$iv = new ArrayList($this$map$iv.size());
                while (r12.hasNext()) {
                    String category6 = (String) item$iv$iv.getKey();
                    List items4 = (List) item$iv$iv.getValue();
                    Map $this$map$iv7 = $this$map$iv;
                    lowerCase = category6.toLowerCase(Locale.ROOT);
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
                    C00201 c00205 = c00201;
                    final Comparator comparator4 = new Comparator() { // from class: com.cncverse.PlayFyLiveEvents$getMainPage$lambda$1$$inlined$compareBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Integer num;
                            Integer num2;
                            PlayFyChannel ch2 = (PlayFyChannel) t;
                            if (StringsKt.contains$default(this.this$0.getEventStatus(ch2), "🔴", false, 2, (Object) null)) {
                                num = (Comparable) 0;
                            } else if (StringsKt.contains$default(this.this$0.getEventStatus(ch2), "🔜", false, 2, (Object) null)) {
                                num = (Comparable) 1;
                            } else {
                                num = StringsKt.contains$default(this.this$0.getEventStatus(ch2), "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                            }
                            PlayFyChannel ch3 = (PlayFyChannel) t2;
                            if (StringsKt.contains$default(this.this$0.getEventStatus(ch3), "🔴", false, 2, (Object) null)) {
                                num2 = (Comparable) 0;
                            } else if (StringsKt.contains$default(this.this$0.getEventStatus(ch3), "🔜", false, 2, (Object) null)) {
                                num2 = (Comparable) 1;
                            } else {
                                num2 = StringsKt.contains$default(this.this$0.getEventStatus(ch3), "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                            }
                            return ComparisonsKt.compareValues(num, num2);
                        }
                    };
                    Object $result5 = $result;
                    $this$map$iv2 = CollectionsKt.sortedWith(items4, new Comparator() { // from class: com.cncverse.PlayFyLiveEvents$getMainPage$lambda$1$$inlined$thenBy$1
                        /* JADX WARN: Code duplicated, block: B:16:0x0043  */
                        /* JADX WARN: Code duplicated, block: B:31:0x0082  */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Long lValueOf;
                            Long lValueOf2;
                            long jLongValue;
                            String it6;
                            long jLongValue2;
                            String it7;
                            int previousCompare = comparator4.compare(t, t2);
                            if (previousCompare != 0) {
                                return previousCompare;
                            }
                            PlayFyChannel ch2 = (PlayFyChannel) t;
                            try {
                                SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                PlayFyEventInfo eventInfo4 = ch2.getEventInfo();
                                if (eventInfo4 == null || (it7 = eventInfo4.getStartTime()) == null) {
                                    jLongValue2 = Long.MAX_VALUE;
                                } else {
                                    Date date = fmt.parse(it7);
                                    Long lValueOf3 = date != null ? Long.valueOf(date.getTime()) : null;
                                    if (lValueOf3 != null) {
                                        jLongValue2 = lValueOf3.longValue();
                                    } else {
                                        jLongValue2 = Long.MAX_VALUE;
                                    }
                                }
                                lValueOf = Long.valueOf(jLongValue2);
                            } catch (Exception e) {
                                lValueOf = (Comparable) Long.MAX_VALUE;
                            }
                            PlayFyChannel ch3 = (PlayFyChannel) t2;
                            try {
                                SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                PlayFyEventInfo eventInfo5 = ch3.getEventInfo();
                                if (eventInfo5 == null || (it6 = eventInfo5.getStartTime()) == null) {
                                    jLongValue = Long.MAX_VALUE;
                                } else {
                                    Date date2 = fmt2.parse(it6);
                                    Long lValueOf4 = date2 != null ? Long.valueOf(date2.getTime()) : null;
                                    if (lValueOf4 != null) {
                                        jLongValue = lValueOf4.longValue();
                                    } else {
                                        jLongValue = Long.MAX_VALUE;
                                    }
                                }
                                lValueOf2 = Long.valueOf(jLongValue);
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
                            ch = (PlayFyChannel) it.next();
                            Iterable $this$mapTo$iv$iv5 = $this$mapTo$iv$iv;
                            displayTitle = createDisplayTitle(ch);
                            MainPageRequest request6 = request2;
                            status = getEventStatus(ch);
                            if (StringsKt.isBlank(status)) {
                                status2 = status + ' ' + displayTitle;
                            } else {
                                status2 = displayTitle;
                            }
                            String fullTitle4 = status2;
                            if (Intrinsics.areEqual(ch.getCat(), "Custom")) {
                                posterUrl = generateMatchCardUrl(ch);
                            } else {
                                image = ch.getImage();
                                if (image != null) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    posterUrl = ch.getImage();
                                } else {
                                    posterUrl = generateMatchCardUrl(ch);
                                }
                            }
                            id = ch.getId();
                            if (id == null) {
                                str = "";
                            } else {
                                str = id;
                            }
                            category = ch.getCategory();
                            if (category == null) {
                                str2 = category;
                            } else {
                                str2 = category;
                            }
                            PlayFyEventInfo eventInfo4 = ch.getEventInfo();
                            formats = ch.getFormats();
                            if (formats == null) {
                                formats = CollectionsKt.emptyList();
                            }
                            PlayFyLoadData loadData4 = new PlayFyLoadData(str, displayTitle, posterUrl, str2, eventInfo4, formats);
                            final String posterUrl5 = posterUrl;
                            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle4, AppUtils.INSTANCE.toJson(loadData4), TvType.Live, false, new Function1() { // from class: com.cncverse.PlayFyLiveEvents$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    return PlayFyLiveEvents.getMainPage$lambda$1$2$0(posterUrl5, (LiveSearchResponse) obj);
                                }
                            }, 8, (Object) null));
                            $this$map$iv2 = $this$map$iv3;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv5;
                            request2 = request6;
                            channels = channels;
                        }
                    }
                    List sorted4 = (List) destination$iv$iv2;
                    destination$iv$iv.add(new HomePageList(icon + ' ' + category6, sorted4, true));
                    $this$map$iv = $this$map$iv7;
                    c00201 = c00205;
                    $result = $result5;
                    request2 = request2;
                }
                Iterable $this$sortedBy$iv4 = (List) destination$iv$iv;
                List lists4 = CollectionsKt.sortedWith($this$sortedBy$iv4, new Comparator() { // from class: com.cncverse.PlayFyLiveEvents$getMainPage$$inlined$sortedBy$1
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
                return MainAPIKt.newHomePageResponse(lists4, Boxing.boxBoolean(false));
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
        C00261 c00261;
        Object objFetchLiveEvents;
        String query2;
        PlayFyLiveEvents playFyLiveEvents = this;
        if (continuation instanceof C00261) {
            c00261 = (C00261) continuation;
            if ((c00261.label & Integer.MIN_VALUE) != 0) {
                c00261.label -= Integer.MIN_VALUE;
            } else {
                c00261 = playFyLiveEvents.new C00261(continuation);
            }
        } else {
            c00261 = playFyLiveEvents.new C00261(continuation);
        }
        Object $result = c00261.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00261.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PlayFyProviderManager playFyProviderManager = PlayFyProviderManager.INSTANCE;
                c00261.L$0 = query;
                c00261.label = 1;
                objFetchLiveEvents = playFyProviderManager.fetchLiveEvents(c00261);
                if (objFetchLiveEvents == coroutine_suspended) {
                    return coroutine_suspended;
                }
                query2 = query;
                break;
                break;
            case 1:
                query2 = (String) c00261.L$0;
                ResultKt.throwOnFailure($result);
                objFetchLiveEvents = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable channels = (List) objFetchLiveEvents;
        Iterable $this$filter$iv = channels;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            PlayFyChannel ch = (PlayFyChannel) element$iv$iv;
            String title = ch.getTitle();
            PlayFyEventInfo eventInfo = ch.getEventInfo();
            String teamA = eventInfo != null ? eventInfo.getTeamA() : null;
            PlayFyEventInfo eventInfo2 = ch.getEventInfo();
            String teamB = eventInfo2 != null ? eventInfo2.getTeamB() : null;
            PlayFyEventInfo eventInfo3 = ch.getEventInfo();
            String eventName = eventInfo3 != null ? eventInfo3.getEventName() : null;
            Object $result2 = $result;
            if (StringsKt.contains(CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{title, teamA, teamB, eventName}), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), query2, true)) {
                destination$iv$iv.add(element$iv$iv);
            }
            c00261 = c00261;
            $result = $result2;
        }
        Iterable $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            PlayFyChannel ch2 = (PlayFyChannel) item$iv$iv;
            String displayTitle = playFyLiveEvents.createDisplayTitle(ch2);
            String status = playFyLiveEvents.getEventStatus(ch2);
            String fullTitle = !StringsKt.isBlank(status) ? status + ' ' + displayTitle : displayTitle;
            final String posterUrl = playFyLiveEvents.generateMatchCardUrl(ch2);
            String id = ch2.getId();
            String str = id == null ? "" : id;
            String category = ch2.getCategory();
            String str2 = (category == null && (category = ch2.getCat()) == null) ? "" : category;
            PlayFyEventInfo eventInfo4 = ch2.getEventInfo();
            List<String> formats = ch2.getFormats();
            if (formats == null) {
                formats = CollectionsKt.emptyList();
            }
            PlayFyLoadData loadData = new PlayFyLoadData(str, displayTitle, posterUrl, str2, eventInfo4, formats);
            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(playFyLiveEvents, fullTitle, AppUtils.INSTANCE.toJson(loadData), TvType.Live, false, new Function1() { // from class: com.cncverse.PlayFyLiveEvents$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return PlayFyLiveEvents.search$lambda$1$0(posterUrl, (LiveSearchResponse) obj);
                }
            }, 8, (Object) null));
            playFyLiveEvents = this;
            $this$map$iv = $this$map$iv;
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
            KType kTypeTypeOf = Reflection.typeOf(PlayFyLoadData.class);
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            try {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(PlayFyLoadData.class), (List) null, 2, (Object) null));
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
                objDecodeFromString = $this$readValue$iv$iv.readValue(url, new TypeReference<PlayFyLoadData>() { // from class: com.cncverse.PlayFyLiveEvents$load$$inlined$parseJson$1
                });
            } catch (Throwable th3) {
                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv2.readValue(url, new TypeReference<PlayFyLoadData>() { // from class: com.cncverse.PlayFyLiveEvents$load$$inlined$parseJson$1
                });
            }
        } else {
            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
            objDecodeFromString = $this$readValue$iv$iv3.readValue(url, new TypeReference<PlayFyLoadData>() { // from class: com.cncverse.PlayFyLiveEvents$load$$inlined$parseJson$1
            });
        }
        PlayFyLoadData data = (PlayFyLoadData) objDecodeFromString;
        PlayFyEventInfo info = data.getEventInfo();
        StringBuilder $this$load_u24lambda_u240 = new StringBuilder();
        if (info != null) {
            String it = info.getEventName();
            if (it != null) {
                $this$load_u24lambda_u240.append("🏆 " + it + '\n');
            }
            String it2 = info.getStartTime();
            if (it2 != null) {
                try {
                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                    SimpleDateFormat disp = new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.US);
                    StringBuilder sbAppend = new StringBuilder().append("🕐 ");
                    Date date = fmt.parse(it2);
                    Intrinsics.checkNotNull(date);
                    $this$load_u24lambda_u240.append(sbAppend.append(disp.format(date)).append('\n').toString());
                } catch (Exception e2) {
                    $this$load_u24lambda_u240.append("🕐 " + it2 + '\n');
                }
            }
        }
        if (!data.getFormats().isEmpty()) {
            $this$load_u24lambda_u240.append("\n📡 Available Servers: " + data.getFormats().size());
        }
        String plot = $this$load_u24lambda_u240.toString();
        return MainAPIKt.newLiveStreamLoadResponse(this, data.getTitle(), url, url, new C00212(data, plot, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.PlayFyLiveEvents$load$2 */
    /* JADX INFO: compiled from: PlayFyLiveEvents.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/LiveStreamLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayFyLiveEvents$load$2", f = "PlayFyLiveEvents.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nPlayFyLiveEvents.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayFyLiveEvents.kt\ncom/cncverse/PlayFyLiveEvents$load$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,476:1\n1#2:477\n*E\n"})
    static final class C00212 extends SuspendLambda implements Function2<LiveStreamLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ PlayFyLoadData $data;
        final /* synthetic */ String $plot;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00212(PlayFyLoadData playFyLoadData, String str, Continuation<? super C00212> continuation) {
            super(2, continuation);
            this.$data = playFyLoadData;
            this.$plot = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00212 = new C00212(this.$data, this.$plot, continuation);
            c00212.L$0 = obj;
            return c00212;
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
                    String str = this.$plot;
                    if (StringsKt.isBlank(str)) {
                        str = null;
                    }
                    $this$newLiveStreamLoadResponse.setPlot(str);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:110:0x047d A[Catch: Exception -> 0x05a4, TRY_ENTER, TryCatch #11 {Exception -> 0x05a4, blocks: (B:65:0x028d, B:110:0x047d, B:112:0x0483, B:118:0x04a0), top: B:163:0x028d }] */
    /* JADX WARN: Code duplicated, block: B:112:0x0483 A[Catch: Exception -> 0x05a4, TryCatch #11 {Exception -> 0x05a4, blocks: (B:65:0x028d, B:110:0x047d, B:112:0x0483, B:118:0x04a0), top: B:163:0x028d }] */
    /* JADX WARN: Code duplicated, block: B:114:0x0490  */
    /* JADX WARN: Code duplicated, block: B:115:0x0491  */
    /* JADX WARN: Code duplicated, block: B:117:0x0494  */
    /* JADX WARN: Code duplicated, block: B:118:0x04a0 A[Catch: Exception -> 0x05a4, TRY_LEAVE, TryCatch #11 {Exception -> 0x05a4, blocks: (B:65:0x028d, B:110:0x047d, B:112:0x0483, B:118:0x04a0), top: B:163:0x028d }] */
    /* JADX WARN: Code duplicated, block: B:120:0x04ba  */
    /* JADX WARN: Code duplicated, block: B:127:0x0524 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:128:0x0525  */
    /* JADX WARN: Code duplicated, block: B:137:0x0597  */
    /* JADX WARN: Code duplicated, block: B:61:0x027a  */
    /* JADX WARN: Code duplicated, block: B:63:0x0289  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0167: MOVE (r14 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('serverName' java.lang.String)]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$f$forEach' int)]), block:B:24:0x0160 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0162: MOVE (r26 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY] A[D('serverName' java.lang.String)]), block:B:24:0x0160 */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0160: MOVE (r17 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$a$-forEach-PlayFyLiveEvents$loadLinks$2' int)]), block:B:24:0x0160 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:128:0x0525 -> B:129:0x0536). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:138:0x05a1 -> B:143:0x05ce). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:141:0x05bf -> B:142:0x05ca). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r28, boolean r29, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r30, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r31, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r32) {
        /*
            Method dump skipped, instruction units count: 1512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.PlayFyLiveEvents.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:25:0x0123  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    public final Object emitLink(Function1<? super ExtractorLink, Unit> function1, String serverName, String url, Map<String, String> map, String api, Continuation<? super Unit> continuation) {
        C00151 c00151;
        Object obj;
        Object obj2;
        List listSplit$default;
        Object obj3;
        Object obj4;
        Function1<? super ExtractorLink, Unit> function2 = function1;
        if (continuation instanceof C00151) {
            c00151 = (C00151) continuation;
            if ((c00151.label & Integer.MIN_VALUE) != 0) {
                c00151.label -= Integer.MIN_VALUE;
            } else {
                c00151 = new C00151(continuation);
            }
        } else {
            c00151 = new C00151(continuation);
        }
        C00151 c00152 = c00151;
        Object $result = c00152.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00152.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!StringsKt.contains$default(url, ".mpd", false, 2, (Object) null)) {
                    if (StringsKt.contains$default(url, ".m3u8", false, 2, (Object) null) || StringsKt.contains$default(url, ".m3u", false, 2, (Object) null)) {
                        Map h = MapsKt.toMutableMap(map);
                        if (!h.containsKey("User-Agent")) {
                            h.put("User-Agent", "Mozilla/5.0 (Linux; Android 10) AppleWebKit/537.36 Chrome/122.0.0.0 Mobile Safari/537.36");
                        }
                        String name = getName();
                        ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                        C00184 c00184 = new C00184(h, null);
                        c00152.L$0 = SpillingKt.nullOutSpilledVariable(function2);
                        c00152.L$1 = SpillingKt.nullOutSpilledVariable(serverName);
                        c00152.L$2 = SpillingKt.nullOutSpilledVariable(url);
                        c00152.L$3 = SpillingKt.nullOutSpilledVariable(map);
                        c00152.L$4 = SpillingKt.nullOutSpilledVariable(api);
                        c00152.L$5 = SpillingKt.nullOutSpilledVariable(h);
                        c00152.L$6 = function2;
                        c00152.label = 3;
                        Object objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, serverName, url, extractorLinkType, c00184, c00152);
                        if (objNewExtractorLink == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = objNewExtractorLink;
                        function2.invoke(obj);
                        return Unit.INSTANCE;
                    }
                    Map h2 = MapsKt.toMutableMap(map);
                    if (!h2.containsKey("User-Agent")) {
                        h2.put("User-Agent", "Mozilla/5.0 (Linux; Android 10) AppleWebKit/537.36 Chrome/122.0.0.0 Mobile Safari/537.36");
                    }
                    String name2 = getName();
                    ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                    C00195 c00195 = new C00195(h2, null);
                    c00152.L$0 = SpillingKt.nullOutSpilledVariable(function2);
                    c00152.L$1 = SpillingKt.nullOutSpilledVariable(serverName);
                    c00152.L$2 = SpillingKt.nullOutSpilledVariable(url);
                    c00152.L$3 = SpillingKt.nullOutSpilledVariable(map);
                    c00152.L$4 = SpillingKt.nullOutSpilledVariable(api);
                    c00152.L$5 = SpillingKt.nullOutSpilledVariable(h2);
                    c00152.L$6 = function2;
                    c00152.label = 4;
                    Object objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(name2, serverName, url, infer_type, c00195, c00152);
                    if (objNewExtractorLink2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj2 = objNewExtractorLink2;
                    function2.invoke(obj2);
                    return Unit.INSTANCE;
                }
                if (api == null) {
                    listSplit$default = null;
                } else {
                    String str = StringsKt.contains$default(api, ":", false, 2, (Object) null) ? api : null;
                    if (str != null) {
                        listSplit$default = StringsKt.split$default(str, new String[]{":"}, false, 2, 2, (Object) null);
                    } else {
                        listSplit$default = null;
                    }
                }
                List drmInfo = listSplit$default;
                if (drmInfo != null && drmInfo.size() == 2) {
                    String kidB64 = hexToBase64((String) drmInfo.get(0));
                    String keyB64 = hexToBase64((String) drmInfo.get(1));
                    if (kidB64 != null && keyB64 != null) {
                        String name3 = getName();
                        ExtractorLinkType infer_type2 = ExtractorApiKt.getINFER_TYPE();
                        UUID clearkey_uuid = ExtractorApiKt.getCLEARKEY_UUID();
                        C00162 c00162 = new C00162(keyB64, kidB64, map, null);
                        c00152.L$0 = SpillingKt.nullOutSpilledVariable(function2);
                        c00152.L$1 = SpillingKt.nullOutSpilledVariable(serverName);
                        c00152.L$2 = SpillingKt.nullOutSpilledVariable(url);
                        c00152.L$3 = SpillingKt.nullOutSpilledVariable(map);
                        c00152.L$4 = SpillingKt.nullOutSpilledVariable(api);
                        c00152.L$5 = SpillingKt.nullOutSpilledVariable(drmInfo);
                        c00152.L$6 = SpillingKt.nullOutSpilledVariable(kidB64);
                        c00152.L$7 = SpillingKt.nullOutSpilledVariable(keyB64);
                        c00152.L$8 = function2;
                        c00152.label = 1;
                        Object objNewDrmExtractorLink = ExtractorApiKt.newDrmExtractorLink(name3, serverName, url, infer_type2, clearkey_uuid, c00162, c00152);
                        if (objNewDrmExtractorLink == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj4 = objNewDrmExtractorLink;
                        function2.invoke(obj4);
                        return Unit.INSTANCE;
                    }
                }
                String name4 = getName();
                ExtractorLinkType extractorLinkType2 = ExtractorLinkType.DASH;
                C00173 c00173 = new C00173(map, null);
                c00152.L$0 = SpillingKt.nullOutSpilledVariable(function2);
                c00152.L$1 = SpillingKt.nullOutSpilledVariable(serverName);
                c00152.L$2 = SpillingKt.nullOutSpilledVariable(url);
                c00152.L$3 = SpillingKt.nullOutSpilledVariable(map);
                c00152.L$4 = SpillingKt.nullOutSpilledVariable(api);
                c00152.L$5 = SpillingKt.nullOutSpilledVariable(drmInfo);
                c00152.L$6 = function2;
                c00152.label = 2;
                Object objNewExtractorLink3 = ExtractorApiKt.newExtractorLink(name4, serverName, url, extractorLinkType2, c00173, c00152);
                if (objNewExtractorLink3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj3 = objNewExtractorLink3;
                function2.invoke(obj3);
                return Unit.INSTANCE;
            case 1:
                Function1<? super ExtractorLink, Unit> function3 = (Function1) c00152.L$8;
                ResultKt.throwOnFailure($result);
                function2 = function3;
                obj4 = $result;
                function2.invoke(obj4);
                return Unit.INSTANCE;
            case 2:
                Function1<? super ExtractorLink, Unit> function4 = (Function1) c00152.L$6;
                ResultKt.throwOnFailure($result);
                function2 = function4;
                obj3 = $result;
                function2.invoke(obj3);
                return Unit.INSTANCE;
            case 3:
                Function1<? super ExtractorLink, Unit> function5 = (Function1) c00152.L$6;
                ResultKt.throwOnFailure($result);
                function2 = function5;
                obj = $result;
                function2.invoke(obj);
                return Unit.INSTANCE;
            case 4:
                Function1<? super ExtractorLink, Unit> function6 = (Function1) c00152.L$6;
                ResultKt.throwOnFailure($result);
                function2 = function6;
                obj2 = $result;
                function2.invoke(obj2);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PlayFyLiveEvents$emitLink$2 */
    /* JADX INFO: compiled from: PlayFyLiveEvents.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/DrmExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayFyLiveEvents$emitLink$2", f = "PlayFyLiveEvents.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00162 extends SuspendLambda implements Function2<DrmExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        final /* synthetic */ String $keyB64;
        final /* synthetic */ String $kidB64;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00162(String str, String str2, Map<String, String> map, Continuation<? super C00162> continuation) {
            super(2, continuation);
            this.$keyB64 = str;
            this.$kidB64 = str2;
            this.$headers = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00162 = new C00162(this.$keyB64, this.$kidB64, this.$headers, continuation);
            c00162.L$0 = obj;
            return c00162;
        }

        public final Object invoke(DrmExtractorLink drmExtractorLink, Continuation<? super Unit> continuation) {
            return create(drmExtractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            DrmExtractorLink $this$newDrmExtractorLink = (DrmExtractorLink) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newDrmExtractorLink.setQuality(Qualities.Unknown.getValue());
                    $this$newDrmExtractorLink.setKey(this.$keyB64);
                    $this$newDrmExtractorLink.setKid(this.$kidB64);
                    if (!this.$headers.isEmpty()) {
                        $this$newDrmExtractorLink.setHeaders(this.$headers);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PlayFyLiveEvents$emitLink$3 */
    /* JADX INFO: compiled from: PlayFyLiveEvents.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayFyLiveEvents$emitLink$3", f = "PlayFyLiveEvents.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00173 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00173(Map<String, String> map, Continuation<? super C00173> continuation) {
            super(2, continuation);
            this.$headers = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00173 = new C00173(this.$headers, continuation);
            c00173.L$0 = obj;
            return c00173;
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
                    if (!this.$headers.isEmpty()) {
                        $this$newExtractorLink.setHeaders(this.$headers);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PlayFyLiveEvents$emitLink$4 */
    /* JADX INFO: compiled from: PlayFyLiveEvents.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayFyLiveEvents$emitLink$4", f = "PlayFyLiveEvents.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00184 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: $h */
        final /* synthetic */ Map<String, String> f3$h;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00184(Map<String, String> map, Continuation<? super C00184> continuation) {
            super(2, continuation);
            this.f3$h = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00184 = new C00184(this.f3$h, continuation);
            c00184.L$0 = obj;
            return c00184;
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
                    if (!this.f3$h.isEmpty()) {
                        $this$newExtractorLink.setHeaders(this.f3$h);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PlayFyLiveEvents$emitLink$5 */
    /* JADX INFO: compiled from: PlayFyLiveEvents.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayFyLiveEvents$emitLink$5", f = "PlayFyLiveEvents.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00195 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: $h */
        final /* synthetic */ Map<String, String> f4$h;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00195(Map<String, String> map, Continuation<? super C00195> continuation) {
            super(2, continuation);
            this.f4$h = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00195 = new C00195(this.f4$h, continuation);
            c00195.L$0 = obj;
            return c00195;
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
                    if (!this.f4$h.isEmpty()) {
                        $this$newExtractorLink.setHeaders(this.f4$h);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final String hexToBase64(String hex) {
        String n = StringsKt.trim(StringsKt.replace$default(hex, "-", "", false, 4, (Object) null)).toString();
        if (!(n.length() == 0) && n.length() % 2 == 0) {
            if (new Regex("^[0-9a-fA-F]+$").matches(n)) {
                try {
                    Iterable $this$map$iv = StringsKt.chunked(n, 2);
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        String it = (String) item$iv$iv;
                        destination$iv$iv.add(Byte.valueOf((byte) Integer.parseInt(it, CharsKt.checkRadix(16))));
                    }
                    byte[] bytes = CollectionsKt.toByteArray((List) destination$iv$iv);
                    return Base64.encodeToString(bytes, 11);
                } catch (Exception e) {
                    return null;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:31:0x00d2  */
    private final Pair<String, Map<String, String>> parseStreamLink(String link) {
        String string;
        Map headers = new LinkedHashMap();
        if (!StringsKt.contains$default(link, "|", false, 2, (Object) null)) {
            return new Pair<>(link, headers);
        }
        List parts = StringsKt.split$default(link, new String[]{"|"}, false, 2, 2, (Object) null);
        String url = (String) parts.get(0);
        if (parts.size() > 1) {
            Iterable $this$forEach$iv = StringsKt.split$default((CharSequence) parts.get(1), new String[]{"&"}, false, 0, 6, (Object) null);
            for (Object element$iv : $this$forEach$iv) {
                String pair = (String) element$iv;
                List kv = StringsKt.split$default(pair, new String[]{"="}, false, 2, 2, (Object) null);
                if (kv.size() == 2) {
                    String lowerCase = StringsKt.trim((String) kv.get(0)).toString().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    switch (lowerCase) {
                        case "cookie":
                            string = "Cookie";
                            break;
                        case "origin":
                            string = "Origin";
                            break;
                        case "user-agent":
                            string = "User-Agent";
                            break;
                        case "referer":
                            string = "Referer";
                            break;
                        default:
                            string = StringsKt.trim((String) kv.get(0)).toString();
                            break;
                    }
                    headers.put(string, StringsKt.trim((String) kv.get(1)).toString());
                }
            }
        }
        return new Pair<>(url, headers);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadEmbedInWebView(String embedUrl, Continuation<? super String> continuation) {
        if (StringsKt.contains$default(embedUrl, ".m3u8", false, 2, (Object) null) || StringsKt.contains$default(embedUrl, ".mpd", false, 2, (Object) null) || StringsKt.contains$default(embedUrl, ".mp4", false, 2, (Object) null)) {
            return embedUrl;
        }
        return BuildersKt.withContext(Dispatchers.getMain(), new C00222(embedUrl, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.PlayFyLiveEvents$loadEmbedInWebView$2 */
    /* JADX INFO: compiled from: PlayFyLiveEvents.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayFyLiveEvents$loadEmbedInWebView$2", f = "PlayFyLiveEvents.kt", i = {}, l = {415}, m = "invokeSuspend", n = {}, nl = {469}, s = {}, v = 2)
    static final class C00222 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $embedUrl;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00222(String str, Continuation<? super C00222> continuation) {
            super(2, continuation);
            this.$embedUrl = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00222(this.$embedUrl, continuation);
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
                    final Continuation cont = safeContinuation;
                    try {
                        Context ctx = PlayFyLiveEvents.INSTANCE.getContext();
                        if (ctx == null) {
                            Result.Companion companion = Result.Companion;
                            cont.resumeWith(Result.constructor-impl((Object) null));
                        } else {
                            final WebView wv = new WebView(ctx);
                            WebSettings s = wv.getSettings();
                            s.setJavaScriptEnabled(true);
                            s.setDomStorageEnabled(true);
                            s.setMixedContentMode(0);
                            s.setMediaPlaybackRequiresUserGesture(false);
                            final Ref.BooleanRef captured = new Ref.BooleanRef();
                            wv.addJavascriptInterface(new Object() { // from class: com.cncverse.PlayFyLiveEvents$loadEmbedInWebView$2$1$bridge$1
                                @JavascriptInterface
                                public final void onStreamUrlFound(final String url) {
                                    if (!captured.element && !StringsKt.isBlank(url)) {
                                        captured.element = true;
                                        Handler handler = new Handler(Looper.getMainLooper());
                                        final WebView webView = wv;
                                        final Continuation<String> continuation = cont;
                                        handler.post(new Runnable() { // from class: com.cncverse.PlayFyLiveEvents$loadEmbedInWebView$2$1$bridge$1$onStreamUrlFound$1
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                try {
                                                    webView.destroy();
                                                } catch (Exception e) {
                                                }
                                                Continuation<String> continuation2 = continuation;
                                                Result.Companion companion2 = Result.Companion;
                                                continuation2.resumeWith(Result.constructor-impl(url));
                                            }
                                        });
                                    }
                                }
                            }, "StreamBridge");
                            wv.setWebViewClient(new WebViewClient() { // from class: com.cncverse.PlayFyLiveEvents$loadEmbedInWebView$2$1$1
                                @Override // android.webkit.WebViewClient
                                public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest req) {
                                    final String u = req.getUrl().toString();
                                    if (!captured.element && (StringsKt.contains$default(u, ".m3u8", false, 2, (Object) null) || StringsKt.contains$default(u, ".mpd", false, 2, (Object) null) || StringsKt.contains$default(u, ".mp4", false, 2, (Object) null))) {
                                        captured.element = true;
                                        Handler handler = new Handler(Looper.getMainLooper());
                                        final WebView webView = wv;
                                        final Continuation<String> continuation = cont;
                                        handler.post(new Runnable() { // from class: com.cncverse.PlayFyLiveEvents$loadEmbedInWebView$2$1$1$shouldInterceptRequest$1
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                try {
                                                    webView.destroy();
                                                } catch (Exception e) {
                                                }
                                                Continuation<String> continuation2 = continuation;
                                                Result.Companion companion2 = Result.Companion;
                                                continuation2.resumeWith(Result.constructor-impl(u));
                                            }
                                        });
                                    }
                                    return super.shouldInterceptRequest(view, req);
                                }

                                @Override // android.webkit.WebViewClient
                                public void onPageFinished(WebView view, String pageUrl) {
                                    super.onPageFinished(view, pageUrl);
                                    if (!captured.element) {
                                        Handler handler = new Handler(Looper.getMainLooper());
                                        final WebView webView = wv;
                                        handler.postDelayed(new Runnable() { // from class: com.cncverse.PlayFyLiveEvents$loadEmbedInWebView$2$1$1$onPageFinished$1
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                webView.evaluateJavascript("(function(){ if(typeof playbackURL!=='undefined'&&playbackURL) window.StreamBridge.onStreamUrlFound(playbackURL); })();", null);
                                            }
                                        }, 500L);
                                        Handler handler2 = new Handler(Looper.getMainLooper());
                                        final Ref.BooleanRef booleanRef = captured;
                                        final WebView webView2 = wv;
                                        final Continuation<String> continuation = cont;
                                        handler2.postDelayed(new Runnable() { // from class: com.cncverse.PlayFyLiveEvents$loadEmbedInWebView$2$1$1$onPageFinished$2
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                if (!booleanRef.element) {
                                                    try {
                                                        webView2.destroy();
                                                    } catch (Exception e) {
                                                    }
                                                    Continuation<String> continuation2 = continuation;
                                                    Result.Companion companion2 = Result.Companion;
                                                    continuation2.resumeWith(Result.constructor-impl((Object) null));
                                                }
                                            }
                                        }, 4000L);
                                    }
                                }
                            });
                            wv.setWebChromeClient(new WebChromeClient());
                            wv.loadUrl(str);
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.cncverse.PlayFyLiveEvents$loadEmbedInWebView$2$1$2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    if (!captured.element) {
                                        try {
                                            wv.destroy();
                                        } catch (Exception e) {
                                        }
                                        try {
                                            Continuation<String> continuation = cont;
                                            Result.Companion companion2 = Result.Companion;
                                            continuation.resumeWith(Result.constructor-impl((Object) null));
                                        } catch (Exception e2) {
                                        }
                                    }
                                }
                            }, 30000L);
                        }
                        break;
                    } catch (Exception e) {
                        Result.Companion companion2 = Result.Companion;
                        cont.resumeWith(Result.constructor-impl((Object) null));
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
}
