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
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchQuality;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.ui.settings.Globals;
import com.lagradost.cloudstream3.utils.AppUtils;
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
import kotlin.Result;
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
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamFlixProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamFlixProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 B2\u00020\u0001:\bBCDEFGHIB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0082@¢\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010)\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010*J\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010*J&\u00100\u001a\b\u0012\u0004\u0012\u0002010'2\u0006\u00102\u001a\u00020\u00052\b\b\u0002\u00103\u001a\u00020\"H\u0082@¢\u0006\u0002\u00104JF\u00105\u001a\u00020\u00162\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00162\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;092\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020;09H\u0096@¢\u0006\u0002\u0010>J\b\u0010?\u001a\u00020;H\u0002J\b\u0010@\u001a\u00020;H\u0002J\u0010\u0010A\u001a\u00020;2\u0006\u0010-\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\u0014\u0010\u0015\u001a\u00020\u0016X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u0016X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/cncverse/StreamFlixProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "lang", "getLang", "setLang", "hasMainPage", "", "getHasMainPage", "()Z", "hasQuickSearch", "getHasQuickSearch", "configData", "Lcom/cncverse/StreamFlixProvider$ConfigResponse;", "getConfig", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "webSocketExtractor", "Lcom/cncverse/StreamFlixWebSocketExtractor;", "getEpisodesFromWebSocket", "Lcom/lagradost/cloudstream3/Episode;", "movieKey", "totalSeasons", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showSubscriptionPopupIfNeeded", "showTelegramPopup", "openInExternalBrowser", "Companion", "StreamFlixData", "StreamFlixItem", "ConfigResponse", "WebSocketRequest", "WebSocketData", "WebSocketBody", "Episode", "StreamFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStreamFlixProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamFlixProvider.kt\ncom/cncverse/StreamFlixProvider\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,802:1\n63#2:803\n64#2,15:805\n63#2:822\n64#2,15:824\n63#2:855\n64#2,15:857\n63#2:879\n64#2,15:881\n1#3:804\n1#3:823\n1#3:856\n1#3:880\n1#3:898\n50#4:820\n43#4:821\n50#4:839\n43#4:840\n50#4:872\n43#4:873\n50#4:896\n43#4:897\n777#5:841\n873#5,2:842\n1586#5:844\n1661#5,3:845\n777#5:848\n873#5,2:849\n1586#5:851\n1661#5,3:852\n777#5:874\n873#5,2:875\n1915#5,2:877\n1915#5,2:903\n1915#5,2:905\n1915#5,2:907\n1915#5,2:909\n1915#5,2:911\n221#6:899\n221#6,2:900\n222#6:902\n*S KotlinDebug\n*F\n+ 1 StreamFlixProvider.kt\ncom/cncverse/StreamFlixProvider\n*L\n140#1:803\n140#1:805,15\n179#1:822\n179#1:824,15\n246#1:855\n246#1:857,15\n317#1:879\n317#1:881,15\n140#1:804\n179#1:823\n246#1:856\n317#1:880\n140#1:820\n140#1:821\n179#1:839\n179#1:840\n246#1:872\n246#1:873\n317#1:896\n317#1:897\n181#1:841\n181#1:842,2\n181#1:844\n181#1:845,3\n193#1:848\n193#1:849,2\n193#1:851\n193#1:852,3\n248#1:874\n248#1:875,2\n256#1:877,2\n451#1:903,2\n467#1:905,2\n498#1:907,2\n519#1:909,2\n535#1:911,2\n376#1:899\n377#1:900,2\n376#1:902\n*E\n"})
public final class StreamFlixProvider extends MainAPI {
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
    private ConfigResponse configData;

    @NotNull
    private String mainUrl = "https://api.streamflix.app";

