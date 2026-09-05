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
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/CricifyProvider/classes.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0006\u0018\u0000 M2\u00020\u0001:\u0004MNOPB\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H\u0002J\u001e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0096@¢\u0006\u0002\u0010,J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u00101J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u00101J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u000206H\u0002J\u0010\u00108\u001a\u0002062\u0006\u00104\u001a\u00020\u0003H\u0002JF\u00109\u001a\u00020\u00132\u0006\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u00132\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u0002060=2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u0002060=H\u0096@¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u0003H\u0002J\u0018\u0010C\u001a\u0004\u0018\u00010\u00032\u0006\u00104\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u00101J\u0018\u0010D\u001a\u0004\u0018\u00010\u00032\u0006\u0010E\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u00101J\u0018\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010H\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u00101J(\u0010I\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030K0J2\u0006\u0010L\u001a\u00020\u0003H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u001a\u0010\u000f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/cncverse/LiveEventsProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "name", "", "customCatLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getCustomCatLink", "mainUrl", "getMainUrl", "setMainUrl", "lang", "getLang", "setLang", "hasMainPage", "", "getHasMainPage", "()Z", "hasChromecastSupport", "getHasChromecastSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "client", "Lokhttp3/OkHttpClient;", "createDisplayTitle", "event", "Lcom/cncverse/LiveEventData;", "getEventStatus", "isEventLive", "isEventEnded", "generateMatchCardUrl", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "showSubscriptionPopupIfNeeded", "", "showTelegramPopup", "openInExternalBrowser", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isDirectStreamUrl", "resolveEmbedUrlIfNeeded", "loadEmbedInWebView", "embedUrl", "fetchChannelStreams", "Lcom/cncverse/LiveEventsProvider$ChannelStreamResponse;", "slug", "parseStreamLink", "Lkotlin/Pair;", "", "link", "Companion", "ChannelStreamResponse", "StreamUrl", "LiveEventLoadData", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLiveEventsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveEventsProvider.kt\ncom/cncverse/LiveEventsProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 7 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,1011:1\n1#2:1012\n1#2:1044\n1#2:1063\n1512#3:1013\n1538#3,3:1014\n1541#3,3:1024\n1586#3:1030\n1661#3,3:1031\n1068#3:1035\n777#3:1036\n873#3,2:1037\n1586#3:1039\n1661#3,3:1040\n1915#3:1081\n1586#3:1082\n1661#3,3:1083\n1586#3:1086\n1661#3,3:1087\n1916#3:1090\n1915#3,2:1091\n383#4,7:1017\n129#5:1027\n158#5,2:1028\n160#5:1034\n63#6:1043\n64#6,15:1045\n63#6:1062\n64#6,15:1064\n50#7:1060\n43#7:1061\n50#7:1079\n43#7:1080\n*S KotlinDebug\n*F\n+ 1 LiveEventsProvider.kt\ncom/cncverse/LiveEventsProvider\n*L\n388#1:1044\n679#1:1063\n250#1:1013\n250#1:1014,3\n250#1:1024,3\n287#1:1030\n287#1:1031,3\n324#1:1035\n346#1:1036\n346#1:1037,2\n359#1:1039\n359#1:1040,3\n688#1:1081\n709#1:1082\n709#1:1083,3\n720#1:1086\n720#1:1087,3\n688#1:1090\n989#1:1091,2\n250#1:1017,7\n254#1:1027\n254#1:1028,2\n254#1:1034\n388#1:1043\n388#1:1045,15\n679#1:1062\n679#1:1064,15\n388#1:1060\n388#1:1061\n679#1:1079\n679#1:1080\n*E\n"})
public final class LiveEventsProvider extends MainAPI {
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
    @DebugMetadata(c = "com.cncverse.LiveEventsProvider", f = "LiveEventsProvider.kt", i = {0, 0, 1, 1}, l = {244, 246}, m = "getMainPage", n = {"request", "page", "request", "page"}, nl = {246, 243}, s = {"L$0", "I$0", "L$0", "I$0"}, v = 2)
    static final class C00191 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00191(Continuation<? super C00191> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveEventsProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.LiveEventsProvider$loadLinks$1 */
    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LiveEventsProvider", f = "LiveEventsProvider.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {682, 697, 727, 745, 776}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "loadData", "isCasting", "data", "subtitleCallback", "callback", "loadData", "streamResponse", "$this$forEach$iv", "element$iv", "stream", "streamLink", "serverName", "url", "headers", "isCasting", "$i$f$forEach", "$i$a$-forEach-LiveEventsProvider$loadLinks$3", "data", "subtitleCallback", "callback", "loadData", "streamResponse", "$this$forEach$iv", "element$iv", "stream", "streamLink", "serverName", "url", "headers", "resolvedUrl", "drmKidBytes", "drmKidBase64", "drmInfo", "drmKeyBytes", "drmKeyBase64", "isCasting", "$i$f$forEach", "$i$a$-forEach-LiveEventsProvider$loadLinks$3", "data", "subtitleCallback", "callback", "loadData", "streamResponse", "$this$forEach$iv", "element$iv", "stream", "streamLink", "serverName", "url", "headers", "resolvedUrl", "drmInfo", "isCasting", "$i$f$forEach", "$i$a$-forEach-LiveEventsProvider$loadLinks$3", "data", "subtitleCallback", "callback", "loadData", "streamResponse", "$this$forEach$iv", "element$iv", "stream", "streamLink", "serverName", "url", "headers", "resolvedUrl", "finalHeaders", "linkType", "isCasting", "$i$f$forEach", "$i$a$-forEach-LiveEventsProvider$loadLinks$3"}, nl = {684, 699, 726, 744, 775}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "Z$0", "I$0", "I$1"}, v = 2)
    static final class C00241 extends ContinuationImpl {
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

        C00241(Continuation<? super C00241> continuation) {
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
    @DebugMetadata(c = "com.cncverse.LiveEventsProvider", f = "LiveEventsProvider.kt", i = {0, 1}, l = {340, 342}, m = "search", n = {"query", "query"}, nl = {342, 339}, s = {"L$0", "L$0"}, v = 2)
    static final class C00251 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00251(Continuation<? super C00251> continuation) {
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
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/cncverse/LiveEventsProvider$Companion;", "", "<init>", "()V", "isCsGuardActive", "", "csGuardWasEverActive", "isCsGuardBlocked", "showCsGuardToast", "", "ctx", "Landroid/content/Context;", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "OMG10", "", "lastBrowserOpenMs", "", "telegramPopupShown", "subscriptionPopupShown", "BROWSER_DEBOUNCE_MS", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nLiveEventsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveEventsProvider.kt\ncom/cncverse/LiveEventsProvider$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1011:1\n1#2:1012\n*E\n"})
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
                LiveEventsProvider.csGuardWasEverActive = true;
            }
            return LiveEventsProvider.csGuardWasEverActive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCsGuardToast(final Context ctx) {
            if (ctx == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.LiveEventsProvider$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LiveEventsProvider.Companion.showCsGuardToast$lambda$0(ctx);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showCsGuardToast$lambda$0(Context $c) {
            Toast.makeText($c, "🚫 CSGuard detected — Restart CloudStream after removing CSGuard to use CNCRepo", 1).show();
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
        this.mainUrl = "https://cfyhljddgbkkufh82.top";
        this.lang = "ta";
        this.hasMainPage = true;
        this.hasChromecastSupport = true;
        this.supportedTypes = SetsKt.setOf(TvType.Live);
        this.client = new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).build();
    }

    public /* synthetic */ LiveEventsProvider(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "⚡Cricify Live Events" : str, (i & 2) != 0 ? null : str2);
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

    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\bHÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/cncverse/LiveEventsProvider$ChannelStreamResponse;", "", "streamUrls", "", "Lcom/cncverse/LiveEventsProvider$StreamUrl;", "related", "Lcom/cncverse/LiveEventData;", "prevChannel", "", "nextChannel", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getStreamUrls", "()Ljava/util/List;", "getRelated", "getPrevChannel", "()Ljava/lang/String;", "getNextChannel", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
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
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/cncverse/LiveEventsProvider$StreamUrl;", "", "api", "", "id", "", "link", "title", "type", "webLink", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApi", "()Ljava/lang/String;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLink", "getTitle", "getType", "getWebLink", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/cncverse/LiveEventsProvider$StreamUrl;", "equals", "", "other", "hashCode", "toString", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class StreamUrl {

        @Nullable
        private final String api;

        @Nullable
        private final Integer id;

        @Nullable
        private final String link;

        @Nullable
        private final String title;

        @Nullable
        private final String type;

        @Nullable
        private final String webLink;

        public static /* synthetic */ StreamUrl copy$default(StreamUrl streamUrl, String str, Integer num, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = streamUrl.api;
            }
            if ((i & 2) != 0) {
                num = streamUrl.id;
            }
            if ((i & 4) != 0) {
                str2 = streamUrl.link;
            }
            if ((i & 8) != 0) {
                str3 = streamUrl.title;
            }
            if ((i & 16) != 0) {
                str4 = streamUrl.type;
            }
            if ((i & 32) != 0) {
                str5 = streamUrl.webLink;
            }
            String str6 = str4;
            String str7 = str5;
            return streamUrl.copy(str, num, str2, str3, str6, str7);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getApi() {
            return this.api;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getLink() {
            return this.link;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getWebLink() {
            return this.webLink;
        }

        @NotNull
        public final StreamUrl copy(@Nullable String api, @Nullable Integer id, @Nullable String link, @Nullable String title, @Nullable String type, @Nullable String webLink) {
            return new StreamUrl(api, id, link, title, type, webLink);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StreamUrl)) {
                return false;
            }
            StreamUrl streamUrl = (StreamUrl) other;
            return Intrinsics.areEqual(this.api, streamUrl.api) && Intrinsics.areEqual(this.id, streamUrl.id) && Intrinsics.areEqual(this.link, streamUrl.link) && Intrinsics.areEqual(this.title, streamUrl.title) && Intrinsics.areEqual(this.type, streamUrl.type) && Intrinsics.areEqual(this.webLink, streamUrl.webLink);
        }

        public int hashCode() {
            return ((((((((((this.api == null ? 0 : this.api.hashCode()) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.link == null ? 0 : this.link.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.webLink != null ? this.webLink.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "StreamUrl(api=" + this.api + ", id=" + this.id + ", link=" + this.link + ", title=" + this.title + ", type=" + this.type + ", webLink=" + this.webLink + ')';
        }

        public StreamUrl(@Nullable String api, @Nullable Integer id, @Nullable String link, @Nullable String title, @Nullable String type, @Nullable String webLink) {
            this.api = api;
            this.id = id;
            this.link = link;
            this.title = title;
            this.type = type;
            this.webLink = webLink;
        }

        @Nullable
        public final String getApi() {
            return this.api;
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final String getLink() {
            return this.link;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getWebLink() {
            return this.webLink;
        }
    }

    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003JM\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/cncverse/LiveEventsProvider$LiveEventLoadData;", "", "eventId", "", "title", "", "poster", "slug", "formats", "", "Lcom/cncverse/LiveEventFormat;", "eventInfo", "Lcom/cncverse/LiveEventInfo;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/cncverse/LiveEventInfo;)V", "getEventId", "()I", "getTitle", "()Ljava/lang/String;", "getPoster", "getSlug", "getFormats", "()Ljava/util/List;", "getEventInfo", "()Lcom/cncverse/LiveEventInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
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
        C00191 c00191;
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
        if (continuation instanceof C00191) {
            c00191 = (C00191) continuation;
            if ((c00191.label & Integer.MIN_VALUE) != 0) {
                c00191.label -= Integer.MIN_VALUE;
            } else {
                c00191 = new C00191(continuation);
            }
        } else {
            c00191 = new C00191(continuation);
        }
        Object $result = c00191.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00191.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                }
                showTelegramPopup();
                showSubscriptionPopupIfNeeded();
                if (this.customCatLink == null) {
                    ProviderManager providerManager = ProviderManager.INSTANCE;
                    c00191.L$0 = SpillingKt.nullOutSpilledVariable(request);
                    c00191.I$0 = page2;
                    c00191.label = 2;
                    objFetchLiveEvents = providerManager.fetchLiveEvents(c00191);
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
                        C00191 c00192 = c00191;
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
                                destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle, AppUtils.INSTANCE.toJson(loadData), TvType.Live, false, new Function1() { // from class: com.cncverse.LiveEventsProvider$$ExternalSyntheticLambda7
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
                        c00191 = c00192;
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
                c00191.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00191.I$0 = page2;
                c00191.label = 1;
                objFetchCustomEvents = providerManager2.fetchCustomEvents(str2, c00191);
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
                    C00191 c00193 = c00191;
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
                            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle2, AppUtils.INSTANCE.toJson(loadData2), TvType.Live, false, new Function1() { // from class: com.cncverse.LiveEventsProvider$$ExternalSyntheticLambda7
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
                    c00191 = c00193;
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
                page2 = c00191.I$0;
                request2 = (MainPageRequest) c00191.L$0;
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
                    C00191 c00194 = c00191;
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
                            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle3, AppUtils.INSTANCE.toJson(loadData3), TvType.Live, false, new Function1() { // from class: com.cncverse.LiveEventsProvider$$ExternalSyntheticLambda7
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
                    c00191 = c00194;
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
                page2 = c00191.I$0;
                request2 = (MainPageRequest) c00191.L$0;
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
                    C00191 c00195 = c00191;
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
                            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle4, AppUtils.INSTANCE.toJson(loadData4), TvType.Live, false, new Function1() { // from class: com.cncverse.LiveEventsProvider$$ExternalSyntheticLambda7
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
                    c00191 = c00195;
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

    /* JADX WARN: Code duplicated, block: B:31:0x009d  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:38:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:45:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:48:0x0127  */
    /* JADX WARN: Code duplicated, block: B:53:0x015c  */
    /* JADX WARN: Code duplicated, block: B:55:0x0175  */
    /* JADX WARN: Code duplicated, block: B:56:0x018d  */
    /* JADX WARN: Code duplicated, block: B:59:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:65:0x012a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x01a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Instruction removed from duplicated block: B:31:0x009d, please report this as an issue */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws UnsupportedEncodingException {
        C00251 c00251;
        Object objFetchLiveEvents;
        Object objFetchCustomEvents;
        Iterable events;
        Collection destination$iv$iv;
        Collection destination$iv$iv2;
        String displayTitle;
        String status;
        String fullTitle;
        List<LiveEventFormat> formats;
        LiveEventInfo eventInfo;
        String query2;
        LiveEventInfo eventInfo2;
        String teamB;
        LiveEventInfo eventInfo3;
        String eventName;
        String searchText;
        LiveEventsProvider liveEventsProvider = this;
        String query3 = query;
        if (continuation instanceof C00251) {
            c00251 = (C00251) continuation;
            if ((c00251.label & Integer.MIN_VALUE) != 0) {
                c00251.label -= Integer.MIN_VALUE;
            } else {
                c00251 = liveEventsProvider.new C00251(continuation);
            }
        } else {
            c00251 = liveEventsProvider.new C00251(continuation);
        }
        Object $result = c00251.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00251.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return CollectionsKt.emptyList();
                }
                if (liveEventsProvider.customCatLink == null) {
                    ProviderManager providerManager = ProviderManager.INSTANCE;
                    c00251.L$0 = query3;
                    c00251.label = 2;
                    objFetchLiveEvents = providerManager.fetchLiveEvents(c00251);
                    if (objFetchLiveEvents == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    events = (List) objFetchLiveEvents;
                    Iterable $this$filter$iv = events;
                    destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        LiveEventData event = (LiveEventData) element$iv$iv;
                        String title = event.getTitle();
                        eventInfo = event.getEventInfo();
                        if (eventInfo != null) {
                            query2 = eventInfo.getTeamA();
                        } else {
                            query2 = null;
                        }
                        eventInfo2 = event.getEventInfo();
                        if (eventInfo2 != null) {
                            teamB = eventInfo2.getTeamB();
                        } else {
                            teamB = null;
                        }
                        eventInfo3 = event.getEventInfo();
                        if (eventInfo3 != null) {
                            eventName = eventInfo3.getEventName();
                        } else {
                            eventName = null;
                        }
                        LiveEventInfo eventInfo4 = event.getEventInfo();
                        if (eventInfo4 != null) {
                        }
                        Object $result2 = $result;
                        searchText = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{title, query2, teamB, eventName, eventType}), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                        if (StringsKt.contains(searchText, query3, true)) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        query3 = query3;
                        c00251 = c00251;
                        $result = $result2;
                    }
                    Iterable $this$map$iv = (List) destination$iv$iv;
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        LiveEventData event2 = (LiveEventData) item$iv$iv;
                        displayTitle = liveEventsProvider.createDisplayTitle(event2);
                        status = liveEventsProvider.getEventStatus(event2);
                        if (StringsKt.isBlank(status)) {
                            fullTitle = displayTitle;
                        } else {
                            fullTitle = status + ' ' + displayTitle;
                        }
                        final String posterUrl = liveEventsProvider.generateMatchCardUrl(event2);
                        int id = event2.getId();
                        String slug = event2.getSlug();
                        formats = event2.getFormats();
                        if (formats == null) {
                            formats = CollectionsKt.emptyList();
                        }
                        LiveEventLoadData loadData = new LiveEventLoadData(id, displayTitle, posterUrl, slug, formats, event2.getEventInfo());
                        destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(liveEventsProvider, fullTitle, AppUtils.INSTANCE.toJson(loadData), TvType.Live, false, new Function1() { // from class: com.cncverse.LiveEventsProvider$$ExternalSyntheticLambda8
                            public final Object invoke(Object obj) {
                                return LiveEventsProvider.search$lambda$1$0(posterUrl, (LiveSearchResponse) obj);
                            }
                        }, 8, (Object) null));
                        liveEventsProvider = this;
                    }
                    return (List) destination$iv$iv2;
                }
                ProviderManager providerManager2 = ProviderManager.INSTANCE;
                String str = liveEventsProvider.customCatLink;
                c00251.L$0 = query3;
                c00251.label = 1;
                objFetchCustomEvents = providerManager2.fetchCustomEvents(str, c00251);
                if (objFetchCustomEvents == coroutine_suspended) {
                    return coroutine_suspended;
                }
                events = (List) objFetchCustomEvents;
                Iterable $this$filter$iv2 = events;
                destination$iv$iv = new ArrayList();
                while (r12.hasNext()) {
                    LiveEventData event3 = (LiveEventData) element$iv$iv;
                    String title2 = event3.getTitle();
                    eventInfo = event3.getEventInfo();
                    if (eventInfo != null) {
                        query2 = eventInfo.getTeamA();
                    } else {
                        query2 = null;
                    }
                    eventInfo2 = event3.getEventInfo();
                    if (eventInfo2 != null) {
                        teamB = eventInfo2.getTeamB();
                    } else {
                        teamB = null;
                    }
                    eventInfo3 = event3.getEventInfo();
                    if (eventInfo3 != null) {
                        eventName = eventInfo3.getEventName();
                    } else {
                        eventName = null;
                    }
                    LiveEventInfo eventInfo5 = event3.getEventInfo();
                    String eventType = eventInfo5 != null ? eventInfo5.getEventType() : null;
                    Object $result3 = $result;
                    searchText = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{title2, query2, teamB, eventName, eventType}), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                    if (StringsKt.contains(searchText, query3, true)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    query3 = query3;
                    c00251 = c00251;
                    $result = $result3;
                }
                Iterable $this$map$iv2 = (List) destination$iv$iv;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                while (r7.hasNext()) {
                    LiveEventData event4 = (LiveEventData) item$iv$iv;
                    displayTitle = liveEventsProvider.createDisplayTitle(event4);
                    status = liveEventsProvider.getEventStatus(event4);
                    if (StringsKt.isBlank(status)) {
                        fullTitle = status + ' ' + displayTitle;
                    } else {
                        fullTitle = displayTitle;
                    }
                    final String posterUrl2 = liveEventsProvider.generateMatchCardUrl(event4);
                    int id2 = event4.getId();
                    String slug2 = event4.getSlug();
                    formats = event4.getFormats();
                    if (formats == null) {
                        formats = CollectionsKt.emptyList();
                    }
                    LiveEventLoadData loadData2 = new LiveEventLoadData(id2, displayTitle, posterUrl2, slug2, formats, event4.getEventInfo());
                    destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(liveEventsProvider, fullTitle, AppUtils.INSTANCE.toJson(loadData2), TvType.Live, false, new Function1() { // from class: com.cncverse.LiveEventsProvider$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj) {
                            return LiveEventsProvider.search$lambda$1$0(posterUrl2, (LiveSearchResponse) obj);
                        }
                    }, 8, (Object) null));
                    liveEventsProvider = this;
                }
                return (List) destination$iv$iv2;
            case 1:
                query3 = (String) c00251.L$0;
                ResultKt.throwOnFailure($result);
                objFetchCustomEvents = $result;
                events = (List) objFetchCustomEvents;
                Iterable $this$filter$iv3 = events;
                destination$iv$iv = new ArrayList();
                while (r12.hasNext()) {
                    LiveEventData event5 = (LiveEventData) element$iv$iv;
                    String title3 = event5.getTitle();
                    eventInfo = event5.getEventInfo();
                    if (eventInfo != null) {
                        query2 = eventInfo.getTeamA();
                    } else {
                        query2 = null;
                    }
                    eventInfo2 = event5.getEventInfo();
                    if (eventInfo2 != null) {
                        teamB = eventInfo2.getTeamB();
                    } else {
                        teamB = null;
                    }
                    eventInfo3 = event5.getEventInfo();
                    if (eventInfo3 != null) {
                        eventName = eventInfo3.getEventName();
                    } else {
                        eventName = null;
                    }
                    LiveEventInfo eventInfo6 = event5.getEventInfo();
                    if (eventInfo6 != null) {
                    }
                    Object $result4 = $result;
                    searchText = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{title3, query2, teamB, eventName, eventType}), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                    if (StringsKt.contains(searchText, query3, true)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    query3 = query3;
                    c00251 = c00251;
                    $result = $result4;
                }
                Iterable $this$map$iv3 = (List) destination$iv$iv;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                while (r7.hasNext()) {
                    LiveEventData event6 = (LiveEventData) item$iv$iv;
                    displayTitle = liveEventsProvider.createDisplayTitle(event6);
                    status = liveEventsProvider.getEventStatus(event6);
                    if (StringsKt.isBlank(status)) {
                        fullTitle = status + ' ' + displayTitle;
                    } else {
                        fullTitle = displayTitle;
                    }
                    final String posterUrl3 = liveEventsProvider.generateMatchCardUrl(event6);
                    int id3 = event6.getId();
                    String slug3 = event6.getSlug();
                    formats = event6.getFormats();
                    if (formats == null) {
                        formats = CollectionsKt.emptyList();
                    }
                    LiveEventLoadData loadData3 = new LiveEventLoadData(id3, displayTitle, posterUrl3, slug3, formats, event6.getEventInfo());
                    destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(liveEventsProvider, fullTitle, AppUtils.INSTANCE.toJson(loadData3), TvType.Live, false, new Function1() { // from class: com.cncverse.LiveEventsProvider$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj) {
                            return LiveEventsProvider.search$lambda$1$0(posterUrl3, (LiveSearchResponse) obj);
                        }
                    }, 8, (Object) null));
                    liveEventsProvider = this;
                }
                return (List) destination$iv$iv2;
            case 2:
                query3 = (String) c00251.L$0;
                ResultKt.throwOnFailure($result);
                objFetchLiveEvents = $result;
                events = (List) objFetchLiveEvents;
                Iterable $this$filter$iv4 = events;
                destination$iv$iv = new ArrayList();
                while (r12.hasNext()) {
                    LiveEventData event7 = (LiveEventData) element$iv$iv;
                    String title4 = event7.getTitle();
                    eventInfo = event7.getEventInfo();
                    if (eventInfo != null) {
                        query2 = eventInfo.getTeamA();
                    } else {
                        query2 = null;
                    }
                    eventInfo2 = event7.getEventInfo();
                    if (eventInfo2 != null) {
                        teamB = eventInfo2.getTeamB();
                    } else {
                        teamB = null;
                    }
                    eventInfo3 = event7.getEventInfo();
                    if (eventInfo3 != null) {
                        eventName = eventInfo3.getEventName();
                    } else {
                        eventName = null;
                    }
                    LiveEventInfo eventInfo7 = event7.getEventInfo();
                    if (eventInfo7 != null) {
                    }
                    Object $result5 = $result;
                    searchText = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{title4, query2, teamB, eventName, eventType}), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                    if (StringsKt.contains(searchText, query3, true)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    query3 = query3;
                    c00251 = c00251;
                    $result = $result5;
                }
                Iterable $this$map$iv4 = (List) destination$iv$iv;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                while (r7.hasNext()) {
                    LiveEventData event8 = (LiveEventData) item$iv$iv;
                    displayTitle = liveEventsProvider.createDisplayTitle(event8);
                    status = liveEventsProvider.getEventStatus(event8);
                    if (StringsKt.isBlank(status)) {
                        fullTitle = status + ' ' + displayTitle;
                    } else {
                        fullTitle = displayTitle;
                    }
                    final String posterUrl4 = liveEventsProvider.generateMatchCardUrl(event8);
                    int id4 = event8.getId();
                    String slug4 = event8.getSlug();
                    formats = event8.getFormats();
                    if (formats == null) {
                        formats = CollectionsKt.emptyList();
                    }
                    LiveEventLoadData loadData4 = new LiveEventLoadData(id4, displayTitle, posterUrl4, slug4, formats, event8.getEventInfo());
                    destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(liveEventsProvider, fullTitle, AppUtils.INSTANCE.toJson(loadData4), TvType.Live, false, new Function1() { // from class: com.cncverse.LiveEventsProvider$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj) {
                            return LiveEventsProvider.search$lambda$1$0(posterUrl4, (LiveSearchResponse) obj);
                        }
                    }, 8, (Object) null));
                    liveEventsProvider = this;
                }
                return (List) destination$iv$iv2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
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
        return MainAPIKt.newLiveStreamLoadResponse(this, data.getTitle(), url, url, new C00202(data, plot, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LiveEventsProvider$load$2 */
    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/LiveStreamLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LiveEventsProvider$load$2", f = "LiveEventsProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00202 extends SuspendLambda implements Function2<LiveStreamLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ LiveEventLoadData $data;
        final /* synthetic */ String $plot;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00202(LiveEventLoadData liveEventLoadData, String str, Continuation<? super C00202> continuation) {
            super(2, continuation);
            this.$data = liveEventLoadData;
            this.$plot = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00202 = new C00202(this.$data, this.$plot, continuation);
            c00202.L$0 = obj;
            return c00202;
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
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.LiveEventsProvider$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    LiveEventsProvider.showSubscriptionPopupIfNeeded$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.LiveEventsProvider$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveEventsProvider.showSubscriptionPopupIfNeeded$lambda$0$11($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249, $ctx, dialog, view);
                }
            });
            subscribeTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.LiveEventsProvider$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveEventsProvider.showSubscriptionPopupIfNeeded$lambda$0$12(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.LiveEventsProvider$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                LiveEventsProvider.showTelegramPopup$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.LiveEventsProvider$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            joinTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.LiveEventsProvider$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveEventsProvider.showTelegramPopup$lambda$0$9(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.LiveEventsProvider$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                LiveEventsProvider.openInExternalBrowser$lambda$0(ctx, url);
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

    /* JADX WARN: Code duplicated, block: B:104:0x03f9  */
    /* JADX WARN: Code duplicated, block: B:106:0x0409  */
    /* JADX WARN: Code duplicated, block: B:109:0x0413  */
    /* JADX WARN: Code duplicated, block: B:110:0x0421  */
    /* JADX WARN: Code duplicated, block: B:112:0x0449  */
    /* JADX WARN: Code duplicated, block: B:114:0x04a8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:115:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:118:0x04c9  */
    /* JADX WARN: Code duplicated, block: B:128:0x0531  */
    /* JADX WARN: Code duplicated, block: B:130:0x0534 A[Catch: Exception -> 0x091b, TRY_ENTER, TRY_LEAVE, TryCatch #15 {Exception -> 0x091b, blocks: (B:122:0x04f0, B:130:0x0534), top: B:265:0x04f0 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x053d  */
    /* JADX WARN: Code duplicated, block: B:150:0x0623 A[Catch: Exception -> 0x05a6, TRY_ENTER, TRY_LEAVE, TryCatch #19 {Exception -> 0x05a6, blocks: (B:142:0x0581, B:150:0x0623), top: B:271:0x0581 }] */
    /* JADX WARN: Code duplicated, block: B:158:0x070c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:159:0x070d  */
    /* JADX WARN: Code duplicated, block: B:172:0x0819  */
    /* JADX WARN: Code duplicated, block: B:173:0x0825  */
    /* JADX WARN: Code duplicated, block: B:177:0x08a7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:178:0x08a8  */
    /* JADX WARN: Code duplicated, block: B:187:0x093d  */
    /* JADX WARN: Code duplicated, block: B:190:0x0958 A[Catch: Exception -> 0x0904, TRY_ENTER, TRY_LEAVE, TryCatch #20 {Exception -> 0x0904, blocks: (B:175:0x0833, B:190:0x0958, B:207:0x0996, B:209:0x099c, B:196:0x0977, B:199:0x097e), top: B:273:0x0833 }] */
    /* JADX WARN: Code duplicated, block: B:192:0x095d A[Catch: Exception -> 0x0a8d, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x0a8d, blocks: (B:188:0x0948, B:205:0x098c, B:211:0x09a2, B:192:0x095d, B:204:0x098a), top: B:241:0x0948 }] */
    /* JADX WARN: Code duplicated, block: B:198:0x097d  */
    /* JADX WARN: Code duplicated, block: B:199:0x097e A[Catch: Exception -> 0x0904, TRY_LEAVE, TryCatch #20 {Exception -> 0x0904, blocks: (B:175:0x0833, B:190:0x0958, B:207:0x0996, B:209:0x099c, B:196:0x0977, B:199:0x097e), top: B:273:0x0833 }] */
    /* JADX WARN: Code duplicated, block: B:203:0x0988  */
    /* JADX WARN: Code duplicated, block: B:207:0x0996 A[Catch: Exception -> 0x0904, TRY_ENTER, TryCatch #20 {Exception -> 0x0904, blocks: (B:175:0x0833, B:190:0x0958, B:207:0x0996, B:209:0x099c, B:196:0x0977, B:199:0x097e), top: B:273:0x0833 }] */
    /* JADX WARN: Code duplicated, block: B:215:0x0a23 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:216:0x0a24  */
    /* JADX WARN: Code duplicated, block: B:232:0x0b18  */
    /* JADX WARN: Code duplicated, block: B:243:0x04f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:257:0x04e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:265:0x04f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:271:0x0581 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:275:0x096d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:118:0x04c9 -> B:234:0x0b2e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:161:0x0736 -> B:231:0x0b03). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:180:0x08c9 -> B:231:0x0b03). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:216:0x0a24 -> B:255:0x0a4e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:230:0x0adf -> B:231:0x0b03). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:216:0x0a24
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r41, boolean r42, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r43, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r44, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r45) {
        /*
            Method dump skipped, instruction units count: 2890
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.LiveEventsProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadLinks$lambda$0$0(Context $_ctx) {
        Toast.makeText($_ctx, "⚠️(Opening ads) Subscription expired. If you have renewed your subscription, please re-verify it in Subscription Manager.", 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isDirectStreamUrl(String url) {
        return StringsKt.contains$default(url, ".m3u8", false, 2, (Object) null) || StringsKt.contains$default(url, ".mpd", false, 2, (Object) null) || StringsKt.contains$default(url, ".mp4", false, 2, (Object) null) || StringsKt.contains$default(url, ".ts", false, 2, (Object) null) || StringsKt.contains$default(url, ".mkv", false, 2, (Object) null) || StringsKt.contains$default(url, ".webm", false, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object resolveEmbedUrlIfNeeded(String url, Continuation<? super String> continuation) {
        if (isDirectStreamUrl(url)) {
            return url;
        }
        return loadEmbedInWebView(url, continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LiveEventsProvider$loadEmbedInWebView$2 */
    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LiveEventsProvider$loadEmbedInWebView$2", f = "LiveEventsProvider.kt", i = {}, l = {815}, m = "invokeSuspend", n = {}, nl = {935}, s = {}, v = 2)
    static final class C00212 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $embedUrl;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ LiveEventsProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00212(String str, LiveEventsProvider liveEventsProvider, Continuation<? super C00212> continuation) {
            super(2, continuation);
            this.$embedUrl = str;
            this.this$0 = liveEventsProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00212(this.$embedUrl, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0 */
        /* JADX WARN: Type inference failed for: r11v1 */
        /* JADX WARN: Type inference failed for: r11v2 */
        /* JADX WARN: Type inference failed for: r11v3 */
        /* JADX WARN: Type inference failed for: r11v4 */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v3 */
        public final Object invokeSuspend(Object obj) {
            ?? r4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    String str = this.$embedUrl;
                    final LiveEventsProvider liveEventsProvider = this.this$0;
                    this.L$0 = str;
                    this.L$1 = liveEventsProvider;
                    this.label = 1;
                    Continuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted((Continuation) this));
                    final Continuation continuation = safeContinuation;
                    ?? r11 = 0;
                    r11 = 0;
                    try {
                        Context context = LiveEventsProvider.INSTANCE.getContext();
                        if (context == null) {
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
                            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                            webView.addJavascriptInterface(new Object() { // from class: com.cncverse.LiveEventsProvider$loadEmbedInWebView$2$1$bridge$1
                                @JavascriptInterface
                                public final void onStreamUrlFound(final String url) {
                                    if (!booleanRef.element && !StringsKt.isBlank(url)) {
                                        booleanRef.element = true;
                                        objectRef.element = url;
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
                                    final String requestUrl = request.getUrl().toString();
                                    if (liveEventsProvider.isDirectStreamUrl(requestUrl) && !booleanRef.element) {
                                        booleanRef.element = true;
                                        objectRef.element = requestUrl;
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
                                                continuation3.resumeWith(Result.constructor-impl(requestUrl));
                                            }
                                        });
                                    }
                                    return super.shouldInterceptRequest(view, request);
                                }

                                @Override // android.webkit.WebViewClient
                                public void onPageFinished(WebView view, String pageUrl) {
                                    super.onPageFinished(view, pageUrl);
                                    if (!booleanRef.element) {
                                        Handler handler = new Handler(Looper.getMainLooper());
                                        final WebView webView2 = webView;
                                        handler.postDelayed(new Runnable() { // from class: com.cncverse.LiveEventsProvider$loadEmbedInWebView$2$1$1$onPageFinished$1
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                try {
                                                    webView2.evaluateJavascript("(function() {\n    if (typeof playbackURL !== 'undefined' && playbackURL) {\n        window.StreamBridge.onStreamUrlFound(playbackURL);\n    }\n})();", null);
                                                } catch (Exception e) {
                                                }
                                            }
                                        }, 500L);
                                    }
                                    if (!booleanRef.element) {
                                        Handler handler2 = new Handler(Looper.getMainLooper());
                                        final Ref.BooleanRef booleanRef2 = booleanRef;
                                        final WebView webView3 = webView;
                                        final Continuation<String> continuation2 = continuation;
                                        handler2.postDelayed(new Runnable() { // from class: com.cncverse.LiveEventsProvider$loadEmbedInWebView$2$1$1$onPageFinished$2
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                if (!booleanRef2.element) {
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
                            webView.loadUrl(str);
                            r4 = 0;
                            r11 = 30000;
                            try {
                                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.cncverse.LiveEventsProvider$loadEmbedInWebView$2$1$2
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        if (!booleanRef.element && objectRef.element == null) {
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
                            } catch (Exception e) {
                                Result.Companion companion2 = Result.Companion;
                                continuation.resumeWith(Result.constructor-impl((Object) r4));
                            }
                        }
                        break;
                    } catch (Exception e2) {
                        r4 = r11;
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
                    ResultKt.throwOnFailure(obj);
                    return obj;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadEmbedInWebView(String embedUrl, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new C00212(embedUrl, this, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LiveEventsProvider$fetchChannelStreams$2 */
    /* JADX INFO: compiled from: LiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/cncverse/LiveEventsProvider$ChannelStreamResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LiveEventsProvider$fetchChannelStreams$2", f = "LiveEventsProvider.kt", i = {}, l = {943}, m = "invokeSuspend", n = {}, nl = {944}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nLiveEventsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveEventsProvider.kt\ncom/cncverse/LiveEventsProvider$fetchChannelStreams$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,1011:1\n63#2:1012\n64#2,15:1014\n1#3:1013\n50#4:1029\n43#4:1030\n*S KotlinDebug\n*F\n+ 1 LiveEventsProvider.kt\ncom/cncverse/LiveEventsProvider$fetchChannelStreams$2\n*L\n961#1:1012\n961#1:1014,15\n961#1:1013\n961#1:1029\n961#1:1030\n*E\n"})
    static final class C00172 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ChannelStreamResponse>, Object> {
        final /* synthetic */ String $slug;
        int label;
        final /* synthetic */ LiveEventsProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00172(String str, LiveEventsProvider liveEventsProvider, Continuation<? super C00172> continuation) {
            super(2, continuation);
            this.$slug = str;
            this.this$0 = liveEventsProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00172(this.$slug, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ChannelStreamResponse> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object baseUrl;
            Object obj;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            boolean z = true;
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        baseUrl = ProviderManager.INSTANCE.getBaseUrl((Continuation) this);
                        if (baseUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        baseUrl = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String baseUrl2 = (String) baseUrl;
                StringBuilder sbAppend = new StringBuilder().append(baseUrl2).append("/channels/");
                String lowerCase = this.$slug.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String url = sbAppend.append(lowerCase).append(".txt").toString();
                Request request = new Request.Builder().url(url).header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36").build();
                Response response = this.this$0.client.newCall(request).execute();
                if (!response.isSuccessful()) {
                    return null;
                }
                String encryptedData = response.body().string();
                String str = encryptedData;
                if (str == null || StringsKt.isBlank(str)) {
                    return null;
                }
                String decryptedData = CryptoUtils.INSTANCE.decryptData(StringsKt.trim(encryptedData).toString());
                String str2 = decryptedData;
                if (str2 != null && !StringsKt.isBlank(str2)) {
                    z = false;
                }
                if (z) {
                    return null;
                }
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(ChannelStreamResponse.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) != null) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ChannelStreamResponse.class), (List) null, 2, (Object) null));
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
                        return MainAPIKt.getJson().decodeFromString(deserializationStrategy, decryptedData);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                    } catch (Throwable th3) {
                    }
                }
                ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                try {
                    return $this$readValue$iv$iv.readValue(decryptedData, new TypeReference<ChannelStreamResponse>() { // from class: com.cncverse.LiveEventsProvider$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$1
                    });
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
            }
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchChannelStreams(String slug, Continuation<? super ChannelStreamResponse> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00172(slug, this, null), continuation);
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
