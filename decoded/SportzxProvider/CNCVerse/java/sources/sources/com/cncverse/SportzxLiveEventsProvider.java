package com.cncverse;

import android.content.Context;
import android.util.Base64;
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
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SportzxLiveEventsProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/SportzxProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ?2\u00020\u0001:\u0002?@B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H\u0002J\u001e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0096@¢\u0006\u0002\u0010,J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u00101J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u00101JF\u00105\u001a\u00020\u00132\u0006\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00132\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;092\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020;09H\u0096@¢\u0006\u0002\u0010>R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u001a\u0010\u000f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/cncverse/SportzxLiveEventsProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "name", "", "customLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getCustomLink", "mainUrl", "getMainUrl", "setMainUrl", "lang", "getLang", "setLang", "hasMainPage", "", "getHasMainPage", "()Z", "hasChromecastSupport", "getHasChromecastSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "client", "Lokhttp3/OkHttpClient;", "createDisplayTitle", "event", "Lcom/cncverse/SportzxLiveEventData;", "getEventStatus", "isEventLive", "isEventEnded", "generateMatchCardUrl", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "SportzxLoadData", "SportzxProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSportzxLiveEventsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportzxLiveEventsProvider.kt\ncom/cncverse/SportzxLiveEventsProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 7 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 8 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,528:1\n1#2:529\n1#2:561\n1#2:580\n1#2:599\n1512#3:530\n1538#3,3:531\n1541#3,3:541\n1586#3:547\n1661#3,3:548\n1068#3:552\n777#3:553\n873#3,2:554\n1586#3:556\n1661#3,3:557\n1915#3:617\n1915#3,2:618\n1916#3:622\n1586#3:623\n1661#3,3:624\n383#4,7:534\n129#5:544\n158#5,2:545\n160#5:551\n63#6:560\n64#6,15:562\n63#6:579\n64#6,15:581\n63#6:598\n64#6,15:600\n50#7:577\n43#7:578\n50#7:596\n43#7:597\n50#7:615\n43#7:616\n1088#8,2:620\n*S KotlinDebug\n*F\n+ 1 SportzxLiveEventsProvider.kt\ncom/cncverse/SportzxLiveEventsProvider\n*L\n288#1:561\n321#1:580\n331#1:599\n171#1:530\n171#1:531,3\n171#1:541,3\n207#1:547\n207#1:548,3\n234#1:552\n255#1:553\n255#1:554,2\n262#1:556\n262#1:557,3\n339#1:617\n349#1:618,2\n339#1:622\n441#1:623\n441#1:624,3\n171#1:534,7\n173#1:544\n173#1:545,2\n173#1:551\n288#1:560\n288#1:562,15\n321#1:579\n321#1:581,15\n331#1:598\n331#1:600,15\n288#1:577\n288#1:578\n321#1:596\n321#1:597\n331#1:615\n331#1:616\n422#1:620,2\n*E\n"})
public final class SportzxLiveEventsProvider extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static Context context;

    @NotNull
    private final OkHttpClient client;

    @Nullable
    private final String customLink;
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

    /* JADX INFO: renamed from: com.cncverse.SportzxLiveEventsProvider$getMainPage$1 */
    /* JADX INFO: compiled from: SportzxLiveEventsProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.SportzxLiveEventsProvider", f = "SportzxLiveEventsProvider.kt", i = {0, 0, 1, 1}, l = {166, 168}, m = "getMainPage", n = {"request", "page", "request", "page"}, nl = {168, 165}, s = {"L$0", "I$0", "L$0", "I$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SportzxLiveEventsProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.SportzxLiveEventsProvider$loadLinks$1 */
    /* JADX INFO: compiled from: SportzxLiveEventsProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.SportzxLiveEventsProvider", f = "SportzxLiveEventsProvider.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {324, 450, 466, 475, 490, 508}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "loadData", "isCasting", "data", "subtitleCallback", "callback", "loadData", "streamJson", "streams", "$this$forEach$iv", "element$iv", "stream", "link", "serverName", "parts", "url", "headers", "decryptedApi", "drmParts", "kidHex", "keyHex", "kidB64", "keyB64", "isCasting", "$i$f$forEach", "$i$a$-forEach-SportzxLiveEventsProvider$loadLinks$2", "data", "subtitleCallback", "callback", "loadData", "streamJson", "streams", "$this$forEach$iv", "element$iv", "stream", "link", "serverName", "parts", "url", "headers", "decryptedApi", "drmParts", "kidHex", "keyHex", "kidB64", "keyB64", "isCasting", "$i$f$forEach", "$i$a$-forEach-SportzxLiveEventsProvider$loadLinks$2", "data", "subtitleCallback", "callback", "loadData", "streamJson", "streams", "$this$forEach$iv", "element$iv", "stream", "link", "serverName", "parts", "url", "headers", "decryptedApi", "drmParts", "isCasting", "$i$f$forEach", "$i$a$-forEach-SportzxLiveEventsProvider$loadLinks$2", "data", "subtitleCallback", "callback", "loadData", "streamJson", "streams", "$this$forEach$iv", "element$iv", "stream", "link", "serverName", "parts", "url", "headers", "finalHeaders", "isCasting", "$i$f$forEach", "$i$a$-forEach-SportzxLiveEventsProvider$loadLinks$2", "data", "subtitleCallback", "callback", "loadData", "streamJson", "streams", "$this$forEach$iv", "element$iv", "stream", "link", "serverName", "parts", "url", "headers", "finalHeaders", "isCasting", "$i$f$forEach", "$i$a$-forEach-SportzxLiveEventsProvider$loadLinks$2"}, nl = {325, 449, 465, 474, 489, 507}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "Z$0", "I$0", "I$1"}, v = 2)
    static final class C00061 extends ContinuationImpl {
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
        Object L$20;
        Object L$21;
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

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SportzxLiveEventsProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.SportzxLiveEventsProvider$search$1 */
    /* JADX INFO: compiled from: SportzxLiveEventsProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.SportzxLiveEventsProvider", f = "SportzxLiveEventsProvider.kt", i = {0, 1}, l = {251, 253}, m = "search", n = {"query", "query"}, nl = {253, 250}, s = {"L$0", "L$0"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SportzxLiveEventsProvider.this.search(null, (Continuation) this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SportzxLiveEventsProvider() {
        String str = null;
        this(str, str, 3, str);
    }

    public SportzxLiveEventsProvider(@NotNull String name, @Nullable String customLink) {
        this.name = name;
        this.customLink = customLink;
        this.mainUrl = "https://sportzx.live";
        this.lang = "ta";
        this.hasMainPage = true;
        this.hasChromecastSupport = true;
        this.supportedTypes = SetsKt.setOf(TvType.Live);
        this.client = new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).build();
    }

    public /* synthetic */ SportzxLiveEventsProvider(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "⚡SportzX Live Events" : str, (i & 2) != 0 ? null : str2);
    }

    @Nullable
    public final String getCustomLink() {
        return this.customLink;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    /* JADX INFO: compiled from: SportzxLiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/cncverse/SportzxLiveEventsProvider$Companion;", "", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "SportzxProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Context getContext() {
            return SportzxLiveEventsProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            SportzxLiveEventsProvider.context = context;
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

    /* JADX INFO: compiled from: SportzxLiveEventsProvider.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/cncverse/SportzxLiveEventsProvider$SportzxLoadData;", "", "eventId", "", "title", "", "poster", "cat", "formats", "", "Lcom/cncverse/SportzxLiveEventFormat;", "eventInfo", "Lcom/cncverse/SportzxLiveEventInfo;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/cncverse/SportzxLiveEventInfo;)V", "getEventId", "()I", "getTitle", "()Ljava/lang/String;", "getPoster", "getCat", "getFormats", "()Ljava/util/List;", "getEventInfo", "()Lcom/cncverse/SportzxLiveEventInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "SportzxProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SportzxLoadData {

        @Nullable
        private final String cat;
        private final int eventId;

        @Nullable
        private final SportzxLiveEventInfo eventInfo;

        @NotNull
        private final List<SportzxLiveEventFormat> formats;

        @NotNull
        private final String poster;

        @NotNull
        private final String title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SportzxLoadData copy$default(SportzxLoadData sportzxLoadData, int i, String str, String str2, String str3, List list, SportzxLiveEventInfo sportzxLiveEventInfo, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = sportzxLoadData.eventId;
            }
            if ((i2 & 2) != 0) {
                str = sportzxLoadData.title;
            }
            if ((i2 & 4) != 0) {
                str2 = sportzxLoadData.poster;
            }
            if ((i2 & 8) != 0) {
                str3 = sportzxLoadData.cat;
            }
            if ((i2 & 16) != 0) {
                list = sportzxLoadData.formats;
            }
            if ((i2 & 32) != 0) {
                sportzxLiveEventInfo = sportzxLoadData.eventInfo;
            }
            List list2 = list;
            SportzxLiveEventInfo sportzxLiveEventInfo2 = sportzxLiveEventInfo;
            return sportzxLoadData.copy(i, str, str2, str3, list2, sportzxLiveEventInfo2);
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

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getCat() {
            return this.cat;
        }

        @NotNull
        public final List<SportzxLiveEventFormat> component5() {
            return this.formats;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final SportzxLiveEventInfo getEventInfo() {
            return this.eventInfo;
        }

        @NotNull
        public final SportzxLoadData copy(int eventId, @NotNull String title, @NotNull String poster, @Nullable String cat, @NotNull List<SportzxLiveEventFormat> formats, @Nullable SportzxLiveEventInfo eventInfo) {
            return new SportzxLoadData(eventId, title, poster, cat, formats, eventInfo);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SportzxLoadData)) {
                return false;
            }
            SportzxLoadData sportzxLoadData = (SportzxLoadData) other;
            return this.eventId == sportzxLoadData.eventId && Intrinsics.areEqual(this.title, sportzxLoadData.title) && Intrinsics.areEqual(this.poster, sportzxLoadData.poster) && Intrinsics.areEqual(this.cat, sportzxLoadData.cat) && Intrinsics.areEqual(this.formats, sportzxLoadData.formats) && Intrinsics.areEqual(this.eventInfo, sportzxLoadData.eventInfo);
        }

        public int hashCode() {
            return (((((((((this.eventId * 31) + this.title.hashCode()) * 31) + this.poster.hashCode()) * 31) + (this.cat == null ? 0 : this.cat.hashCode())) * 31) + this.formats.hashCode()) * 31) + (this.eventInfo != null ? this.eventInfo.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "SportzxLoadData(eventId=" + this.eventId + ", title=" + this.title + ", poster=" + this.poster + ", cat=" + this.cat + ", formats=" + this.formats + ", eventInfo=" + this.eventInfo + ')';
        }

        public SportzxLoadData(int eventId, @NotNull String title, @NotNull String poster, @Nullable String cat, @NotNull List<SportzxLiveEventFormat> list, @Nullable SportzxLiveEventInfo eventInfo) {
            this.eventId = eventId;
            this.title = title;
            this.poster = poster;
            this.cat = cat;
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

        @Nullable
        public final String getCat() {
            return this.cat;
        }

        @NotNull
        public final List<SportzxLiveEventFormat> getFormats() {
            return this.formats;
        }

        @Nullable
        public final SportzxLiveEventInfo getEventInfo() {
            return this.eventInfo;
        }
    }

    private final String createDisplayTitle(SportzxLiveEventData event) {
        SportzxLiveEventInfo info = event.getEventInfo();
        if (info != null) {
            String teamA = info.getTeamA();
            if (!(teamA == null || StringsKt.isBlank(teamA))) {
                String teamB = info.getTeamB();
                if (!(teamB == null || StringsKt.isBlank(teamB))) {
                    return Intrinsics.areEqual(info.getTeamA(), info.getTeamB()) ? info.getTeamA() : info.getTeamA() + " vs " + info.getTeamB();
                }
            }
        }
        return event.getTitle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getEventStatus(SportzxLiveEventData event) {
        Date date;
        Date date2;
        SportzxLiveEventInfo info = event.getEventInfo();
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

    private final boolean isEventLive(SportzxLiveEventData event) {
        Date date;
        Date date2;
        SportzxLiveEventInfo info = event.getEventInfo();
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

    private final boolean isEventEnded(SportzxLiveEventData event) {
        Date date;
        SportzxLiveEventInfo info = event.getEventInfo();
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

    /* JADX WARN: Code duplicated, block: B:53:0x009c  */
    private final String generateMatchCardUrl(SportzxLiveEventData event) throws UnsupportedEncodingException {
        String title;
        String teamA;
        String teamB;
        String teamAFlag;
        String teamBFlag;
        String eventLogo;
        String it;
        SportzxLiveEventInfo info = event.getEventInfo();
        if (info == null || (title = info.getEventName()) == null) {
            title = event.getTitle();
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
        String time = "";
        if (info == null || (teamAFlag = info.getTeamAFlag()) == null) {
            teamAFlag = "";
        }
        String teamAImg = teamAFlag;
        if (info == null || (teamBFlag = info.getTeamBFlag()) == null) {
            teamBFlag = "";
        }
        String teamBImg = teamBFlag;
        if (info == null || (eventLogo = info.getEventLogo()) == null) {
            eventLogo = "";
        }
        String eventLogo2 = eventLogo;
        boolean isLive = isEventLive(event);
        boolean isEnded = isEventEnded(event);
        if (info != null) {
            try {
                String it2 = info.getStartTime();
                if (it2 != null) {
                    SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                    try {
                        SimpleDateFormat disp = new SimpleDateFormat("MMM dd, yyyy hh:mm a", Locale.US);
                        Date d = df.parse(it2);
                        if (d == null || (it = URLEncoder.encode(disp.format(d), "UTF-8")) == null) {
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
    /* JADX WARN: Code duplicated, block: B:100:0x0259  */
    /* JADX WARN: Code duplicated, block: B:111:0x025d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:33:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:44:0x0115  */
    /* JADX WARN: Code duplicated, block: B:47:0x0140  */
    /* JADX WARN: Code duplicated, block: B:50:0x0149  */
    /* JADX WARN: Code duplicated, block: B:51:0x014d  */
    /* JADX WARN: Code duplicated, block: B:54:0x0156  */
    /* JADX WARN: Code duplicated, block: B:55:0x015a  */
    /* JADX WARN: Code duplicated, block: B:58:0x0163  */
    /* JADX WARN: Code duplicated, block: B:61:0x016c  */
    /* JADX WARN: Code duplicated, block: B:62:0x016f  */
    /* JADX WARN: Code duplicated, block: B:65:0x0178  */
    /* JADX WARN: Code duplicated, block: B:66:0x017b  */
    /* JADX WARN: Code duplicated, block: B:70:0x0185  */
    /* JADX WARN: Code duplicated, block: B:73:0x018e  */
    /* JADX WARN: Code duplicated, block: B:74:0x0191  */
    /* JADX WARN: Code duplicated, block: B:77:0x019a  */
    /* JADX WARN: Code duplicated, block: B:78:0x019d  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:81:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:82:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:85:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:86:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:90:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:94:0x0200  */
    /* JADX WARN: Code duplicated, block: B:96:0x0220  */
    /* JADX WARN: Code duplicated, block: B:97:0x023c  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws UnsupportedEncodingException {
        C00031 c00031;
        Object objFetchLiveEvents$default;
        MainPageRequest request2;
        Object objFetchLiveEvents;
        List events;
        Map grouped;
        Map $this$map$iv;
        Collection destination$iv$iv;
        String lowerCase;
        String str;
        Iterable $this$map$iv2;
        Collection destination$iv$iv2;
        Iterable $this$mapTo$iv$iv;
        Iterator it;
        Iterable $this$map$iv3;
        String displayTitle;
        String status;
        String status2;
        List<SportzxLiveEventFormat> formats;
        SportzxLiveEventInfo eventInfo;
        String str2;
        Object value$iv$iv$iv;
        Object answer$iv$iv$iv;
        int page2 = page;
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
        Object $result = c00031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00031.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DonationManager.INSTANCE.checkAndShow(getName());
                if (this.customLink == null) {
                    SportzxProviderManager sportzxProviderManager = SportzxProviderManager.INSTANCE;
                    c00031.L$0 = SpillingKt.nullOutSpilledVariable(request);
                    c00031.I$0 = page2;
                    c00031.label = 2;
                    objFetchLiveEvents$default = SportzxProviderManager.fetchLiveEvents$default(sportzxProviderManager, null, c00031, 1, null);
                    if (objFetchLiveEvents$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    request2 = request;
                    events = (List) objFetchLiveEvents$default;
                    List $this$groupBy$iv = events;
                    grouped = new LinkedHashMap();
                    for (Object element$iv$iv : $this$groupBy$iv) {
                        SportzxLiveEventData it2 = (SportzxLiveEventData) element$iv$iv;
                        eventInfo = it2.getEventInfo();
                        String cat = eventInfo != null ? "Other" : "Other";
                        str2 = cat;
                        value$iv$iv$iv = grouped.get(str2);
                        if (value$iv$iv$iv == null) {
                            Object answer$iv$iv$iv2 = (List) new ArrayList();
                            answer$iv$iv$iv = answer$iv$iv$iv2;
                            grouped.put(str2, answer$iv$iv$iv);
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
                        String category = (String) item$iv$iv.getKey();
                        List categoryEvents = (List) item$iv$iv.getValue();
                        Map $this$map$iv4 = $this$map$iv;
                        lowerCase = category.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        str = "🥊";
                        switch (lowerCase.hashCode()) {
                            case -1383120329:
                                if (!lowerCase.equals("boxing")) {
                                    str = "📺";
                                }
                                break;
                            case -1068313274:
                                if (lowerCase.equals("motogp")) {
                                    str = "🏍️";
                                } else {
                                    str = "📺";
                                }
                                break;
                            case -877324069:
                                if (lowerCase.equals("tennis")) {
                                    str = "🎾";
                                } else {
                                    str = "📺";
                                }
                                break;
                            case -654884904:
                                if (lowerCase.equals("ice hockey")) {
                                    str = "🏒";
                                } else {
                                    str = "📺";
                                }
                                break;
                            case 3211:
                                if (lowerCase.equals("f1")) {
                                    str = "🏎️";
                                } else {
                                    str = "📺";
                                }
                                break;
                            case 115698:
                                if (!lowerCase.equals("ufc")) {
                                    str = "📺";
                                }
                                break;
                            case 118149:
                                if (lowerCase.equals("wwe")) {
                                    str = "🤼";
                                } else {
                                    str = "📺";
                                }
                                break;
                            case 394668909:
                                if (lowerCase.equals("football")) {
                                    str = "⚽";
                                } else {
                                    str = "📺";
                                }
                                break;
                            case 400486431:
                                if (lowerCase.equals("motorsport")) {
                                    str = "🏎️";
                                } else {
                                    str = "📺";
                                }
                                break;
                            case 727149765:
                                if (lowerCase.equals("basketball")) {
                                    str = "🏀";
                                } else {
                                    str = "📺";
                                }
                                break;
                            case 1032299505:
                                if (lowerCase.equals("cricket")) {
                                    str = "🏏";
                                } else {
                                    str = "📺";
                                }
                                break;
                            default:
                                str = "📺";
                                break;
                        }
                        String icon = str;
                        C00031 c00032 = c00031;
                        final Comparator comparator = new Comparator() { // from class: com.cncverse.SportzxLiveEventsProvider$getMainPage$lambda$1$$inlined$compareBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                Integer num;
                                Integer num2;
                                SportzxLiveEventData event = (SportzxLiveEventData) t;
                                String status3 = this.this$0.getEventStatus(event);
                                if (StringsKt.contains$default(status3, "🔴", false, 2, (Object) null)) {
                                    num = (Comparable) 0;
                                } else if (StringsKt.contains$default(status3, "🔜", false, 2, (Object) null)) {
                                    num = (Comparable) 1;
                                } else {
                                    num = StringsKt.contains$default(status3, "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                                }
                                SportzxLiveEventData event2 = (SportzxLiveEventData) t2;
                                String status4 = this.this$0.getEventStatus(event2);
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
                        $this$map$iv2 = CollectionsKt.sortedWith(categoryEvents, new Comparator() { // from class: com.cncverse.SportzxLiveEventsProvider$getMainPage$lambda$1$$inlined$thenBy$1
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
                                SportzxLiveEventData event = (SportzxLiveEventData) t;
                                try {
                                    SportzxLiveEventInfo info = event.getEventInfo();
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
                                SportzxLiveEventData event2 = (SportzxLiveEventData) t2;
                                try {
                                    SportzxLiveEventInfo info2 = event2.getEventInfo();
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
                                SportzxLiveEventData event = (SportzxLiveEventData) it.next();
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
                                final String posterUrl = generateMatchCardUrl(event);
                                int eventId = event.getEventId();
                                String cat2 = event.getCat();
                                formats = event.getFormats();
                                if (formats == null) {
                                    formats = CollectionsKt.emptyList();
                                }
                                SportzxLoadData loadData = new SportzxLoadData(eventId, displayTitle, posterUrl, cat2, formats, event.getEventInfo());
                                destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle, AppUtils.INSTANCE.toJson(loadData), TvType.Live, false, new Function1() { // from class: com.cncverse.SportzxLiveEventsProvider$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj) {
                                        return SportzxLiveEventsProvider.getMainPage$lambda$1$2$0(posterUrl, (LiveSearchResponse) obj);
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
                        c00031 = c00032;
                        $result = $result2;
                        request2 = request2;
                    }
                    Iterable $this$sortedBy$iv = (List) destination$iv$iv;
                    List homePageLists = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: com.cncverse.SportzxLiveEventsProvider$getMainPage$$inlined$sortedBy$1
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
                SportzxProviderManager sportzxProviderManager2 = SportzxProviderManager.INSTANCE;
                String str3 = this.customLink;
                c00031.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00031.I$0 = page2;
                c00031.label = 1;
                objFetchLiveEvents = sportzxProviderManager2.fetchLiveEvents(str3, c00031);
                if (objFetchLiveEvents == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                events = (List) objFetchLiveEvents;
                List $this$groupBy$iv2 = events;
                grouped = new LinkedHashMap();
                while (r13.hasNext()) {
                    SportzxLiveEventData it3 = (SportzxLiveEventData) element$iv$iv;
                    eventInfo = it3.getEventInfo();
                    if ((eventInfo != null || (cat = eventInfo.getEventCat()) == null) && (cat = it3.getCat()) == null) {
                    }
                    str2 = cat;
                    value$iv$iv$iv = grouped.get(str2);
                    if (value$iv$iv$iv == null) {
                        Object answer$iv$iv$iv3 = (List) new ArrayList();
                        answer$iv$iv$iv = answer$iv$iv$iv3;
                        grouped.put(str2, answer$iv$iv$iv);
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
                    String category2 = (String) item$iv$iv.getKey();
                    List categoryEvents2 = (List) item$iv$iv.getValue();
                    Map $this$map$iv5 = $this$map$iv;
                    lowerCase = category2.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    str = "🥊";
                    switch (lowerCase.hashCode()) {
                        case -1383120329:
                            if (!lowerCase.equals("boxing")) {
                                str = "📺";
                            }
                            break;
                        case -1068313274:
                            if (lowerCase.equals("motogp")) {
                                str = "📺";
                            } else {
                                str = "🏍️";
                            }
                            break;
                        case -877324069:
                            if (lowerCase.equals("tennis")) {
                                str = "📺";
                            } else {
                                str = "🎾";
                            }
                            break;
                        case -654884904:
                            if (lowerCase.equals("ice hockey")) {
                                str = "📺";
                            } else {
                                str = "🏒";
                            }
                            break;
                        case 3211:
                            if (lowerCase.equals("f1")) {
                                str = "📺";
                            } else {
                                str = "🏎️";
                            }
                            break;
                        case 115698:
                            if (!lowerCase.equals("ufc")) {
                                str = "📺";
                            }
                            break;
                        case 118149:
                            if (lowerCase.equals("wwe")) {
                                str = "📺";
                            } else {
                                str = "🤼";
                            }
                            break;
                        case 394668909:
                            if (lowerCase.equals("football")) {
                                str = "📺";
                            } else {
                                str = "⚽";
                            }
                            break;
                        case 400486431:
                            if (lowerCase.equals("motorsport")) {
                                str = "📺";
                            } else {
                                str = "🏎️";
                            }
                            break;
                        case 727149765:
                            if (lowerCase.equals("basketball")) {
                                str = "📺";
                            } else {
                                str = "🏀";
                            }
                            break;
                        case 1032299505:
                            if (lowerCase.equals("cricket")) {
                                str = "📺";
                            } else {
                                str = "🏏";
                            }
                            break;
                        default:
                            str = "📺";
                            break;
                    }
                    String icon2 = str;
                    C00031 c00033 = c00031;
                    final Comparator comparator2 = new Comparator() { // from class: com.cncverse.SportzxLiveEventsProvider$getMainPage$lambda$1$$inlined$compareBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Integer num;
                            Integer num2;
                            SportzxLiveEventData event2 = (SportzxLiveEventData) t;
                            String status3 = this.this$0.getEventStatus(event2);
                            if (StringsKt.contains$default(status3, "🔴", false, 2, (Object) null)) {
                                num = (Comparable) 0;
                            } else if (StringsKt.contains$default(status3, "🔜", false, 2, (Object) null)) {
                                num = (Comparable) 1;
                            } else {
                                num = StringsKt.contains$default(status3, "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                            }
                            SportzxLiveEventData event3 = (SportzxLiveEventData) t2;
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
                    $this$map$iv2 = CollectionsKt.sortedWith(categoryEvents2, new Comparator() { // from class: com.cncverse.SportzxLiveEventsProvider$getMainPage$lambda$1$$inlined$thenBy$1
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
                            SportzxLiveEventData event2 = (SportzxLiveEventData) t;
                            try {
                                SportzxLiveEventInfo info = event2.getEventInfo();
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
                            SportzxLiveEventData event3 = (SportzxLiveEventData) t2;
                            try {
                                SportzxLiveEventInfo info2 = event3.getEventInfo();
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
                            SportzxLiveEventData event2 = (SportzxLiveEventData) it.next();
                            Iterable $this$mapTo$iv$iv3 = $this$mapTo$iv$iv;
                            displayTitle = createDisplayTitle(event2);
                            MainPageRequest request4 = request2;
                            status = getEventStatus(event2);
                            if (StringsKt.isBlank(status)) {
                                status2 = status + ' ' + displayTitle;
                            } else {
                                status2 = displayTitle;
                            }
                            String fullTitle2 = status2;
                            final String posterUrl2 = generateMatchCardUrl(event2);
                            int eventId2 = event2.getEventId();
                            String cat3 = event2.getCat();
                            formats = event2.getFormats();
                            if (formats == null) {
                                formats = CollectionsKt.emptyList();
                            }
                            SportzxLoadData loadData2 = new SportzxLoadData(eventId2, displayTitle, posterUrl2, cat3, formats, event2.getEventInfo());
                            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle2, AppUtils.INSTANCE.toJson(loadData2), TvType.Live, false, new Function1() { // from class: com.cncverse.SportzxLiveEventsProvider$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    return SportzxLiveEventsProvider.getMainPage$lambda$1$2$0(posterUrl2, (LiveSearchResponse) obj);
                                }
                            }, 8, (Object) null));
                            $this$map$iv2 = $this$map$iv3;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv3;
                            request2 = request4;
                            events = events;
                        }
                    }
                    List searchResponses2 = (List) destination$iv$iv2;
                    destination$iv$iv.add(new HomePageList(icon2 + ' ' + category2, searchResponses2, true));
                    $this$map$iv = $this$map$iv5;
                    c00031 = c00033;
                    $result = $result3;
                    request2 = request2;
                }
                Iterable $this$sortedBy$iv2 = (List) destination$iv$iv;
                List homePageLists2 = CollectionsKt.sortedWith($this$sortedBy$iv2, new Comparator() { // from class: com.cncverse.SportzxLiveEventsProvider$getMainPage$$inlined$sortedBy$1
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
                page2 = c00031.I$0;
                request2 = (MainPageRequest) c00031.L$0;
                ResultKt.throwOnFailure($result);
                objFetchLiveEvents = $result;
                events = (List) objFetchLiveEvents;
                List $this$groupBy$iv3 = events;
                grouped = new LinkedHashMap();
                while (r13.hasNext()) {
                    SportzxLiveEventData it4 = (SportzxLiveEventData) element$iv$iv;
                    eventInfo = it4.getEventInfo();
                    if (eventInfo != null) {
                    }
                    str2 = cat;
                    value$iv$iv$iv = grouped.get(str2);
                    if (value$iv$iv$iv == null) {
                        Object answer$iv$iv$iv4 = (List) new ArrayList();
                        answer$iv$iv$iv = answer$iv$iv$iv4;
                        grouped.put(str2, answer$iv$iv$iv);
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
                    String category3 = (String) item$iv$iv.getKey();
                    List categoryEvents3 = (List) item$iv$iv.getValue();
                    Map $this$map$iv6 = $this$map$iv;
                    lowerCase = category3.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    str = "🥊";
                    switch (lowerCase.hashCode()) {
                        case -1383120329:
                            if (!lowerCase.equals("boxing")) {
                                str = "📺";
                            }
                            break;
                        case -1068313274:
                            if (lowerCase.equals("motogp")) {
                                str = "📺";
                            } else {
                                str = "🏍️";
                            }
                            break;
                        case -877324069:
                            if (lowerCase.equals("tennis")) {
                                str = "📺";
                            } else {
                                str = "🎾";
                            }
                            break;
                        case -654884904:
                            if (lowerCase.equals("ice hockey")) {
                                str = "📺";
                            } else {
                                str = "🏒";
                            }
                            break;
                        case 3211:
                            if (lowerCase.equals("f1")) {
                                str = "📺";
                            } else {
                                str = "🏎️";
                            }
                            break;
                        case 115698:
                            if (!lowerCase.equals("ufc")) {
                                str = "📺";
                            }
                            break;
                        case 118149:
                            if (lowerCase.equals("wwe")) {
                                str = "📺";
                            } else {
                                str = "🤼";
                            }
                            break;
                        case 394668909:
                            if (lowerCase.equals("football")) {
                                str = "📺";
                            } else {
                                str = "⚽";
                            }
                            break;
                        case 400486431:
                            if (lowerCase.equals("motorsport")) {
                                str = "📺";
                            } else {
                                str = "🏎️";
                            }
                            break;
                        case 727149765:
                            if (lowerCase.equals("basketball")) {
                                str = "📺";
                            } else {
                                str = "🏀";
                            }
                            break;
                        case 1032299505:
                            if (lowerCase.equals("cricket")) {
                                str = "📺";
                            } else {
                                str = "🏏";
                            }
                            break;
                        default:
                            str = "📺";
                            break;
                    }
                    String icon3 = str;
                    C00031 c00034 = c00031;
                    final Comparator comparator3 = new Comparator() { // from class: com.cncverse.SportzxLiveEventsProvider$getMainPage$lambda$1$$inlined$compareBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Integer num;
                            Integer num2;
                            SportzxLiveEventData event3 = (SportzxLiveEventData) t;
                            String status3 = this.this$0.getEventStatus(event3);
                            if (StringsKt.contains$default(status3, "🔴", false, 2, (Object) null)) {
                                num = (Comparable) 0;
                            } else if (StringsKt.contains$default(status3, "🔜", false, 2, (Object) null)) {
                                num = (Comparable) 1;
                            } else {
                                num = StringsKt.contains$default(status3, "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                            }
                            SportzxLiveEventData event4 = (SportzxLiveEventData) t2;
                            String status4 = this.this$0.getEventStatus(event4);
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
                    $this$map$iv2 = CollectionsKt.sortedWith(categoryEvents3, new Comparator() { // from class: com.cncverse.SportzxLiveEventsProvider$getMainPage$lambda$1$$inlined$thenBy$1
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
                            SportzxLiveEventData event3 = (SportzxLiveEventData) t;
                            try {
                                SportzxLiveEventInfo info = event3.getEventInfo();
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
                            SportzxLiveEventData event4 = (SportzxLiveEventData) t2;
                            try {
                                SportzxLiveEventInfo info2 = event4.getEventInfo();
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
                            SportzxLiveEventData event3 = (SportzxLiveEventData) it.next();
                            Iterable $this$mapTo$iv$iv4 = $this$mapTo$iv$iv;
                            displayTitle = createDisplayTitle(event3);
                            MainPageRequest request5 = request2;
                            status = getEventStatus(event3);
                            if (StringsKt.isBlank(status)) {
                                status2 = status + ' ' + displayTitle;
                            } else {
                                status2 = displayTitle;
                            }
                            String fullTitle3 = status2;
                            final String posterUrl3 = generateMatchCardUrl(event3);
                            int eventId3 = event3.getEventId();
                            String cat4 = event3.getCat();
                            formats = event3.getFormats();
                            if (formats == null) {
                                formats = CollectionsKt.emptyList();
                            }
                            SportzxLoadData loadData3 = new SportzxLoadData(eventId3, displayTitle, posterUrl3, cat4, formats, event3.getEventInfo());
                            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle3, AppUtils.INSTANCE.toJson(loadData3), TvType.Live, false, new Function1() { // from class: com.cncverse.SportzxLiveEventsProvider$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    return SportzxLiveEventsProvider.getMainPage$lambda$1$2$0(posterUrl3, (LiveSearchResponse) obj);
                                }
                            }, 8, (Object) null));
                            $this$map$iv2 = $this$map$iv3;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv4;
                            request2 = request5;
                            events = events;
                        }
                    }
                    List searchResponses3 = (List) destination$iv$iv2;
                    destination$iv$iv.add(new HomePageList(icon3 + ' ' + category3, searchResponses3, true));
                    $this$map$iv = $this$map$iv6;
                    c00031 = c00034;
                    $result = $result4;
                    request2 = request2;
                }
                Iterable $this$sortedBy$iv3 = (List) destination$iv$iv;
                List homePageLists3 = CollectionsKt.sortedWith($this$sortedBy$iv3, new Comparator() { // from class: com.cncverse.SportzxLiveEventsProvider$getMainPage$$inlined$sortedBy$1
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
                page2 = c00031.I$0;
                request2 = (MainPageRequest) c00031.L$0;
                ResultKt.throwOnFailure($result);
                objFetchLiveEvents$default = $result;
                events = (List) objFetchLiveEvents$default;
                List $this$groupBy$iv4 = events;
                grouped = new LinkedHashMap();
                while (r13.hasNext()) {
                    SportzxLiveEventData it5 = (SportzxLiveEventData) element$iv$iv;
                    eventInfo = it5.getEventInfo();
                    if (eventInfo != null) {
                    }
                    str2 = cat;
                    value$iv$iv$iv = grouped.get(str2);
                    if (value$iv$iv$iv == null) {
                        Object answer$iv$iv$iv5 = (List) new ArrayList();
                        answer$iv$iv$iv = answer$iv$iv$iv5;
                        grouped.put(str2, answer$iv$iv$iv);
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
                    String category4 = (String) item$iv$iv.getKey();
                    List categoryEvents4 = (List) item$iv$iv.getValue();
                    Map $this$map$iv7 = $this$map$iv;
                    lowerCase = category4.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    str = "🥊";
                    switch (lowerCase.hashCode()) {
                        case -1383120329:
                            if (!lowerCase.equals("boxing")) {
                                str = "📺";
                            }
                            break;
                        case -1068313274:
                            if (lowerCase.equals("motogp")) {
                                str = "📺";
                            } else {
                                str = "🏍️";
                            }
                            break;
                        case -877324069:
                            if (lowerCase.equals("tennis")) {
                                str = "📺";
                            } else {
                                str = "🎾";
                            }
                            break;
                        case -654884904:
                            if (lowerCase.equals("ice hockey")) {
                                str = "📺";
                            } else {
                                str = "🏒";
                            }
                            break;
                        case 3211:
                            if (lowerCase.equals("f1")) {
                                str = "📺";
                            } else {
                                str = "🏎️";
                            }
                            break;
                        case 115698:
                            if (!lowerCase.equals("ufc")) {
                                str = "📺";
                            }
                            break;
                        case 118149:
                            if (lowerCase.equals("wwe")) {
                                str = "📺";
                            } else {
                                str = "🤼";
                            }
                            break;
                        case 394668909:
                            if (lowerCase.equals("football")) {
                                str = "📺";
                            } else {
                                str = "⚽";
                            }
                            break;
                        case 400486431:
                            if (lowerCase.equals("motorsport")) {
                                str = "📺";
                            } else {
                                str = "🏎️";
                            }
                            break;
                        case 727149765:
                            if (lowerCase.equals("basketball")) {
                                str = "📺";
                            } else {
                                str = "🏀";
                            }
                            break;
                        case 1032299505:
                            if (lowerCase.equals("cricket")) {
                                str = "📺";
                            } else {
                                str = "🏏";
                            }
                            break;
                        default:
                            str = "📺";
                            break;
                    }
                    String icon4 = str;
                    C00031 c00035 = c00031;
                    final Comparator comparator4 = new Comparator() { // from class: com.cncverse.SportzxLiveEventsProvider$getMainPage$lambda$1$$inlined$compareBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Integer num;
                            Integer num2;
                            SportzxLiveEventData event4 = (SportzxLiveEventData) t;
                            String status3 = this.this$0.getEventStatus(event4);
                            if (StringsKt.contains$default(status3, "🔴", false, 2, (Object) null)) {
                                num = (Comparable) 0;
                            } else if (StringsKt.contains$default(status3, "🔜", false, 2, (Object) null)) {
                                num = (Comparable) 1;
                            } else {
                                num = StringsKt.contains$default(status3, "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                            }
                            SportzxLiveEventData event5 = (SportzxLiveEventData) t2;
                            String status4 = this.this$0.getEventStatus(event5);
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
                    $this$map$iv2 = CollectionsKt.sortedWith(categoryEvents4, new Comparator() { // from class: com.cncverse.SportzxLiveEventsProvider$getMainPage$lambda$1$$inlined$thenBy$1
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
                            SportzxLiveEventData event4 = (SportzxLiveEventData) t;
                            try {
                                SportzxLiveEventInfo info = event4.getEventInfo();
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
                            SportzxLiveEventData event5 = (SportzxLiveEventData) t2;
                            try {
                                SportzxLiveEventInfo info2 = event5.getEventInfo();
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
                            SportzxLiveEventData event4 = (SportzxLiveEventData) it.next();
                            Iterable $this$mapTo$iv$iv5 = $this$mapTo$iv$iv;
                            displayTitle = createDisplayTitle(event4);
                            MainPageRequest request6 = request2;
                            status = getEventStatus(event4);
                            if (StringsKt.isBlank(status)) {
                                status2 = status + ' ' + displayTitle;
                            } else {
                                status2 = displayTitle;
                            }
                            String fullTitle4 = status2;
                            final String posterUrl4 = generateMatchCardUrl(event4);
                            int eventId4 = event4.getEventId();
                            String cat5 = event4.getCat();
                            formats = event4.getFormats();
                            if (formats == null) {
                                formats = CollectionsKt.emptyList();
                            }
                            SportzxLoadData loadData4 = new SportzxLoadData(eventId4, displayTitle, posterUrl4, cat5, formats, event4.getEventInfo());
                            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle4, AppUtils.INSTANCE.toJson(loadData4), TvType.Live, false, new Function1() { // from class: com.cncverse.SportzxLiveEventsProvider$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    return SportzxLiveEventsProvider.getMainPage$lambda$1$2$0(posterUrl4, (LiveSearchResponse) obj);
                                }
                            }, 8, (Object) null));
                            $this$map$iv2 = $this$map$iv3;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv5;
                            request2 = request6;
                            events = events;
                        }
                    }
                    List searchResponses4 = (List) destination$iv$iv2;
                    destination$iv$iv.add(new HomePageList(icon4 + ' ' + category4, searchResponses4, true));
                    $this$map$iv = $this$map$iv7;
                    c00031 = c00035;
                    $result = $result5;
                    request2 = request2;
                }
                Iterable $this$sortedBy$iv4 = (List) destination$iv$iv;
                List homePageLists4 = CollectionsKt.sortedWith($this$sortedBy$iv4, new Comparator() { // from class: com.cncverse.SportzxLiveEventsProvider$getMainPage$$inlined$sortedBy$1
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

    /* JADX WARN: Code duplicated, block: B:27:0x0089  */
    /* JADX WARN: Code duplicated, block: B:29:0x009c  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:37:0x00be  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:41:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:46:0x0124  */
    /* JADX WARN: Code duplicated, block: B:48:0x013d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0157  */
    /* JADX WARN: Code duplicated, block: B:52:0x0173  */
    /* JADX WARN: Code duplicated, block: B:58:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x0177 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws UnsupportedEncodingException {
        C00071 c00071;
        Object objFetchLiveEvents$default;
        Object objFetchLiveEvents;
        Iterable events;
        Collection destination$iv$iv;
        Iterable $this$map$iv;
        Collection destination$iv$iv2;
        String displayTitle;
        String status;
        String str;
        List<SportzxLiveEventFormat> formats;
        String title;
        SportzxLiveEventInfo eventInfo;
        String teamA;
        SportzxLiveEventInfo eventInfo2;
        String query2;
        SportzxLiveEventInfo eventInfo3;
        String eventName;
        SportzxLiveEventsProvider sportzxLiveEventsProvider = this;
        String query3 = query;
        if (continuation instanceof C00071) {
            c00071 = (C00071) continuation;
            if ((c00071.label & Integer.MIN_VALUE) != 0) {
                c00071.label -= Integer.MIN_VALUE;
            } else {
                c00071 = sportzxLiveEventsProvider.new C00071(continuation);
            }
        } else {
            c00071 = sportzxLiveEventsProvider.new C00071(continuation);
        }
        Object $result = c00071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00071.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (sportzxLiveEventsProvider.customLink == null) {
                    SportzxProviderManager sportzxProviderManager = SportzxProviderManager.INSTANCE;
                    c00071.L$0 = query3;
                    c00071.label = 2;
                    objFetchLiveEvents$default = SportzxProviderManager.fetchLiveEvents$default(sportzxProviderManager, null, c00071, 1, null);
                    if (objFetchLiveEvents$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    events = (List) objFetchLiveEvents$default;
                    Iterable $this$filter$iv = events;
                    destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        SportzxLiveEventData event = (SportzxLiveEventData) element$iv$iv;
                        title = event.getTitle();
                        eventInfo = event.getEventInfo();
                        if (eventInfo != null) {
                            teamA = eventInfo.getTeamA();
                        } else {
                            teamA = null;
                        }
                        eventInfo2 = event.getEventInfo();
                        if (eventInfo2 != null) {
                            query2 = eventInfo2.getTeamB();
                        } else {
                            query2 = null;
                        }
                        eventInfo3 = event.getEventInfo();
                        if (eventInfo3 != null) {
                            eventName = eventInfo3.getEventName();
                        } else {
                            eventName = null;
                        }
                        if (StringsKt.contains(CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{title, teamA, query2, eventName}), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), query3, true)) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        query3 = query3;
                    }
                    $this$map$iv = (List) destination$iv$iv;
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        SportzxLiveEventData event2 = (SportzxLiveEventData) item$iv$iv;
                        displayTitle = sportzxLiveEventsProvider.createDisplayTitle(event2);
                        status = sportzxLiveEventsProvider.getEventStatus(event2);
                        if (StringsKt.isBlank(status)) {
                            str = displayTitle;
                        } else {
                            str = status + ' ' + displayTitle;
                        }
                        String fullTitle = str;
                        final String posterUrl = sportzxLiveEventsProvider.generateMatchCardUrl(event2);
                        int eventId = event2.getEventId();
                        String cat = event2.getCat();
                        formats = event2.getFormats();
                        if (formats == null) {
                            formats = CollectionsKt.emptyList();
                        }
                        SportzxLoadData loadData = new SportzxLoadData(eventId, displayTitle, posterUrl, cat, formats, event2.getEventInfo());
                        destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(sportzxLiveEventsProvider, fullTitle, AppUtils.INSTANCE.toJson(loadData), TvType.Live, false, new Function1() { // from class: com.cncverse.SportzxLiveEventsProvider$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                return SportzxLiveEventsProvider.search$lambda$1$0(posterUrl, (LiveSearchResponse) obj);
                            }
                        }, 8, (Object) null));
                        sportzxLiveEventsProvider = this;
                        $this$map$iv = $this$map$iv;
                    }
                    return (List) destination$iv$iv2;
                }
                SportzxProviderManager sportzxProviderManager2 = SportzxProviderManager.INSTANCE;
                String str2 = sportzxLiveEventsProvider.customLink;
                c00071.L$0 = query3;
                c00071.label = 1;
                objFetchLiveEvents = sportzxProviderManager2.fetchLiveEvents(str2, c00071);
                if (objFetchLiveEvents == coroutine_suspended) {
                    return coroutine_suspended;
                }
                events = (List) objFetchLiveEvents;
                Iterable $this$filter$iv2 = events;
                destination$iv$iv = new ArrayList();
                while (r13.hasNext()) {
                    SportzxLiveEventData event3 = (SportzxLiveEventData) element$iv$iv;
                    title = event3.getTitle();
                    eventInfo = event3.getEventInfo();
                    if (eventInfo != null) {
                        teamA = eventInfo.getTeamA();
                    } else {
                        teamA = null;
                    }
                    eventInfo2 = event3.getEventInfo();
                    if (eventInfo2 != null) {
                        query2 = eventInfo2.getTeamB();
                    } else {
                        query2 = null;
                    }
                    eventInfo3 = event3.getEventInfo();
                    if (eventInfo3 != null) {
                        eventName = eventInfo3.getEventName();
                    } else {
                        eventName = null;
                    }
                    if (StringsKt.contains(CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{title, teamA, query2, eventName}), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), query3, true)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    query3 = query3;
                }
                $this$map$iv = (List) destination$iv$iv;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r9.hasNext()) {
                    SportzxLiveEventData event4 = (SportzxLiveEventData) item$iv$iv;
                    displayTitle = sportzxLiveEventsProvider.createDisplayTitle(event4);
                    status = sportzxLiveEventsProvider.getEventStatus(event4);
                    if (StringsKt.isBlank(status)) {
                        str = status + ' ' + displayTitle;
                    } else {
                        str = displayTitle;
                    }
                    String fullTitle2 = str;
                    final String posterUrl2 = sportzxLiveEventsProvider.generateMatchCardUrl(event4);
                    int eventId2 = event4.getEventId();
                    String cat2 = event4.getCat();
                    formats = event4.getFormats();
                    if (formats == null) {
                        formats = CollectionsKt.emptyList();
                    }
                    SportzxLoadData loadData2 = new SportzxLoadData(eventId2, displayTitle, posterUrl2, cat2, formats, event4.getEventInfo());
                    destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(sportzxLiveEventsProvider, fullTitle2, AppUtils.INSTANCE.toJson(loadData2), TvType.Live, false, new Function1() { // from class: com.cncverse.SportzxLiveEventsProvider$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            return SportzxLiveEventsProvider.search$lambda$1$0(posterUrl2, (LiveSearchResponse) obj);
                        }
                    }, 8, (Object) null));
                    sportzxLiveEventsProvider = this;
                    $this$map$iv = $this$map$iv;
                }
                return (List) destination$iv$iv2;
            case 1:
                query3 = (String) c00071.L$0;
                ResultKt.throwOnFailure($result);
                objFetchLiveEvents = $result;
                events = (List) objFetchLiveEvents;
                Iterable $this$filter$iv3 = events;
                destination$iv$iv = new ArrayList();
                while (r13.hasNext()) {
                    SportzxLiveEventData event5 = (SportzxLiveEventData) element$iv$iv;
                    title = event5.getTitle();
                    eventInfo = event5.getEventInfo();
                    if (eventInfo != null) {
                        teamA = eventInfo.getTeamA();
                    } else {
                        teamA = null;
                    }
                    eventInfo2 = event5.getEventInfo();
                    if (eventInfo2 != null) {
                        query2 = eventInfo2.getTeamB();
                    } else {
                        query2 = null;
                    }
                    eventInfo3 = event5.getEventInfo();
                    if (eventInfo3 != null) {
                        eventName = eventInfo3.getEventName();
                    } else {
                        eventName = null;
                    }
                    if (StringsKt.contains(CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{title, teamA, query2, eventName}), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), query3, true)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    query3 = query3;
                }
                $this$map$iv = (List) destination$iv$iv;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r9.hasNext()) {
                    SportzxLiveEventData event6 = (SportzxLiveEventData) item$iv$iv;
                    displayTitle = sportzxLiveEventsProvider.createDisplayTitle(event6);
                    status = sportzxLiveEventsProvider.getEventStatus(event6);
                    if (StringsKt.isBlank(status)) {
                        str = status + ' ' + displayTitle;
                    } else {
                        str = displayTitle;
                    }
                    String fullTitle3 = str;
                    final String posterUrl3 = sportzxLiveEventsProvider.generateMatchCardUrl(event6);
                    int eventId3 = event6.getEventId();
                    String cat3 = event6.getCat();
                    formats = event6.getFormats();
                    if (formats == null) {
                        formats = CollectionsKt.emptyList();
                    }
                    SportzxLoadData loadData3 = new SportzxLoadData(eventId3, displayTitle, posterUrl3, cat3, formats, event6.getEventInfo());
                    destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(sportzxLiveEventsProvider, fullTitle3, AppUtils.INSTANCE.toJson(loadData3), TvType.Live, false, new Function1() { // from class: com.cncverse.SportzxLiveEventsProvider$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            return SportzxLiveEventsProvider.search$lambda$1$0(posterUrl3, (LiveSearchResponse) obj);
                        }
                    }, 8, (Object) null));
                    sportzxLiveEventsProvider = this;
                    $this$map$iv = $this$map$iv;
                }
                return (List) destination$iv$iv2;
            case 2:
                query3 = (String) c00071.L$0;
                ResultKt.throwOnFailure($result);
                objFetchLiveEvents$default = $result;
                events = (List) objFetchLiveEvents$default;
                Iterable $this$filter$iv4 = events;
                destination$iv$iv = new ArrayList();
                while (r13.hasNext()) {
                    SportzxLiveEventData event7 = (SportzxLiveEventData) element$iv$iv;
                    title = event7.getTitle();
                    eventInfo = event7.getEventInfo();
                    if (eventInfo != null) {
                        teamA = eventInfo.getTeamA();
                    } else {
                        teamA = null;
                    }
                    eventInfo2 = event7.getEventInfo();
                    if (eventInfo2 != null) {
                        query2 = eventInfo2.getTeamB();
                    } else {
                        query2 = null;
                    }
                    eventInfo3 = event7.getEventInfo();
                    if (eventInfo3 != null) {
                        eventName = eventInfo3.getEventName();
                    } else {
                        eventName = null;
                    }
                    if (StringsKt.contains(CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{title, teamA, query2, eventName}), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), query3, true)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    query3 = query3;
                }
                $this$map$iv = (List) destination$iv$iv;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r9.hasNext()) {
                    SportzxLiveEventData event8 = (SportzxLiveEventData) item$iv$iv;
                    displayTitle = sportzxLiveEventsProvider.createDisplayTitle(event8);
                    status = sportzxLiveEventsProvider.getEventStatus(event8);
                    if (StringsKt.isBlank(status)) {
                        str = status + ' ' + displayTitle;
                    } else {
                        str = displayTitle;
                    }
                    String fullTitle4 = str;
                    final String posterUrl4 = sportzxLiveEventsProvider.generateMatchCardUrl(event8);
                    int eventId4 = event8.getEventId();
                    String cat4 = event8.getCat();
                    formats = event8.getFormats();
                    if (formats == null) {
                        formats = CollectionsKt.emptyList();
                    }
                    SportzxLoadData loadData4 = new SportzxLoadData(eventId4, displayTitle, posterUrl4, cat4, formats, event8.getEventInfo());
                    destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(sportzxLiveEventsProvider, fullTitle4, AppUtils.INSTANCE.toJson(loadData4), TvType.Live, false, new Function1() { // from class: com.cncverse.SportzxLiveEventsProvider$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            return SportzxLiveEventsProvider.search$lambda$1$0(posterUrl4, (LiveSearchResponse) obj);
                        }
                    }, 8, (Object) null));
                    sportzxLiveEventsProvider = this;
                    $this$map$iv = $this$map$iv;
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
            KType kTypeTypeOf = Reflection.typeOf(SportzxLoadData.class);
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            try {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(SportzxLoadData.class), (List) null, 2, (Object) null));
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
                objDecodeFromString = $this$readValue$iv$iv.readValue(url, new TypeReference<SportzxLoadData>() { // from class: com.cncverse.SportzxLiveEventsProvider$load$$inlined$parseJson$1
                });
            } catch (Throwable th3) {
                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv2.readValue(url, new TypeReference<SportzxLoadData>() { // from class: com.cncverse.SportzxLiveEventsProvider$load$$inlined$parseJson$1
                });
            }
        } else {
            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
            objDecodeFromString = $this$readValue$iv$iv3.readValue(url, new TypeReference<SportzxLoadData>() { // from class: com.cncverse.SportzxLiveEventsProvider$load$$inlined$parseJson$1
            });
        }
        SportzxLoadData data = (SportzxLoadData) objDecodeFromString;
        SportzxLiveEventInfo info = data.getEventInfo();
        StringBuilder $this$load_u24lambda_u240 = new StringBuilder();
        if (info != null) {
            String t = info.getEventType();
            if (t != null) {
                if (Intrinsics.areEqual(t, "null")) {
                    t = null;
                }
                if (t != null) {
                    $this$load_u24lambda_u240.append("📌 " + t + '\n');
                }
            }
            String n = info.getEventName();
            if (n != null) {
                $this$load_u24lambda_u240.append("🏆 " + n + '\n');
            }
            String st = info.getStartTime();
            if (st != null) {
                try {
                    SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                    SimpleDateFormat disp = new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.US);
                    Date d = df.parse(st);
                    if (d != null) {
                        $this$load_u24lambda_u240.append("🕐 " + disp.format(d) + '\n');
                    }
                } catch (Exception e2) {
                    $this$load_u24lambda_u240.append("🕐 " + st + '\n');
                }
            }
        }
        $this$load_u24lambda_u240.append("\n📡 Available Servers: " + data.getFormats().size());
        String plot = $this$load_u24lambda_u240.toString();
        return MainAPIKt.newLiveStreamLoadResponse(this, data.getTitle(), url, url, new C00052(data, plot, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.SportzxLiveEventsProvider$load$2 */
    /* JADX INFO: compiled from: SportzxLiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/LiveStreamLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.SportzxLiveEventsProvider$load$2", f = "SportzxLiveEventsProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00052 extends SuspendLambda implements Function2<LiveStreamLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ SportzxLoadData $data;
        final /* synthetic */ String $plot;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00052(SportzxLoadData sportzxLoadData, String str, Continuation<? super C00052> continuation) {
            super(2, continuation);
            this.$data = sportzxLoadData;
            this.$plot = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00052 = new C00052(this.$data, this.$plot, continuation);
            c00052.L$0 = obj;
            return c00052;
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:150:0x0640  */
    /* JADX WARN: Code duplicated, block: B:182:0x0723 A[Catch: Exception -> 0x0765, TRY_LEAVE, TryCatch #16 {Exception -> 0x0765, blocks: (B:179:0x0711, B:180:0x071b, B:182:0x0723), top: B:382:0x0711 }] */
    /* JADX WARN: Code duplicated, block: B:187:0x0748 A[LOOP:2: B:180:0x071b->B:187:0x0748, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:442:0x0746 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0341: MOVE (r29 I:??[OBJECT, ARRAY] A[D('loadData' com.cncverse.SportzxLiveEventsProvider$SportzxLoadData)]) = (r14 I:??[OBJECT, ARRAY] A[D('headers' java.util.Map)]), block:B:34:0x0329 */
    /* JADX WARN: Not initialized variable reg: 20, insn: 0x0329: MOVE (r9 I:??[OBJECT, ARRAY]) = (r20 I:??[OBJECT, ARRAY] A[D('parts' java.util.List)]), block:B:34:0x0329 */
    /* JADX WARN: Not initialized variable reg: 21, insn: 0x032b: MOVE (r8 I:??[OBJECT, ARRAY]) = (r21 I:??[OBJECT, ARRAY] A[D('serverName' java.lang.String)]), block:B:34:0x0329 */
    /* JADX WARN: Not initialized variable reg: 22, insn: 0x032d: MOVE (r7 I:??[OBJECT, ARRAY]) = (r22 I:??[OBJECT, ARRAY] A[D('link' java.lang.String)]), block:B:34:0x0329 */
    /* JADX WARN: Not initialized variable reg: 23, insn: 0x032f: MOVE (r10 I:??[OBJECT, ARRAY]) = (r23 I:??[OBJECT, ARRAY] A[D('stream' com.cncverse.SportzxStreamEntry)]), block:B:34:0x0329 */
    /* JADX WARN: Not initialized variable reg: 26, insn: 0x0331: MOVE (r21 I:??[OBJECT, ARRAY] A[D('serverName' java.lang.String)]) = (r26 I:??[OBJECT, ARRAY] A[D('$this$forEach$iv' java.lang.Iterable)]), block:B:34:0x0329 */
    /* JADX WARN: Not initialized variable reg: 27, insn: 0x0333: MOVE (r22 I:??[OBJECT, ARRAY] A[D('link' java.lang.String)]) = (r27 I:??[OBJECT, ARRAY] A[D('streams' java.util.List)]), block:B:34:0x0329 */
    /* JADX WARN: Not initialized variable reg: 28, insn: 0x0335: MOVE (r23 I:??[OBJECT, ARRAY] A[D('stream' com.cncverse.SportzxStreamEntry)]) = (r28 I:??[OBJECT, ARRAY] A[D('streamJson' java.lang.String)]), block:B:34:0x0329 */
    /* JADX WARN: Not initialized variable reg: 29, insn: 0x0337: MOVE (r24 I:??[OBJECT, ARRAY]) = (r29 I:??[OBJECT, ARRAY] A[D('loadData' com.cncverse.SportzxLiveEventsProvider$SportzxLoadData)]), block:B:34:0x0329 */
    /* JADX WARN: Not initialized variable reg: 30, insn: 0x0339: MOVE (r27 I:??[OBJECT, ARRAY] A[D('streams' java.util.List)]) = (r30 I:??[OBJECT, ARRAY] A[D('callback' kotlin.jvm.functions.Function1)]), block:B:34:0x0329 */
    /* JADX WARN: Not initialized variable reg: 31, insn: 0x033b: MOVE (r26 I:??[OBJECT, ARRAY] A[D('$this$forEach$iv' java.lang.Iterable)]) = (r31 I:??[OBJECT, ARRAY] A[D('subtitleCallback' kotlin.jvm.functions.Function1)]), block:B:34:0x0329 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:239:0x096a -> B:339:0x0f81). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:250:0x0a9b -> B:339:0x0f81). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:259:0x0b81 -> B:339:0x0f81). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:293:0x0d17 -> B:375:0x0d3e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:323:0x0e83 -> B:339:0x0f81). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:338:0x0f68 -> B:339:0x0f81). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r44, boolean r45, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r46, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r47, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r48) {
        /*
            Method dump skipped, instruction units count: 4088
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.SportzxLiveEventsProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final String loadLinks$lambda$0$1$shiftChar(String str, int i) {
        int i2;
        if ((str.length() == 0) || i == 0) {
            return str;
        }
        int length = str.length() - (((i + (-1) < 0 ? 0 : i - 1) % str.length()) + 1);
        char charAt = str.charAt(length);
        List alphabets = CollectionsKt.listOf(new String[]{"abcdefghijklmnopqrstuvwxyz", "ABCDEFGHIJKLMNOPQRSTUVWXYZ", "0123456789"});
        int alphaIdx = -1;
        int charIdx = -1;
        int size = alphabets.size();
        for (int idx = 0; idx < size; idx++) {
            int pos = StringsKt.indexOf$default((CharSequence) alphabets.get(idx), charAt, 0, false, 6, (Object) null);
            if (pos != -1) {
                alphaIdx = idx;
                charIdx = pos;
                break;
            }
        }
        if (alphaIdx != -1) {
            int shift = i;
            while (shift > 0) {
                String currentAlpha = (String) alphabets.get(alphaIdx);
                int remaining = (currentAlpha.length() - 1) - charIdx;
                if (shift > remaining) {
                    shift -= currentAlpha.length() - charIdx;
                    switch (alphaIdx) {
                        case 0:
                            i2 = 2;
                            break;
                        case 1:
                            i2 = 0;
                            break;
                        default:
                            i2 = 1;
                            break;
                    }
                    alphaIdx = i2;
                    charIdx = 0;
                } else {
                    charIdx += shift;
                    shift = 0;
                }
            }
            charAt = ((String) alphabets.get(alphaIdx)).charAt(charIdx);
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, length);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        StringBuilder sbAppend = sb.append(strSubstring).append(charAt);
        String strSubstring2 = str.substring(length + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        return sbAppend.append(strSubstring2).toString();
    }

    private static final String loadLinks$lambda$0$hexToBase64Url(String hex) {
        try {
            Iterable $this$map$iv = StringsKt.chunked(hex, 2);
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