    @NotNull
    private String name = "StreamFlix 2.0";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});

    @NotNull
    private String lang = "ta";
    private final boolean hasMainPage = true;
    private final boolean hasQuickSearch = true;

    @NotNull
    private final StreamFlixWebSocketExtractor webSocketExtractor = new StreamFlixWebSocketExtractor();

    /* JADX INFO: renamed from: com.cncverse.StreamFlixProvider$getConfig$1 */
    /* JADX INFO: compiled from: StreamFlixProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.StreamFlixProvider", f = "StreamFlixProvider.kt", i = {0}, l = {139}, m = "getConfig", n = {"headers"}, nl = {140}, s = {"L$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
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
            return StreamFlixProvider.this.getConfig((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.StreamFlixProvider$getEpisodesFromWebSocket$1 */
    /* JADX INFO: compiled from: StreamFlixProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.StreamFlixProvider", f = "StreamFlixProvider.kt", i = {0, 0, 0}, l = {374}, m = "getEpisodesFromWebSocket", n = {"movieKey", "episodes", "totalSeasons"}, nl = {376}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamFlixProvider.this.getEpisodesFromWebSocket(null, 0, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.StreamFlixProvider$getMainPage$1 */
    /* JADX INFO: compiled from: StreamFlixProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.StreamFlixProvider", f = "StreamFlixProvider.kt", i = {0, 0, 0, 0}, l = {177}, m = "getMainPage", n = {"request", "items", "headers", "page"}, nl = {179}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamFlixProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.StreamFlixProvider$load$1 */
    /* JADX INFO: compiled from: StreamFlixProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.StreamFlixProvider", f = "StreamFlixProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {297, 316, 331, 333, 347}, m = "load", n = {"url", "str", "movieKey", "type", "url", "str", "movieKey", "type", "headers", "url", "str", "movieKey", "type", "headers", "response", "data", "item", "movieName", "seasonCount", "url", "str", "movieKey", "type", "headers", "response", "data", "item", "movieName", "episodes", "seasonCount", "url", "str", "movieKey", "type", "headers", "response", "data", "item", "movieName"}, nl = {308, 317, 333, 347, 323}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
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

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamFlixProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.StreamFlixProvider$loadLinks$1 */
    /* JADX INFO: compiled from: StreamFlixProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.StreamFlixProvider", f = "StreamFlixProvider.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {445, 454, 470, 501, 522, 538}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "str", "isCasting", "data", "subtitleCallback", "callback", "str", "config", "$this$forEach$iv", "element$iv", "baseUrl", "videoUrl", "isCasting", "$i$f$forEach", "$i$a$-forEach-StreamFlixProvider$loadLinks$3", "data", "subtitleCallback", "callback", "str", "config", "$this$forEach$iv", "element$iv", "baseUrl", "videoUrl", "isCasting", "$i$f$forEach", "$i$a$-forEach-StreamFlixProvider$loadLinks$4", "data", "subtitleCallback", "callback", "str", "config", "parts", "movieKey", "episodeInfo", "seasonMatch", "episodeMatch", "season", "episode", "$this$forEach$iv", "element$iv", "baseUrl", "videoUrl", "isCasting", "$i$f$forEach", "$i$a$-forEach-StreamFlixProvider$loadLinks$5", "data", "subtitleCallback", "callback", "str", "config", "movieLink", "$this$forEach$iv", "element$iv", "baseUrl", "videoUrl", "isCasting", "$i$f$forEach", "$i$a$-forEach-StreamFlixProvider$loadLinks$6", "data", "subtitleCallback", "callback", "str", "config", "movieLink", "$this$forEach$iv", "element$iv", "baseUrl", "videoUrl", "isCasting", "$i$f$forEach", "$i$a$-forEach-StreamFlixProvider$loadLinks$7"}, nl = {447, 453, 469, 500, 521, 537}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$14", "L$15", "L$16", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "Z$0", "I$0", "I$1"}, v = 2)
    static final class C00071 extends ContinuationImpl {
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
            return StreamFlixProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.StreamFlixProvider$search$1 */
    /* JADX INFO: compiled from: StreamFlixProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.StreamFlixProvider", f = "StreamFlixProvider.kt", i = {0, 0, 0}, l = {245}, m = "search", n = {"query", "searchResults", "headers"}, nl = {246}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamFlixProvider.this.search(null, (Continuation) this);
        }
    }

    /* JADX INFO: compiled from: StreamFlixProvider.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/cncverse/StreamFlixProvider$Companion;", "", "<init>", "()V", "isCsGuardActive", "", "csGuardWasEverActive", "isCsGuardBlocked", "showCsGuardToast", "", "ctx", "Landroid/content/Context;", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "OMG10", "", "lastBrowserOpenMs", "", "telegramPopupShown", "subscriptionPopupShown", "BROWSER_DEBOUNCE_MS", "StreamFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nStreamFlixProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamFlixProvider.kt\ncom/cncverse/StreamFlixProvider$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,802:1\n1#2:803\n*E\n"})
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
                StreamFlixProvider.csGuardWasEverActive = true;
            }
            return StreamFlixProvider.csGuardWasEverActive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCsGuardToast(final Context ctx) {
            if (ctx == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.StreamFlixProvider$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    StreamFlixProvider.Companion.showCsGuardToast$lambda$0(ctx);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showCsGuardToast$lambda$0(Context $c) {
            Toast.makeText($c, "🚫 CSGuard detected — Restart CloudStream after removing CSGuard to use CNCRepo", 1).show();
        }

        @Nullable
        public final Context getContext() {
            return StreamFlixProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            StreamFlixProvider.context = context;
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

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    /* JADX INFO: compiled from: StreamFlixProvider.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/cncverse/StreamFlixProvider$StreamFlixData;", "", "data", "", "Lcom/cncverse/StreamFlixProvider$StreamFlixItem;", "<init>", "(Ljava/util/List;)V", "getData", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class StreamFlixData {

        @JsonProperty("data")
        @NotNull
        private final List<StreamFlixItem> data;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StreamFlixData copy$default(StreamFlixData streamFlixData, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = streamFlixData.data;
            }
            return streamFlixData.copy(list);
        }

        @NotNull
        public final List<StreamFlixItem> component1() {
            return this.data;
        }

        @NotNull
        public final StreamFlixData copy(@JsonProperty("data") @NotNull List<StreamFlixItem> data) {
            return new StreamFlixData(data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof StreamFlixData) && Intrinsics.areEqual(this.data, ((StreamFlixData) other).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "StreamFlixData(data=" + this.data + ')';
        }

        public StreamFlixData(@JsonProperty("data") @NotNull List<StreamFlixItem> list) {
            this.data = list;
        }

        @NotNull
        public final List<StreamFlixItem> getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: StreamFlixProvider.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b0\b\u0086\b\u0018\u00002\u00020\u0001BÏ\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00104\u001a\u00020\u000bHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003JÖ\u0001\u0010?\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\n\u001a\u00020\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010@J\u0014\u0010A\u001a\u00020\u00032\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010C\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010D\u001a\u00020\u0005HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0019R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001b¨\u0006E"}, d2 = {"Lcom/cncverse/StreamFlixProvider$StreamFlixItem;", "", "isTV", "", "movieName", "", "movieDesc", "moviePoster", "movieBanner", "movieYear", "movieRating", "", "movieType", "movieInfo", "movieDuration", "movieKey", "movieLink", "movieTrailer", "movieImdb", "tmdb", "movieViews", "", "newSeason", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "()Z", "getMovieName", "()Ljava/lang/String;", "getMovieDesc", "getMoviePoster", "getMovieBanner", "getMovieYear", "getMovieRating", "()D", "getMovieType", "getMovieInfo", "getMovieDuration", "getMovieKey", "getMovieLink", "getMovieTrailer", "getMovieImdb", "getTmdb", "getMovieViews", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNewSeason", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/cncverse/StreamFlixProvider$StreamFlixItem;", "equals", "other", "hashCode", "toString", "StreamFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class StreamFlixItem {

        @JsonProperty("isTV")
        private final boolean isTV;

        @JsonProperty("moviebanner")
        @Nullable
        private final String movieBanner;

        @JsonProperty("moviedesc")
        @Nullable
        private final String movieDesc;

        @JsonProperty("movieduration")
        @Nullable
        private final String movieDuration;

        @JsonProperty("movieimdb")
        @Nullable
        private final String movieImdb;

        @JsonProperty("movieinfo")
        @Nullable
        private final String movieInfo;

        @JsonProperty("moviekey")
        @Nullable
        private final String movieKey;

        @JsonProperty("movielink")
        @Nullable
        private final String movieLink;

        @JsonProperty("moviename")
        @Nullable
        private final String movieName;

        @JsonProperty("movieposter")
        @Nullable
        private final String moviePoster;

        @JsonProperty("movierating")
        private final double movieRating;

        @JsonProperty("movietrailer")
        @Nullable
        private final String movieTrailer;

        @JsonProperty("movietype")
        @Nullable
        private final String movieType;

        @JsonProperty("movieviews")
        @Nullable
        private final Integer movieViews;

        @JsonProperty("movieyear")
        @Nullable
        private final String movieYear;

        @JsonProperty("newseason")
        @Nullable
        private final String newSeason;

        @JsonProperty("tmdb")
        @Nullable
        private final String tmdb;

        public static /* synthetic */ StreamFlixItem copy$default(StreamFlixItem streamFlixItem, boolean z, String str, String str2, String str3, String str4, String str5, double d, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Integer num, String str14, int i, Object obj) {
            String str15;
            Integer num2;
            boolean z2 = (i & 1) != 0 ? streamFlixItem.isTV : z;
            String str16 = (i & 2) != 0 ? streamFlixItem.movieName : str;
            String str17 = (i & 4) != 0 ? streamFlixItem.movieDesc : str2;
            String str18 = (i & 8) != 0 ? streamFlixItem.moviePoster : str3;
            String str19 = (i & 16) != 0 ? streamFlixItem.movieBanner : str4;
            String str20 = (i & 32) != 0 ? streamFlixItem.movieYear : str5;
            double d2 = (i & 64) != 0 ? streamFlixItem.movieRating : d;
            String str21 = (i & 128) != 0 ? streamFlixItem.movieType : str6;
            String str22 = (i & 256) != 0 ? streamFlixItem.movieInfo : str7;
            String str23 = (i & 512) != 0 ? streamFlixItem.movieDuration : str8;
            String str24 = (i & 1024) != 0 ? streamFlixItem.movieKey : str9;
            String str25 = (i & 2048) != 0 ? streamFlixItem.movieLink : str10;
            String str26 = (i & 4096) != 0 ? streamFlixItem.movieTrailer : str11;
            boolean z3 = z2;
            String str27 = (i & 8192) != 0 ? streamFlixItem.movieImdb : str12;
            String str28 = (i & 16384) != 0 ? streamFlixItem.tmdb : str13;
            Integer num3 = (i & 32768) != 0 ? streamFlixItem.movieViews : num;
            if ((i & 65536) != 0) {
                num2 = num3;
                str15 = streamFlixItem.newSeason;
            } else {
                str15 = str14;
                num2 = num3;
            }
            return streamFlixItem.copy(z3, str16, str17, str18, str19, str20, d2, str21, str22, str23, str24, str25, str26, str27, str28, num2, str15);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsTV() {
            return this.isTV;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getMovieDuration() {
            return this.movieDuration;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getMovieKey() {
            return this.movieKey;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getMovieLink() {
            return this.movieLink;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getMovieTrailer() {
            return this.movieTrailer;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getMovieImdb() {
            return this.movieImdb;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getTmdb() {
            return this.tmdb;
        }

        @Nullable
        /* JADX INFO: renamed from: component16, reason: from getter */
        public final Integer getMovieViews() {
            return this.movieViews;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final String getNewSeason() {
            return this.newSeason;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMovieName() {
            return this.movieName;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMovieDesc() {
            return this.movieDesc;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getMoviePoster() {
            return this.moviePoster;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getMovieBanner() {
            return this.movieBanner;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getMovieYear() {
            return this.movieYear;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final double getMovieRating() {
            return this.movieRating;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getMovieType() {
            return this.movieType;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getMovieInfo() {
            return this.movieInfo;
        }

        @NotNull
        public final StreamFlixItem copy(@JsonProperty("isTV") boolean isTV, @JsonProperty("moviename") @Nullable String movieName, @JsonProperty("moviedesc") @Nullable String movieDesc, @JsonProperty("movieposter") @Nullable String moviePoster, @JsonProperty("moviebanner") @Nullable String movieBanner, @JsonProperty("movieyear") @Nullable String movieYear, @JsonProperty("movierating") double movieRating, @JsonProperty("movietype") @Nullable String movieType, @JsonProperty("movieinfo") @Nullable String movieInfo, @JsonProperty("movieduration") @Nullable String movieDuration, @JsonProperty("moviekey") @Nullable String movieKey, @JsonProperty("movielink") @Nullable String movieLink, @JsonProperty("movietrailer") @Nullable String movieTrailer, @JsonProperty("movieimdb") @Nullable String movieImdb, @JsonProperty("tmdb") @Nullable String tmdb, @JsonProperty("movieviews") @Nullable Integer movieViews, @JsonProperty("newseason") @Nullable String newSeason) {
            return new StreamFlixItem(isTV, movieName, movieDesc, moviePoster, movieBanner, movieYear, movieRating, movieType, movieInfo, movieDuration, movieKey, movieLink, movieTrailer, movieImdb, tmdb, movieViews, newSeason);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StreamFlixItem)) {
                return false;
            }
            StreamFlixItem streamFlixItem = (StreamFlixItem) other;
            return this.isTV == streamFlixItem.isTV && Intrinsics.areEqual(this.movieName, streamFlixItem.movieName) && Intrinsics.areEqual(this.movieDesc, streamFlixItem.movieDesc) && Intrinsics.areEqual(this.moviePoster, streamFlixItem.moviePoster) && Intrinsics.areEqual(this.movieBanner, streamFlixItem.movieBanner) && Intrinsics.areEqual(this.movieYear, streamFlixItem.movieYear) && Double.compare(this.movieRating, streamFlixItem.movieRating) == 0 && Intrinsics.areEqual(this.movieType, streamFlixItem.movieType) && Intrinsics.areEqual(this.movieInfo, streamFlixItem.movieInfo) && Intrinsics.areEqual(this.movieDuration, streamFlixItem.movieDuration) && Intrinsics.areEqual(this.movieKey, streamFlixItem.movieKey) && Intrinsics.areEqual(this.movieLink, streamFlixItem.movieLink) && Intrinsics.areEqual(this.movieTrailer, streamFlixItem.movieTrailer) && Intrinsics.areEqual(this.movieImdb, streamFlixItem.movieImdb) && Intrinsics.areEqual(this.tmdb, streamFlixItem.tmdb) && Intrinsics.areEqual(this.movieViews, streamFlixItem.movieViews) && Intrinsics.areEqual(this.newSeason, streamFlixItem.newSeason);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((StreamFlixProvider$StreamFlixItem$$ExternalSyntheticBackport0.m2m(this.isTV) * 31) + (this.movieName == null ? 0 : this.movieName.hashCode())) * 31) + (this.movieDesc == null ? 0 : this.movieDesc.hashCode())) * 31) + (this.moviePoster == null ? 0 : this.moviePoster.hashCode())) * 31) + (this.movieBanner == null ? 0 : this.movieBanner.hashCode())) * 31) + (this.movieYear == null ? 0 : this.movieYear.hashCode())) * 31) + StreamFlixProvider$StreamFlixItem$$ExternalSyntheticBackport1.m3m(this.movieRating)) * 31) + (this.movieType == null ? 0 : this.movieType.hashCode())) * 31) + (this.movieInfo == null ? 0 : this.movieInfo.hashCode())) * 31) + (this.movieDuration == null ? 0 : this.movieDuration.hashCode())) * 31) + (this.movieKey == null ? 0 : this.movieKey.hashCode())) * 31) + (this.movieLink == null ? 0 : this.movieLink.hashCode())) * 31) + (this.movieTrailer == null ? 0 : this.movieTrailer.hashCode())) * 31) + (this.movieImdb == null ? 0 : this.movieImdb.hashCode())) * 31) + (this.tmdb == null ? 0 : this.tmdb.hashCode())) * 31) + (this.movieViews == null ? 0 : this.movieViews.hashCode())) * 31) + (this.newSeason != null ? this.newSeason.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("StreamFlixItem(isTV=").append(this.isTV).append(", movieName=").append(this.movieName).append(", movieDesc=").append(this.movieDesc).append(", moviePoster=").append(this.moviePoster).append(", movieBanner=").append(this.movieBanner).append(", movieYear=").append(this.movieYear).append(", movieRating=").append(this.movieRating).append(", movieType=").append(this.movieType).append(", movieInfo=").append(this.movieInfo).append(", movieDuration=").append(this.movieDuration).append(", movieKey=").append(this.movieKey).append(", movieLink=");
            sb.append(this.movieLink).append(", movieTrailer=").append(this.movieTrailer).append(", movieImdb=").append(this.movieImdb).append(", tmdb=").append(this.tmdb).append(", movieViews=").append(this.movieViews).append(", newSeason=").append(this.newSeason).append(')');
            return sb.toString();
        }

        public StreamFlixItem(@JsonProperty("isTV") boolean isTV, @JsonProperty("moviename") @Nullable String movieName, @JsonProperty("moviedesc") @Nullable String movieDesc, @JsonProperty("movieposter") @Nullable String moviePoster, @JsonProperty("moviebanner") @Nullable String movieBanner, @JsonProperty("movieyear") @Nullable String movieYear, @JsonProperty("movierating") double movieRating, @JsonProperty("movietype") @Nullable String movieType, @JsonProperty("movieinfo") @Nullable String movieInfo, @JsonProperty("movieduration") @Nullable String movieDuration, @JsonProperty("moviekey") @Nullable String movieKey, @JsonProperty("movielink") @Nullable String movieLink, @JsonProperty("movietrailer") @Nullable String movieTrailer, @JsonProperty("movieimdb") @Nullable String movieImdb, @JsonProperty("tmdb") @Nullable String tmdb, @JsonProperty("movieviews") @Nullable Integer movieViews, @JsonProperty("newseason") @Nullable String newSeason) {
            this.isTV = isTV;
            this.movieName = movieName;
            this.movieDesc = movieDesc;
            this.moviePoster = moviePoster;
            this.movieBanner = movieBanner;
            this.movieYear = movieYear;
            this.movieRating = movieRating;
            this.movieType = movieType;
            this.movieInfo = movieInfo;
            this.movieDuration = movieDuration;
            this.movieKey = movieKey;
            this.movieLink = movieLink;
            this.movieTrailer = movieTrailer;
            this.movieImdb = movieImdb;
            this.tmdb = tmdb;
            this.movieViews = movieViews;
            this.newSeason = newSeason;
        }

        public final boolean isTV() {
            return this.isTV;
        }

        @Nullable
        public final String getMovieName() {
            return this.movieName;
        }

        @Nullable
        public final String getMovieDesc() {
            return this.movieDesc;
        }

        @Nullable
        public final String getMoviePoster() {
            return this.moviePoster;
        }

        @Nullable
        public final String getMovieBanner() {
            return this.movieBanner;
        }

        @Nullable
        public final String getMovieYear() {
            return this.movieYear;
        }

        public final double getMovieRating() {
            return this.movieRating;
        }

        @Nullable
        public final String getMovieType() {
            return this.movieType;
        }

        @Nullable
        public final String getMovieInfo() {
            return this.movieInfo;
        }

        @Nullable
        public final String getMovieDuration() {
            return this.movieDuration;
        }

        @Nullable
        public final String getMovieKey() {
            return this.movieKey;
        }

        @Nullable
        public final String getMovieLink() {
            return this.movieLink;
        }

        @Nullable
        public final String getMovieTrailer() {
            return this.movieTrailer;
        }

        @Nullable
        public final String getMovieImdb() {
            return this.movieImdb;
        }

        @Nullable
        public final String getTmdb() {
            return this.tmdb;
        }

        @Nullable
        public final Integer getMovieViews() {
            return this.movieViews;
        }

        @Nullable
        public final String getNewSeason() {
            return this.newSeason;
        }
    }

    /* JADX INFO: compiled from: StreamFlixProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0001\u0010\f\u001a\u00020\r\u0012\b\b\u0001\u0010\u000e\u001a\u00020\r\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\u0004HÆ\u0003J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J\t\u0010+\u001a\u00020\u0004HÆ\u0003J\t\u0010,\u001a\u00020\u0004HÆ\u0003J\u008f\u0001\u0010-\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0003\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u00042\b\b\u0003\u0010\u000b\u001a\u00020\u00042\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0003\u0010\u000e\u001a\u00020\r2\b\b\u0003\u0010\u000f\u001a\u00020\u00042\b\b\u0003\u0010\u0010\u001a\u00020\u0004HÆ\u0001J\u0014\u0010.\u001a\u00020\r2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00100\u001a\u00020\tHÖ\u0081\u0004J\n\u00101\u001a\u00020\u0004HÖ\u0081\u0004R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0016\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0016\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001b¨\u00062"}, d2 = {"Lcom/cncverse/StreamFlixProvider$ConfigResponse;", "", "movies", "", "", "tv", "premium", "download", "latest", "", "banner", "video", "newApp", "", "notice", "title", "text", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;)V", "getMovies", "()Ljava/util/List;", "getTv", "getPremium", "getDownload", "getLatest", "()I", "getBanner", "()Ljava/lang/String;", "getVideo", "getNewApp", "()Z", "getNotice", "getTitle", "getText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "StreamFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ConfigResponse {

        @JsonProperty("banner")
        @NotNull
        private final String banner;

        @JsonProperty("download")
        @NotNull
        private final List<String> download;

        @JsonProperty("latest")
        private final int latest;

        @JsonProperty("movies")
        @NotNull
        private final List<String> movies;

        @JsonProperty("newapp")
        private final boolean newApp;

        @JsonProperty("notice")
        private final boolean notice;

        @JsonProperty("premium")
        @NotNull
        private final List<String> premium;

        @JsonProperty("text")
        @NotNull
        private final String text;

        @JsonProperty("title")
        @NotNull
        private final String title;

        @JsonProperty("tv")
        @NotNull
        private final List<String> tv;

        @JsonProperty("video")
        @NotNull
        private final String video;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ConfigResponse copy$default(ConfigResponse configResponse, List list, List list2, List list3, List list4, int i, String str, String str2, boolean z, boolean z2, String str3, String str4, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = configResponse.movies;
            }
            if ((i2 & 2) != 0) {
                list2 = configResponse.tv;
            }
            if ((i2 & 4) != 0) {
                list3 = configResponse.premium;
            }
            if ((i2 & 8) != 0) {
                list4 = configResponse.download;
            }
            if ((i2 & 16) != 0) {
                i = configResponse.latest;
            }
            if ((i2 & 32) != 0) {
                str = configResponse.banner;
            }
            if ((i2 & 64) != 0) {
                str2 = configResponse.video;
            }
            if ((i2 & 128) != 0) {
                z = configResponse.newApp;
            }
            if ((i2 & 256) != 0) {
                z2 = configResponse.notice;
            }
            if ((i2 & 512) != 0) {
                str3 = configResponse.title;
            }
            if ((i2 & 1024) != 0) {
                str4 = configResponse.text;
            }
            String str5 = str3;
            String str6 = str4;
            boolean z3 = z;
            boolean z4 = z2;
            String str7 = str;
            String str8 = str2;
            int i3 = i;
            List list5 = list3;
            return configResponse.copy(list, list2, list5, list4, i3, str7, str8, z3, z4, str5, str6);
        }

        @NotNull
        public final List<String> component1() {
            return this.movies;
        }

        @NotNull
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getText() {
            return this.text;
        }

        @NotNull
        public final List<String> component2() {
            return this.tv;
        }

        @NotNull
        public final List<String> component3() {
            return this.premium;
        }

        @NotNull
        public final List<String> component4() {
            return this.download;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getLatest() {
            return this.latest;
        }

        @NotNull
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getBanner() {
            return this.banner;
        }

        @NotNull
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getVideo() {
            return this.video;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getNewApp() {
            return this.newApp;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getNotice() {
            return this.notice;
        }

        @NotNull
        public final ConfigResponse copy(@JsonProperty("movies") @NotNull List<String> movies, @JsonProperty("tv") @NotNull List<String> tv, @JsonProperty("premium") @NotNull List<String> premium, @JsonProperty("download") @NotNull List<String> download, @JsonProperty("latest") int latest, @JsonProperty("banner") @NotNull String banner, @JsonProperty("video") @NotNull String video, @JsonProperty("newapp") boolean newApp, @JsonProperty("notice") boolean notice, @JsonProperty("title") @NotNull String title, @JsonProperty("text") @NotNull String text) {
            return new ConfigResponse(movies, tv, premium, download, latest, banner, video, newApp, notice, title, text);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConfigResponse)) {
                return false;
            }
            ConfigResponse configResponse = (ConfigResponse) other;
            return Intrinsics.areEqual(this.movies, configResponse.movies) && Intrinsics.areEqual(this.tv, configResponse.tv) && Intrinsics.areEqual(this.premium, configResponse.premium) && Intrinsics.areEqual(this.download, configResponse.download) && this.latest == configResponse.latest && Intrinsics.areEqual(this.banner, configResponse.banner) && Intrinsics.areEqual(this.video, configResponse.video) && this.newApp == configResponse.newApp && this.notice == configResponse.notice && Intrinsics.areEqual(this.title, configResponse.title) && Intrinsics.areEqual(this.text, configResponse.text);
        }

        public int hashCode() {
            return (((((((((((((((((((this.movies.hashCode() * 31) + this.tv.hashCode()) * 31) + this.premium.hashCode()) * 31) + this.download.hashCode()) * 31) + this.latest) * 31) + this.banner.hashCode()) * 31) + this.video.hashCode()) * 31) + StreamFlixProvider$ConfigResponse$$ExternalSyntheticBackport0.m0m(this.newApp)) * 31) + StreamFlixProvider$ConfigResponse$$ExternalSyntheticBackport0.m0m(this.notice)) * 31) + this.title.hashCode()) * 31) + this.text.hashCode();
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ConfigResponse(movies=").append(this.movies).append(", tv=").append(this.tv).append(", premium=").append(this.premium).append(", download=").append(this.download).append(", latest=").append(this.latest).append(", banner=").append(this.banner).append(", video=").append(this.video).append(", newApp=").append(this.newApp).append(", notice=").append(this.notice).append(", title=").append(this.title).append(", text=").append(this.text).append(')');
            return sb.toString();
        }

        public ConfigResponse(@JsonProperty("movies") @NotNull List<String> list, @JsonProperty("tv") @NotNull List<String> list2, @JsonProperty("premium") @NotNull List<String> list3, @JsonProperty("download") @NotNull List<String> list4, @JsonProperty("latest") int latest, @JsonProperty("banner") @NotNull String banner, @JsonProperty("video") @NotNull String video, @JsonProperty("newapp") boolean newApp, @JsonProperty("notice") boolean notice, @JsonProperty("title") @NotNull String title, @JsonProperty("text") @NotNull String text) {
            this.movies = list;
            this.tv = list2;
            this.premium = list3;
            this.download = list4;
            this.latest = latest;
            this.banner = banner;
            this.video = video;
            this.newApp = newApp;
            this.notice = notice;
            this.title = title;
            this.text = text;
        }

        @NotNull
        public final List<String> getMovies() {
            return this.movies;
        }

        @NotNull
        public final List<String> getTv() {
            return this.tv;
        }

        @NotNull
        public final List<String> getPremium() {
            return this.premium;
        }

        @NotNull
        public final List<String> getDownload() {
            return this.download;
        }

        public final int getLatest() {
            return this.latest;
        }

        @NotNull
        public final String getBanner() {
            return this.banner;
        }

        @NotNull
        public final String getVideo() {
            return this.video;
        }

        public final boolean getNewApp() {
            return this.newApp;
        }

        public final boolean getNotice() {
            return this.notice;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }
    }

    /* JADX INFO: compiled from: StreamFlixProvider.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/cncverse/StreamFlixProvider$WebSocketRequest;", "", "type", "", "data", "Lcom/cncverse/StreamFlixProvider$WebSocketData;", "<init>", "(Ljava/lang/String;Lcom/cncverse/StreamFlixProvider$WebSocketData;)V", "getType", "()Ljava/lang/String;", "getData", "()Lcom/cncverse/StreamFlixProvider$WebSocketData;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class WebSocketRequest {

        @JsonProperty("d")
        @NotNull
        private final WebSocketData data;

        @JsonProperty("t")
        @NotNull
        private final String type;

        public static /* synthetic */ WebSocketRequest copy$default(WebSocketRequest webSocketRequest, String str, WebSocketData webSocketData, int i, Object obj) {
            if ((i & 1) != 0) {
                str = webSocketRequest.type;
            }
            if ((i & 2) != 0) {
                webSocketData = webSocketRequest.data;
            }
            return webSocketRequest.copy(str, webSocketData);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final WebSocketData getData() {
            return this.data;
        }

        @NotNull
        public final WebSocketRequest copy(@JsonProperty("t") @NotNull String type, @JsonProperty("d") @NotNull WebSocketData data) {
            return new WebSocketRequest(type, data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WebSocketRequest)) {
                return false;
            }
            WebSocketRequest webSocketRequest = (WebSocketRequest) other;
            return Intrinsics.areEqual(this.type, webSocketRequest.type) && Intrinsics.areEqual(this.data, webSocketRequest.data);
        }

        public int hashCode() {
            return (this.type.hashCode() * 31) + this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "WebSocketRequest(type=" + this.type + ", data=" + this.data + ')';
        }

        public WebSocketRequest(@JsonProperty("t") @NotNull String type, @JsonProperty("d") @NotNull WebSocketData data) {
            this.type = type;
            this.data = data;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final WebSocketData getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: StreamFlixProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/cncverse/StreamFlixProvider$WebSocketData;", "", "action", "", "request", "", "body", "Lcom/cncverse/StreamFlixProvider$WebSocketBody;", "<init>", "(Ljava/lang/String;ILcom/cncverse/StreamFlixProvider$WebSocketBody;)V", "getAction", "()Ljava/lang/String;", "getRequest", "()I", "getBody", "()Lcom/cncverse/StreamFlixProvider$WebSocketBody;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "StreamFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class WebSocketData {

        @JsonProperty("a")
        @NotNull
        private final String action;

        @JsonProperty("b")
        @NotNull
        private final WebSocketBody body;

        @JsonProperty("r")
        private final int request;

        public static /* synthetic */ WebSocketData copy$default(WebSocketData webSocketData, String str, int i, WebSocketBody webSocketBody, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = webSocketData.action;
            }
            if ((i2 & 2) != 0) {
                i = webSocketData.request;
            }
            if ((i2 & 4) != 0) {
                webSocketBody = webSocketData.body;
            }
            return webSocketData.copy(str, i, webSocketBody);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAction() {
            return this.action;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getRequest() {
            return this.request;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final WebSocketBody getBody() {
            return this.body;
        }

        @NotNull
        public final WebSocketData copy(@JsonProperty("a") @NotNull String action, @JsonProperty("r") int request, @JsonProperty("b") @NotNull WebSocketBody body) {
            return new WebSocketData(action, request, body);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WebSocketData)) {
                return false;
            }
            WebSocketData webSocketData = (WebSocketData) other;
            return Intrinsics.areEqual(this.action, webSocketData.action) && this.request == webSocketData.request && Intrinsics.areEqual(this.body, webSocketData.body);
        }

        public int hashCode() {
            return (((this.action.hashCode() * 31) + this.request) * 31) + this.body.hashCode();
        }

        @NotNull
        public String toString() {
            return "WebSocketData(action=" + this.action + ", request=" + this.request + ", body=" + this.body + ')';
        }

        public WebSocketData(@JsonProperty("a") @NotNull String action, @JsonProperty("r") int request, @JsonProperty("b") @NotNull WebSocketBody body) {
            this.action = action;
            this.request = request;
            this.body = body;
        }

        @NotNull
        public final String getAction() {
            return this.action;
        }

        public final int getRequest() {
            return this.request;
        }

        @NotNull
        public final WebSocketBody getBody() {
            return this.body;
        }
    }

    /* JADX INFO: compiled from: StreamFlixProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/cncverse/StreamFlixProvider$WebSocketBody;", "", "path", "", "hash", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "getHash", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class WebSocketBody {

        @JsonProperty("h")
        @NotNull
        private final String hash;

        @JsonProperty("p")
        @NotNull
        private final String path;

        public static /* synthetic */ WebSocketBody copy$default(WebSocketBody webSocketBody, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = webSocketBody.path;
            }
            if ((i & 2) != 0) {
                str2 = webSocketBody.hash;
            }
            return webSocketBody.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getHash() {
            return this.hash;
        }

        @NotNull
        public final WebSocketBody copy(@JsonProperty("p") @NotNull String path, @JsonProperty("h") @NotNull String hash) {
            return new WebSocketBody(path, hash);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WebSocketBody)) {
                return false;
            }
            WebSocketBody webSocketBody = (WebSocketBody) other;
            return Intrinsics.areEqual(this.path, webSocketBody.path) && Intrinsics.areEqual(this.hash, webSocketBody.hash);
        }

        public int hashCode() {
            return (this.path.hashCode() * 31) + this.hash.hashCode();
        }

        @NotNull
        public String toString() {
            return "WebSocketBody(path=" + this.path + ", hash=" + this.hash + ')';
        }

        public WebSocketBody(@JsonProperty("p") @NotNull String path, @JsonProperty("h") @NotNull String hash) {
            this.path = path;
            this.hash = hash;
        }

        @NotNull
        public final String getPath() {
            return this.path;
        }

        @NotNull
        public final String getHash() {
            return this.hash;
        }
    }

    /* JADX INFO: compiled from: StreamFlixProvider.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JQ\u0010\u001f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00052\b\b\u0003\u0010\b\u001a\u00020\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0005HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/cncverse/StreamFlixProvider$Episode;", "", "key", "", "link", "", "name", "overview", "runtime", "stillPath", "voteAverage", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;D)V", "getKey", "()I", "getLink", "()Ljava/lang/String;", "getName", "getOverview", "getRuntime", "getStillPath", "getVoteAverage", "()D", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "StreamFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Episode {

        @JsonProperty("key")
        private final int key;

        @JsonProperty("link")
        @NotNull
        private final String link;

        @JsonProperty("name")
        @NotNull
        private final String name;

        @JsonProperty("overview")
        @NotNull
        private final String overview;

        @JsonProperty("runtime")
        private final int runtime;

        @JsonProperty("still_path")
        @Nullable
        private final String stillPath;

        @JsonProperty("vote_average")
        private final double voteAverage;

        public static /* synthetic */ Episode copy$default(Episode episode, int i, String str, String str2, String str3, int i2, String str4, double d, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = episode.key;
            }
            if ((i3 & 2) != 0) {
                str = episode.link;
            }
            if ((i3 & 4) != 0) {
                str2 = episode.name;
            }
            if ((i3 & 8) != 0) {
                str3 = episode.overview;
            }
            if ((i3 & 16) != 0) {
                i2 = episode.runtime;
            }
            if ((i3 & 32) != 0) {
                str4 = episode.stillPath;
            }
            if ((i3 & 64) != 0) {
                d = episode.voteAverage;
            }
            double d2 = d;
            int i4 = i2;
            String str5 = str4;
            return episode.copy(i, str, str2, str3, i4, str5, d2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getKey() {
            return this.key;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLink() {
            return this.link;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getOverview() {
            return this.overview;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getRuntime() {
            return this.runtime;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getStillPath() {
            return this.stillPath;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final double getVoteAverage() {
            return this.voteAverage;
        }

        @NotNull
        public final Episode copy(@JsonProperty("key") int key, @JsonProperty("link") @NotNull String link, @JsonProperty("name") @NotNull String name, @JsonProperty("overview") @NotNull String overview, @JsonProperty("runtime") int runtime, @JsonProperty("still_path") @Nullable String stillPath, @JsonProperty("vote_average") double voteAverage) {
            return new Episode(key, link, name, overview, runtime, stillPath, voteAverage);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Episode)) {
                return false;
            }
            Episode episode = (Episode) other;
            return this.key == episode.key && Intrinsics.areEqual(this.link, episode.link) && Intrinsics.areEqual(this.name, episode.name) && Intrinsics.areEqual(this.overview, episode.overview) && this.runtime == episode.runtime && Intrinsics.areEqual(this.stillPath, episode.stillPath) && Double.compare(this.voteAverage, episode.voteAverage) == 0;
        }

        public int hashCode() {
            return (((((((((((this.key * 31) + this.link.hashCode()) * 31) + this.name.hashCode()) * 31) + this.overview.hashCode()) * 31) + this.runtime) * 31) + (this.stillPath == null ? 0 : this.stillPath.hashCode())) * 31) + StreamFlixProvider$Episode$$ExternalSyntheticBackport0.m1m(this.voteAverage);
        }

        @NotNull
        public String toString() {
            return "Episode(key=" + this.key + ", link=" + this.link + ", name=" + this.name + ", overview=" + this.overview + ", runtime=" + this.runtime + ", stillPath=" + this.stillPath + ", voteAverage=" + this.voteAverage + ')';
        }

        public Episode(@JsonProperty("key") int key, @JsonProperty("link") @NotNull String link, @JsonProperty("name") @NotNull String name, @JsonProperty("overview") @NotNull String overview, @JsonProperty("runtime") int runtime, @JsonProperty("still_path") @Nullable String stillPath, @JsonProperty("vote_average") double voteAverage) {
            this.key = key;
            this.link = link;
            this.name = name;
            this.overview = overview;
            this.runtime = runtime;
            this.stillPath = stillPath;
            this.voteAverage = voteAverage;
        }

        public final int getKey() {
            return this.key;
        }

        @NotNull
        public final String getLink() {
            return this.link;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getOverview() {
            return this.overview;
        }

        public final int getRuntime() {
            return this.runtime;
        }

        @Nullable
        public final String getStillPath() {
            return this.stillPath;
        }

        public final double getVoteAverage() {
            return this.voteAverage;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:41:0x0136  */
    /* JADX WARN: Code duplicated, block: B:42:0x0137  */
    /* JADX WARN: Code duplicated, block: B:51:0x0153 A[Catch: Exception -> 0x016d, TryCatch #1 {Exception -> 0x016d, blocks: (B:25:0x00d5, B:31:0x0102, B:39:0x0130, B:43:0x0138, B:52:0x0168, B:51:0x0153, B:50:0x014d, B:38:0x0125, B:30:0x00f8, B:22:0x00ce, B:45:0x013e, B:35:0x010a, B:27:0x00df), top: B:64:0x00ce, inners: #2, #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object getConfig(Continuation<? super ConfigResponse> continuation) {
        C00001 c00001;
        int i;
        String value$iv;
        Object obj;
        Object obj2;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
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
                if (this.configData == null) {
                    try {
                        Map headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36"), TuplesKt.to("Accept", "application/json, text/plain, */*"), TuplesKt.to("Accept-Language", "en-US,en;q=0.9"), TuplesKt.to("Connection", "keep-alive")});
                        Requests app = MainActivityKt.getApp();
                        String str = getMainUrl() + "/config/config-streamflixapp.json";
                        c00002.L$0 = SpillingKt.nullOutSpilledVariable(headers);
                        c00002.label = 1;
                        i = 2;
                        try {
                            $result = Requests.get$default(app, str, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 30L, (Interceptor) null, false, (ResponseParser) null, c00002, 3836, (Object) null);
                            if ($result == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            NiceResponse response = (NiceResponse) $result;
                            AppUtils appUtils = AppUtils.INSTANCE;
                            value$iv = response.getText();
                            try {
                                Result.Companion companion = Result.Companion;
                                KType kTypeTypeOf = Reflection.typeOf(ConfigResponse.class);
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            obj2 = null;
                            if (Result.exceptionOrNull-impl(obj) != null) {
                                try {
                                    Result.Companion companion3 = Result.Companion;
                                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ConfigResponse.class), (List) null, i, (Object) null));
                                } catch (Throwable th2) {
                                    Result.Companion companion4 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th2));
                                }
                            }
                            if (Result.isFailure-impl(obj)) {
                                obj2 = obj;
                            }
                            deserializationStrategy = (KSerializer) obj2;
                            if (deserializationStrategy != null) {
                                ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv.readValue(value$iv, new TypeReference<ConfigResponse>() { // from class: com.cncverse.StreamFlixProvider$getConfig$$inlined$parseJson$1
                                });
                                this.configData = (ConfigResponse) objDecodeFromString;
                            } else {
                                try {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                                } catch (SerializationException e) {
                                    ArchComponentExtKt.logError(e);
                                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv2.readValue(value$iv, new TypeReference<ConfigResponse>() { // from class: com.cncverse.StreamFlixProvider$getConfig$$inlined$parseJson$1
                                    });
                                } catch (Throwable th3) {
                                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv3.readValue(value$iv, new TypeReference<ConfigResponse>() { // from class: com.cncverse.StreamFlixProvider$getConfig$$inlined$parseJson$1
                                    });
                                }
                                this.configData = (ConfigResponse) objDecodeFromString;
                            }
                        } catch (Exception e2) {
                            this.configData = new ConfigResponse(CollectionsKt.listOf("https://example.com/fallback/"), CollectionsKt.listOf("https://example.com/fallback/"), CollectionsKt.listOf("https://example.com/fallback/"), CollectionsKt.listOf("https://example.com/fallback/"), 1, "", "", false, false, "Fallback", "Using fallback configuration");
                        }
                    } catch (Exception e3) {
                        this.configData = new ConfigResponse(CollectionsKt.listOf("https://example.com/fallback/"), CollectionsKt.listOf("https://example.com/fallback/"), CollectionsKt.listOf("https://example.com/fallback/"), CollectionsKt.listOf("https://example.com/fallback/"), 1, "", "", false, false, "Fallback", "Using fallback configuration");
                    }
                    break;
                }
                return this.configData;
            case 1:
                try {
                    ResultKt.throwOnFailure($result);
                    i = 2;
                    NiceResponse response2 = (NiceResponse) $result;
                    AppUtils appUtils2 = AppUtils.INSTANCE;
                    value$iv = response2.getText();
                    Result.Companion companion5 = Result.Companion;
                    KType kTypeTypeOf2 = Reflection.typeOf(ConfigResponse.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                    obj2 = null;
                    if (Result.exceptionOrNull-impl(obj) != null) {
                        Result.Companion companion6 = Result.Companion;
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ConfigResponse.class), (List) null, i, (Object) null));
                    }
                    if (Result.isFailure-impl(obj)) {
                        obj2 = obj;
                    }
                    deserializationStrategy = (KSerializer) obj2;
                    if (deserializationStrategy != null) {
                        ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv4.readValue(value$iv, new TypeReference<ConfigResponse>() { // from class: com.cncverse.StreamFlixProvider$getConfig$$inlined$parseJson$1
                        });
                        this.configData = (ConfigResponse) objDecodeFromString;
                    } else {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                        this.configData = (ConfigResponse) objDecodeFromString;
                    }
                    break;
                } catch (Exception e4) {
                    this.configData = new ConfigResponse(CollectionsKt.listOf("https://example.com/fallback/"), CollectionsKt.listOf("https://example.com/fallback/"), CollectionsKt.listOf("https://example.com/fallback/"), CollectionsKt.listOf("https://example.com/fallback/"), 1, "", "", false, false, "Fallback", "Using fallback configuration");
                }
                return this.configData;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x034f A[Catch: Exception -> 0x035e, TRY_LEAVE, TryCatch #2 {Exception -> 0x035e, blocks: (B:28:0x011d, B:34:0x014a, B:41:0x0177, B:44:0x017e, B:54:0x01ae, B:55:0x01c4, B:57:0x01ca, B:59:0x01d9, B:61:0x01e1, B:70:0x01f4, B:71:0x01f8, B:72:0x021a, B:74:0x0220, B:75:0x026a, B:76:0x0285, B:78:0x028b, B:80:0x029a, B:82:0x02a2, B:91:0x02b5, B:92:0x02b9, B:93:0x02d7, B:95:0x02dd, B:96:0x0323, B:98:0x0334, B:99:0x0346, B:101:0x034f, B:53:0x0199, B:52:0x0193, B:40:0x016c, B:33:0x0140, B:37:0x0151, B:30:0x0127, B:47:0x0184), top: B:114:0x011d, inners: #4, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x0151 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:0x0184 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:126:0x01f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:129:0x01c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x02b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:135:0x0285 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0177 A[Catch: Exception -> 0x035e, PHI: r0
      0x0177: PHI (r0v23 java.lang.Object) = (r0v16 java.lang.Object), (r0v19 java.lang.Object), (r0v22 java.lang.Object) binds: [B:35:0x014e, B:40:0x016c, B:37:0x0151] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {Exception -> 0x035e, blocks: (B:28:0x011d, B:34:0x014a, B:41:0x0177, B:44:0x017e, B:54:0x01ae, B:55:0x01c4, B:57:0x01ca, B:59:0x01d9, B:61:0x01e1, B:70:0x01f4, B:71:0x01f8, B:72:0x021a, B:74:0x0220, B:75:0x026a, B:76:0x0285, B:78:0x028b, B:80:0x029a, B:82:0x02a2, B:91:0x02b5, B:92:0x02b9, B:93:0x02d7, B:95:0x02dd, B:96:0x0323, B:98:0x0334, B:99:0x0346, B:101:0x034f, B:53:0x0199, B:52:0x0193, B:40:0x016c, B:33:0x0140, B:37:0x0151, B:30:0x0127, B:47:0x0184), top: B:114:0x011d, inners: #4, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x017d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0199 A[Catch: Exception -> 0x035e, TryCatch #2 {Exception -> 0x035e, blocks: (B:28:0x011d, B:34:0x014a, B:41:0x0177, B:44:0x017e, B:54:0x01ae, B:55:0x01c4, B:57:0x01ca, B:59:0x01d9, B:61:0x01e1, B:70:0x01f4, B:71:0x01f8, B:72:0x021a, B:74:0x0220, B:75:0x026a, B:76:0x0285, B:78:0x028b, B:80:0x029a, B:82:0x02a2, B:91:0x02b5, B:92:0x02b9, B:93:0x02d7, B:95:0x02dd, B:96:0x0323, B:98:0x0334, B:99:0x0346, B:101:0x034f, B:53:0x0199, B:52:0x0193, B:40:0x016c, B:33:0x0140, B:37:0x0151, B:30:0x0127, B:47:0x0184), top: B:114:0x011d, inners: #4, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x01ca A[Catch: Exception -> 0x035e, TryCatch #2 {Exception -> 0x035e, blocks: (B:28:0x011d, B:34:0x014a, B:41:0x0177, B:44:0x017e, B:54:0x01ae, B:55:0x01c4, B:57:0x01ca, B:59:0x01d9, B:61:0x01e1, B:70:0x01f4, B:71:0x01f8, B:72:0x021a, B:74:0x0220, B:75:0x026a, B:76:0x0285, B:78:0x028b, B:80:0x029a, B:82:0x02a2, B:91:0x02b5, B:92:0x02b9, B:93:0x02d7, B:95:0x02dd, B:96:0x0323, B:98:0x0334, B:99:0x0346, B:101:0x034f, B:53:0x0199, B:52:0x0193, B:40:0x016c, B:33:0x0140, B:37:0x0151, B:30:0x0127, B:47:0x0184), top: B:114:0x011d, inners: #4, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x01d9 A[Catch: Exception -> 0x035e, TryCatch #2 {Exception -> 0x035e, blocks: (B:28:0x011d, B:34:0x014a, B:41:0x0177, B:44:0x017e, B:54:0x01ae, B:55:0x01c4, B:57:0x01ca, B:59:0x01d9, B:61:0x01e1, B:70:0x01f4, B:71:0x01f8, B:72:0x021a, B:74:0x0220, B:75:0x026a, B:76:0x0285, B:78:0x028b, B:80:0x029a, B:82:0x02a2, B:91:0x02b5, B:92:0x02b9, B:93:0x02d7, B:95:0x02dd, B:96:0x0323, B:98:0x0334, B:99:0x0346, B:101:0x034f, B:53:0x0199, B:52:0x0193, B:40:0x016c, B:33:0x0140, B:37:0x0151, B:30:0x0127, B:47:0x0184), top: B:114:0x011d, inners: #4, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x01e1 A[Catch: Exception -> 0x035e, TryCatch #2 {Exception -> 0x035e, blocks: (B:28:0x011d, B:34:0x014a, B:41:0x0177, B:44:0x017e, B:54:0x01ae, B:55:0x01c4, B:57:0x01ca, B:59:0x01d9, B:61:0x01e1, B:70:0x01f4, B:71:0x01f8, B:72:0x021a, B:74:0x0220, B:75:0x026a, B:76:0x0285, B:78:0x028b, B:80:0x029a, B:82:0x02a2, B:91:0x02b5, B:92:0x02b9, B:93:0x02d7, B:95:0x02dd, B:96:0x0323, B:98:0x0334, B:99:0x0346, B:101:0x034f, B:53:0x0199, B:52:0x0193, B:40:0x016c, B:33:0x0140, B:37:0x0151, B:30:0x0127, B:47:0x0184), top: B:114:0x011d, inners: #4, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:67:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:68:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:74:0x0220 A[Catch: Exception -> 0x035e, LOOP:1: B:72:0x021a->B:74:0x0220, LOOP_END, TryCatch #2 {Exception -> 0x035e, blocks: (B:28:0x011d, B:34:0x014a, B:41:0x0177, B:44:0x017e, B:54:0x01ae, B:55:0x01c4, B:57:0x01ca, B:59:0x01d9, B:61:0x01e1, B:70:0x01f4, B:71:0x01f8, B:72:0x021a, B:74:0x0220, B:75:0x026a, B:76:0x0285, B:78:0x028b, B:80:0x029a, B:82:0x02a2, B:91:0x02b5, B:92:0x02b9, B:93:0x02d7, B:95:0x02dd, B:96:0x0323, B:98:0x0334, B:99:0x0346, B:101:0x034f, B:53:0x0199, B:52:0x0193, B:40:0x016c, B:33:0x0140, B:37:0x0151, B:30:0x0127, B:47:0x0184), top: B:114:0x011d, inners: #4, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x028b A[Catch: Exception -> 0x035e, TryCatch #2 {Exception -> 0x035e, blocks: (B:28:0x011d, B:34:0x014a, B:41:0x0177, B:44:0x017e, B:54:0x01ae, B:55:0x01c4, B:57:0x01ca, B:59:0x01d9, B:61:0x01e1, B:70:0x01f4, B:71:0x01f8, B:72:0x021a, B:74:0x0220, B:75:0x026a, B:76:0x0285, B:78:0x028b, B:80:0x029a, B:82:0x02a2, B:91:0x02b5, B:92:0x02b9, B:93:0x02d7, B:95:0x02dd, B:96:0x0323, B:98:0x0334, B:99:0x0346, B:101:0x034f, B:53:0x0199, B:52:0x0193, B:40:0x016c, B:33:0x0140, B:37:0x0151, B:30:0x0127, B:47:0x0184), top: B:114:0x011d, inners: #4, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x029a A[Catch: Exception -> 0x035e, TryCatch #2 {Exception -> 0x035e, blocks: (B:28:0x011d, B:34:0x014a, B:41:0x0177, B:44:0x017e, B:54:0x01ae, B:55:0x01c4, B:57:0x01ca, B:59:0x01d9, B:61:0x01e1, B:70:0x01f4, B:71:0x01f8, B:72:0x021a, B:74:0x0220, B:75:0x026a, B:76:0x0285, B:78:0x028b, B:80:0x029a, B:82:0x02a2, B:91:0x02b5, B:92:0x02b9, B:93:0x02d7, B:95:0x02dd, B:96:0x0323, B:98:0x0334, B:99:0x0346, B:101:0x034f, B:53:0x0199, B:52:0x0193, B:40:0x016c, B:33:0x0140, B:37:0x0151, B:30:0x0127, B:47:0x0184), top: B:114:0x011d, inners: #4, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x02a2 A[Catch: Exception -> 0x035e, TryCatch #2 {Exception -> 0x035e, blocks: (B:28:0x011d, B:34:0x014a, B:41:0x0177, B:44:0x017e, B:54:0x01ae, B:55:0x01c4, B:57:0x01ca, B:59:0x01d9, B:61:0x01e1, B:70:0x01f4, B:71:0x01f8, B:72:0x021a, B:74:0x0220, B:75:0x026a, B:76:0x0285, B:78:0x028b, B:80:0x029a, B:82:0x02a2, B:91:0x02b5, B:92:0x02b9, B:93:0x02d7, B:95:0x02dd, B:96:0x0323, B:98:0x0334, B:99:0x0346, B:101:0x034f, B:53:0x0199, B:52:0x0193, B:40:0x016c, B:33:0x0140, B:37:0x0151, B:30:0x0127, B:47:0x0184), top: B:114:0x011d, inners: #4, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:88:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:89:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:95:0x02dd A[Catch: Exception -> 0x035e, LOOP:3: B:93:0x02d7->B:95:0x02dd, LOOP_END, TryCatch #2 {Exception -> 0x035e, blocks: (B:28:0x011d, B:34:0x014a, B:41:0x0177, B:44:0x017e, B:54:0x01ae, B:55:0x01c4, B:57:0x01ca, B:59:0x01d9, B:61:0x01e1, B:70:0x01f4, B:71:0x01f8, B:72:0x021a, B:74:0x0220, B:75:0x026a, B:76:0x0285, B:78:0x028b, B:80:0x029a, B:82:0x02a2, B:91:0x02b5, B:92:0x02b9, B:93:0x02d7, B:95:0x02dd, B:96:0x0323, B:98:0x0334, B:99:0x0346, B:101:0x034f, B:53:0x0199, B:52:0x0193, B:40:0x016c, B:33:0x0140, B:37:0x0151, B:30:0x0127, B:47:0x0184), top: B:114:0x011d, inners: #4, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0334 A[Catch: Exception -> 0x035e, TryCatch #2 {Exception -> 0x035e, blocks: (B:28:0x011d, B:34:0x014a, B:41:0x0177, B:44:0x017e, B:54:0x01ae, B:55:0x01c4, B:57:0x01ca, B:59:0x01d9, B:61:0x01e1, B:70:0x01f4, B:71:0x01f8, B:72:0x021a, B:74:0x0220, B:75:0x026a, B:76:0x0285, B:78:0x028b, B:80:0x029a, B:82:0x02a2, B:91:0x02b5, B:92:0x02b9, B:93:0x02d7, B:95:0x02dd, B:96:0x0323, B:98:0x0334, B:99:0x0346, B:101:0x034f, B:53:0x0199, B:52:0x0193, B:40:0x016c, B:33:0x0140, B:37:0x0151, B:30:0x0127, B:47:0x0184), top: B:114:0x011d, inners: #4, #7, #8 }] */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00021 c00021;
        List items;
        List list;
        int i;
        String value$iv;
        Object obj;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        StreamFlixData data;
        Collection destination$iv$iv;
        Collection destination$iv$iv2;
        List movies;
        Collection destination$iv$iv3;
        Collection destination$iv$iv4;
        List tvShows;
        StreamFlixItem it;
        boolean z;
        String movieName;
        boolean z2;
        StreamFlixItem it2;
        boolean z3;
        String movieName2;
        boolean z4;
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
        C00021 c00022 = c00021;
        Object $result = c00022.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00022.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                }
                showTelegramPopup();
                showSubscriptionPopupIfNeeded();
                List items2 = new ArrayList();
                try {
                    Map headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36"), TuplesKt.to("Accept", "application/json, text/plain, */*"), TuplesKt.to("Accept-Language", "en-US,en;q=0.9"), TuplesKt.to("Connection", "keep-alive")});
                    Requests app = MainActivityKt.getApp();
                    String str = getMainUrl() + "/data.json";
                    c00022.L$0 = SpillingKt.nullOutSpilledVariable(request);
                    c00022.L$1 = items2;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(headers);
                    c00022.I$0 = page;
                    c00022.label = 1;
                    list = null;
                    i = 2;
                    try {
                        $result = Requests.get$default(app, str, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 30L, (Interceptor) null, false, (ResponseParser) null, c00022, 3836, (Object) null);
                        if ($result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        items = items2;
                        try {
                            NiceResponse response = (NiceResponse) $result;
                            AppUtils appUtils = AppUtils.INSTANCE;
                            value$iv = response.getText();
                            try {
                                Result.Companion companion = Result.Companion;
                                KType kTypeTypeOf = Reflection.typeOf(StreamFlixData.class);
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            if (Result.exceptionOrNull-impl(obj) == null) {
                                if (Result.isFailure-impl(obj)) {
                                    obj = list;
                                }
                                deserializationStrategy = (KSerializer) obj;
                                if (deserializationStrategy != null) {
                                    try {
                                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                                    } catch (SerializationException e) {
                                        ArchComponentExtKt.logError(e);
                                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv.readValue(value$iv, new TypeReference<StreamFlixData>() { // from class: com.cncverse.StreamFlixProvider$getMainPage$$inlined$parseJson$1
                                        });
                                    } catch (Throwable th2) {
                                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv2.readValue(value$iv, new TypeReference<StreamFlixData>() { // from class: com.cncverse.StreamFlixProvider$getMainPage$$inlined$parseJson$1
                                        });
                                    }
                                    data = (StreamFlixData) objDecodeFromString;
                                    Iterable $this$filter$iv = data.getData();
                                    destination$iv$iv = new ArrayList();
                                    while (r13.hasNext()) {
                                        it2 = (StreamFlixItem) element$iv$iv;
                                        if (it2.isTV()) {
                                            z3 = false;
                                        } else {
                                            movieName2 = it2.getMovieName();
                                            if (movieName2 != null || StringsKt.isBlank(movieName2)) {
                                                z4 = true;
                                            } else {
                                                z4 = false;
                                            }
                                            if (z4) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                        }
                                        if (z3) {
                                            destination$iv$iv.add(element$iv$iv);
                                        }
                                    }
                                    Iterable $this$map$iv = CollectionsKt.take((List) destination$iv$iv, 20);
                                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                    while (r15.hasNext()) {
                                        final StreamFlixItem item = (StreamFlixItem) item$iv$iv;
                                        String movieName3 = item.getMovieName();
                                        Intrinsics.checkNotNull(movieName3);
                                        destination$iv$iv2.add(MainAPIKt.newMovieSearchResponse$default(this, movieName3, item.getMovieKey() + "|movie", TvType.Movie, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda12
                                            public final Object invoke(Object obj2) {
                                                return StreamFlixProvider.getMainPage$lambda$1$0(item, (MovieSearchResponse) obj2);
                                            }
                                        }, 8, (Object) null));
                                    }
                                    movies = (List) destination$iv$iv2;
                                    Iterable $this$filter$iv2 = data.getData();
                                    destination$iv$iv3 = new ArrayList();
                                    while (r13.hasNext()) {
                                        it = (StreamFlixItem) element$iv$iv;
                                        if (it.isTV()) {
                                            z = false;
                                        } else {
                                            movieName = it.getMovieName();
                                            if (movieName != null || StringsKt.isBlank(movieName)) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                            if (z2) {
                                                z = true;
                                            } else {
                                                z = false;
                                            }
                                        }
                                        if (z) {
                                            destination$iv$iv3.add(element$iv$iv);
                                        }
                                    }
                                    Iterable $this$map$iv2 = CollectionsKt.take((List) destination$iv$iv3, 20);
                                    destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                                    while (r11.hasNext()) {
                                        final StreamFlixItem item2 = (StreamFlixItem) item$iv$iv;
                                        String movieName4 = item2.getMovieName();
                                        Intrinsics.checkNotNull(movieName4);
                                        destination$iv$iv4.add(MainAPIKt.newTvSeriesSearchResponse$default(this, movieName4, item2.getMovieKey() + "|tv", TvType.TvSeries, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda13
                                            public final Object invoke(Object obj2) {
                                                return StreamFlixProvider.getMainPage$lambda$3$0(item2, (TvSeriesSearchResponse) obj2);
                                            }
                                        }, 8, (Object) null));
                                        data = data;
                                    }
                                    tvShows = (List) destination$iv$iv4;
                                    if (!movies.isEmpty()) {
                                        items.add(new HomePageList("Latest Movies", movies, false, 4, (DefaultConstructorMarker) null));
                                    }
                                    if (!tvShows.isEmpty()) {
                                        items.add(new HomePageList("Latest TV Shows", tvShows, false, 4, (DefaultConstructorMarker) null));
                                    }
                                } else {
                                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv3.readValue(value$iv, new TypeReference<StreamFlixData>() { // from class: com.cncverse.StreamFlixProvider$getMainPage$$inlined$parseJson$1
                                    });
                                    data = (StreamFlixData) objDecodeFromString;
                                    Iterable $this$filter$iv3 = data.getData();
                                    destination$iv$iv = new ArrayList();
                                    while (r13.hasNext()) {
                                        it2 = (StreamFlixItem) element$iv$iv;
                                        if (it2.isTV()) {
                                            z3 = false;
                                        } else {
                                            movieName2 = it2.getMovieName();
                                            if (movieName2 != null) {
                                                z4 = true;
                                            } else {
                                                z4 = true;
                                            }
                                            if (z4) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                        }
                                        if (z3) {
                                            destination$iv$iv.add(element$iv$iv);
                                        }
                                    }
                                    Iterable $this$map$iv3 = CollectionsKt.take((List) destination$iv$iv, 20);
                                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                                    while (r15.hasNext()) {
                                        final StreamFlixItem item3 = (StreamFlixItem) item$iv$iv;
                                        String movieName5 = item3.getMovieName();
                                        Intrinsics.checkNotNull(movieName5);
                                        destination$iv$iv2.add(MainAPIKt.newMovieSearchResponse$default(this, movieName5, item3.getMovieKey() + "|movie", TvType.Movie, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda12
                                            public final Object invoke(Object obj2) {
                                                return StreamFlixProvider.getMainPage$lambda$1$0(item3, (MovieSearchResponse) obj2);
                                            }
                                        }, 8, (Object) null));
                                    }
                                    movies = (List) destination$iv$iv2;
                                    Iterable $this$filter$iv4 = data.getData();
                                    destination$iv$iv3 = new ArrayList();
                                    while (r13.hasNext()) {
                                        it = (StreamFlixItem) element$iv$iv;
                                        if (it.isTV()) {
                                            z = false;
                                        } else {
                                            movieName = it.getMovieName();
                                            if (movieName != null) {
                                                z2 = true;
                                            } else {
                                                z2 = true;
                                            }
                                            if (z2) {
                                                z = true;
                                            } else {
                                                z = false;
                                            }
                                        }
                                        if (z) {
                                            destination$iv$iv3.add(element$iv$iv);
                                        }
                                    }
                                    Iterable $this$map$iv4 = CollectionsKt.take((List) destination$iv$iv3, 20);
                                    destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                                    while (r11.hasNext()) {
                                        final StreamFlixItem item4 = (StreamFlixItem) item$iv$iv;
                                        String movieName6 = item4.getMovieName();
                                        Intrinsics.checkNotNull(movieName6);
                                        destination$iv$iv4.add(MainAPIKt.newTvSeriesSearchResponse$default(this, movieName6, item4.getMovieKey() + "|tv", TvType.TvSeries, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda13
                                            public final Object invoke(Object obj2) {
                                                return StreamFlixProvider.getMainPage$lambda$3$0(item4, (TvSeriesSearchResponse) obj2);
                                            }
                                        }, 8, (Object) null));
                                        data = data;
                                    }
                                    tvShows = (List) destination$iv$iv4;
                                    if (!movies.isEmpty()) {
                                        items.add(new HomePageList("Latest Movies", movies, false, 4, (DefaultConstructorMarker) null));
                                    }
                                    if (!tvShows.isEmpty()) {
                                        items.add(new HomePageList("Latest TV Shows", tvShows, false, 4, (DefaultConstructorMarker) null));
                                    }
                                }
                                break;
                            } else {
                                try {
                                    Result.Companion companion3 = Result.Companion;
                                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(StreamFlixData.class), list, i, list));
                                } catch (Throwable th3) {
                                    Result.Companion companion4 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th3));
                                }
                                if (Result.isFailure-impl(obj)) {
                                    obj = list;
                                }
                                deserializationStrategy = (KSerializer) obj;
                                if (deserializationStrategy != null) {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                                    data = (StreamFlixData) objDecodeFromString;
                                    Iterable $this$filter$iv5 = data.getData();
                                    destination$iv$iv = new ArrayList();
                                    while (r13.hasNext()) {
                                        it2 = (StreamFlixItem) element$iv$iv;
                                        if (it2.isTV()) {
                                            z3 = false;
                                        } else {
                                            movieName2 = it2.getMovieName();
                                            if (movieName2 != null) {
                                                z4 = true;
                                            } else {
                                                z4 = true;
                                            }
                                            if (z4) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                        }
                                        if (z3) {
                                            destination$iv$iv.add(element$iv$iv);
                                        }
                                    }
                                    Iterable $this$map$iv5 = CollectionsKt.take((List) destination$iv$iv, 20);
                                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                                    while (r15.hasNext()) {
                                        final StreamFlixItem item5 = (StreamFlixItem) item$iv$iv;
                                        String movieName7 = item5.getMovieName();
                                        Intrinsics.checkNotNull(movieName7);
                                        destination$iv$iv2.add(MainAPIKt.newMovieSearchResponse$default(this, movieName7, item5.getMovieKey() + "|movie", TvType.Movie, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda12
                                            public final Object invoke(Object obj2) {
                                                return StreamFlixProvider.getMainPage$lambda$1$0(item5, (MovieSearchResponse) obj2);
                                            }
                                        }, 8, (Object) null));
                                    }
                                    movies = (List) destination$iv$iv2;
                                    Iterable $this$filter$iv6 = data.getData();
                                    destination$iv$iv3 = new ArrayList();
                                    while (r13.hasNext()) {
                                        it = (StreamFlixItem) element$iv$iv;
                                        if (it.isTV()) {
                                            z = false;
                                        } else {
                                            movieName = it.getMovieName();
                                            if (movieName != null) {
                                                z2 = true;
                                            } else {
                                                z2 = true;
                                            }
                                            if (z2) {
                                                z = true;
                                            } else {
                                                z = false;
                                            }
                                        }
                                        if (z) {
                                            destination$iv$iv3.add(element$iv$iv);
                                        }
                                    }
                                    Iterable $this$map$iv6 = CollectionsKt.take((List) destination$iv$iv3, 20);
                                    destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv6, 10));
                                    while (r11.hasNext()) {
                                        final StreamFlixItem item6 = (StreamFlixItem) item$iv$iv;
                                        String movieName8 = item6.getMovieName();
                                        Intrinsics.checkNotNull(movieName8);
                                        destination$iv$iv4.add(MainAPIKt.newTvSeriesSearchResponse$default(this, movieName8, item6.getMovieKey() + "|tv", TvType.TvSeries, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda13
                                            public final Object invoke(Object obj2) {
                                                return StreamFlixProvider.getMainPage$lambda$3$0(item6, (TvSeriesSearchResponse) obj2);
                                            }
                                        }, 8, (Object) null));
                                        data = data;
                                    }
                                    tvShows = (List) destination$iv$iv4;
                                    if (!movies.isEmpty()) {
                                        items.add(new HomePageList("Latest Movies", movies, false, 4, (DefaultConstructorMarker) null));
                                    }
                                    if (!tvShows.isEmpty()) {
                                        items.add(new HomePageList("Latest TV Shows", tvShows, false, 4, (DefaultConstructorMarker) null));
                                    }
                                } else {
                                    ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv4.readValue(value$iv, new TypeReference<StreamFlixData>() { // from class: com.cncverse.StreamFlixProvider$getMainPage$$inlined$parseJson$1
                                    });
                                    data = (StreamFlixData) objDecodeFromString;
                                    Iterable $this$filter$iv7 = data.getData();
                                    destination$iv$iv = new ArrayList();
                                    for (Object element$iv$iv : $this$filter$iv7) {
                                        it2 = (StreamFlixItem) element$iv$iv;
                                        if (it2.isTV()) {
                                            z3 = false;
                                        } else {
                                            movieName2 = it2.getMovieName();
                                            if (movieName2 != null) {
                                                z4 = true;
                                            } else {
                                                z4 = true;
                                            }
                                            if (z4) {
                                                z3 = false;
                                            } else {
                                                z3 = true;
                                            }
                                        }
                                        if (z3) {
                                            destination$iv$iv.add(element$iv$iv);
                                        }
                                    }
                                    Iterable $this$map$iv7 = CollectionsKt.take((List) destination$iv$iv, 20);
                                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv7, 10));
                                    for (Object item$iv$iv : $this$map$iv7) {
                                        final StreamFlixItem item7 = (StreamFlixItem) item$iv$iv;
                                        String movieName9 = item7.getMovieName();
                                        Intrinsics.checkNotNull(movieName9);
                                        destination$iv$iv2.add(MainAPIKt.newMovieSearchResponse$default(this, movieName9, item7.getMovieKey() + "|movie", TvType.Movie, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda12
                                            public final Object invoke(Object obj2) {
                                                return StreamFlixProvider.getMainPage$lambda$1$0(item7, (MovieSearchResponse) obj2);
                                            }
                                        }, 8, (Object) null));
                                    }
                                    movies = (List) destination$iv$iv2;
                                    Iterable $this$filter$iv8 = data.getData();
                                    destination$iv$iv3 = new ArrayList();
                                    for (Object element$iv$iv2 : $this$filter$iv8) {
                                        it = (StreamFlixItem) element$iv$iv2;
                                        if (it.isTV()) {
                                            movieName = it.getMovieName();
                                            if (movieName != null) {
                                                z2 = true;
                                            } else {
                                                z2 = true;
                                            }
                                            if (z2) {
                                                z = false;
                                            } else {
                                                z = true;
                                            }
                                        } else {
                                            z = false;
                                        }
                                        if (z) {
                                            destination$iv$iv3.add(element$iv$iv2);
                                        }
                                    }
                                    Iterable $this$map$iv8 = CollectionsKt.take((List) destination$iv$iv3, 20);
                                    destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv8, 10));
                                    for (Object item$iv$iv2 : $this$map$iv8) {
                                        final StreamFlixItem item8 = (StreamFlixItem) item$iv$iv2;
                                        String movieName10 = item8.getMovieName();
                                        Intrinsics.checkNotNull(movieName10);
                                        destination$iv$iv4.add(MainAPIKt.newTvSeriesSearchResponse$default(this, movieName10, item8.getMovieKey() + "|tv", TvType.TvSeries, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda13
                                            public final Object invoke(Object obj2) {
                                                return StreamFlixProvider.getMainPage$lambda$3$0(item8, (TvSeriesSearchResponse) obj2);
                                            }
                                        }, 8, (Object) null));
                                        data = data;
                                    }
                                    tvShows = (List) destination$iv$iv4;
                                    if (!movies.isEmpty()) {
                                        items.add(new HomePageList("Latest Movies", movies, false, 4, (DefaultConstructorMarker) null));
                                    }
                                    if (!tvShows.isEmpty()) {
                                        items.add(new HomePageList("Latest TV Shows", tvShows, false, 4, (DefaultConstructorMarker) null));
                                    }
                                }
                            }
                            break;
                        } catch (Exception e2) {
                            e = e2;
                            Log.INSTANCE.e("StreamFlix", "Error in getMainPage: " + e.getMessage());
                            List fallbackMovies = CollectionsKt.listOf(MainAPIKt.newMovieSearchResponse$default(this, "StreamFlix Service Unavailable", "error|movie", TvType.Movie, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda14
                                public final Object invoke(Object obj2) {
                                    return StreamFlixProvider.getMainPage$lambda$4((MovieSearchResponse) obj2);
                                }
                            }, 8, (Object) null));
                            items.add(new HomePageList("Service Status", fallbackMovies, false, 4, (DefaultConstructorMarker) null));
                        }
                        return MainAPIKt.newHomePageResponse$default(items, (Boolean) null, 2, (Object) null);
                    } catch (Exception e3) {
                        e = e3;
                        items = items2;
                        Log.INSTANCE.e("StreamFlix", "Error in getMainPage: " + e.getMessage());
                        List fallbackMovies2 = CollectionsKt.listOf(MainAPIKt.newMovieSearchResponse$default(this, "StreamFlix Service Unavailable", "error|movie", TvType.Movie, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda14
                            public final Object invoke(Object obj2) {
                                return StreamFlixProvider.getMainPage$lambda$4((MovieSearchResponse) obj2);
                            }
                        }, 8, (Object) null));
                        items.add(new HomePageList("Service Status", fallbackMovies2, false, 4, (DefaultConstructorMarker) null));
                        return MainAPIKt.newHomePageResponse$default(items, (Boolean) null, 2, (Object) null);
                    }
                } catch (Exception e4) {
                    e = e4;
                    items = items2;
                }
                break;
            case 1:
                int i2 = c00022.I$0;
                items = (List) c00022.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    list = null;
                    i = 2;
                    NiceResponse response2 = (NiceResponse) $result;
                    AppUtils appUtils2 = AppUtils.INSTANCE;
                    value$iv = response2.getText();
                    Result.Companion companion5 = Result.Companion;
                    KType kTypeTypeOf2 = Reflection.typeOf(StreamFlixData.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                    if (Result.exceptionOrNull-impl(obj) == null) {
                        if (Result.isFailure-impl(obj)) {
                            obj = list;
                        }
                        deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                            data = (StreamFlixData) objDecodeFromString;
                            Iterable $this$filter$iv9 = data.getData();
                            destination$iv$iv = new ArrayList();
                            while (r13.hasNext()) {
                                it2 = (StreamFlixItem) element$iv$iv;
                                if (it2.isTV()) {
                                    z3 = false;
                                } else {
                                    movieName2 = it2.getMovieName();
                                    if (movieName2 != null) {
                                        z4 = true;
                                    } else {
                                        z4 = true;
                                    }
                                    if (z4) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                }
                                if (z3) {
                                    destination$iv$iv.add(element$iv$iv);
                                }
                            }
                            Iterable $this$map$iv9 = CollectionsKt.take((List) destination$iv$iv, 20);
                            destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv9, 10));
                            while (r15.hasNext()) {
                                final StreamFlixItem item9 = (StreamFlixItem) item$iv$iv;
                                String movieName11 = item9.getMovieName();
                                Intrinsics.checkNotNull(movieName11);
                                destination$iv$iv2.add(MainAPIKt.newMovieSearchResponse$default(this, movieName11, item9.getMovieKey() + "|movie", TvType.Movie, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda12
                                    public final Object invoke(Object obj2) {
                                        return StreamFlixProvider.getMainPage$lambda$1$0(item9, (MovieSearchResponse) obj2);
                                    }
                                }, 8, (Object) null));
                            }
                            movies = (List) destination$iv$iv2;
                            Iterable $this$filter$iv10 = data.getData();
                            destination$iv$iv3 = new ArrayList();
                            while (r13.hasNext()) {
                                it = (StreamFlixItem) element$iv$iv2;
                                if (it.isTV()) {
                                    z = false;
                                } else {
                                    movieName = it.getMovieName();
                                    if (movieName != null) {
                                        z2 = true;
                                    } else {
                                        z2 = true;
                                    }
                                    if (z2) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                }
                                if (z) {
                                    destination$iv$iv3.add(element$iv$iv2);
                                }
                            }
                            Iterable $this$map$iv10 = CollectionsKt.take((List) destination$iv$iv3, 20);
                            destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv10, 10));
                            while (r11.hasNext()) {
                                final StreamFlixItem item10 = (StreamFlixItem) item$iv$iv2;
                                String movieName12 = item10.getMovieName();
                                Intrinsics.checkNotNull(movieName12);
                                destination$iv$iv4.add(MainAPIKt.newTvSeriesSearchResponse$default(this, movieName12, item10.getMovieKey() + "|tv", TvType.TvSeries, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda13
                                    public final Object invoke(Object obj2) {
                                        return StreamFlixProvider.getMainPage$lambda$3$0(item10, (TvSeriesSearchResponse) obj2);
                                    }
                                }, 8, (Object) null));
                                data = data;
                            }
                            tvShows = (List) destination$iv$iv4;
                            if (!movies.isEmpty()) {
                                items.add(new HomePageList("Latest Movies", movies, false, 4, (DefaultConstructorMarker) null));
                            }
                            if (!tvShows.isEmpty()) {
                                items.add(new HomePageList("Latest TV Shows", tvShows, false, 4, (DefaultConstructorMarker) null));
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv5.readValue(value$iv, new TypeReference<StreamFlixData>() { // from class: com.cncverse.StreamFlixProvider$getMainPage$$inlined$parseJson$1
                            });
                            data = (StreamFlixData) objDecodeFromString;
                            Iterable $this$filter$iv11 = data.getData();
                            destination$iv$iv = new ArrayList();
                            while (r13.hasNext()) {
                                it2 = (StreamFlixItem) element$iv$iv;
                                if (it2.isTV()) {
                                    z3 = false;
                                } else {
                                    movieName2 = it2.getMovieName();
                                    if (movieName2 != null) {
                                        z4 = true;
                                    } else {
                                        z4 = true;
                                    }
                                    if (z4) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                }
                                if (z3) {
                                    destination$iv$iv.add(element$iv$iv);
                                }
                            }
                            Iterable $this$map$iv11 = CollectionsKt.take((List) destination$iv$iv, 20);
                            destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv11, 10));
                            while (r15.hasNext()) {
                                final StreamFlixItem item11 = (StreamFlixItem) item$iv$iv;
                                String movieName13 = item11.getMovieName();
                                Intrinsics.checkNotNull(movieName13);
                                destination$iv$iv2.add(MainAPIKt.newMovieSearchResponse$default(this, movieName13, item11.getMovieKey() + "|movie", TvType.Movie, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda12
                                    public final Object invoke(Object obj2) {
                                        return StreamFlixProvider.getMainPage$lambda$1$0(item11, (MovieSearchResponse) obj2);
                                    }
                                }, 8, (Object) null));
                            }
                            movies = (List) destination$iv$iv2;
                            Iterable $this$filter$iv12 = data.getData();
                            destination$iv$iv3 = new ArrayList();
                            while (r13.hasNext()) {
                                it = (StreamFlixItem) element$iv$iv2;
                                if (it.isTV()) {
                                    z = false;
                                } else {
                                    movieName = it.getMovieName();
                                    if (movieName != null) {
                                        z2 = true;
                                    } else {
                                        z2 = true;
                                    }
                                    if (z2) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                }
                                if (z) {
                                    destination$iv$iv3.add(element$iv$iv2);
                                }
                            }
                            Iterable $this$map$iv12 = CollectionsKt.take((List) destination$iv$iv3, 20);
                            destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv12, 10));
                            while (r11.hasNext()) {
                                final StreamFlixItem item12 = (StreamFlixItem) item$iv$iv2;
                                String movieName14 = item12.getMovieName();
                                Intrinsics.checkNotNull(movieName14);
                                destination$iv$iv4.add(MainAPIKt.newTvSeriesSearchResponse$default(this, movieName14, item12.getMovieKey() + "|tv", TvType.TvSeries, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda13
                                    public final Object invoke(Object obj2) {
                                        return StreamFlixProvider.getMainPage$lambda$3$0(item12, (TvSeriesSearchResponse) obj2);
                                    }
                                }, 8, (Object) null));
                                data = data;
                            }
                            tvShows = (List) destination$iv$iv4;
                            if (!movies.isEmpty()) {
                                items.add(new HomePageList("Latest Movies", movies, false, 4, (DefaultConstructorMarker) null));
                            }
                            if (!tvShows.isEmpty()) {
                                items.add(new HomePageList("Latest TV Shows", tvShows, false, 4, (DefaultConstructorMarker) null));
                            }
                        }
                    } else {
                        Result.Companion companion6 = Result.Companion;
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(StreamFlixData.class), list, i, list));
                        if (Result.isFailure-impl(obj)) {
                            obj = list;
                        }
                        deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                            data = (StreamFlixData) objDecodeFromString;
                            Iterable $this$filter$iv13 = data.getData();
                            destination$iv$iv = new ArrayList();
                            while (r13.hasNext()) {
                                it2 = (StreamFlixItem) element$iv$iv;
                                if (it2.isTV()) {
                                    z3 = false;
                                } else {
                                    movieName2 = it2.getMovieName();
                                    if (movieName2 != null) {
                                        z4 = true;
                                    } else {
                                        z4 = true;
                                    }
                                    if (z4) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                }
                                if (z3) {
                                    destination$iv$iv.add(element$iv$iv);
                                }
                            }
                            Iterable $this$map$iv13 = CollectionsKt.take((List) destination$iv$iv, 20);
                            destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv13, 10));
                            while (r15.hasNext()) {
                                final StreamFlixItem item13 = (StreamFlixItem) item$iv$iv;
                                String movieName15 = item13.getMovieName();
                                Intrinsics.checkNotNull(movieName15);
                                destination$iv$iv2.add(MainAPIKt.newMovieSearchResponse$default(this, movieName15, item13.getMovieKey() + "|movie", TvType.Movie, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda12
                                    public final Object invoke(Object obj2) {
                                        return StreamFlixProvider.getMainPage$lambda$1$0(item13, (MovieSearchResponse) obj2);
                                    }
                                }, 8, (Object) null));
                            }
                            movies = (List) destination$iv$iv2;
                            Iterable $this$filter$iv14 = data.getData();
                            destination$iv$iv3 = new ArrayList();
                            while (r13.hasNext()) {
                                it = (StreamFlixItem) element$iv$iv2;
                                if (it.isTV()) {
                                    z = false;
                                } else {
                                    movieName = it.getMovieName();
                                    if (movieName != null) {
                                        z2 = true;
                                    } else {
                                        z2 = true;
                                    }
                                    if (z2) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                }
                                if (z) {
                                    destination$iv$iv3.add(element$iv$iv2);
                                }
                            }
                            Iterable $this$map$iv14 = CollectionsKt.take((List) destination$iv$iv3, 20);
                            destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv14, 10));
                            while (r11.hasNext()) {
                                final StreamFlixItem item14 = (StreamFlixItem) item$iv$iv2;
                                String movieName16 = item14.getMovieName();
                                Intrinsics.checkNotNull(movieName16);
                                destination$iv$iv4.add(MainAPIKt.newTvSeriesSearchResponse$default(this, movieName16, item14.getMovieKey() + "|tv", TvType.TvSeries, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda13
                                    public final Object invoke(Object obj2) {
                                        return StreamFlixProvider.getMainPage$lambda$3$0(item14, (TvSeriesSearchResponse) obj2);
                                    }
                                }, 8, (Object) null));
                                data = data;
                            }
                            tvShows = (List) destination$iv$iv4;
                            if (!movies.isEmpty()) {
                                items.add(new HomePageList("Latest Movies", movies, false, 4, (DefaultConstructorMarker) null));
                            }
                            if (!tvShows.isEmpty()) {
                                items.add(new HomePageList("Latest TV Shows", tvShows, false, 4, (DefaultConstructorMarker) null));
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv6.readValue(value$iv, new TypeReference<StreamFlixData>() { // from class: com.cncverse.StreamFlixProvider$getMainPage$$inlined$parseJson$1
                            });
                            data = (StreamFlixData) objDecodeFromString;
                            Iterable $this$filter$iv15 = data.getData();
                            destination$iv$iv = new ArrayList();
                            while (r13.hasNext()) {
                                it2 = (StreamFlixItem) element$iv$iv;
                                if (it2.isTV()) {
                                    z3 = false;
                                } else {
                                    movieName2 = it2.getMovieName();
                                    if (movieName2 != null) {
                                        z4 = true;
                                    } else {
                                        z4 = true;
                                    }
                                    if (z4) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                }
                                if (z3) {
                                    destination$iv$iv.add(element$iv$iv);
                                }
                            }
                            Iterable $this$map$iv15 = CollectionsKt.take((List) destination$iv$iv, 20);
                            destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv15, 10));
                            while (r15.hasNext()) {
                                final StreamFlixItem item15 = (StreamFlixItem) item$iv$iv;
                                String movieName17 = item15.getMovieName();
                                Intrinsics.checkNotNull(movieName17);
                                destination$iv$iv2.add(MainAPIKt.newMovieSearchResponse$default(this, movieName17, item15.getMovieKey() + "|movie", TvType.Movie, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda12
                                    public final Object invoke(Object obj2) {
                                        return StreamFlixProvider.getMainPage$lambda$1$0(item15, (MovieSearchResponse) obj2);
                                    }
                                }, 8, (Object) null));
                            }
                            movies = (List) destination$iv$iv2;
                            Iterable $this$filter$iv16 = data.getData();
                            destination$iv$iv3 = new ArrayList();
                            while (r13.hasNext()) {
                                it = (StreamFlixItem) element$iv$iv2;
                                if (it.isTV()) {
                                    z = false;
                                } else {
                                    movieName = it.getMovieName();
                                    if (movieName != null) {
                                        z2 = true;
                                    } else {
                                        z2 = true;
                                    }
                                    if (z2) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                }
                                if (z) {
                                    destination$iv$iv3.add(element$iv$iv2);
                                }
                            }
                            Iterable $this$map$iv16 = CollectionsKt.take((List) destination$iv$iv3, 20);
                            destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv16, 10));
                            while (r11.hasNext()) {
                                final StreamFlixItem item16 = (StreamFlixItem) item$iv$iv2;
                                String movieName18 = item16.getMovieName();
                                Intrinsics.checkNotNull(movieName18);
                                destination$iv$iv4.add(MainAPIKt.newTvSeriesSearchResponse$default(this, movieName18, item16.getMovieKey() + "|tv", TvType.TvSeries, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda13
                                    public final Object invoke(Object obj2) {
                                        return StreamFlixProvider.getMainPage$lambda$3$0(item16, (TvSeriesSearchResponse) obj2);
                                    }
                                }, 8, (Object) null));
                                data = data;
                            }
                            tvShows = (List) destination$iv$iv4;
                            if (!movies.isEmpty()) {
                                items.add(new HomePageList("Latest Movies", movies, false, 4, (DefaultConstructorMarker) null));
                            }
                            if (!tvShows.isEmpty()) {
                                items.add(new HomePageList("Latest TV Shows", tvShows, false, 4, (DefaultConstructorMarker) null));
                            }
                        }
                    }
                    break;
                } catch (Exception e5) {
                    e = e5;
                    Log.INSTANCE.e("StreamFlix", "Error in getMainPage: " + e.getMessage());
                    List fallbackMovies3 = CollectionsKt.listOf(MainAPIKt.newMovieSearchResponse$default(this, "StreamFlix Service Unavailable", "error|movie", TvType.Movie, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda14
                        public final Object invoke(Object obj2) {
                            return StreamFlixProvider.getMainPage$lambda$4((MovieSearchResponse) obj2);
                        }
                    }, 8, (Object) null));
                    items.add(new HomePageList("Service Status", fallbackMovies3, false, 4, (DefaultConstructorMarker) null));
                    return MainAPIKt.newHomePageResponse$default(items, (Boolean) null, 2, (Object) null);
                }
                return MainAPIKt.newHomePageResponse$default(items, (Boolean) null, 2, (Object) null);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$1$0(StreamFlixItem $item, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl("https://image.tmdb.org/t/p/w500/" + $item.getMoviePoster());
        String movieYear = $item.getMovieYear();
        $this$newMovieSearchResponse.setYear(movieYear != null ? StringsKt.toIntOrNull(movieYear) : null);
        $this$newMovieSearchResponse.setQuality(SearchQuality.HD);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$3$0(StreamFlixItem $item, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl("https://image.tmdb.org/t/p/w500/" + $item.getMoviePoster());
        String movieYear = $item.getMovieYear();
        $this$newTvSeriesSearchResponse.setYear(movieYear != null ? StringsKt.toIntOrNull(movieYear) : null);
        $this$newTvSeriesSearchResponse.setQuality(SearchQuality.HD);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$4(MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl((String) null);
        $this$newMovieSearchResponse.setYear(2024);
        $this$newMovieSearchResponse.setQuality(SearchQuality.HD);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0137 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x016b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:125:0x0221 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:126:0x0285 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:128:0x024c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0163  */
    /* JADX WARN: Code duplicated, block: B:45:0x0164  */
    /* JADX WARN: Code duplicated, block: B:54:0x0180 A[Catch: Exception -> 0x02c3, TryCatch #7 {Exception -> 0x02c3, blocks: (B:28:0x0102, B:34:0x012f, B:42:0x015d, B:46:0x0165, B:55:0x0195, B:56:0x01ab, B:58:0x01b1, B:60:0x01c1, B:66:0x01cd, B:68:0x01e1, B:70:0x01e7, B:75:0x01f8, B:77:0x01fe, B:90:0x021e, B:92:0x0226, B:93:0x0237, B:95:0x023d, B:97:0x024c, B:98:0x0285, B:54:0x0180, B:53:0x017a, B:41:0x0152, B:33:0x0125, B:38:0x0137, B:30:0x010c, B:48:0x016b), top: B:119:0x0102, inners: #0, #3, #8 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x01b1 A[Catch: Exception -> 0x02c3, TryCatch #7 {Exception -> 0x02c3, blocks: (B:28:0x0102, B:34:0x012f, B:42:0x015d, B:46:0x0165, B:55:0x0195, B:56:0x01ab, B:58:0x01b1, B:60:0x01c1, B:66:0x01cd, B:68:0x01e1, B:70:0x01e7, B:75:0x01f8, B:77:0x01fe, B:90:0x021e, B:92:0x0226, B:93:0x0237, B:95:0x023d, B:97:0x024c, B:98:0x0285, B:54:0x0180, B:53:0x017a, B:41:0x0152, B:33:0x0125, B:38:0x0137, B:30:0x010c, B:48:0x016b), top: B:119:0x0102, inners: #0, #3, #8 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:66:0x01cd A[Catch: Exception -> 0x02c3, TryCatch #7 {Exception -> 0x02c3, blocks: (B:28:0x0102, B:34:0x012f, B:42:0x015d, B:46:0x0165, B:55:0x0195, B:56:0x01ab, B:58:0x01b1, B:60:0x01c1, B:66:0x01cd, B:68:0x01e1, B:70:0x01e7, B:75:0x01f8, B:77:0x01fe, B:90:0x021e, B:92:0x0226, B:93:0x0237, B:95:0x023d, B:97:0x024c, B:98:0x0285, B:54:0x0180, B:53:0x017a, B:41:0x0152, B:33:0x0125, B:38:0x0137, B:30:0x010c, B:48:0x016b), top: B:119:0x0102, inners: #0, #3, #8 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x01e1 A[Catch: Exception -> 0x02c3, TryCatch #7 {Exception -> 0x02c3, blocks: (B:28:0x0102, B:34:0x012f, B:42:0x015d, B:46:0x0165, B:55:0x0195, B:56:0x01ab, B:58:0x01b1, B:60:0x01c1, B:66:0x01cd, B:68:0x01e1, B:70:0x01e7, B:75:0x01f8, B:77:0x01fe, B:90:0x021e, B:92:0x0226, B:93:0x0237, B:95:0x023d, B:97:0x024c, B:98:0x0285, B:54:0x0180, B:53:0x017a, B:41:0x0152, B:33:0x0125, B:38:0x0137, B:30:0x010c, B:48:0x016b), top: B:119:0x0102, inners: #0, #3, #8 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:75:0x01f8 A[Catch: Exception -> 0x02c3, TryCatch #7 {Exception -> 0x02c3, blocks: (B:28:0x0102, B:34:0x012f, B:42:0x015d, B:46:0x0165, B:55:0x0195, B:56:0x01ab, B:58:0x01b1, B:60:0x01c1, B:66:0x01cd, B:68:0x01e1, B:70:0x01e7, B:75:0x01f8, B:77:0x01fe, B:90:0x021e, B:92:0x0226, B:93:0x0237, B:95:0x023d, B:97:0x024c, B:98:0x0285, B:54:0x0180, B:53:0x017a, B:41:0x0152, B:33:0x0125, B:38:0x0137, B:30:0x010c, B:48:0x016b), top: B:119:0x0102, inners: #0, #3, #8 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:83:0x0210  */
    /* JADX WARN: Code duplicated, block: B:84:0x0211  */
    /* JADX WARN: Code duplicated, block: B:85:0x0213  */
    /* JADX WARN: Code duplicated, block: B:87:0x0216  */
    /* JADX WARN: Code duplicated, block: B:90:0x021e A[Catch: Exception -> 0x02c3, TryCatch #7 {Exception -> 0x02c3, blocks: (B:28:0x0102, B:34:0x012f, B:42:0x015d, B:46:0x0165, B:55:0x0195, B:56:0x01ab, B:58:0x01b1, B:60:0x01c1, B:66:0x01cd, B:68:0x01e1, B:70:0x01e7, B:75:0x01f8, B:77:0x01fe, B:90:0x021e, B:92:0x0226, B:93:0x0237, B:95:0x023d, B:97:0x024c, B:98:0x0285, B:54:0x0180, B:53:0x017a, B:41:0x0152, B:33:0x0125, B:38:0x0137, B:30:0x010c, B:48:0x016b), top: B:119:0x0102, inners: #0, #3, #8 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x023d A[Catch: Exception -> 0x02c3, TryCatch #7 {Exception -> 0x02c3, blocks: (B:28:0x0102, B:34:0x012f, B:42:0x015d, B:46:0x0165, B:55:0x0195, B:56:0x01ab, B:58:0x01b1, B:60:0x01c1, B:66:0x01cd, B:68:0x01e1, B:70:0x01e7, B:75:0x01f8, B:77:0x01fe, B:90:0x021e, B:92:0x0226, B:93:0x0237, B:95:0x023d, B:97:0x024c, B:98:0x0285, B:54:0x0180, B:53:0x017a, B:41:0x0152, B:33:0x0125, B:38:0x0137, B:30:0x010c, B:48:0x016b), top: B:119:0x0102, inners: #0, #3, #8 }] */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00081 c00081;
        ArrayList searchResults;
        int i;
        String query2;
        List searchResults2;
        String value$iv;
        Object obj;
        Object obj2;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        StreamFlixData data;
        Iterable $this$filter$iv;
        Collection destination$iv$iv;
        final StreamFlixItem item;
        StreamFlixItem it;
        String movieName;
        boolean z;
        StreamFlixData data2;
        Iterable $this$filter$iv2;
        boolean z2;
        String movieType;
        boolean z3;
        String movieInfo;
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
        C00081 c00082 = c00081;
        Object $result = c00082.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00082.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return CollectionsKt.emptyList();
                }
                searchResults = new ArrayList();
                try {
                    Map headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36"), TuplesKt.to("Accept", "application/json, text/plain, */*"), TuplesKt.to("Accept-Language", "en-US,en;q=0.9"), TuplesKt.to("Connection", "keep-alive")});
                    Requests app = MainActivityKt.getApp();
                    String str = getMainUrl() + "/data.json";
                    c00082.L$0 = query;
                    c00082.L$1 = searchResults;
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(headers);
                    c00082.label = 1;
                    i = 2;
                    try {
                        $result = Requests.get$default(app, str, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 30L, (Interceptor) null, false, (ResponseParser) null, c00082, 3836, (Object) null);
                        if ($result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        query2 = query;
                        searchResults2 = searchResults;
                        try {
                            NiceResponse response = (NiceResponse) $result;
                            AppUtils appUtils = AppUtils.INSTANCE;
                            value$iv = response.getText();
                            try {
                                Result.Companion companion = Result.Companion;
                                KType kTypeTypeOf = Reflection.typeOf(StreamFlixData.class);
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                break;
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            obj2 = null;
                            if (Result.exceptionOrNull-impl(obj) != null) {
                                try {
                                    Result.Companion companion3 = Result.Companion;
                                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(StreamFlixData.class), (List) null, i, (Object) null));
                                } catch (Throwable th2) {
                                    Result.Companion companion4 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th2));
                                }
                                break;
                            }
                            if (Result.isFailure-impl(obj)) {
                                obj2 = obj;
                            }
                            deserializationStrategy = (KSerializer) obj2;
                            if (deserializationStrategy != null) {
                                try {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                                } catch (SerializationException e) {
                                    ArchComponentExtKt.logError(e);
                                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv.readValue(value$iv, new TypeReference<StreamFlixData>() { // from class: com.cncverse.StreamFlixProvider$search$$inlined$parseJson$1
                                    });
                                } catch (Throwable th3) {
                                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv2.readValue(value$iv, new TypeReference<StreamFlixData>() { // from class: com.cncverse.StreamFlixProvider$search$$inlined$parseJson$1
                                    });
                                }
                                break;
                            } else {
                                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv3.readValue(value$iv, new TypeReference<StreamFlixData>() { // from class: com.cncverse.StreamFlixProvider$search$$inlined$parseJson$1
                                });
                            }
                            data = (StreamFlixData) objDecodeFromString;
                            $this$filter$iv = data.getData();
                            destination$iv$iv = new ArrayList();
                            for (Object element$iv$iv : $this$filter$iv) {
                                it = (StreamFlixItem) element$iv$iv;
                                movieName = it.getMovieName();
                                if (movieName != null || StringsKt.isBlank(movieName)) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    data2 = data;
                                    $this$filter$iv2 = $this$filter$iv;
                                } else {
                                    data2 = data;
                                    $this$filter$iv2 = $this$filter$iv;
                                    if (StringsKt.contains(it.getMovieName(), query2, true)) {
                                        movieType = it.getMovieType();
                                        if (movieType == null && StringsKt.contains(movieType, query2, true)) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        if (z3) {
                                            movieInfo = it.getMovieInfo();
                                            if (movieInfo == null && StringsKt.contains(movieInfo, query2, true)) {
                                            }
                                            if (z2) {
                                                destination$iv$iv.add(element$iv$iv);
                                            }
                                            data = data2;
                                            $this$filter$iv = $this$filter$iv2;
                                        }
                                    }
                                    z2 = true;
                                    if (z2) {
                                        destination$iv$iv.add(element$iv$iv);
                                    }
                                    data = data2;
                                    $this$filter$iv = $this$filter$iv2;
                                }
                                z2 = false;
                                if (z2) {
                                    destination$iv$iv.add(element$iv$iv);
                                }
                                data = data2;
                                $this$filter$iv = $this$filter$iv2;
                            }
                            Iterable filteredItems = (List) destination$iv$iv;
                            Iterable $this$forEach$iv = filteredItems;
                            for (Object element$iv : $this$forEach$iv) {
                                item = (StreamFlixItem) element$iv;
                                if (item.isTV()) {
                                    String movieName2 = item.getMovieName();
                                    Intrinsics.checkNotNull(movieName2);
                                    searchResults2.add(MainAPIKt.newTvSeriesSearchResponse$default(this, movieName2, item.getMovieKey() + "|tv", TvType.TvSeries, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda5
                                        public final Object invoke(Object obj3) {
                                            return StreamFlixProvider.search$lambda$1$0(item, (TvSeriesSearchResponse) obj3);
                                        }
                                    }, 8, (Object) null));
                                } else {
                                    String movieName3 = item.getMovieName();
                                    Intrinsics.checkNotNull(movieName3);
                                    searchResults2.add(MainAPIKt.newMovieSearchResponse$default(this, movieName3, item.getMovieKey() + "|movie", TvType.Movie, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda6
                                        public final Object invoke(Object obj3) {
                                            return StreamFlixProvider.search$lambda$1$1(item, (MovieSearchResponse) obj3);
                                        }
                                    }, 8, (Object) null));
                                }
                                break;
                            }
                            return searchResults2;
                        } catch (Exception e2) {
                            e = e2;
                            searchResults = searchResults2;
                            Log.INSTANCE.e("StreamFlix", "Error in search: " + e.getMessage());
                            return searchResults;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        searchResults = searchResults;
                        Log.INSTANCE.e("StreamFlix", "Error in search: " + e.getMessage());
                        return searchResults;
                    }
                } catch (Exception e4) {
                    e = e4;
                }
                break;
            case 1:
                searchResults = (List) c00082.L$1;
                query2 = (String) c00082.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    searchResults2 = searchResults;
                    i = 2;
                    NiceResponse response2 = (NiceResponse) $result;
                    AppUtils appUtils2 = AppUtils.INSTANCE;
                    value$iv = response2.getText();
                    Result.Companion companion5 = Result.Companion;
                    KType kTypeTypeOf2 = Reflection.typeOf(StreamFlixData.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                    obj2 = null;
                    if (Result.exceptionOrNull-impl(obj) != null) {
                        Result.Companion companion6 = Result.Companion;
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(StreamFlixData.class), (List) null, i, (Object) null));
                        break;
                    }
                    if (Result.isFailure-impl(obj)) {
                        obj2 = obj;
                    }
                    deserializationStrategy = (KSerializer) obj2;
                    if (deserializationStrategy != null) {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                        break;
                    } else {
                        ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv4.readValue(value$iv, new TypeReference<StreamFlixData>() { // from class: com.cncverse.StreamFlixProvider$search$$inlined$parseJson$1
                        });
                    }
                    data = (StreamFlixData) objDecodeFromString;
                    $this$filter$iv = data.getData();
                    destination$iv$iv = new ArrayList();
                    while (r11.hasNext()) {
                        it = (StreamFlixItem) element$iv$iv;
                        movieName = it.getMovieName();
                        if (movieName != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (z) {
                            data2 = data;
                            $this$filter$iv2 = $this$filter$iv;
                            if (StringsKt.contains(it.getMovieName(), query2, true)) {
                                movieType = it.getMovieType();
                                if (movieType == null) {
                                    z3 = false;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    movieInfo = it.getMovieInfo();
                                    if (movieInfo == null) {
                                        break;
                                    }
                                    if (movieInfo == null && StringsKt.contains(movieInfo, query2, true)) {
                                    }
                                    if (z2) {
                                        destination$iv$iv.add(element$iv$iv);
                                    }
                                    data = data2;
                                    $this$filter$iv = $this$filter$iv2;
                                }
                            }
                            z2 = true;
                            if (z2) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                            data = data2;
                            $this$filter$iv = $this$filter$iv2;
                        } else {
                            data2 = data;
                            $this$filter$iv2 = $this$filter$iv;
                        }
                        z2 = false;
                        if (z2) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        data = data2;
                        $this$filter$iv = $this$filter$iv2;
                    }
                    Iterable filteredItems2 = (List) destination$iv$iv;
                    Iterable $this$forEach$iv2 = filteredItems2;
                    while (r7.hasNext()) {
                        item = (StreamFlixItem) element$iv;
                        if (item.isTV()) {
                            String movieName4 = item.getMovieName();
                            Intrinsics.checkNotNull(movieName4);
                            searchResults2.add(MainAPIKt.newTvSeriesSearchResponse$default(this, movieName4, item.getMovieKey() + "|tv", TvType.TvSeries, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda5
                                public final Object invoke(Object obj3) {
                                    return StreamFlixProvider.search$lambda$1$0(item, (TvSeriesSearchResponse) obj3);
                                }
                            }, 8, (Object) null));
                        } else {
                            String movieName5 = item.getMovieName();
                            Intrinsics.checkNotNull(movieName5);
                            searchResults2.add(MainAPIKt.newMovieSearchResponse$default(this, movieName5, item.getMovieKey() + "|movie", TvType.Movie, false, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda6
                                public final Object invoke(Object obj3) {
                                    return StreamFlixProvider.search$lambda$1$1(item, (MovieSearchResponse) obj3);
                                }
                            }, 8, (Object) null));
                        }
                        break;
                    }
                    return searchResults2;
                } catch (Exception e5) {
                    e = e5;
                    Log.INSTANCE.e("StreamFlix", "Error in search: " + e.getMessage());
                    return searchResults;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$1$0(StreamFlixItem $item, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl("https://image.tmdb.org/t/p/w500/" + $item.getMoviePoster());
        String movieYear = $item.getMovieYear();
        $this$newTvSeriesSearchResponse.setYear(movieYear != null ? StringsKt.toIntOrNull(movieYear) : null);
        $this$newTvSeriesSearchResponse.setQuality(SearchQuality.HD);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$1$1(StreamFlixItem $item, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl("https://image.tmdb.org/t/p/w500/" + $item.getMoviePoster());
        String movieYear = $item.getMovieYear();
        $this$newMovieSearchResponse.setYear(movieYear != null ? StringsKt.toIntOrNull(movieYear) : null);
        $this$newMovieSearchResponse.setQuality(SearchQuality.HD);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0349 A[Catch: Exception -> 0x0502, TRY_LEAVE, TryCatch #18 {Exception -> 0x0502, blocks: (B:50:0x025e, B:56:0x028f, B:63:0x02bc, B:66:0x02c3, B:79:0x02ff, B:80:0x030b, B:87:0x0327, B:89:0x032b, B:98:0x0343, B:100:0x0349, B:118:0x038b, B:78:0x02e6, B:62:0x02b1, B:55:0x0285, B:52:0x026a, B:59:0x0296), top: B:203:0x025e, inners: #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:102:0x034f  */
    /* JADX WARN: Code duplicated, block: B:105:0x0369 A[Catch: Exception -> 0x02df, TryCatch #9 {Exception -> 0x02df, blocks: (B:82:0x0311, B:92:0x0334, B:103:0x0350, B:105:0x0369, B:107:0x036f, B:109:0x0378, B:113:0x0381, B:74:0x02d8, B:69:0x02c9), top: B:188:0x02c6, inners: #20 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x037d  */
    /* JADX WARN: Code duplicated, block: B:113:0x0381 A[Catch: Exception -> 0x02df, TRY_LEAVE, TryCatch #9 {Exception -> 0x02df, blocks: (B:82:0x0311, B:92:0x0334, B:103:0x0350, B:105:0x0369, B:107:0x036f, B:109:0x0378, B:113:0x0381, B:74:0x02d8, B:69:0x02c9), top: B:188:0x02c6, inners: #20 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x0386  */
    /* JADX WARN: Code duplicated, block: B:120:0x03de A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:121:0x03df  */
    /* JADX WARN: Code duplicated, block: B:130:0x0447 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:131:0x0448  */
    /* JADX WARN: Code duplicated, block: B:144:0x047a  */
    /* JADX WARN: Code duplicated, block: B:147:0x048e  */
    /* JADX WARN: Code duplicated, block: B:150:0x04d9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:151:0x04da  */
    /* JADX WARN: Code duplicated, block: B:157:0x04f2  */
    /* JADX WARN: Code duplicated, block: B:186:0x0296 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:207:0x02c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:209:0x0326 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:78:0x02e6 A[Catch: Exception -> 0x0502, TRY_ENTER, TryCatch #18 {Exception -> 0x0502, blocks: (B:50:0x025e, B:56:0x028f, B:63:0x02bc, B:66:0x02c3, B:79:0x02ff, B:80:0x030b, B:87:0x0327, B:89:0x032b, B:98:0x0343, B:100:0x0349, B:118:0x038b, B:78:0x02e6, B:62:0x02b1, B:55:0x0285, B:52:0x026a, B:59:0x0296), top: B:203:0x025e, inners: #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:82:0x0311 A[Catch: Exception -> 0x02df, TRY_ENTER, TRY_LEAVE, TryCatch #9 {Exception -> 0x02df, blocks: (B:82:0x0311, B:92:0x0334, B:103:0x0350, B:105:0x0369, B:107:0x036f, B:109:0x0378, B:113:0x0381, B:74:0x02d8, B:69:0x02c9), top: B:188:0x02c6, inners: #20 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x032b A[Catch: Exception -> 0x0502, TRY_LEAVE, TryCatch #18 {Exception -> 0x0502, blocks: (B:50:0x025e, B:56:0x028f, B:63:0x02bc, B:66:0x02c3, B:79:0x02ff, B:80:0x030b, B:87:0x0327, B:89:0x032b, B:98:0x0343, B:100:0x0349, B:118:0x038b, B:78:0x02e6, B:62:0x02b1, B:55:0x0285, B:52:0x026a, B:59:0x0296), top: B:203:0x025e, inners: #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0332  */
    /* JADX WARN: Code duplicated, block: B:95:0x033e  */
    /* JADX WARN: Code duplicated, block: B:97:0x0341  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) throws Exception {
        Continuation<? super List<com.lagradost.cloudstream3.Episode>> c00031;
        String type;
        List list;
        Object obj;
        Map headers;
        int i;
        String str;
        String str2;
        NiceResponse response;
        String value$iv;
        Object obj2;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        StreamFlixData data;
        Iterator<T> it;
        Object next;
        StreamFlixItem streamFlixItem;
        StreamFlixItem item;
        String movieName;
        Object obj3;
        String movieName2;
        String movieLink;
        Object objNewMovieLoadResponse;
        StreamFlixData data2;
        NiceResponse response2;
        Map headers2;
        String movieKey;
        String movieKey2;
        StreamFlixItem item2;
        String movieName3;
        String duration;
        StreamFlixData data3;
        int seasonCount;
        Object episodesFromWebSocket;
        StreamFlixData data4;
        String str3;
        Map headers3;
        NiceResponse response3;
        MatchResult seasonMatch;
        List groupValues;
        StreamFlixItem it2;
        Object obj4;
        String str4;
        String movieKey3;
        String movieKey4;
        String url2 = url;
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
        Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation2 = c00031;
        Object $result = continuation2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation3 = "StreamFlix";
        switch (continuation2.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String str5 = StringsKt.substringAfter$default(url2, "https://api.streamflix.app/", (String) null, 2, (Object) null);
                List listSplit$default = StringsKt.split$default(str5, new String[]{"|"}, false, 0, 6, (Object) null);
                String movieKey5 = (String) listSplit$default.get(0);
                type = (String) listSplit$default.get(1);
                if (Intrinsics.areEqual(movieKey5, "error")) {
                    TvType tvType = TvType.Movie;
                    C00042 c00042 = new C00042(null);
                    continuation2.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    continuation2.L$1 = SpillingKt.nullOutSpilledVariable(str5);
                    continuation2.L$2 = SpillingKt.nullOutSpilledVariable(movieKey5);
                    continuation2.L$3 = SpillingKt.nullOutSpilledVariable(type);
                    continuation2.label = 1;
                    Object objNewMovieLoadResponse2 = MainAPIKt.newMovieLoadResponse(this, "StreamFlix Service Unavailable", url2, tvType, "", c00042, continuation2);
                    return objNewMovieLoadResponse2 == coroutine_suspended ? coroutine_suspended : objNewMovieLoadResponse2;
                }
                try {
                    Map headers4 = MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36"), TuplesKt.to("Accept", "application/json, text/plain, */*"), TuplesKt.to("Accept-Language", "en-US,en;q=0.9"), TuplesKt.to("Connection", "keep-alive")});
                    try {
                        Requests app = MainActivityKt.getApp();
                        String str6 = getMainUrl() + "/data.json";
                        continuation2.L$0 = url2;
                        continuation2.L$1 = SpillingKt.nullOutSpilledVariable(str5);
                        continuation2.L$2 = movieKey5;
                        continuation2.L$3 = SpillingKt.nullOutSpilledVariable(type);
                        continuation2.L$4 = SpillingKt.nullOutSpilledVariable(headers4);
                        continuation2.label = 2;
                        list = null;
                        obj = coroutine_suspended;
                        headers = headers4;
                        i = 2;
                        try {
                            $result = Requests.get$default(app, str6, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 30L, (Interceptor) null, false, (ResponseParser) null, continuation2, 3836, (Object) null);
                            continuation3 = continuation2;
                            if ($result == obj) {
                                return obj;
                            }
                            str = str5;
                            str2 = movieKey5;
                            try {
                                response = (NiceResponse) $result;
                                AppUtils appUtils = AppUtils.INSTANCE;
                                value$iv = response.getText();
                                try {
                                    Result.Companion companion = Result.Companion;
                                    KType kTypeTypeOf = Reflection.typeOf(StreamFlixData.class);
                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                    obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                } catch (Throwable th) {
                                    Result.Companion companion2 = Result.Companion;
                                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                }
                                if (Result.exceptionOrNull-impl(obj2) != null) {
                                    try {
                                        Result.Companion companion3 = Result.Companion;
                                        obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(StreamFlixData.class), list, i, list));
                                    } catch (Throwable th2) {
                                        Result.Companion companion4 = Result.Companion;
                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                                    }
                                }
                                if (Result.isFailure-impl(obj2)) {
                                    obj2 = list;
                                }
                                deserializationStrategy = (KSerializer) obj2;
                                try {
                                    if (deserializationStrategy == null) {
                                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv.readValue(value$iv, new TypeReference<StreamFlixData>() { // from class: com.cncverse.StreamFlixProvider$load$$inlined$parseJson$1
                                        });
                                        data = (StreamFlixData) objDecodeFromString;
                                        it = data.getData().iterator();
                                        do {
                                            if (it.hasNext()) {
                                                next = it.next();
                                                it2 = (StreamFlixItem) next;
                                            } else {
                                                next = null;
                                            }
                                            streamFlixItem = (StreamFlixItem) next;
                                            if (streamFlixItem != null) {
                                                throw new Exception("Movie not found");
                                            }
                                            item = streamFlixItem;
                                            movieName = item.getMovieName();
                                            if (movieName == null) {
                                                movieName = "Unknown Title";
                                            } else {
                                                if (StringsKt.isBlank(movieName)) {
                                                    movieName = null;
                                                }
                                                if (movieName == null) {
                                                    movieName = "Unknown Title";
                                                }
                                            }
                                            if (!item.isTV()) {
                                                obj3 = obj;
                                                Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation4 = continuation3;
                                                movieName2 = movieName;
                                                StreamFlixProvider streamFlixProvider = this;
                                                TvType tvType2 = TvType.Movie;
                                                movieLink = item.getMovieLink();
                                                if (movieLink == null) {
                                                    movieLink = "";
                                                }
                                                C00064 c00064 = new C00064(item, null);
                                                continuation4.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                                continuation4.L$1 = SpillingKt.nullOutSpilledVariable(str);
                                                continuation4.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                                continuation4.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                                continuation4.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                                                continuation4.L$5 = SpillingKt.nullOutSpilledVariable(response);
                                                continuation4.L$6 = SpillingKt.nullOutSpilledVariable(data);
                                                continuation4.L$7 = SpillingKt.nullOutSpilledVariable(item);
                                                continuation4.L$8 = SpillingKt.nullOutSpilledVariable(movieName2);
                                                continuation4.label = 5;
                                                objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(streamFlixProvider, movieName2, url2, tvType2, movieLink, c00064, continuation4);
                                                if (objNewMovieLoadResponse == obj3) {
                                                    return obj3;
                                                }
                                                data2 = data;
                                                response2 = response;
                                                headers2 = headers;
                                                movieKey = str2;
                                                movieKey2 = str;
                                                item2 = item;
                                                $result = objNewMovieLoadResponse;
                                                movieName3 = movieName2;
                                                return (LoadResponse) $result;
                                            }
                                            duration = item.getMovieDuration();
                                            if (duration != null) {
                                                data3 = data;
                                                seasonMatch = Regex.find$default(new Regex("(\\d+)\\s+Season"), duration, 0, 2, (Object) null);
                                                if (seasonMatch == null) {
                                                }
                                                if (intOrNull != null) {
                                                    break;
                                                }
                                                seasonCount = iIntValue;
                                                Log.INSTANCE.d("StreamFlix", "TV Show has " + seasonCount + " seasons");
                                                continuation3.L$0 = url2;
                                                continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str);
                                                continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                                continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                                continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                                                continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response);
                                                continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data3);
                                                continuation3.L$7 = item;
                                                continuation3.L$8 = movieName;
                                                continuation3.I$0 = seasonCount;
                                                continuation3.label = 3;
                                                episodesFromWebSocket = getEpisodesFromWebSocket(str2, seasonCount, continuation3);
                                                if (episodesFromWebSocket == obj) {
                                                    return obj;
                                                }
                                                data4 = data3;
                                                str3 = str;
                                                headers3 = headers;
                                                response3 = response;
                                                $result = episodesFromWebSocket;
                                                List episodes = (List) $result;
                                                String movieName4 = movieName;
                                                StreamFlixProvider streamFlixProvider2 = this;
                                                TvType tvType3 = TvType.TvSeries;
                                                C00053 c00053 = new C00053(item, null);
                                                continuation3.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                                continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                                                continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                                continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                                continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                                                continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response3);
                                                continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data4);
                                                continuation3.L$7 = SpillingKt.nullOutSpilledVariable(item);
                                                continuation3.L$8 = SpillingKt.nullOutSpilledVariable(movieName4);
                                                continuation3.L$9 = SpillingKt.nullOutSpilledVariable(episodes);
                                                continuation3.I$0 = seasonCount;
                                                continuation3.label = 4;
                                                obj4 = obj;
                                                Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation5 = continuation3;
                                                continuation3 = "StreamFlix";
                                                $result = MainAPIKt.newTvSeriesLoadResponse(streamFlixProvider2, movieName4, url2, tvType3, episodes, c00053, continuation5);
                                                if ($result == obj4) {
                                                    return obj4;
                                                }
                                                str4 = str3;
                                                movieKey3 = str2;
                                                movieKey4 = type;
                                                return (LoadResponse) $result;
                                            }
                                            data3 = data;
                                            seasonCount = iIntValue;
                                            Log.INSTANCE.d("StreamFlix", "TV Show has " + seasonCount + " seasons");
                                            continuation3.L$0 = url2;
                                            continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str);
                                            continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                            continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                            continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                                            continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response);
                                            continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data3);
                                            continuation3.L$7 = item;
                                            continuation3.L$8 = movieName;
                                            continuation3.I$0 = seasonCount;
                                            continuation3.label = 3;
                                            episodesFromWebSocket = getEpisodesFromWebSocket(str2, seasonCount, continuation3);
                                            if (episodesFromWebSocket == obj) {
                                                return obj;
                                            }
                                            data4 = data3;
                                            str3 = str;
                                            headers3 = headers;
                                            response3 = response;
                                            $result = episodesFromWebSocket;
                                            List episodes2 = (List) $result;
                                            String movieName5 = movieName;
                                            StreamFlixProvider streamFlixProvider3 = this;
                                            TvType tvType4 = TvType.TvSeries;
                                            C00053 c00054 = new C00053(item, null);
                                            continuation3.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                            continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                                            continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                            continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                            continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                                            continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response3);
                                            continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data4);
                                            continuation3.L$7 = SpillingKt.nullOutSpilledVariable(item);
                                            continuation3.L$8 = SpillingKt.nullOutSpilledVariable(movieName5);
                                            continuation3.L$9 = SpillingKt.nullOutSpilledVariable(episodes2);
                                            continuation3.I$0 = seasonCount;
                                            continuation3.label = 4;
                                            obj4 = obj;
                                            Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation6 = continuation3;
                                            continuation3 = "StreamFlix";
                                            $result = MainAPIKt.newTvSeriesLoadResponse(streamFlixProvider3, movieName5, url2, tvType4, episodes2, c00054, continuation6);
                                            if ($result == obj4) {
                                                return obj4;
                                            }
                                            str4 = str3;
                                            movieKey3 = str2;
                                            movieKey4 = type;
                                            return (LoadResponse) $result;
                                        } while (!Intrinsics.areEqual(it2.getMovieKey(), str2));
                                        streamFlixItem = (StreamFlixItem) next;
                                        if (streamFlixItem != null) {
                                            throw new Exception("Movie not found");
                                        }
                                        item = streamFlixItem;
                                        movieName = item.getMovieName();
                                        if (movieName == null) {
                                            movieName = "Unknown Title";
                                        } else {
                                            if (StringsKt.isBlank(movieName)) {
                                                movieName = null;
                                            }
                                            if (movieName == null) {
                                                movieName = "Unknown Title";
                                            }
                                        }
                                        if (!item.isTV()) {
                                            obj3 = obj;
                                            Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation7 = continuation3;
                                            movieName2 = movieName;
                                            StreamFlixProvider streamFlixProvider4 = this;
                                            TvType tvType5 = TvType.Movie;
                                            movieLink = item.getMovieLink();
                                            if (movieLink == null) {
                                                movieLink = "";
                                            }
                                            C00064 c00065 = new C00064(item, null);
                                            continuation7.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                            continuation7.L$1 = SpillingKt.nullOutSpilledVariable(str);
                                            continuation7.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                            continuation7.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                            continuation7.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                                            continuation7.L$5 = SpillingKt.nullOutSpilledVariable(response);
                                            continuation7.L$6 = SpillingKt.nullOutSpilledVariable(data);
                                            continuation7.L$7 = SpillingKt.nullOutSpilledVariable(item);
                                            continuation7.L$8 = SpillingKt.nullOutSpilledVariable(movieName2);
                                            continuation7.label = 5;
                                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(streamFlixProvider4, movieName2, url2, tvType5, movieLink, c00065, continuation7);
                                            if (objNewMovieLoadResponse == obj3) {
                                                return obj3;
                                            }
                                            data2 = data;
                                            response2 = response;
                                            headers2 = headers;
                                            movieKey = str2;
                                            movieKey2 = str;
                                            item2 = item;
                                            $result = objNewMovieLoadResponse;
                                            movieName3 = movieName2;
                                            return (LoadResponse) $result;
                                        }
                                        duration = item.getMovieDuration();
                                        if (duration != null) {
                                            data3 = data;
                                            seasonMatch = Regex.find$default(new Regex("(\\d+)\\s+Season"), duration, 0, 2, (Object) null);
                                            if (seasonMatch == null) {
                                            }
                                            if (intOrNull != null) {
                                                break;
                                            }
                                            seasonCount = iIntValue;
                                            Log.INSTANCE.d("StreamFlix", "TV Show has " + seasonCount + " seasons");
                                            continuation3.L$0 = url2;
                                            continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str);
                                            continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                            continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                            continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                                            continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response);
                                            continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data3);
                                            continuation3.L$7 = item;
                                            continuation3.L$8 = movieName;
                                            continuation3.I$0 = seasonCount;
                                            continuation3.label = 3;
                                            episodesFromWebSocket = getEpisodesFromWebSocket(str2, seasonCount, continuation3);
                                            if (episodesFromWebSocket == obj) {
                                                return obj;
                                            }
                                            data4 = data3;
                                            str3 = str;
                                            headers3 = headers;
                                            response3 = response;
                                            $result = episodesFromWebSocket;
                                            List episodes3 = (List) $result;
                                            String movieName6 = movieName;
                                            StreamFlixProvider streamFlixProvider5 = this;
                                            TvType tvType6 = TvType.TvSeries;
                                            C00053 c00055 = new C00053(item, null);
                                            continuation3.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                            continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                                            continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                            continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                            continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                                            continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response3);
                                            continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data4);
                                            continuation3.L$7 = SpillingKt.nullOutSpilledVariable(item);
                                            continuation3.L$8 = SpillingKt.nullOutSpilledVariable(movieName6);
                                            continuation3.L$9 = SpillingKt.nullOutSpilledVariable(episodes3);
                                            continuation3.I$0 = seasonCount;
                                            continuation3.label = 4;
                                            obj4 = obj;
                                            Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation8 = continuation3;
                                            continuation3 = "StreamFlix";
                                            $result = MainAPIKt.newTvSeriesLoadResponse(streamFlixProvider5, movieName6, url2, tvType6, episodes3, c00055, continuation8);
                                            if ($result == obj4) {
                                                return obj4;
                                            }
                                            str4 = str3;
                                            movieKey3 = str2;
                                            movieKey4 = type;
                                            return (LoadResponse) $result;
                                        }
                                        data3 = data;
                                        seasonCount = iIntValue;
                                        Log.INSTANCE.d("StreamFlix", "TV Show has " + seasonCount + " seasons");
                                        continuation3.L$0 = url2;
                                        continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str);
                                        continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                        continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                        continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                                        continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response);
                                        continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data3);
                                        continuation3.L$7 = item;
                                        continuation3.L$8 = movieName;
                                        continuation3.I$0 = seasonCount;
                                        continuation3.label = 3;
                                        episodesFromWebSocket = getEpisodesFromWebSocket(str2, seasonCount, continuation3);
                                        if (episodesFromWebSocket == obj) {
                                            return obj;
                                        }
                                        data4 = data3;
                                        str3 = str;
                                        headers3 = headers;
                                        response3 = response;
                                        $result = episodesFromWebSocket;
                                        List episodes4 = (List) $result;
                                        String movieName7 = movieName;
                                        StreamFlixProvider streamFlixProvider6 = this;
                                        TvType tvType7 = TvType.TvSeries;
                                        C00053 c00056 = new C00053(item, null);
                                        continuation3.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                        continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                                        continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                        continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                        continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                                        continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response3);
                                        continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data4);
                                        continuation3.L$7 = SpillingKt.nullOutSpilledVariable(item);
                                        continuation3.L$8 = SpillingKt.nullOutSpilledVariable(movieName7);
                                        continuation3.L$9 = SpillingKt.nullOutSpilledVariable(episodes4);
                                        continuation3.I$0 = seasonCount;
                                        continuation3.label = 4;
                                        obj4 = obj;
                                        Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation9 = continuation3;
                                        continuation3 = "StreamFlix";
                                        $result = MainAPIKt.newTvSeriesLoadResponse(streamFlixProvider6, movieName7, url2, tvType7, episodes4, c00056, continuation9);
                                        if ($result == obj4) {
                                            return obj4;
                                        }
                                        str4 = str3;
                                        movieKey3 = str2;
                                        movieKey4 = type;
                                        return (LoadResponse) $result;
                                    }
                                    try {
                                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                                    } catch (SerializationException e) {
                                        ArchComponentExtKt.logError(e);
                                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv2.readValue(value$iv, new TypeReference<StreamFlixData>() { // from class: com.cncverse.StreamFlixProvider$load$$inlined$parseJson$1
                                        });
                                    } catch (Throwable th3) {
                                        ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv3.readValue(value$iv, new TypeReference<StreamFlixData>() { // from class: com.cncverse.StreamFlixProvider$load$$inlined$parseJson$1
                                        });
                                    }
                                    data = (StreamFlixData) objDecodeFromString;
                                    it = data.getData().iterator();
                                    try {
                                        do {
                                            if (it.hasNext()) {
                                                next = it.next();
                                                it2 = (StreamFlixItem) next;
                                            } else {
                                                next = null;
                                            }
                                            streamFlixItem = (StreamFlixItem) next;
                                            if (streamFlixItem != null) {
                                                throw new Exception("Movie not found");
                                            }
                                            item = streamFlixItem;
                                            movieName = item.getMovieName();
                                            if (movieName == null) {
                                                movieName = "Unknown Title";
                                            } else {
                                                if (StringsKt.isBlank(movieName)) {
                                                    movieName = null;
                                                }
                                                if (movieName == null) {
                                                    movieName = "Unknown Title";
                                                }
                                            }
                                            if (!item.isTV()) {
                                                duration = item.getMovieDuration();
                                                if (duration != null) {
                                                    data3 = data;
                                                    seasonMatch = Regex.find$default(new Regex("(\\d+)\\s+Season"), duration, 0, 2, (Object) null);
                                                    if (seasonMatch == null && (groupValues = seasonMatch.getGroupValues()) != null) {
                                                        String str7 = (String) groupValues.get(1);
                                                        Integer intOrNull = str7 != null ? StringsKt.toIntOrNull(str7) : null;
                                                        int iIntValue = intOrNull != null ? intOrNull.intValue() : 1;
                                                        seasonCount = iIntValue;
                                                        Log.INSTANCE.d("StreamFlix", "TV Show has " + seasonCount + " seasons");
                                                        continuation3.L$0 = url2;
                                                        continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str);
                                                        continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                                        continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                                        continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                                                        continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response);
                                                        continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data3);
                                                        continuation3.L$7 = item;
                                                        continuation3.L$8 = movieName;
                                                        continuation3.I$0 = seasonCount;
                                                        continuation3.label = 3;
                                                        episodesFromWebSocket = getEpisodesFromWebSocket(str2, seasonCount, continuation3);
                                                        if (episodesFromWebSocket == obj) {
                                                            return obj;
                                                        }
                                                        data4 = data3;
                                                        str3 = str;
                                                        headers3 = headers;
                                                        response3 = response;
                                                        $result = episodesFromWebSocket;
                                                        try {
                                                            List episodes5 = (List) $result;
                                                            String movieName8 = movieName;
                                                            try {
                                                                StreamFlixProvider streamFlixProvider7 = this;
                                                                try {
                                                                    TvType tvType8 = TvType.TvSeries;
                                                                    C00053 c00057 = new C00053(item, null);
                                                                    continuation3.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                                                    continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                                                                    continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                                                    continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                                                    continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                                                                    continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response3);
                                                                    continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data4);
                                                                    continuation3.L$7 = SpillingKt.nullOutSpilledVariable(item);
                                                                    continuation3.L$8 = SpillingKt.nullOutSpilledVariable(movieName8);
                                                                    continuation3.L$9 = SpillingKt.nullOutSpilledVariable(episodes5);
                                                                    continuation3.I$0 = seasonCount;
                                                                    continuation3.label = 4;
                                                                    obj4 = obj;
                                                                    Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation10 = continuation3;
                                                                    continuation3 = "StreamFlix";
                                                                    try {
                                                                        $result = MainAPIKt.newTvSeriesLoadResponse(streamFlixProvider7, movieName8, url2, tvType8, episodes5, c00057, continuation10);
                                                                        if ($result == obj4) {
                                                                            return obj4;
                                                                        }
                                                                        str4 = str3;
                                                                        movieKey3 = str2;
                                                                        movieKey4 = type;
                                                                        try {
                                                                            return (LoadResponse) $result;
                                                                        } catch (Exception e2) {
                                                                            e = e2;
                                                                        }
                                                                    } catch (Exception e3) {
                                                                        e = e3;
                                                                    }
                                                                } catch (Exception e4) {
                                                                    e = e4;
                                                                    continuation3 = "StreamFlix";
                                                                }
                                                            } catch (Exception e5) {
                                                                e = e5;
                                                                continuation3 = "StreamFlix";
                                                            }
                                                        } catch (Exception e6) {
                                                            e = e6;
                                                            continuation3 = "StreamFlix";
                                                        }
                                                        break;
                                                    }
                                                    if (intOrNull != null) {
                                                        break;
                                                    }
                                                    seasonCount = iIntValue;
                                                    Log.INSTANCE.d("StreamFlix", "TV Show has " + seasonCount + " seasons");
                                                    continuation3.L$0 = url2;
                                                    continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str);
                                                    continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                                    continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                                    continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                                                    continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response);
                                                    continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data3);
                                                    continuation3.L$7 = item;
                                                    continuation3.L$8 = movieName;
                                                    continuation3.I$0 = seasonCount;
                                                    continuation3.label = 3;
                                                    episodesFromWebSocket = getEpisodesFromWebSocket(str2, seasonCount, continuation3);
                                                    if (episodesFromWebSocket == obj) {
                                                        return obj;
                                                    }
                                                    data4 = data3;
                                                    str3 = str;
                                                    headers3 = headers;
                                                    response3 = response;
                                                    $result = episodesFromWebSocket;
                                                    List episodes6 = (List) $result;
                                                    String movieName9 = movieName;
                                                    StreamFlixProvider streamFlixProvider8 = this;
                                                    TvType tvType9 = TvType.TvSeries;
                                                    C00053 c00058 = new C00053(item, null);
                                                    continuation3.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                                    continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                                                    continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                                    continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                                    continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                                                    continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response3);
                                                    continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data4);
                                                    continuation3.L$7 = SpillingKt.nullOutSpilledVariable(item);
                                                    continuation3.L$8 = SpillingKt.nullOutSpilledVariable(movieName9);
                                                    continuation3.L$9 = SpillingKt.nullOutSpilledVariable(episodes6);
                                                    continuation3.I$0 = seasonCount;
                                                    continuation3.label = 4;
                                                    obj4 = obj;
                                                    Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation11 = continuation3;
                                                    continuation3 = "StreamFlix";
                                                    $result = MainAPIKt.newTvSeriesLoadResponse(streamFlixProvider8, movieName9, url2, tvType9, episodes6, c00058, continuation11);
                                                    if ($result == obj4) {
                                                        return obj4;
                                                    }
                                                    str4 = str3;
                                                    movieKey3 = str2;
                                                    movieKey4 = type;
                                                    return (LoadResponse) $result;
                                                }
                                                data3 = data;
                                                seasonCount = iIntValue;
                                                Log.INSTANCE.d("StreamFlix", "TV Show has " + seasonCount + " seasons");
                                                continuation3.L$0 = url2;
                                                continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str);
                                                continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                                continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                                continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                                                continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response);
                                                continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data3);
                                                continuation3.L$7 = item;
                                                continuation3.L$8 = movieName;
                                                continuation3.I$0 = seasonCount;
                                                continuation3.label = 3;
                                                episodesFromWebSocket = getEpisodesFromWebSocket(str2, seasonCount, continuation3);
                                                if (episodesFromWebSocket == obj) {
                                                    return obj;
                                                }
                                                data4 = data3;
                                                str3 = str;
                                                headers3 = headers;
                                                response3 = response;
                                                $result = episodesFromWebSocket;
                                                List episodes7 = (List) $result;
                                                String movieName10 = movieName;
                                                StreamFlixProvider streamFlixProvider9 = this;
                                                TvType tvType10 = TvType.TvSeries;
                                                C00053 c00059 = new C00053(item, null);
                                                continuation3.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                                continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                                                continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                                continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                                continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                                                continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response3);
                                                continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data4);
                                                continuation3.L$7 = SpillingKt.nullOutSpilledVariable(item);
                                                continuation3.L$8 = SpillingKt.nullOutSpilledVariable(movieName10);
                                                continuation3.L$9 = SpillingKt.nullOutSpilledVariable(episodes7);
                                                continuation3.I$0 = seasonCount;
                                                continuation3.label = 4;
                                                obj4 = obj;
                                                Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation12 = continuation3;
                                                continuation3 = "StreamFlix";
                                                $result = MainAPIKt.newTvSeriesLoadResponse(streamFlixProvider9, movieName10, url2, tvType10, episodes7, c00059, continuation12);
                                                if ($result == obj4) {
                                                    return obj4;
                                                }
                                                str4 = str3;
                                                movieKey3 = str2;
                                                movieKey4 = type;
                                                return (LoadResponse) $result;
                                            }
                                            obj3 = obj;
                                            Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation13 = continuation3;
                                            movieName2 = movieName;
                                            StreamFlixProvider streamFlixProvider10 = this;
                                            TvType tvType11 = TvType.Movie;
                                            movieLink = item.getMovieLink();
                                            if (movieLink == null) {
                                                movieLink = "";
                                            }
                                            C00064 c00066 = new C00064(item, null);
                                            continuation13.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                            continuation13.L$1 = SpillingKt.nullOutSpilledVariable(str);
                                            continuation13.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                            continuation13.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                            continuation13.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                                            continuation13.L$5 = SpillingKt.nullOutSpilledVariable(response);
                                            continuation13.L$6 = SpillingKt.nullOutSpilledVariable(data);
                                            continuation13.L$7 = SpillingKt.nullOutSpilledVariable(item);
                                            continuation13.L$8 = SpillingKt.nullOutSpilledVariable(movieName2);
                                            continuation13.label = 5;
                                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(streamFlixProvider10, movieName2, url2, tvType11, movieLink, c00066, continuation13);
                                            if (objNewMovieLoadResponse == obj3) {
                                                return obj3;
                                            }
                                            data2 = data;
                                            response2 = response;
                                            headers2 = headers;
                                            movieKey = str2;
                                            movieKey2 = str;
                                            item2 = item;
                                            $result = objNewMovieLoadResponse;
                                            movieName3 = movieName2;
                                            try {
                                                return (LoadResponse) $result;
                                            } catch (Exception e7) {
                                                e = e7;
                                            }
                                        } while (!Intrinsics.areEqual(it2.getMovieKey(), str2));
                                        if (streamFlixItem != null) {
                                            throw new Exception("Movie not found");
                                        }
                                        item = streamFlixItem;
                                        movieName = item.getMovieName();
                                        if (movieName == null) {
                                            movieName = "Unknown Title";
                                        } else {
                                            if (StringsKt.isBlank(movieName)) {
                                                movieName = null;
                                            }
                                            if (movieName == null) {
                                                movieName = "Unknown Title";
                                            }
                                        }
                                        if (!item.isTV()) {
                                            obj3 = obj;
                                            Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation14 = continuation3;
                                            movieName2 = movieName;
                                            StreamFlixProvider streamFlixProvider11 = this;
                                            TvType tvType12 = TvType.Movie;
                                            movieLink = item.getMovieLink();
                                            if (movieLink == null) {
                                                movieLink = "";
                                            }
                                            C00064 c00067 = new C00064(item, null);
                                            continuation14.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                            continuation14.L$1 = SpillingKt.nullOutSpilledVariable(str);
                                            continuation14.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                            continuation14.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                            continuation14.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                                            continuation14.L$5 = SpillingKt.nullOutSpilledVariable(response);
                                            continuation14.L$6 = SpillingKt.nullOutSpilledVariable(data);
                                            continuation14.L$7 = SpillingKt.nullOutSpilledVariable(item);
                                            continuation14.L$8 = SpillingKt.nullOutSpilledVariable(movieName2);
                                            continuation14.label = 5;
                                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(streamFlixProvider11, movieName2, url2, tvType12, movieLink, c00067, continuation14);
                                            if (objNewMovieLoadResponse == obj3) {
                                                return obj3;
                                            }
                                            data2 = data;
                                            response2 = response;
                                            headers2 = headers;
                                            movieKey = str2;
                                            movieKey2 = str;
                                            item2 = item;
                                            $result = objNewMovieLoadResponse;
                                            movieName3 = movieName2;
                                            return (LoadResponse) $result;
                                        }
                                        duration = item.getMovieDuration();
                                        if (duration != null) {
                                            data3 = data;
                                            seasonMatch = Regex.find$default(new Regex("(\\d+)\\s+Season"), duration, 0, 2, (Object) null);
                                            if (seasonMatch == null) {
                                            }
                                            if (intOrNull != null) {
                                                break;
                                            }
                                            seasonCount = iIntValue;
                                            Log.INSTANCE.d("StreamFlix", "TV Show has " + seasonCount + " seasons");
                                            continuation3.L$0 = url2;
                                            continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str);
                                            continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                            continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                            continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                                            continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response);
                                            continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data3);
                                            continuation3.L$7 = item;
                                            continuation3.L$8 = movieName;
                                            continuation3.I$0 = seasonCount;
                                            continuation3.label = 3;
                                            episodesFromWebSocket = getEpisodesFromWebSocket(str2, seasonCount, continuation3);
                                            if (episodesFromWebSocket == obj) {
                                                return obj;
                                            }
                                            data4 = data3;
                                            str3 = str;
                                            headers3 = headers;
                                            response3 = response;
                                            $result = episodesFromWebSocket;
                                            List episodes8 = (List) $result;
                                            String movieName11 = movieName;
                                            StreamFlixProvider streamFlixProvider12 = this;
                                            TvType tvType13 = TvType.TvSeries;
                                            C00053 c000510 = new C00053(item, null);
                                            continuation3.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                            continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                                            continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                            continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                            continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                                            continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response3);
                                            continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data4);
                                            continuation3.L$7 = SpillingKt.nullOutSpilledVariable(item);
                                            continuation3.L$8 = SpillingKt.nullOutSpilledVariable(movieName11);
                                            continuation3.L$9 = SpillingKt.nullOutSpilledVariable(episodes8);
                                            continuation3.I$0 = seasonCount;
                                            continuation3.label = 4;
                                            obj4 = obj;
                                            Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation15 = continuation3;
                                            continuation3 = "StreamFlix";
                                            $result = MainAPIKt.newTvSeriesLoadResponse(streamFlixProvider12, movieName11, url2, tvType13, episodes8, c000510, continuation15);
                                            if ($result == obj4) {
                                                return obj4;
                                            }
                                            str4 = str3;
                                            movieKey3 = str2;
                                            movieKey4 = type;
                                            return (LoadResponse) $result;
                                        }
                                        data3 = data;
                                        seasonCount = iIntValue;
                                        Log.INSTANCE.d("StreamFlix", "TV Show has " + seasonCount + " seasons");
                                        continuation3.L$0 = url2;
                                        continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str);
                                        continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                        continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                        continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                                        continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response);
                                        continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data3);
                                        continuation3.L$7 = item;
                                        continuation3.L$8 = movieName;
                                        continuation3.I$0 = seasonCount;
                                        continuation3.label = 3;
                                        episodesFromWebSocket = getEpisodesFromWebSocket(str2, seasonCount, continuation3);
                                        if (episodesFromWebSocket == obj) {
                                            return obj;
                                        }
                                        data4 = data3;
                                        str3 = str;
                                        headers3 = headers;
                                        response3 = response;
                                        $result = episodesFromWebSocket;
                                        List episodes9 = (List) $result;
                                        String movieName12 = movieName;
                                        StreamFlixProvider streamFlixProvider13 = this;
                                        TvType tvType14 = TvType.TvSeries;
                                        C00053 c000511 = new C00053(item, null);
                                        continuation3.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                        continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                                        continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                        continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                        continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                                        continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response3);
                                        continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data4);
                                        continuation3.L$7 = SpillingKt.nullOutSpilledVariable(item);
                                        continuation3.L$8 = SpillingKt.nullOutSpilledVariable(movieName12);
                                        continuation3.L$9 = SpillingKt.nullOutSpilledVariable(episodes9);
                                        continuation3.I$0 = seasonCount;
                                        continuation3.label = 4;
                                        obj4 = obj;
                                        Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation16 = continuation3;
                                        continuation3 = "StreamFlix";
                                        $result = MainAPIKt.newTvSeriesLoadResponse(streamFlixProvider13, movieName12, url2, tvType14, episodes9, c000511, continuation16);
                                        if ($result == obj4) {
                                            return obj4;
                                        }
                                        str4 = str3;
                                        movieKey3 = str2;
                                        movieKey4 = type;
                                        return (LoadResponse) $result;
                                    } catch (Exception e8) {
                                        e = e8;
                                    }
                                    streamFlixItem = (StreamFlixItem) next;
                                } catch (Exception e9) {
                                    e = e9;
                                    continuation3 = "StreamFlix";
                                }
                                break;
                            } catch (Exception e10) {
                                e = e10;
                                continuation3 = "StreamFlix";
                            }
                            Log.INSTANCE.e(continuation3, "Error in load: " + e.getMessage());
                            throw new Exception("Failed to load content: " + e.getMessage());
                        } catch (Exception e11) {
                            e = e11;
                            continuation3 = "StreamFlix";
                        }
                    } catch (Exception e12) {
                        e = e12;
                        continuation3 = "StreamFlix";
                    }
                } catch (Exception e13) {
                    e = e13;
                    continuation3 = "StreamFlix";
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            case 2:
                Map headers5 = (Map) continuation2.L$4;
                String type2 = (String) continuation2.L$3;
                str2 = (String) continuation2.L$2;
                str = (String) continuation2.L$1;
                url2 = (String) continuation2.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    continuation3 = continuation2;
                    obj = coroutine_suspended;
                    headers = headers5;
                    type = type2;
                    i = 2;
                    list = null;
                    response = (NiceResponse) $result;
                    AppUtils appUtils2 = AppUtils.INSTANCE;
                    value$iv = response.getText();
                    Result.Companion companion5 = Result.Companion;
                    KType kTypeTypeOf2 = Reflection.typeOf(StreamFlixData.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                    if (Result.exceptionOrNull-impl(obj2) != null) {
                        Result.Companion companion6 = Result.Companion;
                        obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(StreamFlixData.class), list, i, list));
                        break;
                    }
                    if (Result.isFailure-impl(obj2)) {
                        obj2 = list;
                    }
                    deserializationStrategy = (KSerializer) obj2;
                    if (deserializationStrategy == null) {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                        data = (StreamFlixData) objDecodeFromString;
                        it = data.getData().iterator();
                        do {
                            if (it.hasNext()) {
                                next = it.next();
                                it2 = (StreamFlixItem) next;
                            } else {
                                next = null;
                            }
                            streamFlixItem = (StreamFlixItem) next;
                            if (streamFlixItem != null) {
                                throw new Exception("Movie not found");
                            }
                            item = streamFlixItem;
                            movieName = item.getMovieName();
                            if (movieName == null) {
                                movieName = "Unknown Title";
                            } else {
                                if (StringsKt.isBlank(movieName)) {
                                    movieName = null;
                                }
                                if (movieName == null) {
                                    movieName = "Unknown Title";
                                }
                            }
                            if (!item.isTV()) {
                                obj3 = obj;
                                Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation17 = continuation3;
                                movieName2 = movieName;
                                StreamFlixProvider streamFlixProvider14 = this;
                                TvType tvType15 = TvType.Movie;
                                movieLink = item.getMovieLink();
                                if (movieLink == null) {
                                    movieLink = "";
                                }
                                C00064 c00068 = new C00064(item, null);
                                continuation17.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                continuation17.L$1 = SpillingKt.nullOutSpilledVariable(str);
                                continuation17.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                continuation17.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                continuation17.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                                continuation17.L$5 = SpillingKt.nullOutSpilledVariable(response);
                                continuation17.L$6 = SpillingKt.nullOutSpilledVariable(data);
                                continuation17.L$7 = SpillingKt.nullOutSpilledVariable(item);
                                continuation17.L$8 = SpillingKt.nullOutSpilledVariable(movieName2);
                                continuation17.label = 5;
                                objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(streamFlixProvider14, movieName2, url2, tvType15, movieLink, c00068, continuation17);
                                if (objNewMovieLoadResponse == obj3) {
                                    return obj3;
                                }
                                data2 = data;
                                response2 = response;
                                headers2 = headers;
                                movieKey = str2;
                                movieKey2 = str;
                                item2 = item;
                                $result = objNewMovieLoadResponse;
                                movieName3 = movieName2;
                                return (LoadResponse) $result;
                            }
                            duration = item.getMovieDuration();
                            if (duration != null) {
                                data3 = data;
                                seasonMatch = Regex.find$default(new Regex("(\\d+)\\s+Season"), duration, 0, 2, (Object) null);
                                if (seasonMatch == null) {
                                }
                                if (intOrNull != null) {
                                    break;
                                }
                                seasonCount = iIntValue;
                                Log.INSTANCE.d("StreamFlix", "TV Show has " + seasonCount + " seasons");
                                continuation3.L$0 = url2;
                                continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str);
                                continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                                continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response);
                                continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data3);
                                continuation3.L$7 = item;
                                continuation3.L$8 = movieName;
                                continuation3.I$0 = seasonCount;
                                continuation3.label = 3;
                                episodesFromWebSocket = getEpisodesFromWebSocket(str2, seasonCount, continuation3);
                                if (episodesFromWebSocket == obj) {
                                    return obj;
                                }
                                data4 = data3;
                                str3 = str;
                                headers3 = headers;
                                response3 = response;
                                $result = episodesFromWebSocket;
                                List episodes10 = (List) $result;
                                String movieName13 = movieName;
                                StreamFlixProvider streamFlixProvider15 = this;
                                TvType tvType16 = TvType.TvSeries;
                                C00053 c000512 = new C00053(item, null);
                                continuation3.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                                continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                                continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                                continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response3);
                                continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data4);
                                continuation3.L$7 = SpillingKt.nullOutSpilledVariable(item);
                                continuation3.L$8 = SpillingKt.nullOutSpilledVariable(movieName13);
                                continuation3.L$9 = SpillingKt.nullOutSpilledVariable(episodes10);
                                continuation3.I$0 = seasonCount;
                                continuation3.label = 4;
                                obj4 = obj;
                                Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation18 = continuation3;
                                continuation3 = "StreamFlix";
                                $result = MainAPIKt.newTvSeriesLoadResponse(streamFlixProvider15, movieName13, url2, tvType16, episodes10, c000512, continuation18);
                                if ($result == obj4) {
                                    return obj4;
                                }
                                str4 = str3;
                                movieKey3 = str2;
                                movieKey4 = type;
                                return (LoadResponse) $result;
                            }
                            data3 = data;
                            seasonCount = iIntValue;
                            Log.INSTANCE.d("StreamFlix", "TV Show has " + seasonCount + " seasons");
                            continuation3.L$0 = url2;
                            continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str);
                            continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                            continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                            continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                            continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response);
                            continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data3);
                            continuation3.L$7 = item;
                            continuation3.L$8 = movieName;
                            continuation3.I$0 = seasonCount;
                            continuation3.label = 3;
                            episodesFromWebSocket = getEpisodesFromWebSocket(str2, seasonCount, continuation3);
                            if (episodesFromWebSocket == obj) {
                                return obj;
                            }
                            data4 = data3;
                            str3 = str;
                            headers3 = headers;
                            response3 = response;
                            $result = episodesFromWebSocket;
                            List episodes11 = (List) $result;
                            String movieName14 = movieName;
                            StreamFlixProvider streamFlixProvider16 = this;
                            TvType tvType17 = TvType.TvSeries;
                            C00053 c000513 = new C00053(item, null);
                            continuation3.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                            continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                            continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                            continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                            continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                            continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response3);
                            continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data4);
                            continuation3.L$7 = SpillingKt.nullOutSpilledVariable(item);
                            continuation3.L$8 = SpillingKt.nullOutSpilledVariable(movieName14);
                            continuation3.L$9 = SpillingKt.nullOutSpilledVariable(episodes11);
                            continuation3.I$0 = seasonCount;
                            continuation3.label = 4;
                            obj4 = obj;
                            Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation19 = continuation3;
                            continuation3 = "StreamFlix";
                            $result = MainAPIKt.newTvSeriesLoadResponse(streamFlixProvider16, movieName14, url2, tvType17, episodes11, c000513, continuation19);
                            if ($result == obj4) {
                                return obj4;
                            }
                            str4 = str3;
                            movieKey3 = str2;
                            movieKey4 = type;
                            return (LoadResponse) $result;
                        } while (!Intrinsics.areEqual(it2.getMovieKey(), str2));
                        streamFlixItem = (StreamFlixItem) next;
                        if (streamFlixItem != null) {
                            throw new Exception("Movie not found");
                        }
                        item = streamFlixItem;
                        movieName = item.getMovieName();
                        if (movieName == null) {
                            movieName = "Unknown Title";
                        } else {
                            if (StringsKt.isBlank(movieName)) {
                                movieName = null;
                            }
                            if (movieName == null) {
                                movieName = "Unknown Title";
                            }
                        }
                        if (!item.isTV()) {
                            obj3 = obj;
                            Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation110 = continuation3;
                            movieName2 = movieName;
                            StreamFlixProvider streamFlixProvider17 = this;
                            TvType tvType18 = TvType.Movie;
                            movieLink = item.getMovieLink();
                            if (movieLink == null) {
                                movieLink = "";
                            }
                            C00064 c00069 = new C00064(item, null);
                            continuation110.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                            continuation110.L$1 = SpillingKt.nullOutSpilledVariable(str);
                            continuation110.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                            continuation110.L$3 = SpillingKt.nullOutSpilledVariable(type);
                            continuation110.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                            continuation110.L$5 = SpillingKt.nullOutSpilledVariable(response);
                            continuation110.L$6 = SpillingKt.nullOutSpilledVariable(data);
                            continuation110.L$7 = SpillingKt.nullOutSpilledVariable(item);
                            continuation110.L$8 = SpillingKt.nullOutSpilledVariable(movieName2);
                            continuation110.label = 5;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(streamFlixProvider17, movieName2, url2, tvType18, movieLink, c00069, continuation110);
                            if (objNewMovieLoadResponse == obj3) {
                                return obj3;
                            }
                            data2 = data;
                            response2 = response;
                            headers2 = headers;
                            movieKey = str2;
                            movieKey2 = str;
                            item2 = item;
                            $result = objNewMovieLoadResponse;
                            movieName3 = movieName2;
                            return (LoadResponse) $result;
                        }
                        duration = item.getMovieDuration();
                        if (duration != null) {
                            data3 = data;
                            seasonMatch = Regex.find$default(new Regex("(\\d+)\\s+Season"), duration, 0, 2, (Object) null);
                            if (seasonMatch == null) {
                            }
                            if (intOrNull != null) {
                                break;
                            }
                            seasonCount = iIntValue;
                            Log.INSTANCE.d("StreamFlix", "TV Show has " + seasonCount + " seasons");
                            continuation3.L$0 = url2;
                            continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str);
                            continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                            continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                            continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                            continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response);
                            continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data3);
                            continuation3.L$7 = item;
                            continuation3.L$8 = movieName;
                            continuation3.I$0 = seasonCount;
                            continuation3.label = 3;
                            episodesFromWebSocket = getEpisodesFromWebSocket(str2, seasonCount, continuation3);
                            if (episodesFromWebSocket == obj) {
                                return obj;
                            }
                            data4 = data3;
                            str3 = str;
                            headers3 = headers;
                            response3 = response;
                            $result = episodesFromWebSocket;
                            List episodes12 = (List) $result;
                            String movieName15 = movieName;
                            StreamFlixProvider streamFlixProvider18 = this;
                            TvType tvType19 = TvType.TvSeries;
                            C00053 c000514 = new C00053(item, null);
                            continuation3.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                            continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                            continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                            continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                            continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                            continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response3);
                            continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data4);
                            continuation3.L$7 = SpillingKt.nullOutSpilledVariable(item);
                            continuation3.L$8 = SpillingKt.nullOutSpilledVariable(movieName15);
                            continuation3.L$9 = SpillingKt.nullOutSpilledVariable(episodes12);
                            continuation3.I$0 = seasonCount;
                            continuation3.label = 4;
                            obj4 = obj;
                            Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation111 = continuation3;
                            continuation3 = "StreamFlix";
                            $result = MainAPIKt.newTvSeriesLoadResponse(streamFlixProvider18, movieName15, url2, tvType19, episodes12, c000514, continuation111);
                            if ($result == obj4) {
                                return obj4;
                            }
                            str4 = str3;
                            movieKey3 = str2;
                            movieKey4 = type;
                            return (LoadResponse) $result;
                        }
                        data3 = data;
                        seasonCount = iIntValue;
                        Log.INSTANCE.d("StreamFlix", "TV Show has " + seasonCount + " seasons");
                        continuation3.L$0 = url2;
                        continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str);
                        continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                        continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                        continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                        continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response);
                        continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data3);
                        continuation3.L$7 = item;
                        continuation3.L$8 = movieName;
                        continuation3.I$0 = seasonCount;
                        continuation3.label = 3;
                        episodesFromWebSocket = getEpisodesFromWebSocket(str2, seasonCount, continuation3);
                        if (episodesFromWebSocket == obj) {
                            return obj;
                        }
                        data4 = data3;
                        str3 = str;
                        headers3 = headers;
                        response3 = response;
                        $result = episodesFromWebSocket;
                        List episodes13 = (List) $result;
                        String movieName16 = movieName;
                        StreamFlixProvider streamFlixProvider19 = this;
                        TvType tvType110 = TvType.TvSeries;
                        C00053 c000515 = new C00053(item, null);
                        continuation3.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                        continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                        continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                        continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                        continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response3);
                        continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data4);
                        continuation3.L$7 = SpillingKt.nullOutSpilledVariable(item);
                        continuation3.L$8 = SpillingKt.nullOutSpilledVariable(movieName16);
                        continuation3.L$9 = SpillingKt.nullOutSpilledVariable(episodes13);
                        continuation3.I$0 = seasonCount;
                        continuation3.label = 4;
                        obj4 = obj;
                        Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation112 = continuation3;
                        continuation3 = "StreamFlix";
                        $result = MainAPIKt.newTvSeriesLoadResponse(streamFlixProvider19, movieName16, url2, tvType110, episodes13, c000515, continuation112);
                        if ($result == obj4) {
                            return obj4;
                        }
                        str4 = str3;
                        movieKey3 = str2;
                        movieKey4 = type;
                        return (LoadResponse) $result;
                    }
                    ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv4.readValue(value$iv, new TypeReference<StreamFlixData>() { // from class: com.cncverse.StreamFlixProvider$load$$inlined$parseJson$1
                    });
                    data = (StreamFlixData) objDecodeFromString;
                    it = data.getData().iterator();
                    do {
                        if (it.hasNext()) {
                            next = it.next();
                            it2 = (StreamFlixItem) next;
                        } else {
                            next = null;
                        }
                        streamFlixItem = (StreamFlixItem) next;
                        if (streamFlixItem != null) {
                            throw new Exception("Movie not found");
                        }
                        item = streamFlixItem;
                        movieName = item.getMovieName();
                        if (movieName == null) {
                            movieName = "Unknown Title";
                        } else {
                            if (StringsKt.isBlank(movieName)) {
                                movieName = null;
                            }
                            if (movieName == null) {
                                movieName = "Unknown Title";
                            }
                        }
                        if (!item.isTV()) {
                            obj3 = obj;
                            Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation113 = continuation3;
                            movieName2 = movieName;
                            StreamFlixProvider streamFlixProvider110 = this;
                            TvType tvType111 = TvType.Movie;
                            movieLink = item.getMovieLink();
                            if (movieLink == null) {
                                movieLink = "";
                            }
                            C00064 c000610 = new C00064(item, null);
                            continuation113.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                            continuation113.L$1 = SpillingKt.nullOutSpilledVariable(str);
                            continuation113.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                            continuation113.L$3 = SpillingKt.nullOutSpilledVariable(type);
                            continuation113.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                            continuation113.L$5 = SpillingKt.nullOutSpilledVariable(response);
                            continuation113.L$6 = SpillingKt.nullOutSpilledVariable(data);
                            continuation113.L$7 = SpillingKt.nullOutSpilledVariable(item);
                            continuation113.L$8 = SpillingKt.nullOutSpilledVariable(movieName2);
                            continuation113.label = 5;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(streamFlixProvider110, movieName2, url2, tvType111, movieLink, c000610, continuation113);
                            if (objNewMovieLoadResponse == obj3) {
                                return obj3;
                            }
                            data2 = data;
                            response2 = response;
                            headers2 = headers;
                            movieKey = str2;
                            movieKey2 = str;
                            item2 = item;
                            $result = objNewMovieLoadResponse;
                            movieName3 = movieName2;
                            return (LoadResponse) $result;
                        }
                        duration = item.getMovieDuration();
                        if (duration != null) {
                            data3 = data;
                            seasonMatch = Regex.find$default(new Regex("(\\d+)\\s+Season"), duration, 0, 2, (Object) null);
                            if (seasonMatch == null) {
                            }
                            if (intOrNull != null) {
                                break;
                            }
                            seasonCount = iIntValue;
                            Log.INSTANCE.d("StreamFlix", "TV Show has " + seasonCount + " seasons");
                            continuation3.L$0 = url2;
                            continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str);
                            continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                            continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                            continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                            continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response);
                            continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data3);
                            continuation3.L$7 = item;
                            continuation3.L$8 = movieName;
                            continuation3.I$0 = seasonCount;
                            continuation3.label = 3;
                            episodesFromWebSocket = getEpisodesFromWebSocket(str2, seasonCount, continuation3);
                            if (episodesFromWebSocket == obj) {
                                return obj;
                            }
                            data4 = data3;
                            str3 = str;
                            headers3 = headers;
                            response3 = response;
                            $result = episodesFromWebSocket;
                            List episodes14 = (List) $result;
                            String movieName17 = movieName;
                            StreamFlixProvider streamFlixProvider111 = this;
                            TvType tvType112 = TvType.TvSeries;
                            C00053 c000516 = new C00053(item, null);
                            continuation3.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                            continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                            continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                            continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                            continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                            continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response3);
                            continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data4);
                            continuation3.L$7 = SpillingKt.nullOutSpilledVariable(item);
                            continuation3.L$8 = SpillingKt.nullOutSpilledVariable(movieName17);
                            continuation3.L$9 = SpillingKt.nullOutSpilledVariable(episodes14);
                            continuation3.I$0 = seasonCount;
                            continuation3.label = 4;
                            obj4 = obj;
                            Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation114 = continuation3;
                            continuation3 = "StreamFlix";
                            $result = MainAPIKt.newTvSeriesLoadResponse(streamFlixProvider111, movieName17, url2, tvType112, episodes14, c000516, continuation114);
                            if ($result == obj4) {
                                return obj4;
                            }
                            str4 = str3;
                            movieKey3 = str2;
                            movieKey4 = type;
                            return (LoadResponse) $result;
                        }
                        data3 = data;
                        seasonCount = iIntValue;
                        Log.INSTANCE.d("StreamFlix", "TV Show has " + seasonCount + " seasons");
                        continuation3.L$0 = url2;
                        continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str);
                        continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                        continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                        continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                        continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response);
                        continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data3);
                        continuation3.L$7 = item;
                        continuation3.L$8 = movieName;
                        continuation3.I$0 = seasonCount;
                        continuation3.label = 3;
                        episodesFromWebSocket = getEpisodesFromWebSocket(str2, seasonCount, continuation3);
                        if (episodesFromWebSocket == obj) {
                            return obj;
                        }
                        data4 = data3;
                        str3 = str;
                        headers3 = headers;
                        response3 = response;
                        $result = episodesFromWebSocket;
                        List episodes15 = (List) $result;
                        String movieName18 = movieName;
                        StreamFlixProvider streamFlixProvider112 = this;
                        TvType tvType113 = TvType.TvSeries;
                        C00053 c000517 = new C00053(item, null);
                        continuation3.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                        continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                        continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                        continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                        continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response3);
                        continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data4);
                        continuation3.L$7 = SpillingKt.nullOutSpilledVariable(item);
                        continuation3.L$8 = SpillingKt.nullOutSpilledVariable(movieName18);
                        continuation3.L$9 = SpillingKt.nullOutSpilledVariable(episodes15);
                        continuation3.I$0 = seasonCount;
                        continuation3.label = 4;
                        obj4 = obj;
                        Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation115 = continuation3;
                        continuation3 = "StreamFlix";
                        $result = MainAPIKt.newTvSeriesLoadResponse(streamFlixProvider112, movieName18, url2, tvType113, episodes15, c000517, continuation115);
                        if ($result == obj4) {
                            return obj4;
                        }
                        str4 = str3;
                        movieKey3 = str2;
                        movieKey4 = type;
                        return (LoadResponse) $result;
                    } while (!Intrinsics.areEqual(it2.getMovieKey(), str2));
                    streamFlixItem = (StreamFlixItem) next;
                    if (streamFlixItem != null) {
                        throw new Exception("Movie not found");
                    }
                    item = streamFlixItem;
                    movieName = item.getMovieName();
                    if (movieName == null) {
                        movieName = "Unknown Title";
                    } else {
                        if (StringsKt.isBlank(movieName)) {
                            movieName = null;
                        }
                        if (movieName == null) {
                            movieName = "Unknown Title";
                        }
                    }
                    if (!item.isTV()) {
                        obj3 = obj;
                        Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation116 = continuation3;
                        movieName2 = movieName;
                        StreamFlixProvider streamFlixProvider113 = this;
                        TvType tvType114 = TvType.Movie;
                        movieLink = item.getMovieLink();
                        if (movieLink == null) {
                            movieLink = "";
                        }
                        C00064 c000611 = new C00064(item, null);
                        continuation116.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        continuation116.L$1 = SpillingKt.nullOutSpilledVariable(str);
                        continuation116.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                        continuation116.L$3 = SpillingKt.nullOutSpilledVariable(type);
                        continuation116.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                        continuation116.L$5 = SpillingKt.nullOutSpilledVariable(response);
                        continuation116.L$6 = SpillingKt.nullOutSpilledVariable(data);
                        continuation116.L$7 = SpillingKt.nullOutSpilledVariable(item);
                        continuation116.L$8 = SpillingKt.nullOutSpilledVariable(movieName2);
                        continuation116.label = 5;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(streamFlixProvider113, movieName2, url2, tvType114, movieLink, c000611, continuation116);
                        if (objNewMovieLoadResponse == obj3) {
                            return obj3;
                        }
                        data2 = data;
                        response2 = response;
                        headers2 = headers;
                        movieKey = str2;
                        movieKey2 = str;
                        item2 = item;
                        $result = objNewMovieLoadResponse;
                        movieName3 = movieName2;
                        return (LoadResponse) $result;
                    }
                    duration = item.getMovieDuration();
                    if (duration != null) {
                        data3 = data;
                        seasonMatch = Regex.find$default(new Regex("(\\d+)\\s+Season"), duration, 0, 2, (Object) null);
                        if (seasonMatch == null) {
                        }
                        if (intOrNull != null) {
                            break;
                        }
                        seasonCount = iIntValue;
                        Log.INSTANCE.d("StreamFlix", "TV Show has " + seasonCount + " seasons");
                        continuation3.L$0 = url2;
                        continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str);
                        continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                        continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                        continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                        continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response);
                        continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data3);
                        continuation3.L$7 = item;
                        continuation3.L$8 = movieName;
                        continuation3.I$0 = seasonCount;
                        continuation3.label = 3;
                        episodesFromWebSocket = getEpisodesFromWebSocket(str2, seasonCount, continuation3);
                        if (episodesFromWebSocket == obj) {
                            return obj;
                        }
                        data4 = data3;
                        str3 = str;
                        headers3 = headers;
                        response3 = response;
                        $result = episodesFromWebSocket;
                        List episodes16 = (List) $result;
                        String movieName19 = movieName;
                        StreamFlixProvider streamFlixProvider114 = this;
                        TvType tvType115 = TvType.TvSeries;
                        C00053 c000518 = new C00053(item, null);
                        continuation3.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                        continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                        continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                        continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                        continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response3);
                        continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data4);
                        continuation3.L$7 = SpillingKt.nullOutSpilledVariable(item);
                        continuation3.L$8 = SpillingKt.nullOutSpilledVariable(movieName19);
                        continuation3.L$9 = SpillingKt.nullOutSpilledVariable(episodes16);
                        continuation3.I$0 = seasonCount;
                        continuation3.label = 4;
                        obj4 = obj;
                        Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation117 = continuation3;
                        continuation3 = "StreamFlix";
                        $result = MainAPIKt.newTvSeriesLoadResponse(streamFlixProvider114, movieName19, url2, tvType115, episodes16, c000518, continuation117);
                        if ($result == obj4) {
                            return obj4;
                        }
                        str4 = str3;
                        movieKey3 = str2;
                        movieKey4 = type;
                        return (LoadResponse) $result;
                    }
                    data3 = data;
                    seasonCount = iIntValue;
                    Log.INSTANCE.d("StreamFlix", "TV Show has " + seasonCount + " seasons");
                    continuation3.L$0 = url2;
                    continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                    continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                    continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                    continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response);
                    continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data3);
                    continuation3.L$7 = item;
                    continuation3.L$8 = movieName;
                    continuation3.I$0 = seasonCount;
                    continuation3.label = 3;
                    episodesFromWebSocket = getEpisodesFromWebSocket(str2, seasonCount, continuation3);
                    if (episodesFromWebSocket == obj) {
                        return obj;
                    }
                    data4 = data3;
                    str3 = str;
                    headers3 = headers;
                    response3 = response;
                    $result = episodesFromWebSocket;
                    List episodes17 = (List) $result;
                    String movieName110 = movieName;
                    StreamFlixProvider streamFlixProvider115 = this;
                    TvType tvType116 = TvType.TvSeries;
                    C00053 c000519 = new C00053(item, null);
                    continuation3.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                    continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                    continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                    continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                    continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response3);
                    continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data4);
                    continuation3.L$7 = SpillingKt.nullOutSpilledVariable(item);
                    continuation3.L$8 = SpillingKt.nullOutSpilledVariable(movieName110);
                    continuation3.L$9 = SpillingKt.nullOutSpilledVariable(episodes17);
                    continuation3.I$0 = seasonCount;
                    continuation3.label = 4;
                    obj4 = obj;
                    Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation118 = continuation3;
                    continuation3 = "StreamFlix";
                    $result = MainAPIKt.newTvSeriesLoadResponse(streamFlixProvider115, movieName110, url2, tvType116, episodes17, c000519, continuation118);
                    if ($result == obj4) {
                        return obj4;
                    }
                    str4 = str3;
                    movieKey3 = str2;
                    movieKey4 = type;
                    return (LoadResponse) $result;
                } catch (Exception e14) {
                    e = e14;
                    continuation3 = "StreamFlix";
                }
                Log.INSTANCE.e(continuation3, "Error in load: " + e.getMessage());
                throw new Exception("Failed to load content: " + e.getMessage());
            case 3:
                int seasonCount2 = continuation2.I$0;
                movieName = (String) continuation2.L$8;
                StreamFlixItem item3 = (StreamFlixItem) continuation2.L$7;
                StreamFlixData data5 = (StreamFlixData) continuation2.L$6;
                response3 = (NiceResponse) continuation2.L$5;
                headers3 = (Map) continuation2.L$4;
                String type3 = (String) continuation2.L$3;
                String movieKey6 = (String) continuation2.L$2;
                String str8 = (String) continuation2.L$1;
                url2 = (String) continuation2.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    continuation3 = continuation2;
                    obj = coroutine_suspended;
                    data4 = data5;
                    type = type3;
                    seasonCount = seasonCount2;
                    item = item3;
                    str3 = str8;
                    str2 = movieKey6;
                    List episodes18 = (List) $result;
                    String movieName111 = movieName;
                    StreamFlixProvider streamFlixProvider116 = this;
                    TvType tvType117 = TvType.TvSeries;
                    C00053 c0005110 = new C00053(item, null);
                    continuation3.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    continuation3.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                    continuation3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                    continuation3.L$3 = SpillingKt.nullOutSpilledVariable(type);
                    continuation3.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                    continuation3.L$5 = SpillingKt.nullOutSpilledVariable(response3);
                    continuation3.L$6 = SpillingKt.nullOutSpilledVariable(data4);
                    continuation3.L$7 = SpillingKt.nullOutSpilledVariable(item);
                    continuation3.L$8 = SpillingKt.nullOutSpilledVariable(movieName111);
                    continuation3.L$9 = SpillingKt.nullOutSpilledVariable(episodes18);
                    continuation3.I$0 = seasonCount;
                    continuation3.label = 4;
                    obj4 = obj;
                    Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation119 = continuation3;
                    continuation3 = "StreamFlix";
                    $result = MainAPIKt.newTvSeriesLoadResponse(streamFlixProvider116, movieName111, url2, tvType117, episodes18, c0005110, continuation119);
                    if ($result == obj4) {
                        return obj4;
                    }
                    str4 = str3;
                    movieKey3 = str2;
                    movieKey4 = type;
                    return (LoadResponse) $result;
                } catch (Exception e15) {
                    e = e15;
                    continuation3 = "StreamFlix";
                }
                break;
            case 4:
                int i2 = continuation2.I$0;
                movieKey4 = (String) continuation2.L$3;
                movieKey3 = (String) continuation2.L$2;
                str4 = (String) continuation2.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    continuation3 = "StreamFlix";
                    return (LoadResponse) $result;
                } catch (Exception e16) {
                    e = e16;
                    continuation3 = "StreamFlix";
                }
                break;
            case 5:
                movieName3 = (String) continuation2.L$8;
                item2 = (StreamFlixItem) continuation2.L$7;
                data2 = (StreamFlixData) continuation2.L$6;
                response2 = (NiceResponse) continuation2.L$5;
                headers2 = (Map) continuation2.L$4;
                String type4 = (String) continuation2.L$3;
                movieKey = (String) continuation2.L$2;
                movieKey2 = (String) continuation2.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    type = type4;
                    return (LoadResponse) $result;
                } catch (Exception e17) {
                    e = e17;
                    continuation3 = "StreamFlix";
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.cncverse.StreamFlixProvider$load$2 */
    /* JADX INFO: compiled from: StreamFlixProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.StreamFlixProvider$load$2", f = "StreamFlixProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00042 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00042(Continuation<? super C00042> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = new C00042(continuation);
            c00042.L$0 = obj;
            return c00042;
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
                    $this$newMovieLoadResponse.setPlot("The StreamFlix service is currently unavailable. Please try again later.");
                    $this$newMovieLoadResponse.setYear(Boxing.boxInt(2024));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.cncverse.StreamFlixProvider$load$3 */
    /* JADX INFO: compiled from: StreamFlixProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.StreamFlixProvider$load$3", f = "StreamFlixProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamFlixProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamFlixProvider.kt\ncom/cncverse/StreamFlixProvider$load$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,802:1\n1#2:803\n*E\n"})
    static final class C00053 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ StreamFlixItem $item;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00053(StreamFlixItem streamFlixItem, Continuation<? super C00053> continuation) {
            super(2, continuation);
            this.$item = streamFlixItem;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00053 = new C00053(this.$item, continuation);
            c00053.L$0 = obj;
            return c00053;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            List listEmptyList;
            TvSeriesLoadResponse $this$newTvSeriesLoadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String it = this.$item.getMoviePoster();
                    $this$newTvSeriesLoadResponse.setPosterUrl(it != null ? "https://image.tmdb.org/t/p/w500/" + it : null);
                    String it2 = this.$item.getMovieBanner();
                    $this$newTvSeriesLoadResponse.setBackgroundPosterUrl(it2 != null ? "https://image.tmdb.org/t/p/original/" + it2 : null);
                    String movieYear = this.$item.getMovieYear();
                    $this$newTvSeriesLoadResponse.setYear(movieYear != null ? StringsKt.toIntOrNull(movieYear) : null);
                    $this$newTvSeriesLoadResponse.setPlot(this.$item.getMovieDesc());
                    String movieInfo = this.$item.getMovieInfo();
                    if (movieInfo == null || (listEmptyList = StringsKt.split$default(movieInfo, new String[]{"/"}, false, 0, 6, (Object) null)) == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    $this$newTvSeriesLoadResponse.setTags(listEmptyList);
                    $this$newTvSeriesLoadResponse.setScore(Score.Companion.from10(Boxing.boxDouble(this.$item.getMovieRating())));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.cncverse.StreamFlixProvider$load$4 */
    /* JADX INFO: compiled from: StreamFlixProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.StreamFlixProvider$load$4", f = "StreamFlixProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamFlixProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamFlixProvider.kt\ncom/cncverse/StreamFlixProvider$load$4\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,802:1\n1#2:803\n*E\n"})
    static final class C00064 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ StreamFlixItem $item;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00064(StreamFlixItem streamFlixItem, Continuation<? super C00064> continuation) {
            super(2, continuation);
            this.$item = streamFlixItem;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00064 = new C00064(this.$item, continuation);
            c00064.L$0 = obj;
            return c00064;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            List listEmptyList;
            MovieLoadResponse $this$newMovieLoadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String it = this.$item.getMoviePoster();
                    $this$newMovieLoadResponse.setPosterUrl(it != null ? "https://image.tmdb.org/t/p/w500/" + it : null);
                    String it2 = this.$item.getMovieBanner();
                    $this$newMovieLoadResponse.setBackgroundPosterUrl(it2 != null ? "https://image.tmdb.org/t/p/original/" + it2 : null);
                    String movieYear = this.$item.getMovieYear();
                    $this$newMovieLoadResponse.setYear(movieYear != null ? StringsKt.toIntOrNull(movieYear) : null);
                    $this$newMovieLoadResponse.setPlot(this.$item.getMovieDesc());
                    String movieInfo = this.$item.getMovieInfo();
                    if (movieInfo == null || (listEmptyList = StringsKt.split$default(movieInfo, new String[]{"/"}, false, 0, 6, (Object) null)) == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    $this$newMovieLoadResponse.setTags(listEmptyList);
                    $this$newMovieLoadResponse.setScore(Score.Companion.from10(Boxing.boxDouble(this.$item.getMovieRating())));
                    $this$newMovieLoadResponse.setRecommendations(CollectionsKt.emptyList());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:24:0x007e A[Catch: Exception -> 0x0157, TryCatch #3 {Exception -> 0x0157, blocks: (B:21:0x006c, B:22:0x0078, B:24:0x007e, B:25:0x00a1, B:27:0x00a7), top: B:61:0x006c }] */
    /* JADX WARN: Code duplicated, block: B:27:0x00a7 A[Catch: Exception -> 0x0157, TRY_LEAVE, TryCatch #3 {Exception -> 0x0157, blocks: (B:21:0x006c, B:22:0x0078, B:24:0x007e, B:25:0x00a1, B:27:0x00a7), top: B:61:0x006c }] */
    /* JADX WARN: Code duplicated, block: B:37:0x010b A[Catch: Exception -> 0x0155, TryCatch #4 {Exception -> 0x0155, blocks: (B:31:0x00d7, B:35:0x00ff, B:37:0x010b, B:43:0x011b), top: B:63:0x00d7 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0116  */
    /* JADX WARN: Code duplicated, block: B:43:0x011b A[Catch: Exception -> 0x0155, TRY_LEAVE, TryCatch #4 {Exception -> 0x0155, blocks: (B:31:0x00d7, B:35:0x00ff, B:37:0x010b, B:43:0x011b), top: B:63:0x00d7 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    public final Object getEpisodesFromWebSocket(String movieKey, int totalSeasons, Continuation<? super List<com.lagradost.cloudstream3.Episode>> continuation) {
        C00011 c00011;
        ArrayList episodes;
        int totalSeasons2;
        Object episodesFromWebSocket;
        Map $this$forEach$iv;
        final int season;
        final int episode;
        final int seasonNumber;
        StreamFlixProvider streamFlixProvider = this;
        String movieKey2 = movieKey;
        int totalSeasons3 = totalSeasons;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
            } else {
                c00011 = streamFlixProvider.new C00011(continuation);
            }
        } else {
            c00011 = streamFlixProvider.new C00011(continuation);
        }
        C00011 c00012 = c00011;
        Object $result = c00012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00012.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                episodes = new ArrayList();
                try {
                    StreamFlixWebSocketExtractor streamFlixWebSocketExtractor = streamFlixProvider.webSocketExtractor;
                    c00012.L$0 = movieKey2;
                    c00012.L$1 = episodes;
                    c00012.I$0 = totalSeasons3;
                    c00012.label = 1;
                    episodesFromWebSocket = streamFlixWebSocketExtractor.getEpisodesFromWebSocket(movieKey2, totalSeasons3, c00012);
                    if (episodesFromWebSocket == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    try {
                        Map seasonsData = (Map) episodesFromWebSocket;
                        $this$forEach$iv = seasonsData;
                        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                            seasonNumber = ((Number) element$iv.getKey()).intValue();
                            Map episodesMap = (Map) element$iv.getValue();
                            for (Map.Entry element$iv2 : episodesMap.entrySet()) {
                                final int episodeKey = ((Number) element$iv2.getKey()).intValue();
                                final StreamFlixWebSocketExtractor.EpisodeData episodeData = (StreamFlixWebSocketExtractor.EpisodeData) element$iv2.getValue();
                                Map $this$forEach$iv2 = $this$forEach$iv;
                                totalSeasons2 = totalSeasons3;
                                try {
                                    C00011 c00013 = c00012;
                                    try {
                                        episodes.add(MainAPIKt.newEpisode(streamFlixProvider, episodeData.getLink(), new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda1
                                            public final Object invoke(Object obj) {
                                                return StreamFlixProvider.getEpisodesFromWebSocket$lambda$0$0$0(episodeData, seasonNumber, episodeKey, (Episode) obj);
                                            }
                                        }));
                                        streamFlixProvider = this;
                                        $this$forEach$iv = $this$forEach$iv2;
                                        totalSeasons3 = totalSeasons2;
                                        c00012 = c00013;
                                    } catch (Exception e) {
                                        e = e;
                                        Log.INSTANCE.e("StreamFlix", "Error getting episodes: " + e.getMessage());
                                        return episodes;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    Log.INSTANCE.e("StreamFlix", "Error getting episodes: " + e.getMessage());
                                    return episodes;
                                }
                            }
                            streamFlixProvider = this;
                        }
                        totalSeasons2 = totalSeasons3;
                        if (episodes.isEmpty()) {
                            Log.INSTANCE.w("StreamFlix", "WebSocket failed, using fallback episodes");
                            for (season = 1; season < 3; season++) {
                                for (episode = 1; episode < 7; episode++) {
                                    episodes.add(MainAPIKt.newEpisode(this, movieKey2 + "|s" + season + 'e' + episode, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda2
                                        public final Object invoke(Object obj) {
                                            return StreamFlixProvider.getEpisodesFromWebSocket$lambda$1(episode, season, (Episode) obj);
                                        }
                                    }));
                                }
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        totalSeasons2 = totalSeasons3;
                    }
                } catch (Exception e4) {
                    e = e4;
                    totalSeasons2 = totalSeasons3;
                    Log.INSTANCE.e("StreamFlix", "Error getting episodes: " + e.getMessage());
                    return episodes;
                }
                return episodes;
            case 1:
                totalSeasons3 = c00012.I$0;
                episodes = (List) c00012.L$1;
                movieKey2 = (String) c00012.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    episodesFromWebSocket = $result;
                    Map seasonsData2 = (Map) episodesFromWebSocket;
                    $this$forEach$iv = seasonsData2;
                    while (r11.hasNext()) {
                        seasonNumber = ((Number) element$iv.getKey()).intValue();
                        Map episodesMap2 = (Map) element$iv.getValue();
                        while (r18.hasNext()) {
                            final int episodeKey2 = ((Number) element$iv2.getKey()).intValue();
                            final StreamFlixWebSocketExtractor.EpisodeData episodeData2 = (StreamFlixWebSocketExtractor.EpisodeData) element$iv2.getValue();
                            Map $this$forEach$iv3 = $this$forEach$iv;
                            totalSeasons2 = totalSeasons3;
                            C00011 c00014 = c00012;
                            episodes.add(MainAPIKt.newEpisode(streamFlixProvider, episodeData2.getLink(), new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj) {
                                    return StreamFlixProvider.getEpisodesFromWebSocket$lambda$0$0$0(episodeData2, seasonNumber, episodeKey2, (Episode) obj);
                                }
                            }));
                            streamFlixProvider = this;
                            $this$forEach$iv = $this$forEach$iv3;
                            totalSeasons3 = totalSeasons2;
                            c00012 = c00014;
                        }
                        streamFlixProvider = this;
                    }
                    totalSeasons2 = totalSeasons3;
                    if (episodes.isEmpty()) {
                        Log.INSTANCE.w("StreamFlix", "WebSocket failed, using fallback episodes");
                        while (season < 3) {
                            while (episode < 7) {
                                episodes.add(MainAPIKt.newEpisode(this, movieKey2 + "|s" + season + 'e' + episode, new Function1() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj) {
                                        return StreamFlixProvider.getEpisodesFromWebSocket$lambda$1(episode, season, (Episode) obj);
                                    }
                                }));
                            }
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    totalSeasons2 = totalSeasons3;
                    Log.INSTANCE.e("StreamFlix", "Error getting episodes: " + e.getMessage());
                    return episodes;
                }
                return episodes;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static /* synthetic */ Object getEpisodesFromWebSocket$default(StreamFlixProvider streamFlixProvider, String str, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        return streamFlixProvider.getEpisodesFromWebSocket(str, i, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getEpisodesFromWebSocket$lambda$0$0$0(StreamFlixWebSocketExtractor.EpisodeData $episodeData, int $seasonNumber, int $episodeKey, com.lagradost.cloudstream3.Episode $this$newEpisode) {
        $this$newEpisode.setName($episodeData.getName());
        $this$newEpisode.setSeason(Integer.valueOf($seasonNumber));
        $this$newEpisode.setEpisode(Integer.valueOf($episodeKey + 1));
        $this$newEpisode.setDescription($episodeData.getOverview());
        String it = $episodeData.getStillPath();
        $this$newEpisode.setPosterUrl(it != null ? "https://image.tmdb.org/t/p/w500/" + it : null);
        $this$newEpisode.setScore(Score.Companion.from10(Double.valueOf($episodeData.getVoteAverage())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getEpisodesFromWebSocket$lambda$1(int $episode, int $season, com.lagradost.cloudstream3.Episode $this$newEpisode) {
        $this$newEpisode.setName("Episode " + $episode);
        $this$newEpisode.setSeason(Integer.valueOf($season));
        $this$newEpisode.setEpisode(Integer.valueOf($episode));
        $this$newEpisode.setDescription("Episode " + $episode + " of Season " + $season);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x03da A[Catch: Exception -> 0x0628, TRY_LEAVE, TryCatch #16 {Exception -> 0x0628, blocks: (B:101:0x03d4, B:103:0x03da), top: B:309:0x03d4 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x0468 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:112:0x0469  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Not initialized variable reg: 20, insn: 0x027b: MOVE (r3 I:??[OBJECT, ARRAY]) = (r20 I:??[OBJECT, ARRAY] A[D('str' java.lang.String)]), block:B:34:0x0271 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:112:0x0469 -> B:323:0x047c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:135:0x057a -> B:317:0x058e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:182:0x07eb -> B:291:0x080a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:219:0x096f -> B:325:0x0980). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:240:0x0a6d -> B:345:0x0a83). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r37, boolean r38, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r39, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r40, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r41) {
        /*
            Method dump skipped, instruction units count: 2988
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.StreamFlixProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
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
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    StreamFlixProvider.showSubscriptionPopupIfNeeded$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StreamFlixProvider.showSubscriptionPopupIfNeeded$lambda$0$11($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249, $ctx, dialog, view);
                }
            });
            subscribeTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StreamFlixProvider.showSubscriptionPopupIfNeeded$lambda$0$12(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                StreamFlixProvider.showTelegramPopup$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            joinTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StreamFlixProvider.showTelegramPopup$lambda$0$9(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.StreamFlixProvider$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                StreamFlixProvider.openInExternalBrowser$lambda$0(ctx, url);
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
